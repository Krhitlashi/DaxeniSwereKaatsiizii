package com.kaatse;

import com.kaatse.config.Agordo;
import com.kaatse.config.Mesagoj;
import com.kaatse.listeners.Babilo;
import com.kaatse.listeners.Komando;
import com.kaatse.listeners.Konekto;
import com.kaatse.listeners.Konzolo;
import com.kaatse.listeners.ServilajEventoj;
import com.kaatse.logger.Protokolo;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

// ≺⧼ កម្មវិធីជំនួយ Kaatse 📃 ⧽≻
// កម្មវិធីជំនួយកំណត់ហេតុ S2WENI

/* ថ្នាក់ចម្បងរបស់ Kaatse ដែលប្រើពេលវេលា S2WENI និងគោលប្រាំបី
    @returns កម្មវិធីជំនួយដែលបានរៀបចំ */
public class KaatsePlugin extends JavaPlugin {

    // ⟪ ទិន្នន័យកម្មវិធី 📃 ⟫
    // ទិន្នន័យកម្មវិធី
    private Agordo agordo;
    private Protokolo protokolo;

    // ⟪ ការចាប់ផ្តើម 📃 ⟫
    // ការចាប់ផ្តើម

    /* រៀបចំការកំណត់ កំណត់ហេតុ និងអ្នកស្តាប់ព្រឹត្តិការណ៍
        @returns គ្មាន */
    @Override
    public void onEnable() {
        agordo = new Agordo(this);
        protokolo = new Protokolo(this);
        registri();
        getLogger().info(Mesagoj.INFO_EBLIGITA);
    }

    /* បញ្ឈប់កំណត់ហេតុដោយសុវត្ថិភាព
        @returns គ្មាន */
    @Override
    public void onDisable() {
        if ( protokolo != null ) {
            if ( Bukkit.isStopping() ) {
                protokolo.logiServilanFinon();
            }
            protokolo.fermi();
        }
        getLogger().info(Mesagoj.INFO_MALSAALTITA);
    }

    // ⟪ អ្នកស្តាប់ព្រឹត្តិការណ៍ 📃 ⟫
    // ការចុះឈ្មោះព្រឹត្តិការណ៍

    /* ចុះឈ្មោះអ្នកស្តាប់ទាំងបួន
        @returns គ្មាន */
    private void registri() {
        getServer().getPluginManager().registerEvents(new Babilo(this), this);
        getServer().getPluginManager().registerEvents(new Komando(this), this);
        getServer().getPluginManager().registerEvents(new Konekto(this), this);
        getServer().getPluginManager().registerEvents(new Konzolo(this), this);
        getServer().getPluginManager().registerEvents(new ServilajEventoj(this), this);
    }

    /* ទទួលការកំណត់បច្ចុប្បន្ន
        @returns ការកំណត់បច្ចុប្បន្ន */
    public Agordo agordo() {
        return agordo;
    }

    /* ទទួលកំណត់ហេតុបច្ចុប្បន្ន
        @returns កំណត់ហេតុបច្ចុប្បន្ន */
    public Protokolo protokolo() {
        return protokolo;
    }
}
