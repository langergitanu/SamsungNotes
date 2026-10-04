package p025F0;

import android.content.Context;
import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.p113db.SupportSQLiteStatement;
import com.samsung.android.app.notes.sync.microsoft.graph.data.GraphDatabase;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: F0.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0093h {

    /* JADX INFO: renamed from: a */
    public final C0091f f303a;

    public C0093h(Context context) {
        boolean z;
        synchronized (AbstractC0087b.class) {
            if (AbstractC0087b.f293b == null) {
                try {
                    AbstractC0087b.f293b = new AtomicBoolean(true);
                } catch (ClassNotFoundException unused) {
                    AbstractC0087b.f293b = new AtomicBoolean(false);
                }
                z = AbstractC0087b.f293b.get();
            } else {
                z = AbstractC0087b.f293b.get();
            }
        }
        GraphDatabase graphDatabase = AbstractC0087b.f292a;
        if (graphDatabase == null) {
            synchronized (GraphDatabase.class) {
                try {
                    graphDatabase = AbstractC0087b.f292a;
                    if (graphDatabase == null) {
                        GraphDatabase graphDatabaseM228a = AbstractC0087b.m228a(context, z);
                        AbstractC0087b.f292a = graphDatabaseM228a;
                        graphDatabase = graphDatabaseM228a;
                    }
                } finally {
                }
            }
        }
        this.f303a = graphDatabase.mo4924a();
    }

    /* JADX INFO: renamed from: a */
    public final void m236a() {
        C0091f c0091f = this.f303a;
        RoomDatabase roomDatabase = (RoomDatabase) c0091f.f297a;
        roomDatabase.assertNotSuspendingTransaction();
        C0090e c0090e = (C0090e) c0091f.f300d;
        SupportSQLiteStatement supportSQLiteStatementAcquire = c0090e.acquire();
        roomDatabase.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            roomDatabase.setTransactionSuccessful();
        } finally {
            roomDatabase.endTransaction();
            c0090e.release(supportSQLiteStatementAcquire);
        }
    }

    /* JADX INFO: renamed from: b */
    public final ArrayList m237b() {
        C0091f c0091f = this.f303a;
        c0091f.getClass();
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM graph_sync", 0);
        RoomDatabase roomDatabase = (RoomDatabase) c0091f.f297a;
        roomDatabase.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(roomDatabase, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "docUuid");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "commandType");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requestedServerTimestamp");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "msAccountId");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "msDocumentId");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                C0092g c0092g = new C0092g();
                c0092g.f301a = "";
                c0092g.f302b = 0;
                cursorQuery.getLong(columnIndexOrThrow);
                c0092g.f301a = cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2);
                c0092g.f302b = cursorQuery.getInt(columnIndexOrThrow3);
                cursorQuery.getLong(columnIndexOrThrow4);
                if (!cursorQuery.isNull(columnIndexOrThrow5)) {
                    cursorQuery.getString(columnIndexOrThrow5);
                }
                if (!cursorQuery.isNull(columnIndexOrThrow6)) {
                    cursorQuery.getString(columnIndexOrThrow6);
                }
                arrayList.add(c0092g);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m238c(String str, int i) {
        C0091f c0091f = this.f303a;
        RoomDatabase roomDatabase = (RoomDatabase) c0091f.f297a;
        roomDatabase.assertNotSuspendingTransaction();
        C0090e c0090e = (C0090e) c0091f.f299c;
        SupportSQLiteStatement supportSQLiteStatementAcquire = c0090e.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        supportSQLiteStatementAcquire.bindLong(2, i);
        roomDatabase.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            roomDatabase.setTransactionSuccessful();
        } finally {
            roomDatabase.endTransaction();
            c0090e.release(supportSQLiteStatementAcquire);
        }
    }
}
