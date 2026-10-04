package okhttp3;

import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.mobileservice.common.ErrorCodeConvertor;
import io.netty.handler.ssl.Ciphers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p005A3.C0016a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class CipherSuite {
    final String javaName;
    static final Comparator<String> ORDER_BY_NAME = new C0016a(19);
    private static final Map<String, CipherSuite> INSTANCES = new LinkedHashMap();
    public static final CipherSuite TLS_RSA_WITH_NULL_MD5 = init("SSL_RSA_WITH_NULL_MD5", 1);
    public static final CipherSuite TLS_RSA_WITH_NULL_SHA = init("SSL_RSA_WITH_NULL_SHA", 2);
    public static final CipherSuite TLS_RSA_EXPORT_WITH_RC4_40_MD5 = init("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
    public static final CipherSuite TLS_RSA_WITH_RC4_128_MD5 = init("SSL_RSA_WITH_RC4_128_MD5", 4);
    public static final CipherSuite TLS_RSA_WITH_RC4_128_SHA = init("SSL_RSA_WITH_RC4_128_SHA", 5);
    public static final CipherSuite TLS_RSA_EXPORT_WITH_DES40_CBC_SHA = init("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
    public static final CipherSuite TLS_RSA_WITH_DES_CBC_SHA = init("SSL_RSA_WITH_DES_CBC_SHA", 9);
    public static final CipherSuite TLS_RSA_WITH_3DES_EDE_CBC_SHA = init("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
    public static final CipherSuite TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA = init("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
    public static final CipherSuite TLS_DHE_DSS_WITH_DES_CBC_SHA = init("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
    public static final CipherSuite TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA = init("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
    public static final CipherSuite TLS_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA = init("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
    public static final CipherSuite TLS_DHE_RSA_WITH_DES_CBC_SHA = init("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
    public static final CipherSuite TLS_DHE_RSA_WITH_3DES_EDE_CBC_SHA = init("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
    public static final CipherSuite TLS_DH_anon_EXPORT_WITH_RC4_40_MD5 = init("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
    public static final CipherSuite TLS_DH_anon_WITH_RC4_128_MD5 = init("SSL_DH_anon_WITH_RC4_128_MD5", 24);
    public static final CipherSuite TLS_DH_anon_EXPORT_WITH_DES40_CBC_SHA = init("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
    public static final CipherSuite TLS_DH_anon_WITH_DES_CBC_SHA = init("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
    public static final CipherSuite TLS_DH_anon_WITH_3DES_EDE_CBC_SHA = init("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
    public static final CipherSuite TLS_KRB5_WITH_DES_CBC_SHA = init("TLS_KRB5_WITH_DES_CBC_SHA", 30);
    public static final CipherSuite TLS_KRB5_WITH_3DES_EDE_CBC_SHA = init("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
    public static final CipherSuite TLS_KRB5_WITH_RC4_128_SHA = init("TLS_KRB5_WITH_RC4_128_SHA", 32);
    public static final CipherSuite TLS_KRB5_WITH_DES_CBC_MD5 = init("TLS_KRB5_WITH_DES_CBC_MD5", 34);
    public static final CipherSuite TLS_KRB5_WITH_3DES_EDE_CBC_MD5 = init("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
    public static final CipherSuite TLS_KRB5_WITH_RC4_128_MD5 = init("TLS_KRB5_WITH_RC4_128_MD5", 36);
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA = init("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_RC4_40_SHA = init("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5 = init("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_RC4_40_MD5 = init("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
    public static final CipherSuite TLS_RSA_WITH_AES_128_CBC_SHA = init(Ciphers.TLS_RSA_WITH_AES_128_CBC_SHA, 47);
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_128_CBC_SHA = init(Ciphers.TLS_DHE_DSS_WITH_AES_128_CBC_SHA, 50);
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_128_CBC_SHA = init(Ciphers.TLS_DHE_RSA_WITH_AES_128_CBC_SHA, 51);
    public static final CipherSuite TLS_DH_anon_WITH_AES_128_CBC_SHA = init(Ciphers.TLS_DH_anon_WITH_AES_128_CBC_SHA, 52);
    public static final CipherSuite TLS_RSA_WITH_AES_256_CBC_SHA = init(Ciphers.TLS_RSA_WITH_AES_256_CBC_SHA, 53);
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_256_CBC_SHA = init(Ciphers.TLS_DHE_DSS_WITH_AES_256_CBC_SHA, 56);
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_256_CBC_SHA = init(Ciphers.TLS_DHE_RSA_WITH_AES_256_CBC_SHA, 57);
    public static final CipherSuite TLS_DH_anon_WITH_AES_256_CBC_SHA = init(Ciphers.TLS_DH_anon_WITH_AES_256_CBC_SHA, 58);
    public static final CipherSuite TLS_RSA_WITH_NULL_SHA256 = init("TLS_RSA_WITH_NULL_SHA256", 59);
    public static final CipherSuite TLS_RSA_WITH_AES_128_CBC_SHA256 = init(Ciphers.TLS_RSA_WITH_AES_128_CBC_SHA256, 60);
    public static final CipherSuite TLS_RSA_WITH_AES_256_CBC_SHA256 = init(Ciphers.TLS_RSA_WITH_AES_256_CBC_SHA256, 61);
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_128_CBC_SHA256 = init(Ciphers.TLS_DHE_DSS_WITH_AES_128_CBC_SHA256, 64);
    public static final CipherSuite TLS_RSA_WITH_CAMELLIA_128_CBC_SHA = init("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
    public static final CipherSuite TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA = init("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
    public static final CipherSuite TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA = init("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_128_CBC_SHA256 = init(Ciphers.TLS_DHE_RSA_WITH_AES_128_CBC_SHA256, 103);
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_256_CBC_SHA256 = init(Ciphers.TLS_DHE_DSS_WITH_AES_256_CBC_SHA256, 106);
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_256_CBC_SHA256 = init(Ciphers.TLS_DHE_RSA_WITH_AES_256_CBC_SHA256, 107);
    public static final CipherSuite TLS_DH_anon_WITH_AES_128_CBC_SHA256 = init(Ciphers.TLS_DH_anon_WITH_AES_128_CBC_SHA256, 108);
    public static final CipherSuite TLS_DH_anon_WITH_AES_256_CBC_SHA256 = init(Ciphers.TLS_DH_anon_WITH_AES_256_CBC_SHA256, 109);
    public static final CipherSuite TLS_RSA_WITH_CAMELLIA_256_CBC_SHA = init("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
    public static final CipherSuite TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA = init("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
    public static final CipherSuite TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA = init("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
    public static final CipherSuite TLS_PSK_WITH_RC4_128_SHA = init("TLS_PSK_WITH_RC4_128_SHA", 138);
    public static final CipherSuite TLS_PSK_WITH_3DES_EDE_CBC_SHA = init("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
    public static final CipherSuite TLS_PSK_WITH_AES_128_CBC_SHA = init(Ciphers.TLS_PSK_WITH_AES_128_CBC_SHA, 140);
    public static final CipherSuite TLS_PSK_WITH_AES_256_CBC_SHA = init(Ciphers.TLS_PSK_WITH_AES_256_CBC_SHA, 141);
    public static final CipherSuite TLS_RSA_WITH_SEED_CBC_SHA = init("TLS_RSA_WITH_SEED_CBC_SHA", 150);
    public static final CipherSuite TLS_RSA_WITH_AES_128_GCM_SHA256 = init(Ciphers.TLS_RSA_WITH_AES_128_GCM_SHA256, 156);
    public static final CipherSuite TLS_RSA_WITH_AES_256_GCM_SHA384 = init(Ciphers.TLS_RSA_WITH_AES_256_GCM_SHA384, 157);
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_128_GCM_SHA256 = init(Ciphers.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, 158);
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_256_GCM_SHA384 = init(Ciphers.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384, 159);
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_128_GCM_SHA256 = init(Ciphers.TLS_DHE_DSS_WITH_AES_128_GCM_SHA256, 162);
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_256_GCM_SHA384 = init(Ciphers.TLS_DHE_DSS_WITH_AES_256_GCM_SHA384, 163);
    public static final CipherSuite TLS_DH_anon_WITH_AES_128_GCM_SHA256 = init(Ciphers.TLS_DH_anon_WITH_AES_128_GCM_SHA256, 166);
    public static final CipherSuite TLS_DH_anon_WITH_AES_256_GCM_SHA384 = init(Ciphers.TLS_DH_anon_WITH_AES_256_GCM_SHA384, 167);
    public static final CipherSuite TLS_EMPTY_RENEGOTIATION_INFO_SCSV = init("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
    public static final CipherSuite TLS_FALLBACK_SCSV = init("TLS_FALLBACK_SCSV", 22016);
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_NULL_SHA = init("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_RC4_128_SHA = init("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA = init("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA = init("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA = init("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_NULL_SHA = init("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_RC4_128_SHA = init("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA = init("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", ErrorCodeConvertor.CLOUD_PARAM_GCID_REQUIRED);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA = init(Ciphers.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, ErrorCodeConvertor.CLOUD_PARAM_GCID_INVALID);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA = init(Ciphers.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, ErrorCodeConvertor.CLOUD_PARAM_DATA_CLEAR_REQUIRED);
    public static final CipherSuite TLS_ECDH_RSA_WITH_NULL_SHA = init("TLS_ECDH_RSA_WITH_NULL_SHA", ErrorCodeConvertor.CLOUD_PARAM_DATA_CLEAR_INVALID);
    public static final CipherSuite TLS_ECDH_RSA_WITH_RC4_128_SHA = init("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
    public static final CipherSuite TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA = init("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_128_CBC_SHA = init("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", ErrorCodeConvertor.CLOUD_PARAM_PHYSICAL_DEVICE_ID_REQUIRED);
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_256_CBC_SHA = init("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", ErrorCodeConvertor.CLOUD_PARAM_PHYSICAL_DEVICE_ID_INVALID);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_NULL_SHA = init("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_RC4_128_SHA = init("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA = init("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA = init(Ciphers.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, 49171);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA = init(Ciphers.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, 49172);
    public static final CipherSuite TLS_ECDH_anon_WITH_NULL_SHA = init("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
    public static final CipherSuite TLS_ECDH_anon_WITH_RC4_128_SHA = init("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
    public static final CipherSuite TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA = init("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
    public static final CipherSuite TLS_ECDH_anon_WITH_AES_128_CBC_SHA = init(Ciphers.TLS_ECDH_anon_WITH_AES_128_CBC_SHA, 49176);
    public static final CipherSuite TLS_ECDH_anon_WITH_AES_256_CBC_SHA = init(Ciphers.TLS_ECDH_anon_WITH_AES_256_CBC_SHA, 49177);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256 = init(Ciphers.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256, 49187);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384 = init(Ciphers.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384, 49188);
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256 = init("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384 = init("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256 = init(Ciphers.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256, 49191);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384 = init(Ciphers.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384, 49192);
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256 = init("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384 = init("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256 = init(Ciphers.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, 49195);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384 = init(Ciphers.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, 49196);
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256 = init("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384 = init("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256 = init(Ciphers.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, 49199);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384 = init(Ciphers.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, 49200);
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256 = init("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", ErrorCodeConvertor.CLOUD_DELETED_USER);
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384 = init("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", ErrorCodeConvertor.CLOUD_INVALID_USER);
    public static final CipherSuite TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA = init(Ciphers.TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA, 49205);
    public static final CipherSuite TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA = init(Ciphers.TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA, ErrorCodeConvertor.CLOUD_INACTIVE_USER_APP_SERVICE);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256 = init(Ciphers.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, 52392);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256 = init(Ciphers.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, 52393);
    public static final CipherSuite TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256 = init(Ciphers.TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256, 52394);
    public static final CipherSuite TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256 = init(Ciphers.TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256, 52396);
    public static final CipherSuite TLS_AES_128_GCM_SHA256 = init(Ciphers.TLS_AES_128_GCM_SHA256, 4865);
    public static final CipherSuite TLS_AES_256_GCM_SHA384 = init(Ciphers.TLS_AES_256_GCM_SHA384, 4866);
    public static final CipherSuite TLS_CHACHA20_POLY1305_SHA256 = init(Ciphers.TLS_CHACHA20_POLY1305_SHA256, 4867);
    public static final CipherSuite TLS_AES_128_CCM_SHA256 = init("TLS_AES_128_CCM_SHA256", 4868);
    public static final CipherSuite TLS_AES_128_CCM_8_SHA256 = init("TLS_AES_128_CCM_8_SHA256", 4869);

    private CipherSuite(String str) {
        str.getClass();
        this.javaName = str;
    }

    public static synchronized CipherSuite forJavaName(String str) {
        CipherSuite cipherSuite;
        try {
            Map<String, CipherSuite> map = INSTANCES;
            cipherSuite = map.get(str);
            if (cipherSuite == null) {
                cipherSuite = map.get(secondaryName(str));
                if (cipherSuite == null) {
                    cipherSuite = new CipherSuite(str);
                }
                map.put(str, cipherSuite);
            }
        } catch (Throwable th) {
            throw th;
        }
        return cipherSuite;
    }

    public static List<CipherSuite> forJavaNames(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(forJavaName(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static CipherSuite init(String str, int i) {
        CipherSuite cipherSuite = new CipherSuite(str);
        INSTANCES.put(str, cipherSuite);
        return cipherSuite;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$static$0(String str, String str2) {
        int iMin = Math.min(str.length(), str2.length());
        for (int i = 4; i < iMin; i++) {
            char cCharAt = str.charAt(i);
            char cCharAt2 = str2.charAt(i);
            if (cCharAt != cCharAt2) {
                return cCharAt < cCharAt2 ? -1 : 1;
            }
        }
        int length = str.length();
        int length2 = str2.length();
        if (length != length2) {
            return length < length2 ? -1 : 1;
        }
        return 0;
    }

    private static String secondaryName(String str) {
        return str.startsWith("TLS_") ? AbstractC4539a.m3198h(new StringBuilder("SSL_"), str, 4) : str.startsWith("SSL_") ? AbstractC4539a.m3198h(new StringBuilder("TLS_"), str, 4) : str;
    }

    public String javaName() {
        return this.javaName;
    }

    public String toString() {
        return this.javaName;
    }
}
