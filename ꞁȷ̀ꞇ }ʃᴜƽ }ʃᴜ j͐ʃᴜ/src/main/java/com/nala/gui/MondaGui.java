package com.nala.gui;

import com.nala.NalaPlugin;
import com.nala.config.Mesagoj;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

// ≺⧼ បង្អួចពិភពលោក 📃 ⧽≻
// បង្ហាញបញ្ជីពិភពលោក

/* បង្ហាញបង្អួចធ្វើដំណើរដោយមិនបញ្ចូលពិភពលោកបច្ចុប្បន្ន
    @param kromprogramo ( NalaPlugin , មិនមែន null ) - កម្មវិធីជំនួយចម្បង
    @returns បង្អួចថ្មី */
public class MondaGui {

    // ⟪ ទិន្នន័យកម្មវិធី 📃 ⟫
    // ទិន្នន័យកម្មវិធី
    private final NalaPlugin kromprogramo;
    private final Map<UUID, List<World>> elektoj = new HashMap<>();

    public MondaGui(NalaPlugin kromprogramo) {
        this.kromprogramo = kromprogramo;
    }

    // ⟪ បើកបង្អួច 📃 ⟫
    // បើកបង្អួចជ្រើសរើស

    /* បើកម៉ឺនុយធ្វើដំណើរសម្រាប់អ្នកលេង
        @param ludanto ( Player , មិនមែន null ) - អ្នកលេងដែលស្នើសុំ
        @returns គ្មាន */
    public void malfermi(Player ludanto) {
        List<World> celoj = kromprogramo.administranto().celojPor(ludanto);
        if ( celoj.isEmpty() ) {
            ludanto.sendMessage(Component.text(Mesagoj.AVERTO_NENIU_MONDO));
            return;
        }
        int grando = grandoPor(celoj.size());
        Inventory menuo = Bukkit.createInventory(null, grando, Component.text(Mesagoj.GUI_TITOLO));
        for ( int i = 0; i < celoj.size(); i++ ) {
            World mondo = celoj.get(i);
            menuo.setItem(i, ikonoPor(mondo));
        }
        elektoj.put(ludanto.getUniqueId(), celoj);
        ludanto.openInventory(menuo);
    }

    /* គណនាទំហំបង្អួចតាមចំនួនទិសដៅ
        @param kvanto ( int ) - ចំនួនទិសដៅ
        @returns ពហុគុណនៃ 9 */
    private int grandoPor(int kvanto) {
        int grando = 9; // 0o11
        while ( grando < kvanto ) {
            grando += 9; // 0o11
        }
        if ( grando > 54 ) { // 0o66
            grando = 54; // 0o66
        }
        return grando;
    }

    /* បង្កើតរូបតំណាងសម្រាប់ពិភពលោកមួយ ដោយគ្មានសញ្ញាចុចពីរក្នុងអត្ថបទ
        @param mondo ( World , មិនមែន null ) - ពិភពលោកគោលដៅ
        @returns រូបតំណាងដែលបានរៀបចំ */
    private ItemStack ikonoPor(World mondo) {
        Material materialo = Material.GRASS_BLOCK;
        if ( mondo.getEnvironment() == World.Environment.NETHER ) {
            materialo = Material.NETHERRACK;
        } else if ( mondo.getEnvironment() == World.Environment.THE_END ) {
            materialo = Material.END_STONE;
        } else if ( ! mondo.getKey().getKey().equals("overworld") ) {
            materialo = Material.DIORITE;
        }
        ItemStack ikono = new ItemStack(materialo);
        ItemMeta meta = ikono.getItemMeta();
        meta.displayName(Component.text(mondo.getName()));
        String medioNomo = mondo.getEnvironment().name();
        meta.lore(java.util.List.of(Component.text(Mesagoj.GUI_MEDIO + medioNomo + " ⟅"), Component.text(Mesagoj.GUI_ALKLAKU)));
        ikono.setItemMeta(meta);
        return ikono;
    }

    /* អានទិសដៅតាមអ្នកលេង និងរន្ធម៉ឺនុយ
        @param ludanto ( Player , មិនមែន null ) - អ្នកលេងដែលចុច
        @param fendo ( int ) - រន្ធដែលបានចុច
        @returns ពិភពលោកគោលដៅ ឬ null */
    public World celoPor(Player ludanto, int fendo) {
        List<World> celoj = elektoj.get(ludanto.getUniqueId());
        if ( celoj == null || fendo < 0 || fendo >= celoj.size() ) {
            return null;
        }
        return celoj.get(fendo);
    }

    /* ពិនិត្យថាតើអ្នកលេងមានម៉ឺនុយបើកឬអត់
        @param ludanto ( Player , មិនមែន null ) - អ្នកលេងដែលត្រូវពិនិត្យ
        @returns ពិតប្រសិនបើម៉ឺនុយបើក */
    public boolean havasMenuon(Player ludanto) {
        return elektoj.containsKey(ludanto.getUniqueId());
    }

    /* លុបជម្រើសដែលបានរក្សាទុកបន្ទាប់ពីបិទម៉ឺនុយ
        @param ludanto ( Player , មិនមែន null ) - អ្នកលេងដែលចាកចេញ
        @returns គ្មាន */
    public void forgesi(Player ludanto) {
        elektoj.remove(ludanto.getUniqueId());
    }
}
