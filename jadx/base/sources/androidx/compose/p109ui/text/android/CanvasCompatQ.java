package androidx.compose.p109ui.text.android;

import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.RenderNode;
import android.graphics.text.MeasuredText;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(29)
@Metadata(m13885d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\fH\u0007J \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u000bH\u0007JH\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J8\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dH\u0007JX\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006*"}, m13886d2 = {"Landroidx/compose/ui/text/android/CanvasCompatQ;", "", "()V", "disableZ", "", "canvas", "Landroid/graphics/Canvas;", "drawColor", "color", "", "mode", "Landroid/graphics/BlendMode;", "", "drawDoubleRoundRect", "outer", "Landroid/graphics/RectF;", "outerRx", "", "outerRy", "inner", "innerRx", "innerRy", "paint", "Landroid/graphics/Paint;", "outerRadii", "", "innerRadii", "drawRenderNode", "renderNode", "Landroid/graphics/RenderNode;", "drawTextRun", "text", "Landroid/graphics/text/MeasuredText;", "start", "end", "contextStart", "contextEnd", "x", "y", "isRtl", "", "enableZ", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class CanvasCompatQ {

    @NotNull
    public static final CanvasCompatQ INSTANCE = new CanvasCompatQ();

    private CanvasCompatQ() {
    }

    @DoNotInline
    public final void disableZ(@NotNull Canvas canvas) {
        canvas.disableZ();
    }

    @DoNotInline
    public final void drawColor(@NotNull Canvas canvas, long color) {
        canvas.drawColor(color);
    }

    @DoNotInline
    public final void drawDoubleRoundRect(@NotNull Canvas canvas, @NotNull RectF outer, float outerRx, float outerRy, @NotNull RectF inner, float innerRx, float innerRy, @NotNull Paint paint) {
        canvas.drawDoubleRoundRect(outer, outerRx, outerRy, inner, innerRx, innerRy, paint);
    }

    @DoNotInline
    public final void drawRenderNode(@NotNull Canvas canvas, @NotNull RenderNode renderNode) {
        canvas.drawRenderNode(renderNode);
    }

    @DoNotInline
    public final void drawTextRun(@NotNull Canvas canvas, @NotNull MeasuredText text, int start, int end, int contextStart, int contextEnd, float x, float y2, boolean isRtl, @NotNull Paint paint) {
        canvas.drawTextRun(text, start, end, contextStart, contextEnd, x, y2, isRtl, paint);
    }

    @DoNotInline
    public final void enableZ(@NotNull Canvas canvas) {
        canvas.enableZ();
    }

    @DoNotInline
    public final void drawColor(@NotNull Canvas canvas, int color, @NotNull BlendMode mode) {
        canvas.drawColor(color, mode);
    }

    @DoNotInline
    public final void drawDoubleRoundRect(@NotNull Canvas canvas, @NotNull RectF outer, @NotNull float[] outerRadii, @NotNull RectF inner, @NotNull float[] innerRadii, @NotNull Paint paint) {
        canvas.drawDoubleRoundRect(outer, outerRadii, inner, innerRadii, paint);
    }

    @DoNotInline
    public final void drawColor(@NotNull Canvas canvas, long color, @NotNull BlendMode mode) {
        canvas.drawColor(color, mode);
    }
}
