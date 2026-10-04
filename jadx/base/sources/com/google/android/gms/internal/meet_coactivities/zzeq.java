package com.google.android.gms.internal.meet_coactivities;

import com.google.common.util.concurrent.FutureCallback;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzeq implements FutureCallback {
    final /* synthetic */ zzfa zza;

    public zzeq(zzfa zzfaVar) {
        this.zza = zzfaVar;
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onFailure(Throwable th) {
        ((zzkv) ((zzkv) zzfa.zzd.zzd().zzg(th)).zzh("com/google/android/meet/addons/internal/AddonClientImpl$1", "onFailure", 357, "AddonClientImpl.java")).zzo("connectMeeting call to IpcManager failed.");
        this.zza.zzai();
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        ((zzkv) zzfa.zzd.zzb().zzh("com/google/android/meet/addons/internal/AddonClientImpl$1", "onSuccess", 349, "AddonClientImpl.java")).zzo("connectMeeting call to IpcManager succeeded.");
        this.zza.zzr = new zzip();
    }
}
