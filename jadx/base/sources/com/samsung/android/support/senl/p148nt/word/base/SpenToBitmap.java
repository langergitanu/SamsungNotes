package com.samsung.android.support.senl.p148nt.word.base;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.document.SpenObjectLine;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenPath;
import com.samsung.android.sdk.pen.document.shapeeffect.SpenFillColorEffect;
import com.samsung.android.sdk.pen.document.shapeeffect.SpenLineColorEffect;
import com.samsung.android.sdk.pen.document.shapeeffect.SpenLineStyleEffect;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001(B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J8\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0017H\u0002J \u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u0017H\u0002J3\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001f0&2\u0006\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u0017H\u0002¢\u0006\u0002\u0010'R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/base/SpenToBitmap;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "drawShape", "Landroid/graphics/Bitmap;", VMetaDataKey.META_KEY_SHAPE, "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "drawLine", "line", "Lcom/samsung/android/sdk/pen/document/SpenObjectLine;", "createDrawableAttributes", "Lcom/samsung/android/support/senl/nt/word/base/SpenToBitmap$DrawingAttributesData;", "rectF", "Landroid/graphics/RectF;", "drawArrowHead", "", "canvas", "Landroid/graphics/Canvas;", "x", "", "y", "color", "", "strokeWidth", "rotate", "convertSegment", "segment", "Lcom/samsung/android/sdk/pen/document/SpenPath$Segment;", "top", "left", "segmentToPath", "Landroid/graphics/Path;", "path", "segments", "", "(Landroid/graphics/Path;[Lcom/samsung/android/sdk/pen/document/SpenPath$Segment;FF)Landroid/graphics/Path;", "DrawingAttributesData", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SpenToBitmap {

    @NotNull
    public static final SpenToBitmap INSTANCE = new SpenToBitmap();
    private static final String TAG = Logger.createTag("SpenToBitmap");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/word/base/SpenToBitmap$DrawingAttributesData;", "", "bitmap", "Landroid/graphics/Bitmap;", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "top", "", "left", "<init>", "(Landroid/graphics/Bitmap;Landroid/graphics/Canvas;Landroid/graphics/Paint;FF)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getCanvas", "()Landroid/graphics/Canvas;", "getPaint", "()Landroid/graphics/Paint;", "getTop", "()F", "getLeft", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ntWord_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final /* data */ class DrawingAttributesData {

        @NotNull
        private final Bitmap bitmap;

        @NotNull
        private final Canvas canvas;
        private final float left;

        @NotNull
        private final Paint paint;
        private final float top;

        public DrawingAttributesData(@NotNull Bitmap bitmap, @NotNull Canvas canvas, @NotNull Paint paint, float f, float f4) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(paint, "paint");
            this.bitmap = bitmap;
            this.canvas = canvas;
            this.paint = paint;
            this.top = f;
            this.left = f4;
        }

        public static /* synthetic */ DrawingAttributesData copy$default(DrawingAttributesData drawingAttributesData, Bitmap bitmap, Canvas canvas, Paint paint, float f, float f4, int i, Object obj) {
            if ((i & 1) != 0) {
                bitmap = drawingAttributesData.bitmap;
            }
            if ((i & 2) != 0) {
                canvas = drawingAttributesData.canvas;
            }
            if ((i & 4) != 0) {
                paint = drawingAttributesData.paint;
            }
            if ((i & 8) != 0) {
                f = drawingAttributesData.top;
            }
            if ((i & 16) != 0) {
                f4 = drawingAttributesData.left;
            }
            float f5 = f4;
            Paint paint2 = paint;
            return drawingAttributesData.copy(bitmap, canvas, paint2, f, f5);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Canvas getCanvas() {
            return this.canvas;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Paint getPaint() {
            return this.paint;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final float getTop() {
            return this.top;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final float getLeft() {
            return this.left;
        }

        @NotNull
        public final DrawingAttributesData copy(@NotNull Bitmap bitmap, @NotNull Canvas canvas, @NotNull Paint paint, float top, float left) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(paint, "paint");
            return new DrawingAttributesData(bitmap, canvas, paint, top, left);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DrawingAttributesData)) {
                return false;
            }
            DrawingAttributesData drawingAttributesData = (DrawingAttributesData) other;
            return Intrinsics.areEqual(this.bitmap, drawingAttributesData.bitmap) && Intrinsics.areEqual(this.canvas, drawingAttributesData.canvas) && Intrinsics.areEqual(this.paint, drawingAttributesData.paint) && Float.compare(this.top, drawingAttributesData.top) == 0 && Float.compare(this.left, drawingAttributesData.left) == 0;
        }

        @NotNull
        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        @NotNull
        public final Canvas getCanvas() {
            return this.canvas;
        }

        public final float getLeft() {
            return this.left;
        }

        @NotNull
        public final Paint getPaint() {
            return this.paint;
        }

        public final float getTop() {
            return this.top;
        }

        public int hashCode() {
            return Float.hashCode(this.left) + AbstractC0622a.m1156b(this.top, (this.paint.hashCode() + ((this.canvas.hashCode() + (this.bitmap.hashCode() * 31)) * 31)) * 31, 31);
        }

        @NotNull
        public String toString() {
            Bitmap bitmap = this.bitmap;
            Canvas canvas = this.canvas;
            Paint paint = this.paint;
            float f = this.top;
            float f4 = this.left;
            StringBuilder sb = new StringBuilder("DrawingAttributesData(bitmap=");
            sb.append(bitmap);
            sb.append(", canvas=");
            sb.append(canvas);
            sb.append(", paint=");
            sb.append(paint);
            sb.append(", top=");
            sb.append(f);
            sb.append(", left=");
            return AbstractC1038a.m1217r(sb, ")", f4);
        }
    }

    private SpenToBitmap() {
    }

    private final void convertSegment(SpenPath.Segment segment, float top, float left) {
        segment.x -= left;
        segment.y -= top;
        segment.x1 -= left;
        segment.y1 -= top;
        segment.x2 -= left;
        segment.y2 -= top;
    }

    private final DrawingAttributesData createDrawableAttributes(RectF rectF) {
        float f = rectF.top;
        float f4 = rectF.left;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) (rectF.right - f4), (int) (rectF.bottom - f), Bitmap.Config.ARGB_8888);
        Canvas canvasM4740a = AbstractC6670b.m4740a(bitmapCreateBitmap, "createBitmap(...)", bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(0);
        canvasM4740a.drawPaint(paint);
        return new DrawingAttributesData(bitmapCreateBitmap, canvasM4740a, paint, f, f4);
    }

    private final void drawArrowHead(Canvas canvas, float x, float y2, int color, float strokeWidth, float rotate) {
        canvas.save();
        canvas.rotate(rotate, x, y2);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(strokeWidth);
        paint.setColor(color);
        Path path = new Path();
        path.moveTo(x, y2);
        float f = 5;
        float f4 = y2 + 10;
        path.lineTo(x + f, f4);
        path.lineTo(x - f, f4);
        path.close();
        canvas.drawPath(path, paint);
        canvas.restore();
    }

    private final Path segmentToPath(Path path, SpenPath.Segment[] segments, float top, float left) {
        RectF rectF = new RectF();
        for (SpenPath.Segment segment : segments) {
            convertSegment(segment, top, left);
            switch (segment.type) {
                case 1:
                    path.moveTo(segment.x, segment.y);
                    break;
                case 2:
                    path.lineTo(segment.x, segment.y);
                    break;
                case 3:
                    path.quadTo(segment.x, segment.y, segment.x2, segment.y2);
                    break;
                case 4:
                    path.cubicTo(segment.x, segment.y, segment.x1, segment.y1, segment.x2, segment.y2);
                    break;
                case 5:
                    rectF.set(segment.x, segment.y, segment.x1, segment.y1);
                    path.arcTo(rectF, segment.x2, segment.y2, true);
                    break;
                case 6:
                    path.close();
                    break;
                case 7:
                    rectF.set(segment.x, segment.y, segment.x1, segment.y1);
                    path.addOval(rectF, Path.Direction.CW);
                    break;
            }
        }
        return path;
    }

    @Nullable
    public final Bitmap drawLine(@NotNull SpenObjectLine line) {
        Canvas canvas;
        double d;
        Intrinsics.checkNotNullParameter(line, "line");
        RectF drawnRect = line.getDrawnRect();
        if (drawnRect == null) {
            Logger.m10999d(TAG, "drawLine() rectF is null");
            return null;
        }
        DrawingAttributesData drawingAttributesDataCreateDrawableAttributes = createDrawableAttributes(drawnRect);
        Bitmap bitmap = drawingAttributesDataCreateDrawableAttributes.getBitmap();
        Canvas canvas2 = drawingAttributesDataCreateDrawableAttributes.getCanvas();
        Paint paint = drawingAttributesDataCreateDrawableAttributes.getPaint();
        Path path = new Path();
        SpenPath.Segment[] segment = line.getPath().getSegment();
        segmentToPath(path, segment, drawingAttributesDataCreateDrawableAttributes.getTop(), drawingAttributesDataCreateDrawableAttributes.getLeft());
        SpenLineColorEffect spenLineColorEffect = new SpenLineColorEffect();
        SpenLineStyleEffect spenLineStyleEffect = new SpenLineStyleEffect();
        line.getLineColorEffect(spenLineColorEffect);
        line.getLineStyleEffect(spenLineStyleEffect);
        paint.setStrokeWidth(spenLineStyleEffect.getWidth());
        paint.setPathEffect(null);
        paint.setColor(spenLineColorEffect.getSolidColor());
        paint.setStyle(Paint.Style.STROKE);
        canvas2.drawPath(path, paint);
        if (spenLineStyleEffect.getBeginArrowType() != 0) {
            SpenPath.Segment segment2 = segment[0];
            float f = segment2.x;
            float f4 = segment2.y;
            float f5 = segment[1].x;
            d = 6.283185307179586d;
            float fAtan = (float) ((Math.atan((r1.y - f4) / (f5 - f)) * ((double) PopOverActivityWrapper.DEFAULT_WIDTH)) / 6.283185307179586d);
            canvas = canvas2;
            drawArrowHead(canvas, f, f4, spenLineColorEffect.getSolidColor(), spenLineStyleEffect.getWidth(), (fAtan - 90) + (f > f5 ? 180 : 0));
        } else {
            canvas = canvas2;
            d = 6.283185307179586d;
        }
        if (spenLineStyleEffect.getEndArrowType() != 0) {
            float f6 = segment[segment.length - 2].x;
            float f7 = segment[segment.length - 2].y;
            float f8 = segment[segment.length - 1].x;
            drawArrowHead(canvas, f8, segment[segment.length - 1].y, spenLineColorEffect.getSolidColor(), spenLineStyleEffect.getWidth(), ((float) ((Math.atan((r4 - f7) / (f8 - f6)) * ((double) PopOverActivityWrapper.DEFAULT_WIDTH)) / d)) + 90 + (f6 > f8 ? 180 : 0));
        }
        return bitmap;
    }

    @Nullable
    public final Bitmap drawShape(@NotNull SpenObjectShape shape) {
        Intrinsics.checkNotNullParameter(shape, "shape");
        RectF drawnRect = shape.getDrawnRect();
        if (drawnRect == null) {
            Logger.m10999d(TAG, "drawShape() rect shape is null");
            return null;
        }
        DrawingAttributesData drawingAttributesDataCreateDrawableAttributes = createDrawableAttributes(drawnRect);
        Bitmap bitmap = drawingAttributesDataCreateDrawableAttributes.getBitmap();
        Canvas canvas = drawingAttributesDataCreateDrawableAttributes.getCanvas();
        Paint paint = drawingAttributesDataCreateDrawableAttributes.getPaint();
        Path path = new Path();
        SpenPath spenPath = new SpenPath();
        shape.getPath(spenPath);
        segmentToPath(path, spenPath.getSegment(), drawingAttributesDataCreateDrawableAttributes.getTop(), drawingAttributesDataCreateDrawableAttributes.getLeft());
        SpenLineColorEffect spenLineColorEffect = new SpenLineColorEffect();
        SpenLineStyleEffect spenLineStyleEffect = new SpenLineStyleEffect();
        shape.getLineColorEffect(spenLineColorEffect);
        shape.getLineStyleEffect(spenLineStyleEffect);
        paint.setStrokeWidth(spenLineStyleEffect.getWidth());
        paint.setPathEffect(null);
        paint.setColor(spenLineColorEffect.getSolidColor());
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path, paint);
        SpenFillColorEffect spenFillColorEffect = new SpenFillColorEffect();
        shape.getFillEffect(spenFillColorEffect);
        paint.setStyle(Paint.Style.FILL);
        paint.setPathEffect(null);
        paint.setColor(spenFillColorEffect.getSolidColor());
        canvas.drawPath(path, paint);
        return bitmap;
    }
}
