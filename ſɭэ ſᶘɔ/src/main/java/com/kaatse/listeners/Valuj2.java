package com.kaatse.listeners;

import com.kaatse.KaatseDaxe;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

// ≺⧼ j͑ʃ'ᴜ j͐ʃw ɭl̀ɹ 📃 ⧽≻


/* j͑ʃ'ᴜ j͐ʃw ɭl̀ɹ */
public class Valuj2 implements Listener {

    // ⟪ ſɟᴜͷ̗ ʌ j͑ʃ'ᴜ j͐ʃw ɭl̀ɹ 📃 ⟫

    private final KaatseDaxe daxe;

    public Valuj2(KaatseDaxe daxe) {
        this.daxe = daxe;
    }

    // ⟪ ſɟᴜͷ̗ ʌ j͑ʃ'ᴜ j͐ʃw ɭl̀ɹ 📃 ⟫


    /* ſɟᴜͷ̗ ʌ j͑ʃ'ᴜ j͐ʃw ɭl̀ɹ */
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void calValuj2(PlayerCommandPreprocessEvent cal) {
        Player hq2 = cal.getPlayer();
        String eskek22 = cal.getMessage();
        daxe.k2f3().k2fValuj22(hq2, eskek22);
    }
}
