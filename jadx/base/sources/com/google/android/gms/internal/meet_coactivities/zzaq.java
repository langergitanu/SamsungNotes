package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaq extends zzsy implements zzuf {
    private static final zzaq zzb;
    private static volatile zzul zze;
    private int zzf;

    static {
        zzaq zzaqVar = new zzaq();
        zzb = zzaqVar;
        zzsy.zzN(zzaq.class, zzaqVar);
    }

    private zzaq() {
    }

    public static zzap zza() {
        return (zzap) zzb.zzA();
    }

    public static zzaq zzc() {
        return zzb;
    }

    public final int zzd() {
        int i = this.zzf;
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
            return zzsy.zzK(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"zzf"});
        }
        if (i2 == 3) {
            return new zzaq();
        }
        zze zzeVar = null;
        if (i2 == 4) {
            return new zzap(zzeVar);
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
        synchronized (zzaq.class) {
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
