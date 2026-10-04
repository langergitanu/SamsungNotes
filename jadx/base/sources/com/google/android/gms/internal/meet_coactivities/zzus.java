package com.google.android.gms.internal.meet_coactivities;

import com.google.android.gms.common.data.AbstractC4539a;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzus {
    public static final /* synthetic */ int zza = 0;
    private static final zzve zzb;

    static {
        int i = zzum.zza;
        zzb = new zzvg();
    }

    public static void zzA(int i, List list, zzvr zzvrVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzvrVar.zzB(i, list, z);
    }

    public static void zzB(int i, List list, zzvr zzvrVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzvrVar.zzD(i, list, z);
    }

    public static void zzC(int i, List list, zzvr zzvrVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzvrVar.zzF(i, list, z);
    }

    public static void zzD(int i, List list, zzvr zzvrVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzvrVar.zzK(i, list, z);
    }

    public static void zzE(int i, List list, zzvr zzvrVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzvrVar.zzM(i, list, z);
    }

    public static boolean zzF(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int zza(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzsz)) {
            int iZzA = 0;
            while (i < size) {
                iZzA += zzsb.zzA(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzA;
        }
        zzsz zzszVar = (zzsz) list;
        int iZzA2 = 0;
        while (i < size) {
            iZzA2 += zzsb.zzA(zzszVar.zze(i));
            i++;
        }
        return iZzA2;
    }

    public static int zzb(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzsb.zzz(i << 3) + 4) * size;
    }

    public static int zzc(List list) {
        return list.size() * 4;
    }

    public static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzsb.zzz(i << 3) + 8) * size;
    }

    public static int zze(List list) {
        return list.size() * 8;
    }

    public static int zzf(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzsz)) {
            int iZzA = 0;
            while (i < size) {
                iZzA += zzsb.zzA(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzA;
        }
        zzsz zzszVar = (zzsz) list;
        int iZzA2 = 0;
        while (i < size) {
            iZzA2 += zzsb.zzA(zzszVar.zze(i));
            i++;
        }
        return iZzA2;
    }

    public static int zzg(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzts)) {
            int iZzA = 0;
            while (i < size) {
                iZzA += zzsb.zzA(((Long) list.get(i)).longValue());
                i++;
            }
            return iZzA;
        }
        zzts zztsVar = (zzts) list;
        int iZzA2 = 0;
        while (i < size) {
            iZzA2 += zzsb.zzA(zztsVar.zze(i));
            i++;
        }
        return iZzA2;
    }

    public static int zzh(int i, Object obj, zzuq zzuqVar) {
        int i2 = i << 3;
        if (!(obj instanceof zzto)) {
            return zzsb.zzx((zzue) obj, zzuqVar) + zzsb.zzz(i2);
        }
        int iZzz = zzsb.zzz(i2);
        int iZza = ((zzto) obj).zza();
        return AbstractC4539a.m3191a(iZza, iZza, iZzz);
    }

    public static int zzi(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzsz)) {
            int iZzz = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iZzz += zzsb.zzz((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
            return iZzz;
        }
        zzsz zzszVar = (zzsz) list;
        int iZzz2 = 0;
        while (i < size) {
            int iZze = zzszVar.zze(i);
            iZzz2 += zzsb.zzz((iZze >> 31) ^ (iZze + iZze));
            i++;
        }
        return iZzz2;
    }

    public static int zzj(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzts)) {
            int iZzA = 0;
            while (i < size) {
                long jLongValue = ((Long) list.get(i)).longValue();
                iZzA += zzsb.zzA((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i++;
            }
            return iZzA;
        }
        zzts zztsVar = (zzts) list;
        int iZzA2 = 0;
        while (i < size) {
            long jZze = zztsVar.zze(i);
            iZzA2 += zzsb.zzA((jZze >> 63) ^ (jZze + jZze));
            i++;
        }
        return iZzA2;
    }

    public static int zzk(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzsz)) {
            int iZzz = 0;
            while (i < size) {
                iZzz += zzsb.zzz(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzz;
        }
        zzsz zzszVar = (zzsz) list;
        int iZzz2 = 0;
        while (i < size) {
            iZzz2 += zzsb.zzz(zzszVar.zze(i));
            i++;
        }
        return iZzz2;
    }

    public static int zzl(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzts)) {
            int iZzA = 0;
            while (i < size) {
                iZzA += zzsb.zzA(((Long) list.get(i)).longValue());
                i++;
            }
            return iZzA;
        }
        zzts zztsVar = (zzts) list;
        int iZzA2 = 0;
        while (i < size) {
            iZzA2 += zzsb.zzA(zztsVar.zze(i));
            i++;
        }
        return iZzA2;
    }

    public static zzve zzm() {
        return zzb;
    }

    public static Object zzn(Object obj, int i, List list, zztb zztbVar, Object obj2, zzve zzveVar) {
        if (zztbVar == null) {
            return obj2;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (!zztbVar.zza()) {
                    obj2 = zzo(obj, i, iIntValue, obj2, zzveVar);
                    it.remove();
                }
            }
            return obj2;
        }
        int size = list.size();
        int i2 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            Integer num = (Integer) list.get(i4);
            int iIntValue2 = num.intValue();
            if (zztbVar.zza()) {
                if (i4 != i2) {
                    list.set(i2, num);
                }
                i2++;
            } else {
                obj2 = zzo(obj, i, iIntValue2, obj2, zzveVar);
            }
        }
        if (i2 != size) {
            list.subList(i2, size).clear();
        }
        return obj2;
    }

    public static Object zzo(Object obj, int i, int i2, Object obj2, zzve zzveVar) {
        if (obj2 == null) {
            obj2 = zzveVar.zza(obj);
        }
        zzveVar.zzh(obj2, i, i2);
        return obj2;
    }

    public static void zzp(zzsk zzskVar, Object obj, Object obj2) {
        if (((zzsu) obj2).zzb.zza.isEmpty()) {
            return;
        }
        throw null;
    }

    public static void zzq(zzve zzveVar, Object obj, Object obj2) {
        zzsy zzsyVar = (zzsy) obj;
        zzvf zzvfVarZze = zzsyVar.zzc;
        zzvf zzvfVar = ((zzsy) obj2).zzc;
        if (!zzvf.zzc().equals(zzvfVar)) {
            if (zzvf.zzc().equals(zzvfVarZze)) {
                zzvfVarZze = zzvf.zze(zzvfVarZze, zzvfVar);
            } else {
                zzvfVarZze.zzd(zzvfVar);
            }
        }
        zzsyVar.zzc = zzvfVarZze;
    }

    public static void zzr(int i, List list, zzvr zzvrVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzvrVar.zzc(i, list, z);
    }

    public static void zzs(int i, List list, zzvr zzvrVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzvrVar.zzg(i, list, z);
    }

    public static void zzt(int i, List list, zzvr zzvrVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzvrVar.zzj(i, list, z);
    }

    public static void zzu(int i, List list, zzvr zzvrVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzvrVar.zzl(i, list, z);
    }

    public static void zzv(int i, List list, zzvr zzvrVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzvrVar.zzn(i, list, z);
    }

    public static void zzw(int i, List list, zzvr zzvrVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzvrVar.zzp(i, list, z);
    }

    public static void zzx(int i, List list, zzvr zzvrVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzvrVar.zzs(i, list, z);
    }

    public static void zzy(int i, List list, zzvr zzvrVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzvrVar.zzu(i, list, z);
    }

    public static void zzz(int i, List list, zzvr zzvrVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzvrVar.zzz(i, list, z);
    }
}
