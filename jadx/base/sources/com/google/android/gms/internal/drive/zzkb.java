package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzkd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
final class zzkb<FieldDescriptorType extends zzkd<FieldDescriptorType>> {
    private static final zzkb zzov = new zzkb(true);
    private boolean zzot;
    private boolean zzou = false;
    final zzmi<FieldDescriptorType, Object> zzos = zzmi.zzav(16);

    private zzkb() {
    }

    private final Object zza(FieldDescriptorType fielddescriptortype) {
        Object obj = this.zzos.get(fielddescriptortype);
        return obj instanceof zzkt ? zzkt.zzdp() : obj;
    }

    private static boolean zzb(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.zzcr() == zznr.MESSAGE) {
            if (key.zzcs()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((zzlq) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (!(value instanceof zzlq)) {
                    if (value instanceof zzkt) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
                if (!((zzlq) value).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    private final void zzc(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzkt) {
            value = zzkt.zzdp();
        }
        if (key.zzcs()) {
            Object objZza = zza(key);
            if (objZza == null) {
                objZza = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objZza).add(zze(it.next()));
            }
            this.zzos.put(key, objZza);
            return;
        }
        if (key.zzcr() != zznr.MESSAGE) {
            this.zzos.put(key, zze(value));
            return;
        }
        Object objZza2 = zza(key);
        if (objZza2 == null) {
            this.zzos.put(key, zze(value));
        } else {
            this.zzos.put(key, objZza2 instanceof zzlx ? key.zza((zzlx) objZza2, (zzlx) value) : key.zza(((zzlq) objZza2).zzcy(), (zzlq) value).zzdf());
        }
    }

    public static <T extends zzkd<T>> zzkb<T> zzcn() {
        return zzov;
    }

    private static int zzd(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        return (key.zzcr() != zznr.MESSAGE || key.zzcs() || key.zzct()) ? zzb((zzkd<?>) key, value) : value instanceof zzkt ? zzjr.zzb(entry.getKey().zzcp(), (zzkt) value) : zzjr.zzb(entry.getKey().zzcp(), (zzlq) value);
    }

    private static Object zze(Object obj) {
        if (obj instanceof zzlx) {
            return ((zzlx) obj).zzef();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ Object clone() {
        zzkb zzkbVar = new zzkb();
        for (int i = 0; i < this.zzos.zzer(); i++) {
            Map.Entry<K, Object> entryZzaw = this.zzos.zzaw(i);
            zzkbVar.zza((zzkd) entryZzaw.getKey(), entryZzaw.getValue());
        }
        Iterator it = this.zzos.zzes().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zzkbVar.zza((zzkd) entry.getKey(), entry.getValue());
        }
        zzkbVar.zzou = this.zzou;
        return zzkbVar;
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> descendingIterator() {
        return this.zzou ? new zzkw(this.zzos.zzet().iterator()) : this.zzos.zzet().iterator();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzkb) {
            return this.zzos.equals(((zzkb) obj).zzos);
        }
        return false;
    }

    public final int hashCode() {
        return this.zzos.hashCode();
    }

    public final boolean isImmutable() {
        return this.zzot;
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zzos.zzer(); i++) {
            if (!zzb(this.zzos.zzaw(i))) {
                return false;
            }
        }
        Iterator it = this.zzos.zzes().iterator();
        while (it.hasNext()) {
            if (!zzb((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        return this.zzou ? new zzkw(this.zzos.entrySet().iterator()) : this.zzos.entrySet().iterator();
    }

    public final void zzbp() {
        if (this.zzot) {
            return;
        }
        this.zzos.zzbp();
        this.zzot = true;
    }

    public final int zzco() {
        int iZzd = 0;
        for (int i = 0; i < this.zzos.zzer(); i++) {
            iZzd += zzd(this.zzos.zzaw(i));
        }
        Iterator it = this.zzos.zzes().iterator();
        while (it.hasNext()) {
            iZzd += zzd((Map.Entry) it.next());
        }
        return iZzd;
    }

    private zzkb(boolean z) {
        zzbp();
    }

    private final void zza(FieldDescriptorType fielddescriptortype, Object obj) {
        if (fielddescriptortype.zzcs()) {
            if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    zza(fielddescriptortype.zzcq(), obj2);
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            zza(fielddescriptortype.zzcq(), obj);
        }
        if (obj instanceof zzkt) {
            this.zzou = true;
        }
        this.zzos.put(fielddescriptortype, obj);
    }

    private static int zzb(zznm zznmVar, Object obj) {
        switch (zzkc.zzox[zznmVar.ordinal()]) {
            case 1:
                return zzjr.zzb(((Double) obj).doubleValue());
            case 2:
                return zzjr.zzb(((Float) obj).floatValue());
            case 3:
                return zzjr.zzo(((Long) obj).longValue());
            case 4:
                return zzjr.zzp(((Long) obj).longValue());
            case 5:
                return zzjr.zzac(((Integer) obj).intValue());
            case 6:
                return zzjr.zzr(((Long) obj).longValue());
            case 7:
                return zzjr.zzaf(((Integer) obj).intValue());
            case 8:
                return zzjr.zzd(((Boolean) obj).booleanValue());
            case 9:
                return zzjr.zzd((zzlq) obj);
            case 10:
                if (obj instanceof zzkt) {
                    return zzjr.zza((zzkt) obj);
                }
                return zzjr.zzc((zzlq) obj);
            case 11:
                if (obj instanceof zzjc) {
                    return zzjr.zzb((zzjc) obj);
                }
                return zzjr.zzm((String) obj);
            case 12:
                if (obj instanceof zzjc) {
                    return zzjr.zzb((zzjc) obj);
                }
                return zzjr.zzc((byte[]) obj);
            case 13:
                return zzjr.zzad(((Integer) obj).intValue());
            case 14:
                return zzjr.zzag(((Integer) obj).intValue());
            case 15:
                return zzjr.zzs(((Long) obj).longValue());
            case 16:
                return zzjr.zzae(((Integer) obj).intValue());
            case 17:
                return zzjr.zzq(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzkn) {
                    return zzjr.zzah(((zzkn) obj).zzcp());
                }
                return zzjr.zzah(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0011. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void zza(zznm zznmVar, Object obj) {
        zzkm.checkNotNull(obj);
        boolean z = true;
        boolean z2 = false;
        switch (zzkc.zzow[zznmVar.zzfj().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                z2 = z;
                break;
            case 2:
                z = obj instanceof Long;
                z2 = z;
                break;
            case 3:
                z = obj instanceof Float;
                z2 = z;
                break;
            case 4:
                z = obj instanceof Double;
                z2 = z;
                break;
            case 5:
                z = obj instanceof Boolean;
                z2 = z;
                break;
            case 6:
                z = obj instanceof String;
                z2 = z;
                break;
            case 7:
                if (!(obj instanceof zzjc) && !(obj instanceof byte[])) {
                    z = false;
                }
                z2 = z;
                break;
            case 8:
                if (!(obj instanceof Integer) && !(obj instanceof zzkn)) {
                }
                z2 = z;
                break;
            case 9:
                if (!(obj instanceof zzlq) && !(obj instanceof zzkt)) {
                }
                z2 = z;
                break;
        }
        if (!z2) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public final void zza(zzkb<FieldDescriptorType> zzkbVar) {
        for (int i = 0; i < zzkbVar.zzos.zzer(); i++) {
            zzc(zzkbVar.zzos.zzaw(i));
        }
        Iterator it = zzkbVar.zzos.zzes().iterator();
        while (it.hasNext()) {
            zzc((Map.Entry) it.next());
        }
    }

    public static void zza(zzjr zzjrVar, zznm zznmVar, int i, Object obj) {
        if (zznmVar == zznm.zzxd) {
            zzlq zzlqVar = (zzlq) obj;
            zzkm.zzf(zzlqVar);
            zzjrVar.zzb(i, 3);
            zzlqVar.zzb(zzjrVar);
            zzjrVar.zzb(i, 4);
        }
        zzjrVar.zzb(i, zznmVar.zzfk());
        switch (zzkc.zzox[zznmVar.ordinal()]) {
            case 1:
                zzjrVar.zza(((Double) obj).doubleValue());
                break;
            case 2:
                zzjrVar.zza(((Float) obj).floatValue());
                break;
            case 3:
                zzjrVar.zzl(((Long) obj).longValue());
                break;
            case 4:
                zzjrVar.zzl(((Long) obj).longValue());
                break;
            case 5:
                zzjrVar.zzx(((Integer) obj).intValue());
                break;
            case 6:
                zzjrVar.zzn(((Long) obj).longValue());
                break;
            case 7:
                zzjrVar.zzaa(((Integer) obj).intValue());
                break;
            case 8:
                zzjrVar.zzc(((Boolean) obj).booleanValue());
                break;
            case 9:
                ((zzlq) obj).zzb(zzjrVar);
                break;
            case 10:
                zzjrVar.zzb((zzlq) obj);
                break;
            case 11:
                if (obj instanceof zzjc) {
                    zzjrVar.zza((zzjc) obj);
                } else {
                    zzjrVar.zzl((String) obj);
                }
                break;
            case 12:
                if (obj instanceof zzjc) {
                    zzjrVar.zza((zzjc) obj);
                } else {
                    byte[] bArr = (byte[]) obj;
                    zzjrVar.zzd(bArr, 0, bArr.length);
                }
                break;
            case 13:
                zzjrVar.zzy(((Integer) obj).intValue());
                break;
            case 14:
                zzjrVar.zzaa(((Integer) obj).intValue());
                break;
            case 15:
                zzjrVar.zzn(((Long) obj).longValue());
                break;
            case 16:
                zzjrVar.zzz(((Integer) obj).intValue());
                break;
            case 17:
                zzjrVar.zzm(((Long) obj).longValue());
                break;
            case 18:
                if (obj instanceof zzkn) {
                    zzjrVar.zzx(((zzkn) obj).zzcp());
                } else {
                    zzjrVar.zzx(((Integer) obj).intValue());
                }
                break;
        }
    }

    public static int zzb(zzkd<?> zzkdVar, Object obj) {
        zznm zznmVarZzcq = zzkdVar.zzcq();
        int iZzcp = zzkdVar.zzcp();
        if (zzkdVar.zzcs()) {
            int iZza = 0;
            if (zzkdVar.zzct()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    iZza += zzb(zznmVarZzcq, it.next());
                }
                return zzjr.zzaj(iZza) + zzjr.zzab(iZzcp) + iZza;
            }
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                iZza += zza(zznmVarZzcq, iZzcp, it2.next());
            }
            return iZza;
        }
        return zza(zznmVarZzcq, iZzcp, obj);
    }

    public static int zza(zznm zznmVar, int i, Object obj) {
        int iZzab = zzjr.zzab(i);
        if (zznmVar == zznm.zzxd) {
            zzkm.zzf((zzlq) obj);
            iZzab <<= 1;
        }
        return iZzab + zzb(zznmVar, obj);
    }
}
