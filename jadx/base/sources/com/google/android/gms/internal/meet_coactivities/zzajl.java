package com.google.android.gms.internal.meet_coactivities;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@VisibleForTesting
final class zzajl implements Executor {
    private final zzale zza;
    private Executor zzb;

    public zzajl(zzale zzaleVar) {
        this.zza = (zzale) Preconditions.checkNotNull(zzaleVar, "executorPool");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        zza().execute(runnable);
    }

    public final synchronized Executor zza() {
        try {
            if (this.zzb == null) {
                this.zzb = (Executor) Preconditions.checkNotNull((Executor) this.zza.zza(), "%s.getObject()", this.zzb);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.zzb;
    }

    public final synchronized void zzb() {
        Executor executor = this.zzb;
        if (executor != null) {
            this.zza.zzb(executor);
            this.zzb = null;
        }
    }
}
