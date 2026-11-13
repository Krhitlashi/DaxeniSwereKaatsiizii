package com.hantami.mobo;

import com.hantami.HantamiDaxe;
import com.hantami.config.Ku1o;
import com.hantami.config.S2bana;
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

// ≺⧼ ŋᷠᴜ ſɭᴜ ŋᷠᴜ ɭl̀э ſȷꞇ 📃 ⧽≻


/* ŋᷠᴜ ſɭᴜ ŋᷠᴜ ɭl̀э ſȷꞇ */
public class HantamiMakamaj6fi {

    // ⟪ ı],ɔ ֭ſɭᴜ ɭʃɔ 📃 ⟫

    private static final String XEHATE = "hantami";

    /* ı],ɔ ֭ſɭᴜ ɭʃɔ */
    private static class Xehate {
        UUID kxawa = null;
        int ka5ik5 = 0;
        int vepaqKsaka = 1200;
        Location kata2 = null;
        long kataH2l = 0L;
        int peKsaka = 0;
        int fumuPabok = 0;
        Location xaraqKxawa = null;
        double xaraqXaraq = 0.15D;
        int pabokPabok = 0;
        Location hunaqAraq = null;
        int h2l12 = 0;
        double kantoni4 = 0.0D;
        UUID taroha3 = null;
        int osakajo2 = 0;
        boolean hena4 = false;
        double kataL6da = 0.42D;
        Location caka3aq222 = null;
    }

    private final HantamiDaxe daxe;
    private final Ku1o ku1o;
    private final Random osakajo = new Random();
    private volatile boolean sp24 = false;
    private final Map<UUID, Xehate> xehate4 = new HashMap<>();
    private final List<Location> caka3aq22 = new ArrayList<>();
    private final List<Location> arakap2 = new ArrayList<>();
    private final List<VepaqKeka> keka3 = new ArrayList<>();
    private final List<String> vop23 = new ArrayList<>();
    private final Object vop2Ca3aq = new Object();
    private final java.util.Map<String, ResolvableProfile> s2qenaH2l = new java.util.HashMap<>();
    private int pabokKsaka = -1;
    private int xaraqPabokKsaka = -1;
    private int pabok4 = 0;
    private boolean xehateHunaq2 = false;

    public HantamiMakamaj6fi(HantamiDaxe daxe) {
        this.daxe = daxe;
        this.ku1o = daxe.ku1o();
    }

    // ⟪ }ʃᴜ j͐ʃᴜ ɹ 📃 ⟫


    /* }ʃᴜ j͐ʃᴜ ɹ */
    public World nala2() {
        return Bukkit.getWorld(ku1o.nala2());
    }

    // ⟪ ſᶘɹ ɭʃɜ j͑ʃᴜᶗ‹ 📃 ⟫


    /* ſᶘɹ ɭʃɜ j͑ʃᴜᶗ‹ */
    public void ts2tosax() {
        java.io.File cakavop2 = new java.io.File(daxe.getDataFolder(), "hantami.yml");
        if ( cakavop2.exists() ) {
            YamlConfiguration knakehe4 = YamlConfiguration.loadConfiguration(cakavop2);
            for ( String s2bana : knakehe4.getStringList("hantamoj") ) {
                try {
                    xehate4.putIfAbsent(UUID.fromString(s2bana), sp2Xehate());
                } catch ( IllegalArgumentException a3ohk2nik2p2 ) {
                    daxe.getLogger().warning(S2bana.A3OHK2NIK2P2_H2L2);
                }
            }
            World nala2 = nala2();
            if ( nala2 != null ) {
                caka3aq22.clear();
                for ( String s2bana : knakehe4.getStringList("domoj") ) {
                    Location araq3 = vefalAraq2(nala2, s2bana);
                    if ( araq3 != null ) {
                        caka3aq22.add(araq3);
                    }
                }
                arakap2.clear();
                for ( String s2bana : knakehe4.getStringList("vilagxoj") ) {
                    Location araq3 = vefalAraq2(nala2, s2bana);
                    if ( araq3 != null ) {
                        arakap2.add(araq3);
                    }
                }
            }
        }
        ts2tosaxVop2();
    }

    /* j͑ʃ'ɔ ſ̀ȷᴜȝ */
    public void ve3aq() {
        java.io.File cakavop2 = new java.io.File(daxe.getDataFolder(), "hantami.yml");
        YamlConfiguration knakehe4 = new YamlConfiguration();
        List<String> kap2S2bana = new ArrayList<>();
        for ( Location araq3 : caka3aq22 ) {
            kap2S2bana.add(k2fAraq(araq3));
        }
        knakehe4.set("domoj", kap2S2bana);
        List<String> arakap2S2bana = new ArrayList<>();
        for ( Location araq3 : arakap2 ) {
            arakap2S2bana.add(k2fAraq(araq3));
        }
        knakehe4.set("vilagxoj", arakap2S2bana);
        knakehe4.set("hantamoj", xehate4.keySet().stream().map(UUID::toString).toList());
        try {
            knakehe4.save(cakavop2);
        } catch ( Exception a3ohk2nik2p2 ) {
            daxe.getLogger().warning(S2bana.A3OHK2NIK2P2_H2L2);
        }
    }

    /* ſᶘɹ ɭʃɜ j͑ʃᴜᶗ‹ ʌ j͑ʃ'ɜ ſןɹ ɹ */
    public int ts2tosaxVop22() {
        ts2tosaxVop2();
        synchronized ( vop2Ca3aq ) {
            return vop23.size();
        }
    }

    /* ſᶘɹ ɭʃɜ j͑ʃᴜᶗ‹ ʌ j͑ʃ'ɜ ſןɹ */
    private void ts2tosaxVop2() {
        synchronized ( vop2Ca3aq ) {
            vop23.clear();
            java.io.File cakavop2 = new java.io.File(daxe.getDataFolder(), "nomoj.txt");
            if ( ! cakavop2.exists() ) {
                return;
            }
            try {
                for ( String ox2pewa2 : java.nio.file.Files.readAllLines(cakavop2.toPath()) ) {
                    String ksaka = ox2pewa2.trim();
                    if ( ksaka.matches("[A-Za-z0-9_]{3,16}") && ! vop23.contains(ksaka) ) {
                        vop23.add(ksaka);
                    }
                }
            } catch ( Exception a3ohk2nik2p2 ) {
                daxe.getLogger().warning(S2bana.A3OHK2NIK2P2_H2L2);
            }
        }
    }

    /* j͑ʃ'ɔ ſȷᴜͷ̗ ʌ ᴜ ɽ͑ʃ'ᴜ ſ͕ɭɹ */
    private Location vefalAraq2(World nala2, String s2bana) {
        try {
            String[] a10ni3 = s2bana.split(" ");
            int kantoni2 = Integer.parseInt(a10ni3[0]);
            int kantoni22 = Integer.parseInt(a10ni3[1]);
            int kantoni3 = Integer.parseInt(a10ni3[2]);
            return new Location(nala2, kantoni2, kantoni22, kantoni3);
        } catch ( Exception a3ohk2nik2p2 ) {
            return null;
        }
    }

    /* ſɭɹʞ ʌ ᴜ ɽ͑ʃ'ᴜȝ */
    private String k2fAraq(Location araq3) {
        return araq3.getBlockX() + " " + araq3.getBlockY() + " " + araq3.getBlockZ();
    }

    // ⟪ ſןᴜ ʃɜ ſɭɹ 📃 ⟫


    /* ſןᴜ ʃɜ ſɭɹ */
    public void pabok2() {
        vanekala();
        sp24 = true;
        pabokKsaka = Bukkit.getScheduler().runTaskTimer(daxe, this::pabok3, 40, 4).getTaskId(); // j͑ʃ'ᴜ }ʃɔ ſɭᴜ j͐ʃᴜ
        xaraqPabokKsaka = Bukkit.getScheduler().runTaskTimer(daxe, this::xaraqCa1ara, 1, 1).getTaskId();
    }

    /* j͑ʃ'ᴜ }ʃɔ ſɭᴜ j͐ʃᴜ */
    public void vanekala() {
        sp24 = false;
        for ( UUID ksaka4 : new ArrayList<>(xehate4.keySet()) ) {
            Entity fumu = Bukkit.getEntity(ksaka4);
            if ( fumu instanceof Mannequin daxe3 && ! daxe3.isDead() && daxe3.isValid() ) {
                daxe3.setGlowing(false);
                daxe3.customName(null);
                daxe3.setCustomNameVisible(false);
                daxe3.removePotionEffect(PotionEffectType.SPEED);
                daxe3.getEquipment().setItemInMainHand(new ItemStack(Material.AIR));
                daxe3.setVelocity(new Vector(0.0D, 0.0D, 0.0D));
            }
        }
        if ( pabokKsaka >= 0 ) {
            Bukkit.getScheduler().cancelTask(pabokKsaka);
            pabokKsaka = -1;
        }
        if ( xaraqPabokKsaka >= 0 ) {
            Bukkit.getScheduler().cancelTask(xaraqPabokKsaka);
            xaraqPabokKsaka = -1;
        }
    }

    /* ı],ᴜ ɽ͑ʃ'ᴜȝ ʌ ſɟᴜ ſᶘᴜ ɽ͑ʃ'ᴜ */
    private void xaraqCa1ara() {
        for ( Map.Entry<UUID, Xehate> paro : xehate4.entrySet() ) {
            Entity fumu = Bukkit.getEntity(paro.getKey());
            if ( ! ( fumu instanceof Mannequin daxe3 ) || daxe3.isDead() || ! daxe3.isValid() ) {
                continue;
            }
            Xehate xehate3 = paro.getValue();
            if ( xehate3.pabokPabok > 0 ) {
                xehate3.pabokPabok--;
                daxe3.setRotation(daxe3.getLocation().getYaw() + 36.0F, 0.0F);
            }
            Player kxawa3 = null;
            if ( xehate3.kxawa != null ) {
                Entity kxawaFumu = Bukkit.getEntity(xehate3.kxawa);
                if ( kxawaFumu instanceof Player hq2 && hq2.isOnline() && hq2.getWorld().equals(daxe3.getWorld()) && ! hq2.isDead() && hq2.getGameMode() != GameMode.SPECTATOR ) {
                    kxawa3 = hq2;
                }
            }
            Location kxawa = kxawa3 != null ? kxawa3.getLocation() : xehate3.xaraqKxawa;
            if ( kxawa == null || ! kxawa.getWorld().equals(daxe3.getWorld()) ) {
                h2l10(daxe3);
                continue;
            }
            Location araq5 = daxe3.getLocation();
            Vector pal62 = kxawa.clone().subtract(araq5).toVector();
            Vector c2w2q = pal62.clone();
            c2w2q.setY(0.0D);
            if ( c2w2q.lengthSquared() < 0.01D ) {
                h2l10(daxe3);
                continue;
            }
            double ka5ikKantoni = c2w2q.length();
            c2w2q.normalize();
            xehate3.h2l12++;
            if ( xehate3.h2l12 >= 10 ) {
                xehate3.h2l12 = 0;
                if ( xehate3.hunaqAraq != null && xehate3.hunaqAraq.distanceSquared(araq5) < 0.25D && araq5.distanceSquared(kxawa) > 4.0D ) {
                    xehate3.kantoni4 = osakajo.nextBoolean() ? 0.6D : -0.6D;
                }
                xehate3.hunaqAraq = araq5.clone();
            }
            xehate3.kantoni4 *= 0.95D;
            Vector kantoni5 = new Vector(-c2w2q.getZ(), 0.0D, c2w2q.getX());
            Vector xaraq = c2w2q.multiply(xehate3.xaraqXaraq).add(kantoni5.multiply(xehate3.kantoni4 * xehate3.xaraqXaraq));
            if ( kxawa3 != null ) {
                double pabok5 = ( daxe3.getWorld().getFullTime() / 20.0D ) + ( daxe3.getUniqueId().hashCode() % 628 ) / 100.0D; // ſɭэ ֭ſɭэ ʌ j͑ʃɘɹ
                xaraq.add(kantoni5.multiply(0.10D * Math.sin(pabok5)));
            }
            double kantoni22 = daxe3.getVelocity().getY();
            if ( daxe3.isOnGround() ) {
                Location hunaq5 = araq5.clone().add(c2w2q);
                boolean h2l13 = ! hunaq5.getBlock().isPassable() || ! hunaq5.clone().add(0.0D, 1.0D, 0.0D).getBlock().isPassable();
                if ( h2l13 ) {
                    kantoni22 = xehate3.kataL6da;
                    boolean c2w2qSp2 = k6h6Sp2(araq5.clone().add(kantoni5));
                    boolean c2w2qSp22 = k6h6Sp2(araq5.clone().subtract(kantoni5));
                    if ( c2w2qSp2 && ! c2w2qSp22 ) {
                        xehate3.kantoni4 = 0.9D;
                    } else if ( c2w2qSp22 && ! c2w2qSp2 ) {
                        xehate3.kantoni4 = -0.9D;
                    } else if ( c2w2qSp2 && c2w2qSp22 && xehate3.kantoni4 == 0.0D ) {
                        xehate3.kantoni4 = osakajo.nextBoolean() ? 0.9D : -0.9D;
                    }
                    xaraq.add(kantoni5.multiply(xehate3.kantoni4 * xehate3.xaraqXaraq));
                } else if ( kxawa.getY() - araq5.getY() > 1.2D && ka5ikKantoni > 1.0D ) {
                    kantoni22 = xehate3.kataL6da;
                } else if ( kantoni22 < -0.2D ) {
                    kantoni22 = -0.1D;
                } else {
                    kantoni22 = 0.0D;
                }
                if ( ! h2l13 && yor2Hunaq(hunaq5) ) {
                    xaraq.multiply(0.25D);
                    xehate3.kantoni4 = ( daxe3.getWorld().getFullTime() % 40L < 20L ) ? 0.8D : -0.8D; // ſɭэ ֭ſɭэ ʌ j͑ʃɘɹ
                }
            }
            daxe3.setVelocity(new Vector(xaraq.getX(), kantoni22, xaraq.getZ()));
            if ( xehate3.pabokPabok <= 0 && ! xehate3.hena4 ) {
                float kxawa5 = (float) Math.toDegrees(Math.atan2(-pal62.getX(), pal62.getZ()));
                float k2fe12 = keflna(kxawa5 - araq5.getYaw());
                float kata3 = Math.max(-20.0F, Math.min(20.0F, k2fe12));
                double kantoni6 = Math.sqrt(pal62.getX() * pal62.getX() + pal62.getZ() * pal62.getZ());
                float kantoni7 = (float) Math.toDegrees(Math.atan2(-pal62.getY(), kantoni6));
                kantoni7 = Math.max(-30.0F, Math.min(30.0F, kantoni7));
                daxe3.setRotation(araq5.getYaw() + kata3, kantoni7);
            }
        }
    }

    /* ſɭэ ֭ſɭэ ʌ j͑ʃɘɹ */
    private boolean k6h6Sp2(Location araq3) {
        return araq3.getBlock().isPassable() && araq3.clone().add(0.0D, 1.0D, 0.0D).getBlock().isPassable();
    }

    /* ſ͕ȷɜ ɽ͑ʃ'ɹ ʌ ֭ſɭw }ʃᴜȝ */
    private boolean yor2Hunaq(Location hunaq5) {
        Material xehate2 = hunaq5.getBlock().getType();
        if ( xehate2 == Material.LAVA || xehate2 == Material.FIRE || xehate2 == Material.SOUL_FIRE || xehate2 == Material.MAGMA_BLOCK || xehate2 == Material.CAMPFIRE || xehate2 == Material.CACTUS ) {
            return true;
        }
        for ( int k2fe = 1; k2fe <= 4; k2fe++ ) { // ֭ſɭɹ j͐ʃꝛ̗ɔⅎ
            Material kantoni8 = hunaq5.clone().add(0.0D, -k2fe, 0.0D).getBlock().getType();
            if ( kantoni8 == Material.LAVA ) {
                return true;
            }
            if ( kantoni8.isSolid() && kantoni8 != Material.CACTUS ) {
                return false;
            }
        }
        return true;
    }

    /* ֭ſɭɹ j͐ʃꝛ̗ɔⅎ */
    private void h2l10(Mannequin daxe3) {
        Vector xaraq2 = daxe3.getVelocity();
        daxe3.setVelocity(new Vector(xaraq2.getX() * 0.5D, xaraq2.getY(), xaraq2.getZ() * 0.5D));
    }

    /* ſɭɔ ſȷͷ̗c̗ᴜ */
    private float keflna(float kantoni) {
        while ( kantoni > 180.0F ) {
            kantoni -= 360.0F;
        }
        while ( kantoni < -180.0F ) {
            kantoni += 360.0F;
        }
        return kantoni;
    }

    /* ſןᴜ ʃɜƽŋ */
    private void pabok3() {
        pabok4++;
        World nala2 = nala2();
        if ( nala2 == null ) {
            if ( pabok4 % 75 == 0 ) {
                daxe.getLogger().warning(S2bana.A3OHK2NIK2P2_H2L2);
            }
            return;
        }
        List<UUID> cam2 = new ArrayList<>();
        for ( Map.Entry<UUID, Xehate> paro : xehate4.entrySet() ) {
            Entity fumu = Bukkit.getEntity(paro.getKey());
            if ( fumu == null ) {
                continue;
            }
            if ( ! ( fumu instanceof Mannequin daxe3 ) || daxe3.isDead() || ! daxe3.isValid() ) {
                cam2.add(paro.getKey());
                continue;
            }
            if ( ! daxe3.getWorld().equals(nala2) ) {
                cam2.add(paro.getKey());
                continue;
            }
            cal2(daxe3, paro.getValue());
        }
        for ( UUID cam22 : cam2 ) {
            xehate4.remove(cam22);
        }
        s2rol2miHunaq(nala2);
        if ( ! keka3.isEmpty() ) {
            java.util.Iterator<VepaqKeka> ca1ara = keka3.iterator();
            while ( ca1ara.hasNext() ) {
                VepaqKeka keka4 = ca1ara.next();
                int xehate3 = keka4.kata3();
                if ( xehate3 == 1 ) {
                    ca1ara.remove();
                    Location araq4 = keka4.araq4();
                    caka3aq22.add(new Location(araq4.getWorld(), araq4.getBlockX(), araq4.getBlockY(), araq4.getBlockZ()));
                    if ( caka3aq22.size() > 64 ) {
                        caka3aq22.remove(0);
                    }
                    daxe.getLogger().info(S2bana.VOP2_KAP2);
                } else if ( xehate3 == 2 ) {
                    ca1ara.remove();
                }
            }
        }
        if ( pabok4 % 50 == 0 ) {
            s2rol2miArakap2(nala2);
        }
        if ( pabok4 % 1500 == 0 ) {
            k2fTs2tosax(nala2, false);
            kawetabiHq2(nala2);
        }
        if ( pabok4 % 150 == 0 ) {
            ve3aq();
        }
    }

    /* ı],ɔ ֭ſɭᴜ ɭʃɔ ʌ ֭ſɭw }ʃᴜȝ */
    private boolean xehateHunaq(World nala2) {
        long gani12 = nala2.getTime() % 24000L;
        return gani12 >= 13000L && gani12 <= 23000L; // j͑ʃɹ ɽ͑ʃ'ɜ j͐ʃɹ ŋᷠꞇ ʌ ֭ſɭw }ʃᴜȝ
    }

    /* j͑ʃɹ ɽ͑ʃ'ɜ j͐ʃɹ ŋᷠꞇ ʌ ֭ſɭw }ʃᴜȝ */
    private void s2rol2miHunaq(World nala2) {
        boolean hunaq7 = xehateHunaq(nala2);
        if ( hunaq7 && ! xehateHunaq2 ) {
            for ( Map.Entry<UUID, Xehate> paro : xehate4.entrySet() ) {
                Entity fumu = Bukkit.getEntity(paro.getKey());
                if ( fumu instanceof Mannequin daxe3 && ! daxe3.isDead() && daxe3.isValid() && daxe3.getWorld().equals(nala2) ) {
                    if ( osakajo.nextInt(4) == 0 ) {
                        paro.getValue().hena4 = true;
                    }
                }
            }
        }
        if ( ! hunaq7 && xehateHunaq2 ) {
            for ( Map.Entry<UUID, Xehate> paro : xehate4.entrySet() ) {
                Entity fumu = Bukkit.getEntity(paro.getKey());
                if ( fumu instanceof Mannequin daxe3 && ! daxe3.isDead() && daxe3.isValid() ) {
                    if ( paro.getValue().hena4 ) {
                        paro.getValue().hena4 = false;
                        sp22(daxe3, paro.getValue());
                    }
                }
            }
        }
        xehateHunaq2 = hunaq7;
    }

    // ⟪ эⅎ ſᶘɔ ʌ j͑ʃɘɹ 📃 ⟫


    /* эⅎ ſᶘɔ ʌ j͑ʃɘɹ */
    public void a41eSp2() {
        World nala2 = nala2();
        if ( nala2 == null ) {
            return;
        }
        k2fTs2tosax(nala2, true);
    }

    private void k2fTs2tosax(World nala2, boolean hunaq6) {
        for ( Entity fumu : nala2.getEntities() ) {
            if ( fumu instanceof Mannequin daxe3 && daxe3.getScoreboardTags().contains(XEHATE) ) {
                Xehate xehate3 = xehate4.putIfAbsent(daxe3.getUniqueId(), sp2Xehate());
                if ( xehate3 != null && ! hunaq6 ) {
                    continue;
                }
                daxe3.getEquipment().setItemInMainHand(new ItemStack(Material.AIR));
                daxe3.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, PotionEffect.INFINITE_DURATION, 0, false, false));
                sp22(daxe3, xehate3 == null ? xehate4.get(daxe3.getUniqueId()) : xehate3);
            }
        }
    }

    /* j͑ʃɘɹ ʌ ı],ɔ ֭ſɭᴜ ɭʃɔ */
    private Xehate sp2Xehate() {
        Xehate xehate3 = new Xehate();
        xehate3.vepaqKsaka = 1200 + osakajo.nextInt(3600); // ſɭᴜ ᶅſɔ ɭʃᴜ ʃꞇ ʌ ֭ſɭȝɹ
        return xehate3;
    }

    /* ſɭᴜ ᶅſɔ ɭʃᴜ ʃꞇ ʌ ֭ſɭȝɹ */
    private void kawetabiHq2(World nala2) {
        int sp23 = xehate4.size();
        int h2l14 = ku1o.kxawa() - sp23;
        if ( h2l14 <= 0 ) {
            return;
        }
        int veb6kek4 = Math.min(h2l14, 1);
        for ( int k2fe = 0; k2fe < veb6kek4; k2fe++ ) {
            Location keka2 = sukf2qKeka(nala2);
            if ( keka2 == null ) {
                return;
            }
            Location veb6kek2 = s2rol2miVeb6kek(nala2, keka2);
            if ( veb6kek2 == null ) {
                continue;
            }
            q2qVeb6kek(veb6kek2);
        }
    }

    /* j͑ʃw ſɭʞɹȝ ʌ ſɭɔ ſɭᴜ */
    private Location sukf2qKeka(World nala2) {
        List<Location> sp23 = new ArrayList<>();
        for ( UUID ksaka4 : xehate4.keySet() ) {
            Entity fumu = Bukkit.getEntity(ksaka4);
            if ( fumu instanceof Mannequin daxe3 && ! daxe3.isDead() ) {
                sp23.add(daxe3.getLocation());
            }
        }
        if ( ! sp23.isEmpty() ) {
            return sp23.get(osakajo.nextInt(sp23.size()));
        }
        List<Player> araq6 = new ArrayList<>();
        for ( Player hq2 : Bukkit.getOnlinePlayers() ) {
            if ( hq2.getWorld().equals(nala2) ) {
                araq6.add(hq2);
            }
        }
        if ( ! araq6.isEmpty() ) {
            return araq6.get(osakajo.nextInt(araq6.size())).getLocation();
        }
        return nala2.getSpawnLocation();
    }

    /* j͑ʃɹ ɽ͑ʃ'ɜ j͐ʃɹ ŋᷠꞇ ʌ j͑ʃ'ɔ ʃэ ſɭɔƽ */
    private Location s2rol2miVeb6kek(World nala2, Location keka2) {
        int ka5ik4 = ku1o.veb6kekKa5ik();
        for ( int s2rol2mi3 = 0; s2rol2mi3 < 8; s2rol2mi3++ ) {
            double kantoni = osakajo.nextDouble() * Math.PI * 2.0D;
            double ka5ik6 = 64.0D + osakajo.nextDouble() * ka5ik4;
            int kantoni2 = keka2.getBlockX() + (int) ( Math.cos(kantoni) * ka5ik6 );
            int kantoni3 = keka2.getBlockZ() + (int) ( Math.sin(kantoni) * ka5ik6 );
            Location oz = HantamiVepaq.s2rol2miOz(nala2, kantoni2, kantoni3);
            if ( oz != null ) {
                return oz;
            }
        }
        return null;
    }

    /* ſ͕ɭɹȝ ʌ j͑ʃ'ɔ ʃэ ſɭɔƽ */
    public boolean q2qVeb6kek(Location araq3) {
        return q2qVeb6kek(araq3, null);
    }

    /* ſ͕ɭɹȝ ʌ j͑ʃ'ɔ ʃэ ſɭɔƽ */
    public boolean q2qVeb6kek(Location araq3, org.bukkit.command.CommandSender s2bana4) {
        String ksaka;
        synchronized ( vop2Ca3aq ) {
            if ( vop23.isEmpty() || ( s2bana4 == null && xehate4.size() >= ku1o.pal6Hq2() ) ) {
                return false;
            }
            ksaka = vop23.get(osakajo.nextInt(vop23.size()));
        }
        String sukf2q = ksaka;
        Bukkit.getScheduler().runTaskAsynchronously(daxe, () -> {
            ResolvableProfile a10ni8 = a10niS2qena(sukf2q);
            if ( a10ni8 == null ) {
                a10ni8 = ResolvableProfile.resolvableProfile().name(sukf2q).uuid(UUID.randomUUID()).build();
            }
            ResolvableProfile sp25 = a10ni8;
            Bukkit.getScheduler().runTask(daxe, () -> {
                if ( ! daxe.isEnabled() ) {
                    return;
                }
                Mannequin veb6kek5 = veb6kek3(araq3, sp25);
                if ( veb6kek5 != null && s2bana4 != null ) {
                    s2bana4.sendMessage(S2bana.VEB6KEK2);
                }
            });
        });
        return true;
    }

    /* ſᶘɔⅎ }ʃꞇ ʌ j͑ʃɹ ſ͕ɭɔ }ʃᴜ */
    private ResolvableProfile a10niS2qena(String ksaka) {
        synchronized ( vop2Ca3aq ) {
            ResolvableProfile h2l15 = s2qenaH2l.get(ksaka);
            if ( h2l15 != null ) {
                return h2l15;
            }
        }
        try {
            PlayerProfile pukek = Bukkit.createProfile(null, ksaka);
            boolean pal62;
            try {
                pal62 = pukek.complete();
            } catch ( Exception a3ohk2nik2p2 ) {
                pal62 = false;
            }
            if ( ! pal62 || ! pukek.hasTextures() ) {
                return null;
            }
            ResolvableProfile a10ni8 = ResolvableProfile.resolvableProfile(pukek);
            synchronized ( vop2Ca3aq ) {
                s2qenaH2l.put(ksaka, a10ni8);
            }
            return a10ni8;
        } catch ( Exception a3ohk2nik2p2 ) {
            return null;
        }
    }

    /* j͑ʃ'ɔ ʃэ ſɭɔƽŋ */
    public Mannequin veb6kek3(Location araq3, ResolvableProfile s2qena) {
        World nala2 = araq3.getWorld();
        if ( nala2 == null ) {
            return null;
        }
        Entity fumu = nala2.spawnEntity(araq3, EntityType.MANNEQUIN);
        if ( ! ( fumu instanceof Mannequin daxe3 ) ) {
            fumu.remove();
            return null;
        }
        daxe3.setProfile(s2qena);
        daxe3.setImmovable(false);
        daxe3.addScoreboardTag(XEHATE);
        try {
            if ( daxe3.getAttribute(Attribute.MAX_HEALTH) != null ) {
                daxe3.getAttribute(Attribute.MAX_HEALTH).setBaseValue(20.0D);
            }
            daxe3.setHealth(20.0D);
        } catch ( Exception a3ohk2nik2p2 ) {
            daxe.getLogger().warning(S2bana.A3OHK2NIK2P2_H2L2);
        }
        daxe3.getEquipment().setItemInMainHand(new ItemStack(Material.AIR));
        daxe3.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, PotionEffect.INFINITE_DURATION, 0, false, false));
        Xehate xehate3 = sp2Xehate();
        xehate4.put(daxe3.getUniqueId(), xehate3);
        ve3aq();
        if ( xehateHunaq(nala2) && osakajo.nextInt(4) == 0 ) {
            xehate3.hena4 = true;
        }
        sp22(daxe3, xehate3);
        daxe.getLogger().info(S2bana.VOP2_VEB6KEK);
        return daxe3;
    }

    /* ֭ſɭɹͷ̗ꝛ̗ꝛ̗ */
    public void h2l11(UUID ksaka4) {
        xehate4.remove(ksaka4);
        ve3aq();
    }

    /* ı],ɔ ֭ſɭᴜ ɭʃɔ ʌ ɭ(ᴜ ı],ɔ */
    public boolean xehateDaxe(Entity fumu) {
        return fumu instanceof Mannequin && fumu.getScoreboardTags().contains(XEHATE);
    }

    /* j͑ʃɘɹ ʌ ſɭɹ ſȷɔ */
    public int sp2K2fe() {
        return xehate4.size();
    }

    /* ſɟᴜ ſɭᴜ ſ̀ȷᴜ ſ͕ɭɹ ɹ */
    public List<Location> caka3aq22() {
        return caka3aq22;
    }

    /* ᴜ ɽ͑ʃ'ᴜ ſɭᴜ ſןɹ */
    public List<Location> arakap2() {
        return arakap2;
    }

    /* ᴜ }ʃꞇɔ˞ŋ */
    public int anis3(World nala2) {
        int k2fe11 = 0;
        for ( Entity fumu : new ArrayList<>(nala2.getEntities()) ) {
            if ( xehateDaxe(fumu) ) {
                fumu.remove();
                xehate4.remove(fumu.getUniqueId());
                k2fe11++;
            }
        }
        ve3aq();
        return k2fe11;
    }

    // ⟪ ſɟᴜ j͐ʃɹ 📃 ⟫


    /* ſɟᴜ j͐ʃɹ */
    private void cal2(Mannequin daxe3, Xehate xehate3) {
        if ( xehate3.peKsaka > 0 ) {
            xehate3.peKsaka -= 4;
        }
        if ( xehate3.hena4 ) {
            if ( ! xehateHunaq(daxe3.getWorld()) ) {
                xehate3.hena4 = false;
                sp22(daxe3, xehate3);
                return;
            }
            Player taroha2 = pal6Ka5ikPe(daxe3, 48.0D);
            if ( taroha2 != null ) {
                xehate3.kxawa = taroha2.getUniqueId();
                xehate3.xaraqKxawa = taroha2.getLocation();
                xehate3.xaraqXaraq = 0.30D;
                xehate3.kataL6da = 0.9D;
                daxe3.setGlowing(true);
                taroha(daxe3, xehate3, taroha2);
                hena(daxe3, xehate3);
            } else {
                xehate3.kxawa = null;
                xehate3.kataL6da = 0.9D;
                kata(daxe3, xehate3);
                hena(daxe3, xehate3);
            }
            return;
        }
        Player kxawa3 = null;
        if ( xehate3.kxawa != null ) {
            Entity fumu = Bukkit.getEntity(xehate3.kxawa);
            if ( fumu instanceof Player hq2 && hq2.isOnline() && hq2.getWorld().equals(daxe3.getWorld()) && ! hq2.isDead() && hq2.getGameMode() != GameMode.SPECTATOR ) {
                if ( hq2.getLocation().distanceSquared(daxe3.getLocation()) < 2304.0D ) {
                    kxawa3 = hq2;
                }
            }
            if ( kxawa3 == null ) {
                Player sp26 = pal6Ka5ikPe(daxe3, 32.0D);
                if ( sp26 != null ) {
                    xehate3.kxawa = sp26.getUniqueId();
                    kxawa3 = sp26;
                } else {
                    sp22(daxe3, xehate3);
                }
            }
        }
        if ( kxawa3 != null ) {
            xehate3.xaraqKxawa = kxawa3.getLocation();
            xehate3.xaraqXaraq = 0.26D;
            taroha(daxe3, xehate3, kxawa3);
            hena2(daxe3, xehate3);
            return;
        }
        a2banuKa5ik(daxe3, xehate3);
        a2banuTaroha(daxe3, xehate3);
        if ( xehate3.kxawa != null ) {
            Entity fumu = Bukkit.getEntity(xehate3.kxawa);
            if ( fumu instanceof Player hq2 ) {
                xehate3.xaraqKxawa = hq2.getLocation();
                xehate3.xaraqXaraq = 0.26D;
                taroha(daxe3, xehate3, hq2);
                hena2(daxe3, xehate3);
                return;
            }
        }
        kata(daxe3, xehate3);
        xehate3.vepaqKsaka -= 4;
        if ( xehate3.vepaqKsaka <= 0 ) {
            xehate3.vepaqKsaka = 2400 + osakajo.nextInt(4800); // ɹ ʃᴜ }ʃw ʌ ſɭᴜ ſɭˬꞇƽ
            s2rol2miVepaq(daxe3, xehate3);
        }
    }

    /* ɹ ʃᴜ }ʃw ʌ ſɭᴜ ſɭˬꞇƽ */
    private void a2banuKa5ik(Mannequin daxe3, Xehate xehate3) {
        Location araq5 = daxe3.getLocation();
        List<Player> ka5ik7 = new ArrayList<>();
        for ( Entity fumu : daxe3.getNearbyEntities(ku1o.ka5ik2banu(), 8.0D, ku1o.ka5ik2banu()) ) {
            if ( fumu instanceof Player hq2 && ! hq2.isDead() && hq2.getGameMode() != GameMode.SPECTATOR ) {
                ka5ik7.add(hq2);
            }
        }
        int c2kani4 = 0;
        for ( Entity fumu : daxe3.getNearbyEntities(ku1o.c2kani2banu(), 8.0D, ku1o.c2kani2banu()) ) {
            if ( fumu instanceof Mannequin yor23 && ! yor23.getUniqueId().equals(daxe3.getUniqueId()) && yor23.getScoreboardTags().contains(XEHATE) ) {
                c2kani4++;
            }
        }
        if ( ka5ik7.size() == 1 && c2kani4 == 0 ) {
            xehate3.ka5ik5 += 4;
            if ( xehate3.ka5ik5 >= ku1o.ka5ikPabok() ) {
                yor22(daxe3, xehate3, ka5ik7.get(0));
            }
        } else {
            xehate3.ka5ik5 = Math.max(0, xehate3.ka5ik5 - 8);
        }
    }

    /* ɹ ʃᴜ }ʃw ʌ ɭʃᴜ ɽ͑ʃ'ɜ ֭ſɭᴜ */
    private void a2banuTaroha(Mannequin daxe3, Xehate xehate3) {
        if ( xehate3.kxawa != null ) {
            return;
        }
        Location araq5 = daxe3.getLocation();
        Player ka5ik3 = null;
        for ( Entity fumu : daxe3.getNearbyEntities(ku1o.ka5ik2banu(), 8.0D, ku1o.ka5ik2banu()) ) {
            if ( fumu instanceof Player hq2 && ! hq2.isDead() && hq2.getGameMode() != GameMode.SPECTATOR ) {
                if ( ka5ik3 != null ) {
                    xehate3.taroha3 = null;
                    xehate3.osakajo2 = 0;
                    return;
                }
                ka5ik3 = hq2;
            }
        }
        if ( ka5ik3 == null ) {
            xehate3.taroha3 = null;
            xehate3.osakajo2 = 0;
            return;
        }
        double ka5ik22 = ku1o.ka5ikHq22banu() * ku1o.ka5ikHq22banu();
        for ( Player yor23 : daxe3.getWorld().getPlayers() ) {
            if ( yor23.equals(ka5ik3) || yor23.isDead() || yor23.getGameMode() == GameMode.SPECTATOR ) {
                continue;
            }
            if ( yor23.getLocation().distanceSquared(araq5) < ka5ik22 ) {
                xehate3.taroha3 = null;
                xehate3.osakajo2 = 0;
                return;
            }
        }
        if ( ! ka5ik3.getUniqueId().equals(xehate3.taroha3) ) {
            xehate3.taroha3 = ka5ik3.getUniqueId();
            xehate3.osakajo2 = 4;
        } else {
            xehate3.osakajo2 += 4;
        }
        if ( xehate3.osakajo2 >= ku1o.osakajoPabok() ) {
            yor22(daxe3, xehate3, ka5ik3);
        }
    }

    /* ֭ſɭɔ }ʃᴜ */
    private void hena(Mannequin daxe3, Xehate xehate3) {
        xehate3.fumuPabok++;
        daxe3.setRotation(daxe3.getLocation().getYaw() + 12.0F, 0.0F);
        Location a2banu = daxe3.getEyeLocation();
        World nala2 = daxe3.getWorld();
        nala2.spawnParticle(Particle.ASH, a2banu, 6, 0.5D, 0.8D, 0.5D, 0.02D);
        nala2.spawnParticle(Particle.LARGE_SMOKE, a2banu, 3, 0.4D, 0.6D, 0.4D, 0.01D);
        for ( Entity fumu : daxe3.getNearbyEntities(12.0D, 8.0D, 12.0D) ) { // ſ͕ȷɜ ɽ͑ʃ'ɹ ɹ
            if ( fumu instanceof Player hq2 && ! hq2.isDead() && hq2.getGameMode() != GameMode.SPECTATOR ) {
                hq2.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS, 80, 0, false, false));
            }
        }
        if ( xehate3.fumuPabok % 40 == 0 ) {
            nala2.playSound(daxe3.getLocation(), Sound.ENTITY_WARDEN_HEARTBEAT, 1.0F, 0.7F);
        }
        if ( xehate3.fumuPabok % 100 == 0 ) {
            nala2.playSound(daxe3.getLocation(), Sound.ENTITY_ENDERMAN_SCREAM, 0.8F, 0.4F);
        }
    }

    /* ſ͕ȷɜ ɽ͑ʃ'ɹ ɹ */
    public void yor22(Mannequin daxe3, Xehate xehate3, Player kxawa3) {
        xehate3.kxawa = kxawa3.getUniqueId();
        xehate3.ka5ik5 = 0;
        xehate3.fumuPabok = 0;
        xehate3.pabokPabok = 10;
        daxe3.setGlowing(true);
        daxe3.getWorld().playSound(daxe3.getLocation(), Sound.ENTITY_WARDEN_ROAR, 1.0F, 0.6F);
        daxe3.getWorld().spawnParticle(Particle.SOUL_FIRE_FLAME, daxe3.getEyeLocation(), 24, 0.5D, 0.8D, 0.5D, 0.02D);
    }

    /* j͑ʃɘɹ ɹ */
    private void sp22(Mannequin daxe3, Xehate xehate3) {
        xehate3.kxawa = null;
        xehate3.ka5ik5 = 0;
        xehate3.fumuPabok = 0;
        xehate3.pabokPabok = 0;
        xehate3.xaraqKxawa = null;
        xehate3.kantoni4 = 0.0D;
        xehate3.taroha3 = null;
        xehate3.osakajo2 = 0;
        xehate3.kataL6da = 0.42D;
        daxe3.setGlowing(false);
        daxe3.customName(null);
        daxe3.setCustomNameVisible(false);
    }

    /* ſןᴜ j͐ʃэ ʌ ſɭᴜ ſɭˬꞇƽ ʌ ſןɔ */
    private Player pal6Ka5ikPe(Mannequin daxe3, double ka5ik4) {
        Location araq5 = daxe3.getLocation();
        Player pal6Anis = null;
        double pal6Ka5ik2 = ka5ik4 * ka5ik4;
        for ( Player hq2 : daxe3.getWorld().getPlayers() ) {
            if ( hq2.isDead() || hq2.getGameMode() == GameMode.SPECTATOR ) {
                continue;
            }
            double ka5ik23 = hq2.getLocation().distanceSquared(araq5);
            if ( ka5ik23 < pal6Ka5ik2 ) {
                pal6Ka5ik2 = ka5ik23;
                pal6Anis = hq2;
            }
        }
        return pal6Anis;
    }

    /* ɭʃᴜ ɽ͑ʃ'ɜ ֭ſɭᴜ */
    private void taroha(Mannequin daxe3, Xehate xehate3, Player kxawa3) {
        Location araq5 = daxe3.getLocation();
        Location kxawa4 = kxawa3.getLocation();
        double ka5ik23 = araq5.distanceSquared(kxawa4);
        if ( ka5ik23 < 9.0D ) {
            a2banuZeni(daxe3, kxawa4);
            if ( xehate3.peKsaka <= 0 ) {
                xehate3.peKsaka = 20;
                daxe3.swingMainHand();
                Vector kata4 = kxawa4.clone().subtract(araq5).toVector();
                kata4.setY(0.0D);
                if ( kata4.lengthSquared() > 0.01D ) {
                    kata4.normalize().multiply(0.35D);
                    daxe3.setVelocity(new Vector(kata4.getX(), daxe3.getVelocity().getY(), kata4.getZ()));
                }
                kxawa3.damage(ku1o.peSkak(), daxe3);
            }
            return;
        }
        xehate3.xaraqKxawa = kxawa4;
        xehate3.xaraqXaraq = 0.26D;
        if ( ka5ik23 < 36.0D ) {
            a2banuZeni(daxe3, kxawa4);
        }
    }

    /* ֭ſɭɔ }ʃᴜ ɹ */
    private void hena2(Mannequin daxe3, Xehate xehate3) {
        xehate3.fumuPabok++;
        Location a2banu = daxe3.getEyeLocation();
        World nala2 = daxe3.getWorld();
        double veb6kek6 = 0.35D + 0.35D * Math.sin(xehate3.fumuPabok * 0.6D);
        Vector hunaq8 = a2banu.getDirection().setY(0.0D).normalize();
        Vector kantoni5 = new Vector(-hunaq8.getZ(), 0.0D, hunaq8.getX()).normalize();
        for ( int l6da = 0; l6da < 3; l6da++ ) {
            Location sost2 = a2banu.clone().add(hunaq8.clone().multiply(0.6D));
            sost2.setY(a2banu.getY() - l6da * 0.25D);
            Location c2w2q2 = sost2.clone().add(kantoni5.clone().multiply(veb6kek6 + 0.08D));
            Location c2w2q3 = sost2.clone().subtract(kantoni5.clone().multiply(veb6kek6 + 0.08D));
            nala2.spawnParticle(Particle.SOUL_FIRE_FLAME, c2w2q2, 2, 0.02D, 0.05D, 0.02D, 0.0D);
            nala2.spawnParticle(Particle.SOUL_FIRE_FLAME, c2w2q3, 2, 0.02D, 0.05D, 0.02D, 0.0D);
            nala2.spawnParticle(Particle.SMOKE, sost2, 1, 0.02D, 0.05D, 0.02D, 0.0D);
        }
        if ( xehate3.fumuPabok % 25 == 0 ) {
            nala2.playSound(daxe3.getLocation(), Sound.ENTITY_ENDERMAN_SCREAM, 0.7F, 0.5F);
        }
    }

    // ⟪ ſɭᴜ ɭʃᴜ 📃 ⟫


    /* ſɭᴜ ɭʃᴜ */
    private void kata(Mannequin daxe3, Xehate xehate3) {
        VepaqKeka keka4 = kekaA1iq(daxe3.getUniqueId());
        if ( keka4 != null ) {
            Location araq4 = keka4.araq4();
            xehate3.xaraqKxawa = null;
            if ( daxe3.getLocation().distanceSquared(araq4) > 36.0D ) {
                xehate3.xaraqKxawa = araq4;
                xehate3.xaraqXaraq = 0.15D;
            } else {
                a2banuZeni(daxe3, araq4);
            }
            return;
        }
        long gani13 = daxe3.getWorld().getFullTime();
        Location araq5 = daxe3.getLocation();
        if ( xehate3.kata2 == null || gani13 > xehate3.kataH2l || xehate3.kata2.distanceSquared(araq5) < 4.0D ) {
            xehate3.kata2 = sukf2qKata(daxe3, xehate3);
            xehate3.kataH2l = gani13 + 200L + osakajo.nextInt(400); // j͑ʃw ſɭʞɹȝ ʌ ſɭᴜ ɭʃᴜ
            return;
        }
        xehate3.xaraqKxawa = xehate3.kata2;
        xehate3.xaraqXaraq = 0.15D;
    }

    /* j͑ʃw ſɭʞɹȝ ʌ ſɭᴜ ɭʃᴜ */
    private Location sukf2qKata(Mannequin daxe3, Xehate xehate3) {
        Location araq5 = daxe3.getLocation();
        Location pal6Ka5ik = null;
        double pal6Ka5ik2 = Double.MAX_VALUE;
        for ( Location arakap22 : arakap2 ) {
            if ( ! arakap22.getWorld().equals(araq5.getWorld()) ) {
                continue;
            }
            double ka5ik23 = arakap22.distanceSquared(araq5);
            if ( ka5ik23 < pal6Ka5ik2 ) {
                pal6Ka5ik2 = ka5ik23;
                pal6Ka5ik = arakap22;
            }
        }
        Location k6h6 = araq5;
        double pal6K6h62 = 4096.0D;
        if ( pal6Ka5ik != null && pal6Ka5ik2 < pal6K6h62 ) {
            k6h6 = pal6Ka5ik;
            pal6K6h62 = pal6Ka5ik2;
        }
        if ( xehate3.caka3aq222 != null && xehate3.caka3aq222.getWorld().equals(araq5.getWorld()) ) {
            double caka3aq2222 = xehate3.caka3aq222.distanceSquared(araq5);
            if ( caka3aq2222 < pal6K6h62 && caka3aq2222 < 9216.0D ) {
                k6h6 = xehate3.caka3aq222;
            }
        }
        for ( int s2rol2mi3 = 0; s2rol2mi3 < 6; s2rol2mi3++ ) {
            double kantoni = osakajo.nextDouble() * Math.PI * 2.0D;
            double ka5ik6 = 8.0D + osakajo.nextDouble() * 16.0D; // ɹ ʃᴜ }ʃw ʌ ſɭ,ɔ }ʃꞇ
            int kantoni2 = k6h6.getBlockX() + (int) ( Math.cos(kantoni) * ka5ik6 );
            int kantoni3 = k6h6.getBlockZ() + (int) ( Math.sin(kantoni) * ka5ik6 );
            Location oz = HantamiVepaq.s2rol2miOz(araq5.getWorld(), kantoni2, kantoni3);
            if ( oz != null ) {
                return oz;
            }
        }
        return araq5;
    }

    /* ɹ ʃᴜ }ʃw ʌ ſɭ,ɔ }ʃꞇ */
    private void a2banuZeni(Mannequin daxe3, Location kxawa) {
        Location araq5 = daxe3.getLocation();
        Vector c2w2q = kxawa.clone().subtract(araq5).toVector();
        if ( c2w2q.lengthSquared() < 0.01D ) {
            return;
        }
        float a2banu2 = (float) Math.toDegrees(Math.atan2(-c2w2q.getX(), c2w2q.getZ()));
        daxe3.setRotation(a2banu2, 0.0F);
    }

    // ⟪ j͑ʃɹ ɽ͑ʃ'ɜ j͐ʃɹ ŋᷠꞇ ʌ j͑ʃ'ɔ ſןᴜȝ 📃 ⟫


    /* j͑ʃɹ ɽ͑ʃ'ɜ j͐ʃɹ ŋᷠꞇ ʌ j͑ʃ'ɔ ſןᴜȝ */
    private void s2rol2miVepaq(Mannequin daxe3, Xehate xehate3) {
        World nala2 = daxe3.getWorld();
        Location araq5 = daxe3.getLocation();
        if ( keka3.size() >= 3 ) {
            return;
        }
        for ( VepaqKeka keka4 : keka3 ) {
            if ( keka4.vepaq3().equals(daxe3.getUniqueId()) ) {
                return;
            }
            if ( keka4.araq4().getWorld().equals(nala2) && keka4.araq4().distanceSquared(araq5) < 100.0D ) {
                return;
            }
        }
        Location a41e = null;
        double a41e2 = 576.0D;
        for ( Location ksaka5 : caka3aq22 ) {
            if ( ! ksaka5.getWorld().equals(nala2) ) {
                continue;
            }
            double ka5ik23 = ksaka5.distanceSquared(araq5);
            if ( ka5ik23 < a41e2 ) {
                a41e2 = ka5ik23;
                a41e = ksaka5;
            }
        }
        if ( a41e != null ) {
            xehate3.caka3aq222 = a41e;
            return;
        }
        for ( Location ksaka5 : caka3aq22 ) {
            if ( ksaka5.getWorld().equals(nala2) && ksaka5.distanceSquared(araq5) < 100.0D ) {
                return;
            }
        }
        HantamiVepaq.B6rakowe10ni b6rakowe = HantamiVepaq.b6rakoweKap2(nala2, araq5, osakajo, ku1o.kehuKa5ik(), caka3aq22);
        if ( b6rakowe == null || b6rakowe.ca1ara2.isEmpty() ) {
            return;
        }
        Location araq4 = new Location(nala2, araq5.getBlockX(), araq5.getBlockY(), araq5.getBlockZ());
        keka3.add(new VepaqKeka(nala2, daxe3.getUniqueId(), araq4, b6rakowe.ca1ara2, b6rakowe.pukek3));
    }

    /* ſɭɔ ſɭᴜ ʌ ᴜ ſᶘꞇȝ */
    private VepaqKeka kekaA1iq(UUID ksaka4) {
        for ( VepaqKeka keka4 : keka3 ) {
            if ( keka4.vepaq3().equals(ksaka4) ) {
                return keka4;
            }
        }
        return null;
    }

    // ⟪ j͑ʃɹ ɽ͑ʃ'ɜ j͐ʃɹ ŋᷠꞇ ʌ ᴜ ɽ͑ʃ'ᴜ ſɭᴜ ſןɹ 📃 ⟫


    /* j͑ʃɹ ɽ͑ʃ'ɜ j͐ʃɹ ŋᷠꞇ ʌ ᴜ ɽ͑ʃ'ᴜ ſɭᴜ ſןɹ */
    public void s2rol2miArakap2(World nala2) {
        Set<UUID> xaraq3 = new HashSet<>();
        Collection<Mannequin> sp23 = ca1araSp2(nala2);
        for ( Mannequin caka3aq2 : sp23 ) {
            if ( xaraq3.contains(caka3aq2.getUniqueId()) ) {
                continue;
            }
            List<Mannequin> hate2 = ca1araHate(caka3aq2, sp23);
            for ( Mannequin osakajo3 : hate2 ) {
                xaraq3.add(osakajo3.getUniqueId());
            }
            if ( hate2.size() < ku1o.arakap2K2fe() ) {
                continue;
            }
            Location sost2 = sost2A1iqHate(hate2);
            if ( sost2 == null ) {
                continue;
            }
            if ( ka5ikArakap2(sost2, ku1o.hateKa5ik()) ) {
                continue;
            }
            if ( HantamiVepaq.sahaKa5ik(nala2, sost2, 12) ) {
                arakap2.add(sost2);
                continue;
            }
            boolean sp25 = HantamiVepaq.vepaqSaha(nala2, sost2);
            if ( sp25 ) {
                arakap2.add(new Location(nala2, sost2.getBlockX(), sost2.getBlockY(), sost2.getBlockZ()));
                if ( arakap2.size() > 32 ) {
                    arakap2.remove(0);
                }
                daxe.getLogger().info(S2bana.VOP2_ARAKAP2);
            }
        }
    }

    /* ſɟᴜ ſᶘᴜ ɽ͑ʃ'ᴜ ʌ j͑ʃɘɹ */
    private Collection<Mannequin> ca1araSp2(World nala2) {
        List<Mannequin> sp23 = new ArrayList<>();
        for ( UUID ksaka4 : xehate4.keySet() ) {
            Entity fumu = Bukkit.getEntity(ksaka4);
            if ( fumu instanceof Mannequin daxe3 && ! daxe3.isDead() && daxe3.getWorld().equals(nala2) ) {
                sp23.add(daxe3);
            }
        }
        return sp23;
    }

    /* ſɟᴜ ſᶘᴜ ɽ͑ʃ'ᴜ ʌ ֭ſɭᴜ ɭʃɔ */
    private List<Mannequin> ca1araHate(Mannequin caka3aq2, Collection<Mannequin> sp23) {
        List<Mannequin> hate2 = new ArrayList<>();
        hate2.add(caka3aq2);
        double ka5ik24 = ku1o.hateKa5ik() * ku1o.hateKa5ik();
        boolean vepaq2 = true;
        while ( vepaq2 ) {
            vepaq2 = false;
            for ( Mannequin keka5 : sp23 ) {
                if ( hate2.contains(keka5) ) {
                    continue;
                }
                for ( Mannequin osakajo3 : new ArrayList<>(hate2) ) {
                    if ( osakajo3.getLocation().distanceSquared(keka5.getLocation()) <= ka5ik24 ) {
                        hate2.add(keka5);
                        vepaq2 = true;
                        break;
                    }
                }
            }
        }
        return hate2;
    }

    /* j͑ʃɜ j͑ʃƨɹ ʌ ᴜ ſᶘꞇȝ ʌ ֭ſɭᴜ ɭʃɔ */
    private Location sost2A1iqHate(List<Mannequin> hate2) {
        if ( hate2.isEmpty() ) {
            return null;
        }
        World nala2 = hate2.get(0).getWorld();
        double kantoni2 = 0.0D;
        double kantoni3 = 0.0D;
        for ( Mannequin osakajo3 : hate2 ) {
            kantoni2 += osakajo3.getLocation().getX();
            kantoni3 += osakajo3.getLocation().getZ();
        }
        kantoni2 /= hate2.size();
        kantoni3 /= hate2.size();
        return HantamiVepaq.s2rol2miOz(nala2, (int) kantoni2, (int) kantoni3);
    }

    /* ſɭᴜ ſɭˬꞇƽ ʌ ᴜ ɽ͑ʃ'ᴜ ſɭᴜ ſןɹ */
    private boolean ka5ikArakap2(Location sost2, double ka5ik4) {
        double ka5ik24 = ka5ik4 * ka5ik4;
        for ( Location arakap22 : arakap2 ) {
            if ( arakap22.getWorld().equals(sost2.getWorld()) && arakap22.distanceSquared(sost2) < ka5ik24 ) {
                return true;
            }
        }
        return false;
    }

    /* j͑ʃɘɹ ʌ ᴜ ɽ͑ʃ'ᴜ ſɭᴜ ſןɹ */
    public void sp2Arakap2(World nala2) {
        s2rol2miArakap2(nala2);
    }

    /* ֭ſɭɔ }ʃᴜŋ */
    Xehate xehateA1iq(UUID ksaka4) {
        return xehate4.get(ksaka4);
    }

    /* ֭ſɭɔ }ʃᴜŋ */
    public void hena3(Mannequin daxe3, Player maveputas) {
        Xehate xehate3 = xehate4.get(daxe3.getUniqueId());
        if ( xehate3 == null ) {
            xehate3 = sp2Xehate();
            xehate4.put(daxe3.getUniqueId(), xehate3);
        }
        yor22(daxe3, xehate3, maveputas);
    }
}
