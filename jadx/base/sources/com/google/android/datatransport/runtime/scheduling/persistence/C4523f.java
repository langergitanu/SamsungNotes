package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.HashMap;

/* JADX INFO: renamed from: com.google.android.datatransport.runtime.scheduling.persistence.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4523f implements SQLiteEventStore.Function, SQLiteEventStore.Producer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2171a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f2172b;

    public /* synthetic */ C4523f(Object obj, int i) {
        this.f2171a = i;
        this.f2172b = obj;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        return SQLiteEventStore.lambda$loadMetadata$16((HashMap) this.f2172b, (Cursor) obj);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Producer
    public Object produce() {
        switch (this.f2171a) {
            case 1:
                return SQLiteEventStore.lambda$ensureBeginTransaction$24((SQLiteDatabase) this.f2172b);
            default:
                return ((SchemaManager) this.f2172b).getWritableDatabase();
        }
    }
}
