package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzpx extends zzsy implements zzuf {
    private static final zzpx zzb;
    private static volatile zzul zze;
    private Object zzg;
    private long zzh;
    private boolean zzl;
    private boolean zzm;
    private long zzo;
    private int zzf = 0;
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";
    private String zzn = "";

    static {
        zzpx zzpxVar = new zzpx();
        zzb = zzpxVar;
        zzsy.zzN(zzpx.class, zzpxVar);
    }

    private zzpx() {
    }

    public static zzpw zzc() {
        return (zzpw) zzb.zzA();
    }

    public static zzpx zze() {
        return zzb;
    }

    public static /* synthetic */ void zzk(zzpx zzpxVar, zzqf zzqfVar) {
        zzqfVar.getClass();
        zzpxVar.zzg = zzqfVar;
        zzpxVar.zzf = 4;
    }

    public static /* synthetic */ void zzl(zzpx zzpxVar, zzqp zzqpVar) {
        zzqpVar.getClass();
        zzpxVar.zzg = zzqpVar;
        zzpxVar.zzf = 5;
    }

    public static /* synthetic */ void zzm(zzpx zzpxVar, zzqp zzqpVar) {
        zzqpVar.getClass();
        zzsy zzsyVarZzl = zzqpVar;
        if (zzpxVar.zzf == 5) {
            zzsyVarZzl = zzqpVar;
            if (zzpxVar.zzg != zzqp.zze()) {
                zzqk zzqkVarZzc = zzqp.zzc((zzqp) zzpxVar.zzg);
                zzqkVarZzc.zzj(zzqpVar);
                zzsyVarZzl = zzqkVarZzc.zzm();
            }
        }
        zzpxVar.zzg = zzsyVarZzl;
        zzpxVar.zzf = 5;
    }

    public static /* synthetic */ void zzo(zzpx zzpxVar, String str) {
        str.getClass();
        zzpxVar.zzn = str;
    }

    public final long zza() {
        return this.zzo;
    }

    public final long zzb() {
        return this.zzh;
    }

    public final zzqf zzf() {
        return this.zzf == 4 ? (zzqf) this.zzg : zzqf.zzd();
    }

    public final zzqp zzg() {
        return this.zzf == 5 ? (zzqp) this.zzg : zzqp.zze();
    }

    public final String zzh() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsy
    public final Object zzi(int i, Object obj, Object obj2) {
        zzul zzstVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsy.zzK(zzb, "\u0000\u000b\u0001\u0000\u0001\f\u000b\u0000\u0000\u0000\u0001\u0002\u0002Ȉ\u0003Ȉ\u0004<\u0000\u0005<\u0000\u0006\u0007\u0007\u0007\bȈ\tȈ\n\u0003\f<\u0000", new Object[]{"zzg", "zzf", "zzh", "zzi", "zzk", zzqf.class, zzqp.class, "zzl", "zzm", "zzn", "zzj", "zzo", zzqt.class});
        }
        if (i2 == 3) {
            return new zzpx();
        }
        zzpv zzpvVar = null;
        if (i2 == 4) {
            return new zzpw(zzpvVar);
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
        synchronized (zzpx.class) {
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

    public final boolean zzq() {
        return this.zzl;
    }

    public final boolean zzr() {
        return this.zzm;
    }

    public final boolean zzs() {
        return this.zzf == 4;
    }

    public final boolean zzt() {
        return this.zzf == 5;
    }

    public final int zzu() {
        int i = this.zzf;
        if (i == 0) {
            return 1;
        }
        if (i == 12) {
            return 13;
        }
        if (i != 4) {
            return i != 5 ? 0 : 6;
        }
        return 5;
    }
}
