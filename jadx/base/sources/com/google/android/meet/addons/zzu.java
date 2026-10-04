package com.google.android.meet.addons;

import com.google.android.meet.addons.CoWatchingState;
import java.time.Duration;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzu extends CoWatchingState.Builder {
    private String zza;
    private Duration zzb;
    private double zzc;
    private CoWatchingState.PlaybackState zzd;
    private CoWatchingQueue zze;
    private byte zzf;

    public zzu() {
    }

    @Override // com.google.android.meet.addons.CoWatchingState.Builder
    public final CoWatchingState build() {
        String str;
        Duration duration;
        CoWatchingState.PlaybackState playbackState;
        CoWatchingQueue coWatchingQueue;
        if (this.zzf == 1 && (str = this.zza) != null && (duration = this.zzb) != null && (playbackState = this.zzd) != null && (coWatchingQueue = this.zze) != null) {
            return new zzw(str, duration, this.zzc, playbackState, coWatchingQueue, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" mediaId");
        }
        if (this.zzb == null) {
            sb.append(" mediaPlayoutPosition");
        }
        if (this.zzf == 0) {
            sb.append(" mediaPlayoutRate");
        }
        if (this.zzd == null) {
            sb.append(" playbackState");
        }
        if (this.zze == null) {
            sb.append(" coWatchingQueue");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.android.meet.addons.CoWatchingState.Builder
    public final CoWatchingState.Builder setCoWatchingQueue(CoWatchingQueue coWatchingQueue) {
        if (coWatchingQueue == null) {
            throw new NullPointerException("Null coWatchingQueue");
        }
        this.zze = coWatchingQueue;
        return this;
    }

    @Override // com.google.android.meet.addons.CoWatchingState.Builder
    public final CoWatchingState.Builder setMediaId(String str) {
        if (str == null) {
            throw new NullPointerException("Null mediaId");
        }
        this.zza = str;
        return this;
    }

    @Override // com.google.android.meet.addons.CoWatchingState.Builder
    public final CoWatchingState.Builder setMediaPlayoutPosition(Duration duration) {
        if (duration == null) {
            throw new NullPointerException("Null mediaPlayoutPosition");
        }
        this.zzb = duration;
        return this;
    }

    @Override // com.google.android.meet.addons.CoWatchingState.Builder
    public final CoWatchingState.Builder setMediaPlayoutRate(double d) {
        this.zzc = d;
        this.zzf = (byte) 1;
        return this;
    }

    @Override // com.google.android.meet.addons.CoWatchingState.Builder
    public final CoWatchingState.Builder setPlaybackState(CoWatchingState.PlaybackState playbackState) {
        if (playbackState == null) {
            throw new NullPointerException("Null playbackState");
        }
        this.zzd = playbackState;
        return this;
    }

    public zzu(CoWatchingState coWatchingState) {
        this.zza = coWatchingState.mediaId();
        this.zzb = coWatchingState.mediaPlayoutPosition();
        this.zzc = coWatchingState.mediaPlayoutRate();
        this.zzd = coWatchingState.playbackState();
        this.zze = coWatchingState.coWatchingQueue();
        this.zzf = (byte) 1;
    }
}
