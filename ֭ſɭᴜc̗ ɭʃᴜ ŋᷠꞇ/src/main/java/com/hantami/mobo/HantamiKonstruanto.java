package com.hantami.mobo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Chest;
import org.bukkit.block.data.Lightable;
import org.bukkit.block.data.type.Stairs;
import org.bukkit.inventory.ItemStack;

// ≺⧼ អ្នកសាងសង់ 📃 ⧽≻
// សង់ផ្ទះឈើនិងភ្លើងជំរំ

/* រៀបចំផែនការផ្ទះសាមញ្ញពីឈើក្នុងតំបន់ និងសង់ភ្លើងភូមិ
    @returns គ្មានសម្រាប់ប្រើផ្ទាល់ */
public final class HantamiKonstruanto {

    private HantamiKonstruanto() {
    }

    // ⟪ Plano 📃 ⟫
    // ប្លុកត្រូវដាក់ម្តងមួយៗ

    /* Unu planita bloko en konstrua vico
        @returns Nova planbloko */
    public static class PlanoBloko {
        public final int x;
        public final int y;
        public final int z;
        public final Material material;
        public final boolean kesto;
        public BlockFace vizaĝo = null;

        public PlanoBloko(int x, int y, int z, Material material, boolean kesto) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.material = material;
            this.kesto = kesto;
        }

        /* Aldonas ŝtuparan direkton al planbloko
            @param vizaĝo ( BlockFace , មិនមែន null ) - Direkto ekstera
            @returns Sama planbloko */
        public PlanoBloko kunVizaĝo(BlockFace vizaĝo) {
            this.vizaĝo = vizaĝo;
            return this;
        }
    }

    /* Rezulto de planado kun vico kaj tabulo por hiboplenigo
        @returns Nova planrezulto */
    public static class PlanoRezulto {
        public final List<PlanoBloko> vico;
        public final Material tabulo;

        public PlanoRezulto(List<PlanoBloko> vico, Material tabulo) {
            this.vico = vico;
            this.tabulo = tabulo;
        }
    }

    // ⟪ Tero 📃 ⟫
    // រកដីរឹងមាំ

    /* រកចំណុចដីសុវត្ថិភាពនៅជួរឈរ
        @param mondo ( World , មិនមែន null ) - ពិភពលោកគោលដៅ
        @param x ( int ) - ប្លុក X
        @param z ( int ) - ប្លុក Z
        @returns ទីតាំងដី ឬ null */
    public static Location troviTeron(World mondo, int x, int z) {
        int supro = mondo.getHighestBlockYAt(x, z);
        for ( int y = supro; y > supro - 8 && y > mondo.getMinHeight(); y-- ) { // 0o10
            Block bloko = mondo.getBlockAt(x, y, z);
            Block supre = mondo.getBlockAt(x, y + 1, z);
            Block duSupre = mondo.getBlockAt(x, y + 2, z);
            if ( bloko.getType().isSolid() && ! bloko.isLiquid() && supre.getType().isAir() && duSupre.getType().isAir() ) {
                return new Location(mondo, x + 0.5D, y + 1.0D, z + 0.5D);
            }
        }
        return null;
    }

    // ⟪ Ligno 📃 ⟫
    // ជ្រើសរើសឈើក្នុងតំបន់

    /* ជ្រើសរើសគល់ឈើតាមជីវមណ្ឌលជុំវិញចំណុច
        @param mondo ( World , មិនមែន null ) - ពិភពលោកគោលដៅ
        @param centro ( Location , មិនមែន null ) - ចំណុចកណ្តាល
        @returns គល់ឈើ ឬ null */
    public static Material lignoDeBiomo(World mondo, Location centro) {
        try {
            String nomo = mondo.getBiome(centro.getBlockX(), centro.getBlockY(), centro.getBlockZ()).key().asString().toUpperCase();
            if ( nomo.contains("BAMBOO") ) {
                return Material.BAMBOO_BLOCK;
            }
            if ( nomo.contains("CHERRY") ) {
                return Material.CHERRY_LOG;
            }
            if ( nomo.contains("PALE_GARDEN") ) {
                return Material.PALE_OAK_LOG;
            }
            if ( nomo.contains("MANGROVE") ) {
                return Material.MANGROVE_LOG;
            }
            if ( nomo.contains("BIRCH") ) {
                return Material.BIRCH_LOG;
            }
            if ( nomo.contains("DARK") ) {
                return Material.DARK_OAK_LOG;
            }
            if ( nomo.contains("JUNGLE") ) {
                return Material.JUNGLE_LOG;
            }
            if ( nomo.contains("SAVANNA") ) {
                return Material.ACACIA_LOG;
            }
            if ( nomo.contains("CRIMSON") ) {
                return Material.CRIMSON_STEM;
            }
            if ( nomo.contains("WARPED") ) {
                return Material.WARPED_STEM;
            }
            if ( nomo.contains("TAIGA") || nomo.contains("GROVE") || nomo.contains("SNOWY") || nomo.contains("FROZEN") || nomo.contains("STONY") || nomo.contains("WINDSWEPT") ) {
                return Material.SPRUCE_LOG;
            }
        } catch ( Exception eraro ) {
            return null;
        }
        return null;
    }

    /* ស្វែងរកគល់ឈើដែលជួบบ่อยជាងគេជុំវិញចំណុច
        @param mondo ( World , មិនមែន null ) - ពិភពលោកគោលដៅ
        @param centro ( Location , មិនមែន null ) - ចំណុចកណ្តាល
        @param radiuso ( int ) - កាំស្វែងរក
        @returns គល់ឈើដែលរកឃើញ ឬគល់ស oak */
    public static Material troviLignanTrabon(World mondo, Location centro, int radiuso) {
        Map<Material, Integer> kalkulo = new HashMap<>();
        int cx = centro.getBlockX();
        int cy = centro.getBlockY();
        int cz = centro.getBlockZ();
        for ( int x = cx - radiuso; x <= cx + radiuso; x++ ) {
            for ( int z = cz - radiuso; z <= cz + radiuso; z++ ) {
                for ( int y = cy - 6; y <= cy + 6; y++ ) { // 0o6
                    if ( y < mondo.getMinHeight() || y >= mondo.getMaxHeight() ) {
                        continue;
                    }
                    Material tipo = mondo.getBlockAt(x, y, z).getType();
                    if ( estasTrunko(tipo) ) {
                        kalkulo.put(tipo, kalkulo.getOrDefault(tipo, 0) + 1);
                    }
                }
            }
        }
        Material plejBona = Material.OAK_LOG;
        int plejMulto = 0;
        for ( Map.Entry<Material, Integer> paro : kalkulo.entrySet() ) {
            if ( paro.getValue() > plejMulto ) {
                plejMulto = paro.getValue();
                plejBona = paro.getKey();
            }
        }
        return plejBona;
    }

    /* ជ្រើសរើសឈើក្នុងតំបន់ពីជីវមណ្ឌលមុនហើយពីដើមជិតៗ
        @param mondo ( World , មិនមែន null ) - ពិភពលោកគោលដៅ
        @param centro ( Location , មិនមែន null ) - ចំណុចកណ្តាល
        @param radiuso ( int ) - កាំស្វែងរក
        @returns គល់ឈើដែលជ្រើសរើស */
    public static Material elektiLignon(World mondo, Location centro, int radiuso) {
        Material biomo = lignoDeBiomo(mondo, centro);
        if ( biomo != null ) {
            return biomo;
        }
        return troviLignanTrabon(mondo, centro, radiuso);
    }

    /* ប្រាប់ថាតើវត្ថុជាគល់ឈើឬដើមឬអត់
        @param tipo ( Material , មិនមែន null ) - ប្រភេទត្រូវពិនិត្យ
        @returns True នៅពេលជាគល់ឈើ */
    public static boolean estasTrunko(Material tipo) {
        String nomo = tipo.name();
        return nomo.endsWith("_LOG") || nomo.endsWith("_STEM") || nomo.equals("BAMBOO_BLOCK");
    }

    /* ស្រិតសំបកគល់ឈើសម្រាប់សសរត្រង់
        @param trunko ( Material , មិនមែន null ) - ប្រភេទគល់ឈើ
        @returns ប្រភេទស្រិតសំបករួច ឬដើម */
    public static Material senŝeligi(Material trunko) {
        Material rezulto = Material.matchMaterial("STRIPPED_" + trunko.name());
        if ( rezulto == null ) {
            return trunko;
        }
        return rezulto;
    }

    /* ផ្គូផ្គងគល់ឈើទៅនឹងក្តារឈើដើមដូចគ្នា
        @param trunko ( Material , មិនមែន null ) - ប្រភេទគល់ឈើ
        @returns ប្រភេទក្តារ */
    public static Material traboAlTabulo(Material trunko) {
        String nomo = trunko.name();
        String tabulo = nomo;
        if ( nomo.endsWith("_LOG") ) {
            tabulo = nomo.substring(0, nomo.length() - 4) + "_PLANKS";
        } else if ( nomo.endsWith("_STEM") ) {
            tabulo = nomo.substring(0, nomo.length() - 5) + "_PLANKS";
        } else if ( nomo.equals("BAMBOO_BLOCK") ) {
            tabulo = "BAMBOO_PLANKS";
        }
        Material rezulto = Material.matchMaterial(tabulo);
        if ( rezulto == null ) {
            return Material.OAK_PLANKS;
        }
        return rezulto;
    }

    /* Mapas tabulon al ŝtuparo de sama arbo
        @param tabulo ( Material , មិនមែន null ) - Tabula tipo
        @returns Ŝtupara tipo */
    public static Material ŝtuparoDe(Material tabulo) {
        String nomo = tabulo.name();
        Material rezulto = null;
        if ( nomo.endsWith("_PLANKS") ) {
            rezulto = Material.matchMaterial(nomo.substring(0, nomo.length() - 7) + "_STAIRS");
        }
        if ( rezulto == null ) {
            return tabulo;
        }
        return rezulto;
    }

    // ⟪ Domo 📃 ⟫
    // សង់ផ្ទះសាមញ្ញមួយ

    /* រៀបផែនការផ្ទះសាមញ្ញមានសសរ ជញ្ជាំង ដំបូល និងហិបសម្រាប់សង់បន្តិចម្តងៗ
        @param mondo ( World , មិនមែន null ) - ពិភពលោកគោលដៅ
        @param centro ( Location , មិនមែន null ) - កណ្តាលប្រហាក់ប្រហែល
        @param hazardo ( Random , មិនមែន null ) - ប្រភពចៃដន្យ
        @param lignoRadiuso ( int ) - កាំស្វែងរកឈើក្នុងតំបន់
        @param domoj ( Collection , មិនមែន null ) - ផ្ទះដែលស្គាល់សម្រាប់គម្លាត
        @returns ផែនការ ឬ null */
    public static PlanoRezulto planiDomon(World mondo, Location centro, Random hazardo, int lignoRadiuso, Collection<Location> domoj) {
        int larĝo = 5 + hazardo.nextInt(5); // 0o5 ĝis 0o11
        int profundo = 5 + hazardo.nextInt(5); // 0o5 ĝis 0o11
        int alto = 3 + hazardo.nextInt(3); // 0o3 ĝis 0o5
        int x0 = centro.getBlockX() - larĝo / 2;
        int z0 = centro.getBlockZ() - profundo / 2;
        int x1 = x0 + larĝo - 1;
        int z1 = z0 + profundo - 1;
        Location tereno = troviTeron(mondo, ( x0 + x1 ) / 2, ( z0 + z1 ) / 2);
        if ( tereno == null ) {
            return null;
        }
        int y0 = tereno.getBlockY();
        int[] anguloj = new int[] {
            mondo.getHighestBlockYAt(x0, z0),
            mondo.getHighestBlockYAt(x0, z1),
            mondo.getHighestBlockYAt(x1, z0),
            mondo.getHighestBlockYAt(x1, z1)
        };
        int min = anguloj[0];
        int maks = anguloj[0];
        for ( int valoro : anguloj ) {
            if ( valoro < min ) {
                min = valoro;
            }
            if ( valoro > maks ) {
                maks = valoro;
            }
        }
        if ( maks - min > 3 ) { // 0o3
            return null;
        }
        Location mezo = new Location(mondo, ( x0 + x1 ) / 2.0D, y0, ( z0 + z1 ) / 2.0D);
        for ( Location konata : domoj ) {
            if ( ! konata.getWorld().equals(mondo) ) {
                continue;
            }
            if ( konata.distanceSquared(mezo) < 100.0D ) { // 0o144
                return null;
            }
        }
        Material trabo = elektiLignon(mondo, tereno, lignoRadiuso);
        Material tabulo = traboAlTabulo(trabo);
        Material fosto = senŝeligi(trabo);
        Material ŝtuparo = ŝtuparoDe(tabulo);
        int pordoFlanko = hazardo.nextInt(4); // 0o4
        int pordoX = ( x0 + x1 ) / 2;
        int pordoZ = ( z0 + z1 ) / 2;
        for ( int x = x0; x <= x1; x++ ) {
            for ( int z = z0; z <= z1; z++ ) {
                for ( int y = y0; y <= y0 + alto + 1; y++ ) {
                    Block bloko = mondo.getBlockAt(x, y, z);
                    if ( bloko.getType() == Material.BEDROCK ) {
                        continue;
                    }
                    bloko.setType(Material.AIR, false);
                }
            }
        }
        List<PlanoBloko> vico = new ArrayList<>();
        for ( int x = x0; x <= x1; x++ ) {
            for ( int z = z0; z <= z1; z++ ) {
                vico.add(new PlanoBloko(x, y0, z, tabulo, false));
            }
        }
        for ( int y = y0; y <= y0 + alto; y++ ) {
            vico.add(new PlanoBloko(x0, y, z0, fosto, false));
            vico.add(new PlanoBloko(x0, y, z1, fosto, false));
            vico.add(new PlanoBloko(x1, y, z0, fosto, false));
            vico.add(new PlanoBloko(x1, y, z1, fosto, false));
        }
        for ( int y = y0 + 1; y <= y0 + alto; y++ ) {
            boolean supro = y == y0 + alto;
            for ( int x = x0 + 1; x <= x1 - 1; x++ ) {
                aldoniMurBlokon(vico, x, y, z0, supro ? ŝtuparo : tabulo, supro, BlockFace.NORTH, pordoFlanko, 0, x, pordoX, y0);
                aldoniMurBlokon(vico, x, y, z1, supro ? ŝtuparo : tabulo, supro, BlockFace.SOUTH, pordoFlanko, 1, x, pordoX, y0);
            }
            for ( int z = z0 + 1; z <= z1 - 1; z++ ) {
                aldoniMurBlokon(vico, x0, y, z, supro ? ŝtuparo : tabulo, supro, BlockFace.EAST, pordoFlanko, 2, z, pordoZ, y0);
                aldoniMurBlokon(vico, x1, y, z, supro ? ŝtuparo : tabulo, supro, BlockFace.WEST, pordoFlanko, 3, z, pordoZ, y0);
            }
        }
        for ( int x = x0 + 1; x <= x1 - 1; x++ ) {
            for ( int z = z0 + 1; z <= z1 - 1; z++ ) {
                vico.add(new PlanoBloko(x, y0 + alto, z, tabulo, false));
            }
        }
        vico.add(new PlanoBloko(x0 + 1, y0 + 1, z0 + 1, Material.CHEST, true));
        if ( pordoFlanko == 0 ) {
            vico.add(new PlanoBloko(pordoX - 1, y0 + 1, z0 + 1, Material.TORCH, false));
            vico.add(new PlanoBloko(pordoX + 1, y0 + 1, z0 + 1, Material.TORCH, false));
        } else if ( pordoFlanko == 1 ) {
            vico.add(new PlanoBloko(pordoX - 1, y0 + 1, z1 - 1, Material.TORCH, false));
            vico.add(new PlanoBloko(pordoX + 1, y0 + 1, z1 - 1, Material.TORCH, false));
        } else if ( pordoFlanko == 2 ) {
            vico.add(new PlanoBloko(x0 + 1, y0 + 1, pordoZ - 1, Material.TORCH, false));
            vico.add(new PlanoBloko(x0 + 1, y0 + 1, pordoZ + 1, Material.TORCH, false));
        } else {
            vico.add(new PlanoBloko(x1 - 1, y0 + 1, pordoZ - 1, Material.TORCH, false));
            vico.add(new PlanoBloko(x1 - 1, y0 + 1, pordoZ + 1, Material.TORCH, false));
        }
        return new PlanoRezulto(vico, tabulo);
    }

    /* បន្ថែមប្លុកជញ្ជាំងមួយមានប្រហោងទ្វារទៅក្នុងជួរ
        @returns គ្មាន */
    private static void aldoniMurBlokon(List<PlanoBloko> vico, int x, int y, int z, Material material, boolean supro, BlockFace vizaĝo, int pordoFlanko, int flanko, int akso, int pordoAkso, int y0) {
        if ( flanko == pordoFlanko && akso == pordoAkso && ( y == y0 + 1 || y == y0 + 2 ) ) {
            return;
        }
        if ( supro ) {
            vico.add(new PlanoBloko(x, y, z, material, false).kunVizaĝo(vizaĝo));
        } else {
            vico.add(new PlanoBloko(x, y, z, material, false));
        }
    }

    /* បំពេញហិបដោយរបស់របរចម្រុះ
        @returns គ្មាន */
    public static void plenigiKeston(World mondo, int x, int y, int z, Material tabulo, Random hazardo) {
        Block bloko = mondo.getBlockAt(x, y, z);
        if ( ! ( bloko.getState() instanceof Chest kesto ) ) {
            return;
        }
        List<ItemStack> donacoj = new ArrayList<>();
        donacoj.add(new ItemStack(Material.BREAD, 2 + hazardo.nextInt(4))); // 0o2 ĝis 0o5
        donacoj.add(new ItemStack(Material.TORCH, 4 + hazardo.nextInt(5))); // 0o4 ĝis 0o10
        donacoj.add(new ItemStack(Material.COAL, 2 + hazardo.nextInt(5)));
        donacoj.add(new ItemStack(Material.STICK, 4 + hazardo.nextInt(9))); // 0o4 ĝis 0o14
        donacoj.add(new ItemStack(tabulo, 8 + hazardo.nextInt(17))); // 0o10 ĝis 0o30
        donacoj.add(new ItemStack(Material.IRON_INGOT, 1 + hazardo.nextInt(3))); // 0o1 ĝis 0o3
        donacoj.add(new ItemStack(Material.APPLE, 1 + hazardo.nextInt(4)));
        donacoj.add(new ItemStack(Material.ARROW, 4 + hazardo.nextInt(13))); // 0o4 ĝis 0o20
        donacoj.add(new ItemStack(Material.COOKED_BEEF, 1 + hazardo.nextInt(4)));
        donacoj.add(new ItemStack(Material.LEATHER, 1 + hazardo.nextInt(3)));
        if ( hazardo.nextInt(8) < 3 ) { // 0o10
            donacoj.add(new ItemStack(Material.EMERALD, 1));
        }
        for ( ItemStack donaco : donacoj ) {
            if ( hazardo.nextInt(8) < 6 ) { // 0o10
                kesto.getInventory().addItem(donaco);
            }
        }
    }

    // ⟪ Fajro 📃 ⟫
    // អុជភ្លើងភូមិ

    /* ប្រាប់ថាតើភ្លើងជំរំនៅជិតរួចឬអត់
        @param mondo ( World , មិនមែន null ) - ពិភពលោកគោលដៅ
        @param centro ( Location , មិនមែន null ) - ចំណុចកណ្តាល
        @param radiuso ( int ) - កាំស្វែងរក
        @returns True នៅពេលភ្លើងនៅជិត */
    public static boolean fajroProksimas(World mondo, Location centro, int radiuso) {
        int cx = centro.getBlockX();
        int cy = centro.getBlockY();
        int cz = centro.getBlockZ();
        for ( int x = cx - radiuso; x <= cx + radiuso; x++ ) {
            for ( int z = cz - radiuso; z <= cz + radiuso; z++ ) {
                for ( int y = cy - 3; y <= cy + 3; y++ ) { // 0o3
                    if ( y < mondo.getMinHeight() || y >= mondo.getMaxHeight() ) {
                        continue;
                    }
                    if ( mondo.getBlockAt(x, y, z).getType() == Material.CAMPFIRE ) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* សង់ភ្លើងជំរំមានរង្វង់គល់ឈើនៅកណ្តាលភូមិ
        @param mondo ( World , មិនមែន null ) - ពិភពលោកគោលដៅ
        @param centro ( Location , មិនមែន null ) - កណ្តាលភូមិ
        @returns True នៅពេលភ្លើងសង់រួច */
    public static boolean konstruiFajron(World mondo, Location centro) {
        if ( fajroProksimas(mondo, centro, 16) ) { // 0o20
            return false;
        }
        Location tereno = troviTeron(mondo, centro.getBlockX(), centro.getBlockZ());
        if ( tereno == null ) {
            return false;
        }
        int x = tereno.getBlockX();
        int y = tereno.getBlockY();
        int z = tereno.getBlockZ();
        Material trabo = elektiLignon(mondo, tereno, 12); // 0o14
        for ( int dx = -2; dx <= 2; dx++ ) {
            for ( int dz = -2; dz <= 2; dz++ ) {
                Block bloko = mondo.getBlockAt(x + dx, y, z + dz);
                if ( bloko.getType() != Material.BEDROCK && ! bloko.getType().isSolid() ) {
                    bloko.setType(Material.AIR, false);
                }
                Block supra = mondo.getBlockAt(x + dx, y + 1, z + dz);
                if ( supra.getType() != Material.BEDROCK ) {
                    supra.setType(Material.AIR, false);
                }
            }
        }
        Block fajro = mondo.getBlockAt(x, y, z);
        fajro.setType(Material.CAMPFIRE, false);
        if ( fajro.getBlockData() instanceof Lightable lumo ) {
            lumo.setLit(true);
            fajro.setBlockData(lumo, false);
        }
        int[][] seĝoj = new int[][] { { 2, 0 }, { -2, 0 }, { 0, 2 }, { 0, -2 } };
        for ( int[] seĝo : seĝoj ) {
            int sx = x + seĝo[0];
            int sz = z + seĝo[1];
            int sy = mondo.getHighestBlockYAt(sx, sz);
            if ( Math.abs(sy - y) > 2 ) { // 0o2
                continue;
            }
            Block sube = mondo.getBlockAt(sx, sy, sz);
            Block sure = mondo.getBlockAt(sx, sy + 1, sz);
            if ( sube.getType().isSolid() && ! sube.isLiquid() && sure.getType().isAir() ) {
                sure.setType(trabo, false);
            }
        }
        return true;
    }
}
