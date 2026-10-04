package com.samsung.android.support.senl.docscan.detect.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.Key;
import com.samsung.android.support.senl.docscan.C7976R;
import com.samsung.android.support.senl.docscan.common.Logger;
import com.samsung.android.support.senl.docscan.common.util.CommonUtils;
import com.samsung.android.support.senl.docscan.detect.controller.CameraProperty;
import com.samsung.android.support.senl.docscan.detect.util.CameraHelper;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 +2\u00020\u0001:\u0001+B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0014J&\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u0010\u0010$\u001a\u00020\u00192\b\u0010%\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010&\u001a\u00020\u0019J\u001d\u0010'\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010)0(2\u0006\u0010\u001f\u001a\u00020\n¢\u0006\u0002\u0010*R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/detect/view/DetectOverlayView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mPaint", "Landroid/graphics/Paint;", "mVertexArray", "", "mTextureWidth", "mTextureHeight", "mPrimaryColor", "mMatrix", "Landroid/graphics/Matrix;", "mIsClear", "", "mNeedSkip", "init", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setTransform", "matrix", Key.ROTATION, "screenSize", "Landroid/graphics/Point;", "textureSize", "Landroid/util/Size;", "setResult", "corners", "clearCanvas", "getResultPoint", "", "Landroid/graphics/PointF;", "(I)[Landroid/graphics/PointF;", "Companion", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DetectOverlayView extends View {

    @NotNull
    private static final String TAG = "DetectOverlayView";
    private boolean mIsClear;

    @Nullable
    private Matrix mMatrix;
    private boolean mNeedSkip;

    @Nullable
    private Paint mPaint;
    private int mPrimaryColor;
    private int mTextureHeight;
    private int mTextureWidth;

    @Nullable
    private float[] mVertexArray;

    public DetectOverlayView(@Nullable Context context) {
        super(context);
        init();
    }

    private final void init() {
        Paint paint = new Paint(1);
        this.mPaint = paint;
        Intrinsics.checkNotNull(paint);
        paint.setColor(-256);
        Paint paint2 = this.mPaint;
        Intrinsics.checkNotNull(paint2);
        paint2.setStrokeWidth(getResources().getDimension(C7976R.dimen.detect_area_line_width));
        Paint paint3 = this.mPaint;
        Intrinsics.checkNotNull(paint3);
        paint3.setStyle(Paint.Style.STROKE);
        this.mPrimaryColor = getResources().getColor(C7976R.color.detect_highlight_color, null);
        this.mMatrix = new Matrix();
    }

    public final void clearCanvas() {
        if (this.mNeedSkip) {
            return;
        }
        if (this.mVertexArray != null) {
            this.mVertexArray = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};
        }
        this.mIsClear = true;
        this.mNeedSkip = true;
        invalidate();
    }

    @NotNull
    public final PointF[] getResultPoint(int rotation) {
        if (this.mVertexArray == null) {
            return new PointF[]{new PointF(0.0f, 0.0f), new PointF(1.0f, 0.0f), new PointF(1.0f, 1.0f), new PointF(0.0f, 1.0f)};
        }
        PointF[] pointFArr = new PointF[4];
        Logger.m7145d(TAG, "getResultPoint# rotation : " + rotation);
        for (int i = 0; i < 4; i++) {
            if (rotation == 0) {
                float[] fArr = this.mVertexArray;
                Intrinsics.checkNotNull(fArr);
                int i2 = i * 2;
                float f = 1 - fArr[i2 + 1];
                float[] fArr2 = this.mVertexArray;
                Intrinsics.checkNotNull(fArr2);
                pointFArr[i] = new PointF(f, fArr2[i2]);
            } else if (rotation == 90) {
                float[] fArr3 = this.mVertexArray;
                Intrinsics.checkNotNull(fArr3);
                int i4 = i * 2;
                float f4 = fArr3[i4];
                float[] fArr4 = this.mVertexArray;
                Intrinsics.checkNotNull(fArr4);
                pointFArr[i] = new PointF(f4, fArr4[i4 + 1]);
            } else if (rotation != 180) {
                float f5 = 1;
                float[] fArr5 = this.mVertexArray;
                Intrinsics.checkNotNull(fArr5);
                int i5 = i * 2;
                float f6 = f5 - fArr5[i5];
                float[] fArr6 = this.mVertexArray;
                Intrinsics.checkNotNull(fArr6);
                pointFArr[i] = new PointF(f6, f5 - fArr6[i5 + 1]);
            } else {
                float[] fArr7 = this.mVertexArray;
                Intrinsics.checkNotNull(fArr7);
                int i6 = i * 2;
                float f7 = fArr7[i6 + 1];
                float[] fArr8 = this.mVertexArray;
                Intrinsics.checkNotNull(fArr8);
                pointFArr[i] = new PointF(f7, 1 - fArr8[i6]);
            }
        }
        return pointFArr;
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        float f;
        float f4;
        float f5;
        float f6;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.mVertexArray == null || this.mTextureWidth == 0 || this.mTextureHeight == 0) {
            return;
        }
        canvas.setMatrix(this.mMatrix);
        if (this.mIsClear) {
            Paint paint = this.mPaint;
            Intrinsics.checkNotNull(paint);
            paint.setColor(0);
            this.mIsClear = false;
        } else {
            Paint paint2 = this.mPaint;
            Intrinsics.checkNotNull(paint2);
            paint2.setColor(this.mPrimaryColor);
        }
        int i = 0;
        while (true) {
            float[] fArr = this.mVertexArray;
            Intrinsics.checkNotNull(fArr);
            if (i >= fArr.length) {
                return;
            }
            if (i == 6) {
                float[] fArr2 = this.mVertexArray;
                Intrinsics.checkNotNull(fArr2);
                f = fArr2[i + 1];
                float[] fArr3 = this.mVertexArray;
                Intrinsics.checkNotNull(fArr3);
                f4 = fArr3[i];
                float[] fArr4 = this.mVertexArray;
                Intrinsics.checkNotNull(fArr4);
                f5 = fArr4[1];
                float[] fArr5 = this.mVertexArray;
                Intrinsics.checkNotNull(fArr5);
                f6 = fArr5[0];
            } else {
                float[] fArr6 = this.mVertexArray;
                Intrinsics.checkNotNull(fArr6);
                f = fArr6[i + 1];
                float[] fArr7 = this.mVertexArray;
                Intrinsics.checkNotNull(fArr7);
                f4 = fArr7[i];
                float[] fArr8 = this.mVertexArray;
                Intrinsics.checkNotNull(fArr8);
                f5 = fArr8[i + 3];
                float[] fArr9 = this.mVertexArray;
                Intrinsics.checkNotNull(fArr9);
                f6 = fArr9[i + 2];
            }
            int i2 = this.mTextureWidth;
            int i4 = this.mTextureHeight;
            Paint paint3 = this.mPaint;
            Intrinsics.checkNotNull(paint3);
            canvas.drawLine(f * i2, f4 * i4, f5 * i2, f6 * i4, paint3);
            i += 2;
        }
    }

    public final void setResult(@Nullable float[] corners) {
        this.mNeedSkip = false;
        this.mVertexArray = corners;
        invalidate();
    }

    public final void setTransform(@NotNull Matrix matrix, int rotation, @NotNull Point screenSize, @NotNull Size textureSize) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        Intrinsics.checkNotNullParameter(screenSize, "screenSize");
        Intrinsics.checkNotNullParameter(textureSize, "textureSize");
        setResult(null);
        this.mTextureWidth = textureSize.getWidth();
        this.mTextureHeight = textureSize.getHeight();
        this.mMatrix = matrix;
        Intrinsics.checkNotNull(matrix);
        matrix.postScale(-1.0f, 1.0f, this.mTextureWidth / 2.0f, 0.0f);
        int navigationBarHeight = InputMethodCompat.INSTANCE.getInstance().getNavigationBarHeight(getContext());
        int statusBarHeight = WindowManagerCompat.INSTANCE.getInstance().getStatusBarHeight(getContext());
        int i4 = SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() >= 70000 ? navigationBarHeight : 0;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        if (!CommonUtils.isStandardViewOfFoldDevice(context) && !CameraProperty.INSTANCE.isTranslucentNavigationBar(getContext())) {
            i4 = navigationBarHeight + statusBarHeight;
        }
        StringBuilder sbM1173s = AbstractC0622a.m1173s(navigationBarHeight, statusBarHeight, "setTransform# naviHeight : ", ", statusHeight : ", ", systemUIHeight : ");
        sbM1173s.append(i4);
        Logger.m7145d(TAG, sbM1173s.toString());
        ResourceUtils resourceUtils = ResourceUtils.INSTANCE;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        if (resourceUtils.isNavigationLocatedBottom(context2)) {
            screenSize.y -= i4;
        } else {
            screenSize.x -= i4;
        }
        if (CameraHelper.isLandscape(rotation)) {
            i = (screenSize.y - this.mTextureWidth) / 2;
            i2 = (screenSize.x - this.mTextureHeight) / 2;
        } else {
            i = (screenSize.x - this.mTextureWidth) / 2;
            i2 = (screenSize.y - this.mTextureHeight) / 2;
        }
        matrix.postTranslate(i, i2);
    }

    public DetectOverlayView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public DetectOverlayView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
