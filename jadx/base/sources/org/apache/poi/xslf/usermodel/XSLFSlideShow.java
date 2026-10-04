package org.apache.poi.xslf.usermodel;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTNotesSlide;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPresentation;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlide;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdListEntry;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMaster;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideMasterIdListEntry;
import org.openxmlformats.schemas.presentationml.x2006.main.CmLstDocument;
import org.openxmlformats.schemas.presentationml.x2006.main.NotesDocument;
import org.openxmlformats.schemas.presentationml.x2006.main.PresentationDocument;
import org.openxmlformats.schemas.presentationml.x2006.main.SldDocument;
import org.openxmlformats.schemas.presentationml.x2006.main.SldMasterDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XSLFSlideShow extends POIXMLDocument {
    private List<PackagePart> embedds;
    private PresentationDocument presentationDoc;

    public XSLFSlideShow(OPCPackage oPCPackage) throws InvalidFormatException {
        super(oPCPackage);
        if (getCorePart().getContentType().equals(XSLFRelation.THEME_MANAGER.getContentType())) {
            rebase(getPackage());
        }
        this.presentationDoc = PresentationDocument.Factory.parse(getCorePart().getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        this.embedds = new LinkedList();
        for (CTSlideIdListEntry cTSlideIdListEntry : getSlideReferences().getSldIdArray()) {
            PackagePart corePart = getCorePart();
            PackagePart relatedPart = corePart.getRelatedPart(corePart.getRelationship(cTSlideIdListEntry.getId2()));
            for (PackageRelationship packageRelationship : relatedPart.getRelationshipsByType(POIXMLDocument.OLE_OBJECT_REL_TYPE)) {
                if (TargetMode.EXTERNAL != packageRelationship.getTargetMode()) {
                    this.embedds.add(relatedPart.getRelatedPart(packageRelationship));
                }
            }
            Iterator<PackageRelationship> it = relatedPart.getRelationshipsByType(POIXMLDocument.PACK_OBJECT_REL_TYPE).iterator();
            while (it.hasNext()) {
                this.embedds.add(relatedPart.getRelatedPart(it.next()));
            }
        }
    }

    @Override // org.apache.poi.POIXMLDocument
    public List<PackagePart> getAllEmbedds() {
        return this.embedds;
    }

    public PackagePart getNodesPart(CTSlideIdListEntry cTSlideIdListEntry) throws XmlException {
        PackagePart slidePart = getSlidePart(cTSlideIdListEntry);
        try {
            PackageRelationshipCollection relationshipsByType = slidePart.getRelationshipsByType(XSLFRelation.NOTES.getRelation());
            if (relationshipsByType.size() == 0) {
                return null;
            }
            if (relationshipsByType.size() <= 1) {
                try {
                    return slidePart.getRelatedPart(relationshipsByType.getRelationship(0));
                } catch (InvalidFormatException e) {
                    throw new IllegalStateException(e);
                }
            }
            throw new IllegalStateException("Expecting 0 or 1 notes for a slide, but found " + relationshipsByType.size());
        } catch (InvalidFormatException e2) {
            throw new IllegalStateException(e2);
        }
    }

    @Internal
    public CTNotesSlide getNotes(CTSlideIdListEntry cTSlideIdListEntry) throws XmlException {
        PackagePart nodesPart = getNodesPart(cTSlideIdListEntry);
        if (nodesPart == null) {
            return null;
        }
        return NotesDocument.Factory.parse(nodesPart.getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getNotes();
    }

    @Internal
    public CTPresentation getPresentation() {
        return this.presentationDoc.getPresentation();
    }

    @Internal
    public CTSlide getSlide(CTSlideIdListEntry cTSlideIdListEntry) {
        return SldDocument.Factory.parse(getSlidePart(cTSlideIdListEntry).getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getSld();
    }

    @Internal
    public CTCommentList getSlideComments(CTSlideIdListEntry cTSlideIdListEntry) throws XmlException {
        PackagePart slidePart = getSlidePart(cTSlideIdListEntry);
        try {
            PackageRelationshipCollection relationshipsByType = slidePart.getRelationshipsByType(XSLFRelation.COMMENTS.getRelation());
            if (relationshipsByType.size() == 0) {
                return null;
            }
            if (relationshipsByType.size() <= 1) {
                try {
                    return CmLstDocument.Factory.parse(slidePart.getRelatedPart(relationshipsByType.getRelationship(0)).getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getCmLst();
                } catch (InvalidFormatException e) {
                    throw new IllegalStateException(e);
                }
            }
            throw new IllegalStateException("Expecting 0 or 1 comments for a slide, but found " + relationshipsByType.size());
        } catch (InvalidFormatException e2) {
            throw new IllegalStateException(e2);
        }
    }

    @Internal
    public CTSlideMaster getSlideMaster(CTSlideMasterIdListEntry cTSlideMasterIdListEntry) {
        return SldMasterDocument.Factory.parse(getSlideMasterPart(cTSlideMasterIdListEntry).getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getSldMaster();
    }

    public PackagePart getSlideMasterPart(CTSlideMasterIdListEntry cTSlideMasterIdListEntry) throws XmlException {
        try {
            PackagePart corePart = getCorePart();
            return corePart.getRelatedPart(corePart.getRelationship(cTSlideMasterIdListEntry.getId2()));
        } catch (InvalidFormatException e) {
            throw new XmlException(e);
        }
    }

    @Internal
    public CTSlideMasterIdList getSlideMasterReferences() {
        return getPresentation().getSldMasterIdLst();
    }

    public PackagePart getSlidePart(CTSlideIdListEntry cTSlideIdListEntry) throws XmlException {
        try {
            PackagePart corePart = getCorePart();
            return corePart.getRelatedPart(corePart.getRelationship(cTSlideIdListEntry.getId2()));
        } catch (InvalidFormatException e) {
            throw new XmlException(e);
        }
    }

    @Internal
    public CTSlideIdList getSlideReferences() {
        if (!getPresentation().isSetSldIdLst()) {
            getPresentation().setSldIdLst(CTSlideIdList.Factory.newInstance());
        }
        return getPresentation().getSldIdLst();
    }

    public XSLFSlideShow(String str) {
        this(POIXMLDocument.openPackage(str));
    }
}
