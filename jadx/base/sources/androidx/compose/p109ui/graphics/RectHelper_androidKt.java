package androidx.compose.p109ui.graphics;

import android.graphics.Rect;
import android.graphics.RectF;
import androidx.compose.p109ui.unit.IntRect;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0003\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0003*\u00020\u0001\u001a\n\u0010\u0007\u001a\u00020\u0002*\u00020\u0001\u001a\n\u0010\u0007\u001a\u00020\u0002*\u00020\u0005¨\u0006\b"}, m13886d2 = {"toAndroidRect", "Landroid/graphics/Rect;", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/IntRect;", "toAndroidRectF", "Landroid/graphics/RectF;", "toComposeIntRect", "toComposeRect", "ui-graphics_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class RectHelper_androidKt {
    @Deprecated(message = "Converting Rect to android.graphics.Rect is lossy, and requires rounding. The behavior of toAndroidRect() truncates to an integral Rect, but you should choose the method of rounding most suitable for your use case.", replaceWith = @ReplaceWith(expression = "android.graphics.Rect(left.toInt(), top.toInt(), right.toInt(), bottom.toInt())", imports = {}))
    @NotNull
    public static final Rect toAndroidRect(@NotNull androidx.compose.p109ui.geometry.Rect rect) {
        return new Rect((int) rect.getLeft(), (int) rect.getTop(), (int) rect.getRight(), (int) rect.getBottom());
    }

    @NotNull
    public static final RectF toAndroidRectF(@NotNull androidx.compose.p109ui.geometry.Rect rect) {
        return new RectF(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom());
    }

    @NotNull
    public static final IntRect toComposeIntRect(@NotNull Rect rect) {
        return new IntRect(rect.left, rect.top, rect.right, rect.bottom);
    }

    @NotNull
    public static final androidx.compose.p109ui.geometry.Rect toComposeRect(@NotNull Rect rect) {
        return new androidx.compose.p109ui.geometry.Rect(rect.left, rect.top, rect.right, rect.bottom);
    }

    @NotNull
    public static final Rect toAndroidRect(@NotNull IntRect intRect) {
        return new Rect(intRect.getLeft(), intRect.getTop(), intRect.getRight(), intRect.getBottom());
    }

    @NotNull
    public static final androidx.compose.p109ui.geometry.Rect toComposeRect(@NotNull RectF rectF) {
        return new androidx.compose.p109ui.geometry.Rect(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }
}
