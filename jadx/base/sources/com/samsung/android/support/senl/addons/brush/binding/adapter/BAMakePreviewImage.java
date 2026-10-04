package com.samsung.android.support.senl.addons.brush.binding.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.addons.C7944R;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.utils.ScreenUtils;
import com.samsung.android.support.senl.addons.brush.model.canvas.BrushPreviewBitmap;
import com.samsung.android.support.senl.addons.brush.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\"\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/binding/adapter/BAMakePreviewImage;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "setPreviewImage", "", "view", "Landroid/view/View;", "previewBitmap", "Lcom/samsung/android/support/senl/addons/brush/model/canvas/BrushPreviewBitmap;", "makeBackgroundBitmap", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "width", "", "height", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BAMakePreviewImage {

    @NotNull
    public static final BAMakePreviewImage INSTANCE = new BAMakePreviewImage();

    @NotNull
    private static final String TAG = Logger.createBrushTag("BAMakePreviewImage");

    private BAMakePreviewImage() {
    }

    private final Bitmap makeBackgroundBitmap(Drawable drawable, int width, int height) {
        if (width <= 0 || height <= 0) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        for (int i = 0; i < width; i += intrinsicWidth) {
            for (int i2 = 0; i2 < height; i2 += intrinsicHeight) {
                Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
                canvas.drawBitmap(((BitmapDrawable) drawable).getBitmap(), i, i2, (Paint) null);
            }
        }
        return bitmapCreateBitmap;
    }

    public final void setPreviewImage(@NotNull View view, @Nullable BrushPreviewBitmap previewBitmap) {
        float f;
        float f4;
        float f5;
        Intrinsics.checkNotNullParameter(view, "view");
        if (!(view instanceof ImageView) || previewBitmap == null) {
            return;
        }
        int mDocWidth = previewBitmap.getMDocWidth();
        int mDocHeight = previewBitmap.getMDocHeight();
        String str = TAG;
        Logger.m7100d(str, "setPreviewImage. doc size = " + mDocWidth + SQLKeyword.COMMA + mDocHeight);
        Drawable drawable = view.getResources().getDrawable(C7944R.drawable.paper_kent, null);
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(...)");
        Bitmap bitmapMakeBackgroundBitmap = makeBackgroundBitmap(drawable, mDocWidth, mDocHeight);
        if (bitmapMakeBackgroundBitmap != null) {
            Bitmap mForegroundImage = previewBitmap.getMForegroundImage();
            float f6 = 0.0f;
            if (mForegroundImage != null) {
                int width = mForegroundImage.getWidth();
                int height = mForegroundImage.getHeight();
                if (mDocWidth != width || mDocHeight != height) {
                    Logger.m7100d(str, "setPreviewImage foregroundImage w:" + width + " h:" + height);
                    Logger.m7100d(str, "setPreviewImage target w:" + mDocWidth + " h:" + mDocHeight);
                    mForegroundImage = CommonUtil.INSTANCE.fitPreviewBitmap(mForegroundImage, mDocWidth, mDocHeight);
                }
                Canvas canvas = new Canvas(bitmapMakeBackgroundBitmap);
                Paint paint = new Paint(2);
                if (mForegroundImage != null) {
                    canvas.drawBitmap(mForegroundImage, 0.0f, 0.0f, paint);
                    if (!mForegroundImage.isRecycled()) {
                        mForegroundImage.recycle();
                    }
                }
            }
            Context context = view.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            if (ScreenUtils.getWindowType((Activity) context) != 0) {
                f4 = view.getContext().getApplicationContext().getResources().getDisplayMetrics().densityDpi / view.getContext().getResources().getDisplayMetrics().densityDpi;
                f = f4;
            } else {
                f = 1.0f;
                f4 = 1.0f;
            }
            float mCurrentZoomRatio = previewBitmap.getMCurrentZoomRatio() * f4;
            int mCurrentZoomRatio2 = mDocWidth * ((int) previewBitmap.getMCurrentZoomRatio());
            int mCurrentZoomRatio3 = mDocHeight * ((int) previewBitmap.getMCurrentZoomRatio());
            ImageView imageView = (ImageView) view;
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
            imageView.setImageBitmap(bitmapMakeBackgroundBitmap);
            Object parent = view.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
            View view2 = (View) parent;
            int width2 = view2.getWidth();
            int height2 = view2.getHeight();
            if (width2 > 0 && height2 > 0) {
                if (mCurrentZoomRatio2 > width2) {
                    mCurrentZoomRatio2 = width2;
                }
                if (mCurrentZoomRatio3 > height2) {
                    mCurrentZoomRatio3 = height2;
                }
            }
            Logger.m7100d(str, "setPreviewImage. Scale pageDocX: " + mCurrentZoomRatio2 + ", pageDocY: " + mCurrentZoomRatio3);
            if (previewBitmap.getMPan() != null) {
                PointF mPan = previewBitmap.getMPan();
                Intrinsics.checkNotNull(mPan);
                f6 = -mPan.x;
                PointF mPan2 = previewBitmap.getMPan();
                Intrinsics.checkNotNull(mPan2);
                f5 = -mPan2.y;
                if (Math.abs(f - 1.0f) > 0.001f) {
                    f6 /= f;
                    f5 /= f;
                }
            } else {
                Logger.m7105w(str, "setPreviewImage : pan info is null!");
                f5 = 0.0f;
            }
            Matrix matrix = new Matrix();
            matrix.preScale(mCurrentZoomRatio, mCurrentZoomRatio);
            matrix.preTranslate(f6, f5);
            StringBuilder sbM1176v = AbstractC0622a.m1176v("setPreviewImage. set matrix: preScale = ", mCurrentZoomRatio, ", preTranslate: ", f6, SQLKeyword.COMMA);
            sbM1176v.append(f5);
            Logger.m7100d(str, sbM1176v.toString());
            Logger.m7100d(str, "setPreviewImage. set matrix: target View size = " + view.getWidth() + " , " + view.getHeight());
            imageView.setImageMatrix(matrix);
        }
    }
}
