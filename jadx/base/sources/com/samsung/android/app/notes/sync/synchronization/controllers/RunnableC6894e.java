package com.samsung.android.app.notes.sync.synchronization.controllers;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import com.samsung.android.app.notes.sync.microsoft.graph.AbstractC6784f;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import p025F0.C0091f;
import p025F0.C0093h;
import p026F1.C0099c;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.synchronization.controllers.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class RunnableC6894e implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C6896g f4444a;

    public RunnableC6894e(C6896g c6896g) {
        this.f4444a = c6896g;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AbstractC6784f.f4180a.getClass();
        C0091f c0091f = new C0093h(BaseUtils.getApplicationContext()).f303a;
        c0091f.getClass();
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM graph_sync", 0);
        RoomDatabase roomDatabase = (RoomDatabase) c0091f.f297a;
        roomDatabase.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(roomDatabase, roomSQLiteQueryAcquire, false, null);
        try {
            int i = cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            if (i == 0) {
                Debugger.m8615i("SyncOldServiceController", "checkAndRequestSyncMsFeed() : No note to sync for MS feed!");
            } else {
                Debugger.m8615i("SyncOldServiceController", "checkAndRequestSyncMsFeed() : call requestSync()");
                this.f4444a.m5100j(new C0099c(1));
            }
        } catch (Throwable th) {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            throw th;
        }
    }
}
