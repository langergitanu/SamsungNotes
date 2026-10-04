package com.google.android.gms.internal.meet_coactivities;

import com.google.android.meet.addons.AddonMeetingInfo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzjw implements zzkm {
    public static final AddonMeetingInfo zzb(zzl zzlVar) {
        AddonMeetingInfo.MeetingStatus meetingStatus;
        AddonMeetingInfo.Builder builder = AddonMeetingInfo.builder();
        builder.setMeetingCode(zzlVar.zzf());
        builder.setMeetingUrl(zzlVar.zzg());
        zzal zzalVarZzd = zzlVar.zzd();
        AddonMeetingInfo.MeetingStatus meetingStatus2 = AddonMeetingInfo.MeetingStatus.NOT_CONNECTED;
        switch (zzalVarZzd) {
            case UNKNOWN:
            case CONNECTING:
            case ENDING:
            case ENDED:
            case NOT_CONNECTED:
            case ENDED_UNEXPECTEDLY:
            case ENDED_DUE_TO_RECORDING_STATUS_DESYNC:
            case UNRECOGNIZED:
                meetingStatus = AddonMeetingInfo.MeetingStatus.NOT_CONNECTED;
                break;
            case CONNECTED:
                meetingStatus = AddonMeetingInfo.MeetingStatus.CONNECTED;
                break;
            case CONNECTED_WITH_COACTIVITY:
            case CONNECTED_WITH_COACTIVITY_LOCAL_USER_LEFT:
                meetingStatus = AddonMeetingInfo.MeetingStatus.CONNECTED_WITH_ADDON_SESSION;
                break;
            default:
                throw new AssertionError();
        }
        builder.setMeetingStatus(meetingStatus);
        builder.setRecordingInfo(zzkn.zzb(zzlVar.zze()));
        return builder.build();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzkm
    public final /* bridge */ /* synthetic */ Object zza(Object obj) {
        throw null;
    }
}
