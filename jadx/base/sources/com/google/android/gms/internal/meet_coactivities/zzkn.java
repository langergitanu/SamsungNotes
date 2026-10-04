package com.google.android.gms.internal.meet_coactivities;

import com.google.android.meet.addons.RecordingInfo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzkn implements zzkm {
    public static final RecordingInfo zzb(zzaq zzaqVar) {
        RecordingInfo.Builder builder = RecordingInfo.builder();
        int iZzd = zzaqVar.zzd() - 2;
        builder.setStatus(iZzd != 1 ? iZzd != 2 ? RecordingInfo.RecordingStatus.UNKNOWN : RecordingInfo.RecordingStatus.RECORDING : RecordingInfo.RecordingStatus.NOT_RECORDING);
        return builder.build();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzkm
    public final /* bridge */ /* synthetic */ Object zza(Object obj) {
        throw null;
    }
}
