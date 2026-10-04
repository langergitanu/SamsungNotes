package org.apache.poi.xslf.usermodel;

import androidx.compose.foundation.layout.AbstractC1038a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.java.awt.Graphics2D;
import org.apache.poi.java.awt.geom.Rectangle2D;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.p226sl.usermodel.TableShape;
import org.apache.poi.sl.draw.DrawFactory;
import org.apache.poi.util.Internal;
import org.apache.poi.util.Units;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlAnyTypeImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObjectData;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTable;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrameNonVisual;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XSLFTable extends XSLFGraphicFrame implements Iterable<XSLFTableRow>, TableShape<XSLFShape, XSLFTextParagraph> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final String DRAWINGML_URI = "http://schemas.openxmlformats.org/drawingml/2006/main";
    static final String TABLE_URI = "http://schemas.openxmlformats.org/drawingml/2006/table";
    private List<XSLFTableRow> _rows;
    private CTTable _table;

    public XSLFTable(CTGraphicalObjectFrame cTGraphicalObjectFrame, XSLFSheet xSLFSheet) {
        super(cTGraphicalObjectFrame, xSLFSheet);
        CTGraphicalObjectData graphicData = cTGraphicalObjectFrame.getGraphic().getGraphicData();
        XmlCursor xmlCursorNewCursor = graphicData.newCursor();
        if (!xmlCursorNewCursor.toChild("http://schemas.openxmlformats.org/drawingml/2006/main", "tbl")) {
            throw new IllegalStateException("a:tbl element was not found in\n " + graphicData);
        }
        XmlObject object = xmlCursorNewCursor.getObject();
        if (object instanceof XmlAnyTypeImpl) {
            throw new IllegalStateException("Schemas (*.xsb) for CTTable can't be loaded - usually this happens when OSGI loading is used and the thread context classloader has no reference to the xmlbeans classes - use POIXMLTypeLoader.setClassLoader() to set the loader, e.g. with CTTable.class.getClassLoader()");
        }
        this._table = (CTTable) object;
        xmlCursorNewCursor.dispose();
        this._rows = new ArrayList(this._table.sizeOfTrArray());
        for (CTTableRow cTTableRow : this._table.getTrArray()) {
            this._rows.add(new XSLFTableRow(cTTableRow, this));
        }
        updateRowColIndexes();
    }

    public static CTGraphicalObjectFrame prototype(int i) {
        CTGraphicalObjectFrame cTGraphicalObjectFrameNewInstance = CTGraphicalObjectFrame.Factory.newInstance();
        CTGraphicalObjectFrameNonVisual cTGraphicalObjectFrameNonVisualAddNewNvGraphicFramePr = cTGraphicalObjectFrameNewInstance.addNewNvGraphicFramePr();
        CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewCNvPr = cTGraphicalObjectFrameNonVisualAddNewNvGraphicFramePr.addNewCNvPr();
        cTNonVisualDrawingPropsAddNewCNvPr.setName("Table " + i);
        cTNonVisualDrawingPropsAddNewCNvPr.setId((long) (i + 1));
        cTGraphicalObjectFrameNonVisualAddNewNvGraphicFramePr.addNewCNvGraphicFramePr().addNewGraphicFrameLocks().setNoGrp(true);
        cTGraphicalObjectFrameNonVisualAddNewNvGraphicFramePr.addNewNvPr();
        cTGraphicalObjectFrameNewInstance.addNewXfrm();
        CTGraphicalObjectData cTGraphicalObjectDataAddNewGraphicData = cTGraphicalObjectFrameNewInstance.addNewGraphic().addNewGraphicData();
        XmlCursor xmlCursorNewCursor = cTGraphicalObjectDataAddNewGraphicData.newCursor();
        xmlCursorNewCursor.toNextToken();
        xmlCursorNewCursor.beginElement(new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "tbl"));
        CTTable cTTableNewInstance = CTTable.Factory.newInstance();
        cTTableNewInstance.addNewTblPr();
        cTTableNewInstance.addNewTblGrid();
        XmlCursor xmlCursorNewCursor2 = cTTableNewInstance.newCursor();
        xmlCursorNewCursor2.moveXmlContents(xmlCursorNewCursor);
        xmlCursorNewCursor2.dispose();
        xmlCursorNewCursor.dispose();
        cTGraphicalObjectDataAddNewGraphicData.setUri(TABLE_URI);
        return cTGraphicalObjectFrameNewInstance;
    }

    public XSLFTableRow addRow() {
        XSLFTableRow xSLFTableRow = new XSLFTableRow(this._table.addNewTr(), this);
        xSLFTableRow.setHeight(20.0d);
        this._rows.add(xSLFTableRow);
        updateRowColIndexes();
        return xSLFTableRow;
    }

    @Internal
    public CTTable getCTTable() {
        return this._table;
    }

    @Override // org.apache.poi.p226sl.usermodel.TableShape
    public double getColumnWidth(int i) {
        return Units.toPoints(this._table.getTblGrid().getGridColArray(i).getW());
    }

    @Override // org.apache.poi.p226sl.usermodel.TableShape
    public int getNumberOfColumns() {
        return this._table.getTblGrid().sizeOfGridColArray();
    }

    @Override // org.apache.poi.p226sl.usermodel.TableShape
    public int getNumberOfRows() {
        return this._table.sizeOfTrArray();
    }

    @Override // org.apache.poi.p226sl.usermodel.TableShape
    public double getRowHeight(int i) {
        return Units.toPoints(this._table.getTrArray(i).getH());
    }

    public List<XSLFTableRow> getRows() {
        return Collections.unmodifiableList(this._rows);
    }

    public XSLFTableStyle getTableStyle() {
        CTTable cTTable = getCTTable();
        if (cTTable.isSetTblPr() && cTTable.getTblPr().isSetTableStyleId()) {
            String tableStyleId = cTTable.getTblPr().getTableStyleId();
            for (XSLFTableStyle xSLFTableStyle : getSheet().getSlideShow().getTableStyles().getStyles()) {
                if (xSLFTableStyle.getStyleId().equals(tableStyleId)) {
                    return xSLFTableStyle;
                }
            }
        }
        return null;
    }

    @Override // java.lang.Iterable
    public Iterator<XSLFTableRow> iterator() {
        return this._rows.iterator();
    }

    public void mergeCells(int i, int i2, int i4, int i5) {
        if (i > i2) {
            throw new IllegalArgumentException(AbstractC1038a.m1214o(i, i2, "Cannot merge, first row > last row : ", " > "));
        }
        if (i4 > i5) {
            throw new IllegalArgumentException(AbstractC1038a.m1214o(i4, i5, "Cannot merge, first column > last column : ", " > "));
        }
        int i6 = (i2 - i) + 1;
        boolean z = i6 > 1;
        int i7 = (i5 - i4) + 1;
        boolean z2 = i7 > 1;
        for (int i8 = i; i8 <= i2; i8++) {
            XSLFTableRow xSLFTableRow = this._rows.get(i8);
            for (int i9 = i4; i9 <= i5; i9++) {
                XSLFTableCell xSLFTableCell = xSLFTableRow.getCells().get(i9);
                if (z) {
                    if (i8 == i) {
                        xSLFTableCell.setRowSpan(i6);
                    } else {
                        xSLFTableCell.setVMerge(true);
                    }
                }
                if (z2) {
                    if (i9 == i4) {
                        xSLFTableCell.setGridSpan(i7);
                    } else {
                        xSLFTableCell.setHMerge(true);
                    }
                }
            }
        }
    }

    @Override // org.apache.poi.p226sl.usermodel.TableShape
    public void setColumnWidth(int i, double d) {
        this._table.getTblGrid().getGridColArray(i).setW(Units.toEMU(d));
    }

    @Override // org.apache.poi.p226sl.usermodel.TableShape
    public void setRowHeight(int i, double d) {
        this._table.getTrArray(i).setH(Units.toEMU(d));
    }

    public void updateCellAnchor() {
        int numberOfRows = getNumberOfRows();
        int numberOfColumns = getNumberOfColumns();
        double[] dArr = new double[numberOfColumns];
        double[] dArr2 = new double[numberOfRows];
        for (int i = 0; i < numberOfRows; i++) {
            dArr2[i] = getRowHeight(i);
        }
        for (int i2 = 0; i2 < numberOfColumns; i2++) {
            dArr[i2] = getColumnWidth(i2);
        }
        Rectangle2D anchor = getAnchor();
        DrawFactory drawFactory = DrawFactory.getInstance((Graphics2D) null);
        double y2 = anchor.getY();
        for (int i4 = 0; i4 < numberOfRows; i4++) {
            double dMax = 0.0d;
            for (int i5 = 0; i5 < numberOfColumns; i5++) {
                XSLFTableCell cell = getCell(i4, i5);
                if (cell != null && cell.getGridSpan() == 1 && cell.getRowSpan() == 1) {
                    cell.setAnchor(new Rectangle2D.Double(0.0d, 0.0d, dArr[i5], 0.0d));
                    dMax = Math.max(dMax, drawFactory.getDrawable(cell).getTextHeight());
                }
            }
            dArr2[i4] = Math.max(dArr2[i4], dMax);
        }
        double d = y2;
        for (int i6 = 0; i6 < numberOfRows; i6++) {
            double x = anchor.getX();
            for (int i7 = 0; i7 < numberOfColumns; i7++) {
                Rectangle2D.Double r16 = new Rectangle2D.Double(x, d, dArr[i7], dArr2[i6]);
                XSLFTableCell cell2 = getCell(i6, i7);
                if (cell2 != null) {
                    cell2.setAnchor(r16);
                    x = dArr[i7] + 2.0d + x;
                }
            }
            d = dArr2[i6] + 2.0d + d;
        }
        for (int i8 = 0; i8 < numberOfRows; i8++) {
            for (int i9 = 0; i9 < numberOfColumns; i9++) {
                XSLFTableCell cell3 = getCell(i8, i9);
                if (cell3 != null) {
                    Rectangle2D anchor2 = cell3.getAnchor();
                    for (int i10 = i9 + 1; i10 < cell3.getGridSpan() + i9; i10++) {
                        anchor2.add(getCell(i8, i10).getAnchor());
                    }
                    for (int i11 = i8 + 1; i11 < cell3.getRowSpan() + i8; i11++) {
                        anchor2.add(getCell(i11, i9).getAnchor());
                    }
                    cell3.setAnchor(anchor2);
                }
            }
        }
    }

    public void updateRowColIndexes() {
        Iterator<XSLFTableRow> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            Iterator<XSLFTableCell> it2 = it.next().iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                it2.next().setRowColIndex(i, i2);
                i2++;
            }
            i++;
        }
    }

    @Override // org.apache.poi.p226sl.usermodel.TableShape
    public XSLFTableCell getCell(int i, int i2) {
        XSLFTableRow xSLFTableRow;
        List<XSLFTableRow> rows = getRows();
        if (i < 0 || rows.size() <= i || (xSLFTableRow = rows.get(i)) == null) {
            return null;
        }
        List<XSLFTableCell> cells = xSLFTableRow.getCells();
        if (i2 >= 0 && cells.size() > i2) {
            return cells.get(i2);
        }
        return null;
    }
}
