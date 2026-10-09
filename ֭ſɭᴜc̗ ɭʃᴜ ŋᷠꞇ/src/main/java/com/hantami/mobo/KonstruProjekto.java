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

// ≺⧼ គម្រោងសង់ 📃 ⧽≻
// ដាក់ប្លុកម្តងមួយៗយឺតៗ

/* គម្រោងសង់ដែលតុក្កតាអនុវត្តបន្តិចម្តងៗ
    @param mondo ( World , មិនមែន null ) - ពិភពលោកគោលដៅ
    @param konstruanto ( UUID , មិនមែន null ) - Hantami អ្នកសាងសង់
    @param ejo ( Location , មិនមែន null ) - កណ្តាលកន្លែងសង់
    @param plano ( List , មិនមែន null ) - ជួរប្លុកផែនការ
    @param tabulo ( Material , មិនមែន null ) - ក្តារសម្រាប់បំពេញហិប
    @returns គម្រោងថ្មី */
public class KonstruProjekto {

    // ⟪ Datumoj 📃 ⟫
    // ជួរនិងអ្នកសាងសង់
    private final World mondo;
    private final UUID konstruanto;
    private final Location ejo;
    private final Deque<HantamiKonstruanto.PlanoBloko> vico;
    private final Material tabulo;
    private final Random hazardo = new Random();

    public KonstruProjekto(World mondo, UUID konstruanto, Location ejo, List<HantamiKonstruanto.PlanoBloko> plano, Material tabulo) {
        this.mondo = mondo;
        this.konstruanto = konstruanto;
        this.ejo = ejo;
        this.vico = new ArrayDeque<>(plano);
        this.tabulo = tabulo;
    }

    /* ទទួលអ្នកសាងសង់
        @returns អត្តសញ្ញាណអ្នកសាងសង់ */
    public UUID konstruanto() {
        return konstruanto;
    }

    /* ទទួលកន្លែងសង់
        @returns ទីតាំងកណ្តាល */
    public Location ejo() {
        return ejo;
    }

    /* ប្រាប់ថាតើអ្នកសាងសង់រស់និងនៅជិតឬអត់
        @returns True នៅពេលការងារអាចបន្ត */
    public boolean konstruantoĈeestas() {
        Entity ento = Bukkit.getEntity(konstruanto);
        if ( ! ( ento instanceof Mannequin hantamo ) || hantamo.isDead() || ! hantamo.isValid() ) {
            return false;
        }
        if ( ! hantamo.getWorld().equals(mondo) ) {
            return false;
        }
        return hantamo.getLocation().distanceSquared(ejo) < 1024.0D; // 0o2000
    }

    /* ដាក់ប្លុកមួយនិងរាយការណ៍ស្ថានភាព
        @returns 0 បន្ត 1 រួចរាល់ 2 លុបចោល */
    public int paŝo() {
        Entity ento = Bukkit.getEntity(konstruanto);
        if ( ! ( ento instanceof Mannequin hantamo ) || hantamo.isDead() || ! hantamo.isValid() || ! hantamo.getWorld().equals(mondo) ) {
            return 2;
        }
        if ( ! konstruantoĈeestas() ) {
            return 0;
        }
        HantamiKonstruanto.PlanoBloko sekva = vico.pollFirst();
        if ( sekva == null ) {
            return 1;
        }
        if ( sekva.y < mondo.getMinHeight() || sekva.y >= mondo.getMaxHeight() ) {
            return vico.isEmpty() ? 1 : 0;
        }
        org.bukkit.block.Block bloko = mondo.getBlockAt(sekva.x, sekva.y, sekva.z);
        if ( bloko.getType() != sekva.material ) {
            if ( bloko.getType() == Material.BEDROCK ) {
                return vico.isEmpty() ? 1 : 0;
            }
            bloko.setType(sekva.material, false);
            if ( sekva.vizaĝo != null && bloko.getBlockData() instanceof Stairs ŝtuparo ) {
                ŝtuparo.setFacing(sekva.vizaĝo);
                bloko.setBlockData(ŝtuparo, false);
            }
            if ( sekva.kesto ) {
                HantamiKonstruanto.plenigiKeston(mondo, sekva.x, sekva.y, sekva.z, tabulo, hazardo);
            }
        }
        hantamo.swingMainHand();
        return vico.isEmpty() ? 1 : 0;
    }
}
