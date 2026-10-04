package androidx.compose.foundation;

import android.graphics.Canvas;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.widget.EdgeEffect;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AbstractC0551l;
import androidx.compose.p109ui.draw.DrawModifier;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.p109ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p109ui.graphics.drawscope.DrawContext;
import androidx.compose.p109ui.graphics.layer.GraphicsLayer;
import androidx.compose.p109ui.platform.InspectorInfo;
import androidx.compose.p109ui.platform.InspectorValueInfo;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(31)
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B.\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b¢\u0006\u0002\u0010\fJ\u001c\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H\u0002J\u001c\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H\u0002J\u001c\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H\u0002J\u001c\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H\u0002J$\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H\u0002J\b\u0010#\u001a\u00020\u0013H\u0002J\b\u0010$\u001a\u00020\u0013H\u0002J\f\u0010%\u001a\u00020\n*\u00020&H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006'"}, m13886d2 = {"Landroidx/compose/foundation/DrawStretchOverscrollModifier;", "Landroidx/compose/ui/draw/DrawModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "overscrollEffect", "Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "edgeEffectWrapper", "Landroidx/compose/foundation/EdgeEffectWrapper;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;Landroidx/compose/foundation/EdgeEffectWrapper;Lkotlin/jvm/functions/Function1;)V", "_renderNode", "Landroid/graphics/RenderNode;", "renderNode", "getRenderNode", "()Landroid/graphics/RenderNode;", "drawBottomStretch", "", "bottom", "Landroid/widget/EdgeEffect;", "canvas", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/graphics/NativeCanvas;", "drawLeftStretch", "left", "drawRightStretch", "right", "drawTopStretch", "top", "drawWithRotation", "rotationDegrees", "", "edgeEffect", "shouldDrawHorizontalStretch", "shouldDrawVerticalStretch", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAndroidOverscroll.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidOverscroll.android.kt\nandroidx/compose/foundation/DrawStretchOverscrollModifier\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 DrawScope.kt\nandroidx/compose/ui/graphics/drawscope/DrawScopeKt\n*L\n1#1,875:1\n1#2:876\n317#3,27:877\n128#3,7:904\n345#3,10:911\n*S KotlinDebug\n*F\n+ 1 AndroidOverscroll.android.kt\nandroidx/compose/foundation/DrawStretchOverscrollModifier\n*L\n253#1:877,27\n254#1:904,7\n253#1:911,10\n*E\n"})
final class DrawStretchOverscrollModifier extends InspectorValueInfo implements DrawModifier {

    @Nullable
    private RenderNode _renderNode;

    @NotNull
    private final EdgeEffectWrapper edgeEffectWrapper;

    @NotNull
    private final AndroidEdgeEffectOverscrollEffect overscrollEffect;

    public DrawStretchOverscrollModifier(@NotNull AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, @NotNull EdgeEffectWrapper edgeEffectWrapper, @NotNull Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        this.overscrollEffect = androidEdgeEffectOverscrollEffect;
        this.edgeEffectWrapper = edgeEffectWrapper;
    }

    private final boolean drawBottomStretch(EdgeEffect bottom, Canvas canvas) {
        return drawWithRotation(180.0f, bottom, canvas);
    }

    private final boolean drawLeftStretch(EdgeEffect left, Canvas canvas) {
        return drawWithRotation(270.0f, left, canvas);
    }

    private final boolean drawRightStretch(EdgeEffect right, Canvas canvas) {
        return drawWithRotation(90.0f, right, canvas);
    }

    private final boolean drawTopStretch(EdgeEffect top, Canvas canvas) {
        return drawWithRotation(0.0f, top, canvas);
    }

    private final boolean drawWithRotation(float rotationDegrees, EdgeEffect edgeEffect, Canvas canvas) {
        if (rotationDegrees == 0.0f) {
            return edgeEffect.draw(canvas);
        }
        int iSave = canvas.save();
        canvas.rotate(rotationDegrees);
        boolean zDraw = edgeEffect.draw(canvas);
        canvas.restoreToCount(iSave);
        return zDraw;
    }

    private final RenderNode getRenderNode() {
        RenderNode renderNode = this._renderNode;
        if (renderNode != null) {
            return renderNode;
        }
        RenderNode renderNodeM825g = AbstractC0551l.m825g();
        this._renderNode = renderNodeM825g;
        return renderNodeM825g;
    }

    private final boolean shouldDrawHorizontalStretch() {
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        return edgeEffectWrapper.isLeftAnimating() || edgeEffectWrapper.isLeftNegationStretched() || edgeEffectWrapper.isRightAnimating() || edgeEffectWrapper.isRightNegationStretched();
    }

    private final boolean shouldDrawVerticalStretch() {
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        return edgeEffectWrapper.isTopAnimating() || edgeEffectWrapper.isTopNegationStretched() || edgeEffectWrapper.isBottomAnimating() || edgeEffectWrapper.isBottomNegationStretched();
    }

    @Override // androidx.compose.p109ui.draw.DrawModifier
    public void draw(@NotNull ContentDrawScope contentDrawScope) {
        boolean zDrawLeftStretch;
        float f;
        float f4;
        this.overscrollEffect.m15393updateSizeuvyYCjk$foundation_release(contentDrawScope.mo19076getSizeNHjbRc());
        if (Size.m18355isEmptyimpl(contentDrawScope.mo19076getSizeNHjbRc())) {
            contentDrawScope.drawContent();
            return;
        }
        this.overscrollEffect.getRedrawSignal$foundation_release().getValue();
        float fMo15546toPx0680j_4 = contentDrawScope.mo15546toPx0680j_4(ClipScrollableContainerKt.getMaxSupportedElevation());
        Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(contentDrawScope.getDrawContext().getCanvas());
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        boolean zShouldDrawVerticalStretch = shouldDrawVerticalStretch();
        boolean zShouldDrawHorizontalStretch = shouldDrawHorizontalStretch();
        if (zShouldDrawVerticalStretch && zShouldDrawHorizontalStretch) {
            getRenderNode().setPosition(0, 0, nativeCanvas.getWidth(), nativeCanvas.getHeight());
        } else if (zShouldDrawVerticalStretch) {
            getRenderNode().setPosition(0, 0, (MathKt.roundToInt(fMo15546toPx0680j_4) * 2) + nativeCanvas.getWidth(), nativeCanvas.getHeight());
        } else {
            if (!zShouldDrawHorizontalStretch) {
                contentDrawScope.drawContent();
                return;
            }
            getRenderNode().setPosition(0, 0, nativeCanvas.getWidth(), (MathKt.roundToInt(fMo15546toPx0680j_4) * 2) + nativeCanvas.getHeight());
        }
        RecordingCanvas recordingCanvasBeginRecording = getRenderNode().beginRecording();
        if (edgeEffectWrapper.isLeftNegationStretched()) {
            EdgeEffect orCreateLeftEffectNegation = edgeEffectWrapper.getOrCreateLeftEffectNegation();
            drawRightStretch(orCreateLeftEffectNegation, recordingCanvasBeginRecording);
            orCreateLeftEffectNegation.finish();
        }
        if (edgeEffectWrapper.isLeftAnimating()) {
            EdgeEffect orCreateLeftEffect = edgeEffectWrapper.getOrCreateLeftEffect();
            zDrawLeftStretch = drawLeftStretch(orCreateLeftEffect, recordingCanvasBeginRecording);
            if (edgeEffectWrapper.isLeftStretched()) {
                float fM18285getYimpl = Offset.m18285getYimpl(this.overscrollEffect.m15392displacementF1C5BW0$foundation_release());
                EdgeEffectCompat edgeEffectCompat = EdgeEffectCompat.INSTANCE;
                edgeEffectCompat.onPullDistanceCompat(edgeEffectWrapper.getOrCreateLeftEffectNegation(), edgeEffectCompat.getDistanceCompat(orCreateLeftEffect), 1 - fM18285getYimpl);
            }
        } else {
            zDrawLeftStretch = false;
        }
        if (edgeEffectWrapper.isTopNegationStretched()) {
            EdgeEffect orCreateTopEffectNegation = edgeEffectWrapper.getOrCreateTopEffectNegation();
            drawBottomStretch(orCreateTopEffectNegation, recordingCanvasBeginRecording);
            orCreateTopEffectNegation.finish();
        }
        if (edgeEffectWrapper.isTopAnimating()) {
            EdgeEffect orCreateTopEffect = edgeEffectWrapper.getOrCreateTopEffect();
            zDrawLeftStretch = drawTopStretch(orCreateTopEffect, recordingCanvasBeginRecording) || zDrawLeftStretch;
            if (edgeEffectWrapper.isTopStretched()) {
                float fM18284getXimpl = Offset.m18284getXimpl(this.overscrollEffect.m15392displacementF1C5BW0$foundation_release());
                EdgeEffectCompat edgeEffectCompat2 = EdgeEffectCompat.INSTANCE;
                edgeEffectCompat2.onPullDistanceCompat(edgeEffectWrapper.getOrCreateTopEffectNegation(), edgeEffectCompat2.getDistanceCompat(orCreateTopEffect), fM18284getXimpl);
            }
        }
        if (edgeEffectWrapper.isRightNegationStretched()) {
            EdgeEffect orCreateRightEffectNegation = edgeEffectWrapper.getOrCreateRightEffectNegation();
            drawLeftStretch(orCreateRightEffectNegation, recordingCanvasBeginRecording);
            orCreateRightEffectNegation.finish();
        }
        if (edgeEffectWrapper.isRightAnimating()) {
            EdgeEffect orCreateRightEffect = edgeEffectWrapper.getOrCreateRightEffect();
            zDrawLeftStretch = drawRightStretch(orCreateRightEffect, recordingCanvasBeginRecording) || zDrawLeftStretch;
            if (edgeEffectWrapper.isRightStretched()) {
                float fM18285getYimpl2 = Offset.m18285getYimpl(this.overscrollEffect.m15392displacementF1C5BW0$foundation_release());
                EdgeEffectCompat edgeEffectCompat3 = EdgeEffectCompat.INSTANCE;
                edgeEffectCompat3.onPullDistanceCompat(edgeEffectWrapper.getOrCreateRightEffectNegation(), edgeEffectCompat3.getDistanceCompat(orCreateRightEffect), fM18285getYimpl2);
            }
        }
        if (edgeEffectWrapper.isBottomNegationStretched()) {
            EdgeEffect orCreateBottomEffectNegation = edgeEffectWrapper.getOrCreateBottomEffectNegation();
            drawTopStretch(orCreateBottomEffectNegation, recordingCanvasBeginRecording);
            orCreateBottomEffectNegation.finish();
        }
        if (edgeEffectWrapper.isBottomAnimating()) {
            EdgeEffect orCreateBottomEffect = edgeEffectWrapper.getOrCreateBottomEffect();
            boolean z = drawBottomStretch(orCreateBottomEffect, recordingCanvasBeginRecording) || zDrawLeftStretch;
            if (edgeEffectWrapper.isBottomStretched()) {
                float fM18284getXimpl2 = Offset.m18284getXimpl(this.overscrollEffect.m15392displacementF1C5BW0$foundation_release());
                EdgeEffectCompat edgeEffectCompat4 = EdgeEffectCompat.INSTANCE;
                edgeEffectCompat4.onPullDistanceCompat(edgeEffectWrapper.getOrCreateBottomEffectNegation(), edgeEffectCompat4.getDistanceCompat(orCreateBottomEffect), 1 - fM18284getXimpl2);
            }
            zDrawLeftStretch = z;
        }
        if (zDrawLeftStretch) {
            this.overscrollEffect.invalidateOverscroll$foundation_release();
        }
        float f5 = zShouldDrawHorizontalStretch ? 0.0f : fMo15546toPx0680j_4;
        if (zShouldDrawVerticalStretch) {
            fMo15546toPx0680j_4 = 0.0f;
        }
        LayoutDirection layoutDirection = contentDrawScope.getLayoutDirection();
        androidx.compose.p109ui.graphics.Canvas Canvas = AndroidCanvas_androidKt.Canvas(recordingCanvasBeginRecording);
        long jMo19076getSizeNHjbRc = contentDrawScope.mo19076getSizeNHjbRc();
        Density density = contentDrawScope.getDrawContext().getDensity();
        LayoutDirection layoutDirection2 = contentDrawScope.getDrawContext().getLayoutDirection();
        androidx.compose.p109ui.graphics.Canvas canvas = contentDrawScope.getDrawContext().getCanvas();
        long jMo18997getSizeNHjbRc = contentDrawScope.getDrawContext().mo18997getSizeNHjbRc();
        GraphicsLayer graphicsLayer = contentDrawScope.getDrawContext().getGraphicsLayer();
        DrawContext drawContext = contentDrawScope.getDrawContext();
        drawContext.setDensity(contentDrawScope);
        drawContext.setLayoutDirection(layoutDirection);
        drawContext.setCanvas(Canvas);
        drawContext.mo18998setSizeuvyYCjk(jMo19076getSizeNHjbRc);
        drawContext.setGraphicsLayer(null);
        Canvas.save();
        try {
            contentDrawScope.getDrawContext().getTransform().translate(f5, fMo15546toPx0680j_4);
            try {
                contentDrawScope.drawContent();
                Canvas.restore();
                DrawContext drawContext2 = contentDrawScope.getDrawContext();
                drawContext2.setDensity(density);
                drawContext2.setLayoutDirection(layoutDirection2);
                drawContext2.setCanvas(canvas);
                drawContext2.mo18998setSizeuvyYCjk(jMo18997getSizeNHjbRc);
                drawContext2.setGraphicsLayer(graphicsLayer);
                getRenderNode().endRecording();
                int iSave = nativeCanvas.save();
                nativeCanvas.translate(f, f4);
                nativeCanvas.drawRenderNode(getRenderNode());
                nativeCanvas.restoreToCount(iSave);
            } finally {
                contentDrawScope.getDrawContext().getTransform().translate(-f5, -fMo15546toPx0680j_4);
            }
        } catch (Throwable th) {
            Canvas.restore();
            DrawContext drawContext3 = contentDrawScope.getDrawContext();
            drawContext3.setDensity(density);
            drawContext3.setLayoutDirection(layoutDirection2);
            drawContext3.setCanvas(canvas);
            drawContext3.mo18998setSizeuvyYCjk(jMo18997getSizeNHjbRc);
            drawContext3.setGraphicsLayer(graphicsLayer);
            throw th;
        }
    }
}
