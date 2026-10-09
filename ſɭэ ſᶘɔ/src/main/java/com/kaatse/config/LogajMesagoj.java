package com.kaatse.config;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class LogajMesagoj {

    private static final Pattern ANSTATAŬEJO = Pattern.compile("%([A-Za-z][A-Za-z0-9-]*)%");
    private final YamlConfiguration agordo;

    public LogajMesagoj(JavaPlugin kromprogramo) throws IOException, InvalidConfigurationException {
        kromprogramo.saveResource("log-messages.yml", false);
        File dosiero = new File(kromprogramo.getDataFolder(), "log-messages.yml");
        this.agordo = new YamlConfiguration();
        this.agordo.load(dosiero);
    }

    public String teksto(String ŝlosilo) {
        String teksto = agordo.getString(ŝlosilo);
        if ( teksto == null || teksto.isBlank() ) {
            throw new IllegalStateException("បាត់សារកំណត់ហេតុ");
        }
        return teksto;
    }

    public List<String> tekstoj(String ŝlosilo) {
        List<String> tekstoj = agordo.getStringList(ŝlosilo);
        if ( tekstoj.isEmpty() || tekstoj.stream().anyMatch(String::isBlank) ) {
            throw new IllegalStateException("បាត់បញ្ជីសារកំណត់ហេតុ");
        }
        return List.copyOf(tekstoj);
    }

    public String formati(String ŝlosilo, String... anstataŭigoj) {
        if ( anstataŭigoj.length % 2 != 0 ) {
            throw new IllegalArgumentException("ការជំនួសសារកំណត់ហេតុត្រូវមានគូសោនិងតម្លៃ");
        }
        Map<String, String> valoroj = new HashMap<>();
        int i = 0;
        while ( i < anstataŭigoj.length ) {
            String nomo = Objects.requireNonNull(anstataŭigoj[i], "សោជំនួសសារកំណត់ហេតុមិនអាចទទេបានទេ");
            String valoro = Objects.requireNonNull(anstataŭigoj[i + 1], "តម្លៃជំនួសសារកំណត់ហេតុមិនអាចទទេបានទេ");
            if ( valoroj.containsKey(nomo) ) {
                throw new IllegalArgumentException("មានសោជំនួសសារកំណត់ហេតុស្ទួន " + nomo);
            }
            valoroj.put(nomo, valoro);
            i = i + 2;
        }
        String ŝablono = teksto(ŝlosilo);
        Matcher kongruilo = ANSTATAŬEJO.matcher(ŝablono);
        StringBuffer rezulto = new StringBuffer();
        Set<String> uzitaj = new HashSet<>();
        while ( kongruilo.find() ) {
            String nomo = kongruilo.group(1);
            String valoro = valoroj.get(nomo);
            if ( valoro == null ) {
                throw new IllegalStateException("បាត់តម្លៃជំនួសសារកំណត់ហេតុ");
            }
            uzitaj.add(nomo);
            kongruilo.appendReplacement(rezulto, Matcher.quoteReplacement(valoro));
        }
        kongruilo.appendTail(rezulto);
        if ( uzitaj.size() != valoroj.size() ) {
            throw new IllegalArgumentException("មានតម្លៃជំនួសសារកំណត់ហេតុដែលមិនបានប្រើ");
        }
        return rezulto.toString();
    }
}
