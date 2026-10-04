package com.google.android.meet.addons;

import androidx.annotation.NonNull;
import com.google.android.meet.addons.annotations.PublicApi;
import com.google.auto.value.AutoValue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@AutoValue
@PublicApi
public abstract class ClientQueueEntry {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract Builder zza(@NonNull String str);

        @NonNull
        public abstract Builder zzb(@NonNull String str);

        @NonNull
        public abstract ClientQueueEntry zzc();
    }

    @NonNull
    public static Builder builder() {
        return new zzl();
    }

    @NonNull
    public abstract String entryId();

    @NonNull
    public abstract String mediaId();
}
