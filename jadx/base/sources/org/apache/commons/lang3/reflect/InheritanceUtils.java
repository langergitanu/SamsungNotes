package org.apache.commons.lang3.reflect;

import org.apache.commons.lang3.BooleanUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class InheritanceUtils {
    @Deprecated
    public InheritanceUtils() {
    }

    public static int distance(Class<?> cls, Class<?> cls2) {
        if (cls != null && cls2 != null) {
            if (cls.equals(cls2)) {
                return 0;
            }
            Class<? super Object> superclass = cls.getSuperclass();
            int integer = BooleanUtils.toInteger(cls2.equals(superclass));
            if (integer == 1) {
                return integer;
            }
            int iDistance = distance(superclass, cls2) + integer;
            if (iDistance > 0) {
                return iDistance + 1;
            }
        }
        return -1;
    }
}
