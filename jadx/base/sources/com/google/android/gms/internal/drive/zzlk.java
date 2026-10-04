package com.google.android.gms.internal.drive;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public final class zzlk<K, V> extends LinkedHashMap<K, V> {
    private static final zzlk zzty;
    private boolean zznh;

    static {
        zzlk zzlkVar = new zzlk();
        zzty = zzlkVar;
        zzlkVar.zznh = false;
    }

    private zzlk() {
        this.zznh = true;
    }

    public static <K, V> zzlk<K, V> zzdw() {
        return zzty;
    }

    private final void zzdy() {
        if (!this.zznh) {
            throw new UnsupportedOperationException();
        }
    }

    private static int zzg(Object obj) {
        if (obj instanceof byte[]) {
            return zzkm.hashCode((byte[]) obj);
        }
        if (obj instanceof zzkn) {
            throw new UnsupportedOperationException();
        }
        return obj.hashCode();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        zzdy();
        super.clear();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.EMPTY_SET : super.entrySet();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005c A[RETURN] */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean equals(Object obj) {
        boolean z;
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this == map) {
                z = true;
                if (z) {
                    return true;
                }
            } else {
                if (size() == map.size()) {
                    for (Map.Entry<K, V> entry : entrySet()) {
                        if (map.containsKey(entry.getKey())) {
                            V value = entry.getValue();
                            Object obj2 = map.get(entry.getKey());
                            if (!(((value instanceof byte[]) && (obj2 instanceof byte[])) ? Arrays.equals((byte[]) value, (byte[]) obj2) : value.equals(obj2))) {
                            }
                        }
                    }
                    z = true;
                    if (z) {
                    }
                }
                z = false;
                if (z) {
                }
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int iZzg = 0;
        for (Map.Entry<K, V> entry : entrySet()) {
            iZzg += zzg(entry.getValue()) ^ zzg(entry.getKey());
        }
        return iZzg;
    }

    public final boolean isMutable() {
        return this.zznh;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V put(K k, V v) {
        zzdy();
        zzkm.checkNotNull(k);
        zzkm.checkNotNull(v);
        return (V) super.put(k, v);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        zzdy();
        for (K k : map.keySet()) {
            zzkm.checkNotNull(k);
            zzkm.checkNotNull(map.get(k));
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        zzdy();
        return (V) super.remove(obj);
    }

    public final void zza(zzlk<K, V> zzlkVar) {
        zzdy();
        if (zzlkVar.isEmpty()) {
            return;
        }
        putAll(zzlkVar);
    }

    public final void zzbp() {
        this.zznh = false;
    }

    public final zzlk<K, V> zzdx() {
        return isEmpty() ? new zzlk<>() : new zzlk<>(this);
    }

    private zzlk(Map<K, V> map) {
        super(map);
        this.zznh = true;
    }
}
