package com.samsung.android.support.senl.p148nt.base.common.util;

import android.content.Context;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p009B3.C0035a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0007J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u001a\u0010\n\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/util/WDocUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "SAMSUNG_NOTES_PATH", "getNoteDirPath", "context", "Landroid/content/Context;", "getNoteFilePath", "includeSlash", "", "getSdkCacheDocCount", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WDocUtils {

    @NotNull
    public static final WDocUtils INSTANCE = new WDocUtils();

    @NotNull
    private static String SAMSUNG_NOTES_PATH = "";

    @NotNull
    private static final String TAG = "WDocUtils";

    private WDocUtils() {
    }

    @JvmStatic
    @NotNull
    public static final String getNoteDirPath(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        File parentFile = context.getFilesDir().getParentFile();
        if (parentFile == null) {
            return "";
        }
        String absolutePath = parentFile.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        return absolutePath;
    }

    @JvmStatic
    @NotNull
    public static final String getNoteFilePath(@Nullable Context context) {
        return getNoteFilePath(context, true);
    }

    @JvmStatic
    public static final int getSdkCacheDocCount(@Nullable Context context) {
        File[] fileArrListFiles;
        if (context == null) {
            Logger.m8698e(TAG, "getSdkCacheDocCount, context is null");
            return 0;
        }
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            Logger.m8698e(TAG, "getSdkCacheDocCount, filesDir is null");
            return 0;
        }
        if (!filesDir.exists() && !filesDir.mkdir()) {
            Logger.m8698e(TAG, "getSdkCacheDocCount, Failed to make files directory");
            return 0;
        }
        File file = new File(AbstractC0541b.m757C(filesDir.getAbsolutePath(), File.separator, "SPenSDK30"));
        if (!file.exists() || (fileArrListFiles = file.listFiles(new C0035a(6))) == null || fileArrListFiles.length == 0) {
            return 0;
        }
        return fileArrListFiles.length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getSdkCacheDocCount$lambda$0(File file, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return StringsKt.m14167w(name, ".sdocx");
    }

    @JvmStatic
    @NotNull
    public static final String getNoteFilePath(@Nullable Context context, boolean includeSlash) {
        if (SAMSUNG_NOTES_PATH.length() == 0 && context != null && context.getFilesDir() != null) {
            String noteDirPath = getNoteDirPath(context);
            if (!TextUtils.isEmpty(noteDirPath)) {
                SAMSUNG_NOTES_PATH = AbstractC0541b.m756B(noteDirPath, "/SDocData");
            }
        }
        File file = new File(SAMSUNG_NOTES_PATH);
        if (!file.exists() && !file.mkdir()) {
            Logger.m8698e(TAG, "getNoteFilePath, Failed to make directory");
        }
        return includeSlash ? AbstractC0541b.m756B(SAMSUNG_NOTES_PATH, "/") : SAMSUNG_NOTES_PATH;
    }
}
