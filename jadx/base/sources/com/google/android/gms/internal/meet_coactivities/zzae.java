package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzae extends zzsy implements zzuf {
    private static final zzae zzb;
    private static volatile zzul zze;
    private int zzf;
    private zzl zzg;
    private zzao zzh;
    private int zzi;

    static {
        zzae zzaeVar = new zzae();
        zzb = zzaeVar;
        zzsy.zzN(zzae.class, zzaeVar);
    }

    private zzae() {
    }

    public static zzad zza() {
        return (zzad) zzb.zzA();
    }

    public static zzae zzc() {
        return zzb;
    }

    public static /* synthetic */ void zzd(zzae zzaeVar, zzl zzlVar) {
        zzlVar.getClass();
        zzaeVar.zzg = zzlVar;
        zzaeVar.zzf |= 1;
    }

    public static /* synthetic */ void zze(zzae zzaeVar, zzao zzaoVar) {
        zzaeVar.zzh = zzaoVar;
        zzaeVar.zzf |= 2;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsy
    public final Object zzi(int i, Object obj, Object obj2) {
        zzul zzstVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsy.zzK(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\f", new Object[]{"zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzae();
        }
        zze zzeVar = null;
        if (i2 == 4) {
            return new zzad(zzeVar);
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
        synchronized (zzae.class) {
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
