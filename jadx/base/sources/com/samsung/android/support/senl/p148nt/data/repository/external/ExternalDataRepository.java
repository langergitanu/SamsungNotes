package com.samsung.android.support.senl.p148nt.data.repository.external;

import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase;
import com.samsung.android.support.senl.p148nt.data.database.core.external.ExternalDataDao;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ExternalDataRepository {
    private static final String TAG = DataLogger.createTag("ExternalDataRepository");
    private final ExternalDataDao mDao;

    public ExternalDataRepository(NotesDatabase notesDatabase) {
        this.mDao = notesDatabase.getExternalDataDao();
    }

    @Nullable
    public Cursor getDocumentData(@NonNull String[] strArr, @Nullable String str, @Nullable String str2, @Nullable String[] strArr2, @Nullable String str3) {
        AbstractC11014a.m12334s("getDocumentData, uuid: ", TextUtils.isEmpty(str) ? "all documents" : str, TAG);
        return this.mDao.getDocumentData(strArr, str, str2, strArr2, str3);
    }
}
