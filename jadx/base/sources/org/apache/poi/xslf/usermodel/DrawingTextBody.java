package org.apache.poi.xslf.usermodel;

import org.apache.poi.util.Removal;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Removal(version = "3.18")
public class DrawingTextBody {
    private final CTTextBody textBody;

    public DrawingTextBody(CTTextBody cTTextBody) {
        this.textBody = cTTextBody;
    }

    public DrawingParagraph[] getParagraphs() {
        CTTextParagraph[] pArray = this.textBody.getPArray();
        int length = pArray.length;
        DrawingParagraph[] drawingParagraphArr = new DrawingParagraph[length];
        for (int i = 0; i < length; i++) {
            drawingParagraphArr[i] = new DrawingParagraph(pArray[i]);
        }
        return drawingParagraphArr;
    }
}
