package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.drawable.Drawable;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001+BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0016\u001a\u00020\u00172\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0013J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0003H\u0016J\u0012\u0010 \u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u0003H\u0017J\u000e\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&J\u0016\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0006R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SliderBackgroundDrawable;", "Landroid/graphics/drawable/Drawable;", "width", "", "height", "radius", "", "strokeWidth", "startAngle", "sweepAngle", "color", "", "<init>", "(IIFFFF[I)V", "mLinearGradient", "Landroid/graphics/LinearGradient;", "mPaint", "Landroid/graphics/Paint;", "mDrawArcInfo", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SliderBackgroundDrawable$DrawArcInfo;", "mCenterX", "mCenterY", "updatePaint", "", "close", "setDrawInfo", "drawArcInfo", "draw", "canvas", "Landroid/graphics/Canvas;", "setAlpha", "alpha", BaseWidgetConstant.SET_COLOR_FILTER, "colorFilter", "Landroid/graphics/ColorFilter;", "getOpacity", "enableCheckerboardDrawable", "context", "Landroid/content/Context;", "isPointInPath", "", "x", "y", "DrawArcInfo", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SliderBackgroundDrawable extends Drawable {

    @Nullable
    private int[] color;
    private float mCenterX;
    private float mCenterY;

    @NotNull
    private DrawArcInfo mDrawArcInfo;

    @Nullable
    private LinearGradient mLinearGradient;

    @Nullable
    private Paint mPaint;
    private final float startAngle;
    private final float sweepAngle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ6\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SliderBackgroundDrawable$DrawArcInfo;", "", "width", "", "height", "radius", "strokeWidth", "startAngle", "sweepAngle", "<init>", "(FFFFFF)V", "getWidth", "()F", "setWidth", "(F)V", "getHeight", "setHeight", "getRadius", "setRadius", "getStrokeWidth", "setStrokeWidth", "getStartAngle", "setStartAngle", "getSweepAngle", "setSweepAngle", "setInfo", "", "toString", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class DrawArcInfo {
        private float height;
        private float radius;
        private float startAngle;
        private float strokeWidth;
        private float sweepAngle;
        private float width;

        public DrawArcInfo() {
            this(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 63, null);
        }

        public final float getHeight() {
            return this.height;
        }

        public final float getRadius() {
            return this.radius;
        }

        public final float getStartAngle() {
            return this.startAngle;
        }

        public final float getStrokeWidth() {
            return this.strokeWidth;
        }

        public final float getSweepAngle() {
            return this.sweepAngle;
        }

        public final float getWidth() {
            return this.width;
        }

        public final void setHeight(float f) {
            this.height = f;
        }

        public final void setInfo(float width, float height, float radius, float strokeWidth, float startAngle, float sweepAngle) {
            this.width = width;
            this.height = height;
            this.radius = radius;
            this.strokeWidth = strokeWidth;
            this.startAngle = startAngle;
            this.sweepAngle = sweepAngle;
        }

        public final void setRadius(float f) {
            this.radius = f;
        }

        public final void setStartAngle(float f) {
            this.startAngle = f;
        }

        public final void setStrokeWidth(float f) {
            this.strokeWidth = f;
        }

        public final void setSweepAngle(float f) {
            this.sweepAngle = f;
        }

        public final void setWidth(float f) {
            this.width = f;
        }

        @NotNull
        public String toString() {
            float f = this.width;
            float f4 = this.height;
            float f5 = this.radius;
            float f6 = this.strokeWidth;
            float f7 = this.startAngle;
            float f8 = this.sweepAngle;
            StringBuilder sbM1176v = AbstractC0622a.m1176v("(width=", f, " height=", f4, " radius=");
            AbstractC11014a.m12337v(sbM1176v, f5, " strokeWidth=", f6, " startAngle=");
            return AbstractC1038a.m1216q(sbM1176v, f7, " sweepAngle=", f8, ")");
        }

        public DrawArcInfo(float f, float f4, float f5, float f6, float f7, float f8) {
            this.width = f;
            this.height = f4;
            this.radius = f5;
            this.strokeWidth = f6;
            this.startAngle = f7;
            this.sweepAngle = f8;
        }

        public /* synthetic */ DrawArcInfo(float f, float f4, float f5, float f6, float f7, float f8, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 0.0f : f, (i & 2) != 0 ? 0.0f : f4, (i & 4) != 0 ? 0.0f : f5, (i & 8) != 0 ? 0.0f : f6, (i & 16) != 0 ? 0.0f : f7, (i & 32) != 0 ? 0.0f : f8);
        }
    }

    public SliderBackgroundDrawable(int i, int i2, float f, float f4, float f5, float f6, @Nullable int[] iArr) {
        this.startAngle = f5;
        this.sweepAngle = f6;
        this.color = iArr;
        DrawArcInfo drawArcInfo = new DrawArcInfo(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 63, null);
        this.mDrawArcInfo = drawArcInfo;
        float f7 = i;
        float f8 = i2;
        drawArcInfo.setInfo(f7, f8, f, f4, f5, f6);
        this.mCenterX = f7 / 2.0f;
        this.mCenterY = f8 / 2.0f;
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(f4);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setAntiAlias(true);
        this.mPaint = paint;
        updatePaint(this.color);
    }

    public final void close() {
        this.mLinearGradient = null;
        this.mPaint = null;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        RectF rectF = new RectF(this.mCenterX - this.mDrawArcInfo.getRadius(), this.mCenterY - this.mDrawArcInfo.getRadius(), this.mDrawArcInfo.getRadius() + this.mCenterX, this.mDrawArcInfo.getRadius() + this.mCenterY);
        float startAngle = this.mDrawArcInfo.getStartAngle();
        float sweepAngle = this.mDrawArcInfo.getSweepAngle();
        Paint paint = this.mPaint;
        Intrinsics.checkNotNull(paint);
        canvas.drawArc(rectF, startAngle, sweepAngle, false, paint);
    }

    public final void enableCheckerboardDrawable(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Drawable drawable = context.getResources().getDrawable(C9086R.drawable.checkerboard_pattern);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        drawable.draw(new Canvas(bitmapCreateBitmap));
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setStrokeWidth(this.mDrawArcInfo.getStrokeWidth());
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            paint.setShader(new BitmapShader(bitmapCreateBitmap, tileMode, tileMode));
        }
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java", replaceWith = @ReplaceWith(expression = "PixelFormat.TRANSLUCENT", imports = {"android.graphics.PixelFormat"}))
    public int getOpacity() {
        return -3;
    }

    public final boolean isPointInPath(float x, float y2) {
        float f = x - this.mCenterX;
        float f4 = y2 - this.mCenterY;
        float fSqrt = (float) Math.sqrt((f4 * f4) + (f * f));
        float radius = this.mDrawArcInfo.getRadius();
        Paint paint = this.mPaint;
        Intrinsics.checkNotNull(paint);
        float strokeWidth = (paint.getStrokeWidth() / 2.0f) + radius;
        Paint paint2 = this.mPaint;
        Intrinsics.checkNotNull(paint2);
        if (fSqrt < strokeWidth - paint2.getStrokeWidth() || fSqrt > strokeWidth) {
            return false;
        }
        float degrees = (float) Math.toDegrees(Math.atan2(f4, f));
        Paint paint3 = this.mPaint;
        Intrinsics.checkNotNull(paint3);
        double strokeWidth2 = (((double) paint3.getStrokeWidth()) / (((double) this.mDrawArcInfo.getRadius()) * 3.141592653589793d)) * ((double) 180);
        if (degrees < 0.0f) {
            degrees += 360.0f;
        }
        float startAngle = this.mDrawArcInfo.getStartAngle();
        float f5 = PopOverActivityWrapper.DEFAULT_WIDTH;
        double d = ((double) (((startAngle % f5) + f5) % f5)) - (strokeWidth2 / ((double) 2));
        double sweepAngle = ((((double) this.mDrawArcInfo.getSweepAngle()) + d) % ((double) PopOverActivityWrapper.DEFAULT_WIDTH)) + strokeWidth2;
        if (this.mDrawArcInfo.getSweepAngle() >= 0.0f) {
            if (d < sweepAngle) {
                double d2 = degrees;
                return d <= d2 && d2 <= sweepAngle;
            }
            double d3 = degrees;
            return d3 >= d || d3 <= sweepAngle;
        }
        if (sweepAngle < d) {
            double d4 = degrees;
            return sweepAngle <= d4 && d4 <= d;
        }
        double d5 = degrees;
        return d5 >= sweepAngle || d5 <= d;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setAlpha(alpha);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setColorFilter(colorFilter);
        }
    }

    public final void setDrawInfo(@NotNull DrawArcInfo drawArcInfo) {
        Intrinsics.checkNotNullParameter(drawArcInfo, "drawArcInfo");
        this.mDrawArcInfo.setInfo(drawArcInfo.getWidth(), drawArcInfo.getHeight(), drawArcInfo.getRadius(), drawArcInfo.getStrokeWidth(), drawArcInfo.getStartAngle(), drawArcInfo.getSweepAngle());
        this.mCenterX = drawArcInfo.getWidth() / 2.0f;
        this.mCenterY = drawArcInfo.getHeight() / 2.0f;
        updatePaint(this.color);
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setStrokeWidth(drawArcInfo.getStrokeWidth());
        }
        invalidateSelf();
    }

    public final void updatePaint(@Nullable int[] color) {
        if (color != null) {
            this.color = color;
            float f = this.startAngle;
            float[] fArr = {f / 360.0f, (f + this.sweepAngle) / 360.0f};
            float width = this.mDrawArcInfo.getWidth() * 0.5f;
            float height = this.mDrawArcInfo.getHeight() * 0.5f;
            SweepGradient sweepGradient = new SweepGradient(width, height, color, fArr);
            Matrix matrix = new Matrix();
            matrix.setRotate(-((float) (((((double) this.mDrawArcInfo.getStrokeWidth()) * 0.5d) / (((double) (this.mDrawArcInfo.getRadius() * 2)) * 3.141592653589793d)) * ((double) PopOverActivityWrapper.DEFAULT_WIDTH))), width, height);
            sweepGradient.setLocalMatrix(matrix);
            Paint paint = this.mPaint;
            if (paint != null) {
                paint.setShader(sweepGradient);
            }
            invalidateSelf();
        }
    }
}
