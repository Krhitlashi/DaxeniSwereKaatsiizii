package com.nala.komando;

import com.nala.NalaDaxe;
import com.nala.config.S2bana;
import net.kyori.adventure.text.Component;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

// ≺⧼ j͑ʃ'ᴜ j͐ʃw ɭl̀ɹ 📃 ⧽≻


/* j͑ʃ'ᴜ j͐ʃw ɭl̀ɹ */
public class NalaValuj2 implements CommandExecutor, TabCompleter {

    // ⟪ j͑ʃ'ᴜ j͐ʃw ɭl̀ɹ 📃 ⟫

    private final NalaDaxe daxe;

    public NalaValuj2(NalaDaxe daxe) {
        this.daxe = daxe;
    }

    // ⟪ j͑ʃ'ᴜ j͐ʃw ɭl̀ɹ 📃 ⟫


    /* j͑ʃ'ᴜ j͐ʃw ɭl̀ɹ */
    @Override
    public boolean onCommand(CommandSender bana, Command eskek22, String xehate, String[] a10ni4) {
        if ( ! bana.hasPermission("nala.admin") ) {
            bana.sendMessage(Component.text(S2bana.A3OHK2NIK2P2_EK6));
            return true;
        }
        Player hq2 = bana instanceof Player ? (Player) bana : null;
        if ( a10ni4.length == 0 ) {
            if ( hq2 == null ) {
                bana.sendMessage(Component.text(S2bana.VOP2_DAXE_K6H6));
                return true;
            }
            daxe.cafas().veb6kek9(hq2);
            return true;
        }
        String zeni = a10ni4[0].toLowerCase();
        if ( zeni.equals("oku3a") ) {
            if ( hq2 == null ) {
                bana.sendMessage(Component.text(S2bana.A3OHK2NIK2P2_HQ2));
                return true;
            }
            List<World> kxawa7 = daxe.makamaj6fi2().kxawaZeni2(hq2);
            if ( kxawa7.isEmpty() ) {
                hq2.sendMessage(Component.text(S2bana.YOR2_H2L_NALA));
                return true;
            }
            StringBuilder ca1ara3 = new StringBuilder(S2bana.VOP2);
            for ( int k2fe = 0; k2fe < kxawa7.size(); k2fe++ ) {
                if ( k2fe > 0 ) {
                    ca1ara3.append(" , ");
                }
                ca1ara3.append(kxawa7.get(k2fe).getName());
            }
            hq2.sendMessage(Component.text(ca1ara3.toString()));
            return true;
        }
        if ( zeni.equals("au1e") ) {
            Player eskek2 = hq2;
            int pal65 = 0;
            if ( a10ni4.length >= 2 ) {
                Integer k2fe11 = k2fea1iq(a10ni4[1]);
                if ( k2fe11 != null ) {
                    pal65 = k2fe11;
                } else {
                    Player s2rol2mi7 = Bukkit.getPlayer(a10ni4[1]);
                    if ( s2rol2mi7 == null ) {
                        bana.sendMessage(Component.text(S2bana.hq2H2lS2rol2mi(a10ni4[1])));
                        return true;
                    }
                    eskek2 = s2rol2mi7;
                }
            }
            if ( a10ni4.length >= 3 ) {
                Integer k2fe11 = k2fea1iq(a10ni4[2]);
                if ( k2fe11 == null ) {
                    bana.sendMessage(Component.text(S2bana.A3OHK2NIK2P2_K2FE_K2FE));
                    return true;
                }
                pal65 += k2fe11;
            }
            if ( eskek2 == null ) {
                bana.sendMessage(Component.text(S2bana.A3OHK2NIK2P2_VE3AQ_HQ2));
                return true;
            }
            int k2fe13 = 1 + pal65;
            if ( k2fe13 < 1 ) {
                k2fe13 = 1;
            }
            if ( k2fe13 > 64 ) {
                k2fe13 = 64;
            }
            java.util.Map<Integer, ItemStack> hunaq4 = eskek2.getInventory().addItem(daxe.casokfam222().vepaqK2fe(k2fe13));
            for ( ItemStack hunaq10 : hunaq4.values() ) {
                eskek2.getWorld().dropItemNaturally(eskek2.getLocation(), hunaq10);
            }
            bana.sendMessage(Component.text(S2bana.veb6kek8(eskek2.getName())));
            return true;
        }
        if ( zeni.equals("importi") ) {
            if ( a10ni4.length < 2 ) {
                bana.sendMessage(Component.text(S2bana.VOP2_DAXE_Q2Q));
                return true;
            }
            if ( a10ni4.length > 4 ) {
                bana.sendMessage(Component.text(S2bana.VOP2_DAXE_Q2Q));
                return true;
            }
            java.util.Set<String> tara1of2 = java.util.Set.of("NORMAL", "NETHER", "THE_END", "FLAT");
            String fal3aqai = a10ni4[1];
            String ksaka = anis3(fal3aqai);
            String tara1of = null;
            if ( a10ni4.length >= 3 ) {
                if ( tara1of2.contains(a10ni4[2].toUpperCase()) && a10ni4.length == 3 ) {
                    tara1of = a10ni4[2].toUpperCase();
                } else {
                    ksaka = a10ni4[2].toLowerCase();
                }
            }
            if ( a10ni4.length >= 4 ) {
                if ( ! tara1of2.contains(a10ni4[3].toUpperCase()) ) {
                    bana.sendMessage(Component.text(S2bana.A3OHK2NIK2P2_TARA1OF));
                    return true;
                }
                tara1of = a10ni4[3].toUpperCase();
            }
            daxe.makamaj6fi2().q2qNala(bana, fal3aqai, ksaka, tara1of);
            return true;
        }
        if ( zeni.equals("s2tosax") ) {
            daxe.ku1o().vefal();
            daxe.makamaj6fi2().s2rol2miNala();
            bana.sendMessage(Component.text(S2bana.VOP2_Q2Q));
            return true;
        }
        Player kxawa6 = Bukkit.getPlayer(a10ni4[0]);
        if ( kxawa6 != null ) {
            if ( a10ni4.length >= 2 ) {
                World nala2 = Bukkit.getWorld(a10ni4[1]);
                if ( nala2 == null ) {
                    bana.sendMessage(Component.text(S2bana.nalaH2lS2rol2mi(a10ni4[1])));
                    return true;
                }
                if ( nala2.getKey().equals(kxawa6.getWorld().getKey()) ) {
                    bana.sendMessage(Component.text(S2bana.YOR2_GANI_ARAQ));
                    return true;
                }
                daxe.makamaj6fi2().xaraq4(kxawa6, nala2);
                bana.sendMessage(Component.text(S2bana.k6h6Zeni(kxawa6.getName(), nala2.getName())));
                return true;
            }
            daxe.cafas().veb6kek9(kxawa6);
            bana.sendMessage(Component.text(S2bana.ca1araVeb6kek(kxawa6.getName())));
            return true;
        }
        bana.sendMessage(Component.text(S2bana.VOP2_DAXE_PAL6));
        return true;
    }

    /* ſɭɹ ſȷɔ */
    @Override
    public List<String> onTabComplete(CommandSender bana, Command eskek22, String xehate, String[] a10ni4) {
        List<String> a10ni5 = new ArrayList<>();
        if ( ! bana.hasPermission("nala.admin") ) {
            return a10ni5;
        }
        if ( a10ni4.length == 1 ) {
            a10ni5.add("oku3a");
            a10ni5.add("au1e");
            a10ni5.add("importi");
            a10ni5.add("s2tosax");
            for ( Player c2kani5 : Bukkit.getOnlinePlayers() ) {
                a10ni5.add(c2kani5.getName());
            }
            return s2rol2mi6(a10ni5, a10ni4[0]);
        }
        if ( a10ni4.length == 2 ) {
            if ( a10ni4[0].equalsIgnoreCase("importi") ) {
                java.io.File q2qK6h6 = new java.io.File(daxe.getDataFolder(), "import");
                String[] fal3aqai2 = q2qK6h6.list((cakavop2, ksaka) -> new java.io.File(cakavop2, ksaka).isDirectory());
                if ( fal3aqai2 != null ) {
                    for ( String fal3aqai : fal3aqai2 ) {
                        a10ni5.add(fal3aqai);
                    }
                }
                return s2rol2mi6(a10ni5, a10ni4[1]);
            }
            if ( a10ni4[0].equalsIgnoreCase("au1e") ) {
                for ( Player c2kani5 : Bukkit.getOnlinePlayers() ) {
                    a10ni5.add(c2kani5.getName());
                }
                return s2rol2mi6(a10ni5, a10ni4[1]);
            }
            Player kxawa6 = Bukkit.getPlayer(a10ni4[0]);
            if ( kxawa6 != null ) {
                for ( World nala2 : daxe.makamaj6fi2().kxawaZeni2(kxawa6) ) {
                    a10ni5.add(nala2.getName());
                }
                return s2rol2mi6(a10ni5, a10ni4[1]);
            }
        }
        if ( a10ni4.length >= 3 && a10ni4[0].equalsIgnoreCase("importi") ) {
            a10ni5.add("NORMAL");
            a10ni5.add("NETHER");
            a10ni5.add("THE_END");
            a10ni5.add("FLAT");
            return s2rol2mi6(a10ni5, a10ni4[a10ni4.length - 1]);
        }
        return a10ni5;
    }

    /* ᴜ }ʃꞇɔ˞ŋ */
    private String anis3(String s2bana) {
        String anis2 = s2bana.toLowerCase().replaceAll("[^a-z0-9_.-]", "_");
        if ( anis2.isEmpty() ) {
            anis2 = "importita";
        }
        return anis2;
    }

    /* ſɭɹ ſȷɔ ᴜ ſᶘꞇȝ */
    private Integer k2fea1iq(String s2bana) {
        try {
            return Integer.valueOf(s2bana.trim());
        } catch ( NumberFormatException a3ohk2nik2p2 ) {
            return null;
        }
    }

    /* j͑ʃɹ ɽ͑ʃ'ɜ j͐ʃɹ ŋᷠꞇ э */
    private List<String> s2rol2mi6(List<String> ca1ara3, String ruva5) {
        if ( ruva5 == null || ruva5.isEmpty() ) {
            return ca1ara3;
        }
        List<String> a10ni = new ArrayList<>();
        for ( String a10ni9 : ca1ara3 ) {
            if ( a10ni9.toLowerCase().startsWith(ruva5.toLowerCase()) ) {
                a10ni.add(a10ni9);
            }
        }
        return a10ni;
    }
}
