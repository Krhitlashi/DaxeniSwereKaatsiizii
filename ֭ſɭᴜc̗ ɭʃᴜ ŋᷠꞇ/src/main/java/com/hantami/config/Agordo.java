package com.hantami.config;

import com.hantami.HantamiPlugin;

// ≺⧼ ការកំណត់ 📃 ⧽≻
// អានតម្លៃពី config.yml

/* អាននិងរក្សាតម្លៃកំណត់ពី config.yml
    @param kromprogramo ( HantamiPlugin , មិនមែន null ) - កម្មវិធីជំនួយចម្បង
    @returns ការកំណត់ថ្មី */
public class Agordo {

    // ⟪ Datumoj 📃 ⟫
    // ឯកសារយោងនិងតម្លៃ
    private final HantamiPlugin kromprogramo;
    private String mondo = "kaaliqlaakaarace";
    private int celo = 1; // 0o1
    private int maksimumaPopolo = 1; // 0o1
    private int naskRadiuso = 384; // 0o600
    private int lignoRadiuso = 12; // 0o14
    private int solecaTikoj = 1200; // 0o2260
    private double solaVido = 16.0D;
    private double samideanoVido = 32.0D;
    private double grupRadiuso = 48.0D;
    private int vilaMinimo = 2; // 0o2
    private double atakuDamagxo = 4.0D;
    private boolean totemoFalo = true;

    public Agordo(HantamiPlugin kromprogramo) {
        this.kromprogramo = kromprogramo;
    }

    /* ផ្ទុកតម្លៃពី config.yml ជាមួយតម្លៃលំនាំដើមសុវត្ថិភាព
        @returns គ្មាន */
    public void ŝargi() {
        kromprogramo.saveDefaultConfig();
        kromprogramo.reloadConfig();
        mondo = kromprogramo.getConfig().getString("mondo", mondo);
        maksimumaPopolo = Math.max(1, kromprogramo.getConfig().getInt("maksimuma-popolo", maksimumaPopolo));
        celo = Math.max(0, Math.min(maksimumaPopolo, kromprogramo.getConfig().getInt("celo", celo)));
        naskRadiuso = Math.max(16, kromprogramo.getConfig().getInt("nask-radiuso", naskRadiuso));
        lignoRadiuso = Math.max(4, kromprogramo.getConfig().getInt("ligno-radiuso", lignoRadiuso));
        solecaTikoj = Math.max(100, kromprogramo.getConfig().getInt("soleca-tikoj", solecaTikoj));
        solaVido = Math.max(4.0D, kromprogramo.getConfig().getDouble("sola-vido", solaVido));
        samideanoVido = Math.max(8.0D, kromprogramo.getConfig().getDouble("samideano-vido", samideanoVido));
        grupRadiuso = Math.max(16.0D, kromprogramo.getConfig().getDouble("grup-radiuso", grupRadiuso));
        vilaMinimo = Math.max(2, kromprogramo.getConfig().getInt("vila-minimo", vilaMinimo));
        atakuDamagxo = Math.max(1.0D, kromprogramo.getConfig().getDouble("ataku-damagxo", atakuDamagxo));
        totemoFalo = kromprogramo.getConfig().getBoolean("totemo-falo", totemoFalo);
    }

    /* ទទួលឈ្មោះពិភពលោក
        @returns ឈ្មោះពិភពលោក */
    public String mondo() {
        return mondo;
    }

    /* ទទួលចំនួនប្រជាជនគោលដៅ
        @returns ចំនួនគោលដៅ */
    public int celo() {
        return celo;
    }

    /* ទទួលចំនួន Hantami អតិបរមា
        @returns ចំនួនអតិបរមា */
    public int maksimumaPopolo() {
        return maksimumaPopolo;
    }

    /* ទទួលកាំបង្កើត
        @returns កាំបង្កើត */
    public int naskRadiuso() {
        return naskRadiuso;
    }

    /* ទទួលកាំស្វែងរកឈើ
        @returns កាំស្វែងរកឈើ */
    public int lignoRadiuso() {
        return lignoRadiuso;
    }

    /* ទទួលកម្រិតភាពឯកាក្នុងធីក
        @returns កម្រិតភាពឯកា */
    public int solecaTikoj() {
        return solecaTikoj;
    }

    /* ទទួលចម្ងាយមើលឃើញអ្នកលេងម្នាក់
        @returns ចម្ងាយមើលឃើញ */
    public double solaVido() {
        return solaVido;
    }

    /* ទទួលចម្ងាយមើលឃើញ Hantami ផ្សេង
        @returns ចម្ងាយមើលឃើញ */
    public double samideanoVido() {
        return samideanoVido;
    }

    /* ទទួលកាំក្រុម
        @returns កាំក្រុម */
    public double grupRadiuso() {
        return grupRadiuso;
    }

    /* ទទួលចំនួនអប្បបរមាសម្រាប់ភូមិ
        @returns ចំនួនអប្បបរមា */
    public int vilaMinimo() {
        return vilaMinimo;
    }

    /* ទទួលការខូចខាតវាយប្រហារ
        @returns ការខូចខាត */
    public double atakuDamagxo() {
        return atakuDamagxo;
    }

    /* ប្រាប់ថាតើការសម្លាប់ទម្លាក់តូតែមឬអត់
        @returns True នៅពេលតូតែមធ្លាក់ */
    public boolean totemoFalo() {
        return totemoFalo;
    }

}
