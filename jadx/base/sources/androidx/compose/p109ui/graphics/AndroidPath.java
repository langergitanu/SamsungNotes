package androidx.compose.p109ui.graphics;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.compose.p109ui.geometry.CornerRadius;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.geometry.RoundRect;
import androidx.compose.p109ui.graphics.Path;
import androidx.compose.p109ui.graphics.PathOperation;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataPredefinedShape;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0016J \u0010!\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u001fH\u0016J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010$\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&H\u0016J\"\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u001dH\u0016J\u0018\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u000201H\u0016J\u0018\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u0002012\u0006\u0010%\u001a\u00020&H\u0016J(\u00102\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u00103\u001a\u00020\u000fH\u0016J\b\u00104\u001a\u00020\u001bH\u0016J8\u00105\u001a\u00020\u001b2\u0006\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u001f2\u0006\u00108\u001a\u00020\u001f2\u0006\u00109\u001a\u00020\u001f2\u0006\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\u001fH\u0016J\b\u0010<\u001a\u00020\u001dH\u0016J\u0018\u0010=\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020\u001f2\u0006\u0010?\u001a\u00020\u001fH\u0016J\u0018\u0010@\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020\u001f2\u0006\u0010?\u001a\u00020\u001fH\u0016J*\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u00012\u0006\u0010C\u001a\u00020\u00012\u0006\u0010D\u001a\u00020EH\u0016ø\u0001\u0000¢\u0006\u0004\bF\u0010GJ(\u0010H\u001a\u00020\u001b2\u0006\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u001f2\u0006\u00108\u001a\u00020\u001f2\u0006\u00109\u001a\u00020\u001fH\u0016J(\u0010I\u001a\u00020\u001b2\u0006\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u001f2\u0006\u00108\u001a\u00020\u001f2\u0006\u00109\u001a\u00020\u001fH\u0016J8\u0010J\u001a\u00020\u001b2\u0006\u0010K\u001a\u00020\u001f2\u0006\u0010L\u001a\u00020\u001f2\u0006\u0010M\u001a\u00020\u001f2\u0006\u0010N\u001a\u00020\u001f2\u0006\u0010O\u001a\u00020\u001f2\u0006\u0010P\u001a\u00020\u001fH\u0016J\u0018\u0010Q\u001a\u00020\u001b2\u0006\u0010R\u001a\u00020\u001f2\u0006\u0010S\u001a\u00020\u001fH\u0016J\u0018\u0010T\u001a\u00020\u001b2\u0006\u0010R\u001a\u00020\u001f2\u0006\u0010S\u001a\u00020\u001fH\u0016J(\u0010U\u001a\u00020\u001b2\u0006\u0010K\u001a\u00020\u001f2\u0006\u0010L\u001a\u00020\u001f2\u0006\u0010M\u001a\u00020\u001f2\u0006\u0010N\u001a\u00020\u001fH\u0016J(\u0010V\u001a\u00020\u001b2\u0006\u0010K\u001a\u00020\u001f2\u0006\u0010L\u001a\u00020\u001f2\u0006\u0010M\u001a\u00020\u001f2\u0006\u0010N\u001a\u00020\u001fH\u0016J\b\u0010W\u001a\u00020\u001bH\u0016J\b\u0010X\u001a\u00020\u001bH\u0016J\u001a\u0010Y\u001a\u00020\u001b2\u0006\u0010Z\u001a\u00020[H\u0016ø\u0001\u0000¢\u0006\u0004\b\\\u0010]J\u001a\u0010^\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000¢\u0006\u0004\b_\u0010`J\u0010\u0010a\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u001dH\u0002R*\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0012R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006b"}, m13886d2 = {"Landroidx/compose/ui/graphics/AndroidPath;", "Landroidx/compose/ui/graphics/Path;", "internalPath", "Landroid/graphics/Path;", "(Landroid/graphics/Path;)V", "value", "Landroidx/compose/ui/graphics/PathFillType;", "fillType", "getFillType-Rg-k1Os", "()I", "setFillType-oQ8Xj4U", "(I)V", "getInternalPath", "()Landroid/graphics/Path;", "isConvex", "", "isConvex$annotations", "()V", "()Z", "isEmpty", "mMatrix", "Landroid/graphics/Matrix;", "radii", "", "rectF", "Landroid/graphics/RectF;", "addArc", "", VMetaDataPredefinedShape.OVAL, "Landroidx/compose/ui/geometry/Rect;", "startAngleDegrees", "", "sweepAngleDegrees", "addArcRad", "startAngleRadians", "sweepAngleRadians", "addOval", "direction", "Landroidx/compose/ui/graphics/Path$Direction;", "addPath", "path", TypedValues.Cycle.S_WAVE_OFFSET, "Landroidx/compose/ui/geometry/Offset;", "addPath-Uv8p0NA", "(Landroidx/compose/ui/graphics/Path;J)V", "addRect", "rect", "addRoundRect", "roundRect", "Landroidx/compose/ui/geometry/RoundRect;", "arcTo", "forceMoveTo", "close", "cubicTo", "x1", "y1", "x2", "y2", "x3", "y3", "getBounds", "lineTo", "x", "y", "moveTo", "op", "path1", "path2", "operation", "Landroidx/compose/ui/graphics/PathOperation;", "op-N5in7k0", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Path;I)Z", "quadraticBezierTo", "quadraticTo", "relativeCubicTo", "dx1", "dy1", "dx2", "dy2", "dx3", "dy3", "relativeLineTo", "dx", "dy", "relativeMoveTo", "relativeQuadraticBezierTo", "relativeQuadraticTo", "reset", "rewind", "transform", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transform-58bKbWc", "([F)V", "translate", "translate-k-4lQ0M", "(J)V", "validateRectangle", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAndroidPath.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidPath.android.kt\nandroidx/compose/ui/graphics/AndroidPath\n+ 2 AndroidPath.android.kt\nandroidx/compose/ui/graphics/AndroidPath_androidKt\n*L\n1#1,286:1\n38#2,5:287\n38#2,5:292\n*S KotlinDebug\n*F\n+ 1 AndroidPath.android.kt\nandroidx/compose/ui/graphics/AndroidPath\n*L\n205#1:287,5\n258#1:292,5\n*E\n"})
public final class AndroidPath implements Path {

    @NotNull
    private final Path internalPath;

    @Nullable
    private Matrix mMatrix;

    @Nullable
    private float[] radii;

    @Nullable
    private RectF rectF;

    /* JADX WARN: Multi-variable type inference failed */
    public AndroidPath() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final void validateRectangle(Rect rect) {
        if (Float.isNaN(rect.getLeft()) || Float.isNaN(rect.getTop()) || Float.isNaN(rect.getRight()) || Float.isNaN(rect.getBottom())) {
            AndroidPath_androidKt.throwIllegalStateException("Invalid rectangle, make sure no value is NaN");
        }
    }

    @Override // androidx.compose.p109ui.graphics.Path
    public void addArc(@NotNull Rect oval, float startAngleDegrees, float sweepAngleDegrees) {
        validateRectangle(oval);
        if (this.rectF == null) {
            this.rectF = new RectF();
        }
        RectF rectF = this.rectF;
        Intrinsics.checkNotNull(rectF);
        rectF.set(oval.getLeft(), oval.getTop(), oval.getRight(), oval.getBottom());
        Path path = this.internalPath;
        RectF rectF2 = this.rectF;
        Intrinsics.checkNotNull(rectF2);
        path.addArc(rectF2, startAngleDegrees, sweepAngleDegrees);
    }

    @Override // androidx.compose.p109ui.graphics.Path
    public void addArcRad(@NotNull Rect oval, float startAngleRadians, float sweepAngleRadians) {
        addArc(oval, DegreesKt.degrees(startAngleRadians), DegreesKt.degrees(sweepAngleRadians));
    }

    @Override // androidx.compose.p109ui.graphics.Path
    public /* synthetic */ void addOval(Rect oval) {
        addOval(oval, Path.Direction.CounterClockwise);
    }

    @Override // androidx.compose.p109ui.graphics.Path
    /* JADX INFO: renamed from: addPath-Uv8p0NA, reason: not valid java name */
    public void mo18415addPathUv8p0NA(@NotNull Path path, long offset) {
        android.graphics.Path path2 = this.internalPath;
        if (!(path instanceof AndroidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        path2.addPath(((AndroidPath) path).getInternalPath(), Offset.m18284getXimpl(offset), Offset.m18285getYimpl(offset));
    }

    @Override // androidx.compose.p109ui.graphics.Path
    public /* synthetic */ void addRect(Rect rect) {
        addRect(rect, Path.Direction.CounterClockwise);
    }

    @Override // androidx.compose.p109ui.graphics.Path
    public /* synthetic */ void addRoundRect(RoundRect roundRect) {
        addRoundRect(roundRect, Path.Direction.CounterClockwise);
    }

    @Override // androidx.compose.p109ui.graphics.Path
    public void arcTo(@NotNull Rect rect, float startAngleDegrees, float sweepAngleDegrees, boolean forceMoveTo) {
        float left = rect.getLeft();
        float top = rect.getTop();
        float right = rect.getRight();
        float bottom = rect.getBottom();
        if (this.rectF == null) {
            this.rectF = new RectF();
        }
        RectF rectF = this.rectF;
        Intrinsics.checkNotNull(rectF);
        rectF.set(left, top, right, bottom);
        android.graphics.Path path = this.internalPath;
        RectF rectF2 = this.rectF;
        Intrinsics.checkNotNull(rectF2);
        path.arcTo(rectF2, startAngleDegrees, sweepAngleDegrees, forceMoveTo);
    }

    @Override // androidx.compose.p109ui.graphics.Path
    public void close() {
        this.internalPath.close();
    }

    @Override // androidx.compose.p109ui.graphics.Path
    public void cubicTo(float x12, float y1, float x2, float y2, float x32, float y3) {
        this.internalPath.cubicTo(x12, y1, x2, y2, x32, y3);
    }

    @Override // androidx.compose.p109ui.graphics.Path
    @NotNull
    public Rect getBounds() {
        if (this.rectF == null) {
            this.rectF = new RectF();
        }
        RectF rectF = this.rectF;
        Intrinsics.checkNotNull(rectF);
        this.internalPath.computeBounds(rectF, true);
        return new Rect(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    @Override // androidx.compose.p109ui.graphics.Path
    /* JADX INFO: renamed from: getFillType-Rg-k1Os, reason: not valid java name */
    public int mo18416getFillTypeRgk1Os() {
        return this.internalPath.getFillType() == Path.FillType.EVEN_ODD ? PathFillType.INSTANCE.m18807getEvenOddRgk1Os() : PathFillType.INSTANCE.m18808getNonZeroRgk1Os();
    }

    @NotNull
    public final android.graphics.Path getInternalPath() {
        return this.internalPath;
    }

    @Override // androidx.compose.p109ui.graphics.Path
    public boolean isConvex() {
        return this.internalPath.isConvex();
    }

    @Override // androidx.compose.p109ui.graphics.Path
    public boolean isEmpty() {
        return this.internalPath.isEmpty();
    }

    @Override // androidx.compose.p109ui.graphics.Path
    public void lineTo(float x, float y2) {
        this.internalPath.lineTo(x, y2);
    }

    @Override // androidx.compose.p109ui.graphics.Path
    public void moveTo(float x, float y2) {
        this.internalPath.moveTo(x, y2);
    }

    @Override // androidx.compose.p109ui.graphics.Path
    /* JADX INFO: renamed from: op-N5in7k0, reason: not valid java name */
    public boolean mo18417opN5in7k0(@NotNull Path path1, @NotNull Path path2, int operation) {
        PathOperation.Companion companion = PathOperation.INSTANCE;
        Path.Op op = PathOperation.m18813equalsimpl0(operation, companion.m18817getDifferenceb3I0S0c()) ? Path.Op.DIFFERENCE : PathOperation.m18813equalsimpl0(operation, companion.m18818getIntersectb3I0S0c()) ? Path.Op.INTERSECT : PathOperation.m18813equalsimpl0(operation, companion.m18819getReverseDifferenceb3I0S0c()) ? Path.Op.REVERSE_DIFFERENCE : PathOperation.m18813equalsimpl0(operation, companion.m18820getUnionb3I0S0c()) ? Path.Op.UNION : Path.Op.XOR;
        android.graphics.Path path = this.internalPath;
        if (!(path1 instanceof AndroidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        android.graphics.Path internalPath = ((AndroidPath) path1).getInternalPath();
        if (path2 instanceof AndroidPath) {
            return path.op(internalPath, ((AndroidPath) path2).getInternalPath(), op);
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    @Override // androidx.compose.p109ui.graphics.Path
    public void quadraticBezierTo(float x12, float y1, float x2, float y2) {
        this.internalPath.quadTo(x12, y1, x2, y2);
    }

    @Override // androidx.compose.p109ui.graphics.Path
    public void quadraticTo(float x12, float y1, float x2, float y2) {
        this.internalPath.quadTo(x12, y1, x2, y2);
    }

    @Override // androidx.compose.p109ui.graphics.Path
    public void relativeCubicTo(float dx1, float dy1, float dx2, float dy2, float dx3, float dy3) {
        this.internalPath.rCubicTo(dx1, dy1, dx2, dy2, dx3, dy3);
    }

    @Override // androidx.compose.p109ui.graphics.Path
    public void relativeLineTo(float dx, float dy) {
        this.internalPath.rLineTo(dx, dy);
    }

    @Override // androidx.compose.p109ui.graphics.Path
    public void relativeMoveTo(float dx, float dy) {
        this.internalPath.rMoveTo(dx, dy);
    }

    @Override // androidx.compose.p109ui.graphics.Path
    public void relativeQuadraticBezierTo(float dx1, float dy1, float dx2, float dy2) {
        this.internalPath.rQuadTo(dx1, dy1, dx2, dy2);
    }

    @Override // androidx.compose.p109ui.graphics.Path
    public void relativeQuadraticTo(float dx1, float dy1, float dx2, float dy2) {
        this.internalPath.rQuadTo(dx1, dy1, dx2, dy2);
    }

    @Override // androidx.compose.p109ui.graphics.Path
    public void reset() {
        this.internalPath.reset();
    }

    @Override // androidx.compose.p109ui.graphics.Path
    public void rewind() {
        this.internalPath.rewind();
    }

    @Override // androidx.compose.p109ui.graphics.Path
    /* JADX INFO: renamed from: setFillType-oQ8Xj4U, reason: not valid java name */
    public void mo18418setFillTypeoQ8Xj4U(int i) {
        this.internalPath.setFillType(PathFillType.m18803equalsimpl0(i, PathFillType.INSTANCE.m18807getEvenOddRgk1Os()) ? Path.FillType.EVEN_ODD : Path.FillType.WINDING);
    }

    @Override // androidx.compose.p109ui.graphics.Path
    /* JADX INFO: renamed from: transform-58bKbWc, reason: not valid java name */
    public void mo18419transform58bKbWc(@NotNull float[] matrix) {
        if (this.mMatrix == null) {
            this.mMatrix = new Matrix();
        }
        Matrix matrix2 = this.mMatrix;
        Intrinsics.checkNotNull(matrix2);
        AndroidMatrixConversions_androidKt.m18395setFromEL8BTi8(matrix2, matrix);
        android.graphics.Path path = this.internalPath;
        Matrix matrix3 = this.mMatrix;
        Intrinsics.checkNotNull(matrix3);
        path.transform(matrix3);
    }

    @Override // androidx.compose.p109ui.graphics.Path
    /* JADX INFO: renamed from: translate-k-4lQ0M, reason: not valid java name */
    public void mo18420translatek4lQ0M(long offset) {
        Matrix matrix = this.mMatrix;
        if (matrix == null) {
            this.mMatrix = new Matrix();
        } else {
            Intrinsics.checkNotNull(matrix);
            matrix.reset();
        }
        Matrix matrix2 = this.mMatrix;
        Intrinsics.checkNotNull(matrix2);
        matrix2.setTranslate(Offset.m18284getXimpl(offset), Offset.m18285getYimpl(offset));
        android.graphics.Path path = this.internalPath;
        Matrix matrix3 = this.mMatrix;
        Intrinsics.checkNotNull(matrix3);
        path.transform(matrix3);
    }

    public AndroidPath(@NotNull android.graphics.Path path) {
        this.internalPath = path;
    }

    @Override // androidx.compose.p109ui.graphics.Path
    public void addOval(@NotNull Rect oval, @NotNull Path.Direction direction) {
        if (this.rectF == null) {
            this.rectF = new RectF();
        }
        RectF rectF = this.rectF;
        Intrinsics.checkNotNull(rectF);
        rectF.set(oval.getLeft(), oval.getTop(), oval.getRight(), oval.getBottom());
        android.graphics.Path path = this.internalPath;
        RectF rectF2 = this.rectF;
        Intrinsics.checkNotNull(rectF2);
        path.addOval(rectF2, AndroidPath_androidKt.toPlatformPathDirection(direction));
    }

    @Override // androidx.compose.p109ui.graphics.Path
    public void addRect(@NotNull Rect rect, @NotNull Path.Direction direction) {
        validateRectangle(rect);
        if (this.rectF == null) {
            this.rectF = new RectF();
        }
        RectF rectF = this.rectF;
        Intrinsics.checkNotNull(rectF);
        rectF.set(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom());
        android.graphics.Path path = this.internalPath;
        RectF rectF2 = this.rectF;
        Intrinsics.checkNotNull(rectF2);
        path.addRect(rectF2, AndroidPath_androidKt.toPlatformPathDirection(direction));
    }

    @Override // androidx.compose.p109ui.graphics.Path
    public void addRoundRect(@NotNull RoundRect roundRect, @NotNull Path.Direction direction) {
        if (this.rectF == null) {
            this.rectF = new RectF();
        }
        RectF rectF = this.rectF;
        Intrinsics.checkNotNull(rectF);
        rectF.set(roundRect.getLeft(), roundRect.getTop(), roundRect.getRight(), roundRect.getBottom());
        if (this.radii == null) {
            this.radii = new float[8];
        }
        float[] fArr = this.radii;
        Intrinsics.checkNotNull(fArr);
        fArr[0] = CornerRadius.m18259getXimpl(roundRect.m18334getTopLeftCornerRadiuskKHJgLs());
        fArr[1] = CornerRadius.m18260getYimpl(roundRect.m18334getTopLeftCornerRadiuskKHJgLs());
        fArr[2] = CornerRadius.m18259getXimpl(roundRect.m18335getTopRightCornerRadiuskKHJgLs());
        fArr[3] = CornerRadius.m18260getYimpl(roundRect.m18335getTopRightCornerRadiuskKHJgLs());
        fArr[4] = CornerRadius.m18259getXimpl(roundRect.m18333getBottomRightCornerRadiuskKHJgLs());
        fArr[5] = CornerRadius.m18260getYimpl(roundRect.m18333getBottomRightCornerRadiuskKHJgLs());
        fArr[6] = CornerRadius.m18259getXimpl(roundRect.m18332getBottomLeftCornerRadiuskKHJgLs());
        fArr[7] = CornerRadius.m18260getYimpl(roundRect.m18332getBottomLeftCornerRadiuskKHJgLs());
        android.graphics.Path path = this.internalPath;
        RectF rectF2 = this.rectF;
        Intrinsics.checkNotNull(rectF2);
        float[] fArr2 = this.radii;
        Intrinsics.checkNotNull(fArr2);
        path.addRoundRect(rectF2, fArr2, AndroidPath_androidKt.toPlatformPathDirection(direction));
    }

    public /* synthetic */ AndroidPath(android.graphics.Path path, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new android.graphics.Path() : path);
    }

    public static /* synthetic */ void isConvex$annotations() {
    }
}
