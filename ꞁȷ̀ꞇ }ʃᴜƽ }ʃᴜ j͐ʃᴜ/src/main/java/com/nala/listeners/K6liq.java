package com.nala.listeners;

import com.nala.NalaDaxe;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockFormEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.SpongeAbsorbEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.inventory.ItemStack;

// ≺⧼ ſɭэ j͐ʃꞇȝ 📃 ⧽≻


/* ſɭэ j͐ʃꞇȝ */
public class K6liq implements Listener {

    // ⟪ ſɟᴜͷ̗ ʌ ʃᴜ }ʃᴜ 📃 ⟫

    private final NalaDaxe daxe;

    public K6liq(NalaDaxe daxe) {
        this.daxe = daxe;
    }

    // ⟪ ſɟᴜͷ̗ ʌ ʃᴜ }ʃᴜ 📃 ⟫


    /* ſɟᴜͷ̗ ʌ ʃᴜ }ʃᴜ */
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void calBana(PlayerBucketEmptyEvent cal) {
        if ( ! xehateXehate(cal.getItemStack()) && ! xehateXehate(cal.getPlayer().getInventory().getItemInMainHand()) && ! xehateXehate(cal.getPlayer().getInventory().getItemInOffHand()) ) {
            return;
        }
        cal.setCancelled(true);
        Block kxawa = cal.getBlockClicked().getRelative(cal.getBlockFace());
        if ( kxawa.getType() != Material.AIR && kxawa.getType() != Material.WATER ) {
            return;
        }
        kxawa.setType(Material.WATER);
        daxe.casokfam222().s2rol2miCasokfam2(kxawa.getWorld(), kxawa.getX(), kxawa.getY(), kxawa.getZ());
    }

    /* ſɟᴜͷ̗ ʌ j͑ʃ'ɔ ɭʃɔ ŋᷠɹ */
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void calVetem2(PlayerBucketFillEvent cal) {
        Block k6liq = cal.getBlockClicked();
        if ( daxe.casokfam222().xehateCasokfam2(k6liq.getWorld(), k6liq.getX(), k6liq.getY(), k6liq.getZ()) ) {
            cal.setCancelled(true);
        }
    }

    /* ſɟᴜͷ̗ ʌ ſɭc̗ᴜ */
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void calKna(BlockPhysicsEvent cal) {
        Block k6liq = cal.getBlock();
        if ( daxe.casokfam222().xehateCasokfam2(k6liq.getWorld(), k6liq.getX(), k6liq.getY(), k6liq.getZ()) ) {
            cal.setCancelled(true);
        }
    }

    /* ſɟᴜͷ̗ ʌ ʃᴜ }ʃᴜ ɹ */
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void calBana2(BlockFromToEvent cal) {
        Block k6liq = cal.getBlock();
        if ( daxe.casokfam222().xehateCasokfam2(k6liq.getWorld(), k6liq.getX(), k6liq.getY(), k6liq.getZ()) ) {
            cal.setCancelled(true);
        }
    }

    /* ſɟᴜͷ̗ ʌ ı],ɔ ֭ſɭᴜ ɭʃɔ */
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void calXehate(BlockFormEvent cal) {
        Block k6liq = cal.getBlock();
        if ( daxe.casokfam222().xehateCasokfam2(k6liq.getWorld(), k6liq.getX(), k6liq.getY(), k6liq.getZ()) ) {
            cal.setCancelled(true);
        }
    }

    /* ſɟᴜͷ̗ ʌ ſןw ſɭɔƽ */
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void calPukek(SpongeAbsorbEvent cal) {
        for ( BlockState xehate3 : cal.getBlocks() ) {
            Block k6liq = xehate3.getBlock();
            daxe.casokfam222().h2lCasokfam2(k6liq.getWorld(), k6liq.getX(), k6liq.getY(), k6liq.getZ());
        }
    }

    /* ſɟᴜͷ̗ ʌ ſןɔ */
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void calPe(BlockExplodeEvent cal) {
        for ( Block k6liq : cal.blockList() ) {
            daxe.casokfam222().h2lCasokfam2(k6liq.getWorld(), k6liq.getX(), k6liq.getY(), k6liq.getZ());
        }
    }

    /* ſɟᴜͷ̗ ʌ ſȷw ŋᷠw ʌ ſןɔ */
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void calFumuPe(EntityExplodeEvent cal) {
        for ( Block k6liq : cal.blockList() ) {
            daxe.casokfam222().h2lCasokfam2(k6liq.getWorld(), k6liq.getX(), k6liq.getY(), k6liq.getZ());
        }
    }

    /* ı],ɔ ֭ſɭᴜ ɭʃɔ ʌ ı],ɔ ֭ſɭᴜ ɭʃɔ */
    private boolean xehateXehate(ItemStack k2fe14) {
        return daxe.casokfam222().xehateCasokfam2K2fe(k2fe14);
    }
}
