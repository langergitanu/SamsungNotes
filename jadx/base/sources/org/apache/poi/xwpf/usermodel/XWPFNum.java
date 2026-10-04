package org.apache.poi.xwpf.usermodel;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNum;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XWPFNum {
    private CTNum ctNum;
    protected XWPFNumbering numbering;

    public XWPFNum() {
        this.ctNum = null;
        this.numbering = null;
    }

    public CTNum getCTNum() {
        return this.ctNum;
    }

    public XWPFNumbering getNumbering() {
        return this.numbering;
    }

    public void setCTNum(CTNum cTNum) {
        this.ctNum = cTNum;
    }

    public void setNumbering(XWPFNumbering xWPFNumbering) {
        this.numbering = xWPFNumbering;
    }

    public XWPFNum(CTNum cTNum) {
        this.ctNum = cTNum;
        this.numbering = null;
    }

    public XWPFNum(XWPFNumbering xWPFNumbering) {
        this.ctNum = null;
        this.numbering = xWPFNumbering;
    }

    public XWPFNum(CTNum cTNum, XWPFNumbering xWPFNumbering) {
        this.ctNum = cTNum;
        this.numbering = xWPFNumbering;
    }
}
