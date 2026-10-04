package org.apache.poi.p227ss.usermodel;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface Table {
    public static final Pattern isStructuredReference = Pattern.compile("[a-zA-Z_\\\\][a-zA-Z0-9._]*\\[.*\\]");

    boolean contains(Cell cell);

    int findColumnIndex(String str);

    int getEndColIndex();

    int getEndRowIndex();

    int getHeaderRowCount();

    String getName();

    String getSheetName();

    int getStartColIndex();

    int getStartRowIndex();

    TableStyleInfo getStyle();

    String getStyleName();

    int getTotalsRowCount();

    boolean isHasTotalsRow();
}
