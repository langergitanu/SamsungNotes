package androidx.compose.p109ui.graphics;

import android.graphics.Canvas;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0002\b\u000fH\u0086\bR\u001c\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, m13886d2 = {"Landroidx/compose/ui/graphics/CanvasHolder;", "", "()V", "androidCanvas", "Landroidx/compose/ui/graphics/AndroidCanvas;", "getAndroidCanvas$annotations", "getAndroidCanvas", "()Landroidx/compose/ui/graphics/AndroidCanvas;", "drawInto", "", "targetCanvas", "Landroid/graphics/Canvas;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "Lkotlin/ExtensionFunctionType;", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class CanvasHolder {

    @NotNull
    private final AndroidCanvas androidCanvas = new AndroidCanvas();

    public final void drawInto(@NotNull Canvas targetCanvas, @NotNull Function1<? super Canvas, Unit> block) {
        Canvas internalCanvas = getAndroidCanvas().getInternalCanvas();
        getAndroidCanvas().setInternalCanvas(targetCanvas);
        block.invoke(getAndroidCanvas());
        getAndroidCanvas().setInternalCanvas(internalCanvas);
    }

    @NotNull
    public final AndroidCanvas getAndroidCanvas() {
        return this.androidCanvas;
    }

    @PublishedApi
    public static /* synthetic */ void getAndroidCanvas$annotations() {
    }
}
