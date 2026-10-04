package com.google.android.gms.internal.meet_coactivities;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzip {
    private final AtomicBoolean zza = new AtomicBoolean(false);
    private final Set zzb = new HashSet();

    public final void zza() {
        if (this.zza.getAndSet(false)) {
            synchronized (this) {
                this.zzb.forEach(new Consumer() { // from class: com.google.android.gms.internal.meet_coactivities.zzio
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        ((Runnable) obj).run();
                    }
                });
            }
        }
    }

    public final synchronized void zzb(Runnable runnable) {
        this.zzb.add(runnable);
    }

    public final void zzc() {
        this.zza.set(true);
    }

    public final boolean zzd() {
        return this.zza.get();
    }
}
