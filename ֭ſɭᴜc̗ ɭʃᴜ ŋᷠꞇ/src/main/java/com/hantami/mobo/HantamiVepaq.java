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

// ≺⧼ j͑ʃ'ɔ ſןᴜȝ 📃 ⧽≻


/* j͑ʃ'ɔ ſןᴜȝ */
public final class HantamiVepaq {

    private HantamiVepaq() {
    }

    // ⟪ ʃэ ɽ͑ʃ'ᴜ ſɭɜ ᶅſɔ ʌ ſɭэ j͐ʃꞇȝ 📃 ⟫


    /* ʃэ ɽ͑ʃ'ᴜ ſɭɜ ᶅſɔ ʌ ſɭэ j͐ʃꞇȝ */
    public static class B6rakoweK6liq {
        public final int kantoni2;
        public final int kantoni22;
        public final int kantoni3;
        public final Material pukek2;
        public final boolean caka3aq3;
        public BlockFace a2banu2 = null;

        public B6rakoweK6liq(int kantoni2, int kantoni22, int kantoni3, Material pukek2, boolean caka3aq3) {
            this.kantoni2 = kantoni2;
            this.kantoni22 = kantoni22;
            this.kantoni3 = kantoni3;
            this.pukek2 = pukek2;
            this.caka3aq3 = caka3aq3;
        }

        /* ʃэ ɽ͑ʃ'ᴜ ſɭɜ ᶅſɔ ſᶘɔⅎ }ʃꞇ */
        public B6rakoweK6liq c2kani2banu2(BlockFace a2banu2) {
            this.a2banu2 = a2banu2;
            return this;
        }
    }

    /* ʃэ ɽ͑ʃ'ᴜ ſɭɜ ᶅſɔ ſᶘɔⅎ }ʃꞇ */
    public static class B6rakowe10ni {
        public final List<B6rakoweK6liq> ca1ara2;
        public final Material pukek3;

        public B6rakowe10ni(List<B6rakoweK6liq> ca1ara2, Material pukek3) {
            this.ca1ara2 = ca1ara2;
            this.pukek3 = pukek3;
        }
    }

    // ⟪ j͑ʃɹ ɽ͑ʃ'ɜ j͐ʃɹ ŋᷠꞇ ʌ ꞁȷ̀ɜƴ 📃 ⟫


    /* j͑ʃɹ ɽ͑ʃ'ɜ j͐ʃɹ ŋᷠꞇ ʌ ꞁȷ̀ɜƴ */
    public static Location s2rol2miOz(World nala2, int kantoni2, int kantoni3) {
        int l6da2 = nala2.getHighestBlockYAt(kantoni2, kantoni3);
        for ( int kantoni22 = l6da2; kantoni22 > l6da2 - 8 && kantoni22 > nala2.getMinHeight(); kantoni22-- ) {
            Block k6liq = nala2.getBlockAt(kantoni2, kantoni22, kantoni3);
            Block l6da3 = nala2.getBlockAt(kantoni2, kantoni22 + 1, kantoni3);
            Block k2feL6da = nala2.getBlockAt(kantoni2, kantoni22 + 2, kantoni3);
            if ( k6liq.getType().isSolid() && ! k6liq.isLiquid() && l6da3.getType().isAir() && k2feL6da.getType().isAir() ) {
                return new Location(nala2, kantoni2 + 0.5D, kantoni22 + 1.0D, kantoni3 + 0.5D);
            }
        }
        return null;
    }

    // ⟪ ſɭɔ ֭ſɭw ʌ ᴜ ſᶘꞇȝ ʌ }ʃᴜ j͐ʃᴜ 📃 ⟫


    /* ſɭɔ ֭ſɭw ʌ ᴜ ſᶘꞇȝ ʌ }ʃᴜ j͐ʃᴜ */
    public static Material kehuA1iqNala(World nala2, Location sost22) {
        try {
            String ksaka = nala2.getBiome(sost22.getBlockX(), sost22.getBlockY(), sost22.getBlockZ()).key().asString().toUpperCase();
            if ( ksaka.contains("BAMBOO") ) {
                return Material.BAMBOO_BLOCK;
            }
            if ( ksaka.contains("CHERRY") ) {
                return Material.CHERRY_LOG;
            }
            if ( ksaka.contains("PALE_GARDEN") ) {
                return Material.PALE_OAK_LOG;
            }
            if ( ksaka.contains("MANGROVE") ) {
                return Material.MANGROVE_LOG;
            }
            if ( ksaka.contains("BIRCH") ) {
                return Material.BIRCH_LOG;
            }
            if ( ksaka.contains("DARK") ) {
                return Material.DARK_OAK_LOG;
            }
            if ( ksaka.contains("JUNGLE") ) {
                return Material.JUNGLE_LOG;
            }
            if ( ksaka.contains("SAVANNA") ) {
                return Material.ACACIA_LOG;
            }
            if ( ksaka.contains("CRIMSON") ) {
                return Material.CRIMSON_STEM;
            }
            if ( ksaka.contains("WARPED") ) {
                return Material.WARPED_STEM;
            }
            if ( ksaka.contains("TAIGA") || ksaka.contains("GROVE") || ksaka.contains("SNOWY") || ksaka.contains("FROZEN") || ksaka.contains("STONY") || ksaka.contains("WINDSWEPT") ) {
                return Material.SPRUCE_LOG;
            }
        } catch ( Exception a3ohk2nik2p2 ) {
            return null;
        }
        return null;
    }

    /* j͑ʃɹ ɽ͑ʃ'ɜ j͐ʃɹ ŋᷠꞇ ʌ ɽ͑ʃ'w j͑ʃ'ᴜ ʌ j͑ʃɹ ſɟɔ */
    public static Material s2rol2miRuvaS2ce(World nala2, Location sost22, int ka5ik4) {
        Map<Material, Integer> kalkulo = new HashMap<>();
        int sost2Kantoni = sost22.getBlockX();
        int sost2Kantoni2 = sost22.getBlockY();
        int sost2Kantoni3 = sost22.getBlockZ();
        for ( int kantoni2 = sost2Kantoni - ka5ik4; kantoni2 <= sost2Kantoni + ka5ik4; kantoni2++ ) {
            for ( int kantoni3 = sost2Kantoni3 - ka5ik4; kantoni3 <= sost2Kantoni3 + ka5ik4; kantoni3++ ) {
                for ( int kantoni22 = sost2Kantoni2 - 6; kantoni22 <= sost2Kantoni2 + 6; kantoni22++ ) {
                    if ( kantoni22 < nala2.getMinHeight() || kantoni22 >= nala2.getMaxHeight() ) {
                        continue;
                    }
                    Material xehate2 = nala2.getBlockAt(kantoni2, kantoni22, kantoni3).getType();
                    if ( xehateSost2cesai(xehate2) ) {
                        kalkulo.put(xehate2, kalkulo.getOrDefault(xehate2, 0) + 1);
                    }
                }
            }
        }
        Material pal6Anis = Material.OAK_LOG;
        int pal6K2fe = 0;
        for ( Map.Entry<Material, Integer> paro : kalkulo.entrySet() ) {
            if ( paro.getValue() > pal6K2fe ) {
                pal6K2fe = paro.getValue();
                pal6Anis = paro.getKey();
            }
        }
        return pal6Anis;
    }

    /* j͑ʃw ſɭʞɹȝ ʌ ſɭɔ ֭ſɭw */
    public static Material sukf2qKehu(World nala2, Location sost22, int ka5ik4) {
        Material nala3 = kehuA1iqNala(nala2, sost22);
        if ( nala3 != null ) {
            return nala3;
        }
        return s2rol2miRuvaS2ce(nala2, sost22, ka5ik4);
    }

    /* ı],ɔ ֭ſɭᴜ ɭʃɔ ʌ j͑ʃɜ j͑ʃƨɹ ſɟɔ j͑ʃᴜꞇ */
    public static boolean xehateSost2cesai(Material xehate2) {
        String ksaka = xehate2.name();
        return ksaka.endsWith("_LOG") || ksaka.endsWith("_STEM") || ksaka.equals("BAMBOO_BLOCK");
    }

    /* ֭ſɭɹ j͐ʃꝛ̗э */
    public static Material h2l16(Material sost2cesai) {
        Material a10ni = Material.matchMaterial("STRIPPED_" + sost2cesai.name());
        if ( a10ni == null ) {
            return sost2cesai;
        }
        return a10ni;
    }

    /* j͑ʃɹ ſɟɔ ʌ ſɭ,ɔ }ʃꞇ ʌ ſןw ſɭɔƽ */
    public static Material s2ceZeniPukek(Material sost2cesai) {
        String ksaka = sost2cesai.name();
        String pukek3 = ksaka;
        if ( ksaka.endsWith("_LOG") ) {
            pukek3 = ksaka.substring(0, ksaka.length() - 4) + "_PLANKS";
        } else if ( ksaka.endsWith("_STEM") ) {
            pukek3 = ksaka.substring(0, ksaka.length() - 5) + "_PLANKS";
        } else if ( ksaka.equals("BAMBOO_BLOCK") ) {
            pukek3 = "BAMBOO_PLANKS";
        }
        Material a10ni = Material.matchMaterial(pukek3);
        if ( a10ni == null ) {
            return Material.OAK_PLANKS;
        }
        return a10ni;
    }

    /* ſɟᴜ j͑ʃ'ɔ ſןᴜ ɭʃэ ʌ ᴜ ſᶘꞇȝ */
    public static Material cavepat6A1iq(Material pukek3) {
        String ksaka = pukek3.name();
        Material a10ni = null;
        if ( ksaka.endsWith("_PLANKS") ) {
            a10ni = Material.matchMaterial(ksaka.substring(0, ksaka.length() - 7) + "_STAIRS");
        }
        if ( a10ni == null ) {
            return pukek3;
        }
        return a10ni;
    }

    // ⟪ ʃэ ɽ͑ʃ'ᴜ ſɭɜ ᶅſɔ ʌ ſɭᴜ ſןɹ 📃 ⟫


    /* ʃэ ɽ͑ʃ'ᴜ ſɭɜ ᶅſɔ ʌ ſɭᴜ ſןɹ */
    public static B6rakowe10ni b6rakoweKap2(World nala2, Location sost22, Random osakajo, int kehuKa5ik, Collection<Location> caka3aq22) {
        int sefini = 5 + osakajo.nextInt(5); // j͑ʃ'ɔ ɭʃɔ ŋᷠɹ ʌ ſɟᴜ ſɭᴜ ſ̀ȷᴜȝ
        int l6da4 = 5 + osakajo.nextInt(5); // j͑ʃ'ɔ ɭʃɔ ŋᷠɹ ʌ ſɟᴜ ſɭᴜ ſ̀ȷᴜȝ
        int l6da = 3 + osakajo.nextInt(3); // j͑ʃ'ɔ ɭʃɔ ŋᷠɹ ʌ ſɟᴜ ſɭᴜ ſ̀ȷᴜȝ
        int kantoniK2fe = sost22.getBlockX() - sefini / 2;
        int kantoni3K2fe = sost22.getBlockZ() - l6da4 / 2;
        int kantoniK2fe2 = kantoniK2fe + sefini - 1;
        int kantoni3K2fe2 = kantoni3K2fe + l6da4 - 1;
        Location oz = s2rol2miOz(nala2, ( kantoniK2fe + kantoniK2fe2 ) / 2, ( kantoni3K2fe + kantoni3K2fe2 ) / 2);
        if ( oz == null ) {
            return null;
        }
        int kantoni2K2fe = oz.getBlockY();
        int[] kantoni11 = new int[] {
            nala2.getHighestBlockYAt(kantoniK2fe, kantoni3K2fe),
            nala2.getHighestBlockYAt(kantoniK2fe, kantoni3K2fe2),
            nala2.getHighestBlockYAt(kantoniK2fe2, kantoni3K2fe),
            nala2.getHighestBlockYAt(kantoniK2fe2, kantoni3K2fe2)
        };
        int k2fe = kantoni11[0];
        int pal63 = kantoni11[0];
        for ( int eskek : kantoni11 ) {
            if ( eskek < k2fe ) {
                k2fe = eskek;
            }
            if ( eskek > pal63 ) {
                pal63 = eskek;
            }
        }
        if ( pal63 - k2fe > 3 ) {
            return null;
        }
        kantoni2K2fe = pal63;
        int k2fePal6 = pal63;
        for ( int kantoni2 = kantoniK2fe; kantoni2 <= kantoniK2fe2; kantoni2++ ) {
            for ( int kantoni3 = kantoni3K2fe; kantoni3 <= kantoni3K2fe2; kantoni3++ ) {
                int l6da5 = nala2.getHighestBlockYAt(kantoni2, kantoni3);
                if ( l6da5 > kantoni2K2fe ) {
                    kantoni2K2fe = l6da5;
                }
                if ( l6da5 < k2fePal6 ) {
                    k2fePal6 = l6da5;
                }
            }
        }
        if ( kantoni2K2fe - k2fePal6 > 4 ) {
            return null;
        }
        Location sost2 = new Location(nala2, ( kantoniK2fe + kantoniK2fe2 ) / 2.0D, kantoni2K2fe, ( kantoni3K2fe + kantoni3K2fe2 ) / 2.0D);
        for ( Location ksaka5 : caka3aq22 ) {
            if ( ! ksaka5.getWorld().equals(nala2) ) {
                continue;
            }
            if ( ksaka5.distanceSquared(sost2) < 100.0D ) {
                return null;
            }
        }
        Material s2ce = sukf2qKehu(nala2, oz, kehuKa5ik);
        Material pukek3 = s2ceZeniPukek(s2ce);
        Material s2ce2 = h2l16(s2ce);
        Material cavepat6 = cavepat6A1iq(pukek3);
        int k6h6Kantoni2 = osakajo.nextInt(4);
        int k6h6Kantoni4 = ( kantoniK2fe + kantoniK2fe2 ) / 2;
        int k6h6Kantoni32 = ( kantoni3K2fe + kantoni3K2fe2 ) / 2;
        for ( int kantoni2 = kantoniK2fe; kantoni2 <= kantoniK2fe2; kantoni2++ ) {
            for ( int kantoni3 = kantoni3K2fe; kantoni3 <= kantoni3K2fe2; kantoni3++ ) {
                for ( int kantoni22 = kantoni2K2fe + 1; kantoni22 <= kantoni2K2fe + l6da + 1; kantoni22++ ) {
                    Block k6liq = nala2.getBlockAt(kantoni2, kantoni22, kantoni3);
                    if ( k6liq.getType() == Material.BEDROCK ) {
                        continue;
                    }
                    k6liq.setType(Material.AIR, false);
                }
            }
        }
        List<B6rakoweK6liq> ca1ara2 = new ArrayList<>();
        for ( int kantoni2 = kantoniK2fe; kantoni2 <= kantoniK2fe2; kantoni2++ ) {
            for ( int kantoni3 = kantoni3K2fe; kantoni3 <= kantoni3K2fe2; kantoni3++ ) {
                for ( int kantoni22 = kantoni2K2fe - 1; kantoni22 >= kantoni2K2fe - 5 && kantoni22 >= nala2.getMinHeight(); kantoni22-- ) {
                    Block kantoni8 = nala2.getBlockAt(kantoni2, kantoni22, kantoni3);
                    if ( kantoni8.getType().isSolid() ) {
                        break;
                    }
                    ca1ara2.add(new B6rakoweK6liq(kantoni2, kantoni22, kantoni3, pukek3, false));
                }
            }
        }
        for ( int kantoni2 = kantoniK2fe; kantoni2 <= kantoniK2fe2; kantoni2++ ) {
            for ( int kantoni3 = kantoni3K2fe; kantoni3 <= kantoni3K2fe2; kantoni3++ ) {
                ca1ara2.add(new B6rakoweK6liq(kantoni2, kantoni2K2fe, kantoni3, pukek3, false));
            }
        }
        for ( int kantoni22 = kantoni2K2fe; kantoni22 <= kantoni2K2fe + l6da; kantoni22++ ) {
            ca1ara2.add(new B6rakoweK6liq(kantoniK2fe, kantoni22, kantoni3K2fe, s2ce2, false));
            ca1ara2.add(new B6rakoweK6liq(kantoniK2fe, kantoni22, kantoni3K2fe2, s2ce2, false));
            ca1ara2.add(new B6rakoweK6liq(kantoniK2fe2, kantoni22, kantoni3K2fe, s2ce2, false));
            ca1ara2.add(new B6rakoweK6liq(kantoniK2fe2, kantoni22, kantoni3K2fe2, s2ce2, false));
        }
        for ( int kantoni22 = kantoni2K2fe + 1; kantoni22 <= kantoni2K2fe + l6da; kantoni22++ ) {
            boolean l6da2 = kantoni22 == kantoni2K2fe + l6da;
            for ( int kantoni2 = kantoniK2fe + 1; kantoni2 <= kantoniK2fe2 - 1; kantoni2++ ) {
                a41eK6liq(ca1ara2, kantoni2, kantoni22, kantoni3K2fe, l6da2 ? cavepat6 : pukek3, l6da2, BlockFace.SOUTH, k6h6Kantoni2, 0, kantoni2, k6h6Kantoni4, kantoni2K2fe);
                a41eK6liq(ca1ara2, kantoni2, kantoni22, kantoni3K2fe2, l6da2 ? cavepat6 : pukek3, l6da2, BlockFace.NORTH, k6h6Kantoni2, 1, kantoni2, k6h6Kantoni4, kantoni2K2fe);
            }
            for ( int kantoni3 = kantoni3K2fe + 1; kantoni3 <= kantoni3K2fe2 - 1; kantoni3++ ) {
                a41eK6liq(ca1ara2, kantoniK2fe, kantoni22, kantoni3, l6da2 ? cavepat6 : pukek3, l6da2, BlockFace.WEST, k6h6Kantoni2, 2, kantoni3, k6h6Kantoni32, kantoni2K2fe);
                a41eK6liq(ca1ara2, kantoniK2fe2, kantoni22, kantoni3, l6da2 ? cavepat6 : pukek3, l6da2, BlockFace.EAST, k6h6Kantoni2, 3, kantoni3, k6h6Kantoni32, kantoni2K2fe);
            }
        }
        for ( int kantoni2 = kantoniK2fe + 1; kantoni2 <= kantoniK2fe2 - 1; kantoni2++ ) {
            for ( int kantoni3 = kantoni3K2fe + 1; kantoni3 <= kantoni3K2fe2 - 1; kantoni3++ ) {
                ca1ara2.add(new B6rakoweK6liq(kantoni2, kantoni2K2fe + l6da, kantoni3, pukek3, false));
            }
        }
        ca1ara2.add(new B6rakoweK6liq(kantoniK2fe + 1, kantoni2K2fe + 1, kantoni3K2fe + 1, Material.CHEST, true));
        if ( k6h6Kantoni2 == 0 ) {
            ca1ara2.add(new B6rakoweK6liq(k6h6Kantoni4 - 1, kantoni2K2fe + 1, kantoni3K2fe + 1, Material.TORCH, false));
            ca1ara2.add(new B6rakoweK6liq(k6h6Kantoni4 + 1, kantoni2K2fe + 1, kantoni3K2fe + 1, Material.TORCH, false));
        } else if ( k6h6Kantoni2 == 1 ) {
            ca1ara2.add(new B6rakoweK6liq(k6h6Kantoni4 - 1, kantoni2K2fe + 1, kantoni3K2fe2 - 1, Material.TORCH, false));
            ca1ara2.add(new B6rakoweK6liq(k6h6Kantoni4 + 1, kantoni2K2fe + 1, kantoni3K2fe2 - 1, Material.TORCH, false));
        } else if ( k6h6Kantoni2 == 2 ) {
            ca1ara2.add(new B6rakoweK6liq(kantoniK2fe + 1, kantoni2K2fe + 1, k6h6Kantoni32 - 1, Material.TORCH, false));
            ca1ara2.add(new B6rakoweK6liq(kantoniK2fe + 1, kantoni2K2fe + 1, k6h6Kantoni32 + 1, Material.TORCH, false));
        } else {
            ca1ara2.add(new B6rakoweK6liq(kantoniK2fe2 - 1, kantoni2K2fe + 1, k6h6Kantoni32 - 1, Material.TORCH, false));
            ca1ara2.add(new B6rakoweK6liq(kantoniK2fe2 - 1, kantoni2K2fe + 1, k6h6Kantoni32 + 1, Material.TORCH, false));
        }
        return new B6rakowe10ni(ca1ara2, pukek3);
    }

    /* j͑ʃ'ɔ ɭʃɔ ŋᷠɹ ʌ ſɟᴜ ſɭᴜ ſ̀ȷᴜȝ */
    private static void a41eK6liq(List<B6rakoweK6liq> ca1ara2, int kantoni2, int kantoni22, int kantoni3, Material pukek2, boolean l6da2, BlockFace a2banu2, int k6h6Kantoni2, int kantoni9, int kantoni10, int k6h6Kantoni5, int kantoni2K2fe) {
        if ( kantoni9 == k6h6Kantoni2 && kantoni10 == k6h6Kantoni5 && ( kantoni22 == kantoni2K2fe + 1 || kantoni22 == kantoni2K2fe + 2 ) ) {
            return;
        }
        if ( l6da2 ) {
            ca1ara2.add(new B6rakoweK6liq(kantoni2, kantoni22, kantoni3, pukek2, false).c2kani2banu2(a2banu2));
        } else {
            ca1ara2.add(new B6rakoweK6liq(kantoni2, kantoni22, kantoni3, pukek2, false));
        }
    }

    /* j͑ʃ'ɔ ɭʃɔ ŋᷠɹ ʌ ſɟᴜ ſɭᴜ ſ̀ȷᴜȝ */
    public static void vetem2Caka3aq(World nala2, int kantoni2, int kantoni22, int kantoni3, Material pukek3, Random osakajo) {
        Block k6liq = nala2.getBlockAt(kantoni2, kantoni22, kantoni3);
        if ( ! ( k6liq.getState() instanceof Chest caka3aq3 ) ) {
            return;
        }
        List<ItemStack> a41e3 = new ArrayList<>();
        a41e3.add(new ItemStack(Material.BREAD, 2 + osakajo.nextInt(4))); // j͑ʃᴜ ֭ſɭᴜ ʌ ſɭᴜ ſɭˬꞇƽ
        a41e3.add(new ItemStack(Material.TORCH, 4 + osakajo.nextInt(5))); // j͑ʃᴜ ֭ſɭᴜ ʌ ſɭᴜ ſɭˬꞇƽ
        a41e3.add(new ItemStack(Material.COAL, 2 + osakajo.nextInt(5)));
        a41e3.add(new ItemStack(Material.STICK, 4 + osakajo.nextInt(9))); // j͑ʃᴜ ֭ſɭᴜ ʌ ſɭᴜ ſɭˬꞇƽ
        a41e3.add(new ItemStack(pukek3, 8 + osakajo.nextInt(17))); // j͑ʃᴜ ֭ſɭᴜ ʌ ſɭᴜ ſɭˬꞇƽ
        a41e3.add(new ItemStack(Material.IRON_INGOT, 1 + osakajo.nextInt(3))); // j͑ʃᴜ ֭ſɭᴜ ʌ ſɭᴜ ſɭˬꞇƽ
        a41e3.add(new ItemStack(Material.APPLE, 1 + osakajo.nextInt(4)));
        a41e3.add(new ItemStack(Material.ARROW, 4 + osakajo.nextInt(13))); // j͑ʃᴜ ֭ſɭᴜ ʌ ſɭᴜ ſɭˬꞇƽ
        a41e3.add(new ItemStack(Material.COOKED_BEEF, 1 + osakajo.nextInt(4)));
        a41e3.add(new ItemStack(Material.LEATHER, 1 + osakajo.nextInt(3)));
        if ( osakajo.nextInt(8) < 3 ) {
            a41e3.add(new ItemStack(Material.EMERALD, 1));
        }
        for ( ItemStack a41e4 : a41e3 ) {
            if ( osakajo.nextInt(8) < 6 ) {
                caka3aq3.getInventory().addItem(a41e4);
            }
        }
    }

    // ⟪ j͑ʃᴜ ֭ſɭᴜ ʌ ſɭᴜ ſɭˬꞇƽ 📃 ⟫


    /* j͑ʃᴜ ֭ſɭᴜ ʌ ſɭᴜ ſɭˬꞇƽ */
    public static boolean sahaKa5ik(World nala2, Location sost22, int ka5ik4) {
        int sost2Kantoni = sost22.getBlockX();
        int sost2Kantoni2 = sost22.getBlockY();
        int sost2Kantoni3 = sost22.getBlockZ();
        for ( int kantoni2 = sost2Kantoni - ka5ik4; kantoni2 <= sost2Kantoni + ka5ik4; kantoni2++ ) {
            for ( int kantoni3 = sost2Kantoni3 - ka5ik4; kantoni3 <= sost2Kantoni3 + ka5ik4; kantoni3++ ) {
                for ( int kantoni22 = sost2Kantoni2 - 3; kantoni22 <= sost2Kantoni2 + 3; kantoni22++ ) {
                    if ( kantoni22 < nala2.getMinHeight() || kantoni22 >= nala2.getMaxHeight() ) {
                        continue;
                    }
                    if ( nala2.getBlockAt(kantoni2, kantoni22, kantoni3).getType() == Material.CAMPFIRE ) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* j͑ʃ'ɔ ſןᴜȝ ʌ j͑ʃᴜ ֭ſɭᴜ */
    public static boolean vepaqSaha(World nala2, Location sost22) {
        if ( sahaKa5ik(nala2, sost22, 16) ) {
            return false;
        }
        Location oz = s2rol2miOz(nala2, sost22.getBlockX(), sost22.getBlockZ());
        if ( oz == null ) {
            return false;
        }
        int kantoni2 = oz.getBlockX();
        int kantoni22 = oz.getBlockY();
        int kantoni3 = oz.getBlockZ();
        Material s2ce = sukf2qKehu(nala2, oz, 12);
        for ( int ra3akakKantoni = -2; ra3akakKantoni <= 2; ra3akakKantoni++ ) {
            for ( int ra3akakKantoni3 = -2; ra3akakKantoni3 <= 2; ra3akakKantoni3++ ) {
                Block k6liq = nala2.getBlockAt(kantoni2 + ra3akakKantoni, kantoni22, kantoni3 + ra3akakKantoni3);
                if ( k6liq.getType() != Material.BEDROCK && ! k6liq.getType().isSolid() ) {
                    k6liq.setType(Material.AIR, false);
                }
                Block l6da6 = nala2.getBlockAt(kantoni2 + ra3akakKantoni, kantoni22 + 1, kantoni3 + ra3akakKantoni3);
                if ( l6da6.getType() != Material.BEDROCK ) {
                    l6da6.setType(Material.AIR, false);
                }
            }
        }
        Block saha = nala2.getBlockAt(kantoni2, kantoni22, kantoni3);
        saha.setType(Material.CAMPFIRE, false);
        if ( saha.getBlockData() instanceof Lightable lumo ) {
            lumo.setLit(true);
            saha.setBlockData(lumo, false);
        }
        int[][] k6h62 = new int[][] { { 2, 0 }, { -2, 0 }, { 0, 2 }, { 0, -2 } };
        for ( int[] k6h63 : k6h62 ) {
            int a1iqKantoni = kantoni2 + k6h63[0];
            int a1iqKantoni3 = kantoni3 + k6h63[1];
            int a1iqKantoni2 = nala2.getHighestBlockYAt(a1iqKantoni, a1iqKantoni3);
            if ( Math.abs(a1iqKantoni2 - kantoni22) > 2 ) {
                continue;
            }
            Block kantoni8 = nala2.getBlockAt(a1iqKantoni, a1iqKantoni2, a1iqKantoni3);
            Block xehate5 = nala2.getBlockAt(a1iqKantoni, a1iqKantoni2 + 1, a1iqKantoni3);
            if ( kantoni8.getType().isSolid() && ! kantoni8.isLiquid() && xehate5.getType().isAir() ) {
                xehate5.setType(s2ce, false);
            }
        }
        return true;
    }
}
