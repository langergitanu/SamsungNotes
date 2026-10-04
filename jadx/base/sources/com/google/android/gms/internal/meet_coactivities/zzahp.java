package com.google.android.gms.internal.meet_coactivities;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzahp implements zzaoo {
    public final String toString() {
        return "grpc-default-executor";
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaoo
    public final /* bridge */ /* synthetic */ Object zza() {
        return Executors.newCachedThreadPool(zzahv.zzd("grpc-default-executor-%d", true));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaoo
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        ((ExecutorService) obj).shutdown();
    }
}
