package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.controller.image;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002$%B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0007H\u0007J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0007H\u0003J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\tH\u0003J\b\u0010\u001b\u001a\u00020\u0010H\u0003J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0003J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0003J\u0018\u0010!\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#H\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/controller/image/ConnerCutEffect;", "", "<init>", "()V", "DEBUG", "", "padding", "", "clipLen", "", "defaultSize", "gradientPosDelta", "shadowLineDelta", "curveDelta", "cutLineDelta", "applyEffect", "Landroid/graphics/Bitmap;", "src", "size", "drawSrc", "", "canvas", "Landroid/graphics/Canvas;", "makeConnerClipPath", "Landroid/graphics/Path;", "width", "height", "makeEffectBitmap", "drawEffect", "makeShadowPaint", "Landroid/graphics/Paint;", "line", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/controller/image/ConnerCutEffect$LinePos;", "drawRectLine", "rect", "Landroid/graphics/RectF;", "LinePos", "LineEquation", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nConnerCutEffect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnerCutEffect.kt\ncom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/controller/image/ConnerCutEffect\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,187:1\n1#2:188\n*E\n"})
public final class ConnerCutEffect {
    private static final boolean DEBUG = false;

    @NotNull
    public static final ConnerCutEffect INSTANCE = new ConnerCutEffect();
    private static final int padding = 50;
    private static final float clipLen = 200.0f;
    private static final float defaultSize = 788.0f;
    private static final float gradientPosDelta = 10.0f;
    private static final float shadowLineDelta = 15.0f;
    private static final float curveDelta = 10.0f;
    private static final float cutLineDelta = 10.0f;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/controller/image/ConnerCutEffect$LinePos;", "", "x1", "", "y1", "x2", "y2", "<init>", "(FFFF)V", "getX1", "()F", "setX1", "(F)V", "getY1", "setY1", "getX2", "setX2", "getY2", "setY2", "drawLine", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class LinePos {
        private float x1;
        private float x2;
        private float y1;
        private float y2;

        public LinePos() {
            this(0.0f, 0.0f, 0.0f, 0.0f, 15, null);
        }

        public final void drawLine(@NotNull Canvas canvas, @NotNull Paint paint) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(paint, "paint");
            canvas.drawLine(this.x1, this.y1, this.x2, this.y2, paint);
        }

        public final float getX1() {
            return this.x1;
        }

        public final float getX2() {
            return this.x2;
        }

        public final float getY1() {
            return this.y1;
        }

        public final float getY2() {
            return this.y2;
        }

        public final void setX1(float f) {
            this.x1 = f;
        }

        public final void setX2(float f) {
            this.x2 = f;
        }

        public final void setY1(float f) {
            this.y1 = f;
        }

        public final void setY2(float f) {
            this.y2 = f;
        }

        public LinePos(float f, float f4, float f5, float f6) {
            this.x1 = f;
            this.y1 = f4;
            this.x2 = f5;
            this.y2 = f6;
        }

        public /* synthetic */ LinePos(float f, float f4, float f5, float f6, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 0.0f : f, (i & 2) != 0 ? 0.0f : f4, (i & 4) != 0 ? 0.0f : f5, (i & 8) != 0 ? 0.0f : f6);
        }
    }

    private ConnerCutEffect() {
    }

    @JvmStatic
    @NotNull
    public static final Bitmap applyEffect(@NotNull Bitmap src, int size) {
        Intrinsics.checkNotNullParameter(src, "src");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        Canvas canvasM4740a = AbstractC6670b.m4740a(bitmapCreateBitmap, "createBitmap(...)", bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        float f = size;
        canvasM4740a.clipPath(makeConnerClipPath(f, f));
        drawSrc(canvasM4740a, src, size);
        Bitmap bitmapMakeEffectBitmap = makeEffectBitmap();
        canvasM4740a.drawBitmap(bitmapMakeEffectBitmap, 0.0f, 0.0f, paint);
        canvasM4740a.save();
        canvasM4740a.rotate(180.0f, canvasM4740a.getWidth() / 2.0f, canvasM4740a.getHeight() / 2.0f);
        canvasM4740a.drawBitmap(bitmapMakeEffectBitmap, 0.0f, 0.0f, paint);
        canvasM4740a.restore();
        bitmapMakeEffectBitmap.recycle();
        if (DEBUG) {
            int i = padding;
            drawRectLine(canvasM4740a, new RectF(i, i, canvasM4740a.getWidth() - i, canvasM4740a.getWidth() - i));
        }
        return bitmapCreateBitmap;
    }

    @JvmStatic
    private static final void drawEffect(Canvas canvas) {
        float f = clipLen;
        canvas.saveLayer(new RectF(0.0f, 0.0f, f, f), null);
        float f4 = (f / 2.0f) - gradientPosDelta;
        int i = padding;
        float f5 = (i / 2.0f) + f4;
        LinePos linePos = new LinePos(f4, f4, f5, f5);
        Paint paintMakeShadowPaint = makeShadowPaint(linePos);
        LineEquation lineEquation = new LineEquation();
        lineEquation.init(0.0f, f, f, 0.0f);
        LineEquation lineEquation2 = new LineEquation();
        lineEquation2.init(lineEquation.getSlope(), lineEquation.getIntercept());
        lineEquation2.moveX(shadowLineDelta);
        Path path = new Path();
        float f6 = curveDelta;
        float f7 = i - f6;
        float f8 = i - f6;
        float f9 = ((i / 2.0f) + (f / 2.0f)) - f6;
        path.moveTo(lineEquation2.getX(f7), f7);
        path.quadTo(f9, f9, f8, lineEquation2.getY(f8));
        path.close();
        canvas.drawPath(path, paintMakeShadowPaint);
        canvas.restore();
        paintMakeShadowPaint.clearShadowLayer();
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#25999999"));
        float f10 = cutLineDelta;
        paint.setStrokeWidth(f10);
        float f11 = i - f10;
        new LinePos(lineEquation.getX(f11), f11, f11, lineEquation.getY(f11)).drawLine(canvas, paint);
        if (DEBUG) {
            drawRectLine(canvas, new RectF(0.0f, 0.0f, f, f));
            linePos.drawLine(canvas, new Paint(-65536));
            new LinePos(lineEquation2.getX(0.0f), 0.0f, 0.0f, lineEquation2.getY(0.0f)).drawLine(canvas, new Paint(-65536));
            new LinePos(f, 0.0f, 0.0f, f).drawLine(canvas, new Paint(-65536));
        }
    }

    @JvmStatic
    private static final void drawRectLine(Canvas canvas, RectF rect) {
        Paint paint = new Paint(-16776961);
        float f = rect.left;
        float f4 = rect.top;
        canvas.drawLine(f, f4, rect.right, f4, paint);
        float f5 = rect.right;
        canvas.drawLine(f5, rect.top, f5, rect.bottom, paint);
        float f6 = rect.right;
        float f7 = rect.bottom;
        canvas.drawLine(f6, f7, rect.left, f7, paint);
        float f8 = rect.left;
        canvas.drawLine(f8, rect.bottom, f8, rect.top, paint);
    }

    @JvmStatic
    private static final void drawSrc(Canvas canvas, Bitmap src, int size) {
        int i = padding;
        canvas.drawBitmap(src, new Rect(0, 0, src.getWidth(), src.getHeight()), new Rect(i, i, size - i, size - i), new Paint());
    }

    @JvmStatic
    private static final Path makeConnerClipPath(float width, float height) {
        Path path = new Path();
        float f = clipLen;
        path.moveTo(f, 0.0f);
        path.lineTo(width, 0.0f);
        path.lineTo(width, height - f);
        path.lineTo(width - f, height);
        path.lineTo(0.0f, height);
        path.lineTo(0.0f, f);
        path.lineTo(f, 0.0f);
        path.close();
        return path;
    }

    @JvmStatic
    private static final Bitmap makeEffectBitmap() {
        float f = clipLen;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) f, (int) f, Bitmap.Config.ARGB_8888);
        Canvas canvasM4740a = AbstractC6670b.m4740a(bitmapCreateBitmap, "createBitmap(...)", bitmapCreateBitmap);
        Path path = new Path();
        path.moveTo(canvasM4740a.getWidth(), 0.0f);
        path.lineTo(canvasM4740a.getWidth(), canvasM4740a.getHeight());
        path.lineTo(0.0f, canvasM4740a.getHeight());
        path.close();
        canvasM4740a.clipPath(path);
        drawEffect(canvasM4740a);
        return bitmapCreateBitmap;
    }

    @JvmStatic
    private static final Paint makeShadowPaint(LinePos line) {
        Paint paint = new Paint();
        paint.setShadowLayer(10.0f, 10.0f, 10.0f, -16777216);
        paint.setShader(new LinearGradient(line.getX1(), line.getY1(), line.getX2(), line.getY2(), new int[]{Color.parseColor("#55000000"), Color.parseColor("#00eeeeee")}, (float[]) null, Shader.TileMode.CLAMP));
        return paint;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/template/dynamic/controller/image/ConnerCutEffect$LineEquation;", "", "<init>", "()V", "slope", "", "getSlope", "()F", "setSlope", "(F)V", "intercept", "getIntercept", "setIntercept", "init", "", "x1", "y1", "x2", "y2", "getX", "y", "getY", "x", "moveX", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class LineEquation {
        private float intercept;
        private float slope;

        public final float getIntercept() {
            return this.intercept;
        }

        public final float getSlope() {
            return this.slope;
        }

        public final float getX(float y2) {
            return (y2 - this.intercept) / this.slope;
        }

        public final float getY(float x) {
            return (this.slope * x) + this.intercept;
        }

        public final void init(float x12, float y1, float x2, float y2) {
            float f = (y2 - y1) / (x2 - x12);
            this.slope = f;
            this.intercept = y1 - (f * x12);
        }

        public final void moveX(float x) {
            this.intercept = (this.slope * x) + this.intercept;
        }

        public final void setIntercept(float f) {
            this.intercept = f;
        }

        public final void setSlope(float f) {
            this.slope = f;
        }

        public final void init(float slope, float intercept) {
            this.slope = slope;
            this.intercept = intercept;
        }
    }
}
