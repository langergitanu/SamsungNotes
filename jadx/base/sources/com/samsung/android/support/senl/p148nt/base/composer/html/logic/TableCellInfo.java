package com.samsung.android.support.senl.p148nt.base.composer.html.logic;

import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003JE\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010 \u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u0017\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0010¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/logic/TableCellInfo;", "", "content", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/TextBox;", "colSpan", "", "rowSpan", "rowIndex", "colIndex", "isHeader", "", "<init>", "(Lcom/samsung/android/support/senl/nt/base/composer/html/logic/TextBox;IIIIZ)V", "getContent", "()Lcom/samsung/android/support/senl/nt/base/composer/html/logic/TextBox;", "getColSpan", "()I", "getRowSpan", "getRowIndex", "getColIndex", "()Z", "rowEndIndex", "getRowEndIndex", "colEndIndex", "getColEndIndex", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final /* data */ class TableCellInfo {
    private final int colIndex;
    private final int colSpan;

    @NotNull
    private final TextBox content;
    private final boolean isHeader;
    private final int rowIndex;
    private final int rowSpan;

    public TableCellInfo(@NotNull TextBox content, int i, int i2, int i4, int i5, boolean z) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.content = content;
        this.colSpan = i;
        this.rowSpan = i2;
        this.rowIndex = i4;
        this.colIndex = i5;
        this.isHeader = z;
    }

    public static /* synthetic */ TableCellInfo copy$default(TableCellInfo tableCellInfo, TextBox textBox, int i, int i2, int i4, int i5, boolean z, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            textBox = tableCellInfo.content;
        }
        if ((i6 & 2) != 0) {
            i = tableCellInfo.colSpan;
        }
        if ((i6 & 4) != 0) {
            i2 = tableCellInfo.rowSpan;
        }
        if ((i6 & 8) != 0) {
            i4 = tableCellInfo.rowIndex;
        }
        if ((i6 & 16) != 0) {
            i5 = tableCellInfo.colIndex;
        }
        if ((i6 & 32) != 0) {
            z = tableCellInfo.isHeader;
        }
        int i7 = i5;
        boolean z2 = z;
        return tableCellInfo.copy(textBox, i, i2, i4, i7, z2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final TextBox getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getColSpan() {
        return this.colSpan;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getRowSpan() {
        return this.rowSpan;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getRowIndex() {
        return this.rowIndex;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getColIndex() {
        return this.colIndex;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsHeader() {
        return this.isHeader;
    }

    @NotNull
    public final TableCellInfo copy(@NotNull TextBox content, int colSpan, int rowSpan, int rowIndex, int colIndex, boolean isHeader) {
        Intrinsics.checkNotNullParameter(content, "content");
        return new TableCellInfo(content, colSpan, rowSpan, rowIndex, colIndex, isHeader);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TableCellInfo)) {
            return false;
        }
        TableCellInfo tableCellInfo = (TableCellInfo) other;
        return Intrinsics.areEqual(this.content, tableCellInfo.content) && this.colSpan == tableCellInfo.colSpan && this.rowSpan == tableCellInfo.rowSpan && this.rowIndex == tableCellInfo.rowIndex && this.colIndex == tableCellInfo.colIndex && this.isHeader == tableCellInfo.isHeader;
    }

    public final int getColEndIndex() {
        return (this.colIndex + this.colSpan) - 1;
    }

    public final int getColIndex() {
        return this.colIndex;
    }

    public final int getColSpan() {
        return this.colSpan;
    }

    @NotNull
    public final TextBox getContent() {
        return this.content;
    }

    public final int getRowEndIndex() {
        return (this.rowIndex + this.rowSpan) - 1;
    }

    public final int getRowIndex() {
        return this.rowIndex;
    }

    public final int getRowSpan() {
        return this.rowSpan;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isHeader) + AbstractC0622a.m1157c(this.colIndex, AbstractC0622a.m1157c(this.rowIndex, AbstractC0622a.m1157c(this.rowSpan, AbstractC0622a.m1157c(this.colSpan, this.content.hashCode() * 31, 31), 31), 31), 31);
    }

    public final boolean isHeader() {
        return this.isHeader;
    }

    @NotNull
    public String toString() {
        TextBox textBox = this.content;
        int i = this.colSpan;
        int i2 = this.rowSpan;
        int i4 = this.rowIndex;
        int i5 = this.colIndex;
        boolean z = this.isHeader;
        StringBuilder sb = new StringBuilder("TableCellInfo(content=");
        sb.append(textBox);
        sb.append(", colSpan=");
        sb.append(i);
        sb.append(", rowSpan=");
        AbstractC2821a.m2235z(sb, i2, i4, ", rowIndex=", ", colIndex=");
        sb.append(i5);
        sb.append(", isHeader=");
        sb.append(z);
        sb.append(")");
        return sb.toString();
    }

    public /* synthetic */ TableCellInfo(TextBox textBox, int i, int i2, int i4, int i5, boolean z, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(textBox, (i6 & 2) != 0 ? 1 : i, (i6 & 4) != 0 ? 1 : i2, i4, i5, (i6 & 32) != 0 ? false : z);
    }
}
