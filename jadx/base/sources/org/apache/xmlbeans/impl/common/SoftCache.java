package org.apache.xmlbeans.impl.common;

import java.lang.ref.SoftReference;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SoftCache {
    private HashMap map = new HashMap();

    public Object get(Object obj) {
        SoftReference softReference = (SoftReference) this.map.get(obj);
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public Object put(Object obj, Object obj2) {
        SoftReference softReference = (SoftReference) this.map.put(obj, new SoftReference(obj2));
        if (softReference == null) {
            return null;
        }
        Object obj3 = softReference.get();
        softReference.clear();
        return obj3;
    }

    public Object remove(Object obj) {
        SoftReference softReference = (SoftReference) this.map.remove(obj);
        if (softReference == null) {
            return null;
        }
        Object obj2 = softReference.get();
        softReference.clear();
        return obj2;
    }
}
