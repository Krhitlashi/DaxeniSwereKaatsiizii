package com.hantami.listeners;

import com.hantami.HantamiDaxe;
import com.hantami.mobo.HantamiMakamaj6fi;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Mannequin;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

// ≺⧼ ſןɔ 📃 ⧽≻


/* ſןɔ */
public class Pe implements Listener {

    // ⟪ ſɟᴜͷ̗ ʌ j͑ʃƽᴜƽ 📃 ⟫

    private final HantamiDaxe daxe;
    private final HantamiMakamaj6fi makamaj6fi2;

    public Pe(HantamiDaxe daxe) {
        this.daxe = daxe;
        this.makamaj6fi2 = daxe.makamaj6fi2();
    }

    // ⟪ ſɟᴜͷ̗ ʌ j͑ʃƽᴜƽ 📃 ⟫


    /* ſɟᴜͷ̗ ʌ j͑ʃƽᴜƽ */
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void calSkak(EntityDamageByEntityEvent cal) {
        if ( ! makamaj6fi2.xehateDaxe(cal.getEntity()) ) {
            return;
        }
        Mannequin daxe3 = (Mannequin) cal.getEntity();
        Player maveputas = s2rol2miMaveputas(cal.getDamager());
        if ( maveputas == null ) {
            return;
        }
        makamaj6fi2.hena3(daxe3, maveputas);
    }

    /* j͑ʃɹ ɽ͑ʃ'ɜ j͐ʃɹ ŋᷠꞇ ʌ ŋᷠᴜ j͑ʃ'ɔ ſןw ɭʃᴜɔ˞ */
    private Player s2rol2miMaveputas(Entity skak) {
        if ( skak instanceof Player hq2 ) {
            return hq2;
        }
        if ( skak instanceof Projectile tsiitii && tsiitii.getShooter() instanceof Player pe ) {
            return pe;
        }
        return null;
    }

    // ⟪ ſɟᴜͷ̗ ʌ ſɟᴜ ŋᷠɹ 📃 ⟫


    /* ſɟᴜͷ̗ ʌ ſɟᴜ ŋᷠɹ */
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void calCam2(EntityDeathEvent cal) {
        if ( ! makamaj6fi2.xehateDaxe(cal.getEntity()) ) {
            return;
        }
        makamaj6fi2.h2l11(cal.getEntity().getUniqueId());
        if ( daxe.ku1o().sahaH2l() ) {
            cal.getDrops().clear();
            cal.getDrops().add(new ItemStack(Material.TOTEM_OF_UNDYING));
        }
    }
}
