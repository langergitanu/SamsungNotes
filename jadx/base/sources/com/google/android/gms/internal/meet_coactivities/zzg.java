package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzg extends zzsy implements zzuf {
    private static final zzg zzb;
    private static volatile zzul zze;
    private int zzf;
    private boolean zzg;
    private zzsg zzh;
    private zzsg zzi;
    private boolean zzj;

    static {
        zzg zzgVar = new zzg();
        zzb = zzgVar;
        zzsy.zzN(zzg.class, zzgVar);
    }

    private zzg() {
    }

    public static zzg zzb() {
        return zzb;
    }

    public final zzsg zzc() {
        zzsg zzsgVar = this.zzh;
        return zzsgVar == null ? zzsg.zzg() : zzsgVar;
    }

    public final zzsg zzd() {
        zzsg zzsgVar = this.zzi;
        return zzsgVar == null ? zzsg.zzg() : zzsgVar;
    }

    public final boolean zze() {
        return this.zzj;
    }

    public final boolean zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        return (this.zzf & 1) != 0;
    }

    public final boolean zzh() {
        return (this.zzf & 2) != 0;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsy
    public final Object zzi(int i, Object obj, Object obj2) {
        zzul zzstVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsy.zzK(zzb, "\u0000\u0004\u0000\u0001\u0002\n\u0004\u0000\u0000\u0000\u0002\u0007\u0004ဉ\u0000\tဉ\u0001\n\u0007", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zzg();
        }
        zze zzeVar = null;
        if (i2 == 4) {
            return new zzf(zzeVar);
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
        synchronized (zzg.class) {
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
