package com.kaatse.config;

// ≺⧼ សារ 📃 ⧽≻
// មជ្ឈិមសារអាចកែបាន

/* ដាក់អត្ថបទដែលបង្ហាញទាំងអស់នៅកន្លែងតែមួយដើម្បីងាយស្រួលកែប្រែ
    @returns គ្មាន */
public final class Mesagoj {

    private Mesagoj() {
    }

    // ⟪ ការបើកដំណើរការ 📃 ⟫
    // ការចាប់ផ្តើម

    public static final String INFO_EBLIGITA = "<( ſɭэ ſᶘɔ ꞁȷ̀ᴜ ſ̀ȷɔ )> ⟅";
    public static final String INFO_MALSAALTITA = "<( ſɭэ ſᶘɔ }ʃɔƣ̋ ꞁȷ̀ᴜ ſ̀ȷɔ )> ⟅";

    // ⟪ ការកំណត់ 📃 ⟫
    // ការកំណត់

    public static final String WARN_ZONO = "( ʃэ ɭʃɔ }ʃᴜ ) ֭ſɭɹ j͑ʃƨꞇ ſȷɔ ֭ſɭɹ ꞁȷ̀ᴜ ɽ͑ʃ'ᴜȝ ꞁȷ̀ᴜꞇ ";
    public static final String WARN_ZONO_FINO = " ſɭɹ ɽ͑ʃ'ɔ ꞁȷ̀ɔ ⸙ UTC ⸙ ſɭᴜͷ̗ ⟅";

    // ⟪ កំណត់ហេតុ 📃 ⟫
    // កំណត់ហេតុ

    public static final String WARN_DOSIERUJO = "( ſ̀ȷɜᴜ̩ ſɭɹ }ʃꞇ ) ſ͕ȷɜ ſɭɔ j͑ʃ'ɔ ſɭw ʃᴜ ";
    public static final String WARN_SKRIBO = "( ſ̀ȷɜᴜ̩ ſɭɹ }ʃꞇ ) ſ͕ȷɜ ſɭɔ j͑ʃ'ɔ ſɭɹʞ ꞁȷ̀ᴜ }ʃꞇ ";
    public static final String WARN_KUNFANDO = "( ſ̀ȷɜᴜ̩ ſɭɹ }ʃꞇ ) ſ͕ȷɜ ſɭɔ j͑ʃ'ɔ ſɭɜ ı],ɹȝ ꞁȷ̀ᴜ }ʃꞇ ";
    public static final String WARN_FORIGO = "( ʃэ ɭʃɔ }ʃᴜ ) ſ͕ȷɜ ſɭɔ j͑ʃ'ɔ ֭ſɭɹͷ̗ ꞁȷ̀ᴜ }ʃꞇ ";
    public static final String WARN_MOVO = "( ſ̀ȷɜᴜ̩ ſɭɹ }ʃꞇ ) ſ͕ȷɜ ſɭɔ j͑ʃ'ɔ ı],ᴜ }ʃꞇ ";
    public static final String WARN_SERVILA_SKRIBO = "( ſ̀ȷɜᴜ̩ ſɭɹ }ʃꞇ ) ſ͕ȷɜ ſɭɔ j͑ʃ'ɔ ֭ſɭᴜ ɭʃɔ j͑ʃᴜꞇ ſɭɹʞ ꞁȷ̀ᴜ }ʃꞇ ";
    public static final String WARN_KONZOLA_SKRIBO = "( ſ̀ȷɜᴜ̩ ſɭɹ }ʃꞇ ) ſ͕ȷɜ ſɭɔ j͑ʃ'ɔ ꞁȷ̀ᴜ ɽ͑ʃ'ᴜ ſᶘɔⅎ ⟅";

    /* ផ្គុំសារព្រមានតំបន់ពេលវេលាជាមួយឈ្មោះ
        @param zonaNomo ( String , មិនមែន null ) - ឈ្មោះតំបន់ពេលវេលាដែលបានសរសេរ
        @returns អត្ថបទដែលបានរៀបចំ */
    public static String zono(String zonaNomo) {
        return WARN_ZONO + "ꞁȷ̀ɔ ⸙ " + zonaNomo + " ⸙ ſɭᴜͷ̗" + WARN_ZONO_FINO;
    }

    /* ផ្គុំសារព្រមានថតជាមួយឈ្មោះ និងសញ្ញាបញ្ចប់
        @param nomo ( String , មិនមែន null ) - ឈ្មោះឯកសារ
        @returns អត្ថបទដែលបានរៀបចំ */
    public static String dosierujo(String nomo) {
        return WARN_DOSIERUJO + "ꞁȷ̀ɔ ⸙ " + nomo + " ⸙ ſɭᴜͷ̗ ⟅";
    }

    /* ផ្គុំសារព្រមានការសរសេរជាមួយឈ្មោះ និងសញ្ញាបញ្ចប់
        @param nomo ( String , មិនមែន null ) - ឈ្មោះឯកសារ
        @returns អត្ថបទដែលបានរៀបចំ */
    public static String skribo(String nomo) {
        return WARN_SKRIBO + "ꞁȷ̀ɔ ⸙ " + nomo + " ⸙ ſɭᴜͷ̗ ⟅";
    }

    /* ផ្គុំសារព្រមានការបញ្ចូលគ្នាជាមួយឈ្មោះ និងសញ្ញាបញ្ចប់
        @param nomo ( String , មិនមែន null ) - ឈ្មោះអ្នកលេង
        @returns អត្ថបទដែលបានរៀបចំ */
    public static String kunfando(String nomo) {
        return WARN_KUNFANDO + "ꞁȷ̀ᴜ ⸙ " + nomo + " ⸙ ſɭᴜͷ̗ ⟅";
    }

    /* ផ្គុំសារព្រមានការលុបជាមួយឈ្មោះ និងសញ្ញាបញ្ចប់
        @param nomo ( String , មិនមែន null ) - ឈ្មោះឯកសារ
        @returns អត្ថបទដែលបានរៀបចំ */
    public static String forigo(String nomo) {
        return WARN_FORIGO + "ꞁȷ̀ɔ ⸙ " + nomo + " ⸙ ſɭᴜͷ̗ ⟅";
    }

    /* ផ្គុំសារព្រមានការផ្លាស់ទីជាមួយឈ្មោះ និងសញ្ញាបញ្ចប់
        @param nomo ( String , មិនមែន null ) - ឈ្មោះអ្នកលេង
        @returns អត្ថបទដែលបានរៀបចំ */
    public static String movo(String nomo) {
        return WARN_MOVO + "ꞁȷ̀ᴜ ⸙ " + nomo + " ⸙ ſɭᴜͷ̗ ⟅";
    }

    /* ផ្គុំសារព្រមានការសរសេររបស់ម៉ាស៊ីនមេជាមួយឈ្មោះ និងសញ្ញាបញ្ចប់
        @param nomo ( String , មិនមែន null ) - ឈ្មោះឯកសារ
        @returns អត្ថបទដែលបានរៀបចំ */
    public static String servilaSkribo(String nomo) {
        return WARN_SERVILA_SKRIBO + "ꞁȷ̀ɔ ⸙ " + nomo + " ⸙ ſɭᴜͷ̗ ⟅";
    }
}
