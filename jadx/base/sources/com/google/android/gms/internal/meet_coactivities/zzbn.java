package com.google.android.gms.internal.meet_coactivities;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbn extends zzsy implements zzuf {
    private static final zztd zzb = new zzbl();
    private static final zzbn zze;
    private static volatile zzul zzf;
    private int zzg;
    private int zzh;
    private zzpx zzi;
    private int zzj;
    private zzn zzk;
    private zztc zzl = zzsy.zzF();
    private zztf zzm = zzsy.zzG();
    private zzr zzn;

    static {
        zzbn zzbnVar = new zzbn();
        zze = zzbnVar;
        zzsy.zzN(zzbn.class, zzbnVar);
    }

    private zzbn() {
    }

    public static zzbn zze() {
        return zze;
    }

    public final zzn zza() {
        zzn zznVar = this.zzk;
        return zznVar == null ? zzn.zzc() : zznVar;
    }

    public final zzr zzb() {
        zzr zzrVar = this.zzn;
        return zzrVar == null ? zzr.zzc() : zzrVar;
    }

    public final zzal zzc() {
        zzal zzalVarZzb = zzal.zzb(this.zzj);
        return zzalVarZzb == null ? zzal.UNRECOGNIZED : zzalVarZzb;
    }

    public final zzpx zzf() {
        zzpx zzpxVar = this.zzi;
        return zzpxVar == null ? zzpx.zze() : zzpxVar;
    }

    public final List zzg() {
        return this.zzm;
    }

    public final List zzh() {
        return new zzte(this.zzl, zzb);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsy
    public final Object zzi(int i, Object obj, Object obj2) {
        zzul zzstVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsy.zzK(zze, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0002\u0000\u0001\f\u0002ဉ\u0000\u0003\f\u0004ဉ\u0001\u0005,\u0006\u001b\u0007ဉ\u0002", new Object[]{"zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", zzac.class, "zzn"});
        }
        if (i2 == 3) {
            return new zzbn();
        }
        zze zzeVar = null;
        if (i2 == 4) {
            return new zzbm(zzeVar);
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
        synchronized (zzbn.class) {
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

    public final boolean zzj() {
        return (this.zzg & 4) != 0;
    }
}
