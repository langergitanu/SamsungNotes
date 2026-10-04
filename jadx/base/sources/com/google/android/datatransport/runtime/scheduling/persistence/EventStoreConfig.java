package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_EventStoreConfig;
import com.google.auto.value.AutoValue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@AutoValue
abstract class EventStoreConfig {
    private static final long DURATION_ONE_WEEK_MS = 604800000;
    private static final int LOAD_BATCH_SIZE = 200;
    private static final int LOCK_TIME_OUT_MS = 10000;
    private static final long MAX_DB_STORAGE_SIZE_IN_BYTES = 10485760;
    private static final int MAX_BLOB_BYTE_SIZE_PER_ROW = 81920;
    static final EventStoreConfig DEFAULT = builder().setMaxStorageSizeInBytes(10485760).setLoadBatchSize(200).setCriticalSectionEnterTimeoutMs(10000).setEventCleanUpAge(604800000).setMaxBlobByteSizePerRow(MAX_BLOB_BYTE_SIZE_PER_ROW).build();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @AutoValue.Builder
    public static abstract class Builder {
        public abstract EventStoreConfig build();

        public abstract Builder setCriticalSectionEnterTimeoutMs(int i);

        public abstract Builder setEventCleanUpAge(long j);

        public abstract Builder setLoadBatchSize(int i);

        public abstract Builder setMaxBlobByteSizePerRow(int i);

        public abstract Builder setMaxStorageSizeInBytes(long j);
    }

    public static Builder builder() {
        return new AutoValue_EventStoreConfig.Builder();
    }

    public abstract int getCriticalSectionEnterTimeoutMs();

    public abstract long getEventCleanUpAge();

    public abstract int getLoadBatchSize();

    public abstract int getMaxBlobByteSizePerRow();

    public abstract long getMaxStorageSizeInBytes();

    public Builder toBuilder() {
        return builder().setMaxStorageSizeInBytes(getMaxStorageSizeInBytes()).setLoadBatchSize(getLoadBatchSize()).setCriticalSectionEnterTimeoutMs(getCriticalSectionEnterTimeoutMs()).setEventCleanUpAge(getEventCleanUpAge()).setMaxBlobByteSizePerRow(getMaxBlobByteSizePerRow());
    }
}
