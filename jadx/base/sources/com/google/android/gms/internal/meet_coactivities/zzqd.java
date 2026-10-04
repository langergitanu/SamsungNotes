package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzqd extends zzsy implements zzuf {
    private static final zzqd zzb;
    private static volatile zzul zze;
    private zzrq zzf = zzrq.zzb;

    static {
        zzqd zzqdVar = new zzqd();
        zzb = zzqdVar;
        zzsy.zzN(zzqd.class, zzqdVar);
    }

    private zzqd() {
    }

    public static zzqc zza() {
        return (zzqc) zzb.zzA();
    }

    public static zzqd zzc() {
        return zzb;
    }

    public final zzrq zzd() {
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
            return zzsy.zzK(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\n", new Object[]{"zzf"});
        }
        if (i2 == 3) {
            return new zzqd();
        }
        zzpv zzpvVar = null;
        if (i2 == 4) {
            return new zzqc(zzpvVar);
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
        synchronized (zzqd.class) {
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
