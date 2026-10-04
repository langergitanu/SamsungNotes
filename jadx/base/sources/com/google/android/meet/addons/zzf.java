package com.google.android.meet.addons;

import com.google.android.meet.addons.AddonMeetingInfo;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzf extends AddonMeetingInfo.Builder {
    private String zza;
    private String zzb;
    private AddonMeetingInfo.MeetingStatus zzc;
    private RecordingInfo zzd;
    private Optional zze;
    private Optional zzf;

    public zzf() {
        this.zze = Optional.empty();
        this.zzf = Optional.empty();
    }

    @Override // com.google.android.meet.addons.AddonMeetingInfo.Builder
    public final AddonMeetingInfo build() {
        String str;
        AddonMeetingInfo.MeetingStatus meetingStatus;
        RecordingInfo recordingInfo;
        String str2 = this.zza;
        if (str2 != null && (str = this.zzb) != null && (meetingStatus = this.zzc) != null && (recordingInfo = this.zzd) != null) {
            return new zzh(str2, str, meetingStatus, recordingInfo, this.zze, this.zzf, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" meetingCode");
        }
        if (this.zzb == null) {
            sb.append(" meetingUrl");
        }
        if (this.zzc == null) {
            sb.append(" meetingStatus");
        }
        if (this.zzd == null) {
            sb.append(" recordingInfo");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.android.meet.addons.AddonMeetingInfo.Builder
    public final AddonMeetingInfo.Builder setInitialCoDoingState(CoDoingState coDoingState) {
        this.zzf = Optional.of(coDoingState);
        return this;
    }

    @Override // com.google.android.meet.addons.AddonMeetingInfo.Builder
    public final AddonMeetingInfo.Builder setInitialCoWatchingState(CoWatchingState coWatchingState) {
        this.zze = Optional.of(coWatchingState);
        return this;
    }

    @Override // com.google.android.meet.addons.AddonMeetingInfo.Builder
    public final AddonMeetingInfo.Builder setMeetingCode(String str) {
        if (str == null) {
            throw new NullPointerException("Null meetingCode");
        }
        this.zza = str;
        return this;
    }

    @Override // com.google.android.meet.addons.AddonMeetingInfo.Builder
    public final AddonMeetingInfo.Builder setMeetingStatus(AddonMeetingInfo.MeetingStatus meetingStatus) {
        if (meetingStatus == null) {
            throw new NullPointerException("Null meetingStatus");
        }
        this.zzc = meetingStatus;
        return this;
    }

    @Override // com.google.android.meet.addons.AddonMeetingInfo.Builder
    public final AddonMeetingInfo.Builder setMeetingUrl(String str) {
        if (str == null) {
            throw new NullPointerException("Null meetingUrl");
        }
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.meet.addons.AddonMeetingInfo.Builder
    public final AddonMeetingInfo.Builder setRecordingInfo(RecordingInfo recordingInfo) {
        if (recordingInfo == null) {
            throw new NullPointerException("Null recordingInfo");
        }
        this.zzd = recordingInfo;
        return this;
    }

    public zzf(AddonMeetingInfo addonMeetingInfo) {
        this.zze = Optional.empty();
        this.zzf = Optional.empty();
        this.zza = addonMeetingInfo.meetingCode();
        this.zzb = addonMeetingInfo.meetingUrl();
        this.zzc = addonMeetingInfo.meetingStatus();
        this.zzd = addonMeetingInfo.recordingInfo();
        this.zze = addonMeetingInfo.initialCoWatchingState();
        this.zzf = addonMeetingInfo.initialCoDoingState();
    }
}
