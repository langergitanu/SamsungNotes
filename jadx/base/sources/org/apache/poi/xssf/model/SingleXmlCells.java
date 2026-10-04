package org.apache.poi.xssf.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Vector;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.helpers.XSSFSingleXmlCell;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCells;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.SingleXmlCellsDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SingleXmlCells extends POIXMLDocumentPart {
    private CTSingleXmlCells singleXMLCells;

    public SingleXmlCells() {
        this.singleXMLCells = CTSingleXmlCells.Factory.newInstance();
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    public void commit() throws IOException {
        OutputStream outputStream = getPackagePart().getOutputStream();
        writeTo(outputStream);
        outputStream.close();
    }

    public List<XSSFSingleXmlCell> getAllSimpleXmlCell() {
        Vector vector = new Vector();
        for (CTSingleXmlCell cTSingleXmlCell : this.singleXMLCells.getSingleXmlCellArray()) {
            vector.add(new XSSFSingleXmlCell(cTSingleXmlCell, this));
        }
        return vector;
    }

    public CTSingleXmlCells getCTSingleXMLCells() {
        return this.singleXMLCells;
    }

    public XSSFSheet getXSSFSheet() {
        return (XSSFSheet) getParent();
    }

    public void readFrom(InputStream inputStream) throws IOException {
        try {
            this.singleXMLCells = SingleXmlCellsDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getSingleXmlCells();
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    public void writeTo(OutputStream outputStream) {
        SingleXmlCellsDocument singleXmlCellsDocumentNewInstance = SingleXmlCellsDocument.Factory.newInstance();
        singleXmlCellsDocumentNewInstance.setSingleXmlCells(this.singleXMLCells);
        singleXmlCellsDocumentNewInstance.save(outputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
    }

    public SingleXmlCells(PackagePart packagePart) throws IOException {
        super(packagePart);
        readFrom(packagePart.getInputStream());
    }
}
