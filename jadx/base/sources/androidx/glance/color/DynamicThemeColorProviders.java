package androidx.glance.color;

import androidx.annotation.RestrictTo;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.C2817R;
import androidx.glance.unit.ColorProviderKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m13886d2 = {"Landroidx/glance/color/DynamicThemeColorProviders;", "Landroidx/glance/color/ColorProviders;", "()V", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class DynamicThemeColorProviders extends ColorProviders {
    public static final int $stable = 0;

    @NotNull
    public static final DynamicThemeColorProviders INSTANCE = new DynamicThemeColorProviders();

    private DynamicThemeColorProviders() {
        super(ColorProviderKt.ColorProvider(C2817R.color.glance_colorPrimary), ColorProviderKt.ColorProvider(C2817R.color.glance_colorOnPrimary), ColorProviderKt.ColorProvider(C2817R.color.glance_colorPrimaryContainer), ColorProviderKt.ColorProvider(C2817R.color.glance_colorOnPrimaryContainer), ColorProviderKt.ColorProvider(C2817R.color.glance_colorSecondary), ColorProviderKt.ColorProvider(C2817R.color.glance_colorOnSecondary), ColorProviderKt.ColorProvider(C2817R.color.glance_colorSecondaryContainer), ColorProviderKt.ColorProvider(C2817R.color.glance_colorOnSecondaryContainer), ColorProviderKt.ColorProvider(C2817R.color.glance_colorTertiary), ColorProviderKt.ColorProvider(C2817R.color.glance_colorOnTertiary), ColorProviderKt.ColorProvider(C2817R.color.glance_colorTertiaryContainer), ColorProviderKt.ColorProvider(C2817R.color.glance_colorOnTertiaryContainer), ColorProviderKt.ColorProvider(C2817R.color.glance_colorError), ColorProviderKt.ColorProvider(C2817R.color.glance_colorErrorContainer), ColorProviderKt.ColorProvider(C2817R.color.glance_colorOnError), ColorProviderKt.ColorProvider(C2817R.color.glance_colorOnErrorContainer), ColorProviderKt.ColorProvider(C2817R.color.glance_colorBackground), ColorProviderKt.ColorProvider(C2817R.color.glance_colorOnBackground), ColorProviderKt.ColorProvider(C2817R.color.glance_colorSurface), ColorProviderKt.ColorProvider(C2817R.color.glance_colorOnSurface), ColorProviderKt.ColorProvider(C2817R.color.glance_colorSurfaceVariant), ColorProviderKt.ColorProvider(C2817R.color.glance_colorOnSurfaceVariant), ColorProviderKt.ColorProvider(C2817R.color.glance_colorOutline), ColorProviderKt.ColorProvider(C2817R.color.glance_colorOnSurfaceInverse), ColorProviderKt.ColorProvider(C2817R.color.glance_colorSurfaceInverse), ColorProviderKt.ColorProvider(C2817R.color.glance_colorPrimaryInverse), ColorProviderKt.ColorProvider(C2817R.color.glance_colorWidgetBackground), null);
    }
}
