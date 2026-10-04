package androidx.glance.text;

import androidx.compose.p109ui.graphics.Color;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.ColorProviderKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m13886d2 = {"Landroidx/glance/text/TextDefaults;", "", "()V", "defaultTextColor", "Landroidx/glance/unit/ColorProvider;", "getDefaultTextColor", "()Landroidx/glance/unit/ColorProvider;", "defaultTextStyle", "Landroidx/glance/text/TextStyle;", "getDefaultTextStyle", "()Landroidx/glance/text/TextStyle;", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class TextDefaults {
    public static final int $stable;

    @NotNull
    public static final TextDefaults INSTANCE = new TextDefaults();

    @NotNull
    private static final ColorProvider defaultTextColor;

    @NotNull
    private static final TextStyle defaultTextStyle;

    static {
        ColorProvider colorProviderM22055ColorProvider8_81llA = ColorProviderKt.m22055ColorProvider8_81llA(Color.INSTANCE.m18551getBlack0d7_KjU());
        defaultTextColor = colorProviderM22055ColorProvider8_81llA;
        defaultTextStyle = new TextStyle(colorProviderM22055ColorProvider8_81llA, null, null, null, null, null, null, 0, false, null, null, 0, null, null, 0, 32766, null);
        $stable = 8;
    }

    private TextDefaults() {
    }

    @NotNull
    public final ColorProvider getDefaultTextColor() {
        return defaultTextColor;
    }

    @NotNull
    public final TextStyle getDefaultTextStyle() {
        return defaultTextStyle;
    }
}
