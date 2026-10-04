package com.samsung.android.support.senl.p148nt.app.common.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.bitmap.BitmapInfo;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.base.common.util.ImageUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0007J(\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eH\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/common/util/ThumbnailBitmapUtil;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "MAX_THUMBNAIL_WIDTH", "", "getBitmapInfoForImageView", "Lcom/samsung/android/support/senl/nt/app/common/bitmap/BitmapInfo;", "view", "Landroid/widget/ImageView;", "filePath", "viewMode", "", "calculateInImageSize", "imageSizeWidth", "imageSizeHeight", "reqWidth", "reqHeight", "recycleBitmap", "", "image", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ThumbnailBitmapUtil {

    @NotNull
    public static final ThumbnailBitmapUtil INSTANCE = new ThumbnailBitmapUtil();
    private static final float MAX_THUMBNAIL_WIDTH = 2048.0f;

    @NotNull
    private static final String TAG = "ThumbnailBitmapUtil";

    private ThumbnailBitmapUtil() {
    }

    private final int calculateInImageSize(int imageSizeWidth, int imageSizeHeight, int reqWidth, int reqHeight) {
        if (reqWidth <= 0 && reqHeight <= 0) {
            return 0;
        }
        int i = 1;
        if (imageSizeHeight <= reqHeight && imageSizeWidth <= reqWidth) {
            return 1;
        }
        int i2 = imageSizeHeight / 2;
        int i4 = imageSizeWidth / 2;
        while (i2 / i > reqHeight && i4 / i > reqWidth) {
            i *= 2;
        }
        return i;
    }

    @JvmStatic
    @NotNull
    public static final BitmapInfo getBitmapInfoForImageView(@Nullable ImageView view, @Nullable String filePath, int viewMode) {
        int iMin;
        int iMin2;
        Bitmap bitmapResizeBitmapImage = null;
        if (view != null) {
            try {
                Rect imageSize = ImageUtils.getImageSize(filePath);
                fHeight = imageSize.isEmpty() ? 1.0f : imageSize.height() / imageSize.width();
                int iWidth = imageSize.width();
                int iHeight = imageSize.height();
                int size = View.MeasureSpec.getSize(view.getMeasuredWidth());
                int size2 = View.MeasureSpec.getSize(view.getMeasuredHeight());
                if (size == 0 || size2 == 0) {
                    iMin = iWidth;
                    iMin2 = iHeight;
                } else {
                    iMin = Math.min(size, iWidth);
                    iMin2 = Math.min(size2, iHeight);
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                if (3 == viewMode) {
                    options.inSampleSize = view.getResources().getInteger(C8003R.integer.noteslist_simple_thumbnail_scale_size);
                } else {
                    options.inSampleSize = INSTANCE.calculateInImageSize(iWidth, iHeight, iMin, iMin2);
                }
                float fCoerceAtMost = RangesKt.coerceAtMost(MAX_THUMBNAIL_WIDTH, iMin);
                Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(filePath, options);
                Intrinsics.checkNotNull(bitmapDecodeFile);
                bitmapResizeBitmapImage = ImageUtils.resizeBitmapImage(bitmapDecodeFile, fCoerceAtMost);
                MainLogger.m7254d(TAG, "getBitmap# bitmapWidth : " + bitmapResizeBitmapImage.getWidth() + ", bitmapHeight : " + bitmapResizeBitmapImage.getHeight() + ", viewWidth + " + iMin + ", viewHeight + " + iMin2 + ", viewMeasuredWidth + " + size + ", viewMeasuredHeight + " + size2 + ", imageSize : " + imageSize + ", filePath : " + MainLogger.getEncode(filePath));
            } catch (Exception e) {
                AbstractC6670b.m4738C("getBitmap# e : ", e.getMessage(), TAG);
            }
        }
        return new BitmapInfo.BitmapInfoGetBuilder().setBitmapInfo(bitmapResizeBitmapImage).setRatioInfo(fHeight).build();
    }

    @JvmStatic
    public static final void recycleBitmap(@Nullable ImageView image) {
        Bitmap bitmap;
        Drawable drawable = image != null ? image.getDrawable() : null;
        BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        if (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) {
            return;
        }
        bitmap.recycle();
    }
}
