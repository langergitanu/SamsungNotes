package com.google.android.meet.addons;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.meet_coactivities.zzfa;
import com.google.android.gms.internal.meet_coactivities.zzij;
import com.google.android.meet.addons.annotations.PublicApi;
import com.google.common.base.Preconditions;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@PublicApi
public final class AddonClientFactory {
    private static final Object zza = new Object();
    private static Optional zzb = Optional.empty();
    private static Optional zzc = Optional.empty();

    private AddonClientFactory() {
    }

    @NonNull
    public static AddonClient getClient(long j) {
        return getClient(j, Optional.empty(), Optional.empty());
    }

    /* JADX WARN: Type inference failed for: r8v8, types: [com.google.android.meet.addons.AddonClient, java.lang.Object] */
    @NonNull
    public static AddonClient getClient(long j, @NonNull Optional<ExecutorService> optional, @NonNull Optional<ScheduledExecutorService> optional2) {
        ?? r8;
        Preconditions.checkArgument(j > 0, "Expected 'cloudProjectNumber' to be provided.");
        synchronized (zza) {
            try {
                if (!zzb.isPresent()) {
                    zzb = Optional.of(new zzfa(j, optional, optional2, zzij.zzb()));
                    zzc = Optional.of(Long.valueOf(j));
                } else {
                    if (!((Long) zzc.get()).equals(Long.valueOf(j))) {
                        throw new IllegalArgumentException("Unexpected change in cloud project number.");
                    }
                }
                r8 = zzb.get();
            } catch (Throwable th) {
                throw th;
            }
        }
        return r8;
    }
}
