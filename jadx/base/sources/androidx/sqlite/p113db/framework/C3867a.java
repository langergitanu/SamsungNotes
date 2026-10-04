package androidx.sqlite.p113db.framework;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import androidx.sqlite.p113db.SupportSQLiteQuery;
import kotlin.jvm.functions.Function4;

/* JADX INFO: renamed from: androidx.sqlite.db.framework.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class C3867a implements SQLiteDatabase.CursorFactory {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1682a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f1683b;

    public /* synthetic */ C3867a(Object obj, int i) {
        this.f1682a = i;
        this.f1683b = obj;
    }

    @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
    public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        switch (this.f1682a) {
            case 0:
                return FrameworkSQLiteDatabase.query$lambda$1((SupportSQLiteQuery) this.f1683b, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
            default:
                return FrameworkSQLiteDatabase.query$lambda$0((Function4) this.f1683b, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
        }
    }
}
