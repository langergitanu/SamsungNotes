package androidx.compose.p109ui.graphics.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import androidx.compose.p109ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.p109ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0096@¢\u0006\u0002\u0010\u0007¨\u0006\b"}, m13886d2 = {"Landroidx/compose/ui/graphics/layer/LayerSnapshotV21;", "Landroidx/compose/ui/graphics/layer/LayerSnapshotImpl;", "()V", "toBitmap", "Landroid/graphics/Bitmap;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class LayerSnapshotV21 implements LayerSnapshotImpl {

    @NotNull
    public static final LayerSnapshotV21 INSTANCE = new LayerSnapshotV21();

    private LayerSnapshotV21() {
    }

    @Override // androidx.compose.p109ui.graphics.layer.LayerSnapshotImpl
    @Nullable
    public Object toBitmap(@NotNull GraphicsLayer graphicsLayer, @NotNull Continuation<? super Bitmap> continuation) {
        long size = graphicsLayer.getSize();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(IntSize.m21138getWidthimpl(size), IntSize.m21137getHeightimpl(size), Bitmap.Config.ARGB_8888);
        graphicsLayer.draw$ui_graphics_release(AndroidCanvas_androidKt.Canvas(new Canvas(bitmapCreateBitmap)), null);
        return bitmapCreateBitmap;
    }
}
