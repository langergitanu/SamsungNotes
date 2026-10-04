package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbg extends zzsy implements zzuf {
    private static final zzbg zzb;
    private static volatile zzul zze;
    private int zzf;
    private zzao zzg;
    private zzas zzh;

    static {
        zzbg zzbgVar = new zzbg();
        zzb = zzbgVar;
        zzsy.zzN(zzbg.class, zzbgVar);
    }

    private zzbg() {
    }

    public static zzbf zza() {
        return (zzbf) zzb.zzA();
    }

    public static zzbg zzc() {
        return zzb;
    }

    public static /* synthetic */ void zzd(zzbg zzbgVar, zzas zzasVar) {
        zzasVar.getClass();
        zzbgVar.zzh = zzasVar;
        zzbgVar.zzf |= 2;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsy
    public final Object zzi(int i, Object obj, Object obj2) {
        zzul zzstVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsy.zzK(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzbg();
        }
        zze zzeVar = null;
        if (i2 == 4) {
            return new zzbf(zzeVar);
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
        synchronized (zzbg.class) {
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
