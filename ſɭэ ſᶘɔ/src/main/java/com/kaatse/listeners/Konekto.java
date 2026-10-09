package com.kaatse.listeners;

import com.kaatse.KaatsePlugin;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

// ≺⧼ ការតភ្ជាប់ 📃 ⧽≻
// ស្តាប់ការចូលនិងចាកចេញ

/* ស្តាប់ការចូល និងចាកចេញ ហើយកត់ត្រាវា
    @param kromprogramo ( KaatsePlugin , មិនមែន null ) - កម្មវិធីជំនួយចម្បង
    @returns អ្នកស្តាប់ថ្មី */
public class Konekto implements Listener {

    // ⟪ ទិន្នន័យកម្មវិធី 📃 ⟫
    // ឯកសារយោងកម្មវិធី
    private final KaatsePlugin kromprogramo;
    private final Set<UUID> forpelitaj = ConcurrentHashMap.newKeySet();

    public Konekto(KaatsePlugin kromprogramo) {
        this.kromprogramo = kromprogramo;
    }

    // ⟪ ព្រឹត្តិការណ៍ 📃 ⟫
    // ព្រឹត្តិការណ៍ចូលចាកចេញ

    /* កត់ត្រាការចូល និងធ្វើបច្ចុប្បន្នភាពទីតាំងឯកសារ
        @param evento ( PlayerJoinEvent , មិនមែន null ) - ព្រឹត្តិការណ៍ចូល
        @returns គ្មាន */
    @EventHandler(priority = EventPriority.MONITOR)
    public void priEniro(PlayerJoinEvent evento) {
        Player ludanto = evento.getPlayer();
        forpelitaj.remove(ludanto.getUniqueId());
        kromprogramo.protokolo().kontroliKajMovi(ludanto);
        kromprogramo.protokolo().logiEniron(ludanto);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void priForpelo(PlayerKickEvent evento) {
        Player ludanto = evento.getPlayer();
        if ( kromprogramo.agordo().logiServilajnEventojn()
            && kromprogramo.agordo().logiForpelojn() ) {
            forpelitaj.add(ludanto.getUniqueId());
        }
        kromprogramo.protokolo().logiForpelon(ludanto);
    }

    /* កត់ត្រាការចាកចេញ
        @param evento ( PlayerQuitEvent , មិនមែន null ) - ព្រឹត្តិការណ៍ចាកចេញ
        @returns គ្មាន */
    @EventHandler(priority = EventPriority.MONITOR)
    public void priEliro(PlayerQuitEvent evento) {
        Player ludanto = evento.getPlayer();
        if ( forpelitaj.remove(ludanto.getUniqueId()) == false ) {
            kromprogramo.protokolo().logiEliron(ludanto);
        }
    }
}
