package com.nala.komando;

import com.nala.NalaPlugin;
import com.nala.config.Mesagoj;
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

// ≺⧼ ពាក្យបញ្ជា Nala 📃 ⧽≻
// បញ្ជាធ្វើដំណើរ

/* ដំណើរការម៉ឺនុយ /nala និងការធ្វើដំណើរដោយផ្ទាល់
    @param kromprogramo ( NalaPlugin , មិនមែន null ) - កម្មវិធីជំនួយចម្បង
    @returns ពាក្យបញ្ជាថ្មី */
public class NalaKomando implements CommandExecutor, TabCompleter {

    // ⟪ ទិន្នន័យកម្មវិធី 📃 ⟫
    // ឯកសារយោងកម្មវិធី
    private final NalaPlugin kromprogramo;

    public NalaKomando(NalaPlugin kromprogramo) {
        this.kromprogramo = kromprogramo;
    }

    // ⟪ ប្រតិបត្តិ 📃 ⟫
    // ការប្រតិបត្តិពាក្យបញ្ជា

    /* ដំណើរការ /nala សម្រាប់តែអ្នកគ្រប់គ្រង និងគោលដៅជាអ្នកលេង
        @param sendanto ( CommandSender , មិនមែន null ) - អ្នកផ្ញើពាក្យបញ្ជា
        @param komando ( Command , មិនមែន null ) - ពាក្យបញ្ជា
        @param etikedo ( String , មិនមែន null ) - ស្លាកដែលបានប្រើ
        @param argumentoj ( String[] , មិនមែន null ) - អាគុយម៉ង់
        @returns ពិតប្រសិនបើបានដំណើរការ */
    @Override
    public boolean onCommand(CommandSender sendanto, Command komando, String etikedo, String[] argumentoj) {
        if ( ! sendanto.hasPermission("nala.admin") ) {
            sendanto.sendMessage(Component.text(Mesagoj.ERARO_PERMESO));
            return true;
        }
        Player ludanto = sendanto instanceof Player ? (Player) sendanto : null;
        if ( argumentoj.length == 0 ) {
            if ( ludanto == null ) {
                sendanto.sendMessage(Component.text(Mesagoj.INFO_UZO_BAZA));
                return true;
            }
            kromprogramo.gui().malfermi(ludanto);
            return true;
        }
        String ago = argumentoj[0].toLowerCase();
        if ( ago.equals("oku3a") ) {
            if ( ludanto == null ) {
                sendanto.sendMessage(Component.text(Mesagoj.ERARO_NUR_LUDANTOJ));
                return true;
            }
            List<World> celoj = kromprogramo.administranto().celojPor(ludanto);
            if ( celoj.isEmpty() ) {
                ludanto.sendMessage(Component.text(Mesagoj.AVERTO_NENIU_MONDO));
                return true;
            }
            StringBuilder listo = new StringBuilder(Mesagoj.INFO);
            for ( int i = 0; i < celoj.size(); i++ ) {
                if ( i > 0 ) {
                    listo.append(" , ");
                }
                listo.append(celoj.get(i).getName());
            }
            ludanto.sendMessage(Component.text(listo.toString()));
            return true;
        }
        if ( ago.equals("au1e") ) {
            Player ricevanto = ludanto;
            int ekstra = 0;
            if ( argumentoj.length >= 2 ) {
                Integer nombro = nombroEl(argumentoj[1]);
                if ( nombro != null ) {
                    ekstra = nombro;
                } else {
                    Player trovita = Bukkit.getPlayer(argumentoj[1]);
                    if ( trovita == null ) {
                        sendanto.sendMessage(Component.text(Mesagoj.ludantoNeTrovita(argumentoj[1])));
                        return true;
                    }
                    ricevanto = trovita;
                }
            }
            if ( argumentoj.length >= 3 ) {
                Integer nombro = nombroEl(argumentoj[2]);
                if ( nombro == null ) {
                    sendanto.sendMessage(Component.text(Mesagoj.ERARO_KVANTO_NOMBRO));
                    return true;
                }
                ekstra += nombro;
            }
            if ( ricevanto == null ) {
                sendanto.sendMessage(Component.text(Mesagoj.ERARO_TENU_LUDANTON));
                return true;
            }
            int kvanto = 1 + ekstra;
            if ( kvanto < 1 ) {
                kvanto = 1;
            }
            if ( kvanto > 64 ) { // 0o100
                kvanto = 64; // 0o100
            }
            java.util.Map<Integer, ItemStack> resto = ricevanto.getInventory().addItem(kromprogramo.portalo().kreiObjekton(kvanto));
            for ( ItemStack restanta : resto.values() ) {
                ricevanto.getWorld().dropItemNaturally(ricevanto.getLocation(), restanta);
            }
            sendanto.sendMessage(Component.text(Mesagoj.donita(ricevanto.getName())));
            return true;
        }
        if ( ago.equals("importi") ) {
            if ( argumentoj.length < 2 ) {
                sendanto.sendMessage(Component.text(Mesagoj.INFO_UZO_IMPORTI));
                return true;
            }
            if ( argumentoj.length > 4 ) {
                sendanto.sendMessage(Component.text(Mesagoj.INFO_UZO_IMPORTI));
                return true;
            }
            java.util.Set<String> medioj = java.util.Set.of("NORMAL", "NETHER", "THE_END", "FLAT");
            String dosierujo = argumentoj[1];
            String nomo = purigi(dosierujo);
            String medio = null;
            if ( argumentoj.length >= 3 ) {
                if ( medioj.contains(argumentoj[2].toUpperCase()) && argumentoj.length == 3 ) {
                    medio = argumentoj[2].toUpperCase();
                } else {
                    nomo = argumentoj[2].toLowerCase();
                }
            }
            if ( argumentoj.length >= 4 ) {
                if ( ! medioj.contains(argumentoj[3].toUpperCase()) ) {
                    sendanto.sendMessage(Component.text(Mesagoj.ERARO_MEDIO));
                    return true;
                }
                medio = argumentoj[3].toUpperCase();
            }
            kromprogramo.administranto().importiMondon(sendanto, dosierujo, nomo, medio);
            return true;
        }
        if ( ago.equals("s2tosax") ) {
            kromprogramo.agordo().relegi();
            kromprogramo.administranto().certigiMondojn();
            sendanto.sendMessage(Component.text(Mesagoj.INFO_RELEGITA));
            return true;
        }
        Player celato = Bukkit.getPlayer(argumentoj[0]);
        if ( celato != null ) {
            if ( argumentoj.length >= 2 ) {
                World mondo = Bukkit.getWorld(argumentoj[1]);
                if ( mondo == null ) {
                    sendanto.sendMessage(Component.text(Mesagoj.mondoNeTrovita(argumentoj[1])));
                    return true;
                }
                if ( mondo.getKey().equals(celato.getWorld().getKey()) ) {
                    sendanto.sendMessage(Component.text(Mesagoj.AVERTO_JAM_TIE));
                    return true;
                }
                kromprogramo.administranto().vojaĝi(celato, mondo);
                sendanto.sendMessage(Component.text(Mesagoj.vojagasAl(celato.getName(), mondo.getName())));
                return true;
            }
            kromprogramo.gui().malfermi(celato);
            sendanto.sendMessage(Component.text(Mesagoj.menuoMalfermita(celato.getName())));
            return true;
        }
        sendanto.sendMessage(Component.text(Mesagoj.INFO_UZO_PLENA));
        return true;
    }

    /* ផ្តល់ជម្រើសបំពេញសម្រាប់ពាក្យបញ្ជារង អ្នកលេង និងពិភពលោក
        @param sendanto ( CommandSender , មិនមែន null ) - អ្នកផ្ញើពាក្យបញ្ជា
        @param komando ( Command , មិនមែន null ) - ពាក្យបញ្ជា
        @param etikedo ( String , មិនមែន null ) - ស្លាកដែលបានប្រើ
        @param argumentoj ( String[] , មិនមែន null ) - អាគុយម៉ង់
        @returns បញ្ជីជម្រើស */
    @Override
    public List<String> onTabComplete(CommandSender sendanto, Command komando, String etikedo, String[] argumentoj) {
        List<String> proponoj = new ArrayList<>();
        if ( ! sendanto.hasPermission("nala.admin") ) {
            return proponoj;
        }
        if ( argumentoj.length == 1 ) {
            proponoj.add("oku3a");
            proponoj.add("au1e");
            proponoj.add("importi");
            proponoj.add("s2tosax");
            for ( Player retludanto : Bukkit.getOnlinePlayers() ) {
                proponoj.add(retludanto.getName());
            }
            return filtri(proponoj, argumentoj[0]);
        }
        if ( argumentoj.length == 2 ) {
            if ( argumentoj[0].equalsIgnoreCase("importi") ) {
                java.io.File importBazo = new java.io.File(kromprogramo.getDataFolder(), "import");
                String[] dosierujoj = importBazo.list((dosiero, nomo) -> new java.io.File(dosiero, nomo).isDirectory());
                if ( dosierujoj != null ) {
                    for ( String dosierujo : dosierujoj ) {
                        proponoj.add(dosierujo);
                    }
                }
                return filtri(proponoj, argumentoj[1]);
            }
            if ( argumentoj[0].equalsIgnoreCase("au1e") ) {
                for ( Player retludanto : Bukkit.getOnlinePlayers() ) {
                    proponoj.add(retludanto.getName());
                }
                return filtri(proponoj, argumentoj[1]);
            }
            Player celato = Bukkit.getPlayer(argumentoj[0]);
            if ( celato != null ) {
                for ( World mondo : kromprogramo.administranto().celojPor(celato) ) {
                    proponoj.add(mondo.getName());
                }
                return filtri(proponoj, argumentoj[1]);
            }
        }
        if ( argumentoj.length >= 3 && argumentoj[0].equalsIgnoreCase("importi") ) {
            proponoj.add("NORMAL");
            proponoj.add("NETHER");
            proponoj.add("THE_END");
            proponoj.add("FLAT");
            return filtri(proponoj, argumentoj[argumentoj.length - 1]);
        }
        return proponoj;
    }

    /* សម្អាតឈ្មោះថតឱ្យទៅជាឈ្មោះពិភពលោកត្រឹមត្រូវ
        @param teksto ( String , មិនមែន null ) - ឈ្មោះដើម
        @returns ឈ្មោះដែលបានសម្អាត */
    private String purigi(String teksto) {
        String pura = teksto.toLowerCase().replaceAll("[^a-z0-9_.-]", "_");
        if ( pura.isEmpty() ) {
            pura = "importita";
        }
        return pura;
    }

    /* អានលេខ ឬ null ប្រសិនបើមិនមែនជាលេខ
        @param teksto ( String , មិនមែន null ) - អត្ថបទដែលបានវាយ
        @returns លេខ ឬ null */
    private Integer nombroEl(String teksto) {
        try {
            return Integer.valueOf(teksto.trim());
        } catch ( NumberFormatException eraro ) {
            return null;
        }
    }

    /* ត្រងជម្រើសតាមបុព្វបទ
        @param listo ( List , មិនមែន null ) - ជម្រើសទាំងអស់
        @param prefikso ( String , មិនមែន null ) - បុព្វបទដែលបានវាយ
        @returns បញ្ជីដែលបានត្រង */
    private List<String> filtri(List<String> listo, String prefikso) {
        if ( prefikso == null || prefikso.isEmpty() ) {
            return listo;
        }
        List<String> rezulto = new ArrayList<>();
        for ( String ero : listo ) {
            if ( ero.toLowerCase().startsWith(prefikso.toLowerCase()) ) {
                rezulto.add(ero);
            }
        }
        return rezulto;
    }
}
