package com.google.android.meet.addons;

import com.google.android.meet.addons.MeetingStatus;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaa extends MeetingStatus.Builder {
    private MeetingStatus.Status zza;
    private RecordingInfo zzb;

    public zzaa() {
    }

    @Override // com.google.android.meet.addons.MeetingStatus.Builder
    public final MeetingStatus build() {
        RecordingInfo recordingInfo;
        MeetingStatus.Status status = this.zza;
        if (status != null && (recordingInfo = this.zzb) != null) {
            return new zzac(status, recordingInfo, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" status");
        }
        if (this.zzb == null) {
            sb.append(" recordingInfo");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.android.meet.addons.MeetingStatus.Builder
    public final MeetingStatus.Builder setRecordingInfo(RecordingInfo recordingInfo) {
        if (recordingInfo == null) {
            throw new NullPointerException("Null recordingInfo");
        }
        this.zzb = recordingInfo;
        return this;
    }

    @Override // com.google.android.meet.addons.MeetingStatus.Builder
    public final MeetingStatus.Builder setStatus(MeetingStatus.Status status) {
        if (status == null) {
            throw new NullPointerException("Null status");
        }
        this.zza = status;
        return this;
    }

    public zzaa(MeetingStatus meetingStatus) {
        this.zza = meetingStatus.status();
        this.zzb = meetingStatus.recordingInfo();
    }
}
