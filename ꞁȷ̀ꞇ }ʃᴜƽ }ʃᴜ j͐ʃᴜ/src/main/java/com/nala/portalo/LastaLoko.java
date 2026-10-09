package com.nala.portalo;

import com.nala.NalaPlugin;
import com.nala.config.Mesagoj;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

// ≺⧼ ទីតាំងចុងក្រោយ 📃 ⧽≻
// ចងចាំទីតាំងចុងក្រោយក្នុងពិភពនីមួយៗ

/* ចងចាំទីតាំងចុងក្រោយរបស់អ្នកលេងម្នាក់ៗក្នុងពិភពលោកនីមួយៗ
    @param kromprogramo ( NalaPlugin , មិនមែន null ) - កម្មវិធីជំនួយចម្បង
    @returns ទិន្នន័យចងចាំថ្មី */
public class LastaLoko {

    // ⟪ ទិន្នន័យទីតាំង 📃 ⟫
    // ទិន្នន័យទីតាំង
    private final NalaPlugin kromprogramo;
    private final Map<UUID, Map<String, Loko>> memoroj = new HashMap<>();
    private File dosiero;
    private YamlConfiguration datumoj;

    public LastaLoko(NalaPlugin kromprogramo) {
        this.kromprogramo = kromprogramo;
    }

    /* តំណាងសាមញ្ញសម្រាប់ទីតាំងមួយដែលបានចងចាំ ដោយមិនបញ្ចូលពិភពលោក
        @returns ទីតាំងថ្មី */
    public record Loko(double x, double y, double z, float yaw, float pitch) {
    }

    // ⟪ ឯកសារ 📃 ⟫
    // ឯកសាររក្សាទុក

    /* ផ្ទុកទីតាំងចុងក្រោយពី lokoj.yml
        @returns គ្មាន */
    public void ŝargi() {
        dosiero = new File(kromprogramo.getDataFolder(), "lokoj.yml");
        dosiero.getParentFile().mkdirs();
        datumoj = YamlConfiguration.loadConfiguration(dosiero);
        memoroj.clear();
        for ( String idento : datumoj.getKeys(false) ) {
            UUID ludantoId;
            try {
                ludantoId = UUID.fromString(idento);
            } catch ( Exception eraro ) {
                kromprogramo.getLogger().warning(Mesagoj.AVERTO_LOKOJ_LUDANTO);
                continue;
            }
            if ( ! datumoj.isConfigurationSection(idento) ) {
                continue;
            }
            ConfigurationSection ludantoSekcio = datumoj.getConfigurationSection(idento);
            Map<String, Loko> mondoj = new HashMap<>();
            for ( String mondoŜlosilo : ludantoSekcio.getKeys(false) ) {
                if ( ! ludantoSekcio.isConfigurationSection(mondoŜlosilo) ) {
                    continue;
                }
                ConfigurationSection lokoSekcio = ludantoSekcio.getConfigurationSection(mondoŜlosilo);
                try {
                    Loko loko = new Loko(
                        lokoSekcio.getDouble("x"),
                        lokoSekcio.getDouble("y"),
                        lokoSekcio.getDouble("z"),
                        (float) lokoSekcio.getDouble("yaw"),
                        (float) lokoSekcio.getDouble("pitch"));
                    mondoj.put(mondoŜlosilo, loko);
                } catch ( Exception eraro ) {
                    kromprogramo.getLogger().warning(Mesagoj.AVERTO_LOKOJ_LOKO);
                }
            }
            if ( ! mondoj.isEmpty() ) {
                memoroj.put(ludantoId, mondoj);
            }
        }
    }

    /* រក្សាទុកទីតាំងចុងក្រោយទៅ lokoj.yml
        @returns គ្មាន */
    public void konservi() {
        if ( datumoj == null || dosiero == null ) {
            return;
        }
        for ( String malnovaIdento : new ArrayList<>(datumoj.getKeys(false)) ) {
            UUID malnova;
            try {
                malnova = UUID.fromString(malnovaIdento);
            } catch ( Exception eraro ) {
                datumoj.set(malnovaIdento, null);
                continue;
            }
            if ( ! memoroj.containsKey(malnova) ) {
                datumoj.set(malnovaIdento, null);
            }
        }
        for ( Map.Entry<UUID, Map<String, Loko>> paro : memoroj.entrySet() ) {
            String idento = paro.getKey().toString();
            ConfigurationSection ludantoSekcio = datumoj.getConfigurationSection(idento);
            if ( ludantoSekcio == null ) {
                ludantoSekcio = datumoj.createSection(idento);
            }
            for ( String malnovaMondo : new ArrayList<>(ludantoSekcio.getKeys(false)) ) {
                if ( ! paro.getValue().containsKey(malnovaMondo) ) {
                    ludantoSekcio.set(malnovaMondo, null);
                }
            }
            for ( Map.Entry<String, Loko> lokoParo : paro.getValue().entrySet() ) {
                ConfigurationSection lokoSekcio = ludantoSekcio.getConfigurationSection(lokoParo.getKey());
                if ( lokoSekcio == null ) {
                    lokoSekcio = ludantoSekcio.createSection(lokoParo.getKey());
                }
                Loko loko = lokoParo.getValue();
                lokoSekcio.set("x", loko.x());
                lokoSekcio.set("y", loko.y());
                lokoSekcio.set("z", loko.z());
                lokoSekcio.set("yaw", loko.yaw());
                lokoSekcio.set("pitch", loko.pitch());
            }
        }
        try {
            datumoj.save(dosiero);
        } catch ( Exception eraro ) {
            kromprogramo.getLogger().warning(Mesagoj.ERARO_KONSERVI_LOKOJN + eraro.getMessage() + " ⟅");
        }
    }

    // ⟪ ការចងចាំ 📃 ⟫
    // ការចងចាំនិងការស្វែងរក

    /* ចងចាំទីតាំងបច្ចុប្បន្នរបស់អ្នកលេងក្នុងពិភពលោករបស់គាត់
        @param ludanto ( Player , មិនមែន null ) - អ្នកលេងដែលកំពុងធ្វើដំណើរ
        @returns គ្មាន */
    public void memoru(Player ludanto) {
        Location loko = ludanto.getLocation();
        if ( loko.getWorld() == null ) {
            return;
        }
        Map<String, Loko> mondoj = memoroj.computeIfAbsent(ludanto.getUniqueId(), k -> new HashMap<>());
        mondoj.put(loko.getWorld().getKey().toString(), new Loko(loko.getX(), loko.getY(), loko.getZ(), loko.getYaw(), loko.getPitch()));
        konservi();
    }

    /* ស្វែងរកទីតាំងចុងក្រោយរបស់អ្នកលេងក្នុងពិភពគោលដៅ
        @param ludanto ( Player , មិនមែន null ) - អ្នកលេងដែលកំពុងធ្វើដំណើរ
        @param celo ( World , មិនមែន null ) - ពិភពលោកគោលដៅ
        @returns ទីតាំងក្នុងពិភពគោលដៅ ឬ null */
    public Location lastaLoko(Player ludanto, World celo) {
        Map<String, Loko> mondoj = memoroj.get(ludanto.getUniqueId());
        if ( mondoj == null ) {
            return null;
        }
        Loko loko = mondoj.get(celo.getKey().toString());
        if ( loko == null ) {
            return null;
        }
        return new Location(celo, loko.x(), loko.y(), loko.z(), loko.yaw(), loko.pitch());
    }
}
