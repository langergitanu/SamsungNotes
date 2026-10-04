package androidx.compose.p109ui.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.graphics.PointMode;
import androidx.compose.p109ui.unit.IntOffset;
import androidx.compose.p109ui.unit.IntSize;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J:\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0013H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 H\u0016ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\b\u0010#\u001a\u00020\u000fH\u0016JH\u0010$\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J*\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0004\b/\u00100J*\u00101\u001a\u00020\u000f2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020-2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0004\b5\u00106JB\u00107\u001a\u00020\u000f2\u0006\u00102\u001a\u0002032\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u0002092\u0006\u0010=\u001a\u00020;2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0004\b>\u0010?J*\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020-2\u0006\u0010B\u001a\u00020-2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0004\bC\u0010DJ&\u0010E\u001a\u00020\u000f2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020-0G2\u0006\u0010)\u001a\u00020*2\u0006\u0010H\u001a\u00020IH\u0002J0\u0010J\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*H\u0016J\u0018\u0010K\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010)\u001a\u00020*H\u0016J0\u0010L\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020N2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020-0G2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0004\bO\u0010PJ\u001e\u0010L\u001a\u00020\u000f2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020-0G2\u0006\u0010)\u001a\u00020*H\u0002J \u0010Q\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020R2\u0006\u0010)\u001a\u00020*2\u0006\u0010H\u001a\u00020IH\u0002J*\u0010S\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020N2\u0006\u0010F\u001a\u00020R2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0004\bT\u0010UJ \u0010S\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020R2\u0006\u0010)\u001a\u00020*2\u0006\u0010H\u001a\u00020IH\u0002J0\u0010V\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*H\u0016J@\u0010W\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010X\u001a\u00020\u00182\u0006\u0010Y\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*H\u0016J*\u0010Z\u001a\u00020\u000f2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0004\b_\u0010`J\b\u0010a\u001a\u00020\u000fH\u0016J\b\u0010b\u001a\u00020\u000fH\u0016J\u0010\u0010c\u001a\u00020\u000f2\u0006\u0010d\u001a\u00020\u0018H\u0016J\b\u0010e\u001a\u00020\u000fH\u0016J\u0018\u0010f\u001a\u00020\u000f2\u0006\u0010g\u001a\u00020h2\u0006\u0010)\u001a\u00020*H\u0016J\u0018\u0010i\u001a\u00020\u000f2\u0006\u0010j\u001a\u00020\u00182\u0006\u0010k\u001a\u00020\u0018H\u0016J\u0018\u0010l\u001a\u00020\u000f2\u0006\u0010j\u001a\u00020\u00182\u0006\u0010k\u001a\u00020\u0018H\u0016J\u0018\u0010m\u001a\u00020\u000f2\u0006\u0010n\u001a\u00020\u00182\u0006\u0010o\u001a\u00020\u0018H\u0016J\u0014\u0010p\u001a\u00020q*\u00020\u0013ø\u0001\u0000¢\u0006\u0004\br\u0010sR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0005\u001a\u00060\u0006j\u0002`\u00078\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006t"}, m13886d2 = {"Landroidx/compose/ui/graphics/AndroidCanvas;", "Landroidx/compose/ui/graphics/Canvas;", "()V", "dstRect", "Landroid/graphics/Rect;", "internalCanvas", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/graphics/NativeCanvas;", "getInternalCanvas$annotations", "getInternalCanvas", "()Landroid/graphics/Canvas;", "setInternalCanvas", "(Landroid/graphics/Canvas;)V", "srcRect", "clipPath", "", "path", "Landroidx/compose/ui/graphics/Path;", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "clipPath-mtrdD-E", "(Landroidx/compose/ui/graphics/Path;I)V", "clipRect", "left", "", "top", "right", "bottom", "clipRect-N_I0leg", "(FFFFI)V", "concat", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "concat-58bKbWc", "([F)V", "disableZ", "drawArc", "startAngle", "sweepAngle", "useCenter", "", "paint", "Landroidx/compose/ui/graphics/Paint;", "drawCircle", "center", "Landroidx/compose/ui/geometry/Offset;", "radius", "drawCircle-9KIMszo", "(JFLandroidx/compose/ui/graphics/Paint;)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "topLeftOffset", "drawImage-d-4ec7I", "(Landroidx/compose/ui/graphics/ImageBitmap;JLandroidx/compose/ui/graphics/Paint;)V", "drawImageRect", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImageRect-HPBpro0", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJLandroidx/compose/ui/graphics/Paint;)V", "drawLine", "p1", "p2", "drawLine-Wko1d7g", "(JJLandroidx/compose/ui/graphics/Paint;)V", "drawLines", "points", "", "stepBy", "", "drawOval", "drawPath", "drawPoints", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-O7TthRY", "(ILjava/util/List;Landroidx/compose/ui/graphics/Paint;)V", "drawRawLines", "", "drawRawPoints", "drawRawPoints-O7TthRY", "(I[FLandroidx/compose/ui/graphics/Paint;)V", "drawRect", "drawRoundRect", "radiusX", "radiusY", "drawVertices", "vertices", "Landroidx/compose/ui/graphics/Vertices;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawVertices-TPEHhCM", "(Landroidx/compose/ui/graphics/Vertices;ILandroidx/compose/ui/graphics/Paint;)V", "enableZ", "restore", "rotate", "degrees", "save", "saveLayer", "bounds", "Landroidx/compose/ui/geometry/Rect;", WiggleAnimationConfig.KEY_SCALE, "sx", "sy", "skew", "translate", "dx", "dy", "toRegionOp", "Landroid/graphics/Region$Op;", "toRegionOp--7u2Bmg", "(I)Landroid/graphics/Region$Op;", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@PublishedApi
@SourceDebugExtension({"SMAP\nAndroidCanvas.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidCanvas.android.kt\nandroidx/compose/ui/graphics/AndroidCanvas\n+ 2 AndroidPath.android.kt\nandroidx/compose/ui/graphics/AndroidPath_androidKt\n+ 3 ListUtils.kt\nandroidx/compose/ui/util/ListUtilsKt\n*L\n1#1,435:1\n38#2,5:436\n38#2,5:441\n33#3,6:446\n*S KotlinDebug\n*F\n+ 1 AndroidCanvas.android.kt\nandroidx/compose/ui/graphics/AndroidCanvas\n*L\n154#1:436,5\n242#1:441,5\n319#1:446,6\n*E\n"})
public final class AndroidCanvas implements Canvas {

    @Nullable
    private Rect dstRect;

    @NotNull
    private Canvas internalCanvas = AndroidCanvas_androidKt.EmptyCanvas;

    @Nullable
    private Rect srcRect;

    private final void drawLines(List<Offset> points, Paint paint, int stepBy) {
        if (points.size() >= 2) {
            Paint paintAsFrameworkPaint = paint.getInternalPaint();
            int i = 0;
            while (i < points.size() - 1) {
                long packedValue = points.get(i).getPackedValue();
                long packedValue2 = points.get(i + 1).getPackedValue();
                this.internalCanvas.drawLine(Offset.m18284getXimpl(packedValue), Offset.m18285getYimpl(packedValue), Offset.m18284getXimpl(packedValue2), Offset.m18285getYimpl(packedValue2), paintAsFrameworkPaint);
                i += stepBy;
            }
        }
    }

    private final void drawPoints(List<Offset> points, Paint paint) {
        int size = points.size();
        for (int i = 0; i < size; i++) {
            long packedValue = points.get(i).getPackedValue();
            this.internalCanvas.drawPoint(Offset.m18284getXimpl(packedValue), Offset.m18285getYimpl(packedValue), paint.getInternalPaint());
        }
    }

    private final void drawRawLines(float[] points, Paint paint, int stepBy) {
        if (points.length < 4 || points.length % 2 != 0) {
            return;
        }
        Paint paintAsFrameworkPaint = paint.getInternalPaint();
        int i = 0;
        while (i < points.length - 3) {
            this.internalCanvas.drawLine(points[i], points[i + 1], points[i + 2], points[i + 3], paintAsFrameworkPaint);
            i += stepBy * 2;
        }
    }

    private final void drawRawPoints(float[] points, Paint paint, int stepBy) {
        if (points.length % 2 == 0) {
            Paint paintAsFrameworkPaint = paint.getInternalPaint();
            int i = 0;
            while (i < points.length - 1) {
                this.internalCanvas.drawPoint(points[i], points[i + 1], paintAsFrameworkPaint);
                i += stepBy;
            }
        }
    }

    @Override // androidx.compose.p109ui.graphics.Canvas
    /* JADX INFO: renamed from: clipPath-mtrdD-E, reason: not valid java name */
    public void mo18378clipPathmtrdDE(@NotNull Path path, int clipOp) {
        Canvas canvas = this.internalCanvas;
        if (!(path instanceof AndroidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        canvas.clipPath(((AndroidPath) path).getInternalPath(), m18388toRegionOp7u2Bmg(clipOp));
    }

    @Override // androidx.compose.p109ui.graphics.Canvas
    /* JADX INFO: renamed from: clipRect-N_I0leg, reason: not valid java name */
    public void mo18379clipRectN_I0leg(float left, float top, float right, float bottom, int clipOp) {
        this.internalCanvas.clipRect(left, top, right, bottom, m18388toRegionOp7u2Bmg(clipOp));
    }

    @Override // androidx.compose.p109ui.graphics.Canvas
    /* JADX INFO: renamed from: concat-58bKbWc, reason: not valid java name */
    public void mo18380concat58bKbWc(@NotNull float[] matrix) {
        if (MatrixKt.m18780isIdentity58bKbWc(matrix)) {
            return;
        }
        Matrix matrix2 = new Matrix();
        AndroidMatrixConversions_androidKt.m18395setFromEL8BTi8(matrix2, matrix);
        this.internalCanvas.concat(matrix2);
    }

    @Override // androidx.compose.p109ui.graphics.Canvas
    public void disableZ() {
        CanvasUtils.INSTANCE.enableZ(this.internalCanvas, false);
    }

    @Override // androidx.compose.p109ui.graphics.Canvas
    public void drawArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean useCenter, @NotNull Paint paint) {
        this.internalCanvas.drawArc(left, top, right, bottom, startAngle, sweepAngle, useCenter, paint.getInternalPaint());
    }

    @Override // androidx.compose.p109ui.graphics.Canvas
    /* JADX INFO: renamed from: drawCircle-9KIMszo, reason: not valid java name */
    public void mo18381drawCircle9KIMszo(long center, float radius, @NotNull Paint paint) {
        this.internalCanvas.drawCircle(Offset.m18284getXimpl(center), Offset.m18285getYimpl(center), radius, paint.getInternalPaint());
    }

    @Override // androidx.compose.p109ui.graphics.Canvas
    /* JADX INFO: renamed from: drawImage-d-4ec7I, reason: not valid java name */
    public void mo18382drawImaged4ec7I(@NotNull ImageBitmap image, long topLeftOffset, @NotNull Paint paint) {
        this.internalCanvas.drawBitmap(AndroidImageBitmap_androidKt.asAndroidBitmap(image), Offset.m18284getXimpl(topLeftOffset), Offset.m18285getYimpl(topLeftOffset), paint.getInternalPaint());
    }

    @Override // androidx.compose.p109ui.graphics.Canvas
    /* JADX INFO: renamed from: drawImageRect-HPBpro0, reason: not valid java name */
    public void mo18383drawImageRectHPBpro0(@NotNull ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, @NotNull Paint paint) {
        if (this.srcRect == null) {
            this.srcRect = new Rect();
            this.dstRect = new Rect();
        }
        Canvas canvas = this.internalCanvas;
        Bitmap bitmapAsAndroidBitmap = AndroidImageBitmap_androidKt.asAndroidBitmap(image);
        Rect rect = this.srcRect;
        Intrinsics.checkNotNull(rect);
        rect.left = IntOffset.m21096getXimpl(srcOffset);
        rect.top = IntOffset.m21097getYimpl(srcOffset);
        rect.right = IntSize.m21138getWidthimpl(srcSize) + IntOffset.m21096getXimpl(srcOffset);
        rect.bottom = IntSize.m21137getHeightimpl(srcSize) + IntOffset.m21097getYimpl(srcOffset);
        Unit unit = Unit.INSTANCE;
        Rect rect2 = this.dstRect;
        Intrinsics.checkNotNull(rect2);
        rect2.left = IntOffset.m21096getXimpl(dstOffset);
        rect2.top = IntOffset.m21097getYimpl(dstOffset);
        rect2.right = IntSize.m21138getWidthimpl(dstSize) + IntOffset.m21096getXimpl(dstOffset);
        rect2.bottom = IntSize.m21137getHeightimpl(dstSize) + IntOffset.m21097getYimpl(dstOffset);
        canvas.drawBitmap(bitmapAsAndroidBitmap, rect, rect2, paint.getInternalPaint());
    }

    @Override // androidx.compose.p109ui.graphics.Canvas
    /* JADX INFO: renamed from: drawLine-Wko1d7g, reason: not valid java name */
    public void mo18384drawLineWko1d7g(long p1, long p2, @NotNull Paint paint) {
        this.internalCanvas.drawLine(Offset.m18284getXimpl(p1), Offset.m18285getYimpl(p1), Offset.m18284getXimpl(p2), Offset.m18285getYimpl(p2), paint.getInternalPaint());
    }

    @Override // androidx.compose.p109ui.graphics.Canvas
    public void drawOval(float left, float top, float right, float bottom, @NotNull Paint paint) {
        this.internalCanvas.drawOval(left, top, right, bottom, paint.getInternalPaint());
    }

    @Override // androidx.compose.p109ui.graphics.Canvas
    public void drawPath(@NotNull Path path, @NotNull Paint paint) {
        Canvas canvas = this.internalCanvas;
        if (!(path instanceof AndroidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        canvas.drawPath(((AndroidPath) path).getInternalPath(), paint.getInternalPaint());
    }

    @Override // androidx.compose.p109ui.graphics.Canvas
    /* JADX INFO: renamed from: drawPoints-O7TthRY, reason: not valid java name */
    public void mo18385drawPointsO7TthRY(int pointMode, @NotNull List<Offset> points, @NotNull Paint paint) {
        PointMode.Companion companion = PointMode.INSTANCE;
        if (PointMode.m18826equalsimpl0(pointMode, companion.m18830getLinesr_lszbg())) {
            drawLines(points, paint, 2);
        } else if (PointMode.m18826equalsimpl0(pointMode, companion.m18832getPolygonr_lszbg())) {
            drawLines(points, paint, 1);
        } else if (PointMode.m18826equalsimpl0(pointMode, companion.m18831getPointsr_lszbg())) {
            drawPoints(points, paint);
        }
    }

    @Override // androidx.compose.p109ui.graphics.Canvas
    /* JADX INFO: renamed from: drawRawPoints-O7TthRY, reason: not valid java name */
    public void mo18386drawRawPointsO7TthRY(int pointMode, @NotNull float[] points, @NotNull Paint paint) {
        if (points.length % 2 != 0) {
            throw new IllegalArgumentException("points must have an even number of values");
        }
        PointMode.Companion companion = PointMode.INSTANCE;
        if (PointMode.m18826equalsimpl0(pointMode, companion.m18830getLinesr_lszbg())) {
            drawRawLines(points, paint, 2);
        } else if (PointMode.m18826equalsimpl0(pointMode, companion.m18832getPolygonr_lszbg())) {
            drawRawLines(points, paint, 1);
        } else if (PointMode.m18826equalsimpl0(pointMode, companion.m18831getPointsr_lszbg())) {
            drawRawPoints(points, paint, 2);
        }
    }

    @Override // androidx.compose.p109ui.graphics.Canvas
    public void drawRect(float left, float top, float right, float bottom, @NotNull Paint paint) {
        this.internalCanvas.drawRect(left, top, right, bottom, paint.getInternalPaint());
    }

    @Override // androidx.compose.p109ui.graphics.Canvas
    public void drawRoundRect(float left, float top, float right, float bottom, float radiusX, float radiusY, @NotNull Paint paint) {
        this.internalCanvas.drawRoundRect(left, top, right, bottom, radiusX, radiusY, paint.getInternalPaint());
    }

    @Override // androidx.compose.p109ui.graphics.Canvas
    /* JADX INFO: renamed from: drawVertices-TPEHhCM, reason: not valid java name */
    public void mo18387drawVerticesTPEHhCM(@NotNull Vertices vertices, int blendMode, @NotNull Paint paint) {
        this.internalCanvas.drawVertices(AndroidVertexMode_androidKt.m18431toAndroidVertexModeJOOmi9M(vertices.getVertexMode()), vertices.getPositions().length, vertices.getPositions(), 0, vertices.getTextureCoordinates(), 0, vertices.getColors(), 0, vertices.getIndices(), 0, vertices.getIndices().length, paint.getInternalPaint());
    }

    @Override // androidx.compose.p109ui.graphics.Canvas
    public void enableZ() {
        CanvasUtils.INSTANCE.enableZ(this.internalCanvas, true);
    }

    @NotNull
    public final Canvas getInternalCanvas() {
        return this.internalCanvas;
    }

    @Override // androidx.compose.p109ui.graphics.Canvas
    public void restore() {
        this.internalCanvas.restore();
    }

    @Override // androidx.compose.p109ui.graphics.Canvas
    public void rotate(float degrees) {
        this.internalCanvas.rotate(degrees);
    }

    @Override // androidx.compose.p109ui.graphics.Canvas
    public void save() {
        this.internalCanvas.save();
    }

    @Override // androidx.compose.p109ui.graphics.Canvas
    public void saveLayer(@NotNull androidx.compose.p109ui.geometry.Rect bounds, @NotNull Paint paint) {
        this.internalCanvas.saveLayer(bounds.getLeft(), bounds.getTop(), bounds.getRight(), bounds.getBottom(), paint.getInternalPaint(), 31);
    }

    @Override // androidx.compose.p109ui.graphics.Canvas
    public void scale(float sx, float sy) {
        this.internalCanvas.scale(sx, sy);
    }

    public final void setInternalCanvas(@NotNull Canvas canvas) {
        this.internalCanvas = canvas;
    }

    @Override // androidx.compose.p109ui.graphics.Canvas
    public void skew(float sx, float sy) {
        this.internalCanvas.skew(sx, sy);
    }

    @NotNull
    /* JADX INFO: renamed from: toRegionOp--7u2Bmg, reason: not valid java name */
    public final Region.Op m18388toRegionOp7u2Bmg(int i) {
        return ClipOp.m18509equalsimpl0(i, ClipOp.INSTANCE.m18513getDifferencertfAjoo()) ? Region.Op.DIFFERENCE : Region.Op.INTERSECT;
    }

    @Override // androidx.compose.p109ui.graphics.Canvas
    public void translate(float dx, float dy) {
        this.internalCanvas.translate(dx, dy);
    }

    @PublishedApi
    public static /* synthetic */ void getInternalCanvas$annotations() {
    }
}
