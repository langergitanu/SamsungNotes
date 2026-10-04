package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzax extends zzsy implements zzuf {
    private static final zzax zzb;
    private static volatile zzul zze;
    private boolean zzf;
    private String zzg = "";
    private int zzh;
    private long zzi;

    static {
        zzax zzaxVar = new zzax();
        zzb = zzaxVar;
        zzsy.zzN(zzax.class, zzaxVar);
    }

    private zzax() {
    }

    public static zzax zzc() {
        return zzb;
    }

    public final long zza() {
        return this.zzi;
    }

    public final String zzd() {
        return this.zzg;
    }

    public final int zze() {
        int i = this.zzh;
        int i2 = i != 0 ? i != 1 ? i != 2 ? 0 : 4 : 3 : 2;
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsy
    public final Object zzi(int i, Object obj, Object obj2) {
        zzul zzstVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsy.zzK(zzb, "\u0000\u0004\u0000\u0000\u0001\u0007\u0004\u0000\u0000\u0000\u0001\u0007\u0003Ȉ\u0004\f\u0007\u0003", new Object[]{"zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzax();
        }
        zze zzeVar = null;
        if (i2 == 4) {
            return new zzaw(zzeVar);
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
        synchronized (zzax.class) {
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
