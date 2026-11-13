package com.nala.listeners;

import com.nala.NalaDaxe;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

// ≺⧼ ı],ᴜ ɽ͑ʃ'ᴜȝ 📃 ⧽≻


/* ı],ᴜ ɽ͑ʃ'ᴜȝ */
public class Xaraq implements Listener {

    // ⟪ ſɟᴜͷ̗ ʌ ı],ᴜ ɽ͑ʃ'ᴜ ſ͕ɭɹ 📃 ⟫

    private final NalaDaxe daxe;
    private final Set<UUID> tara1of3 = new HashSet<>();

    public Xaraq(NalaDaxe daxe) {
        this.daxe = daxe;
    }

    // ⟪ ſɟᴜͷ̗ ʌ ı],ᴜ ɽ͑ʃ'ᴜ ſ͕ɭɹ 📃 ⟫


    /* ſɟᴜͷ̗ ʌ ı],ᴜ ɽ͑ʃ'ᴜ ſ͕ɭɹ */
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void calXaraq2(PlayerMoveEvent cal) {
        Location a1iq = cal.getFrom();
        Location zeni2 = cal.getTo();
        if ( zeni2 == null ) {
            return;
        }
        if ( a1iq.getBlockX() == zeni2.getBlockX() && a1iq.getBlockY() == zeni2.getBlockY() && a1iq.getBlockZ() == zeni2.getBlockZ() ) {
            return;
        }
        Player hq2 = cal.getPlayer();
        if ( ! hq2.hasPermission("nala.uzi") ) {
            return;
        }
        UUID ksaka6 = hq2.getUniqueId();
        boolean tara1ofGani = daxe.casokfam222().s2rol2mi9(hq2, zeni2) != null;
        if ( tara1ofGani && ! tara1of3.contains(ksaka6) ) {
            tara1of3.add(ksaka6);
            daxe.cafas().veb6kek9(hq2);
            return;
        }
        if ( ! tara1ofGani ) {
            tara1of3.remove(ksaka6);
        }
    }

    /* ſɟᴜͷ̗ ʌ ı],ᴜ ɽ͑ʃ'ᴜȝŋ */
    @EventHandler
    public void calXaraq3(PlayerQuitEvent cal) {
        daxe.araq7().ksaka7(cal.getPlayer());
        tara1of3.remove(cal.getPlayer().getUniqueId());
    }
}
