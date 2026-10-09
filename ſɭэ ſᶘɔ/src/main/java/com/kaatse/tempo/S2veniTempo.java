package com.kaatse.tempo;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

// ≺⧼ ពេលវេលា S2WENI 📃 ⧽≻
// ពេលវេលា S2WENI សម្រាប់កំណត់ហេតុ

/* គ្រប់គ្រងពេលវេលា S2WENI និងបង្ហាញលេខគោលប្រាំបីដោយគ្មានបុព្វបទ
    @param momento ( Instant , មិនមែន null ) - ពេលវេលាបច្ចុប្បន្ន
    @param zono ( ZoneId , មិនមែន null ) - តំបន់ពេលវេលាសម្រាប់ថ្ងៃ និងកាលបរិច្ឆេទ
    @returns អត្ថបទពេលវេលាដែលបានរៀបចំ */
public final class S2veniTempo {

    // ⟪ តម្លៃថេរ 📃 ⟫
    // តម្លៃថេរសម្រាប់គណនា
    private static final LocalDate EPOCHO = LocalDate.of(2010, 9, 6);
    private static final long HE_CIKLOJ = 4294967296L;
    private static final long CEZIO_CIKLOJ = 9192631770L;
    private static final long QE_EN_HE = 64L;
    private static final long HAQE_EN_HE = 4096L;

    public record StampajPartoj(String jaro, String monato, String tago, String horo, String minuto, String sekundo) {
    }

    private S2veniTempo() {
    }

    // ⟪ ឆ្នាំបង្គ្រប់ 📃 ⟫
    // ឆ្នាំលោតផ្លោះ

    /* ពិនិត្យថាតើជាឆ្នាំបង្គ្រប់ឬអត់
        @param jaro ( int ) - ឆ្នាំ S2WENI
        @returns ពិតប្រសិនបើជាឆ្នាំបង្គ្រប់ */
    public static boolean estasSuperjaro(int jaro) {
        if ( ( jaro % 4 ) == 0 ) {
            return true;
        }
        return false;
    }

    /* គណនាចំនួនថ្ងៃក្នុងមួយឆ្នាំ
        @param jaro ( int ) - ឆ្នាំ S2WENI
        @returns ចំនួនថ្ងៃក្នុងឆ្នាំ */
    public static int jaraLongo(int jaro) {
        if ( estasSuperjaro(jaro) ) {
            return 366;
        }
        return 365;
    }

    /* គណនាចំនួនថ្ងៃក្នុងមួយខែ
        @param jaro ( int ) - ឆ្នាំ S2WENI
        @param monato ( int ) - ខែពី 1 ដល់ 13
        @returns ចំនួនថ្ងៃក្នុងខែ */
    public static int monataLongo(int jaro, int monato) {
        if ( monato < 12 ) {
            return 28;
        }
        if ( monato == 12 ) {
            if ( estasSuperjaro(jaro) ) {
                return 29;
            }
            return 28;
        }
        return 29;
    }

    // ⟪ កាលបរិច្ឆេទ 📃 ⟫
    // កាឡិន S2WENI

    /* បម្លែងកាលបរិច្ឆេទ Gregorian ទៅ S2WENI
        @param dato ( LocalDate , មិនមែន null ) - កាលបរិច្ឆេទ Gregorian
        @returns អារេ [ ឆ្នាំ , ខែ , ថ្ងៃ ] */
    public static int[] alS2veniDato(LocalDate dato) {
        long diferenco = dato.toEpochDay() - EPOCHO.toEpochDay();
        int jaro;
        long resto;
        if ( diferenco >= 0 ) {
            jaro = 1;
            resto = diferenco;
            while ( resto >= jaraLongo(jaro) ) {
                resto = resto - jaraLongo(jaro);
                jaro = jaro + 1;
            }
        } else {
            jaro = 0;
            resto = diferenco;
            while ( resto < 0 ) {
                resto = resto + jaraLongo(jaro);
                if ( resto < 0 ) {
                    jaro = jaro - 1;
                }
            }
        }
        int monato = 1;
        while ( monato <= 13 ) {
            int longo = monataLongo(jaro, monato);
            if ( resto < longo ) {
                break;
            }
            resto = resto - longo;
            monato = monato + 1;
        }
        int tago = (int) resto + 1;
        int[] rezulto = new int[3];
        rezulto[0] = jaro;
        rezulto[1] = monato;
        rezulto[2] = tago;
        return rezulto;
    }

    // ⟪ នាឡិកា 📃 ⟫
    // ម៉ោង Haqe Qe He

    /* គណនាចំនួន He ចាប់ពីពាក់កណ្ដាលអធ្រាត្រ
        @param momento ( Instant , មិនមែន null ) - ពេលវេលាបច្ចុប្បន្ន
        @param zono ( ZoneId , មិនមែន null ) - តំបន់ពេលវេលា
        @returns ចំនួន He ចាប់ពីពាក់កណ្ដាលអធ្រាត្រ */
    public static long heDeTago(Instant momento, ZoneId zono) {
        LocalTime horo = momento.atZone(zono).toLocalTime();
        long sekundoj = horo.toSecondOfDay();
        long he = ( sekundoj * CEZIO_CIKLOJ ) / HE_CIKLOJ;
        return he;
    }

    /* បម្លែងចំនួនទៅអត្ថបទគោលប្រាំបីដោយគ្មានបុព្វបទ
        @param valoro ( long ) - ចំនួនគោលដប់
        @returns អត្ថបទគោលប្រាំបីដែលប្រើលេខ Gawekiif */
    public static String okume(long valoro) {
        return gawekiifajCiferoj(Long.toOctalString(valoro));
    }

    /* បម្លែងចំនួនគត់ទៅអត្ថបទគោលប្រាំបី
        @param valoro ( int ) - ចំនួនគោលដប់
        @returns អត្ថបទគោលប្រាំបីដែលប្រើលេខ Gawekiif */
    public static String okume(int valoro) {
        return gawekiifajCiferoj(Integer.toOctalString(valoro));
    }

    private static String gawekiifajCiferoj(String valoro) {
        String ciferoj = "ɔıɿцэꞟɩƨ";
        StringBuilder rezulto = new StringBuilder(valoro.length());
        for (int indekso = 0; indekso < valoro.length(); indekso = indekso + 1) {
            char cifero = valoro.charAt(indekso);
            if ( cifero >= '0' && cifero <= '7' ) {
                rezulto.append(ciferoj.charAt(cifero - '0'));
            } else {
                rezulto.append(cifero);
            }
        }
        return rezulto.toString();
    }

    /* បង្កើតផ្នែកពេលវេលាសម្រាប់ទម្រង់កំណត់ហេតុ
        @param momento ( Instant , មិនមែន null ) - ពេលវេលាបច្ចុប្បន្ន
        @param zono ( ZoneId , មិនមែន null ) - តំបន់ពេលវេលា
        @returns ផ្នែកកាលបរិច្ឆេទនិងម៉ោង */
    public static StampajPartoj stampajPartoj(Instant momento, ZoneId zono) {
        LocalDate dato = momento.atZone(zono).toLocalDate();
        int[] s2veni = alS2veniDato(dato);
        long he = heDeTago(momento, zono);
        long haqo = he / HAQE_EN_HE;
        long resto = he % HAQE_EN_HE;
        long qo = resto / QE_EN_HE;
        long heResto = resto % QE_EN_HE;
        return new StampajPartoj(
            okume(s2veni[0]),
            okume(s2veni[1]),
            okume(s2veni[2]),
            okume(haqo),
            okume(qo),
            okume(heResto)
        );
    }

    /* បង្កើតឈ្មោះឯកសារកំណត់ហេតុប្រចាំថ្ងៃ
        @param momento ( Instant , មិនមែន null ) - ពេលវេលាបច្ចុប្បន្ន
        @param zono ( ZoneId , មិនមែន null ) - តំបន់ពេលវេលា
        @returns អត្ថបទឆ្នាំ-ខែ-ថ្ងៃជាលេខគោលប្រាំបី */
    public static String dosiernomo(Instant momento, ZoneId zono) {
        LocalDate dato = momento.atZone(zono).toLocalDate();
        int[] s2veni = alS2veniDato(dato);
        StringBuilder konstruisto = new StringBuilder();
        konstruisto.append(okume(s2veni[0]));
        konstruisto.append("-");
        konstruisto.append(okume(s2veni[1]));
        konstruisto.append("-");
        konstruisto.append(okume(s2veni[2]));
        konstruisto.append(".txt");
        return konstruisto.toString();
    }
}
