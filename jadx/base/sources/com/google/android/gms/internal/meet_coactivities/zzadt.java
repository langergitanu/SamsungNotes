package com.google.android.gms.internal.meet_coactivities;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzadt implements zzaiw {
    private final AtomicLong zza = new AtomicLong();

    @Override // com.google.android.gms.internal.meet_coactivities.zzaiw
    public final void zza(long j) {
        this.zza.getAndAdd(1L);
    }
}
