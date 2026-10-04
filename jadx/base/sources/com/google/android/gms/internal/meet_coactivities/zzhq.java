package com.google.android.gms.internal.meet_coactivities;

import com.google.common.util.concurrent.FutureCallback;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzhq implements FutureCallback {
    final /* synthetic */ zzhs zza;

    public zzhq(zzhs zzhsVar) {
        this.zza = zzhsVar;
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onFailure(Throwable th) {
        zzia.zze(th);
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        try {
            this.zza.zzc.zzg((zzpx) obj);
        } catch (RuntimeException e) {
            zzia.zze(e);
        }
    }
}
