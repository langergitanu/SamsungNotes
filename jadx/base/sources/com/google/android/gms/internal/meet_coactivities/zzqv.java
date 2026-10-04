package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzqv extends zzsy implements zzuf {
    private static final zzqv zzb;
    private static volatile zzul zze;
    private String zzf = "";
    private long zzg;

    static {
        zzqv zzqvVar = new zzqv();
        zzb = zzqvVar;
        zzsy.zzN(zzqv.class, zzqvVar);
    }

    private zzqv() {
    }

    public static zzqu zzb() {
        return (zzqu) zzb.zzA();
    }

    public static zzqv zzd() {
        return zzb;
    }

    public static /* synthetic */ void zzf(zzqv zzqvVar, String str) {
        str.getClass();
        zzqvVar.zzf = str;
    }

    public final long zza() {
        return this.zzg;
    }

    public final String zze() {
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
            return zzsy.zzK(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\u0002", new Object[]{"zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzqv();
        }
        zzpv zzpvVar = null;
        if (i2 == 4) {
            return new zzqu(zzpvVar);
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
        synchronized (zzqv.class) {
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
