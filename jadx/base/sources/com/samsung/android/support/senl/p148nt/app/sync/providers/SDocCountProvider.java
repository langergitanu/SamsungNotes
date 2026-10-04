package com.samsung.android.support.senl.p148nt.app.sync.providers;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.utils.DataUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.QueryUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SDocCountProvider extends ContentProvider {
    private static final String TAG = "SDocCountProvider";

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Logger.m8697d(TAG, "onCreate()");
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(@NonNull Uri uri, String[] strArr, String str, String[] strArr2, String str2) throws Exception {
        if (getContext() == null) {
            return null;
        }
        DataUtils.setContext(getContext().getApplicationContext());
        try {
            StringBuilder sb = new StringBuilder();
            if (!QueryUtils.isAllowedStatement(str)) {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                sb.append("isDeleted != 1");
            } else {
                sb.append(PropertyUtils.MAPPED_DELIM);
                sb.append(str);
                sb.append(PropertyUtils.MAPPED_DELIM2);
            }
            sb.append(" AND mdeSpaceId = '' AND map.UUID IS NULL");
            Cursor allDocument = NotesDataRepositoryFactory.newInstance(getContext()).createDocumentDataRepository().getAllDocument("sdoc", DBSchema.DocumentProjection.SDOC_COUNT_PROJECTION, sb.toString());
            StringBuilder sb2 = new StringBuilder("query result cursor size : ");
            sb2.append(allDocument != null ? allDocument.getCount() : 0);
            Logger.m8697d(TAG, sb2.toString());
            return allDocument;
        } catch (Exception e) {
            Logger.m8699e(TAG, "query() " + uri, e);
            throw e;
        }
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
