package com.google.android.meet.addons;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.meet.addons.annotations.PublicApi;
import com.google.auto.value.AutoValue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@AutoValue
@PublicApi
public abstract class CoWatchingQueue {

    @NonNull
    public static final CoWatchingQueue EMPTY = builder().zzc();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract Builder zza(@NonNull ClientQueue clientQueue);

        @NonNull
        public abstract Builder zzb(@NonNull ServerQueueParams serverQueueParams);

        @NonNull
        public abstract CoWatchingQueue zzc();
    }

    @NonNull
    public static Builder builder() {
        return new zzr();
    }

    @Nullable
    public abstract ClientQueue clientQueue();

    @Nullable
    public abstract ServerQueueParams serverQueueParams();
}
