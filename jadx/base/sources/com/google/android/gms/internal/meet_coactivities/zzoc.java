package com.google.android.gms.internal.meet_coactivities;

import android.annotation.SuppressLint;
import android.os.Build;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzoc extends zznv {
    static final boolean zza;
    static final boolean zzb;
    static final boolean zzc;
    private static final AtomicReference zzd;
    private static final AtomicLong zze;
    private static final ConcurrentLinkedQueue zzf;
    private volatile zzmn zzg;

    static {
        String str = Build.FINGERPRINT;
        zza = str == null || "robolectric".equals(str);
        String str2 = Build.HARDWARE;
        zzb = "goldfish".equals(str2) || "ranchu".equals(str2);
        String str3 = Build.TYPE;
        zzc = "eng".equals(str3) || "userdebug".equals(str3);
        zzd = new AtomicReference();
        zze = new AtomicLong();
        zzf = new ConcurrentLinkedQueue();
    }

    private zzoc(String str) {
        super(str);
        if (zza || zzb) {
            this.zzg = new zznw().zza(zza());
        } else if (zzc) {
            this.zzg = zzoi.zzf().zzb(false).zza(zza());
        } else {
            this.zzg = null;
        }
    }

    public static zzmn zze(String str) {
        AtomicReference atomicReference = zzd;
        if (atomicReference.get() != null) {
            return ((zznx) atomicReference.get()).zza(str);
        }
        int length = str.length();
        while (true) {
            length--;
            if (length >= 0) {
                char cCharAt = str.charAt(length);
                if (cCharAt != '$') {
                    if (cCharAt == '.') {
                        break;
                    }
                } else {
                    str = str.replace('$', '.');
                    break;
                }
            } else {
                break;
            }
        }
        zzoc zzocVar = new zzoc(str);
        zzoa.zza.offer(zzocVar);
        if (zzd.get() != null) {
            while (true) {
                zzoc zzocVar2 = (zzoc) zzoa.zza.poll();
                if (zzocVar2 == null) {
                    break;
                }
                zzocVar2.zzg = ((zznx) zzd.get()).zza(zzocVar2.zza());
            }
            zzf();
        }
        return zzocVar;
    }

    private static void zzf() {
        while (true) {
            zzob zzobVar = (zzob) zzf.poll();
            if (zzobVar == null) {
                return;
            }
            zze.getAndDecrement();
            zzmn zzmnVarZzb = zzobVar.zzb();
            zzml zzmlVarZza = zzobVar.zza();
            if (zzmlVarZza.zzv() || zzmnVarZzb.zzd(zzmlVarZza.zzl())) {
                zzmnVarZzb.zzc(zzmlVarZza);
            }
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zznv, com.google.android.gms.internal.meet_coactivities.zzmn
    public final void zzb(RuntimeException runtimeException, zzml zzmlVar) {
        if (this.zzg != null) {
            this.zzg.zzb(runtimeException, zzmlVar);
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzmn
    @SuppressLint({"LongLogTag"})
    public final void zzc(zzml zzmlVar) {
        if (this.zzg != null) {
            this.zzg.zzc(zzmlVar);
            return;
        }
        if (zze.incrementAndGet() > 20) {
            zzf.poll();
        }
        zzf.offer(new zzob(this, zzmlVar));
        if (this.zzg != null) {
            zzf();
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzmn
    public final boolean zzd(Level level) {
        return this.zzg == null || this.zzg.zzd(level);
    }
}
