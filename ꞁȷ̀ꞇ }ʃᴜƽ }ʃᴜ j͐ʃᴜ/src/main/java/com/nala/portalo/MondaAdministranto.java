package com.nala.portalo;

import com.nala.NalaPlugin;
import com.nala.config.Agordo;
import com.nala.config.Mesagoj;
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

// ≺⧼ កម្មវិធីគ្រប់គ្រងពិភពលោក 📃 ⧽≻
// គ្រប់គ្រងពិភពលោកផ្ទាល់ខ្លួន

/* ធានាការបង្កើត និងរាយបញ្ជីពិភពលោកសម្រាប់ធ្វើដំណើរ
    @param kromprogramo ( NalaPlugin , មិនមែន null ) - កម្មវិធីជំនួយចម្បង
    @returns កម្មវិធីគ្រប់គ្រងថ្មី */
public class MondaAdministranto {

    // ⟪ ទិន្នន័យកម្មវិធី 📃 ⟫
    // ឯកសារយោងកម្មវិធី
    private final NalaPlugin kromprogramo;
    private final Map<UUID, Set<UUID>> senditaj = new HashMap<>();

    public MondaAdministranto(NalaPlugin kromprogramo) {
        this.kromprogramo = kromprogramo;
    }

    /* តំណាងសាមញ្ញសម្រាប់កញ្ចប់ធនធានមួយដែលត្រូវផ្ញើ
        @returns ព័ត៌មានថ្មី */
    private record PakoInfo(String ligilo, byte[] haketo) {
    }

    // ⟪ ផ្ទៀងផ្ទាត់ 📃 ⟫
    // ផ្ទៀងផ្ទាត់នៅពេលចាប់ផ្តើម

    /* បង្កើតពិភពលោកដែលបាត់ពីការកំណត់ ដោយមិនលុបពិភពលោកផ្សេងទៀត
        @returns គ្មាន */
    public void certigiMondojn() {
        for ( Agordo.MondaEniro eniro : kromprogramo.agordo().mondoj() ) {
            certigiUnu(eniro);
        }
    }

    /* បង្កើត ឬផ្ទុកពិភពលោកមួយតាមឈ្មោះ
        @param eniro ( MondaEniro , មិនមែន null ) - ធាតុការកំណត់
        @returns ពិភពលោក ឬ null */
    public World certigiUnu(Agordo.MondaEniro eniro) {
        String nomo = eniro.nomo();
        World ekzista = Bukkit.getWorld(nomo);
        if ( ekzista != null ) {
            return ekzista;
        }
        try {
            WorldCreator kreilo = WorldCreator.ofKey(NamespacedKey.minecraft(nomo));
            kreilo.environment(medioDe(eniro.medio()));
            if ( eniro.medio().equals("FLAT") ) {
                kreilo.type(WorldType.FLAT);
            } else {
                kreilo.type(WorldType.NORMAL);
            }
            if ( eniro.semo() != 0L ) {
                kreilo.seed(eniro.semo());
            }
            String generilo = eniro.generilo();
            if ( generilo != null && ! generilo.trim().isEmpty() ) {
                String pura = generilo.trim();
                String provizantoNomo = pura;
                int limmarko = pura.indexOf(":");
                if ( limmarko > 0 ) {
                    provizantoNomo = pura.substring(0, limmarko);
                }
                Plugin provizanto = Bukkit.getPluginManager().getPlugin(provizantoNomo);
                if ( provizanto != null && provizanto.isEnabled() ) {
                    kreilo.generator(pura);
                    kromprogramo.getLogger().info(Mesagoj.DEBUG_GENERILO + Mesagoj.mondo(nomo) + " " + pura + " ⟅");
                } else {
                    kromprogramo.getLogger().warning(Mesagoj.AVERTO_GENERILO_MANKAS + Mesagoj.mondo(nomo) + " " + pura + " ⟅");
                }
            }
            kreilo.generateStructures(false);
            World mondo = kreilo.createWorld();
            if ( mondo != null ) {
                kromprogramo.getLogger().info(Mesagoj.DEBUG_MONDO_PRETA + Mesagoj.mondo(nomo) + " ⟅");
                instaliDatumpakojn(eniro, mondo);
            }
            return mondo;
        } catch ( Exception eraro ) {
            kromprogramo.getLogger().warning(Mesagoj.ERARO_KREI_MONDON + Mesagoj.mondo(nomo) + " " + eraro.getMessage() + " ⟅");
            return null;
        }
    }

    // ⟪ កញ្ចប់ទិន្នន័យ 📃 ⟫
    // ពិភពលោកកញ្ចប់ទិន្នន័យ

    /* ចម្លងកញ្ចប់ទិន្នន័យរបស់ Nala ទៅថតកម្រិតពិភពលោកមួយ
        @param eniro ( MondaEniro , មិនមែន null ) - ធាតុការកំណត់
        @param mondo ( World , មិនមែន null ) - ពិភពលោកដែលបានបង្កើត
        @returns គ្មាន */
    private void instaliDatumpakojn(Agordo.MondaEniro eniro, World mondo) {
        if ( eniro.datumpako() == null || eniro.datumpako().isEmpty() ) {
            return;
        }
        File fontoBazo = new File(kromprogramo.getDataFolder(), "datumpako");
        File nivelaBazo = nivelaDosierujo(mondo);
        if ( nivelaBazo == null ) {
            kromprogramo.getLogger().warning(Mesagoj.ERARO_NIVELA_DOSIERUJO + Mesagoj.mondo(eniro.nomo()) + " ⟅");
            return;
        }
        File celoBazo = new File(nivelaBazo, "datapacks");
        celoBazo.mkdirs();
        for ( String pako : eniro.datumpako() ) {
            if ( pako == null ) {
                continue;
            }
            String pura = pako.trim();
            if ( ! pura.matches("[A-Za-z0-9_.-]+") ) {
                kromprogramo.getLogger().warning(Mesagoj.ERARO_MALBONA_PAKNOMO + pura + " ⟅");
                continue;
            }
            File fonto = new File(fontoBazo, pura);
            File celo = new File(celoBazo, pura);
            if ( ! fonto.exists() ) {
                kromprogramo.getLogger().warning(Mesagoj.AVERTO_DATUMPAKO_MANKAS + pura + " ⟅");
                continue;
            }
            if ( celo.exists() ) {
                continue;
            }
            try {
                if ( fonto.isDirectory() ) {
                    kopiiRekurse(fonto.toPath(), celo.toPath());
                } else {
                    Files.createDirectories(celo.getParentFile().toPath());
                    Files.copy(fonto.toPath(), celo.toPath());
                }
                kromprogramo.getLogger().info(Mesagoj.DEBUG_DATUMPAKO + pura + " ⟅");
            } catch ( Exception eraro ) {
                kromprogramo.getLogger().warning(Mesagoj.ERARO_DATUMPAKO + pura + " ⟅");
            }
        }
    }

    /* ស្វែងរកថតឫសកម្រិតដែលមាន level.dat ដោយឡើងតាមថត
        @param mondo ( World , មិនមែន null ) - ពិភពលោក
        @returns ថត ឬ null */
    private File nivelaDosierujo(World mondo) {
        File bazo = mondo.getWorldFolder();
        int profundo = 0; // 0o0
        while ( bazo != null && profundo < 8 ) { // 0o10
            if ( new File(bazo, "level.dat").isFile() ) {
                return bazo;
            }
            bazo = bazo.getParentFile();
            profundo++;
        }
        return null;
    }

    /* ចម្លងថតជាបន្តបន្ទាប់ ដោយមិនចម្លង lock files របស់ប្រព័ន្ធ
        @param fonto ( Path , មិនមែន null ) - ផ្លូវប្រភព
        @param celo ( Path , មិនមែន null ) - ផ្លូវគោលដៅ
        @returns គ្មាន */
    private void kopiiRekurse(Path fonto, Path celo) throws Exception {
        Set<String> ignorataj = Set.of("session.lock", "level.dat", "level.dat_old");
        Files.walk(fonto).forEach(fontoVojo -> {
            try {
                if ( ignorataj.contains(fontoVojo.getFileName().toString()) ) {
                    return;
                }
                Path celoVojo = celo.resolve(fonto.relativize(fontoVojo));
                if ( Files.isDirectory(fontoVojo) ) {
                    Files.createDirectories(celoVojo);
                } else {
                    Files.createDirectories(celoVojo.getParent());
                    Files.copy(fontoVojo, celoVojo, StandardCopyOption.REPLACE_EXISTING);
                }
            } catch ( Exception eraro ) {
                throw new RuntimeException(eraro);
            }
        });
    }

    /* បម្លែងបរិស្ថានក្នុងការកំណត់ទៅជាបរិស្ថាន Bukkit
        @param nomo ( String , មិនមែន null ) - ឈ្មោះក្នុងការកំណត់
        @returns បរិស្ថាន Bukkit */
    private World.Environment medioDe(String nomo) {
        if ( nomo.equals("NETHER") ) {
            return World.Environment.NETHER;
        }
        if ( nomo.equals("THE_END") ) {
            return World.Environment.THE_END;
        }
        return World.Environment.NORMAL;
    }

    // ⟪ នាំចូល 📃 ⟫
    // នាំចូលពិភពលោកខាងក្រៅ

    /* នាំចូលថតពិភពលោកខាងក្រៅ ដោយរកបរិស្ថានដោយស្វ័យប្រវត្តិបើមិនបានបញ្ជាក់
        @param sendanto ( CommandSender , មិនមែន null ) - អ្នកផ្ញើពាក្យបញ្ជា
        @param dosierujo ( String , មិនមែន null ) - ថតប្រភពក្នុងទីតាំងនាំចូល
        @param nomo ( String , មិនមែន null ) - ឈ្មោះពិភពលោកថ្មីជាអក្សរតូច
        @param medio ( String , អាចជា null ) - បរិស្ថាន ឬ null ដើម្បីរកដោយស្វ័យប្រវត្តិ
        @returns គ្មាន */
    public void importiMondon(CommandSender sendanto, String dosierujo, String nomo, String medio) {
        Set<String> medioj = Set.of("NORMAL", "NETHER", "THE_END", "FLAT");
        if ( medio != null && ! medioj.contains(medio) ) {
            sendanto.sendMessage(Component.text(Mesagoj.ERARO_MEDIO));
            return;
        }
        if ( ! nomo.matches("[a-z0-9_.-]+") ) {
            sendanto.sendMessage(Component.text(Mesagoj.ERARO_NOMO));
            return;
        }
        File fonto = new File(new File(kromprogramo.getDataFolder(), "import"), dosierujo);
        if ( ! fonto.isDirectory() ) {
            sendanto.sendMessage(Component.text(Mesagoj.ERARO_METU_DOSIERUJON));
            return;
        }
        if ( Bukkit.getWorld(nomo) != null ) {
            sendanto.sendMessage(Component.text(Mesagoj.ERARO_JAM_SARGITA));
            return;
        }
        File celo = celDosierujo(nomo);
        if ( celo == null ) {
            sendanto.sendMessage(Component.text(Mesagoj.ERARO_OVERWORLD));
            return;
        }
        if ( new File(celo, "region").isDirectory() ) {
            sendanto.sendMessage(Component.text(Mesagoj.ERARO_REGIONO));
            return;
        }
        File fontoRadiko;
        boolean mem = medio == null;
        String veraMedio = mem ? diveniMedion(fonto) : medio;
        if ( mem ) {
            sendanto.sendMessage(Component.text(Mesagoj.INFO_MEMDETEKTITA + veraMedio + " ⟅"));
        }
        fontoRadiko = troviFonton(fonto, veraMedio);
        if ( fontoRadiko == null ) {
            sendanto.sendMessage(Component.text(Mesagoj.ERARO_NENIU_REGIONO));
            return;
        }
        sendanto.sendMessage(Component.text(Mesagoj.INFO_KOPIADO));
        Bukkit.getScheduler().runTaskAsynchronously(kromprogramo, () -> {
            try {
                kopiiMondon(fontoRadiko, celo);
            } catch ( Exception eraro ) {
                Bukkit.getScheduler().runTask(kromprogramo, () -> sendanto.sendMessage(Component.text(Mesagoj.ERARO_KOPIADO + eraro.getMessage() + " ⟅")));
                return;
            }
            Bukkit.getScheduler().runTask(kromprogramo, () -> {
                kromprogramo.agordo().aldoniMondon(nomo, veraMedio);
                World mondo = certigiUnu(new Agordo.MondaEniro(nomo, veraMedio, 0L));
                if ( mondo != null ) {
                    sendanto.sendMessage(Component.text(Mesagoj.INFO_IMPORTITA + Mesagoj.mondo(nomo) + " ⟅"));
                } else {
                    sendanto.sendMessage(Component.text(Mesagoj.ERARO_SARGO));
                }
            });
        });
    }

    /* រកបរិស្ថានពីរចនាសម្ព័ន្ធថត ដោយមិនចាំបាច់វាយបញ្ចូល
        @param fonto ( File , មិនមែន null ) - ថតខាងក្រៅ
        @returns NORMAL, NETHER, THE_END ឬ FLAT ដែលមិនមែន null */
    private String diveniMedion(File fonto) {
        boolean hasOver = new File(fonto, "dimensions/minecraft/overworld/region").isDirectory() || new File(fonto, "region").isDirectory();
        boolean hasNether = new File(fonto, "dimensions/minecraft/the_nether/region").isDirectory() || new File(fonto, "DIM-1/region").isDirectory();
        boolean hasEnd = new File(fonto, "dimensions/minecraft/the_end/region").isDirectory() || new File(fonto, "DIM1/region").isDirectory();
        if ( ! hasOver && hasNether && ! hasEnd ) {
            return "NETHER";
        }
        if ( ! hasOver && ! hasNether && hasEnd ) {
            return "THE_END";
        }
        return "NORMAL";
    }

    /* ស្វែងរកថតគោលដៅក្រោម dimensions/minecraft
        @param nomo ( String , មិនមែន null ) - ឈ្មោះពិភពលោកថ្មី
        @returns ថត ឬ null */
    private File celDosierujo(String nomo) {
        World overworld = null;
        for ( World mondo : Bukkit.getWorlds() ) {
            if ( mondo.getKey().getKey().equals("overworld") ) {
                overworld = mondo;
                break;
            }
        }
        if ( overworld == null && ! Bukkit.getWorlds().isEmpty() ) {
            overworld = Bukkit.getWorlds().get(0);
        }
        if ( overworld == null ) {
            return null;
        }
        File bazo = overworld.getWorldFolder();
        if ( bazo.getName().equals("overworld") && bazo.getParentFile() != null ) {
            bazo = bazo.getParentFile();
        } else {
            bazo = new File(bazo, "dimensions/minecraft");
        }
        return new File(bazo, nomo);
    }

    /* ស្វែងរកថតឫស region ក្នុងថតខាងក្រៅតាមបរិស្ថាន
        @param fonto ( File , មិនមែន null ) - ថតខាងក្រៅ
        @param medio ( String , មិនមែន null ) - បរិស្ថានគោលដៅ
        @returns ថតឫសដែលមាន region ឬ null */
    private File troviFonton(File fonto, String medio) {
        String sub;
        if ( medio.equals("NETHER") ) {
            sub = "the_nether";
        } else if ( medio.equals("THE_END") ) {
            sub = "the_end";
        } else {
            sub = "overworld";
        }
        File nova = new File(fonto, "dimensions/minecraft/" + sub);
        if ( new File(nova, "region").isDirectory() ) {
            return nova;
        }
        if ( medio.equals("NETHER") ) {
            File malnova = new File(fonto, "DIM-1");
            if ( new File(malnova, "region").isDirectory() ) {
                return malnova;
            }
        }
        if ( medio.equals("THE_END") ) {
            File malnova = new File(fonto, "DIM1");
            if ( new File(malnova, "region").isDirectory() ) {
                return malnova;
            }
        }
        if ( new File(fonto, "region").isDirectory() ) {
            return fonto;
        }
        return null;
    }

    /* ចម្លងឯកសារ region ដោយមិនចម្លងទិន្នន័យអ្នកលេង និងឯកសារប្រព័ន្ធ
        @param fonto ( File , មិនមែន null ) - ថតឫសប្រភព
        @param celo ( File , មិនមែន null ) - ថតគោលដៅ
        @returns គ្មាន */
    private void kopiiMondon(File fonto, File celo) throws Exception {
        String[] kopiotaj = new String[] { "region", "entities", "poi", "data" };
        Set<String> ignorataj = Set.of("session.lock", "level.dat", "level.dat_old");
        for ( String nomo : kopiotaj ) {
            File subFonto = new File(fonto, nomo);
            if ( ! subFonto.isDirectory() ) {
                continue;
            }
            Path radiko = subFonto.toPath();
            Files.walk(radiko).forEach(fontoVojo -> {
                try {
                    if ( ignorataj.contains(fontoVojo.getFileName().toString()) ) {
                        return;
                    }
                    Path celoVojo = new File(celo, nomo).toPath().resolve(radiko.relativize(fontoVojo));
                    if ( Files.isDirectory(fontoVojo) ) {
                        Files.createDirectories(celoVojo);
                    } else {
                        Files.createDirectories(celoVojo.getParent());
                        Files.copy(fontoVojo, celoVojo, StandardCopyOption.REPLACE_EXISTING);
                    }
                } catch ( Exception eraro ) {
                    throw new RuntimeException(eraro);
                }
            });
        }
    }

    // ⟪ បញ្ជី 📃 ⟫
    // បញ្ជីគោលដៅធ្វើដំណើរ

    /* រាយបញ្ជីគោលដៅធ្វើដំណើរ ដោយមិនបញ្ចូលពិភពលោកបច្ចុប្បន្ន
        @param ludanto ( Player , មិនមែន null ) - អ្នកលេងដែលស្នើសុំ
        @returns បញ្ជីពិភពលោក */
    public List<World> celojPor(Player ludanto) {
        World nuna = ludanto.getWorld();
        List<World> celoj = new ArrayList<>();
        for ( World mondo : Bukkit.getWorlds() ) {
            if ( mondo.getKey().equals(nuna.getKey()) ) {
                continue;
            }
            if ( estasVanilaNetherAŭEnd(mondo) && ( ! kromprogramo.agordo().montriNetherEnd() ) ) {
                continue;
            }
            celoj.add(mondo);
        }
        return celoj;
    }

    /* ពិនិត្យថាតើពិភពលោកជា Nether ឬ End របស់ vanilla ឬអត់
        @param mondo ( World , មិនមែន null ) - ពិភពលោកដែលត្រូវពិនិត្យ
        @returns ពិតប្រសិនបើជា Nether ឬ End */
    private boolean estasVanilaNetherAŭEnd(World mondo) {
        World.Environment medio = mondo.getEnvironment();
        if ( medio != World.Environment.NETHER && medio != World.Environment.THE_END ) {
            return false;
        }
        String ŝlosilo = mondo.getKey().getKey();
        return ŝlosilo.equals("the_nether") || ŝlosilo.equals("the_end");
    }

    // ⟪ បញ្ជូនទីតាំង 📃 ⟫
    // ការផ្លាស់ទីទៅពិភពមួយផ្សេងទៀត

    /* បញ្ជូនអ្នកលេងទៅទីតាំងចុងក្រោយ ទ្វារ ឬកន្លែងកំណើត
        @param ludanto ( Player , មិនមែន null ) - អ្នកលេងដែលកំពុងធ្វើដំណើរ
        @param celo ( World , មិនមែន null ) - ពិភពលោកគោលដៅ
        @returns ពិតប្រសិនបើជោគជ័យ */
    public boolean vojaĝi(Player ludanto, World celo) {
        kromprogramo.lokoj().memoru(ludanto);
        Location lasta = kromprogramo.lokoj().lastaLoko(ludanto, celo);
        if ( lasta != null ) {
            ludanto.teleportAsync(lasta).thenAccept(rezulto -> {
                if ( rezulto ) {
                    ludanto.sendMessage(Component.text(Mesagoj.bonvenon(celo.getName())));
                    sinkronigiRimedpakojn(ludanto, celo);
                } else {
                    ludanto.sendMessage(Component.text(Mesagoj.ERARO_TELEPORTO));
                }
            });
            return true;
        }
        boolean havas = kromprogramo.portalo().havasPortalon(celo);
        Location alveno = kromprogramo.portalo().troviAŭKonstrui(celo);
        ludanto.teleportAsync(alveno).thenAccept(rezulto -> {
            if ( rezulto ) {
                ludanto.sendMessage(Component.text(Mesagoj.bonvenon(celo.getName())));
                if ( ! havas ) {
                    ludanto.sendMessage(Component.text(Mesagoj.AVERTO_NENIU_PORTALO));
                }
                sinkronigiRimedpakojn(ludanto, celo);
            } else {
                ludanto.sendMessage(Component.text(Mesagoj.ERARO_TELEPORTO));
            }
        });
        return true;
    }

    // ⟪ កញ្ចប់ធនធាន 📃 ⟫
    // កញ្ចប់ធនធានតាមពិភពលោក

    /* ធ្វើសមកាលកម្មកញ្ចប់ធនធានរបស់ពិភពគោលដៅជាមួយអ្នកលេង
        @param ludanto ( Player , មិនមែន null ) - អ្នកលេងដែលកំពុងធ្វើដំណើរ
        @param celo ( World , មិនមែន null ) - ពិភពលោកគោលដៅ
        @returns គ្មាន */
    private void sinkronigiRimedpakojn(Player ludanto, World celo) {
        Agordo.MondaEniro eniro = kromprogramo.agordo().trovi(celo.getName());
        if ( eniro == null ) {
            eniro = kromprogramo.agordo().trovi(celo.getKey().getKey());
        }
        Map<UUID, PakoInfo> dezirataj = new LinkedHashMap<>();
        if ( eniro != null && eniro.rimedpako() != null ) {
            for ( String ero : eniro.rimedpako() ) {
                if ( ero == null ) {
                    continue;
                }
                String pura = ero.trim();
                if ( pura.isEmpty() ) {
                    continue;
                }
                String ligilo = kromprogramo.gastiganto().ligiloPor(pura);
                if ( ligilo.isEmpty() ) {
                    continue;
                }
                UUID identigilo = UUID.nameUUIDFromBytes(("nala:" + ligilo).getBytes(StandardCharsets.UTF_8));
                if ( dezirataj.containsKey(identigilo) ) {
                    continue;
                }
                byte[] haketo = null;
                if ( ! pura.startsWith("http") ) {
                    haketo = kromprogramo.gastiganto().haketoPor(new File(kromprogramo.gastiganto().bazo(), pura));
                }
                dezirataj.put(identigilo, new PakoInfo(ligilo, haketo));
            }
        }
        Set<UUID> havataj = senditaj.getOrDefault(ludanto.getUniqueId(), Set.of());
        Set<UUID> forigotaj = new HashSet<>(havataj);
        forigotaj.removeAll(dezirataj.keySet());
        for ( UUID identigilo : forigotaj ) {
            try {
                ludanto.removeResourcePack(identigilo);
            } catch ( Exception eraro ) {
                kromprogramo.getLogger().warning(Mesagoj.AVERTO_RIMEDPAKO_FORIGO);
            }
        }
        Set<UUID> aldonotaj = new HashSet<>(dezirataj.keySet());
        aldonotaj.removeAll(havataj);
        for ( UUID identigilo : aldonotaj ) {
            PakoInfo info = dezirataj.get(identigilo);
            try {
                ludanto.addResourcePack(identigilo, info.ligilo(), info.haketo(), null, false);
            } catch ( Exception eraro ) {
                ludanto.sendMessage(Component.text(Mesagoj.AVERTO_RIMEDPAKO_MALSUKCESIS));
            }
        }
        if ( dezirataj.isEmpty() ) {
            senditaj.remove(ludanto.getUniqueId());
        } else {
            senditaj.put(ludanto.getUniqueId(), new HashSet<>(dezirataj.keySet()));
        }
    }
}
