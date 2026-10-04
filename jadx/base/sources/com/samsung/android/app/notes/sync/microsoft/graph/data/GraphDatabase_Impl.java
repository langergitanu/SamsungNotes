package com.samsung.android.app.notes.sync.microsoft.graph.data;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.Migration;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import androidx.sqlite.p113db.SupportSQLiteOpenHelper;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p025F0.C0088c;
import p025F0.C0091f;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class GraphDatabase_Impl extends GraphDatabase {

    /* JADX INFO: renamed from: a */
    public volatile C0091f f4178a;

    @Override // com.samsung.android.app.notes.sync.microsoft.graph.data.GraphDatabase
    /* JADX INFO: renamed from: a */
    public final C0091f mo4924a() {
        C0091f c0091f;
        if (this.f4178a != null) {
            return this.f4178a;
        }
        synchronized (this) {
            try {
                if (this.f4178a == null) {
                    this.f4178a = new C0091f(this);
                }
                c0091f = this.f4178a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0091f;
    }

    @Override // androidx.room.RoomDatabase
    public final void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `graph_sync`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    public final InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "graph_sync");
    }

    @Override // androidx.room.RoomDatabase
    public final SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new C0088c(this), "2e48616e8327fa57ad40b34830912b7c", "24087c130dad9159dad8823b3ec5ae8a")).build());
    }

    @Override // androidx.room.RoomDatabase
    public final List getAutoMigrations(Map map) {
        return Arrays.asList(new Migration[0]);
    }

    @Override // androidx.room.RoomDatabase
    public final Set getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public final Map getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(C0091f.class, Collections.EMPTY_LIST);
        return map;
    }
}
