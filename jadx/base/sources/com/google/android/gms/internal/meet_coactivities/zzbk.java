package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbk extends zzsy implements zzuf {
    private static final zzbk zzb;
    private static volatile zzul zze;
    private int zzf;
    private zzpx zzg;
    private zzao zzh;
    private zzn zzi;
    private zzaq zzj;
    private zzr zzk;

    static {
        zzbk zzbkVar = new zzbk();
        zzb = zzbkVar;
        zzsy.zzN(zzbk.class, zzbkVar);
    }

    private zzbk() {
    }

    public static zzbj zza() {
        return (zzbj) zzb.zzA();
    }

    public static zzbk zzc() {
        return zzb;
    }

    public static /* synthetic */ void zzd(zzbk zzbkVar, zzpx zzpxVar) {
        zzpxVar.getClass();
        zzbkVar.zzg = zzpxVar;
        zzbkVar.zzf |= 1;
    }

    public static /* synthetic */ void zze(zzbk zzbkVar, zzao zzaoVar) {
        zzbkVar.zzh = zzaoVar;
        zzbkVar.zzf |= 2;
    }

    public static /* synthetic */ void zzf(zzbk zzbkVar, zzn zznVar) {
        zznVar.getClass();
        zzbkVar.zzi = zznVar;
        zzbkVar.zzf |= 4;
    }

    public static /* synthetic */ void zzg(zzbk zzbkVar, zzaq zzaqVar) {
        zzaqVar.getClass();
        zzbkVar.zzj = zzaqVar;
        zzbkVar.zzf |= 8;
    }

    public static /* synthetic */ void zzh(zzbk zzbkVar, zzr zzrVar) {
        zzrVar.getClass();
        zzbkVar.zzk = zzrVar;
        zzbkVar.zzf |= 16;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsy
    public final Object zzi(int i, Object obj, Object obj2) {
        zzul zzstVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsy.zzK(zzb, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new zzbk();
        }
        zze zzeVar = null;
        if (i2 == 4) {
            return new zzbj(zzeVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            return null;
        }
        zzul zzulVar = zze;
        if (zzulVar != null) {
            return zzulVar;
        }
        synchronized (zzbk.class) {
            try {
                zzstVar = zze;
                if (zzstVar == null) {
                    zzstVar = new zzst(zzb);
                    zze = zzstVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzstVar;
    }
}
