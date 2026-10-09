package com.hantami.listeners;

import com.hantami.HantamiPlugin;
import com.hantami.mobo.HantamiAdministranto;
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

// ≺⧼ បាតុភូតប្រយុទ្ធ 📃 ⧽≻
// សងសឹក ទម្លាក់ totem និងតាមដានព្រួញ

/* ការវាយប្រហារ Hantami ធ្វើឱ្យខឹង និងការស្លាប់ទម្លាក់តូតែម
    @param kromprogramo ( HantamiPlugin , មិនមែន null ) - កម្មវិធីជំនួយចម្បង
    @returns អ្នកស្តាប់ថ្មី */
public class Batalo implements Listener {

    // ⟪ Datumoj 📃 ⟫
    // ឯកសារយោងកម្មវិធី
    private final HantamiPlugin kromprogramo;
    private final HantamiAdministranto administranto;

    public Batalo(HantamiPlugin kromprogramo) {
        this.kromprogramo = kromprogramo;
        this.administranto = kromprogramo.administranto();
    }

    // ⟪ Vundo 📃 ⟫
    // អ្នកវាយប្រហារក្លាយជាគោលដៅ

    /* ការវាយប្រហារពីអ្នកលេងធ្វើឱ្យ Hantami រងរបួសខឹង
        @param evento ( EntityDamageByEntityEvent , មិនមែន null ) - ព្រឹត្តិការណ៍របួស
        @returns គ្មាន */
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void priVundo(EntityDamageByEntityEvent evento) {
        if ( ! administranto.estasHantami(evento.getEntity()) ) {
            return;
        }
        Mannequin hantamo = (Mannequin) evento.getEntity();
        Player atakanto = troviAtakanton(evento.getDamager());
        if ( atakanto == null ) {
            return;
        }
        administranto.venĝi(hantamo, atakanto);
    }

    /* រកអ្នកលេងនៅពីក្រោយការខូចខាតផ្ទាល់ឬពីព្រួញ
        @param damaĝanto ( Entity , មិនមែន null ) - អង្គភាពបង្កការខូចខាត
        @returns អ្នកលេង ឬ null */
    private Player troviAtakanton(Entity damaĝanto) {
        if ( damaĝanto instanceof Player ludanto ) {
            return ludanto;
        }
        if ( damaĝanto instanceof Projectile pafaĵo && pafaĵo.getShooter() instanceof Player pafinto ) {
            return pafinto;
        }
        return null;
    }

    // ⟪ Morto 📃 ⟫
    // តូតែមធ្លាក់

    /* ការស្លាប់របស់ Hantami ទម្លាក់តូតែមការពារស្លាប់
        @param evento ( EntityDeathEvent , មិនមែន null ) - ព្រឹត្តិការណ៍ស្លាប់
        @returns គ្មាន */
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void priMorto(EntityDeathEvent evento) {
        if ( ! administranto.estasHantami(evento.getEntity()) ) {
            return;
        }
        administranto.forgesu(evento.getEntity().getUniqueId());
        if ( kromprogramo.agordo().totemoFalo() ) {
            evento.getDrops().clear();
            evento.getDrops().add(new ItemStack(Material.TOTEM_OF_UNDYING));
        }
    }
}
