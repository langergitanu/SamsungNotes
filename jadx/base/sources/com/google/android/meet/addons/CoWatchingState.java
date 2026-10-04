package com.google.android.meet.addons;

import androidx.annotation.NonNull;
import com.google.android.meet.addons.annotations.PublicApi;
import com.google.auto.value.AutoValue;
import java.time.Duration;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@AutoValue
@PublicApi
public abstract class CoWatchingState implements QueriedCoWatchingState {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @PublicApi
    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract CoWatchingState build();

        @NonNull
        public abstract Builder setCoWatchingQueue(@NonNull CoWatchingQueue coWatchingQueue);

        @NonNull
        public abstract Builder setMediaId(@NonNull String str);

        @NonNull
        public abstract Builder setMediaPlayoutPosition(@NonNull Duration duration);

        @NonNull
        public abstract Builder setMediaPlayoutRate(double d);

        @NonNull
        public abstract Builder setPlaybackState(@NonNull PlaybackState playbackState);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @PublicApi
    public enum PlaybackState {
        BUFFERING,
        PLAY,
        PAUSE,
        ENDED
    }

    @NonNull
    public static Builder builder() {
        return new zzu();
    }

    @NonNull
    public abstract CoWatchingQueue coWatchingQueue();

    @NonNull
    public abstract String mediaId();

    @Override // com.google.android.meet.addons.QueriedCoWatchingState
    @NonNull
    public abstract Duration mediaPlayoutPosition();

    public abstract double mediaPlayoutRate();

    @NonNull
    public abstract PlaybackState playbackState();

    @NonNull
    public abstract Builder toBuilder();
}
