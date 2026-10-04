package io.netty.handler.ssl;

import androidx.glance.AbstractC2821a;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.internal.tcnative.Buffer;
import io.netty.internal.tcnative.CertificateCallback;
import io.netty.internal.tcnative.Library;
import io.netty.internal.tcnative.SSL;
import io.netty.internal.tcnative.SSLContext;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.NativeLibraryLoader;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.ByteArrayInputStream;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.SystemProperties;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class OpenSsl {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final Set<String> AVAILABLE_CIPHER_SUITES;
    private static final Set<String> AVAILABLE_JAVA_CIPHER_SUITES;
    private static final Set<String> AVAILABLE_OPENSSL_CIPHER_SUITES;
    private static final String CERT = "-----BEGIN CERTIFICATE-----\nMIICrjCCAZagAwIBAgIIdSvQPv1QAZQwDQYJKoZIhvcNAQELBQAwFjEUMBIGA1UEAxMLZXhhbXBs\nZS5jb20wIBcNMTgwNDA2MjIwNjU5WhgPOTk5OTEyMzEyMzU5NTlaMBYxFDASBgNVBAMTC2V4YW1w\nbGUuY29tMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAggbWsmDQ6zNzRZ5AW8E3eoGl\nqWvOBDb5Fs1oBRrVQHuYmVAoaqwDzXYJ0LOwa293AgWEQ1jpcbZ2hpoYQzqEZBTLnFhMrhRFlH6K\nbJND8Y33kZ/iSVBBDuGbdSbJShlM+4WwQ9IAso4MZ4vW3S1iv5fGGpLgbtXRmBf/RU8omN0Gijlv\nWlLWHWijLN8xQtySFuBQ7ssW8RcKAary3pUm6UUQB+Co6lnfti0Tzag8PgjhAJq2Z3wbsGRnP2YS\nvYoaK6qzmHXRYlp/PxrjBAZAmkLJs4YTm/XFF+fkeYx4i9zqHbyone5yerRibsHaXZWLnUL+rFoe\nMdKvr0VS3sGmhQIDAQABMA0GCSqGSIb3DQEBCwUAA4IBAQADQi441pKmXf9FvUV5EHU4v8nJT9Iq\nyqwsKwXnr7AsUlDGHBD7jGrjAXnG5rGxuNKBQ35wRxJATKrUtyaquFUL6H8O6aGQehiFTk6zmPbe\n12Gu44vqqTgIUxnv3JQJiox8S2hMxsSddpeCmSdvmalvD6WG4NthH6B9ZaBEiep1+0s0RUaBYn73\nI7CCUaAtbjfR6pcJjrFk5ei7uwdQZFSJtkP2z8r7zfeANJddAKFlkaMWn7u+OIVuB4XPooWicObk\nNAHFtP65bocUYnDpTVdiyvn8DdqyZ/EO8n1bBKBzuSLplk2msW4pdgaFgY7Vw/0wzcFXfUXmL1uy\nG8sQD/wx\n-----END CERTIFICATE-----";
    private static final Set<String> CLIENT_DEFAULT_PROTOCOLS;
    static final List<String> DEFAULT_CIPHERS;
    private static final String[] DEFAULT_NAMED_GROUPS;
    static final String[] EXTRA_SUPPORTED_TLS_1_3_CIPHERS;
    static final String EXTRA_SUPPORTED_TLS_1_3_CIPHERS_STRING;
    private static final boolean IS_BORINGSSL;
    private static final String KEY = "-----BEGIN PRIVATE KEY-----\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCCBtayYNDrM3NFnkBbwTd6gaWp\na84ENvkWzWgFGtVAe5iZUChqrAPNdgnQs7Brb3cCBYRDWOlxtnaGmhhDOoRkFMucWEyuFEWUfops\nk0PxjfeRn+JJUEEO4Zt1JslKGUz7hbBD0gCyjgxni9bdLWK/l8YakuBu1dGYF/9FTyiY3QaKOW9a\nUtYdaKMs3zFC3JIW4FDuyxbxFwoBqvLelSbpRRAH4KjqWd+2LRPNqDw+COEAmrZnfBuwZGc/ZhK9\nihorqrOYddFiWn8/GuMEBkCaQsmzhhOb9cUX5+R5jHiL3OodvKid7nJ6tGJuwdpdlYudQv6sWh4x\n0q+vRVLewaaFAgMBAAECggEAP8tPJvFtTxhNJAkCloHz0D0vpDHqQBMgntlkgayqmBqLwhyb18pR\ni0qwgh7HHc7wWqOOQuSqlEnrWRrdcI6TSe8R/sErzfTQNoznKWIPYcI/hskk4sdnQ//Yn9/Jvnsv\nU/BBjOTJxtD+sQbhAl80JcA3R+5sArURQkfzzHOL/YMqzAsn5hTzp7HZCxUqBk3KaHRxV7NefeOE\nxlZuWSmxYWfbFIs4kx19/1t7h8CHQWezw+G60G2VBtSBBxDnhBWvqG6R/wpzJ3nEhPLLY9T+XIHe\nipzdMOOOUZorfIg7M+pyYPji+ZIZxIpY5OjrOzXHciAjRtr5Y7l99K1CG1LguQKBgQDrQfIMxxtZ\nvxU/1cRmUV9l7pt5bjV5R6byXq178LxPKVYNjdZ840Q0/OpZEVqaT1xKVi35ohP1QfNjxPLlHD+K\niDAR9z6zkwjIrbwPCnb5kuXy4lpwPcmmmkva25fI7qlpHtbcuQdoBdCfr/KkKaUCMPyY89LCXgEw\n5KTDj64UywKBgQCNfbO+eZLGzhiHhtNJurresCsIGWlInv322gL8CSfBMYl6eNfUTZvUDdFhPISL\nUljKWzXDrjw0ujFSPR0XhUGtiq89H+HUTuPPYv25gVXO+HTgBFZEPl4PpA+BUsSVZy0NddneyqLk\n42Wey9omY9Q8WsdNQS5cbUvy0uG6WFoX7wKBgQDZ1jpW8pa0x2bZsQsm4vo+3G5CRnZlUp+XlWt2\ndDcp5dC0xD1zbs1dc0NcLeGDOTDv9FSl7hok42iHXXq8AygjEm/QcuwwQ1nC2HxmQP5holAiUs4D\nWHM8PWs3wFYPzE459EBoKTxeaeP/uWAn+he8q7d5uWvSZlEcANs/6e77eQKBgD21Ar0hfFfj7mK8\n9E0FeRZBsqK3omkfnhcYgZC11Xa2SgT1yvs2Va2n0RcdM5kncr3eBZav2GYOhhAdwyBM55XuE/sO\neokDVutNeuZ6d5fqV96TRaRBpvgfTvvRwxZ9hvKF4Vz+9wfn/JvCwANaKmegF6ejs7pvmF3whq2k\ndrZVAoGAX5YxQ5XMTD0QbMAl7/6qp6S58xNoVdfCkmkj1ZLKaHKIjS/benkKGlySVQVPexPfnkZx\np/Vv9yyphBoudiTBS9Uog66ueLYZqpgxlM/6OhYg86Gm3U2ycvMxYjBM1NFiyze21AqAhI+HX+Ot\nmraV2/guSgDgZAhukRZzeQ2RucI=\n-----END PRIVATE KEY-----";
    static final String[] NAMED_GROUPS;
    private static final Set<String> SERVER_DEFAULT_PROTOCOLS;
    static final Set<String> SUPPORTED_PROTOCOLS_SET;
    private static final boolean SUPPORTS_KEYMANAGER_FACTORY;
    private static final boolean SUPPORTS_OCSP;
    private static final boolean TLSV13_SUPPORTED;
    private static final Throwable UNAVAILABILITY_CAUSE;
    private static final boolean USE_KEYMANAGER_FACTORY;
    private static final InternalLogger logger;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0274 A[Catch: all -> 0x0278, TRY_ENTER, TryCatch #8 {all -> 0x0278, blocks: (B:187:0x0361, B:189:0x0368, B:192:0x036f, B:195:0x0376, B:198:0x037d, B:199:0x0380, B:131:0x0274, B:136:0x027f, B:139:0x0286, B:142:0x028d), top: B:249:0x0163 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x027f A[Catch: all -> 0x0278, TryCatch #8 {all -> 0x0278, blocks: (B:187:0x0361, B:189:0x0368, B:192:0x036f, B:195:0x0376, B:198:0x037d, B:199:0x0380, B:131:0x0274, B:136:0x027f, B:139:0x0286, B:142:0x028d), top: B:249:0x0163 }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0286 A[Catch: all -> 0x0278, TryCatch #8 {all -> 0x0278, blocks: (B:187:0x0361, B:189:0x0368, B:192:0x036f, B:195:0x0376, B:198:0x037d, B:199:0x0380, B:131:0x0274, B:136:0x027f, B:139:0x0286, B:142:0x028d), top: B:249:0x0163 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x028d A[Catch: all -> 0x0278, TRY_LEAVE, TryCatch #8 {all -> 0x0278, blocks: (B:187:0x0361, B:189:0x0368, B:192:0x036f, B:195:0x0376, B:198:0x037d, B:199:0x0380, B:131:0x0274, B:136:0x027f, B:139:0x0286, B:142:0x028d), top: B:249:0x0163 }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0299 A[Catch: all -> 0x02df, TryCatch #34 {all -> 0x02df, blocks: (B:128:0x026d, B:143:0x0290, B:145:0x0299, B:147:0x02b5), top: B:285:0x026d }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0368 A[Catch: all -> 0x0278, TryCatch #8 {all -> 0x0278, blocks: (B:187:0x0361, B:189:0x0368, B:192:0x036f, B:195:0x0376, B:198:0x037d, B:199:0x0380, B:131:0x0274, B:136:0x027f, B:139:0x0286, B:142:0x028d), top: B:249:0x0163 }] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x036f A[Catch: all -> 0x0278, TryCatch #8 {all -> 0x0278, blocks: (B:187:0x0361, B:189:0x0368, B:192:0x036f, B:195:0x0376, B:198:0x037d, B:199:0x0380, B:131:0x0274, B:136:0x027f, B:139:0x0286, B:142:0x028d), top: B:249:0x0163 }] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0376 A[Catch: all -> 0x0278, TryCatch #8 {all -> 0x0278, blocks: (B:187:0x0361, B:189:0x0368, B:192:0x036f, B:195:0x0376, B:198:0x037d, B:199:0x0380, B:131:0x0274, B:136:0x027f, B:139:0x0286, B:142:0x028d), top: B:249:0x0163 }] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x037d A[Catch: all -> 0x0278, TryCatch #8 {all -> 0x0278, blocks: (B:187:0x0361, B:189:0x0368, B:192:0x036f, B:195:0x0376, B:198:0x037d, B:199:0x0380, B:131:0x0274, B:136:0x027f, B:139:0x0286, B:142:0x028d), top: B:249:0x0163 }] */
    /* JADX WARN: Removed duplicated region for block: B:214:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x045b  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x046a  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0485  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x049b  */
    /* JADX WARN: Removed duplicated region for block: B:323:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01a1 A[Catch: all -> 0x0186, TryCatch #15 {all -> 0x0186, blocks: (B:63:0x016d, B:65:0x0171, B:67:0x0177, B:70:0x017f, B:75:0x0193, B:76:0x0196, B:77:0x019b, B:79:0x01a1, B:80:0x01b3), top: B:258:0x016d }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01eb A[Catch: all -> 0x01fc, TRY_LEAVE, TryCatch #11 {all -> 0x01fc, blocks: (B:86:0x01e5, B:88:0x01eb), top: B:252:0x01e5 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01ff  */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [int] */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v46 */
    /* JADX WARN: Type inference failed for: r1v47 */
    /* JADX WARN: Type inference failed for: r1v48 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    static {
        boolean z;
        ?? r12;
        boolean z2;
        boolean z3;
        ?? r13;
        InternalLogger internalLogger;
        boolean z4;
        long jNewSSL;
        long bio;
        long privateKey;
        long x509Chain;
        long bio2;
        int length;
        int i;
        boolean z5;
        PemPrivateKey pemPrivateKeyValueOf;
        boolean z6;
        boolean z7;
        String str;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean zContains;
        boolean z12;
        String str2 = "io.netty.handler.ssl.openssl.useKeyManagerFactory";
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) OpenSsl.class);
        logger = internalLoggerFactory;
        DEFAULT_NAMED_GROUPS = new String[]{"x25519", "secp256r1", "secp384r1", "secp521r1"};
        boolean z13 = false;
        boolean z14 = false;
        if (SystemPropertyUtil.getBoolean("io.netty.handler.ssl.noOpenSsl", false)) {
            th = new UnsupportedOperationException("OpenSSL was explicit disabled with -Dio.netty.handler.ssl.noOpenSsl=true");
            internalLoggerFactory.debug("netty-tcnative explicit disabled; OpenSslEngine will be unavailable.", th);
        } else {
            try {
                Class.forName("io.netty.internal.tcnative.SSLContext", false, PlatformDependent.getClassLoader(OpenSsl.class));
                th = null;
            } catch (ClassNotFoundException e) {
                th = e;
                logger.debug("netty-tcnative not in the classpath; OpenSslEngine will be unavailable.");
            }
            if (th == null) {
                try {
                    loadTcNative();
                } catch (Throwable th) {
                    th = th;
                    logger.debug("Failed to load netty-tcnative; OpenSslEngine will be unavailable, unless the application has already loaded the symbols by some other means. See https://netty.io/wiki/forked-tomcat-native.html for more information.", th);
                }
                Throwable th2 = th;
                try {
                    String str3 = SystemPropertyUtil.get("io.netty.handler.ssl.openssl.engine", null);
                    if (str3 == null) {
                        logger.debug("Initialize netty-tcnative using engine: 'default'");
                    } else {
                        logger.debug("Initialize netty-tcnative using engine: '{}'", str3);
                    }
                    initializeTcNative(str3);
                    th = null;
                } catch (Throwable th3) {
                    if (th2 == null) {
                        th2 = th3;
                    }
                    logger.debug("Failed to initialize netty-tcnative; OpenSslEngine will be unavailable. See https://netty.io/wiki/forked-tomcat-native.html for more information.", th3);
                    th = th2;
                }
            }
        }
        UNAVAILABILITY_CAUSE = th;
        CLIENT_DEFAULT_PROTOCOLS = protocols("jdk.tls.client.protocols");
        SERVER_DEFAULT_PROTOCOLS = protocols("jdk.tls.server.protocols");
        if (th != null) {
            DEFAULT_CIPHERS = Collections.EMPTY_LIST;
            Set<String> set = Collections.EMPTY_SET;
            AVAILABLE_OPENSSL_CIPHER_SUITES = set;
            AVAILABLE_JAVA_CIPHER_SUITES = set;
            AVAILABLE_CIPHER_SUITES = set;
            SUPPORTS_KEYMANAGER_FACTORY = false;
            USE_KEYMANAGER_FACTORY = false;
            SUPPORTED_PROTOCOLS_SET = set;
            SUPPORTS_OCSP = false;
            TLSV13_SUPPORTED = false;
            IS_BORINGSSL = false;
            EXTRA_SUPPORTED_TLS_1_3_CIPHERS = EmptyArrays.EMPTY_STRINGS;
            EXTRA_SUPPORTED_TLS_1_3_CIPHERS_STRING = "";
            NAMED_GROUPS = DEFAULT_NAMED_GROUPS;
            return;
        }
        logger.debug("netty-tcnative using native library: {}", SSL.versionString());
        ArrayList arrayList = new ArrayList();
        LinkedHashSet linkedHashSet = new LinkedHashSet(128);
        String[] strArr = DEFAULT_NAMED_GROUPS;
        String[] strArr2 = new String[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            strArr2[i2] = GroupsConverter.toOpenSsl(strArr[i2]);
        }
        boolean zEquals = "BoringSSL".equals(versionString());
        IS_BORINGSSL = zEquals;
        if (zEquals) {
            String[] strArr3 = {Ciphers.TLS_AES_128_GCM_SHA256, Ciphers.TLS_AES_256_GCM_SHA384, Ciphers.TLS_CHACHA20_POLY1305_SHA256};
            EXTRA_SUPPORTED_TLS_1_3_CIPHERS = strArr3;
            StringBuilder sb = new StringBuilder(128);
            int length2 = strArr3.length;
            for (int iM2213d = 0; iM2213d < length2; iM2213d = AbstractC2821a.m2213d(sb, iM2213d, 1, strArr3[iM2213d], ":")) {
            }
            sb.setLength(sb.length() - 1);
            EXTRA_SUPPORTED_TLS_1_3_CIPHERS_STRING = sb.toString();
        } else {
            EXTRA_SUPPORTED_TLS_1_3_CIPHERS = EmptyArrays.EMPTY_STRINGS;
            EXTRA_SUPPORTED_TLS_1_3_CIPHERS_STRING = "";
        }
        try {
            long jMake = SSLContext.make(63, 1);
            try {
                if (SslProvider.isTlsv13Supported(SslProvider.JDK)) {
                    try {
                        StringBuilder sb2 = new StringBuilder();
                        Iterator<String> it = SslUtils.TLSV13_CIPHERS.iterator();
                        while (it.hasNext()) {
                            String openSsl = CipherSuiteConverter.toOpenSsl(it.next(), IS_BORINGSSL);
                            if (openSsl != null) {
                                sb2.append(openSsl);
                                sb2.append(':');
                            }
                        }
                        if (sb2.length() == 0) {
                            z4 = false;
                        } else {
                            sb2.setLength(sb2.length() - 1);
                            SSLContext.setCipherSuite(jMake, sb2.toString(), true);
                            z4 = true;
                        }
                        z2 = z4;
                    } catch (Exception unused) {
                        z2 = false;
                    } catch (Throwable th4) {
                        th = th4;
                        r12 = 0;
                        z2 = false;
                        z14 = false;
                        z = false;
                        try {
                            SSLContext.free(jMake);
                            throw th;
                        } catch (Exception e2) {
                            e = e2;
                            logger.warn("Failed to get the list of available OpenSSL cipher suites.", (Throwable) e);
                            r13 = r12;
                            z3 = z2;
                            NAMED_GROUPS = strArr;
                            Set<String> setUnmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
                            AVAILABLE_OPENSSL_CIPHER_SUITES = setUnmodifiableSet;
                            LinkedHashSet linkedHashSet2 = new LinkedHashSet(setUnmodifiableSet.size() * 2);
                            while (r0.hasNext()) {
                            }
                            SslUtils.addIfSupported(linkedHashSet2, arrayList, SslUtils.DEFAULT_CIPHER_SUITES);
                            SslUtils.addIfSupported(linkedHashSet2, arrayList, SslUtils.TLSV13_CIPHER_SUITES);
                            SslUtils.addIfSupported(linkedHashSet2, arrayList, EXTRA_SUPPORTED_TLS_1_3_CIPHERS);
                            SslUtils.useFallbackCiphersIfDefaultIsEmpty(arrayList, linkedHashSet2);
                            List<String> listUnmodifiableList = Collections.unmodifiableList(arrayList);
                            DEFAULT_CIPHERS = listUnmodifiableList;
                            Set<String> setUnmodifiableSet2 = Collections.unmodifiableSet(linkedHashSet2);
                            AVAILABLE_JAVA_CIPHER_SUITES = setUnmodifiableSet2;
                            Set<String> set2 = AVAILABLE_OPENSSL_CIPHER_SUITES;
                            LinkedHashSet linkedHashSet3 = new LinkedHashSet(setUnmodifiableSet2.size() + set2.size());
                            linkedHashSet3.addAll(set2);
                            linkedHashSet3.addAll(setUnmodifiableSet2);
                            AVAILABLE_CIPHER_SUITES = linkedHashSet3;
                            SUPPORTS_KEYMANAGER_FACTORY = z14;
                            USE_KEYMANAGER_FACTORY = r13;
                            LinkedHashSet linkedHashSet4 = new LinkedHashSet(6);
                            linkedHashSet4.add(SslProtocols.SSL_v2_HELLO);
                            if (doesSupportProtocol(1, SSL.SSL_OP_NO_SSLv2)) {
                            }
                            if (doesSupportProtocol(2, SSL.SSL_OP_NO_SSLv3)) {
                            }
                            if (doesSupportProtocol(4, SSL.SSL_OP_NO_TLSv1)) {
                            }
                            if (doesSupportProtocol(8, SSL.SSL_OP_NO_TLSv1_1)) {
                            }
                            if (doesSupportProtocol(16, SSL.SSL_OP_NO_TLSv1_2)) {
                            }
                            if (z3) {
                                TLSV13_SUPPORTED = z;
                            }
                            Set<String> setUnmodifiableSet3 = Collections.unmodifiableSet(linkedHashSet4);
                            SUPPORTED_PROTOCOLS_SET = setUnmodifiableSet3;
                            SUPPORTS_OCSP = doesSupportOcsp();
                            internalLogger = logger;
                            if (internalLogger.isDebugEnabled()) {
                            }
                        }
                    }
                    try {
                        SSLContext.setCipherSuite(jMake, "ALL", false);
                        jNewSSL = SSL.newSSL(jMake, true);
                        try {
                            try {
                                String[] ciphers = SSL.getCiphers(jNewSSL);
                                length = ciphers.length;
                                i = 0;
                                while (i < length) {
                                    z = z13;
                                    try {
                                        String str4 = ciphers[i];
                                        if (str4 != null && !str4.isEmpty() && !linkedHashSet.contains(str4) && (z2 || !SslUtils.isTLSv13Cipher(str4))) {
                                            linkedHashSet.add(str4);
                                        }
                                        i++;
                                        z13 = z;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        bio2 = 0;
                                        x509Chain = 0;
                                        privateKey = 0;
                                        bio = 0;
                                        SSL.freeSSL(jNewSSL);
                                        if (bio != 0) {
                                            SSL.freeBIO(bio);
                                        }
                                        if (bio2 != 0) {
                                            SSL.freeBIO(bio2);
                                        }
                                        if (x509Chain != 0) {
                                            SSL.freeX509Chain(x509Chain);
                                        }
                                        if (privateKey != 0) {
                                            SSL.freePrivateKey(privateKey);
                                        }
                                        throw th;
                                    }
                                }
                                z = z13;
                                z5 = IS_BORINGSSL;
                                if (z5) {
                                    Collections.addAll(linkedHashSet, EXTRA_SUPPORTED_TLS_1_3_CIPHERS);
                                    Collections.addAll(linkedHashSet, "AEAD-AES128-GCM-SHA256", "AEAD-AES256-GCM-SHA384", "AEAD-CHACHA20-POLY1305-SHA256");
                                }
                                pemPrivateKeyValueOf = PemPrivateKey.valueOf(KEY.getBytes(CharsetUtil.US_ASCII));
                                try {
                                    SSLContext.setCertificateCallback(jMake, (CertificateCallback) null);
                                    bio = ReferenceCountedOpenSslContext.toBIO(ByteBufAllocator.DEFAULT, selfSignedCertificate());
                                    try {
                                        x509Chain = SSL.parseX509Chain(bio);
                                        try {
                                            bio2 = ReferenceCountedOpenSslContext.toBIO(UnpooledByteBufAllocator.DEFAULT, pemPrivateKeyValueOf.retain());
                                            try {
                                                privateKey = SSL.parsePrivateKey(bio2, (String) null);
                                                try {
                                                    SSL.setKeyMaterial(jNewSSL, x509Chain, privateKey);
                                                    try {
                                                        zContains = SystemPropertyUtil.contains("io.netty.handler.ssl.openssl.useKeyManagerFactory");
                                                    } catch (Throwable unused2) {
                                                        z10 = z;
                                                    }
                                                } catch (Error unused3) {
                                                    boolean z15 = z;
                                                    z14 = z15 ? 1 : 0;
                                                    z6 = z15;
                                                    try {
                                                        boolean z16 = z6;
                                                        try {
                                                            logger.debug("KeyManagerFactory not supported.");
                                                            try {
                                                                pemPrivateKeyValueOf.release();
                                                                z7 = z16 ? 1 : 0;
                                                                try {
                                                                    SSL.freeSSL(jNewSSL);
                                                                    if (bio != 0) {
                                                                    }
                                                                    if (bio2 != 0) {
                                                                    }
                                                                    if (x509Chain != 0) {
                                                                    }
                                                                    if (privateKey != 0) {
                                                                    }
                                                                    str = SystemPropertyUtil.get(SystemProperties.JDK_TLS_NAMED_GROUPS, null);
                                                                    if (str == null) {
                                                                    }
                                                                    strArr = strArr2;
                                                                    try {
                                                                        SSLContext.free(jMake);
                                                                        r13 = z8;
                                                                        z3 = z2;
                                                                    } catch (Exception e3) {
                                                                        e = e3;
                                                                        r12 = z8;
                                                                        logger.warn("Failed to get the list of available OpenSSL cipher suites.", (Throwable) e);
                                                                        r13 = r12;
                                                                        z3 = z2;
                                                                    }
                                                                    NAMED_GROUPS = strArr;
                                                                    Set<String> setUnmodifiableSet4 = Collections.unmodifiableSet(linkedHashSet);
                                                                    AVAILABLE_OPENSSL_CIPHER_SUITES = setUnmodifiableSet4;
                                                                    LinkedHashSet linkedHashSet22 = new LinkedHashSet(setUnmodifiableSet4.size() * 2);
                                                                    while (r0.hasNext()) {
                                                                    }
                                                                    SslUtils.addIfSupported(linkedHashSet22, arrayList, SslUtils.DEFAULT_CIPHER_SUITES);
                                                                    SslUtils.addIfSupported(linkedHashSet22, arrayList, SslUtils.TLSV13_CIPHER_SUITES);
                                                                    SslUtils.addIfSupported(linkedHashSet22, arrayList, EXTRA_SUPPORTED_TLS_1_3_CIPHERS);
                                                                    SslUtils.useFallbackCiphersIfDefaultIsEmpty(arrayList, linkedHashSet22);
                                                                    List<String> listUnmodifiableList2 = Collections.unmodifiableList(arrayList);
                                                                    DEFAULT_CIPHERS = listUnmodifiableList2;
                                                                    Set<String> setUnmodifiableSet22 = Collections.unmodifiableSet(linkedHashSet22);
                                                                    AVAILABLE_JAVA_CIPHER_SUITES = setUnmodifiableSet22;
                                                                    Set<String> set22 = AVAILABLE_OPENSSL_CIPHER_SUITES;
                                                                    LinkedHashSet linkedHashSet32 = new LinkedHashSet(setUnmodifiableSet22.size() + set22.size());
                                                                    linkedHashSet32.addAll(set22);
                                                                    linkedHashSet32.addAll(setUnmodifiableSet22);
                                                                    AVAILABLE_CIPHER_SUITES = linkedHashSet32;
                                                                    SUPPORTS_KEYMANAGER_FACTORY = z14;
                                                                    USE_KEYMANAGER_FACTORY = r13;
                                                                    LinkedHashSet linkedHashSet42 = new LinkedHashSet(6);
                                                                    linkedHashSet42.add(SslProtocols.SSL_v2_HELLO);
                                                                    if (doesSupportProtocol(1, SSL.SSL_OP_NO_SSLv2)) {
                                                                    }
                                                                    if (doesSupportProtocol(2, SSL.SSL_OP_NO_SSLv3)) {
                                                                    }
                                                                    if (doesSupportProtocol(4, SSL.SSL_OP_NO_TLSv1)) {
                                                                    }
                                                                    if (doesSupportProtocol(8, SSL.SSL_OP_NO_TLSv1_1)) {
                                                                    }
                                                                    if (doesSupportProtocol(16, SSL.SSL_OP_NO_TLSv1_2)) {
                                                                    }
                                                                    if (z3) {
                                                                    }
                                                                    Set<String> setUnmodifiableSet32 = Collections.unmodifiableSet(linkedHashSet42);
                                                                    SUPPORTED_PROTOCOLS_SET = setUnmodifiableSet32;
                                                                    SUPPORTS_OCSP = doesSupportOcsp();
                                                                    internalLogger = logger;
                                                                    if (internalLogger.isDebugEnabled()) {
                                                                    }
                                                                } catch (Throwable th6) {
                                                                    th = th6;
                                                                    r12 = z7;
                                                                    z2 = z2;
                                                                }
                                                            } catch (Throwable th7) {
                                                                th = th7;
                                                                SSL.freeSSL(jNewSSL);
                                                                if (bio != 0) {
                                                                }
                                                                if (bio2 != 0) {
                                                                }
                                                                if (x509Chain != 0) {
                                                                }
                                                                if (privateKey != 0) {
                                                                }
                                                                throw th;
                                                            }
                                                        } catch (Throwable th8) {
                                                            th = th8;
                                                            try {
                                                                pemPrivateKeyValueOf.release();
                                                                throw th;
                                                            } catch (Throwable th9) {
                                                                th = th9;
                                                                SSL.freeSSL(jNewSSL);
                                                                if (bio != 0) {
                                                                }
                                                                if (bio2 != 0) {
                                                                }
                                                                if (x509Chain != 0) {
                                                                }
                                                                if (privateKey != 0) {
                                                                }
                                                                throw th;
                                                            }
                                                        }
                                                    } catch (Throwable th10) {
                                                        th = th10;
                                                    }
                                                } catch (Throwable th11) {
                                                    th = th11;
                                                    pemPrivateKeyValueOf.release();
                                                    throw th;
                                                }
                                            } catch (Error unused4) {
                                                privateKey = 0;
                                            } catch (Throwable th12) {
                                                th = th12;
                                                privateKey = 0;
                                            }
                                        } catch (Error unused5) {
                                            bio2 = 0;
                                            privateKey = 0;
                                        } catch (Throwable th13) {
                                            th = th13;
                                            bio2 = 0;
                                            privateKey = 0;
                                        }
                                    } catch (Error unused6) {
                                        bio2 = 0;
                                        x509Chain = 0;
                                        privateKey = 0;
                                    } catch (Throwable th14) {
                                        th = th14;
                                        bio2 = 0;
                                        x509Chain = 0;
                                        privateKey = 0;
                                    }
                                } catch (Error unused7) {
                                    bio2 = 0;
                                    x509Chain = 0;
                                    privateKey = 0;
                                    bio = 0;
                                } catch (Throwable th15) {
                                    th = th15;
                                    bio2 = 0;
                                    x509Chain = 0;
                                    privateKey = 0;
                                    bio = 0;
                                }
                                if (z5) {
                                    z12 = SystemPropertyUtil.getBoolean("io.netty.handler.ssl.openssl.useKeyManagerFactory", true);
                                    if (zContains) {
                                        try {
                                            logger.info("System property 'io.netty.handler.ssl.openssl.useKeyManagerFactory' is deprecated and so will be ignored in the future");
                                        } catch (Throwable unused8) {
                                            z10 = z12;
                                            try {
                                                logger.debug("Failed to get useKeyManagerFactory system property.");
                                                z11 = z10;
                                            } catch (Error unused9) {
                                                z14 = true;
                                                z6 = z10;
                                                boolean z162 = z6;
                                                logger.debug("KeyManagerFactory not supported.");
                                                pemPrivateKeyValueOf.release();
                                                z7 = z162 ? 1 : 0;
                                                SSL.freeSSL(jNewSSL);
                                                if (bio != 0) {
                                                }
                                                if (bio2 != 0) {
                                                }
                                                if (x509Chain != 0) {
                                                }
                                                if (privateKey != 0) {
                                                }
                                                str = SystemPropertyUtil.get(SystemProperties.JDK_TLS_NAMED_GROUPS, null);
                                                if (str == null) {
                                                }
                                                strArr = strArr2;
                                                SSLContext.free(jMake);
                                                r13 = z8;
                                                z3 = z2;
                                                NAMED_GROUPS = strArr;
                                                Set<String> setUnmodifiableSet42 = Collections.unmodifiableSet(linkedHashSet);
                                                AVAILABLE_OPENSSL_CIPHER_SUITES = setUnmodifiableSet42;
                                                LinkedHashSet linkedHashSet222 = new LinkedHashSet(setUnmodifiableSet42.size() * 2);
                                                while (r0.hasNext()) {
                                                }
                                                SslUtils.addIfSupported(linkedHashSet222, arrayList, SslUtils.DEFAULT_CIPHER_SUITES);
                                                SslUtils.addIfSupported(linkedHashSet222, arrayList, SslUtils.TLSV13_CIPHER_SUITES);
                                                SslUtils.addIfSupported(linkedHashSet222, arrayList, EXTRA_SUPPORTED_TLS_1_3_CIPHERS);
                                                SslUtils.useFallbackCiphersIfDefaultIsEmpty(arrayList, linkedHashSet222);
                                                List<String> listUnmodifiableList22 = Collections.unmodifiableList(arrayList);
                                                DEFAULT_CIPHERS = listUnmodifiableList22;
                                                Set<String> setUnmodifiableSet222 = Collections.unmodifiableSet(linkedHashSet222);
                                                AVAILABLE_JAVA_CIPHER_SUITES = setUnmodifiableSet222;
                                                Set<String> set222 = AVAILABLE_OPENSSL_CIPHER_SUITES;
                                                LinkedHashSet linkedHashSet322 = new LinkedHashSet(setUnmodifiableSet222.size() + set222.size());
                                                linkedHashSet322.addAll(set222);
                                                linkedHashSet322.addAll(setUnmodifiableSet222);
                                                AVAILABLE_CIPHER_SUITES = linkedHashSet322;
                                                SUPPORTS_KEYMANAGER_FACTORY = z14;
                                                USE_KEYMANAGER_FACTORY = r13;
                                                LinkedHashSet linkedHashSet422 = new LinkedHashSet(6);
                                                linkedHashSet422.add(SslProtocols.SSL_v2_HELLO);
                                                if (doesSupportProtocol(1, SSL.SSL_OP_NO_SSLv2)) {
                                                }
                                                if (doesSupportProtocol(2, SSL.SSL_OP_NO_SSLv3)) {
                                                }
                                                if (doesSupportProtocol(4, SSL.SSL_OP_NO_TLSv1)) {
                                                }
                                                if (doesSupportProtocol(8, SSL.SSL_OP_NO_TLSv1_1)) {
                                                }
                                                if (doesSupportProtocol(16, SSL.SSL_OP_NO_TLSv1_2)) {
                                                }
                                                if (z3) {
                                                }
                                                Set<String> setUnmodifiableSet322 = Collections.unmodifiableSet(linkedHashSet422);
                                                SUPPORTED_PROTOCOLS_SET = setUnmodifiableSet322;
                                                SUPPORTS_OCSP = doesSupportOcsp();
                                                internalLogger = logger;
                                                if (internalLogger.isDebugEnabled()) {
                                                }
                                            } catch (Throwable th16) {
                                                th = th16;
                                                pemPrivateKeyValueOf.release();
                                                throw th;
                                            }
                                        }
                                    }
                                    z11 = z12;
                                    try {
                                        pemPrivateKeyValueOf.release();
                                        z14 = true;
                                        z7 = z11;
                                        SSL.freeSSL(jNewSSL);
                                        if (bio != 0) {
                                            SSL.freeBIO(bio);
                                        }
                                        if (bio2 != 0) {
                                            SSL.freeBIO(bio2);
                                        }
                                        if (x509Chain != 0) {
                                            SSL.freeX509Chain(x509Chain);
                                        }
                                        if (privateKey != 0) {
                                            SSL.freePrivateKey(privateKey);
                                        }
                                        str = SystemPropertyUtil.get(SystemProperties.JDK_TLS_NAMED_GROUPS, null);
                                        if (str == null) {
                                            String[] strArrSplit = str.split(",");
                                            LinkedHashSet linkedHashSet5 = new LinkedHashSet(strArrSplit.length);
                                            LinkedHashSet linkedHashSet6 = new LinkedHashSet(strArrSplit.length);
                                            LinkedHashSet linkedHashSet7 = new LinkedHashSet();
                                            int length3 = strArrSplit.length;
                                            z7 = z7;
                                            for (?? r14 = z; r14 < length3; r14++) {
                                                String str5 = strArrSplit[r14];
                                                String[] strArr4 = strArrSplit;
                                                String openSsl2 = GroupsConverter.toOpenSsl(str5);
                                                z9 = z7;
                                                try {
                                                    if (SSLContext.setCurvesList(jMake, new String[]{openSsl2})) {
                                                        linkedHashSet6.add(openSsl2);
                                                        linkedHashSet5.add(str5);
                                                    } else {
                                                        linkedHashSet7.add(str5);
                                                    }
                                                    strArrSplit = strArr4;
                                                    z7 = z9 ? 1 : 0;
                                                } catch (Throwable th17) {
                                                    th = th17;
                                                    r12 = z9;
                                                    z2 = z2;
                                                    SSLContext.free(jMake);
                                                    throw th;
                                                }
                                            }
                                            z9 = z7;
                                            if (linkedHashSet5.isEmpty()) {
                                                try {
                                                    logger.info("All configured namedGroups are not supported: {}. Use default: {}.", Arrays.toString(linkedHashSet7.toArray(EmptyArrays.EMPTY_STRINGS)), Arrays.toString(DEFAULT_NAMED_GROUPS));
                                                    z8 = z9;
                                                } catch (Throwable th18) {
                                                    th = th18;
                                                    strArr = strArr2;
                                                    r12 = z9;
                                                    z2 = z2;
                                                    SSLContext.free(jMake);
                                                    throw th;
                                                }
                                            } else {
                                                String[] strArr5 = EmptyArrays.EMPTY_STRINGS;
                                                String[] strArr6 = (String[]) linkedHashSet5.toArray(strArr5);
                                                if (linkedHashSet7.isEmpty()) {
                                                    logger.info("Using configured namedGroups -D 'jdk.tls.namedGroup': {} ", Arrays.toString(strArr6));
                                                } else {
                                                    logger.info("Using supported configured namedGroups: {}. Unsupported namedGroups: {}. ", Arrays.toString(strArr6), Arrays.toString(linkedHashSet7.toArray(strArr5)));
                                                }
                                                strArr2 = (String[]) linkedHashSet6.toArray(strArr5);
                                                z8 = z9;
                                            }
                                        } else {
                                            z8 = z7 ? 1 : 0;
                                        }
                                        strArr = strArr2;
                                        SSLContext.free(jMake);
                                        r13 = z8;
                                        z3 = z2;
                                    } catch (Throwable th19) {
                                        th = th19;
                                        SSL.freeSSL(jNewSSL);
                                        if (bio != 0) {
                                        }
                                        if (bio2 != 0) {
                                        }
                                        if (x509Chain != 0) {
                                        }
                                        if (privateKey != 0) {
                                        }
                                        throw th;
                                    }
                                } else {
                                    if (zContains) {
                                        try {
                                            logger.info("System property 'io.netty.handler.ssl.openssl.useKeyManagerFactory' is deprecated and will be ignored when using BoringSSL");
                                        } catch (Throwable unused10) {
                                            z10 = true;
                                            logger.debug("Failed to get useKeyManagerFactory system property.");
                                            z11 = z10;
                                        }
                                    }
                                    z12 = true;
                                    z11 = z12;
                                    pemPrivateKeyValueOf.release();
                                    z14 = true;
                                    z7 = z11;
                                    SSL.freeSSL(jNewSSL);
                                    if (bio != 0) {
                                    }
                                    if (bio2 != 0) {
                                    }
                                    if (x509Chain != 0) {
                                    }
                                    if (privateKey != 0) {
                                    }
                                    str = SystemPropertyUtil.get(SystemProperties.JDK_TLS_NAMED_GROUPS, null);
                                    if (str == null) {
                                    }
                                    strArr = strArr2;
                                    SSLContext.free(jMake);
                                    r13 = z8;
                                    z3 = z2;
                                }
                            } catch (Throwable th20) {
                                th = th20;
                                r12 = str2;
                                z2 = z2;
                            }
                        } catch (Throwable th21) {
                            th = th21;
                            z = false;
                        }
                    } catch (Throwable th22) {
                        th = th22;
                        z = false;
                        r12 = 0;
                        z14 = false;
                        z2 = z2;
                    }
                } else {
                    z2 = false;
                    SSLContext.setCipherSuite(jMake, "ALL", false);
                    jNewSSL = SSL.newSSL(jMake, true);
                    String[] ciphers2 = SSL.getCiphers(jNewSSL);
                    length = ciphers2.length;
                    i = 0;
                    while (i < length) {
                    }
                    z = z13;
                    z5 = IS_BORINGSSL;
                    if (z5) {
                    }
                    pemPrivateKeyValueOf = PemPrivateKey.valueOf(KEY.getBytes(CharsetUtil.US_ASCII));
                    SSLContext.setCertificateCallback(jMake, (CertificateCallback) null);
                    bio = ReferenceCountedOpenSslContext.toBIO(ByteBufAllocator.DEFAULT, selfSignedCertificate());
                    x509Chain = SSL.parseX509Chain(bio);
                    bio2 = ReferenceCountedOpenSslContext.toBIO(UnpooledByteBufAllocator.DEFAULT, pemPrivateKeyValueOf.retain());
                    privateKey = SSL.parsePrivateKey(bio2, (String) null);
                    SSL.setKeyMaterial(jNewSSL, x509Chain, privateKey);
                    zContains = SystemPropertyUtil.contains("io.netty.handler.ssl.openssl.useKeyManagerFactory");
                    if (z5) {
                    }
                }
            } catch (Throwable th23) {
                th = th23;
                z = false;
                r12 = 0;
                z2 = false;
                z14 = false;
            }
        } catch (Exception e5) {
            e = e5;
            z = false;
            r12 = 0;
            z2 = false;
            z14 = false;
        }
        NAMED_GROUPS = strArr;
        Set<String> setUnmodifiableSet422 = Collections.unmodifiableSet(linkedHashSet);
        AVAILABLE_OPENSSL_CIPHER_SUITES = setUnmodifiableSet422;
        LinkedHashSet linkedHashSet2222 = new LinkedHashSet(setUnmodifiableSet422.size() * 2);
        for (String str6 : setUnmodifiableSet422) {
            if (SslUtils.isTLSv13Cipher(str6)) {
                linkedHashSet2222.add(str6);
            } else {
                linkedHashSet2222.add(CipherSuiteConverter.toJava(str6, "TLS"));
                linkedHashSet2222.add(CipherSuiteConverter.toJava(str6, "SSL"));
            }
        }
        SslUtils.addIfSupported(linkedHashSet2222, arrayList, SslUtils.DEFAULT_CIPHER_SUITES);
        SslUtils.addIfSupported(linkedHashSet2222, arrayList, SslUtils.TLSV13_CIPHER_SUITES);
        SslUtils.addIfSupported(linkedHashSet2222, arrayList, EXTRA_SUPPORTED_TLS_1_3_CIPHERS);
        SslUtils.useFallbackCiphersIfDefaultIsEmpty(arrayList, linkedHashSet2222);
        List<String> listUnmodifiableList222 = Collections.unmodifiableList(arrayList);
        DEFAULT_CIPHERS = listUnmodifiableList222;
        Set<String> setUnmodifiableSet2222 = Collections.unmodifiableSet(linkedHashSet2222);
        AVAILABLE_JAVA_CIPHER_SUITES = setUnmodifiableSet2222;
        Set<String> set2222 = AVAILABLE_OPENSSL_CIPHER_SUITES;
        LinkedHashSet linkedHashSet3222 = new LinkedHashSet(setUnmodifiableSet2222.size() + set2222.size());
        linkedHashSet3222.addAll(set2222);
        linkedHashSet3222.addAll(setUnmodifiableSet2222);
        AVAILABLE_CIPHER_SUITES = linkedHashSet3222;
        SUPPORTS_KEYMANAGER_FACTORY = z14;
        USE_KEYMANAGER_FACTORY = r13;
        LinkedHashSet linkedHashSet4222 = new LinkedHashSet(6);
        linkedHashSet4222.add(SslProtocols.SSL_v2_HELLO);
        if (doesSupportProtocol(1, SSL.SSL_OP_NO_SSLv2)) {
            linkedHashSet4222.add("SSLv2");
        }
        if (doesSupportProtocol(2, SSL.SSL_OP_NO_SSLv3)) {
            linkedHashSet4222.add(SslProtocols.SSL_v3);
        }
        if (doesSupportProtocol(4, SSL.SSL_OP_NO_TLSv1)) {
            linkedHashSet4222.add(SslProtocols.TLS_v1);
        }
        if (doesSupportProtocol(8, SSL.SSL_OP_NO_TLSv1_1)) {
            linkedHashSet4222.add(SslProtocols.TLS_v1_1);
        }
        if (doesSupportProtocol(16, SSL.SSL_OP_NO_TLSv1_2)) {
            linkedHashSet4222.add(SslProtocols.TLS_v1_2);
        }
        if (z3 || !doesSupportProtocol(32, SSL.SSL_OP_NO_TLSv1_3)) {
            TLSV13_SUPPORTED = z;
        } else {
            linkedHashSet4222.add(SslProtocols.TLS_v1_3);
            TLSV13_SUPPORTED = true;
        }
        Set<String> setUnmodifiableSet3222 = Collections.unmodifiableSet(linkedHashSet4222);
        SUPPORTED_PROTOCOLS_SET = setUnmodifiableSet3222;
        SUPPORTS_OCSP = doesSupportOcsp();
        internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            return;
        }
        internalLogger.debug("Supported protocols (OpenSSL): {} ", setUnmodifiableSet3222);
        internalLogger.debug("Default cipher suites (OpenSSL): {}", listUnmodifiableList222);
    }

    private OpenSsl() {
    }

    @Deprecated
    public static Set<String> availableCipherSuites() {
        return availableOpenSslCipherSuites();
    }

    public static Set<String> availableJavaCipherSuites() {
        return AVAILABLE_JAVA_CIPHER_SUITES;
    }

    public static Set<String> availableOpenSslCipherSuites() {
        return AVAILABLE_OPENSSL_CIPHER_SUITES;
    }

    public static String checkTls13Ciphers(InternalLogger internalLogger, String str) {
        boolean z;
        if (IS_BORINGSSL && !str.isEmpty()) {
            String[] strArr = EXTRA_SUPPORTED_TLS_1_3_CIPHERS;
            HashSet hashSet = new HashSet(strArr.length);
            Collections.addAll(hashSet, strArr);
            for (String str2 : str.split(":")) {
                if (hashSet.isEmpty() || (!hashSet.remove(str2) && !hashSet.remove(CipherSuiteConverter.toJava(str2, "TLS")))) {
                    z = true;
                    break;
                }
            }
            z = false;
            if ((!hashSet.isEmpty()) | z) {
                if (internalLogger.isInfoEnabled()) {
                    StringBuilder sb = new StringBuilder(128);
                    for (String str3 : str.split(":")) {
                        sb.append(CipherSuiteConverter.toJava(str3, "TLS"));
                        sb.append(":");
                    }
                    sb.setLength(sb.length() - 1);
                    internalLogger.info("BoringSSL doesn't allow to enable or disable TLSv1.3 ciphers explicitly. Provided TLSv1.3 ciphers: '{}', default TLSv1.3 ciphers that will be used: '{}'.", sb, EXTRA_SUPPORTED_TLS_1_3_CIPHERS_STRING);
                }
                return EXTRA_SUPPORTED_TLS_1_3_CIPHERS_STRING;
            }
        }
        return str;
    }

    public static String[] defaultProtocols(boolean z) {
        Set<String> set = z ? CLIENT_DEFAULT_PROTOCOLS : SERVER_DEFAULT_PROTOCOLS;
        if (set == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(set.size());
        for (String str : set) {
            if (SUPPORTED_PROTOCOLS_SET.contains(str)) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    private static boolean doesSupportOcsp() throws Throwable {
        long jMake;
        if (version() >= 268443648) {
            try {
                jMake = SSLContext.make(16, 1);
                try {
                    SSLContext.enableOcsp(jMake, false);
                    if (jMake != -1) {
                        SSLContext.free(jMake);
                    }
                    return true;
                } catch (Exception unused) {
                    if (jMake != -1) {
                        SSLContext.free(jMake);
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    if (jMake != -1) {
                        SSLContext.free(jMake);
                    }
                    throw th;
                }
            } catch (Exception unused2) {
                jMake = -1;
            } catch (Throwable th2) {
                th = th2;
                jMake = -1;
            }
        }
        return false;
    }

    private static boolean doesSupportProtocol(int i, int i2) {
        if (i2 == 0) {
            return false;
        }
        try {
            long jMake = SSLContext.make(i, 2);
            if (jMake != -1) {
                SSLContext.free(jMake);
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void ensureAvailability() {
        Throwable th = UNAVAILABILITY_CAUSE;
        if (th != null) {
            throw ((Error) new UnsatisfiedLinkError("failed to load the required native library").initCause(th));
        }
    }

    private static boolean initializeTcNative(String str) {
        return Library.initialize("provided", str);
    }

    @Deprecated
    public static boolean isAlpnSupported() {
        return ((long) version()) >= 268443648;
    }

    public static boolean isAvailable() {
        return UNAVAILABILITY_CAUSE == null;
    }

    public static boolean isBoringSSL() {
        return IS_BORINGSSL;
    }

    public static boolean isCipherSuiteAvailable(String str) {
        String openSsl = CipherSuiteConverter.toOpenSsl(str, IS_BORINGSSL);
        if (openSsl != null) {
            str = openSsl;
        }
        return AVAILABLE_OPENSSL_CIPHER_SUITES.contains(str);
    }

    public static boolean isOcspSupported() {
        return SUPPORTS_OCSP;
    }

    public static boolean isOptionSupported(SslContextOption<?> sslContextOption) {
        if (isAvailable()) {
            if (sslContextOption == OpenSslContextOption.USE_TASKS) {
                return true;
            }
            if (isBoringSSL()) {
                return sslContextOption == OpenSslContextOption.ASYNC_PRIVATE_KEY_METHOD || sslContextOption == OpenSslContextOption.PRIVATE_KEY_METHOD || sslContextOption == OpenSslContextOption.CERTIFICATE_COMPRESSION_ALGORITHMS || sslContextOption == OpenSslContextOption.TLS_FALSE_START || sslContextOption == OpenSslContextOption.MAX_CERTIFICATE_LIST_BYTES;
            }
        }
        return false;
    }

    public static boolean isSessionCacheSupported() {
        return ((long) version()) >= 269484032;
    }

    public static boolean isTlsv13Supported() {
        return TLSV13_SUPPORTED;
    }

    private static void loadTcNative() {
        String strNormalizedOs = PlatformDependent.normalizedOs();
        String strNormalizedArch = PlatformDependent.normalizedArch();
        LinkedHashSet linkedHashSet = new LinkedHashSet(5);
        if ("linux".equals(strNormalizedOs)) {
            Iterator<String> it = PlatformDependent.normalizedLinuxClassifiers().iterator();
            while (it.hasNext()) {
                linkedHashSet.add("netty_tcnative_" + strNormalizedOs + '_' + strNormalizedArch + "_" + it.next());
            }
            linkedHashSet.add("netty_tcnative_" + strNormalizedOs + '_' + strNormalizedArch);
            linkedHashSet.add("netty_tcnative_" + strNormalizedOs + '_' + strNormalizedArch + "_fedora");
        } else {
            linkedHashSet.add("netty_tcnative_" + strNormalizedOs + '_' + strNormalizedArch);
        }
        linkedHashSet.add("netty_tcnative_" + strNormalizedArch);
        linkedHashSet.add("netty_tcnative");
        NativeLibraryLoader.loadFirstAvailable(PlatformDependent.getClassLoader(SSLContext.class), (String[]) linkedHashSet.toArray(new String[0]));
    }

    public static long memoryAddress(ByteBuf byteBuf) {
        return byteBuf.hasMemoryAddress() ? byteBuf.memoryAddress() : Buffer.address(byteBuf.internalNioBuffer(0, byteBuf.readableBytes()));
    }

    private static Set<String> protocols(String str) {
        HashSet hashSet = null;
        String str2 = SystemPropertyUtil.get(str, null);
        if (str2 != null) {
            hashSet = new HashSet();
            for (String str3 : str2.split(",")) {
                hashSet.add(str3.trim());
            }
        }
        return hashSet;
    }

    public static void releaseIfNeeded(ReferenceCounted referenceCounted) {
        if (referenceCounted.refCnt() > 0) {
            ReferenceCountUtil.safeRelease(referenceCounted);
        }
    }

    public static X509Certificate selfSignedCertificate() {
        return (X509Certificate) SslContext.X509_CERT_FACTORY.generateCertificate(new ByteArrayInputStream(CERT.getBytes(CharsetUtil.US_ASCII)));
    }

    @Deprecated
    public static boolean supportsHostnameValidation() {
        return isAvailable();
    }

    public static boolean supportsKeyManagerFactory() {
        return SUPPORTS_KEYMANAGER_FACTORY;
    }

    public static Throwable unavailabilityCause() {
        return UNAVAILABILITY_CAUSE;
    }

    public static boolean useKeyManagerFactory() {
        return USE_KEYMANAGER_FACTORY;
    }

    public static int version() {
        if (isAvailable()) {
            return SSL.version();
        }
        return -1;
    }

    public static String versionString() {
        if (isAvailable()) {
            return SSL.versionString();
        }
        return null;
    }
}
