package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzqf extends zzsy implements zzuf {
    private static final zzqf zzb;
    private static volatile zzul zze;
    private int zzf;
    private zzqd zzg;

    static {
        zzqf zzqfVar = new zzqf();
        zzb = zzqfVar;
        zzsy.zzN(zzqf.class, zzqfVar);
    }

    private zzqf() {
    }

    public static zzqe zzb() {
        return (zzqe) zzb.zzA();
    }

    public static zzqf zzd() {
        return zzb;
    }

    public static /* synthetic */ void zze(zzqf zzqfVar, zzqd zzqdVar) {
        zzqdVar.getClass();
        zzqfVar.zzg = zzqdVar;
        zzqfVar.zzf |= 1;
    }

    public final zzqd zza() {
        zzqd zzqdVar = this.zzg;
        return zzqdVar == null ? zzqd.zzc() : zzqdVar;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsy
    public final Object zzi(int i, Object obj, Object obj2) {
        zzul zzstVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsy.zzK(zzb, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzqf();
        }
        zzpv zzpvVar = null;
        if (i2 == 4) {
            return new zzqe(zzpvVar);
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
        synchronized (zzqf.class) {
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
