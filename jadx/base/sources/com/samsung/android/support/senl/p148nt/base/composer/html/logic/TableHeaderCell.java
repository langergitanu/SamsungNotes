package com.samsung.android.support.senl.p148nt.base.composer.html.logic;

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
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B;\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007HÆ\u0003J=\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001c\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/logic/TableHeaderCell;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/HtmlNode;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/ParentCapableNode;", "colSpan", "", "rowSpan", "classes", "", "", "children", "<init>", "(IILjava/util/List;Ljava/util/List;)V", "getColSpan", "()I", "getRowSpan", "getClasses", "()Ljava/util/List;", "getChildren", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final /* data */ class TableHeaderCell extends HtmlNode implements ParentCapableNode {

    @NotNull
    private final List<HtmlNode> children;

    @NotNull
    private final List<String> classes;
    private final int colSpan;
    private final int rowSpan;

    public TableHeaderCell() {
        this(0, 0, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TableHeaderCell copy$default(TableHeaderCell tableHeaderCell, int i, int i2, List list, List list2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = tableHeaderCell.colSpan;
        }
        if ((i4 & 2) != 0) {
            i2 = tableHeaderCell.rowSpan;
        }
        if ((i4 & 4) != 0) {
            list = tableHeaderCell.classes;
        }
        if ((i4 & 8) != 0) {
            list2 = tableHeaderCell.children;
        }
        return tableHeaderCell.copy(i, i2, list, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getColSpan() {
        return this.colSpan;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getRowSpan() {
        return this.rowSpan;
    }

    @NotNull
    public final List<String> component3() {
        return this.classes;
    }

    @NotNull
    public final List<HtmlNode> component4() {
        return this.children;
    }

    @NotNull
    public final TableHeaderCell copy(int colSpan, int rowSpan, @NotNull List<String> classes, @NotNull List<? extends HtmlNode> children) {
        Intrinsics.checkNotNullParameter(classes, "classes");
        Intrinsics.checkNotNullParameter(children, "children");
        return new TableHeaderCell(colSpan, rowSpan, classes, children);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TableHeaderCell)) {
            return false;
        }
        TableHeaderCell tableHeaderCell = (TableHeaderCell) other;
        return this.colSpan == tableHeaderCell.colSpan && this.rowSpan == tableHeaderCell.rowSpan && Intrinsics.areEqual(this.classes, tableHeaderCell.classes) && Intrinsics.areEqual(this.children, tableHeaderCell.children);
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

    public final int getColSpan() {
        return this.colSpan;
    }

    public final int getRowSpan() {
        return this.rowSpan;
    }

    public int hashCode() {
        return this.children.hashCode() + AbstractC0622a.m1159e(this.classes, AbstractC0622a.m1157c(this.rowSpan, Integer.hashCode(this.colSpan) * 31, 31), 31);
    }

    @NotNull
    public String toString() {
        int i = this.colSpan;
        int i2 = this.rowSpan;
        List<String> list = this.classes;
        List<HtmlNode> list2 = this.children;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "TableHeaderCell(colSpan=", ", rowSpan=", ", classes=");
        sbM1173s.append(list);
        sbM1173s.append(", children=");
        sbM1173s.append(list2);
        sbM1173s.append(")");
        return sbM1173s.toString();
    }

    public /* synthetic */ TableHeaderCell(int i, int i2, List list, List list2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 1 : i, (i4 & 2) != 0 ? 1 : i2, (i4 & 4) != 0 ? CollectionsKt.emptyList() : list, (i4 & 8) != 0 ? CollectionsKt.emptyList() : list2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TableHeaderCell(int i, int i2, @NotNull List<String> classes, @NotNull List<? extends HtmlNode> children) {
        super(null);
        Intrinsics.checkNotNullParameter(classes, "classes");
        Intrinsics.checkNotNullParameter(children, "children");
        this.colSpan = i;
        this.rowSpan = i2;
        this.classes = classes;
        this.children = children;
    }
}
