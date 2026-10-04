package org.apache.poi.xslf.usermodel;

import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.openxmlformats.schemas.presentationml.x2006.main.CTComment;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentList;
import org.openxmlformats.schemas.presentationml.x2006.main.CmLstDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XSLFComments extends POIXMLDocumentPart {
    private final CTCommentList _comments;

    public XSLFComments() {
        this._comments = CmLstDocument.Factory.newInstance().addNewCmLst();
    }

    public CTCommentList getCTCommentsList() {
        return this._comments;
    }

    public CTComment getCommentAt(int i) {
        return this._comments.getCmArray(i);
    }

    public int getNumberOfComments() {
        return this._comments.sizeOfCmArray();
    }

    public XSLFComments(PackagePart packagePart) {
        super(packagePart);
        this._comments = CmLstDocument.Factory.parse(getPackagePart().getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getCmLst();
    }
}
