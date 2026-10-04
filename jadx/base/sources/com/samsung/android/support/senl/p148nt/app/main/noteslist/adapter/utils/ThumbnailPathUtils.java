package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.PageCacheUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.DataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.model.utils.OldDocumentThumbnailUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0007J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0002J\u001c\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0007J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0007J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0007J\"\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/adapter/utils/ThumbnailPathUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getSimpleThumbnailFilePath", "uuid", "isDarkMode", "", "isSupportInvertedBGColor", "fileName", "docUuid", "getSdocHWThumbnailFilePath", "strokeUuid", "viewMode", "", "getSdocThumbnailFilePath", "contentUuid", "isExistFilePath", "filePath", "generateThumbnailPath", "hasTextOnly", "getExistFilePath", "getThumbnailFilePath", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ThumbnailPathUtils {

    @NotNull
    public static final ThumbnailPathUtils INSTANCE = new ThumbnailPathUtils();

    @NotNull
    private static final String TAG = "ThumbnailPathUtils";

    private ThumbnailPathUtils() {
    }

    private final String generateThumbnailPath(String uuid, String fileName) {
        Context applicationContext = BaseUtils.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext);
        String rootCacheDirectoryPath = PageCacheUtils.getRootCacheDirectoryPath(applicationContext);
        String str = File.separator;
        return AbstractC0622a.m1170p(str, fileName, AbstractC2821a.m2228s(rootCacheDirectoryPath, str, uuid, str, Constants.MAIN_THUMBNAIL_PATH));
    }

    @JvmStatic
    @Nullable
    public static final String getExistFilePath(@NotNull String uuid, @NotNull String fileName) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        String strGenerateThumbnailPath = INSTANCE.generateThumbnailPath(uuid, fileName);
        if (isExistFilePath(strGenerateThumbnailPath)) {
            return strGenerateThumbnailPath;
        }
        return null;
    }

    @JvmStatic
    @Nullable
    public static final String getSdocHWThumbnailFilePath(@Nullable String strokeUuid, int viewMode) {
        if (TextUtils.isEmpty(strokeUuid)) {
            return null;
        }
        return ContentUtils.isGridViewMode(viewMode) ? OldDocumentThumbnailUtils.getHWThumbnailFilePath(BaseUtils.getApplicationContext(), strokeUuid, DataConstants.GRID_POSTFIX) : OldDocumentThumbnailUtils.getHWThumbnailFilePath(BaseUtils.getApplicationContext(), strokeUuid, DataConstants.LIST_POSTFIX);
    }

    @JvmStatic
    @Nullable
    public static final String getSdocThumbnailFilePath(@Nullable String contentUuid) {
        if (TextUtils.isEmpty(contentUuid)) {
            return null;
        }
        return OldDocumentThumbnailUtils.getThumbnailFilePath(BaseUtils.getApplicationContext(), contentUuid);
    }

    @JvmStatic
    @Nullable
    public static final String getSimpleThumbnailFilePath(@NotNull String uuid, boolean isDarkMode, boolean isSupportInvertedBGColor) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        ThumbnailPathUtils thumbnailPathUtils = INSTANCE;
        String simpleThumbnailFilePath = thumbnailPathUtils.getSimpleThumbnailFilePath((isDarkMode && isSupportInvertedBGColor) ? Constants.MAIN_DARK_THUMBNAIL_FILE_NAME : "thumbnail", uuid);
        if (simpleThumbnailFilePath != null) {
            return simpleThumbnailFilePath;
        }
        MainLogger.m7258i(TAG, "getSimpleThumbnailFilePath# check full thumbnail path");
        return thumbnailPathUtils.getSimpleThumbnailFilePath((isDarkMode && isSupportInvertedBGColor) ? Constants.MAIN_DARK_FULL_THUMBNAIL_FILE_NAME : Constants.MAIN_FULL_THUMBNAIL_FILE_NAME, uuid);
    }

    @JvmStatic
    @Nullable
    public static final String getThumbnailFilePath(@NotNull String docUuid, boolean isDarkMode, boolean isSupportInvertedBGColor) {
        Intrinsics.checkNotNullParameter(docUuid, "docUuid");
        String existFilePath = null;
        for (String str : (isDarkMode && isSupportInvertedBGColor) ? new String[]{Constants.MAIN_DARK_FULL_THUMBNAIL_FILE_NAME, Constants.MAIN_DARK_THUMBNAIL_FILE_NAME, "d_thumbnail_text"} : new String[]{Constants.MAIN_FULL_THUMBNAIL_FILE_NAME, "thumbnail", "thumbnail_text"}) {
            existFilePath = getExistFilePath(docUuid, str);
            if (existFilePath != null) {
                return existFilePath;
            }
        }
        return existFilePath;
    }

    @JvmStatic
    public static final boolean hasTextOnly(@NotNull String docUuid, boolean isDarkMode) {
        Intrinsics.checkNotNullParameter(docUuid, "docUuid");
        if (getExistFilePath(docUuid, isDarkMode ? "d_full_thumbnail_text" : "full_thumbnail_text") == null) {
            return getExistFilePath(docUuid, isDarkMode ? "d_thumbnail_text" : "thumbnail_text") != null && getExistFilePath(docUuid, "image") == null;
        }
        return true;
    }

    @JvmStatic
    public static final boolean isExistFilePath(@Nullable String filePath) {
        if (TextUtils.isEmpty(filePath)) {
            return false;
        }
        return AbstractC2322a.m1607A(filePath);
    }

    private final String getSimpleThumbnailFilePath(String fileName, String docUuid) {
        String[] strArr = {fileName, AbstractC0541b.m756B(fileName, Constants.MAIN_THUMBNAIL_FILE_NAME_TEXT)};
        for (int i = 0; i < 2; i++) {
            String strGenerateThumbnailPath = generateThumbnailPath(docUuid, strArr[i]);
            if (AbstractC2322a.m1607A(strGenerateThumbnailPath)) {
                return strGenerateThumbnailPath;
            }
        }
        return null;
    }
}
