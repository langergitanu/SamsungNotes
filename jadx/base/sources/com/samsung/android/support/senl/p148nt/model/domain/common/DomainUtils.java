package com.samsung.android.support.senl.p148nt.model.domain.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DomainUtils {
    private static final String TAG = ModelLogger.createTag("DomainUtils");

    @NonNull
    public static String applyFolderNameMaxLimit(@NonNull String str) {
        if (str.length() < 30) {
            return str;
        }
        DataLogger.m12309w(TAG, "applyFolderNameMaxLimit, len: " + str.length() + " > 30");
        return str.substring(0, 30);
    }

    @Nullable
    public static String applyTitleMaxLimit(@Nullable String str) {
        if (str == null || str.length() < 50) {
            return str;
        }
        DataLogger.m12309w(TAG, "applyTitleMaxLimit, len: " + str.length() + " > 50");
        return str.substring(0, 50);
    }
}
