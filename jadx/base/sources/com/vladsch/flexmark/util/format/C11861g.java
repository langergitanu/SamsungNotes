package com.vladsch.flexmark.util.format;

import java.util.ArrayList;

/* JADX INFO: renamed from: com.vladsch.flexmark.util.format.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11861g implements TableRowManipulator, TableCellManipulator {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8390a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f8391b;

    public /* synthetic */ C11861g(Object obj, int i) {
        this.f8390a = i;
        this.f8391b = obj;
    }

    @Override // com.vladsch.flexmark.util.format.TableCellManipulator
    public int apply(TableCell tableCell, int i, int i2, int i4) {
        return TableRow.lambda$forAllCells$0((TableCellConsumer) this.f8391b, tableCell, i, i2, i4);
    }

    @Override // com.vladsch.flexmark.util.format.TableRowManipulator
    public int apply(TableRow tableRow, int i, ArrayList arrayList, int i2) {
        switch (this.f8390a) {
            case 0:
                return MarkdownTable.lambda$transposed$8((TableCell[][]) this.f8391b, tableRow, i, arrayList, i2);
            case 1:
                return MarkdownTable.lambda$isEmptyRowAt$7((boolean[]) this.f8391b, tableRow, i, arrayList, i2);
            default:
                return MarkdownTable.lambda$sorted$9((MarkdownTable) this.f8391b, tableRow, i, arrayList, i2);
        }
    }
}
