package com.samsung.android.support.senl.p148nt.base.composer.html.logic;

import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\bHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/logic/ListItem;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/HtmlNode;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/ParentCapableNode;", "classes", "", "", "children", "wrapCnt", "", "<init>", "(Ljava/util/List;Ljava/util/List;I)V", "getClasses", "()Ljava/util/List;", "getChildren", "getWrapCnt", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final /* data */ class ListItem extends HtmlNode implements ParentCapableNode {

    @NotNull
    private final List<HtmlNode> children;

    @NotNull
    private final List<String> classes;
    private final int wrapCnt;

    public ListItem() {
        this(null, null, 0, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ListItem copy$default(ListItem listItem, List list, List list2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = listItem.classes;
        }
        if ((i2 & 2) != 0) {
            list2 = listItem.children;
        }
        if ((i2 & 4) != 0) {
            i = listItem.wrapCnt;
        }
        return listItem.copy(list, list2, i);
    }

    @NotNull
    public final List<String> component1() {
        return this.classes;
    }

    @NotNull
    public final List<HtmlNode> component2() {
        return this.children;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getWrapCnt() {
        return this.wrapCnt;
    }

    @NotNull
    public final ListItem copy(@NotNull List<String> classes, @NotNull List<? extends HtmlNode> children, int wrapCnt) {
        Intrinsics.checkNotNullParameter(classes, "classes");
        Intrinsics.checkNotNullParameter(children, "children");
        return new ListItem(classes, children, wrapCnt);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ListItem)) {
            return false;
        }
        ListItem listItem = (ListItem) other;
        return Intrinsics.areEqual(this.classes, listItem.classes) && Intrinsics.areEqual(this.children, listItem.children) && this.wrapCnt == listItem.wrapCnt;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.html.logic.ParentCapableNode
    @NotNull
    public List<HtmlNode> getChildren() {
        return this.children;
    }

    @NotNull
    public final List<String> getClasses() {
        return this.classes;
    }

    public final int getWrapCnt() {
        return this.wrapCnt;
    }

    public int hashCode() {
        return Integer.hashCode(this.wrapCnt) + AbstractC0622a.m1159e(this.children, this.classes.hashCode() * 31, 31);
    }

    @NotNull
    public String toString() {
        List<String> list = this.classes;
        List<HtmlNode> list2 = this.children;
        int i = this.wrapCnt;
        StringBuilder sb = new StringBuilder("ListItem(classes=");
        sb.append(list);
        sb.append(", children=");
        sb.append(list2);
        sb.append(", wrapCnt=");
        return AbstractC2821a.m2223n(sb, ")", i);
    }

    public /* synthetic */ ListItem(List list, List list2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? CollectionsKt.emptyList() : list, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list2, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ListItem(@NotNull List<String> classes, @NotNull List<? extends HtmlNode> children, int i) {
        super(null);
        Intrinsics.checkNotNullParameter(classes, "classes");
        Intrinsics.checkNotNullParameter(children, "children");
        this.classes = classes;
        this.children = children;
        this.wrapCnt = i;
    }
}
