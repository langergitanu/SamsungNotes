package org.apache.poi.xslf.usermodel;

import androidx.compose.foundation.layout.AbstractC1038a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.util.Units;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableCell;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XSLFTableRow implements Iterable<XSLFTableCell> {
    private final List<XSLFTableCell> _cells;
    private final CTTableRow _row;
    private final XSLFTable _table;

    public XSLFTableRow(CTTableRow cTTableRow, XSLFTable xSLFTable) {
        this._row = cTTableRow;
        this._table = xSLFTable;
        CTTableCell[] tcArray = cTTableRow.getTcArray();
        this._cells = new ArrayList(tcArray.length);
        for (CTTableCell cTTableCell : tcArray) {
            this._cells.add(new XSLFTableCell(cTTableCell, xSLFTable));
        }
    }

    public XSLFTableCell addCell() {
        CTTableCell cTTableCellAddNewTc = this._row.addNewTc();
        cTTableCellAddNewTc.set(XSLFTableCell.prototype());
        XSLFTableCell xSLFTableCell = new XSLFTableCell(cTTableCellAddNewTc, this._table);
        this._cells.add(xSLFTableCell);
        if (this._table.getNumberOfColumns() < this._row.sizeOfTcArray()) {
            this._table.getCTTable().getTblGrid().addNewGridCol().setW(Units.toEMU(100.0d));
        }
        this._table.updateRowColIndexes();
        return xSLFTableCell;
    }

    public List<XSLFTableCell> getCells() {
        return Collections.unmodifiableList(this._cells);
    }

    public double getHeight() {
        return Units.toPoints(this._row.getH());
    }

    public CTTableRow getXmlObject() {
        return this._row;
    }

    @Override // java.lang.Iterable
    public Iterator<XSLFTableCell> iterator() {
        return this._cells.iterator();
    }

    public void mergeCells(int i, int i2) {
        if (i >= i2) {
            throw new IllegalArgumentException(AbstractC1038a.m1214o(i, i2, "Cannot merge, first column >= last column : ", " >= "));
        }
        this._cells.get(i).setGridSpan((i2 - i) + 1);
        Iterator<XSLFTableCell> it = this._cells.subList(i + 1, i2 + 1).iterator();
        while (it.hasNext()) {
            it.next().setHMerge(true);
        }
    }

    public void setHeight(double d) {
        this._row.setH(Units.toEMU(d));
    }
}
