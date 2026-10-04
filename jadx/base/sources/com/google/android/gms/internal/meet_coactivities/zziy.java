package com.google.android.gms.internal.meet_coactivities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.meet.addons.MeetingStatus;
import com.google.android.meet.addons.MeetingStatusListener;
import com.google.android.meet.addons.RecordingInfo;
import com.google.common.base.VerifyException;
import java.util.Optional;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zziy extends BroadcastReceiver {
    public static final /* synthetic */ int zza = 0;
    private static final zzkz zzb = zzkz.zzj("com/google/android/meet/addons/internal/sessiondetection/MeetingStatusBroadcastReceiver");
    private static final zzbe zzc;
    private final MeetingStatusListener zzd;
    private final String zze;
    private final long zzf;

    static {
        zzav zzavVarZzb = zzbe.zzb();
        zzbc zzbcVarZza = zzbd.zza();
        zzbcVarZza.zza(false);
        zzavVarZzb.zzb(zzbcVarZza);
        zzba zzbaVarZzb = zzbb.zzb();
        zzbaVarZzb.zza(zzaz.zzb());
        zzavVarZzb.zza(zzbaVarZzb);
        zzap zzapVarZza = zzaq.zza();
        zzapVarZza.zza(2);
        zzavVarZzb.zzc(zzapVarZza);
        zzc = (zzbe) zzavVarZzb.zzk();
    }

    public zziy(MeetingStatusListener meetingStatusListener, String str, long j) {
        this.zzd = meetingStatusListener;
        this.zze = str;
        this.zzf = j;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        zzbe zzbeVar;
        Optional optionalOfNullable = Optional.ofNullable(getResultExtras(false) == null ? intent.getExtras() : getResultExtras(false));
        if (optionalOfNullable.isPresent()) {
            zzbeVar = (zzbe) optionalOfNullable.map(new Function() { // from class: com.google.android.gms.internal.meet_coactivities.zziw
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i = zziy.zza;
                    return ((Bundle) obj).getByteArray("S11Y_SESSION_DETECTION_RESPONSE");
                }
            }).map(new Function() { // from class: com.google.android.gms.internal.meet_coactivities.zzix
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    byte[] bArr = (byte[]) obj;
                    int i = zziy.zza;
                    try {
                        return zzbe.zzf(bArr, zzsj.zza());
                    } catch (zzti e) {
                        throw new VerifyException(e);
                    }
                }
            }).orElse(zzc);
        } else {
            ((zzkv) zzb.zze().zzh("com/google/android/meet/addons/internal/sessiondetection/MeetingStatusBroadcastReceiver", "parseResponse", 121, "MeetingStatusBroadcastReceiver.java")).zzo("Received an empty event notification from Meet side event bus.");
            zzbeVar = zzc;
        }
        RecordingInfo recordingInfoZzb = zzkn.zzb(zzbeVar.zza());
        zzkz zzkzVar = zzb;
        ((zzkv) zzkzVar.zzc().zzh("com/google/android/meet/addons/internal/sessiondetection/MeetingStatusBroadcastReceiver", "maybeNotifyListener", 87, "MeetingStatusBroadcastReceiver.java")).zzp("Meeting status event of %s received.", zzbeVar);
        int iZzh = zzbeVar.zzc().zzh();
        if (iZzh == 0) {
            throw null;
        }
        if (iZzh == 1) {
            zzax zzaxVarZza = zzbeVar.zzc().zza();
            if ((zzaxVarZza.zzd().equals(this.zze) && this.zzf == 0) || this.zzf == zzaxVarZza.zza()) {
                ((zzkv) zzkzVar.zzc().zzh("com/google/android/meet/addons/internal/sessiondetection/MeetingStatusBroadcastReceiver", "maybeNotifyListener", 90, "MeetingStatusBroadcastReceiver.java")).zzo("Notifying ongoing live sharing experience.");
                MeetingStatusListener meetingStatusListener = this.zzd;
                MeetingStatus.Builder builder = MeetingStatus.builder();
                builder.setStatus(MeetingStatus.Status.ADDON_SESSION);
                builder.setRecordingInfo(recordingInfoZzb);
                meetingStatusListener.onMeetingStatusChange(builder.build());
                return;
            }
        }
        if (zzbeVar.zzd().zze()) {
            ((zzkv) zzkzVar.zzc().zzh("com/google/android/meet/addons/internal/sessiondetection/MeetingStatusBroadcastReceiver", "maybeNotifyListener", 100, "MeetingStatusBroadcastReceiver.java")).zzo("Notifying ongoing conference in Meet app.");
            MeetingStatusListener meetingStatusListener2 = this.zzd;
            MeetingStatus.Builder builder2 = MeetingStatus.builder();
            builder2.setStatus(MeetingStatus.Status.MEETING);
            builder2.setRecordingInfo(recordingInfoZzb);
            meetingStatusListener2.onMeetingStatusChange(builder2.build());
            return;
        }
        if (zzbeVar.zzd().zze()) {
            return;
        }
        ((zzkv) zzkzVar.zzc().zzh("com/google/android/meet/addons/internal/sessiondetection/MeetingStatusBroadcastReceiver", "maybeNotifyListener", 110, "MeetingStatusBroadcastReceiver.java")).zzo("Notifying no meeting in the Meet app.");
        MeetingStatusListener meetingStatusListener3 = this.zzd;
        MeetingStatus.Builder builder3 = MeetingStatus.builder();
        builder3.setStatus(MeetingStatus.Status.NO_MEETING);
        builder3.setRecordingInfo(recordingInfoZzb);
        meetingStatusListener3.onMeetingStatusChange(builder3.build());
    }
}
