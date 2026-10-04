package org.apache.poi.xwpf.usermodel;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XWPFAbstractNum {
    private CTAbstractNum ctAbstractNum;
    protected XWPFNumbering numbering;

    public XWPFAbstractNum() {
        this.ctAbstractNum = null;
        this.numbering = null;
    }

    public CTAbstractNum getAbstractNum() {
        return this.ctAbstractNum;
    }

    public CTAbstractNum getCTAbstractNum() {
        return this.ctAbstractNum;
    }

    public XWPFNumbering getNumbering() {
        return this.numbering;
    }

    public void setNumbering(XWPFNumbering xWPFNumbering) {
        this.numbering = xWPFNumbering;
    }

    public XWPFAbstractNum(CTAbstractNum cTAbstractNum) {
        this.ctAbstractNum = cTAbstractNum;
    }

    public XWPFAbstractNum(CTAbstractNum cTAbstractNum, XWPFNumbering xWPFNumbering) {
        this.ctAbstractNum = cTAbstractNum;
        this.numbering = xWPFNumbering;
    }
}
