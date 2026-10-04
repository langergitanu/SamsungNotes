package io.netty.handler.ssl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.AbstractC12991c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class GroupsConverter {
    private static final Map<String, String> mappings;

    static {
        HashMap mapM13996q = AbstractC12991c.m13996q("secp224r1", "P-224", "prime256v1", "P-256");
        mapM13996q.put("secp256r1", "P-256");
        mapM13996q.put("secp384r1", "P-384");
        mapM13996q.put("secp521r1", "P-521");
        mapM13996q.put("x25519", "X25519");
        mappings = Collections.unmodifiableMap(mapM13996q);
    }

    private GroupsConverter() {
    }

    public static String toOpenSsl(String str) {
        String str2 = mappings.get(str);
        return str2 == null ? str : str2;
    }
}
