package com.google.android.meet.addons;

import androidx.annotation.NonNull;
import com.google.android.meet.addons.annotations.PublicApi;
import com.google.auto.value.AutoValue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@AutoValue
@PublicApi
public abstract class RecordingInfo {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @PublicApi
    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract RecordingInfo build();

        @NonNull
        public abstract Builder setStatus(@NonNull RecordingStatus recordingStatus);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @PublicApi
    public enum RecordingStatus {
        UNKNOWN,
        NOT_RECORDING,
        RECORDING
    }

    @NonNull
    public static Builder builder() {
        return new zzad();
    }

    @NonNull
    public abstract RecordingStatus status();
}
