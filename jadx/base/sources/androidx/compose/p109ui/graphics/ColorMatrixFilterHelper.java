package androidx.compose.p109ui.graphics;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\t"}, m13886d2 = {"Landroidx/compose/ui/graphics/ColorMatrixFilterHelper;", "", "()V", "getColorMatrix", "Landroidx/compose/ui/graphics/ColorMatrix;", "colorFilter", "Landroid/graphics/ColorMatrixColorFilter;", "getColorMatrix-8unuwjk", "(Landroid/graphics/ColorMatrixColorFilter;)[F", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
final class ColorMatrixFilterHelper {

    @NotNull
    public static final ColorMatrixFilterHelper INSTANCE = new ColorMatrixFilterHelper();

    private ColorMatrixFilterHelper() {
    }

    @DoNotInline
    @NotNull
    /* JADX INFO: renamed from: getColorMatrix-8unuwjk, reason: not valid java name */
    public final float[] m18605getColorMatrix8unuwjk(@NotNull ColorMatrixColorFilter colorFilter) {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorFilter.getColorMatrix(colorMatrix);
        return ColorMatrix.m18581constructorimpl(colorMatrix.getArray());
    }
}
