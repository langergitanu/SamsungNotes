package p025F0;

import androidx.glance.AbstractC2821a;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.app.notes.sync.microsoft.graph.data.GraphDatabase_Impl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: renamed from: F0.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0088c extends RoomOpenHelper.Delegate {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ GraphDatabase_Impl f294a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0088c(GraphDatabase_Impl graphDatabase_Impl) {
        super(1);
        this.f294a = graphDatabase_Impl;
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
        AbstractC2821a.m2233x(supportSQLiteDatabase, "CREATE TABLE IF NOT EXISTS `graph_sync` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `docUuid` TEXT NOT NULL, `commandType` INTEGER NOT NULL DEFAULT 0, `requestedServerTimestamp` INTEGER NOT NULL DEFAULT 0, `msAccountId` TEXT DEFAULT '', `msDocumentId` TEXT DEFAULT '')", "CREATE UNIQUE INDEX IF NOT EXISTS `index_graph_sync_docUuid_commandType` ON `graph_sync` (`docUuid`, `commandType`)", RoomMasterTable.CREATE_QUERY, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '2e48616e8327fa57ad40b34830912b7c')");
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `graph_sync`");
        GraphDatabase_Impl graphDatabase_Impl = this.f294a;
        if (((RoomDatabase) graphDatabase_Impl).mCallbacks != null) {
            int size = ((RoomDatabase) graphDatabase_Impl).mCallbacks.size();
            for (int i = 0; i < size; i++) {
                ((RoomDatabase.Callback) ((RoomDatabase) graphDatabase_Impl).mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
            }
        }
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
        GraphDatabase_Impl graphDatabase_Impl = this.f294a;
        if (((RoomDatabase) graphDatabase_Impl).mCallbacks != null) {
            int size = ((RoomDatabase) graphDatabase_Impl).mCallbacks.size();
            for (int i = 0; i < size; i++) {
                ((RoomDatabase.Callback) ((RoomDatabase) graphDatabase_Impl).mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
            }
        }
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
        GraphDatabase_Impl graphDatabase_Impl = this.f294a;
        ((RoomDatabase) graphDatabase_Impl).mDatabase = supportSQLiteDatabase;
        graphDatabase_Impl.internalInitInvalidationTracker(supportSQLiteDatabase);
        if (((RoomDatabase) graphDatabase_Impl).mCallbacks != null) {
            int size = ((RoomDatabase) graphDatabase_Impl).mCallbacks.size();
            for (int i = 0; i < size; i++) {
                ((RoomDatabase.Callback) ((RoomDatabase) graphDatabase_Impl).mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
            }
        }
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
        HashMap map = new HashMap(6);
        map.put("_id", new TableInfo.Column("_id", "INTEGER", true, 1, null, 1));
        map.put("docUuid", new TableInfo.Column("docUuid", "TEXT", true, 0, null, 1));
        map.put("commandType", new TableInfo.Column("commandType", "INTEGER", true, 0, "0", 1));
        map.put("requestedServerTimestamp", new TableInfo.Column("requestedServerTimestamp", "INTEGER", true, 0, "0", 1));
        map.put("msAccountId", new TableInfo.Column("msAccountId", "TEXT", false, 0, "''", 1));
        HashSet hashSetM2231v = AbstractC2821a.m2231v(map, "msDocumentId", new TableInfo.Column("msDocumentId", "TEXT", false, 0, "''", 1), 0);
        HashSet hashSet = new HashSet(1);
        hashSet.add(new TableInfo.Index("index_graph_sync_docUuid_commandType", true, Arrays.asList("docUuid", "commandType"), Arrays.asList("ASC", "ASC")));
        TableInfo tableInfo = new TableInfo("graph_sync", map, hashSetM2231v, hashSet);
        TableInfo tableInfo2 = TableInfo.read(supportSQLiteDatabase, "graph_sync");
        return !tableInfo.equals(tableInfo2) ? new RoomOpenHelper.ValidationResult(false, AbstractC2821a.m2220k("graph_sync(com.samsung.android.app.notes.sync.microsoft.graph.data.GraphSyncEntity).\n Expected:\n", tableInfo, "\n Found:\n", tableInfo2)) : new RoomOpenHelper.ValidationResult(true, null);
    }
}
