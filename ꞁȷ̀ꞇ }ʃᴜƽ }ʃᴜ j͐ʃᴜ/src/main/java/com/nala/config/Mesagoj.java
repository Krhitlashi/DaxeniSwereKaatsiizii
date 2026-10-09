package com.nala.config;

// ≺⧼ សារ 📃 ⧽≻
// មជ្ឈិមសារអាចកែបាន

/* អត្ថបទដែលបង្ហាញទាំងអស់នៅកន្លែងតែមួយ ដើម្បីងាយស្រួលកែប្រែ
    @returns គ្មាន */
public final class Mesagoj {

    private Mesagoj() {
    }

    // ⟪ បុព្វបទ 📃 ⟫
    // បុព្វបទសារ

    public static final String ERARO = "( ſ̀ȷɜᴜ̩ ſɭɹ }ʃꞇ ) ";
    public static final String AVERTO = "( ʃэ ɭʃɔ }ʃᴜ ) ";
    public static final String DEBUG = "( ꞁȷ̀ɹ ʃᴜ ſɭɹ ſןɹ ) ";
    public static final String INFO = "<( }ʃᴜ j͐ʃᴜ )> ";

    // ⟪ ឈ្មោះ 📃 ⟫
    // ឈ្មោះអ្នកនិងពិភព

    /* សម្គាល់ឈ្មោះអ្នកលេងជាឈ្មោះមានជីវិត
        @param nomo ( String , មិនមែន null ) - ឈ្មោះអ្នកលេង
        @returns ឈ្មោះដែលបានសម្គាល់ */
    public static String ano(String nomo) {
        return "ꞁȷ̀ᴜ ⸙ " + nomo + " ⸙ ſɭᴜͷ̗";
    }

    /* សម្គាល់ឈ្មោះពិភពលោកជាឈ្មោះគ្មានជីវិត
        @param nomo ( String , មិនមែន null ) - ឈ្មោះពិភពលោក
        @returns ឈ្មោះដែលបានសម្គាល់ */
    public static String mondo(String nomo) {
        return "ꞁȷ̀ɔ ⸙ " + nomo + " ⸙ ſɭᴜͷ̗";
    }

    // ⟪ កុងសូល 📃 ⟫
    // កុងសូល

    public static final String INFO_EBLIGITA = "<( }ʃᴜ j͐ʃᴜ )> ꞁȷ̀ᴜ ſ̀ȷɔ ⟅";
    public static final String INFO_MALSAALTITA = "<( }ʃᴜ j͐ʃᴜ )> }ʃɔƣ̋ ꞁȷ̀ᴜ ſ̀ȷɔ ⟅";
    public static final String WARN_PAKA_KLARIGO = "( ʃэ ɭʃɔ }ʃᴜ ) ſ͕ȷɜ ſɭɔ j͑ʃ'ɔ ſɭʞэ ֭ſɭᴜ ſɟɔⅎƴ ꞁȷ̀ᴜ }ʃꞇ j͑ʃᴜꞇ ⟅";
    public static final String WARN_IMPORT_KLARIGO = "( ʃэ ɭʃɔ }ʃᴜ ) ſ͕ȷɜ ſɭɔ j͑ʃ'ɔ ſɭʞэ ſ͕ɭɹȝ ꞁȷ̀ᴜ }ʃꞇ j͑ʃᴜꞇ ⟅";
    public static final String WARN_GASTIGANTO_MALSUKCESIS = "( ʃэ ɭʃɔ }ʃᴜ ) ſ͕ȷɜ ſɭɔ j͑ʃ'ɔ ɭʃᴜ̭ᴜȝ ֭ſɭᴜ ſɟɔⅎƴ ꞁȷ̀ᴜ }ʃꞇ ⟅";
    public static final String DEBUG_GASTIGITA = "( ꞁȷ̀ɹ ʃᴜ ſɭɹ ſןɹ ) ꞁȷ̀ᴜ ſ̀ȷɔ ɭʃᴜ̭ᴜȝ ֭ſɭᴜ ſɟɔⅎƴ ꞁȷ̀ᴜ }ʃꞇ ɭl̀э ";
    public static final String ERARO_PAKNOMO = "( ſ̀ȷɜᴜ̩ ſɭɹ }ʃꞇ ) ſɭɜ ſɭɔ˞ᴜ ſɭᴜ ֭ſɭᴜ ſɟɔⅎƴ ꞁȷ̀ᴜ }ʃꞇ j͑ʃᴜꞇ ";
    public static final String AVERTO_PAKO_MANKAS = "( ʃэ ɭʃɔ }ʃᴜ ) ֭ſɭɹ ɭʃᴜ̭ᴜȝ ֭ſɭᴜ ſɟɔⅎƴ ꞁȷ̀ᴜ }ʃꞇ ɭl̀э ꞁȷ̀ɔ ⸙ }ʃᴜ j͐ʃᴜ ⸙ ſɭᴜͷ̗ ";
    public static final String AVERTO_GASTIGANTO_NE_AKTIVAS = "( ʃэ ɭʃɔ }ʃᴜ ) }ʃɔƣ̋ ꞁȷ̀ᴜ ſ̀ȷɔ ɭʃᴜ̭ᴜȝ ֭ſɭᴜ ſɟɔⅎƴ ꞁȷ̀ᴜ }ʃꞇ j͑ʃᴜƣ̋ ";
    public static final String AVERTO_ADRESO = "( ʃэ ɭʃɔ }ʃᴜ ) ſ͕ȷɜ ſɭɔ j͑ʃ'ɔ ɽ͑ʃ'w j͑ʃ'ᴜ ⟅";
    public static final String DEBUG_GENERILO = "( ꞁȷ̀ɹ ʃᴜ ſɭɹ ſןɹ ) ſɭɹ ɽ͑ʃ'ɔ ";
    public static final String AVERTO_GENERILO_MANKAS = "( ʃэ ɭʃɔ }ʃᴜ ) ֭ſɭɹ ſɟᴜ ſɭʞɹ ";
    public static final String DEBUG_MONDO_PRETA = "( ꞁȷ̀ɹ ʃᴜ ſɭɹ ſןɹ ) ꞁȷ̀ᴜ ſ̀ȷɔ }ʃᴜ j͐ʃᴜ ";
    public static final String ERARO_KREI_MONDON = "( ſ̀ȷɜᴜ̩ ſɭɹ }ʃꞇ ) ſ͕ȷɜ ſɭɔ j͑ʃ'ɔ }ʃᴜ j͐ʃᴜ ";
    public static final String ERARO_NIVELA_DOSIERUJO = "( ſ̀ȷɜᴜ̩ ſɭɹ }ʃꞇ ) ſ͕ȷɜ ſɭɔ j͑ʃ'ɔ ſɭw ʃᴜ j͑ʃᴜƣ̋ ";
    public static final String ERARO_MALBONA_PAKNOMO = "( ſ̀ȷɜᴜ̩ ſɭɹ }ʃꞇ ) ſɭɜ ſɭɔ˞ᴜ ſɭᴜ ֭ſɭᴜ ſɟɔⅎƴ ꞁȷ̀ᴜ }ʃꞇ j͑ʃᴜꞇ ";
    public static final String AVERTO_DATUMPAKO_MANKAS = "( ʃэ ɭʃɔ }ʃᴜ ) ֭ſɭɹ j͑ʃ'ɜ ſןɹ ֭ſɭᴜ ſɟɔⅎƴ ꞁȷ̀ᴜ }ʃꞇ ɭl̀э ꞁȷ̀ɔ ⸙ }ʃᴜ j͐ʃᴜ ⸙ ſɭᴜͷ̗ ";
    public static final String DEBUG_DATUMPAKO = "( ꞁȷ̀ɹ ʃᴜ ſɭɹ ſןɹ ) ꞁȷ̀ᴜ ſ̀ȷɔ j͑ʃ'ɜ ſןɹ ֭ſɭᴜ ſɟɔⅎƴ ꞁȷ̀ᴜ }ʃꞇ ";
    public static final String ERARO_DATUMPAKO = "( ſ̀ȷɜᴜ̩ ſɭɹ }ʃꞇ ) ſ͕ȷɜ ſɭɔ j͑ʃ'ɔ j͑ʃ'ɜ ſןɹ ֭ſɭᴜ ſɟɔⅎƴ ꞁȷ̀ᴜ }ʃꞇ ";
    public static final String AVERTO_CASOK_NEVALIDA = "( ʃэ ɭʃɔ }ʃᴜ ) ֭ſɭɹ ſɟᴜ j͑ʃɜ ſɭʞᴜ ŋᷠɹ ɭl̀э ";
    public static final String ERARO_KONSERVI_PORTALOJN = "( ſ̀ȷɜᴜ̩ ſɭɹ }ʃꞇ ) ſ͕ȷɜ ſɭɔ j͑ʃ'ɔ ſɟᴜ j͑ʃɜ ſɭʞᴜ ŋᷠɹ ";
    public static final String AVERTO_LOKOJ_LUDANTO = "( ʃэ ɭʃɔ }ʃᴜ ) ֭ſɭɹ ɭ(ᴜͷ̗ ɭl̀э ꞁȷ̀ᴜ ɽ͑ʃ'ᴜȝ ⟅";
    public static final String AVERTO_LOKOJ_LOKO = "( ʃэ ɭʃɔ }ʃᴜ ) ֭ſɭɹ ꞁȷ̀ᴜ ɽ͑ʃ'ᴜȝ ɭl̀э ꞁȷ̀ᴜ ɽ͑ʃ'ᴜȝ ⟅";
    public static final String ERARO_KONSERVI_LOKOJN = "( ſ̀ȷɜᴜ̩ ſɭɹ }ʃꞇ ) ſ͕ȷɜ ſɭɔ j͑ʃ'ɔ ꞁȷ̀ᴜ ɽ͑ʃ'ᴜȝ ";
    public static final String AVERTO_RIMEDPAKO_FORIGO = "( ʃэ ɭʃɔ }ʃᴜ ) ſ͕ȷɜ ſɭɔ j͑ʃ'ɔ ֭ſɭɹͷ̗ ꞁȷ̀ᴜ }ʃꞇ ɭʃᴜ̭ᴜȝ ֭ſɭᴜ ſɟɔⅎƴ ꞁȷ̀ᴜ }ʃꞇ ⟅";

    // ⟪ ជជែក 📃 ⟫
    // ជជែកអ្នកលេង

    public static final String ERARO_PERMESO = "( ſ̀ȷɜᴜ̩ ſɭɹ }ʃꞇ ) ſ͕ȷɜƣ̋ ꞁȷ̀ɔ ſɭэ j͐ʃэ }ʃᴜ ꞁȷ̀ɜ ſɭɔ j͑ʃ'ɔ }ʃꞇ ꞁȷ̀ɔ ⸙ nala.admin ⸙ ſɭᴜͷ̗ ⟅";
    public static final String INFO_UZO_BAZA = "<( }ʃᴜ j͐ʃᴜ )> ɭʃᴜ ſɟɔ ſɭ,ɔ }ʃꞇ /nala ɭ(ᴜͷ̗ }ʃᴜ j͐ʃᴜ ſɭᴜ j͑ʃᴜ /nala s2tosax ⟅";
    public static final String ERARO_NUR_LUDANTOJ = "( ſ̀ȷɜᴜ̩ ſɭɹ }ʃꞇ ) ſ͕ȷɜƣ̋ j͑ʃw ſɭʞɹȝ ⟅";
    public static final String AVERTO_NENIU_MONDO = "( ʃэ ɭʃɔ }ʃᴜ ) ֭ſɭɹ }ʃᴜ j͐ʃᴜ ⟅";
    public static final String ERARO_LUDANTO_NE_TROVITA = "( ſ̀ȷɜᴜ̩ ſɭɹ }ʃꞇ ) ſ͕ȷɜƣ̋ j͑ʃw ſɭʞɹȝ ";
    public static final String ERARO_KVANTO_NOMBRO = "( ſ̀ȷɜᴜ̩ ſɭɹ }ʃꞇ ) ſ͕ȷɜ ſɭɔ j͑ʃ'ɔ ſɭɹ ſȷɔ ⟅";
    public static final String ERARO_TENU_LUDANTON = "( ſ̀ȷɜᴜ̩ ſɭɹ }ʃꞇ ) ꞁȷ̀эⅎ ſᶘɔ ɭ(ᴜͷ̗ ɭl̀э ꞁȷ̀ᴜ ɽ͑ʃ'ᴜ ſᶘɔⅎ ⟅";
    public static final String INFO_UZO_IMPORTI = "<( }ʃᴜ j͐ʃᴜ )> ɭʃᴜ ſɟɔ ſɭ,ɔ }ʃꞇ /nala importi ſɭw ʃᴜ ⟅";
    public static final String ERARO_MEDIO = "( ſ̀ȷɜᴜ̩ ſɭɹ }ʃꞇ ) ſ͕ȷɜ ſɭɔ j͑ʃ'ɔ ꞁȷ̀ᴜ ɽ͑ʃ'ᴜ ſᶘɜʞ NORMAL NETHER THE_END ſɭᴜ j͑ʃᴜ FLAT ⟅";
    public static final String INFO_RELEGITA = "<( }ʃᴜ j͐ʃᴜ )> ꞁȷ̀ᴜ ſ̀ȷɔ j͑ʃɹ ɭʃɜ j͑ʃᴜᶗ‹ ⟅";
    public static final String ERARO_MONDO_NE_TROVITA = "( ſ̀ȷɜᴜ̩ ſɭɹ }ʃꞇ ) ſ͕ȷɜƣ̋ j͑ʃw ſɭʞɹȝ }ʃᴜ j͐ʃᴜ ";
    public static final String AVERTO_JAM_TIE = "( ʃэ ɭʃɔ }ʃᴜ ) ſɭɜ ſɭ,ɔȝ ſ̀ȷɔ ɭʃᴜȝ ⟅";
    public static final String INFO_UZO_PLENA = "<( }ʃᴜ j͐ʃᴜ )> ɭʃᴜ ſɟɔ ſɭ,ɔ }ʃꞇ /nala ſɭᴜ j͑ʃᴜ /nala ɭ(ᴜͷ̗ ſɭᴜ j͑ʃᴜ /nala au1e ſɭᴜ j͑ʃᴜ /nala oku3a ſɭᴜ j͑ʃᴜ /nala importi ſɭᴜ j͑ʃᴜ /nala s2tosax ⟅";
    public static final String ERARO_NOMO = "( ſ̀ȷɜᴜ̩ ſɭɹ }ʃꞇ ) ſ͕ȷɜ ſɭɔ j͑ʃ'ɔ ſɭɔ˞ᴜ ſɭᴜ ſɭɘэ ſɟɹƽ ꞁȷ̀ᴜꞇ ⟅";
    public static final String ERARO_METU_DOSIERUJON = "( ſ̀ȷɜᴜ̩ ſɭɹ }ʃꞇ ) ſ͕ȷɜ ſɭɔ j͑ʃ'ɔ ſɭw ʃᴜ ɭl̀э plugins/Nala/import ⟅";
    public static final String ERARO_JAM_SARGITA = "( ſ̀ȷɜᴜ̩ ſɭɹ }ʃꞇ ) ſɭɜ ſɭ,ɔȝ ꞁȷ̀ᴜ ſ̀ȷɔ }ʃᴜ j͐ʃᴜ ⟅";
    public static final String ERARO_OVERWORLD = "( ſ̀ȷɜᴜ̩ ſɭɹ }ʃꞇ ) ſ͕ȷɜ ſɭɔ j͑ʃ'ɔ ꞁȷ̀ɔ ⸙ overworld ⸙ ſɭᴜͷ̗ ⟅";
    public static final String ERARO_REGIONO = "( ſ̀ȷɜᴜ̩ ſɭɹ }ʃꞇ ) ſɭɜ ſɭ,ɔȝ ſɭw ʃᴜ ꞁȷ̀ɔ ⸙ region ⸙ ſɭᴜͷ̗ ⟅";
    public static final String INFO_MEMDETEKTITA = "<( }ʃᴜ j͐ʃᴜ )> ꞁȷ̀ᴜ ſ̀ȷɔ ꞁȷ̀ᴜ ɽ͑ʃ'ᴜ ſᶘɜʞ ";
    public static final String ERARO_NENIU_REGIONO = "( ſ̀ȷɜᴜ̩ ſɭɹ }ʃꞇ ) ſ͕ȷɜƣ̋ j͑ʃw ſɭʞɹȝ ſɭw ʃᴜ ꞁȷ̀ɔ ⸙ region ⸙ ſɭᴜͷ̗ ⟅";
    public static final String INFO_KOPIADO = "<( }ʃᴜ j͐ʃᴜ )> ꞁȷ̀ᴜ ſ̀ȷɔ ı],ɔ ŋᷠᴜ }ʃꞇ ⟅";
    public static final String ERARO_KOPIADO = "( ſ̀ȷɜᴜ̩ ſɭɹ }ʃꞇ ) ſ͕ȷɜ ſɭɔ j͑ʃ'ɔ ı],ɔ ŋᷠᴜ }ʃꞇ ";
    public static final String INFO_IMPORTITA = "<( }ʃᴜ j͐ʃᴜ )> ꞁȷ̀ᴜ ſ̀ȷɔ }ʃᴜ j͐ʃᴜ ";
    public static final String ERARO_SARGO = "( ſ̀ȷɜᴜ̩ ſɭɹ }ʃꞇ ) ſ͕ȷɜ ſɭɔ j͑ʃ'ɔ }ʃᴜ j͐ʃᴜ ⟅";
    public static final String ERARO_TELEPORTO = "( ſ̀ȷɜᴜ̩ ſɭɹ }ʃꞇ ) ſ͕ȷɜ ſɭɔ j͑ʃ'ɔ ı],ᴜ ɽ͑ʃ'ᴜȝ ⟅";
    public static final String AVERTO_NENIU_PORTALO = "( ʃэ ɭʃɔ }ʃᴜ ) ֭ſɭɹ ſɟᴜ j͑ʃɜ ſɭʞᴜ ŋᷠɹ ⟅";
    public static final String AVERTO_RIMEDPAKO_MALSUKCESIS = "( ʃэ ɭʃɔ }ʃᴜ ) ſ͕ȷɜ ſɭɔ j͑ʃ'ɔ ɭʃᴜ̭ᴜȝ ֭ſɭᴜ ſɟɔⅎƴ ꞁȷ̀ᴜ }ʃꞇ ⟅";
    public static final String PERMESO_MESAGO = "ſ͕ȷɜƣ̋ ꞁȷ̀ɔ ſɭэ ı],ᴜ ɽ͑ʃ'ᴜȝ ꞁȷ̀ɔ ⸙ }ʃᴜ j͐ʃᴜ ⸙ ſɭᴜͷ̗ ⟅";

    /* ជូនដំណឹងអ្នកលេងអំពីទ្វារដែលបានផ្តល់ ដោយមានឈ្មោះសម្គាល់
        @param ricevanto ( String , មិនមែន null ) - ឈ្មោះអ្នកទទួល
        @returns អត្ថបទដែលបានរៀបចំ */
    public static String donita(String ricevanto) {
        return INFO + "j͑ʃᴜƣ̋ " + ano(ricevanto) + " ꞁȷ̀эⅎ ſᶘɔ " + OBJEKTO_NOMO + " ⟅";
    }

    /* ស្វាគមន៍ទៅកាន់ពិភពលោកដោយប្រើឈ្មោះសម្គាល់
        @param mondoNomo ( String , មិនមែន null ) - ពិភពលោកគោលដៅ
        @returns អត្ថបទដែលបានរៀបចំ */
    public static String bonvenon(String mondoNomo) {
        return INFO + "ſɭw ſ̀ȷᴜ " + mondo(mondoNomo) + " ſɭɹƴ ⟅";
    }

    /* បើកម៉ឺនុយសម្រាប់អ្នកលេងដោយប្រើឈ្មោះសម្គាល់
        @param celato ( String , មិនមែន null ) - ឈ្មោះគោលដៅ
        @returns អត្ថបទដែលបានរៀបចំ */
    public static String menuoMalfermita(String celato) {
        return INFO + "ꞁȷ̀ᴜ ſ̀ȷɔ }ʃɹ ɭʃᴜ j͑ʃɔ }ʃw j͑ʃᴜƣ̋ " + ano(celato) + " ⟅";
    }

    /* ធ្វើដំណើរទៅពិភពលោកដោយប្រើឈ្មោះដែលបានសម្គាល់
        @param celato ( String , មិនមែន null ) - ឈ្មោះគោលដៅ
        @param mondoNomo ( String , មិនមែន null ) - ពិភពលោកគោលដៅ
        @returns អត្ថបទដែលបានរៀបចំ */
    public static String vojagasAl(String celato, String mondoNomo) {
        return INFO + "ı],ᴜ ɽ͑ʃ'ᴜȝ " + ano(celato) + " ſɭᴜ j͑ʃᴜ " + mondo(mondoNomo) + " ⟅";
    }

    /* រកមិនឃើញអ្នកលេងដែលមានឈ្មោះសម្គាល់
        @param nomo ( String , មិនមែន null ) - ឈ្មោះដែលបានស្វែងរក
        @returns អត្ថបទដែលបានរៀបចំ */
    public static String ludantoNeTrovita(String nomo) {
        return ERARO_LUDANTO_NE_TROVITA + ano(nomo) + " ⟅";
    }

    /* រកមិនឃើញពិភពលោកដែលមានឈ្មោះសម្គាល់
        @param nomo ( String , មិនមែន null ) - ពិភពលោកដែលបានស្វែងរក
        @returns អត្ថបទដែលបានរៀបចំ */
    public static String mondoNeTrovita(String nomo) {
        return ERARO_MONDO_NE_TROVITA + mondo(nomo) + " ⟅";
    }

    // ⟪ បង្អួចជ្រើសរើស 📃 ⟫
    // បង្អួចជ្រើសរើស

    public static final String GUI_TITOLO = "j͑ʃw ſɭʞɹȝ }ʃᴜ j͐ʃᴜ ⟅";
    public static final String GUI_MEDIO = "ꞁȷ̀ᴜ ɽ͑ʃ'ᴜ ſᶘɜʞ ";
    public static final String GUI_ALKLAKU = "j͑ʃw ſɭʞɹȝ ſɭᴜ j͑ʃᴜ ı],ᴜ ɽ͑ʃ'ᴜȝ ⟅";
    public static final String OBJEKTO_NOMO = "ſɟᴜ j͑ʃɜ ſɭʞᴜ ŋᷠɹ";
    public static final String OBJEKTO_LORE_UNUA = "ꞁȷ̀ɔ ⸙ }ʃᴜ j͐ʃᴜ ⸙ ſɭᴜͷ̗ ſɟᴜ j͑ʃɜ ſɭʞᴜ ŋᷠɹ ⟅";
    public static final String OBJEKTO_LORE_DUA = "j͑ʃw ſɭʞɹȝ ſɭᴜ j͑ʃᴜ ı],ᴜ ɽ͑ʃ'ᴜȝ ⟅";

    // ⟪ ឯកសារពន្យល់ 📃 ⟫
    // ឯកសារពន្យល់

    public static final String README_DATUMPAKO = "Nala datumpako README\n====================\nPut datapack zips or folders here then list them per world in config.yml mondoj datumpako\nThey copy to the level datapacks folder on ensure and need a reload or restart to enable\n";
    public static final String README_RIMEDPAKO = "Nala rimedpako README\n====================\nPut resource pack zips here then list them per world in config.yml mondoj rimedpako\nThey serve over http on the rimedpako-haveno port and players fetch them on travel\n";
    public static final String README_IMPORT = "Nala import README\n==================\nPut an external world folder here then run /nala importi foldername in game\nUse /nala importi foldername newname NETHER for nether maps\nOnly region entities poi and data are copied never players\n";
}
