package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* JADX INFO: renamed from: com.google.android.datatransport.runtime.scheduling.persistence.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4525h implements SQLiteEventStore.Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2176a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ long f2177b;

    public /* synthetic */ C4525h(long j, int i) {
        this.f2176a = i;
        this.f2177b = j;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public final Object apply(Object obj) {
        switch (this.f2176a) {
            case 0:
                return SQLiteEventStore.lambda$getTimeWindow$22(this.f2177b, (SQLiteDatabase) obj);
            default:
                return SQLiteEventStore.lambda$getTimeWindow$21(this.f2177b, (Cursor) obj);
        }
    }
}
