package com.google.android.meet.addons;

import com.google.android.meet.addons.RecordingInfo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzad extends RecordingInfo.Builder {
    private RecordingInfo.RecordingStatus zza;

    @Override // com.google.android.meet.addons.RecordingInfo.Builder
    public final RecordingInfo build() {
        RecordingInfo.RecordingStatus recordingStatus = this.zza;
        if (recordingStatus != null) {
            return new zzaf(recordingStatus, null);
        }
        throw new IllegalStateException("Missing required properties: status");
    }

    @Override // com.google.android.meet.addons.RecordingInfo.Builder
    public final RecordingInfo.Builder setStatus(RecordingInfo.RecordingStatus recordingStatus) {
        if (recordingStatus == null) {
            throw new NullPointerException("Null status");
        }
        this.zza = recordingStatus;
        return this;
    }
}
