package com.google.android.gms.internal.meet_coactivities;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzn extends zzsy implements zzuf {
    private static final zzn zzb;
    private static volatile zzul zze;
    private zztf zzf = zzsy.zzG();
    private String zzg = "";
    private long zzh;

    static {
        zzn zznVar = new zzn();
        zzb = zznVar;
        zzsy.zzN(zzn.class, zznVar);
    }

    private zzn() {
    }

    public static zzm zza() {
        return (zzm) zzb.zzA();
    }

    public static zzn zzc() {
        return zzb;
    }

    public static /* synthetic */ void zze(zzn zznVar, zzrq zzrqVar) {
        zzrqVar.getClass();
        zztf zztfVar = zznVar.zzf;
        if (!zztfVar.zzc()) {
            zznVar.zzf = zzsy.zzH(zztfVar);
        }
        zznVar.zzf.add(zzrqVar);
    }

    public static /* synthetic */ void zzf(zzn zznVar, String str) {
        str.getClass();
        zznVar.zzg = str;
    }

    public final List zzd() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsy
    public final Object zzi(int i, Object obj, Object obj2) {
        zzul zzstVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsy.zzK(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001c\u0002Ȉ\u0003\u0002", new Object[]{"zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzn();
        }
        zze zzeVar = null;
        if (i2 == 4) {
            return new zzm(zzeVar);
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
        synchronized (zzn.class) {
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
