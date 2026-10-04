package com.google.android.meet.addons;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.google.android.meet.addons.CoWatchingState;
import java.time.Duration;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzw extends CoWatchingState {
    private final String zza;
    private final Duration zzb;
    private final double zzc;
    private final CoWatchingState.PlaybackState zzd;
    private final CoWatchingQueue zze;

    public /* synthetic */ zzw(String str, Duration duration, double d, CoWatchingState.PlaybackState playbackState, CoWatchingQueue coWatchingQueue, zzv zzvVar) {
        this.zza = str;
        this.zzb = duration;
        this.zzc = d;
        this.zzd = playbackState;
        this.zze = coWatchingQueue;
    }

    @Override // com.google.android.meet.addons.CoWatchingState
    public final CoWatchingQueue coWatchingQueue() {
        return this.zze;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CoWatchingState) {
            CoWatchingState coWatchingState = (CoWatchingState) obj;
            if (this.zza.equals(coWatchingState.mediaId()) && this.zzb.equals(coWatchingState.mediaPlayoutPosition()) && Double.doubleToLongBits(this.zzc) == Double.doubleToLongBits(coWatchingState.mediaPlayoutRate()) && this.zzd.equals(coWatchingState.playbackState()) && this.zze.equals(coWatchingState.coWatchingQueue())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode()) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.zzc) >>> 32) ^ Double.doubleToLongBits(this.zzc)))) * 1000003) ^ this.zzd.hashCode()) * 1000003) ^ this.zze.hashCode();
    }

    @Override // com.google.android.meet.addons.CoWatchingState
    public final String mediaId() {
        return this.zza;
    }

    @Override // com.google.android.meet.addons.CoWatchingState, com.google.android.meet.addons.QueriedCoWatchingState
    public final Duration mediaPlayoutPosition() {
        return this.zzb;
    }

    @Override // com.google.android.meet.addons.CoWatchingState
    public final double mediaPlayoutRate() {
        return this.zzc;
    }

    @Override // com.google.android.meet.addons.CoWatchingState
    public final CoWatchingState.PlaybackState playbackState() {
        return this.zzd;
    }

    @Override // com.google.android.meet.addons.CoWatchingState
    public final CoWatchingState.Builder toBuilder() {
        return new zzu(this);
    }

    public final String toString() {
        CoWatchingQueue coWatchingQueue = this.zze;
        CoWatchingState.PlaybackState playbackState = this.zzd;
        String string = this.zzb.toString();
        String string2 = playbackState.toString();
        String string3 = coWatchingQueue.toString();
        StringBuilder sb = new StringBuilder("CoWatchingState{mediaId=");
        AbstractC2821a.m2207B(sb, this.zza, ", mediaPlayoutPosition=", string, ", mediaPlayoutRate=");
        sb.append(this.zzc);
        sb.append(", playbackState=");
        sb.append(string2);
        return AbstractC2322a.m1626p(sb, ", coWatchingQueue=", string3, "}");
    }
}
