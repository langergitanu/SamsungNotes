package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* JADX INFO: renamed from: com.google.android.datatransport.runtime.scheduling.persistence.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4520c implements SQLiteEventStore.Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2163a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SQLiteEventStore f2164b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f2165c;

    public /* synthetic */ C4520c(SQLiteEventStore sQLiteEventStore, Object obj, int i) {
        this.f2163a = i;
        this.f2164b = sQLiteEventStore;
        this.f2165c = obj;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public final Object apply(Object obj) {
        switch (this.f2163a) {
            case 0:
                return this.f2164b.lambda$hasPendingEventsFor$6((TransportContext) this.f2165c, (SQLiteDatabase) obj);
            case 1:
                return this.f2164b.lambda$loadBatch$8((TransportContext) this.f2165c, (SQLiteDatabase) obj);
            default:
                return this.f2164b.lambda$recordFailure$4((String) this.f2165c, "SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name", (SQLiteDatabase) obj);
        }
    }
}
