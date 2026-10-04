package com.samsung.android.support.senl.p148nt.base.common.util;

import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0007J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/FolderUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "isValidFolderName", "", "displayName", "getNewFolderName", "currentTime", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class FolderUtils {

    @NotNull
    public static final FolderUtils INSTANCE = new FolderUtils();

    @NotNull
    private static final String TAG = "FolderUtils";

    private FolderUtils() {
    }

    @JvmStatic
    @NotNull
    public static final String getNewFolderName(long currentTime) {
        return AbstractC0622a.m1169o("New Folder_", currentTime + 1);
    }

    @JvmStatic
    public static final boolean isValidFolderName(@Nullable String displayName) {
        if (displayName == null || displayName.length() == 0) {
            Debugger.INSTANCE.m8621e(TAG, "isValidFolderName() : display name is empty!");
            return false;
        }
        try {
            Base64Utils.encodeBase64(displayName);
            return true;
        } catch (Exception unused) {
            Debugger.INSTANCE.m8621e(TAG, "isValidFolderName() : display name is corrupt!");
            return false;
        }
    }
}
