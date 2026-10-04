package com.samsung.android.support.senl.p148nt.model.utils;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class NotesDocumentIntentUtils {
    private static final String CALLER_ANONYMOUS = "anonymous";
    private static final String TAG = ModelLogger.createTag("NotesDocumentIntentUtils");

    public static String getCaller(@Nullable String str) {
        return TextUtils.isEmpty(str) ? CALLER_ANONYMOUS : str;
    }

    public static String getFolderUuid(@Nullable String str) {
        String str2 = TAG;
        AbstractC0000a.m2C("getFolderUuid, folderPath : ", str, str2);
        if (str == null) {
            return PredefinedCategory.UNCATEGORIZED.getUuid();
        }
        PredefinedCategory predefinedCategory = PredefinedCategory.UNCATEGORIZED;
        if (!str.startsWith(predefinedCategory.getPath())) {
            str = predefinedCategory.getPath() + str;
            AbstractC0000a.m2C("getFolderUuid, new folder path : ", str, str2);
        }
        return FolderManager.getInstance().findAndMakeCategory(str);
    }

    public static String getIntentCaller(@NonNull Intent intent) {
        return getCaller(intent.getComponent() == null ? CALLER_ANONYMOUS : intent.getComponent().getClassName());
    }

    public static void setFolderUuid(@NonNull NotesDocumentEntity notesDocumentEntity, @Nullable String str) {
        DataLogger.m12307i(TAG, "setFolderUuid, uuid : " + notesDocumentEntity.getUuid() + ", folderUuid : " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        notesDocumentEntity.setCategoryUuid(str);
    }
}
