package androidx.glance.oneui.template.color;

import androidx.compose.p109ui.graphics.Color;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.ColorProviderKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m13886d2 = {"Landroidx/glance/oneui/template/color/ColorProviderUtils;", "", "()V", "Companion", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class ColorProviderUtils {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final ColorProvider Undefined = ColorProviderKt.m22055ColorProvider8_81llA(ColorProvidersKt.getColorNotDefined());

    @NotNull
    private static final ColorProvider Transparent = ColorProviderKt.m22055ColorProvider8_81llA(Color.INSTANCE.m18560getTransparent0d7_KjU());

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, m13886d2 = {"Landroidx/glance/oneui/template/color/ColorProviderUtils$Companion;", "", "()V", "Transparent", "Landroidx/glance/unit/ColorProvider;", "getTransparent", "()Landroidx/glance/unit/ColorProvider;", "Undefined", "getUndefined", "glance-oneui-template_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ColorProvider getTransparent() {
            return ColorProviderUtils.Transparent;
        }

        @NotNull
        public final ColorProvider getUndefined() {
            return ColorProviderUtils.Undefined;
        }

        private Companion() {
        }
    }
}
