package androidx.compose.p109ui.graphics.layer;

import androidx.compose.p109ui.geometry.CornerRadius;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.geometry.RoundRect;
import androidx.compose.p109ui.geometry.SizeKt;
import androidx.compose.p109ui.graphics.Outline;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0012\u0010\u0007\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\b\u001a\u00020\t\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"DefaultCameraDistance", "", "drawLayer", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "setOutline", "outline", "Landroidx/compose/ui/graphics/Outline;", "ui-graphics_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nGraphicsLayer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GraphicsLayer.kt\nandroidx/compose/ui/graphics/layer/GraphicsLayerKt\n+ 2 DrawScope.kt\nandroidx/compose/ui/graphics/drawscope/DrawScopeKt\n*L\n1#1,429:1\n256#2:430\n*S KotlinDebug\n*F\n+ 1 GraphicsLayer.kt\nandroidx/compose/ui/graphics/layer/GraphicsLayerKt\n*L\n51#1:430\n*E\n"})
public final class GraphicsLayerKt {
    public static final float DefaultCameraDistance = 8.0f;

    public static final void drawLayer(@NotNull DrawScope drawScope, @NotNull GraphicsLayer graphicsLayer) {
        graphicsLayer.draw$ui_graphics_release(drawScope.getDrawContext().getCanvas(), drawScope.getDrawContext().getGraphicsLayer());
    }

    public static final void setOutline(@NotNull GraphicsLayer graphicsLayer, @NotNull Outline outline) {
        if (outline instanceof Outline.Rectangle) {
            Outline.Rectangle rectangle = (Outline.Rectangle) outline;
            graphicsLayer.m19175setRectOutlinetz77jQw(OffsetKt.Offset(rectangle.getRect().getLeft(), rectangle.getRect().getTop()), SizeKt.Size(rectangle.getRect().getWidth(), rectangle.getRect().getHeight()));
            return;
        }
        if (outline instanceof Outline.Generic) {
            graphicsLayer.setPathOutline(((Outline.Generic) outline).getPath());
            return;
        }
        if (outline instanceof Outline.Rounded) {
            Outline.Rounded rounded = (Outline.Rounded) outline;
            if (rounded.getRoundRectPath() != null) {
                graphicsLayer.setPathOutline(rounded.getRoundRectPath());
            } else {
                RoundRect roundRect = rounded.getRoundRect();
                graphicsLayer.m19176setRoundRectOutlineTNW_H78(OffsetKt.Offset(roundRect.getLeft(), roundRect.getTop()), SizeKt.Size(roundRect.getWidth(), roundRect.getHeight()), CornerRadius.m18259getXimpl(roundRect.m18332getBottomLeftCornerRadiuskKHJgLs()));
            }
        }
    }
}
