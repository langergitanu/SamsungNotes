package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.AutoValue_ClientInfo;
import com.google.auto.value.AutoValue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@AutoValue
public abstract class ClientInfo {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract ClientInfo build();

        @NonNull
        public abstract Builder setAndroidClientInfo(@Nullable AndroidClientInfo androidClientInfo);

        @NonNull
        public abstract Builder setClientType(@Nullable ClientType clientType);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ClientType {
        UNKNOWN(0),
        ANDROID_FIREBASE(23);

        private final int value;

        ClientType(int i) {
            this.value = i;
        }
    }

    @NonNull
    public static Builder builder() {
        return new AutoValue_ClientInfo.Builder();
    }

    @Nullable
    public abstract AndroidClientInfo getAndroidClientInfo();

    @Nullable
    public abstract ClientType getClientType();
}
