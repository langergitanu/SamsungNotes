package com.samsung.android.support.senl.p148nt.base.composer.html.logic;

import android.graphics.RectF;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectTable;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.support.senl.p148nt.base.composer.html.common.HtmlConstants;
import com.samsung.android.support.senl.p148nt.base.composer.table.TableHelper;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001BC\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u0010*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J \u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u0019J\u0018\u0010\u001b\u001a\u00020\u001a*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003H\u0002J\u0015\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003HÆ\u0003J\u0015\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003HÆ\u0003J\u0015\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003HÆ\u0003JK\u0010\u001f\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u001aHÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006'"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/logic/TableObject;", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/DocumentElement;", Contract.HEADERS, "", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/TableCellInfo;", "body", "footers", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getHeaders", "()Ljava/util/List;", "getBody", "getFooters", "convertObject", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "initCell", "", "table", "Lcom/samsung/android/sdk/pen/document/SpenObjectTable;", "initDefaultStyle", "cell", ExternalDataConstants.Column.TEXT_BOX, "Lcom/samsung/android/sdk/pen/document/SpenObjectTextBox;", "initEmptyCell", "getDimensions", "Lkotlin/Pair;", "", "calculateMaxColumns", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nDocumentElement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DocumentElement.kt\ncom/samsung/android/support/senl/nt/base/composer/html/logic/TableObject\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1110:1\n1869#2:1111\n1869#2,2:1112\n1870#2:1114\n1#3:1115\n*S KotlinDebug\n*F\n+ 1 DocumentElement.kt\ncom/samsung/android/support/senl/nt/base/composer/html/logic/TableObject\n*L\n103#1:1111\n104#1:1112,2\n103#1:1114\n*E\n"})
public final /* data */ class TableObject extends DocumentElement {

    @NotNull
    private final List<List<TableCellInfo>> body;

    @NotNull
    private final List<List<TableCellInfo>> footers;

    @NotNull
    private final List<List<TableCellInfo>> headers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TableObject(@NotNull List<? extends List<TableCellInfo>> headers, @NotNull List<? extends List<TableCellInfo>> body, @NotNull List<? extends List<TableCellInfo>> footers) {
        super(null);
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(footers, "footers");
        this.headers = headers;
        this.body = body;
        this.footers = footers;
    }

    private final int calculateMaxColumns(List<? extends List<TableCellInfo>> list) {
        Integer num;
        Iterator<T> it = list.iterator();
        if (it.hasNext()) {
            Iterator it2 = ((List) it.next()).iterator();
            int colSpan = 0;
            while (it2.hasNext()) {
                colSpan += ((TableCellInfo) it2.next()).getColSpan();
            }
            Integer numValueOf = Integer.valueOf(colSpan);
            while (it.hasNext()) {
                Iterator it3 = ((List) it.next()).iterator();
                int colSpan2 = 0;
                while (it3.hasNext()) {
                    colSpan2 += ((TableCellInfo) it3.next()).getColSpan();
                }
                Integer numValueOf2 = Integer.valueOf(colSpan2);
                if (numValueOf.compareTo(numValueOf2) < 0) {
                    numValueOf = numValueOf2;
                }
            }
            num = numValueOf;
        } else {
            num = null;
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TableObject copy$default(TableObject tableObject, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = tableObject.headers;
        }
        if ((i & 2) != 0) {
            list2 = tableObject.body;
        }
        if ((i & 4) != 0) {
            list3 = tableObject.footers;
        }
        return tableObject.copy(list, list2, list3);
    }

    private final void initCell(List<? extends List<TableCellInfo>> list, SpenObjectTable spenObjectTable) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            for (TableCellInfo tableCellInfo : (List) it.next()) {
                SpenObjectTextBox contentObject = spenObjectTable.getContentObject(tableCellInfo.getRowIndex(), tableCellInfo.getColIndex());
                SpenObjectBase spenObjectBaseConvertObject = tableCellInfo.getContent().convertObject();
                if (spenObjectBaseConvertObject != null) {
                    contentObject.copy(spenObjectBaseConvertObject);
                }
                initDefaultStyle(spenObjectTable, tableCellInfo, contentObject);
                initEmptyCell(spenObjectTable, tableCellInfo);
            }
        }
    }

    private final void initDefaultStyle(SpenObjectTable table, TableCellInfo cell, SpenObjectTextBox textBox) {
        TableHelper.initTableCellTextBox(textBox);
        if (cell.isHeader()) {
            TableHelper.INSTANCE.setTableHeaderStyle(table, textBox, cell.getRowIndex(), cell.getColIndex());
        }
    }

    private final void initEmptyCell(SpenObjectTable table, TableCellInfo cell) {
        int colIndex;
        int colEndIndex;
        int rowIndex = cell.getRowIndex();
        int rowEndIndex = cell.getRowEndIndex();
        if (rowIndex > rowEndIndex) {
            return;
        }
        while (true) {
            if (rowIndex < table.getRowsCount() && (colIndex = cell.getColIndex()) <= (colEndIndex = cell.getColEndIndex())) {
                while (true) {
                    if (colIndex < table.getColumnsCount() && (rowIndex != cell.getRowIndex() || colIndex != cell.getColIndex())) {
                        SpenObjectTextBox contentObject = table.getContentObject(rowIndex, colIndex);
                        HtmlConstants htmlConstants = HtmlConstants.INSTANCE;
                        htmlConstants.setTypeBody1(contentObject, 0, 1);
                        contentObject.setFontSize(15.0f);
                        contentObject.setTextColor(htmlConstants.getDEF_FONT_COLOR());
                        initDefaultStyle(table, cell, contentObject);
                    }
                    if (colIndex == colEndIndex) {
                        break;
                    } else {
                        colIndex++;
                    }
                }
            }
            if (rowIndex == rowEndIndex) {
                return;
            } else {
                rowIndex++;
            }
        }
    }

    @NotNull
    public final List<List<TableCellInfo>> component1() {
        return this.headers;
    }

    @NotNull
    public final List<List<TableCellInfo>> component2() {
        return this.body;
    }

    @NotNull
    public final List<List<TableCellInfo>> component3() {
        return this.footers;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.html.logic.DocumentElement
    @NotNull
    public SpenObjectBase convertObject() {
        Pair<Integer, Integer> dimensions = getDimensions();
        SpenObjectTable spenObjectTable = new SpenObjectTable(new RectF(0.0f, 0.0f, 300.0f, 300.0f), dimensions.getFirst().intValue(), dimensions.getSecond().intValue());
        if (!this.headers.isEmpty()) {
            spenObjectTable.setHeadingRowEnabled(true);
            spenObjectTable.setHeadingBackgroundColor(TableHelper.getHeaderColor(0));
            initCell(this.headers, spenObjectTable);
        }
        initCell(this.body, spenObjectTable);
        initCell(this.footers, spenObjectTable);
        return spenObjectTable;
    }

    @NotNull
    public final TableObject copy(@NotNull List<? extends List<TableCellInfo>> headers, @NotNull List<? extends List<TableCellInfo>> body, @NotNull List<? extends List<TableCellInfo>> footers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(footers, "footers");
        return new TableObject(headers, body, footers);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TableObject)) {
            return false;
        }
        TableObject tableObject = (TableObject) other;
        return Intrinsics.areEqual(this.headers, tableObject.headers) && Intrinsics.areEqual(this.body, tableObject.body) && Intrinsics.areEqual(this.footers, tableObject.footers);
    }

    @NotNull
    public final List<List<TableCellInfo>> getBody() {
        return this.body;
    }

    @NotNull
    public final Pair<Integer, Integer> getDimensions() {
        return new Pair<>(Integer.valueOf(this.footers.size() + this.body.size() + this.headers.size()), Integer.valueOf(Math.max(calculateMaxColumns(this.headers), Math.max(calculateMaxColumns(this.body), calculateMaxColumns(this.footers)))));
    }

    @NotNull
    public final List<List<TableCellInfo>> getFooters() {
        return this.footers;
    }

    @NotNull
    public final List<List<TableCellInfo>> getHeaders() {
        return this.headers;
    }

    public int hashCode() {
        return this.footers.hashCode() + AbstractC0622a.m1159e(this.body, this.headers.hashCode() * 31, 31);
    }

    @NotNull
    public String toString() {
        List<List<TableCellInfo>> list = this.headers;
        List<List<TableCellInfo>> list2 = this.body;
        List<List<TableCellInfo>> list3 = this.footers;
        StringBuilder sb = new StringBuilder("TableObject(headers=");
        sb.append(list);
        sb.append(", body=");
        sb.append(list2);
        sb.append(", footers=");
        return AbstractC0541b.m777s(sb, list3, ")");
    }
}
