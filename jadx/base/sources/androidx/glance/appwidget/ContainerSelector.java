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
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b\u0016J\u0016\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b\u0018J=\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001ø\u0001\u0000¢\u0006\u0002\b\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\b\u001a\u0004\u0018\u00010\tø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, m13886d2 = {"Landroidx/glance/appwidget/ContainerSelector;", "", "type", "Landroidx/glance/appwidget/LayoutType;", "numChildren", "", "horizontalAlignment", "Landroidx/glance/layout/Alignment$Horizontal;", "verticalAlignment", "Landroidx/glance/layout/Alignment$Vertical;", "(Landroidx/glance/appwidget/LayoutType;ILandroidx/glance/layout/Alignment$Horizontal;Landroidx/glance/layout/Alignment$Vertical;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getHorizontalAlignment-Y9TK7ig", "()Landroidx/glance/layout/Alignment$Horizontal;", "getNumChildren", "()I", "getType", "()Landroidx/glance/appwidget/LayoutType;", "getVerticalAlignment-TcxAxEM", "()Landroidx/glance/layout/Alignment$Vertical;", "component1", "component2", "component3", "component3-Y9TK7ig", "component4", "component4-TcxAxEM", "copy", "copy-4Me4wgM", "equals", "", "other", "hashCode", "toString", "", "glance-appwidget_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final /* data */ class ContainerSelector {
    public static final int $stable = 0;

    @Nullable
    private final Alignment.Horizontal horizontalAlignment;
    private final int numChildren;

    @NotNull
    private final LayoutType type;

    @Nullable
    private final Alignment.Vertical verticalAlignment;

    public /* synthetic */ ContainerSelector(LayoutType layoutType, int i, Alignment.Horizontal horizontal, Alignment.Vertical vertical, DefaultConstructorMarker defaultConstructorMarker) {
        this(layoutType, i, horizontal, vertical);
    }

    /* JADX INFO: renamed from: copy-4Me4wgM$default, reason: not valid java name */
    public static /* synthetic */ ContainerSelector m21279copy4Me4wgM$default(ContainerSelector containerSelector, LayoutType layoutType, int i, Alignment.Horizontal horizontal, Alignment.Vertical vertical, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            layoutType = containerSelector.type;
        }
        if ((i2 & 2) != 0) {
            i = containerSelector.numChildren;
        }
        if ((i2 & 4) != 0) {
            horizontal = containerSelector.horizontalAlignment;
        }
        if ((i2 & 8) != 0) {
            vertical = containerSelector.verticalAlignment;
        }
        return containerSelector.m21282copy4Me4wgM(layoutType, i, horizontal, vertical);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final LayoutType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getNumChildren() {
        return this.numChildren;
    }

    @Nullable
    /* JADX INFO: renamed from: component3-Y9TK7ig, reason: not valid java name and from getter */
    public final Alignment.Horizontal getHorizontalAlignment() {
        return this.horizontalAlignment;
    }

    @Nullable
    /* JADX INFO: renamed from: component4-TcxAxEM, reason: not valid java name and from getter */
    public final Alignment.Vertical getVerticalAlignment() {
        return this.verticalAlignment;
    }

    @NotNull
    /* JADX INFO: renamed from: copy-4Me4wgM, reason: not valid java name */
    public final ContainerSelector m21282copy4Me4wgM(@NotNull LayoutType type, int numChildren, @Nullable Alignment.Horizontal horizontalAlignment, @Nullable Alignment.Vertical verticalAlignment) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new ContainerSelector(type, numChildren, horizontalAlignment, verticalAlignment, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContainerSelector)) {
            return false;
        }
        ContainerSelector containerSelector = (ContainerSelector) other;
        return this.type == containerSelector.type && this.numChildren == containerSelector.numChildren && Intrinsics.areEqual(this.horizontalAlignment, containerSelector.horizontalAlignment) && Intrinsics.areEqual(this.verticalAlignment, containerSelector.verticalAlignment);
    }

    @Nullable
    /* JADX INFO: renamed from: getHorizontalAlignment-Y9TK7ig, reason: not valid java name */
    public final Alignment.Horizontal m21283getHorizontalAlignmentY9TK7ig() {
        return this.horizontalAlignment;
    }

    public final int getNumChildren() {
        return this.numChildren;
    }

    @NotNull
    public final LayoutType getType() {
        return this.type;
    }

    @Nullable
    /* JADX INFO: renamed from: getVerticalAlignment-TcxAxEM, reason: not valid java name */
    public final Alignment.Vertical m21284getVerticalAlignmentTcxAxEM() {
        return this.verticalAlignment;
    }

    public int hashCode() {
        int iM1157c = AbstractC0622a.m1157c(this.numChildren, this.type.hashCode() * 31, 31);
        Alignment.Horizontal horizontal = this.horizontalAlignment;
        int iM21439hashCodeimpl = (iM1157c + (horizontal == null ? 0 : Alignment.Horizontal.m21439hashCodeimpl(horizontal.getValue()))) * 31;
        Alignment.Vertical vertical = this.verticalAlignment;
        return iM21439hashCodeimpl + (vertical != null ? Alignment.Vertical.m21449hashCodeimpl(vertical.getValue()) : 0);
    }

    @NotNull
    public String toString() {
        return "ContainerSelector(type=" + this.type + ", numChildren=" + this.numChildren + ", horizontalAlignment=" + this.horizontalAlignment + ", verticalAlignment=" + this.verticalAlignment + ")";
    }

    private ContainerSelector(LayoutType type, int i, Alignment.Horizontal horizontal, Alignment.Vertical vertical) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.numChildren = i;
        this.horizontalAlignment = horizontal;
        this.verticalAlignment = vertical;
    }

    public /* synthetic */ ContainerSelector(LayoutType layoutType, int i, Alignment.Horizontal horizontal, Alignment.Vertical vertical, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(layoutType, i, (i2 & 4) != 0 ? null : horizontal, (i2 & 8) != 0 ? null : vertical, null);
    }
}
