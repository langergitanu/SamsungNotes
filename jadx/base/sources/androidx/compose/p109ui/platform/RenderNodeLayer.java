package androidx.compose.p109ui.platform;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.p109ui.geometry.MutableRect;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.p109ui.graphics.AndroidPaint_androidKt;
import androidx.compose.p109ui.graphics.Canvas;
import androidx.compose.p109ui.graphics.CanvasHolder;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.p109ui.graphics.Fields;
import androidx.compose.p109ui.graphics.Paint;
import androidx.compose.p109ui.graphics.Path;
import androidx.compose.p109ui.graphics.RectangleShapeKt;
import androidx.compose.p109ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.p109ui.graphics.TransformOrigin;
import androidx.compose.p109ui.graphics.layer.GraphicsLayer;
import androidx.compose.p109ui.layout.GraphicLayerInfo;
import androidx.compose.p109ui.node.OwnedLayer;
import androidx.compose.p109ui.unit.IntOffset;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.runtime.internal.StabilityInferred;
import com.samsung.android.support.senl.p148nt.model.securefolder.common.SecureFolderConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 U2\u00020\u00012\u00020\u0002:\u0002UVBU\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00128\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0006\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\u0002\u0010\u0010J\u0010\u0010/\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0007H\u0002J\b\u00100\u001a\u00020\rH\u0016J\u001a\u00101\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u00102\u001a\u00020\rH\u0016J\u001a\u00103\u001a\u00020\r2\u0006\u00104\u001a\u000205H\u0016ø\u0001\u0000¢\u0006\u0004\b6\u00107J\u001a\u00108\u001a\u00020\u00142\u0006\u00109\u001a\u00020:H\u0016ø\u0001\u0000¢\u0006\u0004\b;\u0010<J\u0018\u0010=\u001a\u00020\r2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u0014H\u0016J\"\u0010A\u001a\u00020:2\u0006\u0010B\u001a\u00020:2\u0006\u0010@\u001a\u00020\u0014H\u0016ø\u0001\u0000¢\u0006\u0004\bC\u0010DJ\u001a\u0010E\u001a\u00020\r2\u0006\u00109\u001a\u00020FH\u0016ø\u0001\u0000¢\u0006\u0004\bG\u0010HJ\u001a\u0010I\u001a\u00020\r2\u0006\u0010J\u001a\u00020KH\u0016ø\u0001\u0000¢\u0006\u0004\bL\u0010HJP\u0010M\u001a\u00020\r28\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0016J\u001a\u0010N\u001a\u00020\r2\u0006\u00104\u001a\u000205H\u0016ø\u0001\u0000¢\u0006\u0004\bO\u00107J\b\u0010P\u001a\u00020\rH\u0002J\b\u0010Q\u001a\u00020\rH\u0016J\u0010\u0010R\u001a\u00020\r2\u0006\u0010S\u001a\u00020TH\u0016R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010\u0005\u001a6\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u001dR\u000e\u0010)\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010,\u001a\u00020-X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010.\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006W"}, m13886d2 = {"Landroidx/compose/ui/platform/RenderNodeLayer;", "Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/layout/GraphicLayerInfo;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "drawBlock", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/Canvas;", "Lkotlin/ParameterName;", "name", "canvas", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "parentLayer", "", "invalidateParentLayer", "Lkotlin/Function0;", "(Landroidx/compose/ui/platform/AndroidComposeView;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "drawnWithZ", "", "isDestroyed", "value", "isDirty", "setDirty", "(Z)V", "layerId", "", "getLayerId", "()J", "matrixCache", "Landroidx/compose/ui/platform/LayerMatrixCache;", "Landroidx/compose/ui/platform/DeviceRenderNode;", "mutatedFields", "", "outlineResolver", "Landroidx/compose/ui/platform/OutlineResolver;", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "ownerViewId", "getOwnerViewId", "renderNode", "softwareLayerPaint", "Landroidx/compose/ui/graphics/Paint;", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "J", "clipRenderNode", "destroy", "drawLayer", "invalidate", "inverseTransform", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "inverseTransform-58bKbWc", "([F)V", "isInLayer", "position", "Landroidx/compose/ui/geometry/Offset;", "isInLayer-k-4lQ0M", "(J)Z", "mapBounds", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "inverse", "mapOffset", "point", "mapOffset-8S9VItk", "(JZ)J", SecureFolderConstants.TEMP_FOLDER_NAME, "Landroidx/compose/ui/unit/IntOffset;", "move--gyyYBs", "(J)V", "resize", "size", "Landroidx/compose/ui/unit/IntSize;", "resize-ozmzZPI", "reuseLayer", "transform", "transform-58bKbWc", "triggerRepaint", "updateDisplayList", "updateLayerProperties", "scope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "Companion", "UniqueDrawingIdApi29", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RequiresApi(23)
@SourceDebugExtension({"SMAP\nRenderNodeLayer.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RenderNodeLayer.android.kt\nandroidx/compose/ui/platform/RenderNodeLayer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,410:1\n1#2:411\n*E\n"})
public final class RenderNodeLayer implements OwnedLayer, GraphicLayerInfo {

    @Nullable
    private Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock;
    private boolean drawnWithZ;

    @Nullable
    private Function0<Unit> invalidateParentLayer;
    private boolean isDestroyed;
    private boolean isDirty;
    private int mutatedFields;

    @NotNull
    private final AndroidComposeView ownerView;

    @NotNull
    private final DeviceRenderNode renderNode;

    @Nullable
    private Paint softwareLayerPaint;
    public static final int $stable = 8;

    @NotNull
    private static final Function2<DeviceRenderNode, Matrix, Unit> getMatrix = new Function2<DeviceRenderNode, Matrix, Unit>() { // from class: androidx.compose.ui.platform.RenderNodeLayer$Companion$getMatrix$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(DeviceRenderNode deviceRenderNode, Matrix matrix) {
            invoke2(deviceRenderNode, matrix);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull DeviceRenderNode deviceRenderNode, @NotNull Matrix matrix) {
            deviceRenderNode.getMatrix(matrix);
        }
    };

    @NotNull
    private final OutlineResolver outlineResolver = new OutlineResolver();

    @NotNull
    private final LayerMatrixCache<DeviceRenderNode> matrixCache = new LayerMatrixCache<>(getMatrix);

    @NotNull
    private final CanvasHolder canvasHolder = new CanvasHolder();
    private long transformOrigin = TransformOrigin.INSTANCE.m18916getCenterSzJe1aQ();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(29)
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m13886d2 = {"Landroidx/compose/ui/platform/RenderNodeLayer$UniqueDrawingIdApi29;", "", "()V", "getUniqueDrawingId", "", "view", "Landroid/view/View;", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class UniqueDrawingIdApi29 {

        @NotNull
        public static final UniqueDrawingIdApi29 INSTANCE = new UniqueDrawingIdApi29();

        private UniqueDrawingIdApi29() {
        }

        @JvmStatic
        @DoNotInline
        public static final long getUniqueDrawingId(@NotNull View view) {
            return view.getUniqueDrawingId();
        }
    }

    public RenderNodeLayer(@NotNull AndroidComposeView androidComposeView, @NotNull Function2<? super Canvas, ? super GraphicsLayer, Unit> function2, @NotNull Function0<Unit> function0) {
        this.ownerView = androidComposeView;
        this.drawBlock = function2;
        this.invalidateParentLayer = function0;
        DeviceRenderNode renderNodeApi29 = Build.VERSION.SDK_INT >= 29 ? new RenderNodeApi29(androidComposeView) : new RenderNodeApi23(androidComposeView);
        renderNodeApi29.setHasOverlappingRendering(true);
        renderNodeApi29.setClipToBounds(false);
        this.renderNode = renderNodeApi29;
    }

    private final void clipRenderNode(Canvas canvas) {
        if (this.renderNode.getClipToOutline() || this.renderNode.getClipToBounds()) {
            this.outlineResolver.clipToOutline(canvas);
        }
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

    @Override // androidx.compose.p109ui.node.OwnedLayer
    public void destroy() {
        if (this.renderNode.getHasDisplayList()) {
            this.renderNode.discardDisplayList();
        }
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        this.isDestroyed = true;
        setDirty(false);
        this.ownerView.requestClearInvalidObservations();
        this.ownerView.recycle$ui_release(this);
    }

    @Override // androidx.compose.p109ui.node.OwnedLayer
    public void drawLayer(@NotNull Canvas canvas, @Nullable GraphicsLayer parentLayer) {
        android.graphics.Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        if (nativeCanvas.isHardwareAccelerated()) {
            updateDisplayList();
            boolean z = this.renderNode.getElevation() > 0.0f;
            this.drawnWithZ = z;
            if (z) {
                canvas.enableZ();
            }
            this.renderNode.drawInto(nativeCanvas);
            if (this.drawnWithZ) {
                canvas.disableZ();
                return;
            }
            return;
        }
        float left = this.renderNode.getLeft();
        float top = this.renderNode.getTop();
        float right = this.renderNode.getRight();
        float bottom = this.renderNode.getBottom();
        if (this.renderNode.getAlpha() < 1.0f) {
            Paint Paint = this.softwareLayerPaint;
            if (Paint == null) {
                Paint = AndroidPaint_androidKt.Paint();
                this.softwareLayerPaint = Paint;
            }
            Paint.setAlpha(this.renderNode.getAlpha());
            nativeCanvas.saveLayer(left, top, right, bottom, Paint.getInternalPaint());
        } else {
            canvas.save();
        }
        canvas.translate(left, top);
        canvas.mo18380concat58bKbWc(this.matrixCache.m20217calculateMatrixGrdbGEg(this.renderNode));
        clipRenderNode(canvas);
        Function2<? super Canvas, ? super GraphicsLayer, Unit> function2 = this.drawBlock;
        if (function2 != null) {
            function2.invoke(canvas, null);
        }
        canvas.restore();
        setDirty(false);
    }

    @Override // androidx.compose.p109ui.layout.GraphicLayerInfo
    public long getLayerId() {
        return this.renderNode.getUniqueId();
    }

    @NotNull
    public final AndroidComposeView getOwnerView() {
        return this.ownerView;
    }

    @Override // androidx.compose.p109ui.layout.GraphicLayerInfo
    public long getOwnerViewId() {
        if (Build.VERSION.SDK_INT >= 29) {
            return UniqueDrawingIdApi29.getUniqueDrawingId(this.ownerView);
        }
        return -1L;
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
        float[] fArrM20216calculateInverseMatrixbWbORWo = this.matrixCache.m20216calculateInverseMatrixbWbORWo(this.renderNode);
        if (fArrM20216calculateInverseMatrixbWbORWo != null) {
            androidx.compose.p109ui.graphics.Matrix.m18773timesAssign58bKbWc(matrix, fArrM20216calculateInverseMatrixbWbORWo);
        }
    }

    @Override // androidx.compose.p109ui.node.OwnedLayer
    /* JADX INFO: renamed from: isInLayer-k-4lQ0M */
    public boolean mo20138isInLayerk4lQ0M(long position) {
        float fM18284getXimpl = Offset.m18284getXimpl(position);
        float fM18285getYimpl = Offset.m18285getYimpl(position);
        if (this.renderNode.getClipToBounds()) {
            return 0.0f <= fM18284getXimpl && fM18284getXimpl < ((float) this.renderNode.getWidth()) && 0.0f <= fM18285getYimpl && fM18285getYimpl < ((float) this.renderNode.getHeight());
        }
        if (this.renderNode.getClipToOutline()) {
            return this.outlineResolver.m20239isInOutlinek4lQ0M(position);
        }
        return true;
    }

    @Override // androidx.compose.p109ui.node.OwnedLayer
    public void mapBounds(@NotNull MutableRect rect, boolean inverse) {
        if (!inverse) {
            androidx.compose.p109ui.graphics.Matrix.m18764mapimpl(this.matrixCache.m20217calculateMatrixGrdbGEg(this.renderNode), rect);
            return;
        }
        float[] fArrM20216calculateInverseMatrixbWbORWo = this.matrixCache.m20216calculateInverseMatrixbWbORWo(this.renderNode);
        if (fArrM20216calculateInverseMatrixbWbORWo == null) {
            rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            androidx.compose.p109ui.graphics.Matrix.m18764mapimpl(fArrM20216calculateInverseMatrixbWbORWo, rect);
        }
    }

    @Override // androidx.compose.p109ui.node.OwnedLayer
    /* JADX INFO: renamed from: mapOffset-8S9VItk */
    public long mo20139mapOffset8S9VItk(long point, boolean inverse) {
        if (!inverse) {
            return androidx.compose.p109ui.graphics.Matrix.m18762mapMKHz9U(this.matrixCache.m20217calculateMatrixGrdbGEg(this.renderNode), point);
        }
        float[] fArrM20216calculateInverseMatrixbWbORWo = this.matrixCache.m20216calculateInverseMatrixbWbORWo(this.renderNode);
        return fArrM20216calculateInverseMatrixbWbORWo != null ? androidx.compose.p109ui.graphics.Matrix.m18762mapMKHz9U(fArrM20216calculateInverseMatrixbWbORWo, point) : Offset.INSTANCE.m18298getInfiniteF1C5BW0();
    }

    @Override // androidx.compose.p109ui.node.OwnedLayer
    /* JADX INFO: renamed from: move--gyyYBs */
    public void mo20140movegyyYBs(long position) {
        int left = this.renderNode.getLeft();
        int top = this.renderNode.getTop();
        int iM21096getXimpl = IntOffset.m21096getXimpl(position);
        int iM21097getYimpl = IntOffset.m21097getYimpl(position);
        if (left == iM21096getXimpl && top == iM21097getYimpl) {
            return;
        }
        if (left != iM21096getXimpl) {
            this.renderNode.offsetLeftAndRight(iM21096getXimpl - left);
        }
        if (top != iM21097getYimpl) {
            this.renderNode.offsetTopAndBottom(iM21097getYimpl - top);
        }
        triggerRepaint();
        this.matrixCache.invalidate();
    }

    @Override // androidx.compose.p109ui.node.OwnedLayer
    /* JADX INFO: renamed from: resize-ozmzZPI */
    public void mo20141resizeozmzZPI(long size) {
        int iM21138getWidthimpl = IntSize.m21138getWidthimpl(size);
        int iM21137getHeightimpl = IntSize.m21137getHeightimpl(size);
        this.renderNode.setPivotX(TransformOrigin.m18911getPivotFractionXimpl(this.transformOrigin) * iM21138getWidthimpl);
        this.renderNode.setPivotY(TransformOrigin.m18912getPivotFractionYimpl(this.transformOrigin) * iM21137getHeightimpl);
        DeviceRenderNode deviceRenderNode = this.renderNode;
        if (deviceRenderNode.setPosition(deviceRenderNode.getLeft(), this.renderNode.getTop(), this.renderNode.getLeft() + iM21138getWidthimpl, this.renderNode.getTop() + iM21137getHeightimpl)) {
            this.renderNode.setOutline(this.outlineResolver.getAndroidOutline());
            invalidate();
            this.matrixCache.invalidate();
        }
    }

    @Override // androidx.compose.p109ui.node.OwnedLayer
    public void reuseLayer(@NotNull Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock, @NotNull Function0<Unit> invalidateParentLayer) {
        setDirty(false);
        this.isDestroyed = false;
        this.drawnWithZ = false;
        this.transformOrigin = TransformOrigin.INSTANCE.m18916getCenterSzJe1aQ();
        this.drawBlock = drawBlock;
        this.invalidateParentLayer = invalidateParentLayer;
    }

    @Override // androidx.compose.p109ui.node.OwnedLayer
    /* JADX INFO: renamed from: transform-58bKbWc */
    public void mo20142transform58bKbWc(@NotNull float[] matrix) {
        androidx.compose.p109ui.graphics.Matrix.m18773timesAssign58bKbWc(matrix, this.matrixCache.m20217calculateMatrixGrdbGEg(this.renderNode));
    }

    @Override // androidx.compose.p109ui.node.OwnedLayer
    public void updateDisplayList() {
        if (this.isDirty || !this.renderNode.getHasDisplayList()) {
            Path clipPath = (!this.renderNode.getClipToOutline() || this.outlineResolver.getOutlineClipSupported()) ? null : this.outlineResolver.getClipPath();
            final Function2<? super Canvas, ? super GraphicsLayer, Unit> function2 = this.drawBlock;
            if (function2 != null) {
                this.renderNode.record(this.canvasHolder, clipPath, new Function1<Canvas, Unit>() { // from class: androidx.compose.ui.platform.RenderNodeLayer$updateDisplayList$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas) {
                        invoke2(canvas);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull Canvas canvas) {
                        function2.invoke(canvas, null);
                    }
                });
            }
            setDirty(false);
        }
    }

    @Override // androidx.compose.p109ui.node.OwnedLayer
    public void updateLayerProperties(@NotNull ReusableGraphicsLayerScope scope) {
        Function0<Unit> function0;
        int mutatedFields = scope.getMutatedFields() | this.mutatedFields;
        int i = mutatedFields & 4096;
        if (i != 0) {
            this.transformOrigin = scope.getTransformOrigin();
        }
        boolean z = false;
        boolean z2 = this.renderNode.getClipToOutline() && !this.outlineResolver.getOutlineClipSupported();
        if ((mutatedFields & 1) != 0) {
            this.renderNode.setScaleX(scope.getScaleX());
        }
        if ((mutatedFields & 2) != 0) {
            this.renderNode.setScaleY(scope.getScaleY());
        }
        if ((mutatedFields & 4) != 0) {
            this.renderNode.setAlpha(scope.getAlpha());
        }
        if ((mutatedFields & 8) != 0) {
            this.renderNode.setTranslationX(scope.getTranslationX());
        }
        if ((mutatedFields & 16) != 0) {
            this.renderNode.setTranslationY(scope.getTranslationY());
        }
        if ((mutatedFields & 32) != 0) {
            this.renderNode.setElevation(scope.getShadowElevation());
        }
        if ((mutatedFields & 64) != 0) {
            this.renderNode.setAmbientShadowColor(ColorKt.m18579toArgb8_81llA(scope.getAmbientShadowColor()));
        }
        if ((mutatedFields & 128) != 0) {
            this.renderNode.setSpotShadowColor(ColorKt.m18579toArgb8_81llA(scope.getSpotShadowColor()));
        }
        if ((mutatedFields & 1024) != 0) {
            this.renderNode.setRotationZ(scope.getRotationZ());
        }
        if ((mutatedFields & 256) != 0) {
            this.renderNode.setRotationX(scope.getRotationX());
        }
        if ((mutatedFields & 512) != 0) {
            this.renderNode.setRotationY(scope.getRotationY());
        }
        if ((mutatedFields & 2048) != 0) {
            this.renderNode.setCameraDistance(scope.getCameraDistance());
        }
        if (i != 0) {
            this.renderNode.setPivotX(TransformOrigin.m18911getPivotFractionXimpl(this.transformOrigin) * this.renderNode.getWidth());
            this.renderNode.setPivotY(TransformOrigin.m18912getPivotFractionYimpl(this.transformOrigin) * this.renderNode.getHeight());
        }
        boolean z3 = scope.getClip() && scope.getShape() != RectangleShapeKt.getRectangleShape();
        if ((mutatedFields & 24576) != 0) {
            this.renderNode.setClipToOutline(z3);
            this.renderNode.setClipToBounds(scope.getClip() && scope.getShape() == RectangleShapeKt.getRectangleShape());
        }
        if ((131072 & mutatedFields) != 0) {
            this.renderNode.setRenderEffect(scope.getRenderEffect());
        }
        if ((32768 & mutatedFields) != 0) {
            this.renderNode.mo20200setCompositingStrategyaDBOjCE(scope.getCompositingStrategy());
        }
        boolean zM20240updateS_szKao = this.outlineResolver.m20240updateS_szKao(scope.getOutline(), scope.getAlpha(), z3, scope.getShadowElevation(), scope.getSize());
        if (this.outlineResolver.getCacheIsDirty()) {
            this.renderNode.setOutline(this.outlineResolver.getAndroidOutline());
        }
        if (z3 && !this.outlineResolver.getOutlineClipSupported()) {
            z = true;
        }
        if (z2 != z || (z && zM20240updateS_szKao)) {
            invalidate();
        } else {
            triggerRepaint();
        }
        if (!this.drawnWithZ && this.renderNode.getElevation() > 0.0f && (function0 = this.invalidateParentLayer) != null) {
            function0.invoke();
        }
        if ((mutatedFields & Fields.MatrixAffectingFields) != 0) {
            this.matrixCache.invalidate();
        }
        this.mutatedFields = scope.getMutatedFields();
    }
}
