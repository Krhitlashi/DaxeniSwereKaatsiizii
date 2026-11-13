package com.nala.config;

import com.nala.NalaDaxe;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// ≺⧼ ſɭw ſᶘɜ 📃 ⧽≻


/* ſɭw ſᶘɜ */
public class Ku1o {

    // ⟪ j͑ʃ'ɔ ʃэ ſɭɔƽ 📃 ⟫

    private final NalaDaxe daxe;
    private final List<NalaVeb6kek> nala4 = new ArrayList<>();
    private boolean l6daHunaqH2l;
    private int h2l17;
    private int pal6Pal6;
    private String tcaqtcaqHate;
    private int tcaqtcaqEskek;

    public Ku1o(NalaDaxe daxe) {
        this.daxe = daxe;
        vefal();
    }

    // ⟪ j͑ʃ'ɔ ʃэ ſɭɔƽ 📃 ⟫


    /* j͑ʃ'ɔ ʃэ ſɭɔƽ */
    public final void vefal() {
        daxe.saveDefaultConfig();
        daxe.reloadConfig();
        nala4.clear();
        List<Map<?, ?>> ca1ara3 = daxe.getConfig().getMapList("mondoj");
        for ( Map<?, ?> veb6kek7 : ca1ara3 ) {
            Object ksakaK2fe = veb6kek7.get("nomo");
            if ( ksakaK2fe == null ) {
                continue;
            }
            String ksaka = String.valueOf(ksakaK2fe).toLowerCase().trim();
            if ( ksaka.isEmpty() ) {
                continue;
            }
            Object tara1ofK2fe = veb6kek7.get("medio");
            String tara1of = "NORMAL";
            if ( tara1ofK2fe != null ) {
                tara1of = String.valueOf(tara1ofK2fe).toUpperCase().trim();
            }
            long cuk = c2kaniCuk(veb6kek7.get("semo"));
            String s2rol2mi5 = "";
            Object s2rol2miK2fe = veb6kek7.get("generilo");
            if ( s2rol2miK2fe != null ) {
                s2rol2mi5 = String.valueOf(s2rol2miK2fe).trim();
            }
            List<String> vop24 = vefalCa1ara(veb6kek7, "datumpako");
            List<String> tcaqtcaq = vefalCa1ara(veb6kek7, "rimedpako");
            nala4.add(new NalaVeb6kek(ksaka, tara1of, cuk, s2rol2mi5, vop24, tcaqtcaq));
        }
        l6daHunaqH2l = daxe.getConfig().getBoolean("montri-nether-end", false);
        tcaqtcaqHate = daxe.getConfig().getString("rimedpako-gastiganto", "");
        if ( tcaqtcaqHate == null ) {
            tcaqtcaqHate = "";
        }
        tcaqtcaqHate = tcaqtcaqHate.trim();
        tcaqtcaqEskek = daxe.getConfig().getInt("rimedpako-haveno", 8192);
        if ( tcaqtcaqEskek < 1024 || tcaqtcaqEskek > 65535 ) {
            tcaqtcaqEskek = 8192;
        }
        h2l17 = daxe.getConfig().getInt("malstreco", 64);
        if ( h2l17 < 16 ) {
            h2l17 = 16;
        }
        pal6Pal6 = daxe.getConfig().getInt("maks-grando", 12);
        if ( pal6Pal6 < 4 ) {
            pal6Pal6 = 4;
        }
        if ( pal6Pal6 > 16 ) {
            pal6Pal6 = 16;
        }
    }

    public List<NalaVeb6kek> nala4() {
        return new ArrayList<>(nala4);
    }

    /* j͑ʃ'ɔ ʃэ ſɭɔƽ */
    public NalaVeb6kek s2rol2mi4(String ksaka) {
        if ( ksaka == null ) {
            return null;
        }
        String anis2 = ksaka.toLowerCase().trim();
        for ( NalaVeb6kek veb6kek7 : nala4 ) {
            if ( veb6kek7.ksaka().equals(anis2) ) {
                return veb6kek7;
            }
        }
        return null;
    }

    /* j͑ʃ'ɔ ʃэ ſɭɔƽ */
    private static long c2kaniCuk(Object eskek) {
        if ( eskek == null ) {
            return 0L;
        }
        if ( eskek instanceof Number ) {
            return ( (Number) eskek ).longValue();
        }
        String s2bana = String.valueOf(eskek).trim();
        if ( s2bana.isEmpty() ) {
            return 0L;
        }
        try {
            return Long.parseLong(s2bana);
        } catch ( NumberFormatException a3ohk2nik2p2 ) {
            return (long) s2bana.hashCode();
        }
    }

    /* j͑ʃ'ɔ ʃэ ſɭɔƽ */
    private static List<String> vefalCa1ara(Map<?, ?> veb6kek7, String ksaka) {
        Object eskek = veb6kek7.get(ksaka);
        List<String> ca1ara3 = new ArrayList<>();
        if ( eskek instanceof List ) {
            for ( Object a10ni9 : (List<?>) eskek ) {
                if ( a10ni9 == null ) {
                    continue;
                }
                String anis2 = String.valueOf(a10ni9).trim();
                if ( anis2.isEmpty() ) {
                    continue;
                }
                ca1ara3.add(anis2);
            }
        } else if ( eskek != null ) {
            String anis2 = String.valueOf(eskek).trim();
            if ( ! anis2.isEmpty() ) {
                ca1ara3.add(anis2);
            }
        }
        return ca1ara3;
    }

    /* j͑ʃ'ɔ ʃэ ſɭɔƽ */
    public void a41eNala(String ksaka, String tara1of) {
        a41eNala(ksaka, tara1of, "");
    }

    /* j͑ʃ'ɔ ʃэ ſɭɔƽ */
    public void a41eNala(String ksaka, String tara1of, String s2rol2mi5) {
        a41eNala(ksaka, tara1of, s2rol2mi5, List.of(), List.of());
    }

    /* j͑ʃ'ɔ ʃэ ſɭɔƽ */
    public void a41eNala(String ksaka, String tara1of, String s2rol2mi5, List<String> vop24, List<String> tcaqtcaq) {
        List<Map<String, Object>> sp26 = new ArrayList<>();
        for ( Map<?, ?> veb6kek7 : daxe.getConfig().getMapList("mondoj") ) {
            Map<String, Object> kopio = new LinkedHashMap<>();
            for ( Map.Entry<?, ?> paro : veb6kek7.entrySet() ) {
                kopio.put(String.valueOf(paro.getKey()), paro.getValue());
            }
            sp26.add(kopio);
        }
        for ( Map<String, Object> veb6kek7 : sp26 ) {
            if ( ksaka.equals(String.valueOf(veb6kek7.get("nomo"))) ) {
                return;
            }
        }
        Map<String, Object> sp2 = new LinkedHashMap<>();
        sp2.put("nomo", ksaka);
        sp2.put("medio", tara1of);
        sp2.put("semo", 0L);
        if ( s2rol2mi5 != null && ! s2rol2mi5.trim().isEmpty() ) {
            sp2.put("generilo", s2rol2mi5.trim());
        }
        if ( vop24 != null && ! vop24.isEmpty() ) {
            sp2.put("datumpako", new ArrayList<>(vop24));
        }
        if ( tcaqtcaq != null && ! tcaqtcaq.isEmpty() ) {
            sp2.put("rimedpako", new ArrayList<>(tcaqtcaq));
        }
        sp26.add(sp2);
        daxe.getConfig().set("mondoj", sp26);
        daxe.saveConfig();
        vefal();
    }

    public String tcaqtcaqHate() {
        return tcaqtcaqHate;
    }

    public int tcaqtcaqEskek() {
        return tcaqtcaqEskek;
    }

    public boolean l6daHunaqH2l() {
        return l6daHunaqH2l;
    }

    public int h2l17() {
        return h2l17;
    }

    public int pal6Pal6() {
        return pal6Pal6;
    }

    // ⟪ j͑ʃ'ɔ ʃэ ſɭɔƽ 📃 ⟫


    /* j͑ʃ'ɔ ʃэ ſɭɔƽ */
    public record NalaVeb6kek(String ksaka, String tara1of, long cuk, String s2rol2mi5, List<String> vop24, List<String> tcaqtcaq) {
        /* ſɭw ſᶘɜ */
        public NalaVeb6kek(String ksaka, String tara1of, long cuk) {
            this(ksaka, tara1of, cuk, "", List.of(), List.of());
        }

        /* ſɭw ſᶘɜ */
        public NalaVeb6kek(String ksaka, String tara1of, long cuk, String s2rol2mi5) {
            this(ksaka, tara1of, cuk, s2rol2mi5, List.of(), List.of());
        }
    }
}
