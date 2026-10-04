package org.apache.poi.xwpf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.POIXMLRelation;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class XWPFHeaderFooter extends POIXMLDocumentPart implements IBody {
    List<IBodyElement> bodyElements;
    XWPFDocument document;
    CTHdrFtr headerFooter;
    List<XWPFParagraph> paragraphs;
    List<XWPFPictureData> pictures;
    List<XWPFTable> tables;

    public XWPFHeaderFooter(XWPFDocument xWPFDocument, CTHdrFtr cTHdrFtr) {
        this.paragraphs = new ArrayList();
        this.tables = new ArrayList();
        this.pictures = new ArrayList();
        this.bodyElements = new ArrayList();
        xWPFDocument.getClass();
        this.document = xWPFDocument;
        this.headerFooter = cTHdrFtr;
        readHdrFtr();
    }

    private boolean isCursorInHdrF(XmlCursor xmlCursor) {
        XmlCursor xmlCursorNewCursor = xmlCursor.newCursor();
        xmlCursorNewCursor.toParent();
        boolean z = xmlCursorNewCursor.getObject() == this.headerFooter;
        xmlCursorNewCursor.dispose();
        return z;
    }

    @Internal
    public CTHdrFtr _getHdrFtr() {
        return this.headerFooter;
    }

    public String addPictureData(byte[] bArr, int i) {
        XWPFPictureData xWPFPictureDataFindPackagePictureData = this.document.findPackagePictureData(bArr, i);
        POIXMLRelation pOIXMLRelation = XWPFPictureData.RELATIONS[i];
        OutputStream outputStream = null;
        if (xWPFPictureDataFindPackagePictureData != null) {
            if (getRelations().contains(xWPFPictureDataFindPackagePictureData)) {
                return getRelationId(xWPFPictureDataFindPackagePictureData);
            }
            POIXMLDocumentPart.RelationPart relationPartAddRelation = addRelation(null, XWPFRelation.IMAGES, xWPFPictureDataFindPackagePictureData);
            this.pictures.add(xWPFPictureDataFindPackagePictureData);
            return relationPartAddRelation.getRelationship().getId();
        }
        XWPFPictureData xWPFPictureData = (XWPFPictureData) createRelationship(pOIXMLRelation, XWPFFactory.getInstance(), this.document.getNextPicNameNumber(i));
        try {
            try {
                outputStream = xWPFPictureData.getPackagePart().getOutputStream();
                outputStream.write(bArr);
                try {
                    outputStream.close();
                } catch (IOException unused) {
                }
                this.document.registerPackagePictureData(xWPFPictureData);
                this.pictures.add(xWPFPictureData);
                return getRelationId(xWPFPictureData);
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (IOException e) {
            throw new POIXMLException(e);
        }
    }

    public void clearHeaderFooter() {
        XmlCursor xmlCursorNewCursor = this.headerFooter.newCursor();
        xmlCursorNewCursor.removeXmlContents();
        xmlCursorNewCursor.dispose();
        this.paragraphs.clear();
        this.tables.clear();
        this.bodyElements.clear();
    }

    public XWPFParagraph createParagraph() {
        XWPFParagraph xWPFParagraph = new XWPFParagraph(this.headerFooter.addNewP(), this);
        this.paragraphs.add(xWPFParagraph);
        this.bodyElements.add(xWPFParagraph);
        return xWPFParagraph;
    }

    public XWPFTable createTable(int i, int i2) {
        XWPFTable xWPFTable = new XWPFTable(this.headerFooter.addNewTbl(), this, i, i2);
        this.tables.add(xWPFTable);
        this.bodyElements.add(xWPFTable);
        return xWPFTable;
    }

    public List<XWPFPictureData> getAllPackagePictures() {
        return this.document.getAllPackagePictures();
    }

    public List<XWPFPictureData> getAllPictures() {
        return Collections.unmodifiableList(this.pictures);
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public List<IBodyElement> getBodyElements() {
        return Collections.unmodifiableList(this.bodyElements);
    }

    public List<XWPFParagraph> getListParagraph() {
        return this.paragraphs;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFParagraph getParagraph(CTP ctp) {
        for (XWPFParagraph xWPFParagraph : this.paragraphs) {
            if (xWPFParagraph.getCTP().equals(ctp)) {
                return xWPFParagraph;
            }
        }
        return null;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFParagraph getParagraphArray(int i) {
        if (i < 0 || i >= this.paragraphs.size()) {
            return null;
        }
        return this.paragraphs.get(i);
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public List<XWPFParagraph> getParagraphs() {
        return Collections.unmodifiableList(this.paragraphs);
    }

    public XWPFPictureData getPictureDataByID(String str) {
        POIXMLDocumentPart relationById = getRelationById(str);
        if (relationById == null || !(relationById instanceof XWPFPictureData)) {
            return null;
        }
        return (XWPFPictureData) relationById;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFTable getTable(CTTbl cTTbl) {
        XWPFTable next;
        Iterator<XWPFTable> it = this.tables.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (next.getCTTbl().equals(cTTbl)) {
                return next;
            }
        }
        return null;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFTable getTableArray(int i) {
        if (i < 0 || i >= this.tables.size()) {
            return null;
        }
        return this.tables.get(i);
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFTableCell getTableCell(CTTc cTTc) {
        XWPFTable table;
        XmlCursor xmlCursorNewCursor = cTTc.newCursor();
        xmlCursorNewCursor.toParent();
        XmlObject object = xmlCursorNewCursor.getObject();
        if (!(object instanceof CTRow)) {
            xmlCursorNewCursor.dispose();
            return null;
        }
        CTRow cTRow = (CTRow) object;
        xmlCursorNewCursor.toParent();
        XmlObject object2 = xmlCursorNewCursor.getObject();
        xmlCursorNewCursor.dispose();
        if ((object2 instanceof CTTbl) && (table = getTable((CTTbl) object2)) != null) {
            return table.getRow(cTRow).getTableCell(cTTc);
        }
        return null;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public List<XWPFTable> getTables() {
        return Collections.unmodifiableList(this.tables);
    }

    public String getText() {
        String text;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < this.paragraphs.size(); i++) {
            if (!this.paragraphs.get(i).isEmpty() && (text = this.paragraphs.get(i).getText()) != null && text.length() > 0) {
                stringBuffer.append(text);
                stringBuffer.append('\n');
            }
        }
        for (int i2 = 0; i2 < this.tables.size(); i2++) {
            String text2 = this.tables.get(i2).getText();
            if (text2 != null && text2.length() > 0) {
                stringBuffer.append(text2);
                stringBuffer.append('\n');
            }
        }
        Iterator<IBodyElement> it = getBodyElements().iterator();
        while (it.hasNext()) {
            XWPFSDT xwpfsdt = (IBodyElement) it.next();
            if (xwpfsdt instanceof XWPFSDT) {
                stringBuffer.append(xwpfsdt.getContent().getText() + '\n');
            }
        }
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFDocument getXWPFDocument() {
        XWPFDocument xWPFDocument = this.document;
        return xWPFDocument != null ? xWPFDocument : (XWPFDocument) getParent();
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFParagraph insertNewParagraph(XmlCursor xmlCursor) {
        boolean z;
        CTP ctp;
        XmlObject object = null;
        if (!isCursorInHdrF(xmlCursor)) {
            return null;
        }
        xmlCursor.beginElement("p", CTP.type.getName().getNamespaceURI());
        xmlCursor.toParent();
        CTP ctp2 = (CTP) xmlCursor.getObject();
        XWPFParagraph xWPFParagraph = new XWPFParagraph(ctp2, this);
        while (true) {
            z = object instanceof CTP;
            if (z || !xmlCursor.toPrevSibling()) {
                break;
            }
            object = xmlCursor.getObject();
        }
        int i = 0;
        if (!z || (ctp = (CTP) object) == ctp2) {
            this.paragraphs.add(0, xWPFParagraph);
        } else {
            this.paragraphs.add(this.paragraphs.indexOf(getParagraph(ctp)) + 1, xWPFParagraph);
        }
        XmlCursor xmlCursorNewCursor = ctp2.newCursor();
        xmlCursor.toCursor(xmlCursorNewCursor);
        xmlCursorNewCursor.dispose();
        while (xmlCursor.toPrevSibling()) {
            XmlObject object2 = xmlCursor.getObject();
            if ((object2 instanceof CTP) || (object2 instanceof CTTbl)) {
                i++;
            }
        }
        this.bodyElements.add(i, xWPFParagraph);
        XmlCursor xmlCursorNewCursor2 = ctp2.newCursor();
        xmlCursor.toCursor(xmlCursorNewCursor2);
        xmlCursor.toEndToken();
        xmlCursorNewCursor2.dispose();
        return xWPFParagraph;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public XWPFTable insertNewTbl(XmlCursor xmlCursor) {
        boolean z;
        XmlObject object = null;
        if (!isCursorInHdrF(xmlCursor)) {
            return null;
        }
        xmlCursor.beginElement("tbl", CTTbl.type.getName().getNamespaceURI());
        xmlCursor.toParent();
        CTTbl cTTbl = (CTTbl) xmlCursor.getObject();
        XWPFTable xWPFTable = new XWPFTable(cTTbl, this);
        xmlCursor.removeXmlContents();
        while (true) {
            z = object instanceof CTTbl;
            if (z || !xmlCursor.toPrevSibling()) {
                break;
            }
            object = xmlCursor.getObject();
        }
        int i = 0;
        if (z) {
            this.tables.add(this.tables.indexOf(getTable((CTTbl) object)) + 1, xWPFTable);
        } else {
            this.tables.add(0, xWPFTable);
        }
        XmlCursor xmlCursorNewCursor = cTTbl.newCursor();
        while (xmlCursorNewCursor.toPrevSibling()) {
            XmlObject object2 = xmlCursorNewCursor.getObject();
            if ((object2 instanceof CTP) || (object2 instanceof CTTbl)) {
                i++;
            }
        }
        xmlCursorNewCursor.dispose();
        this.bodyElements.add(i, xWPFTable);
        XmlCursor xmlCursorNewCursor2 = cTTbl.newCursor();
        xmlCursor.toCursor(xmlCursorNewCursor2);
        xmlCursor.toEndToken();
        xmlCursorNewCursor2.dispose();
        return xWPFTable;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public void insertTable(int i, XWPFTable xWPFTable) {
        this.bodyElements.add(i, xWPFTable);
        CTTbl[] tblArray = this.headerFooter.getTblArray();
        int length = tblArray.length;
        int i2 = 0;
        for (int i4 = 0; i4 < length && tblArray[i4] != xWPFTable.getCTTbl(); i4++) {
            i2++;
        }
        this.tables.add(i2, xWPFTable);
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    public void onDocumentRead() {
        for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
            if (pOIXMLDocumentPart instanceof XWPFPictureData) {
                XWPFPictureData xWPFPictureData = (XWPFPictureData) pOIXMLDocumentPart;
                this.pictures.add(xWPFPictureData);
                this.document.registerPackagePictureData(xWPFPictureData);
            }
        }
    }

    @Override // org.apache.poi.POIXMLDocumentPart
    public void prepareForCommit() {
        if (this.bodyElements.size() == 0) {
            createParagraph();
        }
        Iterator<XWPFTable> it = this.tables.iterator();
        while (it.hasNext()) {
            Iterator<XWPFTableRow> it2 = it.next().tableRows.iterator();
            while (it2.hasNext()) {
                for (XWPFTableCell xWPFTableCell : it2.next().getTableCells()) {
                    if (xWPFTableCell.getBodyElements().size() == 0) {
                        xWPFTableCell.addParagraph();
                    }
                }
            }
        }
        super.prepareForCommit();
    }

    public void readHdrFtr() {
        this.bodyElements = new ArrayList();
        this.paragraphs = new ArrayList();
        this.tables = new ArrayList();
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

    public void removeParagraph(XWPFParagraph xWPFParagraph) {
        if (this.paragraphs.contains(xWPFParagraph)) {
            XmlCursor xmlCursorNewCursor = xWPFParagraph.getCTP().newCursor();
            xmlCursorNewCursor.removeXml();
            xmlCursorNewCursor.dispose();
            this.paragraphs.remove(xWPFParagraph);
            this.bodyElements.remove(xWPFParagraph);
        }
    }

    public void removeTable(XWPFTable xWPFTable) {
        if (this.tables.contains(xWPFTable)) {
            XmlCursor xmlCursorNewCursor = xWPFTable.getCTTbl().newCursor();
            xmlCursorNewCursor.removeXml();
            xmlCursorNewCursor.dispose();
            this.tables.remove(xWPFTable);
            this.bodyElements.remove(xWPFTable);
        }
    }

    public void setHeaderFooter(CTHdrFtr cTHdrFtr) {
        this.headerFooter = cTHdrFtr;
        readHdrFtr();
    }

    public void setXWPFDocument(XWPFDocument xWPFDocument) {
        this.document = xWPFDocument;
    }

    public XWPFHeaderFooter() {
        this.paragraphs = new ArrayList();
        this.tables = new ArrayList();
        this.pictures = new ArrayList();
        this.bodyElements = new ArrayList();
        this.headerFooter = CTHdrFtr.Factory.newInstance();
        readHdrFtr();
    }

    public XWPFHeaderFooter(POIXMLDocumentPart pOIXMLDocumentPart, PackagePart packagePart) {
        super(pOIXMLDocumentPart, packagePart);
        this.paragraphs = new ArrayList();
        this.tables = new ArrayList();
        this.pictures = new ArrayList();
        this.bodyElements = new ArrayList();
        XWPFDocument xWPFDocument = (XWPFDocument) getParent();
        this.document = xWPFDocument;
        xWPFDocument.getClass();
    }

    public POIXMLDocumentPart getOwner() {
        return this;
    }

    @Override // org.apache.poi.xwpf.usermodel.IBody
    public POIXMLDocumentPart getPart() {
        return this;
    }

    public String addPictureData(InputStream inputStream, int i) {
        return addPictureData(IOUtils.toByteArray(inputStream), i);
    }
}
