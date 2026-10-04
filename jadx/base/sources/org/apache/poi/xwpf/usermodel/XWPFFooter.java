package org.apache.poi.xwpf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.FtrDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XWPFFooter extends XWPFHeaderFooter {
    public XWPFFooter() {
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    public void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTNumbering.type.getName().getNamespaceURI(), "ftr"));
        OutputStream outputStream = getPackagePart().getOutputStream();
        super._getHdrFtr().save(outputStream, xmlOptions);
        outputStream.close();
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public BodyType getPartType() {
        return BodyType.FOOTER;
    }

    @Override // org.apache.poi.xwpf.usermodel.XWPFHeaderFooter, org.apache.poi.POIXMLDocumentPart
    public void onDocumentRead() {
        super.onDocumentRead();
        InputStream inputStream = null;
        try {
            try {
                inputStream = getPackagePart().getInputStream();
                CTHdrFtr ftr = FtrDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getFtr();
                this.headerFooter = ftr;
                XmlCursor xmlCursorNewCursor = ftr.newCursor();
                xmlCursorNewCursor.selectPath("./*");
                while (xmlCursorNewCursor.toNextSelection()) {
                    XmlObject object = xmlCursorNewCursor.getObject();
                    if (object instanceof CTP) {
                        XWPFParagraph xWPFParagraph = new XWPFParagraph((CTP) object, this);
                        this.paragraphs.add(xWPFParagraph);
                        this.bodyElements.add(xWPFParagraph);
                    }
                    if (object instanceof CTTbl) {
                        XWPFTable xWPFTable = new XWPFTable((CTTbl) object, this);
                        this.tables.add(xWPFTable);
                        this.bodyElements.add(xWPFTable);
                    }
                    if (object instanceof CTSdtBlock) {
                        this.bodyElements.add(new XWPFSDT((CTSdtBlock) object, this));
                    }
                }
                xmlCursorNewCursor.dispose();
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e) {
                throw new POIXMLException(e);
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    public XWPFFooter(XWPFDocument xWPFDocument, CTHdrFtr cTHdrFtr) {
        super(xWPFDocument, cTHdrFtr);
        XmlCursor xmlCursorNewCursor = this.headerFooter.newCursor();
        xmlCursorNewCursor.selectPath("./*");
        while (xmlCursorNewCursor.toNextSelection()) {
            XmlObject object = xmlCursorNewCursor.getObject();
            if (object instanceof CTP) {
                XWPFParagraph xWPFParagraph = new XWPFParagraph((CTP) object, this);
                this.paragraphs.add(xWPFParagraph);
                this.bodyElements.add(xWPFParagraph);
            }
            if (object instanceof CTTbl) {
                XWPFTable xWPFTable = new XWPFTable((CTTbl) object, this);
                this.tables.add(xWPFTable);
                this.bodyElements.add(xWPFTable);
            }
        }
        xmlCursorNewCursor.dispose();
    }

    public XWPFFooter(POIXMLDocumentPart pOIXMLDocumentPart, PackagePart packagePart) {
        super(pOIXMLDocumentPart, packagePart);
    }
}
