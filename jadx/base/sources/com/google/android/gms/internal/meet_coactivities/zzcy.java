package com.google.android.gms.internal.meet_coactivities;

import com.google.common.util.concurrent.FutureCallback;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzcy implements FutureCallback {
    final /* synthetic */ String zza;

    public zzcy(zzda zzdaVar, String str) {
        this.zza = str;
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onFailure(Throwable th) {
        ((zzkv) ((zzkv) zzda.zza.zzd().zzg(th)).zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl$1", "onFailure", 991, "MeetIpcManagerImpl.java")).zzs("%s unsuccessful - thread %s", this.zza, Thread.currentThread().getName());
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        ((zzkv) zzda.zza.zzb().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl$1", "onSuccess", 986, "MeetIpcManagerImpl.java")).zzs("%s successful - thread %s", this.zza, Thread.currentThread().getName());
    }
}
