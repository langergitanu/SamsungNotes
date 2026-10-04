package org.apache.poi.xslf.extractor;

import androidx.glance.AbstractC2821a;
import java.util.Iterator;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.p226sl.usermodel.Shape;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFCommentAuthors;
import org.apache.poi.xslf.usermodel.XSLFComments;
import org.apache.poi.xslf.usermodel.XSLFNotes;
import org.apache.poi.xslf.usermodel.XSLFRelation;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFShapeContainer;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFSlideMaster;
import org.apache.poi.xslf.usermodel.XSLFSlideShow;
import org.apache.poi.xslf.usermodel.XSLFTable;
import org.apache.poi.xslf.usermodel.XSLFTableCell;
import org.apache.poi.xslf.usermodel.XSLFTableRow;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTComment;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XSLFPowerPointExtractor extends POIXMLTextExtractor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final XSLFRelation[] SUPPORTED_TYPES = {XSLFRelation.MAIN, XSLFRelation.MACRO, XSLFRelation.MACRO_TEMPLATE, XSLFRelation.PRESENTATIONML, XSLFRelation.PRESENTATIONML_TEMPLATE, XSLFRelation.PRESENTATION_MACRO};
    private boolean masterByDefault;
    private boolean notesByDefault;
    private boolean slidesByDefault;
    private XMLSlideShow slideshow;

    public XSLFPowerPointExtractor(XMLSlideShow xMLSlideShow) {
        super(xMLSlideShow);
        this.slidesByDefault = true;
        this.notesByDefault = false;
        this.masterByDefault = false;
        this.slideshow = xMLSlideShow;
    }

    private static void extractText(XSLFShapeContainer xSLFShapeContainer, boolean z, StringBuilder sb) {
        Iterator<S> it = xSLFShapeContainer.iterator();
        while (it.hasNext()) {
            Shape shape = (XSLFShape) it.next();
            if (shape instanceof XSLFShapeContainer) {
                extractText((XSLFShapeContainer) shape, z, sb);
            } else if (shape instanceof XSLFTextShape) {
                XSLFTextShape xSLFTextShape = (XSLFTextShape) shape;
                if (!z || !xSLFTextShape.isPlaceholder()) {
                    sb.append(xSLFTextShape.getText());
                    sb.append("\n");
                }
            } else if (shape instanceof XSLFTable) {
                Iterator<XSLFTableRow> it2 = ((XSLFTable) shape).iterator();
                while (it2.hasNext()) {
                    Iterator<XSLFTableCell> it3 = it2.next().iterator();
                    while (it3.hasNext()) {
                        sb.append(it3.next().getText());
                        sb.append("\t");
                    }
                    sb.append("\n");
                }
            }
        }
    }

    public static void main(String[] strArr) {
        if (strArr.length < 1) {
            System.err.println("Use:");
            System.err.println("  XSLFPowerPointExtractor <filename.pptx>");
            System.exit(1);
        }
        XSLFPowerPointExtractor xSLFPowerPointExtractor = new XSLFPowerPointExtractor(new XSLFSlideShow(strArr[0]));
        System.out.println(xSLFPowerPointExtractor.getText());
        xSLFPowerPointExtractor.close();
    }

    public String getText() {
        return getText(this.slidesByDefault, this.notesByDefault);
    }

    public void setMasterByDefault(boolean z) {
        this.masterByDefault = z;
    }

    public void setNotesByDefault(boolean z) {
        this.notesByDefault = z;
    }

    public void setSlidesByDefault(boolean z) {
        this.slidesByDefault = z;
    }

    public String getText(boolean z, boolean z2) {
        return getText(z, z2, this.masterByDefault);
    }

    public String getText(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        Iterator<XSLFSlide> it = this.slideshow.getSlides().iterator();
        while (it.hasNext()) {
            sb.append(getText(it.next(), z, z2, z3));
        }
        return sb.toString();
    }

    public XSLFPowerPointExtractor(XSLFSlideShow xSLFSlideShow) {
        this(new XMLSlideShow(xSLFSlideShow.getPackage()));
    }

    public XSLFPowerPointExtractor(OPCPackage oPCPackage) {
        this(new XSLFSlideShow(oPCPackage));
    }

    public static String getText(XSLFSlide xSLFSlide, boolean z, boolean z2, boolean z3) {
        CTCommentAuthor authorById;
        StringBuilder sb = new StringBuilder();
        XSLFCommentAuthors commentAuthors = xSLFSlide.getSlideShow().getCommentAuthors();
        XSLFNotes notes = xSLFSlide.getNotes();
        XSLFComments comments = xSLFSlide.getComments();
        XSLFSlideLayout slideLayout = xSLFSlide.getSlideLayout();
        XSLFSlideMaster slideMaster = slideLayout.getSlideMaster();
        if (z) {
            extractText(xSLFSlide, false, sb);
            if (z3) {
                extractText(slideLayout, true, sb);
                extractText(slideMaster, true, sb);
            }
            if (comments != null) {
                CTComment[] cmArray = comments.getCTCommentsList().getCmArray();
                int length = cmArray.length;
                int iM2213d = 0;
                while (iM2213d < length) {
                    CTComment cTComment = cmArray[iM2213d];
                    if (commentAuthors != null && (authorById = commentAuthors.getAuthorById(cTComment.getAuthorId())) != null) {
                        sb.append(authorById.getName() + ": ");
                    }
                    iM2213d = AbstractC2821a.m2213d(sb, iM2213d, 1, cTComment.getText(), "\n");
                }
            }
        }
        if (z2 && notes != null) {
            extractText(notes, false, sb);
        }
        return sb.toString();
    }
}
