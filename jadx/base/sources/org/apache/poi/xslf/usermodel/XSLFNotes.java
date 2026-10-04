package org.apache.poi.xslf.usermodel;

import com.samsung.android.sdk.mobileservice.profile.Privacy;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.p226sl.usermodel.Notes;
import org.openxmlformats.schemas.presentationml.x2006.main.CTNotesSlide;
import org.openxmlformats.schemas.presentationml.x2006.main.NotesDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class XSLFNotes extends XSLFSheet implements Notes<XSLFShape, XSLFTextParagraph> {
    private CTNotesSlide _notes;

    public XSLFNotes() {
        CTNotesSlide cTNotesSlidePrototype = prototype();
        this._notes = cTNotesSlidePrototype;
        setCommonSlideData(cTNotesSlidePrototype.getCSld());
    }

    private static CTNotesSlide prototype() {
        CTNotesSlide cTNotesSlideNewInstance = CTNotesSlide.Factory.newInstance();
        cTNotesSlideNewInstance.addNewCSld().addNewSpTree();
        return cTNotesSlideNewInstance;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public String getRootElementName() {
        return Privacy.KEY_NOTES;
    }

    @Override // org.apache.poi.p226sl.usermodel.Notes
    public List<List<XSLFTextParagraph>> getTextParagraphs() {
        ArrayList arrayList = new ArrayList();
        for (XSLFShape xSLFShape : super.getShapes()) {
            if (xSLFShape instanceof XSLFTextShape) {
                arrayList.add(((XSLFTextShape) xSLFShape).getTextParagraphs());
            }
        }
        return arrayList;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public XSLFTheme getTheme() {
        return getMasterSheet().getTheme();
    }

    @Override // org.apache.poi.p226sl.usermodel.Sheet
    public XSLFNotesMaster getMasterSheet() {
        for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
            if (pOIXMLDocumentPart instanceof XSLFNotesMaster) {
                return (XSLFNotesMaster) pOIXMLDocumentPart;
            }
        }
        return null;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public CTNotesSlide getXmlObject() {
        return this._notes;
    }

    public XSLFNotes(PackagePart packagePart) {
        super(packagePart);
        CTNotesSlide notes = NotesDocument.Factory.parse(getPackagePart().getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getNotes();
        this._notes = notes;
        setCommonSlideData(notes.getCSld());
    }
}
