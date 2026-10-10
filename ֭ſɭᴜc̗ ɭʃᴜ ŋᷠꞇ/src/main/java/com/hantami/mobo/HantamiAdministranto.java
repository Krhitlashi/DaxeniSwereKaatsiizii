package com.hantami.mobo;

import com.hantami.HantamiPlugin;
import com.hantami.config.Agordo;
import com.hantami.config.Mesagoj;
import com.destroystokyo.paper.profile.PlayerProfile;
import io.papermc.paper.datacomponent.item.ResolvableProfile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Mannequin;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

// ≺⧼ អ្នកគ្រប់គ្រង Hantami 📃 ⧽≻
// បង្កើត តាមដាន និងបញ្ជាមនុស្សតុក្កតា

/* បង្កើត តាមដាន និងដឹកនាំប្រជាជន Hantami ក្នុងពិភពលោក
    @param kromprogramo ( HantamiPlugin , មិនមែន null ) - កម្មវិធីជំនួយចម្បង
    @returns អ្នកគ្រប់គ្រងថ្មី */
public class HantamiAdministranto {

    // ⟪ Datumoj 📃 ⟫
    // ស្ថានភាពរបស់ Hantami នីមួយៗ
    private static final String ETIKEDO = "hantami";

    /* ស្ថានភាពខាងក្នុងរបស់ Hantami មួយ
        @returns ស្ថានភាពថ្មី */
    private static class Stato {
        UUID celo = null;
        int soleca = 0;
        int konstruKd = 1200; // 0o2260
        Location vaga = null;
        long vagaFino = 0L;
        int atakoKd = 0;
        int animFazo = 0;
        Location movCelo = null;
        double movRapido = 0.15D;
        int spinFazo = 0;
        Location lastLoko = null;
        int senmova = 0;
        double flanka = 0.0D;
        UUID predanto = null;
        int embusko = 0;
        boolean koŝmaro = false;
        double saltaAlteco = 0.42D;
        Location hejmo = null;
    }

    private final HantamiPlugin kromprogramo;
    private final Agordo agordo;
    private final Random hazardo = new Random();
    private volatile boolean aktiva = false;
    private final Map<UUID, Stato> statoj = new HashMap<>();
    private final List<Location> domoj = new ArrayList<>();
    private final List<Location> vilagxoj = new ArrayList<>();
    private final List<KonstruProjekto> projektoj = new ArrayList<>();
    private final List<String> datumbazo = new ArrayList<>();
    private final Object datumbazaSeruro = new Object();
    private final java.util.Map<String, ResolvableProfile> profilKaŝo = new java.util.HashMap<>();
    private int taskoId = -1;
    private int movTaskoId = -1;
    private int tiklo = 0;
    private boolean estisNokto = false;

    public HantamiAdministranto(HantamiPlugin kromprogramo) {
        this.kromprogramo = kromprogramo;
        this.agordo = kromprogramo.agordo();
    }

    // ⟪ Mondo 📃 ⟫
    // រកពិភពលោកដែលរស់នៅ

    /* ទទួលពិភព Hantami នៅពេលវាមាន
        @returns ពិភពលោក ឬ null */
    public World mondo() {
        return Bukkit.getWorld(agordo.mondo());
    }

    // ⟪ Konservado 📃 ⟫
    // ចងចាំផ្ទះនិងភូមិ

    /* ផ្ទុកផ្ទះនិងភូមិដែលស្គាល់ពីឯកសារ
        @returns គ្មាន */
    public void ŝargi() {
        java.io.File dosiero = new java.io.File(kromprogramo.getDataFolder(), "hantami.yml");
        if ( dosiero.exists() ) {
            YamlConfiguration yaml = YamlConfiguration.loadConfiguration(dosiero);
            for ( String teksto : yaml.getStringList("hantamoj") ) {
                try {
                    statoj.putIfAbsent(UUID.fromString(teksto), novaStato());
                } catch ( IllegalArgumentException eraro ) {
                    kromprogramo.getLogger().warning(Mesagoj.WARN_SENMONDO);
                }
            }
            World mondo = mondo();
            if ( mondo != null ) {
                domoj.clear();
                for ( String teksto : yaml.getStringList("domoj") ) {
                    Location loko = legiLokon(mondo, teksto);
                    if ( loko != null ) {
                        domoj.add(loko);
                    }
                }
                vilagxoj.clear();
                for ( String teksto : yaml.getStringList("vilagxoj") ) {
                    Location loko = legiLokon(mondo, teksto);
                    if ( loko != null ) {
                        vilagxoj.add(loko);
                    }
                }
            }
        }
        ŝargiDatumbazon();
    }

    /* រក្សាទុកផ្ទះនិងភូមិដែលស្គាល់ទៅក្នុងឯកសារ
        @returns គ្មាន */
    public void konservi() {
        java.io.File dosiero = new java.io.File(kromprogramo.getDataFolder(), "hantami.yml");
        YamlConfiguration yaml = new YamlConfiguration();
        List<String> domTekstoj = new ArrayList<>();
        for ( Location loko : domoj ) {
            domTekstoj.add(skribiLokon(loko));
        }
        yaml.set("domoj", domTekstoj);
        List<String> vilTekstoj = new ArrayList<>();
        for ( Location loko : vilagxoj ) {
            vilTekstoj.add(skribiLokon(loko));
        }
        yaml.set("vilagxoj", vilTekstoj);
        yaml.set("hantamoj", statoj.keySet().stream().map(UUID::toString).toList());
        try {
            yaml.save(dosiero);
        } catch ( Exception eraro ) {
            kromprogramo.getLogger().warning(Mesagoj.WARN_SENMONDO);
        }
    }

    /* ផ្ទុកមូលដ្ឋានឈ្មោះក្នុងតំបន់ពីឯកសារឡើងវិញ
        @returns ចំនួនឈ្មោះដែលផ្ទុក */
    public int reŝargiDatumbazon() {
        ŝargiDatumbazon();
        synchronized ( datumbazaSeruro ) {
            return datumbazo.size();
        }
    }

    /* ផ្ទុកមូលដ្ឋានឈ្មោះក្នុងតំបន់ពីឯកសារ
        @returns គ្មាន */
    private void ŝargiDatumbazon() {
        synchronized ( datumbazaSeruro ) {
            datumbazo.clear();
            java.io.File dosiero = new java.io.File(kromprogramo.getDataFolder(), "nomoj.txt");
            if ( ! dosiero.exists() ) {
                return;
            }
            try {
                for ( String linio : java.nio.file.Files.readAllLines(dosiero.toPath()) ) {
                    String nomo = linio.trim();
                    if ( nomo.matches("[A-Za-z0-9_]{3,16}") && ! datumbazo.contains(nomo) ) {
                        datumbazo.add(nomo);
                    }
                }
            } catch ( Exception eraro ) {
                kromprogramo.getLogger().warning(Mesagoj.WARN_SENMONDO);
            }
        }
    }

    /* អានទីតាំងប្លុកពីអត្ថបទ
        @param mondo ( World , មិនមែន null ) - ពិភពលោកគោលដៅ
        @param teksto ( String , មិនមែន null ) - អត្ថបទជាទម្រង់ x y z
        @returns ទីតាំង ឬ null */
    private Location legiLokon(World mondo, String teksto) {
        try {
            String[] partoj = teksto.split(" ");
            int x = Integer.parseInt(partoj[0]);
            int y = Integer.parseInt(partoj[1]);
            int z = Integer.parseInt(partoj[2]);
            return new Location(mondo, x, y, z);
        } catch ( Exception eraro ) {
            return null;
        }
    }

    /* សរសេរទីតាំងប្លុកជាអត្ថបទ
        @param loko ( Location , មិនមែន null ) - ទីតាំងត្រូវសរសេរ
        @returns អត្ថបទជាទម្រង់ x y z */
    private String skribiLokon(Location loko) {
        return loko.getBlockX() + " " + loko.getBlockY() + " " + loko.getBlockZ();
    }

    // ⟪ Horloĝo 📃 ⟫
    // ខួរក្បាលដដដែលៗ

    /* ចាប់ផ្តើមធីកដដដែលៗ
        @returns គ្មាន */
    public void eklabori() {
        halti();
        aktiva = true;
        taskoId = Bukkit.getScheduler().runTaskTimer(kromprogramo, this::tikli, 40, 4).getTaskId(); // 0o50 0o4
        movTaskoId = Bukkit.getScheduler().runTaskTimer(kromprogramo, this::moviĈiujn, 1, 1).getTaskId(); // 0o1
    }

    /* បញ្ឈប់ធីកដដដែលៗនិងរំងាប់ទាំងអស់សម្រាប់លាស្អាត
        @returns គ្មាន */
    public void halti() {
        aktiva = false;
        for ( UUID id : new ArrayList<>(statoj.keySet()) ) {
            Entity ento = Bukkit.getEntity(id);
            if ( ento instanceof Mannequin hantamo && ! hantamo.isDead() && hantamo.isValid() ) {
                hantamo.setGlowing(false);
                hantamo.customName(null);
                hantamo.setCustomNameVisible(false);
                hantamo.removePotionEffect(PotionEffectType.SPEED);
                hantamo.getEquipment().setItemInMainHand(new ItemStack(Material.AIR));
                hantamo.setVelocity(new Vector(0.0D, 0.0D, 0.0D));
            }
        }
        if ( taskoId >= 0 ) {
            Bukkit.getScheduler().cancelTask(taskoId);
            taskoId = -1;
        }
        if ( movTaskoId >= 0 ) {
            Bukkit.getScheduler().cancelTask(movTaskoId);
            movTaskoId = -1;
        }
    }

    /* ផ្លាស់ទី Hantami ទាំងអស់រលូនរាល់ធីកមានបង្វិលលោតនិងឈប់
        @returns គ្មាន */
    private void moviĈiujn() {
        for ( Map.Entry<UUID, Stato> paro : statoj.entrySet() ) {
            Entity ento = Bukkit.getEntity(paro.getKey());
            if ( ! ( ento instanceof Mannequin hantamo ) || hantamo.isDead() || ! hantamo.isValid() ) {
                continue;
            }
            Stato stato = paro.getValue();
            if ( stato.spinFazo > 0 ) {
                stato.spinFazo--;
                hantamo.setRotation(hantamo.getLocation().getYaw() + 36.0F, 0.0F); // 0o44
            }
            Player celulo = null;
            if ( stato.celo != null ) {
                Entity celEnto = Bukkit.getEntity(stato.celo);
                if ( celEnto instanceof Player ludanto && ludanto.isOnline() && ludanto.getWorld().equals(hantamo.getWorld()) && ! ludanto.isDead() && ludanto.getGameMode() != GameMode.SPECTATOR ) {
                    celulo = ludanto;
                }
            }
            Location celo = celulo != null ? celulo.getLocation() : stato.movCelo;
            if ( celo == null || ! celo.getWorld().equals(hantamo.getWorld()) ) {
                bremsi(hantamo);
                continue;
            }
            Location tie = hantamo.getLocation();
            Vector plena = celo.clone().subtract(tie).toVector();
            Vector direkto = plena.clone();
            direkto.setY(0.0D);
            if ( direkto.lengthSquared() < 0.01D ) {
                bremsi(hantamo);
                continue;
            }
            double distHoriz = direkto.length();
            direkto.normalize();
            stato.senmova++;
            if ( stato.senmova >= 10 ) { // 0o12
                stato.senmova = 0;
                if ( stato.lastLoko != null && stato.lastLoko.distanceSquared(tie) < 0.25D && tie.distanceSquared(celo) > 4.0D ) {
                    stato.flanka = hazardo.nextBoolean() ? 0.6D : -0.6D;
                }
                stato.lastLoko = tie.clone();
            }
            stato.flanka *= 0.95D;
            Vector flanken = new Vector(-direkto.getZ(), 0.0D, direkto.getX());
            Vector movo = direkto.multiply(stato.movRapido).add(flanken.multiply(stato.flanka * stato.movRapido));
            if ( celulo != null ) {
                double fazo = ( hantamo.getWorld().getFullTime() / 20.0D ) + ( hantamo.getUniqueId().hashCode() % 628 ) / 100.0D; // 0o24 0o1164
                movo.add(flanken.multiply(0.10D * Math.sin(fazo)));
            }
            double y = hantamo.getVelocity().getY();
            if ( hantamo.isOnGround() ) {
                Location antaŭe = tie.clone().add(direkto);
                boolean barita = ! antaŭe.getBlock().isPassable() || ! antaŭe.clone().add(0.0D, 1.0D, 0.0D).getBlock().isPassable();
                if ( barita ) {
                    y = stato.saltaAlteco;
                    boolean maldekstraLibera = vojoLibera(tie.clone().add(flanken));
                    boolean dekstraLibera = vojoLibera(tie.clone().subtract(flanken));
                    if ( maldekstraLibera && ! dekstraLibera ) {
                        stato.flanka = 0.9D;
                    } else if ( dekstraLibera && ! maldekstraLibera ) {
                        stato.flanka = -0.9D;
                    } else if ( maldekstraLibera && dekstraLibera && stato.flanka == 0.0D ) {
                        stato.flanka = hazardo.nextBoolean() ? 0.9D : -0.9D;
                    }
                    movo.add(flanken.multiply(stato.flanka * stato.movRapido));
                } else if ( celo.getY() - tie.getY() > 1.2D && distHoriz > 1.0D ) {
                    y = stato.saltaAlteco;
                } else if ( y < -0.2D ) {
                    y = -0.1D;
                } else {
                    y = 0.0D;
                }
                if ( ! barita && danĝeraAntaŭe(antaŭe) ) {
                    movo.multiply(0.25D);
                    stato.flanka = ( hantamo.getWorld().getFullTime() % 40L < 20L ) ? 0.8D : -0.8D; // 0o50 0o24
                }
            }
            hantamo.setVelocity(new Vector(movo.getX(), y, movo.getZ()));
            if ( stato.spinFazo <= 0 && ! stato.koŝmaro ) {
                float dezirata = (float) Math.toDegrees(Math.atan2(-plena.getX(), plena.getZ()));
                float delta = envolvi(dezirata - tie.getYaw());
                float paŝo = Math.max(-20.0F, Math.min(20.0F, delta)); // 0o24
                double horizontala = Math.sqrt(plena.getX() * plena.getX() + plena.getZ() * plena.getZ());
                float inklino = (float) Math.toDegrees(Math.atan2(-plena.getY(), horizontala));
                inklino = Math.max(-30.0F, Math.min(30.0F, inklino)); // 0o36
                hantamo.setRotation(tie.getYaw() + paŝo, inklino);
            }
        }
    }

    /* ប្រាប់ថាតើផ្លូវឆ្លងកាត់បានឬអត់
        @param loko ( Location , មិនមែន null ) - ចំណុចត្រូវពិនិត្យ
        @returns True នៅពេលឆ្លងកាត់បាន */
    private boolean vojoLibera(Location loko) {
        return loko.getBlock().isPassable() && loko.clone().add(0.0D, 1.0D, 0.0D).getBlock().isPassable();
    }

    /* ប្រាប់ថាតើដីខាងមុខមានគ្រោះថ្នាក់ឬជ្រោះឬអត់
        @param antaŭe ( Location , មិនមែន null ) - ចំណុចខាងមុខ
        @returns True នៅពេលគ្រោះថ្នាក់ */
    private boolean danĝeraAntaŭe(Location antaŭe) {
        Material tipo = antaŭe.getBlock().getType();
        if ( tipo == Material.LAVA || tipo == Material.FIRE || tipo == Material.SOUL_FIRE || tipo == Material.MAGMA_BLOCK || tipo == Material.CAMPFIRE || tipo == Material.CACTUS ) {
            return true;
        }
        for ( int i = 1; i <= 4; i++ ) { // 0o1 ĝis 0o4
            Material sube = antaŭe.clone().add(0.0D, -i, 0.0D).getBlock().getType();
            if ( sube == Material.LAVA ) {
                return true;
            }
            if ( sube.isSolid() && sube != Material.CACTUS ) {
                return false;
            }
        }
        return true;
    }

    /* បន្ថយល្បឿនតុក្កតាធម្មជាតិដោយមិនប៉ះទំនាញ
        @param hantamo ( Mannequin , មិនមែន null ) - តុក្កតាត្រូវបញ្ឈប់
        @returns គ្មាន */
    private void bremsi(Mannequin hantamo) {
        Vector rapido = hantamo.getVelocity();
        hantamo.setVelocity(new Vector(rapido.getX() * 0.5D, rapido.getY(), rapido.getZ() * 0.5D));
    }

    /* រុមមុំចូលរង្វង់ពីដកមួយរយប៉ែតសិបទៅមួយរយប៉ែតសិប
        @param angulo ( float ) - មុំត្រូវរុម
        @returns មុំរវាង -180 និង 180 */
    private float envolvi(float angulo) {
        while ( angulo > 180.0F ) {
            angulo -= 360.0F;
        }
        while ( angulo < -180.0F ) {
            angulo += 360.0F;
        }
        return angulo;
    }

    /* ធីកខួរក្បាលមួយសម្រាប់ប្រជាជនទាំងមូល
        @returns គ្មាន */
    private void tikli() {
        tiklo++;
        World mondo = mondo();
        if ( mondo == null ) {
            if ( tiklo % 75 == 0 ) { // 0o113
                kromprogramo.getLogger().warning(Mesagoj.WARN_SENMONDO);
            }
            return;
        }
        List<UUID> mortintoj = new ArrayList<>();
        for ( Map.Entry<UUID, Stato> paro : statoj.entrySet() ) {
            Entity ento = Bukkit.getEntity(paro.getKey());
            if ( ento == null ) {
                continue;
            }
            if ( ! ( ento instanceof Mannequin hantamo ) || hantamo.isDead() || ! hantamo.isValid() ) {
                mortintoj.add(paro.getKey());
                continue;
            }
            if ( ! hantamo.getWorld().equals(mondo) ) {
                mortintoj.add(paro.getKey());
                continue;
            }
            konduto(hantamo, paro.getValue());
        }
        for ( UUID mortinto : mortintoj ) {
            statoj.remove(mortinto);
        }
        kontroliNokton(mondo);
        if ( ! projektoj.isEmpty() ) {
            java.util.Iterator<KonstruProjekto> iteratoro = projektoj.iterator();
            while ( iteratoro.hasNext() ) {
                KonstruProjekto projekto = iteratoro.next();
                int stato = projekto.paŝo();
                if ( stato == 1 ) {
                    iteratoro.remove();
                    Location ejo = projekto.ejo();
                    domoj.add(new Location(ejo.getWorld(), ejo.getBlockX(), ejo.getBlockY(), ejo.getBlockZ()));
                    if ( domoj.size() > 64 ) { // 0o100
                        domoj.remove(0);
                    }
                    kromprogramo.getLogger().info(Mesagoj.INFO_DOMO);
                } else if ( stato == 2 ) {
                    iteratoro.remove();
                }
            }
        }
        if ( tiklo % 50 == 0 ) { // 0o62
            kontroliVilagxojn(mondo);
        }
        if ( tiklo % 1500 == 0 ) { // 0o2734
            registriŜargitajn(mondo, false);
            subteniPopolon(mondo);
        }
        if ( tiklo % 150 == 0 ) { // 0o226
            konservi();
        }
    }

    /* ប្រាប់ថាតើពិភពលោកយប់ឬអត់
        @param mondo ( World , មិនមែន null ) - ពិភពលោកត្រូវពិនិត្យ
        @returns True នៅពេលយប់ */
    private boolean estasNokto(World mondo) {
        long tempo = mondo.getTime() % 24000L; // 0o57000
        return tempo >= 13000L && tempo <= 23000L; // 0o31250 ĝis 0o54730
    }

    /* រមៀលសុបិន្តអាក្រក់ពេលយប់ធ្លាក់និងរំងាប់ពេលថ្ងៃរះ
        @param mondo ( World , មិនមែន null ) - Cela mondo
        @returns គ្មាន */
    private void kontroliNokton(World mondo) {
        boolean nokto = estasNokto(mondo);
        if ( nokto && ! estisNokto ) {
            for ( Map.Entry<UUID, Stato> paro : statoj.entrySet() ) {
                Entity ento = Bukkit.getEntity(paro.getKey());
                if ( ento instanceof Mannequin hantamo && ! hantamo.isDead() && hantamo.isValid() && hantamo.getWorld().equals(mondo) ) {
                    if ( hazardo.nextInt(4) == 0 ) { // 0o4
                        paro.getValue().koŝmaro = true;
                    }
                }
            }
        }
        if ( ! nokto && estisNokto ) {
            for ( Map.Entry<UUID, Stato> paro : statoj.entrySet() ) {
                Entity ento = Bukkit.getEntity(paro.getKey());
                if ( ento instanceof Mannequin hantamo && ! hantamo.isDead() && hantamo.isValid() ) {
                    if ( paro.getValue().koŝmaro ) {
                        paro.getValue().koŝmaro = false;
                        pacigi(hantamo, paro.getValue());
                    }
                }
            }
        }
        estisNokto = nokto;
    }

    // ⟪ Popolo 📃 ⟫
    // បង្កើតនិងទទួលស្គាល់

    /* ទទួលស្គាល់តុក្កតាដែលមានស្លាកស្រាប់ក្រោយចាប់ផ្តើមឡើងវិញ
        @returns គ្មាន */
    public void adoptuEkzistantajn() {
        World mondo = mondo();
        if ( mondo == null ) {
            return;
        }
        registriŜargitajn(mondo, true);
    }

    private void registriŜargitajn(World mondo, boolean restarigi) {
        for ( Entity ento : mondo.getEntities() ) {
            if ( ento instanceof Mannequin hantamo && hantamo.getScoreboardTags().contains(ETIKEDO) ) {
                Stato stato = statoj.putIfAbsent(hantamo.getUniqueId(), novaStato());
                if ( stato != null && ! restarigi ) {
                    continue;
                }
                hantamo.getEquipment().setItemInMainHand(new ItemStack(Material.AIR));
                hantamo.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, PotionEffect.INFINITE_DURATION, 0, false, false));
                pacigi(hantamo, stato == null ? statoj.get(hantamo.getUniqueId()) : stato);
            }
        }
    }

    /* បង្កើតស្ថានភាពថ្មីមានការពន្យារសង់ចៃដន្យ
        @returns ស្ថានភាពថ្មី */
    private Stato novaStato() {
        Stato stato = new Stato();
        stato.konstruKd = 1200 + hazardo.nextInt(3600); // 0o2260 ĝis 0o10050
        return stato;
    }

    /* បង្កើតរហូតដល់គ្រប់ចំនួនគោលដៅ
        @param mondo ( World , មិនមែន null ) - ពិភពលោកគោលដៅ
        @returns គ្មាន */
    private void subteniPopolon(World mondo) {
        int viva = statoj.size();
        int manko = agordo.celo() - viva;
        if ( manko <= 0 ) {
            return;
        }
        int naskitoj = Math.min(manko, 1);
        for ( int i = 0; i < naskitoj; i++ ) {
            Location referenco = elektiReferencon(mondo);
            if ( referenco == null ) {
                return;
            }
            Location nasko = troviNaskejon(mondo, referenco);
            if ( nasko == null ) {
                continue;
            }
            petiNaskon(nasko);
        }
    }

    /* ជ្រើសរើសចំណុចយោងសម្រាប់បំបែកគ្នា
        @param mondo ( World , មិនមែន null ) - ពិភពលោកគោលដៅ
        @returns ទីតាំងយោង ឬ null */
    private Location elektiReferencon(World mondo) {
        List<Location> viva = new ArrayList<>();
        for ( UUID id : statoj.keySet() ) {
            Entity ento = Bukkit.getEntity(id);
            if ( ento instanceof Mannequin hantamo && ! hantamo.isDead() ) {
                viva.add(hantamo.getLocation());
            }
        }
        if ( ! viva.isEmpty() ) {
            return viva.get(hazardo.nextInt(viva.size()));
        }
        List<Player> lokanoj = new ArrayList<>();
        for ( Player ludanto : Bukkit.getOnlinePlayers() ) {
            if ( ludanto.getWorld().equals(mondo) ) {
                lokanoj.add(ludanto);
            }
        }
        if ( ! lokanoj.isEmpty() ) {
            return lokanoj.get(hazardo.nextInt(lokanoj.size())).getLocation();
        }
        return mondo.getSpawnLocation();
    }

    /* រកកន្លែងបង្កើតសុវត្ថិភាពជុំវិញយោង
        @param mondo ( World , មិនមែន null ) - ពិភពលោកគោលដៅ
        @param referenco ( Location , មិនមែន null ) - ចំណុចកណ្តាល
        @returns ទីតាំងបង្កើត ឬ null */
    private Location troviNaskejon(World mondo, Location referenco) {
        int radiuso = agordo.naskRadiuso();
        for ( int provo = 0; provo < 8; provo++ ) { // 0o10
            double angulo = hazardo.nextDouble() * Math.PI * 2.0D;
            double distanco = 64.0D + hazardo.nextDouble() * radiuso; // 0o100
            int x = referenco.getBlockX() + (int) ( Math.cos(angulo) * distanco );
            int z = referenco.getBlockZ() + (int) ( Math.sin(angulo) * distanco );
            Location tereno = HantamiKonstruanto.troviTeron(mondo, x, z);
            if ( tereno != null ) {
                return tereno;
            }
        }
        return null;
    }

    /* ស្នើបង្កើតមានឈ្មោះត្រឹមត្រូវតែពីមូលដ្ឋាន
        @param loko ( Location , មិនមែន null ) - ទីតាំងបង្កើត
        @returns True នៅពេលកើតរួច */
    public boolean petiNaskon(Location loko) {
        return petiNaskon(loko, null);
    }

    /* ស្នើបង្កើតតែពីមូលដ្ឋានជាមួយសារជូនដំណឹងពេលកើតរួច
        @param loko ( Location , មិនមែន null ) - ទីតាំងបង្កើត
        @param anonco ( CommandSender , អាច null ) - អ្នកត្រូវជូនដំណឹង
        @returns True នៅពេលកើតរួច */
    public boolean petiNaskon(Location loko, org.bukkit.command.CommandSender anonco) {
        String nomo;
        synchronized ( datumbazaSeruro ) {
            if ( datumbazo.isEmpty() || ( anonco == null && statoj.size() >= agordo.maksimumaPopolo() ) ) {
                return false;
            }
            nomo = datumbazo.get(hazardo.nextInt(datumbazo.size()));
        }
        String elektita = nomo;
        Bukkit.getScheduler().runTaskAsynchronously(kromprogramo, () -> {
            ResolvableProfile solvita = solviProfilon(elektita);
            if ( solvita == null ) {
                solvita = ResolvableProfile.resolvableProfile().name(elektita).uuid(UUID.randomUUID()).build();
            }
            ResolvableProfile preta = solvita;
            Bukkit.getScheduler().runTask(kromprogramo, () -> {
                if ( ! kromprogramo.isEnabled() ) {
                    return;
                }
                Mannequin naskita = aperigi(loko, preta);
                if ( naskita != null && anonco != null ) {
                    anonco.sendMessage(Mesagoj.NASKITA);
                }
            });
        });
        return true;
    }

    /* ដោះស្រាយឈ្មោះទៅប្រវត្តិរូបមានផ្ទាំងស្បែកពិត
        @param nomo ( String , មិនមែន null ) - ឈ្មោះត្រូវដោះស្រាយ
        @returns ប្រវត្តិរូបមានស្បែក ឬ null */
    private ResolvableProfile solviProfilon(String nomo) {
        synchronized ( datumbazaSeruro ) {
            ResolvableProfile kaŝita = profilKaŝo.get(nomo);
            if ( kaŝita != null ) {
                return kaŝita;
            }
        }
        try {
            PlayerProfile papera = Bukkit.createProfile(null, nomo);
            boolean plena;
            try {
                plena = papera.complete();
            } catch ( Exception eraro ) {
                plena = false;
            }
            if ( ! plena || ! papera.hasTextures() ) {
                return null;
            }
            ResolvableProfile solvita = ResolvableProfile.resolvableProfile(papera);
            synchronized ( datumbazaSeruro ) {
                profilKaŝo.put(nomo, solvita);
            }
            return solvita;
        } catch ( Exception eraro ) {
            return null;
        }
    }

    /* បង្ហាញ Hantami មួយមានប្រវត្តិរូបរួចរាល់
        @param loko ( Location , មិនមែន null ) - ទីតាំងបង្កើត
        @param profilo ( ResolvableProfile , មិនមែន null ) - ប្រវត្តិរូបរួចរាល់
        @returns តុក្កតាថ្មី ឬ null */
    public Mannequin aperigi(Location loko, ResolvableProfile profilo) {
        World mondo = loko.getWorld();
        if ( mondo == null ) {
            return null;
        }
        Entity ento = mondo.spawnEntity(loko, EntityType.MANNEQUIN);
        if ( ! ( ento instanceof Mannequin hantamo ) ) {
            ento.remove();
            return null;
        }
        hantamo.setProfile(profilo);
        hantamo.setImmovable(false);
        hantamo.addScoreboardTag(ETIKEDO);
        try {
            if ( hantamo.getAttribute(Attribute.MAX_HEALTH) != null ) {
                hantamo.getAttribute(Attribute.MAX_HEALTH).setBaseValue(20.0D); // 0o24
            }
            hantamo.setHealth(20.0D); // 0o24
        } catch ( Exception eraro ) {
            kromprogramo.getLogger().warning(Mesagoj.WARN_SENMONDO);
        }
        hantamo.getEquipment().setItemInMainHand(new ItemStack(Material.AIR));
        hantamo.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, PotionEffect.INFINITE_DURATION, 0, false, false));
        Stato stato = novaStato();
        statoj.put(hantamo.getUniqueId(), stato);
        konservi();
        if ( estasNokto(mondo) && hazardo.nextInt(4) == 0 ) { // 0o4
            stato.koŝmaro = true;
        }
        pacigi(hantamo, stato);
        kromprogramo.getLogger().info(Mesagoj.INFO_NASKITA);
        return hantamo;
    }

    /* ភ្លេច Hantami ដែលស្លាប់
        @param id ( UUID , មិនមែន null ) - អត្តសញ្ញាណ Hantami
        @returns គ្មាន */
    public void forgesu(UUID id) {
        statoj.remove(id);
        konservi();
    }

    /* ប្រាប់ថាតើអង្គភាពជា Hantami ឬអត់
        @param ento ( Entity , មិនមែន null ) - អង្គភាពត្រូវពិនិត្យ
        @returns True នៅពេលជា Hantami */
    public boolean estasHantami(Entity ento) {
        return ento instanceof Mannequin && ento.getScoreboardTags().contains(ETIKEDO);
    }

    /* ទទួលចំនួនរស់
        @returns ចំនួនរស់ */
    public int vivaNombro() {
        return statoj.size();
    }

    /* ទទួលផ្ទះដែលស្គាល់
        @returns បញ្ជីផ្ទះ */
    public List<Location> domoj() {
        return domoj;
    }

    /* ទទួលភូមិដែលស្គាល់
        @returns បញ្ជីភូមិ */
    public List<Location> vilagxoj() {
        return vilagxoj;
    }

    /* លុប Hantami ទាំងអស់និងភ្លេចពួកវា
        @param mondo ( World , មិនមែន null ) - ពិភពលោកគោលដៅ
        @returns ចំនួនដែលលុប */
    public int purigi(World mondo) {
        int nombro = 0;
        for ( Entity ento : new ArrayList<>(mondo.getEntities()) ) {
            if ( estasHantami(ento) ) {
                ento.remove();
                statoj.remove(ento.getUniqueId());
                nombro++;
            }
        }
        konservi();
        return nombro;
    }

    // ⟪ Konduto 📃 ⟫
    // ដើរ ប្រយុទ្ធ សង់

    /* ជំហានខួរក្បាលមួយសម្រាប់ Hantami មួយ
        @param hantamo ( Mannequin , មិនមែន null ) - តុក្កតា
        @param stato ( Stato , មិនមែន null ) - ស្ថានភាពរបស់វា
        @returns គ្មាន */
    private void konduto(Mannequin hantamo, Stato stato) {
        if ( stato.atakoKd > 0 ) {
            stato.atakoKd -= 4; // 0o4
        }
        if ( stato.koŝmaro ) {
            if ( ! estasNokto(hantamo.getWorld()) ) {
                stato.koŝmaro = false;
                pacigi(hantamo, stato);
                return;
            }
            Player predo = plejProksimaAtakebla(hantamo, 48.0D); // 0o60
            if ( predo != null ) {
                stato.celo = predo.getUniqueId();
                stato.movCelo = predo.getLocation();
                stato.movRapido = 0.30D;
                stato.saltaAlteco = 0.9D;
                hantamo.setGlowing(true);
                ĉasi(hantamo, stato, predo);
                koŝmari(hantamo, stato);
            } else {
                stato.celo = null;
                stato.saltaAlteco = 0.9D;
                vagi(hantamo, stato);
                koŝmari(hantamo, stato);
            }
            return;
        }
        Player celulo = null;
        if ( stato.celo != null ) {
            Entity ento = Bukkit.getEntity(stato.celo);
            if ( ento instanceof Player ludanto && ludanto.isOnline() && ludanto.getWorld().equals(hantamo.getWorld()) && ! ludanto.isDead() && ludanto.getGameMode() != GameMode.SPECTATOR ) {
                if ( ludanto.getLocation().distanceSquared(hantamo.getLocation()) < 2304.0D ) { // 0o4400
                    celulo = ludanto;
                }
            }
            if ( celulo == null ) {
                Player nova = plejProksimaAtakebla(hantamo, 32.0D); // 0o40
                if ( nova != null ) {
                    stato.celo = nova.getUniqueId();
                    celulo = nova;
                } else {
                    pacigi(hantamo, stato);
                }
            }
        }
        if ( celulo != null ) {
            stato.movCelo = celulo.getLocation();
            stato.movRapido = 0.26D;
            ĉasi(hantamo, stato, celulo);
            fantomi(hantamo, stato);
            return;
        }
        rigardiSolecon(hantamo, stato);
        rigardiPredon(hantamo, stato);
        if ( stato.celo != null ) {
            Entity ento = Bukkit.getEntity(stato.celo);
            if ( ento instanceof Player ludanto ) {
                stato.movCelo = ludanto.getLocation();
                stato.movRapido = 0.26D;
                ĉasi(hantamo, stato, ludanto);
                fantomi(hantamo, stato);
                return;
            }
        }
        vagi(hantamo, stato);
        stato.konstruKd -= 4; // 0o4
        if ( stato.konstruKd <= 0 ) {
            stato.konstruKd = 2400 + hazardo.nextInt(4800); // 0o4540 ĝis 0o11300
            proviKonstrui(hantamo, stato);
        }
    }

    /* ពិនិត្យថាតើ Hantami នៅម្នាក់ឯងជាមួយអ្នកលេងយូរពេកឬអត់
        @param hantamo ( Mannequin , មិនមែន null ) - តុក្កតា
        @param stato ( Stato , មិនមែន null ) - ស្ថានភាពរបស់វា
        @returns គ្មាន */
    private void rigardiSolecon(Mannequin hantamo, Stato stato) {
        Location tie = hantamo.getLocation();
        List<Player> proksimaj = new ArrayList<>();
        for ( Entity ento : hantamo.getNearbyEntities(agordo.solaVido(), 8.0D, agordo.solaVido()) ) { // 0o10
            if ( ento instanceof Player ludanto && ! ludanto.isDead() && ludanto.getGameMode() != GameMode.SPECTATOR ) {
                proksimaj.add(ludanto);
            }
        }
        int samideanoj = 0;
        for ( Entity ento : hantamo.getNearbyEntities(agordo.samideanoVido(), 8.0D, agordo.samideanoVido()) ) { // 0o10
            if ( ento instanceof Mannequin alia && ! alia.getUniqueId().equals(hantamo.getUniqueId()) && alia.getScoreboardTags().contains(ETIKEDO) ) {
                samideanoj++;
            }
        }
        if ( proksimaj.size() == 1 && samideanoj == 0 ) {
            stato.soleca += 4; // 0o4
            if ( stato.soleca >= agordo.solecaTikoj() ) {
                ekkoleri(hantamo, stato, proksimaj.get(0));
            }
        } else {
            stato.soleca = Math.max(0, stato.soleca - 8); // 0o10
        }
    }

    /* រង់ចាំវាយអ្នកលេងឯកាដែលគ្មានអ្នកផ្សេងនៅជិត
        @param hantamo ( Mannequin , មិនមែន null ) - តុក្កតា
        @param stato ( Stato , មិនមែន null ) - ស្ថានភាពរបស់វា
        @returns គ្មាន */
    private void rigardiPredon(Mannequin hantamo, Stato stato) {
        if ( stato.celo != null ) {
            return;
        }
        Location tie = hantamo.getLocation();
        Player sola = null;
        for ( Entity ento : hantamo.getNearbyEntities(agordo.solaVido(), 8.0D, agordo.solaVido()) ) { // 0o10
            if ( ento instanceof Player ludanto && ! ludanto.isDead() && ludanto.getGameMode() != GameMode.SPECTATOR ) {
                if ( sola != null ) {
                    stato.predanto = null;
                    stato.embusko = 0;
                    return;
                }
                sola = ludanto;
            }
        }
        if ( sola == null ) {
            stato.predanto = null;
            stato.embusko = 0;
            return;
        }
        double malproksimo2 = agordo.solaLudantoVido() * agordo.solaLudantoVido();
        for ( Player alia : hantamo.getWorld().getPlayers() ) {
            if ( alia.equals(sola) || alia.isDead() || alia.getGameMode() == GameMode.SPECTATOR ) {
                continue;
            }
            if ( alia.getLocation().distanceSquared(tie) < malproksimo2 ) {
                stato.predanto = null;
                stato.embusko = 0;
                return;
            }
        }
        if ( ! sola.getUniqueId().equals(stato.predanto) ) {
            stato.predanto = sola.getUniqueId();
            stato.embusko = 4; // 0o4
        } else {
            stato.embusko += 4; // 0o4
        }
        if ( stato.embusko >= agordo.embuskoTikoj() ) {
            ekkoleri(hantamo, stato, sola);
        }
    }

    /* បំភ័យពេលយប់ដោយបង្វិលក្បាលយឺត ផេះ និងចង្វាក់បេះដូង
        @param hantamo ( Mannequin , មិនមែន null ) - តុក្កតា
        @param stato ( Stato , មិនមែន null ) - ស្ថានភាពរបស់វា
        @returns គ្មាន */
    private void koŝmari(Mannequin hantamo, Stato stato) {
        stato.animFazo++;
        hantamo.setRotation(hantamo.getLocation().getYaw() + 12.0F, 0.0F); // 0o14
        Location okulo = hantamo.getEyeLocation();
        World mondo = hantamo.getWorld();
        mondo.spawnParticle(Particle.ASH, okulo, 6, 0.5D, 0.8D, 0.5D, 0.02D); // 0o6
        mondo.spawnParticle(Particle.LARGE_SMOKE, okulo, 3, 0.4D, 0.6D, 0.4D, 0.01D); // 0o3
        for ( Entity ento : hantamo.getNearbyEntities(12.0D, 8.0D, 12.0D) ) { // 0o14 0o10
            if ( ento instanceof Player ludanto && ! ludanto.isDead() && ludanto.getGameMode() != GameMode.SPECTATOR ) {
                ludanto.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS, 80, 0, false, false)); // 0o120
            }
        }
        if ( stato.animFazo % 40 == 0 ) { // 0o50
            mondo.playSound(hantamo.getLocation(), Sound.ENTITY_WARDEN_HEARTBEAT, 1.0F, 0.7F);
        }
        if ( stato.animFazo % 100 == 0 ) { // 0o144
            mondo.playSound(hantamo.getLocation(), Sound.ENTITY_ENDERMAN_SCREAM, 0.8F, 0.4F);
        }
    }

    /* សន្យាតាមអ្នកលេងមានរូបគួរឱ្យខ្លាច
        @param hantamo ( Mannequin , មិនមែន null ) - តុក្កតា
        @param stato ( Stato , មិនមែន null ) - ស្ថានភាពរបស់វា
        @param celulo ( Player , មិនមែន null ) - អ្នកលេងគោលដៅ
        @returns គ្មាន */
    public void ekkoleri(Mannequin hantamo, Stato stato, Player celulo) {
        stato.celo = celulo.getUniqueId();
        stato.soleca = 0;
        stato.animFazo = 0;
        stato.spinFazo = 10; // 0o12
        hantamo.setGlowing(true);
        hantamo.getWorld().playSound(hantamo.getLocation(), Sound.ENTITY_WARDEN_ROAR, 1.0F, 0.6F);
        hantamo.getWorld().spawnParticle(Particle.SOUL_FIRE_FLAME, hantamo.getEyeLocation(), 24, 0.5D, 0.8D, 0.5D, 0.02D); // 0o30
    }

    /* រំងាប់ Hantami ត្រឡប់ទៅសន្តិភាពវិញ
        @param hantamo ( Mannequin , មិនមែន null ) - តុក្កតា
        @param stato ( Stato , មិនមែន null ) - ស្ថានភាពរបស់វា
        @returns គ្មាន */
    private void pacigi(Mannequin hantamo, Stato stato) {
        stato.celo = null;
        stato.soleca = 0;
        stato.animFazo = 0;
        stato.spinFazo = 0;
        stato.movCelo = null;
        stato.flanka = 0.0D;
        stato.predanto = null;
        stato.embusko = 0;
        stato.saltaAlteco = 0.42D;
        hantamo.setGlowing(false);
        hantamo.customName(null);
        hantamo.setCustomNameVisible(false);
    }

    /* រកអ្នកលេងវាយប្រហារបានជិតបំផុត
        @param hantamo ( Mannequin , មិនមែន null ) - តុក្កតា
        @param radiuso ( double ) - កាំស្វែងរក
        @returns អ្នកលេងជិតបំផុត ឬ null */
    private Player plejProksimaAtakebla(Mannequin hantamo, double radiuso) {
        Location tie = hantamo.getLocation();
        Player plejBona = null;
        double plejDistanco2 = radiuso * radiuso;
        for ( Player ludanto : hantamo.getWorld().getPlayers() ) {
            if ( ludanto.isDead() || ludanto.getGameMode() == GameMode.SPECTATOR ) {
                continue;
            }
            double distanco2 = ludanto.getLocation().distanceSquared(tie);
            if ( distanco2 < plejDistanco2 ) {
                plejDistanco2 = distanco2;
                plejBona = ludanto;
            }
        }
        return plejBona;
    }

    /* ដេញនិងវាយគោលដៅ
        @param hantamo ( Mannequin , មិនមែន null ) - តុក្កតា
        @param stato ( Stato , មិនមែន null ) - ស្ថានភាពរបស់វា
        @param celulo ( Player , មិនមែន null ) - អ្នកលេងគោលដៅ
        @returns គ្មាន */
    private void ĉasi(Mannequin hantamo, Stato stato, Player celulo) {
        Location tie = hantamo.getLocation();
        Location celloko = celulo.getLocation();
        double distanco2 = tie.distanceSquared(celloko);
        if ( distanco2 < 9.0D ) { // 0o11
            rigardiAl(hantamo, celloko);
            if ( stato.atakoKd <= 0 ) {
                stato.atakoKd = 20; // 0o24
                hantamo.swingMainHand();
                Vector salto = celloko.clone().subtract(tie).toVector();
                salto.setY(0.0D);
                if ( salto.lengthSquared() > 0.01D ) {
                    salto.normalize().multiply(0.35D);
                    hantamo.setVelocity(new Vector(salto.getX(), hantamo.getVelocity().getY(), salto.getZ()));
                }
                celulo.damage(agordo.atakuDamagxo(), hantamo);
            }
            return;
        }
        stato.movCelo = celloko;
        stato.movRapido = 0.26D;
        if ( distanco2 < 36.0D ) { // 0o44
            rigardiAl(hantamo, celloko);
        }
    }

    /* ចលនាភ័យខ្លាចដោយភាគល្អិតព្រលឹងនិងសំឡេង
        @param hantamo ( Mannequin , មិនមែន null ) - តុក្កតា
        @param stato ( Stato , មិនមែន null ) - ស្ថានភាពរបស់វា
        @returns គ្មាន */
    private void fantomi(Mannequin hantamo, Stato stato) {
        stato.animFazo++;
        Location okulo = hantamo.getEyeLocation();
        World mondo = hantamo.getWorld();
        double malfermo = 0.35D + 0.35D * Math.sin(stato.animFazo * 0.6D);
        Vector antaŭen = okulo.getDirection().setY(0.0D).normalize();
        Vector flanken = new Vector(-antaŭen.getZ(), 0.0D, antaŭen.getX()).normalize();
        for ( int alto = 0; alto < 3; alto++ ) { // 0o3
            Location mezo = okulo.clone().add(antaŭen.clone().multiply(0.6D));
            mezo.setY(okulo.getY() - alto * 0.25D);
            Location maldekstra = mezo.clone().add(flanken.clone().multiply(malfermo + 0.08D));
            Location dekstra = mezo.clone().subtract(flanken.clone().multiply(malfermo + 0.08D));
            mondo.spawnParticle(Particle.SOUL_FIRE_FLAME, maldekstra, 2, 0.02D, 0.05D, 0.02D, 0.0D); // 0o2
            mondo.spawnParticle(Particle.SOUL_FIRE_FLAME, dekstra, 2, 0.02D, 0.05D, 0.02D, 0.0D); // 0o2
            mondo.spawnParticle(Particle.SMOKE, mezo, 1, 0.02D, 0.05D, 0.02D, 0.0D);
        }
        if ( stato.animFazo % 25 == 0 ) { // 0o31
            mondo.playSound(hantamo.getLocation(), Sound.ENTITY_ENDERMAN_SCREAM, 0.7F, 0.5F);
        }
    }

    // ⟪ Vagado 📃 ⟫
    // ដើរដូចអ្នកលេង

    /* ដើរលេងទៅចំណុចចៃដន្យមានទាញភូមិ
        @param hantamo ( Mannequin , មិនមែន null ) - តុក្កតា
        @param stato ( Stato , មិនមែន null ) - ស្ថានភាពរបស់វា
        @returns គ្មាន */
    private void vagi(Mannequin hantamo, Stato stato) {
        KonstruProjekto projekto = projektoDe(hantamo.getUniqueId());
        if ( projekto != null ) {
            Location ejo = projekto.ejo();
            stato.movCelo = null;
            if ( hantamo.getLocation().distanceSquared(ejo) > 36.0D ) { // 0o44
                stato.movCelo = ejo;
                stato.movRapido = 0.15D;
            } else {
                rigardiAl(hantamo, ejo);
            }
            return;
        }
        long nun = hantamo.getWorld().getFullTime();
        Location tie = hantamo.getLocation();
        if ( stato.vaga == null || nun > stato.vagaFino || stato.vaga.distanceSquared(tie) < 4.0D ) { // 0o4
            stato.vaga = elektiVagon(hantamo, stato);
            stato.vagaFino = nun + 200L + hazardo.nextInt(400); // 0o310 ĝis 0o1070
            return;
        }
        stato.movCelo = stato.vaga;
        stato.movRapido = 0.15D;
    }

    /* ជ្រើសរើសគោលដៅដើរលេងមានទាញទៅភូមិជិតឬផ្ទះដែលទទួលស្គាល់
        @param hantamo ( Mannequin , មិនមែន null ) - តុក្កតា
        @param stato ( Stato , មិនមែន null ) - ស្ថានភាពរបស់វា
        @returns គោលដៅដើរលេង */
    private Location elektiVagon(Mannequin hantamo, Stato stato) {
        Location tie = hantamo.getLocation();
        Location plejProksima = null;
        double plejDistanco2 = Double.MAX_VALUE;
        for ( Location vilagxo : vilagxoj ) {
            if ( ! vilagxo.getWorld().equals(tie.getWorld()) ) {
                continue;
            }
            double distanco2 = vilagxo.distanceSquared(tie);
            if ( distanco2 < plejDistanco2 ) {
                plejDistanco2 = distanco2;
                plejProksima = vilagxo;
            }
        }
        Location bazo = tie;
        double plejBazo2 = 4096.0D; // 0o10000
        if ( plejProksima != null && plejDistanco2 < plejBazo2 ) {
            bazo = plejProksima;
            plejBazo2 = plejDistanco2;
        }
        if ( stato.hejmo != null && stato.hejmo.getWorld().equals(tie.getWorld()) ) {
            double hejmo2 = stato.hejmo.distanceSquared(tie);
            if ( hejmo2 < plejBazo2 && hejmo2 < 9216.0D ) { // 0o22000
                bazo = stato.hejmo;
            }
        }
        for ( int provo = 0; provo < 6; provo++ ) { // 0o6
            double angulo = hazardo.nextDouble() * Math.PI * 2.0D;
            double distanco = 8.0D + hazardo.nextDouble() * 16.0D; // 0o10 ĝis 0o30
            int x = bazo.getBlockX() + (int) ( Math.cos(angulo) * distanco );
            int z = bazo.getBlockZ() + (int) ( Math.sin(angulo) * distanco );
            Location tereno = HantamiKonstruanto.troviTeron(tie.getWorld(), x, z);
            if ( tereno != null ) {
                return tereno;
            }
        }
        return tie;
    }

    /* បង្វិលមុខទៅគោលដៅ
        @param hantamo ( Mannequin , មិនមែន null ) - តុក្កតា
        @param celo ( Location , មិនមែន null ) - ចំណុចត្រូវសម្លឹង
        @returns គ្មាន */
    private void rigardiAl(Mannequin hantamo, Location celo) {
        Location tie = hantamo.getLocation();
        Vector direkto = celo.clone().subtract(tie).toVector();
        if ( direkto.lengthSquared() < 0.01D ) {
            return;
        }
        float vizaĝo = (float) Math.toDegrees(Math.atan2(-direkto.getX(), direkto.getZ()));
        hantamo.setRotation(vizaĝo, 0.0F);
    }

    // ⟪ Konstruado 📃 ⟫
    // ផ្ទះតូចសម្រាប់ប្រជាជន

    /* ព្យាយាមចាប់ផ្តើមគម្រោងសង់ផ្ទះបន្តិចម្តងៗនៅទីតាំងបច្ចុប្បន្ន
        @param hantamo ( Mannequin , មិនមែន null ) - អ្នកសាងសង់
        @param stato ( Stato , មិនមែន null ) - ស្ថានភាពរបស់វា
        @returns គ្មាន */
    private void proviKonstrui(Mannequin hantamo, Stato stato) {
        World mondo = hantamo.getWorld();
        Location tie = hantamo.getLocation();
        if ( projektoj.size() >= 3 ) { // 0o3
            return;
        }
        for ( KonstruProjekto projekto : projektoj ) {
            if ( projekto.konstruanto().equals(hantamo.getUniqueId()) ) {
                return;
            }
            if ( projekto.ejo().getWorld().equals(mondo) && projekto.ejo().distanceSquared(tie) < 100.0D ) { // 0o144
                return;
            }
        }
        Location adoptita = null;
        double adoptita2 = 576.0D; // 0o1100
        for ( Location konata : domoj ) {
            if ( ! konata.getWorld().equals(mondo) ) {
                continue;
            }
            double distanco2 = konata.distanceSquared(tie);
            if ( distanco2 < adoptita2 ) {
                adoptita2 = distanco2;
                adoptita = konata;
            }
        }
        if ( adoptita != null ) {
            stato.hejmo = adoptita;
            return;
        }
        for ( Location konata : domoj ) {
            if ( konata.getWorld().equals(mondo) && konata.distanceSquared(tie) < 100.0D ) { // 0o144
                return;
            }
        }
        HantamiKonstruanto.PlanoRezulto plano = HantamiKonstruanto.planiDomon(mondo, tie, hazardo, agordo.lignoRadiuso(), domoj);
        if ( plano == null || plano.vico.isEmpty() ) {
            return;
        }
        Location ejo = new Location(mondo, tie.getBlockX(), tie.getBlockY(), tie.getBlockZ());
        projektoj.add(new KonstruProjekto(mondo, hantamo.getUniqueId(), ejo, plano.vico, plano.tabulo));
    }

    /* រកគម្រោងសកម្មរបស់អ្នកសាងសង់
        @param id ( UUID , មិនមែន null ) - អត្តសញ្ញាណអ្នកសាងសង់
        @returns គម្រោង ឬ null */
    private KonstruProjekto projektoDe(UUID id) {
        for ( KonstruProjekto projekto : projektoj ) {
            if ( projekto.konstruanto().equals(id) ) {
                return projekto;
            }
        }
        return null;
    }

    // ⟪ Vilaĝoj 📃 ⟫
    // ជួបជុំគ្នាមានភ្លើងនៅកណ្តាល

    /* ប្រមូល Hantami ជិតគ្នានិងអុជភ្លើងភូមិ
        @param mondo ( World , មិនមែន null ) - ពិភពលោកគោលដៅ
        @returns គ្មាន */
    public void kontroliVilagxojn(World mondo) {
        Set<UUID> vizititaj = new HashSet<>();
        Collection<Mannequin> viva = kolektiVivajn(mondo);
        for ( Mannequin radiko : viva ) {
            if ( vizititaj.contains(radiko.getUniqueId()) ) {
                continue;
            }
            List<Mannequin> grupo = kolektiGrupon(radiko, viva);
            for ( Mannequin membro : grupo ) {
                vizititaj.add(membro.getUniqueId());
            }
            if ( grupo.size() < agordo.vilaMinimo() ) {
                continue;
            }
            Location mezo = mezoDeGrupo(grupo);
            if ( mezo == null ) {
                continue;
            }
            if ( proksimaVilaĝo(mezo, agordo.grupRadiuso()) ) {
                continue;
            }
            if ( HantamiKonstruanto.fajroProksimas(mondo, mezo, 12) ) { // 0o14
                vilagxoj.add(mezo);
                continue;
            }
            boolean preta = HantamiKonstruanto.konstruiFajron(mondo, mezo);
            if ( preta ) {
                vilagxoj.add(new Location(mondo, mezo.getBlockX(), mezo.getBlockY(), mezo.getBlockZ()));
                if ( vilagxoj.size() > 32 ) { // 0o40
                    vilagxoj.remove(0);
                }
                kromprogramo.getLogger().info(Mesagoj.INFO_VILAGXO);
            }
        }
    }

    /* ប្រមូល Hantami រស់ទាំងអស់ក្នុងពិភពលោក
        @param mondo ( World , មិនមែន null ) - ពិភពលោកគោលដៅ
        @returns បញ្ជី Hantami រស់ */
    private Collection<Mannequin> kolektiVivajn(World mondo) {
        List<Mannequin> viva = new ArrayList<>();
        for ( UUID id : statoj.keySet() ) {
            Entity ento = Bukkit.getEntity(id);
            if ( ento instanceof Mannequin hantamo && ! hantamo.isDead() && hantamo.getWorld().equals(mondo) ) {
                viva.add(hantamo);
            }
        }
        return viva;
    }

    /* ប្រមូលក្រុមដោយស្វែងរកទូលំទូលាយជុំវិញឫស
        @param radiko ( Mannequin , មិនមែន null ) - តុក្កតាចាប់ផ្តើម
        @param viva ( Collection , មិនមែន null ) - Hantami រស់ទាំងអស់
        @returns សមាជិកក្រុម */
    private List<Mannequin> kolektiGrupon(Mannequin radiko, Collection<Mannequin> viva) {
        List<Mannequin> grupo = new ArrayList<>();
        grupo.add(radiko);
        double radiuso2 = agordo.grupRadiuso() * agordo.grupRadiuso();
        boolean kreskis = true;
        while ( kreskis ) {
            kreskis = false;
            for ( Mannequin kandidato : viva ) {
                if ( grupo.contains(kandidato) ) {
                    continue;
                }
                for ( Mannequin membro : new ArrayList<>(grupo) ) {
                    if ( membro.getLocation().distanceSquared(kandidato.getLocation()) <= radiuso2 ) {
                        grupo.add(kandidato);
                        kreskis = true;
                        break;
                    }
                }
            }
        }
        return grupo;
    }

    /* គណនាចំណុចកណ្តាលរបស់ក្រុម
        @param grupo ( List , មិនមែន null ) - សមាជិកក្រុម
        @returns ទីតាំងកណ្តាល ឬ null */
    private Location mezoDeGrupo(List<Mannequin> grupo) {
        if ( grupo.isEmpty() ) {
            return null;
        }
        World mondo = grupo.get(0).getWorld();
        double x = 0.0D;
        double z = 0.0D;
        for ( Mannequin membro : grupo ) {
            x += membro.getLocation().getX();
            z += membro.getLocation().getZ();
        }
        x /= grupo.size();
        z /= grupo.size();
        return HantamiKonstruanto.troviTeron(mondo, (int) x, (int) z);
    }

    /* ប្រាប់ថាតើភូមិស្គាល់នៅជិតឬអត់
        @param mezo ( Location , មិនមែន null ) - ចំណុចត្រូវពិនិត្យ
        @param radiuso ( double ) - កាំស្វែងរក
        @returns True នៅពេលភូមិនៅជិត */
    private boolean proksimaVilaĝo(Location mezo, double radiuso) {
        double radiuso2 = radiuso * radiuso;
        for ( Location vilagxo : vilagxoj ) {
            if ( vilagxo.getWorld().equals(mezo.getWorld()) && vilagxo.distanceSquared(mezo) < radiuso2 ) {
                return true;
            }
        }
        return false;
    }

    /* ដាស់ការត្រួតពិនិត្យភូមិដោយបង្ខំ
        @param mondo ( World , មិនមែន null ) - ពិភពលោកគោលដៅ
        @returns គ្មាន */
    public void vekiVilagxon(World mondo) {
        kontroliVilagxojn(mondo);
    }

    /* ទទួលស្ថានភាពសម្រាប់ប្រើខាងក្រៅ
        @param id ( UUID , មិនមែន null ) - អត្តសញ្ញាណ Hantami
        @returns ស្ថានភាព ឬ null */
    Stato statoDe(UUID id) {
        return statoj.get(id);
    }

    /* ធ្វើឱ្យ Hantami ខឹងនឹងអ្នកវាយប្រហារ
        @param hantamo ( Mannequin , មិនមែន null ) - តុក្កតា
        @param atakanto ( Player , មិនមែន null ) - អ្នកលេងវាយប្រហារ
        @returns គ្មាន */
    public void venĝi(Mannequin hantamo, Player atakanto) {
        Stato stato = statoj.get(hantamo.getUniqueId());
        if ( stato == null ) {
            stato = novaStato();
            statoj.put(hantamo.getUniqueId(), stato);
        }
        ekkoleri(hantamo, stato, atakanto);
    }
}
