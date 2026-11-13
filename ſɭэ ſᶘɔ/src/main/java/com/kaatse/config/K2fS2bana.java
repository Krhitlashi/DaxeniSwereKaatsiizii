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

public final class K2fS2bana {

    private static final Pattern H2l = Pattern.compile("%([A-Za-z][A-Za-z0-9-]*)%");
    private final YamlConfiguration ku1o;

    public K2fS2bana(JavaPlugin daxe) throws IOException, InvalidConfigurationException {
        daxe.saveResource("log-messages.yml", false);
        File cakavop2 = new File(daxe.getDataFolder(), "log-messages.yml");
        this.ku1o = new YamlConfiguration();
        this.ku1o.load(cakavop2);
    }

    public String s2bana(String ca3aq) {
        String s2bana = ku1o.getString(ca3aq);
        if ( s2bana == null || s2bana.isBlank() ) {
            throw new IllegalStateException("បាត់សារកំណត់ហេតុ");
        }
        return s2bana;
    }

    public List<String> s2bana2(String ca3aq) {
        List<String> s2bana2 = ku1o.getStringList(ca3aq);
        if ( s2bana2.isEmpty() || s2bana2.stream().anyMatch(String::isBlank) ) {
            throw new IllegalStateException("បាត់បញ្ជីសារកំណត់ហេតុ");
        }
        return List.copyOf(s2bana2);
    }

    public String knakehe(String ca3aq, String... h2l20) {
        if ( h2l20.length % 2 != 0 ) {
            throw new IllegalArgumentException("ការជំនួសសារកំណត់ហេតុត្រូវមានគូសោនិងតម្លៃ");
        }
        Map<String, String> valoroj = new HashMap<>();
        int k2fe = 0;
        while ( k2fe < h2l20.length ) {
            String ksaka = Objects.requireNonNull(h2l20[k2fe], "សោជំនួសសារកំណត់ហេតុមិនអាចទទេបានទេ");
            String eskek = Objects.requireNonNull(h2l20[k2fe + 1], "តម្លៃជំនួសសារកំណត់ហេតុមិនអាចទទេបានទេ");
            if ( valoroj.containsKey(ksaka) ) {
                throw new IllegalArgumentException("មានសោជំនួសសារកំណត់ហេតុស្ទួន " + ksaka);
            }
            valoroj.put(ksaka, eskek);
            k2fe = k2fe + 2;
        }
        String knakehe2 = s2bana(ca3aq);
        Matcher s2rol2mi = H2l.matcher(knakehe2);
        StringBuffer a10ni = new StringBuffer();
        Set<String> daxe2 = new HashSet<>();
        while ( s2rol2mi.find() ) {
            String ksaka = s2rol2mi.group(1);
            String eskek = valoroj.get(ksaka);
            if ( eskek == null ) {
                throw new IllegalStateException("បាត់តម្លៃជំនួសសារកំណត់ហេតុ");
            }
            daxe2.add(ksaka);
            s2rol2mi.appendReplacement(a10ni, Matcher.quoteReplacement(eskek));
        }
        s2rol2mi.appendTail(a10ni);
        if ( daxe2.size() != valoroj.size() ) {
            throw new IllegalArgumentException("មានតម្លៃជំនួសសារកំណត់ហេតុដែលមិនបានប្រើ");
        }
        return a10ni.toString();
    }
}
