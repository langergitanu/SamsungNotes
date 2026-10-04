package androidx.glance.color;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.unit.ColorProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0000\u0018\u00002\u00020\u0001BÝ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003¢\u0006\u0002\u0010\u001e¨\u0006\u001f"}, m13886d2 = {"Landroidx/glance/color/CustomColorProviders;", "Landroidx/glance/color/ColorProviders;", "primary", "Landroidx/glance/unit/ColorProvider;", "onPrimary", "primaryContainer", "onPrimaryContainer", "secondary", "onSecondary", "secondaryContainer", "onSecondaryContainer", "tertiary", "onTertiary", "tertiaryContainer", "onTertiaryContainer", "error", "errorContainer", "onError", "onErrorContainer", "background", "onBackground", "surface", "onSurface", "surfaceVariant", "onSurfaceVariant", "outline", "inverseOnSurface", "inverseSurface", "inversePrimary", "widgetBackground", "(Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;)V", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class CustomColorProviders extends ColorProviders {
    public static final int $stable = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomColorProviders(@NotNull ColorProvider primary, @NotNull ColorProvider onPrimary, @NotNull ColorProvider primaryContainer, @NotNull ColorProvider onPrimaryContainer, @NotNull ColorProvider secondary, @NotNull ColorProvider onSecondary, @NotNull ColorProvider secondaryContainer, @NotNull ColorProvider onSecondaryContainer, @NotNull ColorProvider tertiary, @NotNull ColorProvider onTertiary, @NotNull ColorProvider tertiaryContainer, @NotNull ColorProvider onTertiaryContainer, @NotNull ColorProvider error, @NotNull ColorProvider errorContainer, @NotNull ColorProvider onError, @NotNull ColorProvider onErrorContainer, @NotNull ColorProvider background, @NotNull ColorProvider onBackground, @NotNull ColorProvider surface, @NotNull ColorProvider onSurface, @NotNull ColorProvider surfaceVariant, @NotNull ColorProvider onSurfaceVariant, @NotNull ColorProvider outline, @NotNull ColorProvider inverseOnSurface, @NotNull ColorProvider inverseSurface, @NotNull ColorProvider inversePrimary, @NotNull ColorProvider widgetBackground) {
        super(primary, onPrimary, primaryContainer, onPrimaryContainer, secondary, onSecondary, secondaryContainer, onSecondaryContainer, tertiary, onTertiary, tertiaryContainer, onTertiaryContainer, error, errorContainer, onError, onErrorContainer, background, onBackground, surface, onSurface, surfaceVariant, onSurfaceVariant, outline, inverseOnSurface, inverseSurface, inversePrimary, widgetBackground, null);
        Intrinsics.checkNotNullParameter(primary, "primary");
        Intrinsics.checkNotNullParameter(onPrimary, "onPrimary");
        Intrinsics.checkNotNullParameter(primaryContainer, "primaryContainer");
        Intrinsics.checkNotNullParameter(onPrimaryContainer, "onPrimaryContainer");
        Intrinsics.checkNotNullParameter(secondary, "secondary");
        Intrinsics.checkNotNullParameter(onSecondary, "onSecondary");
        Intrinsics.checkNotNullParameter(secondaryContainer, "secondaryContainer");
        Intrinsics.checkNotNullParameter(onSecondaryContainer, "onSecondaryContainer");
        Intrinsics.checkNotNullParameter(tertiary, "tertiary");
        Intrinsics.checkNotNullParameter(onTertiary, "onTertiary");
        Intrinsics.checkNotNullParameter(tertiaryContainer, "tertiaryContainer");
        Intrinsics.checkNotNullParameter(onTertiaryContainer, "onTertiaryContainer");
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(errorContainer, "errorContainer");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onErrorContainer, "onErrorContainer");
        Intrinsics.checkNotNullParameter(background, "background");
        Intrinsics.checkNotNullParameter(onBackground, "onBackground");
        Intrinsics.checkNotNullParameter(surface, "surface");
        Intrinsics.checkNotNullParameter(onSurface, "onSurface");
        Intrinsics.checkNotNullParameter(surfaceVariant, "surfaceVariant");
        Intrinsics.checkNotNullParameter(onSurfaceVariant, "onSurfaceVariant");
        Intrinsics.checkNotNullParameter(outline, "outline");
        Intrinsics.checkNotNullParameter(inverseOnSurface, "inverseOnSurface");
        Intrinsics.checkNotNullParameter(inverseSurface, "inverseSurface");
        Intrinsics.checkNotNullParameter(inversePrimary, "inversePrimary");
        Intrinsics.checkNotNullParameter(widgetBackground, "widgetBackground");
    }
}
