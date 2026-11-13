package com.kaatse.tempo;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

// ≺⧼ ſ͔ɭᴜ }ʃꞇ 📃 ⧽≻


/* ſ͔ɭᴜ }ʃꞇ */
public final class S2veniGani {

    // ⟪ ſɭɹ ſȷꝛ̗ɔⅎ }ʃꞇ 📃 ⟫

    private static final LocalDate GANI = LocalDate.of(2010, 9, 6);
    private static final long HE_PABOK = 4294967296L;
    private static final long CS_PABOK = 9192631770L;
    private static final long QE_TARA1OF_HE = 64L;
    private static final long HAQE_TARA1OF_HE = 4096L;

    public record K2f10ni(String gani2, String gani3, String gani4, String gani5, String k2fe5, String gani6) {
    }

    private S2veniGani() {
    }

    // ⟪ ı],ɔ ֭ſɭᴜ ɭʃɔ ʌ j͐ʃэ ɭ(ᴜ 📃 ⟫


    /* ı],ɔ ֭ſɭᴜ ɭʃɔ ʌ j͐ʃэ ɭ(ᴜ */
    public static boolean xehateL6da(int gani2) {
        if ( ( gani2 % 4 ) == 0 ) {
            return true;
        }
        return false;
    }

    /* ſ͔ɭᴜ }ʃꞇ ʌ ſןᴜ j͐ʃэ */
    public static int ganiPal6(int gani2) {
        if ( xehateL6da(gani2) ) {
            return 366;
        }
        return 365;
    }

    /* ſ͔ɭᴜ }ʃꞇ ʌ ſןᴜ j͐ʃэ ɹ */
    public static int ganiPal62(int gani2, int gani3) {
        if ( gani3 < 12 ) {
            return 28;
        }
        if ( gani3 == 12 ) {
            if ( xehateL6da(gani2) ) {
                return 29;
            }
            return 28;
        }
        return 29;
    }

    // ⟪ ſɭ,ɔ }ʃꞇ ʌ ſ͔ɭᴜ }ʃꞇ 📃 ⟫


    /* ſɭ,ɔ }ʃꞇ ʌ ſ͔ɭᴜ }ʃꞇ */
    public static int[] zeniGani(LocalDate gani7) {
        long k2fe7 = gani7.toEpochDay() - GANI.toEpochDay();
        int gani2;
        long hunaq4;
        if ( k2fe7 >= 0 ) {
            gani2 = 1;
            hunaq4 = k2fe7;
            while ( hunaq4 >= ganiPal6(gani2) ) {
                hunaq4 = hunaq4 - ganiPal6(gani2);
                gani2 = gani2 + 1;
            }
        } else {
            gani2 = 0;
            hunaq4 = k2fe7;
            while ( hunaq4 < 0 ) {
                hunaq4 = hunaq4 + ganiPal6(gani2);
                if ( hunaq4 < 0 ) {
                    gani2 = gani2 - 1;
                }
            }
        }
        int gani3 = 1;
        while ( gani3 <= 13 ) {
            int pal6 = ganiPal62(gani2, gani3);
            if ( hunaq4 < pal6 ) {
                break;
            }
            hunaq4 = hunaq4 - pal6;
            gani3 = gani3 + 1;
        }
        int gani4 = (int) hunaq4 + 1;
        int[] a10ni = new int[3];
        a10ni[0] = gani2;
        a10ni[1] = gani3;
        a10ni[2] = gani4;
        return a10ni;
    }

    // ⟪ ſ͔ɭᴜ }ʃꞇ ʌ ᴜ ſᶘꞇȝ ʌ ſ͔ɭᴜ }ʃꞇ 📃 ⟫


    /* ſ͔ɭᴜ }ʃꞇ ʌ ᴜ ſᶘꞇȝ ʌ ſ͔ɭᴜ }ʃꞇ */
    public static long ganiA1iqGani(Instant gani, ZoneId araq) {
        LocalTime gani5 = gani.atZone(araq).toLocalTime();
        long gani8 = gani5.toSecondOfDay();
        long gani9 = ( gani8 * CS_PABOK ) / HE_PABOK;
        return gani9;
    }

    /* ſɭɹ ſȷɔ э */
    public static String k2fe6(long eskek) {
        return knakeheK2fe(Long.toOctalString(eskek));
    }

    /* ſɭɹ ſȷɔ э */
    public static String k2fe6(int eskek) {
        return knakeheK2fe(Integer.toOctalString(eskek));
    }

    private static String knakeheK2fe(String eskek) {
        String k2fe8 = "ɔıɿцэꞟɩƨ";
        StringBuilder a10ni = new StringBuilder(eskek.length());
        for (int keka = 0; keka < eskek.length(); keka = keka + 1) {
            char k2fe9 = eskek.charAt(keka);
            if ( k2fe9 >= '0' && k2fe9 <= '7' ) {
                a10ni.append(k2fe8.charAt(k2fe9 - '0'));
            } else {
                a10ni.append(k2fe9);
            }
        }
        return a10ni.toString();
    }

    /* ſɭɹ ſȷꝛ̗ɔⅎ }ʃꞇ */
    public static K2f10ni k2f10ni(Instant gani, ZoneId araq) {
        LocalDate gani7 = gani.atZone(araq).toLocalDate();
        int[] gani10 = zeniGani(gani7);
        long gani9 = ganiA1iqGani(gani, araq);
        long hq22 = gani9 / HAQE_TARA1OF_HE;
        long hunaq4 = gani9 % HAQE_TARA1OF_HE;
        long k2fe10 = hunaq4 / QE_TARA1OF_HE;
        long ganiHunaq = hunaq4 % QE_TARA1OF_HE;
        return new K2f10ni(
            k2fe6(gani10[0]),
            k2fe6(gani10[1]),
            k2fe6(gani10[2]),
            k2fe6(hq22),
            k2fe6(k2fe10),
            k2fe6(ganiHunaq)
        );
    }

    /* ſɟᴜ ſɭᴜ j͑ʃ'ɜ ſןɹ ɹ */
    public static String cakavop22(Instant gani, ZoneId araq) {
        LocalDate gani7 = gani.atZone(araq).toLocalDate();
        int[] gani10 = zeniGani(gani7);
        StringBuilder vepaq = new StringBuilder();
        vepaq.append(k2fe6(gani10[0]));
        vepaq.append("-");
        vepaq.append(k2fe6(gani10[1]));
        vepaq.append("-");
        vepaq.append(k2fe6(gani10[2]));
        vepaq.append(".txt");
        return vepaq.toString();
    }
}
