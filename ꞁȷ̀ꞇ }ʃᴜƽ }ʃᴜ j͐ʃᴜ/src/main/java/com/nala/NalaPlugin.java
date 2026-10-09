package com.nala;

import com.nala.config.Agordo;
import com.nala.config.Mesagoj;
import com.nala.gui.MondaGui;
import com.nala.komando.NalaKomando;
import com.nala.listeners.Bloko;
import com.nala.listeners.GuiKlako;
import com.nala.listeners.Movado;
import com.nala.portalo.LastaLoko;
import com.nala.portalo.MondaAdministranto;
import com.nala.portalo.Portalo;
import com.nala.rimedpako.RimedpakoGastiganto;
import org.bukkit.plugin.java.JavaPlugin;

// ≺⧼ កម្មវិធីជំនួយ Nala 📃 ⧽≻
// កម្មវិធីធ្វើដំណើរតាមទ្វារ

/* ថ្នាក់ចម្បងរបស់ Nala សម្រាប់ធ្វើដំណើរតាមទ្វាររវាងពិភពលោក
    @returns កម្មវិធីជំនួយដែលបានរៀបចំ */
public class NalaPlugin extends JavaPlugin {

    // ⟪ ទិន្នន័យកម្មវិធី 📃 ⟫
    // ទិន្នន័យកម្មវិធី
    private Agordo agordo;
    private Portalo portalo;
    private LastaLoko lokoj;
    private MondaAdministranto administranto;
    private MondaGui gui;
    private RimedpakoGastiganto gastiganto;

    // ⟪ ការចាប់ផ្តើម 📃 ⟫
    // ការចាប់ផ្តើម

    /* រៀបចំការកំណត់ ពិភពលោក ទ្វារ និងអ្នកស្តាប់ព្រឹត្តិការណ៍
        @returns គ្មាន */
    @Override
    public void onEnable() {
        agordo = new Agordo(this);
        portalo = new Portalo(this);
        lokoj = new LastaLoko(this);
        lokoj.ŝargi();
        administranto = new MondaAdministranto(this);
        gui = new MondaGui(this);
        prepariImport();
        prepariPakojn();
        gastiganto = new RimedpakoGastiganto(this);
        gastiganto.eklabori();
        administranto.certigiMondojn();
        portalo.ŝargi();
        NalaKomando komando = new NalaKomando(this);
        getCommand("nala").setExecutor(komando);
        getCommand("nala").setTabCompleter(komando);
        getServer().getPluginManager().registerEvents(new Movado(this), this);
        getServer().getPluginManager().registerEvents(new GuiKlako(this), this);
        getServer().getPluginManager().registerEvents(new Bloko(this), this);
        getServer().getScheduler().runTaskTimer(this, () -> portalo.briligi(), 8, 8); // 0o10
        getLogger().info(Mesagoj.INFO_EBLIGITA);
    }

    /* រក្សាទុកទ្វារដោយសុវត្ថិភាព
        @returns គ្មាន */
    @Override
    public void onDisable() {
        if ( portalo != null ) {
            portalo.konservi();
        }
        if ( lokoj != null ) {
            lokoj.konservi();
        }
        if ( gastiganto != null ) {
            gastiganto.halti();
        }
        getLogger().info(Mesagoj.INFO_MALSAALTITA);
    }

    /* រៀបចំថតកញ្ចប់ជាមួយសេចក្តីពន្យល់
        @returns គ្មាន */
    private void prepariPakojn() {
        prepariPakujon("datumpako", Mesagoj.README_DATUMPAKO);
        prepariPakujon("rimedpako", Mesagoj.README_RIMEDPAKO);
    }

    /* រៀបចំថតកញ្ចប់មួយជាមួយសេចក្តីពន្យល់
        @param nomo ( String , មិនមែន null ) - ឈ្មោះថត
        @param teksto ( String , មិនមែន null ) - អត្ថបទពន្យល់
        @returns គ្មាន */
    private void prepariPakujon(String nomo, String teksto) {
        java.io.File pakaBazo = new java.io.File(getDataFolder(), nomo);
        pakaBazo.mkdirs();
        java.io.File klarigo = new java.io.File(pakaBazo, "README.txt");
        if ( ! klarigo.exists() ) {
            try {
                java.nio.file.Files.writeString(klarigo.toPath(), teksto);
            } catch ( Exception eraro ) {
                getLogger().warning(Mesagoj.WARN_PAKA_KLARIGO);
            }
        }
    }

    /* រៀបចំថតនាំចូលជាមួយសេចក្តីពន្យល់
        @returns គ្មាន */
    private void prepariImport() {
        java.io.File importBazo = new java.io.File(getDataFolder(), "import");
        importBazo.mkdirs();
        java.io.File klarigo = new java.io.File(importBazo, "README.txt");
        if ( ! klarigo.exists() ) {
            try {
                java.nio.file.Files.writeString(klarigo.toPath(), Mesagoj.README_IMPORT);
            } catch ( Exception eraro ) {
                getLogger().warning(Mesagoj.WARN_IMPORT_KLARIGO);
            }
        }
    }

    /* ទទួលការកំណត់បច្ចុប្បន្ន
        @returns ការកំណត់បច្ចុប្បន្ន */
    public Agordo agordo() {
        return agordo;
    }

    /* ទទួលទ្វារបច្ចុប្បន្ន
        @returns ទ្វារបច្ចុប្បន្ន */
    public Portalo portalo() {
        return portalo;
    }

    /* ទទួលទិន្នន័យទីតាំងចុងក្រោយ
        @returns ទិន្នន័យចងចាំបច្ចុប្បន្ន */
    public LastaLoko lokoj() {
        return lokoj;
    }

    /* ទទួលកម្មវិធីគ្រប់គ្រងពិភពលោក
        @returns កម្មវិធីគ្រប់គ្រងបច្ចុប្បន្ន */
    public MondaAdministranto administranto() {
        return administranto;
    }

    /* ទទួលបង្អួចជ្រើសរើស
        @returns បង្អួចជ្រើសរើសបច្ចុប្បន្ន */
    public MondaGui gui() {
        return gui;
    }

    /* ទទួលម៉ាស៊ីនផ្ទុកកញ្ចប់ធនធាន
        @returns ម៉ាស៊ីនផ្ទុកបច្ចុប្បន្ន */
    public RimedpakoGastiganto gastiganto() {
        return gastiganto;
    }
}
