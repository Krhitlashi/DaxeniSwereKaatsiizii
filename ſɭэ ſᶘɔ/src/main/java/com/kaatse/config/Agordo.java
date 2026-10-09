package com.kaatse.config;

import com.kaatse.KaatsePlugin;
import java.time.ZoneId;

// ≺⧼ ការកំណត់ 📃 ⧽≻
// ការកំណត់កម្មវិធីជំនួយ

/* ការកំណត់ដែលបានអានពី config.yml
    @param kromprogramo ( KaatsePlugin , មិនមែន null ) - កម្មវិធីជំនួយចម្បង
    @returns ការកំណត់ថ្មី */
public class Agordo {

    // ⟪ ទិន្នន័យកំណត់ 📃 ⟫
    // ទិន្នន័យកំណត់
    private final KaatsePlugin kromprogramo;
    private ZoneId zono;
    private String adminPermeso;
    private boolean logiBabilon;
    private boolean logiKomandojn;
    private boolean logiKonekton;
    private boolean logiKonzolon;
    private boolean logiSubjektanMarkilon;
    private boolean logiServilajnEventojn;
    private boolean logiMortojn;
    private boolean logiForpelojn;
    private boolean logiAvancojn;
    private boolean logiServilanVivciklon;
    private boolean logiMondajnSavojn;

    public Agordo(KaatsePlugin kromprogramo) {
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
        String zonaNomo = kromprogramo.getConfig().getString("timezone", "-08:00");
        ZoneId legitaZono;
        try {
            legitaZono = ZoneId.of(zonaNomo.trim());
        } catch ( Exception eraro ) {
            legitaZono = ZoneId.of("-08:00");
            kromprogramo.getLogger().warning(Mesagoj.zono(zonaNomo));
        }
        this.zono = legitaZono;
        this.adminPermeso = kromprogramo.getConfig().getString("admin-permission", "kaatse.admin");
        this.logiBabilon = kromprogramo.getConfig().getBoolean("log-chat", true);
        this.logiKomandojn = kromprogramo.getConfig().getBoolean("log-commands", true);
        this.logiKonekton = kromprogramo.getConfig().getBoolean("log-join-quit", true);
        this.logiKonzolon = kromprogramo.getConfig().getBoolean("log-console", true);
        this.logiSubjektanMarkilon = kromprogramo.getConfig().getBoolean("log-subject-marker", false);
        this.logiServilajnEventojn = kromprogramo.getConfig().getBoolean("log-server-events", true);
        this.logiMortojn = kromprogramo.getConfig().getBoolean("log-deaths", true);
        this.logiForpelojn = kromprogramo.getConfig().getBoolean("log-kicks", true);
        this.logiAvancojn = kromprogramo.getConfig().getBoolean("log-advancements", true);
        this.logiServilanVivciklon = kromprogramo.getConfig().getBoolean("log-server-start-stop", false);
        this.logiMondajnSavojn = kromprogramo.getConfig().getBoolean("log-world-saves", false);
    }

    public ZoneId zono() {
        return zono;
    }

    public String adminPermeso() {
        return adminPermeso;
    }

    public boolean logiBabilon() {
        return logiBabilon;
    }

    public boolean logiKomandojn() {
        return logiKomandojn;
    }

    public boolean logiKonekton() {
        return logiKonekton;
    }

    public boolean logiKonzolon() {
        return logiKonzolon;
    }

    public boolean logiSubjektanMarkilon() {
        return logiSubjektanMarkilon;
    }

    public boolean logiServilajnEventojn() {
        return logiServilajnEventojn;
    }

    public boolean logiMortojn() {
        return logiMortojn;
    }

    public boolean logiForpelojn() {
        return logiForpelojn;
    }

    public boolean logiAvancojn() {
        return logiAvancojn;
    }

    public boolean logiServilanVivciklon() {
        return logiServilanVivciklon;
    }

    public boolean logiMondajnSavojn() {
        return logiMondajnSavojn;
    }
}
