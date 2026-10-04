package androidx.glance.appwidget;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.GlanceModifier;
import androidx.glance.unit.ColorProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m13886d2 = {"Landroidx/glance/appwidget/BackgroundTintModifier;", "Landroidx/glance/GlanceModifier$Element;", "tint", "Landroidx/glance/unit/ColorProvider;", "(Landroidx/glance/unit/ColorProvider;)V", "getTint", "()Landroidx/glance/unit/ColorProvider;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class BackgroundTintModifier implements GlanceModifier.Element {
    public static final int $stable = 0;

    @Nullable
    private final ColorProvider tint;

    public BackgroundTintModifier(@Nullable ColorProvider colorProvider) {
        this.tint = colorProvider;
    }

    public static /* synthetic */ BackgroundTintModifier copy$default(BackgroundTintModifier backgroundTintModifier, ColorProvider colorProvider, int i, Object obj) {
        if ((i & 1) != 0) {
            colorProvider = backgroundTintModifier.tint;
        }
        return backgroundTintModifier.copy(colorProvider);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ColorProvider getTint() {
        return this.tint;
    }

    @NotNull
    public final BackgroundTintModifier copy(@Nullable ColorProvider tint) {
        return new BackgroundTintModifier(tint);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof BackgroundTintModifier) && Intrinsics.areEqual(this.tint, ((BackgroundTintModifier) other).tint);
    }

    @Nullable
    public final ColorProvider getTint() {
        return this.tint;
    }

    public int hashCode() {
        ColorProvider colorProvider = this.tint;
        if (colorProvider == null) {
            return 0;
        }
        return colorProvider.hashCode();
    }

    @NotNull
    public String toString() {
        return "BackgroundTintModifier(tint=" + this.tint + ")";
    }
}
