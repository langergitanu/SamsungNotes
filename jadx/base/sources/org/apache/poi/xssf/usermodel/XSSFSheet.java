package org.apache.poi.xssf.usermodel;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.core.view.MotionEventCompat;
import com.microsoft.schemas.vml.CTShape;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.PartAlreadyExistsException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.p227ss.usermodel.Sheet;
import org.apache.poi.p227ss.usermodel.Table;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.FormulaShifter;
import org.apache.poi.ss.formula.SheetNameFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellCopyPolicy;
import org.apache.poi.ss.usermodel.CellRange;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.usermodel.Footer;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.IgnoredErrorType;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.ss.util.PaneInformation;
import org.apache.poi.ss.util.SSCellRange;
import org.apache.poi.ss.util.SheetUtil;
import org.apache.poi.util.Internal;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.xssf.model.CommentsTable;
import org.apache.poi.xssf.usermodel.XSSFPivotTable;
import org.apache.poi.xssf.usermodel.helpers.ColumnHelper;
import org.apache.poi.xssf.usermodel.helpers.XSSFIgnoredErrorHelper;
import org.apache.poi.xssf.usermodel.helpers.XSSFPasswordHelper;
import org.apache.poi.xssf.usermodel.helpers.XSSFRowShifter;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBreak;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellFormula;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCol;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComment;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidations;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDrawing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHeaderFooter;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlink;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredError;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTLegacyDrawing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCells;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObjects;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOutlinePr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageBreak;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetUpPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPrintOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRow;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSelection;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetFormatPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetProtection;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetView;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTablePart;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheetSource;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCalcMode;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellFormulaType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPane;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPaneState;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorksheetDocument;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XSSFSheet extends POIXMLDocumentPart implements Sheet {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final double DEFAULT_MARGIN_BOTTOM = 0.75d;
    private static final double DEFAULT_MARGIN_FOOTER = 0.3d;
    private static final double DEFAULT_MARGIN_HEADER = 0.3d;
    private static final double DEFAULT_MARGIN_LEFT = 0.7d;
    private static final double DEFAULT_MARGIN_RIGHT = 0.7d;
    private static final double DEFAULT_MARGIN_TOP = 0.75d;
    private static final double DEFAULT_ROW_HEIGHT = 15.0d;
    public static final int TWIPS_PER_POINT = 20;
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) XSSFSheet.class);
    private final SortedMap<Integer, XSSFRow> _rows;
    private List<CellRangeAddress> arrayFormulas;
    private ColumnHelper columnHelper;
    private XSSFDataValidationHelper dataValidationHelper;
    private List<XSSFHyperlink> hyperlinks;
    private Map<Integer, CTCellFormula> sharedFormulas;
    protected CTSheet sheet;
    private CommentsTable sheetComments;
    private SortedMap<String, XSSFTable> tables;
    protected CTWorksheet worksheet;

    public XSSFSheet() {
        this._rows = new TreeMap();
        this.dataValidationHelper = new XSSFDataValidationHelper(this);
        onDocumentCreate();
    }

    private void checkForIntersectingMergedRegions() {
        List<CellRangeAddress> mergedRegions = getMergedRegions();
        int size = mergedRegions.size();
        int i = 0;
        while (i < size) {
            CellRangeAddress cellRangeAddress = mergedRegions.get(i);
            i++;
            for (CellRangeAddress cellRangeAddress2 : mergedRegions.subList(i, mergedRegions.size())) {
                if (cellRangeAddress.intersects(cellRangeAddress2)) {
                    StringBuilder sb = new StringBuilder("The range ");
                    sb.append(cellRangeAddress.formatAsString());
                    sb.append(" intersects with another merged region ");
                    throw new IllegalStateException(AbstractC0622a.m1170p(cellRangeAddress2.formatAsString(), " in this sheet", sb));
                }
            }
        }
    }

    private void checkForMergedRegionsIntersectingArrayFormulas() {
        Iterator<CellRangeAddress> it = getMergedRegions().iterator();
        while (it.hasNext()) {
            validateArrayFormulas(it.next());
        }
    }

    private void collapseColumn(int i) {
        CTCols colsArray = this.worksheet.getColsArray(0);
        int indexOfColumn = this.columnHelper.getIndexOfColumn(colsArray, this.columnHelper.getColumn(i, false));
        if (indexOfColumn == -1) {
            return;
        }
        int iFindStartOfColumnOutlineGroup = findStartOfColumnOutlineGroup(indexOfColumn);
        setColumn(setGroupHidden(iFindStartOfColumnOutlineGroup, colsArray.getColArray(iFindStartOfColumnOutlineGroup).getOutlineLevel(), true) + 1, 0, null, null, Boolean.TRUE);
    }

    private void collapseRow(int i) {
        XSSFRow row = getRow(i);
        if (row != null) {
            int iWriteHidden = writeHidden(row, findStartOfRowOutlineGroup(i), true);
            if (getRow(iWriteHidden) != null) {
                getRow(iWriteHidden).getCTRow().setCollapsed(true);
            } else {
                createRow(iWriteHidden).getCTRow().setCollapsed(true);
            }
        }
    }

    private boolean containsColumn(CTCol cTCol, int i) {
        long j = i;
        return cTCol.getMin() <= j && j <= cTCol.getMax();
    }

    private XSSFPivotTable createPivotTable() {
        XSSFWorkbook workbook = getWorkbook();
        List pivotTables = workbook.getPivotTables();
        int size = getWorkbook().getPivotTables().size() + 1;
        XSSFPivotTable xSSFPivotTable = (XSSFPivotTable) createRelationship(XSSFRelation.PIVOT_TABLE, XSSFFactory.getInstance(), size);
        xSSFPivotTable.setParentSheet(this);
        pivotTables.add(xSSFPivotTable);
        XSSFWorkbook workbook2 = getWorkbook();
        XSSFRelation xSSFRelation = XSSFRelation.PIVOT_CACHE_DEFINITION;
        XSSFPivotCacheDefinition xSSFPivotCacheDefinition = (XSSFPivotCacheDefinition) workbook2.createRelationship(xSSFRelation, XSSFFactory.getInstance(), size);
        String relationId = workbook2.getRelationId(xSSFPivotCacheDefinition);
        xSSFPivotTable.getPackagePart().addRelationship(xSSFPivotCacheDefinition.getPackagePart().getPartName(), TargetMode.INTERNAL, xSSFRelation.getRelation());
        xSSFPivotTable.setPivotCacheDefinition(xSSFPivotCacheDefinition);
        xSSFPivotTable.setPivotCache(new XSSFPivotCache(workbook2.addPivotCache(relationId)));
        xSSFPivotTable.getPivotCacheDefinition().getCTPivotCacheDefinition().setId(xSSFPivotCacheDefinition.getRelationId((XSSFPivotCacheRecords) xSSFPivotCacheDefinition.createRelationship(XSSFRelation.PIVOT_CACHE_RECORDS, XSSFFactory.getInstance(), size)));
        workbook.setPivotTables(pivotTables);
        return xSSFPivotTable;
    }

    private CTOutlinePr ensureOutlinePr() {
        CTSheetPr sheetPr = this.worksheet.isSetSheetPr() ? this.worksheet.getSheetPr() : this.worksheet.addNewSheetPr();
        return sheetPr.isSetOutlinePr() ? sheetPr.getOutlinePr() : sheetPr.addNewOutlinePr();
    }

    private void expandColumn(int i) {
        CTCols colsArray = this.worksheet.getColsArray(0);
        CTCol column = this.columnHelper.getColumn(i, false);
        int iFindColInfoIdx = findColInfoIdx((int) column.getMax(), this.columnHelper.getIndexOfColumn(colsArray, column));
        if (iFindColInfoIdx != -1 && isColumnGroupCollapsed(iFindColInfoIdx)) {
            int iFindEndOfColumnOutlineGroup = findEndOfColumnOutlineGroup(iFindColInfoIdx);
            CTCol[] colArray = colsArray.getColArray();
            CTCol cTCol = colArray[iFindEndOfColumnOutlineGroup];
            if (!isColumnGroupHiddenByParent(iFindColInfoIdx)) {
                short outlineLevel = cTCol.getOutlineLevel();
                boolean z = false;
                for (int iFindStartOfColumnOutlineGroup = findStartOfColumnOutlineGroup(iFindColInfoIdx); iFindStartOfColumnOutlineGroup <= iFindEndOfColumnOutlineGroup; iFindStartOfColumnOutlineGroup++) {
                    CTCol cTCol2 = colArray[iFindStartOfColumnOutlineGroup];
                    if (outlineLevel == cTCol2.getOutlineLevel()) {
                        cTCol2.unsetHidden();
                        if (z) {
                            cTCol2.setCollapsed(true);
                            z = false;
                        }
                    } else {
                        z = true;
                    }
                }
            }
            int max = ((int) cTCol.getMax()) + 1;
            Boolean bool = Boolean.FALSE;
            setColumn(max, null, null, bool, bool);
        }
    }

    private void expandRow(int i) {
        if (i == -1) {
            return;
        }
        XSSFRow row = getRow(i);
        if (row.getCTRow().isSetHidden()) {
            int iFindEndOfRowOutlineGroup = findEndOfRowOutlineGroup(i);
            short outlineLevel = row.getCTRow().getOutlineLevel();
            if (!isRowGroupHiddenByParent(i)) {
                for (int iFindStartOfRowOutlineGroup = findStartOfRowOutlineGroup(i); iFindStartOfRowOutlineGroup < iFindEndOfRowOutlineGroup; iFindStartOfRowOutlineGroup++) {
                    if (outlineLevel == getRow(iFindStartOfRowOutlineGroup).getCTRow().getOutlineLevel()) {
                        getRow(iFindStartOfRowOutlineGroup).getCTRow().unsetHidden();
                    } else if (!isRowGroupCollapsed(iFindStartOfRowOutlineGroup)) {
                        getRow(iFindStartOfRowOutlineGroup).getCTRow().unsetHidden();
                    }
                }
            }
            CTRow cTRow = getRow(iFindEndOfRowOutlineGroup).getCTRow();
            if (cTRow.getCollapsed()) {
                cTRow.unsetCollapsed();
            }
        }
    }

    private int findColInfoIdx(int i, int i2) {
        CTCols colsArray = this.worksheet.getColsArray(0);
        if (i < 0) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "column parameter out of range: "));
        }
        if (i2 < 0) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i2, "fromIdx parameter out of range: "));
        }
        CTCol[] colArray = colsArray.getColArray();
        for (int i4 = i2; i4 < colArray.length; i4++) {
            CTCol cTCol = colArray[i4];
            if (containsColumn(cTCol, i)) {
                return i4;
            }
            if (cTCol.getMin() > i2) {
                return -1;
            }
        }
        return -1;
    }

    private int findEndOfColumnOutlineGroup(int i) {
        CTCol[] colArray = this.worksheet.getColsArray(0).getColArray();
        CTCol cTCol = colArray[i];
        short outlineLevel = cTCol.getOutlineLevel();
        int length = colArray.length - 1;
        while (i < length) {
            int i2 = i + 1;
            CTCol cTCol2 = colArray[i2];
            if (!isAdjacentBefore(cTCol, cTCol2) || cTCol2.getOutlineLevel() < outlineLevel) {
                break;
            }
            i = i2;
            cTCol = cTCol2;
        }
        return i;
    }

    private int findStartOfColumnOutlineGroup(int i) {
        CTCol[] colArray = this.worksheet.getColsArray(0).getColArray();
        CTCol cTCol = colArray[i];
        short outlineLevel = cTCol.getOutlineLevel();
        while (i != 0) {
            CTCol cTCol2 = colArray[i - 1];
            if (!isAdjacentBefore(cTCol2, cTCol) || cTCol2.getOutlineLevel() < outlineLevel) {
                break;
            }
            i--;
            cTCol = cTCol2;
        }
        return i;
    }

    private int findStartOfRowOutlineGroup(int i) {
        short outlineLevel = getRow(i).getCTRow().getOutlineLevel();
        while (getRow(i) != null) {
            if (getRow(i).getCTRow().getOutlineLevel() < outlineLevel) {
                return i + 1;
            }
            i--;
        }
        return i;
    }

    private int[] getBreaks(CTPageBreak cTPageBreak) {
        CTBreak[] brkArray = cTPageBreak.getBrkArray();
        int[] iArr = new int[brkArray.length];
        for (int i = 0; i < brkArray.length; i++) {
            iArr[i] = ((int) brkArray[i].getId()) - 1;
        }
        return iArr;
    }

    private CellRange<XSSFCell> getCellRange(CellRangeAddress cellRangeAddress) {
        int firstRow = cellRangeAddress.getFirstRow();
        int firstColumn = cellRangeAddress.getFirstColumn();
        int lastRow = cellRangeAddress.getLastRow();
        int lastColumn = cellRangeAddress.getLastColumn();
        int i = (lastRow - firstRow) + 1;
        int i2 = (lastColumn - firstColumn) + 1;
        ArrayList arrayList = new ArrayList(i * i2);
        for (int i4 = firstRow; i4 <= lastRow; i4++) {
            for (int i5 = firstColumn; i5 <= lastColumn; i5++) {
                XSSFRow row = getRow(i4);
                if (row == null) {
                    row = createRow(i4);
                }
                XSSFCell cell = row.getCell(i5);
                if (cell == null) {
                    cell = row.createCell(i5);
                }
                arrayList.add(cell);
            }
        }
        return SSCellRange.create(firstRow, firstColumn, i, i2, arrayList, XSSFCell.class);
    }

    private CTSheetView getDefaultSheetView() {
        int iSizeOfSheetViewArray;
        CTSheetViews sheetTypeSheetViews = getSheetTypeSheetViews();
        if (sheetTypeSheetViews == null || (iSizeOfSheetViewArray = sheetTypeSheetViews.sizeOfSheetViewArray()) == 0) {
            return null;
        }
        return sheetTypeSheetViews.getSheetViewArray(iSizeOfSheetViewArray - 1);
    }

    private short getMaxOutlineLevelCols() {
        int iMax = 0;
        for (CTCol cTCol : this.worksheet.getColsArray(0).getColArray()) {
            iMax = Math.max(iMax, (int) cTCol.getOutlineLevel());
        }
        return (short) iMax;
    }

    private short getMaxOutlineLevelRows() {
        Iterator<XSSFRow> it = this._rows.values().iterator();
        int iMax = 0;
        while (it.hasNext()) {
            iMax = Math.max(iMax, (int) it.next().getCTRow().getOutlineLevel());
        }
        return (short) iMax;
    }

    private CTPane getPane() {
        if (getDefaultSheetView().getPane() == null) {
            getDefaultSheetView().addNewPane();
        }
        return getDefaultSheetView().getPane();
    }

    private static String getReferenceBuiltInRecord(String str, int i, int i2, int i4, int i5) {
        CellReference cellReference = new CellReference(str, 0, i, true, true);
        CellReference cellReference2 = new CellReference(str, 0, i2, true, true);
        CellReference cellReference3 = new CellReference(str, i4, 0, true, true);
        CellReference cellReference4 = new CellReference(str, i5, 0, true, true);
        String str2 = SheetNameFormatter.format(str);
        String strM1622l = "";
        String strM1622l2 = (i == -1 && i2 == -1) ? "" : AbstractC2322a.m1622l(str2, "!$", cellReference.getCellRefParts()[2], ":$", cellReference2.getCellRefParts()[2]);
        if (i4 != -1 || i5 != -1) {
            String str3 = cellReference3.getCellRefParts()[1];
            String str4 = cellReference4.getCellRefParts()[1];
            if (!str3.equals("0") && !str4.equals("0")) {
                strM1622l = AbstractC2322a.m1622l(str2, "!$", str3, ":$", str4);
            }
        }
        StringBuilder sbM1324q = AbstractC1974b.m1324q(strM1622l2);
        if (sbM1324q.length() > 0 && strM1622l.length() > 0) {
            sbM1324q.append(',');
        }
        sbM1324q.append(strM1622l);
        return sbM1324q.toString();
    }

    private CellRangeAddress getRepeatingRowsOrColums(boolean z) {
        String refersToFormula;
        XSSFName builtInName = getWorkbook().getBuiltInName("_xlnm.Print_Titles", getWorkbook().getSheetIndex(this));
        if (builtInName == null || (refersToFormula = builtInName.getRefersToFormula()) == null) {
            return null;
        }
        String[] strArrSplit = refersToFormula.split(",");
        int lastRowIndex = SpreadsheetVersion.EXCEL2007.getLastRowIndex();
        int lastColumnIndex = SpreadsheetVersion.EXCEL2007.getLastColumnIndex();
        for (String str : strArrSplit) {
            CellRangeAddress cellRangeAddressValueOf = CellRangeAddress.valueOf(str);
            if ((cellRangeAddressValueOf.getFirstColumn() == 0 && cellRangeAddressValueOf.getLastColumn() == lastColumnIndex) || (cellRangeAddressValueOf.getFirstColumn() == -1 && cellRangeAddressValueOf.getLastColumn() == -1)) {
                if (z) {
                    return cellRangeAddressValueOf;
                }
            } else {
                if (((cellRangeAddressValueOf.getFirstRow() == 0 && cellRangeAddressValueOf.getLastRow() == lastRowIndex) || (cellRangeAddressValueOf.getFirstRow() == -1 && cellRangeAddressValueOf.getLastRow() == -1)) && !z) {
                    return cellRangeAddressValueOf;
                }
            }
        }
        return null;
    }

    private List<XSSFRow> getRows(int i, int i2, boolean z) {
        if (i > i2) {
            throw new IllegalArgumentException("getRows: startRowNum must be less than or equal to endRowNum");
        }
        ArrayList arrayList = new ArrayList();
        if (!z) {
            arrayList.addAll(this._rows.subMap(new Integer(i), new Integer(i2 + 1)).values());
            return arrayList;
        }
        while (i <= i2) {
            XSSFRow row = getRow(i);
            if (row == null) {
                row = createRow(i);
            }
            arrayList.add(row);
            i++;
        }
        return arrayList;
    }

    private CTHeaderFooter getSheetTypeHeaderFooter() {
        if (this.worksheet.getHeaderFooter() == null) {
            this.worksheet.setHeaderFooter(CTHeaderFooter.Factory.newInstance());
        }
        return this.worksheet.getHeaderFooter();
    }

    private CTPageSetUpPr getSheetTypePageSetUpPr() {
        CTSheetPr sheetTypeSheetPr = getSheetTypeSheetPr();
        return sheetTypeSheetPr.isSetPageSetUpPr() ? sheetTypeSheetPr.getPageSetUpPr() : sheetTypeSheetPr.addNewPageSetUpPr();
    }

    private CTSelection getSheetTypeSelection() {
        if (getSheetTypeSheetView().sizeOfSelectionArray() == 0) {
            getSheetTypeSheetView().insertNewSelection(0);
        }
        return getSheetTypeSheetView().getSelectionArray(0);
    }

    private CTSheetFormatPr getSheetTypeSheetFormatPr() {
        return this.worksheet.isSetSheetFormatPr() ? this.worksheet.getSheetFormatPr() : this.worksheet.addNewSheetFormatPr();
    }

    private CTSheetPr getSheetTypeSheetPr() {
        if (this.worksheet.getSheetPr() == null) {
            this.worksheet.setSheetPr(CTSheetPr.Factory.newInstance());
        }
        return this.worksheet.getSheetPr();
    }

    private CTSheetView getSheetTypeSheetView() {
        if (getDefaultSheetView() == null) {
            getSheetTypeSheetViews().setSheetViewArray(0, CTSheetView.Factory.newInstance());
        }
        return getDefaultSheetView();
    }

    private CTSheetViews getSheetTypeSheetViews() {
        if (this.worksheet.getSheetViews() == null) {
            this.worksheet.setSheetViews(CTSheetViews.Factory.newInstance());
            this.worksheet.getSheetViews().addNewSheetView();
        }
        return this.worksheet.getSheetViews();
    }

    private void groupColumn1Based(int i, int i2) {
        CTCols colsArray = this.worksheet.getColsArray(0);
        CTCol cTColNewInstance = CTCol.Factory.newInstance();
        long j = i2;
        CTCol column1Based = this.columnHelper.getColumn1Based(j, false);
        if (column1Based != null) {
            column1Based = (CTCol) column1Based.copy();
        }
        cTColNewInstance.setMin(i);
        cTColNewInstance.setMax(j);
        this.columnHelper.addCleanColIntoCols(colsArray, cTColNewInstance);
        CTCol column1Based2 = this.columnHelper.getColumn1Based(j, false);
        if (column1Based != null && column1Based2 != null) {
            this.columnHelper.setColumnAttributes(column1Based, column1Based2);
        }
        while (i <= i2) {
            CTCol column1Based3 = this.columnHelper.getColumn1Based(i, false);
            column1Based3.setOutlineLevel((short) (column1Based3.getOutlineLevel() + 1));
            i = ((int) column1Based3.getMax()) + 1;
        }
        this.worksheet.setColsArray(0, colsArray);
        setSheetFormatPrOutlineLevelCol();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.POIXMLException */
    private void initHyperlinks() throws POIXMLException {
        this.hyperlinks = new ArrayList();
        if (this.worksheet.isSetHyperlinks()) {
            try {
                PackageRelationshipCollection relationshipsByType = getPackagePart().getRelationshipsByType(XSSFRelation.SHEET_HYPERLINKS.getRelation());
                for (CTHyperlink cTHyperlink : this.worksheet.getHyperlinks().getHyperlinkArray()) {
                    this.hyperlinks.add(new XSSFHyperlink(cTHyperlink, cTHyperlink.getId() != null ? relationshipsByType.getRelationshipByID(cTHyperlink.getId()) : null));
                }
            } catch (InvalidFormatException e) {
                throw new POIXMLException(e);
            }
        }
    }

    private void initRows(CTWorksheet cTWorksheet) {
        this._rows.clear();
        this.tables = new TreeMap();
        this.sharedFormulas = new HashMap();
        this.arrayFormulas = new ArrayList();
        for (CTRow cTRow : cTWorksheet.getSheetData().getRowArray()) {
            XSSFRow xSSFRow = new XSSFRow(cTRow, this);
            this._rows.put(new Integer(xSSFRow.getRowNum()), xSSFRow);
        }
    }

    private boolean isAdjacentBefore(CTCol cTCol, CTCol cTCol2) {
        return cTCol.getMax() == cTCol2.getMin() - 1;
    }

    private boolean isColumnGroupCollapsed(int i) {
        CTCol[] colArray = this.worksheet.getColsArray(0).getColArray();
        int iFindEndOfColumnOutlineGroup = findEndOfColumnOutlineGroup(i);
        int i2 = iFindEndOfColumnOutlineGroup + 1;
        if (i2 >= colArray.length) {
            return false;
        }
        CTCol cTCol = colArray[i2];
        if (isAdjacentBefore(colArray[iFindEndOfColumnOutlineGroup], cTCol)) {
            return cTCol.getCollapsed();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean isColumnGroupHiddenByParent(int i) {
        short outlineLevel;
        boolean hidden;
        boolean hidden2;
        short outlineLevel2 = 0;
        CTCols colsArray = this.worksheet.getColsArray(0);
        int iFindEndOfColumnOutlineGroup = findEndOfColumnOutlineGroup(i);
        CTCol[] colArray = colsArray.getColArray();
        if (iFindEndOfColumnOutlineGroup < colArray.length) {
            CTCol cTCol = colArray[iFindEndOfColumnOutlineGroup + 1];
            if (isAdjacentBefore(colArray[iFindEndOfColumnOutlineGroup], cTCol)) {
                outlineLevel = cTCol.getOutlineLevel();
                hidden = cTCol.getHidden();
            } else {
                outlineLevel = 0;
                hidden = false;
            }
        }
        int iFindStartOfColumnOutlineGroup = findStartOfColumnOutlineGroup(i);
        if (iFindStartOfColumnOutlineGroup > 0) {
            CTCol cTCol2 = colArray[iFindStartOfColumnOutlineGroup - 1];
            if (isAdjacentBefore(cTCol2, colArray[iFindStartOfColumnOutlineGroup])) {
                outlineLevel2 = cTCol2.getOutlineLevel();
                hidden2 = cTCol2.getHidden();
            } else {
                hidden2 = false;
            }
        }
        return outlineLevel > outlineLevel2 ? hidden : hidden2;
    }

    private boolean isRowGroupCollapsed(int i) {
        int iFindEndOfRowOutlineGroup = findEndOfRowOutlineGroup(i) + 1;
        if (getRow(iFindEndOfRowOutlineGroup) == null) {
            return false;
        }
        return getRow(iFindEndOfRowOutlineGroup).getCTRow().getCollapsed();
    }

    private boolean isRowGroupHiddenByParent(int i) {
        short outlineLevel;
        boolean hidden;
        boolean hidden2;
        int iFindEndOfRowOutlineGroup = findEndOfRowOutlineGroup(i);
        short outlineLevel2 = 0;
        if (getRow(iFindEndOfRowOutlineGroup) == null) {
            hidden = false;
            outlineLevel = 0;
        } else {
            outlineLevel = getRow(iFindEndOfRowOutlineGroup).getCTRow().getOutlineLevel();
            hidden = getRow(iFindEndOfRowOutlineGroup).getCTRow().getHidden();
        }
        int iFindStartOfRowOutlineGroup = findStartOfRowOutlineGroup(i);
        if (iFindStartOfRowOutlineGroup < 0 || getRow(iFindStartOfRowOutlineGroup) == null) {
            hidden2 = false;
        } else {
            outlineLevel2 = getRow(iFindStartOfRowOutlineGroup).getCTRow().getOutlineLevel();
            hidden2 = getRow(iFindStartOfRowOutlineGroup).getCTRow().getHidden();
        }
        return outlineLevel > outlineLevel2 ? hidden : hidden2;
    }

    private static CTWorksheet newSheet() {
        CTWorksheet cTWorksheetNewInstance = CTWorksheet.Factory.newInstance();
        cTWorksheetNewInstance.addNewSheetFormatPr().setDefaultRowHeight(DEFAULT_ROW_HEIGHT);
        cTWorksheetNewInstance.addNewSheetViews().addNewSheetView().setWorkbookViewId(0L);
        cTWorksheetNewInstance.addNewDimension().setRef("A1");
        cTWorksheetNewInstance.addNewSheetData();
        CTPageMargins cTPageMarginsAddNewPageMargins = cTWorksheetNewInstance.addNewPageMargins();
        cTPageMarginsAddNewPageMargins.setBottom(0.75d);
        cTPageMarginsAddNewPageMargins.setFooter(0.3d);
        cTPageMarginsAddNewPageMargins.setHeader(0.3d);
        cTPageMarginsAddNewPageMargins.setLeft(0.7d);
        cTPageMarginsAddNewPageMargins.setRight(0.7d);
        cTPageMarginsAddNewPageMargins.setTop(0.75d);
        return cTWorksheetNewInstance;
    }

    private void removeBreak(int i, CTPageBreak cTPageBreak) {
        int i2 = i + 1;
        CTBreak[] brkArray = cTPageBreak.getBrkArray();
        for (int i4 = 0; i4 < brkArray.length; i4++) {
            if (brkArray[i4].getId() == i2) {
                cTPageBreak.removeBrk(i4);
            }
        }
    }

    private CTSheetProtection safeGetProtectionField() {
        return !isSheetProtectionEnabled() ? this.worksheet.addNewSheetProtection() : this.worksheet.getSheetProtection();
    }

    private void setBreak(int i, CTPageBreak cTPageBreak, int i2) {
        CTBreak cTBreakAddNewBrk = cTPageBreak.addNewBrk();
        cTBreakAddNewBrk.setId(i + 1);
        cTBreakAddNewBrk.setMan(true);
        cTBreakAddNewBrk.setMax(i2);
        long jSizeOfBrkArray = cTPageBreak.sizeOfBrkArray();
        cTPageBreak.setCount(jSizeOfBrkArray);
        cTPageBreak.setManualBreakCount(jSizeOfBrkArray);
    }

    private void setColWidthAttribute(CTCols cTCols) {
        for (CTCol cTCol : cTCols.getColArray()) {
            if (!cTCol.isSetWidth()) {
                cTCol.setWidth(getDefaultColumnWidth());
                cTCol.setCustomWidth(false);
            }
        }
    }

    private void setColumn(int i, Integer num, Integer num2, Boolean bool, Boolean bool2) {
        CTCol cTCol;
        boolean z = false;
        CTCols colsArray = this.worksheet.getColsArray(0);
        CTCol[] colArray = colsArray.getColArray();
        int length = colArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            cTCol = colArray[i2];
            long min = cTCol.getMin();
            long max = cTCol.getMax();
            long j = i;
            if (min >= j && max <= j) {
                break;
            } else {
                if (min > j) {
                    break;
                }
            }
        }
        cTCol = null;
        if (cTCol == null) {
            CTCol cTColNewInstance = CTCol.Factory.newInstance();
            long j2 = i;
            cTColNewInstance.setMin(j2);
            cTColNewInstance.setMax(j2);
            unsetCollapsed(bool2.booleanValue(), cTColNewInstance);
            this.columnHelper.addCleanColIntoCols(colsArray, cTColNewInstance);
            return;
        }
        boolean z2 = (num == null || cTCol.getStyle() == ((long) num.intValue())) ? false : true;
        boolean z3 = (num2 == null || cTCol.getOutlineLevel() == num2.intValue()) ? false : true;
        boolean z4 = (bool == null || cTCol.getHidden() == bool.booleanValue()) ? false : true;
        if (bool2 != null && cTCol.getCollapsed() != bool2.booleanValue()) {
            z = true;
        }
        if (z3 || z4 || z || z2) {
            long min2 = cTCol.getMin();
            long max2 = cTCol.getMax();
            long j3 = i;
            if (min2 == j3 && max2 == j3) {
                unsetCollapsed(bool2.booleanValue(), cTCol);
                return;
            }
            if (min2 == j3 || max2 == j3) {
                if (min2 == j3) {
                    cTCol.setMin(i + 1);
                } else {
                    cTCol.setMax(i - 1);
                }
                CTCol cTColCloneCol = this.columnHelper.cloneCol(colsArray, cTCol);
                cTColCloneCol.setMin(j3);
                unsetCollapsed(bool2.booleanValue(), cTColCloneCol);
                this.columnHelper.addCleanColIntoCols(colsArray, cTColCloneCol);
                return;
            }
            CTCol cTColCloneCol2 = this.columnHelper.cloneCol(colsArray, cTCol);
            CTCol cTColCloneCol3 = this.columnHelper.cloneCol(colsArray, cTCol);
            cTCol.setMax(i - 1);
            cTColCloneCol2.setMin(j3);
            cTColCloneCol2.setMax(j3);
            unsetCollapsed(bool2.booleanValue(), cTColCloneCol2);
            this.columnHelper.addCleanColIntoCols(colsArray, cTColCloneCol2);
            cTColCloneCol3.setMin(i + 1);
            cTColCloneCol3.setMax((int) max2);
            this.columnHelper.addCleanColIntoCols(colsArray, cTColCloneCol3);
        }
    }

    private int setGroupHidden(int i, int i2, boolean z) {
        CTCol[] colArray = this.worksheet.getColsArray(0).getColArray();
        CTCol cTCol = colArray[i];
        while (i < colArray.length) {
            cTCol.setHidden(z);
            i++;
            if (i < colArray.length) {
                CTCol cTCol2 = colArray[i];
                if (!isAdjacentBefore(cTCol, cTCol2) || cTCol2.getOutlineLevel() < i2) {
                    break;
                }
                cTCol = cTCol2;
            }
        }
        return (int) cTCol.getMax();
    }

    private void setRepeatingRowsAndColumns(CellRangeAddress cellRangeAddress, CellRangeAddress cellRangeAddress2) {
        int firstRow;
        int lastRow;
        int lastColumn;
        int i = -1;
        if (cellRangeAddress != null) {
            firstRow = cellRangeAddress.getFirstRow();
            lastRow = cellRangeAddress.getLastRow();
            if ((firstRow == -1 && lastRow != -1) || firstRow < -1 || lastRow < -1 || firstRow > lastRow) {
                throw new IllegalArgumentException("Invalid row range specification");
            }
        } else {
            firstRow = -1;
            lastRow = -1;
        }
        if (cellRangeAddress2 != null) {
            int firstColumn = cellRangeAddress2.getFirstColumn();
            lastColumn = cellRangeAddress2.getLastColumn();
            if ((firstColumn == -1 && lastColumn != -1) || firstColumn < -1 || lastColumn < -1 || firstColumn > lastColumn) {
                throw new IllegalArgumentException("Invalid column range specification");
            }
            i = firstColumn;
        } else {
            lastColumn = -1;
        }
        int sheetIndex = getWorkbook().getSheetIndex(this);
        boolean z = cellRangeAddress == null && cellRangeAddress2 == null;
        XSSFName builtInName = getWorkbook().getBuiltInName("_xlnm.Print_Titles", sheetIndex);
        if (z) {
            if (builtInName != null) {
                getWorkbook().removeName(builtInName);
                return;
            }
            return;
        }
        if (builtInName == null) {
            builtInName = getWorkbook().createBuiltInName("_xlnm.Print_Titles", sheetIndex);
        }
        builtInName.setRefersToFormula(getReferenceBuiltInRecord(builtInName.getSheetName(), i, lastColumn, firstRow, lastRow));
        if (this.worksheet.isSetPageSetup() && this.worksheet.isSetPageMargins()) {
            return;
        }
        getPrintSetup().setValidSettings(false);
    }

    private void setSheetFormatPrOutlineLevelCol() {
        getSheetTypeSheetFormatPr().setOutlineLevelCol(getMaxOutlineLevelCols());
    }

    private void setSheetFormatPrOutlineLevelRow() {
        getSheetTypeSheetFormatPr().setOutlineLevelRow(getMaxOutlineLevelRows());
    }

    private int shiftedRowNum(int i, int i2, int i4, int i5) {
        return ((i5 >= i || (i4 <= 0 && i - i5 <= i4)) && (i5 <= i2 || (i4 >= 0 && i5 - i2 <= i4))) ? i5 < i ? (i2 - i) + i5 : i5 > i2 ? i5 - (i2 - i) : i5 + i4 : i5;
    }

    private static boolean shouldRemoveRow(int i, int i2, int i4, int i5) {
        if (i5 < i + i4 || i5 > i2 + i4) {
            return false;
        }
        if (i4 <= 0 || i5 <= i2) {
            return i4 < 0 && i5 < i;
        }
        return true;
    }

    private void unsetCollapsed(boolean z, CTCol cTCol) {
        if (z) {
            cTCol.setCollapsed(z);
        } else {
            cTCol.unsetCollapsed();
        }
    }

    private void validateArrayFormulas(CellRangeAddress cellRangeAddress) {
        int firstColumn = cellRangeAddress.getFirstColumn();
        int lastRow = cellRangeAddress.getLastRow();
        int lastColumn = cellRangeAddress.getLastColumn();
        for (int firstRow = cellRangeAddress.getFirstRow(); firstRow <= lastRow; firstRow++) {
            XSSFRow row = getRow(firstRow);
            if (row != null) {
                for (int i = firstColumn; i <= lastColumn; i++) {
                    XSSFCell cell = row.getCell(i);
                    if (cell != null && cell.isPartOfArrayFormulaGroup()) {
                        CellRangeAddress arrayFormulaRange = cell.getArrayFormulaRange();
                        if (arrayFormulaRange.getNumberOfCells() > 1 && cellRangeAddress.intersects(arrayFormulaRange)) {
                            throw new IllegalStateException(AbstractC0622a.m1170p(cellRangeAddress.formatAsString(), " intersects with a multi-cell array formula. You cannot merge cells of an array.", new StringBuilder("The range ")));
                        }
                    }
                }
            }
        }
    }

    private void validateMergedRegions(CellRangeAddress cellRangeAddress) {
        for (CellRangeAddress cellRangeAddress2 : getMergedRegions()) {
            if (cellRangeAddress2.intersects(cellRangeAddress)) {
                StringBuilder sb = new StringBuilder("Cannot add merged region ");
                sb.append(cellRangeAddress.formatAsString());
                sb.append(" to sheet because it overlaps with an existing merged region (");
                throw new IllegalStateException(AbstractC0622a.m1170p(cellRangeAddress2.formatAsString(), ").", sb));
            }
        }
    }

    private int writeHidden(XSSFRow xSSFRow, int i, boolean z) {
        short outlineLevel = xSSFRow.getCTRow().getOutlineLevel();
        Iterator<Row> itRowIterator = rowIterator();
        while (itRowIterator.hasNext()) {
            XSSFRow next = itRowIterator.next();
            if (next.getRowNum() >= i && next.getCTRow().getOutlineLevel() >= outlineLevel) {
                next.getCTRow().setHidden(z);
                i++;
            }
        }
        return i;
    }

    @Internal
    public void addHyperlink(XSSFHyperlink xSSFHyperlink) {
        this.hyperlinks.add(xSSFHyperlink);
    }

    public void addIgnoredErrors(CellReference cellReference, IgnoredErrorType... ignoredErrorTypeArr) {
        addIgnoredErrors(cellReference.formatAsString(), ignoredErrorTypeArr);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public int addMergedRegion(CellRangeAddress cellRangeAddress) {
        return addMergedRegion(cellRangeAddress, true);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public int addMergedRegionUnsafe(CellRangeAddress cellRangeAddress) {
        return addMergedRegion(cellRangeAddress, false);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void addValidationData(DataValidation dataValidation) {
        XSSFDataValidation xSSFDataValidation = (XSSFDataValidation) dataValidation;
        CTDataValidations dataValidations = this.worksheet.getDataValidations();
        if (dataValidations == null) {
            dataValidations = this.worksheet.addNewDataValidations();
        }
        int iSizeOfDataValidationArray = dataValidations.sizeOfDataValidationArray();
        dataValidations.addNewDataValidation().set(xSSFDataValidation.getCtDdataValidation());
        dataValidations.setCount(iSizeOfDataValidationArray + 1);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void autoSizeColumn(int i) {
        autoSizeColumn(i, false);
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    public void commit() throws IOException {
        OutputStream outputStream = getPackagePart().getOutputStream();
        write(outputStream);
        outputStream.close();
    }

    public void copyRows(List<? extends Row> list, int i, CellCopyPolicy cellCopyPolicy) {
        int i2;
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("No rows to copy");
        }
        Row row = list.get(0);
        Row row2 = (Row) AbstractC0000a.m10g(list, 1);
        if (row == null) {
            throw new IllegalArgumentException("copyRows: First row cannot be null");
        }
        int rowNum = row.getRowNum();
        int rowNum2 = row2.getRowNum();
        int size = list.size();
        for (int i4 = 1; i4 < size; i4++) {
            Row row3 = list.get(i4);
            if (row3 == null) {
                throw new IllegalArgumentException(AbstractC0541b.m767i(i4, "srcRows may not contain null rows. Found null row at index ", Extension.DOT));
            }
            if (row.getSheet().getWorkbook() != row3.getSheet().getWorkbook()) {
                throw new IllegalArgumentException("All rows in srcRows must belong to the same sheet in the same workbook.Expected all rows from same workbook (" + row.getSheet().getWorkbook() + "). Got srcRows[" + i4 + "] from different workbook (" + row3.getSheet().getWorkbook() + ").");
            }
            if (row.getSheet() != row3.getSheet()) {
                throw new IllegalArgumentException("All rows in srcRows must belong to the same sheet. Expected all rows from " + row.getSheet().getSheetName() + ". Got srcRows[" + i4 + "] from " + row3.getSheet().getSheetName());
            }
        }
        CellCopyPolicy cellCopyPolicy2 = new CellCopyPolicy(cellCopyPolicy);
        cellCopyPolicy2.setCopyMergedRegions(false);
        int rowNum3 = i;
        for (Row row4 : list) {
            if (cellCopyPolicy.isCondenseRows()) {
                i2 = rowNum3 + 1;
            } else {
                i2 = rowNum3;
                rowNum3 = (row4.getRowNum() - rowNum) + i;
            }
            createRow(rowNum3).copyRowFrom(row4, cellCopyPolicy2);
            rowNum3 = i2;
        }
        if (cellCopyPolicy.isCopyMergedRegions()) {
            int i5 = i - rowNum;
            for (CellRangeAddress cellRangeAddress : row.getSheet().getMergedRegions()) {
                if (rowNum <= cellRangeAddress.getFirstRow() && cellRangeAddress.getLastRow() <= rowNum2) {
                    CellRangeAddress cellRangeAddressCopy = cellRangeAddress.copy();
                    cellRangeAddressCopy.setFirstRow(cellRangeAddressCopy.getFirstRow() + i5);
                    cellRangeAddressCopy.setLastRow(cellRangeAddressCopy.getLastRow() + i5);
                    addMergedRegion(cellRangeAddressCopy);
                }
            }
        }
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void createFreezePane(int i, int i2) {
        createFreezePane(i, i2, i, i2);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void createSplitPane(int i, int i2, int i4, int i5, int i6) {
        createFreezePane(i, i2, i4, i5);
        getPane().setState(STPaneState.SPLIT);
        getPane().setActivePane(STPane.Enum.forInt(i6));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.POIXMLException */
    public XSSFTable createTable() throws POIXMLException {
        if (!this.worksheet.isSetTableParts()) {
            this.worksheet.addNewTableParts();
        }
        CTTablePart cTTablePartAddNewTablePart = this.worksheet.getTableParts().addNewTablePart();
        OPCPackage oPCPackage = getPackagePart().getPackage();
        XSSFRelation xSSFRelation = XSSFRelation.TABLE;
        int size = oPCPackage.getPartsByContentType(xSSFRelation.getContentType()).size() + 1;
        POIXMLDocumentPart.RelationPart relationPartCreateRelationship = createRelationship(xSSFRelation, XSSFFactory.getInstance(), size, false);
        XSSFTable xSSFTable = (XSSFTable) relationPartCreateRelationship.getDocumentPart();
        cTTablePartAddNewTablePart.setId(relationPartCreateRelationship.getRelationship().getId());
        xSSFTable.getCTTable().setId(size);
        this.tables.put(cTTablePartAddNewTablePart.getId(), xSSFTable);
        return xSSFTable;
    }

    public void disableLocking() {
        safeGetProtectionField().setSheet(false);
    }

    public void enableLocking() {
        safeGetProtectionField().setSheet(true);
    }

    public int findEndOfRowOutlineGroup(int i) {
        short outlineLevel = getRow(i).getCTRow().getOutlineLevel();
        int lastRowNum = getLastRowNum();
        while (i < lastRowNum && getRow(i) != null && getRow(i).getCTRow().getOutlineLevel() >= outlineLevel) {
            i++;
        }
        return i;
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public CellAddress getActiveCell() {
        String activeCell = getSheetTypeSelection().getActiveCell();
        if (activeCell == null) {
            return null;
        }
        return new CellAddress(activeCell);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public boolean getAutobreaks() {
        CTSheetPr sheetTypeSheetPr = getSheetTypeSheetPr();
        return ((sheetTypeSheetPr == null || !sheetTypeSheetPr.isSetPageSetUpPr()) ? CTPageSetUpPr.Factory.newInstance() : sheetTypeSheetPr.getPageSetUpPr()).getAutoPageBreaks();
    }

    public CTDrawing getCTDrawing() {
        return this.worksheet.getDrawing();
    }

    public CTLegacyDrawing getCTLegacyDrawing() {
        return this.worksheet.getLegacyDrawing();
    }

    @Internal
    public CTWorksheet getCTWorksheet() {
        return this.worksheet;
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public Map<CellAddress, XSSFComment> getCellComments() {
        CommentsTable commentsTable = this.sheetComments;
        return commentsTable == null ? Collections.EMPTY_MAP : commentsTable.getCellComments();
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public int[] getColumnBreaks() {
        return this.worksheet.isSetColBreaks() ? getBreaks(this.worksheet.getColBreaks()) : new int[0];
    }

    public ColumnHelper getColumnHelper() {
        return this.columnHelper;
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public int getColumnOutlineLevel(int i) {
        CTCol column = this.columnHelper.getColumn(i, false);
        if (column == null) {
            return 0;
        }
        return column.getOutlineLevel();
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public CellStyle getColumnStyle(int i) {
        int colDefaultStyle = this.columnHelper.getColDefaultStyle(i);
        XSSFWorkbook workbook = getWorkbook();
        if (colDefaultStyle == -1) {
            colDefaultStyle = 0;
        }
        return workbook.getCellStyleAt((short) colDefaultStyle);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public int getColumnWidth(int i) {
        CTCol column = this.columnHelper.getColumn(i, false);
        return (int) (((column == null || !column.isSetWidth()) ? getDefaultColumnWidth() : column.getWidth()) * 256.0d);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public float getColumnWidthInPixels(int i) {
        return (float) ((((double) getColumnWidth(i)) / 256.0d) * 7.001699924468994d);
    }

    public CommentsTable getCommentsTable(boolean z) {
        if (this.sheetComments == null && z) {
            try {
                this.sheetComments = (CommentsTable) createRelationship(XSSFRelation.SHEET_COMMENTS, XSSFFactory.getInstance(), (int) this.sheet.getSheetId());
            } catch (PartAlreadyExistsException unused) {
                this.sheetComments = (CommentsTable) createRelationship(XSSFRelation.SHEET_COMMENTS, XSSFFactory.getInstance(), -1);
            }
        }
        return this.sheetComments;
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public DataValidationHelper getDataValidationHelper() {
        return this.dataValidationHelper;
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public List<XSSFDataValidation> getDataValidations() {
        ArrayList arrayList = new ArrayList();
        CTDataValidations dataValidations = this.worksheet.getDataValidations();
        if (dataValidations != null && dataValidations.getCount() > 0) {
            CTDataValidation[] dataValidationArray = dataValidations.getDataValidationArray();
            int length = dataValidationArray.length;
            int i = 0;
            int i2 = 0;
            while (i2 < length) {
                CTDataValidation cTDataValidation = dataValidationArray[i2];
                CellRangeAddressList cellRangeAddressList = new CellRangeAddressList();
                Iterator it = cTDataValidation.getSqref().iterator();
                while (it.hasNext()) {
                    String[] strArrSplit = ((String) it.next()).split(" ");
                    int length2 = strArrSplit.length;
                    int i4 = i;
                    while (i4 < length2) {
                        String[] strArrSplit2 = strArrSplit[i4].split(":");
                        CellReference cellReference = new CellReference(strArrSplit2[i]);
                        CellReference cellReference2 = strArrSplit2.length > 1 ? new CellReference(strArrSplit2[1]) : cellReference;
                        cellRangeAddressList.addCellRangeAddress(new CellRangeAddress(cellReference.getRow(), cellReference2.getRow(), cellReference.getCol(), cellReference2.getCol()));
                        i4++;
                        i = 0;
                    }
                }
                arrayList.add(new XSSFDataValidation(cellRangeAddressList, cTDataValidation));
                i2++;
                i = 0;
            }
        }
        return arrayList;
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public int getDefaultColumnWidth() {
        CTSheetFormatPr sheetFormatPr = this.worksheet.getSheetFormatPr();
        if (sheetFormatPr == null) {
            return 8;
        }
        return (int) sheetFormatPr.getBaseColWidth();
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public short getDefaultRowHeight() {
        return (short) (getDefaultRowHeightInPoints() * 20.0f);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public float getDefaultRowHeightInPoints() {
        CTSheetFormatPr sheetFormatPr = this.worksheet.getSheetFormatPr();
        return (float) (sheetFormatPr == null ? 0.0d : sheetFormatPr.getDefaultRowHeight());
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public boolean getDisplayGuts() {
        CTSheetPr sheetTypeSheetPr = getSheetTypeSheetPr();
        return (sheetTypeSheetPr.getOutlinePr() == null ? CTOutlinePr.Factory.newInstance() : sheetTypeSheetPr.getOutlinePr()).getShowOutlineSymbols();
    }

    public Footer getEvenFooter() {
        return new XSSFEvenFooter(getSheetTypeHeaderFooter());
    }

    public Header getEvenHeader() {
        return new XSSFEvenHeader(getSheetTypeHeaderFooter());
    }

    public XSSFCell getFirstCellInArrayFormula(XSSFCell xSSFCell) {
        for (CellRangeAddress cellRangeAddress : this.arrayFormulas) {
            if (cellRangeAddress.isInRange(xSSFCell.getRowIndex(), xSSFCell.getColumnIndex())) {
                return getRow(cellRangeAddress.getFirstRow()).getCell(cellRangeAddress.getFirstColumn());
            }
        }
        return null;
    }

    public Footer getFirstFooter() {
        return new XSSFFirstFooter(getSheetTypeHeaderFooter());
    }

    public Header getFirstHeader() {
        return new XSSFFirstHeader(getSheetTypeHeaderFooter());
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public int getFirstRowNum() {
        if (this._rows.isEmpty()) {
            return 0;
        }
        return this._rows.firstKey().intValue();
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public boolean getFitToPage() {
        CTSheetPr sheetTypeSheetPr = getSheetTypeSheetPr();
        return ((sheetTypeSheetPr == null || !sheetTypeSheetPr.isSetPageSetUpPr()) ? CTPageSetUpPr.Factory.newInstance() : sheetTypeSheetPr.getPageSetUpPr()).getFitToPage();
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public Footer getFooter() {
        return getOddFooter();
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public boolean getForceFormulaRecalculation() {
        if (this.worksheet.isSetSheetCalcPr()) {
            return this.worksheet.getSheetCalcPr().getFullCalcOnLoad();
        }
        return false;
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public Header getHeader() {
        return getOddHeader();
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public boolean getHorizontallyCenter() {
        CTPrintOptions printOptions = this.worksheet.getPrintOptions();
        return printOptions != null && printOptions.getHorizontalCentered();
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public List<XSSFHyperlink> getHyperlinkList() {
        return Collections.unmodifiableList(this.hyperlinks);
    }

    public Map<IgnoredErrorType, Set<CellRangeAddress>> getIgnoredErrors() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.worksheet.isSetIgnoredErrors()) {
            for (CTIgnoredError cTIgnoredError : this.worksheet.getIgnoredErrors().getIgnoredErrorList()) {
                for (IgnoredErrorType ignoredErrorType : XSSFIgnoredErrorHelper.getErrorTypes(cTIgnoredError)) {
                    if (!linkedHashMap.containsKey(ignoredErrorType)) {
                        linkedHashMap.put(ignoredErrorType, new LinkedHashSet());
                    }
                    Iterator it = cTIgnoredError.getSqref().iterator();
                    while (it.hasNext()) {
                        ((Set) linkedHashMap.get(ignoredErrorType)).add(CellRangeAddress.valueOf(it.next().toString()));
                    }
                }
            }
        }
        return linkedHashMap;
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public int getLastRowNum() {
        if (this._rows.isEmpty()) {
            return 0;
        }
        return this._rows.lastKey().intValue();
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public short getLeftCol() {
        String topLeftCell = this.worksheet.getSheetViews().getSheetViewArray(0).getTopLeftCell();
        if (topLeftCell == null) {
            return (short) 0;
        }
        return new CellReference(topLeftCell).getCol();
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public double getMargin(short s) {
        if (!this.worksheet.isSetPageMargins()) {
            return 0.0d;
        }
        CTPageMargins pageMargins = this.worksheet.getPageMargins();
        if (s == 0) {
            return pageMargins.getLeft();
        }
        if (s == 1) {
            return pageMargins.getRight();
        }
        if (s == 2) {
            return pageMargins.getTop();
        }
        if (s == 3) {
            return pageMargins.getBottom();
        }
        if (s == 4) {
            return pageMargins.getHeader();
        }
        if (s == 5) {
            return pageMargins.getFooter();
        }
        throw new IllegalArgumentException(AbstractC0000a.m11h(s, "Unknown margin constant:  "));
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public CellRangeAddress getMergedRegion(int i) {
        CTMergeCells mergeCells = this.worksheet.getMergeCells();
        if (mergeCells != null) {
            return CellRangeAddress.valueOf(mergeCells.getMergeCellArray(i).getRef());
        }
        throw new IllegalStateException("This worksheet does not contain merged regions");
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public List<CellRangeAddress> getMergedRegions() {
        ArrayList arrayList = new ArrayList();
        CTMergeCells mergeCells = this.worksheet.getMergeCells();
        if (mergeCells != null) {
            for (CTMergeCell cTMergeCell : mergeCells.getMergeCellArray()) {
                arrayList.add(CellRangeAddress.valueOf(cTMergeCell.getRef()));
            }
        }
        return arrayList;
    }

    public int getNumHyperlinks() {
        return this.hyperlinks.size();
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public int getNumMergedRegions() {
        CTMergeCells mergeCells = this.worksheet.getMergeCells();
        if (mergeCells == null) {
            return 0;
        }
        return mergeCells.sizeOfMergeCellArray();
    }

    public int getNumberOfComments() {
        CommentsTable commentsTable = this.sheetComments;
        if (commentsTable == null) {
            return 0;
        }
        return commentsTable.getNumberOfComments();
    }

    public Footer getOddFooter() {
        return new XSSFOddFooter(getSheetTypeHeaderFooter());
    }

    public Header getOddHeader() {
        return new XSSFOddHeader(getSheetTypeHeaderFooter());
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public PaneInformation getPaneInformation() {
        CTPane pane = getDefaultSheetView().getPane();
        if (pane == null) {
            return null;
        }
        CellReference cellReference = pane.isSetTopLeftCell() ? new CellReference(pane.getTopLeftCell()) : null;
        return new PaneInformation((short) pane.getXSplit(), (short) pane.getYSplit(), (short) (cellReference == null ? 0 : cellReference.getRow()), cellReference == null ? (short) 0 : cellReference.getCol(), (byte) (pane.getActivePane().intValue() - 1), pane.getState() == STPaneState.FROZEN);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public int getPhysicalNumberOfRows() {
        return this._rows.size();
    }

    public List<XSSFPivotTable> getPivotTables() {
        ArrayList arrayList = new ArrayList();
        for (XSSFPivotTable xSSFPivotTable : getWorkbook().getPivotTables()) {
            if (xSSFPivotTable.getParent() == this) {
                arrayList.add(xSSFPivotTable);
            }
        }
        return arrayList;
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public boolean getProtect() {
        return isSheetLocked();
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public CellRangeAddress getRepeatingColumns() {
        return getRepeatingRowsOrColums(false);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public CellRangeAddress getRepeatingRows() {
        return getRepeatingRowsOrColums(true);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public int[] getRowBreaks() {
        return this.worksheet.isSetRowBreaks() ? getBreaks(this.worksheet.getRowBreaks()) : new int[0];
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public boolean getRowSumsBelow() {
        CTSheetPr sheetPr = this.worksheet.getSheetPr();
        CTOutlinePr outlinePr = (sheetPr == null || !sheetPr.isSetOutlinePr()) ? null : sheetPr.getOutlinePr();
        return outlinePr == null || outlinePr.getSummaryBelow();
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public boolean getRowSumsRight() {
        CTSheetPr sheetPr = this.worksheet.getSheetPr();
        return ((sheetPr == null || !sheetPr.isSetOutlinePr()) ? CTOutlinePr.Factory.newInstance() : sheetPr.getOutlinePr()).getSummaryRight();
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public boolean getScenarioProtect() {
        return this.worksheet.isSetSheetProtection() && this.worksheet.getSheetProtection().getScenarios();
    }

    @Internal
    public CTCellFormula getSharedFormula(int i) {
        return this.sharedFormulas.get(Integer.valueOf(i));
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public String getSheetName() {
        return this.sheet.getName();
    }

    public XSSFColor getTabColor() {
        CTSheetPr sheetPr = this.worksheet.getSheetPr();
        if (sheetPr == null) {
            sheetPr = this.worksheet.addNewSheetPr();
        }
        if (sheetPr.isSetTabColor()) {
            return new XSSFColor(sheetPr.getTabColor(), getWorkbook().getStylesSource().getIndexedColors());
        }
        return null;
    }

    public List<XSSFTable> getTables() {
        return new ArrayList(this.tables.values());
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public short getTopRow() {
        String topLeftCell = getSheetTypeSheetView().getTopLeftCell();
        if (topLeftCell == null) {
            return (short) 0;
        }
        return (short) new CellReference(topLeftCell).getRow();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.POIXMLException */
    public XSSFVMLDrawing getVMLDrawing(boolean z) throws POIXMLException {
        CTLegacyDrawing cTLegacyDrawing = getCTLegacyDrawing();
        XSSFVMLDrawing xSSFVMLDrawing = null;
        if (cTLegacyDrawing == null) {
            if (!z) {
                return null;
            }
            OPCPackage oPCPackage = getPackagePart().getPackage();
            XSSFRelation xSSFRelation = XSSFRelation.VML_DRAWINGS;
            POIXMLDocumentPart.RelationPart relationPartCreateRelationship = createRelationship(xSSFRelation, XSSFFactory.getInstance(), oPCPackage.getPartsByContentType(xSSFRelation.getContentType()).size() + 1, false);
            XSSFVMLDrawing xSSFVMLDrawing2 = (XSSFVMLDrawing) relationPartCreateRelationship.getDocumentPart();
            this.worksheet.addNewLegacyDrawing().setId(relationPartCreateRelationship.getRelationship().getId());
            return xSSFVMLDrawing2;
        }
        String id = cTLegacyDrawing.getId();
        Iterator<POIXMLDocumentPart.RelationPart> it = getRelationParts().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            POIXMLDocumentPart.RelationPart next = it.next();
            POIXMLDocumentPart documentPart = next.getDocumentPart();
            if (documentPart instanceof XSSFVMLDrawing) {
                XSSFVMLDrawing xSSFVMLDrawing3 = (XSSFVMLDrawing) documentPart;
                if (next.getRelationship().getId().equals(id)) {
                    xSSFVMLDrawing = xSSFVMLDrawing3;
                    break;
                }
            }
        }
        if (xSSFVMLDrawing == null) {
            logger.log(7, AbstractC0541b.m773o("Can't find VML drawing with id=", id, " in the list of the sheet's relationships"));
        }
        return xSSFVMLDrawing;
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public boolean getVerticallyCenter() {
        CTPrintOptions printOptions = this.worksheet.getPrintOptions();
        return printOptions != null && printOptions.getVerticalCentered();
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void groupColumn(int i, int i2) {
        groupColumn1Based(i + 1, i2 + 1);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void groupRow(int i, int i2) {
        while (i <= i2) {
            XSSFRow row = getRow(i);
            if (row == null) {
                row = createRow(i);
            }
            CTRow cTRow = row.getCTRow();
            cTRow.setOutlineLevel((short) (cTRow.getOutlineLevel() + 1));
            i++;
        }
        setSheetFormatPrOutlineLevelRow();
    }

    public boolean hasComments() {
        CommentsTable commentsTable = this.sheetComments;
        return commentsTable != null && commentsTable.getNumberOfComments() > 0;
    }

    public boolean isAutoFilterLocked() {
        return isSheetLocked() && safeGetProtectionField().getAutoFilter();
    }

    public boolean isCellInArrayFormulaContext(XSSFCell xSSFCell) {
        Iterator<CellRangeAddress> it = this.arrayFormulas.iterator();
        while (it.hasNext()) {
            if (it.next().isInRange(xSSFCell.getRowIndex(), xSSFCell.getColumnIndex())) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public boolean isColumnBroken(int i) {
        for (int i2 : getColumnBreaks()) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public boolean isColumnHidden(int i) {
        CTCol column = this.columnHelper.getColumn(i, false);
        return column != null && column.getHidden();
    }

    public boolean isDeleteColumnsLocked() {
        return isSheetLocked() && safeGetProtectionField().getDeleteColumns();
    }

    public boolean isDeleteRowsLocked() {
        return isSheetLocked() && safeGetProtectionField().getDeleteRows();
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public boolean isDisplayFormulas() {
        return getSheetTypeSheetView().getShowFormulas();
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public boolean isDisplayGridlines() {
        return getSheetTypeSheetView().getShowGridLines();
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public boolean isDisplayRowColHeadings() {
        return getSheetTypeSheetView().getShowRowColHeaders();
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public boolean isDisplayZeros() {
        CTSheetView defaultSheetView = getDefaultSheetView();
        return defaultSheetView == null || defaultSheetView.getShowZeros();
    }

    public boolean isFormatCellsLocked() {
        return isSheetLocked() && safeGetProtectionField().getFormatCells();
    }

    public boolean isFormatColumnsLocked() {
        return isSheetLocked() && safeGetProtectionField().getFormatColumns();
    }

    public boolean isFormatRowsLocked() {
        return isSheetLocked() && safeGetProtectionField().getFormatRows();
    }

    public boolean isInsertColumnsLocked() {
        return isSheetLocked() && safeGetProtectionField().getInsertColumns();
    }

    public boolean isInsertHyperlinksLocked() {
        return isSheetLocked() && safeGetProtectionField().getInsertHyperlinks();
    }

    public boolean isInsertRowsLocked() {
        return isSheetLocked() && safeGetProtectionField().getInsertRows();
    }

    public boolean isObjectsLocked() {
        return isSheetLocked() && safeGetProtectionField().getObjects();
    }

    public boolean isPivotTablesLocked() {
        return isSheetLocked() && safeGetProtectionField().getPivotTables();
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public boolean isPrintGridlines() {
        CTPrintOptions printOptions = this.worksheet.getPrintOptions();
        return printOptions != null && printOptions.getGridLines();
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public boolean isPrintRowAndColumnHeadings() {
        CTPrintOptions printOptions = this.worksheet.getPrintOptions();
        return printOptions != null && printOptions.getHeadings();
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public boolean isRightToLeft() {
        CTSheetView defaultSheetView = getDefaultSheetView();
        return defaultSheetView != null && defaultSheetView.getRightToLeft();
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public boolean isRowBroken(int i) {
        for (int i2 : getRowBreaks()) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public boolean isScenariosLocked() {
        return isSheetLocked() && safeGetProtectionField().getScenarios();
    }

    public boolean isSelectLockedCellsLocked() {
        return isSheetLocked() && safeGetProtectionField().getSelectLockedCells();
    }

    public boolean isSelectUnlockedCellsLocked() {
        return isSheetLocked() && safeGetProtectionField().getSelectUnlockedCells();
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public boolean isSelected() {
        CTSheetView defaultSheetView = getDefaultSheetView();
        return defaultSheetView != null && defaultSheetView.getTabSelected();
    }

    public boolean isSheetLocked() {
        return this.worksheet.isSetSheetProtection() && safeGetProtectionField().getSheet();
    }

    public boolean isSheetProtectionEnabled() {
        return this.worksheet.isSetSheetProtection();
    }

    public boolean isSortLocked() {
        return isSheetLocked() && safeGetProtectionField().getSort();
    }

    @Override // java.lang.Iterable
    public Iterator<Row> iterator() {
        return rowIterator();
    }

    public void lockAutoFilter(boolean z) {
        safeGetProtectionField().setAutoFilter(z);
    }

    public void lockDeleteColumns(boolean z) {
        safeGetProtectionField().setDeleteColumns(z);
    }

    public void lockDeleteRows(boolean z) {
        safeGetProtectionField().setDeleteRows(z);
    }

    public void lockFormatCells(boolean z) {
        safeGetProtectionField().setFormatCells(z);
    }

    public void lockFormatColumns(boolean z) {
        safeGetProtectionField().setFormatColumns(z);
    }

    public void lockFormatRows(boolean z) {
        safeGetProtectionField().setFormatRows(z);
    }

    public void lockInsertColumns(boolean z) {
        safeGetProtectionField().setInsertColumns(z);
    }

    public void lockInsertHyperlinks(boolean z) {
        safeGetProtectionField().setInsertHyperlinks(z);
    }

    public void lockInsertRows(boolean z) {
        safeGetProtectionField().setInsertRows(z);
    }

    public void lockObjects(boolean z) {
        safeGetProtectionField().setObjects(z);
    }

    public void lockPivotTables(boolean z) {
        safeGetProtectionField().setPivotTables(z);
    }

    public void lockScenarios(boolean z) {
        safeGetProtectionField().setScenarios(z);
    }

    public void lockSelectLockedCells(boolean z) {
        safeGetProtectionField().setSelectLockedCells(z);
    }

    public void lockSelectUnlockedCells(boolean z) {
        safeGetProtectionField().setSelectUnlockedCells(z);
    }

    public void lockSort(boolean z) {
        safeGetProtectionField().setSort(z);
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    public void onDocumentCreate() {
        CTWorksheet cTWorksheetNewSheet = newSheet();
        this.worksheet = cTWorksheetNewSheet;
        initRows(cTWorksheetNewSheet);
        this.columnHelper = new ColumnHelper(this.worksheet);
        this.hyperlinks = new ArrayList();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.POIXMLException */
    @Override // org.apache.poi.POIXMLDocumentPart
    public void onDocumentRead() throws POIXMLException {
        try {
            read(getPackagePart().getInputStream());
        } catch (IOException e) {
            throw new POIXMLException(e);
        }
    }

    public void onReadCell(XSSFCell xSSFCell) {
        CTCellFormula f = xSSFCell.getCTCell().getF();
        if (f != null && f.getT() == STCellFormulaType.SHARED && f.isSetRef() && f.getStringValue() != null) {
            CTCellFormula cTCellFormulaCopy = f.copy();
            CellRangeAddress cellRangeAddressValueOf = CellRangeAddress.valueOf(cTCellFormulaCopy.getRef());
            CellReference cellReference = new CellReference(xSSFCell);
            if (cellReference.getCol() > cellRangeAddressValueOf.getFirstColumn() || cellReference.getRow() > cellRangeAddressValueOf.getFirstRow()) {
                cTCellFormulaCopy.setRef(new CellRangeAddress(Math.max(cellReference.getRow(), cellRangeAddressValueOf.getFirstRow()), cellRangeAddressValueOf.getLastRow(), Math.max((int) cellReference.getCol(), cellRangeAddressValueOf.getFirstColumn()), cellRangeAddressValueOf.getLastColumn()).formatAsString());
            }
            this.sharedFormulas.put(Integer.valueOf((int) f.getSi()), cTCellFormulaCopy);
        }
        if (f == null || f.getT() != STCellFormulaType.ARRAY || f.getRef() == null) {
            return;
        }
        this.arrayFormulas.add(CellRangeAddress.valueOf(f.getRef()));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.POIXMLException */
    public void onSheetDelete() throws POIXMLException {
        for (POIXMLDocumentPart.RelationPart relationPart : getRelationParts()) {
            if (relationPart.getDocumentPart() instanceof XSSFTable) {
                removeTable((XSSFTable) relationPart.getDocumentPart());
            } else {
                removeRelation(relationPart.getDocumentPart(), true);
            }
        }
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void protectSheet(String str) {
        if (str == null) {
            this.worksheet.unsetSheetProtection();
            return;
        }
        CTSheetProtection cTSheetProtectionSafeGetProtectionField = safeGetProtectionField();
        setSheetPassword(str, null);
        cTSheetProtectionSafeGetProtectionField.setSheet(true);
        cTSheetProtectionSafeGetProtectionField.setScenarios(true);
        cTSheetProtectionSafeGetProtectionField.setObjects(true);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.POIXMLException */
    public void read(InputStream inputStream) throws POIXMLException {
        try {
            CTWorksheet worksheet = WorksheetDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getWorksheet();
            this.worksheet = worksheet;
            initRows(worksheet);
            this.columnHelper = new ColumnHelper(this.worksheet);
            for (POIXMLDocumentPart.RelationPart relationPart : getRelationParts()) {
                POIXMLDocumentPart documentPart = relationPart.getDocumentPart();
                if (documentPart instanceof CommentsTable) {
                    this.sheetComments = (CommentsTable) documentPart;
                }
                if (documentPart instanceof XSSFTable) {
                    this.tables.put(relationPart.getRelationship().getId(), (XSSFTable) documentPart);
                }
                if (documentPart instanceof XSSFPivotTable) {
                    getWorkbook().getPivotTables().add((XSSFPivotTable) documentPart);
                }
            }
            initHyperlinks();
        } catch (XmlException e) {
            throw new POIXMLException(e);
        }
    }

    public CTOleObject readOleObject(long j) {
        CTOleObject oleObjectArray;
        if (!getCTWorksheet().isSetOleObjects()) {
            return null;
        }
        XmlCursor xmlCursorNewCursor = getCTWorksheet().getOleObjects().newCursor();
        try {
            xmlCursorNewCursor.selectPath("declare namespace p='http://schemas.openxmlformats.org/spreadsheetml/2006/main' .//p:oleObject");
            oleObjectArray = null;
        } catch (Throwable th) {
            xmlCursorNewCursor.dispose();
            throw th;
        }
        while (xmlCursorNewCursor.toNextSelection()) {
            String attributeText = xmlCursorNewCursor.getAttributeText(new QName(null, "shapeId"));
            if (attributeText != null && Long.parseLong(attributeText) == j) {
                XmlObject object = xmlCursorNewCursor.getObject();
                if (!(object instanceof CTOleObject)) {
                    XMLStreamReader xMLStreamReaderNewXMLStreamReader = xmlCursorNewCursor.newXMLStreamReader();
                    try {
                        try {
                            CTOleObjects cTOleObjects = CTOleObjects.Factory.parse(xMLStreamReaderNewXMLStreamReader);
                            if (cTOleObjects.sizeOfOleObjectArray() == 0) {
                                try {
                                    xMLStreamReaderNewXMLStreamReader.close();
                                } catch (XMLStreamException e) {
                                    logger.log(3, "can't close reader", e);
                                }
                            } else {
                                oleObjectArray = cTOleObjects.getOleObjectArray(0);
                            }
                        } catch (XmlException e2) {
                            logger.log(3, "can't parse CTOleObjects", e2);
                            try {
                                xMLStreamReaderNewXMLStreamReader.close();
                            } catch (XMLStreamException e3) {
                                logger.log(3, "can't close reader", e3);
                            }
                        }
                    } finally {
                        try {
                            xMLStreamReaderNewXMLStreamReader.close();
                        } catch (XMLStreamException e5) {
                            logger.log(3, "can't close reader", e5);
                        }
                    }
                    xmlCursorNewCursor.dispose();
                    throw th;
                }
                oleObjectArray = (CTOleObject) object;
                if (xmlCursorNewCursor.toChild(XSSFRelation.NS_SPREADSHEETML, "objectPr")) {
                    break;
                }
            }
        }
        CTOleObject cTOleObject = oleObjectArray != null ? oleObjectArray : null;
        xmlCursorNewCursor.dispose();
        return cTOleObject;
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public CellRange<XSSFCell> removeArrayFormula(Cell cell) {
        if (cell.getSheet() != this) {
            throw new IllegalArgumentException("Specified cell does not belong to this sheet.");
        }
        for (CellRangeAddress cellRangeAddress : this.arrayFormulas) {
            if (cellRangeAddress.isInRange(cell)) {
                this.arrayFormulas.remove(cellRangeAddress);
                CellRange<XSSFCell> cellRange = getCellRange(cellRangeAddress);
                Iterator it = cellRange.iterator();
                while (it.hasNext()) {
                    ((XSSFCell) it.next()).setCellType(CellType.BLANK);
                }
                return cellRange;
            }
        }
        throw new IllegalArgumentException(AbstractC0541b.m773o("Cell ", ((XSSFCell) cell).getCTCell().getR(), " is not part of an array formula."));
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void removeColumnBreak(int i) {
        if (this.worksheet.isSetColBreaks()) {
            removeBreak(i, this.worksheet.getColBreaks());
        }
    }

    @Internal
    public void removeHyperlink(int i, int i2) {
        String asString = new CellReference(i, i2).formatAsString();
        Iterator<XSSFHyperlink> it = this.hyperlinks.iterator();
        while (it.hasNext()) {
            if (it.next().getCellRef().equals(asString)) {
                it.remove();
                return;
            }
        }
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void removeMergedRegion(int i) {
        if (this.worksheet.isSetMergeCells()) {
            CTMergeCells mergeCells = this.worksheet.getMergeCells();
            if (mergeCells.sizeOfMergeCellArray() > 1) {
                mergeCells.removeMergeCell(i);
            } else {
                this.worksheet.unsetMergeCells();
            }
        }
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void removeMergedRegions(Collection<Integer> collection) {
        if (this.worksheet.isSetMergeCells()) {
            CTMergeCells mergeCells = this.worksheet.getMergeCells();
            ArrayList arrayList = new ArrayList(mergeCells.sizeOfMergeCellArray());
            CTMergeCell[] mergeCellArray = mergeCells.getMergeCellArray();
            int length = mergeCellArray.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                CTMergeCell cTMergeCell = mergeCellArray[i];
                int i4 = i2 + 1;
                if (!collection.contains(Integer.valueOf(i2))) {
                    arrayList.add(cTMergeCell);
                }
                i++;
                i2 = i4;
            }
            if (arrayList.isEmpty()) {
                this.worksheet.unsetMergeCells();
            } else {
                mergeCells.setMergeCellArray((CTMergeCell[]) arrayList.toArray(new CTMergeCell[arrayList.size()]));
            }
        }
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void removeRow(Row row) {
        if (row.getSheet() != this) {
            throw new IllegalArgumentException("Specified row does not belong to this sheet");
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = row.iterator();
        while (it.hasNext()) {
            arrayList.add((Cell) it.next());
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            row.removeCell((XSSFCell) it2.next());
        }
        int rowNum = row.getRowNum();
        Integer num = new Integer(rowNum);
        int size = this._rows.headMap(num).size();
        this._rows.remove(num);
        this.worksheet.getSheetData().removeRow(size);
        if (this.sheetComments != null) {
            for (CellAddress cellAddress : getCellComments().keySet()) {
                if (cellAddress.getRow() == rowNum) {
                    this.sheetComments.removeComment(cellAddress);
                }
            }
        }
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void removeRowBreak(int i) {
        if (this.worksheet.isSetRowBreaks()) {
            removeBreak(i, this.worksheet.getRowBreaks());
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.POIXMLException */
    public void removeTable(XSSFTable xSSFTable) throws POIXMLException {
        long id = xSSFTable.getCTTable().getId();
        Map.Entry<String, XSSFTable> entry = null;
        for (Map.Entry<String, XSSFTable> entry2 : this.tables.entrySet()) {
            if (entry2.getValue().getCTTable().getId() == id) {
                entry = entry2;
            }
        }
        if (entry != null) {
            removeRelation(getRelationById(entry.getKey()), true);
            this.tables.remove(entry.getKey());
            entry.getValue().onTableDelete();
        }
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public Iterator<Row> rowIterator() {
        return this._rows.values().iterator();
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void setActiveCell(CellAddress cellAddress) {
        String asString = cellAddress.formatAsString();
        CTSelection sheetTypeSelection = getSheetTypeSelection();
        sheetTypeSelection.setActiveCell(asString);
        sheetTypeSelection.setSqref(Arrays.asList(asString));
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public CellRange<XSSFCell> setArrayFormula(String str, CellRangeAddress cellRangeAddress) {
        CellRange<XSSFCell> cellRange = getCellRange(cellRangeAddress);
        cellRange.getTopLeftCell().setCellArrayFormula(str, cellRangeAddress);
        this.arrayFormulas.add(cellRangeAddress);
        return cellRange;
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void setAutobreaks(boolean z) {
        CTSheetPr sheetTypeSheetPr = getSheetTypeSheetPr();
        (sheetTypeSheetPr.isSetPageSetUpPr() ? sheetTypeSheetPr.getPageSetUpPr() : sheetTypeSheetPr.addNewPageSetUpPr()).setAutoPageBreaks(z);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void setColumnBreak(int i) {
        if (isColumnBroken(i)) {
            return;
        }
        setBreak(i, this.worksheet.isSetColBreaks() ? this.worksheet.getColBreaks() : this.worksheet.addNewColBreaks(), SpreadsheetVersion.EXCEL2007.getLastRowIndex());
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void setColumnGroupCollapsed(int i, boolean z) {
        if (z) {
            collapseColumn(i);
        } else {
            expandColumn(i);
        }
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void setColumnHidden(int i, boolean z) {
        this.columnHelper.setColHidden(i, z);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void setColumnWidth(int i, int i2) {
        if (i2 > 65280) {
            throw new IllegalArgumentException("The maximum column width for an individual cell is 255 characters.");
        }
        long j = i;
        this.columnHelper.setColWidth(j, ((double) i2) / 256.0d);
        this.columnHelper.setCustomWidth(j, true);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void setDefaultColumnStyle(int i, CellStyle cellStyle) {
        this.columnHelper.setColDefaultStyle(i, cellStyle);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void setDefaultColumnWidth(int i) {
        getSheetTypeSheetFormatPr().setBaseColWidth(i);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void setDefaultRowHeight(short s) {
        setDefaultRowHeightInPoints(s / 20.0f);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void setDefaultRowHeightInPoints(float f) {
        CTSheetFormatPr sheetTypeSheetFormatPr = getSheetTypeSheetFormatPr();
        sheetTypeSheetFormatPr.setDefaultRowHeight(f);
        sheetTypeSheetFormatPr.setCustomHeight(true);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void setDisplayFormulas(boolean z) {
        getSheetTypeSheetView().setShowFormulas(z);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void setDisplayGridlines(boolean z) {
        getSheetTypeSheetView().setShowGridLines(z);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void setDisplayGuts(boolean z) {
        CTSheetPr sheetTypeSheetPr = getSheetTypeSheetPr();
        (sheetTypeSheetPr.getOutlinePr() == null ? sheetTypeSheetPr.addNewOutlinePr() : sheetTypeSheetPr.getOutlinePr()).setShowOutlineSymbols(z);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void setDisplayRowColHeadings(boolean z) {
        getSheetTypeSheetView().setShowRowColHeaders(z);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void setDisplayZeros(boolean z) {
        getSheetTypeSheetView().setShowZeros(z);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void setFitToPage(boolean z) {
        getSheetTypePageSetUpPr().setFitToPage(z);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void setForceFormulaRecalculation(boolean z) {
        CTCalcPr calcPr = getWorkbook().getCTWorkbook().getCalcPr();
        if (this.worksheet.isSetSheetCalcPr()) {
            this.worksheet.getSheetCalcPr().setFullCalcOnLoad(z);
        } else if (z) {
            this.worksheet.addNewSheetCalcPr().setFullCalcOnLoad(z);
        }
        if (z && calcPr != null && calcPr.getCalcMode() == STCalcMode.MANUAL) {
            calcPr.setCalcMode(STCalcMode.AUTO);
        }
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void setHorizontallyCenter(boolean z) {
        (this.worksheet.isSetPrintOptions() ? this.worksheet.getPrintOptions() : this.worksheet.addNewPrintOptions()).setHorizontalCentered(z);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void setMargin(short s, double d) {
        CTPageMargins pageMargins = this.worksheet.isSetPageMargins() ? this.worksheet.getPageMargins() : this.worksheet.addNewPageMargins();
        if (s == 0) {
            pageMargins.setLeft(d);
            return;
        }
        if (s == 1) {
            pageMargins.setRight(d);
            return;
        }
        if (s == 2) {
            pageMargins.setTop(d);
            return;
        }
        if (s == 3) {
            pageMargins.setBottom(d);
        } else if (s == 4) {
            pageMargins.setHeader(d);
        } else {
            if (s != 5) {
                throw new IllegalArgumentException(AbstractC0000a.m11h(s, "Unknown margin constant:  "));
            }
            pageMargins.setFooter(d);
        }
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void setPrintGridlines(boolean z) {
        (this.worksheet.isSetPrintOptions() ? this.worksheet.getPrintOptions() : this.worksheet.addNewPrintOptions()).setGridLines(z);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void setPrintRowAndColumnHeadings(boolean z) {
        (this.worksheet.isSetPrintOptions() ? this.worksheet.getPrintOptions() : this.worksheet.addNewPrintOptions()).setHeadings(z);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void setRepeatingColumns(CellRangeAddress cellRangeAddress) {
        setRepeatingRowsAndColumns(getRepeatingRows(), cellRangeAddress);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void setRepeatingRows(CellRangeAddress cellRangeAddress) {
        setRepeatingRowsAndColumns(cellRangeAddress, getRepeatingColumns());
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void setRightToLeft(boolean z) {
        getDefaultSheetView().setRightToLeft(z);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void setRowBreak(int i) {
        if (isRowBroken(i)) {
            return;
        }
        setBreak(i, this.worksheet.isSetRowBreaks() ? this.worksheet.getRowBreaks() : this.worksheet.addNewRowBreaks(), SpreadsheetVersion.EXCEL2007.getLastColumnIndex());
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void setRowGroupCollapsed(int i, boolean z) {
        if (z) {
            collapseRow(i);
        } else {
            expandRow(i);
        }
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void setRowSumsBelow(boolean z) {
        ensureOutlinePr().setSummaryBelow(z);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void setRowSumsRight(boolean z) {
        ensureOutlinePr().setSummaryRight(z);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void setSelected(boolean z) {
        for (CTSheetView cTSheetView : getSheetTypeSheetViews().getSheetViewArray()) {
            cTSheetView.setTabSelected(z);
        }
    }

    public void setSheetPassword(String str, HashAlgorithm hashAlgorithm) {
        if (str != null || isSheetProtectionEnabled()) {
            XSSFPasswordHelper.setPassword(safeGetProtectionField(), str, hashAlgorithm, (String) null);
        }
    }

    public void setTabColor(XSSFColor xSSFColor) {
        CTSheetPr sheetPr = this.worksheet.getSheetPr();
        if (sheetPr == null) {
            sheetPr = this.worksheet.addNewSheetPr();
        }
        sheetPr.setTabColor(xSSFColor.getCTColor());
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void setVerticallyCenter(boolean z) {
        (this.worksheet.isSetPrintOptions() ? this.worksheet.getPrintOptions() : this.worksheet.addNewPrintOptions()).setVerticalCentered(z);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void setZoom(int i) {
        if (i < 10 || i > 400) {
            throw new IllegalArgumentException("Valid scale values range from 10 to 400");
        }
        getSheetTypeSheetView().setZoomScale(i);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.POIXMLException */
    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void shiftRows(int i, int i2, int i4) throws POIXMLException {
        shiftRows(i, i2, i4, false, false);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void showInPane(int i, int i2) {
        getPane().setTopLeftCell(new CellReference(i, i2).formatAsString());
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void ungroupColumn(int i, int i2) {
        CTCols colsArray = this.worksheet.getColsArray(0);
        while (i <= i2) {
            CTCol column = this.columnHelper.getColumn(i, false);
            if (column != null) {
                column.setOutlineLevel((short) (column.getOutlineLevel() - 1));
                i = (int) column.getMax();
                if (column.getOutlineLevel() <= 0) {
                    this.worksheet.getColsArray(0).removeCol(this.columnHelper.getIndexOfColumn(colsArray, column));
                }
            }
            i++;
        }
        this.worksheet.setColsArray(0, colsArray);
        setSheetFormatPrOutlineLevelCol();
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void ungroupRow(int i, int i2) {
        while (i <= i2) {
            XSSFRow row = getRow(i);
            if (row != null) {
                CTRow cTRow = row.getCTRow();
                short outlineLevel = cTRow.getOutlineLevel();
                cTRow.setOutlineLevel((short) (outlineLevel - 1));
                if (outlineLevel == 1 && row.getFirstCellNum() == -1) {
                    removeRow(row);
                }
            }
            i++;
        }
        setSheetFormatPrOutlineLevelRow();
    }

    public boolean validateSheetPassword(String str) {
        return !isSheetProtectionEnabled() ? str == null : XSSFPasswordHelper.validatePassword(safeGetProtectionField(), str, (String) null);
    }

    public void write(OutputStream outputStream) {
        boolean z;
        if (this.worksheet.sizeOfColsArray() == 1) {
            CTCols colsArray = this.worksheet.getColsArray(0);
            if (colsArray.sizeOfColArray() == 0) {
                this.worksheet.setColsArray((CTCols[]) null);
                z = true;
            } else {
                setColWidthAttribute(colsArray);
                z = false;
            }
        } else {
            z = false;
        }
        if (this.hyperlinks.size() > 0) {
            if (this.worksheet.getHyperlinks() == null) {
                this.worksheet.addNewHyperlinks();
            }
            int size = this.hyperlinks.size();
            CTHyperlink[] cTHyperlinkArr = new CTHyperlink[size];
            for (int i = 0; i < size; i++) {
                XSSFHyperlink xSSFHyperlink = this.hyperlinks.get(i);
                xSSFHyperlink.generateRelationIfNeeded(getPackagePart());
                cTHyperlinkArr[i] = xSSFHyperlink.getCTHyperlink();
            }
            this.worksheet.getHyperlinks().setHyperlinkArray(cTHyperlinkArr);
        } else if (this.worksheet.getHyperlinks() != null) {
            for (int iSizeOfHyperlinkArray = this.worksheet.getHyperlinks().sizeOfHyperlinkArray() - 1; iSizeOfHyperlinkArray >= 0; iSizeOfHyperlinkArray--) {
                this.worksheet.getHyperlinks().removeHyperlink(iSizeOfHyperlinkArray);
            }
            this.worksheet.unsetHyperlinks();
        }
        int iMax = Integer.MIN_VALUE;
        int iMin = Integer.MAX_VALUE;
        for (XSSFRow xSSFRow : this._rows.values()) {
            xSSFRow.onDocumentWrite();
            if (xSSFRow.getFirstCellNum() != -1) {
                iMin = Math.min(iMin, (int) xSSFRow.getFirstCellNum());
            }
            if (xSSFRow.getLastCellNum() != -1) {
                iMax = Math.max(iMax, (int) xSSFRow.getLastCellNum());
            }
        }
        if (iMin != Integer.MAX_VALUE) {
            String asString = new CellRangeAddress(getFirstRowNum(), getLastRowNum(), iMin, iMax).formatAsString();
            if (this.worksheet.isSetDimension()) {
                this.worksheet.getDimension().setRef(asString);
            } else {
                this.worksheet.addNewDimension().setRef(asString);
            }
        }
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTWorksheet.type.getName().getNamespaceURI(), "worksheet"));
        this.worksheet.save(outputStream, xmlOptions);
        if (z) {
            this.worksheet.addNewCols();
        }
    }

    private int addMergedRegion(CellRangeAddress cellRangeAddress, boolean z) {
        if (cellRangeAddress.getNumberOfCells() < 2) {
            throw new IllegalArgumentException(AbstractC0622a.m1170p(cellRangeAddress.formatAsString(), " must contain 2 or more cells", new StringBuilder("Merged region ")));
        }
        cellRangeAddress.validate(SpreadsheetVersion.EXCEL2007);
        if (z) {
            validateArrayFormulas(cellRangeAddress);
            validateMergedRegions(cellRangeAddress);
        }
        CTMergeCells mergeCells = this.worksheet.isSetMergeCells() ? this.worksheet.getMergeCells() : this.worksheet.addNewMergeCells();
        mergeCells.addNewMergeCell().setRef(cellRangeAddress.formatAsString());
        return mergeCells.sizeOfMergeCellArray();
    }

    public void addIgnoredErrors(CellRangeAddress cellRangeAddress, IgnoredErrorType... ignoredErrorTypeArr) {
        cellRangeAddress.validate(SpreadsheetVersion.EXCEL2007);
        addIgnoredErrors(cellRangeAddress.formatAsString(), ignoredErrorTypeArr);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void autoSizeColumn(int i, boolean z) {
        double columnWidth = SheetUtil.getColumnWidth(this, i, z);
        if (columnWidth != -1.0d) {
            double d = columnWidth * 256.0d;
            double d2 = MotionEventCompat.ACTION_POINTER_INDEX_MASK;
            if (d > d2) {
                d = d2;
            }
            setColumnWidth(i, (int) d);
            this.columnHelper.setColBestFit(i, true);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.POIXMLException */
    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public XSSFDrawing createDrawingPatriarch() throws POIXMLException {
        if (getCTDrawing() != null) {
            return getDrawingPatriarch();
        }
        OPCPackage oPCPackage = getPackagePart().getPackage();
        XSSFRelation xSSFRelation = XSSFRelation.DRAWINGS;
        POIXMLDocumentPart.RelationPart relationPartCreateRelationship = createRelationship(xSSFRelation, XSSFFactory.getInstance(), getNextPartNumber(xSSFRelation, oPCPackage.getPartsByContentType(xSSFRelation.getContentType()).size() + 1), false);
        XSSFDrawing xSSFDrawing = (XSSFDrawing) relationPartCreateRelationship.getDocumentPart();
        this.worksheet.addNewDrawing().setId(relationPartCreateRelationship.getRelationship().getId());
        return xSSFDrawing;
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void createFreezePane(int i, int i2, int i4, int i5) {
        CTSheetView defaultSheetView = getDefaultSheetView();
        if (i == 0 && i2 == 0) {
            if (defaultSheetView.isSetPane()) {
                defaultSheetView.unsetPane();
            }
            defaultSheetView.setSelectionArray((CTSelection[]) null);
            return;
        }
        if (!defaultSheetView.isSetPane()) {
            defaultSheetView.addNewPane();
        }
        CTPane pane = defaultSheetView.getPane();
        if (i > 0) {
            pane.setXSplit(i);
        } else if (pane.isSetXSplit()) {
            pane.unsetXSplit();
        }
        if (i2 > 0) {
            pane.setYSplit(i2);
        } else if (pane.isSetYSplit()) {
            pane.unsetYSplit();
        }
        pane.setState(STPaneState.FROZEN);
        if (i2 == 0) {
            pane.setTopLeftCell(new CellReference(0, i4).formatAsString());
            pane.setActivePane(STPane.TOP_RIGHT);
        } else if (i == 0) {
            pane.setTopLeftCell(new CellReference(i5, 0).formatAsString());
            pane.setActivePane(STPane.BOTTOM_LEFT);
        } else {
            pane.setTopLeftCell(new CellReference(i5, i4).formatAsString());
            pane.setActivePane(STPane.BOTTOM_RIGHT);
        }
        defaultSheetView.setSelectionArray((CTSelection[]) null);
        defaultSheetView.addNewSelection().setPane(pane.getActivePane());
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public XSSFRow createRow(int i) {
        CTRow cTRowAddNewRow;
        Integer num = new Integer(i);
        XSSFRow xSSFRow = this._rows.get(num);
        if (xSSFRow != null) {
            while (xSSFRow.getFirstCellNum() != -1) {
                xSSFRow.removeCell(xSSFRow.getCell(xSSFRow.getFirstCellNum()));
            }
            cTRowAddNewRow = xSSFRow.getCTRow();
            cTRowAddNewRow.set(CTRow.Factory.newInstance());
        } else if (this._rows.isEmpty() || i > this._rows.lastKey().intValue()) {
            cTRowAddNewRow = this.worksheet.getSheetData().addNewRow();
        } else {
            cTRowAddNewRow = this.worksheet.getSheetData().insertNewRow(this._rows.headMap(num).size());
        }
        XSSFRow xSSFRow2 = new XSSFRow(cTRowAddNewRow, this);
        xSSFRow2.setRowNum(i);
        this._rows.put(num, xSSFRow2);
        return xSSFRow2;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.POIXMLException */
    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public XSSFComment getCellComment(CellAddress cellAddress) throws POIXMLException {
        if (this.sheetComments == null) {
            return null;
        }
        int row = cellAddress.getRow();
        int column = cellAddress.getColumn();
        CTComment cTComment = this.sheetComments.getCTComment(new CellAddress(row, column));
        if (cTComment == null) {
            return null;
        }
        XSSFVMLDrawing vMLDrawing = getVMLDrawing(false);
        return new XSSFComment(this.sheetComments, cTComment, vMLDrawing != null ? vMLDrawing.findCommentShape(row, column) : null);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public XSSFDrawing getDrawingPatriarch() {
        CTDrawing cTDrawing = getCTDrawing();
        if (cTDrawing == null) {
            return null;
        }
        Iterator<POIXMLDocumentPart.RelationPart> it = getRelationParts().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            POIXMLDocumentPart.RelationPart next = it.next();
            POIXMLDocumentPart documentPart = next.getDocumentPart();
            if (documentPart instanceof XSSFDrawing) {
                XSSFDrawing xSSFDrawing = (XSSFDrawing) documentPart;
                if (next.getRelationship().getId().equals(cTDrawing.getId())) {
                    return xSSFDrawing;
                }
            }
        }
        logger.log(7, AbstractC0622a.m1170p(cTDrawing.getId(), " in the list of the sheet's relationships", new StringBuilder("Can't find drawing with id=")));
        return null;
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public XSSFPrintSetup getPrintSetup() {
        return new XSSFPrintSetup(this.worksheet);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public XSSFRow getRow(int i) {
        return this._rows.get(new Integer(i));
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public XSSFSheetConditionalFormatting getSheetConditionalFormatting() {
        return new XSSFSheetConditionalFormatting(this);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public XSSFWorkbook getWorkbook() {
        return getParent();
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public XSSFAutoFilter setAutoFilter(CellRangeAddress cellRangeAddress) {
        CTAutoFilter autoFilter = this.worksheet.getAutoFilter();
        if (autoFilter == null) {
            autoFilter = this.worksheet.addNewAutoFilter();
        }
        autoFilter.setRef(new CellRangeAddress(cellRangeAddress.getFirstRow(), cellRangeAddress.getLastRow(), cellRangeAddress.getFirstColumn(), cellRangeAddress.getLastColumn()).formatAsString());
        XSSFWorkbook workbook = getWorkbook();
        int sheetIndex = getWorkbook().getSheetIndex(this);
        XSSFName builtInName = workbook.getBuiltInName("_xlnm._FilterDatabase", sheetIndex);
        if (builtInName == null) {
            builtInName = workbook.createBuiltInName("_xlnm._FilterDatabase", sheetIndex);
        }
        builtInName.getCTName().setHidden(true);
        builtInName.setRefersToFormula(new CellReference(getSheetName(), cellRangeAddress.getFirstRow(), cellRangeAddress.getFirstColumn(), true, true).formatAsString() + ":" + new CellReference((String) null, cellRangeAddress.getLastRow(), cellRangeAddress.getLastColumn(), true, true).formatAsString());
        return new XSSFAutoFilter(this);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.POIXMLException */
    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void shiftRows(int i, int i2, final int i4, boolean z, boolean z2) throws POIXMLException {
        int iShiftedRowNum;
        Iterator<Row> it;
        CTShape cTShapeFindCommentShape;
        int i5 = 0;
        XSSFVMLDrawing vMLDrawing = getVMLDrawing(false);
        Iterator<Row> itRowIterator = rowIterator();
        while (itRowIterator.hasNext()) {
            XSSFRow next = itRowIterator.next();
            int rowNum = next.getRowNum();
            if (shouldRemoveRow(i, i2, i4, rowNum)) {
                this.worksheet.getSheetData().removeRow(this._rows.headMap(new Integer(next.getRowNum())).size());
                itRowIterator.remove();
                CommentsTable commentsTable = this.sheetComments;
                if (commentsTable != null) {
                    for (CTComment cTComment : commentsTable.getCTComments().getCommentList().getCommentArray()) {
                        CellAddress cellAddress = new CellAddress(cTComment.getRef());
                        if (cellAddress.getRow() == rowNum) {
                            this.sheetComments.removeComment(cellAddress);
                            vMLDrawing.removeCommentShape(cellAddress.getRow(), cellAddress.getColumn());
                        }
                    }
                }
                if (this.hyperlinks != null) {
                    for (XSSFHyperlink xSSFHyperlink : new ArrayList(this.hyperlinks)) {
                        if (new CellReference(xSSFHyperlink.getCellRef()).getRow() == rowNum) {
                            this.hyperlinks.remove(xSSFHyperlink);
                        }
                    }
                }
            }
        }
        TreeMap treeMap = new TreeMap(new Comparator<XSSFComment>() { // from class: org.apache.poi.xssf.usermodel.XSSFSheet.1
            @Override // java.util.Comparator
            public int compare(XSSFComment xSSFComment, XSSFComment xSSFComment2) {
                int row = xSSFComment.getRow();
                int row2 = xSSFComment2.getRow();
                return row == row2 ? xSSFComment.hashCode() - xSSFComment2.hashCode() : i4 > 0 ? row < row2 ? 1 : -1 : row > row2 ? 1 : -1;
            }
        });
        Iterator<Row> itRowIterator2 = rowIterator();
        while (itRowIterator2.hasNext()) {
            XSSFRow next2 = itRowIterator2.next();
            int rowNum2 = next2.getRowNum();
            if (this.sheetComments != null && (iShiftedRowNum = shiftedRowNum(i, i2, i4, rowNum2)) != rowNum2) {
                CTComment[] commentArray = this.sheetComments.getCTComments().getCommentList().getCommentArray();
                int length = commentArray.length;
                int i6 = i5;
                while (i6 < length) {
                    CTComment cTComment2 = commentArray[i6];
                    CellReference cellReference = new CellReference(cTComment2.getRef());
                    if (cellReference.getRow() == rowNum2) {
                        CommentsTable commentsTable2 = this.sheetComments;
                        if (vMLDrawing == null) {
                            cTShapeFindCommentShape = null;
                            it = itRowIterator2;
                        } else {
                            it = itRowIterator2;
                            cTShapeFindCommentShape = vMLDrawing.findCommentShape(rowNum2, cellReference.getCol());
                        }
                        treeMap.put(new XSSFComment(commentsTable2, cTComment2, cTShapeFindCommentShape), Integer.valueOf(iShiftedRowNum));
                    } else {
                        it = itRowIterator2;
                    }
                    i6++;
                    itRowIterator2 = it;
                }
            }
            Iterator<Row> it2 = itRowIterator2;
            if (rowNum2 >= i && rowNum2 <= i2) {
                if (!z) {
                    next2.setHeight((short) -1);
                }
                next2.shift(i4);
            }
            itRowIterator2 = it2;
            i5 = 0;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            ((XSSFComment) entry.getKey()).setRow(((Integer) entry.getValue()).intValue());
        }
        XSSFRowShifter xSSFRowShifter = new XSSFRowShifter(this);
        int sheetIndex = getWorkbook().getSheetIndex(this);
        FormulaShifter formulaShifterCreateForRowShift = FormulaShifter.createForRowShift(sheetIndex, getWorkbook().getSheetName(sheetIndex), i, i2, i4, SpreadsheetVersion.EXCEL2007);
        xSSFRowShifter.updateNamedRanges(formulaShifterCreateForRowShift);
        xSSFRowShifter.updateFormulas(formulaShifterCreateForRowShift);
        xSSFRowShifter.shiftMergedRegions(i, i2, i4);
        xSSFRowShifter.updateConditionalFormatting(formulaShifterCreateForRowShift);
        xSSFRowShifter.updateHyperlinks(formulaShifterCreateForRowShift);
        HashMap map = new HashMap();
        for (XSSFRow xSSFRow : this._rows.values()) {
            map.put(new Integer(xSSFRow.getRowNum()), xSSFRow);
        }
        this._rows.clear();
        this._rows.putAll(map);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public XSSFHyperlink getHyperlink(int i, int i2) {
        return getHyperlink(new CellAddress(i, i2));
    }

    private void addIgnoredErrors(String str, IgnoredErrorType... ignoredErrorTypeArr) {
        XSSFIgnoredErrorHelper.addIgnoredErrors((this.worksheet.isSetIgnoredErrors() ? this.worksheet.getIgnoredErrors() : this.worksheet.addNewIgnoredErrors()).addNewIgnoredError(), str, ignoredErrorTypeArr);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public XSSFHyperlink getHyperlink(CellAddress cellAddress) {
        String asString = cellAddress.formatAsString();
        for (XSSFHyperlink xSSFHyperlink : this.hyperlinks) {
            if (xSSFHyperlink.getCellRef().equals(asString)) {
                return xSSFHyperlink;
            }
        }
        return null;
    }

    public XSSFSheet(PackagePart packagePart) {
        super(packagePart);
        this._rows = new TreeMap();
        this.dataValidationHelper = new XSSFDataValidationHelper(this);
    }

    @Override // org.apache.poi.p227ss.usermodel.Sheet
    public void validateMergedRegions() {
        checkForMergedRegionsIntersectingArrayFormulas();
        checkForIntersectingMergedRegions();
    }

    public XSSFPivotTable createPivotTable(final AreaReference areaReference, CellReference cellReference, Sheet sheet) {
        String sheetName = areaReference.getFirstCell().getSheetName();
        if (sheetName != null && !sheetName.equalsIgnoreCase(sheet.getSheetName())) {
            throw new IllegalArgumentException("The area is referenced in another sheet than the defined source sheet " + sheet.getSheetName() + Extension.DOT);
        }
        return createPivotTable(cellReference, sheet, new XSSFPivotTable.PivotTableReferenceConfigurator() { // from class: org.apache.poi.xssf.usermodel.XSSFSheet.2
            @Override // org.apache.poi.xssf.usermodel.XSSFPivotTable.PivotTableReferenceConfigurator
            public void configureReference(CTWorksheetSource cTWorksheetSource) {
                String[] cellRefParts = areaReference.getFirstCell().getCellRefParts();
                String str = cellRefParts[1];
                String str2 = cellRefParts[2];
                String[] cellRefParts2 = areaReference.getLastCell().getCellRefParts();
                String str3 = cellRefParts2[1];
                cTWorksheetSource.setRef(str2 + str + ':' + cellRefParts2[2] + str3);
            }
        });
    }

    private XSSFPivotTable createPivotTable(CellReference cellReference, Sheet sheet, XSSFPivotTable.PivotTableReferenceConfigurator pivotTableReferenceConfigurator) {
        XSSFPivotTable xSSFPivotTableCreatePivotTable = createPivotTable();
        xSSFPivotTableCreatePivotTable.setDefaultPivotTableDefinition();
        xSSFPivotTableCreatePivotTable.createSourceReferences(cellReference, sheet, pivotTableReferenceConfigurator);
        xSSFPivotTableCreatePivotTable.getPivotCacheDefinition().createCacheFields(sheet);
        xSSFPivotTableCreatePivotTable.createDefaultDataColumns();
        return xSSFPivotTableCreatePivotTable;
    }

    public XSSFPivotTable createPivotTable(AreaReference areaReference, CellReference cellReference) {
        String sheetName = areaReference.getFirstCell().getSheetName();
        if (sheetName != null && !sheetName.equalsIgnoreCase(getSheetName())) {
            return createPivotTable(areaReference, cellReference, getWorkbook().getSheet(sheetName));
        }
        return createPivotTable(areaReference, cellReference, this);
    }

    public XSSFPivotTable createPivotTable(final Name name, CellReference cellReference, Sheet sheet) {
        if (name.getSheetName() != null && !name.getSheetName().equals(sheet.getSheetName())) {
            throw new IllegalArgumentException("The named range references another sheet than the defined source sheet " + sheet.getSheetName() + Extension.DOT);
        }
        return createPivotTable(cellReference, sheet, new XSSFPivotTable.PivotTableReferenceConfigurator() { // from class: org.apache.poi.xssf.usermodel.XSSFSheet.3
            @Override // org.apache.poi.xssf.usermodel.XSSFPivotTable.PivotTableReferenceConfigurator
            public void configureReference(CTWorksheetSource cTWorksheetSource) {
                cTWorksheetSource.setName(name.getNameName());
            }
        });
    }

    public XSSFPivotTable createPivotTable(Name name, CellReference cellReference) {
        return createPivotTable(name, cellReference, getWorkbook().getSheet(name.getSheetName()));
    }

    public XSSFPivotTable createPivotTable(final Table table, CellReference cellReference) {
        return createPivotTable(cellReference, getWorkbook().getSheet(table.getSheetName()), new XSSFPivotTable.PivotTableReferenceConfigurator() { // from class: org.apache.poi.xssf.usermodel.XSSFSheet.4
            @Override // org.apache.poi.xssf.usermodel.XSSFPivotTable.PivotTableReferenceConfigurator
            public void configureReference(CTWorksheetSource cTWorksheetSource) {
                cTWorksheetSource.setName(table.getName());
            }
        });
    }

    public void copyRows(int i, int i2, int i4, CellCopyPolicy cellCopyPolicy) {
        copyRows(getRows(i, i2, false), i4, cellCopyPolicy);
    }
}
