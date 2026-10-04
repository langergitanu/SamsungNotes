package androidx.compose.p109ui.text;

import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.geometry.RectKt;
import androidx.compose.p109ui.geometry.SizeKt;
import androidx.compose.p109ui.graphics.Brush;
import androidx.compose.p109ui.graphics.Canvas;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.Shadow;
import androidx.compose.p109ui.graphics.drawscope.DrawScope;
import androidx.compose.p109ui.graphics.drawscope.DrawStyle;
import androidx.compose.p109ui.graphics.drawscope.Fill;
import androidx.compose.p109ui.text.style.TextDecoration;
import androidx.compose.p109ui.text.style.TextForegroundStyle;
import androidx.compose.p109ui.text.style.TextOverflow;
import androidx.compose.p109ui.unit.IntSize;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, m13886d2 = {"Landroidx/compose/ui/text/TextPainter;", "", "()V", "paint", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class TextPainter {
    public static final int $stable = 0;

    @NotNull
    public static final TextPainter INSTANCE = new TextPainter();

    private TextPainter() {
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void paint(@NotNull Canvas canvas, @NotNull TextLayoutResult textLayoutResult) {
        Canvas canvas2;
        Throwable th;
        Canvas canvas3;
        float alpha;
        boolean z = textLayoutResult.getHasVisualOverflow() && !TextOverflow.m20899equalsimpl0(textLayoutResult.getLayoutInput().getOverflow(), TextOverflow.INSTANCE.m20908getVisiblegIe3tQ8());
        if (z) {
            Rect rectM18324Recttz77jQw = RectKt.m18324Recttz77jQw(Offset.INSTANCE.m18300getZeroF1C5BW0(), SizeKt.Size(IntSize.m21138getWidthimpl(textLayoutResult.getSize()), IntSize.m21137getHeightimpl(textLayoutResult.getSize())));
            canvas.save();
            canvas2 = null;
            Canvas.m18498clipRectmtrdDE$default(canvas, rectM18324Recttz77jQw, 0, 2, null);
        }
        SpanStyle spanStyle = textLayoutResult.getLayoutInput().getStyle().getSpanStyle();
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration == null) {
            textDecoration = TextDecoration.INSTANCE.getNone();
        }
        TextDecoration textDecoration2 = textDecoration;
        Shadow shadow = spanStyle.getShadow();
        if (shadow == null) {
            shadow = Shadow.INSTANCE.getNone();
        }
        Shadow shadow2 = shadow;
        DrawStyle drawStyle = spanStyle.getDrawStyle();
        if (drawStyle == null) {
            drawStyle = Fill.INSTANCE;
        }
        DrawStyle drawStyle2 = drawStyle;
        try {
            Brush brush = spanStyle.getBrush();
            try {
                if (brush != null) {
                    if (spanStyle.getTextForegroundStyle() != TextForegroundStyle.Unspecified.INSTANCE) {
                        try {
                            alpha = spanStyle.getTextForegroundStyle().getAlpha();
                        } catch (Throwable th2) {
                            th = th2;
                            canvas2 = canvas;
                            if (z) {
                                throw th;
                            }
                            canvas2.restore();
                            throw th;
                        }
                    } else {
                        alpha = 1.0f;
                    }
                    canvas3 = canvas;
                    MultiParagraph.m20320painthn5TExg$default(textLayoutResult.getMultiParagraph(), canvas3, brush, alpha, shadow2, textDecoration2, drawStyle2, 0, 64, null);
                } else {
                    canvas3 = canvas;
                    textLayoutResult.getMultiParagraph().m20325paintLG529CI(canvas3, (32 & 2) != 0 ? Color.INSTANCE.m18561getUnspecified0d7_KjU() : spanStyle.getTextForegroundStyle() != TextForegroundStyle.Unspecified.INSTANCE ? spanStyle.getTextForegroundStyle().mo20755getColor0d7_KjU() : Color.INSTANCE.m18551getBlack0d7_KjU(), (32 & 4) != 0 ? null : shadow2, (32 & 8) != 0 ? null : textDecoration2, (32 & 16) == 0 ? drawStyle2 : null, (32 & 32) != 0 ? DrawScope.INSTANCE.m19078getDefaultBlendMode0nO6VwU() : 0);
                }
                if (z) {
                    canvas3.restore();
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                if (z) {
                }
            }
        } catch (Throwable th4) {
            th = th4;
            canvas2 = canvas;
        }
    }
}
