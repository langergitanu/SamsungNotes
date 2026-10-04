package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* JADX INFO: renamed from: com.google.android.datatransport.runtime.scheduling.persistence.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4522e implements SQLiteEventStore.Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2169a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SQLiteEventStore f2170b;

    public /* synthetic */ C4522e(SQLiteEventStore sQLiteEventStore, int i) {
        this.f2169a = i;
        this.f2170b = sQLiteEventStore;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public final Object apply(Object obj) {
        switch (this.f2169a) {
            case 0:
                return this.f2170b.lambda$resetClientMetrics$23((SQLiteDatabase) obj);
            case 1:
                return this.f2170b.lambda$cleanUp$11((Cursor) obj);
            default:
                return this.f2170b.lambda$recordFailure$3((Cursor) obj);
        }
    }
}
