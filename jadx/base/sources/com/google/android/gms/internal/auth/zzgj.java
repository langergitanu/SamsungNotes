package com.google.android.gms.internal.auth;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzgj {
    private static final Class zza;
    private static final zzgy zzb;
    private static final zzgy zzc;
    private static final zzgy zzd;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
        zzb = zzj(false);
        zzc = zzj(true);
        zzd = new zzha();
    }

    public static zzgy zza() {
        return zzb;
    }

    public static zzgy zzb() {
        return zzc;
    }

    public static zzgy zzc() {
        return zzd;
    }

    public static Object zzd(int i, List list, zzex zzexVar, Object obj, zzgy zzgyVar) {
        if (zzexVar == null) {
            return obj;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (!zzexVar.zza()) {
                    obj = zze(i, iIntValue, obj, zzgyVar);
                    it.remove();
                }
            }
            return obj;
        }
        int size = list.size();
        int i2 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            Integer num = (Integer) list.get(i4);
            int iIntValue2 = num.intValue();
            if (zzexVar.zza()) {
                if (i4 != i2) {
                    list.set(i2, num);
                }
                i2++;
            } else {
                obj = zze(i, iIntValue2, obj, zzgyVar);
            }
        }
        if (i2 == size) {
            return obj;
        }
        list.subList(i2, size).clear();
        return obj;
    }

    public static Object zze(int i, int i2, Object obj, zzgy zzgyVar) {
        if (obj == null) {
            obj = zzgyVar.zzc();
        }
        zzgyVar.zzd(obj, i, i2);
        return obj;
    }

    public static void zzf(zzgy zzgyVar, Object obj, Object obj2) {
        zzgyVar.zzf(obj, zzgyVar.zzb(zzgyVar.zza(obj), zzgyVar.zza(obj2)));
    }

    public static void zzg(Class cls) {
        Class cls2;
        if (!zzeu.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static boolean zzh(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void zzi(zzfr zzfrVar, Object obj, Object obj2, long j) {
        zzhi.zzp(obj, j, zzfr.zza(zzhi.zzf(obj, j), zzhi.zzf(obj2, j)));
    }

    private static zzgy zzj(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (zzgy) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused2) {
            return null;
        }
    }
}
