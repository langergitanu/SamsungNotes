package com.google.android.gms.internal.meet_coactivities;

import com.google.android.meet.addons.ParticipantMetadataHandler;
import com.google.common.util.concurrent.FutureCallback;
import com.sun.imageio.plugins.jpeg.JPEG;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzfi implements FutureCallback {
    final /* synthetic */ ParticipantMetadataHandler zza;
    final /* synthetic */ zzfm zzb;

    public zzfi(zzfm zzfmVar, ParticipantMetadataHandler participantMetadataHandler) {
        this.zza = participantMetadataHandler;
        this.zzb = zzfmVar;
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onFailure(Throwable th) {
        ((zzkv) zzfm.zza.zze().zzh("com/google/android/meet/addons/internal/AddonSessionBuilderImpl$1", "onFailure", JPEG.APP0, "AddonSessionBuilderImpl.java")).zzo("Session future failed; not setting participant metadata.");
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        zzfm zzfmVar = this.zzb;
        zzfmVar.zzc.zzU(zzfmVar.zzh, this.zza);
    }
}
