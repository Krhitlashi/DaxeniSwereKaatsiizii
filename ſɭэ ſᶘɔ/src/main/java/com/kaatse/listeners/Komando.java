package com.kaatse.listeners;

import com.kaatse.KaatsePlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

// ≺⧼ ពាក្យបញ្ជា 📃 ⧽≻
// ស្តាប់ពាក្យបញ្ជា

/* ស្តាប់ពាក្យបញ្ជារបស់អ្នកលេង ហើយកត់ត្រាវា
    @param kromprogramo ( KaatsePlugin , មិនមែន null ) - កម្មវិធីជំនួយចម្បង
    @returns អ្នកស្តាប់ថ្មី */
public class Komando implements Listener {

    // ⟪ ទិន្នន័យកម្មវិធី 📃 ⟫
    // ឯកសារយោងកម្មវិធី
    private final KaatsePlugin kromprogramo;

    public Komando(KaatsePlugin kromprogramo) {
        this.kromprogramo = kromprogramo;
    }

    // ⟪ ព្រឹត្តិការណ៍ 📃 ⟫
    // ព្រឹត្តិការណ៍បញ្ជា

    /* កត់ត្រាពាក្យបញ្ជានីមួយៗដែលចាប់ផ្តើមដោយសញ្ញា slash
        @param evento ( PlayerCommandPreprocessEvent , មិនមែន null ) - ព្រឹត្តិការណ៍ពាក្យបញ្ជា
        @returns គ្មាន */
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void priKomando(PlayerCommandPreprocessEvent evento) {
        Player ludanto = evento.getPlayer();
        String komando = evento.getMessage();
        kromprogramo.protokolo().logiKomandon(ludanto, komando);
    }
}
