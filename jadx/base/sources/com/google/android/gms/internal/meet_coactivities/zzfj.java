package com.google.android.gms.internal.meet_coactivities;

import com.google.common.util.concurrent.FutureCallback;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzfj implements FutureCallback {
    final /* synthetic */ zzfm zza;

    public zzfj(zzfm zzfmVar) {
        this.zza = zzfmVar;
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onFailure(Throwable th) {
        ((zzkv) zzfm.zza.zze().zzh("com/google/android/meet/addons/internal/AddonSessionBuilderImpl$2", "onFailure", 248, "AddonSessionBuilderImpl.java")).zzo("Session future failed; not setting initial collaboration starting state.");
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        zzfm zzfmVar = this.zza;
        zzfmVar.zzc.zzS(zzfmVar.zzi);
    }
}
