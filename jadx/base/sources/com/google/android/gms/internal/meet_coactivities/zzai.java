package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzai extends zzsy implements zzuf {
    private static final zzai zzb;
    private static volatile zzul zze;
    private int zzf;
    private Object zzh;
    private zzi zzi;
    private int zzg = 0;
    private String zzj = "";

    static {
        zzai zzaiVar = new zzai();
        zzb = zzaiVar;
        zzsy.zzN(zzai.class, zzaiVar);
    }

    private zzai() {
    }

    public static zzah zza() {
        return (zzah) zzb.zzA();
    }

    public static zzai zzc() {
        return zzb;
    }

    public static /* synthetic */ void zzd(zzai zzaiVar, zzi zziVar) {
        zziVar.getClass();
        zzaiVar.zzi = zziVar;
        zzaiVar.zzf |= 1;
    }

    public static /* synthetic */ void zze(zzai zzaiVar, String str) {
        str.getClass();
        zzaiVar.zzj = str;
    }

    public static /* synthetic */ void zzf(zzai zzaiVar, int i) {
        zzaiVar.zzh = Integer.valueOf(i - 2);
        zzaiVar.zzg = 1;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsy
    public final Object zzi(int i, Object obj, Object obj2) {
        zzul zzstVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsy.zzK(zzb, "\u0000\u0005\u0001\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001?\u0000\u0002?\u0000\u0003?\u0000\u0004ဉ\u0000\u0005Ȉ", new Object[]{"zzh", "zzg", "zzf", "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzai();
        }
        zze zzeVar = null;
        if (i2 == 4) {
            return new zzah(zzeVar);
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
        synchronized (zzai.class) {
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
