package androidx.palette.graphics;

import androidx.palette.graphics.Palette;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13884bv = {1, 0, 2}, m13885d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\n¨\u0006\u0005"}, m13886d2 = {"get", "Landroidx/palette/graphics/Palette$Swatch;", "Landroidx/palette/graphics/Palette;", "target", "Landroidx/palette/graphics/Target;", "palette-ktx_release"}, m13887k = 2, m13888mv = {1, 1, 10})
public final class PaletteKt {
    @Nullable
    public static final Palette.Swatch get(@NotNull Palette receiver, @NotNull Target target) {
        Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(target, "target");
        return receiver.getSwatchForTarget(target);
    }
}
