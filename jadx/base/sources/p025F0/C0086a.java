package p025F0;

import androidx.room.RoomDatabase;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;

/* JADX INFO: renamed from: F0.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0086a extends RoomDatabase.Callback {
    @Override // androidx.room.RoomDatabase.Callback
    public final void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Logger.m8700f("GraphDatabaseManager", "GraphDatabase onCreate, start - version : " + supportSQLiteDatabase.getVersion());
        super.onCreate(supportSQLiteDatabase);
        Logger.m8700f("GraphDatabaseManager", "GraphDatabase onCreate, end - version : " + supportSQLiteDatabase.getVersion());
    }

    @Override // androidx.room.RoomDatabase.Callback
    public final void onDestructiveMigration(SupportSQLiteDatabase supportSQLiteDatabase) {
        Logger.m8700f("GraphDatabaseManager", "GraphDatabase onDestructiveMigration, version : " + supportSQLiteDatabase.getVersion());
        super.onDestructiveMigration(supportSQLiteDatabase);
    }
}
