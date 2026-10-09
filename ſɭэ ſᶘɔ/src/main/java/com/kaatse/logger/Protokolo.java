package com.kaatse.logger;

import com.kaatse.KaatsePlugin;
import com.kaatse.config.LogajMesagoj;
import com.kaatse.config.Mesagoj;
import com.kaatse.tempo.S2veniTempo;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

// ≺⧼ កំណត់ហេតុ 📃 ⧽≻
// កំណត់ហេតុអ្នកលេង និងម៉ាស៊ីនមេ

/* ថ្នាក់កំណត់ហេតុសម្រាប់សារ ពាក្យបញ្ជា និងការតភ្ជាប់
    @param kromprogramo ( KaatsePlugin , មិនមែន null ) - កម្មវិធីជំនួយចម្បង
    @returns វត្ថុកំណត់ហេតុថ្មី */
public class Protokolo {

    // ⟪ ប្រភេទ 📃 ⟫
    // ប្រភេទកំណត់ហេតុជាភាសា Iikrhia
    public enum Tipo {
        BABILO("chat", false),
        KOMANDO("command", false),
        ENIRO("join", true),
        ELIRO("leave", true),
        MORTO("death", true),
        FORPELO("kick", true),
        AVANCO("advancement", true),
        KONZOLO("console", false),
        SERVILA_EKIGO("server-start", true),
        SERVILA_FINO("server-stop", true),
        MONDA_SAVO("world-save", true);

        private final String ŝlosilo;
        private final boolean plenaFrazo;

        Tipo(String ŝlosilo, boolean plenaFrazo) {
            this.ŝlosilo = ŝlosilo;
            this.plenaFrazo = plenaFrazo;
        }

        public String etikedo(LogajMesagoj logajMesagoj) {
            return logajMesagoj.teksto("types." + ŝlosilo);
        }

        public boolean plenaFrazo() {
            return plenaFrazo;
        }
    }

    // ⟨ ព័ត៌មាន 📃 ⟩
    // ព័ត៌មានអ្នកលេង
    private static final class LudantoInfo {
        final String nomo;
        final UUID uuid;
        String ip;
        Instant laste;

        LudantoInfo(String nomo, UUID uuid, String ip, Instant laste) {
            this.nomo = nomo;
            this.uuid = uuid;
            this.ip = ip;
            this.laste = laste;
        }
    }

    // ⟨ បរិបទ 📃 ⟩
    // បរិបទសម្រាប់មួយសកម្មភាព
    private static final class Kunteksto {
        final String nomo;
        final UUID uuid;
        final String ip;
        final boolean admin;
        final Instant momento;

        Kunteksto(String nomo, UUID uuid, String ip, boolean admin, Instant momento) {
            this.nomo = nomo;
            this.uuid = uuid;
            this.ip = ip;
            this.admin = admin;
            this.momento = momento;
        }
    }

    // ⟪ វាលទិន្នន័យ 📃 ⟫
    // ទិន្នន័យខាងក្នុង
    private final KaatsePlugin kromprogramo;
    private final LogajMesagoj logajMesagoj;
    private final File ludantoDosierujo;
    private final File adminDosierujo;
    private final File servilaDosierujo;
    private final ExecutorService plenumanto;
    private final Map<UUID, LudantoInfo> kasxmemoro = new ConcurrentHashMap<>();

    public Protokolo(KaatsePlugin kromprogramo) {
        this.kromprogramo = kromprogramo;
        try {
            this.logajMesagoj = new LogajMesagoj(kromprogramo);
        } catch ( IOException | org.bukkit.configuration.InvalidConfigurationException eraro ) {
            throw new IllegalStateException("មិនអាចអានសារកំណត់ហេតុបានទេ", eraro);
        }
        File datumoDosierujo = kromprogramo.getDataFolder();
        this.ludantoDosierujo = new File(datumoDosierujo, "ludantoj");
        this.adminDosierujo = new File(datumoDosierujo, "adminoj");
        this.servilaDosierujo = new File(datumoDosierujo, "servilo");
        kreiDosierujon(this.ludantoDosierujo);
        kreiDosierujon(this.adminDosierujo);
        kreiDosierujon(this.servilaDosierujo);
        this.plenumanto = Executors.newSingleThreadExecutor((Runnable tasko) -> {
            Thread fadeno = new Thread(tasko, "ſɭэ ſᶘɔ-protokolo");
            fadeno.setDaemon(true);
            return fadeno;
        });
    }

    /* បង្កើតថតប្រសិនបើមិនទាន់មាន
        @param dosierujo ( File , មិនមែន null ) - ថតដែលត្រូវបង្កើត
        @returns គ្មាន */
    private void kreiDosierujon(File dosierujo) {
        if ( dosierujo.exists() ) {
            return;
        }
        boolean farita = dosierujo.mkdirs();
        if ( farita == false ) {
            kromprogramo.getLogger().warning(Mesagoj.dosierujo(dosierujo.getName()));
        }
    }

    /* បញ្ឈប់ខ្សែការងារដោយសុវត្ថិភាព
        @returns គ្មាន */
    public void fermi() {
        plenumanto.shutdown();
        try {
            boolean finita = plenumanto.awaitTermination(10L, TimeUnit.SECONDS);
            if ( finita == false ) {
                plenumanto.shutdownNow();
            }
        } catch ( InterruptedException eraro ) {
            plenumanto.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    // ⟪ អ្នកគ្រប់គ្រង 📃 ⟫
    // តួនាទីអ្នកគ្រប់គ្រង ឬ OP

    /* ពិនិត្យថាតើអ្នកលេងជាអ្នកគ្រប់គ្រងឬអត់
        @param ludanto ( Player , មិនមែន null ) - អ្នកលេងដែលត្រូវពិនិត្យ
        @returns ពិតប្រសិនបើជាអ្នកគ្រប់គ្រង ឬ OP */
    public boolean estasAdmin(Player ludanto) {
        if ( ludanto.isOp() ) {
            return true;
        }
        String permeso = kromprogramo.agordo().adminPermeso();
        return ludanto.hasPermission(permeso);
    }

    /* ពិនិត្យថាតើអ្នកលេងក្រៅបណ្ដាញជាអ្នកគ្រប់គ្រងឬអត់
        @param ludanto ( OfflinePlayer , មិនមែន null ) - អ្នកលេងដែលត្រូវពិនិត្យ
        @returns ពិតប្រសិនបើជាអ្នកគ្រប់គ្រង ឬ OP */
    public boolean estasAdmin(OfflinePlayer ludanto) {
        if ( ludanto.isOp() ) {
            return true;
        }
        return false;
    }

    // ⟪ កំណត់ហេតុសាធារណៈ 📃 ⟫
    // កំណត់ហេតុសាធារណៈ

    /* កត់ត្រាសារជជែក
        @param ludanto ( Player , មិនមែន null ) - អ្នកផ្ញើ
        @param mesago ( String , មិនមែន null ) - អត្ថបទសារ
        @returns គ្មាន */
    public void logiBabilon(Player ludanto, String mesago) {
        if ( kromprogramo.agordo().logiBabilon() == false ) {
            return;
        }
        Kunteksto kunteksto = kaptiKuntekston(ludanto);
        String puraMesago = purigiTekston(mesago);
        plenumanto.execute(() -> aldoniEniron(kunteksto, Tipo.BABILO, puraMesago));
    }

    /* កត់ត្រាពាក្យបញ្ជារបស់អ្នកលេង
        @param ludanto ( Player , មិនមែន null ) - អ្នកផ្ញើ
        @param komando ( String , មិនមែន null ) - ពាក្យបញ្ជាដែលចាប់ផ្ដើមដោយសញ្ញា slash
        @returns គ្មាន */
    public void logiKomandon(Player ludanto, String komando) {
        if ( kromprogramo.agordo().logiKomandojn() == false ) {
            return;
        }
        Kunteksto kunteksto = kaptiKuntekston(ludanto);
        String puraKomando = purigiTekston(komando);
        String frazo = kromprogramo.agordo().logiSubjektanMarkilon()
            ? logajMesagoj.formati(
                "sentences.player-command",
                "command", puraKomando,
                "player", kunteksto.nomo
            )
            : puraKomando;
        plenumanto.execute(() -> aldoniEniron(kunteksto, Tipo.KOMANDO, frazo));
    }

    /* កត់ត្រាការចូលម៉ាស៊ីនមេ
        @param ludanto ( Player , មិនមែន null ) - អ្នកលេងដែលបានចូល
        @returns គ្មាន */
    public void logiEniron(Player ludanto) {
        if ( kromprogramo.agordo().logiKonekton() == false ) {
            return;
        }
        Kunteksto kunteksto = kaptiKuntekston(ludanto);
        String mesago = logajMesagoj.formati("sentences.player-join", "player", kunteksto.nomo);
        plenumanto.execute(() -> aldoniEniron(kunteksto, Tipo.ENIRO, mesago));
    }

    /* កត់ត្រាការចាកចេញពីម៉ាស៊ីនមេ
        @param ludanto ( Player , មិនមែន null ) - អ្នកលេងដែលបានចាកចេញ
        @returns គ្មាន */
    public void logiEliron(Player ludanto) {
        if ( kromprogramo.agordo().logiKonekton() == false ) {
            return;
        }
        Kunteksto kunteksto = kaptiKuntekston(ludanto);
        String mesago = logajMesagoj.formati("sentences.player-leave", "player", kunteksto.nomo);
        plenumanto.execute(() -> aldoniEniron(kunteksto, Tipo.ELIRO, mesago));
    }

    public void logiMorton(Player ludanto) {
        if ( kromprogramo.agordo().logiServilajnEventojn() == false
            || kromprogramo.agordo().logiMortojn() == false ) {
            return;
        }
        Kunteksto kunteksto = kaptiKuntekston(ludanto);
        String mesago = logajMesagoj.formati("sentences.player-death", "player", kunteksto.nomo);
        plenumanto.execute(() -> aldoniEniron(kunteksto, Tipo.MORTO, mesago));
    }

    public void logiForpelon(Player ludanto) {
        if ( kromprogramo.agordo().logiServilajnEventojn() == false
            || kromprogramo.agordo().logiForpelojn() == false ) {
            return;
        }
        Kunteksto kunteksto = kaptiKuntekston(ludanto);
        String mesago = logajMesagoj.formati(
            "sentences.player-kick",
            "player", kunteksto.nomo,
            "server", logajMesagoj.teksto("names.server")
        );
        plenumanto.execute(() -> aldoniEniron(kunteksto, Tipo.FORPELO, mesago));
    }

    public void logiAvancon(Player ludanto, String titolo) {
        if ( kromprogramo.agordo().logiServilajnEventojn() == false
            || kromprogramo.agordo().logiAvancojn() == false ) {
            return;
        }
        Kunteksto kunteksto = kaptiKuntekston(ludanto);
        String mesago = logajMesagoj.formati(
            "sentences.player-advancement",
            "advancement", purigiTekston(titolo),
            "player", kunteksto.nomo
        );
        plenumanto.execute(() -> aldoniEniron(kunteksto, Tipo.AVANCO, mesago));
    }

    public void logiServilanEkigon() {
        if ( kromprogramo.agordo().logiServilanVivciklon() == false ) {
            return;
        }
        logiServilanEventon(
            Tipo.SERVILA_EKIGO,
            logajMesagoj.formati("sentences.server-start", "server", logajMesagoj.teksto("names.server"))
        );
    }

    public void logiServilanFinon() {
        if ( kromprogramo.agordo().logiServilanVivciklon() == false ) {
            return;
        }
        logiServilanEventon(
            Tipo.SERVILA_FINO,
            logajMesagoj.formati("sentences.server-stop", "server", logajMesagoj.teksto("names.server"))
        );
    }

    public void logiMondanSavon(String mondaNomo) {
        if ( kromprogramo.agordo().logiMondajnSavojn() == false ) {
            return;
        }
        logiServilanEventon(
            Tipo.MONDA_SAVO,
            logajMesagoj.formati(
                "sentences.world-save",
                "world", purigiTekston(mondaNomo),
                "server", logajMesagoj.teksto("names.server")
            )
        );
    }

    private void logiServilanEventon(Tipo tipo, String mesago) {
        if ( kromprogramo.agordo().logiServilajnEventojn() == false ) {
            return;
        }
        Instant momento = Instant.now();
        String konzolo = logajMesagoj.teksto("names.console");
        plenumanto.execute(() -> aldoniAlServilo(momento, tipo, konzolo, mesago));
    }

    /* កត់ត្រាពាក្យបញ្ជាកុងសូល
        @param komando ( String , មិនមែន null ) - ពាក្យបញ្ជាពីកុងសូល
        @returns គ្មាន */
    public void logiKonzolon(String komando) {
        if ( kromprogramo.agordo().logiKonzolon() == false ) {
            return;
        }
        Instant momento = Instant.now();
        String purigita = purigiTekston(komando);
        String frazo = kromprogramo.agordo().logiSubjektanMarkilon()
            ? logajMesagoj.formati(
                "sentences.console-command",
                "command", purigita,
                "console", logajMesagoj.teksto("names.console")
            )
            : purigita;
        String nomoKonzolo = logajMesagoj.teksto("names.console");
        plenumanto.execute(() -> {
            aldoniAlServilo(momento, Tipo.KONZOLO, nomoKonzolo, frazo);
            aldoniAlKonzolo(momento, frazo);
        });
    }

    /* ផ្លាស់ទីឯកសារប្រសិនបើស្ថានភាពអ្នកគ្រប់គ្រងបានផ្លាស់ប្ដូរ
        @param ludanto ( Player , មិនមែន null ) - អ្នកលេងដែលត្រូវពិនិត្យ
        @returns គ្មាន */
    public void kontroliKajMovi(Player ludanto) {
        Kunteksto kunteksto = kaptiKuntekston(ludanto);
        plenumanto.execute(() -> moviSeNecesas(kunteksto));
    }

    // ⟪ បរិបទ 📃 ⟫
    // ការប្រមូលបរិបទ

    /* ប្រមូលឈ្មោះ UUID អាសយដ្ឋាន IP និងស្ថានភាពអ្នកគ្រប់គ្រង
        @param ludanto ( Player , មិនមែន null ) - អ្នកលេងដែលត្រូវប្រមូលព័ត៌មាន
        @returns បរិបទថ្មី */
    private Kunteksto kaptiKuntekston(Player ludanto) {
        String nomo = ludanto.getName();
        UUID uuid = ludanto.getUniqueId();
        String ip = adreson(ludanto);
        boolean admin = estasAdmin(ludanto);
        Instant momento = Instant.now();
        ĝisdatigiKaŝon(nomo, uuid, ip, momento);
        return new Kunteksto(nomo, uuid, ip, admin, momento);
    }

    /* រក្សាទុកអាសយដ្ឋាន IP និងពេលវេលាចុងក្រោយ
        @param nomo ( String , មិនមែន null ) - ឈ្មោះអ្នកលេង
        @param uuid ( UUID , មិនមែន null ) - UUID របស់អ្នកលេង
        @param ip ( String , មិនមែន null ) - អាសយដ្ឋាន IP ចុងក្រោយ
        @param momento ( Instant , មិនមែន null ) - សកម្មភាពចុងក្រោយ
        @returns គ្មាន */
    private void ĝisdatigiKaŝon(String nomo, UUID uuid, String ip, Instant momento) {
        LudantoInfo malnova = kasxmemoro.get(uuid);
        if ( malnova == null ) {
            kasxmemoro.put(uuid, new LudantoInfo(nomo, uuid, ip, momento));
            return;
        }
        malnova.ip = ip;
        malnova.laste = momento;
    }

    /* អានអាសយដ្ឋាន IP ជាអត្ថបទ
        @param ludanto ( Player , មិនមែន null ) - អ្នកលេងដែលត្រូវអាន
        @returns អត្ថបទអាសយដ្ឋាន IP ឬ មិនស្គាល់ */
    private String adreson(Player ludanto) {
        try {
            if ( ludanto.getAddress() == null ) {
                return logajMesagoj.teksto("names.unknown");
            }
            if ( ludanto.getAddress().getAddress() == null ) {
                return logajMesagoj.teksto("names.unknown");
            }
            return ludanto.getAddress().getAddress().getHostAddress();
        } catch ( Exception eraro ) {
            return logajMesagoj.teksto("names.unknown");
        }
    }

    // ⟪ ធាតុកំណត់ហេតុ 📃 ⟫
    // ការបន្ថែមធាតុថ្មី

    /* បន្ថែមធាតុមួយទៅកំណត់ហេតុអ្នកលេង និងម៉ាស៊ីនមេ
        @param kunteksto ( Kunteksto , មិនមែន null ) - អ្នកណា និង ពេលណា
        @param tipo ( Tipo , មិនមែន null ) - ប្រភេទធាតុ
        @param mesago ( String , មិនមែន null ) - អត្ថបទដើម
        @returns គ្មាន */
    private void aldoniEniron(Kunteksto kunteksto, Tipo tipo, String mesago) {
        String purigita = purigiTekston(mesago);
        File dosierujo;
        if ( kunteksto.admin ) {
            dosierujo = adminDosierujo;
        } else {
            dosierujo = ludantoDosierujo;
        }
        File celo = dosieroPor(dosierujo, kunteksto.nomo);
        moviSeNecesas(kunteksto);
        String linio = formatiLudantanLinon(kunteksto.momento, tipo, kunteksto.nomo, purigita);
        try {
            if ( celo.exists() == false ) {
                kreiNovan(celo, kunteksto);
            }
            antaŭmetiPostKapo(celo, linio);
            ĝisdatigiKapon(celo, kunteksto.momento, kunteksto.ip);
        } catch ( Exception eraro ) {
            kromprogramo.getLogger().warning(Mesagoj.skribo(celo.getName()));
        }
        aldoniAlServilo(kunteksto.momento, tipo, kunteksto.nomo, purigita);
    }

    /* ស្វែងរកឯកសារតាមឈ្មោះ
        @param dosierujo ( File , មិនមែន null ) - ថតមូលដ្ឋាន
        @param nomo ( String , មិនមែន null ) - ឈ្មោះអ្នកលេង
        @returns ឯកសារដែលមានឈ្មោះបានសម្អាត */
    private File dosieroPor(File dosierujo, String nomo) {
        String pura = purigiNomom(nomo);
        return new File(dosierujo, pura + ".txt");
    }

    /* សម្អាតឈ្មោះសម្រាប់ប្រព័ន្ធឯកសារ
        @param nomo ( String , មិនមែន null ) - ឈ្មោះដើម
        @returns ឈ្មោះដែលជំនួសតួអក្សរមិនត្រឹមត្រូវដោយ _ */
    private String purigiNomom(String nomo) {
        String pura = nomo.replaceAll("[^A-Za-z0-9._-]", "_");
        if ( pura.isEmpty() ) {
            return logajMesagoj.teksto("names.unknown");
        }
        return pura;
    }

    /* លុបការបំបែកបន្ទាត់ចេញពីអត្ថបទ
        @param teksto ( String , អាចជា null ) - អត្ថបទដើម
        @returns អត្ថបទដែលគ្មានការបំបែកបន្ទាត់ */
    private String purigiTekston(String teksto) {
        if ( teksto == null ) {
            return "";
        }
        String senLinio = teksto.replace("\r", " ").replace("\n", " ");
        return senLinio.trim();
    }

    /* ផ្លាស់ទីឯកសាររវាងថតអ្នកលេង និងអ្នកគ្រប់គ្រងនៅពេលចាំបាច់
        @param kunteksto ( Kunteksto , មិនមែន null ) - ស្ថានភាពបច្ចុប្បន្ន
        @returns គ្មាន */
    private void moviSeNecesas(Kunteksto kunteksto) {
        File ĝusta;
        File malĝusta;
        if ( kunteksto.admin ) {
            ĝusta = dosieroPor(adminDosierujo, kunteksto.nomo);
            malĝusta = dosieroPor(ludantoDosierujo, kunteksto.nomo);
        } else {
            ĝusta = dosieroPor(ludantoDosierujo, kunteksto.nomo);
            malĝusta = dosieroPor(adminDosierujo, kunteksto.nomo);
        }
        if ( malĝusta.exists() == false ) {
            return;
        }
        if ( ĝusta.exists() ) {
            try {
                kunfandi(malĝusta, ĝusta);
            } catch ( Exception eraro ) {
                kromprogramo.getLogger().warning(Mesagoj.kunfando(kunteksto.nomo));
                return;
            }
            boolean forigita = malĝusta.delete();
            if ( forigita == false ) {
                kromprogramo.getLogger().warning(Mesagoj.forigo(malĝusta.getName()));
            }
            return;
        }
        try {
            Files.move(malĝusta.toPath(), ĝusta.toPath());
        } catch ( Exception eraro ) {
            kromprogramo.getLogger().warning(Mesagoj.movo(kunteksto.nomo));
        }
    }

    /* បញ្ចូលឯកសារចាស់ទៅក្នុងឯកសារថ្មី
        @param fonto ( File , មិនមែន null ) - ឯកសារប្រភពដែលត្រូវលុបក្រោយបញ្ចូល
        @param celo ( File , មិនមែន null ) - ឯកសារគោលដៅដែលត្រូវរក្សាទុក
        @returns គ្មាន */
    private void kunfandi(File fonto, File celo) throws Exception {
        List<String> fontaj = Files.readAllLines(fonto.toPath(), StandardCharsets.UTF_8);
        List<String> celaj = Files.readAllLines(celo.toPath(), StandardCharsets.UTF_8);
        int fino = kapoFino(celaj);
        List<String> kunmetitaj = new ArrayList<>();
        int i = 0;
        while ( i <= fino ) {
            kunmetitaj.add(celaj.get(i));
            i = i + 1;
        }
        int j = fino + 1;
        while ( j < fontaj.size() ) {
            String linio = fontaj.get(j);
            if ( estasKapaLinio(linio) == false ) {
                kunmetitaj.add(linio);
            }
            j = j + 1;
        }
        int k = fino + 1;
        while ( k < celaj.size() ) {
            kunmetitaj.add(celaj.get(k));
            k = k + 1;
        }
        Files.write(celo.toPath(), kunmetitaj, StandardCharsets.UTF_8);
    }

    /* ស្វែងរកលេខរៀងបន្ទាត់ចុងក្រោយនៃក្បាលឯកសារ
        @param linioj ( List , មិនមែន null ) - បន្ទាត់ទាំងអស់ក្នុងឯកសារ
        @returns លេខរៀងរបស់សញ្ញាបិទក្បាល ឬ 4 ប្រសិនបើរកមិនឃើញ */
    private int kapoFino(List<String> linioj) {
        int i = 0;
        while ( i < linioj.size() ) {
            String linio = linioj.get(i).trim();
            if ( linio.equals(logajMesagoj.teksto("headers.end")) ) {
                return i;
            }
            i = i + 1;
        }
        return 4;
    }

    /* បង្កើតឯកសារថ្មីដែលមានក្បាល
        @param celo ( File , មិនមែន null ) - ឯកសារដែលត្រូវបង្កើត
        @param kunteksto ( Kunteksto , មិនមែន null ) - ស្ថានភាពដំបូង
        @returns គ្មាន */
    private void kreiNovan(File celo, Kunteksto kunteksto) throws Exception {
        LudantoInfo info = kasxmemoro.get(kunteksto.uuid);
        String ip = kunteksto.ip;
        if ( info != null ) {
            ip = info.ip;
        }
        List<String> kapo = new ArrayList<>();
        kapo.add(logajMesagoj.formati("headers.player", "player", kunteksto.nomo));
        kapo.add(logajMesagoj.formati("headers.uuid", "uuid", kunteksto.uuid.toString()));
        kapo.add(logajMesagoj.formati(
            "headers.last-activity",
            "timestamp",
            stampiLastanAktivecon(kunteksto.momento)
        ));
        kapo.add(logajMesagoj.formati("headers.address", "address", ip));
        kapo.add("");
        kapo.add(logajMesagoj.teksto("headers.end"));
        kapo.add("");
        Files.write(celo.toPath(), kapo, StandardCharsets.UTF_8);
    }

    /* រៀបចំបន្ទាត់កំណត់ហេតុអ្នកលេង ដោយដាក់ឈ្មោះអ្នកលេងនៅចុងឃ្លា
        @param momento ( Instant , មិនមែន null ) - ពេលកើតឡើង
        @param tipo ( Tipo , មិនមែន null ) - ប្រភេទធាតុ
        @param nomo ( String , មិនមែន null ) - ឈ្មោះអ្នកលេង
        @param mesago ( String , មិនមែន null ) - អត្ថបទដែលបានសម្អាត
        @returns បន្ទាត់កំណត់ហេតុដែលបានរៀបចំ */
    private String formatiLudantanLinon(Instant momento, Tipo tipo, String nomo, String mesago) {
        String enhavo;
        if ( tipo.plenaFrazo()
            || ( tipo != Tipo.BABILO && kromprogramo.agordo().logiSubjektanMarkilon() ) ) {
            enhavo = mesago;
        } else {
            enhavo = logajMesagoj.formati(
                "formats.player-message",
                "player", nomo,
                "message", mesago
            );
        }
        return logajMesagoj.formati(
            "formats.log-line",
            "timestamp", stampi(momento),
            "type", tipo.etikedo(logajMesagoj),
            "message", enhavo
        );
    }

    /* បន្ថែមបន្ទាត់មួយទៅកំណត់ហេតុម៉ាស៊ីនមេប្រចាំថ្ងៃ
        @param momento ( Instant , មិនមែន null ) - ពេលវេលាដែលកើតឡើង
        @param tipo ( Tipo , មិនមែន null ) - ប្រភេទធាតុ
        @param nomo ( String , មិនមែន null ) - អ្នកលេង ឬ កុងសូល
        @param mesago ( String , មិនមែន null ) - អត្ថបទដែលបានសម្អាត
        @returns គ្មាន */
    private void aldoniAlServilo(Instant momento, Tipo tipo, String nomo, String mesago) {
        String linio = formatiServilanLinon(momento, tipo, nomo, mesago);
        String dosiernomo = S2veniTempo.dosiernomo(momento, kromprogramo.agordo().zono());
        File celo = new File(servilaDosierujo, dosiernomo);
        try {
            if ( celo.exists() == false ) {
                List<String> unua = new ArrayList<>();
                unua.add(linio);
                Files.write(celo.toPath(), unua, StandardCharsets.UTF_8);
                return;
            }
            List<String> malnovaj = Files.readAllLines(celo.toPath(), StandardCharsets.UTF_8);
            List<String> novaj = new ArrayList<>();
            novaj.add(linio);
            int i = 0;
            while ( i < malnovaj.size() ) {
                novaj.add(malnovaj.get(i));
                i = i + 1;
            }
            Files.write(celo.toPath(), novaj, StandardCharsets.UTF_8);
        } catch ( Exception eraro ) {
            kromprogramo.getLogger().warning(Mesagoj.servilaSkribo(dosiernomo));
        }
    }

    /* រៀបចំបន្ទាត់សម្រាប់ឯកសារម៉ាស៊ីនមេ
        @param momento ( Instant , មិនមែន null ) - ពេលវេលាដែលកើតឡើង
        @param tipo ( Tipo , មិនមែន null ) - ប្រភេទធាតុ
        @param nomo ( String , មិនមែន null ) - អ្នកលេង ឬ កុងសូល
        @param mesago ( String , មិនមែន null ) - អត្ថបទដែលបានសម្អាត
        @returns បន្ទាត់ដែលបានរៀបចំ */
    private String formatiServilanLinon(Instant momento, Tipo tipo, String nomo, String mesago) {
        String enhavo;
        if ( tipo.plenaFrazo()
            || ( tipo != Tipo.BABILO && kromprogramo.agordo().logiSubjektanMarkilon() ) ) {
            enhavo = mesago;
        } else if ( tipo == Tipo.KONZOLO ) {
            enhavo = mesago;
        } else {
            enhavo = logajMesagoj.formati(
                "formats.player-message",
                "player", nomo,
                "message", mesago
            );
        }
        return logajMesagoj.formati(
            "formats.log-line",
            "timestamp", stampi(momento),
            "type", tipo.etikedo(logajMesagoj),
            "message", enhavo
        );
    }

    /* បន្ថែមបន្ទាត់កុងសូលទៅឯកសារកុងសូល
        @param momento ( Instant , មិនមែន null ) - ពេលបញ្ជាត្រូវបានដំណើរការ
        @param mesago ( String , មិនមែន null ) - ពាក្យបញ្ជា ឬ ប្រយោគដែលបានសម្អាត
        @returns គ្មាន */
    private void aldoniAlKonzolo(Instant momento, String mesago) {
        File celo = dosieroPor(adminDosierujo, "konzolo");
        String stampo = stampi(momento);
        String linio = logajMesagoj.formati(
            "formats.log-line",
            "timestamp", stampo,
            "type", Tipo.KONZOLO.etikedo(logajMesagoj),
            "message", mesago
        );
        try {
            if ( celo.exists() == false ) {
                List<String> kapo = new ArrayList<>();
                String konzolo = logajMesagoj.teksto("names.console");
                kapo.add(logajMesagoj.formati("headers.console", "console", konzolo));
                kapo.add(logajMesagoj.formati("headers.console-identity", "console", konzolo));
                kapo.add(logajMesagoj.formati(
                    "headers.last-activity",
                    "timestamp",
                    stampiLastanAktivecon(momento)
                ));
                kapo.add(logajMesagoj.formati("headers.address", "address", logajMesagoj.teksto("names.unknown")));
                kapo.add("");
                kapo.add(logajMesagoj.teksto("headers.end"));
                kapo.add("");
                Files.write(celo.toPath(), kapo, StandardCharsets.UTF_8);
            }
            antaŭmetiPostKapo(celo, linio);
            ĝisdatigiKapon(celo, momento, null);
        } catch ( Exception eraro ) {
            kromprogramo.getLogger().warning(Mesagoj.WARN_KONZOLA_SKRIBO);
        }
    }

    /* បញ្ចូលបន្ទាត់ភ្លាមៗក្រោយក្បាល ដើម្បីដាក់ធាតុថ្មីបំផុតមុនគេ
        @param celo ( File , មិនមែន null ) - ឯកសារដែលត្រូវកែប្រែ
        @param linio ( String , មិនមែន null ) - បន្ទាត់ថ្មី
        @returns គ្មាន */
    private void antaŭmetiPostKapo(File celo, String linio) throws Exception {
        List<String> malnovaj = Files.readAllLines(celo.toPath(), StandardCharsets.UTF_8);
        int fino = kapoFino(malnovaj);
        List<String> novaj = new ArrayList<>(malnovaj.subList(0, fino));
        while ( novaj.isEmpty() == false
            && novaj.get(novaj.size() - 1).isBlank() ) {
            novaj.remove(novaj.size() - 1);
        }
        novaj.addAll(List.of("", logajMesagoj.teksto("headers.end"), "", linio));
        for (int i = fino + 1; i < malnovaj.size(); i = i + 1) {
            String malnovaLinio = malnovaj.get(i);
            if ( malnovaLinio.isBlank() == false ) {
                novaj.add(malnovaLinio);
            }
        }
        Files.write(celo.toPath(), novaj, StandardCharsets.UTF_8);
    }

    /* ធ្វើបច្ចុប្បន្នភាពសកម្មភាពចុងក្រោយនៅក្នុងក្បាលឯកសារ
        @param celo ( File , មិនមែន null ) - ឯកសារដែលត្រូវកែប្រែ
        @param momento ( Instant , មិនមែន null ) - ពេលវេលាថ្មី
        @returns គ្មាន */
    private void ĝisdatigiKapon(File celo, Instant momento, String novaIp) throws Exception {
        List<String> linioj = Files.readAllLines(celo.toPath(), StandardCharsets.UTF_8);
        String stampo = stampiLastanAktivecon(momento);
        String aktivaPrefikso = kapliniaPrefikso("headers.last-activity");
        String novaAktivaKapo = logajMesagoj.formati(
            "headers.last-activity",
            "timestamp",
            stampo
        );
        String adresaPrefikso = kapliniaPrefikso("headers.address");
        List<String> novaj = new ArrayList<>();
        int i = 0;
        while ( i < linioj.size() ) {
            String linio = linioj.get(i);
            if ( linio.startsWith(aktivaPrefikso) ) {
                novaj.add(novaAktivaKapo);
            } else if ( linio.startsWith(adresaPrefikso) && novaIp != null
                && novaIp.equals(logajMesagoj.teksto("names.unknown")) == false ) {
                String aktualajAdresoj = linio.substring(adresaPrefikso.length()).trim();
                List<String> adresoj = new ArrayList<>();
                if ( aktualajAdresoj.isEmpty() == false
                    && aktualajAdresoj.equals(logajMesagoj.teksto("names.unknown")) == false ) {
                    for (String adreso : aktualajAdresoj.split("\\s*｡\\s*")) {
                        if ( adreso.equals(novaIp) == false && adresoj.contains(adreso) == false ) {
                            adresoj.add(adreso);
                        }
                    }
                }
                adresoj.add(0, novaIp);
                novaj.add(logajMesagoj.formati(
                    "headers.address",
                    "address",
                    String.join(" ｡ ", adresoj)
                ));
            } else {
                novaj.add(linio);
            }
            i = i + 1;
        }
        Files.write(celo.toPath(), novaj, StandardCharsets.UTF_8);
    }

    private String stampi(Instant momento) {
        return stampi(momento, "formats.timestamp");
    }

    private String stampiLastanAktivecon(Instant momento) {
        return stampi(momento, "formats.last-activity");
    }

    private String stampi(Instant momento, String formato) {
        S2veniTempo.StampajPartoj partoj = S2veniTempo.stampajPartoj(
            momento,
            kromprogramo.agordo().zono()
        );
        return logajMesagoj.formati(
            formato,
            "year", partoj.jaro(),
            "month", partoj.monato(),
            "day", partoj.tago(),
            "hour", partoj.horo(),
            "minute", partoj.minuto(),
            "second", partoj.sekundo()
        );
    }

    private boolean estasKapaLinio(String linio) {
        if ( linio.trim().equals(logajMesagoj.teksto("headers.end")) ) {
            return true;
        }
        for (String ŝlosilo : logajMesagoj.tekstoj("headers.managed")) {
            if ( linio.startsWith(kapliniaPrefikso("headers." + ŝlosilo)) ) {
                return true;
            }
        }
        return false;
    }

    private String kapliniaPrefikso(String ŝlosilo) {
        String ŝablono = logajMesagoj.teksto(ŝlosilo);
        int lokilo = ŝablono.indexOf("%");
        if ( lokilo < 0 ) {
            return ŝablono;
        }
        return ŝablono.substring(0, lokilo);
    }
}
