package com.hantami.komando;

import com.hantami.HantamiDaxe;
import com.hantami.config.S2bana;
import com.hantami.mobo.HantamiVepaq;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

// ≺⧼ j͑ʃ'ᴜ j͐ʃw ɭl̀ɹ 📃 ⧽≻


/* j͑ʃ'ᴜ j͐ʃw ɭl̀ɹ */
public class HantamiValuj2 implements CommandExecutor, TabCompleter {

    // ⟪ j͑ʃ'ᴜ j͐ʃw ɭl̀ɹ 📃 ⟫

    private final HantamiDaxe daxe;

    public HantamiValuj2(HantamiDaxe daxe) {
        this.daxe = daxe;
    }

    /* j͑ʃ'ᴜ j͐ʃw ɭl̀ɹ */
    @Override
    public boolean onCommand(CommandSender bana, Command eskek22, String xehate, String[] a10ni4) {
        if ( a10ni4.length == 0 || a10ni4[0].equalsIgnoreCase("fezi") ) {
            bana.sendMessage(S2bana.A41E);
            return true;
        }
        String zeni = a10ni4[0].toLowerCase();
        if ( zeni.equals("s2tosax") ) {
            daxe.ku1o().ts2tosax();
            int ksaka3 = daxe.makamaj6fi2().ts2tosaxVop22();
            bana.sendMessage(String.format(S2bana.TS2TOSAX, ksaka3));
            return true;
        }
        World nala2 = daxe.makamaj6fi2().nala2();
        if ( nala2 == null ) {
            bana.sendMessage(S2bana.A3OHK2NIK2P2_H2L3);
            return true;
        }
        if ( zeni.equals("veseno") ) {
            int k2fe11 = 1;
            if ( a10ni4.length > 1 ) {
                try {
                    k2fe11 = Integer.parseInt(a10ni4[1]);
                } catch ( NumberFormatException a3ohk2nik2p2 ) {
                    bana.sendMessage(S2bana.A3OHK2NIK2P2_K2FE);
                    return true;
                }
            }
            k2fe11 = Math.max(1, Math.min(k2fe11, 24)); // j͑ʃw ſɭʞɹȝ ʌ ſɭэ ֭ſɭэ
            Location k6h6 = sukf2qK6h6(nala2, bana);
            int veb6kek = 0;
            int gani11 = 0;
            for ( int k2fe = 0; k2fe < k2fe11; k2fe++ ) {
                Location veb6kek2 = s2rol2miKa5ikOz(nala2, k6h6);
                if ( veb6kek2 == null ) {
                    continue;
                }
                if ( daxe.makamaj6fi2().q2qVeb6kek(veb6kek2, bana) ) {
                    veb6kek++;
                } else {
                    gani11++;
                }
            }
            if ( veb6kek > 0 ) {
                bana.sendMessage(String.format(S2bana.Q2Q, veb6kek));
            }
            if ( gani11 > 0 ) {
                bana.sendMessage(S2bana.H2L2);
            }
            return true;
        }
        if ( zeni.equals("soto") ) {
            daxe.makamaj6fi2().sp2Arakap2(nala2);
            bana.sendMessage(S2bana.VOP2_VALUJ2);
            return true;
        }
        if ( zeni.equals("h2l") ) {
            int h2l9 = daxe.makamaj6fi2().anis3(nala2);
            bana.sendMessage(String.format(S2bana.VEB6KEK2, h2l9));
            return true;
        }
        bana.sendMessage(S2bana.A41E);
        return true;
    }

    /* j͑ʃw ſɭʞɹȝ ʌ ſɭэ ֭ſɭэ */
    private Location sukf2qK6h6(World nala2, CommandSender bana) {
        if ( bana instanceof Player hq2 && hq2.getWorld().equals(nala2) ) {
            return hq2.getLocation();
        }
        return nala2.getSpawnLocation();
    }

    /* j͑ʃɹ ɽ͑ʃ'ɜ j͐ʃɹ ŋᷠꞇ ʌ ſɭᴜ ſɭˬꞇƽ ʌ ꞁȷ̀ɜƴ */
    private Location s2rol2miKa5ikOz(World nala2, Location k6h6) {
        int k6h6Kantoni = k6h6.getBlockX();
        int k6h6Kantoni3 = k6h6.getBlockZ();
        int[] ka5ik = new int[] { 0, 4, 8, 12, 16, 20, 24 }; // ſɭɹ ſȷɔ
        for ( int ka5ik2 : ka5ik ) {
            if ( ka5ik2 == 0 ) {
                Location oz = HantamiVepaq.s2rol2miOz(nala2, k6h6Kantoni, k6h6Kantoni3);
                if ( oz != null ) {
                    return oz;
                }
                continue;
            }
            for ( int k2fe3 = 0; k2fe3 < 8; k2fe3++ ) {
                double kantoni = k2fe3 * Math.PI / 4.0D;
                Location oz = HantamiVepaq.s2rol2miOz(nala2, k6h6Kantoni + (int) ( Math.cos(kantoni) * ka5ik2 ), k6h6Kantoni3 + (int) ( Math.sin(kantoni) * ka5ik2 ));
                if ( oz != null ) {
                    return oz;
                }
            }
        }
        return null;
    }

    /* ſɭɹ ſȷɔ */
    @Override
    public List<String> onTabComplete(CommandSender bana, Command eskek22, String xehate, String[] a10ni4) {
        List<String> a10ni5 = new ArrayList<>();
        if ( a10ni4.length == 1 ) {
            String[] a10ni6 = new String[] { "fezi", "veseno", "soto", "h2l", "s2tosax" };
            for ( String a10ni7 : a10ni6 ) {
                if ( a10ni7.startsWith(a10ni4[0].toLowerCase()) ) {
                    a10ni5.add(a10ni7);
                }
            }
        }
        return a10ni5;
    }
}
