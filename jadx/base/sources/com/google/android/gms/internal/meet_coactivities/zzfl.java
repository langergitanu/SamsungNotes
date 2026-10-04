package com.google.android.gms.internal.meet_coactivities;

import com.google.android.meet.addons.AddonSession;
import com.google.common.util.concurrent.FutureCallback;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzfl implements FutureCallback {
    public static final /* synthetic */ int zzb = 0;
    final /* synthetic */ zzfm zza;

    public zzfl(zzfm zzfmVar) {
        this.zza = zzfmVar;
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onFailure(Throwable th) {
        ((zzkv) zzfm.zza.zze().zzh("com/google/android/meet/addons/internal/AddonSessionBuilderImpl$3", "onFailure", 267, "AddonSessionBuilderImpl.java")).zzo("Session future failed; not registering disconnect listener.");
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        final AddonSession addonSession = (AddonSession) obj;
        this.zza.zzc.zzQ(new Runnable() { // from class: com.google.android.gms.internal.meet_coactivities.zzfk
            @Override // java.lang.Runnable
            public final void run() {
                ((zzfs) addonSession).zzc();
            }
        });
    }
}
