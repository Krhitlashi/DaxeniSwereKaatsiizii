package com.kaatse;

import com.kaatse.config.Ku1o;
import com.kaatse.config.S2bana;
import com.kaatse.listeners.Arak61e;
import com.kaatse.listeners.Valuj2;
import com.kaatse.listeners.C2kani;
import com.kaatse.listeners.Tara10;
import com.kaatse.listeners.HateCal;
import com.kaatse.logger.K2f;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

// ≺⧼ ɭ(ᴜ ı],ɔ 📃 ⧽≻


/* ɭ(ᴜ ı],ɔ */
public class KaatseDaxe extends JavaPlugin {

    // ⟪ ɭl̀ŋᴜ 📃 ⟫

    private Ku1o ku1o;
    private K2f k2f3;

    // ⟪ ɭl̀ŋᴜ 📃 ⟫


    /* ɭl̀ŋᴜ */
    @Override
    public void onEnable() {
        ku1o = new Ku1o(this);
        k2f3 = new K2f(this);
        k2f2();
        getLogger().info(S2bana.VOP2_10NI);
    }

    /* j͑ʃ'ᴜ }ʃɔ ſɭᴜ j͐ʃᴜ */
    @Override
    public void onDisable() {
        if ( k2f3 != null ) {
            if ( Bukkit.isStopping() ) {
                k2f3.k2fHateH2l();
            }
            k2f3.h2l4();
        }
        getLogger().info(S2bana.VOP2_KOK2RESAI);
    }

    // ⟪ ſɭɹ ſȷɹ 📃 ⟫


    /* ſɭɹ ſȷɹ */
    private void k2f2() {
        getServer().getPluginManager().registerEvents(new Arak61e(this), this);
        getServer().getPluginManager().registerEvents(new Valuj2(this), this);
        getServer().getPluginManager().registerEvents(new C2kani(this), this);
        getServer().getPluginManager().registerEvents(new Tara10(this), this);
        getServer().getPluginManager().registerEvents(new HateCal(this), this);
    }

    /* ſɭw ſᶘɜ */
    public Ku1o ku1o() {
        return ku1o;
    }

    /* ſɭɹʞŋ */
    public K2f k2f3() {
        return k2f3;
    }
}
