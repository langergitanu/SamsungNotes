package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzl extends zzsy implements zzuf {
    private static final zzl zzb;
    private static volatile zzul zze;
    private int zzf;
    private int zzi;
    private zzaq zzk;
    private String zzg = "";
    private String zzh = "";
    private String zzj = "";

    static {
        zzl zzlVar = new zzl();
        zzb = zzlVar;
        zzsy.zzN(zzl.class, zzlVar);
    }

    private zzl() {
    }

    public static zzk zza() {
        return (zzk) zzb.zzA();
    }

    public static zzl zzc() {
        return zzb;
    }

    public final zzal zzd() {
        zzal zzalVarZzb = zzal.zzb(this.zzi);
        return zzalVarZzb == null ? zzal.UNRECOGNIZED : zzalVarZzb;
    }

    public final zzaq zze() {
        zzaq zzaqVar = this.zzk;
        return zzaqVar == null ? zzaq.zzc() : zzaqVar;
    }

    public final String zzf() {
        return this.zzg;
    }

    public final String zzg() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsy
    public final Object zzi(int i, Object obj, Object obj2) {
        zzul zzstVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsy.zzK(zzb, "\u0000\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\f\u0004Ȉ\u0006ဉ\u0000", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new zzl();
        }
        zze zzeVar = null;
        if (i2 == 4) {
            return new zzk(zzeVar);
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
        synchronized (zzl.class) {
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
