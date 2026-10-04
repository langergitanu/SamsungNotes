package androidx.compose.p109ui.unit;

import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¨\u0006\u0005"}, m13886d2 = {"Density", "Landroidx/compose/ui/unit/Density;", "density", "", "fontScale", "ui-unit_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class DensityKt {
    @Stable
    @NotNull
    public static final Density Density(float f, float f4) {
        return new DensityImpl(f, f4);
    }

    public static /* synthetic */ Density Density$default(float f, float f4, int i, Object obj) {
        if ((i & 2) != 0) {
            f4 = 1.0f;
        }
        return Density(f, f4);
    }
}
