package io.netty.handler.codec.http2;

import io.netty.handler.ssl.Ciphers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class Http2SecurityUtil {
    public static final List<String> CIPHERS;
    private static final List<String> CIPHERS_JAVA_MOZILLA_MODERN_SECURITY;

    static {
        List<String> listUnmodifiableList = Collections.unmodifiableList(Arrays.asList(Ciphers.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, Ciphers.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, Ciphers.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, Ciphers.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, Ciphers.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, Ciphers.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, Ciphers.TLS_AES_128_GCM_SHA256, Ciphers.TLS_AES_256_GCM_SHA384, Ciphers.TLS_CHACHA20_POLY1305_SHA256));
        CIPHERS_JAVA_MOZILLA_MODERN_SECURITY = listUnmodifiableList;
        CIPHERS = Collections.unmodifiableList(new ArrayList(listUnmodifiableList));
    }

    private Http2SecurityUtil() {
    }
}
