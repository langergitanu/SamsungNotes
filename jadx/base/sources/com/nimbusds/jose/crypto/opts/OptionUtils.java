package com.nimbusds.jose.crypto.opts;

import com.nimbusds.jose.JWSSignerOption;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class OptionUtils {
    public static <T extends JWSSignerOption> boolean optionIsPresent(Set<JWSSignerOption> set, Class<T> cls) {
        if (set != null && !set.isEmpty()) {
            Iterator<JWSSignerOption> it = set.iterator();
            while (it.hasNext()) {
                if (it.next().getClass().isAssignableFrom(cls)) {
                    return true;
                }
            }
        }
        return false;
    }
}
