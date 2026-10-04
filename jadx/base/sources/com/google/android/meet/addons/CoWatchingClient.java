package com.google.android.meet.addons;

import androidx.annotation.NonNull;
import com.google.android.meet.addons.annotations.PublicApi;
import java.time.Duration;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@PublicApi
public interface CoWatchingClient {
    public static final double MAX_PLAYOUT_RATE = 2.0d;
    public static final double MAX_SEEKS_PER_SECOND = 0.9d;

    void notifyBuffering(@NonNull Duration duration);

    void notifyEnded(@NonNull Duration duration);

    void notifyPauseState(boolean z, @NonNull Duration duration);

    void notifyPlayoutRate(double d, @NonNull Duration duration);

    void notifyQueueUpdate(@NonNull CoWatchingQueue coWatchingQueue);

    void notifyReady(@NonNull Duration duration);

    void notifySeekToTimestamp(@NonNull Duration duration);

    void notifySwitchedToMedia(@NonNull String str, @NonNull String str2, @NonNull Duration duration);

    void notifySwitchedToMedia(@NonNull String str, @NonNull String str2, @NonNull Duration duration, @NonNull CoWatchingQueue coWatchingQueue);
}
