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
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002Ba\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007HÆ\u0003Jk\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\u0004HÖ\u0001J\t\u0010+\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0013\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015¨\u0006,"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/logic/TableCell;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/HtmlNode;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/ParentCapableNode;", "colSpan", "", "rowSpan", "classes", "", "", "textColor", "textSize", "", "textAlign", "backgroundColor", "children", "<init>", "(IILjava/util/List;Ljava/lang/String;FLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getColSpan", "()I", "getRowSpan", "getClasses", "()Ljava/util/List;", "getTextColor", "()Ljava/lang/String;", "getTextSize", "()F", "getTextAlign", "getBackgroundColor", "getChildren", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "toString", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final /* data */ class TableCell extends HtmlNode implements ParentCapableNode {

    @Nullable
    private final String backgroundColor;

    @NotNull
    private final List<HtmlNode> children;

    @NotNull
    private final List<String> classes;
    private final int colSpan;
    private final int rowSpan;

    @Nullable
    private final String textAlign;

    @Nullable
    private final String textColor;
    private final float textSize;

    public /* synthetic */ TableCell(int i, int i2, List list, String str, float f, String str2, String str3, List list2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 1 : i, (i4 & 2) != 0 ? 1 : i2, (i4 & 4) != 0 ? CollectionsKt.emptyList() : list, str, f, str2, str3, (i4 & 128) != 0 ? CollectionsKt.emptyList() : list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TableCell copy$default(TableCell tableCell, int i, int i2, List list, String str, float f, String str2, String str3, List list2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = tableCell.colSpan;
        }
        if ((i4 & 2) != 0) {
            i2 = tableCell.rowSpan;
        }
        if ((i4 & 4) != 0) {
            list = tableCell.classes;
        }
        if ((i4 & 8) != 0) {
            str = tableCell.textColor;
        }
        if ((i4 & 16) != 0) {
            f = tableCell.textSize;
        }
        if ((i4 & 32) != 0) {
            str2 = tableCell.textAlign;
        }
        if ((i4 & 64) != 0) {
            str3 = tableCell.backgroundColor;
        }
        if ((i4 & 128) != 0) {
            list2 = tableCell.children;
        }
        String str4 = str3;
        List list3 = list2;
        float f4 = f;
        String str5 = str2;
        return tableCell.copy(i, i2, list, str, f4, str5, str4, list3);
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

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTextColor() {
        return this.textColor;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final float getTextSize() {
        return this.textSize;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getTextAlign() {
        return this.textAlign;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    @NotNull
    public final List<HtmlNode> component8() {
        return this.children;
    }

    @NotNull
    public final TableCell copy(int colSpan, int rowSpan, @NotNull List<String> classes, @Nullable String textColor, float textSize, @Nullable String textAlign, @Nullable String backgroundColor, @NotNull List<? extends HtmlNode> children) {
        Intrinsics.checkNotNullParameter(classes, "classes");
        Intrinsics.checkNotNullParameter(children, "children");
        return new TableCell(colSpan, rowSpan, classes, textColor, textSize, textAlign, backgroundColor, children);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TableCell)) {
            return false;
        }
        TableCell tableCell = (TableCell) other;
        return this.colSpan == tableCell.colSpan && this.rowSpan == tableCell.rowSpan && Intrinsics.areEqual(this.classes, tableCell.classes) && Intrinsics.areEqual(this.textColor, tableCell.textColor) && Float.compare(this.textSize, tableCell.textSize) == 0 && Intrinsics.areEqual(this.textAlign, tableCell.textAlign) && Intrinsics.areEqual(this.backgroundColor, tableCell.backgroundColor) && Intrinsics.areEqual(this.children, tableCell.children);
    }

    @Nullable
    public final String getBackgroundColor() {
        return this.backgroundColor;
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

    @Nullable
    public final String getTextAlign() {
        return this.textAlign;
    }

    @Nullable
    public final String getTextColor() {
        return this.textColor;
    }

    public final float getTextSize() {
        return this.textSize;
    }

    public int hashCode() {
        int iM1159e = AbstractC0622a.m1159e(this.classes, AbstractC0622a.m1157c(this.rowSpan, Integer.hashCode(this.colSpan) * 31, 31), 31);
        String str = this.textColor;
        int iM1156b = AbstractC0622a.m1156b(this.textSize, (iM1159e + (str == null ? 0 : str.hashCode())) * 31, 31);
        String str2 = this.textAlign;
        int iHashCode = (iM1156b + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.backgroundColor;
        return this.children.hashCode() + ((iHashCode + (str3 != null ? str3.hashCode() : 0)) * 31);
    }

    @NotNull
    public String toString() {
        int i = this.colSpan;
        int i2 = this.rowSpan;
        List<String> list = this.classes;
        String str = this.textColor;
        float f = this.textSize;
        String str2 = this.textAlign;
        String str3 = this.backgroundColor;
        List<HtmlNode> list2 = this.children;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "TableCell(colSpan=", ", rowSpan=", ", classes=");
        sbM1173s.append(list);
        sbM1173s.append(", textColor=");
        sbM1173s.append(str);
        sbM1173s.append(", textSize=");
        sbM1173s.append(f);
        sbM1173s.append(", textAlign=");
        sbM1173s.append(str2);
        sbM1173s.append(", backgroundColor=");
        sbM1173s.append(str3);
        sbM1173s.append(", children=");
        sbM1173s.append(list2);
        sbM1173s.append(")");
        return sbM1173s.toString();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TableCell(int i, int i2, @NotNull List<String> classes, @Nullable String str, float f, @Nullable String str2, @Nullable String str3, @NotNull List<? extends HtmlNode> children) {
        super(null);
        Intrinsics.checkNotNullParameter(classes, "classes");
        Intrinsics.checkNotNullParameter(children, "children");
        this.colSpan = i;
        this.rowSpan = i2;
        this.classes = classes;
        this.textColor = str;
        this.textSize = f;
        this.textAlign = str2;
        this.backgroundColor = str3;
        this.children = children;
    }
}
