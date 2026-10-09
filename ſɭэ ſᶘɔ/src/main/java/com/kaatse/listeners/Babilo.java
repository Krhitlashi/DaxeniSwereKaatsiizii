package com.kaatse.listeners;

import com.kaatse.KaatsePlugin;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

// ≺⧼ ការជជែក 📃 ⧽≻
// ស្តាប់ការជជែក

/* ស្តាប់ការជជែក ហើយកត់ត្រាវា
    @param kromprogramo ( KaatsePlugin , មិនមែន null ) - កម្មវិធីជំនួយចម្បង
    @returns អ្នកស្តាប់ថ្មី */
public class Babilo implements Listener {

    // ⟪ ទិន្នន័យកម្មវិធី 📃 ⟫
    // ឯកសារយោងកម្មវិធី
    private final KaatsePlugin kromprogramo;

    public Babilo(KaatsePlugin kromprogramo) {
        this.kromprogramo = kromprogramo;
    }

    // ⟪ ព្រឹត្តិការណ៍ 📃 ⟫
    // ព្រឹត្តិការណ៍សារ

    /* កត់ត្រាសារជជែកនីមួយៗ
        @param evento ( AsyncChatEvent , មិនមែន null ) - ព្រឹត្តិការណ៍ជជែក
        @returns គ្មាន */
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void priBabilo(AsyncChatEvent evento) {
        Player ludanto = evento.getPlayer();
        String teksto = PlainTextComponentSerializer.plainText().serialize(evento.message());
        kromprogramo.protokolo().logiBabilon(ludanto, teksto);
    }
}
