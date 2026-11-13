package com.nala.portalo;

import com.nala.NalaDaxe;
import com.nala.config.Ku1o;
import com.nala.config.S2bana;
import net.kyori.adventure.text.Component;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

// ≺⧼ ŋᷠᴜ ſɭᴜ ŋᷠᴜ ɭl̀э ſȷꞇ 📃 ⧽≻


/* ŋᷠᴜ ſɭᴜ ŋᷠᴜ ɭl̀э ſȷꞇ */
public class NalaMakamaj6fi {

    // ⟪ ɭʃᴜ̭ᴜȝ ʌ j͑ʃ'ɜ ſןɹ 📃 ⟫

    private final NalaDaxe daxe;
    private final Map<UUID, Set<UUID>> bana2 = new HashMap<>();

    public NalaMakamaj6fi(NalaDaxe daxe) {
        this.daxe = daxe;
    }

    /* ɭʃᴜ̭ᴜȝ ʌ j͑ʃ'ɜ ſןɹ */
    private record TcaqVop2(String ruva6, byte[] kp6taf) {
    }

    // ⟪ j͑ʃɹ ɽ͑ʃ'ɜ j͐ʃɹ ŋᷠꞇ ʌ }ʃᴜ j͐ʃᴜ 📃 ⟫


    /* j͑ʃɹ ɽ͑ʃ'ɜ j͐ʃɹ ŋᷠꞇ ʌ }ʃᴜ j͐ʃᴜ */
    public void s2rol2miNala() {
        for ( Ku1o.NalaVeb6kek veb6kek7 : daxe.ku1o().nala4() ) {
            s2rol2miK2fe2(veb6kek7);
        }
    }

    /* j͑ʃɹ ɽ͑ʃ'ɜ j͐ʃɹ ŋᷠꞇ ʌ ſɭɹ ſȷɔ ɹ */
    public World s2rol2miK2fe2(Ku1o.NalaVeb6kek veb6kek7) {
        String ksaka = veb6kek7.ksaka();
        World sp27 = Bukkit.getWorld(ksaka);
        if ( sp27 != null ) {
            return sp27;
        }
        try {
            WorldCreator vepaq4 = WorldCreator.ofKey(NamespacedKey.minecraft(ksaka));
            vepaq4.environment(tara1ofA1iq(veb6kek7.tara1of()));
            if ( veb6kek7.tara1of().equals("FLAT") ) {
                vepaq4.type(WorldType.FLAT);
            } else {
                vepaq4.type(WorldType.NORMAL);
            }
            if ( veb6kek7.cuk() != 0L ) {
                vepaq4.seed(veb6kek7.cuk());
            }
            String s2rol2mi5 = veb6kek7.s2rol2mi5();
            if ( s2rol2mi5 != null && ! s2rol2mi5.trim().isEmpty() ) {
                String anis2 = s2rol2mi5.trim();
                String s2rol2miKsaka = anis2;
                int ka5ik8 = anis2.indexOf(":");
                if ( ka5ik8 > 0 ) {
                    s2rol2miKsaka = anis2.substring(0, ka5ik8);
                }
                Plugin s2rol2mi8 = Bukkit.getPluginManager().getPlugin(s2rol2miKsaka);
                if ( s2rol2mi8 != null && s2rol2mi8.isEnabled() ) {
                    vepaq4.generator(anis2);
                    daxe.getLogger().info(S2bana.K2F_S2ROL2MI + S2bana.nala2(ksaka) + " " + anis2 + " ⟅");
                } else {
                    daxe.getLogger().warning(S2bana.YOR2_S2ROL2MI_H2L + S2bana.nala2(ksaka) + " " + anis2 + " ⟅");
                }
            }
            vepaq4.generateStructures(false);
            World nala2 = vepaq4.createWorld();
            if ( nala2 != null ) {
                daxe.getLogger().info(S2bana.K2F_NALA_SP2 + S2bana.nala2(ksaka) + " ⟅");
                veb6kekVop2(veb6kek7, nala2);
            }
            return nala2;
        } catch ( Exception a3ohk2nik2p2 ) {
            daxe.getLogger().warning(S2bana.A3OHK2NIK2P2_VEPAQ_NALA + S2bana.nala2(ksaka) + " " + a3ohk2nik2p2.getMessage() + " ⟅");
            return null;
        }
    }

    // ⟪ j͑ʃ'ɔ ʃэ ſɭɔƽ ʌ j͑ʃ'ɜ ſןɹ 📃 ⟫


    /* j͑ʃ'ɔ ʃэ ſɭɔƽ ʌ j͑ʃ'ɜ ſןɹ */
    private void veb6kekVop2(Ku1o.NalaVeb6kek veb6kek7, World nala2) {
        if ( veb6kek7.vop24() == null || veb6kek7.vop24().isEmpty() ) {
            return;
        }
        File a1iqK6h6 = new File(daxe.getDataFolder(), "datumpako");
        File l6daK6h6 = l6daFal3aqai(nala2);
        if ( l6daK6h6 == null ) {
            daxe.getLogger().warning(S2bana.A3OHK2NIK2P2_L6DA_FAL3AQAI + S2bana.nala2(veb6kek7.ksaka()) + " ⟅");
            return;
        }
        File kxawaK6h6 = new File(l6daK6h6, "datapacks");
        kxawaK6h6.mkdirs();
        for ( String tcaq : veb6kek7.vop24() ) {
            if ( tcaq == null ) {
                continue;
            }
            String anis2 = tcaq.trim();
            if ( ! anis2.matches("[A-Za-z0-9_.-]+") ) {
                daxe.getLogger().warning(S2bana.A3OHK2NIK2P2_H2L_ANIS_TCAQ_KSAKA + anis2 + " ⟅");
                continue;
            }
            File a1iq = new File(a1iqK6h6, anis2);
            File kxawa = new File(kxawaK6h6, anis2);
            if ( ! a1iq.exists() ) {
                daxe.getLogger().warning(S2bana.YOR2_VOP2_TCAQ_H2L + anis2 + " ⟅");
                continue;
            }
            if ( kxawa.exists() ) {
                continue;
            }
            try {
                if ( a1iq.isDirectory() ) {
                    cutaK2fe(a1iq.toPath(), kxawa.toPath());
                } else {
                    Files.createDirectories(kxawa.getParentFile().toPath());
                    Files.copy(a1iq.toPath(), kxawa.toPath());
                }
                daxe.getLogger().info(S2bana.K2F_VOP2_TCAQ + anis2 + " ⟅");
            } catch ( Exception a3ohk2nik2p2 ) {
                daxe.getLogger().warning(S2bana.A3OHK2NIK2P2_VOP2 + anis2 + " ⟅");
            }
        }
    }

    /* ſɭэ ֭ſɭэ */
    private File l6daFal3aqai(World nala2) {
        File k6h6 = nala2.getWorldFolder();
        int l6da4 = 0;
        while ( k6h6 != null && l6da4 < 8 ) {
            if ( new File(k6h6, "level.dat").isFile() ) {
                return k6h6;
            }
            k6h6 = k6h6.getParentFile();
            l6da4++;
        }
        return null;
    }

    /* ſɟw ɭʃᴜ ʌ ſɭɹ ſȷɔ */
    private void cutaK2fe(Path a1iq, Path kxawa) throws Exception {
        Set<String> yor24 = Set.of("session.lock", "level.dat", "level.dat_old");
        Files.walk(a1iq).forEach(a1iqK6h62 -> {
            try {
                if ( yor24.contains(a1iqK6h62.getFileName().toString()) ) {
                    return;
                }
                Path kxawaK6h62 = kxawa.resolve(a1iq.relativize(a1iqK6h62));
                if ( Files.isDirectory(a1iqK6h62) ) {
                    Files.createDirectories(kxawaK6h62);
                } else {
                    Files.createDirectories(kxawaK6h62.getParent());
                    Files.copy(a1iqK6h62, kxawaK6h62, StandardCopyOption.REPLACE_EXISTING);
                }
            } catch ( Exception a3ohk2nik2p2 ) {
                throw new RuntimeException(a3ohk2nik2p2);
            }
        });
    }

    /* ɭʃᴜ ɽ͑ʃ'ᴜ ſᶘɜʞ ʌ ᴜ ſᶘꞇȝ */
    private World.Environment tara1ofA1iq(String ksaka) {
        if ( ksaka.equals("NETHER") ) {
            return World.Environment.NETHER;
        }
        if ( ksaka.equals("THE_END") ) {
            return World.Environment.THE_END;
        }
        return World.Environment.NORMAL;
    }

    // ⟪ ſ͕ɭɹȝ ʌ }ʃᴜ j͐ʃᴜ 📃 ⟫


    /* ſ͕ɭɹȝ ʌ }ʃᴜ j͐ʃᴜ */
    public void q2qNala(CommandSender bana, String fal3aqai, String ksaka, String tara1of) {
        Set<String> tara1of2 = Set.of("NORMAL", "NETHER", "THE_END", "FLAT");
        if ( tara1of != null && ! tara1of2.contains(tara1of) ) {
            bana.sendMessage(Component.text(S2bana.A3OHK2NIK2P2_TARA1OF));
            return;
        }
        if ( ! ksaka.matches("[a-z0-9_.-]+") ) {
            bana.sendMessage(Component.text(S2bana.A3OHK2NIK2P2_KSAKA));
            return;
        }
        File a1iq = new File(new File(daxe.getDataFolder(), "import"), fal3aqai);
        if ( ! a1iq.isDirectory() ) {
            bana.sendMessage(Component.text(S2bana.A3OHK2NIK2P2_VEPAQ_FAL3AQAI));
            return;
        }
        if ( Bukkit.getWorld(ksaka) != null ) {
            bana.sendMessage(Component.text(S2bana.A3OHK2NIK2P2_GANI_TS2TOSAX));
            return;
        }
        File kxawa = kxawaFal3aqai(ksaka);
        if ( kxawa == null ) {
            bana.sendMessage(Component.text(S2bana.A3OHK2NIK2P2_NALA));
            return;
        }
        if ( new File(kxawa, "region").isDirectory() ) {
            bana.sendMessage(Component.text(S2bana.A3OHK2NIK2P2_ARAQ));
            return;
        }
        File a1iqCaka3aq;
        boolean osakajo4 = tara1of == null;
        String anisTara1of = osakajo4 ? osakajoTara1of(a1iq) : tara1of;
        if ( osakajo4 ) {
            bana.sendMessage(Component.text(S2bana.VOP2_OSAKAJO + anisTara1of + " ⟅"));
        }
        a1iqCaka3aq = s2rol2mi1iq(a1iq, anisTara1of);
        if ( a1iqCaka3aq == null ) {
            bana.sendMessage(Component.text(S2bana.A3OHK2NIK2P2_H2L_ARAQ));
            return;
        }
        bana.sendMessage(Component.text(S2bana.VOP2_CUTA));
        Bukkit.getScheduler().runTaskAsynchronously(daxe, () -> {
            try {
                cutaNala(a1iqCaka3aq, kxawa);
            } catch ( Exception a3ohk2nik2p2 ) {
                Bukkit.getScheduler().runTask(daxe, () -> bana.sendMessage(Component.text(S2bana.A3OHK2NIK2P2_CUTA + a3ohk2nik2p2.getMessage() + " ⟅")));
                return;
            }
            Bukkit.getScheduler().runTask(daxe, () -> {
                daxe.ku1o().a41eNala(ksaka, anisTara1of);
                World nala2 = s2rol2miK2fe2(new Ku1o.NalaVeb6kek(ksaka, anisTara1of, 0L));
                if ( nala2 != null ) {
                    bana.sendMessage(Component.text(S2bana.VOP2_VEFAL + S2bana.nala2(ksaka) + " ⟅"));
                } else {
                    bana.sendMessage(Component.text(S2bana.A3OHK2NIK2P2_VOP2));
                }
            });
        });
    }

    /* ɜ j͑ʃᴜ ſɭᴜ ɭl̀ɜ ʌ ɭʃᴜ ɽ͑ʃ'ᴜ ſᶘɜʞ */
    private String osakajoTara1of(File a1iq) {
        boolean xehateNala = new File(a1iq, "dimensions/minecraft/overworld/region").isDirectory() || new File(a1iq, "region").isDirectory();
        boolean xehateHunaq3 = new File(a1iq, "dimensions/minecraft/the_nether/region").isDirectory() || new File(a1iq, "DIM-1/region").isDirectory();
        boolean xehateHunaq4 = new File(a1iq, "dimensions/minecraft/the_end/region").isDirectory() || new File(a1iq, "DIM1/region").isDirectory();
        if ( ! xehateNala && xehateHunaq3 && ! xehateHunaq4 ) {
            return "NETHER";
        }
        if ( ! xehateNala && ! xehateHunaq3 && xehateHunaq4 ) {
            return "THE_END";
        }
        return "NORMAL";
    }

    /* ſɭэ ֭ſɭэ */
    private File kxawaFal3aqai(String ksaka) {
        World nala5 = null;
        for ( World nala2 : Bukkit.getWorlds() ) {
            if ( nala2.getKey().getKey().equals("overworld") ) {
                nala5 = nala2;
                break;
            }
        }
        if ( nala5 == null && ! Bukkit.getWorlds().isEmpty() ) {
            nala5 = Bukkit.getWorlds().get(0);
        }
        if ( nala5 == null ) {
            return null;
        }
        File k6h6 = nala5.getWorldFolder();
        if ( k6h6.getName().equals("overworld") && k6h6.getParentFile() != null ) {
            k6h6 = k6h6.getParentFile();
        } else {
            k6h6 = new File(k6h6, "dimensions/minecraft");
        }
        return new File(k6h6, ksaka);
    }

    /* j͑ʃɹ ɽ͑ʃ'ɜ j͐ʃɹ ŋᷠꞇ ſᶘꞇȝ */
    private File s2rol2mi1iq(File a1iq, String tara1of) {
        String kantoni13;
        if ( tara1of.equals("NETHER") ) {
            kantoni13 = "the_nether";
        } else if ( tara1of.equals("THE_END") ) {
            kantoni13 = "the_end";
        } else {
            kantoni13 = "overworld";
        }
        File sp26 = new File(a1iq, "dimensions/minecraft/" + kantoni13);
        if ( new File(sp26, "region").isDirectory() ) {
            return sp26;
        }
        if ( tara1of.equals("NETHER") ) {
            File hunaq2 = new File(a1iq, "DIM-1");
            if ( new File(hunaq2, "region").isDirectory() ) {
                return hunaq2;
            }
        }
        if ( tara1of.equals("THE_END") ) {
            File hunaq2 = new File(a1iq, "DIM1");
            if ( new File(hunaq2, "region").isDirectory() ) {
                return hunaq2;
            }
        }
        if ( new File(a1iq, "region").isDirectory() ) {
            return a1iq;
        }
        return null;
    }

    /* ſɟw ɭʃᴜ ʌ }ʃᴜ j͐ʃᴜ */
    private void cutaNala(File a1iq, File kxawa) throws Exception {
        String[] cuta = new String[] { "region", "entities", "poi", "data" };
        Set<String> yor24 = Set.of("session.lock", "level.dat", "level.dat_old");
        for ( String ksaka : cuta ) {
            File kantoni1iq = new File(a1iq, ksaka);
            if ( ! kantoni1iq.isDirectory() ) {
                continue;
            }
            Path caka3aq2 = kantoni1iq.toPath();
            Files.walk(caka3aq2).forEach(a1iqK6h62 -> {
                try {
                    if ( yor24.contains(a1iqK6h62.getFileName().toString()) ) {
                        return;
                    }
                    Path kxawaK6h62 = new File(kxawa, ksaka).toPath().resolve(caka3aq2.relativize(a1iqK6h62));
                    if ( Files.isDirectory(a1iqK6h62) ) {
                        Files.createDirectories(kxawaK6h62);
                    } else {
                        Files.createDirectories(kxawaK6h62.getParent());
                        Files.copy(a1iqK6h62, kxawaK6h62, StandardCopyOption.REPLACE_EXISTING);
                    }
                } catch ( Exception a3ohk2nik2p2 ) {
                    throw new RuntimeException(a3ohk2nik2p2);
                }
            });
        }
    }

    // ⟪ ſɭᶗ‹ᴜ ᶅſᴜ ʌ ſɭ,ɔ }ʃꞇ ɹ 📃 ⟫


    /* ſɭᶗ‹ᴜ ᶅſᴜ ʌ ſɭ,ɔ }ʃꞇ ɹ */
    public List<World> kxawaZeni2(Player hq2) {
        World gani14 = hq2.getWorld();
        List<World> kxawa7 = new ArrayList<>();
        for ( World nala2 : Bukkit.getWorlds() ) {
            if ( nala2.getKey().equals(gani14.getKey()) ) {
                continue;
            }
            if ( xehateSp2HunaqC2kaniH2l(nala2) && ( ! daxe.ku1o().l6daHunaqH2l() ) ) {
                continue;
            }
            kxawa7.add(nala2);
        }
        return kxawa7;
    }

    /* ı],ɔ ֭ſɭᴜ ɭʃɔ ʌ j͑ʃɘɹ ʌ ֭ſɭw }ʃᴜȝ ʌ ſɟɹ ſɭᴜ }ʃꞇ ʌ ֭ſɭɹͷ̗ */
    private boolean xehateSp2HunaqC2kaniH2l(World nala2) {
        World.Environment tara1of = nala2.getEnvironment();
        if ( tara1of != World.Environment.NETHER && tara1of != World.Environment.THE_END ) {
            return false;
        }
        String ca3aq = nala2.getKey().getKey();
        return ca3aq.equals("the_nether") || ca3aq.equals("the_end");
    }

    // ⟪ ı],ᴜ ɽ͑ʃ'ᴜ ſ͕ɭэⅎ 📃 ⟫


    /* ı],ᴜ ɽ͑ʃ'ᴜ ſ͕ɭэⅎ */
    public boolean xaraq4(Player hq2, World kxawa) {
        daxe.araq7().ksaka7(hq2);
        Location hunaq11 = daxe.araq7().hunaqAraq2(hq2, kxawa);
        if ( hunaq11 != null ) {
            hq2.teleportAsync(hunaq11).thenAccept(a10ni -> {
                if ( a10ni ) {
                    hq2.sendMessage(Component.text(S2bana.anis4(kxawa.getName())));
                    c2kaniTcaqtcaq(hq2, kxawa);
                } else {
                    hq2.sendMessage(Component.text(S2bana.A3OHK2NIK2P2_VE3AQ_HQ2));
                }
            });
            return true;
        }
        boolean eskek3 = daxe.casokfam222().eskekCasokfam2(kxawa);
        Location xaraq5 = daxe.casokfam222().s2rol2miC2kaniVepaq(kxawa);
        hq2.teleportAsync(xaraq5).thenAccept(a10ni -> {
            if ( a10ni ) {
                hq2.sendMessage(Component.text(S2bana.anis4(kxawa.getName())));
                if ( ! eskek3 ) {
                    hq2.sendMessage(Component.text(S2bana.YOR2_H2L_CASOKFAM2));
                }
                c2kaniTcaqtcaq(hq2, kxawa);
            } else {
                hq2.sendMessage(Component.text(S2bana.A3OHK2NIK2P2_VE3AQ_HQ2));
            }
        });
        return true;
    }

    // ⟪ ſɟɹ ſɭᴜ }ʃꞇ ʌ ɭʃᴜ̭ᴜ ſ͕ɭƨᴜ̭ᴜȝ 📃 ⟫


    /* ſɟɹ ſɭᴜ }ʃꞇ ʌ ɭʃᴜ̭ᴜ ſ͕ɭƨᴜ̭ᴜȝ */
    private void c2kaniTcaqtcaq(Player hq2, World kxawa) {
        Ku1o.NalaVeb6kek veb6kek7 = daxe.ku1o().s2rol2mi4(kxawa.getName());
        if ( veb6kek7 == null ) {
            veb6kek7 = daxe.ku1o().s2rol2mi4(kxawa.getKey().getKey());
        }
        Map<UUID, TcaqVop2> dezirataj = new LinkedHashMap<>();
        if ( veb6kek7 != null && veb6kek7.tcaqtcaq() != null ) {
            for ( String a10ni9 : veb6kek7.tcaqtcaq() ) {
                if ( a10ni9 == null ) {
                    continue;
                }
                String anis2 = a10ni9.trim();
                if ( anis2.isEmpty() ) {
                    continue;
                }
                String ruva6 = daxe.hate3().ruvaZeni(anis2);
                if ( ruva6.isEmpty() ) {
                    continue;
                }
                UUID ksaka9 = UUID.nameUUIDFromBytes(("nala:" + ruva6).getBytes(StandardCharsets.UTF_8));
                if ( dezirataj.containsKey(ksaka9) ) {
                    continue;
                }
                byte[] kp6taf = null;
                if ( ! anis2.startsWith("http") ) {
                    kp6taf = daxe.hate3().kp6tafZeni(new File(daxe.hate3().k6h6(), anis2));
                }
                dezirataj.put(ksaka9, new TcaqVop2(ruva6, kp6taf));
            }
        }
        Set<UUID> eskek4 = bana2.getOrDefault(hq2.getUniqueId(), Set.of());
        Set<UUID> h2l19 = new HashSet<>(eskek4);
        h2l19.removeAll(dezirataj.keySet());
        for ( UUID ksaka9 : h2l19 ) {
            try {
                hq2.removeResourcePack(ksaka9);
            } catch ( Exception a3ohk2nik2p2 ) {
                daxe.getLogger().warning(S2bana.YOR2_TCAQTCAQ_H2L);
            }
        }
        Set<UUID> a41e5 = new HashSet<>(dezirataj.keySet());
        a41e5.removeAll(eskek4);
        for ( UUID ksaka9 : a41e5 ) {
            TcaqVop2 vop2 = dezirataj.get(ksaka9);
            try {
                hq2.addResourcePack(ksaka9, vop2.ruva6(), vop2.kp6taf(), null, false);
            } catch ( Exception a3ohk2nik2p2 ) {
                hq2.sendMessage(Component.text(S2bana.YOR2_TCAQTCAQ_H2L2));
            }
        }
        if ( dezirataj.isEmpty() ) {
            bana2.remove(hq2.getUniqueId());
        } else {
            bana2.put(hq2.getUniqueId(), new HashSet<>(dezirataj.keySet()));
        }
    }
}
