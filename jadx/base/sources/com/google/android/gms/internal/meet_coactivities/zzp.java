package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzp extends zzsy implements zzuf {
    private static final zzp zzb;
    private static volatile zzul zze;
    private int zzg;
    private int zzh;
    private long zzj;
    private boolean zzk;
    private zztc zzf = zzsy.zzF();
    private String zzi = "";

    static {
        zzp zzpVar = new zzp();
        zzb = zzpVar;
        zzsy.zzN(zzp.class, zzpVar);
    }

    private zzp() {
    }

    public static zzo zzc() {
        return (zzo) zzb.zzA();
    }

    public static /* synthetic */ void zzg(zzp zzpVar, String str) {
        str.getClass();
        zzpVar.zzi = str;
    }

    public final long zza() {
        return this.zzj;
    }

    public final zzj zzb() {
        int i = this.zzh;
        zzj zzjVar = i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? null : zzj.HOST_APP_FAKE_TACHYON : zzj.HOST_APP_DUET : zzj.HOST_APP_MIG : zzj.HOST_APP_HAM : zzj.HOST_APP_UNKNOWN;
        return zzjVar == null ? zzj.UNRECOGNIZED : zzjVar;
    }

    public final String zze() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsy
    public final Object zzi(int i, Object obj, Object obj2) {
        zzul zzstVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsy.zzK(zzb, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0001\u0000\u0001,\u0002\f\u0003\f\u0004Ȉ\u0005\u0003\u0006\u0007", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new zzp();
        }
        zze zzeVar = null;
        if (i2 == 4) {
            return new zzo(zzeVar);
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
        synchronized (zzp.class) {
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

    public final boolean zzk() {
        return this.zzk;
    }
}
