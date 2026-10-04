package com.google.android.gms.internal.meet_coactivities;

import com.google.android.meet.addons.CoWatchingState;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzki implements zzkm {
    private final zzkf zza = zzkd.zza;

    private zzki() {
    }

    public static zzki zzc() {
        return zzkg.zza;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzkm
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final CoWatchingState zza(zzqj zzqjVar) {
        CoWatchingState.PlaybackState playbackState;
        CoWatchingState.Builder builder = CoWatchingState.builder();
        builder.setMediaId(zzqjVar.zzg());
        builder.setMediaPlayoutPosition(zzvt.zzb(zzqjVar.zzf()));
        int iZzo = zzqjVar.zzo() - 2;
        CoWatchingState.PlaybackState playbackState2 = CoWatchingState.PlaybackState.BUFFERING;
        if (iZzo == 1) {
            playbackState = CoWatchingState.PlaybackState.BUFFERING;
        } else if (iZzo == 2) {
            playbackState = CoWatchingState.PlaybackState.PLAY;
        } else if (iZzo == 3) {
            playbackState = CoWatchingState.PlaybackState.PAUSE;
        } else {
            if (iZzo != 4) {
                throw new AssertionError();
            }
            playbackState = CoWatchingState.PlaybackState.ENDED;
        }
        builder.setPlaybackState(playbackState);
        double dZza = zzqjVar.zza();
        if (dZza == 0.0d) {
            dZza = 1.0d;
        }
        builder.setMediaPlayoutRate(dZza);
        builder.setCoWatchingQueue(this.zza.zza(zzqjVar.zzb()));
        return builder.build();
    }

    public /* synthetic */ zzki(zzkh zzkhVar) {
    }
}
