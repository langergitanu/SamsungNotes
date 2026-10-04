package com.vladsch.flexmark.ext.tables;

import com.vladsch.flexmark.ast.util.TextCollectingVisitor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Deprecated
public class TableTextCollectingVisitor extends TextCollectingVisitor {
    public static final Class<?>[] TABLE_LINE_BREAK_CLASSES = {TableBlock.class, TableRow.class, TableCaption.class};

    public TableTextCollectingVisitor(Class<?>... clsArr) {
        super(clsArr.length == 0 ? TABLE_LINE_BREAK_CLASSES : TextCollectingVisitor.concatArrays(TABLE_LINE_BREAK_CLASSES, clsArr));
    }
}
