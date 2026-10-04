package androidx.glance.color;

import androidx.compose.p109ui.graphics.Color;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.ColorProviderKt;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b9\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001Bß\u0001\b\u0014\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003¢\u0006\u0002\u0010\u001eB×\u0001\b\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003¢\u0006\u0002\u0010\u001fJ\u0013\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010?\u001a\u00020@H\u0016J\b\u0010A\u001a\u00020BH\u0016R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0011\u0010\u001c\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010!R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010!R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010!R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010!R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010!R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010!R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010!R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010!R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010!R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010!R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010!R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010!R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010!R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010!R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010!R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010!R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010!R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010!R\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010!\u0082\u0001\u0002CD¨\u0006E"}, m13886d2 = {"Landroidx/glance/color/ColorProviders;", "", "primary", "Landroidx/glance/unit/ColorProvider;", "onPrimary", "primaryContainer", "onPrimaryContainer", "secondary", "onSecondary", "secondaryContainer", "onSecondaryContainer", "tertiary", "onTertiary", "tertiaryContainer", "onTertiaryContainer", "error", "errorContainer", "onError", "onErrorContainer", "background", "onBackground", "surface", "onSurface", "surfaceVariant", "onSurfaceVariant", "outline", "inverseOnSurface", "inverseSurface", "inversePrimary", "widgetBackground", "(Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;)V", "(Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;Landroidx/glance/unit/ColorProvider;)V", "getBackground", "()Landroidx/glance/unit/ColorProvider;", "getError", "getErrorContainer", "getInverseOnSurface", "getInversePrimary", "getInverseSurface", "getOnBackground", "getOnError", "getOnErrorContainer", "getOnPrimary", "getOnPrimaryContainer", "getOnSecondary", "getOnSecondaryContainer", "getOnSurface", "getOnSurfaceVariant", "getOnTertiary", "getOnTertiaryContainer", "getOutline", "getPrimary", "getPrimaryContainer", "getSecondary", "getSecondaryContainer", "getSurface", "getSurfaceVariant", "getTertiary", "getTertiaryContainer", "getWidgetBackground", "equals", "", "other", "hashCode", "", "toString", "", "Landroidx/glance/color/CustomColorProviders;", "Landroidx/glance/color/DynamicThemeColorProviders;", "glance_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public abstract class ColorProviders {
    public static final int $stable = 0;

    @NotNull
    private final ColorProvider background;

    @NotNull
    private final ColorProvider error;

    @NotNull
    private final ColorProvider errorContainer;

    @NotNull
    private final ColorProvider inverseOnSurface;

    @NotNull
    private final ColorProvider inversePrimary;

    @NotNull
    private final ColorProvider inverseSurface;

    @NotNull
    private final ColorProvider onBackground;

    @NotNull
    private final ColorProvider onError;

    @NotNull
    private final ColorProvider onErrorContainer;

    @NotNull
    private final ColorProvider onPrimary;

    @NotNull
    private final ColorProvider onPrimaryContainer;

    @NotNull
    private final ColorProvider onSecondary;

    @NotNull
    private final ColorProvider onSecondaryContainer;

    @NotNull
    private final ColorProvider onSurface;

    @NotNull
    private final ColorProvider onSurfaceVariant;

    @NotNull
    private final ColorProvider onTertiary;

    @NotNull
    private final ColorProvider onTertiaryContainer;

    @NotNull
    private final ColorProvider outline;

    @NotNull
    private final ColorProvider primary;

    @NotNull
    private final ColorProvider primaryContainer;

    @NotNull
    private final ColorProvider secondary;

    @NotNull
    private final ColorProvider secondaryContainer;

    @NotNull
    private final ColorProvider surface;

    @NotNull
    private final ColorProvider surfaceVariant;

    @NotNull
    private final ColorProvider tertiary;

    @NotNull
    private final ColorProvider tertiaryContainer;

    @NotNull
    private final ColorProvider widgetBackground;

    public /* synthetic */ ColorProviders(ColorProvider colorProvider, ColorProvider colorProvider2, ColorProvider colorProvider3, ColorProvider colorProvider4, ColorProvider colorProvider5, ColorProvider colorProvider6, ColorProvider colorProvider7, ColorProvider colorProvider8, ColorProvider colorProvider9, ColorProvider colorProvider10, ColorProvider colorProvider11, ColorProvider colorProvider12, ColorProvider colorProvider13, ColorProvider colorProvider14, ColorProvider colorProvider15, ColorProvider colorProvider16, ColorProvider colorProvider17, ColorProvider colorProvider18, ColorProvider colorProvider19, ColorProvider colorProvider20, ColorProvider colorProvider21, ColorProvider colorProvider22, ColorProvider colorProvider23, ColorProvider colorProvider24, ColorProvider colorProvider25, ColorProvider colorProvider26, ColorProvider colorProvider27, DefaultConstructorMarker defaultConstructorMarker) {
        this(colorProvider, colorProvider2, colorProvider3, colorProvider4, colorProvider5, colorProvider6, colorProvider7, colorProvider8, colorProvider9, colorProvider10, colorProvider11, colorProvider12, colorProvider13, colorProvider14, colorProvider15, colorProvider16, colorProvider17, colorProvider18, colorProvider19, colorProvider20, colorProvider21, colorProvider22, colorProvider23, colorProvider24, colorProvider25, colorProvider26, colorProvider27);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.glance.color.ColorProviders");
        ColorProviders colorProviders = (ColorProviders) other;
        return Intrinsics.areEqual(this.primary, colorProviders.primary) && Intrinsics.areEqual(this.onPrimary, colorProviders.onPrimary) && Intrinsics.areEqual(this.primaryContainer, colorProviders.primaryContainer) && Intrinsics.areEqual(this.onPrimaryContainer, colorProviders.onPrimaryContainer) && Intrinsics.areEqual(this.secondary, colorProviders.secondary) && Intrinsics.areEqual(this.onSecondary, colorProviders.onSecondary) && Intrinsics.areEqual(this.secondaryContainer, colorProviders.secondaryContainer) && Intrinsics.areEqual(this.onSecondaryContainer, colorProviders.onSecondaryContainer) && Intrinsics.areEqual(this.tertiary, colorProviders.tertiary) && Intrinsics.areEqual(this.onTertiary, colorProviders.onTertiary) && Intrinsics.areEqual(this.tertiaryContainer, colorProviders.tertiaryContainer) && Intrinsics.areEqual(this.onTertiaryContainer, colorProviders.onTertiaryContainer) && Intrinsics.areEqual(this.error, colorProviders.error) && Intrinsics.areEqual(this.errorContainer, colorProviders.errorContainer) && Intrinsics.areEqual(this.onError, colorProviders.onError) && Intrinsics.areEqual(this.onErrorContainer, colorProviders.onErrorContainer) && Intrinsics.areEqual(this.background, colorProviders.background) && Intrinsics.areEqual(this.onBackground, colorProviders.onBackground) && Intrinsics.areEqual(this.surface, colorProviders.surface) && Intrinsics.areEqual(this.onSurface, colorProviders.onSurface) && Intrinsics.areEqual(this.surfaceVariant, colorProviders.surfaceVariant) && Intrinsics.areEqual(this.onSurfaceVariant, colorProviders.onSurfaceVariant) && Intrinsics.areEqual(this.outline, colorProviders.outline) && Intrinsics.areEqual(this.inverseOnSurface, colorProviders.inverseOnSurface) && Intrinsics.areEqual(this.inverseSurface, colorProviders.inverseSurface) && Intrinsics.areEqual(this.inversePrimary, colorProviders.inversePrimary) && Intrinsics.areEqual(this.widgetBackground, colorProviders.widgetBackground);
    }

    @NotNull
    public final ColorProvider getBackground() {
        return this.background;
    }

    @NotNull
    public final ColorProvider getError() {
        return this.error;
    }

    @NotNull
    public final ColorProvider getErrorContainer() {
        return this.errorContainer;
    }

    @NotNull
    public final ColorProvider getInverseOnSurface() {
        return this.inverseOnSurface;
    }

    @NotNull
    public final ColorProvider getInversePrimary() {
        return this.inversePrimary;
    }

    @NotNull
    public final ColorProvider getInverseSurface() {
        return this.inverseSurface;
    }

    @NotNull
    public final ColorProvider getOnBackground() {
        return this.onBackground;
    }

    @NotNull
    public final ColorProvider getOnError() {
        return this.onError;
    }

    @NotNull
    public final ColorProvider getOnErrorContainer() {
        return this.onErrorContainer;
    }

    @NotNull
    public final ColorProvider getOnPrimary() {
        return this.onPrimary;
    }

    @NotNull
    public final ColorProvider getOnPrimaryContainer() {
        return this.onPrimaryContainer;
    }

    @NotNull
    public final ColorProvider getOnSecondary() {
        return this.onSecondary;
    }

    @NotNull
    public final ColorProvider getOnSecondaryContainer() {
        return this.onSecondaryContainer;
    }

    @NotNull
    public final ColorProvider getOnSurface() {
        return this.onSurface;
    }

    @NotNull
    public final ColorProvider getOnSurfaceVariant() {
        return this.onSurfaceVariant;
    }

    @NotNull
    public final ColorProvider getOnTertiary() {
        return this.onTertiary;
    }

    @NotNull
    public final ColorProvider getOnTertiaryContainer() {
        return this.onTertiaryContainer;
    }

    @NotNull
    public final ColorProvider getOutline() {
        return this.outline;
    }

    @NotNull
    public final ColorProvider getPrimary() {
        return this.primary;
    }

    @NotNull
    public final ColorProvider getPrimaryContainer() {
        return this.primaryContainer;
    }

    @NotNull
    public final ColorProvider getSecondary() {
        return this.secondary;
    }

    @NotNull
    public final ColorProvider getSecondaryContainer() {
        return this.secondaryContainer;
    }

    @NotNull
    public final ColorProvider getSurface() {
        return this.surface;
    }

    @NotNull
    public final ColorProvider getSurfaceVariant() {
        return this.surfaceVariant;
    }

    @NotNull
    public final ColorProvider getTertiary() {
        return this.tertiary;
    }

    @NotNull
    public final ColorProvider getTertiaryContainer() {
        return this.tertiaryContainer;
    }

    @NotNull
    public final ColorProvider getWidgetBackground() {
        return this.widgetBackground;
    }

    public int hashCode() {
        return this.widgetBackground.hashCode() + AbstractC11014a.m12316a(this.inversePrimary, AbstractC11014a.m12316a(this.inverseSurface, AbstractC11014a.m12316a(this.inverseOnSurface, AbstractC11014a.m12316a(this.outline, AbstractC11014a.m12316a(this.onSurfaceVariant, AbstractC11014a.m12316a(this.surfaceVariant, AbstractC11014a.m12316a(this.onSurface, AbstractC11014a.m12316a(this.surface, AbstractC11014a.m12316a(this.onBackground, AbstractC11014a.m12316a(this.background, AbstractC11014a.m12316a(this.onErrorContainer, AbstractC11014a.m12316a(this.onError, AbstractC11014a.m12316a(this.errorContainer, AbstractC11014a.m12316a(this.error, AbstractC11014a.m12316a(this.onTertiaryContainer, AbstractC11014a.m12316a(this.tertiaryContainer, AbstractC11014a.m12316a(this.onTertiary, AbstractC11014a.m12316a(this.tertiary, AbstractC11014a.m12316a(this.onSecondaryContainer, AbstractC11014a.m12316a(this.secondaryContainer, AbstractC11014a.m12316a(this.onSecondary, AbstractC11014a.m12316a(this.secondary, AbstractC11014a.m12316a(this.onPrimaryContainer, AbstractC11014a.m12316a(this.primaryContainer, AbstractC11014a.m12316a(this.onPrimary, this.primary.hashCode() * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31);
    }

    @NotNull
    public String toString() {
        return "ColorProviders(primary=" + this.primary + ", onPrimary=" + this.onPrimary + ", primaryContainer=" + this.primaryContainer + ", onPrimaryContainer=" + this.onPrimaryContainer + ", secondary=" + this.secondary + ", onSecondary=" + this.onSecondary + ", secondaryContainer=" + this.secondaryContainer + ", onSecondaryContainer=" + this.onSecondaryContainer + ", tertiary=" + this.tertiary + ", onTertiary=" + this.onTertiary + ", tertiaryContainer=" + this.tertiaryContainer + ", onTertiaryContainer=" + this.onTertiaryContainer + ", error=" + this.error + ", errorContainer=" + this.errorContainer + ", onError=" + this.onError + ", onErrorContainer=" + this.onErrorContainer + ", background=" + this.background + ", onBackground=" + this.onBackground + ", surface=" + this.surface + ", onSurface=" + this.onSurface + ", surfaceVariant=" + this.surfaceVariant + ", onSurfaceVariant=" + this.onSurfaceVariant + ", outline=" + this.outline + ", inverseOnSurface=" + this.inverseOnSurface + ", inverseSurface=" + this.inverseSurface + ", inversePrimary=" + this.inversePrimary + ")widgetBackground=" + this.widgetBackground;
    }

    public /* synthetic */ ColorProviders(ColorProvider colorProvider, ColorProvider colorProvider2, ColorProvider colorProvider3, ColorProvider colorProvider4, ColorProvider colorProvider5, ColorProvider colorProvider6, ColorProvider colorProvider7, ColorProvider colorProvider8, ColorProvider colorProvider9, ColorProvider colorProvider10, ColorProvider colorProvider11, ColorProvider colorProvider12, ColorProvider colorProvider13, ColorProvider colorProvider14, ColorProvider colorProvider15, ColorProvider colorProvider16, ColorProvider colorProvider17, ColorProvider colorProvider18, ColorProvider colorProvider19, ColorProvider colorProvider20, ColorProvider colorProvider21, ColorProvider colorProvider22, ColorProvider colorProvider23, ColorProvider colorProvider24, ColorProvider colorProvider25, ColorProvider colorProvider26, DefaultConstructorMarker defaultConstructorMarker) {
        this(colorProvider, colorProvider2, colorProvider3, colorProvider4, colorProvider5, colorProvider6, colorProvider7, colorProvider8, colorProvider9, colorProvider10, colorProvider11, colorProvider12, colorProvider13, colorProvider14, colorProvider15, colorProvider16, colorProvider17, colorProvider18, colorProvider19, colorProvider20, colorProvider21, colorProvider22, colorProvider23, colorProvider24, colorProvider25, colorProvider26);
    }

    private ColorProviders(ColorProvider colorProvider, ColorProvider colorProvider2, ColorProvider colorProvider3, ColorProvider colorProvider4, ColorProvider colorProvider5, ColorProvider colorProvider6, ColorProvider colorProvider7, ColorProvider colorProvider8, ColorProvider colorProvider9, ColorProvider colorProvider10, ColorProvider colorProvider11, ColorProvider colorProvider12, ColorProvider colorProvider13, ColorProvider colorProvider14, ColorProvider colorProvider15, ColorProvider colorProvider16, ColorProvider colorProvider17, ColorProvider colorProvider18, ColorProvider colorProvider19, ColorProvider colorProvider20, ColorProvider colorProvider21, ColorProvider colorProvider22, ColorProvider colorProvider23, ColorProvider colorProvider24, ColorProvider colorProvider25, ColorProvider colorProvider26, ColorProvider colorProvider27) {
        this.primary = colorProvider;
        this.onPrimary = colorProvider2;
        this.primaryContainer = colorProvider3;
        this.onPrimaryContainer = colorProvider4;
        this.secondary = colorProvider5;
        this.onSecondary = colorProvider6;
        this.secondaryContainer = colorProvider7;
        this.onSecondaryContainer = colorProvider8;
        this.tertiary = colorProvider9;
        this.onTertiary = colorProvider10;
        this.tertiaryContainer = colorProvider11;
        this.onTertiaryContainer = colorProvider12;
        this.error = colorProvider13;
        this.errorContainer = colorProvider14;
        this.onError = colorProvider15;
        this.onErrorContainer = colorProvider16;
        this.background = colorProvider17;
        this.onBackground = colorProvider18;
        this.surface = colorProvider19;
        this.onSurface = colorProvider20;
        this.surfaceVariant = colorProvider21;
        this.onSurfaceVariant = colorProvider22;
        this.outline = colorProvider23;
        this.inverseOnSurface = colorProvider24;
        this.inverseSurface = colorProvider25;
        this.inversePrimary = colorProvider26;
        this.widgetBackground = colorProvider27;
    }

    @Deprecated(message = "Hidden")
    private ColorProviders(ColorProvider colorProvider, ColorProvider colorProvider2, ColorProvider colorProvider3, ColorProvider colorProvider4, ColorProvider colorProvider5, ColorProvider colorProvider6, ColorProvider colorProvider7, ColorProvider colorProvider8, ColorProvider colorProvider9, ColorProvider colorProvider10, ColorProvider colorProvider11, ColorProvider colorProvider12, ColorProvider colorProvider13, ColorProvider colorProvider14, ColorProvider colorProvider15, ColorProvider colorProvider16, ColorProvider colorProvider17, ColorProvider colorProvider18, ColorProvider colorProvider19, ColorProvider colorProvider20, ColorProvider colorProvider21, ColorProvider colorProvider22, ColorProvider colorProvider23, ColorProvider colorProvider24, ColorProvider colorProvider25, ColorProvider colorProvider26) {
        this.primary = colorProvider;
        this.onPrimary = colorProvider2;
        this.primaryContainer = colorProvider3;
        this.onPrimaryContainer = colorProvider4;
        this.secondary = colorProvider5;
        this.onSecondary = colorProvider6;
        this.secondaryContainer = colorProvider7;
        this.onSecondaryContainer = colorProvider8;
        this.tertiary = colorProvider9;
        this.onTertiary = colorProvider10;
        this.tertiaryContainer = colorProvider11;
        this.onTertiaryContainer = colorProvider12;
        this.error = colorProvider13;
        this.errorContainer = colorProvider14;
        this.onError = colorProvider15;
        this.onErrorContainer = colorProvider16;
        this.background = colorProvider17;
        this.onBackground = colorProvider18;
        this.surface = colorProvider19;
        this.onSurface = colorProvider20;
        this.surfaceVariant = colorProvider21;
        this.onSurfaceVariant = colorProvider22;
        this.outline = colorProvider23;
        this.inverseOnSurface = colorProvider24;
        this.inverseSurface = colorProvider25;
        this.inversePrimary = colorProvider26;
        this.widgetBackground = ColorProviderKt.m22055ColorProvider8_81llA(Color.INSTANCE.m18561getUnspecified0d7_KjU());
    }
}
