package androidx.compose.p109ui.draw;

import androidx.compose.p109ui.Modifier;
import androidx.compose.p109ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.runtime.Stable;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0002H\u0007\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007¨\u0006\u0005"}, m13886d2 = {WiggleAnimationConfig.KEY_SCALE, "Landroidx/compose/ui/Modifier;", "", "scaleX", "scaleY", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ScaleKt {
    @Stable
    @NotNull
    public static final Modifier scale(@NotNull Modifier modifier, float f, float f4) {
        return (f == 1.0f && f4 == 1.0f) ? modifier : GraphicsLayerModifierKt.m18686graphicsLayerAp8cVGQ$default(modifier, f, f4, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131068, null);
    }

    @Stable
    @NotNull
    public static final Modifier scale(@NotNull Modifier modifier, float f) {
        return scale(modifier, f, f);
    }
}
