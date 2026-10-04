package com.google.android.gms.internal.meet_coactivities;

import androidx.annotation.Nullable;
import com.google.common.util.concurrent.ListenableScheduledFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzid {

    @Nullable
    private final ScheduledFuture zza;

    private zzid(@Nullable ListenableScheduledFuture listenableScheduledFuture) {
        this.zza = listenableScheduledFuture;
    }

    public static zzid zza(zzgg zzggVar, final Runnable runnable, ListeningScheduledExecutorService listeningScheduledExecutorService) {
        return zzggVar.zzd() ? new zzid(null) : new zzid(listeningScheduledExecutorService.scheduleAtFixedRate(new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzic
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    runnable.run();
                } catch (RuntimeException e) {
                    zzia.zze(e);
                }
            }
        }, zzggVar.zza().toMillis(), zzggVar.zza().toMillis(), TimeUnit.MILLISECONDS));
    }

    public final void zzb() {
        ScheduledFuture scheduledFuture = this.zza;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }
}
