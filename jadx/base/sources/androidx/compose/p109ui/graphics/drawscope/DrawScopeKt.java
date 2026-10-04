package androidx.compose.p109ui.graphics.drawscope;

import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.graphics.Canvas;
import androidx.compose.p109ui.graphics.ClipOp;
import androidx.compose.p109ui.graphics.DegreesKt;
import androidx.compose.p109ui.graphics.Path;
import androidx.compose.p109ui.graphics.layer.GraphicsLayer;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.LayoutDirection;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aB\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001ab\u0010\f\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001aP\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\\\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a!\u0010#\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\bH\u0086\b\u001a.\u0010$\u001a\u00020\u0001*\u00020\u00022\u0006\u0010$\u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\b\u001a:\u0010$\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u000e2\b\b\u0002\u0010&\u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\b\u001aF\u0010$\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\b\u001aB\u0010'\u001a\u00020\u0001*\u00020\u00022\u0006\u0010(\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020*2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001aB\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010.\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020*2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000¢\u0006\u0004\b/\u0010,\u001aB\u00100\u001a\u00020\u0001*\u00020\u00022\u0006\u00100\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020*2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000¢\u0006\u0004\b1\u0010,\u001aJ\u00100\u001a\u00020\u0001*\u00020\u00022\u0006\u00102\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020*2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\bø\u0001\u0000¢\u0006\u0004\b4\u00105\u001a:\u00106\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\b\u001a?\u00107\u001a\u00020\u0001*\u00020\u00022\u0017\u00108\u001a\u0013\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\t2\u0017\u0010:\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\u0086\b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006;"}, m13886d2 = {"clipPath", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "path", "Landroidx/compose/ui/graphics/Path;", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "clipPath-KD09W0M", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;ILkotlin/jvm/functions/Function1;)V", "clipRect", "left", "", "top", "right", "bottom", "clipRect-rOu3jXo", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFFILkotlin/jvm/functions/Function1;)V", "draw", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "size", "Landroidx/compose/ui/geometry/Size;", "draw-GRGpd60", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;JLkotlin/jvm/functions/Function1;)V", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "draw-ymL40Pk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/layer/GraphicsLayer;Lkotlin/jvm/functions/Function1;)V", "drawIntoCanvas", "inset", "horizontal", "vertical", "rotate", "degrees", "pivot", "Landroidx/compose/ui/geometry/Offset;", "rotate-Rg1IO4c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FJLkotlin/jvm/functions/Function1;)V", "rotateRad", "radians", "rotateRad-Rg1IO4c", WiggleAnimationConfig.KEY_SCALE, "scale-Rg1IO4c", "scaleX", "scaleY", "scale-Fgt4K4Q", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLkotlin/jvm/functions/Function1;)V", "translate", "withTransform", "transformBlock", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "drawBlock", "ui-graphics_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nDrawScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DrawScope.kt\nandroidx/compose/ui/graphics/drawscope/DrawScopeKt\n*L\n1#1,1062:1\n68#1,7:1063\n272#1,14:1070\n272#1,14:1084\n272#1,14:1098\n272#1,14:1112\n272#1,14:1126\n272#1,14:1140\n329#1,26:1154\n*S KotlinDebug\n*F\n+ 1 DrawScope.kt\nandroidx/compose/ui/graphics/drawscope/DrawScopeKt\n*L\n112#1:1063,7\n151#1:1070,14\n168#1:1084,14\n189#1:1098,14\n206#1:1112,14\n232#1:1126,14\n248#1:1140,14\n298#1:1154,26\n*E\n"})
public final class DrawScopeKt {
    /* JADX INFO: renamed from: clipPath-KD09W0M, reason: not valid java name */
    public static final void m19116clipPathKD09W0M(@NotNull DrawScope drawScope, @NotNull Path path, int i, @NotNull Function1<? super DrawScope, Unit> function1) {
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo18997getSizeNHjbRc = drawContext.mo18997getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo18999clipPathmtrdDE(path, i);
            function1.invoke(drawScope);
        } finally {
            AbstractC1974b.m1329v(1, drawContext, jMo18997getSizeNHjbRc, 1);
        }
    }

    /* JADX INFO: renamed from: clipPath-KD09W0M$default, reason: not valid java name */
    public static /* synthetic */ void m19117clipPathKD09W0M$default(DrawScope drawScope, Path path, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = ClipOp.INSTANCE.m18514getIntersectrtfAjoo();
        }
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo18997getSizeNHjbRc = drawContext.mo18997getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo18999clipPathmtrdDE(path, i);
            function1.invoke(drawScope);
        } finally {
            AbstractC1974b.m1329v(1, drawContext, jMo18997getSizeNHjbRc, 1);
        }
    }

    /* JADX INFO: renamed from: clipRect-rOu3jXo, reason: not valid java name */
    public static final void m19118clipRectrOu3jXo(@NotNull DrawScope drawScope, float f, float f4, float f5, float f6, int i, @NotNull Function1<? super DrawScope, Unit> function1) {
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo18997getSizeNHjbRc = drawContext.mo18997getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo19000clipRectN_I0leg(f, f4, f5, f6, i);
            function1.invoke(drawScope);
        } finally {
            AbstractC1974b.m1329v(1, drawContext, jMo18997getSizeNHjbRc, 1);
        }
    }

    /* JADX INFO: renamed from: clipRect-rOu3jXo$default, reason: not valid java name */
    public static /* synthetic */ void m19119clipRectrOu3jXo$default(DrawScope drawScope, float f, float f4, float f5, float f6, int i, Function1 function1, int i2, Object obj) {
        float f7 = (i2 & 1) != 0 ? 0.0f : f;
        float f8 = (i2 & 2) != 0 ? 0.0f : f4;
        if ((i2 & 4) != 0) {
            f5 = Size.m18353getWidthimpl(drawScope.mo19076getSizeNHjbRc());
        }
        float f9 = f5;
        if ((i2 & 8) != 0) {
            f6 = Size.m18350getHeightimpl(drawScope.mo19076getSizeNHjbRc());
        }
        float f10 = f6;
        if ((i2 & 16) != 0) {
            i = ClipOp.INSTANCE.m18514getIntersectrtfAjoo();
        }
        int i4 = i;
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo18997getSizeNHjbRc = drawContext.mo18997getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo19000clipRectN_I0leg(f7, f8, f9, f10, i4);
            function1.invoke(drawScope);
        } finally {
            AbstractC1974b.m1329v(1, drawContext, jMo18997getSizeNHjbRc, 1);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use a new overload accepting nullable GraphicsLayer")
    /* JADX INFO: renamed from: draw-GRGpd60, reason: not valid java name */
    public static final /* synthetic */ void m19120drawGRGpd60(DrawScope drawScope, Density density, LayoutDirection layoutDirection, Canvas canvas, long j, Function1<? super DrawScope, Unit> function1) {
        Density density2 = drawScope.getDrawContext().getDensity();
        LayoutDirection layoutDirection2 = drawScope.getDrawContext().getLayoutDirection();
        Canvas canvas2 = drawScope.getDrawContext().getCanvas();
        long jMo18997getSizeNHjbRc = drawScope.getDrawContext().mo18997getSizeNHjbRc();
        GraphicsLayer graphicsLayer = drawScope.getDrawContext().getGraphicsLayer();
        DrawContext drawContext = drawScope.getDrawContext();
        drawContext.setDensity(density);
        drawContext.setLayoutDirection(layoutDirection);
        drawContext.setCanvas(canvas);
        drawContext.mo18998setSizeuvyYCjk(j);
        drawContext.setGraphicsLayer(null);
        canvas.save();
        try {
            function1.invoke(drawScope);
        } finally {
            InlineMarker.finallyStart(1);
            canvas.restore();
            DrawContext drawContext2 = drawScope.getDrawContext();
            drawContext2.setDensity(density2);
            drawContext2.setLayoutDirection(layoutDirection2);
            drawContext2.setCanvas(canvas2);
            drawContext2.mo18998setSizeuvyYCjk(jMo18997getSizeNHjbRc);
            drawContext2.setGraphicsLayer(graphicsLayer);
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX INFO: renamed from: draw-ymL40Pk, reason: not valid java name */
    public static final void m19121drawymL40Pk(@NotNull DrawScope drawScope, @NotNull Density density, @NotNull LayoutDirection layoutDirection, @NotNull Canvas canvas, long j, @Nullable GraphicsLayer graphicsLayer, @NotNull Function1<? super DrawScope, Unit> function1) {
        Density density2 = drawScope.getDrawContext().getDensity();
        LayoutDirection layoutDirection2 = drawScope.getDrawContext().getLayoutDirection();
        Canvas canvas2 = drawScope.getDrawContext().getCanvas();
        long jMo18997getSizeNHjbRc = drawScope.getDrawContext().mo18997getSizeNHjbRc();
        GraphicsLayer graphicsLayer2 = drawScope.getDrawContext().getGraphicsLayer();
        DrawContext drawContext = drawScope.getDrawContext();
        drawContext.setDensity(density);
        drawContext.setLayoutDirection(layoutDirection);
        drawContext.setCanvas(canvas);
        drawContext.mo18998setSizeuvyYCjk(j);
        drawContext.setGraphicsLayer(graphicsLayer);
        canvas.save();
        try {
            function1.invoke(drawScope);
        } finally {
            InlineMarker.finallyStart(1);
            canvas.restore();
            DrawContext drawContext2 = drawScope.getDrawContext();
            drawContext2.setDensity(density2);
            drawContext2.setLayoutDirection(layoutDirection2);
            drawContext2.setCanvas(canvas2);
            drawContext2.mo18998setSizeuvyYCjk(jMo18997getSizeNHjbRc);
            drawContext2.setGraphicsLayer(graphicsLayer2);
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX INFO: renamed from: draw-ymL40Pk$default, reason: not valid java name */
    public static /* synthetic */ void m19122drawymL40Pk$default(DrawScope drawScope, Density density, LayoutDirection layoutDirection, Canvas canvas, long j, GraphicsLayer graphicsLayer, Function1 function1, int i, Object obj) {
        if ((i & 16) != 0) {
            graphicsLayer = null;
        }
        Density density2 = drawScope.getDrawContext().getDensity();
        LayoutDirection layoutDirection2 = drawScope.getDrawContext().getLayoutDirection();
        Canvas canvas2 = drawScope.getDrawContext().getCanvas();
        long jMo18997getSizeNHjbRc = drawScope.getDrawContext().mo18997getSizeNHjbRc();
        GraphicsLayer graphicsLayer2 = drawScope.getDrawContext().getGraphicsLayer();
        DrawContext drawContext = drawScope.getDrawContext();
        drawContext.setDensity(density);
        drawContext.setLayoutDirection(layoutDirection);
        drawContext.setCanvas(canvas);
        drawContext.mo18998setSizeuvyYCjk(j);
        drawContext.setGraphicsLayer(graphicsLayer);
        canvas.save();
        try {
            function1.invoke(drawScope);
        } finally {
            InlineMarker.finallyStart(1);
            canvas.restore();
            DrawContext drawContext2 = drawScope.getDrawContext();
            drawContext2.setDensity(density2);
            drawContext2.setLayoutDirection(layoutDirection2);
            drawContext2.setCanvas(canvas2);
            drawContext2.mo18998setSizeuvyYCjk(jMo18997getSizeNHjbRc);
            drawContext2.setGraphicsLayer(graphicsLayer2);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final void drawIntoCanvas(@NotNull DrawScope drawScope, @NotNull Function1<? super Canvas, Unit> function1) {
        function1.invoke(drawScope.getDrawContext().getCanvas());
    }

    public static final void inset(@NotNull DrawScope drawScope, float f, float f4, float f5, float f6, @NotNull Function1<? super DrawScope, Unit> function1) {
        drawScope.getDrawContext().getTransform().inset(f, f4, f5, f6);
        try {
            function1.invoke(drawScope);
        } finally {
            InlineMarker.finallyStart(1);
            drawScope.getDrawContext().getTransform().inset(-f, -f4, -f5, -f6);
            InlineMarker.finallyEnd(1);
        }
    }

    public static /* synthetic */ void inset$default(DrawScope drawScope, float f, float f4, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f4 = 0.0f;
        }
        drawScope.getDrawContext().getTransform().inset(f, f4, f, f4);
        try {
            function1.invoke(drawScope);
        } finally {
            InlineMarker.finallyStart(1);
            float f5 = -f;
            float f6 = -f4;
            drawScope.getDrawContext().getTransform().inset(f5, f6, f5, f6);
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX INFO: renamed from: rotate-Rg1IO4c, reason: not valid java name */
    public static final void m19123rotateRg1IO4c(@NotNull DrawScope drawScope, float f, long j, @NotNull Function1<? super DrawScope, Unit> function1) {
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo18997getSizeNHjbRc = drawContext.mo18997getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo19003rotateUv8p0NA(f, j);
            function1.invoke(drawScope);
        } finally {
            AbstractC1974b.m1329v(1, drawContext, jMo18997getSizeNHjbRc, 1);
        }
    }

    /* JADX INFO: renamed from: rotate-Rg1IO4c$default, reason: not valid java name */
    public static /* synthetic */ void m19124rotateRg1IO4c$default(DrawScope drawScope, float f, long j, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            j = drawScope.mo19075getCenterF1C5BW0();
        }
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo18997getSizeNHjbRc = drawContext.mo18997getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo19003rotateUv8p0NA(f, j);
            function1.invoke(drawScope);
        } finally {
            AbstractC1974b.m1329v(1, drawContext, jMo18997getSizeNHjbRc, 1);
        }
    }

    /* JADX INFO: renamed from: rotateRad-Rg1IO4c, reason: not valid java name */
    public static final void m19125rotateRadRg1IO4c(@NotNull DrawScope drawScope, float f, long j, @NotNull Function1<? super DrawScope, Unit> function1) {
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo18997getSizeNHjbRc = drawContext.mo18997getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo19003rotateUv8p0NA(DegreesKt.degrees(f), j);
            function1.invoke(drawScope);
        } finally {
            AbstractC1974b.m1329v(1, drawContext, jMo18997getSizeNHjbRc, 1);
        }
    }

    /* JADX INFO: renamed from: rotateRad-Rg1IO4c$default, reason: not valid java name */
    public static /* synthetic */ void m19126rotateRadRg1IO4c$default(DrawScope drawScope, float f, long j, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            j = drawScope.mo19075getCenterF1C5BW0();
        }
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo18997getSizeNHjbRc = drawContext.mo18997getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo19003rotateUv8p0NA(DegreesKt.degrees(f), j);
            function1.invoke(drawScope);
        } finally {
            AbstractC1974b.m1329v(1, drawContext, jMo18997getSizeNHjbRc, 1);
        }
    }

    /* JADX INFO: renamed from: scale-Fgt4K4Q, reason: not valid java name */
    public static final void m19127scaleFgt4K4Q(@NotNull DrawScope drawScope, float f, float f4, long j, @NotNull Function1<? super DrawScope, Unit> function1) {
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo18997getSizeNHjbRc = drawContext.mo18997getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo19004scale0AR0LA0(f, f4, j);
            function1.invoke(drawScope);
        } finally {
            AbstractC1974b.m1329v(1, drawContext, jMo18997getSizeNHjbRc, 1);
        }
    }

    /* JADX INFO: renamed from: scale-Fgt4K4Q$default, reason: not valid java name */
    public static /* synthetic */ void m19128scaleFgt4K4Q$default(DrawScope drawScope, float f, float f4, long j, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            j = drawScope.mo19075getCenterF1C5BW0();
        }
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo18997getSizeNHjbRc = drawContext.mo18997getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo19004scale0AR0LA0(f, f4, j);
            function1.invoke(drawScope);
        } finally {
            AbstractC1974b.m1329v(1, drawContext, jMo18997getSizeNHjbRc, 1);
        }
    }

    /* JADX INFO: renamed from: scale-Rg1IO4c, reason: not valid java name */
    public static final void m19129scaleRg1IO4c(@NotNull DrawScope drawScope, float f, long j, @NotNull Function1<? super DrawScope, Unit> function1) {
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo18997getSizeNHjbRc = drawContext.mo18997getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo19004scale0AR0LA0(f, f, j);
            function1.invoke(drawScope);
        } finally {
            AbstractC1974b.m1329v(1, drawContext, jMo18997getSizeNHjbRc, 1);
        }
    }

    /* JADX INFO: renamed from: scale-Rg1IO4c$default, reason: not valid java name */
    public static /* synthetic */ void m19130scaleRg1IO4c$default(DrawScope drawScope, float f, long j, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            j = drawScope.mo19075getCenterF1C5BW0();
        }
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo18997getSizeNHjbRc = drawContext.mo18997getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo19004scale0AR0LA0(f, f, j);
            function1.invoke(drawScope);
        } finally {
            AbstractC1974b.m1329v(1, drawContext, jMo18997getSizeNHjbRc, 1);
        }
    }

    public static final void translate(@NotNull DrawScope drawScope, float f, float f4, @NotNull Function1<? super DrawScope, Unit> function1) {
        drawScope.getDrawContext().getTransform().translate(f, f4);
        try {
            function1.invoke(drawScope);
        } finally {
            InlineMarker.finallyStart(1);
            drawScope.getDrawContext().getTransform().translate(-f, -f4);
            InlineMarker.finallyEnd(1);
        }
    }

    public static /* synthetic */ void translate$default(DrawScope drawScope, float f, float f4, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f4 = 0.0f;
        }
        drawScope.getDrawContext().getTransform().translate(f, f4);
        try {
            function1.invoke(drawScope);
        } finally {
            InlineMarker.finallyStart(1);
            drawScope.getDrawContext().getTransform().translate(-f, -f4);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final void withTransform(@NotNull DrawScope drawScope, @NotNull Function1<? super DrawTransform, Unit> function1, @NotNull Function1<? super DrawScope, Unit> function12) {
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo18997getSizeNHjbRc = drawContext.mo18997getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            function1.invoke(drawContext.getTransform());
            function12.invoke(drawScope);
        } finally {
            AbstractC1974b.m1329v(1, drawContext, jMo18997getSizeNHjbRc, 1);
        }
    }

    public static final void inset(@NotNull DrawScope drawScope, float f, @NotNull Function1<? super DrawScope, Unit> function1) {
        drawScope.getDrawContext().getTransform().inset(f, f, f, f);
        try {
            function1.invoke(drawScope);
        } finally {
            InlineMarker.finallyStart(1);
            float f4 = -f;
            drawScope.getDrawContext().getTransform().inset(f4, f4, f4, f4);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final void inset(@NotNull DrawScope drawScope, float f, float f4, @NotNull Function1<? super DrawScope, Unit> function1) {
        drawScope.getDrawContext().getTransform().inset(f, f4, f, f4);
        try {
            function1.invoke(drawScope);
        } finally {
            InlineMarker.finallyStart(1);
            float f5 = -f;
            float f6 = -f4;
            drawScope.getDrawContext().getTransform().inset(f5, f6, f5, f6);
            InlineMarker.finallyEnd(1);
        }
    }
}
