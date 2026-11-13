package com.hantami.mobo;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.data.type.Stairs;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Mannequin;

// ≺⧼ j͑ʃ'ɔ ſןᴜȝ ʌ ſɭɔ ſɭᴜ 📃 ⧽≻


/* j͑ʃ'ɔ ſןᴜȝ ʌ ſɭɔ ſɭᴜ */
public class VepaqKeka {

    // ⟪ j͑ʃ'ɔ ſןᴜȝŋ 📃 ⟫

    private final World nala2;
    private final UUID vepaq3;
    private final Location araq4;
    private final Deque<HantamiVepaq.B6rakoweK6liq> ca1ara2;
    private final Material pukek3;
    private final Random osakajo = new Random();

    public VepaqKeka(World nala2, UUID vepaq3, Location araq4, List<HantamiVepaq.B6rakoweK6liq> b6rakowe, Material pukek3) {
        this.nala2 = nala2;
        this.vepaq3 = vepaq3;
        this.araq4 = araq4;
        this.ca1ara2 = new ArrayDeque<>(b6rakowe);
        this.pukek3 = pukek3;
    }

    /* j͑ʃ'ɔ ſןᴜȝŋ */
    public UUID vepaq3() {
        return vepaq3;
    }

    /* ᴜ ɽ͑ʃ'ᴜ ſ͕ɭэⅎ */
    public Location araq4() {
        return araq4;
    }

    /* j͑ʃ'ɔ ſןᴜȝ ʌ j͑ʃɘɹ ɹ */
    public boolean vepaqSp22() {
        Entity fumu = Bukkit.getEntity(vepaq3);
        if ( ! ( fumu instanceof Mannequin daxe3 ) || daxe3.isDead() || ! daxe3.isValid() ) {
            return false;
        }
        if ( ! daxe3.getWorld().equals(nala2) ) {
            return false;
        }
        return daxe3.getLocation().distanceSquared(araq4) < 1024.0D;
    }

    /* ſɭᴜ ɭʃᴜŋ */
    public int kata3() {
        Entity fumu = Bukkit.getEntity(vepaq3);
        if ( ! ( fumu instanceof Mannequin daxe3 ) || daxe3.isDead() || ! daxe3.isValid() || ! daxe3.getWorld().equals(nala2) ) {
            return 2;
        }
        if ( ! vepaqSp22() ) {
            return 0;
        }
        HantamiVepaq.B6rakoweK6liq hunaq9 = ca1ara2.pollFirst();
        if ( hunaq9 == null ) {
            return 1;
        }
        if ( hunaq9.kantoni22 < nala2.getMinHeight() || hunaq9.kantoni22 >= nala2.getMaxHeight() ) {
            return ca1ara2.isEmpty() ? 1 : 0;
        }
        org.bukkit.block.Block k6liq = nala2.getBlockAt(hunaq9.kantoni2, hunaq9.kantoni22, hunaq9.kantoni3);
        if ( k6liq.getType() != hunaq9.pukek2 ) {
            if ( k6liq.getType() == Material.BEDROCK ) {
                return ca1ara2.isEmpty() ? 1 : 0;
            }
            k6liq.setType(hunaq9.pukek2, false);
            if ( hunaq9.a2banu2 != null && k6liq.getBlockData() instanceof Stairs cavepat6 ) {
                cavepat6.setFacing(hunaq9.a2banu2);
                k6liq.setBlockData(cavepat6, false);
            }
            if ( hunaq9.caka3aq3 ) {
                HantamiVepaq.vetem2Caka3aq(nala2, hunaq9.kantoni2, hunaq9.kantoni22, hunaq9.kantoni3, pukek3, osakajo);
            }
        }
        daxe3.swingMainHand();
        return ca1ara2.isEmpty() ? 1 : 0;
    }
}
