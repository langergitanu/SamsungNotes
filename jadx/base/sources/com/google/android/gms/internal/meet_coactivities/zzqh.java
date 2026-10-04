package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzqh extends zzsy implements zzuf {
    private static final zzqh zzb;
    private static volatile zzul zze;
    private int zzf;
    private zzqv zzg;
    private zzpz zzh;

    static {
        zzqh zzqhVar = new zzqh();
        zzb = zzqhVar;
        zzsy.zzN(zzqh.class, zzqhVar);
    }

    private zzqh() {
    }

    public static zzqg zzb() {
        return (zzqg) zzb.zzA();
    }

    public static zzqh zzd() {
        return zzb;
    }

    public static /* synthetic */ void zzf(zzqh zzqhVar, zzqv zzqvVar) {
        zzqvVar.getClass();
        zzqhVar.zzg = zzqvVar;
        zzqhVar.zzf |= 1;
    }

    public static /* synthetic */ void zzg(zzqh zzqhVar, zzpz zzpzVar) {
        zzpzVar.getClass();
        zzqhVar.zzh = zzpzVar;
        zzqhVar.zzf |= 2;
    }

    public final zzpz zza() {
        zzpz zzpzVar = this.zzh;
        return zzpzVar == null ? zzpz.zzd() : zzpzVar;
    }

    public final zzqv zze() {
        zzqv zzqvVar = this.zzg;
        return zzqvVar == null ? zzqv.zzd() : zzqvVar;
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
            return zzsy.zzK(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzqh();
        }
        zzpv zzpvVar = null;
        if (i2 == 4) {
            return new zzqg(zzpvVar);
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
        synchronized (zzqh.class) {
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

    public final boolean zzj() {
        return (this.zzf & 1) != 0;
    }
}
