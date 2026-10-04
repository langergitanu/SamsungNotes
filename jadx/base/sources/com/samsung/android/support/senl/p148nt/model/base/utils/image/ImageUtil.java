package com.samsung.android.support.senl.p148nt.model.base.utils.image;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.media.SemExtendedFormat;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.ImageUtils;
import com.samsung.android.support.senl.p148nt.base.composer.common.ImageExtension;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.model.assist.common.ChnWatermarkUtil;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class ImageUtil {
    private static final String PE_GENERATED_IMAGE_DATA = "Generated";
    private static final String PE_GENERATED_IMAGE_INFO = "PEg_Info";
    private static final int PE_GENERATED_IMAGE_TYPE = 3473;
    private static final String TAG = ModelLogger.createTag("ntModel$ImageUtil");

    public static void addGenerativeEditData(String str) {
        File file = new File(str);
        if (file.exists()) {
            try {
                if (CscFeature.INSTANCE.getInstance().isChinaAiFeature()) {
                    ChnWatermarkUtil.INSTANCE.addInvisibleWatermark(file, str.endsWith(".jpg") ? "JPEG" : "PNG");
                } else if (SemExtendedFormat.addData(file, PE_GENERATED_IMAGE_INFO, PE_GENERATED_IMAGE_DATA.getBytes(StandardCharsets.UTF_8), PE_GENERATED_IMAGE_TYPE, 3) == 0) {
                    DataLogger.m12303e(TAG, "addGenerativeEditDataToFile");
                }
            } catch (IOException e) {
                AbstractC11014a.m12332q(e, new StringBuilder("addGenerativeEditDataToFile, IOException: "), TAG);
            }
        }
    }

    public static void addGenerativeEditExtraData(@NonNull SpenObjectBase spenObjectBase) {
        spenObjectBase.setExtraDataInt(Constants.EXTRA_KEY_AI_DRAWING_CREATOR, 1);
    }

    public static Bitmap convertDrawableToBitmap(Drawable drawable) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static Bitmap createBitmap(Bitmap bitmap, int i) {
        return ImageUtils.createBitmap(bitmap, i);
    }

    public static boolean isGenerativeEditImage(SpenObjectBase spenObjectBase) {
        if (spenObjectBase.hasExtraDataInt(Constants.EXTRA_KEY_AI_DRAWING_CREATOR) && spenObjectBase.getExtraDataInt(Constants.EXTRA_KEY_AI_DRAWING_CREATOR) == 1) {
            return true;
        }
        if (!(spenObjectBase instanceof SpenObjectImage)) {
            return false;
        }
        SpenObjectImage spenObjectImage = (SpenObjectImage) spenObjectBase;
        return isGenerativeEditImage(spenObjectImage.getImagePath()) || isGenerativeEditImage(spenObjectImage.getOriginalImagePath());
    }

    public static boolean isImageMimeType(String str) {
        return ImageExtension.INSTANCE.isImageMimeType(str);
    }

    public static boolean isImageType(String str) {
        return ImageExtension.INSTANCE.isImageType(str);
    }

    public static void removeGenerativeEditExtraData(@NonNull SpenObjectBase spenObjectBase) {
        spenObjectBase.removeExtraDataInt(Constants.EXTRA_KEY_AI_DRAWING_CREATOR);
    }

    public static Bitmap resizeBitmapImage(Bitmap bitmap, float f) {
        int i;
        int i2;
        int maxTextureSize = ImageUtils.getMaxTextureSize();
        String str = TAG;
        DataLogger.m12307i(str, "resizeBitmapImage, maxWidth: " + f + ", maxHeight: " + maxTextureSize);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f4 = (float) width;
        if (f < f4) {
            float f5 = f / f4;
            i2 = (int) (height * f5);
            i = (int) (f4 * f5);
            DataLogger.m12307i(str, "resizeBitmapImage, width newWidth: " + i + ", newHeight: " + i2);
        } else {
            i = width;
            i2 = height;
        }
        if (maxTextureSize < i2) {
            float f6 = maxTextureSize / height;
            i = (int) (i * f6);
            i2 = (int) (i2 * f6);
            DataLogger.m12307i(str, "resizeBitmapImage, height newWidth: " + i + ", newHeight: " + i2);
        }
        return (width == i && height == i2) ? bitmap : Bitmap.createScaledBitmap(bitmap, i, i2, true);
    }

    public static boolean saveBitmapToFileCache(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i) {
        return saveBitmapToFileCache(bitmap, str, compressFormat, i, 0);
    }

    public static boolean saveBitmapToFileCache(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i, int i2) {
        return saveBitmapToFileCache(bitmap, str, compressFormat, i, i2, false);
    }

    public static boolean saveBitmapToFileCache(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i, int i2, boolean z) {
        return ImageUtils.saveBitmapToFileCache(bitmap, str, compressFormat, i, i2, z);
    }

    public static boolean isGenerativeEditImage(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        try {
            return SemExtendedFormat.hasData(file, PE_GENERATED_IMAGE_INFO);
        } catch (IOException e) {
            AbstractC11014a.m12332q(e, new StringBuilder("isGenerativeEditImage, IOException: "), TAG);
            return false;
        }
    }
}
