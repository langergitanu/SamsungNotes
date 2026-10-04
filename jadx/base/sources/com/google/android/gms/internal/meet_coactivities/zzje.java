package com.google.android.gms.internal.meet_coactivities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.meet.addons.AddonMeetingInfo;
import com.google.android.meet.addons.RecordingInfo;
import java.util.Optional;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzje extends BroadcastReceiver {
    public static final /* synthetic */ int zza = 0;
    private static final zzkz zzb = zzkz.zzj("com/google/android/meet/addons/internal/sessiondetection/SessionDetectionResponseReceiver");
    private static final AddonMeetingInfo zzc;
    private final zziq zzd;

    static {
        AddonMeetingInfo.MeetingStatus meetingStatus = AddonMeetingInfo.MeetingStatus.NOT_CONNECTED;
        RecordingInfo.Builder builder = RecordingInfo.builder();
        builder.setStatus(RecordingInfo.RecordingStatus.UNKNOWN);
        zzc = zza(meetingStatus, builder.build());
    }

    public zzje(zziq zziqVar) {
        this.zzd = zziqVar;
    }

    private static AddonMeetingInfo zza(AddonMeetingInfo.MeetingStatus meetingStatus, RecordingInfo recordingInfo) {
        AddonMeetingInfo.Builder builder = AddonMeetingInfo.builder();
        builder.setMeetingCode("");
        builder.setMeetingUrl("");
        builder.setRecordingInfo(recordingInfo);
        builder.setMeetingStatus(meetingStatus);
        return builder.build();
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        AddonMeetingInfo addonMeetingInfoZza;
        boolean zZzf;
        Optional optionalOfNullable = Optional.ofNullable(getResultExtras(false));
        if (optionalOfNullable.isPresent()) {
            Optional map = optionalOfNullable.map(new Function() { // from class: com.google.android.gms.internal.meet_coactivities.zzjc
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i = zzje.zza;
                    return ((Bundle) obj).getByteArray("S11Y_SESSION_DETECTION_RESPONSE");
                }
            });
            if (((Boolean) map.map(new Function() { // from class: com.google.android.gms.internal.meet_coactivities.zzjd
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i = zzje.zza;
                    return Boolean.valueOf(((byte[]) obj).length > 0);
                }
            }).orElse(Boolean.FALSE)).booleanValue()) {
                try {
                    zzbe zzbeVarZzf = zzbe.zzf((byte[]) map.get(), zzsj.zza());
                    if (zzbeVarZzf.zzd().zze()) {
                        if (zzbeVarZzf.zzc().zzg()) {
                            zZzf = zzbeVarZzf.zzc().zzf();
                        } else {
                            zZzf = !(zzbeVarZzf.zzc().zza().zze() == 4);
                        }
                        if (zZzf) {
                            int iZzh = zzbeVarZzf.zzc().zzh();
                            int i = iZzh - 1;
                            if (iZzh == 0) {
                                throw null;
                            }
                            if (i != 0) {
                                ((zzkv) zzb.zzc().zzh("com/google/android/meet/addons/internal/sessiondetection/SessionDetectionResponseReceiver", "sessionStatus", 111, "SessionDetectionResponseReceiver.java")).zzo("Ongoing meeting.");
                                addonMeetingInfoZza = zza(AddonMeetingInfo.MeetingStatus.CONNECTED, zzkn.zzb(zzbeVarZzf.zza()));
                            } else {
                                ((zzkv) zzb.zzc().zzh("com/google/android/meet/addons/internal/sessiondetection/SessionDetectionResponseReceiver", "sessionStatus", 107, "SessionDetectionResponseReceiver.java")).zzo("Ongoing live sharing session.");
                                addonMeetingInfoZza = zza(AddonMeetingInfo.MeetingStatus.CONNECTED_WITH_ADDON_SESSION, zzkn.zzb(zzbeVarZzf.zza()));
                            }
                        } else {
                            ((zzkv) zzb.zzc().zzh("com/google/android/meet/addons/internal/sessiondetection/SessionDetectionResponseReceiver", "sessionStatus", 101, "SessionDetectionResponseReceiver.java")).zzo("Local user does not have live sharing enabled.");
                            addonMeetingInfoZza = zza(AddonMeetingInfo.MeetingStatus.CONNECTED, zzkn.zzb(zzbeVarZzf.zza()));
                        }
                    } else {
                        ((zzkv) zzb.zze().zzh("com/google/android/meet/addons/internal/sessiondetection/SessionDetectionResponseReceiver", "parseResponse", 151, "SessionDetectionResponseReceiver.java")).zzo("Invalid state proto detected");
                        addonMeetingInfoZza = zzc;
                    }
                } catch (zzti e) {
                    ((zzkv) ((zzkv) zzb.zze().zzg(e)).zzh("com/google/android/meet/addons/internal/sessiondetection/SessionDetectionResponseReceiver", "parseResponse", 145, "SessionDetectionResponseReceiver.java")).zzo("Error parsing bytes and converting to proto");
                    addonMeetingInfoZza = zzc;
                }
            } else {
                ((zzkv) zzb.zze().zzh("com/google/android/meet/addons/internal/sessiondetection/SessionDetectionResponseReceiver", "parseResponse", 132, "SessionDetectionResponseReceiver.java")).zzo("Received response from Meet but proto was empty");
                addonMeetingInfoZza = zzc;
            }
        } else {
            ((zzkv) zzb.zzc().zzh("com/google/android/meet/addons/internal/sessiondetection/SessionDetectionResponseReceiver", "parseResponse", 124, "SessionDetectionResponseReceiver.java")).zzo("Result Extras was empty");
            addonMeetingInfoZza = zzc;
        }
        ((zzit) this.zzd).zza.set(addonMeetingInfoZza);
    }
}
