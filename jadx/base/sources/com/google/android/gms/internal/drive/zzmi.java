package com.google.android.gms.internal.drive;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes5.dex */
class zzmi<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zzot;
    private final int zzvd;
    private List<zzmp> zzve;
    private Map<K, V> zzvf;
    private volatile zzmr zzvg;
    private Map<K, V> zzvh;
    private volatile zzml zzvi;

    private zzmi(int i) {
        this.zzvd = i;
        this.zzve = Collections.EMPTY_LIST;
        Map<K, V> map = Collections.EMPTY_MAP;
        this.zzvf = map;
        this.zzvh = map;
    }

    public static <FieldDescriptorType extends zzkd<FieldDescriptorType>> zzmi<FieldDescriptorType, Object> zzav(int i) {
        return new zzmj(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V zzax(int i) {
        zzeu();
        V v = (V) this.zzve.remove(i).getValue();
        if (!this.zzvf.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = zzev().entrySet().iterator();
            this.zzve.add(new zzmp(this, it.next()));
            it.remove();
        }
        return v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzeu() {
        if (this.zzot) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzev() {
        zzeu();
        if (this.zzvf.isEmpty() && !(this.zzvf instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzvf = treeMap;
            this.zzvh = treeMap.descendingMap();
        }
        return (SortedMap) this.zzvf;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        zzeu();
        if (!this.zzve.isEmpty()) {
            this.zzve.clear();
        }
        if (this.zzvf.isEmpty()) {
            return;
        }
        this.zzvf.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza(comparable) >= 0 || this.zzvf.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zzvg == null) {
            this.zzvg = new zzmr(this, null);
        }
        return this.zzvg;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzmi)) {
            return super.equals(obj);
        }
        zzmi zzmiVar = (zzmi) obj;
        int size = size();
        if (size != zzmiVar.size()) {
            return false;
        }
        int iZzer = zzer();
        if (iZzer != zzmiVar.zzer()) {
            return entrySet().equals(zzmiVar.entrySet());
        }
        for (int i = 0; i < iZzer; i++) {
            if (!zzaw(i).equals(zzmiVar.zzaw(i))) {
                return false;
            }
        }
        if (iZzer != size) {
            return this.zzvf.equals(zzmiVar.zzvf);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iZza = zza(comparable);
        return iZza >= 0 ? (V) this.zzve.get(iZza).getValue() : this.zzvf.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iZzer = zzer();
        int iHashCode = 0;
        for (int i = 0; i < iZzer; i++) {
            iHashCode += this.zzve.get(i).hashCode();
        }
        return this.zzvf.size() > 0 ? this.zzvf.hashCode() + iHashCode : iHashCode;
    }

    public final boolean isImmutable() {
        return this.zzot;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        zzeu();
        Comparable comparable = (Comparable) obj;
        int iZza = zza(comparable);
        if (iZza >= 0) {
            return zzax(iZza);
        }
        if (this.zzvf.isEmpty()) {
            return null;
        }
        return this.zzvf.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.zzvf.size() + this.zzve.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final V put(K k, V v) {
        zzeu();
        int iZza = zza(k);
        if (iZza >= 0) {
            return (V) this.zzve.get(iZza).setValue(v);
        }
        zzeu();
        if (this.zzve.isEmpty() && !(this.zzve instanceof ArrayList)) {
            this.zzve = new ArrayList(this.zzvd);
        }
        int i = -(iZza + 1);
        if (i >= this.zzvd) {
            return zzev().put(k, v);
        }
        int size = this.zzve.size();
        int i2 = this.zzvd;
        if (size == i2) {
            zzmp zzmpVarRemove = this.zzve.remove(i2 - 1);
            zzev().put((Comparable) zzmpVarRemove.getKey(), zzmpVarRemove.getValue());
        }
        this.zzve.add(i, new zzmp(this, k, v));
        return null;
    }

    public final Map.Entry<K, V> zzaw(int i) {
        return this.zzve.get(i);
    }

    public void zzbp() {
        if (this.zzot) {
            return;
        }
        this.zzvf = this.zzvf.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.zzvf);
        this.zzvh = this.zzvh.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.zzvh);
        this.zzot = true;
    }

    public final int zzer() {
        return this.zzve.size();
    }

    public final Iterable<Map.Entry<K, V>> zzes() {
        return this.zzvf.isEmpty() ? zzmm.zzex() : this.zzvf.entrySet();
    }

    public final Set<Map.Entry<K, V>> zzet() {
        if (this.zzvi == null) {
            this.zzvi = new zzml(this, null);
        }
        return this.zzvi;
    }

    public /* synthetic */ zzmi(int i, zzmj zzmjVar) {
        this(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int zza(K k) {
        int i;
        int i2;
        int size = this.zzve.size();
        int i4 = size - 1;
        if (i4 < 0) {
            i = 0;
            while (i <= i4) {
                int i5 = (i + i4) / 2;
                int iCompareTo = k.compareTo((Comparable) this.zzve.get(i5).getKey());
                if (iCompareTo < 0) {
                    i4 = i5 - 1;
                } else {
                    if (iCompareTo <= 0) {
                        return i5;
                    }
                    i = i5 + 1;
                }
            }
            i2 = i + 1;
        } else {
            int iCompareTo2 = k.compareTo((Comparable) this.zzve.get(i4).getKey());
            if (iCompareTo2 > 0) {
                i2 = size + 1;
            } else {
                if (iCompareTo2 == 0) {
                    return i4;
                }
                i = 0;
                while (i <= i4) {
                }
                i2 = i + 1;
            }
        }
        return -i2;
    }
}
