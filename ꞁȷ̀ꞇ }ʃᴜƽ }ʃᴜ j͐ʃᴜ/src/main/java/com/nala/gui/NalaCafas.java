package com.nala.gui;

import com.nala.NalaDaxe;
import com.nala.config.S2bana;
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

// ≺⧼ ſɟᴜ ſȷᴜɔ˞ 📃 ⧽≻


/* ſɟᴜ ſȷᴜɔ˞ */
public class NalaCafas {

    // ⟪ j͑ʃ'ɔ ʃэ ſɭɔƽ 📃 ⟫

    private final NalaDaxe daxe;
    private final Map<UUID, List<World>> sukf2q2 = new HashMap<>();

    public NalaCafas(NalaDaxe daxe) {
        this.daxe = daxe;
    }

    // ⟪ j͑ʃ'ɔ ʃэ ſɭɔƽ 📃 ⟫


    /* j͑ʃ'ɔ ʃэ ſɭɔƽ */
    public void veb6kek9(Player hq2) {
        List<World> kxawa7 = daxe.makamaj6fi2().kxawaZeni2(hq2);
        if ( kxawa7.isEmpty() ) {
            hq2.sendMessage(Component.text(S2bana.YOR2_H2L_NALA));
            return;
        }
        int pal64 = pal6Zeni(kxawa7.size());
        Inventory ca1ara4 = Bukkit.createInventory(null, pal64, Component.text(S2bana.CAFAS_HATE));
        for ( int k2fe = 0; k2fe < kxawa7.size(); k2fe++ ) {
            World nala2 = kxawa7.get(k2fe);
            ca1ara4.setItem(k2fe, tahaqZeni(nala2));
        }
        sukf2q2.put(hq2.getUniqueId(), kxawa7);
        hq2.openInventory(ca1ara4);
    }

    /* ſןᴜ j͐ʃэ ʌ ſɭ,ɔ }ʃꞇ */
    private int pal6Zeni(int k2fe13) {
        int pal64 = 9;
        while ( pal64 < k2fe13 ) {
            pal64 += 9;
        }
        if ( pal64 > 54 ) {
            pal64 = 54;
        }
        return pal64;
    }

    /* ɭʃᴜ ֭ſɭᴜȝ ʌ ſɭ,ɔ }ʃꞇ */
    private ItemStack tahaqZeni(World nala2) {
        Material pukek4 = Material.GRASS_BLOCK;
        if ( nala2.getEnvironment() == World.Environment.NETHER ) {
            pukek4 = Material.NETHERRACK;
        } else if ( nala2.getEnvironment() == World.Environment.THE_END ) {
            pukek4 = Material.END_STONE;
        } else if ( ! nala2.getKey().getKey().equals("overworld") ) {
            pukek4 = Material.DIORITE;
        }
        ItemStack tahaq = new ItemStack(pukek4);
        ItemMeta vop25 = tahaq.getItemMeta();
        vop25.displayName(Component.text(nala2.getName()));
        String tara1ofKsaka = nala2.getEnvironment().name();
        vop25.lore(java.util.List.of(Component.text(S2bana.CAFAS_TARA1OF + tara1ofKsaka + " ⟅"), Component.text(S2bana.CAFAS_PE)));
        tahaq.setItemMeta(vop25);
        return tahaq;
    }

    /* ſɭᶗ‹ᴜ ᶅſᴜ ʌ ſɭ,ɔ }ʃꞇ */
    public World kxawaZeni(Player hq2, int kantoni12) {
        List<World> kxawa7 = sukf2q2.get(hq2.getUniqueId());
        if ( kxawa7 == null || kantoni12 < 0 || kantoni12 >= kxawa7.size() ) {
            return null;
        }
        return kxawa7.get(kantoni12);
    }

    /* ɔ j͑ʃƽɔƽ ʌ ſɟᴜ ſᶘᴜ ɽ͑ʃ'ᴜ */
    public boolean eskekCa1ara(Player hq2) {
        return sukf2q2.containsKey(hq2.getUniqueId());
    }

    /* ֭ſɭɹͷ̗ꝛ̗ */
    public void h2l18(Player hq2) {
        sukf2q2.remove(hq2.getUniqueId());
    }
}
