package com.google.android.gms.internal.meet_coactivities;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzac extends zzsy implements zzuf {
    private static final zztd zzb = new zzz();
    private static final zzac zze;
    private static volatile zzul zzf;
    private int zzg;
    private zztc zzh = zzsy.zzF();

    static {
        zzac zzacVar = new zzac();
        zze = zzacVar;
        zzsy.zzN(zzac.class, zzacVar);
    }

    private zzac() {
    }

    public final zzam zzb() {
        zzam zzamVarZzb = zzam.zzb(this.zzg);
        return zzamVarZzb == null ? zzam.UNRECOGNIZED : zzamVarZzb;
    }

    public final List zzc() {
        return new zzte(this.zzh, zzb);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsy
    public final Object zzi(int i, Object obj, Object obj2) {
        zzul zzstVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsy.zzK(zze, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\f\u0002,", new Object[]{"zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzac();
        }
        zze zzeVar = null;
        if (i2 == 4) {
            return new zzaa(zzeVar);
        }
        if (i2 == 5) {
            return zze;
        }
        if (i2 != 6) {
            return null;
        }
        zzul zzulVar = zzf;
        if (zzulVar != null) {
            return zzulVar;
        }
        synchronized (zzac.class) {
            try {
                zzstVar = zzf;
                if (zzstVar == null) {
                    zzstVar = new zzst(zze);
                    zzf = zzstVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzstVar;
    }
}
