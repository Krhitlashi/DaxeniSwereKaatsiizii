package com.kaatse.listeners;

import com.kaatse.KaatseDaxe;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

// ≺⧼ ꞁȷ̀ᴜ ɽ͑ʃ'ᴜ ſɭэ ſᶘɔ 📃 ⧽≻


/* ꞁȷ̀ᴜ ɽ͑ʃ'ᴜ ſɭэ ſᶘɔ */
public class Arak61e implements Listener {

    // ⟪ ſɟᴜͷ̗ ʌ ꞁȷ̀ᴜ ɽ͑ʃ'ᴜ ſɭэ ſᶘɔ 📃 ⟫

    private final KaatseDaxe daxe;

    public Arak61e(KaatseDaxe daxe) {
        this.daxe = daxe;
    }

    // ⟪ ſɟᴜͷ̗ ʌ ꞁȷ̀ᴜ ɽ͑ʃ'ᴜ ſɭэ ſᶘɔ 📃 ⟫


    /* ſɟᴜͷ̗ ʌ ꞁȷ̀ᴜ ɽ͑ʃ'ᴜ ſɭэ ſᶘɔ */
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void calArak61e(AsyncChatEvent cal) {
        Player hq2 = cal.getPlayer();
        String s2bana = PlainTextComponentSerializer.plainText().serialize(cal.message());
        daxe.k2f3().k2fArak61e(hq2, s2bana);
    }
}
