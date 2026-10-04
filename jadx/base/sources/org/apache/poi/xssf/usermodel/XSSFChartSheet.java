package org.apache.poi.xssf.usermodel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.poi.POIXMLException;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDrawing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTLegacyDrawing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ChartsheetDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XSSFChartSheet extends XSSFSheet {
    private static final byte[] BLANK_WORKSHEET = blankWorksheet();
    protected CTChartsheet chartsheet;

    public XSSFChartSheet(PackagePart packagePart) {
        super(packagePart);
    }

    private static byte[] blankWorksheet() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new XSSFSheet().write(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public CTChartsheet getCTChartsheet() {
        return this.chartsheet;
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFSheet
    public CTDrawing getCTDrawing() {
        return this.chartsheet.getDrawing();
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFSheet
    public CTLegacyDrawing getCTLegacyDrawing() {
        return this.chartsheet.getLegacyDrawing();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.POIXMLException */
    @Override // org.apache.poi.xssf.usermodel.XSSFSheet
    public void read(InputStream inputStream) throws POIXMLException {
        super.read(new ByteArrayInputStream(BLANK_WORKSHEET));
        try {
            this.chartsheet = ChartsheetDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getChartsheet();
        } catch (XmlException e) {
            throw new POIXMLException(e);
        }
    }

    @Override // org.apache.poi.xssf.usermodel.XSSFSheet
    public void write(OutputStream outputStream) {
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTChartsheet.type.getName().getNamespaceURI(), "chartsheet"));
        this.chartsheet.save(outputStream, xmlOptions);
    }
}
