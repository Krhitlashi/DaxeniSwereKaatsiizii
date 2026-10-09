package com.kaatse.listeners;

import com.kaatse.KaatsePlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.server.ServerLoadEvent;
import org.bukkit.event.world.WorldSaveEvent;

public final class ServilajEventoj implements Listener {

    private final KaatsePlugin kromprogramo;

    public ServilajEventoj(KaatsePlugin kromprogramo) {
        this.kromprogramo = kromprogramo;
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void priMorto(PlayerDeathEvent evento) {
        kromprogramo.protokolo().logiMorton(evento.getEntity());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void priAvanco(PlayerAdvancementDoneEvent evento) {
        kromprogramo.protokolo().logiAvancon(
            evento.getPlayer(),
            evento.getAdvancement().getKey().getKey()
        );
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void priKomencaŜargo(ServerLoadEvent evento) {
        if ( evento.getType() == ServerLoadEvent.LoadType.STARTUP ) {
            kromprogramo.protokolo().logiServilanEkigon();
        }
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void priMondaSavo(WorldSaveEvent evento) {
        kromprogramo.protokolo().logiMondanSavon(evento.getWorld().getName());
    }
}
