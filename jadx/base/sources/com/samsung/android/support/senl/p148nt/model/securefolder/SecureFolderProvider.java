package com.samsung.android.support.senl.p148nt.model.securefolder;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.executor.NotesDataTaskExecutor;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.securefolder.common.SecureFolderConstants;
import com.samsung.android.support.senl.p148nt.model.securefolder.domain.DeleteMovedNoteToSecureSpace;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SecureFolderProvider extends ContentProvider {
    static final int FAILED = 0;
    static final int SUCCESS = 1;
    private static final String TAG = ModelLogger.createSecureFolderTag("SecureFolderProvider");

    private void deleteNotes(String[] strArr) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        NotesDataTaskExecutor.getIOThreadExecutor().execute(new DeleteMovedNoteToSecureSpace(context.getApplicationContext(), Arrays.asList(strArr)));
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        if (!SecureFolderConstants.AUTHORITY.equals(uri.getAuthority())) {
            DataLogger.m12303e(TAG, "delete, invalid authority");
            return 0;
        }
        String callingPackage = getCallingPackage();
        if (callingPackage == null || !callingPackage.equals(SecureFolderConstants.SECURE_FOLDER_PACKAGE)) {
            AbstractC11014a.m12314C("delete, invalid caller: ", callingPackage, TAG);
            return 0;
        }
        if (strArr == null || strArr.length == 0) {
            DataLogger.m12303e(TAG, "delete, invalid args");
            return 0;
        }
        deleteNotes(strArr);
        return 1;
    }

    @Override // android.content.ContentProvider
    @Nullable
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
        return false;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
