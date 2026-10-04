package org.apache.poi.xssf.usermodel;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.p227ss.usermodel.Sheet;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheField;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheFields;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheetSource;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XSSFPivotCacheDefinition extends POIXMLDocumentPart {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private CTPivotCacheDefinition ctPivotCacheDefinition;

    public XSSFPivotCacheDefinition() {
        this.ctPivotCacheDefinition = CTPivotCacheDefinition.Factory.newInstance();
        createDefaultValues();
    }

    private void createDefaultValues() {
        this.ctPivotCacheDefinition.setCreatedVersion((short) 3);
        this.ctPivotCacheDefinition.setMinRefreshableVersion((short) 3);
        this.ctPivotCacheDefinition.setRefreshedVersion((short) 3);
        this.ctPivotCacheDefinition.setRefreshedBy(POIXMLDocument.DOCUMENT_CREATOR);
        this.ctPivotCacheDefinition.setRefreshedDate(new Date().getTime());
        this.ctPivotCacheDefinition.setRefreshOnLoad(true);
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    public void commit() throws IOException {
        OutputStream outputStream = getPackagePart().getOutputStream();
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTPivotCacheDefinition.type.getName().getNamespaceURI(), "pivotCacheDefinition"));
        this.ctPivotCacheDefinition.save(outputStream, xmlOptions);
        outputStream.close();
    }

    public void createCacheFields(Sheet sheet) {
        AreaReference pivotArea = getPivotArea(sheet.getWorkbook());
        CellReference firstCell = pivotArea.getFirstCell();
        CellReference lastCell = pivotArea.getLastCell();
        short col = lastCell.getCol();
        Row row = sheet.getRow(firstCell.getRow());
        CTCacheFields cacheFields = this.ctPivotCacheDefinition.getCacheFields() != null ? this.ctPivotCacheDefinition.getCacheFields() : this.ctPivotCacheDefinition.addNewCacheFields();
        for (int col2 = firstCell.getCol(); col2 <= col; col2++) {
            CTCacheField cTCacheFieldAddNewCacheField = cacheFields.addNewCacheField();
            if (col2 == col) {
                cacheFields.setCount(cacheFields.sizeOfCacheFieldArray());
            }
            cTCacheFieldAddNewCacheField.setNumFmtId(0L);
            row.getCell(col2).setCellType(CellType.STRING);
            cTCacheFieldAddNewCacheField.setName(row.getCell(col2).getStringCellValue());
            cTCacheFieldAddNewCacheField.addNewSharedItems();
        }
    }

    @Internal
    public CTPivotCacheDefinition getCTPivotCacheDefinition() {
        return this.ctPivotCacheDefinition;
    }

    public AreaReference getPivotArea(Workbook workbook) {
        CTWorksheetSource worksheetSource = this.ctPivotCacheDefinition.getCacheSource().getWorksheetSource();
        String ref = worksheetSource.getRef();
        String name = worksheetSource.getName();
        if (ref == null && name == null) {
            throw new IllegalArgumentException("Pivot cache must reference an area, named range, or table.");
        }
        if (ref != null) {
            return new AreaReference(ref, SpreadsheetVersion.EXCEL2007);
        }
        Name name2 = workbook.getName(name);
        if (name2 != null) {
            return new AreaReference(name2.getRefersToFormula(), SpreadsheetVersion.EXCEL2007);
        }
        for (XSSFTable xSSFTable : ((XSSFSheet) workbook.getSheet(worksheetSource.getSheet())).getTables()) {
            if (name.equals(xSSFTable.getName())) {
                return new AreaReference(xSSFTable.getStartCellReference(), xSSFTable.getEndCellReference(), SpreadsheetVersion.EXCEL2007);
            }
        }
        throw new IllegalArgumentException(AbstractC0541b.m773o("Name '", name, "' was not found."));
    }

    public void readFrom(InputStream inputStream) throws IOException {
        try {
            XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
            xmlOptions.setLoadReplaceDocumentElement(null);
            this.ctPivotCacheDefinition = CTPivotCacheDefinition.Factory.parse(inputStream, xmlOptions);
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage(), e);
        }
    }

    public XSSFPivotCacheDefinition(PackagePart packagePart) throws IOException {
        super(packagePart);
        readFrom(packagePart.getInputStream());
    }
}
