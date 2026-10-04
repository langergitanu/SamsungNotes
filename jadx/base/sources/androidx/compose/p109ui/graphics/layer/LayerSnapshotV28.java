package androidx.compose.p109ui.graphics.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import androidx.annotation.RequiresApi;
import androidx.compose.p109ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.p109ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(28)
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0096@¢\u0006\u0002\u0010\u0007¨\u0006\t"}, m13886d2 = {"Landroidx/compose/ui/graphics/layer/LayerSnapshotV28;", "Landroidx/compose/ui/graphics/layer/LayerSnapshotImpl;", "()V", "toBitmap", "Landroid/graphics/Bitmap;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "GraphicsLayerPicture", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class LayerSnapshotV28 implements LayerSnapshotImpl {

    @NotNull
    public static final LayerSnapshotV28 INSTANCE = new LayerSnapshotV28();

    private LayerSnapshotV28() {
    }

    @Override // androidx.compose.p109ui.graphics.layer.LayerSnapshotImpl
    @Nullable
    public Object toBitmap(@NotNull GraphicsLayer graphicsLayer, @NotNull Continuation<? super Bitmap> continuation) {
        return Bitmap.createBitmap(new GraphicsLayerPicture(graphicsLayer));
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, m13886d2 = {"Landroidx/compose/ui/graphics/layer/LayerSnapshotV28$GraphicsLayerPicture;", "Landroid/graphics/Picture;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "getGraphicsLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "beginRecording", "Landroid/graphics/Canvas;", "width", "", "height", "draw", "", "canvas", "endRecording", "getHeight", "getWidth", "requiresHardwareAcceleration", "", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class GraphicsLayerPicture extends Picture {

        @NotNull
        private final GraphicsLayer graphicsLayer;

        public GraphicsLayerPicture(@NotNull GraphicsLayer graphicsLayer) {
            this.graphicsLayer = graphicsLayer;
        }

        @Override // android.graphics.Picture
        @NotNull
        public Canvas beginRecording(int width, int height) {
            return new Canvas();
        }

        @Override // android.graphics.Picture
        public void draw(@NotNull Canvas canvas) {
            this.graphicsLayer.draw$ui_graphics_release(AndroidCanvas_androidKt.Canvas(canvas), null);
        }

        @NotNull
        public final GraphicsLayer getGraphicsLayer() {
            return this.graphicsLayer;
        }

        @Override // android.graphics.Picture
        public int getHeight() {
            return IntSize.m21137getHeightimpl(this.graphicsLayer.getSize());
        }

        @Override // android.graphics.Picture
        public int getWidth() {
            return IntSize.m21138getWidthimpl(this.graphicsLayer.getSize());
        }

        @Override // android.graphics.Picture
        public boolean requiresHardwareAcceleration() {
            return true;
        }

        @Override // android.graphics.Picture
        public void endRecording() {
        }
    }
}
