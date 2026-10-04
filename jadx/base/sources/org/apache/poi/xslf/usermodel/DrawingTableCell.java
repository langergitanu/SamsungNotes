package org.apache.poi.xslf.usermodel;

import org.apache.poi.util.Removal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableCell;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Removal(version = "3.18")
public class DrawingTableCell {
    private final CTTableCell cell;
    private final DrawingTextBody drawingTextBody;

    public DrawingTableCell(CTTableCell cTTableCell) {
        this.cell = cTTableCell;
        this.drawingTextBody = new DrawingTextBody(cTTableCell.getTxBody());
    }

    public DrawingTextBody getTextBody() {
        return this.drawingTextBody;
    }
}
