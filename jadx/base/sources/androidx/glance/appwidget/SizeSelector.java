package androidx.glance.appwidget;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, m13886d2 = {"Landroidx/glance/appwidget/SizeSelector;", "", "width", "Landroidx/glance/appwidget/LayoutSize;", "height", "(Landroidx/glance/appwidget/LayoutSize;Landroidx/glance/appwidget/LayoutSize;)V", "getHeight", "()Landroidx/glance/appwidget/LayoutSize;", "getWidth", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class SizeSelector {
    public static final int $stable = 0;

    @NotNull
    private final LayoutSize height;

    @NotNull
    private final LayoutSize width;

    public SizeSelector(@NotNull LayoutSize width, @NotNull LayoutSize height) {
        Intrinsics.checkNotNullParameter(width, "width");
        Intrinsics.checkNotNullParameter(height, "height");
        this.width = width;
        this.height = height;
    }

    public static /* synthetic */ SizeSelector copy$default(SizeSelector sizeSelector, LayoutSize layoutSize, LayoutSize layoutSize2, int i, Object obj) {
        if ((i & 1) != 0) {
            layoutSize = sizeSelector.width;
        }
        if ((i & 2) != 0) {
            layoutSize2 = sizeSelector.height;
        }
        return sizeSelector.copy(layoutSize, layoutSize2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final LayoutSize getWidth() {
        return this.width;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final LayoutSize getHeight() {
        return this.height;
    }

    @NotNull
    public final SizeSelector copy(@NotNull LayoutSize width, @NotNull LayoutSize height) {
        Intrinsics.checkNotNullParameter(width, "width");
        Intrinsics.checkNotNullParameter(height, "height");
        return new SizeSelector(width, height);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SizeSelector)) {
            return false;
        }
        SizeSelector sizeSelector = (SizeSelector) other;
        return this.width == sizeSelector.width && this.height == sizeSelector.height;
    }

    @NotNull
    public final LayoutSize getHeight() {
        return this.height;
    }

    @NotNull
    public final LayoutSize getWidth() {
        return this.width;
    }

    public int hashCode() {
        return this.height.hashCode() + (this.width.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return "SizeSelector(width=" + this.width + ", height=" + this.height + ")";
    }
}
