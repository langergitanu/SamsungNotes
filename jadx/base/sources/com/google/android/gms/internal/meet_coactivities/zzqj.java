package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzqj extends zzsy implements zzuf {
    private static final zzqj zzb;
    private static volatile zzul zze;
    private int zzf;
    private String zzg = "";
    private zzsg zzh;
    private zzsg zzi;
    private int zzj;
    private double zzk;
    private zzqh zzl;

    static {
        zzqj zzqjVar = new zzqj();
        zzb = zzqjVar;
        zzsy.zzN(zzqj.class, zzqjVar);
    }

    private zzqj() {
    }

    public static zzqi zzc() {
        return (zzqi) zzb.zzA();
    }

    public static zzqj zze() {
        return zzb;
    }

    public static /* synthetic */ void zzh(zzqj zzqjVar, String str) {
        str.getClass();
        zzqjVar.zzg = str;
    }

    public static /* synthetic */ void zzj(zzqj zzqjVar, zzsg zzsgVar) {
        zzsgVar.getClass();
        zzqjVar.zzh = zzsgVar;
        zzqjVar.zzf |= 1;
    }

    public static /* synthetic */ void zzk(zzqj zzqjVar) {
        zzqjVar.zzh = null;
        zzqjVar.zzf &= -2;
    }

    public static /* synthetic */ void zzl(zzqj zzqjVar, zzsg zzsgVar) {
        zzsgVar.getClass();
        zzqjVar.zzi = zzsgVar;
        zzqjVar.zzf |= 2;
    }

    public static /* synthetic */ void zzn(zzqj zzqjVar, zzqh zzqhVar) {
        zzqhVar.getClass();
        zzqjVar.zzl = zzqhVar;
        zzqjVar.zzf |= 4;
    }

    public final double zza() {
        return this.zzk;
    }

    public final zzqh zzb() {
        zzqh zzqhVar = this.zzl;
        return zzqhVar == null ? zzqh.zzd() : zzqhVar;
    }

    public final zzsg zzf() {
        zzsg zzsgVar = this.zzh;
        return zzsgVar == null ? zzsg.zzg() : zzsgVar;
    }

    public final String zzg() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsy
    public final Object zzi(int i, Object obj, Object obj2) {
        zzul zzstVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsy.zzK(zzb, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000\u0003\f\u0004\u0000\u0005ဉ\u0001\u0006ဉ\u0002", new Object[]{"zzf", "zzg", "zzh", "zzj", "zzk", "zzi", "zzl"});
        }
        if (i2 == 3) {
            return new zzqj();
        }
        zzpv zzpvVar = null;
        if (i2 == 4) {
            return new zzqi(zzpvVar);
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
        synchronized (zzqj.class) {
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

    public final int zzo() {
        int i = this.zzj;
        int i2 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? 0 : 6 : 5 : 4 : 3 : 2;
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }
}
