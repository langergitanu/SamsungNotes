package com.google.android.meet.addons;

import androidx.annotation.NonNull;
import com.google.android.meet.addons.annotations.PublicApi;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@AutoValue
@PublicApi
public abstract class ClientQueue {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract Builder zza(int i);

        @NonNull
        public abstract Builder zzb(@NonNull List list);

        @NonNull
        public abstract ClientQueue zzc();
    }

    @NonNull
    public static Builder builder() {
        return new zzi();
    }

    public abstract int currentIndex();

    @NonNull
    public abstract ImmutableList<ClientQueueEntry> entries();
}
