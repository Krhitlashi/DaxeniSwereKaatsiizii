package com.kaatse.listeners;

import com.kaatse.KaatseDaxe;
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

// ≺⧼ ſɟɹ ſɭᴜ }ʃꞇ 📃 ⧽≻


/* ſɟɹ ſɭᴜ }ʃꞇ */
public class C2kani implements Listener {

    // ⟪ ſɟᴜͷ̗ ʌ j͑ʃ'ɔ ʃэ ſɭɔƽ 📃 ⟫

    private final KaatseDaxe daxe;
    private final Set<UUID> h2l3 = ConcurrentHashMap.newKeySet();

    public C2kani(KaatseDaxe daxe) {
        this.daxe = daxe;
    }

    // ⟪ ſɟᴜͷ̗ ʌ j͑ʃ'ɔ ʃэ ſɭɔƽ 📃 ⟫


    /* ſɟᴜͷ̗ ʌ j͑ʃ'ɔ ʃэ ſɭɔƽ */
    @EventHandler(priority = EventPriority.MONITOR)
    public void calVeb6kek(PlayerJoinEvent cal) {
        Player hq2 = cal.getPlayer();
        h2l3.remove(hq2.getUniqueId());
        daxe.k2f3().s2rol2miC2kaniXaraq(hq2);
        daxe.k2f3().k2fVeb6kek(hq2);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void calH2l(PlayerKickEvent cal) {
        Player hq2 = cal.getPlayer();
        if ( daxe.ku1o().k2fHateCal()
            && daxe.ku1o().k2fH2l() ) {
            h2l3.add(hq2.getUniqueId());
        }
        daxe.k2f3().k2fH2l2(hq2);
    }

    /* ſɟᴜͷ̗ ʌ ı],ᴜ ɽ͑ʃ'ᴜȝ */
    @EventHandler(priority = EventPriority.MONITOR)
    public void calXaraq(PlayerQuitEvent cal) {
        Player hq2 = cal.getPlayer();
        if ( h2l3.remove(hq2.getUniqueId()) == false ) {
            daxe.k2f3().k2fXaraq(hq2);
        }
    }
}
