package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbe extends zzsy implements zzuf {
    private static final zzbe zzb;
    private static volatile zzul zze;
    private int zzf;
    private zzbd zzg;
    private zzbb zzh;
    private zzaq zzi;

    static {
        zzbe zzbeVar = new zzbe();
        zzb = zzbeVar;
        zzsy.zzN(zzbe.class, zzbeVar);
    }

    private zzbe() {
    }

    public static zzav zzb() {
        return (zzav) zzb.zzA();
    }

    public static zzbe zzf(byte[] bArr, zzsj zzsjVar) {
        return (zzbe) zzsy.zzE(zzb, bArr, zzsjVar);
    }

    public static /* synthetic */ void zzg(zzbe zzbeVar, zzbd zzbdVar) {
        zzbdVar.getClass();
        zzbeVar.zzg = zzbdVar;
        zzbeVar.zzf |= 1;
    }

    public static /* synthetic */ void zzh(zzbe zzbeVar, zzbb zzbbVar) {
        zzbbVar.getClass();
        zzbeVar.zzh = zzbbVar;
        zzbeVar.zzf |= 2;
    }

    public static /* synthetic */ void zzj(zzbe zzbeVar, zzaq zzaqVar) {
        zzaqVar.getClass();
        zzbeVar.zzi = zzaqVar;
        zzbeVar.zzf |= 4;
    }

    public final zzaq zza() {
        zzaq zzaqVar = this.zzi;
        return zzaqVar == null ? zzaq.zzc() : zzaqVar;
    }

    public final zzbb zzc() {
        zzbb zzbbVar = this.zzh;
        return zzbbVar == null ? zzbb.zzd() : zzbbVar;
    }

    public final zzbd zzd() {
        zzbd zzbdVar = this.zzg;
        return zzbdVar == null ? zzbd.zzc() : zzbdVar;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsy
    public final Object zzi(int i, Object obj, Object obj2) {
        zzul zzstVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsy.zzK(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzbe();
        }
        zze zzeVar = null;
        if (i2 == 4) {
            return new zzav(zzeVar);
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
        synchronized (zzbe.class) {
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
