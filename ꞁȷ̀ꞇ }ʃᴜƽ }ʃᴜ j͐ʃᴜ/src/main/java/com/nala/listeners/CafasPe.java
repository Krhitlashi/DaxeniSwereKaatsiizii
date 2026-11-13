package com.nala.listeners;

import com.nala.NalaDaxe;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

// ≺⧼ ſɟᴜ ſȷᴜɔ˞ ʌ ſןɔ 📃 ⧽≻


/* ſɟᴜ ſȷᴜɔ˞ ʌ ſןɔ */
public class CafasPe implements Listener {

    // ⟪ ſɟᴜͷ̗ ʌ ſןɔ ɹ 📃 ⟫

    private final NalaDaxe daxe;

    public CafasPe(NalaDaxe daxe) {
        this.daxe = daxe;
    }

    // ⟪ ſɟᴜͷ̗ ʌ ſןɔ ɹ 📃 ⟫


    /* ſɟᴜͷ̗ ʌ ſןɔ ɹ */
    @EventHandler(ignoreCancelled = true)
    public void calPe2(InventoryClickEvent cal) {
        if ( ! ( cal.getWhoClicked() instanceof Player hq2 ) ) {
            return;
        }
        if ( ! daxe.cafas().eskekCa1ara(hq2) ) {
            return;
        }
        cal.setCancelled(true);
        if ( cal.getClickedInventory() == null || ! cal.getClickedInventory().equals(cal.getView().getTopInventory()) ) {
            return;
        }
        World kxawa = daxe.cafas().kxawaZeni(hq2, cal.getSlot());
        if ( kxawa == null ) {
            return;
        }
        hq2.closeInventory();
        daxe.makamaj6fi2().xaraq4(hq2, kxawa);
    }

    /* ſɟᴜͷ̗ ʌ ֭ſɭɹ j͐ʃɹ */
    @EventHandler
    public void calH2l2(InventoryCloseEvent cal) {
        if ( cal.getPlayer() instanceof Player hq2 ) {
            if ( daxe.cafas().eskekCa1ara(hq2) ) {
                daxe.cafas().h2l18(hq2);
            }
        }
    }
}
