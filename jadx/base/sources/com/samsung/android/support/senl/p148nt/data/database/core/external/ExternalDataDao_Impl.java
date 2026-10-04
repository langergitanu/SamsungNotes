package com.samsung.android.support.senl.p148nt.data.database.core.external;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.sqlite.p113db.SupportSQLiteQuery;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final class ExternalDataDao_Impl extends ExternalDataDao {
    private final RoomDatabase __db;

    public ExternalDataDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.samsung.android.support.senl.p148nt.data.database.core.external.ExternalDataDao
    public Cursor getResult(SupportSQLiteQuery supportSQLiteQuery) {
        return this.__db.query(supportSQLiteQuery);
    }
}
