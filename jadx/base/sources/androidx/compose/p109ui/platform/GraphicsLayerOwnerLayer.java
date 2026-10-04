package androidx.compose.p109ui.platform;

import android.os.Build;
import androidx.compose.p109ui.geometry.MutableRect;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.geometry.SizeKt;
import androidx.compose.p109ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.p109ui.graphics.AndroidPaint_androidKt;
import androidx.compose.p109ui.graphics.AndroidPath_androidKt;
import androidx.compose.p109ui.graphics.Canvas;
import androidx.compose.p109ui.graphics.CompositingStrategy;
import androidx.compose.p109ui.graphics.GraphicsContext;
import androidx.compose.p109ui.graphics.Matrix;
import androidx.compose.p109ui.graphics.Outline;
import androidx.compose.p109ui.graphics.Paint;
import androidx.compose.p109ui.graphics.Path;
import androidx.compose.p109ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.p109ui.graphics.TransformOrigin;
import androidx.compose.p109ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.p109ui.graphics.drawscope.DrawContext;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import androidx.compose.p109ui.graphics.layer.GraphicsLayer;
import androidx.compose.p109ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.p109ui.layout.GraphicLayerInfo;
import androidx.compose.p109ui.node.OwnedLayer;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.DensityKt;
import androidx.compose.p109ui.unit.IntOffset;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.p109ui.unit.IntSizeKt;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.model.securefolder.common.SecureFolderConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002Bg\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00128\u0010\t\u001a4\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\n\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\u0002\u0010\u0013J\u0010\u0010<\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\b\u0010=\u001a\u00020\u0010H\u0016J\u001a\u0010>\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0016J\u0017\u0010?\u001a\u0004\u0018\u00010\u0019H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b@\u0010AJ\u0015\u0010B\u001a\u00020\u0019H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010AJ\b\u0010D\u001a\u00020\u0010H\u0016J\u001a\u0010E\u001a\u00020\u00102\u0006\u0010F\u001a\u00020\u0019H\u0016ø\u0001\u0000¢\u0006\u0004\bG\u0010HJ\u001a\u0010I\u001a\u00020\u00172\u0006\u0010J\u001a\u00020KH\u0016ø\u0001\u0000¢\u0006\u0004\bL\u0010MJ\u0018\u0010N\u001a\u00020\u00102\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u0017H\u0016J\"\u0010R\u001a\u00020K2\u0006\u0010S\u001a\u00020K2\u0006\u0010Q\u001a\u00020\u0017H\u0016ø\u0001\u0000¢\u0006\u0004\bT\u0010UJ\u001a\u0010V\u001a\u00020\u00102\u0006\u0010J\u001a\u00020WH\u0016ø\u0001\u0000¢\u0006\u0004\bX\u0010YJ\u001a\u0010Z\u001a\u00020\u00102\u0006\u00103\u001a\u000204H\u0016ø\u0001\u0000¢\u0006\u0004\b[\u0010YJP\u0010\\\u001a\u00020\u001028\u0010\t\u001a4\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012H\u0016J\u001a\u0010]\u001a\u00020\u00102\u0006\u0010F\u001a\u00020\u0019H\u0016ø\u0001\u0000¢\u0006\u0004\b^\u0010HJ\b\u0010_\u001a\u00020\u0010H\u0002J\b\u0010`\u001a\u00020\u0010H\u0016J\u0010\u0010a\u001a\u00020\u00102\u0006\u00101\u001a\u00020bH\u0016J\b\u0010c\u001a\u00020\u0010H\u0002J\b\u0010d\u001a\u00020\u0010H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000RB\u0010\t\u001a6\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0017@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\u00020\u0019X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010#R\u001f\u0010-\u001a\u0013\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00100.¢\u0006\u0002\b0X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u00103\u001a\u000204X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u00105R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010:\u001a\u00020;X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u00105\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006e"}, m13886d2 = {"Landroidx/compose/ui/platform/GraphicsLayerOwnerLayer;", "Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/layout/GraphicLayerInfo;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "context", "Landroidx/compose/ui/graphics/GraphicsContext;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "drawBlock", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/Canvas;", "Lkotlin/ParameterName;", "name", "canvas", "parentLayer", "", "invalidateParentLayer", "Lkotlin/Function0;", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/ui/platform/AndroidComposeView;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "density", "Landroidx/compose/ui/unit/Density;", "drawnWithEnabledZ", "", "inverseMatrixCache", "Landroidx/compose/ui/graphics/Matrix;", "[F", "isDestroyed", "value", "isDirty", "setDirty", "(Z)V", "layerId", "", "getLayerId", "()J", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "matrixCache", "mutatedFields", "", "outline", "Landroidx/compose/ui/graphics/Outline;", "ownerViewId", "getOwnerViewId", "recordLambda", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "scope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "size", "Landroidx/compose/ui/unit/IntSize;", "J", "softwareLayerPaint", "Landroidx/compose/ui/graphics/Paint;", "tmpPath", "Landroidx/compose/ui/graphics/Path;", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "clipManually", "destroy", "drawLayer", "getInverseMatrix", "getInverseMatrix-3i98HWw", "()[F", "getMatrix", "getMatrix-sQKQjiQ", "invalidate", "inverseTransform", "matrix", "inverseTransform-58bKbWc", "([F)V", "isInLayer", "position", "Landroidx/compose/ui/geometry/Offset;", "isInLayer-k-4lQ0M", "(J)Z", "mapBounds", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "inverse", "mapOffset", "point", "mapOffset-8S9VItk", "(JZ)J", SecureFolderConstants.TEMP_FOLDER_NAME, "Landroidx/compose/ui/unit/IntOffset;", "move--gyyYBs", "(J)V", "resize", "resize-ozmzZPI", "reuseLayer", "transform", "transform-58bKbWc", "triggerRepaint", "updateDisplayList", "updateLayerProperties", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "updateMatrix", "updateOutline", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nGraphicsLayerOwnerLayer.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GraphicsLayerOwnerLayer.android.kt\nandroidx/compose/ui/platform/GraphicsLayerOwnerLayer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,437:1\n1#2:438\n*E\n"})
public final class GraphicsLayerOwnerLayer implements OwnedLayer, GraphicLayerInfo {
    public static final int $stable = 8;

    @Nullable
    private final GraphicsContext context;

    @Nullable
    private Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock;
    private boolean drawnWithEnabledZ;

    @NotNull
    private GraphicsLayer graphicsLayer;

    @Nullable
    private Function0<Unit> invalidateParentLayer;

    @Nullable
    private float[] inverseMatrixCache;
    private boolean isDestroyed;
    private boolean isDirty;
    private int mutatedFields;

    @Nullable
    private Outline outline;

    @NotNull
    private final AndroidComposeView ownerView;

    @Nullable
    private Paint softwareLayerPaint;

    @Nullable
    private Path tmpPath;
    private long size = IntSizeKt.IntSize(Integer.MAX_VALUE, Integer.MAX_VALUE);

    @NotNull
    private final float[] matrixCache = Matrix.m18756constructorimpl$default(null, 1, null);

    @NotNull
    private Density density = DensityKt.Density$default(1.0f, 0.0f, 2, null);

    @NotNull
    private LayoutDirection layoutDirection = LayoutDirection.Ltr;

    @NotNull
    private final CanvasDrawScope scope = new CanvasDrawScope();
    private long transformOrigin = TransformOrigin.INSTANCE.m18916getCenterSzJe1aQ();

    @NotNull
    private final Function1<DrawScope, Unit> recordLambda = new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.platform.GraphicsLayerOwnerLayer$recordLambda$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
            invoke2(drawScope);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull DrawScope drawScope) {
            GraphicsLayerOwnerLayer graphicsLayerOwnerLayer = this.this$0;
            Canvas canvas = drawScope.getDrawContext().getCanvas();
            Function2 function2 = graphicsLayerOwnerLayer.drawBlock;
            if (function2 != null) {
                function2.invoke(canvas, drawScope.getDrawContext().getGraphicsLayer());
            }
        }
    };

    public GraphicsLayerOwnerLayer(@NotNull GraphicsLayer graphicsLayer, @Nullable GraphicsContext graphicsContext, @NotNull AndroidComposeView androidComposeView, @NotNull Function2<? super Canvas, ? super GraphicsLayer, Unit> function2, @NotNull Function0<Unit> function0) {
        this.graphicsLayer = graphicsLayer;
        this.context = graphicsContext;
        this.ownerView = androidComposeView;
        this.drawBlock = function2;
        this.invalidateParentLayer = function0;
    }

    private final void clipManually(Canvas canvas) {
        if (this.graphicsLayer.getClip()) {
            Outline outline = this.graphicsLayer.getOutline();
            if (outline instanceof Outline.Rectangle) {
                Canvas.m18498clipRectmtrdDE$default(canvas, ((Outline.Rectangle) outline).getRect(), 0, 2, null);
                return;
            }
            if (!(outline instanceof Outline.Rounded)) {
                if (outline instanceof Outline.Generic) {
                    Canvas.m18496clipPathmtrdDE$default(canvas, ((Outline.Generic) outline).getPath(), 0, 2, null);
                    return;
                }
                return;
            }
            Path Path = this.tmpPath;
            if (Path == null) {
                Path = AndroidPath_androidKt.Path();
                this.tmpPath = Path;
            }
            Path.reset();
            Path.addRoundRect$default(Path, ((Outline.Rounded) outline).getRoundRect(), null, 2, null);
            Canvas.m18496clipPathmtrdDE$default(canvas, Path, 0, 2, null);
        }
    }

    /* JADX INFO: renamed from: getInverseMatrix-3i98HWw, reason: not valid java name */
    private final float[] m20212getInverseMatrix3i98HWw() {
        float[] fArrM20213getMatrixsQKQjiQ = m20213getMatrixsQKQjiQ();
        float[] fArrM18756constructorimpl$default = this.inverseMatrixCache;
        if (fArrM18756constructorimpl$default == null) {
            fArrM18756constructorimpl$default = Matrix.m18756constructorimpl$default(null, 1, null);
            this.inverseMatrixCache = fArrM18756constructorimpl$default;
        }
        if (InvertMatrixKt.m20214invertToJiSxe2E(fArrM20213getMatrixsQKQjiQ, fArrM18756constructorimpl$default)) {
            return fArrM18756constructorimpl$default;
        }
        return null;
    }

    /* JADX INFO: renamed from: getMatrix-sQKQjiQ, reason: not valid java name */
    private final float[] m20213getMatrixsQKQjiQ() {
        updateMatrix();
        return this.matrixCache;
    }

    private final void setDirty(boolean z) {
        if (z != this.isDirty) {
            this.isDirty = z;
            this.ownerView.notifyLayerIsDirty$ui_release(this, z);
        }
    }

    private final void triggerRepaint() {
        WrapperRenderNodeLayerHelperMethods.INSTANCE.onDescendantInvalidated(this.ownerView);
    }

    private final void updateMatrix() {
        GraphicsLayer graphicsLayer = this.graphicsLayer;
        long jM18363getCenteruvyYCjk = OffsetKt.m18305isUnspecifiedk4lQ0M(graphicsLayer.getPivotOffset()) ? SizeKt.m18363getCenteruvyYCjk(IntSizeKt.m21150toSizeozmzZPI(this.size)) : graphicsLayer.getPivotOffset();
        Matrix.m18765resetimpl(this.matrixCache);
        float[] fArr = this.matrixCache;
        float[] fArrM18756constructorimpl$default = Matrix.m18756constructorimpl$default(null, 1, null);
        Matrix.m18776translateimpl$default(fArrM18756constructorimpl$default, -Offset.m18284getXimpl(jM18363getCenteruvyYCjk), -Offset.m18285getYimpl(jM18363getCenteruvyYCjk), 0.0f, 4, null);
        Matrix.m18773timesAssign58bKbWc(fArr, fArrM18756constructorimpl$default);
        float[] fArr2 = this.matrixCache;
        float[] fArrM18756constructorimpl$default2 = Matrix.m18756constructorimpl$default(null, 1, null);
        Matrix.m18776translateimpl$default(fArrM18756constructorimpl$default2, graphicsLayer.getTranslationX(), graphicsLayer.getTranslationY(), 0.0f, 4, null);
        Matrix.m18766rotateXimpl(fArrM18756constructorimpl$default2, graphicsLayer.getRotationX());
        Matrix.m18767rotateYimpl(fArrM18756constructorimpl$default2, graphicsLayer.getRotationY());
        Matrix.m18768rotateZimpl(fArrM18756constructorimpl$default2, graphicsLayer.getRotationZ());
        Matrix.m18770scaleimpl$default(fArrM18756constructorimpl$default2, graphicsLayer.getScaleX(), graphicsLayer.getScaleY(), 0.0f, 4, null);
        Matrix.m18773timesAssign58bKbWc(fArr2, fArrM18756constructorimpl$default2);
        float[] fArr3 = this.matrixCache;
        float[] fArrM18756constructorimpl$default3 = Matrix.m18756constructorimpl$default(null, 1, null);
        Matrix.m18776translateimpl$default(fArrM18756constructorimpl$default3, Offset.m18284getXimpl(jM18363getCenteruvyYCjk), Offset.m18285getYimpl(jM18363getCenteruvyYCjk), 0.0f, 4, null);
        Matrix.m18773timesAssign58bKbWc(fArr3, fArrM18756constructorimpl$default3);
    }

    private final void updateOutline() {
        Function0<Unit> function0;
        Outline outline = this.outline;
        if (outline == null) {
            return;
        }
        GraphicsLayerKt.setOutline(this.graphicsLayer, outline);
        if (!(outline instanceof Outline.Generic) || Build.VERSION.SDK_INT >= 33 || (function0 = this.invalidateParentLayer) == null) {
            return;
        }
        function0.invoke();
    }

    @Override // androidx.compose.p109ui.node.OwnedLayer
    public void destroy() {
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        this.isDestroyed = true;
        setDirty(false);
        GraphicsContext graphicsContext = this.context;
        if (graphicsContext != null) {
            graphicsContext.releaseGraphicsLayer(this.graphicsLayer);
            this.ownerView.recycle$ui_release(this);
        }
    }

    @Override // androidx.compose.p109ui.node.OwnedLayer
    public void drawLayer(@NotNull Canvas canvas, @Nullable GraphicsLayer parentLayer) {
        android.graphics.Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        if (nativeCanvas.isHardwareAccelerated()) {
            updateDisplayList();
            this.drawnWithEnabledZ = this.graphicsLayer.getShadowElevation() > 0.0f;
            DrawContext drawContext = this.scope.getDrawContext();
            drawContext.setCanvas(canvas);
            drawContext.setGraphicsLayer(parentLayer);
            GraphicsLayerKt.drawLayer(this.scope, this.graphicsLayer);
            return;
        }
        float fM21096getXimpl = IntOffset.m21096getXimpl(this.graphicsLayer.getTopLeft());
        float fM21097getYimpl = IntOffset.m21097getYimpl(this.graphicsLayer.getTopLeft());
        float fM21138getWidthimpl = fM21096getXimpl + IntSize.m21138getWidthimpl(this.size);
        float fM21137getHeightimpl = fM21097getYimpl + IntSize.m21137getHeightimpl(this.size);
        if (this.graphicsLayer.getAlpha() < 1.0f) {
            Paint Paint = this.softwareLayerPaint;
            if (Paint == null) {
                Paint = AndroidPaint_androidKt.Paint();
                this.softwareLayerPaint = Paint;
            }
            Paint.setAlpha(this.graphicsLayer.getAlpha());
            nativeCanvas.saveLayer(fM21096getXimpl, fM21097getYimpl, fM21138getWidthimpl, fM21137getHeightimpl, Paint.getInternalPaint());
        } else {
            canvas.save();
        }
        canvas.translate(fM21096getXimpl, fM21097getYimpl);
        canvas.mo18380concat58bKbWc(m20213getMatrixsQKQjiQ());
        if (this.graphicsLayer.getClip()) {
            clipManually(canvas);
        }
        Function2<? super Canvas, ? super GraphicsLayer, Unit> function2 = this.drawBlock;
        if (function2 != null) {
            function2.invoke(canvas, null);
        }
        canvas.restore();
    }

    @Override // androidx.compose.p109ui.layout.GraphicLayerInfo
    public long getLayerId() {
        return this.graphicsLayer.getLayerId();
    }

    @Override // androidx.compose.p109ui.layout.GraphicLayerInfo
    public long getOwnerViewId() {
        return this.graphicsLayer.getOwnerViewId();
    }

    @Override // androidx.compose.p109ui.node.OwnedLayer
    public void invalidate() {
        if (this.isDirty || this.isDestroyed) {
            return;
        }
        this.ownerView.invalidate();
        setDirty(true);
    }

    @Override // androidx.compose.p109ui.node.OwnedLayer
    /* JADX INFO: renamed from: inverseTransform-58bKbWc */
    public void mo20137inverseTransform58bKbWc(@NotNull float[] matrix) {
        float[] fArrM20212getInverseMatrix3i98HWw = m20212getInverseMatrix3i98HWw();
        if (fArrM20212getInverseMatrix3i98HWw != null) {
            Matrix.m18773timesAssign58bKbWc(matrix, fArrM20212getInverseMatrix3i98HWw);
        }
    }

    @Override // androidx.compose.p109ui.node.OwnedLayer
    /* JADX INFO: renamed from: isInLayer-k-4lQ0M */
    public boolean mo20138isInLayerk4lQ0M(long position) {
        float fM18284getXimpl = Offset.m18284getXimpl(position);
        float fM18285getYimpl = Offset.m18285getYimpl(position);
        if (this.graphicsLayer.getClip()) {
            return ShapeContainingUtilKt.isInOutline$default(this.graphicsLayer.getOutline(), fM18284getXimpl, fM18285getYimpl, null, null, 24, null);
        }
        return true;
    }

    @Override // androidx.compose.p109ui.node.OwnedLayer
    public void mapBounds(@NotNull MutableRect rect, boolean inverse) {
        if (!inverse) {
            Matrix.m18764mapimpl(m20213getMatrixsQKQjiQ(), rect);
            return;
        }
        float[] fArrM20212getInverseMatrix3i98HWw = m20212getInverseMatrix3i98HWw();
        if (fArrM20212getInverseMatrix3i98HWw == null) {
            rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            Matrix.m18764mapimpl(fArrM20212getInverseMatrix3i98HWw, rect);
        }
    }

    @Override // androidx.compose.p109ui.node.OwnedLayer
    /* JADX INFO: renamed from: mapOffset-8S9VItk */
    public long mo20139mapOffset8S9VItk(long point, boolean inverse) {
        if (!inverse) {
            return Matrix.m18762mapMKHz9U(m20213getMatrixsQKQjiQ(), point);
        }
        float[] fArrM20212getInverseMatrix3i98HWw = m20212getInverseMatrix3i98HWw();
        return fArrM20212getInverseMatrix3i98HWw != null ? Matrix.m18762mapMKHz9U(fArrM20212getInverseMatrix3i98HWw, point) : Offset.INSTANCE.m18298getInfiniteF1C5BW0();
    }

    @Override // androidx.compose.p109ui.node.OwnedLayer
    /* JADX INFO: renamed from: move--gyyYBs */
    public void mo20140movegyyYBs(long position) {
        this.graphicsLayer.m19178setTopLeftgyyYBs(position);
        triggerRepaint();
    }

    @Override // androidx.compose.p109ui.node.OwnedLayer
    /* JADX INFO: renamed from: resize-ozmzZPI */
    public void mo20141resizeozmzZPI(long size) {
        if (IntSize.m21136equalsimpl0(size, this.size)) {
            return;
        }
        this.size = size;
        invalidate();
    }

    @Override // androidx.compose.p109ui.node.OwnedLayer
    public void reuseLayer(@NotNull Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock, @NotNull Function0<Unit> invalidateParentLayer) {
        GraphicsContext graphicsContext = this.context;
        if (graphicsContext == null) {
            throw new IllegalArgumentException("currently reuse is only supported when we manage the layer lifecycle");
        }
        if (!this.graphicsLayer.getIsReleased()) {
            throw new IllegalArgumentException("layer should have been released before reuse");
        }
        this.graphicsLayer = graphicsContext.createGraphicsLayer();
        this.isDestroyed = false;
        this.drawBlock = drawBlock;
        this.invalidateParentLayer = invalidateParentLayer;
        this.transformOrigin = TransformOrigin.INSTANCE.m18916getCenterSzJe1aQ();
        this.drawnWithEnabledZ = false;
        this.size = IntSizeKt.IntSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.outline = null;
        this.mutatedFields = 0;
    }

    @Override // androidx.compose.p109ui.node.OwnedLayer
    /* JADX INFO: renamed from: transform-58bKbWc */
    public void mo20142transform58bKbWc(@NotNull float[] matrix) {
        Matrix.m18773timesAssign58bKbWc(matrix, m20213getMatrixsQKQjiQ());
    }

    @Override // androidx.compose.p109ui.node.OwnedLayer
    public void updateDisplayList() {
        if (this.isDirty) {
            if (!TransformOrigin.m18910equalsimpl0(this.transformOrigin, TransformOrigin.INSTANCE.m18916getCenterSzJe1aQ()) && !IntSize.m21136equalsimpl0(this.graphicsLayer.getSize(), this.size)) {
                this.graphicsLayer.m19174setPivotOffsetk4lQ0M(OffsetKt.Offset(TransformOrigin.m18911getPivotFractionXimpl(this.transformOrigin) * IntSize.m21138getWidthimpl(this.size), TransformOrigin.m18912getPivotFractionYimpl(this.transformOrigin) * IntSize.m21137getHeightimpl(this.size)));
            }
            this.graphicsLayer.m19170recordmLhObY(this.density, this.layoutDirection, this.size, this.recordLambda);
            setDirty(false);
        }
    }

    @Override // androidx.compose.p109ui.node.OwnedLayer
    public void updateLayerProperties(@NotNull ReusableGraphicsLayerScope scope) {
        boolean z;
        int iM19157getModulateAlphake2Ky5w;
        Function0<Unit> function0;
        int mutatedFields = scope.getMutatedFields() | this.mutatedFields;
        this.layoutDirection = scope.getLayoutDirection();
        this.density = scope.getGraphicsDensity();
        int i = mutatedFields & 4096;
        if (i != 0) {
            this.transformOrigin = scope.getTransformOrigin();
        }
        if ((mutatedFields & 1) != 0) {
            this.graphicsLayer.setScaleX(scope.getScaleX());
        }
        if ((mutatedFields & 2) != 0) {
            this.graphicsLayer.setScaleY(scope.getScaleY());
        }
        if ((mutatedFields & 4) != 0) {
            this.graphicsLayer.setAlpha(scope.getAlpha());
        }
        if ((mutatedFields & 8) != 0) {
            this.graphicsLayer.setTranslationX(scope.getTranslationX());
        }
        if ((mutatedFields & 16) != 0) {
            this.graphicsLayer.setTranslationY(scope.getTranslationY());
        }
        if ((mutatedFields & 32) != 0) {
            this.graphicsLayer.setShadowElevation(scope.getShadowElevation());
            if (scope.getShadowElevation() > 0.0f && !this.drawnWithEnabledZ && (function0 = this.invalidateParentLayer) != null) {
                function0.invoke();
            }
        }
        if ((mutatedFields & 64) != 0) {
            this.graphicsLayer.m19171setAmbientShadowColor8_81llA(scope.getAmbientShadowColor());
        }
        if ((mutatedFields & 128) != 0) {
            this.graphicsLayer.m19177setSpotShadowColor8_81llA(scope.getSpotShadowColor());
        }
        if ((mutatedFields & 1024) != 0) {
            this.graphicsLayer.setRotationZ(scope.getRotationZ());
        }
        if ((mutatedFields & 256) != 0) {
            this.graphicsLayer.setRotationX(scope.getRotationX());
        }
        if ((mutatedFields & 512) != 0) {
            this.graphicsLayer.setRotationY(scope.getRotationY());
        }
        if ((mutatedFields & 2048) != 0) {
            this.graphicsLayer.setCameraDistance(scope.getCameraDistance());
        }
        if (i != 0) {
            if (TransformOrigin.m18910equalsimpl0(this.transformOrigin, TransformOrigin.INSTANCE.m18916getCenterSzJe1aQ())) {
                this.graphicsLayer.m19174setPivotOffsetk4lQ0M(Offset.INSTANCE.m18299getUnspecifiedF1C5BW0());
            } else {
                this.graphicsLayer.m19174setPivotOffsetk4lQ0M(OffsetKt.Offset(TransformOrigin.m18911getPivotFractionXimpl(this.transformOrigin) * IntSize.m21138getWidthimpl(this.size), TransformOrigin.m18912getPivotFractionYimpl(this.transformOrigin) * IntSize.m21137getHeightimpl(this.size)));
            }
        }
        if ((mutatedFields & 16384) != 0) {
            this.graphicsLayer.setClip(scope.getClip());
        }
        if ((131072 & mutatedFields) != 0) {
            this.graphicsLayer.setRenderEffect(scope.getRenderEffect());
        }
        if ((32768 & mutatedFields) != 0) {
            GraphicsLayer graphicsLayer = this.graphicsLayer;
            int compositingStrategy = scope.getCompositingStrategy();
            CompositingStrategy.Companion companion = CompositingStrategy.INSTANCE;
            if (CompositingStrategy.m18610equalsimpl0(compositingStrategy, companion.m18614getAutoNrFUSI())) {
                iM19157getModulateAlphake2Ky5w = androidx.compose.p109ui.graphics.layer.CompositingStrategy.INSTANCE.m19156getAutoke2Ky5w();
            } else if (CompositingStrategy.m18610equalsimpl0(compositingStrategy, companion.m18616getOffscreenNrFUSI())) {
                iM19157getModulateAlphake2Ky5w = androidx.compose.p109ui.graphics.layer.CompositingStrategy.INSTANCE.m19158getOffscreenke2Ky5w();
            } else {
                if (!CompositingStrategy.m18610equalsimpl0(compositingStrategy, companion.m18615getModulateAlphaNrFUSI())) {
                    throw new IllegalStateException("Not supported composition strategy");
                }
                iM19157getModulateAlphake2Ky5w = androidx.compose.p109ui.graphics.layer.CompositingStrategy.INSTANCE.m19157getModulateAlphake2Ky5w();
            }
            graphicsLayer.m19173setCompositingStrategyWpw9cng(iM19157getModulateAlphake2Ky5w);
        }
        if (Intrinsics.areEqual(this.outline, scope.getOutline())) {
            z = false;
        } else {
            this.outline = scope.getOutline();
            updateOutline();
            z = true;
        }
        this.mutatedFields = scope.getMutatedFields();
        if (mutatedFields != 0 || z) {
            triggerRepaint();
        }
    }
}
