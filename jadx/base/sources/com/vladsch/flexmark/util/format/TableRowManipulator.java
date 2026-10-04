package com.vladsch.flexmark.util.format;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface TableRowManipulator {
    public static final int BREAK = Integer.MIN_VALUE;

    int apply(TableRow tableRow, int i, ArrayList<TableRow> arrayList, int i2);
}
