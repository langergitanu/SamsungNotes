package com.google.android.meet.addons;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.meet.addons.MeetingStatus;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzac extends MeetingStatus {
    private final MeetingStatus.Status zza;
    private final RecordingInfo zzb;

    public /* synthetic */ zzac(MeetingStatus.Status status, RecordingInfo recordingInfo, zzab zzabVar) {
        this.zza = status;
        this.zzb = recordingInfo;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MeetingStatus) {
            MeetingStatus meetingStatus = (MeetingStatus) obj;
            if (this.zza.equals(meetingStatus.status()) && this.zzb.equals(meetingStatus.recordingInfo())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode();
    }

    @Override // com.google.android.meet.addons.MeetingStatus
    public final RecordingInfo recordingInfo() {
        return this.zzb;
    }

    @Override // com.google.android.meet.addons.MeetingStatus
    public final MeetingStatus.Status status() {
        return this.zza;
    }

    @Override // com.google.android.meet.addons.MeetingStatus
    public final MeetingStatus.Builder toBuilder() {
        return new zzaa(this);
    }

    public final String toString() {
        return AbstractC0541b.m775q("MeetingStatus{status=", this.zza.toString(), ", recordingInfo=", this.zzb.toString(), "}");
    }
}
