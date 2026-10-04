package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.google.android.datatransport.runtime.scheduling.persistence.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4518a implements SQLiteEventStore.Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2158a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SQLiteEventStore f2159b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f2160c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f2161d;

    public /* synthetic */ C4518a(SQLiteEventStore sQLiteEventStore, Object obj, Object obj2, int i) {
        this.f2158a = i;
        this.f2159b = sQLiteEventStore;
        this.f2160c = obj;
        this.f2161d = obj2;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public final Object apply(Object obj) {
        switch (this.f2158a) {
            case 0:
                return this.f2159b.lambda$loadClientMetrics$20("SELECT log_source, reason, events_dropped_count FROM log_event_dropped", (HashMap) this.f2160c, (ClientMetrics.Builder) this.f2161d, (SQLiteDatabase) obj);
            case 1:
                return this.f2159b.lambda$loadEvents$14((ArrayList) this.f2160c, (TransportContext) this.f2161d, (Cursor) obj);
            case 2:
                return this.f2159b.lambda$persist$1((EventInternal) this.f2160c, (TransportContext) this.f2161d, (SQLiteDatabase) obj);
            default:
                return this.f2159b.lambda$loadClientMetrics$19((Map) this.f2160c, (ClientMetrics.Builder) this.f2161d, (Cursor) obj);
        }
    }
}
