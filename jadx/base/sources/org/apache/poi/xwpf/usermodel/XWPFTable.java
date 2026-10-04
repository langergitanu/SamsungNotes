package org.apache.poi.xwpf.usermodel;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XWPFTable implements IBodyElement, ISDTContents {
    private static HashMap<Integer, XWPFBorderType> stBorderTypeMap;
    private static EnumMap<XWPFBorderType, STBorder.Enum> xwpfBorderTypeMap;
    private CTTbl ctTbl;
    protected IBody part;
    protected List<XWPFTableRow> tableRows;
    protected StringBuffer text;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum XWPFBorderType {
        NIL,
        NONE,
        SINGLE,
        THICK,
        DOUBLE,
        DOTTED,
        DASHED,
        DOT_DASH
    }

    static {
        EnumMap<XWPFBorderType, STBorder.Enum> enumMap = new EnumMap<>(XWPFBorderType.class);
        xwpfBorderTypeMap = enumMap;
        XWPFBorderType xWPFBorderType = XWPFBorderType.NIL;
        enumMap.put(xWPFBorderType, STBorder.Enum.forInt(1));
        EnumMap<XWPFBorderType, STBorder.Enum> enumMap2 = xwpfBorderTypeMap;
        XWPFBorderType xWPFBorderType2 = XWPFBorderType.NONE;
        enumMap2.put(xWPFBorderType2, STBorder.Enum.forInt(2));
        EnumMap<XWPFBorderType, STBorder.Enum> enumMap3 = xwpfBorderTypeMap;
        XWPFBorderType xWPFBorderType3 = XWPFBorderType.SINGLE;
        enumMap3.put(xWPFBorderType3, STBorder.Enum.forInt(3));
        EnumMap<XWPFBorderType, STBorder.Enum> enumMap4 = xwpfBorderTypeMap;
        XWPFBorderType xWPFBorderType4 = XWPFBorderType.THICK;
        enumMap4.put(xWPFBorderType4, STBorder.Enum.forInt(4));
        EnumMap<XWPFBorderType, STBorder.Enum> enumMap5 = xwpfBorderTypeMap;
        XWPFBorderType xWPFBorderType5 = XWPFBorderType.DOUBLE;
        enumMap5.put(xWPFBorderType5, STBorder.Enum.forInt(5));
        EnumMap<XWPFBorderType, STBorder.Enum> enumMap6 = xwpfBorderTypeMap;
        XWPFBorderType xWPFBorderType6 = XWPFBorderType.DOTTED;
        enumMap6.put(xWPFBorderType6, STBorder.Enum.forInt(6));
        EnumMap<XWPFBorderType, STBorder.Enum> enumMap7 = xwpfBorderTypeMap;
        XWPFBorderType xWPFBorderType7 = XWPFBorderType.DASHED;
        enumMap7.put(xWPFBorderType7, STBorder.Enum.forInt(7));
        EnumMap<XWPFBorderType, STBorder.Enum> enumMap8 = xwpfBorderTypeMap;
        XWPFBorderType xWPFBorderType8 = XWPFBorderType.DOT_DASH;
        enumMap8.put(xWPFBorderType8, STBorder.Enum.forInt(8));
        HashMap<Integer, XWPFBorderType> map = new HashMap<>();
        stBorderTypeMap = map;
        map.put(1, xWPFBorderType);
        stBorderTypeMap.put(2, xWPFBorderType2);
        stBorderTypeMap.put(3, xWPFBorderType3);
        stBorderTypeMap.put(4, xWPFBorderType4);
        stBorderTypeMap.put(5, xWPFBorderType5);
        stBorderTypeMap.put(6, xWPFBorderType6);
        stBorderTypeMap.put(7, xWPFBorderType7);
        stBorderTypeMap.put(8, xWPFBorderType8);
    }

    public XWPFTable(CTTbl cTTbl, IBody iBody, int i, int i2) {
        this(cTTbl, iBody);
        for (int i4 = 0; i4 < i; i4++) {
            XWPFTableRow xWPFTableRowCreateRow = getRow(i4) == null ? createRow() : getRow(i4);
            for (int i5 = 0; i5 < i2; i5++) {
                if (xWPFTableRowCreateRow.getCell(i5) == null) {
                    xWPFTableRowCreateRow.createCell();
                }
            }
        }
    }

    private void addColumn(XWPFTableRow xWPFTableRow, int i) {
        if (i > 0) {
            for (int i2 = 0; i2 < i; i2++) {
                xWPFTableRow.createCell();
            }
        }
    }

    private void createEmptyTable(CTTbl cTTbl) {
        cTTbl.addNewTr().addNewTc().addNewP();
        CTTblPr cTTblPrAddNewTblPr = cTTbl.addNewTblPr();
        cTTblPrAddNewTblPr.addNewTblW().setW(new BigInteger("0"));
        cTTblPrAddNewTblPr.getTblW().setType(STTblWidth.AUTO);
        CTTblBorders cTTblBordersAddNewTblBorders = cTTblPrAddNewTblPr.addNewTblBorders();
        CTBorder cTBorderAddNewBottom = cTTblBordersAddNewTblBorders.addNewBottom();
        STBorder.Enum r12 = STBorder.SINGLE;
        cTBorderAddNewBottom.setVal(r12);
        cTTblBordersAddNewTblBorders.addNewInsideH().setVal(r12);
        cTTblBordersAddNewTblBorders.addNewInsideV().setVal(r12);
        cTTblBordersAddNewTblBorders.addNewLeft().setVal(r12);
        cTTblBordersAddNewTblBorders.addNewRight().setVal(r12);
        cTTblBordersAddNewTblBorders.addNewTop().setVal(r12);
        getRows();
    }

    private CTTblPr getTrPr() {
        return this.ctTbl.getTblPr() != null ? this.ctTbl.getTblPr() : this.ctTbl.addNewTblPr();
    }

    public void addNewCol() {
        if (this.ctTbl.sizeOfTrArray() == 0) {
            createRow();
        }
        for (int i = 0; i < this.ctTbl.sizeOfTrArray(); i++) {
            new XWPFTableRow(this.ctTbl.getTrArray(i), this).createCell();
        }
    }

    public void addRow(XWPFTableRow xWPFTableRow) {
        this.ctTbl.addNewTr();
        this.ctTbl.setTrArray(getNumberOfRows() - 1, xWPFTableRow.getCtRow());
        this.tableRows.add(xWPFTableRow);
    }

    public XWPFTableRow createRow() {
        int iSizeOfTcArray = this.ctTbl.sizeOfTrArray() > 0 ? this.ctTbl.getTrArray(0).sizeOfTcArray() : 0;
        XWPFTableRow xWPFTableRow = new XWPFTableRow(this.ctTbl.addNewTr(), this);
        addColumn(xWPFTableRow, iSizeOfTcArray);
        this.tableRows.add(xWPFTableRow);
        return xWPFTableRow;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBodyElement
    public IBody getBody() {
        return this.part;
    }

    @Internal
    public CTTbl getCTTbl() {
        return this.ctTbl;
    }

    public int getCellMarginBottom() {
        CTTblWidth bottom;
        CTTblCellMar tblCellMar = getTrPr().getTblCellMar();
        if (tblCellMar == null || (bottom = tblCellMar.getBottom()) == null) {
            return 0;
        }
        return bottom.getW().intValue();
    }

    public int getCellMarginLeft() {
        CTTblWidth left;
        CTTblCellMar tblCellMar = getTrPr().getTblCellMar();
        if (tblCellMar == null || (left = tblCellMar.getLeft()) == null) {
            return 0;
        }
        return left.getW().intValue();
    }

    public int getCellMarginRight() {
        CTTblWidth right;
        CTTblCellMar tblCellMar = getTrPr().getTblCellMar();
        if (tblCellMar == null || (right = tblCellMar.getRight()) == null) {
            return 0;
        }
        return right.getW().intValue();
    }

    public int getCellMarginTop() {
        CTTblWidth top;
        CTTblCellMar tblCellMar = getTrPr().getTblCellMar();
        if (tblCellMar == null || (top = tblCellMar.getTop()) == null) {
            return 0;
        }
        return top.getW().intValue();
    }

    public int getColBandSize() {
        CTTblPr trPr = getTrPr();
        if (trPr.isSetTblStyleColBandSize()) {
            return trPr.getTblStyleColBandSize().getVal().intValue();
        }
        return 0;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBodyElement
    public BodyElementType getElementType() {
        return BodyElementType.TABLE;
    }

    public String getInsideHBorderColor() {
        CTTblPr trPr = getTrPr();
        if (!trPr.isSetTblBorders()) {
            return null;
        }
        CTTblBorders tblBorders = trPr.getTblBorders();
        if (tblBorders.isSetInsideH()) {
            return tblBorders.getInsideH().xgetColor().getStringValue();
        }
        return null;
    }

    public int getInsideHBorderSize() {
        CTTblPr trPr = getTrPr();
        if (!trPr.isSetTblBorders()) {
            return -1;
        }
        CTTblBorders tblBorders = trPr.getTblBorders();
        if (tblBorders.isSetInsideH()) {
            return tblBorders.getInsideH().getSz().intValue();
        }
        return -1;
    }

    public int getInsideHBorderSpace() {
        CTTblPr trPr = getTrPr();
        if (!trPr.isSetTblBorders()) {
            return -1;
        }
        CTTblBorders tblBorders = trPr.getTblBorders();
        if (tblBorders.isSetInsideH()) {
            return tblBorders.getInsideH().getSpace().intValue();
        }
        return -1;
    }

    public XWPFBorderType getInsideHBorderType() {
        CTTblPr trPr = getTrPr();
        if (!trPr.isSetTblBorders()) {
            return null;
        }
        CTTblBorders tblBorders = trPr.getTblBorders();
        if (!tblBorders.isSetInsideH()) {
            return null;
        }
        return stBorderTypeMap.get(Integer.valueOf(tblBorders.getInsideH().getVal().intValue()));
    }

    public String getInsideVBorderColor() {
        CTTblPr trPr = getTrPr();
        if (!trPr.isSetTblBorders()) {
            return null;
        }
        CTTblBorders tblBorders = trPr.getTblBorders();
        if (tblBorders.isSetInsideV()) {
            return tblBorders.getInsideV().xgetColor().getStringValue();
        }
        return null;
    }

    public int getInsideVBorderSize() {
        CTTblPr trPr = getTrPr();
        if (!trPr.isSetTblBorders()) {
            return -1;
        }
        CTTblBorders tblBorders = trPr.getTblBorders();
        if (tblBorders.isSetInsideV()) {
            return tblBorders.getInsideV().getSz().intValue();
        }
        return -1;
    }

    public int getInsideVBorderSpace() {
        CTTblPr trPr = getTrPr();
        if (!trPr.isSetTblBorders()) {
            return -1;
        }
        CTTblBorders tblBorders = trPr.getTblBorders();
        if (tblBorders.isSetInsideV()) {
            return tblBorders.getInsideV().getSpace().intValue();
        }
        return -1;
    }

    public XWPFBorderType getInsideVBorderType() {
        CTTblPr trPr = getTrPr();
        if (!trPr.isSetTblBorders()) {
            return null;
        }
        CTTblBorders tblBorders = trPr.getTblBorders();
        if (!tblBorders.isSetInsideV()) {
            return null;
        }
        return stBorderTypeMap.get(Integer.valueOf(tblBorders.getInsideV().getVal().intValue()));
    }

    public int getNumberOfRows() {
        return this.ctTbl.sizeOfTrArray();
    }

    @Override // org.apache.poi.xwpf.usermodel.IBodyElement, org.apache.poi.xwpf.usermodel.IRunBody
    public POIXMLDocumentPart getPart() {
        IBody iBody = this.part;
        if (iBody != null) {
            return iBody.getPart();
        }
        return null;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBodyElement
    public BodyType getPartType() {
        return this.part.getPartType();
    }

    public XWPFTableRow getRow(int i) {
        if (i < 0 || i >= this.ctTbl.sizeOfTrArray()) {
            return null;
        }
        return getRows().get(i);
    }

    public int getRowBandSize() {
        CTTblPr trPr = getTrPr();
        if (trPr.isSetTblStyleRowBandSize()) {
            return trPr.getTblStyleRowBandSize().getVal().intValue();
        }
        return 0;
    }

    public List<XWPFTableRow> getRows() {
        return this.tableRows;
    }

    public String getStyleID() {
        CTString tblStyle;
        CTTblPr tblPr = this.ctTbl.getTblPr();
        if (tblPr == null || (tblStyle = tblPr.getTblStyle()) == null) {
            return null;
        }
        return tblStyle.getVal();
    }

    public String getText() {
        return this.text.toString();
    }

    public int getWidth() {
        CTTblPr trPr = getTrPr();
        if (trPr.isSetTblW()) {
            return trPr.getTblW().getW().intValue();
        }
        return -1;
    }

    public XWPFTableRow insertNewTableRow(int i) {
        if (i < 0 || i > this.tableRows.size()) {
            return null;
        }
        XWPFTableRow xWPFTableRow = new XWPFTableRow(this.ctTbl.insertNewTr(i), this);
        this.tableRows.add(i, xWPFTableRow);
        return xWPFTableRow;
    }

    public boolean removeRow(int i) {
        if (i < 0 || i >= this.tableRows.size()) {
            return false;
        }
        if (this.ctTbl.sizeOfTrArray() > 0) {
            this.ctTbl.removeTr(i);
        }
        this.tableRows.remove(i);
        return true;
    }

    public void setCellMargins(int i, int i2, int i4, int i5) {
        CTTblPr trPr = getTrPr();
        CTTblCellMar tblCellMar = trPr.isSetTblCellMar() ? trPr.getTblCellMar() : trPr.addNewTblCellMar();
        CTTblWidth left = tblCellMar.isSetLeft() ? tblCellMar.getLeft() : tblCellMar.addNewLeft();
        STTblWidth.Enum r2 = STTblWidth.DXA;
        left.setType(r2);
        left.setW(BigInteger.valueOf(i2));
        CTTblWidth top = tblCellMar.isSetTop() ? tblCellMar.getTop() : tblCellMar.addNewTop();
        top.setType(r2);
        top.setW(BigInteger.valueOf(i));
        CTTblWidth bottom = tblCellMar.isSetBottom() ? tblCellMar.getBottom() : tblCellMar.addNewBottom();
        bottom.setType(r2);
        bottom.setW(BigInteger.valueOf(i4));
        CTTblWidth right = tblCellMar.isSetRight() ? tblCellMar.getRight() : tblCellMar.addNewRight();
        right.setType(r2);
        right.setW(BigInteger.valueOf(i5));
    }

    public void setColBandSize(int i) {
        CTTblPr trPr = getTrPr();
        (trPr.isSetTblStyleColBandSize() ? trPr.getTblStyleColBandSize() : trPr.addNewTblStyleColBandSize()).setVal(BigInteger.valueOf(i));
    }

    public void setInsideHBorder(XWPFBorderType xWPFBorderType, int i, int i2, String str) {
        CTTblPr trPr = getTrPr();
        CTTblBorders tblBorders = trPr.isSetTblBorders() ? trPr.getTblBorders() : trPr.addNewTblBorders();
        CTBorder insideH = tblBorders.isSetInsideH() ? tblBorders.getInsideH() : tblBorders.addNewInsideH();
        insideH.setVal(xwpfBorderTypeMap.get(xWPFBorderType));
        insideH.setSz(BigInteger.valueOf(i));
        insideH.setSpace(BigInteger.valueOf(i2));
        insideH.setColor(str);
    }

    public void setInsideVBorder(XWPFBorderType xWPFBorderType, int i, int i2, String str) {
        CTTblPr trPr = getTrPr();
        CTTblBorders tblBorders = trPr.isSetTblBorders() ? trPr.getTblBorders() : trPr.addNewTblBorders();
        CTBorder insideV = tblBorders.isSetInsideV() ? tblBorders.getInsideV() : tblBorders.addNewInsideV();
        insideV.setVal(xwpfBorderTypeMap.get(xWPFBorderType));
        insideV.setSz(BigInteger.valueOf(i));
        insideV.setSpace(BigInteger.valueOf(i2));
        insideV.setColor(str);
    }

    public void setRowBandSize(int i) {
        CTTblPr trPr = getTrPr();
        (trPr.isSetTblStyleRowBandSize() ? trPr.getTblStyleRowBandSize() : trPr.addNewTblStyleRowBandSize()).setVal(BigInteger.valueOf(i));
    }

    public void setStyleID(String str) {
        CTTblPr trPr = getTrPr();
        CTString tblStyle = trPr.getTblStyle();
        if (tblStyle == null) {
            tblStyle = trPr.addNewTblStyle();
        }
        tblStyle.setVal(str);
    }

    public void setWidth(int i) {
        CTTblPr trPr = getTrPr();
        (trPr.isSetTblW() ? trPr.getTblW() : trPr.addNewTblW()).setW(new BigInteger(AbstractC0000a.m11h(i, "")));
    }

    public XWPFTableRow getRow(CTRow cTRow) {
        for (int i = 0; i < getRows().size(); i++) {
            if (getRows().get(i).getCtRow() == cTRow) {
                return getRow(i);
            }
        }
        return null;
    }

    public boolean addRow(XWPFTableRow xWPFTableRow, int i) {
        if (i < 0 || i > this.tableRows.size()) {
            return false;
        }
        this.ctTbl.insertNewTr(i);
        this.ctTbl.setTrArray(i, xWPFTableRow.getCtRow());
        this.tableRows.add(i, xWPFTableRow);
        return true;
    }

    public XWPFTable(CTTbl cTTbl, IBody iBody) {
        this.text = new StringBuffer();
        this.part = iBody;
        this.ctTbl = cTTbl;
        this.tableRows = new ArrayList();
        if (cTTbl.sizeOfTrArray() == 0) {
            createEmptyTable(cTTbl);
        }
        for (CTRow cTRow : cTTbl.getTrArray()) {
            StringBuilder sb = new StringBuilder();
            this.tableRows.add(new XWPFTableRow(cTRow, this));
            for (CTTc cTTc : cTRow.getTcArray()) {
                for (CTP ctp : cTTc.getPArray()) {
                    XWPFParagraph xWPFParagraph = new XWPFParagraph(ctp, iBody);
                    if (sb.length() > 0) {
                        sb.append('\t');
                    }
                    sb.append(xWPFParagraph.getText());
                }
            }
            if (sb.length() > 0) {
                this.text.append((CharSequence) sb);
                this.text.append('\n');
            }
        }
    }

    public void addNewRowBetween(int i, int i2) {
    }
}
