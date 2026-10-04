package androidx.glance.appwidget;

import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.ColorProviderKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\bX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, m13886d2 = {"Landroidx/glance/appwidget/ProgressIndicatorDefaults;", "", "()V", "BackgroundColorProvider", "Landroidx/glance/unit/ColorProvider;", "getBackgroundColorProvider", "()Landroidx/glance/unit/ColorProvider;", "Color", "Landroidx/compose/ui/graphics/Color;", "J", "IndicatorColorProvider", "getIndicatorColorProvider", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class ProgressIndicatorDefaults {
    public static final int $stable;

    @NotNull
    private static final ColorProvider BackgroundColorProvider;
    private static final long Color;

    @NotNull
    public static final ProgressIndicatorDefaults INSTANCE = new ProgressIndicatorDefaults();

    @NotNull
    private static final ColorProvider IndicatorColorProvider;

    static {
        long jColor = ColorKt.Color(4284612846L);
        Color = jColor;
        IndicatorColorProvider = ColorProviderKt.m22055ColorProvider8_81llA(jColor);
        BackgroundColorProvider = ColorProviderKt.m22055ColorProvider8_81llA(Color.m18524copywmQWz5c$default(jColor, 0.24f, 0.0f, 0.0f, 0.0f, 14, null));
        $stable = 8;
    }

    private ProgressIndicatorDefaults() {
    }

    @NotNull
    public final ColorProvider getBackgroundColorProvider() {
        return BackgroundColorProvider;
    }

    @NotNull
    public final ColorProvider getIndicatorColorProvider() {
        return IndicatorColorProvider;
    }
}
