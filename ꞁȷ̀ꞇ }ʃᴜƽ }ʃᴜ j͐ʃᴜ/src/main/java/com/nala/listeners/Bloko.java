package com.nala.listeners;

import com.nala.NalaPlugin;
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

// ≺⧼ ប្លុក 📃 ⧽≻
// គ្រប់គ្រងប្លុកទឹក Casokfamii

/* តាមដានទឹកដែលចាក់ ការពារវា និងដោះស្រាយការស្រូបដោយអេប៉ុង
    @param kromprogramo ( NalaPlugin , មិនមែន null ) - កម្មវិធីជំនួយចម្បង
    @returns អ្នកស្តាប់ថ្មី */
public class Bloko implements Listener {

    // ⟪ ទិន្នន័យកម្មវិធី 📃 ⟫
    // ឯកសារយោងកម្មវិធី
    private final NalaPlugin kromprogramo;

    public Bloko(NalaPlugin kromprogramo) {
        this.kromprogramo = kromprogramo;
    }

    // ⟪ ព្រឹត្តិការណ៍ 📃 ⟫
    // ព្រឹត្តិការណ៍ប្លុក

    /* ជំនួសការចាក់ទឹកពីធុងដោយទឹកទ្វារដែលបានតាមដាន
        @param evento ( PlayerBucketEmptyEvent , មិនមែន null ) - ព្រឹត្តិការណ៍ចាក់ទឹក
        @returns គ្មាន */
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void priVerŝo(PlayerBucketEmptyEvent evento) {
        if ( ! estasMarkita(evento.getItemStack()) && ! estasMarkita(evento.getPlayer().getInventory().getItemInMainHand()) && ! estasMarkita(evento.getPlayer().getInventory().getItemInOffHand()) ) {
            return;
        }
        evento.setCancelled(true);
        Block celo = evento.getBlockClicked().getRelative(evento.getBlockFace());
        if ( celo.getType() != Material.AIR && celo.getType() != Material.WATER ) {
            return;
        }
        celo.setType(Material.WATER);
        kromprogramo.portalo().spuriCasokfamii(celo.getWorld(), celo.getX(), celo.getY(), celo.getZ());
    }

    /* រារាំងការដងទឹកទ្វារដែលបានតាមដានដោយធុង
        @param evento ( PlayerBucketFillEvent , មិនមែន null ) - ព្រឹត្តិការណ៍ដងទឹក
        @returns គ្មាន */
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void priĈerpado(PlayerBucketFillEvent evento) {
        Block bloko = evento.getBlockClicked();
        if ( kromprogramo.portalo().estasCasokfamii(bloko.getWorld(), bloko.getX(), bloko.getY(), bloko.getZ()) ) {
            evento.setCancelled(true);
        }
    }

    /* ការពារទឹកដែលបានតាមដានពីលំហូរ ការកក និងរូបវិទ្យាប្លុក
        @param evento ( BlockPhysicsEvent , មិនមែន null ) - ព្រឹត្តិការណ៍រូបវិទ្យា
        @returns គ្មាន */
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void priFiziko(BlockPhysicsEvent evento) {
        Block bloko = evento.getBlock();
        if ( kromprogramo.portalo().estasCasokfamii(bloko.getWorld(), bloko.getX(), bloko.getY(), bloko.getZ()) ) {
            evento.setCancelled(true);
        }
    }

    /* រារាំងលំហូរចេញពីទឹកទ្វារដែលបានតាមដាន
        @param evento ( BlockFromToEvent , មិនមែន null ) - ព្រឹត្តិការណ៍លំហូរ
        @returns គ្មាន */
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void priFluo(BlockFromToEvent evento) {
        Block bloko = evento.getBlock();
        if ( kromprogramo.portalo().estasCasokfamii(bloko.getWorld(), bloko.getX(), bloko.getY(), bloko.getZ()) ) {
            evento.setCancelled(true);
        }
    }

    /* រារាំងការកករបស់ទឹកទ្វារដែលបានតាមដាន
        @param evento ( BlockFormEvent , មិនមែន null ) - ព្រឹត្តិការណ៍បង្កើតប្លុក
        @returns គ្មាន */
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void priFormo(BlockFormEvent evento) {
        Block bloko = evento.getBlock();
        if ( kromprogramo.portalo().estasCasokfamii(bloko.getWorld(), bloko.getX(), bloko.getY(), bloko.getZ()) ) {
            evento.setCancelled(true);
        }
    }

    /* លុបការតាមដានប្លុកដែលអេប៉ុងបានស្រូប
        @param evento ( SpongeAbsorbEvent , មិនមែន null ) - ព្រឹត្តិការណ៍ស្រូប
        @returns គ្មាន */
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void priSpongo(SpongeAbsorbEvent evento) {
        for ( BlockState stato : evento.getBlocks() ) {
            Block bloko = stato.getBlock();
            kromprogramo.portalo().forgesiCasokfamii(bloko.getWorld(), bloko.getX(), bloko.getY(), bloko.getZ());
        }
    }

    /* លុបការតាមដានប្លុកដែលត្រូវបានបំផ្លាញដោយការផ្ទុះ
        @param evento ( BlockExplodeEvent , មិនមែន null ) - ព្រឹត្តិការណ៍ផ្ទុះ
        @returns គ្មាន */
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void priEksplodo(BlockExplodeEvent evento) {
        for ( Block bloko : evento.blockList() ) {
            kromprogramo.portalo().forgesiCasokfamii(bloko.getWorld(), bloko.getX(), bloko.getY(), bloko.getZ());
        }
    }

    /* លុបការតាមដានប្លុកដែលត្រូវបានបំផ្លាញដោយការផ្ទុះរបស់អង្គភាព
        @param evento ( EntityExplodeEvent , មិនមែន null ) - ព្រឹត្តិការណ៍ផ្ទុះ
        @returns គ្មាន */
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void priEstaĵEksplodo(EntityExplodeEvent evento) {
        for ( Block bloko : evento.blockList() ) {
            kromprogramo.portalo().forgesiCasokfamii(bloko.getWorld(), bloko.getX(), bloko.getY(), bloko.getZ());
        }
    }

    /* ពិនិត្យធុងដែលមានសញ្ញាសម្គាល់តាមផ្ទៃដែលវាប៉ះ
        @param objekto ( ItemStack , អាចជា null ) - វត្ថុដែលត្រូវពិនិត្យ
        @returns ពិតប្រសិនបើមានសញ្ញាសម្គាល់ */
    private boolean estasMarkita(ItemStack objekto) {
        return kromprogramo.portalo().estasCasokfamiiObjekto(objekto);
    }
}
