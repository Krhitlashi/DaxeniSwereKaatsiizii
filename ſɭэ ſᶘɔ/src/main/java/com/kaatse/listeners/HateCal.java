package com.kaatse.listeners;

import com.kaatse.KaatseDaxe;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.server.ServerLoadEvent;
import org.bukkit.event.world.WorldSaveEvent;

public final class HateCal implements Listener {

    private final KaatseDaxe daxe;

    public HateCal(KaatseDaxe daxe) {
        this.daxe = daxe;
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void calCam2(PlayerDeathEvent cal) {
        daxe.k2f3().k2fCam22(cal.getEntity());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void calVepaq(PlayerAdvancementDoneEvent cal) {
        daxe.k2f3().k2fVepaq2(
            cal.getPlayer(),
            cal.getAdvancement().getKey().getKey()
        );
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void calJ3aTs2tosax(ServerLoadEvent cal) {
        if ( cal.getType() == ServerLoadEvent.LoadType.STARTUP ) {
            daxe.k2f3().k2fHateJ3a();
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void calNalaVe3aq(WorldSaveEvent cal) {
        daxe.k2f3().k2fNalaVe3aq2(cal.getWorld().getName());
    }
}
