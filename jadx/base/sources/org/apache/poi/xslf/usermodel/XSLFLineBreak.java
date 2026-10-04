package org.apache.poi.xslf.usermodel;

import org.openxmlformats.schemas.drawingml.x2006.main.CTTextLineBreak;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class XSLFLineBreak extends XSLFTextRun {
    public XSLFLineBreak(CTTextLineBreak cTTextLineBreak, XSLFTextParagraph xSLFTextParagraph) {
        super(cTTextLineBreak, xSLFTextParagraph);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextRun, org.apache.poi.p226sl.usermodel.TextRun
    public void setText(String str) {
        throw new IllegalStateException("You cannot change text of a line break, it is always '\\n'");
    }
}
