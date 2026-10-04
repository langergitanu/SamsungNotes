package org.apache.poi.xssf.usermodel;

import androidx.compose.foundation.layout.AbstractC1038a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.p227ss.usermodel.Sheet;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataConsolidateFunction;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheSource;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColFields;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataField;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataFields;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTField;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTLocation;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageField;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotField;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotFields;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotTableDefinition;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotTableStyle;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRowFields;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheetSource;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STAxis;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDataConsolidateFunction;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STItemType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSourceType;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XSSFPivotTable extends POIXMLDocumentPart {
    protected static final short CREATED_VERSION = 3;
    protected static final short MIN_REFRESHABLE_VERSION = 3;
    protected static final short UPDATED_VERSION = 3;
    private Sheet dataSheet;
    private Sheet parentSheet;
    private XSSFPivotCache pivotCache;
    private XSSFPivotCacheDefinition pivotCacheDefinition;
    private XSSFPivotCacheRecords pivotCacheRecords;
    private CTPivotTableDefinition pivotTableDefinition;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface PivotTableReferenceConfigurator {
        void configureReference(CTWorksheetSource cTWorksheetSource);
    }

    public XSSFPivotTable() {
        this.pivotTableDefinition = CTPivotTableDefinition.Factory.newInstance();
        this.pivotCache = new XSSFPivotCache();
        this.pivotCacheDefinition = new XSSFPivotCacheDefinition();
        this.pivotCacheRecords = new XSSFPivotCacheRecords();
    }

    private void addDataField(DataConsolidateFunction dataConsolidateFunction, int i, String str) {
        checkColumnIndex(i);
        AreaReference pivotArea = getPivotArea();
        CTDataFields dataFields = this.pivotTableDefinition.getDataFields() != null ? this.pivotTableDefinition.getDataFields() : this.pivotTableDefinition.addNewDataFields();
        CTDataField cTDataFieldAddNewDataField = dataFields.addNewDataField();
        cTDataFieldAddNewDataField.setSubtotal(STDataConsolidateFunction.Enum.forInt(dataConsolidateFunction.getValue()));
        getDataSheet().getRow(pivotArea.getFirstCell().getRow()).getCell(pivotArea.getFirstCell().getCol() + i).setCellType(CellType.STRING);
        cTDataFieldAddNewDataField.setName(str);
        cTDataFieldAddNewDataField.setFld(i);
        dataFields.setCount(dataFields.sizeOfDataFieldArray());
    }

    private void checkColumnIndex(int i) {
        AreaReference pivotArea = getPivotArea();
        int col = (pivotArea.getLastCell().getCol() - pivotArea.getFirstCell().getCol()) + 1;
        if (i < 0 || i >= col) {
            throw new IndexOutOfBoundsException(AbstractC1038a.m1214o(i, col, "Column Index: ", ", Size: "));
        }
    }

    private void setDataSheet(Sheet sheet) {
        this.dataSheet = sheet;
    }

    public void addColumnLabel(DataConsolidateFunction dataConsolidateFunction, int i, String str) {
        checkColumnIndex(i);
        addDataColumn(i, true);
        addDataField(dataConsolidateFunction, i, str);
        if (this.pivotTableDefinition.getDataFields().getCount() == 2) {
            CTColFields colFields = this.pivotTableDefinition.getColFields() != null ? this.pivotTableDefinition.getColFields() : this.pivotTableDefinition.addNewColFields();
            colFields.addNewField().setX(-2);
            colFields.setCount(colFields.sizeOfFieldArray());
        }
    }

    public void addDataColumn(int i, boolean z) {
        checkColumnIndex(i);
        CTPivotFields pivotFields = this.pivotTableDefinition.getPivotFields();
        CTPivotField cTPivotFieldNewInstance = CTPivotField.Factory.newInstance();
        cTPivotFieldNewInstance.setDataField(z);
        cTPivotFieldNewInstance.setShowAll(false);
        pivotFields.setPivotFieldArray(i, cTPivotFieldNewInstance);
    }

    public void addReportFilter(int i) {
        CTPageFields cTPageFieldsAddNewPageFields;
        checkColumnIndex(i);
        AreaReference pivotArea = getPivotArea();
        int row = pivotArea.getLastCell().getRow() - pivotArea.getFirstCell().getRow();
        CTPivotFields pivotFields = this.pivotTableDefinition.getPivotFields();
        CTPivotField cTPivotFieldNewInstance = CTPivotField.Factory.newInstance();
        CTItems cTItemsAddNewItems = cTPivotFieldNewInstance.addNewItems();
        cTPivotFieldNewInstance.setAxis(STAxis.AXIS_PAGE);
        cTPivotFieldNewInstance.setShowAll(false);
        for (int i2 = 0; i2 <= row; i2++) {
            cTItemsAddNewItems.addNewItem().setT(STItemType.DEFAULT);
        }
        cTItemsAddNewItems.setCount(cTItemsAddNewItems.sizeOfItemArray());
        pivotFields.setPivotFieldArray(i, cTPivotFieldNewInstance);
        if (this.pivotTableDefinition.getPageFields() != null) {
            cTPageFieldsAddNewPageFields = this.pivotTableDefinition.getPageFields();
            this.pivotTableDefinition.setMultipleFieldFilters(true);
        } else {
            cTPageFieldsAddNewPageFields = this.pivotTableDefinition.addNewPageFields();
        }
        CTPageField cTPageFieldAddNewPageField = cTPageFieldsAddNewPageFields.addNewPageField();
        cTPageFieldAddNewPageField.setHier(-1);
        cTPageFieldAddNewPageField.setFld(i);
        cTPageFieldsAddNewPageFields.setCount(cTPageFieldsAddNewPageFields.sizeOfPageFieldArray());
        this.pivotTableDefinition.getLocation().setColPageCount(cTPageFieldsAddNewPageFields.getCount());
    }

    public void addRowLabel(int i) {
        checkColumnIndex(i);
        AreaReference pivotArea = getPivotArea();
        int row = pivotArea.getLastCell().getRow() - pivotArea.getFirstCell().getRow();
        CTPivotFields pivotFields = this.pivotTableDefinition.getPivotFields();
        CTPivotField cTPivotFieldNewInstance = CTPivotField.Factory.newInstance();
        CTItems cTItemsAddNewItems = cTPivotFieldNewInstance.addNewItems();
        cTPivotFieldNewInstance.setAxis(STAxis.AXIS_ROW);
        cTPivotFieldNewInstance.setShowAll(false);
        for (int i2 = 0; i2 <= row; i2++) {
            cTItemsAddNewItems.addNewItem().setT(STItemType.DEFAULT);
        }
        cTItemsAddNewItems.setCount(cTItemsAddNewItems.sizeOfItemArray());
        pivotFields.setPivotFieldArray(i, cTPivotFieldNewInstance);
        CTRowFields rowFields = this.pivotTableDefinition.getRowFields() != null ? this.pivotTableDefinition.getRowFields() : this.pivotTableDefinition.addNewRowFields();
        rowFields.addNewField().setX(i);
        rowFields.setCount(rowFields.sizeOfFieldArray());
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    public void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTPivotTableDefinition.type.getName().getNamespaceURI(), "pivotTableDefinition"));
        OutputStream outputStream = getPackagePart().getOutputStream();
        this.pivotTableDefinition.save(outputStream, xmlOptions);
        outputStream.close();
    }

    public void createDefaultDataColumns() {
        CTPivotFields pivotFields = this.pivotTableDefinition.getPivotFields() != null ? this.pivotTableDefinition.getPivotFields() : this.pivotTableDefinition.addNewPivotFields();
        AreaReference pivotArea = getPivotArea();
        short col = pivotArea.getLastCell().getCol();
        for (int col2 = pivotArea.getFirstCell().getCol(); col2 <= col; col2++) {
            CTPivotField cTPivotFieldAddNewPivotField = pivotFields.addNewPivotField();
            cTPivotFieldAddNewPivotField.setDataField(false);
            cTPivotFieldAddNewPivotField.setShowAll(false);
        }
        pivotFields.setCount(pivotFields.sizeOfPivotFieldArray());
    }

    public void createSourceReferences(CellReference cellReference, Sheet sheet, PivotTableReferenceConfigurator pivotTableReferenceConfigurator) {
        CTLocation location;
        AreaReference areaReference = new AreaReference(cellReference, new CellReference(cellReference.getRow() + 1, cellReference.getCol() + 1), SpreadsheetVersion.EXCEL2007);
        if (this.pivotTableDefinition.getLocation() == null) {
            location = this.pivotTableDefinition.addNewLocation();
            location.setFirstDataCol(1L);
            location.setFirstDataRow(1L);
            location.setFirstHeaderRow(1L);
        } else {
            location = this.pivotTableDefinition.getLocation();
        }
        location.setRef(areaReference.formatAsString());
        this.pivotTableDefinition.setLocation(location);
        CTCacheSource cTCacheSourceAddNewCacheSource = getPivotCacheDefinition().getCTPivotCacheDefinition().addNewCacheSource();
        cTCacheSourceAddNewCacheSource.setType(STSourceType.WORKSHEET);
        CTWorksheetSource cTWorksheetSourceAddNewWorksheetSource = cTCacheSourceAddNewCacheSource.addNewWorksheetSource();
        cTWorksheetSourceAddNewWorksheetSource.setSheet(sheet.getSheetName());
        setDataSheet(sheet);
        pivotTableReferenceConfigurator.configureReference(cTWorksheetSourceAddNewWorksheetSource);
        if (cTWorksheetSourceAddNewWorksheetSource.getName() == null && cTWorksheetSourceAddNewWorksheetSource.getRef() == null) {
            throw new IllegalArgumentException("Pivot table source area reference or name must be specified.");
        }
    }

    @Internal
    public CTPivotTableDefinition getCTPivotTableDefinition() {
        return this.pivotTableDefinition;
    }

    public Sheet getDataSheet() {
        return this.dataSheet;
    }

    public Sheet getParentSheet() {
        return this.parentSheet;
    }

    public AreaReference getPivotArea() {
        return getPivotCacheDefinition().getPivotArea(getDataSheet().getWorkbook());
    }

    public XSSFPivotCache getPivotCache() {
        return this.pivotCache;
    }

    public XSSFPivotCacheDefinition getPivotCacheDefinition() {
        return this.pivotCacheDefinition;
    }

    public XSSFPivotCacheRecords getPivotCacheRecords() {
        return this.pivotCacheRecords;
    }

    public List<Integer> getRowLabelColumns() {
        if (this.pivotTableDefinition.getRowFields() == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        CTField[] fieldArray = this.pivotTableDefinition.getRowFields().getFieldArray();
        int length = fieldArray.length;
        for (int iM1200a = 0; iM1200a < length; iM1200a = AbstractC1038a.m1200a(fieldArray[iM1200a].getX(), iM1200a, 1, arrayList)) {
        }
        return arrayList;
    }

    public void readFrom(InputStream inputStream) throws IOException {
        try {
            XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
            xmlOptions.setLoadReplaceDocumentElement(null);
            this.pivotTableDefinition = CTPivotTableDefinition.Factory.parse(inputStream, xmlOptions);
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    @Internal
    public void setCTPivotTableDefinition(CTPivotTableDefinition cTPivotTableDefinition) {
        this.pivotTableDefinition = cTPivotTableDefinition;
    }

    public void setDefaultPivotTableDefinition() {
        this.pivotTableDefinition.setMultipleFieldFilters(false);
        this.pivotTableDefinition.setIndent(0L);
        this.pivotTableDefinition.setCreatedVersion((short) 3);
        this.pivotTableDefinition.setMinRefreshableVersion((short) 3);
        this.pivotTableDefinition.setUpdatedVersion((short) 3);
        this.pivotTableDefinition.setItemPrintTitles(true);
        this.pivotTableDefinition.setUseAutoFormatting(true);
        this.pivotTableDefinition.setApplyNumberFormats(false);
        this.pivotTableDefinition.setApplyWidthHeightFormats(true);
        this.pivotTableDefinition.setApplyAlignmentFormats(false);
        this.pivotTableDefinition.setApplyPatternFormats(false);
        this.pivotTableDefinition.setApplyFontFormats(false);
        this.pivotTableDefinition.setApplyBorderFormats(false);
        this.pivotTableDefinition.setCacheId(this.pivotCache.getCTPivotCache().getCacheId());
        this.pivotTableDefinition.setName("PivotTable" + this.pivotTableDefinition.getCacheId());
        this.pivotTableDefinition.setDataCaption("Values");
        CTPivotTableStyle cTPivotTableStyleAddNewPivotTableStyleInfo = this.pivotTableDefinition.addNewPivotTableStyleInfo();
        cTPivotTableStyleAddNewPivotTableStyleInfo.setName("PivotStyleLight16");
        cTPivotTableStyleAddNewPivotTableStyleInfo.setShowLastColumn(true);
        cTPivotTableStyleAddNewPivotTableStyleInfo.setShowColStripes(false);
        cTPivotTableStyleAddNewPivotTableStyleInfo.setShowRowStripes(false);
        cTPivotTableStyleAddNewPivotTableStyleInfo.setShowColHeaders(true);
        cTPivotTableStyleAddNewPivotTableStyleInfo.setShowRowHeaders(true);
    }

    public void setParentSheet(XSSFSheet xSSFSheet) {
        this.parentSheet = xSSFSheet;
    }

    public void setPivotCache(XSSFPivotCache xSSFPivotCache) {
        this.pivotCache = xSSFPivotCache;
    }

    public void setPivotCacheDefinition(XSSFPivotCacheDefinition xSSFPivotCacheDefinition) {
        this.pivotCacheDefinition = xSSFPivotCacheDefinition;
    }

    public void setPivotCacheRecords(XSSFPivotCacheRecords xSSFPivotCacheRecords) {
        this.pivotCacheRecords = xSSFPivotCacheRecords;
    }

    public XSSFPivotTable(PackagePart packagePart) throws IOException {
        super(packagePart);
        readFrom(packagePart.getInputStream());
    }

    public void addColumnLabel(DataConsolidateFunction dataConsolidateFunction, int i) {
        addColumnLabel(dataConsolidateFunction, i, dataConsolidateFunction.getName());
    }
}
