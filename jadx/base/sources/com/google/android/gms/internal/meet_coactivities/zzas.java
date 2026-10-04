package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzas extends zzsy implements zzuf {
    private static final zzas zzb;
    private static volatile zzul zze;
    private int zzf;
    private int zzg;

    static {
        zzas zzasVar = new zzas();
        zzb = zzasVar;
        zzsy.zzN(zzas.class, zzasVar);
    }

    private zzas() {
    }

    public static zzar zza() {
        return (zzar) zzb.zzA();
    }

    public final zzqw zzc() {
        int i = this.zzg;
        zzqw zzqwVar = i != 0 ? i != 1 ? i != 2 ? null : zzqw.OUTGOING : zzqw.INCOMING : zzqw.UNKNOWN;
        return zzqwVar == null ? zzqw.UNRECOGNIZED : zzqwVar;
    }

    public final zzqx zzd() {
        int i = this.zzf;
        zzqx zzqxVar = i != 0 ? i != 1 ? i != 2 ? null : zzqx.UPDATE : zzqx.HEARTBEAT : zzqx.UNDEFINED;
        return zzqxVar == null ? zzqx.UNRECOGNIZED : zzqxVar;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsy
    public final Object zzi(int i, Object obj, Object obj2) {
        zzul zzstVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsy.zzK(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\f", new Object[]{"zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzas();
        }
        zze zzeVar = null;
        if (i2 == 4) {
            return new zzar(zzeVar);
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
        synchronized (zzas.class) {
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
