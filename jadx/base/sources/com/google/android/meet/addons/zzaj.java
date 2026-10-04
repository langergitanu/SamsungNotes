package com.google.android.meet.addons;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface zzaj extends AddonClient {
    @Deprecated
    ListenableFuture zza(CoDoingHandler coDoingHandler, Optional optional);

    @Deprecated
    ListenableFuture zzb(CoWatchingHandler coWatchingHandler, Optional optional);

    @Deprecated
    ListenableFuture zzc(Context context, AddonSessionHandler addonSessionHandler);

    @Deprecated
    ListenableFuture zzd();
}
