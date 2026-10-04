package androidx.compose.p109ui.graphics;

import androidx.compose.p109ui.graphics.layer.GraphicsLayer;
import androidx.compose.runtime.RememberObserver;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, m13886d2 = {"Landroidx/compose/ui/graphics/GraphicsContextObserver;", "Landroidx/compose/runtime/RememberObserver;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "(Landroidx/compose/ui/graphics/GraphicsContext;)V", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "getGraphicsLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "onAbandoned", "", "onForgotten", "onRemembered", "ui_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class GraphicsContextObserver implements RememberObserver {

    @NotNull
    private final GraphicsContext graphicsContext;

    @NotNull
    private final GraphicsLayer graphicsLayer;

    public GraphicsContextObserver(@NotNull GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
        this.graphicsLayer = graphicsContext.createGraphicsLayer();
    }

    @NotNull
    public final GraphicsLayer getGraphicsLayer() {
        return this.graphicsLayer;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
        this.graphicsContext.releaseGraphicsLayer(this.graphicsLayer);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        this.graphicsContext.releaseGraphicsLayer(this.graphicsLayer);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
    }
}
