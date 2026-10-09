package com.hantami.komando;

import com.hantami.HantamiPlugin;
import com.hantami.config.Mesagoj;
import com.hantami.mobo.HantamiKonstruanto;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

// ≺⧼ ពាក្យបញ្ជា 📃 ⧽≻
// គ្រប់គ្រងប្រជាជន Hantami

/* ពាក្យបញ្ជាសម្រាប់បង្កើត ភូមិ លុប និងផ្ទុកឡើងវិញ
    @param kromprogramo ( HantamiPlugin , មិនមែន null ) - កម្មវិធីជំនួយចម្បង
    @returns ពាក្យបញ្ជាថ្មី */
public class HantamiKomando implements CommandExecutor, TabCompleter {

    // ⟪ Datumoj 📃 ⟫
    // ឯកសារយោងកម្មវិធី
    private final HantamiPlugin kromprogramo;

    public HantamiKomando(HantamiPlugin kromprogramo) {
        this.kromprogramo = kromprogramo;
    }

    /* អនុវត្តអនុពាក្យបញ្ជា hantami
        @param sendanto ( CommandSender , មិនមែន null ) - អ្នកផ្ញើពាក្យបញ្ជា
        @param komando ( Command , មិនមែន null ) - ពាក្យបញ្ជាខ្លួនឯង
        @param etikedo ( String , មិនមែន null ) - ស្លាកដែលប្រើ
        @param argumentoj ( String[] , មិនមែន null ) - អាគុយម៉ង់
        @returns True នៅពេលដោះស្រាយរួច */
    @Override
    public boolean onCommand(CommandSender sendanto, Command komando, String etikedo, String[] argumentoj) {
        if ( argumentoj.length == 0 || argumentoj[0].equalsIgnoreCase("fezi") ) {
            sendanto.sendMessage(Mesagoj.HELPO);
            return true;
        }
        String ago = argumentoj[0].toLowerCase();
        if ( ago.equals("s2tosax") ) {
            kromprogramo.agordo().ŝargi();
            int nomoj = kromprogramo.administranto().reŝargiDatumbazon();
            sendanto.sendMessage(String.format(Mesagoj.RESXARGITA, nomoj));
            return true;
        }
        World mondo = kromprogramo.administranto().mondo();
        if ( mondo == null ) {
            sendanto.sendMessage(Mesagoj.ERARO_SENMONDO);
            return true;
        }
        if ( ago.equals("veseno") ) {
            int nombro = 1; // 0o1
            if ( argumentoj.length > 1 ) {
                try {
                    nombro = Integer.parseInt(argumentoj[1]);
                } catch ( NumberFormatException eraro ) {
                    sendanto.sendMessage(Mesagoj.ERARO_NOMBRO);
                    return true;
                }
            }
            nombro = Math.max(1, Math.min(nombro, 24)); // 0o1 ĝis 0o30
            Location bazo = elektiBazon(mondo, sendanto);
            int naskitaj = 0;
            int atendataj = 0;
            for ( int i = 0; i < nombro; i++ ) {
                Location nasko = troviApudanTeron(mondo, bazo);
                if ( nasko == null ) {
                    continue;
                }
                if ( kromprogramo.administranto().petiNaskon(nasko, sendanto) ) {
                    naskitaj++;
                } else {
                    atendataj++;
                }
            }
            if ( naskitaj > 0 ) {
                sendanto.sendMessage(String.format(Mesagoj.PETITAJ, naskitaj));
            }
            if ( atendataj > 0 ) {
                sendanto.sendMessage(Mesagoj.ATENDU);
            }
            return true;
        }
        if ( ago.equals("soto") ) {
            kromprogramo.administranto().vekiVilagxon(mondo);
            sendanto.sendMessage(Mesagoj.SOTOJ);
            return true;
        }
        if ( ago.equals("h2l") ) {
            int forigitaj = kromprogramo.administranto().purigi(mondo);
            sendanto.sendMessage(String.format(Mesagoj.FORIGITAJ, forigitaj));
            return true;
        }
        sendanto.sendMessage(Mesagoj.HELPO);
        return true;
    }

    /* ជ្រើសរើសចំណុចគោលជុំវិញអ្នកផ្ញើឬកន្លែងកំណើត
        @param mondo ( World , មិនមែន null ) - ពិភពលោកគោលដៅ
        @param sendanto ( CommandSender , មិនមែន null ) - អ្នកផ្ញើពាក្យបញ្ជា
        @returns ទីតាំងគោល */
    private Location elektiBazon(World mondo, CommandSender sendanto) {
        if ( sendanto instanceof Player ludanto && ludanto.getWorld().equals(mondo) ) {
            return ludanto.getLocation();
        }
        return mondo.getSpawnLocation();
    }

    /* ស្វែងរកដីសុវត្ថិភាពពីជិតបំផុតទៅគោល
        @param mondo ( World , មិនមែន null ) - ពិភពលោកគោលដៅ
        @param bazo ( Location , មិនមែន null ) - ចំណុចចាប់ផ្តើម
        @returns ទីតាំងដី ឬ null */
    private Location troviApudanTeron(World mondo, Location bazo) {
        int bx = bazo.getBlockX();
        int bz = bazo.getBlockZ();
        int[] radiusoj = new int[] { 0, 4, 8, 12, 16, 20, 24 }; // 0o0 ĝis 0o30
        for ( int r : radiusoj ) {
            if ( r == 0 ) {
                Location tereno = HantamiKonstruanto.troviTeron(mondo, bx, bz);
                if ( tereno != null ) {
                    return tereno;
                }
                continue;
            }
            for ( int k = 0; k < 8; k++ ) { // 0o10
                double angulo = k * Math.PI / 4.0D;
                Location tereno = HantamiKonstruanto.troviTeron(mondo, bx + (int) ( Math.cos(angulo) * r ), bz + (int) ( Math.sin(angulo) * r ));
                if ( tereno != null ) {
                    return tereno;
                }
            }
        }
        return null;
    }

    /* ផ្តល់យោបល់អនុពាក្យបញ្ជា
        @param sendanto ( CommandSender , មិនមែន null ) - អ្នកផ្ញើពាក្យបញ្ជា
        @param komando ( Command , មិនមែន null ) - ពាក្យបញ្ជាខ្លួនឯង
        @param etikedo ( String , មិនមែន null ) - ស្លាកដែលប្រើ
        @param argumentoj ( String[] , មិនមែន null ) - អាគុយម៉ង់
        @returns បញ្ជីយោបល់ */
    @Override
    public List<String> onTabComplete(CommandSender sendanto, Command komando, String etikedo, String[] argumentoj) {
        List<String> proponoj = new ArrayList<>();
        if ( argumentoj.length == 1 ) {
            String[] ebloj = new String[] { "fezi", "veseno", "soto", "h2l", "s2tosax" };
            for ( String eblo : ebloj ) {
                if ( eblo.startsWith(argumentoj[0].toLowerCase()) ) {
                    proponoj.add(eblo);
                }
            }
        }
        return proponoj;
    }
}
