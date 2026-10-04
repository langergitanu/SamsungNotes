package com.google.android.gms.internal.meet_coactivities;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
class zzva extends AbstractMap {
    private List zza = Collections.EMPTY_LIST;
    private Map zzb;
    private boolean zzc;
    private volatile zzuy zzd;
    private Map zze;

    private zzva() {
        Map map = Collections.EMPTY_MAP;
        this.zzb = map;
        this.zze = map;
    }

    private final int zzk(Comparable comparable) {
        int size = this.zza.size();
        int i = size - 1;
        int i2 = 0;
        if (i >= 0) {
            int iCompareTo = comparable.compareTo(((zzuu) this.zza.get(i)).zza());
            if (iCompareTo > 0) {
                return -(size + 1);
            }
            if (iCompareTo == 0) {
                return i;
            }
        }
        while (i2 <= i) {
            int i4 = (i2 + i) / 2;
            int iCompareTo2 = comparable.compareTo(((zzuu) this.zza.get(i4)).zza());
            if (iCompareTo2 < 0) {
                i = i4 - 1;
            } else {
                if (iCompareTo2 <= 0) {
                    return i4;
                }
                i2 = i4 + 1;
            }
        }
        return -(i2 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object zzl(int i) {
        zzn();
        Object value = ((zzuu) this.zza.remove(i)).getValue();
        if (!this.zzb.isEmpty()) {
            Iterator it = zzm().entrySet().iterator();
            List list = this.zza;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new zzuu(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return value;
    }

    private final SortedMap zzm() {
        zzn();
        if (this.zzb.isEmpty() && !(this.zzb instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzb = treeMap;
            this.zze = treeMap.descendingMap();
        }
        return (SortedMap) this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzn() {
        if (this.zzc) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        zzn();
        if (!this.zza.isEmpty()) {
            this.zza.clear();
        }
        if (this.zzb.isEmpty()) {
            return;
        }
        this.zzb.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zzk(comparable) >= 0 || this.zzb.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.zzd == null) {
            this.zzd = new zzuy(this, null);
        }
        return this.zzd;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzva)) {
            return super.equals(obj);
        }
        zzva zzvaVar = (zzva) obj;
        int size = size();
        if (size != zzvaVar.size()) {
            return false;
        }
        int iZzb = zzb();
        if (iZzb != zzvaVar.zzb()) {
            return entrySet().equals(zzvaVar.entrySet());
        }
        for (int i = 0; i < iZzb; i++) {
            if (!zzg(i).equals(zzvaVar.zzg(i))) {
                return false;
            }
        }
        if (iZzb != size) {
            return this.zzb.equals(zzvaVar.zzb);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iZzk = zzk(comparable);
        return iZzk >= 0 ? ((zzuu) this.zza.get(iZzk)).getValue() : this.zzb.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int iZzb = zzb();
        int iHashCode = 0;
        for (int i = 0; i < iZzb; i++) {
            iHashCode += ((zzuu) this.zza.get(i)).hashCode();
        }
        return this.zzb.size() > 0 ? this.zzb.hashCode() + iHashCode : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        zzn();
        Comparable comparable = (Comparable) obj;
        int iZzk = zzk(comparable);
        if (iZzk >= 0) {
            return zzl(iZzk);
        }
        if (this.zzb.isEmpty()) {
            return null;
        }
        return this.zzb.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.zzb.size() + this.zza.size();
    }

    public void zza() {
        if (this.zzc) {
            return;
        }
        this.zzb = this.zzb.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.zzb);
        this.zze = this.zze.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.zze);
        this.zzc = true;
    }

    public final int zzb() {
        return this.zza.size();
    }

    public final Iterable zzc() {
        return this.zzb.isEmpty() ? Collections.EMPTY_SET : this.zzb.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        zzn();
        int iZzk = zzk(comparable);
        if (iZzk >= 0) {
            return ((zzuu) this.zza.get(iZzk)).setValue(obj);
        }
        zzn();
        if (this.zza.isEmpty() && !(this.zza instanceof ArrayList)) {
            this.zza = new ArrayList(16);
        }
        int i = -(iZzk + 1);
        if (i >= 16) {
            return zzm().put(comparable, obj);
        }
        if (this.zza.size() == 16) {
            zzuu zzuuVar = (zzuu) this.zza.remove(15);
            zzm().put(zzuuVar.zza(), zzuuVar.getValue());
        }
        this.zza.add(i, new zzuu(this, comparable, obj));
        return null;
    }

    public final Map.Entry zzg(int i) {
        return (Map.Entry) this.zza.get(i);
    }

    public final boolean zzj() {
        return this.zzc;
    }

    public /* synthetic */ zzva(zzuz zzuzVar) {
        Map map = Collections.EMPTY_MAP;
        this.zzb = map;
        this.zze = map;
    }
}
