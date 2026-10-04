package org.apache.poi.xssf.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CalcChainDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class CalculationChain extends POIXMLDocumentPart {
    private CTCalcChain chain;

    public CalculationChain() {
        this.chain = CTCalcChain.Factory.newInstance();
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    public void commit() throws IOException {
        OutputStream outputStream = getPackagePart().getOutputStream();
        writeTo(outputStream);
        outputStream.close();
    }

    public CTCalcChain getCTCalcChain() {
        return this.chain;
    }

    public void readFrom(InputStream inputStream) throws IOException {
        try {
            this.chain = CalcChainDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getCalcChain();
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    public void removeItem(int i, String str) {
        CTCalcCell[] cArray = this.chain.getCArray();
        int i2 = -1;
        for (int i4 = 0; i4 < cArray.length; i4++) {
            if (cArray[i4].isSetI()) {
                i2 = cArray[i4].getI();
            }
            if (i2 == i && cArray[i4].getR().equals(str)) {
                if (cArray[i4].isSetI() && i4 < cArray.length - 1) {
                    int i5 = i4 + 1;
                    if (!cArray[i5].isSetI()) {
                        cArray[i5].setI(i2);
                    }
                }
                this.chain.removeC(i4);
                return;
            }
        }
    }

    public void writeTo(OutputStream outputStream) {
        CalcChainDocument calcChainDocumentNewInstance = CalcChainDocument.Factory.newInstance();
        calcChainDocumentNewInstance.setCalcChain(this.chain);
        calcChainDocumentNewInstance.save(outputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
    }

    public CalculationChain(PackagePart packagePart) throws IOException {
        super(packagePart);
        readFrom(packagePart.getInputStream());
    }
}
