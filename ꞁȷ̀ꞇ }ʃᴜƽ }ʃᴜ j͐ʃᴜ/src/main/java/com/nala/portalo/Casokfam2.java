package com.nala.portalo;

import com.nala.NalaDaxe;
import com.nala.config.S2bana;
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

// ≺⧼ ſɟᴜ j͑ʃɜ ſɭʞᴜ ŋᷠɹ 📃 ⧽≻


/* ſɟᴜ j͑ʃɜ ſɭʞᴜ ŋᷠɹ */
public class Casokfam2 {

    // ⟪ ſɭэ j͐ʃꞇȝ ʌ ᴜ ɽ͑ʃ'ᴜȝ 📃 ⟫

    private static final int KA5IK = 8;
    private static final int L6DA = 8;
    private static final int PAL6_1IJE = 64;

    // ⟪ ſɭэ j͐ʃꞇȝ ʌ ᴜ ɽ͑ʃ'ᴜȝ 📃 ⟫

    private final NalaDaxe daxe;
    private final NamespacedKey ca3aq;
    private final Map<String, Location> ksaka8 = new HashMap<>();
    private final Map<String, Set<K6liqAraq>> casokfam2222 = new HashMap<>();
    private File cakavop2;
    private YamlConfiguration vop26;

    public Casokfam2(NalaDaxe daxe) {
        this.daxe = daxe;
        this.ca3aq = new NamespacedKey(daxe, "casokfamii");
    }

    // ⟪ ſɭэ j͐ʃꞇȝ ʌ ᴜ ɽ͑ʃ'ᴜȝ 📃 ⟫


    /* ſɭэ j͐ʃꞇȝ ʌ ᴜ ɽ͑ʃ'ᴜȝ */
    public void ts2tosax() {
        cakavop2 = new File(daxe.getDataFolder(), "portals.yml");
        cakavop2.getParentFile().mkdirs();
        vop26 = YamlConfiguration.loadConfiguration(cakavop2);
        for ( String nalaCa3aq : vop26.getKeys(false) ) {
            if ( ! vop26.isConfigurationSection(nalaCa3aq) ) {
                continue;
            }
            ConfigurationSection kantoni14 = vop26.getConfigurationSection(nalaCa3aq);
            Location sost22 = kantoni14.getLocation("centro");
            if ( sost22 != null ) {
                ksaka8.put(nalaCa3aq, sost22);
            }
            Set<K6liqAraq> ca1ara5 = new HashSet<>();
            for ( Map<?, ?> mapo : kantoni14.getMapList("casok") ) {
                try {
                    Object nalaK2fe = mapo.get("biomo");
                    ca1ara5.add(new K6liqAraq(
                        ( (Number) mapo.get("x") ).intValue(),
                        ( (Number) mapo.get("y") ).intValue(),
                        ( (Number) mapo.get("z") ).intValue(),
                        nalaK2fe == null ? null : String.valueOf(nalaK2fe)));
                } catch ( Exception a3ohk2nik2p2 ) {
                    daxe.getLogger().warning(S2bana.YOR2_CASOKFAM2_H2L_XEHATE + S2bana.nala2(nalaCa3aq) + " ⟅");
                }
            }
            if ( ! ca1ara5.isEmpty() ) {
                casokfam2222.put(nalaCa3aq, ca1ara5);
            }
        }
    }

    /* ſɭэ j͐ʃꞇȝ ʌ ᴜ ɽ͑ʃ'ᴜȝ */
    public void ve3aq() {
        if ( vop26 == null || cakavop2 == null ) {
            return;
        }
        for ( String hunaqCa3aq : new ArrayList<>(vop26.getKeys(false)) ) {
            if ( ! ksaka8.containsKey(hunaqCa3aq) && ! casokfam2222.containsKey(hunaqCa3aq) ) {
                vop26.set(hunaqCa3aq, null);
            }
        }
        Set<String> ca1ara6 = new HashSet<>();
        ca1ara6.addAll(ksaka8.keySet());
        ca1ara6.addAll(casokfam2222.keySet());
        for ( String nalaCa3aq : ca1ara6 ) {
            ConfigurationSection kantoni14 = vop26.getConfigurationSection(nalaCa3aq);
            if ( kantoni14 == null ) {
                kantoni14 = vop26.createSection(nalaCa3aq);
            }
            kantoni14.set("regionoj", null);
            kantoni14.set("centro", ksaka8.get(nalaCa3aq));
            List<Map<String, Object>> k6liq2 = new ArrayList<>();
            Set<K6liqAraq> ca1ara5 = casokfam2222.get(nalaCa3aq);
            if ( ca1ara5 != null ) {
                for ( K6liqAraq araq8 : ca1ara5 ) {
                    Map<String, Object> mapo = new HashMap<>();
                    mapo.put("x", araq8.kantoni2());
                    mapo.put("y", araq8.kantoni22());
                    mapo.put("z", araq8.kantoni3());
                    if ( araq8.nala3() != null ) {
                        mapo.put("biomo", araq8.nala3());
                    }
                    k6liq2.add(mapo);
                }
            }
            kantoni14.set("casok", k6liq2);
        }
        try {
            vop26.save(cakavop2);
        } catch ( Exception a3ohk2nik2p2 ) {
            daxe.getLogger().warning(S2bana.A3OHK2NIK2P2_VE3AQ_CASOKFAM2 + a3ohk2nik2p2.getMessage() + " ⟅");
        }
    }

    // ⟪ ſɭэ j͐ʃꞇȝ ʌ ᴜ ɽ͑ʃ'ᴜȝ 📃 ⟫


    /* ſɭэ j͐ʃꞇȝ ʌ ᴜ ɽ͑ʃ'ᴜȝ */
    public ItemStack vepaqK2fe(int k2fe13) {
        if ( k2fe13 < 1 ) {
            k2fe13 = 1;
        }
        if ( k2fe13 > 64 ) {
            k2fe13 = 64;
        }
        ItemStack k2fe14 = new ItemStack(Material.WATER_BUCKET, k2fe13);
        ItemMeta vop25 = k2fe14.getItemMeta();
        vop25.displayName(Component.text(S2bana.K2FE_KSAKA));
        vop25.lore(java.util.List.of(Component.text(S2bana.K2FE_S2BANA_K2FE), Component.text(S2bana.K2FE_S2BANA_K2FE2)));
        vop25.getPersistentDataContainer().set(ca3aq, PersistentDataType.BYTE, (byte) 1);
        k2fe14.setItemMeta(vop25);
        return k2fe14;
    }

    /* ſɭэ j͐ʃꞇȝ ʌ ᴜ ɽ͑ʃ'ᴜȝ */
    public boolean xehateCasokfam2K2fe(ItemStack k2fe14) {
        if ( k2fe14 == null || k2fe14.getType() != Material.WATER_BUCKET ) {
            return false;
        }
        if ( ! k2fe14.hasItemMeta() ) {
            return false;
        }
        Byte xehate6 = k2fe14.getItemMeta().getPersistentDataContainer().get(ca3aq, PersistentDataType.BYTE);
        return xehate6 != null && xehate6 == (byte) 1;
    }

    // ⟪ ſɭэ j͐ʃꞇȝ ʌ ᴜ ɽ͑ʃ'ᴜȝ 📃 ⟫


    /* ſɭэ j͐ʃꞇȝ ʌ ᴜ ɽ͑ʃ'ᴜȝ */
    public void s2rol2miCasokfam2(World nala2, int kantoni2, int kantoni22, int kantoni3) {
        Set<K6liqAraq> ca1ara5 = casokfam2222.computeIfAbsent(nala2.getKey().toString(), k2fe3 -> new HashSet<>());
        for ( K6liqAraq gani15 : ca1ara5 ) {
            if ( gani15.kantoni2() == kantoni2 && gani15.kantoni22() == kantoni22 && gani15.kantoni3() == kantoni3 ) {
                return;
            }
        }
        String nala3 = nala2.getBiome(kantoni2, kantoni3).getKey().toString();
        ca1ara5.add(new K6liqAraq(kantoni2, kantoni22, kantoni3, nala3));
        nala2.setBiome(kantoni2, kantoni3, org.bukkit.block.Biome.WARM_OCEAN);
        nala2.refreshChunk(kantoni2 >> 4, kantoni3 >> 4);
        ve3aq();
    }

    /* ſɭэ j͐ʃꞇȝ ʌ ᴜ ɽ͑ʃ'ᴜȝ */
    public boolean h2lCasokfam2(World nala2, int kantoni2, int kantoni22, int kantoni3) {
        Set<K6liqAraq> ca1ara5 = casokfam2222.get(nala2.getKey().toString());
        if ( ca1ara5 == null ) {
            return false;
        }
        K6liqAraq s2rol2mi7 = null;
        for ( K6liqAraq araq8 : ca1ara5 ) {
            if ( araq8.kantoni2() == kantoni2 && araq8.kantoni22() == kantoni22 && araq8.kantoni3() == kantoni3 ) {
                s2rol2mi7 = araq8;
                break;
            }
        }
        if ( s2rol2mi7 == null ) {
            return false;
        }
        ca1ara5.remove(s2rol2mi7);
        if ( s2rol2mi7.nala3() != null ) {
            org.bukkit.block.Biome hunaq2 = org.bukkit.Registry.BIOME.get(org.bukkit.NamespacedKey.fromString(s2rol2mi7.nala3()));
            if ( hunaq2 != null ) {
                nala2.setBiome(kantoni2, kantoni3, hunaq2);
                nala2.refreshChunk(kantoni2 >> 4, kantoni3 >> 4);
            }
        }
        if ( ca1ara5.isEmpty() ) {
            casokfam2222.remove(nala2.getKey().toString());
        }
        ve3aq();
        return true;
    }

    /* ſɭэ j͐ʃꞇȝ ʌ ᴜ ɽ͑ʃ'ᴜȝ */
    public void h2lK6liq(World nala2, K6liqAraq araq8) {
        nala2.getBlockAt(araq8.kantoni2(), araq8.kantoni22(), araq8.kantoni3()).setType(Material.AIR);
        h2lCasokfam2(nala2, araq8.kantoni2(), araq8.kantoni22(), araq8.kantoni3());
    }

    /* ſɭэ j͐ʃꞇȝ ʌ ᴜ ɽ͑ʃ'ᴜȝ */
    private boolean sp2Casokfam2(World nala2, int kantoni2, int kantoni22, int kantoni3) {
        if ( ! xehateCasokfam2(nala2, kantoni2, kantoni22, kantoni3) ) {
            return false;
        }
        if ( nala2.getBlockAt(kantoni2, kantoni22, kantoni3).getType() != Material.WATER ) {
            h2lCasokfam2(nala2, kantoni2, kantoni22, kantoni3);
            return false;
        }
        return true;
    }

    /* ſɭэ j͐ʃꞇȝ ʌ ᴜ ɽ͑ʃ'ᴜȝ */
    public boolean xehateCasokfam2(World nala2, int kantoni2, int kantoni22, int kantoni3) {
        Set<K6liqAraq> ca1ara5 = casokfam2222.get(nala2.getKey().toString());
        if ( ca1ara5 == null ) {
            return false;
        }
        for ( K6liqAraq araq8 : ca1ara5 ) {
            if ( araq8.kantoni2() == kantoni2 && araq8.kantoni22() == kantoni22 && araq8.kantoni3() == kantoni3 ) {
                return true;
            }
        }
        return false;
    }

    /* ſɭэ j͐ʃꞇȝ ʌ ᴜ ɽ͑ʃ'ᴜȝ */
    public int k2feCasokfam2(World nala2) {
        Set<K6liqAraq> ca1ara5 = casokfam2222.get(nala2.getKey().toString());
        return ca1ara5 == null ? 0 : ca1ara5.size();
    }

    // ⟪ ſɭэ j͐ʃꞇȝ ʌ ᴜ ɽ͑ʃ'ᴜȝ 📃 ⟫


    /* ſɭэ j͐ʃꞇȝ ʌ ᴜ ɽ͑ʃ'ᴜȝ */
    public Location s2rol2mi9(Player hq2, Location araq3) {
        World nala2 = hq2.getWorld();
        int araqKantoni2 = araq3.getBlockX();
        int araqKantoni22 = araq3.getBlockY();
        int araqKantoni3 = araq3.getBlockZ();
        if ( ! sp2Casokfam2(nala2, araqKantoni2, araqKantoni22, araqKantoni3) && ! sp2Casokfam2(nala2, araqKantoni2, araqKantoni22 + 1, araqKantoni3) ) {
            return null;
        }
        Location sost22 = ksaka8.get(nala2.getKey().toString());
        if ( sost22 != null ) {
            sost22 = sost22.clone();
            sost22.setWorld(nala2);
            return sost22;
        }
        return araq3.clone();
    }

    /* ſɭэ j͐ʃꞇȝ ʌ ᴜ ɽ͑ʃ'ᴜȝ */
    public void a1ije() {
        int k2fe11 = 0;
        for ( World nala2 : Bukkit.getWorlds() ) {
            Set<K6liqAraq> ca1ara5 = casokfam2222.get(nala2.getKey().toString());
            if ( ca1ara5 == null ) {
                continue;
            }
            for ( K6liqAraq araq8 : new ArrayList<>(ca1ara5) ) {
                if ( k2fe11 >= PAL6_1IJE ) {
                    return;
                }
                if ( ! nala2.isChunkLoaded(araq8.kantoni2() >> 4, araq8.kantoni3() >> 4) ) {
                    continue;
                }
                if ( nala2.getBlockAt(araq8.kantoni2(), araq8.kantoni22(), araq8.kantoni3()).getType() != Material.WATER ) {
                    continue;
                }
                Location araq3 = new Location(nala2, araq8.kantoni2() + 0.5, araq8.kantoni22() + 0.6, araq8.kantoni3() + 0.5);
                nala2.spawnParticle(Particle.END_ROD, araq3, 1, 0.25, 0.25, 0.25, 0.0);
                k2fe11++;
            }
        }
    }

    // ⟪ ſɭэ j͐ʃꞇȝ ʌ ᴜ ɽ͑ʃ'ᴜȝ 📃 ⟫


    /* ſɭэ j͐ʃꞇȝ ʌ ᴜ ɽ͑ʃ'ᴜȝ */
    public List<String> s2rol2mi10(Player hq2, Location araq3) {
        List<String> ox2pewa3 = new ArrayList<>();
        World nala2 = hq2.getWorld();
        int araqKantoni2 = araq3.getBlockX();
        int araqKantoni22 = araq3.getBlockY();
        int araqKantoni3 = araq3.getBlockZ();
        ox2pewa3.add("<( Nala diagnozo )> mondo " + nala2.getName() + " xyz " + araqKantoni2 + " " + araqKantoni22 + " " + araqKantoni3);
        ox2pewa3.add("pieda bloko " + nala2.getBlockAt(araqKantoni2, araqKantoni22, araqKantoni3).getType() + " kapa bloko " + nala2.getBlockAt(araqKantoni2, araqKantoni22 + 1, araqKantoni3).getType());
        ox2pewa3.add("casokfamii ĉe piedoj " + ( xehateCasokfam2(nala2, araqKantoni2, araqKantoni22, araqKantoni3) ? "jes" : "ne" ) + " ĉe kapo " + ( xehateCasokfam2(nala2, araqKantoni2, araqKantoni22 + 1, araqKantoni3) ? "jes" : "ne" ));
        ox2pewa3.add("spurataj casokfamii en mondo " + k2feCasokfam2(nala2));
        List<String> ka5ik7 = ka5ikCasokfam2(nala2, araqKantoni2, araqKantoni22, araqKantoni3);
        if ( ka5ik7.isEmpty() ) {
            ox2pewa3.add("neniuj casokfamii en " + KA5IK + " blokoj");
        } else {
            ox2pewa3.add("proksimaj casokfamii " + String.join(" , ", ka5ik7));
        }
        ox2pewa3.add("casokfamii en tuŝo " + ( s2rol2mi9(hq2, araq3) != null ? "jes" : "ne" ));
        return ox2pewa3;
    }

    /* ſɭэ j͐ʃꞇȝ ʌ ᴜ ɽ͑ʃ'ᴜȝ */
    private List<String> ka5ikCasokfam2(World nala2, int araqKantoni2, int araqKantoni22, int araqKantoni3) {
        List<String> a10ni = new ArrayList<>();
        Set<K6liqAraq> ca1ara5 = casokfam2222.get(nala2.getKey().toString());
        if ( ca1ara5 == null ) {
            return a10ni;
        }
        for ( K6liqAraq araq8 : ca1ara5 ) {
            if ( Math.abs(araq8.kantoni2() - araqKantoni2) <= KA5IK && Math.abs(araq8.kantoni22() - araqKantoni22) <= KA5IK && Math.abs(araq8.kantoni3() - araqKantoni3) <= KA5IK ) {
                a10ni.add(araq8.kantoni2() + " " + araq8.kantoni22() + " " + araq8.kantoni3());
                if ( a10ni.size() >= L6DA ) {
                    break;
                }
            }
        }
        return a10ni;
    }

    // ⟪ ſɭэ j͐ʃꞇȝ ʌ ᴜ ɽ͑ʃ'ᴜȝ 📃 ⟫


    /* ſɭэ j͐ʃꞇȝ ʌ ᴜ ɽ͑ʃ'ᴜȝ */
    public Location s2rol2miC2kaniVepaq(World kxawa) {
        Location ksaka10 = ksaka8.get(kxawa.getKey().toString());
        if ( ksaka10 != null ) {
            ksaka10 = ksaka10.clone();
            ksaka10.setWorld(kxawa);
            if ( anis5(ksaka10) ) {
                return ksaka10;
            }
        }
        return anisVeb6kek(kxawa);
    }

    /* ſɭэ j͐ʃꞇȝ ʌ ᴜ ɽ͑ʃ'ᴜȝ */
    public boolean eskekCasokfam2(World kxawa) {
        return ksaka8.containsKey(kxawa.getKey().toString()) || k2feCasokfam2(kxawa) > 0;
    }

    /* ſɭэ j͐ʃꞇȝ ʌ ᴜ ɽ͑ʃ'ᴜȝ */
    private Location anisVeb6kek(World kxawa) {
        Location veb6kek10 = kxawa.getSpawnLocation().clone();
        int kantoni2 = veb6kek10.getBlockX();
        int kantoni3 = veb6kek10.getBlockZ();
        int kantoni22 = veb6kek10.getBlockY();
        for ( int k2fe = 0; k2fe < 16; k2fe++ ) {
            Location s2rol2mi3 = new Location(kxawa, kantoni2 + 0.5, kantoni22 + k2fe, kantoni3 + 0.5, veb6kek10.getYaw(), 0.0F);
            if ( anis5(s2rol2mi3) ) {
                return s2rol2mi3;
            }
        }
        for ( int k2fe = 1; k2fe <= 16; k2fe++ ) {
            Location s2rol2mi3 = new Location(kxawa, kantoni2 + 0.5, kantoni22 - k2fe, kantoni3 + 0.5, veb6kek10.getYaw(), 0.0F);
            if ( anis5(s2rol2mi3) ) {
                return s2rol2mi3;
            }
        }
        return veb6kek10;
    }

    /* ſɭэ j͐ʃꞇȝ ʌ ᴜ ɽ͑ʃ'ᴜȝ */
    private boolean anis5(Location araq3) {
        World nala2 = araq3.getWorld();
        if ( nala2 == null ) {
            return false;
        }
        int kantoni2 = araq3.getBlockX();
        int kantoni22 = araq3.getBlockY();
        int kantoni3 = araq3.getBlockZ();
        if ( ! xehateCasokfam2(nala2, kantoni2, kantoni22 - 1, kantoni3) && ! nala2.getBlockAt(kantoni2, kantoni22 - 1, kantoni3).getType().isSolid() ) {
            return false;
        }
        Block kata5 = nala2.getBlockAt(kantoni2, kantoni22, kantoni3);
        Block caka3aq = nala2.getBlockAt(kantoni2, kantoni22 + 1, kantoni3);
        return ( kata5.isPassable() || xehateCasokfam2(nala2, kantoni2, kantoni22, kantoni3) ) && caka3aq.isPassable();
    }

    // ⟪ ſɭэ j͐ʃꞇȝ ʌ ᴜ ɽ͑ʃ'ᴜȝ 📃 ⟫


    /* ſɭэ j͐ʃꞇȝ ʌ ᴜ ɽ͑ʃ'ᴜȝ */
    public record K6liqAraq(int kantoni2, int kantoni22, int kantoni3, String nala3) {
    }
}
