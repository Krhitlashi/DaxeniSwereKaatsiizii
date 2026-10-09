package com.nala.portalo;

import com.nala.NalaPlugin;
import com.nala.config.Mesagoj;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

// ≺⧼ ទ្វារ 📃 ⧽≻
// រកឃើញនិងសាងសង់ទ្វារ

/* តក្កវិធីទ្វារដែលផ្អែកលើប្លុកទ្វារ Casokfamii
    @param kromprogramo ( NalaPlugin , មិនមែន null ) - កម្មវិធីជំនួយចម្បង
    @returns ទ្វារថ្មី */
public class Portalo {

    // ⟪ តម្លៃថេរ 📃 ⟫
    // តម្លៃថេរ
    private static final int PROKSIMO = 8; // 0o10
    private static final int MONTRO = 8; // 0o10
    private static final int MAKS_BRILO = 64; // 0o100

    // ⟪ ទិន្នន័យកម្មវិធី 📃 ⟫
    // ទិន្នន័យកម្មវិធី
    private final NalaPlugin kromprogramo;
    private final NamespacedKey ŝlosilo;
    private final Map<String, Location> memoroj = new HashMap<>();
    private final Map<String, Set<BlokoPos>> casok = new HashMap<>();
    private File dosiero;
    private YamlConfiguration datumoj;

    public Portalo(NalaPlugin kromprogramo) {
        this.kromprogramo = kromprogramo;
        this.ŝlosilo = new NamespacedKey(kromprogramo, "casokfamii");
    }

    // ⟪ ឯកសារ 📃 ⟫
    // ឯកសាររក្សាទុក

    /* ផ្ទុកចំណុចកណ្តាលទ្វារ និងប្លុក Casokfamii ពី portals.yml
        @returns គ្មាន */
    public void ŝargi() {
        dosiero = new File(kromprogramo.getDataFolder(), "portals.yml");
        dosiero.getParentFile().mkdirs();
        datumoj = YamlConfiguration.loadConfiguration(dosiero);
        for ( String mondoŜlosilo : datumoj.getKeys(false) ) {
            if ( ! datumoj.isConfigurationSection(mondoŜlosilo) ) {
                continue;
            }
            ConfigurationSection sekcio = datumoj.getConfigurationSection(mondoŜlosilo);
            Location centro = sekcio.getLocation("centro");
            if ( centro != null ) {
                memoroj.put(mondoŜlosilo, centro);
            }
            Set<BlokoPos> aroj = new HashSet<>();
            for ( Map<?, ?> mapo : sekcio.getMapList("casok") ) {
                try {
                    Object biomoObj = mapo.get("biomo");
                    aroj.add(new BlokoPos(
                        ( (Number) mapo.get("x") ).intValue(),
                        ( (Number) mapo.get("y") ).intValue(),
                        ( (Number) mapo.get("z") ).intValue(),
                        biomoObj == null ? null : String.valueOf(biomoObj)));
                } catch ( Exception eraro ) {
                    kromprogramo.getLogger().warning(Mesagoj.AVERTO_CASOK_NEVALIDA + Mesagoj.mondo(mondoŜlosilo) + " ⟅");
                }
            }
            if ( ! aroj.isEmpty() ) {
                casok.put(mondoŜlosilo, aroj);
            }
        }
    }

    /* រក្សាទុកចំណុចកណ្តាល និងប្លុក Casokfamii ទៅ portals.yml
        @returns គ្មាន */
    public void konservi() {
        if ( datumoj == null || dosiero == null ) {
            return;
        }
        for ( String malnovaŜlosilo : new ArrayList<>(datumoj.getKeys(false)) ) {
            if ( ! memoroj.containsKey(malnovaŜlosilo) && ! casok.containsKey(malnovaŜlosilo) ) {
                datumoj.set(malnovaŜlosilo, null);
            }
        }
        Set<String> ĉiuj = new HashSet<>();
        ĉiuj.addAll(memoroj.keySet());
        ĉiuj.addAll(casok.keySet());
        for ( String mondoŜlosilo : ĉiuj ) {
            ConfigurationSection sekcio = datumoj.getConfigurationSection(mondoŜlosilo);
            if ( sekcio == null ) {
                sekcio = datumoj.createSection(mondoŜlosilo);
            }
            sekcio.set("regionoj", null);
            sekcio.set("centro", memoroj.get(mondoŜlosilo));
            List<Map<String, Object>> blokoj = new ArrayList<>();
            Set<BlokoPos> aroj = casok.get(mondoŜlosilo);
            if ( aroj != null ) {
                for ( BlokoPos pos : aroj ) {
                    Map<String, Object> mapo = new HashMap<>();
                    mapo.put("x", pos.x());
                    mapo.put("y", pos.y());
                    mapo.put("z", pos.z());
                    if ( pos.biomo() != null ) {
                        mapo.put("biomo", pos.biomo());
                    }
                    blokoj.add(mapo);
                }
            }
            sekcio.set("casok", blokoj);
        }
        try {
            datumoj.save(dosiero);
        } catch ( Exception eraro ) {
            kromprogramo.getLogger().warning(Mesagoj.ERARO_KONSERVI_PORTALOJN + eraro.getMessage() + " ⟅");
        }
    }

    // ⟪ វត្ថុ Casokfamii 📃 ⟫
    // ធាតុប្លុកផ្ទាល់ខ្លួន

    /* បង្កើតធុង Casokfamii ដែលមានសញ្ញាសម្គាល់សម្រាប់ដាក់ទឹកទ្វារ
        @param kvanto ( int ) - ចំនួនវត្ថុ
        @returns វត្ថុដែលបានរៀបចំ */
    public ItemStack kreiObjekton(int kvanto) {
        if ( kvanto < 1 ) {
            kvanto = 1;
        }
        if ( kvanto > 64 ) { // 0o100
            kvanto = 64; // 0o100
        }
        ItemStack objekto = new ItemStack(Material.WATER_BUCKET, kvanto);
        ItemMeta meta = objekto.getItemMeta();
        meta.displayName(Component.text(Mesagoj.OBJEKTO_NOMO));
        meta.lore(java.util.List.of(Component.text(Mesagoj.OBJEKTO_LORE_UNUA), Component.text(Mesagoj.OBJEKTO_LORE_DUA)));
        meta.getPersistentDataContainer().set(ŝlosilo, PersistentDataType.BYTE, (byte) 1);
        objekto.setItemMeta(meta);
        return objekto;
    }

    /* ពិនិត្យថាតើវត្ថុជាធុង Casokfamii ពិតប្រាកដឬអត់
        @param objekto ( ItemStack , អាចជា null ) - វត្ថុដែលត្រូវពិនិត្យ
        @returns ពិតប្រសិនបើមានសញ្ញាសម្គាល់ */
    public boolean estasCasokfamiiObjekto(ItemStack objekto) {
        if ( objekto == null || objekto.getType() != Material.WATER_BUCKET ) {
            return false;
        }
        if ( ! objekto.hasItemMeta() ) {
            return false;
        }
        Byte marko = objekto.getItemMeta().getPersistentDataContainer().get(ŝlosilo, PersistentDataType.BYTE);
        return marko != null && marko == (byte) 1;
    }

    // ⟪ ការតាមដាន Casokfamii 📃 ⟫
    // តាមដានប្លុកដែលបានដាក់

    /* តាមដានប្លុក Casokfamii ដែលបានដាក់
        @param mondo ( World , មិនមែន null ) - ពិភពលោក
        @param x ( int ) - កូអរដោនេ x របស់ប្លុក
        @param y ( int ) - កូអរដោនេ y របស់ប្លុក
        @param z ( int ) - កូអរដោនេ z របស់ប្លុក
        @returns គ្មាន */
    public void spuriCasokfamii(World mondo, int x, int y, int z) {
        Set<BlokoPos> aroj = casok.computeIfAbsent(mondo.getKey().toString(), k -> new HashSet<>());
        for ( BlokoPos jam : aroj ) {
            if ( jam.x() == x && jam.y() == y && jam.z() == z ) {
                return;
            }
        }
        String biomo = mondo.getBiome(x, z).getKey().toString();
        aroj.add(new BlokoPos(x, y, z, biomo));
        mondo.setBiome(x, z, org.bukkit.block.Biome.WARM_OCEAN);
        mondo.refreshChunk(x >> 4, z >> 4);
        konservi();
    }

    /* លុបការតាមដានប្លុក Casokfamii
        @param mondo ( World , មិនមែន null ) - ពិភពលោក
        @param x ( int ) - កូអរដោនេ x របស់ប្លុក
        @param y ( int ) - កូអរដោនេ y របស់ប្លុក
        @param z ( int ) - កូអរដោនេ z របស់ប្លុក
        @returns ពិតប្រសិនបើធ្លាប់បានតាមដាន */
    public boolean forgesiCasokfamii(World mondo, int x, int y, int z) {
        Set<BlokoPos> aroj = casok.get(mondo.getKey().toString());
        if ( aroj == null ) {
            return false;
        }
        BlokoPos trovita = null;
        for ( BlokoPos pos : aroj ) {
            if ( pos.x() == x && pos.y() == y && pos.z() == z ) {
                trovita = pos;
                break;
            }
        }
        if ( trovita == null ) {
            return false;
        }
        aroj.remove(trovita);
        if ( trovita.biomo() != null ) {
            org.bukkit.block.Biome malnova = org.bukkit.Registry.BIOME.get(org.bukkit.NamespacedKey.fromString(trovita.biomo()));
            if ( malnova != null ) {
                mondo.setBiome(x, z, malnova);
                mondo.refreshChunk(x >> 4, z >> 4);
            }
        }
        if ( aroj.isEmpty() ) {
            casok.remove(mondo.getKey().toString());
        }
        konservi();
        return true;
    }

    /* លុបប្លុកដែលបានតាមដានចេញពីពិភពលោក និងបញ្ជីតាមដាន
        @param mondo ( World , មិនមែន null ) - ពិភពលោក
        @param pos ( BlokoPos , មិនមែន null ) - ទីតាំង
        @returns គ្មាន */
    public void forigiBlokon(World mondo, BlokoPos pos) {
        mondo.getBlockAt(pos.x(), pos.y(), pos.z()).setType(Material.AIR);
        forgesiCasokfamii(mondo, pos.x(), pos.y(), pos.z());
    }

    /* ពិនិត្យប្លុកដែលបានតាមដានជាមួយទឹក និងសម្អាតកំណត់ត្រាដែលមិនមានសុពលភាព
        @param mondo ( World , មិនមែន null ) - ពិភពលោក
        @param x ( int ) - កូអរដោនេ x របស់ប្លុក
        @param y ( int ) - កូអរដោនេ y របស់ប្លុក
        @param z ( int ) - កូអរដោនេ z របស់ប្លុក
        @returns ពិតប្រសិនបើនៅមានសុពលភាព */
    private boolean vivaCasokfamii(World mondo, int x, int y, int z) {
        if ( ! estasCasokfamii(mondo, x, y, z) ) {
            return false;
        }
        if ( mondo.getBlockAt(x, y, z).getType() != Material.WATER ) {
            forgesiCasokfamii(mondo, x, y, z);
            return false;
        }
        return true;
    }

    /* ពិនិត្យថាតើប្លុក Casokfamii ត្រូវបានតាមដានឬអត់
        @param mondo ( World , មិនមែន null ) - ពិភពលោក
        @param x ( int ) - Bloka x
        @param y ( int ) - Bloka y
        @param z ( int ) - Bloka z
        @returns vera se spurata */
    public boolean estasCasokfamii(World mondo, int x, int y, int z) {
        Set<BlokoPos> aroj = casok.get(mondo.getKey().toString());
        if ( aroj == null ) {
            return false;
        }
        for ( BlokoPos pos : aroj ) {
            if ( pos.x() == x && pos.y() == y && pos.z() == z ) {
                return true;
            }
        }
        return false;
    }

    /* Nombri spuratajn casokfamii blokojn en mondo
        @param mondo ( World , មិនមែន null ) - ពិភពលោក
        @returns kvanto */
    public int nombriCasokfamii(World mondo) {
        Set<BlokoPos> aroj = casok.get(mondo.getKey().toString());
        return aroj == null ? 0 : aroj.size();
    }

    // ⟪ ការរកឃើញ 📃 ⟫
    // ការរកឃើញតាមប្លុក

    /* Detekti portalon nur ene de viva casokfamii
        @param ludanto ( Player , មិនមែន null ) - អ្នកលេងដែលត្រូវពិនិត្យ
        @param loko ( Location , មិនមែន null ) - ទីតាំងថ្មីរបស់អ្នកលេង
        @returns ចំណុចកណ្តាល ឬ null */
    public Location detekti(Player ludanto, Location loko) {
        World mondo = ludanto.getWorld();
        int px = loko.getBlockX();
        int py = loko.getBlockY();
        int pz = loko.getBlockZ();
        if ( ! vivaCasokfamii(mondo, px, py, pz) && ! vivaCasokfamii(mondo, px, py + 1, pz) ) {
            return null;
        }
        Location centro = memoroj.get(mondo.getKey().toString());
        if ( centro != null ) {
            centro = centro.clone();
            centro.setWorld(mondo);
            return centro;
        }
        return loko.clone();
    }

    /* បង្ហាញផ្កាភ្លើងលើប្លុក Casokfamii ដែលនៅមានសុពលភាពទាំងអស់
        @returns គ្មាន */
    public void briligi() {
        int nombro = 0;
        for ( World mondo : Bukkit.getWorlds() ) {
            Set<BlokoPos> aroj = casok.get(mondo.getKey().toString());
            if ( aroj == null ) {
                continue;
            }
            for ( BlokoPos pos : new ArrayList<>(aroj) ) {
                if ( nombro >= MAKS_BRILO ) {
                    return;
                }
                if ( ! mondo.isChunkLoaded(pos.x() >> 4, pos.z() >> 4) ) {
                    continue;
                }
                if ( mondo.getBlockAt(pos.x(), pos.y(), pos.z()).getType() != Material.WATER ) {
                    continue;
                }
                Location loko = new Location(mondo, pos.x() + 0.5, pos.y() + 0.6, pos.z() + 0.5);
                mondo.spawnParticle(Particle.END_ROD, loko, 1, 0.25, 0.25, 0.25, 0.0);
                nombro++;
            }
        }
    }

    // ⟪ ការវិនិច្ឆ័យ 📃 ⟫
    // ការវិភាគរោគវិនិច្ឆ័យ

    /* ពន្យល់មូលហេតុដែលទីតាំងជាទ្វារ ឬមិនមែនជាទ្វារ
        @param ludanto ( Player , មិនមែន null ) - អ្នកលេងដែលត្រូវពិនិត្យ
        @param loko ( Location , មិនមែន null ) - ទីតាំងដែលត្រូវពិនិត្យ
        @returns listo de linioj sen dupunktoj */
    public List<String> diagnozi(Player ludanto, Location loko) {
        List<String> linioj = new ArrayList<>();
        World mondo = ludanto.getWorld();
        int px = loko.getBlockX();
        int py = loko.getBlockY();
        int pz = loko.getBlockZ();
        linioj.add("<( Nala diagnozo )> mondo " + mondo.getName() + " xyz " + px + " " + py + " " + pz);
        linioj.add("pieda bloko " + mondo.getBlockAt(px, py, pz).getType() + " kapa bloko " + mondo.getBlockAt(px, py + 1, pz).getType());
        linioj.add("casokfamii ĉe piedoj " + ( estasCasokfamii(mondo, px, py, pz) ? "jes" : "ne" ) + " ĉe kapo " + ( estasCasokfamii(mondo, px, py + 1, pz) ? "jes" : "ne" ));
        linioj.add("spurataj casokfamii en mondo " + nombriCasokfamii(mondo));
        List<String> proksimaj = proksimajCasokfamii(mondo, px, py, pz);
        if ( proksimaj.isEmpty() ) {
            linioj.add("neniuj casokfamii en " + PROKSIMO + " blokoj");
        } else {
            linioj.add("proksimaj casokfamii " + String.join(" , ", proksimaj));
        }
        linioj.add("casokfamii en tuŝo " + ( detekti(ludanto, loko) != null ? "jes" : "ne" ));
        return linioj;
    }

    /* រាយបញ្ជីប្លុក Casokfamii ដែលត្រូវបានតាមដាននៅជិតទីតាំង
        @param mondo ( World , មិនមែន null ) - ពិភពលោក
        @param px ( int ) - Centra x
        @param py ( int ) - Centra y
        @param pz ( int ) - Centra z
        @returns listo de koordinatoj maksimume ok */
    private List<String> proksimajCasokfamii(World mondo, int px, int py, int pz) {
        List<String> rezulto = new ArrayList<>();
        Set<BlokoPos> aroj = casok.get(mondo.getKey().toString());
        if ( aroj == null ) {
            return rezulto;
        }
        for ( BlokoPos pos : aroj ) {
            if ( Math.abs(pos.x() - px) <= PROKSIMO && Math.abs(pos.y() - py) <= PROKSIMO && Math.abs(pos.z() - pz) <= PROKSIMO ) {
                rezulto.add(pos.x() + " " + pos.y() + " " + pos.z());
                if ( rezulto.size() >= MONTRO ) {
                    break;
                }
            }
        }
        return rezulto;
    }

    // ⟪ ការមកដល់ 📃 ⟫
    // ទីតាំងមកដល់

    /* ស្វែងរកទ្វារដែលបានចងចាំ ឬកន្លែងកំណើតដែលមានសុវត្ថិភាព ដោយមិនសាងសង់អ្វី
        @param celo ( World , មិនមែន null ) - ពិភពលោកគោលដៅ
        @returns sekura alvena loko */
    public Location troviAŭKonstrui(World celo) {
        Location memoro = memoroj.get(celo.getKey().toString());
        if ( memoro != null ) {
            memoro = memoro.clone();
            memoro.setWorld(celo);
            if ( sekura(memoro) ) {
                return memoro;
            }
        }
        return sekuraNaskiĝo(celo);
    }

    /* ពិនិត្យថាតើពិភពលោកមានទ្វារដែលបានចងចាំ ឬទឹកដែលបានតាមដានឬអត់
        @param celo ( World , មិនមែន null ) - ពិភពលោកគោលដៅ
        @returns vera se portalo ekzistas */
    public boolean havasPortalon(World celo) {
        return memoroj.containsKey(celo.getKey().toString()) || nombriCasokfamii(celo) > 0;
    }

    /* ស្វែងរកទីតាំងមានសុវត្ថិភាពនៅកន្លែងកំណើត ដោយមិនដាក់ប្លុក
        @param celo ( World , មិនមែន null ) - ពិភពលោកគោលដៅ
        @returns sekura alvena loko */
    private Location sekuraNaskiĝo(World celo) {
        Location naskiĝo = celo.getSpawnLocation().clone();
        int x = naskiĝo.getBlockX();
        int z = naskiĝo.getBlockZ();
        int y = naskiĝo.getBlockY();
        for ( int i = 0; i < 16; i++ ) { // 0o20
            Location provo = new Location(celo, x + 0.5, y + i, z + 0.5, naskiĝo.getYaw(), 0.0F);
            if ( sekura(provo) ) {
                return provo;
            }
        }
        for ( int i = 1; i <= 16; i++ ) { // 0o20
            Location provo = new Location(celo, x + 0.5, y - i, z + 0.5, naskiĝo.getYaw(), 0.0F);
            if ( sekura(provo) ) {
                return provo;
            }
        }
        return naskiĝo;
    }

    /* ពិនិត្យថាតើទីតាំងមកដល់មានសុវត្ថិភាពសម្រាប់ឈរឬអត់
        @param loko ( Location , មិនមែន null ) - ទីតាំងដែលត្រូវពិនិត្យ
        @returns vera se sekura */
    private boolean sekura(Location loko) {
        World mondo = loko.getWorld();
        if ( mondo == null ) {
            return false;
        }
        int x = loko.getBlockX();
        int y = loko.getBlockY();
        int z = loko.getBlockZ();
        if ( ! estasCasokfamii(mondo, x, y - 1, z) && ! mondo.getBlockAt(x, y - 1, z).getType().isSolid() ) {
            return false;
        }
        Block piedoj = mondo.getBlockAt(x, y, z);
        Block kapo = mondo.getBlockAt(x, y + 1, z);
        return ( piedoj.isPassable() || estasCasokfamii(mondo, x, y, z) ) && kapo.isPassable();
    }

    // ⟪ ទីតាំងប្លុក 📃 ⟫
    // ទីតាំងប្លុកដែលបានតាមដាន

    /* Simpla tenilo por unu spurata bloko
        @returns ទីតាំងថ្មី */
    public record BlokoPos(int x, int y, int z, String biomo) {
    }
}
