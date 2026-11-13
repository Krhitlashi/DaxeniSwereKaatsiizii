package com.kaatse.listeners;

import com.kaatse.KaatseDaxe;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerCommandEvent;

// ≺⧼ ɭʃᴜ ɽ͑ʃ'ᴜ ſᶘɔⅎ 📃 ⧽≻


/* ɭʃᴜ ɽ͑ʃ'ᴜ ſᶘɔⅎ */
public class Tara10 implements Listener {

    // ⟪ ſɟᴜͷ̗ ʌ ɭʃᴜ ɽ͑ʃ'ᴜ ſᶘɔⅎ 📃 ⟫

    private final KaatseDaxe daxe;

    public Tara10(KaatseDaxe daxe) {
        this.daxe = daxe;
    }

    // ⟪ ſɟᴜͷ̗ ʌ ɭʃᴜ ɽ͑ʃ'ᴜ ſᶘɔⅎ 📃 ⟫


    /* ſɟᴜͷ̗ ʌ ɭʃᴜ ɽ͑ʃ'ᴜ ſᶘɔⅎ */
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void calTara10(ServerCommandEvent cal) {
        String eskek22 = cal.getCommand();
        daxe.k2f3().k2fTara10(eskek22);
    }
}
