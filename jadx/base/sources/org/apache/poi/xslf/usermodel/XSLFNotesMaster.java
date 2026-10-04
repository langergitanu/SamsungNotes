package org.apache.poi.xslf.usermodel;

import java.io.InputStream;
import java.util.Iterator;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLException;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.p226sl.usermodel.MasterSheet;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping;
import org.openxmlformats.schemas.presentationml.x2006.main.CTNotesMaster;
import org.openxmlformats.schemas.presentationml.x2006.main.NotesMasterDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XSLFNotesMaster extends XSLFSheet implements MasterSheet<XSLFShape, XSLFTextParagraph> {
    private CTNotesMaster _slide;
    private XSLFTheme _theme;

    public XSLFNotesMaster() {
        this._slide = prototype();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.POIXMLException */
    private static CTNotesMaster prototype() throws POIXMLException {
        InputStream resourceAsStream = XSLFNotesMaster.class.getResourceAsStream("notesMaster.xml");
        try {
            if (resourceAsStream == null) {
                throw new POIXMLException("Missing resource 'notesMaster.xml'");
            }
            try {
                return NotesMasterDocument.Factory.parse(resourceAsStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getNotesMaster();
            } finally {
                resourceAsStream.close();
            }
        } catch (Exception e) {
            throw new POIXMLException("Can't initialize NotesMaster", e);
        }
    }

    @Override // org.apache.poi.p226sl.usermodel.Sheet
    public MasterSheet<XSLFShape, XSLFTextParagraph> getMasterSheet() {
        return null;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public String getRootElementName() {
        return "notesMaster";
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public XSLFTheme getTheme() {
        if (this._theme == null) {
            Iterator<POIXMLDocumentPart> it = getRelations().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                POIXMLDocumentPart next = it.next();
                if (next instanceof XSLFTheme) {
                    this._theme = (XSLFTheme) next;
                    CTColorMapping clrMap = this._slide.getClrMap();
                    if (clrMap != null) {
                        this._theme.initColorMap(clrMap);
                    }
                }
            }
        }
        return this._theme;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSheet
    public CTNotesMaster getXmlObject() {
        return this._slide;
    }

    public XSLFNotesMaster(PackagePart packagePart) {
        super(packagePart);
        CTNotesMaster notesMaster = NotesMasterDocument.Factory.parse(getPackagePart().getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getNotesMaster();
        this._slide = notesMaster;
        setCommonSlideData(notesMaster.getCSld());
    }
}
