package com.google.android.gms.internal.meet_coactivities;

import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzbu implements zzapn {
    private static final zzkz zza = zzkz.zzj("com/google/android/libraries/communications/sdk/sync/ipc/BroadcastStateUpdateResponseObserver");
    private final zzbw zzb;

    public zzbu(zzbw zzbwVar) {
        this.zzb = zzbwVar;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzapn
    public final void zza() {
        ((zzkv) zza.zzb().zzh("com/google/android/libraries/communications/sdk/sync/ipc/BroadcastStateUpdateResponseObserver", "onCompleted", 48, "BroadcastStateUpdateResponseObserver.java")).zzp("onCompleted called - thread %s", Thread.currentThread().getName());
        this.zzb.zzb(Optional.empty());
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzapn
    public final void zzb(Throwable th) {
        ((zzkv) ((zzkv) zza.zze().zzg(th)).zzh("com/google/android/libraries/communications/sdk/sync/ipc/BroadcastStateUpdateResponseObserver", "onError", 36, "BroadcastStateUpdateResponseObserver.java")).zzp("onError called - thread %s", Thread.currentThread().getName());
        this.zzb.zzb(Optional.of(th));
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzapn
    public final /* bridge */ /* synthetic */ void zzc(Object obj) {
        zzbn zzbnVar = (zzbn) obj;
        ((zzkv) zza.zzb().zzh("com/google/android/libraries/communications/sdk/sync/ipc/BroadcastStateUpdateResponseObserver", "onNext", 26, "BroadcastStateUpdateResponseObserver.java")).zzq("onNext called with response with lamport counter: %d - thread %s", zzbnVar.zzf().zzb(), Thread.currentThread().getName());
        this.zzb.zza(zzbnVar);
    }
}
