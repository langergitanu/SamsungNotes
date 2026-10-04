package com.google.android.gms.internal.meet_coactivities;

import com.google.android.meet.addons.CoDoingHandler;
import com.google.android.meet.addons.CoDoingState;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzgo implements zzib {
    private final CoDoingHandler zza;
    private final Executor zzb;

    private zzgo(CoDoingHandler coDoingHandler, Executor executor) {
        this.zza = coDoingHandler;
        this.zzb = executor;
    }

    public static zzgo zza(CoDoingHandler coDoingHandler, Executor executor) {
        return new zzgo(coDoingHandler, executor);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzib
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        final CoDoingState coDoingState = (CoDoingState) obj;
        zzia.zza(Futures.submit(new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzgn
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzc(coDoingState);
            }
        }, this.zzb), "Failed to apply state.", new Object[0]);
    }

    public final /* synthetic */ void zzc(CoDoingState coDoingState) {
        this.zza.onGlobalStateChanged(coDoingState);
    }
}
