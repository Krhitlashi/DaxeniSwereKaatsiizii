package com.hantami;

import com.hantami.config.Agordo;
import com.hantami.config.Mesagoj;
import com.hantami.komando.HantamiKomando;
import com.hantami.listeners.Batalo;
import com.hantami.mobo.HantamiAdministranto;
import org.bukkit.plugin.java.JavaPlugin;

// ≺⧼ កម្មវិធីជំនួយ Hantami 📃 ⧽≻
// មនុស្សតុក្កតារស់នៅពិភព kaaliqlaakaarace

/* ថ្នាក់ចម្បងរបស់កម្មវិធីជំនួយ Hantami
    @returns កម្មវិធីជំនួយដែលបានរៀបចំ */
public class HantamiPlugin extends JavaPlugin {

    // ⟪ Datumoj 📃 ⟫
    // ឯកសារយោងកម្មវិធី
    private Agordo agordo;
    private HantamiAdministranto administranto;

    /* រៀបចំការកំណត់ និងចាប់ផ្តើមប្រជាជន
        @returns គ្មាន */
    @Override
    public void onEnable() {
        agordo = new Agordo(this);
        agordo.ŝargi();
        administranto = new HantamiAdministranto(this);
        administranto.ŝargi();
        administranto.adoptuEkzistantajn();
        HantamiKomando komando = new HantamiKomando(this);
        getCommand("hantami").setExecutor(komando);
        getCommand("hantami").setTabCompleter(komando);
        getServer().getPluginManager().registerEvents(new Batalo(this), this);
        administranto.eklabori();
        getLogger().info(Mesagoj.INFO_EBLIGITA);
    }

    /* រក្សាទុកផ្ទះនិងភូមិដោយសុវត្ថិភាព
        @returns គ្មាន */
    @Override
    public void onDisable() {
        if ( administranto != null ) {
            administranto.halti();
            administranto.konservi();
        }
        getLogger().info(Mesagoj.INFO_MALSAALTITA);
    }

    /* ទទួលការកំណត់បច្ចុប្បន្ន
        @returns ការកំណត់បច្ចុប្បន្ន */
    public Agordo agordo() {
        return agordo;
    }

    /* ទទួលអ្នកគ្រប់គ្រងបច្ចុប្បន្ន
        @returns អ្នកគ្រប់គ្រងបច្ចុប្បន្ន */
    public HantamiAdministranto administranto() {
        return administranto;
    }
}
