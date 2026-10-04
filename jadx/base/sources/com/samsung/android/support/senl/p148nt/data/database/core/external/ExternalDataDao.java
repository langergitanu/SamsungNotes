package com.samsung.android.support.senl.p148nt.data.database.core.external;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Dao;
import androidx.room.RawQuery;
import androidx.sqlite.p113db.SimpleSQLiteQuery;
import androidx.sqlite.p113db.SupportSQLiteQuery;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.QueryUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.query.external.ExternalDataQuery;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class ExternalDataDao {
    @Nullable
    public Cursor getDocumentData(@NonNull String[] strArr, @Nullable String str, @Nullable String str2, @Nullable String[] strArr2, @Nullable String str3) {
        String str4 = new ExternalDataQuery().get(strArr, str, str2, str3);
        if (str4.isEmpty()) {
            return null;
        }
        return (!QueryUtils.hasPlaceHolder(str2) || strArr2 == null || strArr2.length <= 0) ? getResult(new SimpleSQLiteQuery(str4)) : getResult(new SimpleSQLiteQuery(str4, strArr2));
    }

    @RawQuery
    public abstract Cursor getResult(SupportSQLiteQuery supportSQLiteQuery);
}
