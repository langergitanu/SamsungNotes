package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import java.util.IdentityHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@ThreadSafe
public final class zzaop {
    private static final zzaop zza = new zzaop(new zzaol());
    private final IdentityHashMap zzb = new IdentityHashMap();
    private ScheduledExecutorService zzc;

    public zzaop(zzaol zzaolVar) {
    }

    public static Object zza(zzaoo zzaooVar) {
        return zza.zzb(zzaooVar);
    }

    public static Object zzc(zzaoo zzaooVar, Object obj) {
        zza.zzd(zzaooVar, obj);
        return null;
    }

    public final synchronized Object zzb(zzaoo zzaooVar) {
        zzaon zzaonVar;
        try {
            zzaonVar = (zzaon) this.zzb.get(zzaooVar);
            if (zzaonVar == null) {
                zzaonVar = new zzaon(zzaooVar.zza());
                this.zzb.put(zzaooVar, zzaonVar);
            }
            ScheduledFuture scheduledFuture = zzaonVar.zzc;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                zzaonVar.zzc = null;
            }
            zzaonVar.zzb++;
        } catch (Throwable th) {
            throw th;
        }
        return zzaonVar.zza;
    }

    public final synchronized Object zzd(zzaoo zzaooVar, Object obj) {
        try {
            zzaon zzaonVar = (zzaon) this.zzb.get(zzaooVar);
            if (zzaonVar == null) {
                throw new IllegalArgumentException("No cached instance found for ".concat(String.valueOf(zzaooVar)));
            }
            Preconditions.checkArgument(obj == zzaonVar.zza, "Releasing the wrong instance");
            Preconditions.checkState(zzaonVar.zzb > 0, "Refcount has already reached zero");
            int i = zzaonVar.zzb - 1;
            zzaonVar.zzb = i;
            if (i == 0) {
                Preconditions.checkState(zzaonVar.zzc == null, "Destroy task already scheduled");
                if (this.zzc == null) {
                    this.zzc = Executors.newSingleThreadScheduledExecutor(zzahv.zzd("grpc-shared-destroyer-%d", true));
                }
                zzaonVar.zzc = this.zzc.schedule(new zzaiv(new zzaom(this, zzaonVar, zzaooVar, obj)), 1L, TimeUnit.SECONDS);
            }
        } catch (Throwable th) {
            throw th;
        }
        return null;
    }
}
