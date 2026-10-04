package androidx.compose.p109ui.text.android;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(26)
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\fH\u0007J0\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0007J0\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012H\u0007¨\u0006\u0013"}, m13886d2 = {"Landroidx/compose/ui/text/android/CanvasCompatO;", "", "()V", "clipOutPath", "", "canvas", "Landroid/graphics/Canvas;", "path", "Landroid/graphics/Path;", "clipOutRect", "rect", "Landroid/graphics/Rect;", "Landroid/graphics/RectF;", "left", "", "top", "right", "bottom", "", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class CanvasCompatO {

    @NotNull
    public static final CanvasCompatO INSTANCE = new CanvasCompatO();

    private CanvasCompatO() {
    }

    @DoNotInline
    public final boolean clipOutPath(@NotNull Canvas canvas, @NotNull Path path) {
        return canvas.clipOutPath(path);
    }

    @DoNotInline
    public final boolean clipOutRect(@NotNull Canvas canvas, @NotNull RectF rect) {
        return canvas.clipOutRect(rect);
    }

    @DoNotInline
    public final boolean clipOutRect(@NotNull Canvas canvas, @NotNull Rect rect) {
        return canvas.clipOutRect(rect);
    }

    @DoNotInline
    public final boolean clipOutRect(@NotNull Canvas canvas, float left, float top, float right, float bottom) {
        return canvas.clipOutRect(left, top, right, bottom);
    }

    @DoNotInline
    public final boolean clipOutRect(@NotNull Canvas canvas, int left, int top, int right, int bottom) {
        return canvas.clipOutRect(left, top, right, bottom);
    }
}
