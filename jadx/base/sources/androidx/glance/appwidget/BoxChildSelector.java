package androidx.glance.appwidget;

import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.glance.layout.Alignment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 1)
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0016\u0010\u0010\u001a\u00020\u0005HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\nJ\u0016\u0010\u0012\u001a\u00020\u0007HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\nJ1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\n\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, m13886d2 = {"Landroidx/glance/appwidget/BoxChildSelector;", "", "type", "Landroidx/glance/appwidget/LayoutType;", "horizontalAlignment", "Landroidx/glance/layout/Alignment$Horizontal;", "verticalAlignment", "Landroidx/glance/layout/Alignment$Vertical;", "(Landroidx/glance/appwidget/LayoutType;IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getHorizontalAlignment-PGIyAqw", "()I", "I", "getType", "()Landroidx/glance/appwidget/LayoutType;", "getVerticalAlignment-mnfRV0w", "component1", "component2", "component2-PGIyAqw", "component3", "component3-mnfRV0w", "copy", "copy-vmlqhMs", "(Landroidx/glance/appwidget/LayoutType;II)Landroidx/glance/appwidget/BoxChildSelector;", "equals", "", "other", "hashCode", "", "toString", "", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class BoxChildSelector {
    public static final int $stable = 0;
    private final int horizontalAlignment;

    @NotNull
    private final LayoutType type;
    private final int verticalAlignment;

    public /* synthetic */ BoxChildSelector(LayoutType layoutType, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(layoutType, i, i2);
    }

    /* JADX INFO: renamed from: copy-vmlqhMs$default, reason: not valid java name */
    public static /* synthetic */ BoxChildSelector m21271copyvmlqhMs$default(BoxChildSelector boxChildSelector, LayoutType layoutType, int i, int i2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            layoutType = boxChildSelector.type;
        }
        if ((i4 & 2) != 0) {
            i = boxChildSelector.horizontalAlignment;
        }
        if ((i4 & 4) != 0) {
            i2 = boxChildSelector.verticalAlignment;
        }
        return boxChildSelector.m21274copyvmlqhMs(layoutType, i, i2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final LayoutType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2-PGIyAqw, reason: not valid java name and from getter */
    public final int getHorizontalAlignment() {
        return this.horizontalAlignment;
    }

    /* JADX INFO: renamed from: component3-mnfRV0w, reason: not valid java name and from getter */
    public final int getVerticalAlignment() {
        return this.verticalAlignment;
    }

    @NotNull
    /* JADX INFO: renamed from: copy-vmlqhMs, reason: not valid java name */
    public final BoxChildSelector m21274copyvmlqhMs(@NotNull LayoutType type, int horizontalAlignment, int verticalAlignment) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new BoxChildSelector(type, horizontalAlignment, verticalAlignment, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BoxChildSelector)) {
            return false;
        }
        BoxChildSelector boxChildSelector = (BoxChildSelector) other;
        return this.type == boxChildSelector.type && Alignment.Horizontal.m21438equalsimpl0(this.horizontalAlignment, boxChildSelector.horizontalAlignment) && Alignment.Vertical.m21448equalsimpl0(this.verticalAlignment, boxChildSelector.verticalAlignment);
    }

    /* JADX INFO: renamed from: getHorizontalAlignment-PGIyAqw, reason: not valid java name */
    public final int m21275getHorizontalAlignmentPGIyAqw() {
        return this.horizontalAlignment;
    }

    @NotNull
    public final LayoutType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: getVerticalAlignment-mnfRV0w, reason: not valid java name */
    public final int m21276getVerticalAlignmentmnfRV0w() {
        return this.verticalAlignment;
    }

    public int hashCode() {
        return Alignment.Vertical.m21449hashCodeimpl(this.verticalAlignment) + ((Alignment.Horizontal.m21439hashCodeimpl(this.horizontalAlignment) + (this.type.hashCode() * 31)) * 31);
    }

    @NotNull
    public String toString() {
        LayoutType layoutType = this.type;
        String strM21440toStringimpl = Alignment.Horizontal.m21440toStringimpl(this.horizontalAlignment);
        String strM21450toStringimpl = Alignment.Vertical.m21450toStringimpl(this.verticalAlignment);
        StringBuilder sb = new StringBuilder("BoxChildSelector(type=");
        sb.append(layoutType);
        sb.append(", horizontalAlignment=");
        sb.append(strM21440toStringimpl);
        sb.append(", verticalAlignment=");
        return AbstractC0622a.m1170p(strM21450toStringimpl, ")", sb);
    }

    private BoxChildSelector(LayoutType type, int i, int i2) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.horizontalAlignment = i;
        this.verticalAlignment = i2;
    }
}
