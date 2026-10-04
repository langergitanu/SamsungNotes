package com.google.android.gms.internal.meet_coactivities;

import java.util.concurrent.Future;
import javax.annotation.CheckForNull;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzanb {
    final Object zza;

    @GuardedBy("lock")
    Future zzb;

    @GuardedBy("lock")
    boolean zzc;

    public zzanb(Object obj) {
        this.zza = obj;
    }

    @CheckForNull
    @GuardedBy("lock")
    public final Future zza() {
        this.zzc = true;
        return this.zzb;
    }

    public final void zzb(Future future) {
        boolean z;
        synchronized (this.zza) {
            try {
                z = this.zzc;
                if (!z) {
                    this.zzb = future;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            future.cancel(false);
        }
    }
}
