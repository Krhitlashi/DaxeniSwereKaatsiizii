package com.nala.portalo;

import com.nala.NalaDaxe;
import com.nala.config.S2bana;
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

// ≺⧼ ֭ſɭw }ʃᴜȝ ʌ ᴜ ɽ͑ʃ'ᴜȝ 📃 ⧽≻


/* ֭ſɭw }ʃᴜȝ ʌ ᴜ ɽ͑ʃ'ᴜȝ */
public class HunaqAraq {

    // ⟪ ᴜ ɽ͑ʃ'ᴜȝ 📃 ⟫

    private final NalaDaxe daxe;
    private final Map<UUID, Map<String, Araq>> ksaka8 = new HashMap<>();
    private File cakavop2;
    private YamlConfiguration vop26;

    public HunaqAraq(NalaDaxe daxe) {
        this.daxe = daxe;
    }

    /* ᴜ ɽ͑ʃ'ᴜȝ */
    public record Araq(double kantoni2, double kantoni22, double kantoni3, float c2w2q4, float c2w2q5) {
    }

    // ⟪ ſᶘɹ ɭʃɜ j͑ʃᴜᶗ‹ 📃 ⟫


    /* ſᶘɹ ɭʃɜ j͑ʃᴜᶗ‹ */
    public void ts2tosax() {
        cakavop2 = new File(daxe.getDataFolder(), "lokoj.yml");
        cakavop2.getParentFile().mkdirs();
        vop26 = YamlConfiguration.loadConfiguration(cakavop2);
        ksaka8.clear();
        for ( String ksaka6 : vop26.getKeys(false) ) {
            UUID hq2Ksaka;
            try {
                hq2Ksaka = UUID.fromString(ksaka6);
            } catch ( Exception a3ohk2nik2p2 ) {
                daxe.getLogger().warning(S2bana.YOR2_ARAQ_HQ2);
                continue;
            }
            if ( ! vop26.isConfigurationSection(ksaka6) ) {
                continue;
            }
            ConfigurationSection hq2Kantoni = vop26.getConfigurationSection(ksaka6);
            Map<String, Araq> nala4 = new HashMap<>();
            for ( String nalaCa3aq : hq2Kantoni.getKeys(false) ) {
                if ( ! hq2Kantoni.isConfigurationSection(nalaCa3aq) ) {
                    continue;
                }
                ConfigurationSection araqKantoni = hq2Kantoni.getConfigurationSection(nalaCa3aq);
                try {
                    Araq araq3 = new Araq(
                        araqKantoni.getDouble("x"),
                        araqKantoni.getDouble("y"),
                        araqKantoni.getDouble("z"),
                        (float) araqKantoni.getDouble("yaw"),
                        (float) araqKantoni.getDouble("pitch"));
                    nala4.put(nalaCa3aq, araq3);
                } catch ( Exception a3ohk2nik2p2 ) {
                    daxe.getLogger().warning(S2bana.YOR2_ARAQ_ARAQ);
                }
            }
            if ( ! nala4.isEmpty() ) {
                ksaka8.put(hq2Ksaka, nala4);
            }
        }
    }

    /* j͑ʃ'ɔ ſ̀ȷᴜȝ */
    public void ve3aq() {
        if ( vop26 == null || cakavop2 == null ) {
            return;
        }
        for ( String hunaqKsaka : new ArrayList<>(vop26.getKeys(false)) ) {
            UUID hunaq2;
            try {
                hunaq2 = UUID.fromString(hunaqKsaka);
            } catch ( Exception a3ohk2nik2p2 ) {
                vop26.set(hunaqKsaka, null);
                continue;
            }
            if ( ! ksaka8.containsKey(hunaq2) ) {
                vop26.set(hunaqKsaka, null);
            }
        }
        for ( Map.Entry<UUID, Map<String, Araq>> paro : ksaka8.entrySet() ) {
            String ksaka6 = paro.getKey().toString();
            ConfigurationSection hq2Kantoni = vop26.getConfigurationSection(ksaka6);
            if ( hq2Kantoni == null ) {
                hq2Kantoni = vop26.createSection(ksaka6);
            }
            for ( String hunaqNala : new ArrayList<>(hq2Kantoni.getKeys(false)) ) {
                if ( ! paro.getValue().containsKey(hunaqNala) ) {
                    hq2Kantoni.set(hunaqNala, null);
                }
            }
            for ( Map.Entry<String, Araq> lokoParo : paro.getValue().entrySet() ) {
                ConfigurationSection araqKantoni = hq2Kantoni.getConfigurationSection(lokoParo.getKey());
                if ( araqKantoni == null ) {
                    araqKantoni = hq2Kantoni.createSection(lokoParo.getKey());
                }
                Araq araq3 = lokoParo.getValue();
                araqKantoni.set("x", araq3.kantoni2());
                araqKantoni.set("y", araq3.kantoni22());
                araqKantoni.set("z", araq3.kantoni3());
                araqKantoni.set("yaw", araq3.c2w2q4());
                araqKantoni.set("pitch", araq3.c2w2q5());
            }
        }
        try {
            vop26.save(cakavop2);
        } catch ( Exception a3ohk2nik2p2 ) {
            daxe.getLogger().warning(S2bana.A3OHK2NIK2P2_VE3AQ_ARAQ + a3ohk2nik2p2.getMessage() + " ⟅");
        }
    }

    // ⟪ ſɭɔ˞ᴜ ſɭᴜ ɜⅎ 📃 ⟫


    /* ſɭɔ˞ᴜ ſɭᴜ ɜⅎ */
    public void ksaka7(Player hq2) {
        Location araq3 = hq2.getLocation();
        if ( araq3.getWorld() == null ) {
            return;
        }
        Map<String, Araq> nala4 = ksaka8.computeIfAbsent(hq2.getUniqueId(), k2fe3 -> new HashMap<>());
        nala4.put(araq3.getWorld().getKey().toString(), new Araq(araq3.getX(), araq3.getY(), araq3.getZ(), araq3.getYaw(), araq3.getPitch()));
        ve3aq();
    }

    /* ֭ſɭw }ʃᴜȝ ʌ ᴜ ɽ͑ʃ'ᴜ ſ͕ɭɹ */
    public Location hunaqAraq2(Player hq2, World kxawa) {
        Map<String, Araq> nala4 = ksaka8.get(hq2.getUniqueId());
        if ( nala4 == null ) {
            return null;
        }
        Araq araq3 = nala4.get(kxawa.getKey().toString());
        if ( araq3 == null ) {
            return null;
        }
        return new Location(kxawa, araq3.kantoni2(), araq3.kantoni22(), araq3.kantoni3(), araq3.c2w2q4(), araq3.c2w2q5());
    }
}
