package com.google.android.gms.internal.meet_coactivities;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzir {
    public static final Executor zza = MoreExecutors.directExecutor();

    public static ListeningExecutorService zza(Optional optional) {
        return MoreExecutors.listeningDecorator(optional.isPresent() ? (ExecutorService) optional.get() : Executors.newSingleThreadExecutor());
    }
}
