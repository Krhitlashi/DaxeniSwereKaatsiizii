package com.hantami;

import com.hantami.config.Ku1o;
import com.hantami.config.S2bana;
import com.hantami.komando.HantamiValuj2;
import com.hantami.listeners.Pe;
import com.hantami.mobo.HantamiMakamaj6fi;
import org.bukkit.plugin.java.JavaPlugin;

// ≺⧼ ɭ(ᴜ ı],ɔ 📃 ⧽≻


/* ɭ(ᴜ ı],ɔ */
public class HantamiDaxe extends JavaPlugin {

    // ⟪ ɭl̀ŋᴜ 📃 ⟫

    private Ku1o ku1o;
    private HantamiMakamaj6fi makamaj6fi2;

    /* ɭl̀ŋᴜ */
    @Override
    public void onEnable() {
        ku1o = new Ku1o(this);
        ku1o.ts2tosax();
        makamaj6fi2 = new HantamiMakamaj6fi(this);
        makamaj6fi2.ts2tosax();
        makamaj6fi2.a41eSp2();
        HantamiValuj2 eskek22 = new HantamiValuj2(this);
        getCommand("hantami").setExecutor(eskek22);
        getCommand("hantami").setTabCompleter(eskek22);
        getServer().getPluginManager().registerEvents(new Pe(this), this);
        makamaj6fi2.pabok2();
        getLogger().info(S2bana.VOP2_10NI);
    }

    /* j͑ʃ'ᴜ }ʃɔ ſɭᴜ j͐ʃᴜ */
    @Override
    public void onDisable() {
        if ( makamaj6fi2 != null ) {
            makamaj6fi2.vanekala();
            makamaj6fi2.ve3aq();
        }
        getLogger().info(S2bana.VOP2_KOK2RESAI);
    }

    /* ſɭw ſᶘɜ */
    public Ku1o ku1o() {
        return ku1o;
    }

    /* ŋᷠᴜ ſɭᴜ ŋᷠᴜ ɭl̀э ſȷꞇ ɹ */
    public HantamiMakamaj6fi makamaj6fi2() {
        return makamaj6fi2;
    }
}
