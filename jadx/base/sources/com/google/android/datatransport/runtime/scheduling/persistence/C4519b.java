package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* JADX INFO: renamed from: com.google.android.datatransport.runtime.scheduling.persistence.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4519b implements SQLiteEventStore.Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2162a;

    public /* synthetic */ C4519b(int i) {
        this.f2162a = i;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public final Object apply(Object obj) {
        switch (this.f2162a) {
            case 0:
                return SQLiteEventStore.lambda$getTransportContextId$2((Cursor) obj);
            case 1:
                return SQLiteEventStore.lambda$recordLogEventDropped$17((Cursor) obj);
            case 2:
                return SQLiteEventStore.lambda$loadActiveContexts$9((Cursor) obj);
            case 3:
                return SQLiteEventStore.lambda$readPayload$15((Cursor) obj);
            case 4:
                return SQLiteEventStore.lambda$loadActiveContexts$10((SQLiteDatabase) obj);
            case 5:
                return SQLiteEventStore.lambda$getNextCallTime$5((Cursor) obj);
            case 6:
                return SQLiteEventStore.lambda$ensureBeginTransaction$25((Throwable) obj);
            case 7:
                return Boolean.valueOf(((Cursor) obj).moveToNext());
            case 8:
                return SQLiteEventStore.lambda$clearDb$13((SQLiteDatabase) obj);
            default:
                return SQLiteEventStore.lambda$getDb$0((Throwable) obj);
        }
    }
}
