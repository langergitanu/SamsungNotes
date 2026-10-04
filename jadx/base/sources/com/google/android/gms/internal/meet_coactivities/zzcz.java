package com.google.android.gms.internal.meet_coactivities;

import com.google.common.util.concurrent.FutureCallback;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzcz implements FutureCallback {
    final /* synthetic */ String zza;

    public zzcz(String str) {
        this.zza = str;
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onFailure(Throwable th) {
        ((zzkv) ((zzkv) zzda.zza.zze().zzg(th)).zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl$2", "onFailure", 1023, "MeetIpcManagerImpl.java")).zzp("IPC call for %s failed.", this.zza);
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onSuccess(Object obj) {
        ((zzkv) zzda.zza.zzb().zzh("com/google/android/libraries/communications/sdk/sync/ipc/MeetIpcManagerImpl$2", "onSuccess", 1018, "MeetIpcManagerImpl.java")).zzp("IPC call for %s succeeded.", this.zza);
    }
}
