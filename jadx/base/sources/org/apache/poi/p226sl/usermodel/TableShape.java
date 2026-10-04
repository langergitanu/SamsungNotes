package org.apache.poi.p226sl.usermodel;

import org.apache.poi.p226sl.usermodel.Shape;
import org.apache.poi.p226sl.usermodel.TextParagraph;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface TableShape<S extends Shape<S, P>, P extends TextParagraph<S, P, ?>> extends Shape<S, P>, PlaceableShape<S, P> {
    TableCell<S, P> getCell(int i, int i2);

    double getColumnWidth(int i);

    int getNumberOfColumns();

    int getNumberOfRows();

    double getRowHeight(int i);

    void setColumnWidth(int i, double d);

    void setRowHeight(int i, double d);
}
