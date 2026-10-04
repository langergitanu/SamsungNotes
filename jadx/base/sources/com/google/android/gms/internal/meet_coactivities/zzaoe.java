package com.google.android.gms.internal.meet_coactivities;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaoe extends zzaoc {
    private final AtomicIntegerFieldUpdater zza;

    public /* synthetic */ zzaoe(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, zzaod zzaodVar) {
        super(null);
        this.zza = atomicIntegerFieldUpdater;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaoc
    public final void zza(zzaoh zzaohVar, int i) {
        this.zza.set(zzaohVar, 0);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaoc
    public final boolean zzb(zzaoh zzaohVar, int i, int i2) {
        return this.zza.compareAndSet(zzaohVar, 0, -1);
    }
}
