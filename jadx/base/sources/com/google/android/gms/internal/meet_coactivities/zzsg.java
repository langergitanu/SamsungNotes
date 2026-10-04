package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzsg extends zzsy implements zzuf {
    private static final zzsg zzb;
    private static volatile zzul zze;
    private long zzf;
    private int zzg;

    static {
        zzsg zzsgVar = new zzsg();
        zzb = zzsgVar;
        zzsy.zzN(zzsg.class, zzsgVar);
    }

    private zzsg() {
    }

    public static zzsf zze() {
        return (zzsf) zzb.zzA();
    }

    public static zzsg zzg() {
        return zzb;
    }

    public final int zzc() {
        return this.zzg;
    }

    public final long zzd() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsy
    public final Object zzi(int i, Object obj, Object obj2) {
        zzul zzstVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzuo(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzsg();
        }
        zzse zzseVar = null;
        if (i2 == 4) {
            return new zzsf(zzseVar);
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
        synchronized (zzsg.class) {
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
