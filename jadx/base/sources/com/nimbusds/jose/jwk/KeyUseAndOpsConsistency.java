package com.nimbusds.jose.jwk;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
class KeyUseAndOpsConsistency {
    static final Map<KeyUse, Set<KeyOperation>> MAP;

    static {
        HashMap map = new HashMap();
        map.put(KeyUse.SIGNATURE, new HashSet(Arrays.asList(KeyOperation.SIGN, KeyOperation.VERIFY)));
        map.put(KeyUse.ENCRYPTION, new HashSet(Arrays.asList(KeyOperation.ENCRYPT, KeyOperation.DECRYPT, KeyOperation.WRAP_KEY, KeyOperation.UNWRAP_KEY)));
        MAP = Collections.unmodifiableMap(map);
    }

    public static boolean areConsistent(KeyUse keyUse, Set<KeyOperation> set) {
        if (keyUse != null && set != null) {
            Map<KeyUse, Set<KeyOperation>> map = MAP;
            if (map.containsKey(keyUse) && !map.get(keyUse).containsAll(set)) {
                return false;
            }
        }
        return true;
    }
}
