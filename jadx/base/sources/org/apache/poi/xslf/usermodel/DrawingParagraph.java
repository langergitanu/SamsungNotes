package org.apache.poi.xslf.usermodel;

import org.apache.poi.util.Removal;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextLineBreak;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Removal(version = "3.18")
public class DrawingParagraph {

    /* JADX INFO: renamed from: p */
    private final CTTextParagraph f10165p;

    public DrawingParagraph(CTTextParagraph cTTextParagraph) {
        this.f10165p = cTTextParagraph;
    }

    public CharSequence getText() {
        StringBuilder sb = new StringBuilder();
        XmlCursor xmlCursorNewCursor = this.f10165p.newCursor();
        xmlCursorNewCursor.selectPath("./*");
        while (xmlCursorNewCursor.toNextSelection()) {
            XmlObject object = xmlCursorNewCursor.getObject();
            if (object instanceof CTRegularTextRun) {
                sb.append(((CTRegularTextRun) object).getT());
            } else if (object instanceof CTTextLineBreak) {
                sb.append('\n');
            }
        }
        xmlCursorNewCursor.dispose();
        return sb;
    }
}
