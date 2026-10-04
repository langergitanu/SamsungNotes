package com.google.android.meet.addons;

import androidx.annotation.NonNull;
import com.google.android.meet.addons.annotations.PublicApi;
import com.google.auto.value.AutoValue;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@AutoValue
@PublicApi
public abstract class AddonMeetingInfo {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @PublicApi
    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract AddonMeetingInfo build();

        @NonNull
        public abstract Builder setInitialCoDoingState(@NonNull CoDoingState coDoingState);

        @NonNull
        public abstract Builder setInitialCoWatchingState(@NonNull CoWatchingState coWatchingState);

        @NonNull
        public abstract Builder setMeetingCode(@NonNull String str);

        @NonNull
        public abstract Builder setMeetingStatus(@NonNull MeetingStatus meetingStatus);

        @NonNull
        public abstract Builder setMeetingUrl(@NonNull String str);

        @NonNull
        public abstract Builder setRecordingInfo(@NonNull RecordingInfo recordingInfo);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @PublicApi
    public enum MeetingStatus {
        NOT_CONNECTED,
        CONNECTED,
        CONNECTED_WITH_ADDON_SESSION
    }

    @NonNull
    public static Builder builder() {
        return new zzf();
    }

    @NonNull
    public abstract Optional<CoDoingState> initialCoDoingState();

    @NonNull
    public abstract Optional<CoWatchingState> initialCoWatchingState();

    @NonNull
    public abstract String meetingCode();

    @NonNull
    public abstract MeetingStatus meetingStatus();

    @NonNull
    public abstract String meetingUrl();

    @NonNull
    public abstract RecordingInfo recordingInfo();

    @NonNull
    public abstract Builder toBuilder();
}
