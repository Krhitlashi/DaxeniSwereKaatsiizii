package com.nala.config;

import com.nala.NalaPlugin;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// ≺⧼ ការកំណត់ 📃 ⧽≻
// ការកំណត់កម្មវិធីជំនួយ

/* ការកំណត់ដែលបានអានពី config.yml ជាមួយបញ្ជីពិភពលោក
    @param kromprogramo ( NalaPlugin , មិនមែន null ) - កម្មវិធីជំនួយចម្បង
    @returns ការកំណត់ថ្មី */
public class Agordo {

    // ⟪ ទិន្នន័យកំណត់ 📃 ⟫
    // ទិន្នន័យកំណត់
    private final NalaPlugin kromprogramo;
    private final List<MondaEniro> mondoj = new ArrayList<>();
    private boolean montriNetherEnd;
    private int malstreco;
    private int maksGrando;
    private String rimedpakoGastiganto;
    private int rimedpakoHaveno;

    public Agordo(NalaPlugin kromprogramo) {
        this.kromprogramo = kromprogramo;
        relegi();
    }

    // ⟪ អានឡើងវិញ 📃 ⟫
    // អានឡើងវិញពីឯកសារ

    /* អានតម្លៃឡើងវិញពី config.yml
        @returns គ្មាន */
    public final void relegi() {
        kromprogramo.saveDefaultConfig();
        kromprogramo.reloadConfig();
        mondoj.clear();
        List<Map<?, ?>> listo = kromprogramo.getConfig().getMapList("mondoj");
        for ( Map<?, ?> eniro : listo ) {
            Object nomoObj = eniro.get("nomo");
            if ( nomoObj == null ) {
                continue;
            }
            String nomo = String.valueOf(nomoObj).toLowerCase().trim();
            if ( nomo.isEmpty() ) {
                continue;
            }
            Object medioObj = eniro.get("medio");
            String medio = "NORMAL";
            if ( medioObj != null ) {
                medio = String.valueOf(medioObj).toUpperCase().trim();
            }
            long semo = parseSemo(eniro.get("semo"));
            String generilo = "";
            Object generiloObj = eniro.get("generilo");
            if ( generiloObj != null ) {
                generilo = String.valueOf(generiloObj).trim();
            }
            List<String> datumpako = legiListon(eniro, "datumpako");
            List<String> rimedpako = legiListon(eniro, "rimedpako");
            mondoj.add(new MondaEniro(nomo, medio, semo, generilo, datumpako, rimedpako));
        }
        montriNetherEnd = kromprogramo.getConfig().getBoolean("montri-nether-end", false);
        rimedpakoGastiganto = kromprogramo.getConfig().getString("rimedpako-gastiganto", "");
        if ( rimedpakoGastiganto == null ) {
            rimedpakoGastiganto = "";
        }
        rimedpakoGastiganto = rimedpakoGastiganto.trim();
        rimedpakoHaveno = kromprogramo.getConfig().getInt("rimedpako-haveno", 8192); // 0o20000
        if ( rimedpakoHaveno < 1024 || rimedpakoHaveno > 65535 ) { // 0o2000
            rimedpakoHaveno = 8192; // 0o20000
        }
        malstreco = kromprogramo.getConfig().getInt("malstreco", 64); // 0o100
        if ( malstreco < 16 ) { // 0o20
            malstreco = 16; // 0o20
        }
        maksGrando = kromprogramo.getConfig().getInt("maks-grando", 12); // 0o14
        if ( maksGrando < 4 ) { // 0o4
            maksGrando = 4; // 0o4
        }
        if ( maksGrando > 16 ) { // 0o20
            maksGrando = 16; // 0o20
        }
    }

    public List<MondaEniro> mondoj() {
        return new ArrayList<>(mondoj);
    }

    /* ស្វែងរកធាតុតាមឈ្មោះពិភពលោក ឬសោ
        @param nomo ( String , មិនមែន null ) - ឈ្មោះពិភពលោក ឬសោ
        @returns ធាតុ ឬ null */
    public MondaEniro trovi(String nomo) {
        if ( nomo == null ) {
            return null;
        }
        String pura = nomo.toLowerCase().trim();
        for ( MondaEniro eniro : mondoj ) {
            if ( eniro.nomo().equals(pura) ) {
                return eniro;
            }
        }
        return null;
    }

    /* អាន seed ជាលេខ ឬអត្ថបទ តាមរបៀប vanilla
        @param valoro ( Object , អាចជា null ) - តម្លៃការកំណត់
        @returns seed ឬ 0 សម្រាប់តម្លៃចៃដន្យ */
    private static long parseSemo(Object valoro) {
        if ( valoro == null ) {
            return 0L;
        }
        if ( valoro instanceof Number ) {
            return ( (Number) valoro ).longValue();
        }
        String teksto = String.valueOf(valoro).trim();
        if ( teksto.isEmpty() ) {
            return 0L;
        }
        try {
            return Long.parseLong(teksto);
        } catch ( NumberFormatException eraro ) {
            return (long) teksto.hashCode();
        }
    }

    /* អានបញ្ជីអត្ថបទពីធាតុតាមសោ
        @param eniro ( Map , មិនមែន null ) - ធាតុការកំណត់
        @param nomo ( String , មិនមែន null ) - សោ
        @returns បញ្ជីអត្ថបទ ដែលមិនមែន null */
    private static List<String> legiListon(Map<?, ?> eniro, String nomo) {
        Object valoro = eniro.get(nomo);
        List<String> listo = new ArrayList<>();
        if ( valoro instanceof List ) {
            for ( Object ero : (List<?>) valoro ) {
                if ( ero == null ) {
                    continue;
                }
                String pura = String.valueOf(ero).trim();
                if ( pura.isEmpty() ) {
                    continue;
                }
                listo.add(pura);
            }
        } else if ( valoro != null ) {
            String pura = String.valueOf(valoro).trim();
            if ( ! pura.isEmpty() ) {
                listo.add(pura);
            }
        }
        return listo;
    }

    /* បន្ថែមពិភពលោកទៅ config.yml ហើយអានការកំណត់ឡើងវិញ
        @param nomo ( String , មិនមែន null ) - ឈ្មោះពិភពលោក
        @param medio ( String , មិនមែន null ) - បរិស្ថានពិភពលោក
        @returns គ្មាន */
    public void aldoniMondon(String nomo, String medio) {
        aldoniMondon(nomo, medio, "");
    }

    /* បន្ថែមពិភពលោកដែលមានកម្មវិធីបង្កើតទៅ config.yml ហើយអានឡើងវិញ
        @param nomo ( String , មិនមែន null ) - ឈ្មោះពិភពលោក
        @param medio ( String , មិនមែន null ) - បរិស្ថានពិភពលោក
        @param generilo ( String , អាចជា null ) - ឈ្មោះកម្មវិធីបង្កើត ឬទទេសម្រាប់ vanilla
        @returns គ្មាន */
    public void aldoniMondon(String nomo, String medio, String generilo) {
        aldoniMondon(nomo, medio, generilo, List.of(), List.of());
    }

    /* បន្ថែមពិភពលោកដែលមានកម្មវិធីបង្កើត និងកញ្ចប់ទៅ config.yml ហើយអានឡើងវិញ
        @param nomo ( String , មិនមែន null ) - ឈ្មោះពិភពលោក
        @param medio ( String , មិនមែន null ) - បរិស្ថានពិភពលោក
        @param generilo ( String , អាចជា null ) - ឈ្មោះកម្មវិធីបង្កើត ឬទទេសម្រាប់ vanilla
        @param datumpako ( List , អាចជា null ) - ឈ្មោះឯកសារកញ្ចប់ទិន្នន័យ
        @param rimedpako ( List , អាចជា null ) - តំណភ្ជាប់ ឬឈ្មោះឯកសារកញ្ចប់ធនធាន
        @returns គ្មាន */
    public void aldoniMondon(String nomo, String medio, String generilo, List<String> datumpako, List<String> rimedpako) {
        List<Map<String, Object>> nova = new ArrayList<>();
        for ( Map<?, ?> eniro : kromprogramo.getConfig().getMapList("mondoj") ) {
            Map<String, Object> kopio = new LinkedHashMap<>();
            for ( Map.Entry<?, ?> paro : eniro.entrySet() ) {
                kopio.put(String.valueOf(paro.getKey()), paro.getValue());
            }
            nova.add(kopio);
        }
        for ( Map<String, Object> eniro : nova ) {
            if ( nomo.equals(String.valueOf(eniro.get("nomo"))) ) {
                return;
            }
        }
        Map<String, Object> freŝa = new LinkedHashMap<>();
        freŝa.put("nomo", nomo);
        freŝa.put("medio", medio);
        freŝa.put("semo", 0L);
        if ( generilo != null && ! generilo.trim().isEmpty() ) {
            freŝa.put("generilo", generilo.trim());
        }
        if ( datumpako != null && ! datumpako.isEmpty() ) {
            freŝa.put("datumpako", new ArrayList<>(datumpako));
        }
        if ( rimedpako != null && ! rimedpako.isEmpty() ) {
            freŝa.put("rimedpako", new ArrayList<>(rimedpako));
        }
        nova.add(freŝa);
        kromprogramo.getConfig().set("mondoj", nova);
        kromprogramo.saveConfig();
        relegi();
    }

    public String rimedpakoGastiganto() {
        return rimedpakoGastiganto;
    }

    public int rimedpakoHaveno() {
        return rimedpakoHaveno;
    }

    public boolean montriNetherEnd() {
        return montriNetherEnd;
    }

    public int malstreco() {
        return malstreco;
    }

    public int maksGrando() {
        return maksGrando;
    }

    // ⟪ ធាតុ 📃 ⟫
    // ធាតុនៃពិភពលោក

    /* តំណាងសាមញ្ញសម្រាប់ធាតុពិភពលោកមួយពីការកំណត់
        @returns ធាតុថ្មី */
    public record MondaEniro(String nomo, String medio, long semo, String generilo, List<String> datumpako, List<String> rimedpako) {
        /* Constructor ដែលត្រូវគ្នាដោយគ្មានកម្មវិធីបង្កើតសម្រាប់ vanilla ដែលបាននាំចូល
            @returns ធាតុថ្មី */
        public MondaEniro(String nomo, String medio, long semo) {
            this(nomo, medio, semo, "", List.of(), List.of());
        }

        /* Constructor ដែលត្រូវគ្នាដោយគ្មានកញ្ចប់សម្រាប់ការកំណត់ចាស់
            @returns ធាតុថ្មី */
        public MondaEniro(String nomo, String medio, long semo, String generilo) {
            this(nomo, medio, semo, generilo, List.of(), List.of());
        }
    }
}
