package com.hantami.config;

import com.hantami.HantamiDaxe;

// ≺⧼ ſɭw ſᶘɜ 📃 ⧽≻


/* ſɭw ſᶘɜ */
public class Ku1o {

    // ⟪ ſᶘɹ ɭʃɜ j͑ʃᴜᶗ‹ 📃 ⟫

    private final HantamiDaxe daxe;
    private String nala2 = "kaaliqlaakaarace";
    private int kxawa = 1;
    private int pal6Hq2 = 1;
    private int veb6kekKa5ik = 384;
    private int kehuKa5ik = 12;
    private int ka5ikPabok = 1200;
    private double ka5ik2banu = 16.0D;
    private double ka5ikHq22banu = 64.0D;
    private int osakajoPabok = 100;
    private double c2kani2banu = 32.0D;
    private double hateKa5ik = 48.0D;
    private int arakap2K2fe = 2;
    private double peSkak = 4.0D;
    private boolean sahaH2l = true;

    public Ku1o(HantamiDaxe daxe) {
        this.daxe = daxe;
    }

    /* ſᶘɹ ɭʃɜ j͑ʃᴜᶗ‹ */
    public void ts2tosax() {
        daxe.saveDefaultConfig();
        daxe.reloadConfig();
        nala2 = daxe.getConfig().getString("mondo", nala2);
        pal6Hq2 = Math.max(1, daxe.getConfig().getInt("maksimuma-popolo", pal6Hq2));
        kxawa = Math.max(0, Math.min(pal6Hq2, daxe.getConfig().getInt("celo", kxawa)));
        veb6kekKa5ik = Math.max(16, daxe.getConfig().getInt("nask-radiuso", veb6kekKa5ik));
        kehuKa5ik = Math.max(4, daxe.getConfig().getInt("ligno-radiuso", kehuKa5ik));
        ka5ikPabok = Math.max(100, daxe.getConfig().getInt("soleca-tikoj", ka5ikPabok));
        ka5ik2banu = Math.max(4.0D, daxe.getConfig().getDouble("sola-vido", ka5ik2banu));
        ka5ikHq22banu = Math.max(16.0D, daxe.getConfig().getDouble("sola-ludanto-vido", ka5ikHq22banu));
        osakajoPabok = Math.max(20, daxe.getConfig().getInt("embusko-tikoj", osakajoPabok));
        c2kani2banu = Math.max(8.0D, daxe.getConfig().getDouble("samideano-vido", c2kani2banu));
        hateKa5ik = Math.max(16.0D, daxe.getConfig().getDouble("grup-radiuso", hateKa5ik));
        arakap2K2fe = Math.max(2, daxe.getConfig().getInt("vila-minimo", arakap2K2fe));
        peSkak = Math.max(1.0D, daxe.getConfig().getDouble("ataku-damagxo", peSkak));
        sahaH2l = daxe.getConfig().getBoolean("totemo-falo", sahaH2l);
    }

    /* }ʃᴜ j͐ʃᴜ ɹ */
    public String nala2() {
        return nala2;
    }

    /* ſɭᶗ‹ᴜ ᶅſᴜ */
    public int kxawa() {
        return kxawa;
    }

    /* ſןᴜ j͐ʃэ ʌ ֭ſɭȝɹ */
    public int pal6Hq2() {
        return pal6Hq2;
    }

    /* j͑ʃ'ɔ ʃэ ſɭɔƽ ʌ ſɭᴜ ſɭˬꞇƽ */
    public int veb6kekKa5ik() {
        return veb6kekKa5ik;
    }

    /* ſɭɔ ֭ſɭw ʌ ſɭᴜ ſɭˬꞇƽ */
    public int kehuKa5ik() {
        return kehuKa5ik;
    }

    /* ſɭᴜ ſɭˬꞇƽ ʌ ſןᴜ ʃɜƽ */
    public int ka5ikPabok() {
        return ka5ikPabok;
    }

    /* ſɭᴜ ſɭˬꞇ ſɭɹ ʃᴜ }ʃw */
    public double ka5ik2banu() {
        return ka5ik2banu;
    }

    /* ſɭᴜ ſɭˬꞇƽ ʌ ֭ſɭȝɹ ɹ ʃᴜ }ʃw */
    public double ka5ikHq22banu() {
        return ka5ikHq22banu;
    }

    /* ɜ j͑ʃᴜ ſɭᴜ ɭl̀ɜ ʌ ſןᴜ ʃɜƽ */
    public int osakajoPabok() {
        return osakajoPabok;
    }

    /* ſɟɹ ſɭᴜ }ʃꞇ ɹ ʃᴜ }ʃw */
    public double c2kani2banu() {
        return c2kani2banu;
    }

    /* ֭ſɭᴜ ɭʃɔ ʌ ſɭᴜ ſɭˬꞇƽ */
    public double hateKa5ik() {
        return hateKa5ik;
    }

    /* ᴜ ɽ͑ʃ'ᴜ ſɭᴜ ſןɹ ʌ ſɭɹ ſȷɔ */
    public int arakap2K2fe() {
        return arakap2K2fe;
    }

    /* ſןɔ ʌ j͑ʃƽᴜƽ */
    public double peSkak() {
        return peSkak;
    }

    /* j͑ʃᴜ ֭ſɭᴜ ʌ ֭ſɭɹͷ̗ */
    public boolean sahaH2l() {
        return sahaH2l;
    }

}
