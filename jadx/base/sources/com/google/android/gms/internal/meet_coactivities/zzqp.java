package com.google.android.gms.internal.meet_coactivities;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzqp extends zzsy implements zzuf {
    private static final zzqp zzb;
    private static volatile zzul zze;
    private int zzf;
    private zzqj zzg;
    private int zzh;
    private zzty zzi = zzty.zza();

    static {
        zzqp zzqpVar = new zzqp();
        zzb = zzqpVar;
        zzsy.zzN(zzqp.class, zzqpVar);
    }

    private zzqp() {
    }

    public static zzqk zzb() {
        return (zzqk) zzb.zzA();
    }

    public static zzqk zzc(zzqp zzqpVar) {
        zzss zzssVarZzA = zzb.zzA();
        zzssVarZzA.zzj(zzqpVar);
        return (zzqk) zzssVarZzA;
    }

    public static zzqp zze() {
        return zzb;
    }

    public static /* synthetic */ Map zzf(zzqp zzqpVar) {
        if (!zzqpVar.zzi.zze()) {
            zzqpVar.zzi = zzqpVar.zzi.zzb();
        }
        return zzqpVar.zzi;
    }

    public static /* synthetic */ void zzh(zzqp zzqpVar, zzqj zzqjVar) {
        zzqjVar.getClass();
        zzqpVar.zzg = zzqjVar;
        zzqpVar.zzf |= 1;
    }

    public final zzqj zza() {
        zzqj zzqjVar = this.zzg;
        return zzqjVar == null ? zzqj.zze() : zzqjVar;
    }

    public final Map zzg() {
        return Collections.unmodifiableMap(this.zzi);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsy
    public final Object zzi(int i, Object obj, Object obj2) {
        zzul zzstVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsy.zzK(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0001\u0000\u0000\u0001ဉ\u0000\u0002\f\u00032", new Object[]{"zzf", "zzg", "zzh", "zzi", zzqm.zza});
        }
        if (i2 == 3) {
            return new zzqp();
        }
        zzpv zzpvVar = null;
        if (i2 == 4) {
            return new zzqk(zzpvVar);
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
        synchronized (zzqp.class) {
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
