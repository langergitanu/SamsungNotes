package androidx.glance.appwidget;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.GlanceModifier;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006 "}, m13886d2 = {"Landroidx/glance/appwidget/MarginModifier;", "Landroidx/glance/GlanceModifier$Element;", "left", "Landroidx/glance/appwidget/MarginDimension;", "start", "top", "right", "end", "bottom", "(Landroidx/glance/appwidget/MarginDimension;Landroidx/glance/appwidget/MarginDimension;Landroidx/glance/appwidget/MarginDimension;Landroidx/glance/appwidget/MarginDimension;Landroidx/glance/appwidget/MarginDimension;Landroidx/glance/appwidget/MarginDimension;)V", "getBottom", "()Landroidx/glance/appwidget/MarginDimension;", "getEnd", "getLeft", "getRight", "getStart", "getTop", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class MarginModifier implements GlanceModifier.Element {
    public static final int $stable = 0;

    @NotNull
    private final MarginDimension bottom;

    @NotNull
    private final MarginDimension end;

    @NotNull
    private final MarginDimension left;

    @NotNull
    private final MarginDimension right;

    @NotNull
    private final MarginDimension start;

    @NotNull
    private final MarginDimension top;

    public MarginModifier() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ MarginModifier copy$default(MarginModifier marginModifier, MarginDimension marginDimension, MarginDimension marginDimension2, MarginDimension marginDimension3, MarginDimension marginDimension4, MarginDimension marginDimension5, MarginDimension marginDimension6, int i, Object obj) {
        if ((i & 1) != 0) {
            marginDimension = marginModifier.left;
        }
        if ((i & 2) != 0) {
            marginDimension2 = marginModifier.start;
        }
        if ((i & 4) != 0) {
            marginDimension3 = marginModifier.top;
        }
        if ((i & 8) != 0) {
            marginDimension4 = marginModifier.right;
        }
        if ((i & 16) != 0) {
            marginDimension5 = marginModifier.end;
        }
        if ((i & 32) != 0) {
            marginDimension6 = marginModifier.bottom;
        }
        MarginDimension marginDimension7 = marginDimension5;
        MarginDimension marginDimension8 = marginDimension6;
        return marginModifier.copy(marginDimension, marginDimension2, marginDimension3, marginDimension4, marginDimension7, marginDimension8);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MarginDimension getLeft() {
        return this.left;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MarginDimension getStart() {
        return this.start;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MarginDimension getTop() {
        return this.top;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MarginDimension getRight() {
        return this.right;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final MarginDimension getEnd() {
        return this.end;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final MarginDimension getBottom() {
        return this.bottom;
    }

    @NotNull
    public final MarginModifier copy(@NotNull MarginDimension left, @NotNull MarginDimension start, @NotNull MarginDimension top, @NotNull MarginDimension right, @NotNull MarginDimension end, @NotNull MarginDimension bottom) {
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(top, "top");
        Intrinsics.checkNotNullParameter(right, "right");
        Intrinsics.checkNotNullParameter(end, "end");
        Intrinsics.checkNotNullParameter(bottom, "bottom");
        return new MarginModifier(left, start, top, right, end, bottom);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MarginModifier)) {
            return false;
        }
        MarginModifier marginModifier = (MarginModifier) other;
        return Intrinsics.areEqual(this.left, marginModifier.left) && Intrinsics.areEqual(this.start, marginModifier.start) && Intrinsics.areEqual(this.top, marginModifier.top) && Intrinsics.areEqual(this.right, marginModifier.right) && Intrinsics.areEqual(this.end, marginModifier.end) && Intrinsics.areEqual(this.bottom, marginModifier.bottom);
    }

    @NotNull
    public final MarginDimension getBottom() {
        return this.bottom;
    }

    @NotNull
    public final MarginDimension getEnd() {
        return this.end;
    }

    @NotNull
    public final MarginDimension getLeft() {
        return this.left;
    }

    @NotNull
    public final MarginDimension getRight() {
        return this.right;
    }

    @NotNull
    public final MarginDimension getStart() {
        return this.start;
    }

    @NotNull
    public final MarginDimension getTop() {
        return this.top;
    }

    public int hashCode() {
        return this.bottom.hashCode() + ((this.end.hashCode() + ((this.right.hashCode() + ((this.top.hashCode() + ((this.start.hashCode() + (this.left.hashCode() * 31)) * 31)) * 31)) * 31)) * 31);
    }

    @NotNull
    public String toString() {
        return "MarginModifier(left=" + this.left + ", start=" + this.start + ", top=" + this.top + ", right=" + this.right + ", end=" + this.end + ", bottom=" + this.bottom + ")";
    }

    public MarginModifier(@NotNull MarginDimension left, @NotNull MarginDimension start, @NotNull MarginDimension top, @NotNull MarginDimension right, @NotNull MarginDimension end, @NotNull MarginDimension bottom) {
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(top, "top");
        Intrinsics.checkNotNullParameter(right, "right");
        Intrinsics.checkNotNullParameter(end, "end");
        Intrinsics.checkNotNullParameter(bottom, "bottom");
        this.left = left;
        this.start = start;
        this.top = top;
        this.right = right;
        this.end = end;
        this.bottom = bottom;
    }

    public /* synthetic */ MarginModifier(MarginDimension marginDimension, MarginDimension marginDimension2, MarginDimension marginDimension3, MarginDimension marginDimension4, MarginDimension marginDimension5, MarginDimension marginDimension6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new MarginDimension(0.0f, 0, 3, null) : marginDimension, (i & 2) != 0 ? new MarginDimension(0.0f, 0, 3, null) : marginDimension2, (i & 4) != 0 ? new MarginDimension(0.0f, 0, 3, null) : marginDimension3, (i & 8) != 0 ? new MarginDimension(0.0f, 0, 3, null) : marginDimension4, (i & 16) != 0 ? new MarginDimension(0.0f, 0, 3, null) : marginDimension5, (i & 32) != 0 ? new MarginDimension(0.0f, 0, 3, null) : marginDimension6);
    }
}
