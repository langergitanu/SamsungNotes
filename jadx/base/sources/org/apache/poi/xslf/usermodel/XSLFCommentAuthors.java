package org.apache.poi.xslf.usermodel;

import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthor;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthorList;
import org.openxmlformats.schemas.presentationml.x2006.main.CmAuthorLstDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XSLFCommentAuthors extends POIXMLDocumentPart {
    private final CTCommentAuthorList _authors;

    public XSLFCommentAuthors() {
        this._authors = CmAuthorLstDocument.Factory.newInstance().addNewCmAuthorLst();
    }

    public CTCommentAuthor getAuthorById(long j) {
        for (CTCommentAuthor cTCommentAuthor : this._authors.getCmAuthorArray()) {
            if (cTCommentAuthor.getId() == j) {
                return cTCommentAuthor;
            }
        }
        return null;
    }

    public CTCommentAuthorList getCTCommentAuthorsList() {
        return this._authors;
    }

    public XSLFCommentAuthors(PackagePart packagePart) {
        super(packagePart);
        this._authors = CmAuthorLstDocument.Factory.parse(getPackagePart().getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getCmAuthorLst();
    }
}
