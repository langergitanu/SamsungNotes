package org.apache.poi.xssf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCache;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XSSFPivotCache extends POIXMLDocumentPart {
    private CTPivotCache ctPivotCache;

    public XSSFPivotCache() {
        this.ctPivotCache = CTPivotCache.Factory.newInstance();
    }

    public CTPivotCache getCTPivotCache() {
        return this.ctPivotCache;
    }

    public void readFrom(InputStream inputStream) throws IOException {
        try {
            XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
            xmlOptions.setLoadReplaceDocumentElement(null);
            this.ctPivotCache = CTPivotCache.Factory.parse(inputStream, xmlOptions);
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    public XSSFPivotCache(CTPivotCache cTPivotCache) {
        this.ctPivotCache = cTPivotCache;
    }

    public XSSFPivotCache(PackagePart packagePart) throws IOException {
        super(packagePart);
        readFrom(packagePart.getInputStream());
    }
}
