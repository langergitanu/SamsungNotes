package com.google.android.gms.internal.meet_coactivities;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzu extends zzsy implements zzuf {
    private static final zzu zzb;
    private static volatile zzul zze;
    private int zzf;
    private zzao zzg;
    private zzi zzh;
    private String zzi = "";
    private String zzj = "";
    private zztc zzk = zzsy.zzF();
    private long zzl;
    private boolean zzm;

    static {
        zzu zzuVar = new zzu();
        zzb = zzuVar;
        zzsy.zzN(zzu.class, zzuVar);
    }

    private zzu() {
    }

    public static zzs zza() {
        return (zzs) zzb.zzA();
    }

    public static zzu zzc() {
        return zzb;
    }

    public static /* synthetic */ void zzd(zzu zzuVar, String str) {
        str.getClass();
        zzuVar.zzi = str;
    }

    public static /* synthetic */ void zze(zzu zzuVar, String str) {
        str.getClass();
        zzuVar.zzj = str;
    }

    public static /* synthetic */ void zzf(zzu zzuVar, Iterable iterable) {
        zztc zztcVar = zzuVar.zzk;
        if (!zztcVar.zzc()) {
            int size = zztcVar.size();
            zzuVar.zzk = zztcVar.zzd(size == 0 ? 10 : size + size);
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            zzuVar.zzk.zzh(((zzt) it.next()).zza());
        }
    }

    public static /* synthetic */ void zzj(zzu zzuVar, zzi zziVar) {
        zziVar.getClass();
        zzuVar.zzh = zziVar;
        zzuVar.zzf |= 2;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsy
    public final Object zzi(int i, Object obj, Object obj2) {
        zzul zzstVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsy.zzK(zzb, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003Ȉ\u0004Ȉ\u0005,\u0006\u0003\u0007\u0007", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
        }
        if (i2 == 3) {
            return new zzu();
        }
        zze zzeVar = null;
        if (i2 == 4) {
            return new zzs(zzeVar);
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
        synchronized (zzu.class) {
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
