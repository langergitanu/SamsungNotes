package androidx.appsearch.app;

import androidx.annotation.WorkerThread;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public abstract class Migrator {
    @WorkerThread
    public abstract GenericDocument onDowngrade(int i, int i2, GenericDocument genericDocument);

    @WorkerThread
    public abstract GenericDocument onUpgrade(int i, int i2, GenericDocument genericDocument);

    public abstract boolean shouldMigrate(int i, int i2);
}
