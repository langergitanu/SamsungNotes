package org.apache.poi.xwpf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFootnotes;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdn;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.FootnotesDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XWPFFootnotes extends POIXMLDocumentPart {
    private CTFootnotes ctFootnotes;
    protected XWPFDocument document;
    private List<XWPFFootnote> listFootnote;

    public XWPFFootnotes(PackagePart packagePart) {
        super(packagePart);
        this.listFootnote = new ArrayList();
    }

    public void addFootnote(XWPFFootnote xWPFFootnote) {
        this.listFootnote.add(xWPFFootnote);
        this.ctFootnotes.addNewFootnote().set(xWPFFootnote.getCTFtnEdn());
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    public void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTFootnotes.type.getName().getNamespaceURI(), "footnotes"));
        OutputStream outputStream = getPackagePart().getOutputStream();
        this.ctFootnotes.save(outputStream, xmlOptions);
        outputStream.close();
    }

    public XWPFFootnote getFootnoteById(int i) {
        for (XWPFFootnote xWPFFootnote : this.listFootnote) {
            if (xWPFFootnote.getCTFtnEdn().getId().intValue() == i) {
                return xWPFFootnote;
            }
        }
        return null;
    }

    public List<XWPFFootnote> getFootnotesList() {
        return this.listFootnote;
    }

    public XWPFDocument getXWPFDocument() {
        XWPFDocument xWPFDocument = this.document;
        return xWPFDocument != null ? xWPFDocument : (XWPFDocument) getParent();
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    public void onDocumentRead() {
        InputStream inputStream = null;
        try {
            try {
                inputStream = getPackagePart().getInputStream();
                this.ctFootnotes = FootnotesDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getFootnotes();
                for (CTFtnEdn cTFtnEdn : this.ctFootnotes.getFootnoteArray()) {
                    this.listFootnote.add(new XWPFFootnote(cTFtnEdn, this));
                }
            } catch (XmlException unused) {
                throw new POIXMLException();
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public void setFootnotes(CTFootnotes cTFootnotes) {
        this.ctFootnotes = cTFootnotes;
    }

    public void setXWPFDocument(XWPFDocument xWPFDocument) {
        this.document = xWPFDocument;
    }

    public XWPFFootnotes() {
        this.listFootnote = new ArrayList();
    }

    public XWPFFootnote addFootnote(CTFtnEdn cTFtnEdn) {
        CTFtnEdn cTFtnEdnAddNewFootnote = this.ctFootnotes.addNewFootnote();
        cTFtnEdnAddNewFootnote.set(cTFtnEdn);
        XWPFFootnote xWPFFootnote = new XWPFFootnote(cTFtnEdnAddNewFootnote, this);
        this.listFootnote.add(xWPFFootnote);
        return xWPFFootnote;
    }
}
