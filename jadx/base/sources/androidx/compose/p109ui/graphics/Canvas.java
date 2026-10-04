package androidx.compose.p109ui.graphics;

import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.unit.IntOffset;
import androidx.compose.p109ui.unit.IntSizeKt;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ$\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0016ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ<\u0010\n\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0003H&J0\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016JH\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H&J0\u0010#\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J*\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"H&ø\u0001\u0000¢\u0006\u0004\b*\u0010+J*\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020(2\u0006\u0010!\u001a\u00020\"H&ø\u0001\u0000¢\u0006\u0004\b0\u00101JJ\u00102\u001a\u00020\u00032\u0006\u0010-\u001a\u00020.2\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u0002042\b\b\u0002\u00108\u001a\u0002062\u0006\u0010!\u001a\u00020\"H&ø\u0001\u0000¢\u0006\u0004\b9\u0010:J*\u0010;\u001a\u00020\u00032\u0006\u0010<\u001a\u00020(2\u0006\u0010=\u001a\u00020(2\u0006\u0010!\u001a\u00020\"H&ø\u0001\u0000¢\u0006\u0004\b>\u0010?J\u0018\u0010@\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010!\u001a\u00020\"H\u0016J0\u0010@\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"H&J\u0018\u0010A\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H&J0\u0010B\u001a\u00020\u00032\u0006\u0010C\u001a\u00020D2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020(0F2\u0006\u0010!\u001a\u00020\"H&ø\u0001\u0000¢\u0006\u0004\bG\u0010HJ*\u0010I\u001a\u00020\u00032\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020J2\u0006\u0010!\u001a\u00020\"H&ø\u0001\u0000¢\u0006\u0004\bK\u0010LJ\u0018\u0010M\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010!\u001a\u00020\"H\u0016J0\u0010M\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"H&J@\u0010N\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010O\u001a\u00020\u00102\u0006\u0010P\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"H&J*\u0010Q\u001a\u00020\u00032\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010!\u001a\u00020\"H&ø\u0001\u0000¢\u0006\u0004\bV\u0010WJ\b\u0010X\u001a\u00020\u0003H&J\b\u0010Y\u001a\u00020\u0003H&J\u0010\u0010Z\u001a\u00020\u00032\u0006\u0010[\u001a\u00020\u0010H&J\b\u0010\\\u001a\u00020\u0003H&J\u0018\u0010]\u001a\u00020\u00032\u0006\u0010^\u001a\u00020\f2\u0006\u0010!\u001a\u00020\"H&J\u001a\u0010_\u001a\u00020\u00032\u0006\u0010`\u001a\u00020\u00102\b\b\u0002\u0010a\u001a\u00020\u0010H&J\u0018\u0010b\u001a\u00020\u00032\u0006\u0010`\u001a\u00020\u00102\u0006\u0010a\u001a\u00020\u0010H&J\u0018\u0010c\u001a\u00020\u00032\u0006\u0010d\u001a\u00020\u00102\u0006\u0010e\u001a\u00020\u0010H\u0016J\u0018\u0010f\u001a\u00020\u00032\u0006\u0010g\u001a\u00020\u00102\u0006\u0010h\u001a\u00020\u0010H&ø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006iÀ\u0006\u0003"}, m13886d2 = {"Landroidx/compose/ui/graphics/Canvas;", "", "clipPath", "", "path", "Landroidx/compose/ui/graphics/Path;", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "clipPath-mtrdD-E", "(Landroidx/compose/ui/graphics/Path;I)V", "clipRect", "rect", "Landroidx/compose/ui/geometry/Rect;", "clipRect-mtrdD-E", "(Landroidx/compose/ui/geometry/Rect;I)V", "left", "", "top", "right", "bottom", "clipRect-N_I0leg", "(FFFFI)V", "concat", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "concat-58bKbWc", "([F)V", "disableZ", "drawArc", "startAngle", "sweepAngle", "useCenter", "", "paint", "Landroidx/compose/ui/graphics/Paint;", "drawArcRad", "startAngleRad", "sweepAngleRad", "drawCircle", "center", "Landroidx/compose/ui/geometry/Offset;", "radius", "drawCircle-9KIMszo", "(JFLandroidx/compose/ui/graphics/Paint;)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "topLeftOffset", "drawImage-d-4ec7I", "(Landroidx/compose/ui/graphics/ImageBitmap;JLandroidx/compose/ui/graphics/Paint;)V", "drawImageRect", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImageRect-HPBpro0", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJLandroidx/compose/ui/graphics/Paint;)V", "drawLine", "p1", "p2", "drawLine-Wko1d7g", "(JJLandroidx/compose/ui/graphics/Paint;)V", "drawOval", "drawPath", "drawPoints", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "points", "", "drawPoints-O7TthRY", "(ILjava/util/List;Landroidx/compose/ui/graphics/Paint;)V", "drawRawPoints", "", "drawRawPoints-O7TthRY", "(I[FLandroidx/compose/ui/graphics/Paint;)V", "drawRect", "drawRoundRect", "radiusX", "radiusY", "drawVertices", "vertices", "Landroidx/compose/ui/graphics/Vertices;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawVertices-TPEHhCM", "(Landroidx/compose/ui/graphics/Vertices;ILandroidx/compose/ui/graphics/Paint;)V", "enableZ", "restore", "rotate", "degrees", "save", "saveLayer", "bounds", WiggleAnimationConfig.KEY_SCALE, "sx", "sy", "skew", "skewRad", "sxRad", "syRad", "translate", "dx", "dy", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface Canvas {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        /* JADX INFO: renamed from: clipRect-mtrdD-E, reason: not valid java name */
        public static void m18503clipRectmtrdDE(@NotNull Canvas canvas, @NotNull Rect rect, int i) {
            Canvas.super.m18500clipRectmtrdDE(rect, i);
        }

        @Deprecated
        public static void drawArc(@NotNull Canvas canvas, @NotNull Rect rect, float f, float f4, boolean z, @NotNull Paint paint) {
            Canvas.super.drawArc(rect, f, f4, z, paint);
        }

        @Deprecated
        public static void drawArcRad(@NotNull Canvas canvas, @NotNull Rect rect, float f, float f4, boolean z, @NotNull Paint paint) {
            Canvas.super.drawArcRad(rect, f, f4, z, paint);
        }

        @Deprecated
        public static void drawOval(@NotNull Canvas canvas, @NotNull Rect rect, @NotNull Paint paint) {
            Canvas.super.drawOval(rect, paint);
        }

        @Deprecated
        public static void drawRect(@NotNull Canvas canvas, @NotNull Rect rect, @NotNull Paint paint) {
            Canvas.super.drawRect(rect, paint);
        }

        @Deprecated
        public static void skewRad(@NotNull Canvas canvas, float f, float f4) {
            Canvas.super.skewRad(f, f4);
        }
    }

    /* JADX INFO: renamed from: clipPath-mtrdD-E$default, reason: not valid java name */
    static /* synthetic */ void m18496clipPathmtrdDE$default(Canvas canvas, Path path, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipPath-mtrdD-E");
        }
        if ((i2 & 2) != 0) {
            i = ClipOp.INSTANCE.m18514getIntersectrtfAjoo();
        }
        canvas.mo18378clipPathmtrdDE(path, i);
    }

    /* JADX INFO: renamed from: clipRect-N_I0leg$default, reason: not valid java name */
    static /* synthetic */ void m18497clipRectN_I0leg$default(Canvas canvas, float f, float f4, float f5, float f6, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipRect-N_I0leg");
        }
        if ((i2 & 16) != 0) {
            i = ClipOp.INSTANCE.m18514getIntersectrtfAjoo();
        }
        canvas.mo18379clipRectN_I0leg(f, f4, f5, f6, i);
    }

    /* JADX INFO: renamed from: clipRect-mtrdD-E$default, reason: not valid java name */
    static /* synthetic */ void m18498clipRectmtrdDE$default(Canvas canvas, Rect rect, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipRect-mtrdD-E");
        }
        if ((i2 & 2) != 0) {
            i = ClipOp.INSTANCE.m18514getIntersectrtfAjoo();
        }
        canvas.m18500clipRectmtrdDE(rect, i);
    }

    /* JADX INFO: renamed from: drawImageRect-HPBpro0$default, reason: not valid java name */
    static /* synthetic */ void m18499drawImageRectHPBpro0$default(Canvas canvas, ImageBitmap imageBitmap, long j, long j2, long j3, long j5, Paint paint, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drawImageRect-HPBpro0");
        }
        long jM21106getZeronOccac = (i & 2) != 0 ? IntOffset.INSTANCE.m21106getZeronOccac() : j;
        long jIntSize = (i & 4) != 0 ? IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight()) : j2;
        canvas.mo18383drawImageRectHPBpro0(imageBitmap, jM21106getZeronOccac, jIntSize, (i & 8) != 0 ? IntOffset.INSTANCE.m21106getZeronOccac() : j3, (i & 16) != 0 ? jIntSize : j5, paint);
    }

    static /* synthetic */ void scale$default(Canvas canvas, float f, float f4, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scale");
        }
        if ((i & 2) != 0) {
            f4 = f;
        }
        canvas.scale(f, f4);
    }

    /* JADX INFO: renamed from: clipPath-mtrdD-E */
    void mo18378clipPathmtrdDE(@NotNull Path path, int clipOp);

    /* JADX INFO: renamed from: clipRect-N_I0leg */
    void mo18379clipRectN_I0leg(float left, float top, float right, float bottom, int clipOp);

    /* JADX INFO: renamed from: clipRect-mtrdD-E, reason: not valid java name */
    default void m18500clipRectmtrdDE(@NotNull Rect rect, int clipOp) {
        mo18379clipRectN_I0leg(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), clipOp);
    }

    /* JADX INFO: renamed from: concat-58bKbWc */
    void mo18380concat58bKbWc(@NotNull float[] matrix);

    void disableZ();

    void drawArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean useCenter, @NotNull Paint paint);

    default void drawArc(@NotNull Rect rect, float startAngle, float sweepAngle, boolean useCenter, @NotNull Paint paint) {
        drawArc(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), startAngle, sweepAngle, useCenter, paint);
    }

    default void drawArcRad(@NotNull Rect rect, float startAngleRad, float sweepAngleRad, boolean useCenter, @NotNull Paint paint) {
        drawArc(rect, DegreesKt.degrees(startAngleRad), DegreesKt.degrees(sweepAngleRad), useCenter, paint);
    }

    /* JADX INFO: renamed from: drawCircle-9KIMszo */
    void mo18381drawCircle9KIMszo(long center, float radius, @NotNull Paint paint);

    /* JADX INFO: renamed from: drawImage-d-4ec7I */
    void mo18382drawImaged4ec7I(@NotNull ImageBitmap image, long topLeftOffset, @NotNull Paint paint);

    /* JADX INFO: renamed from: drawImageRect-HPBpro0 */
    void mo18383drawImageRectHPBpro0(@NotNull ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, @NotNull Paint paint);

    /* JADX INFO: renamed from: drawLine-Wko1d7g */
    void mo18384drawLineWko1d7g(long p1, long p2, @NotNull Paint paint);

    void drawOval(float left, float top, float right, float bottom, @NotNull Paint paint);

    default void drawOval(@NotNull Rect rect, @NotNull Paint paint) {
        drawOval(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), paint);
    }

    void drawPath(@NotNull Path path, @NotNull Paint paint);

    /* JADX INFO: renamed from: drawPoints-O7TthRY */
    void mo18385drawPointsO7TthRY(int pointMode, @NotNull List<Offset> points, @NotNull Paint paint);

    /* JADX INFO: renamed from: drawRawPoints-O7TthRY */
    void mo18386drawRawPointsO7TthRY(int pointMode, @NotNull float[] points, @NotNull Paint paint);

    void drawRect(float left, float top, float right, float bottom, @NotNull Paint paint);

    default void drawRect(@NotNull Rect rect, @NotNull Paint paint) {
        drawRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), paint);
    }

    void drawRoundRect(float left, float top, float right, float bottom, float radiusX, float radiusY, @NotNull Paint paint);

    /* JADX INFO: renamed from: drawVertices-TPEHhCM */
    void mo18387drawVerticesTPEHhCM(@NotNull Vertices vertices, int blendMode, @NotNull Paint paint);

    void enableZ();

    void restore();

    void rotate(float degrees);

    void save();

    void saveLayer(@NotNull Rect bounds, @NotNull Paint paint);

    void scale(float sx, float sy);

    void skew(float sx, float sy);

    default void skewRad(float sxRad, float syRad) {
        skew(DegreesKt.degrees(sxRad), DegreesKt.degrees(syRad));
    }

    void translate(float dx, float dy);
}
