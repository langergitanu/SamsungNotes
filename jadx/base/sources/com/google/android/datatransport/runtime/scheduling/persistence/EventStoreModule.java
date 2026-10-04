package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.Binds;
import com.google.android.datatransport.runtime.dagger.Module;
import com.google.android.datatransport.runtime.dagger.Provides;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import javax.inject.Named;
import javax.inject.Singleton;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Module
public abstract class EventStoreModule {
    @Provides
    @Named("SQLITE_DB_NAME")
    public static String dbName() {
        return "com.google.android.datatransport.events";
    }

    @Provides
    @Singleton
    @Named("PACKAGE_NAME")
    public static String packageName(Context context) {
        return context.getPackageName();
    }

    @Provides
    @Named("SCHEMA_VERSION")
    public static int schemaVersion() {
        return SchemaManager.SCHEMA_VERSION;
    }

    @Provides
    public static EventStoreConfig storeConfig() {
        return EventStoreConfig.DEFAULT;
    }

    @Binds
    public abstract ClientHealthMetricsStore clientHealthMetricsStore(SQLiteEventStore sQLiteEventStore);

    @Binds
    public abstract EventStore eventStore(SQLiteEventStore sQLiteEventStore);

    @Binds
    public abstract SynchronizationGuard synchronizationGuard(SQLiteEventStore sQLiteEventStore);
}
