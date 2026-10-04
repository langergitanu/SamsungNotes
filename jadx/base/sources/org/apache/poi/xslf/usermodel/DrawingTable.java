package org.apache.poi.xslf.usermodel;

import org.apache.poi.util.Removal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTable;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Removal(version = "3.18")
public class DrawingTable {
    private final CTTable table;

    public DrawingTable(CTTable cTTable) {
        this.table = cTTable;
    }

    public DrawingTableRow[] getRows() {
        CTTableRow[] trArray = this.table.getTrArray();
        int length = trArray.length;
        DrawingTableRow[] drawingTableRowArr = new DrawingTableRow[length];
        for (int i = 0; i < length; i++) {
            drawingTableRowArr[i] = new DrawingTableRow(trArray[i]);
        }
        return drawingTableRowArr;
    }
}
