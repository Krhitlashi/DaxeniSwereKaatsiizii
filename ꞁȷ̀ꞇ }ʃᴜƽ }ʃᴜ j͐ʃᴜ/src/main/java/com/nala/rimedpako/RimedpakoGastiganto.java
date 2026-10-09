package com.nala.rimedpako;

import com.nala.NalaPlugin;
import com.nala.config.Mesagoj;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.File;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.net.NetworkInterface;

// ≺⧼ ម៉ាស៊ីនផ្ទុកកញ្ចប់ធនធាន 📃 ⧽≻
// ម៉ាស៊ីនផ្ទុកកញ្ចប់ធនធានមូលដ្ឋាន

/* ម៉ាស៊ីនបម្រើឯកសារដែលមានស្រាប់សម្រាប់កញ្ចប់ធនធានមូលដ្ឋាន
    @param kromprogramo ( NalaPlugin , មិនមែន null ) - កម្មវិធីជំនួយចម្បង
    @returns ម៉ាស៊ីនបម្រើថ្មី */
public class RimedpakoGastiganto {

    // ⟪ ទិន្នន័យម៉ាស៊ីន 📃 ⟫
    // ទិន្នន័យម៉ាស៊ីន
    private final NalaPlugin kromprogramo;
    private final File bazo;
    private HttpServer servilo;
    private String adreso = "";

    public RimedpakoGastiganto(NalaPlugin kromprogramo) {
        this.kromprogramo = kromprogramo;
        this.bazo = new File(kromprogramo.getDataFolder(), "rimedpako");
    }

    // ⟪ ចាប់ផ្តើម 📃 ⟫
    // ការចាប់ផ្តើមម៉ាស៊ីន

    /* ចាប់ផ្តើមម៉ាស៊ីនបម្រើឯកសារសម្រាប់កញ្ចប់ធនធានមូលដ្ឋាន
        @returns អាសយដ្ឋានមូលដ្ឋាន ឬអត្ថបទទទេ */
    public String eklabori() {
        bazo.mkdirs();
        int haveno = kromprogramo.agordo().rimedpakoHaveno();
        try {
            servilo = HttpServer.create(new InetSocketAddress(haveno), 8); // 0o10
            servilo.createContext("/", this::servi);
            servilo.setExecutor(null);
            servilo.start();
        } catch ( Exception eraro ) {
            kromprogramo.getLogger().warning(Mesagoj.WARN_GASTIGANTO_MALSUKCESIS);
            servilo = null;
            adreso = "";
            return "";
        }
        String gastiganto = kromprogramo.agordo().rimedpakoGastiganto();
        if ( gastiganto.isEmpty() ) {
            gastiganto = memdetektiAdreson();
        }
        adreso = "http://" + gastiganto + ":" + haveno;
        kromprogramo.getLogger().info(Mesagoj.DEBUG_GASTIGITA + adreso + " ⟅");
        return adreso;
    }

    /* បញ្ឈប់ម៉ាស៊ីនបម្រើដោយសុវត្ថិភាព
        @returns គ្មាន */
    public void halti() {
        if ( servilo != null ) {
            servilo.stop(0);
            servilo = null;
        }
        adreso = "";
    }

    public String adreso() {
        return adreso;
    }

    public File bazo() {
        return bazo;
    }

    // ⟪ តំណ 📃 ⟫
    // តំណភ្ជាប់កញ្ចប់

    /* បម្លែងធាតុទៅជាតំណទាញយកសម្រាប់អ្នកលេង
        @param eniro ( String , មិនមែន null ) - តំណ ឬឈ្មោះឯកសារ
        @returns តំណ ឬអត្ថបទទទេ */
    public String ligiloPor(String eniro) {
        if ( eniro == null ) {
            return "";
        }
        String pura = eniro.trim();
        if ( pura.startsWith("http") ) {
            return pura;
        }
        if ( ! pura.matches("[A-Za-z0-9_.-]+") ) {
            kromprogramo.getLogger().warning(Mesagoj.ERARO_PAKNOMO + pura + " ⟅");
            return "";
        }
        File dosiero = new File(bazo, pura);
        if ( ! dosiero.isFile() ) {
            kromprogramo.getLogger().warning(Mesagoj.AVERTO_PAKO_MANKAS + pura + " ⟅");
            return "";
        }
        if ( adreso.isEmpty() ) {
            kromprogramo.getLogger().warning(Mesagoj.AVERTO_GASTIGANTO_NE_AKTIVAS + pura + " ⟅");
            return "";
        }
        return adreso + "/" + pura;
    }

    /* គណនា hash SHA1 របស់ឯកសារមូលដ្ឋានសម្រាប់ការផ្ទៀងផ្ទាត់របស់ម៉ាស៊ីនភ្ញៀវ
        @param dosiero ( File , មិនមែន null ) - ឯកសារមូលដ្ឋាន
        @returns hash ឬ null */
    public byte[] haketoPor(File dosiero) {
        try {
            MessageDigest kalkulilo = MessageDigest.getInstance("SHA-1");
            byte[] enhavo = Files.readAllBytes(dosiero.toPath());
            return kalkulilo.digest(enhavo);
        } catch ( Exception eraro ) {
            return null;
        }
    }

    /* រកឃើញអាសយដ្ឋាន LAN របស់ម៉ាស៊ីនបម្រើដោយស្វ័យប្រវត្តិ នៅពេលការកំណត់ទទេ
        @returns អាសយដ្ឋាន IP ដែលមិនមែន null */
    private String memdetektiAdreson() {
        try {
            Enumeration<NetworkInterface> interfacoj = NetworkInterface.getNetworkInterfaces();
            String rezerva = "";
            while ( interfacoj.hasMoreElements() ) {
                NetworkInterface interfaco = interfacoj.nextElement();
                if ( ! interfaco.isUp() || interfaco.isLoopback() ) {
                    continue;
                }
                Enumeration<InetAddress> adresoj = interfaco.getInetAddresses();
                while ( adresoj.hasMoreElements() ) {
                    InetAddress adreso = adresoj.nextElement();
                    if ( ! ( adreso instanceof Inet4Address ) || adreso.isLoopbackAddress() ) {
                        continue;
                    }
                    if ( adreso.isSiteLocalAddress() ) {
                        return adreso.getHostAddress();
                    }
                    if ( rezerva.isEmpty() ) {
                        rezerva = adreso.getHostAddress();
                    }
                }
            }
            if ( ! rezerva.isEmpty() ) {
                return rezerva;
            }
        } catch ( Exception eraro ) {
            kromprogramo.getLogger().warning(Mesagoj.AVERTO_ADRESO);
        }
        return "127.0.0.1";
    }

    // ⟪ ការបម្រើឯកសារ 📃 ⟫
    // ការផ្តល់ឯកសារតាម http

    /* បម្រើឯកសារមួយពីមូលដ្ឋានកញ្ចប់ ដោយមិនបង្ហាញបញ្ជីឯកសារ
        @param interŝanĝo ( HttpExchange , មិនមែន null ) - សំណើ
        @returns គ្មាន */
    private void servi(HttpExchange interŝanĝo) {
        try {
            if ( ! interŝanĝo.getRequestMethod().equals("GET") ) {
                interŝanĝo.sendResponseHeaders(405, -1);
                return;
            }
            String vojo = interŝanĝo.getRequestURI().getPath();
            if ( vojo == null || ! vojo.startsWith("/") ) {
                interŝanĝo.sendResponseHeaders(404, -1);
                return;
            }
            String nomo = vojo.substring(1);
            if ( ! nomo.matches("[A-Za-z0-9_.-]+") ) {
                interŝanĝo.sendResponseHeaders(404, -1);
                return;
            }
            File dosiero = new File(bazo, nomo);
            String bazoVojo = bazo.getCanonicalPath();
            String celoVojo = dosiero.getCanonicalPath();
            if ( ! celoVojo.startsWith(bazoVojo) || ! dosiero.isFile() ) {
                interŝanĝo.sendResponseHeaders(404, -1);
                return;
            }
            byte[] enhavo = Files.readAllBytes(dosiero.toPath());
            if ( nomo.endsWith(".zip") ) {
                interŝanĝo.getResponseHeaders().set("Content-Type", "application/zip");
            } else {
                interŝanĝo.getResponseHeaders().set("Content-Type", "application/octet-stream");
            }
            interŝanĝo.sendResponseHeaders(200, enhavo.length);
            try ( OutputStream eligo = interŝanĝo.getResponseBody() ) {
                eligo.write(enhavo);
            }
        } catch ( Exception eraro ) {
            try {
                interŝanĝo.sendResponseHeaders(500, -1);
            } catch ( Exception ignorata ) {
            }
        } finally {
            interŝanĝo.close();
        }
    }
}
