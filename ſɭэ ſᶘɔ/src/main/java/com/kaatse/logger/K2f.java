package com.kaatse.logger;

import com.kaatse.KaatseDaxe;
import com.kaatse.config.K2fS2bana;
import com.kaatse.config.S2bana;
import com.kaatse.tempo.S2veniGani;
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

// ≺⧼ ſɭɹʞ 📃 ⧽≻


/* ſɭɹʞ */
public class K2f {

    // ⟪ ı],ɔ ֭ſɭᴜ ɭʃɔ 📃 ⟫

    public enum Xehate {
        ARAK61E("chat", false),
        ESKEK2("command", false),
        VEB6KEK("join", true),
        XARAQ("leave", true),
        CAM2("death", true),
        H2L("kick", true),
        VEPAQ("advancement", true),
        TARA10("console", false),
        HATE_J3A("server-start", true),
        HATE_H2L("server-stop", true),
        NALA_VE3AQ("world-save", true);

        private final String ca3aq;
        private final boolean pal6Ox2pewa;

        Xehate(String ca3aq, boolean pal6Ox2pewa) {
            this.ca3aq = ca3aq;
            this.pal6Ox2pewa = pal6Ox2pewa;
        }

        public String xehate(K2fS2bana k2fS2bana) {
            return k2fS2bana.s2bana("types." + ca3aq);
        }

        public boolean pal6Ox2pewa() {
            return pal6Ox2pewa;
        }
    }

    // ⟨ ֭ſɭȝɹ ʌ j͑ʃ'ɜ ſןɹ 📃 ⟩

    private static final class Hq2Vop2 {
        final String ksaka;
        final UUID ksaka2;
        String ruva;
        Instant hunaq;

        Hq2Vop2(String ksaka, UUID ksaka2, String ruva, Instant hunaq) {
            this.ksaka = ksaka;
            this.ksaka2 = ksaka2;
            this.ruva = ruva;
            this.hunaq = hunaq;
        }
    }

    // ⟨ ſɭɔ }ʃᴜ j͐ʃᴜ 📃 ⟩

    private static final class Kenala {
        final String ksaka;
        final UUID ksaka2;
        final String ruva;
        final boolean makamaj6fi;
        final Instant gani;

        Kenala(String ksaka, UUID ksaka2, String ruva, boolean makamaj6fi, Instant gani) {
            this.ksaka = ksaka;
            this.ksaka2 = ksaka2;
            this.ruva = ruva;
            this.makamaj6fi = makamaj6fi;
            this.gani = gani;
        }
    }

    // ⟪ K2f 📃 ⟫

    private final KaatseDaxe daxe;
    private final K2fS2bana k2fS2bana;
    private final File hq2Fal3aqai;
    private final File makamaj6fiFal3aqai;
    private final File hateFal3aqai;
    private final ExecutorService eskek222;
    private final Map<UUID, Hq2Vop2> h2l5 = new ConcurrentHashMap<>();

    public K2f(KaatseDaxe daxe) {
        this.daxe = daxe;
        try {
            this.k2fS2bana = new K2fS2bana(daxe);
        } catch ( IOException | org.bukkit.configuration.InvalidConfigurationException a3ohk2nik2p2 ) {
            throw new IllegalStateException("មិនអាចអានសារកំណត់ហេតុបានទេ", a3ohk2nik2p2);
        }
        File vop2Fal3aqai = daxe.getDataFolder();
        this.hq2Fal3aqai = new File(vop2Fal3aqai, "ludantoj");
        this.makamaj6fiFal3aqai = new File(vop2Fal3aqai, "adminoj");
        this.hateFal3aqai = new File(vop2Fal3aqai, "servilo");
        vepaqFal3aqai(this.hq2Fal3aqai);
        vepaqFal3aqai(this.makamaj6fiFal3aqai);
        vepaqFal3aqai(this.hateFal3aqai);
        this.eskek222 = Executors.newSingleThreadExecutor((Runnable pabok) -> {
            Thread kna = new Thread(pabok, "ſɭэ ſᶘɔ-protokolo");
            kna.setDaemon(true);
            return kna;
        });
    }

    /* j͑ʃ'ɔ ſןᴜȝ ʌ ſɭw ʃᴜ ʌ ⺓ ʌ vepaqFal3aqai ⟅ */
    private void vepaqFal3aqai(File fal3aqai) {
        if ( fal3aqai.exists() ) {
            return;
        }
        boolean a10ni2 = fal3aqai.mkdirs();
        if ( a10ni2 == false ) {
            daxe.getLogger().warning(S2bana.fal3aqai(fal3aqai.getName()));
        }
    }

    /* ֭ſɭɹ j͐ʃэⅎ */
    public void h2l4() {
        eskek222.shutdown();
        try {
            boolean h2l6 = eskek222.awaitTermination(10L, TimeUnit.SECONDS);
            if ( h2l6 == false ) {
                eskek222.shutdownNow();
            }
        } catch ( InterruptedException a3ohk2nik2p2 ) {
            eskek222.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    // ⟪ ı],ɔ ֭ſɭᴜ ɭʃɔ ʌ ŋᷠᴜ ſɭᴜ ŋᷠᴜ ɭl̀э ſȷꞇ 📃 ⟫


    /* ı],ɔ ֭ſɭᴜ ɭʃɔ ʌ ŋᷠᴜ ſɭᴜ ŋᷠᴜ ɭl̀э ſȷꞇ */
    public boolean xehateMakamaj6fi(Player hq2) {
        if ( hq2.isOp() ) {
            return true;
        }
        String ek6 = daxe.ku1o().makamaj6fiEk6();
        return hq2.hasPermission(ek6);
    }

    /* ı],ɔ ֭ſɭᴜ ɭʃɔ ʌ ŋᷠᴜ ſɭᴜ ŋᷠᴜ ɭl̀э ſȷꞇ */
    public boolean xehateMakamaj6fi(OfflinePlayer hq2) {
        if ( hq2.isOp() ) {
            return true;
        }
        return false;
    }

    // ⟪ ſɭɹʞ ʌ ꞁȷ̀ᴜ ɽ͑ʃ'ᴜ ſɭэ ſᶘɔ ʌ ⺓ ʌ ɭʃƽᴜͷ̗ ⟅ 📃 ⟫


    /* ſɭɹʞ ʌ ꞁȷ̀ᴜ ɽ͑ʃ'ᴜ ſɭэ ſᶘɔ ʌ ⺓ ʌ ɭʃƽᴜͷ̗ ⟅ */
    public void k2fArak61e(Player hq2, String s2bana3) {
        if ( daxe.ku1o().k2fArak61e() == false ) {
            return;
        }
        Kenala kenala = tarohaKenala(hq2);
        String anisS2bana2 = anisS2bana(s2bana3);
        eskek222.execute(() -> a41eVeb6kek(kenala, Xehate.ARAK61E, anisS2bana2));
    }

    /* ſɭɹʞ ʌ j͑ʃ'ᴜ j͐ʃw ɭl̀ɹ ɹ */
    public void k2fValuj22(Player hq2, String eskek22) {
        if ( daxe.ku1o().k2fValuj2() == false ) {
            return;
        }
        Kenala kenala = tarohaKenala(hq2);
        String anisValuj2 = anisS2bana(eskek22);
        String ox2pewa = daxe.ku1o().k2fHq2Xehate()
            ? k2fS2bana.knakehe(
                "sentences.player-command",
                "command", anisValuj2,
                "player", kenala.ksaka
            )
            : anisValuj2;
        eskek222.execute(() -> a41eVeb6kek(kenala, Xehate.ESKEK2, ox2pewa));
    }

    /* ſɭɹʞ ʌ j͑ʃ'ɔ ʃэ ſɭɔƽ */
    public void k2fVeb6kek(Player hq2) {
        if ( daxe.ku1o().k2fC2kani() == false ) {
            return;
        }
        Kenala kenala = tarohaKenala(hq2);
        String s2bana3 = k2fS2bana.knakehe("sentences.player-join", "player", kenala.ksaka);
        eskek222.execute(() -> a41eVeb6kek(kenala, Xehate.VEB6KEK, s2bana3));
    }

    /* ſɭɹʞ ʌ ı],ᴜ ɽ͑ʃ'ᴜȝ */
    public void k2fXaraq(Player hq2) {
        if ( daxe.ku1o().k2fC2kani() == false ) {
            return;
        }
        Kenala kenala = tarohaKenala(hq2);
        String s2bana3 = k2fS2bana.knakehe("sentences.player-leave", "player", kenala.ksaka);
        eskek222.execute(() -> a41eVeb6kek(kenala, Xehate.XARAQ, s2bana3));
    }

    public void k2fCam22(Player hq2) {
        if ( daxe.ku1o().k2fHateCal() == false
            || daxe.ku1o().k2fCam2() == false ) {
            return;
        }
        Kenala kenala = tarohaKenala(hq2);
        String s2bana3 = k2fS2bana.knakehe("sentences.player-death", "player", kenala.ksaka);
        eskek222.execute(() -> a41eVeb6kek(kenala, Xehate.CAM2, s2bana3));
    }

    public void k2fH2l2(Player hq2) {
        if ( daxe.ku1o().k2fHateCal() == false
            || daxe.ku1o().k2fH2l() == false ) {
            return;
        }
        Kenala kenala = tarohaKenala(hq2);
        String s2bana3 = k2fS2bana.knakehe(
            "sentences.player-kick",
            "player", kenala.ksaka,
            "server", k2fS2bana.s2bana("names.server")
        );
        eskek222.execute(() -> a41eVeb6kek(kenala, Xehate.H2L, s2bana3));
    }

    public void k2fVepaq2(Player hq2, String hate) {
        if ( daxe.ku1o().k2fHateCal() == false
            || daxe.ku1o().k2fVepaq() == false ) {
            return;
        }
        Kenala kenala = tarohaKenala(hq2);
        String s2bana3 = k2fS2bana.knakehe(
            "sentences.player-advancement",
            "advancement", anisS2bana(hate),
            "player", kenala.ksaka
        );
        eskek222.execute(() -> a41eVeb6kek(kenala, Xehate.VEPAQ, s2bana3));
    }

    public void k2fHateJ3a() {
        if ( daxe.ku1o().k2fHateSp2() == false ) {
            return;
        }
        k2fHateCal2(
            Xehate.HATE_J3A,
            k2fS2bana.knakehe("sentences.server-start", "server", k2fS2bana.s2bana("names.server"))
        );
    }

    public void k2fHateH2l() {
        if ( daxe.ku1o().k2fHateSp2() == false ) {
            return;
        }
        k2fHateCal2(
            Xehate.HATE_H2L,
            k2fS2bana.knakehe("sentences.server-stop", "server", k2fS2bana.s2bana("names.server"))
        );
    }

    public void k2fNalaVe3aq2(String nalaKsaka) {
        if ( daxe.ku1o().k2fNalaVe3aq() == false ) {
            return;
        }
        k2fHateCal2(
            Xehate.NALA_VE3AQ,
            k2fS2bana.knakehe(
                "sentences.world-save",
                "world", anisS2bana(nalaKsaka),
                "server", k2fS2bana.s2bana("names.server")
            )
        );
    }

    private void k2fHateCal2(Xehate xehate2, String s2bana3) {
        if ( daxe.ku1o().k2fHateCal() == false ) {
            return;
        }
        Instant gani = Instant.now();
        String tara10 = k2fS2bana.s2bana("names.console");
        eskek222.execute(() -> a41eZeniHate(gani, xehate2, tara10, s2bana3));
    }

    /* ſɭɹʞ ʌ ɭʃᴜ ɽ͑ʃ'ᴜ ſᶘɔⅎ */
    public void k2fTara10(String eskek22) {
        if ( daxe.ku1o().k2fTara10() == false ) {
            return;
        }
        Instant gani = Instant.now();
        String anis = anisS2bana(eskek22);
        String ox2pewa = daxe.ku1o().k2fHq2Xehate()
            ? k2fS2bana.knakehe(
                "sentences.console-command",
                "command", anis,
                "console", k2fS2bana.s2bana("names.console")
            )
            : anis;
        String ksakaTara10 = k2fS2bana.s2bana("names.console");
        eskek222.execute(() -> {
            a41eZeniHate(gani, Xehate.TARA10, ksakaTara10, ox2pewa);
            a41eZeniTara10(gani, ox2pewa);
        });
    }

    /* j͑ʃɹ ɽ͑ʃ'ɜ j͐ʃɹ ŋᷠꞇ ʌ ſɟɹ ſɭᴜ }ʃꞇ ʌ ı],ᴜ ɽ͑ʃ'ᴜȝ */
    public void s2rol2miC2kaniXaraq(Player hq2) {
        Kenala kenala = tarohaKenala(hq2);
        eskek222.execute(() -> xaraqKenalaQ2q(kenala));
    }

    // ⟪ ɭʃᴜ ɽ͑ʃ'ɜ ֭ſɭᴜ ʌ ſɭɔ }ʃᴜ j͐ʃᴜ 📃 ⟫


    /* ɭʃᴜ ɽ͑ʃ'ɜ ֭ſɭᴜ ʌ ſɭɔ }ʃᴜ j͐ʃᴜ */
    private Kenala tarohaKenala(Player hq2) {
        String ksaka = hq2.getName();
        UUID ksaka2 = hq2.getUniqueId();
        String ruva = ruva2(hq2);
        boolean makamaj6fi = xehateMakamaj6fi(hq2);
        Instant gani = Instant.now();
        ts2tosaxH2l(ksaka, ksaka2, ruva, gani);
        return new Kenala(ksaka, ksaka2, ruva, makamaj6fi, gani);
    }

    /* ſᶘɹ ɭʃɜ j͑ʃᴜᶗ‹ ʌ ֭ſɭɹͷ̗ */
    private void ts2tosaxH2l(String ksaka, UUID ksaka2, String ruva, Instant gani) {
        Hq2Vop2 hunaq2 = h2l5.get(ksaka2);
        if ( hunaq2 == null ) {
            h2l5.put(ksaka2, new Hq2Vop2(ksaka, ksaka2, ruva, gani));
            return;
        }
        hunaq2.ruva = ruva;
        hunaq2.hunaq = gani;
    }

    /* ɽ͑ʃ'w j͑ʃ'ᴜ ɹ */
    private String ruva2(Player hq2) {
        try {
            if ( hq2.getAddress() == null ) {
                return k2fS2bana.s2bana("names.unknown");
            }
            if ( hq2.getAddress().getAddress() == null ) {
                return k2fS2bana.s2bana("names.unknown");
            }
            return hq2.getAddress().getAddress().getHostAddress();
        } catch ( Exception a3ohk2nik2p2 ) {
            return k2fS2bana.s2bana("names.unknown");
        }
    }

    // ⟪ эⅎ ſᶘɔ ʌ j͑ʃ'ɔ ʃэ ſɭɔƽ 📃 ⟫


    /* эⅎ ſᶘɔ ʌ j͑ʃ'ɔ ʃэ ſɭɔƽ */
    private void a41eVeb6kek(Kenala kenala, Xehate xehate2, String s2bana3) {
        String anis = anisS2bana(s2bana3);
        File fal3aqai;
        if ( kenala.makamaj6fi ) {
            fal3aqai = makamaj6fiFal3aqai;
        } else {
            fal3aqai = hq2Fal3aqai;
        }
        File kxawa = cakavop2Zeni(fal3aqai, kenala.ksaka);
        xaraqKenalaQ2q(kenala);
        String ox2pewa2 = knakeheHq2Ox2pewa(kenala.gani, xehate2, kenala.ksaka, anis);
        try {
            if ( kxawa.exists() == false ) {
                vepaqSp2(kxawa, kenala);
            }
            hunaqAraqCaka3aq(kxawa, ox2pewa2);
            ts2tosaxCaka3aq(kxawa, kenala.gani, kenala.ruva);
        } catch ( Exception a3ohk2nik2p2 ) {
            daxe.getLogger().warning(S2bana.k2f(kxawa.getName()));
        }
        a41eZeniHate(kenala.gani, xehate2, kenala.ksaka, anis);
    }

    /* ſɟᴜ ſɭᴜ j͑ʃ'ɜ ſןɹ ʌ ſɭ,ɔ }ʃꞇ */
    private File cakavop2Zeni(File fal3aqai, String ksaka) {
        String anis2 = anisKsaka(ksaka);
        return new File(fal3aqai, anis2 + ".txt");
    }

    /* ᴜ }ʃꞇɔ˞ ʌ ſɭɔ˞ᴜ ſɭᴜ */
    private String anisKsaka(String ksaka) {
        String anis2 = ksaka.replaceAll("[^A-Za-z0-9._-]", "_");
        if ( anis2.isEmpty() ) {
            return k2fS2bana.s2bana("names.unknown");
        }
        return anis2;
    }

    /* ᴜ }ʃꞇɔ˞ ʌ j͑ʃɹ ʃᴜ }ʃᴜ */
    private String anisS2bana(String s2bana) {
        if ( s2bana == null ) {
            return "";
        }
        String h2lOx2pewa = s2bana.replace("\r", " ").replace("\n", " ");
        return h2lOx2pewa.trim();
    }

    /* ı],ᴜ ɽ͑ʃ'ᴜȝ ʌ ſɭɔ }ʃᴜ j͐ʃᴜ ʌ ſ͕ɭɹȝ */
    private void xaraqKenalaQ2q(Kenala kenala) {
        File s2rol2mi2;
        File yor2;
        if ( kenala.makamaj6fi ) {
            s2rol2mi2 = cakavop2Zeni(makamaj6fiFal3aqai, kenala.ksaka);
            yor2 = cakavop2Zeni(hq2Fal3aqai, kenala.ksaka);
        } else {
            s2rol2mi2 = cakavop2Zeni(hq2Fal3aqai, kenala.ksaka);
            yor2 = cakavop2Zeni(makamaj6fiFal3aqai, kenala.ksaka);
        }
        if ( yor2.exists() == false ) {
            return;
        }
        if ( s2rol2mi2.exists() ) {
            try {
                c2kani2(yor2, s2rol2mi2);
            } catch ( Exception a3ohk2nik2p2 ) {
                daxe.getLogger().warning(S2bana.c2kani(kenala.ksaka));
                return;
            }
            boolean h2l7 = yor2.delete();
            if ( h2l7 == false ) {
                daxe.getLogger().warning(S2bana.h2l2(yor2.getName()));
            }
            return;
        }
        try {
            Files.move(yor2.toPath(), s2rol2mi2.toPath());
        } catch ( Exception a3ohk2nik2p2 ) {
            daxe.getLogger().warning(S2bana.xaraq(kenala.ksaka));
        }
    }

    /* ſɟɹ ſɭᴜ }ʃꞇ ɹ */
    private void c2kani2(File a1iq, File kxawa) throws Exception {
        List<String> a1iq2 = Files.readAllLines(a1iq.toPath(), StandardCharsets.UTF_8);
        List<String> kxawa2 = Files.readAllLines(kxawa.toPath(), StandardCharsets.UTF_8);
        int h2l8 = caka3aqH2l(kxawa2);
        List<String> c2kani3 = new ArrayList<>();
        int k2fe = 0;
        while ( k2fe <= h2l8 ) {
            c2kani3.add(kxawa2.get(k2fe));
            k2fe = k2fe + 1;
        }
        int k2fe2 = h2l8 + 1;
        while ( k2fe2 < a1iq2.size() ) {
            String ox2pewa2 = a1iq2.get(k2fe2);
            if ( xehateCaka3aqOx2pewa(ox2pewa2) == false ) {
                c2kani3.add(ox2pewa2);
            }
            k2fe2 = k2fe2 + 1;
        }
        int k2fe3 = h2l8 + 1;
        while ( k2fe3 < kxawa2.size() ) {
            c2kani3.add(kxawa2.get(k2fe3));
            k2fe3 = k2fe3 + 1;
        }
        Files.write(kxawa.toPath(), c2kani3, StandardCharsets.UTF_8);
    }

    /* ſɟᴜ ſɭᴜ ſ̀ȷᴜȝ ʌ ֭ſɭɹͷ̗ */
    private int caka3aqH2l(List<String> ox2pewa3) {
        int k2fe = 0;
        while ( k2fe < ox2pewa3.size() ) {
            String ox2pewa2 = ox2pewa3.get(k2fe).trim();
            if ( ox2pewa2.equals(k2fS2bana.s2bana("headers.end")) ) {
                return k2fe;
            }
            k2fe = k2fe + 1;
        }
        return 4;
    }

    /* j͑ʃ'ɔ ſןᴜȝ ʌ j͑ʃɘɹ */
    private void vepaqSp2(File kxawa, Kenala kenala) throws Exception {
        Hq2Vop2 vop2 = h2l5.get(kenala.ksaka2);
        String ruva = kenala.ruva;
        if ( vop2 != null ) {
            ruva = vop2.ruva;
        }
        List<String> caka3aq = new ArrayList<>();
        caka3aq.add(k2fS2bana.knakehe("headers.player", "player", kenala.ksaka));
        caka3aq.add(k2fS2bana.knakehe("headers.uuid", "uuid", kenala.ksaka2.toString()));
        caka3aq.add(k2fS2bana.knakehe(
            "headers.last-activity",
            "timestamp",
            k2fHunaqSp2(kenala.gani)
        ));
        caka3aq.add(k2fS2bana.knakehe("headers.address", "address", ruva));
        caka3aq.add("");
        caka3aq.add(k2fS2bana.s2bana("headers.end"));
        caka3aq.add("");
        Files.write(kxawa.toPath(), caka3aq, StandardCharsets.UTF_8);
    }

    /* ſɭc̗ᴜ ſɭɔ ֭ſɭɔ ʌ ֭ſɭȝɹ ʌ ɜ ı],ɹ ſןɔ ᶅſᴜ */
    private String knakeheHq2Ox2pewa(Instant gani, Xehate xehate2, String ksaka, String s2bana3) {
        String vop22;
        if ( xehate2.pal6Ox2pewa()
            || ( xehate2 != Xehate.ARAK61E && daxe.ku1o().k2fHq2Xehate() ) ) {
            vop22 = s2bana3;
        } else {
            vop22 = k2fS2bana.knakehe(
                "formats.player-message",
                "player", ksaka,
                "message", s2bana3
            );
        }
        return k2fS2bana.knakehe(
            "formats.log-line",
            "timestamp", k2f4(gani),
            "type", xehate2.xehate(k2fS2bana),
            "message", vop22
        );
    }

    /* эⅎ ſᶘɔ ʌ ſɭ,ɔ }ʃꞇ ʌ ֭ſɭᴜ ɭʃɔ */
    private void a41eZeniHate(Instant gani, Xehate xehate2, String ksaka, String s2bana3) {
        String ox2pewa2 = knakeheHateOx2pewa(gani, xehate2, ksaka, s2bana3);
        String cakavop22 = S2veniGani.cakavop22(gani, daxe.ku1o().araq());
        File kxawa = new File(hateFal3aqai, cakavop22);
        try {
            if ( kxawa.exists() == false ) {
                List<String> k2fe4 = new ArrayList<>();
                k2fe4.add(ox2pewa2);
                Files.write(kxawa.toPath(), k2fe4, StandardCharsets.UTF_8);
                return;
            }
            List<String> hunaq3 = Files.readAllLines(kxawa.toPath(), StandardCharsets.UTF_8);
            List<String> sp2 = new ArrayList<>();
            sp2.add(ox2pewa2);
            int k2fe = 0;
            while ( k2fe < hunaq3.size() ) {
                sp2.add(hunaq3.get(k2fe));
                k2fe = k2fe + 1;
            }
            Files.write(kxawa.toPath(), sp2, StandardCharsets.UTF_8);
        } catch ( Exception a3ohk2nik2p2 ) {
            daxe.getLogger().warning(S2bana.hateK2f(cakavop22));
        }
    }

    /* ſɭc̗ᴜ ſɭɔ ֭ſɭɔ ʌ ֭ſɭᴜ ɭʃɔ ʌ ɜ ı],ɹ ſןɔ ᶅſᴜ */
    private String knakeheHateOx2pewa(Instant gani, Xehate xehate2, String ksaka, String s2bana3) {
        String vop22;
        if ( xehate2.pal6Ox2pewa()
            || ( xehate2 != Xehate.ARAK61E && daxe.ku1o().k2fHq2Xehate() ) ) {
            vop22 = s2bana3;
        } else if ( xehate2 == Xehate.TARA10 ) {
            vop22 = s2bana3;
        } else {
            vop22 = k2fS2bana.knakehe(
                "formats.player-message",
                "player", ksaka,
                "message", s2bana3
            );
        }
        return k2fS2bana.knakehe(
            "formats.log-line",
            "timestamp", k2f4(gani),
            "type", xehate2.xehate(k2fS2bana),
            "message", vop22
        );
    }

    /* эⅎ ſᶘɔ ʌ ſɭ,ɔ }ʃꞇ ʌ ɭʃᴜ ɽ͑ʃ'ᴜ ſᶘɔⅎ */
    private void a41eZeniTara10(Instant gani, String s2bana3) {
        File kxawa = cakavop2Zeni(makamaj6fiFal3aqai, "konzolo");
        String k2f5 = k2f4(gani);
        String ox2pewa2 = k2fS2bana.knakehe(
            "formats.log-line",
            "timestamp", k2f5,
            "type", Xehate.TARA10.xehate(k2fS2bana),
            "message", s2bana3
        );
        try {
            if ( kxawa.exists() == false ) {
                List<String> caka3aq = new ArrayList<>();
                String tara10 = k2fS2bana.s2bana("names.console");
                caka3aq.add(k2fS2bana.knakehe("headers.console", "console", tara10));
                caka3aq.add(k2fS2bana.knakehe("headers.console-identity", "console", tara10));
                caka3aq.add(k2fS2bana.knakehe(
                    "headers.last-activity",
                    "timestamp",
                    k2fHunaqSp2(gani)
                ));
                caka3aq.add(k2fS2bana.knakehe("headers.address", "address", k2fS2bana.s2bana("names.unknown")));
                caka3aq.add("");
                caka3aq.add(k2fS2bana.s2bana("headers.end"));
                caka3aq.add("");
                Files.write(kxawa.toPath(), caka3aq, StandardCharsets.UTF_8);
            }
            hunaqAraqCaka3aq(kxawa, ox2pewa2);
            ts2tosaxCaka3aq(kxawa, gani, null);
        } catch ( Exception a3ohk2nik2p2 ) {
            daxe.getLogger().warning(S2bana.A3OHK2NIK2P2_TARA10_K2F);
        }
    }

    /* ֭ſɭw }ʃᴜȝ ʌ ᴜ ɽ͑ʃ'ᴜȝ ʌ ſɟᴜ ſɭᴜ ſ̀ȷᴜȝ */
    private void hunaqAraqCaka3aq(File kxawa, String ox2pewa2) throws Exception {
        List<String> hunaq3 = Files.readAllLines(kxawa.toPath(), StandardCharsets.UTF_8);
        int h2l8 = caka3aqH2l(hunaq3);
        List<String> sp2 = new ArrayList<>(hunaq3.subList(0, h2l8));
        while ( sp2.isEmpty() == false
            && sp2.get(sp2.size() - 1).isBlank() ) {
            sp2.remove(sp2.size() - 1);
        }
        sp2.addAll(List.of("", k2fS2bana.s2bana("headers.end"), "", ox2pewa2));
        for (int k2fe = h2l8 + 1; k2fe < hunaq3.size(); k2fe = k2fe + 1) {
            String hunaqOx2pewa = hunaq3.get(k2fe);
            if ( hunaqOx2pewa.isBlank() == false ) {
                sp2.add(hunaqOx2pewa);
            }
        }
        Files.write(kxawa.toPath(), sp2, StandardCharsets.UTF_8);
    }

    /* ſᶘɹ ɭʃɜ j͑ʃᴜᶗ‹ ʌ ſɟᴜ ſɭᴜ ſ̀ȷᴜȝ */
    private void ts2tosaxCaka3aq(File kxawa, Instant gani, String sp2Ruva) throws Exception {
        List<String> ox2pewa3 = Files.readAllLines(kxawa.toPath(), StandardCharsets.UTF_8);
        String k2f5 = k2fHunaqSp2(gani);
        String sp2Ruva2 = caka3aqRuva("headers.last-activity");
        String sp2Sp2Caka3aq = k2fS2bana.knakehe(
            "headers.last-activity",
            "timestamp",
            k2f5
        );
        String ruvaRuva = caka3aqRuva("headers.address");
        List<String> sp2 = new ArrayList<>();
        int k2fe = 0;
        while ( k2fe < ox2pewa3.size() ) {
            String ox2pewa2 = ox2pewa3.get(k2fe);
            if ( ox2pewa2.startsWith(sp2Ruva2) ) {
                sp2.add(sp2Sp2Caka3aq);
            } else if ( ox2pewa2.startsWith(ruvaRuva) && sp2Ruva != null
                && sp2Ruva.equals(k2fS2bana.s2bana("names.unknown")) == false ) {
                String sp2Ruva3 = ox2pewa2.substring(ruvaRuva.length()).trim();
                List<String> ruva3 = new ArrayList<>();
                if ( sp2Ruva3.isEmpty() == false
                    && sp2Ruva3.equals(k2fS2bana.s2bana("names.unknown")) == false ) {
                    for (String ruva4 : sp2Ruva3.split("\\s*｡\\s*")) {
                        if ( ruva4.equals(sp2Ruva) == false && ruva3.contains(ruva4) == false ) {
                            ruva3.add(ruva4);
                        }
                    }
                }
                ruva3.add(0, sp2Ruva);
                sp2.add(k2fS2bana.knakehe(
                    "headers.address",
                    "address",
                    String.join(" ｡ ", ruva3)
                ));
            } else {
                sp2.add(ox2pewa2);
            }
            k2fe = k2fe + 1;
        }
        Files.write(kxawa.toPath(), sp2, StandardCharsets.UTF_8);
    }

    private String k2f4(Instant gani) {
        return k2f4(gani, "formats.timestamp");
    }

    private String k2fHunaqSp2(Instant gani) {
        return k2f4(gani, "formats.last-activity");
    }

    private String k2f4(Instant gani, String knakehe3) {
        S2veniGani.K2f10ni a10ni3 = S2veniGani.k2f10ni(
            gani,
            daxe.ku1o().araq()
        );
        return k2fS2bana.knakehe(
            knakehe3,
            "year", a10ni3.gani2(),
            "month", a10ni3.gani3(),
            "day", a10ni3.gani4(),
            "hour", a10ni3.gani5(),
            "minute", a10ni3.k2fe5(),
            "second", a10ni3.gani6()
        );
    }

    private boolean xehateCaka3aqOx2pewa(String ox2pewa2) {
        if ( ox2pewa2.trim().equals(k2fS2bana.s2bana("headers.end")) ) {
            return true;
        }
        for (String ca3aq : k2fS2bana.s2bana2("headers.managed")) {
            if ( ox2pewa2.startsWith(caka3aqRuva("headers." + ca3aq)) ) {
                return true;
            }
        }
        return false;
    }

    private String caka3aqRuva(String ca3aq) {
        String knakehe2 = k2fS2bana.s2bana(ca3aq);
        int araq2 = knakehe2.indexOf("%");
        if ( araq2 < 0 ) {
            return knakehe2;
        }
        return knakehe2.substring(0, araq2);
    }
}
