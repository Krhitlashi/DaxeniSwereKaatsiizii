package com.nala.listeners;

import com.nala.NalaPlugin;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

// ≺⧼ ការចុចក្នុងបង្អួច 📃 ⧽≻
// ស្តាប់ការជ្រើសរើសពិភពលោក

/* ដំណើរការការចុចក្នុងម៉ឺនុយធ្វើដំណើររបស់ Nala
    @param kromprogramo ( NalaPlugin , មិនមែន null ) - កម្មវិធីជំនួយចម្បង
    @returns អ្នកស្តាប់ថ្មី */
public class GuiKlako implements Listener {

    // ⟪ ទិន្នន័យកម្មវិធី 📃 ⟫
    // ឯកសារយោងកម្មវិធី
    private final NalaPlugin kromprogramo;

    public GuiKlako(NalaPlugin kromprogramo) {
        this.kromprogramo = kromprogramo;
    }

    // ⟪ ព្រឹត្តិការណ៍ 📃 ⟫
    // ព្រឹត្តិការណ៍ចុចនិងបិទ

    /* បញ្ជូនទៅពិភពលោកដែលបានជ្រើសរើសក្រោយចុច
        @param evento ( InventoryClickEvent , មិនមែន null ) - ព្រឹត្តិការណ៍ចុច
        @returns គ្មាន */
    @EventHandler(ignoreCancelled = true)
    public void priKlako(InventoryClickEvent evento) {
        if ( ! ( evento.getWhoClicked() instanceof Player ludanto ) ) {
            return;
        }
        if ( ! kromprogramo.gui().havasMenuon(ludanto) ) {
            return;
        }
        evento.setCancelled(true);
        if ( evento.getClickedInventory() == null || ! evento.getClickedInventory().equals(evento.getView().getTopInventory()) ) {
            return;
        }
        World celo = kromprogramo.gui().celoPor(ludanto, evento.getSlot());
        if ( celo == null ) {
            return;
        }
        ludanto.closeInventory();
        kromprogramo.administranto().vojaĝi(ludanto, celo);
    }

    /* លុបជម្រើសនៅពេលបិទម៉ឺនុយ
        @param evento ( InventoryCloseEvent , មិនមែន null ) - ព្រឹត្តិការណ៍បិទ
        @returns គ្មាន */
    @EventHandler
    public void priFermo(InventoryCloseEvent evento) {
        if ( evento.getPlayer() instanceof Player ludanto ) {
            if ( kromprogramo.gui().havasMenuon(ludanto) ) {
                kromprogramo.gui().forgesi(ludanto);
            }
        }
    }
}
