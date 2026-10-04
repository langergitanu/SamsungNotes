package com.google.android.gms.internal.meet_coactivities;

import com.google.android.gms.common.data.AbstractC4539a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzso {
    private static final zzso zzb = new zzso(true);
    final zzva zza = new zzut();
    private boolean zzc;
    private boolean zzd;

    private zzso() {
    }

    public static int zza(zzvp zzvpVar, int i, Object obj) {
        int iZzz = zzsb.zzz(i << 3);
        if (zzvpVar == zzvp.zzj) {
            zztg.zzd((zzue) obj);
            iZzz += iZzz;
        }
        return iZzz + zzb(zzvpVar, obj);
    }

    public static int zzb(zzvp zzvpVar, Object obj) {
        int iZzd;
        int iZzz;
        zzvp zzvpVar2 = zzvp.zza;
        zzvq zzvqVar = zzvq.INT;
        switch (zzvpVar.ordinal()) {
            case 0:
                ((Double) obj).getClass();
                int i = zzsb.zzb;
                return 8;
            case 1:
                ((Float) obj).getClass();
                int i2 = zzsb.zzb;
                return 4;
            case 2:
                return zzsb.zzA(((Long) obj).longValue());
            case 3:
                return zzsb.zzA(((Long) obj).longValue());
            case 4:
                return zzsb.zzA(((Integer) obj).intValue());
            case 5:
                ((Long) obj).getClass();
                int i4 = zzsb.zzb;
                return 8;
            case 6:
                ((Integer) obj).getClass();
                int i5 = zzsb.zzb;
                return 4;
            case 7:
                ((Boolean) obj).getClass();
                int i6 = zzsb.zzb;
                return 1;
            case 8:
                if (!(obj instanceof zzrq)) {
                    return zzsb.zzy((String) obj);
                }
                int i7 = zzsb.zzb;
                iZzd = ((zzrq) obj).zzd();
                iZzz = zzsb.zzz(iZzd);
                break;
                break;
            case 9:
                int i8 = zzsb.zzb;
                return ((zzue) obj).zzz();
            case 10:
                if (!(obj instanceof zztn)) {
                    return zzsb.zzw((zzue) obj);
                }
                int i9 = zzsb.zzb;
                iZzd = ((zztn) obj).zza();
                iZzz = zzsb.zzz(iZzd);
                break;
                break;
            case 11:
                if (!(obj instanceof zzrq)) {
                    int i10 = zzsb.zzb;
                    iZzd = ((byte[]) obj).length;
                    iZzz = zzsb.zzz(iZzd);
                } else {
                    int i11 = zzsb.zzb;
                    iZzd = ((zzrq) obj).zzd();
                    iZzz = zzsb.zzz(iZzd);
                }
                break;
            case 12:
                return zzsb.zzz(((Integer) obj).intValue());
            case 13:
                return obj instanceof zzta ? zzsb.zzA(((zzta) obj).zza()) : zzsb.zzA(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).getClass();
                int i12 = zzsb.zzb;
                return 4;
            case 15:
                ((Long) obj).getClass();
                int i13 = zzsb.zzb;
                return 8;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                return zzsb.zzz((iIntValue >> 31) ^ (iIntValue + iIntValue));
            case 17:
                long jLongValue = ((Long) obj).longValue();
                return zzsb.zzA((jLongValue >> 63) ^ (jLongValue + jLongValue));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return iZzz + iZzd;
    }

    public static int zzc(zzsn zzsnVar, Object obj) {
        zzvp zzvpVarZzb = zzsnVar.zzb();
        int iZza = zzsnVar.zza();
        if (!zzsnVar.zze()) {
            return zza(zzvpVarZzb, iZza, obj);
        }
        List list = (List) obj;
        int iZza2 = 0;
        if (!zzsnVar.zzd()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                iZza2 += zza(zzvpVarZzb, iZza, it.next());
            }
            return iZza2;
        }
        if (list.isEmpty()) {
            return 0;
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            iZza2 += zzb(zzvpVarZzb, it2.next());
        }
        return zzsb.zzz(iZza2) + zzsb.zzz(iZza << 3) + iZza2;
    }

    public static zzso zze() {
        return zzb;
    }

    public static void zzi(zzsb zzsbVar, zzvp zzvpVar, int i, Object obj) {
        if (zzvpVar == zzvp.zzj) {
            zzue zzueVar = (zzue) obj;
            zztg.zzd(zzueVar);
            zzsbVar.zzq(i, 3);
            zzueVar.zzS(zzsbVar);
            zzsbVar.zzq(i, 4);
            return;
        }
        zzsbVar.zzq(i, zzvpVar.zza());
        zzvq zzvqVar = zzvq.INT;
        switch (zzvpVar.ordinal()) {
            case 0:
                zzsbVar.zzj(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                break;
            case 1:
                zzsbVar.zzh(Float.floatToRawIntBits(((Float) obj).floatValue()));
                break;
            case 2:
                zzsbVar.zzu(((Long) obj).longValue());
                break;
            case 3:
                zzsbVar.zzu(((Long) obj).longValue());
                break;
            case 4:
                zzsbVar.zzl(((Integer) obj).intValue());
                break;
            case 5:
                zzsbVar.zzj(((Long) obj).longValue());
                break;
            case 6:
                zzsbVar.zzh(((Integer) obj).intValue());
                break;
            case 7:
                zzsbVar.zzb(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case 8:
                if (!(obj instanceof zzrq)) {
                    zzsbVar.zzp((String) obj);
                } else {
                    zzsbVar.zzf((zzrq) obj);
                }
                break;
            case 9:
                ((zzue) obj).zzS(zzsbVar);
                break;
            case 10:
                zzsbVar.zzn((zzue) obj);
                break;
            case 11:
                if (!(obj instanceof zzrq)) {
                    byte[] bArr = (byte[]) obj;
                    int length = bArr.length;
                    zzry zzryVar = (zzry) zzsbVar;
                    zzryVar.zzs(length);
                    zzryVar.zzc(bArr, 0, length);
                } else {
                    zzsbVar.zzf((zzrq) obj);
                }
                break;
            case 12:
                zzsbVar.zzs(((Integer) obj).intValue());
                break;
            case 13:
                if (!(obj instanceof zzta)) {
                    zzsbVar.zzl(((Integer) obj).intValue());
                } else {
                    zzsbVar.zzl(((zzta) obj).zza());
                }
                break;
            case 14:
                zzsbVar.zzh(((Integer) obj).intValue());
                break;
            case 15:
                zzsbVar.zzj(((Long) obj).longValue());
                break;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                zzsbVar.zzs((iIntValue >> 31) ^ (iIntValue + iIntValue));
                break;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                zzsbVar.zzu((jLongValue >> 63) ^ (jLongValue + jLongValue));
                break;
        }
    }

    private static boolean zzk(Map.Entry entry) {
        zzsn zzsnVar = (zzsn) entry.getKey();
        if (zzsnVar.zzc() != zzvq.MESSAGE) {
            return true;
        }
        if (!zzsnVar.zze()) {
            return zzl(entry.getValue());
        }
        Iterator it = ((List) entry.getValue()).iterator();
        while (it.hasNext()) {
            if (!zzl(it.next())) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzl(Object obj) {
        if (obj instanceof zzuf) {
            return ((zzuf) obj).zzU();
        }
        if (obj instanceof zztn) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzm(Map.Entry entry) {
        int i;
        int iZzz;
        int iZzw;
        zzsn zzsnVar = (zzsn) entry.getKey();
        Object value = entry.getValue();
        if (zzsnVar.zzc() != zzvq.MESSAGE || zzsnVar.zze() || zzsnVar.zzd()) {
            return zzc(zzsnVar, value);
        }
        if (value instanceof zztn) {
            int iZza = ((zzsn) entry.getKey()).zza();
            int iZzz2 = zzsb.zzz(8);
            i = iZzz2 + iZzz2;
            iZzz = zzsb.zzz(iZza) + zzsb.zzz(16);
            int iZzz3 = zzsb.zzz(24);
            int iZza2 = ((zztn) value).zza();
            iZzw = AbstractC4539a.m3191a(iZza2, iZza2, iZzz3);
        } else {
            int iZza3 = ((zzsn) entry.getKey()).zza();
            int iZzz4 = zzsb.zzz(8);
            i = iZzz4 + iZzz4;
            iZzz = zzsb.zzz(iZza3) + zzsb.zzz(16);
            iZzw = zzsb.zzw((zzue) value) + zzsb.zzz(24);
        }
        return i + iZzz + iZzw;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0047 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void zzn(zzsn zzsnVar, Object obj) {
        boolean z;
        zzsnVar.zzb();
        byte[] bArr = zztg.zzb;
        obj.getClass();
        zzvp zzvpVar = zzvp.zza;
        zzvq zzvqVar = zzvq.INT;
        switch (r0.zzb()) {
            case INT:
                z = obj instanceof Integer;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzsnVar.zza()), zzsnVar.zzb().zzb(), obj.getClass().getName()));
            case LONG:
                z = obj instanceof Long;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzsnVar.zza()), zzsnVar.zzb().zzb(), obj.getClass().getName()));
            case FLOAT:
                z = obj instanceof Float;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzsnVar.zza()), zzsnVar.zzb().zzb(), obj.getClass().getName()));
            case DOUBLE:
                z = obj instanceof Double;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzsnVar.zza()), zzsnVar.zzb().zzb(), obj.getClass().getName()));
            case BOOLEAN:
                z = obj instanceof Boolean;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzsnVar.zza()), zzsnVar.zzb().zzb(), obj.getClass().getName()));
            case STRING:
                z = obj instanceof String;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzsnVar.zza()), zzsnVar.zzb().zzb(), obj.getClass().getName()));
            case BYTE_STRING:
                if ((obj instanceof zzrq) || (obj instanceof byte[])) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzsnVar.zza()), zzsnVar.zzb().zzb(), obj.getClass().getName()));
            case ENUM:
                if ((obj instanceof Integer) || (obj instanceof zzta)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzsnVar.zza()), zzsnVar.zzb().zzb(), obj.getClass().getName()));
            case MESSAGE:
                if ((obj instanceof zzue) || (obj instanceof zztn)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzsnVar.zza()), zzsnVar.zzb().zzb(), obj.getClass().getName()));
            default:
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzsnVar.zza()), zzsnVar.zzb().zzb(), obj.getClass().getName()));
        }
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        zzso zzsoVar = new zzso();
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry entryZzg = this.zza.zzg(i);
            zzsoVar.zzh((zzsn) entryZzg.getKey(), entryZzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzsoVar.zzh((zzsn) entry.getKey(), entry.getValue());
        }
        zzsoVar.zzd = this.zzd;
        return zzsoVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzso) {
            return this.zza.equals(((zzso) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzd() {
        int iZzm = 0;
        for (int i = 0; i < this.zza.zzb(); i++) {
            iZzm += zzm(this.zza.zzg(i));
        }
        Iterator it = this.zza.zzc().iterator();
        while (it.hasNext()) {
            iZzm += zzm((Map.Entry) it.next());
        }
        return iZzm;
    }

    public final Iterator zzf() {
        return this.zza.isEmpty() ? Collections.emptyIterator() : this.zzd ? new zztm(this.zza.entrySet().iterator()) : this.zza.entrySet().iterator();
    }

    public final void zzg() {
        if (this.zzc) {
            return;
        }
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry entryZzg = this.zza.zzg(i);
            if (entryZzg.getValue() instanceof zzsy) {
                ((zzsy) entryZzg.getValue()).zzL();
            }
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final void zzh(zzsn zzsnVar, Object obj) {
        if (!zzsnVar.zze()) {
            zzn(zzsnVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zzn(zzsnVar, arrayList.get(i));
            }
            obj = arrayList;
        }
        if (obj instanceof zztn) {
            this.zzd = true;
        }
        this.zza.put(zzsnVar, obj);
    }

    public final boolean zzj() {
        for (int i = 0; i < this.zza.zzb(); i++) {
            if (!zzk(this.zza.zzg(i))) {
                return false;
            }
        }
        Iterator it = this.zza.zzc().iterator();
        while (it.hasNext()) {
            if (!zzk((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private zzso(boolean z) {
        zzg();
        zzg();
    }
}
