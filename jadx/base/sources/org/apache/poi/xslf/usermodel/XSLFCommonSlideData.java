package org.apache.poi.xslf.usermodel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.POIXMLException;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.util.Removal;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlAnyTypeImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTable;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Removal(version = "3.18")
public class XSLFCommonSlideData {
    private final CTCommonSlideData data;

    public XSLFCommonSlideData(CTCommonSlideData cTCommonSlideData) {
        this.data = cTCommonSlideData;
    }

    private void processShape(CTGroupShape cTGroupShape, List<DrawingTextBody> list) {
        for (CTShape cTShape : cTGroupShape.getSpArray()) {
            CTTextBody txBody = cTShape.getTxBody();
            if (txBody != null) {
                CTApplicationNonVisualDrawingProps nvPr = cTShape.getNvSpPr().getNvPr();
                list.add(nvPr.isSetPh() ? new DrawingTextPlaceholder(txBody, nvPr.getPh()) : new DrawingTextBody(txBody));
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.POIXMLException */
    public List<DrawingTextBody> getDrawingText() throws POIXMLException {
        CTGroupShape spTree = this.data.getSpTree();
        ArrayList arrayList = new ArrayList();
        processShape(spTree, arrayList);
        for (CTGroupShape cTGroupShape : spTree.getGrpSpArray()) {
            processShape(cTGroupShape, arrayList);
        }
        for (CTGraphicalObjectFrame cTGraphicalObjectFrame : spTree.getGraphicFrameArray()) {
            XmlCursor xmlCursorNewCursor = cTGraphicalObjectFrame.getGraphic().getGraphicData().newCursor();
            xmlCursorNewCursor.selectPath("declare namespace pic='" + CTTable.type.getName().getNamespaceURI() + "' .//pic:tbl");
            while (xmlCursorNewCursor.toNextSelection()) {
                XmlObject object = xmlCursorNewCursor.getObject();
                if (object instanceof XmlAnyTypeImpl) {
                    try {
                        object = CTTable.Factory.parse(object.toString(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
                    } catch (XmlException e) {
                        throw new POIXMLException(e);
                    }
                }
                if (object instanceof CTTable) {
                    for (DrawingTableRow drawingTableRow : new DrawingTable((CTTable) object).getRows()) {
                        for (DrawingTableCell drawingTableCell : drawingTableRow.getCells()) {
                            arrayList.add(drawingTableCell.getTextBody());
                        }
                    }
                }
            }
            xmlCursorNewCursor.dispose();
        }
        return arrayList;
    }

    public List<DrawingParagraph> getText() {
        ArrayList arrayList = new ArrayList();
        Iterator<DrawingTextBody> it = getDrawingText().iterator();
        while (it.hasNext()) {
            arrayList.addAll(Arrays.asList(it.next().getParagraphs()));
        }
        return arrayList;
    }
}
