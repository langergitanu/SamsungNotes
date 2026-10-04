package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzau extends zzsy implements zzuf {
    private static final zzau zzb;
    private static volatile zzul zze;
    private String zzf = "";
    private long zzg;

    static {
        zzau zzauVar = new zzau();
        zzb = zzauVar;
        zzsy.zzN(zzau.class, zzauVar);
    }

    private zzau() {
    }

    public static zzat zza() {
        return (zzat) zzb.zzA();
    }

    public static /* synthetic */ void zzc(zzau zzauVar, String str) {
        str.getClass();
        zzauVar.zzf = str;
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
            return new zzau();
        }
        zze zzeVar = null;
        if (i2 == 4) {
            return new zzat(zzeVar);
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
        synchronized (zzau.class) {
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
