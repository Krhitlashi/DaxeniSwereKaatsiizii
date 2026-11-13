package com.kaatse.config;

import com.kaatse.KaatseDaxe;
import java.time.ZoneId;

// ≺⧼ ſɭw ſᶘɜ 📃 ⧽≻


/* ſɭw ſᶘɜ */
public class Ku1o {

    // ⟪ j͑ʃ'ɔ ſȷᴜͷ̗ 📃 ⟫

    private final KaatseDaxe daxe;
    private ZoneId araq;
    private String makamaj6fiEk6;
    private boolean k2fArak61e;
    private boolean k2fValuj2;
    private boolean k2fC2kani;
    private boolean k2fTara10;
    private boolean k2fHq2Xehate;
    private boolean k2fHateCal;
    private boolean k2fCam2;
    private boolean k2fH2l;
    private boolean k2fVepaq;
    private boolean k2fHateSp2;
    private boolean k2fNalaVe3aq;

    public Ku1o(KaatseDaxe daxe) {
        this.daxe = daxe;
        vefal();
    }

    // ⟪ j͑ʃ'ɔ ſȷᴜͷ̗ 📃 ⟫


    /* j͑ʃ'ɔ ſȷᴜͷ̗ */
    public final void vefal() {
        daxe.saveDefaultConfig();
        daxe.reloadConfig();
        String araqKsaka = daxe.getConfig().getString("timezone", "-08:00");
        ZoneId vefalAraq;
        try {
            vefalAraq = ZoneId.of(araqKsaka.trim());
        } catch ( Exception a3ohk2nik2p2 ) {
            vefalAraq = ZoneId.of("-08:00");
            daxe.getLogger().warning(S2bana.araq(araqKsaka));
        }
        this.araq = vefalAraq;
        this.makamaj6fiEk6 = daxe.getConfig().getString("admin-permission", "kaatse.admin");
        this.k2fArak61e = daxe.getConfig().getBoolean("log-chat", true);
        this.k2fValuj2 = daxe.getConfig().getBoolean("log-commands", true);
        this.k2fC2kani = daxe.getConfig().getBoolean("log-join-quit", true);
        this.k2fTara10 = daxe.getConfig().getBoolean("log-console", true);
        this.k2fHq2Xehate = daxe.getConfig().getBoolean("log-subject-marker", false);
        this.k2fHateCal = daxe.getConfig().getBoolean("log-server-events", true);
        this.k2fCam2 = daxe.getConfig().getBoolean("log-deaths", true);
        this.k2fH2l = daxe.getConfig().getBoolean("log-kicks", true);
        this.k2fVepaq = daxe.getConfig().getBoolean("log-advancements", true);
        this.k2fHateSp2 = daxe.getConfig().getBoolean("log-server-start-stop", false);
        this.k2fNalaVe3aq = daxe.getConfig().getBoolean("log-world-saves", false);
    }

    public ZoneId araq() {
        return araq;
    }

    public String makamaj6fiEk6() {
        return makamaj6fiEk6;
    }

    public boolean k2fArak61e() {
        return k2fArak61e;
    }

    public boolean k2fValuj2() {
        return k2fValuj2;
    }

    public boolean k2fC2kani() {
        return k2fC2kani;
    }

    public boolean k2fTara10() {
        return k2fTara10;
    }

    public boolean k2fHq2Xehate() {
        return k2fHq2Xehate;
    }

    public boolean k2fHateCal() {
        return k2fHateCal;
    }

    public boolean k2fCam2() {
        return k2fCam2;
    }

    public boolean k2fH2l() {
        return k2fH2l;
    }

    public boolean k2fVepaq() {
        return k2fVepaq;
    }

    public boolean k2fHateSp2() {
        return k2fHateSp2;
    }

    public boolean k2fNalaVe3aq() {
        return k2fNalaVe3aq;
    }
}
