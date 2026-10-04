package com.samsung.android.support.senl.p148nt.base.composer.html.logic;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/logic/OrderedList;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/HtmlNode;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/ParentCapableNode;", "start", "", "classes", "", "", "children", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/ListItem;", "<init>", "(ILjava/util/List;Ljava/util/List;)V", "getStart", "()I", "getClasses", "()Ljava/util/List;", "getChildren", "fixed", "", "getFixed", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final /* data */ class OrderedList extends HtmlNode implements ParentCapableNode {

    @NotNull
    private final List<ListItem> children;

    @NotNull
    private final List<String> classes;
    private final boolean fixed;
    private final int start;

    public OrderedList() {
        this(0, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OrderedList copy$default(OrderedList orderedList, int i, List list, List list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = orderedList.start;
        }
        if ((i2 & 2) != 0) {
            list = orderedList.classes;
        }
        if ((i2 & 4) != 0) {
            list2 = orderedList.children;
        }
        return orderedList.copy(i, list, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getStart() {
        return this.start;
    }

    @NotNull
    public final List<String> component2() {
        return this.classes;
    }

    @NotNull
    public final List<ListItem> component3() {
        return this.children;
    }

    @NotNull
    public final OrderedList copy(int start, @NotNull List<String> classes, @NotNull List<ListItem> children) {
        Intrinsics.checkNotNullParameter(classes, "classes");
        Intrinsics.checkNotNullParameter(children, "children");
        return new OrderedList(start, classes, children);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OrderedList)) {
            return false;
        }
        OrderedList orderedList = (OrderedList) other;
        return this.start == orderedList.start && Intrinsics.areEqual(this.classes, orderedList.classes) && Intrinsics.areEqual(this.children, orderedList.children);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.html.logic.ParentCapableNode
    @NotNull
    public List<ListItem> getChildren() {
        return this.children;
    }

    @NotNull
    public final List<String> getClasses() {
        return this.classes;
    }

    public final boolean getFixed() {
        return this.fixed;
    }

    public final int getStart() {
        return this.start;
    }

    public int hashCode() {
        return this.children.hashCode() + AbstractC0622a.m1159e(this.classes, Integer.hashCode(this.start) * 31, 31);
    }

    @NotNull
    public String toString() {
        int i = this.start;
        List<String> list = this.classes;
        List<ListItem> list2 = this.children;
        StringBuilder sb = new StringBuilder("OrderedList(start=");
        sb.append(i);
        sb.append(", classes=");
        sb.append(list);
        sb.append(", children=");
        return AbstractC0541b.m777s(sb, list2, ")");
    }

    public /* synthetic */ OrderedList(int i, List list, List list2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 1 : i, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list, (i2 & 4) != 0 ? CollectionsKt.emptyList() : list2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderedList(int i, @NotNull List<String> classes, @NotNull List<ListItem> children) {
        super(null);
        Intrinsics.checkNotNullParameter(classes, "classes");
        Intrinsics.checkNotNullParameter(children, "children");
        this.start = i;
        this.classes = classes;
        this.children = children;
        this.fixed = i > 1;
    }
}
