package com.google.android.gms.internal.meet_coactivities;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzpz extends zzsy implements zzuf {
    private static final zzpz zzb;
    private static volatile zzul zze;
    private int zzf;
    private zztf zzg = zzsy.zzG();

    static {
        zzpz zzpzVar = new zzpz();
        zzb = zzpzVar;
        zzsy.zzN(zzpz.class, zzpzVar);
    }

    private zzpz() {
    }

    public static zzpy zzb() {
        return (zzpy) zzb.zzA();
    }

    public static zzpz zzd() {
        return zzb;
    }

    public static /* synthetic */ void zzg(zzpz zzpzVar, zzqb zzqbVar) {
        zzqbVar.getClass();
        zztf zztfVar = zzpzVar.zzg;
        if (!zztfVar.zzc()) {
            zzpzVar.zzg = zzsy.zzH(zztfVar);
        }
        zzpzVar.zzg.add(zzqbVar);
    }

    public final int zza() {
        return this.zzf;
    }

    public final List zze() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsy
    public final Object zzi(int i, Object obj, Object obj2) {
        zzul zzstVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsy.zzK(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u0004\u0002\u001b", new Object[]{"zzf", "zzg", zzqb.class});
        }
        if (i2 == 3) {
            return new zzpz();
        }
        zzpv zzpvVar = null;
        if (i2 == 4) {
            return new zzpy(zzpvVar);
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
        synchronized (zzpz.class) {
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
