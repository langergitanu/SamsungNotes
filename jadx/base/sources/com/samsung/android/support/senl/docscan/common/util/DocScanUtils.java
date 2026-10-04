package com.samsung.android.support.senl.docscan.common.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.docscan.common.Constant;
import com.samsung.android.support.senl.docscan.common.Logger;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0007J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0007J\b\u0010\f\u001a\u00020\u0005H\u0007J\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0007J\u001c\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u0007H\u0007J\u0012\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/common/util/DocScanUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "ORIENTATION_NOT_FOUND", "", "getThumbnailPath", "uuid", "getEditingPath", "getScanCachePath", "getScanCacheDir", "getBitmapImageFromPath", "Landroid/graphics/Bitmap;", DBSchema.DocumentThumbnail.IMAGE_PATH, "sampleSize", "getOrientationFromPath", "path", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DocScanUtils {

    @NotNull
    public static final DocScanUtils INSTANCE = new DocScanUtils();
    private static final int ORIENTATION_NOT_FOUND = -1;

    @NotNull
    private static final String TAG = "DocScanUtils";

    private DocScanUtils() {
    }

    @JvmStatic
    @Nullable
    public static final Bitmap getBitmapImageFromPath(@Nullable String imagePath) {
        return getBitmapImageFromPath(imagePath, 1);
    }

    @JvmStatic
    @NotNull
    public static final String getEditingPath(@NotNull String uuid) {
        File cacheDir;
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Context applicationContext = BaseUtils.getApplicationContext();
        String string = (applicationContext == null || (cacheDir = applicationContext.getCacheDir()) == null) ? null : cacheDir.toString();
        String str = File.separator;
        StringBuilder sbM2228s = AbstractC2821a.m2228s(string, str, Constant.INSTANCE.getDOC_SCAN_CACHE_DIR(), uuid, str);
        sbM2228s.append(Constant.DOC_SCAN_EDIT_PATH);
        String string2 = sbM2228s.toString();
        File file = new File(string2);
        if (!file.exists() && !file.mkdirs()) {
            Logger.m7148i(TAG, "getEditingPath# The directory was not created");
        }
        return AbstractC0541b.m756B(string2, str);
    }

    @JvmStatic
    public static final int getOrientationFromPath(@Nullable String path) {
        if (path == null || StringsKt.isBlank(path)) {
            return -1;
        }
        try {
            int attributeInt = new ExifInterface(path).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (IOException e) {
            Logger.m7146e(TAG, e.getMessage());
            return -1;
        }
    }

    @JvmStatic
    @NotNull
    public static final String getScanCacheDir() {
        File cacheDir;
        Context applicationContext = BaseUtils.getApplicationContext();
        return AbstractC0541b.m757C((applicationContext == null || (cacheDir = applicationContext.getCacheDir()) == null) ? null : cacheDir.toString(), File.separator, Constant.INSTANCE.getDOC_SCAN_CACHE_DIR());
    }

    @JvmStatic
    @NotNull
    public static final String getScanCachePath(@Nullable String uuid) {
        File cacheDir;
        Context applicationContext = BaseUtils.getApplicationContext();
        String string = (applicationContext == null || (cacheDir = applicationContext.getCacheDir()) == null) ? null : cacheDir.toString();
        String str = File.separator;
        String strM2221l = AbstractC2821a.m2221l(string, str, Constant.INSTANCE.getDOC_SCAN_CACHE_DIR(), uuid);
        File file = new File(strM2221l);
        if (!file.exists() && !file.mkdirs()) {
            Logger.m7148i(TAG, "getScanCachePath# The directory was not created");
        }
        return AbstractC0541b.m756B(strM2221l, str);
    }

    @JvmStatic
    @NotNull
    public static final String getThumbnailPath(@NotNull String uuid) {
        File cacheDir;
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Context applicationContext = BaseUtils.getApplicationContext();
        String string = (applicationContext == null || (cacheDir = applicationContext.getCacheDir()) == null) ? null : cacheDir.toString();
        String str = File.separator;
        StringBuilder sbM2228s = AbstractC2821a.m2228s(string, str, Constant.INSTANCE.getDOC_SCAN_CACHE_DIR(), uuid, str);
        sbM2228s.append("thumbnail");
        String string2 = sbM2228s.toString();
        File file = new File(string2);
        if (!file.exists() && !file.mkdirs()) {
            Logger.m7148i(TAG, "getThumbnailPath# The directory was not created");
        }
        return AbstractC0541b.m756B(string2, str);
    }

    @JvmStatic
    @Nullable
    public static final Bitmap getBitmapImageFromPath(@Nullable String imagePath, int sampleSize) {
        Logger.m7148i(TAG, "getBitmapImageFromPath# sampleSize: " + sampleSize);
        Matrix matrix = new Matrix();
        matrix.postRotate((float) getOrientationFromPath(imagePath));
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inSampleSize = sampleSize;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(imagePath, options);
        if (bitmapDecodeFile == null) {
            return null;
        }
        return Bitmap.createBitmap(bitmapDecodeFile, 0, 0, bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight(), matrix, true);
    }
}
