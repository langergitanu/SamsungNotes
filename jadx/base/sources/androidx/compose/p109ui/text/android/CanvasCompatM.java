package androidx.compose.p109ui.text.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0005\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JX\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007JX\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007¨\u0006\u001a"}, m13886d2 = {"Landroidx/compose/ui/text/android/CanvasCompatM;", "", "()V", "drawTextRun", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "index", "", "count", "contextIndex", "contextCount", "x", "", "y", "isRtl", "", "paint", "Landroid/graphics/Paint;", "", "start", "end", "contextStart", "contextEnd", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class CanvasCompatM {

    @NotNull
    public static final CanvasCompatM INSTANCE = new CanvasCompatM();

    private CanvasCompatM() {
    }

    @DoNotInline
    public final void drawTextRun(@NotNull Canvas canvas, @NotNull char[] text, int index, int count, int contextIndex, int contextCount, float x, float y2, boolean isRtl, @NotNull Paint paint) {
        canvas.drawTextRun(text, index, count, contextIndex, contextCount, x, y2, isRtl, paint);
    }

    @DoNotInline
    public final void drawTextRun(@NotNull Canvas canvas, @NotNull CharSequence text, int start, int end, int contextStart, int contextEnd, float x, float y2, boolean isRtl, @NotNull Paint paint) {
        canvas.drawTextRun(text, start, end, contextStart, contextEnd, x, y2, isRtl, paint);
    }
}
