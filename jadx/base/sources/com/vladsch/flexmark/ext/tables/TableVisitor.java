package com.vladsch.flexmark.ext.tables;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface TableVisitor {
    void visit(TableBlock tableBlock);

    void visit(TableBody tableBody);

    void visit(TableCaption tableCaption);

    void visit(TableCell tableCell);

    void visit(TableHead tableHead);

    void visit(TableRow tableRow);

    void visit(TableSeparator tableSeparator);
}
