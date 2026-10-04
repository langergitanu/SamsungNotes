package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzve {
    public abstract Object zza(Object obj);

    public abstract Object zzb();

    public abstract Object zzc(Object obj);

    public abstract void zzd(Object obj, int i, int i2);

    public abstract void zze(Object obj, int i, long j);

    public abstract void zzf(Object obj, int i, Object obj2);

    public abstract void zzg(Object obj, int i, zzrq zzrqVar);

    public abstract void zzh(Object obj, int i, long j);

    public abstract void zzi(Object obj);

    public final boolean zzj(Object obj, zzup zzupVar) throws zzti {
        int iZzd = zzupVar.zzd();
        int i = iZzd >>> 3;
        int i2 = iZzd & 7;
        if (i2 == 0) {
            zzh(obj, i, zzupVar.zzl());
            return true;
        }
        if (i2 == 1) {
            zze(obj, i, zzupVar.zzk());
            return true;
        }
        if (i2 == 2) {
            zzg(obj, i, zzupVar.zzp());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw zzti.zza();
            }
            zzd(obj, i, zzupVar.zzf());
            return true;
        }
        Object objZzb = zzb();
        int i4 = i << 3;
        while (zzupVar.zzc() != Integer.MAX_VALUE && zzj(objZzb, zzupVar)) {
        }
        if ((4 | i4) != zzupVar.zzd()) {
            throw zzti.zzb();
        }
        zzc(objZzb);
        zzf(obj, i, objZzb);
        return true;
    }
}
