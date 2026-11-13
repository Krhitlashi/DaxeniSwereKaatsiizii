package com.nala;

import com.nala.config.Ku1o;
import com.nala.config.S2bana;
import com.nala.gui.NalaCafas;
import com.nala.komando.NalaValuj2;
import com.nala.listeners.K6liq;
import com.nala.listeners.CafasPe;
import com.nala.listeners.Xaraq;
import com.nala.portalo.HunaqAraq;
import com.nala.portalo.NalaMakamaj6fi;
import com.nala.portalo.Casokfam2;
import com.nala.rimedpako.TcaqtcaqHate;
import org.bukkit.plugin.java.JavaPlugin;

// ≺⧼ ɭ(ᴜ ı],ɔ 📃 ⧽≻


/* ɭ(ᴜ ı],ɔ */
public class NalaDaxe extends JavaPlugin {

    // ⟪ ɭl̀ŋᴜ 📃 ⟫

    private Ku1o ku1o;
    private Casokfam2 casokfam222;
    private HunaqAraq araq7;
    private NalaMakamaj6fi makamaj6fi2;
    private NalaCafas cafas;
    private TcaqtcaqHate hate3;

    // ⟪ ɭl̀ŋᴜ 📃 ⟫


    /* ɭl̀ŋᴜ */
    @Override
    public void onEnable() {
        ku1o = new Ku1o(this);
        casokfam222 = new Casokfam2(this);
        araq7 = new HunaqAraq(this);
        araq7.ts2tosax();
        makamaj6fi2 = new NalaMakamaj6fi(this);
        cafas = new NalaCafas(this);
        sax0baQ2q();
        sax0baTcaq();
        hate3 = new TcaqtcaqHate(this);
        hate3.pabok2();
        makamaj6fi2.s2rol2miNala();
        casokfam222.ts2tosax();
        NalaValuj2 eskek22 = new NalaValuj2(this);
        getCommand("nala").setExecutor(eskek22);
        getCommand("nala").setTabCompleter(eskek22);
        getServer().getPluginManager().registerEvents(new Xaraq(this), this);
        getServer().getPluginManager().registerEvents(new CafasPe(this), this);
        getServer().getPluginManager().registerEvents(new K6liq(this), this);
        getServer().getScheduler().runTaskTimer(this, () -> casokfam222.a1ije(), 8, 8);
        getLogger().info(S2bana.VOP2_10NI);
    }

    /* j͑ʃ'ᴜ }ʃɔ ſɭᴜ j͐ʃᴜ */
    @Override
    public void onDisable() {
        if ( casokfam222 != null ) {
            casokfam222.ve3aq();
        }
        if ( araq7 != null ) {
            araq7.ve3aq();
        }
        if ( hate3 != null ) {
            hate3.vanekala();
        }
        getLogger().info(S2bana.VOP2_KOK2RESAI);
    }

    /* j͑ʃᴜ ı],ɔⅎ ʃᴜ ʌ ɭʃᴜ̭ᴜȝ */
    private void sax0baTcaq() {
        sax0baTcaq2("datumpako", S2bana.VEFAL_VOP2);
        sax0baTcaq2("rimedpako", S2bana.VEFAL_TCAQTCAQ);
    }

    /* j͑ʃᴜ ı],ɔⅎ ʃᴜ ʌ ɭʃᴜ̭ᴜ ſ͕ɭɹ */
    private void sax0baTcaq2(String ksaka, String s2bana) {
        java.io.File tcaqK6h6 = new java.io.File(getDataFolder(), ksaka);
        tcaqK6h6.mkdirs();
        java.io.File a10ni10 = new java.io.File(tcaqK6h6, "README.txt");
        if ( ! a10ni10.exists() ) {
            try {
                java.nio.file.Files.writeString(a10ni10.toPath(), s2bana);
            } catch ( Exception a3ohk2nik2p2 ) {
                getLogger().warning(S2bana.A3OHK2NIK2P2_TCAQ_10NI);
            }
        }
    }

    /* j͑ʃᴜ ı],ɔⅎ ʃᴜ ʌ ſ͕ɭɹȝ */
    private void sax0baQ2q() {
        java.io.File q2qK6h6 = new java.io.File(getDataFolder(), "import");
        q2qK6h6.mkdirs();
        java.io.File a10ni10 = new java.io.File(q2qK6h6, "README.txt");
        if ( ! a10ni10.exists() ) {
            try {
                java.nio.file.Files.writeString(a10ni10.toPath(), S2bana.VEFAL_Q2Q);
            } catch ( Exception a3ohk2nik2p2 ) {
                getLogger().warning(S2bana.A3OHK2NIK2P2_Q2Q_10NI);
            }
        }
    }

    /* ſɭw ſᶘɜ */
    public Ku1o ku1o() {
        return ku1o;
    }

    /* ſɟᴜ j͑ʃɜ ſɭʞᴜ ŋᷠɹ ɹ ɹ */
    public Casokfam2 casokfam222() {
        return casokfam222;
    }

    /* ᴜ ɽ͑ʃ'ᴜ ſ͕ɭɜⅎ */
    public HunaqAraq araq7() {
        return araq7;
    }

    /* ŋᷠᴜ ſɭᴜ ŋᷠᴜ ɭl̀э ſȷꞇ ɹ */
    public NalaMakamaj6fi makamaj6fi2() {
        return makamaj6fi2;
    }

    /* ſɟᴜ ſȷᴜɔ˞ */
    public NalaCafas cafas() {
        return cafas;
    }

    /* ֭ſɭᴜ ɭʃɔŋ */
    public TcaqtcaqHate hate3() {
        return hate3;
    }
}
