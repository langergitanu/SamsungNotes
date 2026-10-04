package androidx.glance.appwidget;

import androidx.annotation.DrawableRes;
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
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m13886d2 = {"Landroidx/glance/appwidget/ShapeBackgroundModifier;", "Landroidx/glance/GlanceModifier$Element;", "resId", "", "colorProvider", "Landroidx/glance/unit/ColorProvider;", "(ILandroidx/glance/unit/ColorProvider;)V", "getColorProvider", "()Landroidx/glance/unit/ColorProvider;", "getResId", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class ShapeBackgroundModifier implements GlanceModifier.Element {
    public static final int $stable = 0;

    @Nullable
    private final ColorProvider colorProvider;
    private final int resId;

    public ShapeBackgroundModifier(@DrawableRes int i, @Nullable ColorProvider colorProvider) {
        this.resId = i;
        this.colorProvider = colorProvider;
    }

    public static /* synthetic */ ShapeBackgroundModifier copy$default(ShapeBackgroundModifier shapeBackgroundModifier, int i, ColorProvider colorProvider, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = shapeBackgroundModifier.resId;
        }
        if ((i2 & 2) != 0) {
            colorProvider = shapeBackgroundModifier.colorProvider;
        }
        return shapeBackgroundModifier.copy(i, colorProvider);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getResId() {
        return this.resId;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ColorProvider getColorProvider() {
        return this.colorProvider;
    }

    @NotNull
    public final ShapeBackgroundModifier copy(@DrawableRes int resId, @Nullable ColorProvider colorProvider) {
        return new ShapeBackgroundModifier(resId, colorProvider);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShapeBackgroundModifier)) {
            return false;
        }
        ShapeBackgroundModifier shapeBackgroundModifier = (ShapeBackgroundModifier) other;
        return this.resId == shapeBackgroundModifier.resId && Intrinsics.areEqual(this.colorProvider, shapeBackgroundModifier.colorProvider);
    }

    @Nullable
    public final ColorProvider getColorProvider() {
        return this.colorProvider;
    }

    public final int getResId() {
        return this.resId;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.resId) * 31;
        ColorProvider colorProvider = this.colorProvider;
        return iHashCode + (colorProvider == null ? 0 : colorProvider.hashCode());
    }

    @NotNull
    public String toString() {
        return "ShapeBackgroundModifier(resId=" + this.resId + ", colorProvider=" + this.colorProvider + ")";
    }
}
