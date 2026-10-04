package com.google.android.meet.addons;

import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.google.android.meet.addons.AddonMeetingInfo;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzh extends AddonMeetingInfo {
    private final String zza;
    private final String zzb;
    private final AddonMeetingInfo.MeetingStatus zzc;
    private final RecordingInfo zzd;
    private final Optional zze;
    private final Optional zzf;

    public /* synthetic */ zzh(String str, String str2, AddonMeetingInfo.MeetingStatus meetingStatus, RecordingInfo recordingInfo, Optional optional, Optional optional2, zzg zzgVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = meetingStatus;
        this.zzd = recordingInfo;
        this.zze = optional;
        this.zzf = optional2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AddonMeetingInfo) {
            AddonMeetingInfo addonMeetingInfo = (AddonMeetingInfo) obj;
            if (this.zza.equals(addonMeetingInfo.meetingCode()) && this.zzb.equals(addonMeetingInfo.meetingUrl()) && this.zzc.equals(addonMeetingInfo.meetingStatus()) && this.zzd.equals(addonMeetingInfo.recordingInfo()) && this.zze.equals(addonMeetingInfo.initialCoWatchingState()) && this.zzf.equals(addonMeetingInfo.initialCoDoingState())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode()) * 1000003) ^ this.zzc.hashCode()) * 1000003) ^ this.zzd.hashCode()) * 1000003) ^ this.zze.hashCode()) * 1000003) ^ this.zzf.hashCode();
    }

    @Override // com.google.android.meet.addons.AddonMeetingInfo
    public final Optional<CoDoingState> initialCoDoingState() {
        return this.zzf;
    }

    @Override // com.google.android.meet.addons.AddonMeetingInfo
    public final Optional<CoWatchingState> initialCoWatchingState() {
        return this.zze;
    }

    @Override // com.google.android.meet.addons.AddonMeetingInfo
    public final String meetingCode() {
        return this.zza;
    }

    @Override // com.google.android.meet.addons.AddonMeetingInfo
    public final AddonMeetingInfo.MeetingStatus meetingStatus() {
        return this.zzc;
    }

    @Override // com.google.android.meet.addons.AddonMeetingInfo
    public final String meetingUrl() {
        return this.zzb;
    }

    @Override // com.google.android.meet.addons.AddonMeetingInfo
    public final RecordingInfo recordingInfo() {
        return this.zzd;
    }

    @Override // com.google.android.meet.addons.AddonMeetingInfo
    public final AddonMeetingInfo.Builder toBuilder() {
        return new zzf(this);
    }

    public final String toString() {
        Optional optional = this.zzf;
        Optional optional2 = this.zze;
        RecordingInfo recordingInfo = this.zzd;
        String string = this.zzc.toString();
        String string2 = recordingInfo.toString();
        String strValueOf = String.valueOf(optional2);
        String strValueOf2 = String.valueOf(optional);
        StringBuilder sb = new StringBuilder("AddonMeetingInfo{meetingCode=");
        sb.append(this.zza);
        sb.append(", meetingUrl=");
        AbstractC2821a.m2207B(sb, this.zzb, ", meetingStatus=", string, ", recordingInfo=");
        AbstractC2821a.m2207B(sb, string2, ", initialCoWatchingState=", strValueOf, ", initialCoDoingState=");
        return AbstractC0622a.m1170p(strValueOf2, "}", sb);
    }
}
