package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* JADX INFO: renamed from: com.google.android.datatransport.runtime.scheduling.persistence.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4521d implements SQLiteEventStore.Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2166a = 0;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ long f2167b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f2168c;

    public /* synthetic */ C4521d(TransportContext transportContext, long j) {
        this.f2167b = j;
        this.f2168c = transportContext;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public final Object apply(Object obj) {
        switch (this.f2166a) {
            case 0:
                return SQLiteEventStore.lambda$recordNextCallTime$7(this.f2167b, (TransportContext) this.f2168c, (SQLiteDatabase) obj);
            default:
                return ((SQLiteEventStore) this.f2168c).lambda$cleanUp$12(this.f2167b, (SQLiteDatabase) obj);
        }
    }

    public /* synthetic */ C4521d(SQLiteEventStore sQLiteEventStore, long j) {
        this.f2168c = sQLiteEventStore;
        this.f2167b = j;
    }
}
