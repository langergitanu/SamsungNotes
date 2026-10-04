package com.google.android.gms.internal.meet_coactivities;

import com.google.common.annotations.VisibleForTesting;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@VisibleForTesting
final class zzanu implements Runnable {
    final /* synthetic */ zzany zza;

    public zzanu(zzany zzanyVar) {
        this.zza = zzanyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzb();
    }
}
