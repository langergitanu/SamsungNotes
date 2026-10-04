package androidx.compose.p109ui.text.android;

import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.fonts.Font;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(31)
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JH\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J*\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J*\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007¨\u0006\u0019"}, m13886d2 = {"Landroidx/compose/ui/text/android/CanvasCompatS;", "", "()V", "drawGlyphs", "", "canvas", "Landroid/graphics/Canvas;", "glyphIds", "", "glyphIdOffset", "", "positions", "", "positionOffset", "glyphCount", "font", "Landroid/graphics/fonts/Font;", "paint", "Landroid/graphics/Paint;", "drawPatch", "patch", "Landroid/graphics/NinePatch;", "dst", "Landroid/graphics/Rect;", "Landroid/graphics/RectF;", "ui-text_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class CanvasCompatS {

    @NotNull
    public static final CanvasCompatS INSTANCE = new CanvasCompatS();

    private CanvasCompatS() {
    }

    @DoNotInline
    public final void drawGlyphs(@NotNull Canvas canvas, @NotNull int[] glyphIds, int glyphIdOffset, @NotNull float[] positions, int positionOffset, int glyphCount, @NotNull Font font, @NotNull Paint paint) {
        canvas.drawGlyphs(glyphIds, glyphIdOffset, positions, positionOffset, glyphCount, font, paint);
    }

    @DoNotInline
    public final void drawPatch(@NotNull Canvas canvas, @NotNull NinePatch patch, @NotNull Rect dst, @Nullable Paint paint) {
        canvas.drawPatch(patch, dst, paint);
    }

    @DoNotInline
    public final void drawPatch(@NotNull Canvas canvas, @NotNull NinePatch patch, @NotNull RectF dst, @Nullable Paint paint) {
        canvas.drawPatch(patch, dst, paint);
    }
}
