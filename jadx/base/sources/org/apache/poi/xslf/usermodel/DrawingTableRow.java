package org.apache.poi.xslf.usermodel;

import org.apache.poi.util.Removal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableCell;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Removal(version = "3.18")
public class DrawingTableRow {
    private final CTTableRow row;

    public DrawingTableRow(CTTableRow cTTableRow) {
        this.row = cTTableRow;
    }

    public DrawingTableCell[] getCells() {
        CTTableCell[] tcArray = this.row.getTcArray();
        int length = tcArray.length;
        DrawingTableCell[] drawingTableCellArr = new DrawingTableCell[length];
        for (int i = 0; i < length; i++) {
            drawingTableCellArr[i] = new DrawingTableCell(tcArray[i]);
        }
        return drawingTableCellArr;
    }
}
