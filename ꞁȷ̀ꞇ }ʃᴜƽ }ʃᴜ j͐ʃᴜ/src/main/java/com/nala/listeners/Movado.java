package com.nala.listeners;

import com.nala.NalaPlugin;
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

// ≺⧼ ចលនា 📃 ⧽≻
// ស្តាប់ការដើរចូលទ្វារ

/* បើកបង្អួចធ្វើដំណើរម្តងនៅពេលចូលទ្វារដែលស្គាល់
    @param kromprogramo ( NalaPlugin , មិនមែន null ) - កម្មវិធីជំនួយចម្បង
    @returns អ្នកស្តាប់ថ្មី */
public class Movado implements Listener {

    // ⟪ ទិន្នន័យកម្មវិធី 📃 ⟫
    // ឯកសារយោងកម្មវិធី
    private final NalaPlugin kromprogramo;
    private final Set<UUID> ene = new HashSet<>();

    public Movado(NalaPlugin kromprogramo) {
        this.kromprogramo = kromprogramo;
    }

    // ⟪ ព្រឹត្តិការណ៍ 📃 ⟫
    // ព្រឹត្តិការណ៍ចូលនិងចាកចេញ

    /* បើកម៉ឺនុយតែនៅជំហានដំបូងចូលទ្វារ មិនមែនរាល់ពេលផ្លាស់ទីទេ
        @param evento ( PlayerMoveEvent , មិនមែន null ) - ព្រឹត្តិការណ៍ផ្លាស់ទី
        @returns គ្មាន */
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void priMovado(PlayerMoveEvent evento) {
        Location de = evento.getFrom();
        Location al = evento.getTo();
        if ( al == null ) {
            return;
        }
        if ( de.getBlockX() == al.getBlockX() && de.getBlockY() == al.getBlockY() && de.getBlockZ() == al.getBlockZ() ) {
            return;
        }
        Player ludanto = evento.getPlayer();
        if ( ! ludanto.hasPermission("nala.uzi") ) {
            return;
        }
        UUID idento = ludanto.getUniqueId();
        boolean eneNun = kromprogramo.portalo().detekti(ludanto, al) != null;
        if ( eneNun && ! ene.contains(idento) ) {
            ene.add(idento);
            kromprogramo.gui().malfermi(ludanto);
            return;
        }
        if ( ! eneNun ) {
            ene.remove(idento);
        }
    }

    /* ចងចាំទីតាំង ហើយលុបស្ថានភាពចូលទ្វារនៅពេលអ្នកលេងចាកចេញ
        @param evento ( PlayerQuitEvent , មិនមែន null ) - ព្រឹត្តិការណ៍ចាកចេញ
        @returns គ្មាន */
    @EventHandler
    public void priForiro(PlayerQuitEvent evento) {
        kromprogramo.lokoj().memoru(evento.getPlayer());
        ene.remove(evento.getPlayer().getUniqueId());
    }
}
