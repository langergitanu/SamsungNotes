package androidx.glance.appwidget;

import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, m13886d2 = {"Landroidx/glance/appwidget/RowColumnChildSelector;", "", "type", "Landroidx/glance/appwidget/LayoutType;", "expandWidth", "", "expandHeight", "(Landroidx/glance/appwidget/LayoutType;ZZ)V", "getExpandHeight", "()Z", "getExpandWidth", "getType", "()Landroidx/glance/appwidget/LayoutType;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class RowColumnChildSelector {
    public static final int $stable = 0;
    private final boolean expandHeight;
    private final boolean expandWidth;

    @NotNull
    private final LayoutType type;

    public RowColumnChildSelector(@NotNull LayoutType type, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.expandWidth = z;
        this.expandHeight = z2;
    }

    public static /* synthetic */ RowColumnChildSelector copy$default(RowColumnChildSelector rowColumnChildSelector, LayoutType layoutType, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            layoutType = rowColumnChildSelector.type;
        }
        if ((i & 2) != 0) {
            z = rowColumnChildSelector.expandWidth;
        }
        if ((i & 4) != 0) {
            z2 = rowColumnChildSelector.expandHeight;
        }
        return rowColumnChildSelector.copy(layoutType, z, z2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final LayoutType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getExpandWidth() {
        return this.expandWidth;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getExpandHeight() {
        return this.expandHeight;
    }

    @NotNull
    public final RowColumnChildSelector copy(@NotNull LayoutType type, boolean expandWidth, boolean expandHeight) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new RowColumnChildSelector(type, expandWidth, expandHeight);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RowColumnChildSelector)) {
            return false;
        }
        RowColumnChildSelector rowColumnChildSelector = (RowColumnChildSelector) other;
        return this.type == rowColumnChildSelector.type && this.expandWidth == rowColumnChildSelector.expandWidth && this.expandHeight == rowColumnChildSelector.expandHeight;
    }

    public final boolean getExpandHeight() {
        return this.expandHeight;
    }

    public final boolean getExpandWidth() {
        return this.expandWidth;
    }

    @NotNull
    public final LayoutType getType() {
        return this.type;
    }

    public int hashCode() {
        return Boolean.hashCode(this.expandHeight) + AbstractC0622a.m1160f(this.expandWidth, this.type.hashCode() * 31, 31);
    }

    @NotNull
    public String toString() {
        LayoutType layoutType = this.type;
        boolean z = this.expandWidth;
        boolean z2 = this.expandHeight;
        StringBuilder sb = new StringBuilder("RowColumnChildSelector(type=");
        sb.append(layoutType);
        sb.append(", expandWidth=");
        sb.append(z);
        sb.append(", expandHeight=");
        return AbstractC0000a.m14k(sb, z2, ")");
    }
}
