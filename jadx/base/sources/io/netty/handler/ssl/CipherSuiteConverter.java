package io.netty.handler.ssl;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.exifinterface.media.ExifInterface;
import com.microsoft.identity.common.java.crypto.key.AES256KeyLoader;
import com.microsoft.identity.common.java.platform.AbstractDevicePopManager;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.collections.AbstractC12991c;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class CipherSuiteConverter {
    private static final Map<String, String> j2oTls13;
    private static final Map<String, Map<String, String>> o2jTls13;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) CipherSuiteConverter.class);
    private static final Pattern JAVA_CIPHERSUITE_PATTERN = Pattern.compile("^(?:TLS|SSL)_((?:(?!_WITH_).)+)_WITH_(.*)_(.*)$");
    private static final Pattern OPENSSL_CIPHERSUITE_PATTERN = Pattern.compile("^(?:((?:(?:EXP-)?(?:(?:DHE|EDH|ECDH|ECDHE|SRP|RSA)-(?:DSS|RSA|ECDSA|PSK)|(?:ADH|AECDH|KRB5|PSK|SRP)))|EXP)-)?(.*)-(.*)$");
    private static final Pattern JAVA_AES_CBC_PATTERN = Pattern.compile("^(AES)_([0-9]+)_CBC$");
    private static final Pattern JAVA_AES_PATTERN = Pattern.compile("^(AES)_([0-9]+)_(.*)$");
    private static final Pattern OPENSSL_AES_CBC_PATTERN = Pattern.compile("^(AES)([0-9]+)$");
    private static final Pattern OPENSSL_AES_PATTERN = Pattern.compile("^(AES)([0-9]+)-(.*)$");
    private static final ConcurrentMap<String, String> j2o = PlatformDependent.newConcurrentHashMap();
    private static final ConcurrentMap<String, Map<String, String>> o2j = PlatformDependent.newConcurrentHashMap();

    static {
        HashMap mapM13996q = AbstractC12991c.m13996q(Ciphers.TLS_AES_128_GCM_SHA256, "AEAD-AES128-GCM-SHA256", Ciphers.TLS_AES_256_GCM_SHA384, "AEAD-AES256-GCM-SHA384");
        mapM13996q.put(Ciphers.TLS_CHACHA20_POLY1305_SHA256, "AEAD-CHACHA20-POLY1305-SHA256");
        j2oTls13 = Collections.unmodifiableMap(mapM13996q);
        HashMap map = new HashMap();
        map.put(Ciphers.TLS_AES_128_GCM_SHA256, Collections.singletonMap("TLS", Ciphers.TLS_AES_128_GCM_SHA256));
        map.put(Ciphers.TLS_AES_256_GCM_SHA384, Collections.singletonMap("TLS", Ciphers.TLS_AES_256_GCM_SHA384));
        map.put(Ciphers.TLS_CHACHA20_POLY1305_SHA256, Collections.singletonMap("TLS", Ciphers.TLS_CHACHA20_POLY1305_SHA256));
        map.put("AEAD-AES128-GCM-SHA256", Collections.singletonMap("TLS", Ciphers.TLS_AES_128_GCM_SHA256));
        map.put("AEAD-AES256-GCM-SHA384", Collections.singletonMap("TLS", Ciphers.TLS_AES_256_GCM_SHA384));
        map.put("AEAD-CHACHA20-POLY1305-SHA256", Collections.singletonMap("TLS", Ciphers.TLS_CHACHA20_POLY1305_SHA256));
        o2jTls13 = Collections.unmodifiableMap(map);
    }

    private CipherSuiteConverter() {
    }

    private static String cacheFromJava(String str, boolean z) {
        String str2 = j2oTls13.get(str);
        if (str2 != null) {
            return z ? str2 : str;
        }
        String openSslUncached = toOpenSslUncached(str, z);
        if (openSslUncached == null) {
            return null;
        }
        j2o.putIfAbsent(str, openSslUncached);
        String strSubstring = str.substring(4);
        HashMap map = new HashMap(4);
        map.put("", strSubstring);
        map.put("SSL", "SSL_" + strSubstring);
        map.put("TLS", "TLS_" + strSubstring);
        o2j.put(openSslUncached, map);
        logger.debug("Cipher suite mapping: {} => {}", str, openSslUncached);
        return openSslUncached;
    }

    private static Map<String, String> cacheFromOpenSsl(String str) {
        Map<String, String> map = o2jTls13.get(str);
        if (map != null) {
            return map;
        }
        String javaUncached0 = toJavaUncached0(str, false);
        if (javaUncached0 == null) {
            return null;
        }
        String strConcat = "SSL_".concat(javaUncached0);
        String strConcat2 = "TLS_".concat(javaUncached0);
        HashMap map2 = new HashMap(4);
        map2.put("", javaUncached0);
        map2.put("SSL", strConcat);
        map2.put("TLS", strConcat2);
        o2j.putIfAbsent(str, map2);
        ConcurrentMap<String, String> concurrentMap = j2o;
        concurrentMap.putIfAbsent(strConcat2, str);
        concurrentMap.putIfAbsent(strConcat, str);
        InternalLogger internalLogger = logger;
        internalLogger.debug("Cipher suite mapping: {} => {}", strConcat2, str);
        internalLogger.debug("Cipher suite mapping: {} => {}", strConcat, str);
        return map2;
    }

    public static void clearCache() {
        j2o.clear();
        o2j.clear();
    }

    public static void convertToCipherStrings(Iterable<String> iterable, StringBuilder sb, StringBuilder sb2, boolean z) {
        String next;
        Iterator<String> it = iterable.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            String openSsl = toOpenSsl(next, z);
            if (openSsl == null) {
                openSsl = next;
            }
            if (!OpenSsl.isCipherSuiteAvailable(openSsl)) {
                throw new IllegalArgumentException("unsupported cipher suite: " + next + PropertyUtils.MAPPED_DELIM + openSsl + PropertyUtils.MAPPED_DELIM2);
            }
            if (SslUtils.isTLSv13Cipher(openSsl) || SslUtils.isTLSv13Cipher(next)) {
                sb2.append(openSsl);
                sb2.append(':');
            } else {
                sb.append(openSsl);
                sb.append(':');
            }
        }
        if (sb.length() == 0 && sb2.length() == 0) {
            throw new IllegalArgumentException("empty cipher suites");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        if (sb2.length() > 0) {
            sb2.setLength(sb2.length() - 1);
        }
    }

    public static boolean isJ2OCached(String str, String str2) {
        return str2.equals(j2o.get(str));
    }

    public static boolean isO2JCached(String str, String str2, String str3) {
        Map<String, String> map = o2j.get(str);
        if (map == null) {
            return false;
        }
        return str3.equals(map.get(str2));
    }

    public static String toJava(String str, String str2) {
        Map<String, String> mapCacheFromOpenSsl = o2j.get(str);
        if (mapCacheFromOpenSsl == null && (mapCacheFromOpenSsl = cacheFromOpenSsl(str)) == null) {
            return null;
        }
        String str3 = mapCacheFromOpenSsl.get(str2);
        if (str3 != null) {
            return str3;
        }
        String str4 = mapCacheFromOpenSsl.get("");
        if (str4 == null) {
            return null;
        }
        return AbstractC1038a.m1212m('_', str2, str4);
    }

    private static String toJavaBulkCipher(String str, boolean z) {
        if (str.startsWith(AES256KeyLoader.AES_ALGORITHM)) {
            Matcher matcher = OPENSSL_AES_CBC_PATTERN.matcher(str);
            if (matcher.matches()) {
                return matcher.replaceFirst("$1_$2_CBC");
            }
            Matcher matcher2 = OPENSSL_AES_PATTERN.matcher(str);
            if (matcher2.matches()) {
                return matcher2.replaceFirst("$1_$2_$3");
            }
        }
        return "DES-CBC3".equals(str) ? "3DES_EDE_CBC" : "RC4".equals(str) ? z ? "RC4_40" : "RC4_128" : "DES-CBC".equals(str) ? z ? "DES_CBC_40" : "DES_CBC" : "RC2-CBC".equals(str) ? z ? "RC2_CBC_40" : "RC2_CBC" : str.replace('-', '_');
    }

    private static String toJavaHandshakeAlgo(String str, boolean z) {
        if (str.isEmpty()) {
            str = AbstractDevicePopManager.KeyPairGeneratorAlgorithms.RSA;
        } else if ("ADH".equals(str)) {
            str = "DH_anon";
        } else if ("AECDH".equals(str)) {
            str = "ECDH_anon";
        }
        String strReplace = str.replace('-', '_');
        return z ? AbstractC0541b.m756B(strReplace, "_EXPORT") : strReplace;
    }

    public static String toJavaUncached(String str) {
        return toJavaUncached0(str, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String toJavaUncached0(String str, boolean z) {
        Map<String, String> map;
        if (z && (map = o2jTls13.get(str)) != null) {
            return map.get("TLS");
        }
        Matcher matcher = OPENSSL_CIPHERSUITE_PATTERN.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        boolean z2 = true;
        String strGroup = matcher.group(1);
        if (strGroup != null) {
            if (strGroup.startsWith("EXP-")) {
                strGroup = strGroup.substring(4);
            } else if (!"EXP".equals(strGroup)) {
                z2 = false;
            }
            String javaHandshakeAlgo = toJavaHandshakeAlgo(strGroup, z2);
            String javaBulkCipher = toJavaBulkCipher(matcher.group(2), z2);
            String str2 = javaHandshakeAlgo + "_WITH_" + javaBulkCipher + '_' + toJavaHmacAlgo(matcher.group(3));
            return !javaBulkCipher.contains("CHACHA20") ? AbstractC0541b.m756B(str2, "_SHA256") : str2;
        }
        z2 = false;
        strGroup = "";
        String javaHandshakeAlgo2 = toJavaHandshakeAlgo(strGroup, z2);
        String javaBulkCipher2 = toJavaBulkCipher(matcher.group(2), z2);
        String str22 = javaHandshakeAlgo2 + "_WITH_" + javaBulkCipher2 + '_' + toJavaHmacAlgo(matcher.group(3));
        if (!javaBulkCipher2.contains("CHACHA20")) {
        }
    }

    public static String toOpenSsl(String str, boolean z) {
        String str2 = j2o.get(str);
        return str2 != null ? str2 : cacheFromJava(str, z);
    }

    private static String toOpenSslBulkCipher(String str) {
        if (str.startsWith("AES_")) {
            Matcher matcher = JAVA_AES_CBC_PATTERN.matcher(str);
            if (matcher.matches()) {
                return matcher.replaceFirst("$1$2");
            }
            Matcher matcher2 = JAVA_AES_PATTERN.matcher(str);
            if (matcher2.matches()) {
                return matcher2.replaceFirst("$1$2-$3");
            }
        }
        return "3DES_EDE_CBC".equals(str) ? "DES-CBC3" : ("RC4_128".equals(str) || "RC4_40".equals(str)) ? "RC4" : ("DES40_CBC".equals(str) || "DES_CBC_40".equals(str)) ? "DES-CBC" : "RC2_CBC_40".equals(str) ? "RC2-CBC" : str.replace('_', '-');
    }

    private static String toOpenSslHandshakeAlgo(String str) {
        boolean zEndsWith = str.endsWith("_EXPORT");
        if (zEndsWith) {
            str = AbstractC2322a.m1614d(7, 0, str);
        }
        if (AbstractDevicePopManager.KeyPairGeneratorAlgorithms.RSA.equals(str)) {
            str = "";
        } else if (str.endsWith("_anon")) {
            str = ExifInterface.GPS_MEASUREMENT_IN_PROGRESS + str.substring(0, str.length() - 5);
        }
        if (zEndsWith) {
            str = str.isEmpty() ? "EXP" : "EXP-".concat(str);
        }
        return str.replace('_', '-');
    }

    public static String toOpenSslUncached(String str, boolean z) {
        String str2 = j2oTls13.get(str);
        if (str2 != null) {
            return z ? str2 : str;
        }
        Matcher matcher = JAVA_CIPHERSUITE_PATTERN.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String openSslHandshakeAlgo = toOpenSslHandshakeAlgo(matcher.group(1));
        String openSslBulkCipher = toOpenSslBulkCipher(matcher.group(2));
        String openSslHmacAlgo = toOpenSslHmacAlgo(matcher.group(3));
        if (openSslHandshakeAlgo.isEmpty()) {
            return AbstractC1038a.m1212m('-', openSslBulkCipher, openSslHmacAlgo);
        }
        if (openSslBulkCipher.contains("CHACHA20")) {
            return AbstractC1038a.m1212m('-', openSslHandshakeAlgo, openSslBulkCipher);
        }
        return openSslHandshakeAlgo + '-' + openSslBulkCipher + '-' + openSslHmacAlgo;
    }

    private static String toJavaHmacAlgo(String str) {
        return str;
    }

    private static String toOpenSslHmacAlgo(String str) {
        return str;
    }
}
