package androidx.compose.p109ui.platform;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.os.Build;
import android.view.DisplayListCanvas;
import android.view.RenderNode;
import androidx.annotation.RequiresApi;
import androidx.compose.p109ui.graphics.AndroidCanvas;
import androidx.compose.p109ui.graphics.CanvasHolder;
import androidx.compose.p109ui.graphics.CompositingStrategy;
import androidx.compose.p109ui.graphics.Path;
import androidx.compose.p109ui.graphics.RenderEffect;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.support.senl.p148nt.coedit.connection.grpc.service.coedit.method.CoeditGrpcMethod;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \u0086\u00012\u00020\u0001:\u0002\u0086\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010e\u001a\u00020fH\u0016J\b\u0010g\u001a\u00020fH\u0002J\u0010\u0010h\u001a\u00020f2\u0006\u0010i\u001a\u00020jH\u0016J\b\u0010k\u001a\u00020lH\u0016J\u0010\u0010m\u001a\u00020f2\u0006\u0010n\u001a\u00020oH\u0016J\r\u0010p\u001a\u00020\fH\u0000¢\u0006\u0002\bqJ\u0010\u0010r\u001a\u00020f2\u0006\u0010n\u001a\u00020oH\u0016J\r\u0010s\u001a\u00020\u0018H\u0000¢\u0006\u0002\btJ\u0010\u0010u\u001a\u00020f2\u0006\u0010v\u001a\u00020\fH\u0016J\u0010\u0010w\u001a\u00020f2\u0006\u0010v\u001a\u00020\fH\u0016J.\u0010x\u001a\u00020f2\u0006\u0010y\u001a\u00020z2\b\u0010{\u001a\u0004\u0018\u00010|2\u0012\u0010}\u001a\u000e\u0012\u0004\u0012\u00020\u007f\u0012\u0004\u0012\u00020f0~H\u0016J\u0011\u0010\u0080\u0001\u001a\u00020\u00182\u0006\u0010s\u001a\u00020\u0018H\u0016J\u0015\u0010\u0081\u0001\u001a\u00020f2\n\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u0001H\u0016J)\u0010\u0084\u0001\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\f2\u0006\u0010V\u001a\u00020\f2\u0006\u0010A\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0016J\u0011\u0010\u0085\u0001\u001a\u00020f2\u0006\u0010?\u001a\u00020@H\u0002R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R$\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0018@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00188V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR*\u0010\"\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020!8V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b#\u0010\u000f\"\u0004\b$\u0010\u0011R$\u0010%\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b&\u0010\t\"\u0004\b'\u0010\u000bR\u0014\u0010(\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u001bR\u0014\u0010*\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u000fR\u0016\u0010,\u001a\u00020!X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010-R\u001a\u0010.\u001a\u00020\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u000f\"\u0004\b0\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R$\u00103\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b4\u0010\t\"\u0004\b5\u0010\u000bR$\u00106\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b7\u0010\t\"\u0004\b8\u0010\u000bR\u001c\u00109\u001a\u0004\u0018\u00010:X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u000e\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010A\u001a\u00020\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u000f\"\u0004\bC\u0010\u0011R$\u0010D\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bE\u0010\t\"\u0004\bF\u0010\u000bR$\u0010G\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bH\u0010\t\"\u0004\bI\u0010\u000bR$\u0010J\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bK\u0010\t\"\u0004\bL\u0010\u000bR$\u0010M\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bN\u0010\t\"\u0004\bO\u0010\u000bR$\u0010P\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bQ\u0010\t\"\u0004\bR\u0010\u000bR$\u0010S\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bT\u0010\u000f\"\u0004\bU\u0010\u0011R\u001a\u0010V\u001a\u00020\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u000f\"\u0004\bX\u0010\u0011R$\u0010Y\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bZ\u0010\t\"\u0004\b[\u0010\u000bR$\u0010\\\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b]\u0010\t\"\u0004\b^\u0010\u000bR\u0014\u0010_\u001a\u00020`8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\ba\u0010bR\u0014\u0010c\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bd\u0010\u000f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0087\u0001"}, m13886d2 = {"Landroidx/compose/ui/platform/RenderNodeApi23;", "Landroidx/compose/ui/platform/DeviceRenderNode;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "value", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "", "ambientShadowColor", "getAmbientShadowColor", "()I", "setAmbientShadowColor", "(I)V", "bottom", "getBottom", "setBottom", "cameraDistance", "getCameraDistance", "setCameraDistance", "", "clipToBounds", "getClipToBounds", "()Z", "setClipToBounds", "(Z)V", "clipToOutline", "getClipToOutline", "setClipToOutline", "Landroidx/compose/ui/graphics/CompositingStrategy;", "compositingStrategy", "getCompositingStrategy--NrFUSI", "setCompositingStrategy-aDBOjCE", "elevation", "getElevation", "setElevation", "hasDisplayList", "getHasDisplayList", "height", "getHeight", "internalCompositingStrategy", "I", "left", "getLeft", "setLeft", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "pivotX", "getPivotX", "setPivotX", "pivotY", "getPivotY", "setPivotY", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "renderNode", "Landroid/view/RenderNode;", "right", "getRight", "setRight", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "spotShadowColor", "getSpotShadowColor", "setSpotShadowColor", "top", "getTop", "setTop", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "uniqueId", "", "getUniqueId", "()J", "width", "getWidth", "discardDisplayList", "", "discardDisplayListInternal", "drawInto", "canvas", "Landroid/graphics/Canvas;", "dumpRenderNodeData", "Landroidx/compose/ui/platform/DeviceRenderNodeData;", "getInverseMatrix", "matrix", "Landroid/graphics/Matrix;", "getLayerType", "getLayerType$ui_release", "getMatrix", "hasOverlappingRendering", "hasOverlappingRendering$ui_release", "offsetLeftAndRight", TypedValues.Cycle.S_WAVE_OFFSET, "offsetTopAndBottom", "record", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "clipPath", "Landroidx/compose/ui/graphics/Path;", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "setHasOverlappingRendering", "setOutline", "outline", "Landroid/graphics/Outline;", "setPosition", "verifyShadowColorProperties", "Companion", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RequiresApi(23)
@SourceDebugExtension({"SMAP\nRenderNodeApi23.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RenderNodeApi23.android.kt\nandroidx/compose/ui/platform/RenderNodeApi23\n+ 2 AndroidCanvas.android.kt\nandroidx/compose/ui/graphics/CanvasHolder\n*L\n1#1,417:1\n47#2,5:418\n*S KotlinDebug\n*F\n+ 1 RenderNodeApi23.android.kt\nandroidx/compose/ui/platform/RenderNodeApi23\n*L\n275#1:418,5\n*E\n"})
public final class RenderNodeApi23 implements DeviceRenderNode {
    private static boolean testFailCreateRenderNode;
    private int bottom;
    private boolean clipToBounds;
    private int internalCompositingStrategy;
    private int left;

    @NotNull
    private final AndroidComposeView ownerView;

    @Nullable
    private RenderEffect renderEffect;

    @NotNull
    private final RenderNode renderNode;
    private int right;
    private int top;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static boolean needToValidateAccess = true;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, m13886d2 = {"Landroidx/compose/ui/platform/RenderNodeApi23$Companion;", "", "()V", "needToValidateAccess", "", "testFailCreateRenderNode", "getTestFailCreateRenderNode$ui_release", "()Z", "setTestFailCreateRenderNode$ui_release", "(Z)V", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean getTestFailCreateRenderNode$ui_release() {
            return RenderNodeApi23.testFailCreateRenderNode;
        }

        public final void setTestFailCreateRenderNode$ui_release(boolean z) {
            RenderNodeApi23.testFailCreateRenderNode = z;
        }

        private Companion() {
        }
    }

    public RenderNodeApi23(@NotNull AndroidComposeView androidComposeView) {
        this.ownerView = androidComposeView;
        RenderNode renderNodeCreate = RenderNode.create(CoeditGrpcMethod.Caller.Compose, androidComposeView);
        this.renderNode = renderNodeCreate;
        this.internalCompositingStrategy = CompositingStrategy.INSTANCE.m18614getAutoNrFUSI();
        if (needToValidateAccess) {
            renderNodeCreate.setScaleX(renderNodeCreate.getScaleX());
            renderNodeCreate.setScaleY(renderNodeCreate.getScaleY());
            renderNodeCreate.setTranslationX(renderNodeCreate.getTranslationX());
            renderNodeCreate.setTranslationY(renderNodeCreate.getTranslationY());
            renderNodeCreate.setElevation(renderNodeCreate.getElevation());
            renderNodeCreate.setRotation(renderNodeCreate.getRotation());
            renderNodeCreate.setRotationX(renderNodeCreate.getRotationX());
            renderNodeCreate.setRotationY(renderNodeCreate.getRotationY());
            renderNodeCreate.setCameraDistance(renderNodeCreate.getCameraDistance());
            renderNodeCreate.setPivotX(renderNodeCreate.getPivotX());
            renderNodeCreate.setPivotY(renderNodeCreate.getPivotY());
            renderNodeCreate.setClipToOutline(renderNodeCreate.getClipToOutline());
            renderNodeCreate.setClipToBounds(false);
            renderNodeCreate.setAlpha(renderNodeCreate.getAlpha());
            renderNodeCreate.isValid();
            renderNodeCreate.setLeftTopRightBottom(0, 0, 0, 0);
            renderNodeCreate.offsetLeftAndRight(0);
            renderNodeCreate.offsetTopAndBottom(0);
            verifyShadowColorProperties(renderNodeCreate);
            discardDisplayListInternal();
            renderNodeCreate.setLayerType(0);
            renderNodeCreate.setHasOverlappingRendering(renderNodeCreate.hasOverlappingRendering());
            needToValidateAccess = false;
        }
        if (testFailCreateRenderNode) {
            throw new NoClassDefFoundError();
        }
    }

    private final void discardDisplayListInternal() {
        RenderNodeVerificationHelper24.INSTANCE.discardDisplayList(this.renderNode);
    }

    private final void verifyShadowColorProperties(RenderNode renderNode) {
        if (Build.VERSION.SDK_INT >= 28) {
            RenderNodeVerificationHelper28 renderNodeVerificationHelper28 = RenderNodeVerificationHelper28.INSTANCE;
            renderNodeVerificationHelper28.setAmbientShadowColor(renderNode, renderNodeVerificationHelper28.getAmbientShadowColor(renderNode));
            renderNodeVerificationHelper28.setSpotShadowColor(renderNode, renderNodeVerificationHelper28.getSpotShadowColor(renderNode));
        }
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public void discardDisplayList() {
        discardDisplayListInternal();
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public void drawInto(@NotNull Canvas canvas) {
        Intrinsics.checkNotNull(canvas, "null cannot be cast to non-null type android.view.DisplayListCanvas");
        ((DisplayListCanvas) canvas).drawRenderNode(this.renderNode);
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    @NotNull
    public DeviceRenderNodeData dumpRenderNodeData() {
        return new DeviceRenderNodeData(0L, 0, 0, 0, 0, 0, 0, this.renderNode.getScaleX(), this.renderNode.getScaleY(), this.renderNode.getTranslationX(), this.renderNode.getTranslationY(), this.renderNode.getElevation(), getAmbientShadowColor(), getSpotShadowColor(), this.renderNode.getRotation(), this.renderNode.getRotationX(), this.renderNode.getRotationY(), this.renderNode.getCameraDistance(), this.renderNode.getPivotX(), this.renderNode.getPivotY(), this.renderNode.getClipToOutline(), getClipToBounds(), this.renderNode.getAlpha(), getRenderEffect(), this.internalCompositingStrategy, null);
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public float getAlpha() {
        return this.renderNode.getAlpha();
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public int getAmbientShadowColor() {
        if (Build.VERSION.SDK_INT >= 28) {
            return RenderNodeVerificationHelper28.INSTANCE.getAmbientShadowColor(this.renderNode);
        }
        return -16777216;
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public int getBottom() {
        return this.bottom;
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public float getCameraDistance() {
        return -this.renderNode.getCameraDistance();
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public boolean getClipToBounds() {
        return this.clipToBounds;
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public boolean getClipToOutline() {
        return this.renderNode.getClipToOutline();
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    /* JADX INFO: renamed from: getCompositingStrategy--NrFUSI, reason: from getter */
    public int getInternalCompositingStrategy() {
        return this.internalCompositingStrategy;
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public float getElevation() {
        return this.renderNode.getElevation();
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public boolean getHasDisplayList() {
        return this.renderNode.isValid();
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public int getHeight() {
        return getBottom() - getTop();
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public void getInverseMatrix(@NotNull Matrix matrix) {
        this.renderNode.getInverseMatrix(matrix);
    }

    public final int getLayerType$ui_release() {
        return CompositingStrategy.m18610equalsimpl0(this.internalCompositingStrategy, CompositingStrategy.INSTANCE.m18616getOffscreenNrFUSI()) ? 2 : 0;
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public int getLeft() {
        return this.left;
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public void getMatrix(@NotNull Matrix matrix) {
        this.renderNode.getMatrix(matrix);
    }

    @NotNull
    public final AndroidComposeView getOwnerView() {
        return this.ownerView;
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public float getPivotX() {
        return this.renderNode.getPivotX();
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public float getPivotY() {
        return this.renderNode.getPivotY();
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    @Nullable
    public RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public int getRight() {
        return this.right;
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public float getRotationX() {
        return this.renderNode.getRotationX();
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public float getRotationY() {
        return this.renderNode.getRotationY();
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public float getRotationZ() {
        return this.renderNode.getRotation();
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public float getScaleX() {
        return this.renderNode.getScaleX();
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public float getScaleY() {
        return this.renderNode.getScaleY();
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public int getSpotShadowColor() {
        if (Build.VERSION.SDK_INT >= 28) {
            return RenderNodeVerificationHelper28.INSTANCE.getSpotShadowColor(this.renderNode);
        }
        return -16777216;
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public int getTop() {
        return this.top;
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public float getTranslationX() {
        return this.renderNode.getTranslationX();
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public float getTranslationY() {
        return this.renderNode.getTranslationY();
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public long getUniqueId() {
        return 0L;
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public int getWidth() {
        return getRight() - getLeft();
    }

    public final boolean hasOverlappingRendering$ui_release() {
        return this.renderNode.hasOverlappingRendering();
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public void offsetLeftAndRight(int offset) {
        setLeft(getLeft() + offset);
        setRight(getRight() + offset);
        this.renderNode.offsetLeftAndRight(offset);
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public void offsetTopAndBottom(int offset) {
        setTop(getTop() + offset);
        setBottom(getBottom() + offset);
        this.renderNode.offsetTopAndBottom(offset);
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public void record(@NotNull CanvasHolder canvasHolder, @Nullable Path clipPath, @NotNull Function1<? super androidx.compose.p109ui.graphics.Canvas, Unit> drawBlock) {
        DisplayListCanvas displayListCanvasStart = this.renderNode.start(getWidth(), getHeight());
        Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
        canvasHolder.getAndroidCanvas().setInternalCanvas((Canvas) displayListCanvasStart);
        AndroidCanvas androidCanvas = canvasHolder.getAndroidCanvas();
        if (clipPath != null) {
            androidCanvas.save();
            androidx.compose.p109ui.graphics.Canvas.m18496clipPathmtrdDE$default(androidCanvas, clipPath, 0, 2, null);
        }
        drawBlock.invoke(androidCanvas);
        if (clipPath != null) {
            androidCanvas.restore();
        }
        canvasHolder.getAndroidCanvas().setInternalCanvas(internalCanvas);
        this.renderNode.end(displayListCanvasStart);
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public void setAlpha(float f) {
        this.renderNode.setAlpha(f);
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public void setAmbientShadowColor(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            RenderNodeVerificationHelper28.INSTANCE.setAmbientShadowColor(this.renderNode, i);
        }
    }

    public void setBottom(int i) {
        this.bottom = i;
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public void setCameraDistance(float f) {
        this.renderNode.setCameraDistance(-f);
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public void setClipToBounds(boolean z) {
        this.clipToBounds = z;
        this.renderNode.setClipToBounds(z);
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public void setClipToOutline(boolean z) {
        this.renderNode.setClipToOutline(z);
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    /* JADX INFO: renamed from: setCompositingStrategy-aDBOjCE */
    public void mo20200setCompositingStrategyaDBOjCE(int i) {
        CompositingStrategy.Companion companion = CompositingStrategy.INSTANCE;
        if (CompositingStrategy.m18610equalsimpl0(i, companion.m18616getOffscreenNrFUSI())) {
            this.renderNode.setLayerType(2);
            this.renderNode.setHasOverlappingRendering(true);
        } else if (CompositingStrategy.m18610equalsimpl0(i, companion.m18615getModulateAlphaNrFUSI())) {
            this.renderNode.setLayerType(0);
            this.renderNode.setHasOverlappingRendering(false);
        } else {
            this.renderNode.setLayerType(0);
            this.renderNode.setHasOverlappingRendering(true);
        }
        this.internalCompositingStrategy = i;
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public void setElevation(float f) {
        this.renderNode.setElevation(f);
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public boolean setHasOverlappingRendering(boolean hasOverlappingRendering) {
        return this.renderNode.setHasOverlappingRendering(hasOverlappingRendering);
    }

    public void setLeft(int i) {
        this.left = i;
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public void setOutline(@Nullable Outline outline) {
        this.renderNode.setOutline(outline);
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public void setPivotX(float f) {
        this.renderNode.setPivotX(f);
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public void setPivotY(float f) {
        this.renderNode.setPivotY(f);
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public boolean setPosition(int left, int top, int right, int bottom) {
        setLeft(left);
        setTop(top);
        setRight(right);
        setBottom(bottom);
        return this.renderNode.setLeftTopRightBottom(left, top, right, bottom);
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public void setRenderEffect(@Nullable RenderEffect renderEffect) {
        this.renderEffect = renderEffect;
    }

    public void setRight(int i) {
        this.right = i;
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public void setRotationX(float f) {
        this.renderNode.setRotationX(f);
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public void setRotationY(float f) {
        this.renderNode.setRotationY(f);
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public void setRotationZ(float f) {
        this.renderNode.setRotation(f);
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public void setScaleX(float f) {
        this.renderNode.setScaleX(f);
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public void setScaleY(float f) {
        this.renderNode.setScaleY(f);
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public void setSpotShadowColor(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            RenderNodeVerificationHelper28.INSTANCE.setSpotShadowColor(this.renderNode, i);
        }
    }

    public void setTop(int i) {
        this.top = i;
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public void setTranslationX(float f) {
        this.renderNode.setTranslationX(f);
    }

    @Override // androidx.compose.p109ui.platform.DeviceRenderNode
    public void setTranslationY(float f) {
        this.renderNode.setTranslationY(f);
    }
}
