package com.nala.rimedpako;

import com.nala.NalaDaxe;
import com.nala.config.S2bana;
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

// ≺⧼ ɭʃᴜ̭ᴜ ſ͕ɭƨᴜ̭ᴜȝ ʌ ֭ſɭᴜ ɭʃɔ 📃 ⧽≻


/* ɭʃᴜ̭ᴜ ſ͕ɭƨᴜ̭ᴜȝ ʌ ֭ſɭᴜ ɭʃɔ */
public class TcaqtcaqHate {

    // ⟪ ſןᴜ ʃɜ ſɭɹ 📃 ⟫

    private final NalaDaxe daxe;
    private final File k6h6;
    private HttpServer hate4;
    private String ruva4 = "";

    public TcaqtcaqHate(NalaDaxe daxe) {
        this.daxe = daxe;
        this.k6h6 = new File(daxe.getDataFolder(), "rimedpako");
    }

    // ⟪ ſןᴜ ʃɜ ſɭɹ 📃 ⟫


    /* ſןᴜ ʃɜ ſɭɹ */
    public String pabok2() {
        k6h6.mkdirs();
        int eskek5 = daxe.ku1o().tcaqtcaqEskek();
        try {
            hate4 = HttpServer.create(new InetSocketAddress(eskek5), 8);
            hate4.createContext("/", this::tlaa);
            hate4.setExecutor(null);
            hate4.start();
        } catch ( Exception a3ohk2nik2p2 ) {
            daxe.getLogger().warning(S2bana.YOR2_HATE_H2L);
            hate4 = null;
            ruva4 = "";
            return "";
        }
        String hate3 = daxe.ku1o().tcaqtcaqHate();
        if ( hate3.isEmpty() ) {
            hate3 = osakajoS2rol2miRuva();
        }
        ruva4 = "http://" + hate3 + ":" + eskek5;
        daxe.getLogger().info(S2bana.K2F_HATE + ruva4 + " ⟅");
        return ruva4;
    }

    /* j͑ʃ'ᴜ }ʃɔ ſɭᴜ j͐ʃᴜ */
    public void vanekala() {
        if ( hate4 != null ) {
            hate4.stop(0);
            hate4 = null;
        }
        ruva4 = "";
    }

    public String ruva4() {
        return ruva4;
    }

    public File k6h6() {
        return k6h6;
    }

    // ⟪ j͐ʃꞇ ſ͔ɭꞇ j͐ʃɜ ʌ ſןɜƣ̋ 📃 ⟫


    /* j͐ʃꞇ ſ͔ɭꞇ j͐ʃɜ ʌ ſןɜƣ̋ */
    public String ruvaZeni(String veb6kek7) {
        if ( veb6kek7 == null ) {
            return "";
        }
        String anis2 = veb6kek7.trim();
        if ( anis2.startsWith("http") ) {
            return anis2;
        }
        if ( ! anis2.matches("[A-Za-z0-9_.-]+") ) {
            daxe.getLogger().warning(S2bana.A3OHK2NIK2P2_H2L_ANIS_TCAQ_KSAKA + anis2 + " ⟅");
            return "";
        }
        File cakavop2 = new File(k6h6, anis2);
        if ( ! cakavop2.isFile() ) {
            daxe.getLogger().warning(S2bana.YOR2_TCAQ_H2L + anis2 + " ⟅");
            return "";
        }
        if ( ruva4.isEmpty() ) {
            daxe.getLogger().warning(S2bana.YOR2_HATE_H2L_SP2 + anis2 + " ⟅");
            return "";
        }
        return ruva4 + "/" + anis2;
    }

    /* ֭ſɭᴜ ſɭɔ ɭʃɜ ʌ ſןɜƣ̋ */
    public byte[] kp6tafZeni(File cakavop2) {
        try {
            MessageDigest kp6taf = MessageDigest.getInstance("SHA-1");
            byte[] vop22 = Files.readAllBytes(cakavop2.toPath());
            return kp6taf.digest(vop22);
        } catch ( Exception a3ohk2nik2p2 ) {
            return null;
        }
    }

    /* ŋᷠɔ ŋᷠԏ͕ɔ ɭʃɔ ſɭƨꞇ ʌ ᴜ ɭ(ƣ̋ɔ j͑ʃɜc̗ */
    private String osakajoS2rol2miRuva() {
        try {
            Enumeration<NetworkInterface> ca1ara = NetworkInterface.getNetworkInterfaces();
            String ve3aq = "";
            while ( ca1ara.hasMoreElements() ) {
                NetworkInterface c2kani = ca1ara.nextElement();
                if ( ! c2kani.isUp() || c2kani.isLoopback() ) {
                    continue;
                }
                Enumeration<InetAddress> ruva3 = c2kani.getInetAddresses();
                while ( ruva3.hasMoreElements() ) {
                    InetAddress ruva4 = ruva3.nextElement();
                    if ( ! ( ruva4 instanceof Inet4Address ) || ruva4.isLoopbackAddress() ) {
                        continue;
                    }
                    if ( ruva4.isSiteLocalAddress() ) {
                        return ruva4.getHostAddress();
                    }
                    if ( ve3aq.isEmpty() ) {
                        ve3aq = ruva4.getHostAddress();
                    }
                }
            }
            if ( ! ve3aq.isEmpty() ) {
                return ve3aq;
            }
        } catch ( Exception a3ohk2nik2p2 ) {
            daxe.getLogger().warning(S2bana.YOR2_RUVA);
        }
        return "127.0.0.1";
    }

    // ⟪ j͑ʃɔ ɽ͑ʃ'ⰱꞇ 📃 ⟫


    /* j͑ʃɔ ɽ͑ʃ'ⰱꞇ */
    private void tlaa(HttpExchange kenala) {
        try {
            if ( ! kenala.getRequestMethod().equals("GET") ) {
                kenala.sendResponseHeaders(405, -1);
                return;
            }
            String ruvaK6h6 = kenala.getRequestURI().getPath();
            if ( ruvaK6h6 == null || ! ruvaK6h6.startsWith("/") ) {
                kenala.sendResponseHeaders(404, -1);
                return;
            }
            String ksaka = ruvaK6h6.substring(1);
            if ( ! ksaka.matches("[A-Za-z0-9_.-]+") ) {
                kenala.sendResponseHeaders(404, -1);
                return;
            }
            File cakavop2 = new File(k6h6, ksaka);
            String k6h6Fal3aqai = k6h6.getCanonicalPath();
            String kxawaK6h62 = cakavop2.getCanonicalPath();
            if ( ! kxawaK6h62.startsWith(k6h6Fal3aqai) || ! cakavop2.isFile() ) {
                kenala.sendResponseHeaders(404, -1);
                return;
            }
            byte[] vop22 = Files.readAllBytes(cakavop2.toPath());
            if ( ksaka.endsWith(".zip") ) {
                kenala.getResponseHeaders().set("Content-Type", "application/zip");
            } else {
                kenala.getResponseHeaders().set("Content-Type", "application/octet-stream");
            }
            kenala.sendResponseHeaders(200, vop22.length);
            try ( OutputStream a10ni11 = kenala.getResponseBody() ) {
                a10ni11.write(vop22);
            }
        } catch ( Exception a3ohk2nik2p2 ) {
            try {
                kenala.sendResponseHeaders(500, -1);
            } catch ( Exception yor25 ) {
            }
        } finally {
            kenala.close();
        }
    }
}
