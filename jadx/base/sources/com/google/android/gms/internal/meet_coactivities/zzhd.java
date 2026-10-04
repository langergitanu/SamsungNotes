package com.google.android.gms.internal.meet_coactivities;

import com.google.android.meet.addons.CoWatchingHandler;
import com.google.android.meet.addons.CoWatchingState;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzhd implements zzib {
    private final CoWatchingHandler zza;
    private final Executor zzb;

    private zzhd(CoWatchingHandler coWatchingHandler, Executor executor) {
        this.zza = coWatchingHandler;
        this.zzb = executor;
    }

    public static zzhd zza(CoWatchingHandler coWatchingHandler, Executor executor) {
        return new zzhd(coWatchingHandler, executor);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzib
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        final CoWatchingState coWatchingState = (CoWatchingState) obj;
        zzia.zza(Futures.submit(new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzhc
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzc(coWatchingState);
            }
        }, this.zzb), "Failed to apply state.", new Object[0]);
    }

    public final /* synthetic */ void zzc(CoWatchingState coWatchingState) {
        this.zza.onCoWatchingStateChanged(coWatchingState);
    }
}
