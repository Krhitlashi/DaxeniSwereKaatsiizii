package com.kaatse.listeners;

import com.kaatse.KaatsePlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerCommandEvent;

// ≺⧼ កុងសូល 📃 ⧽≻
// ស្តាប់បញ្ជាកុងសូល

/* ស្តាប់ពាក្យបញ្ជាកុងសូល ហើយកត់ត្រាវា
    @param kromprogramo ( KaatsePlugin , មិនមែន null ) - កម្មវិធីជំនួយចម្បង
    @returns អ្នកស្តាប់ថ្មី */
public class Konzolo implements Listener {

    // ⟪ ទិន្នន័យកម្មវិធី 📃 ⟫
    // ឯកសារយោងកម្មវិធី
    private final KaatsePlugin kromprogramo;

    public Konzolo(KaatsePlugin kromprogramo) {
        this.kromprogramo = kromprogramo;
    }

    // ⟪ ព្រឹត្តិការណ៍ 📃 ⟫
    // ព្រឹត្តិការណ៍កុងសូល

    /* កត់ត្រាពាក្យបញ្ជាកុងសូលនីមួយៗ
        @param evento ( ServerCommandEvent , មិនមែន null ) - ព្រឹត្តិការណ៍កុងសូល
        @returns គ្មាន */
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void priKonzolo(ServerCommandEvent evento) {
        String komando = evento.getCommand();
        kromprogramo.protokolo().logiKonzolon(komando);
    }
}
