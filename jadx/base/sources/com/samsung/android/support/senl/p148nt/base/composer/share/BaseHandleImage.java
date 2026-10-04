package com.samsung.android.support.senl.p148nt.base.composer.share;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.text.TextUtils;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.sdk.pen.document.SpenObjectPainting;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ImageUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.io.IOException;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/share/BaseHandleImage;", "", "tag", "", "contract", "Lcom/samsung/android/support/senl/nt/base/composer/share/BaseHandleImage$Contract;", "<init>", "(Ljava/lang/String;Lcom/samsung/android/support/senl/nt/base/composer/share/BaseHandleImage$Contract;)V", "getTag", "()Ljava/lang/String;", "getContract", "()Lcom/samsung/android/support/senl/nt/base/composer/share/BaseHandleImage$Contract;", "saveAsImage", "imageObject", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "desDirPath", "fileName", "crop", "Landroid/graphics/Bitmap;", "bitmap", "cropRect", "Landroid/graphics/Rect;", "Contract", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BaseHandleImage {

    @NotNull
    private final Contract contract;

    @NotNull
    private final String tag;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/share/BaseHandleImage$Contract;", "", "markGenerativeEditImage", "", "obj", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "thumbnailPath", "", "path", "originalPath", "imageCropRect", "Landroid/graphics/Rect;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class DefaultImpls {
            public static void markGenerativeEditImage(@NotNull Contract contract, @NotNull SpenObjectBase obj, @NotNull String thumbnailPath, @NotNull String path, @Nullable String str, @Nullable Rect rect) {
                Intrinsics.checkNotNullParameter(obj, "obj");
                Intrinsics.checkNotNullParameter(thumbnailPath, "thumbnailPath");
                Intrinsics.checkNotNullParameter(path, "path");
            }
        }

        void markGenerativeEditImage(@NotNull SpenObjectBase obj, @NotNull String thumbnailPath, @NotNull String path, @Nullable String originalPath, @Nullable Rect imageCropRect);
    }

    public BaseHandleImage(@NotNull String tag, @NotNull Contract contract) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(contract, "contract");
        this.tag = tag;
        this.contract = contract;
    }

    private final Bitmap crop(Bitmap bitmap, Rect cropRect) {
        if (cropRect != null && !cropRect.isEmpty()) {
            if (cropRect.width() + cropRect.left <= bitmap.getWidth()) {
                if (cropRect.height() + cropRect.top <= bitmap.getHeight()) {
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, cropRect.left, cropRect.top, cropRect.width(), cropRect.height());
                    Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
                    return bitmapCreateBitmap;
                }
            }
            Logger.m8698e(this.tag, "saveAsImage# cropRect is wrong. " + cropRect);
        }
        return bitmap;
    }

    @NotNull
    public final Contract getContract() {
        return this.contract;
    }

    @NotNull
    public final String getTag() {
        return this.tag;
    }

    @NotNull
    public final String saveAsImage(@Nullable SpenObjectBase imageObject, @Nullable String desDirPath, @Nullable String fileName) {
        Bitmap capturedBitmap;
        String str;
        String str2;
        boolean z;
        Rect cropRect;
        String lowerCase;
        String str3;
        if (imageObject == null) {
            Logger.m8698e(this.tag, "saveAsImage# imageObject is null");
            return "";
        }
        boolean z2 = false;
        if (imageObject.getType() == 3 && (imageObject instanceof SpenObjectImage)) {
            SpenObjectImage spenObjectImage = (SpenObjectImage) imageObject;
            String imagePath = spenObjectImage.getImagePath();
            String originalImagePath = spenObjectImage.getOriginalImagePath();
            capturedBitmap = spenObjectImage.getImage();
            cropRect = spenObjectImage.getCropRect();
            str = imagePath;
            z = true;
            str2 = originalImagePath;
        } else {
            if (imageObject instanceof SpenObjectPainting) {
                SpenObjectPainting spenObjectPainting = (SpenObjectPainting) imageObject;
                String thumbnailPath = spenObjectPainting.getThumbnailPath();
                Intrinsics.checkNotNull(thumbnailPath);
                capturedBitmap = BitmapFactory.decodeFile(thumbnailPath);
                str2 = "";
                cropRect = spenObjectPainting.getCropRect();
                str = thumbnailPath;
            } else {
                capturedBitmap = null;
                if (imageObject.getType() == 19) {
                    str2 = "";
                    str = "CapturedBitmap.png";
                    cropRect = null;
                    capturedBitmap = imageObject.getCapturedBitmap();
                } else {
                    str = "";
                    str2 = str;
                    z = false;
                    cropRect = null;
                }
            }
            z = false;
        }
        if (TextUtils.isEmpty(str)) {
            Logger.m8698e(this.tag, "saveAsImage# path is empty");
            return "";
        }
        if (capturedBitmap == null) {
            Logger.m8698e(this.tag, "saveAsImage# bitmap is null");
            return "";
        }
        Bitmap bitmapCrop = crop(capturedBitmap, cropRect);
        int iM14130D = StringsKt.m14130D(str, '.');
        if (iM14130D >= 0) {
            String strSubstring = str.substring(iM14130D + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            lowerCase = strSubstring.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = "";
        }
        if (Intrinsics.areEqual(Constants.THUMBNAIL_GIF_EXTENSION, lowerCase)) {
            str3 = Constants.THUMBNAIL_GIF_EXTENSION;
        } else {
            str3 = Constants.THUMBNAIL_PNG_EXTENSION;
            if (!Intrinsics.areEqual(Constants.THUMBNAIL_PNG_EXTENSION, lowerCase) && !Intrinsics.areEqual("spi", lowerCase) && (cropRect == null || cropRect.isEmpty())) {
                str3 = "jpg";
                if (Intrinsics.areEqual("jpg", lowerCase)) {
                    z2 = true;
                }
            }
        }
        String documentTimeName = TextUtils.isEmpty(fileName) ? BaseShareUtil.getDocumentTimeName("") : fileName;
        Intrinsics.checkNotNull(desDirPath);
        Intrinsics.checkNotNull(documentTimeName);
        String strGenerateUniqueFilePath = FileUtils.generateUniqueFilePath(desDirPath, documentTimeName, str3);
        if (Intrinsics.areEqual(Constants.THUMBNAIL_GIF_EXTENSION, str3) || z2) {
            try {
                BaseUtils.copyFile(str, strGenerateUniqueFilePath);
            } catch (IOException e) {
                Logger.m8699e(this.tag, "saveAsImage", e);
            }
        } else {
            ImageUtils.INSTANCE.saveBitmapToFileCache(bitmapCrop, strGenerateUniqueFilePath, Bitmap.CompressFormat.PNG, 100);
        }
        if (z) {
            this.contract.markGenerativeEditImage(imageObject, strGenerateUniqueFilePath, str, str2, cropRect);
        }
        return strGenerateUniqueFilePath;
    }
}
