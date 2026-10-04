package org.openxmlformats.schemas.officeDocument.x2006.math.impl;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTAcc;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTBar;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTBorderBox;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTBox;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTCtrlPr;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTD;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTEqArr;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTF;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTFunc;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTGroupChr;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTLimLow;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTLimUpp;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTM;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTNary;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArgPr;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTPhant;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTR;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTRad;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTSPre;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTSSub;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTSSubSup;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTSSup;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkup;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkupRange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMoveBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPerm;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPermStart;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProofErr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange;

/* JADX INFO: loaded from: classes11.dex */
public class CTOMathArgImpl extends XmlComplexContentImpl implements CTOMathArg {
    private static final QName ARGPR$0 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "argPr");
    private static final QName ACC$2 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "acc");
    private static final QName BAR$4 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "bar");
    private static final QName BOX$6 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "box");
    private static final QName BORDERBOX$8 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "borderBox");
    private static final QName D$10 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "d");
    private static final QName EQARR$12 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "eqArr");
    private static final QName F$14 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "f");
    private static final QName FUNC$16 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "func");
    private static final QName GROUPCHR$18 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "groupChr");
    private static final QName LIMLOW$20 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "limLow");
    private static final QName LIMUPP$22 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "limUpp");
    private static final QName M$24 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "m");
    private static final QName NARY$26 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "nary");
    private static final QName PHANT$28 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "phant");
    private static final QName RAD$30 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "rad");
    private static final QName SPRE$32 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "sPre");
    private static final QName SSUB$34 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "sSub");
    private static final QName SSUBSUP$36 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "sSubSup");
    private static final QName SSUP$38 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "sSup");
    private static final QName R$40 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "r");
    private static final QName PROOFERR$42 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "proofErr");
    private static final QName PERMSTART$44 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "permStart");
    private static final QName PERMEND$46 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "permEnd");
    private static final QName BOOKMARKSTART$48 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bookmarkStart");
    private static final QName BOOKMARKEND$50 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bookmarkEnd");
    private static final QName MOVEFROMRANGESTART$52 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFromRangeStart");
    private static final QName MOVEFROMRANGEEND$54 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFromRangeEnd");
    private static final QName MOVETORANGESTART$56 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveToRangeStart");
    private static final QName MOVETORANGEEND$58 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveToRangeEnd");
    private static final QName COMMENTRANGESTART$60 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "commentRangeStart");
    private static final QName COMMENTRANGEEND$62 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "commentRangeEnd");
    private static final QName CUSTOMXMLINSRANGESTART$64 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlInsRangeStart");
    private static final QName CUSTOMXMLINSRANGEEND$66 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlInsRangeEnd");
    private static final QName CUSTOMXMLDELRANGESTART$68 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlDelRangeStart");
    private static final QName CUSTOMXMLDELRANGEEND$70 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlDelRangeEnd");
    private static final QName CUSTOMXMLMOVEFROMRANGESTART$72 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveFromRangeStart");
    private static final QName CUSTOMXMLMOVEFROMRANGEEND$74 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveFromRangeEnd");
    private static final QName CUSTOMXMLMOVETORANGESTART$76 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveToRangeStart");
    private static final QName CUSTOMXMLMOVETORANGEEND$78 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveToRangeEnd");
    private static final QName INS$80 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ins");
    private static final QName DEL$82 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "del");
    private static final QName MOVEFROM$84 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFrom");
    private static final QName MOVETO$86 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveTo");
    private static final QName OMATHPARA$88 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "oMathPara");
    private static final QName OMATH$90 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "oMath");
    private static final QName CTRLPR$92 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "ctrlPr");

    public CTOMathArgImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTAcc addNewAcc() {
        CTAcc cTAccAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAccAdd_element_user = get_store().add_element_user(ACC$2);
        }
        return cTAccAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTOMathArgPr addNewArgPr() {
        CTOMathArgPr cTOMathArgPr;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathArgPr = (CTOMathArgPr) get_store().add_element_user(ARGPR$0);
        }
        return cTOMathArgPr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTBar addNewBar() {
        CTBar cTBarAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBarAdd_element_user = get_store().add_element_user(BAR$4);
        }
        return cTBarAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange addNewBookmarkEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(BOOKMARKEND$50);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTBookmark addNewBookmarkStart() {
        CTBookmark cTBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmark = (CTBookmark) get_store().add_element_user(BOOKMARKSTART$48);
        }
        return cTBookmark;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTBorderBox addNewBorderBox() {
        CTBorderBox cTBorderBoxAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderBoxAdd_element_user = get_store().add_element_user(BORDERBOX$8);
        }
        return cTBorderBoxAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTBox addNewBox() {
        CTBox cTBoxAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBoxAdd_element_user = get_store().add_element_user(BOX$6);
        }
        return cTBoxAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange addNewCommentRangeEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(COMMENTRANGEEND$62);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange addNewCommentRangeStart() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(COMMENTRANGESTART$60);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTCtrlPr addNewCtrlPr() {
        CTCtrlPr cTCtrlPrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCtrlPrAdd_element_user = get_store().add_element_user(CTRLPR$92);
        }
        return cTCtrlPrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkup addNewCustomXmlDelRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(CUSTOMXMLDELRANGEEND$70);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTTrackChange addNewCustomXmlDelRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(CUSTOMXMLDELRANGESTART$68);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkup addNewCustomXmlInsRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(CUSTOMXMLINSRANGEEND$66);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTTrackChange addNewCustomXmlInsRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(CUSTOMXMLINSRANGESTART$64);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkup addNewCustomXmlMoveFromRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(CUSTOMXMLMOVEFROMRANGEEND$74);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTTrackChange addNewCustomXmlMoveFromRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(CUSTOMXMLMOVEFROMRANGESTART$72);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkup addNewCustomXmlMoveToRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(CUSTOMXMLMOVETORANGEEND$78);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTTrackChange addNewCustomXmlMoveToRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(CUSTOMXMLMOVETORANGESTART$76);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTD addNewD() {
        CTD ctdAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctdAdd_element_user = get_store().add_element_user(D$10);
        }
        return ctdAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRunTrackChange addNewDel() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(DEL$82);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTEqArr addNewEqArr() {
        CTEqArr cTEqArrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEqArrAdd_element_user = get_store().add_element_user(EQARR$12);
        }
        return cTEqArrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTF addNewF() {
        CTF ctfAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctfAdd_element_user = get_store().add_element_user(F$14);
        }
        return ctfAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTFunc addNewFunc() {
        CTFunc cTFuncAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFuncAdd_element_user = get_store().add_element_user(FUNC$16);
        }
        return cTFuncAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTGroupChr addNewGroupChr() {
        CTGroupChr cTGroupChrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupChrAdd_element_user = get_store().add_element_user(GROUPCHR$18);
        }
        return cTGroupChrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRunTrackChange addNewIns() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(INS$80);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTLimLow addNewLimLow() {
        CTLimLow cTLimLowAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLimLowAdd_element_user = get_store().add_element_user(LIMLOW$20);
        }
        return cTLimLowAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTLimUpp addNewLimUpp() {
        CTLimUpp cTLimUppAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLimUppAdd_element_user = get_store().add_element_user(LIMUPP$22);
        }
        return cTLimUppAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTM addNewM() {
        CTM ctmAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctmAdd_element_user = get_store().add_element_user(M$24);
        }
        return ctmAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRunTrackChange addNewMoveFrom() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(MOVEFROM$84);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange addNewMoveFromRangeEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(MOVEFROMRANGEEND$54);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMoveBookmark addNewMoveFromRangeStart() {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().add_element_user(MOVEFROMRANGESTART$52);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRunTrackChange addNewMoveTo() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(MOVETO$86);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange addNewMoveToRangeEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(MOVETORANGEEND$58);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMoveBookmark addNewMoveToRangeStart() {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().add_element_user(MOVETORANGESTART$56);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTNary addNewNary() {
        CTNary cTNaryAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTNaryAdd_element_user = get_store().add_element_user(NARY$26);
        }
        return cTNaryAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTOMath addNewOMath() {
        CTOMath cTOMath;
        synchronized (monitor()) {
            check_orphaned();
            cTOMath = (CTOMath) get_store().add_element_user(OMATH$90);
        }
        return cTOMath;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTOMathPara addNewOMathPara() {
        CTOMathPara cTOMathPara;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathPara = (CTOMathPara) get_store().add_element_user(OMATHPARA$88);
        }
        return cTOMathPara;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTPerm addNewPermEnd() {
        CTPerm cTPermAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPermAdd_element_user = get_store().add_element_user(PERMEND$46);
        }
        return cTPermAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTPermStart addNewPermStart() {
        CTPermStart cTPermStartAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPermStartAdd_element_user = get_store().add_element_user(PERMSTART$44);
        }
        return cTPermStartAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTPhant addNewPhant() {
        CTPhant cTPhantAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPhantAdd_element_user = get_store().add_element_user(PHANT$28);
        }
        return cTPhantAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTProofErr addNewProofErr() {
        CTProofErr cTProofErrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErrAdd_element_user = get_store().add_element_user(PROOFERR$42);
        }
        return cTProofErrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTR addNewR() {
        CTR ctrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctrAdd_element_user = get_store().add_element_user(R$40);
        }
        return ctrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRad addNewRad() {
        CTRad cTRadAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRadAdd_element_user = get_store().add_element_user(RAD$30);
        }
        return cTRadAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSPre addNewSPre() {
        CTSPre cTSPreAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSPreAdd_element_user = get_store().add_element_user(SPRE$32);
        }
        return cTSPreAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSSub addNewSSub() {
        CTSSub cTSSubAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSSubAdd_element_user = get_store().add_element_user(SSUB$34);
        }
        return cTSSubAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSSubSup addNewSSubSup() {
        CTSSubSup cTSSubSupAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSSubSupAdd_element_user = get_store().add_element_user(SSUBSUP$36);
        }
        return cTSSubSupAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSSup addNewSSup() {
        CTSSup cTSSupAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSSupAdd_element_user = get_store().add_element_user(SSUP$38);
        }
        return cTSSupAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTAcc getAccArray(int i) {
        CTAcc cTAccFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTAccFind_element_user = get_store().find_element_user(ACC$2, i);
                if (cTAccFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTAccFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTAcc> getAccList() {
        AbstractList<CTAcc> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTAcc>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1AccList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfAccArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTAcc cTAcc) {
                    CTOMathArgImpl.this.insertNewAcc(i).set(cTAcc);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTAcc get(int i) {
                    return CTOMathArgImpl.this.getAccArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTAcc remove(int i) {
                    CTAcc accArray = CTOMathArgImpl.this.getAccArray(i);
                    CTOMathArgImpl.this.removeAcc(i);
                    return accArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTAcc set(int i, CTAcc cTAcc) {
                    CTAcc accArray = CTOMathArgImpl.this.getAccArray(i);
                    CTOMathArgImpl.this.setAccArray(i, cTAcc);
                    return accArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTOMathArgPr getArgPr() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTOMathArgPr cTOMathArgPr = (CTOMathArgPr) get_store().find_element_user(ARGPR$0, 0);
                if (cTOMathArgPr == null) {
                    return null;
                }
                return cTOMathArgPr;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTBar getBarArray(int i) {
        CTBar cTBarFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTBarFind_element_user = get_store().find_element_user(BAR$4, i);
                if (cTBarFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTBarFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTBar> getBarList() {
        AbstractList<CTBar> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTBar>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1BarList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfBarArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTBar cTBar) {
                    CTOMathArgImpl.this.insertNewBar(i).set(cTBar);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBar get(int i) {
                    return CTOMathArgImpl.this.getBarArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBar remove(int i) {
                    CTBar barArray = CTOMathArgImpl.this.getBarArray(i);
                    CTOMathArgImpl.this.removeBar(i);
                    return barArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBar set(int i, CTBar cTBar) {
                    CTBar barArray = CTOMathArgImpl.this.getBarArray(i);
                    CTOMathArgImpl.this.setBarArray(i, cTBar);
                    return barArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange getBookmarkEndArray(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTMarkupRange = (CTMarkupRange) get_store().find_element_user(BOOKMARKEND$50, i);
                if (cTMarkupRange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTMarkupRange> getBookmarkEndList() {
        AbstractList<CTMarkupRange> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTMarkupRange>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1BookmarkEndList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfBookmarkEndArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTMarkupRange cTMarkupRange) {
                    CTOMathArgImpl.this.insertNewBookmarkEnd(i).set(cTMarkupRange);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkupRange get(int i) {
                    return CTOMathArgImpl.this.getBookmarkEndArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkupRange remove(int i) {
                    CTMarkupRange bookmarkEndArray = CTOMathArgImpl.this.getBookmarkEndArray(i);
                    CTOMathArgImpl.this.removeBookmarkEnd(i);
                    return bookmarkEndArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkupRange set(int i, CTMarkupRange cTMarkupRange) {
                    CTMarkupRange bookmarkEndArray = CTOMathArgImpl.this.getBookmarkEndArray(i);
                    CTOMathArgImpl.this.setBookmarkEndArray(i, cTMarkupRange);
                    return bookmarkEndArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTBookmark getBookmarkStartArray(int i) {
        CTBookmark cTBookmark;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTBookmark = (CTBookmark) get_store().find_element_user(BOOKMARKSTART$48, i);
                if (cTBookmark == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTBookmark;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTBookmark> getBookmarkStartList() {
        AbstractList<CTBookmark> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTBookmark>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1BookmarkStartList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfBookmarkStartArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTBookmark cTBookmark) {
                    CTOMathArgImpl.this.insertNewBookmarkStart(i).set(cTBookmark);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBookmark get(int i) {
                    return CTOMathArgImpl.this.getBookmarkStartArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBookmark remove(int i) {
                    CTBookmark bookmarkStartArray = CTOMathArgImpl.this.getBookmarkStartArray(i);
                    CTOMathArgImpl.this.removeBookmarkStart(i);
                    return bookmarkStartArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBookmark set(int i, CTBookmark cTBookmark) {
                    CTBookmark bookmarkStartArray = CTOMathArgImpl.this.getBookmarkStartArray(i);
                    CTOMathArgImpl.this.setBookmarkStartArray(i, cTBookmark);
                    return bookmarkStartArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTBorderBox getBorderBoxArray(int i) {
        CTBorderBox cTBorderBoxFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTBorderBoxFind_element_user = get_store().find_element_user(BORDERBOX$8, i);
                if (cTBorderBoxFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTBorderBoxFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTBorderBox> getBorderBoxList() {
        AbstractList<CTBorderBox> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTBorderBox>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1BorderBoxList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfBorderBoxArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTBorderBox cTBorderBox) {
                    CTOMathArgImpl.this.insertNewBorderBox(i).set(cTBorderBox);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorderBox get(int i) {
                    return CTOMathArgImpl.this.getBorderBoxArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorderBox remove(int i) {
                    CTBorderBox borderBoxArray = CTOMathArgImpl.this.getBorderBoxArray(i);
                    CTOMathArgImpl.this.removeBorderBox(i);
                    return borderBoxArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorderBox set(int i, CTBorderBox cTBorderBox) {
                    CTBorderBox borderBoxArray = CTOMathArgImpl.this.getBorderBoxArray(i);
                    CTOMathArgImpl.this.setBorderBoxArray(i, cTBorderBox);
                    return borderBoxArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTBox getBoxArray(int i) {
        CTBox cTBoxFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTBoxFind_element_user = get_store().find_element_user(BOX$6, i);
                if (cTBoxFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTBoxFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTBox> getBoxList() {
        AbstractList<CTBox> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTBox>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1BoxList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfBoxArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTBox cTBox) {
                    CTOMathArgImpl.this.insertNewBox(i).set(cTBox);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBox get(int i) {
                    return CTOMathArgImpl.this.getBoxArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBox remove(int i) {
                    CTBox boxArray = CTOMathArgImpl.this.getBoxArray(i);
                    CTOMathArgImpl.this.removeBox(i);
                    return boxArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBox set(int i, CTBox cTBox) {
                    CTBox boxArray = CTOMathArgImpl.this.getBoxArray(i);
                    CTOMathArgImpl.this.setBoxArray(i, cTBox);
                    return boxArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange getCommentRangeEndArray(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTMarkupRange = (CTMarkupRange) get_store().find_element_user(COMMENTRANGEEND$62, i);
                if (cTMarkupRange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTMarkupRange> getCommentRangeEndList() {
        AbstractList<CTMarkupRange> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTMarkupRange>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1CommentRangeEndList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfCommentRangeEndArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTMarkupRange cTMarkupRange) {
                    CTOMathArgImpl.this.insertNewCommentRangeEnd(i).set(cTMarkupRange);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkupRange get(int i) {
                    return CTOMathArgImpl.this.getCommentRangeEndArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkupRange remove(int i) {
                    CTMarkupRange commentRangeEndArray = CTOMathArgImpl.this.getCommentRangeEndArray(i);
                    CTOMathArgImpl.this.removeCommentRangeEnd(i);
                    return commentRangeEndArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkupRange set(int i, CTMarkupRange cTMarkupRange) {
                    CTMarkupRange commentRangeEndArray = CTOMathArgImpl.this.getCommentRangeEndArray(i);
                    CTOMathArgImpl.this.setCommentRangeEndArray(i, cTMarkupRange);
                    return commentRangeEndArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange getCommentRangeStartArray(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTMarkupRange = (CTMarkupRange) get_store().find_element_user(COMMENTRANGESTART$60, i);
                if (cTMarkupRange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTMarkupRange> getCommentRangeStartList() {
        AbstractList<CTMarkupRange> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTMarkupRange>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1CommentRangeStartList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfCommentRangeStartArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTMarkupRange cTMarkupRange) {
                    CTOMathArgImpl.this.insertNewCommentRangeStart(i).set(cTMarkupRange);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkupRange get(int i) {
                    return CTOMathArgImpl.this.getCommentRangeStartArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkupRange remove(int i) {
                    CTMarkupRange commentRangeStartArray = CTOMathArgImpl.this.getCommentRangeStartArray(i);
                    CTOMathArgImpl.this.removeCommentRangeStart(i);
                    return commentRangeStartArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkupRange set(int i, CTMarkupRange cTMarkupRange) {
                    CTMarkupRange commentRangeStartArray = CTOMathArgImpl.this.getCommentRangeStartArray(i);
                    CTOMathArgImpl.this.setCommentRangeStartArray(i, cTMarkupRange);
                    return commentRangeStartArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTCtrlPr getCtrlPr() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTCtrlPr cTCtrlPrFind_element_user = get_store().find_element_user(CTRLPR$92, 0);
                if (cTCtrlPrFind_element_user == null) {
                    return null;
                }
                return cTCtrlPrFind_element_user;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkup getCustomXmlDelRangeEndArray(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTMarkup = (CTMarkup) get_store().find_element_user(CUSTOMXMLDELRANGEEND$70, i);
                if (cTMarkup == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTMarkup> getCustomXmlDelRangeEndList() {
        AbstractList<CTMarkup> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTMarkup>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1CustomXmlDelRangeEndList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfCustomXmlDelRangeEndArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTMarkup cTMarkup) {
                    CTOMathArgImpl.this.insertNewCustomXmlDelRangeEnd(i).set(cTMarkup);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkup get(int i) {
                    return CTOMathArgImpl.this.getCustomXmlDelRangeEndArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkup remove(int i) {
                    CTMarkup customXmlDelRangeEndArray = CTOMathArgImpl.this.getCustomXmlDelRangeEndArray(i);
                    CTOMathArgImpl.this.removeCustomXmlDelRangeEnd(i);
                    return customXmlDelRangeEndArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkup set(int i, CTMarkup cTMarkup) {
                    CTMarkup customXmlDelRangeEndArray = CTOMathArgImpl.this.getCustomXmlDelRangeEndArray(i);
                    CTOMathArgImpl.this.setCustomXmlDelRangeEndArray(i, cTMarkup);
                    return customXmlDelRangeEndArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTTrackChange getCustomXmlDelRangeStartArray(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTrackChange = (CTTrackChange) get_store().find_element_user(CUSTOMXMLDELRANGESTART$68, i);
                if (cTTrackChange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTTrackChange> getCustomXmlDelRangeStartList() {
        AbstractList<CTTrackChange> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTTrackChange>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1CustomXmlDelRangeStartList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfCustomXmlDelRangeStartArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTTrackChange cTTrackChange) {
                    CTOMathArgImpl.this.insertNewCustomXmlDelRangeStart(i).set(cTTrackChange);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTrackChange get(int i) {
                    return CTOMathArgImpl.this.getCustomXmlDelRangeStartArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTrackChange remove(int i) {
                    CTTrackChange customXmlDelRangeStartArray = CTOMathArgImpl.this.getCustomXmlDelRangeStartArray(i);
                    CTOMathArgImpl.this.removeCustomXmlDelRangeStart(i);
                    return customXmlDelRangeStartArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTrackChange set(int i, CTTrackChange cTTrackChange) {
                    CTTrackChange customXmlDelRangeStartArray = CTOMathArgImpl.this.getCustomXmlDelRangeStartArray(i);
                    CTOMathArgImpl.this.setCustomXmlDelRangeStartArray(i, cTTrackChange);
                    return customXmlDelRangeStartArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkup getCustomXmlInsRangeEndArray(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTMarkup = (CTMarkup) get_store().find_element_user(CUSTOMXMLINSRANGEEND$66, i);
                if (cTMarkup == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTMarkup> getCustomXmlInsRangeEndList() {
        AbstractList<CTMarkup> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTMarkup>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1CustomXmlInsRangeEndList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfCustomXmlInsRangeEndArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTMarkup cTMarkup) {
                    CTOMathArgImpl.this.insertNewCustomXmlInsRangeEnd(i).set(cTMarkup);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkup get(int i) {
                    return CTOMathArgImpl.this.getCustomXmlInsRangeEndArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkup remove(int i) {
                    CTMarkup customXmlInsRangeEndArray = CTOMathArgImpl.this.getCustomXmlInsRangeEndArray(i);
                    CTOMathArgImpl.this.removeCustomXmlInsRangeEnd(i);
                    return customXmlInsRangeEndArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkup set(int i, CTMarkup cTMarkup) {
                    CTMarkup customXmlInsRangeEndArray = CTOMathArgImpl.this.getCustomXmlInsRangeEndArray(i);
                    CTOMathArgImpl.this.setCustomXmlInsRangeEndArray(i, cTMarkup);
                    return customXmlInsRangeEndArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTTrackChange getCustomXmlInsRangeStartArray(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTrackChange = (CTTrackChange) get_store().find_element_user(CUSTOMXMLINSRANGESTART$64, i);
                if (cTTrackChange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTTrackChange> getCustomXmlInsRangeStartList() {
        AbstractList<CTTrackChange> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTTrackChange>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1CustomXmlInsRangeStartList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfCustomXmlInsRangeStartArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTTrackChange cTTrackChange) {
                    CTOMathArgImpl.this.insertNewCustomXmlInsRangeStart(i).set(cTTrackChange);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTrackChange get(int i) {
                    return CTOMathArgImpl.this.getCustomXmlInsRangeStartArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTrackChange remove(int i) {
                    CTTrackChange customXmlInsRangeStartArray = CTOMathArgImpl.this.getCustomXmlInsRangeStartArray(i);
                    CTOMathArgImpl.this.removeCustomXmlInsRangeStart(i);
                    return customXmlInsRangeStartArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTrackChange set(int i, CTTrackChange cTTrackChange) {
                    CTTrackChange customXmlInsRangeStartArray = CTOMathArgImpl.this.getCustomXmlInsRangeStartArray(i);
                    CTOMathArgImpl.this.setCustomXmlInsRangeStartArray(i, cTTrackChange);
                    return customXmlInsRangeStartArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkup getCustomXmlMoveFromRangeEndArray(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTMarkup = (CTMarkup) get_store().find_element_user(CUSTOMXMLMOVEFROMRANGEEND$74, i);
                if (cTMarkup == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTMarkup> getCustomXmlMoveFromRangeEndList() {
        AbstractList<CTMarkup> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTMarkup>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1CustomXmlMoveFromRangeEndList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfCustomXmlMoveFromRangeEndArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTMarkup cTMarkup) {
                    CTOMathArgImpl.this.insertNewCustomXmlMoveFromRangeEnd(i).set(cTMarkup);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkup get(int i) {
                    return CTOMathArgImpl.this.getCustomXmlMoveFromRangeEndArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkup remove(int i) {
                    CTMarkup customXmlMoveFromRangeEndArray = CTOMathArgImpl.this.getCustomXmlMoveFromRangeEndArray(i);
                    CTOMathArgImpl.this.removeCustomXmlMoveFromRangeEnd(i);
                    return customXmlMoveFromRangeEndArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkup set(int i, CTMarkup cTMarkup) {
                    CTMarkup customXmlMoveFromRangeEndArray = CTOMathArgImpl.this.getCustomXmlMoveFromRangeEndArray(i);
                    CTOMathArgImpl.this.setCustomXmlMoveFromRangeEndArray(i, cTMarkup);
                    return customXmlMoveFromRangeEndArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTTrackChange getCustomXmlMoveFromRangeStartArray(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTrackChange = (CTTrackChange) get_store().find_element_user(CUSTOMXMLMOVEFROMRANGESTART$72, i);
                if (cTTrackChange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTTrackChange> getCustomXmlMoveFromRangeStartList() {
        AbstractList<CTTrackChange> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTTrackChange>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1CustomXmlMoveFromRangeStartList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfCustomXmlMoveFromRangeStartArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTTrackChange cTTrackChange) {
                    CTOMathArgImpl.this.insertNewCustomXmlMoveFromRangeStart(i).set(cTTrackChange);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTrackChange get(int i) {
                    return CTOMathArgImpl.this.getCustomXmlMoveFromRangeStartArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTrackChange remove(int i) {
                    CTTrackChange customXmlMoveFromRangeStartArray = CTOMathArgImpl.this.getCustomXmlMoveFromRangeStartArray(i);
                    CTOMathArgImpl.this.removeCustomXmlMoveFromRangeStart(i);
                    return customXmlMoveFromRangeStartArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTrackChange set(int i, CTTrackChange cTTrackChange) {
                    CTTrackChange customXmlMoveFromRangeStartArray = CTOMathArgImpl.this.getCustomXmlMoveFromRangeStartArray(i);
                    CTOMathArgImpl.this.setCustomXmlMoveFromRangeStartArray(i, cTTrackChange);
                    return customXmlMoveFromRangeStartArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkup getCustomXmlMoveToRangeEndArray(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTMarkup = (CTMarkup) get_store().find_element_user(CUSTOMXMLMOVETORANGEEND$78, i);
                if (cTMarkup == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTMarkup> getCustomXmlMoveToRangeEndList() {
        AbstractList<CTMarkup> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTMarkup>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1CustomXmlMoveToRangeEndList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfCustomXmlMoveToRangeEndArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTMarkup cTMarkup) {
                    CTOMathArgImpl.this.insertNewCustomXmlMoveToRangeEnd(i).set(cTMarkup);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkup get(int i) {
                    return CTOMathArgImpl.this.getCustomXmlMoveToRangeEndArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkup remove(int i) {
                    CTMarkup customXmlMoveToRangeEndArray = CTOMathArgImpl.this.getCustomXmlMoveToRangeEndArray(i);
                    CTOMathArgImpl.this.removeCustomXmlMoveToRangeEnd(i);
                    return customXmlMoveToRangeEndArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkup set(int i, CTMarkup cTMarkup) {
                    CTMarkup customXmlMoveToRangeEndArray = CTOMathArgImpl.this.getCustomXmlMoveToRangeEndArray(i);
                    CTOMathArgImpl.this.setCustomXmlMoveToRangeEndArray(i, cTMarkup);
                    return customXmlMoveToRangeEndArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTTrackChange getCustomXmlMoveToRangeStartArray(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTrackChange = (CTTrackChange) get_store().find_element_user(CUSTOMXMLMOVETORANGESTART$76, i);
                if (cTTrackChange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTTrackChange> getCustomXmlMoveToRangeStartList() {
        AbstractList<CTTrackChange> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTTrackChange>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1CustomXmlMoveToRangeStartList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfCustomXmlMoveToRangeStartArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTTrackChange cTTrackChange) {
                    CTOMathArgImpl.this.insertNewCustomXmlMoveToRangeStart(i).set(cTTrackChange);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTrackChange get(int i) {
                    return CTOMathArgImpl.this.getCustomXmlMoveToRangeStartArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTrackChange remove(int i) {
                    CTTrackChange customXmlMoveToRangeStartArray = CTOMathArgImpl.this.getCustomXmlMoveToRangeStartArray(i);
                    CTOMathArgImpl.this.removeCustomXmlMoveToRangeStart(i);
                    return customXmlMoveToRangeStartArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTrackChange set(int i, CTTrackChange cTTrackChange) {
                    CTTrackChange customXmlMoveToRangeStartArray = CTOMathArgImpl.this.getCustomXmlMoveToRangeStartArray(i);
                    CTOMathArgImpl.this.setCustomXmlMoveToRangeStartArray(i, cTTrackChange);
                    return customXmlMoveToRangeStartArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTD getDArray(int i) {
        CTD ctdFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                ctdFind_element_user = get_store().find_element_user(D$10, i);
                if (ctdFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return ctdFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTD> getDList() {
        AbstractList<CTD> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTD>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1DList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfDArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTD ctd) {
                    CTOMathArgImpl.this.insertNewD(i).set(ctd);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTD get(int i) {
                    return CTOMathArgImpl.this.getDArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTD remove(int i) {
                    CTD dArray = CTOMathArgImpl.this.getDArray(i);
                    CTOMathArgImpl.this.removeD(i);
                    return dArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTD set(int i, CTD ctd) {
                    CTD dArray = CTOMathArgImpl.this.getDArray(i);
                    CTOMathArgImpl.this.setDArray(i, ctd);
                    return dArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRunTrackChange getDelArray(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTRunTrackChange = (CTRunTrackChange) get_store().find_element_user(DEL$82, i);
                if (cTRunTrackChange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTRunTrackChange> getDelList() {
        AbstractList<CTRunTrackChange> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTRunTrackChange>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1DelList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfDelArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTRunTrackChange cTRunTrackChange) {
                    CTOMathArgImpl.this.insertNewDel(i).set(cTRunTrackChange);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRunTrackChange get(int i) {
                    return CTOMathArgImpl.this.getDelArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRunTrackChange remove(int i) {
                    CTRunTrackChange delArray = CTOMathArgImpl.this.getDelArray(i);
                    CTOMathArgImpl.this.removeDel(i);
                    return delArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRunTrackChange set(int i, CTRunTrackChange cTRunTrackChange) {
                    CTRunTrackChange delArray = CTOMathArgImpl.this.getDelArray(i);
                    CTOMathArgImpl.this.setDelArray(i, cTRunTrackChange);
                    return delArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTEqArr getEqArrArray(int i) {
        CTEqArr cTEqArrFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTEqArrFind_element_user = get_store().find_element_user(EQARR$12, i);
                if (cTEqArrFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTEqArrFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTEqArr> getEqArrList() {
        AbstractList<CTEqArr> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTEqArr>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1EqArrList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfEqArrArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTEqArr cTEqArr) {
                    CTOMathArgImpl.this.insertNewEqArr(i).set(cTEqArr);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTEqArr get(int i) {
                    return CTOMathArgImpl.this.getEqArrArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTEqArr remove(int i) {
                    CTEqArr eqArrArray = CTOMathArgImpl.this.getEqArrArray(i);
                    CTOMathArgImpl.this.removeEqArr(i);
                    return eqArrArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTEqArr set(int i, CTEqArr cTEqArr) {
                    CTEqArr eqArrArray = CTOMathArgImpl.this.getEqArrArray(i);
                    CTOMathArgImpl.this.setEqArrArray(i, cTEqArr);
                    return eqArrArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTF getFArray(int i) {
        CTF ctfFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                ctfFind_element_user = get_store().find_element_user(F$14, i);
                if (ctfFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return ctfFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTF> getFList() {
        AbstractList<CTF> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTF>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1FList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfFArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTF ctf) {
                    CTOMathArgImpl.this.insertNewF(i).set(ctf);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTF get(int i) {
                    return CTOMathArgImpl.this.getFArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTF remove(int i) {
                    CTF fArray = CTOMathArgImpl.this.getFArray(i);
                    CTOMathArgImpl.this.removeF(i);
                    return fArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTF set(int i, CTF ctf) {
                    CTF fArray = CTOMathArgImpl.this.getFArray(i);
                    CTOMathArgImpl.this.setFArray(i, ctf);
                    return fArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTFunc getFuncArray(int i) {
        CTFunc cTFuncFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTFuncFind_element_user = get_store().find_element_user(FUNC$16, i);
                if (cTFuncFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTFuncFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTFunc> getFuncList() {
        AbstractList<CTFunc> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTFunc>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1FuncList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfFuncArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTFunc cTFunc) {
                    CTOMathArgImpl.this.insertNewFunc(i).set(cTFunc);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTFunc get(int i) {
                    return CTOMathArgImpl.this.getFuncArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTFunc remove(int i) {
                    CTFunc funcArray = CTOMathArgImpl.this.getFuncArray(i);
                    CTOMathArgImpl.this.removeFunc(i);
                    return funcArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTFunc set(int i, CTFunc cTFunc) {
                    CTFunc funcArray = CTOMathArgImpl.this.getFuncArray(i);
                    CTOMathArgImpl.this.setFuncArray(i, cTFunc);
                    return funcArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTGroupChr getGroupChrArray(int i) {
        CTGroupChr cTGroupChrFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTGroupChrFind_element_user = get_store().find_element_user(GROUPCHR$18, i);
                if (cTGroupChrFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTGroupChrFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTGroupChr> getGroupChrList() {
        AbstractList<CTGroupChr> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTGroupChr>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1GroupChrList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfGroupChrArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTGroupChr cTGroupChr) {
                    CTOMathArgImpl.this.insertNewGroupChr(i).set(cTGroupChr);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTGroupChr get(int i) {
                    return CTOMathArgImpl.this.getGroupChrArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTGroupChr remove(int i) {
                    CTGroupChr groupChrArray = CTOMathArgImpl.this.getGroupChrArray(i);
                    CTOMathArgImpl.this.removeGroupChr(i);
                    return groupChrArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTGroupChr set(int i, CTGroupChr cTGroupChr) {
                    CTGroupChr groupChrArray = CTOMathArgImpl.this.getGroupChrArray(i);
                    CTOMathArgImpl.this.setGroupChrArray(i, cTGroupChr);
                    return groupChrArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRunTrackChange getInsArray(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTRunTrackChange = (CTRunTrackChange) get_store().find_element_user(INS$80, i);
                if (cTRunTrackChange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTRunTrackChange> getInsList() {
        AbstractList<CTRunTrackChange> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTRunTrackChange>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1InsList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfInsArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTRunTrackChange cTRunTrackChange) {
                    CTOMathArgImpl.this.insertNewIns(i).set(cTRunTrackChange);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRunTrackChange get(int i) {
                    return CTOMathArgImpl.this.getInsArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRunTrackChange remove(int i) {
                    CTRunTrackChange insArray = CTOMathArgImpl.this.getInsArray(i);
                    CTOMathArgImpl.this.removeIns(i);
                    return insArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRunTrackChange set(int i, CTRunTrackChange cTRunTrackChange) {
                    CTRunTrackChange insArray = CTOMathArgImpl.this.getInsArray(i);
                    CTOMathArgImpl.this.setInsArray(i, cTRunTrackChange);
                    return insArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTLimLow getLimLowArray(int i) {
        CTLimLow cTLimLowFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTLimLowFind_element_user = get_store().find_element_user(LIMLOW$20, i);
                if (cTLimLowFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTLimLowFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTLimLow> getLimLowList() {
        AbstractList<CTLimLow> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTLimLow>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1LimLowList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfLimLowArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTLimLow cTLimLow) {
                    CTOMathArgImpl.this.insertNewLimLow(i).set(cTLimLow);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTLimLow get(int i) {
                    return CTOMathArgImpl.this.getLimLowArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTLimLow remove(int i) {
                    CTLimLow limLowArray = CTOMathArgImpl.this.getLimLowArray(i);
                    CTOMathArgImpl.this.removeLimLow(i);
                    return limLowArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTLimLow set(int i, CTLimLow cTLimLow) {
                    CTLimLow limLowArray = CTOMathArgImpl.this.getLimLowArray(i);
                    CTOMathArgImpl.this.setLimLowArray(i, cTLimLow);
                    return limLowArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTLimUpp getLimUppArray(int i) {
        CTLimUpp cTLimUppFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTLimUppFind_element_user = get_store().find_element_user(LIMUPP$22, i);
                if (cTLimUppFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTLimUppFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTLimUpp> getLimUppList() {
        AbstractList<CTLimUpp> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTLimUpp>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1LimUppList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfLimUppArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTLimUpp cTLimUpp) {
                    CTOMathArgImpl.this.insertNewLimUpp(i).set(cTLimUpp);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTLimUpp get(int i) {
                    return CTOMathArgImpl.this.getLimUppArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTLimUpp remove(int i) {
                    CTLimUpp limUppArray = CTOMathArgImpl.this.getLimUppArray(i);
                    CTOMathArgImpl.this.removeLimUpp(i);
                    return limUppArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTLimUpp set(int i, CTLimUpp cTLimUpp) {
                    CTLimUpp limUppArray = CTOMathArgImpl.this.getLimUppArray(i);
                    CTOMathArgImpl.this.setLimUppArray(i, cTLimUpp);
                    return limUppArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTM getMArray(int i) {
        CTM ctmFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                ctmFind_element_user = get_store().find_element_user(M$24, i);
                if (ctmFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return ctmFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTM> getMList() {
        AbstractList<CTM> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTM>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1MList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfMArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTM ctm) {
                    CTOMathArgImpl.this.insertNewM(i).set(ctm);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTM get(int i) {
                    return CTOMathArgImpl.this.getMArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTM remove(int i) {
                    CTM mArray = CTOMathArgImpl.this.getMArray(i);
                    CTOMathArgImpl.this.removeM(i);
                    return mArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTM set(int i, CTM ctm) {
                    CTM mArray = CTOMathArgImpl.this.getMArray(i);
                    CTOMathArgImpl.this.setMArray(i, ctm);
                    return mArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRunTrackChange getMoveFromArray(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTRunTrackChange = (CTRunTrackChange) get_store().find_element_user(MOVEFROM$84, i);
                if (cTRunTrackChange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTRunTrackChange> getMoveFromList() {
        AbstractList<CTRunTrackChange> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTRunTrackChange>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1MoveFromList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfMoveFromArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTRunTrackChange cTRunTrackChange) {
                    CTOMathArgImpl.this.insertNewMoveFrom(i).set(cTRunTrackChange);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRunTrackChange get(int i) {
                    return CTOMathArgImpl.this.getMoveFromArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRunTrackChange remove(int i) {
                    CTRunTrackChange moveFromArray = CTOMathArgImpl.this.getMoveFromArray(i);
                    CTOMathArgImpl.this.removeMoveFrom(i);
                    return moveFromArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRunTrackChange set(int i, CTRunTrackChange cTRunTrackChange) {
                    CTRunTrackChange moveFromArray = CTOMathArgImpl.this.getMoveFromArray(i);
                    CTOMathArgImpl.this.setMoveFromArray(i, cTRunTrackChange);
                    return moveFromArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange getMoveFromRangeEndArray(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTMarkupRange = (CTMarkupRange) get_store().find_element_user(MOVEFROMRANGEEND$54, i);
                if (cTMarkupRange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTMarkupRange> getMoveFromRangeEndList() {
        AbstractList<CTMarkupRange> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTMarkupRange>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1MoveFromRangeEndList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfMoveFromRangeEndArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTMarkupRange cTMarkupRange) {
                    CTOMathArgImpl.this.insertNewMoveFromRangeEnd(i).set(cTMarkupRange);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkupRange get(int i) {
                    return CTOMathArgImpl.this.getMoveFromRangeEndArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkupRange remove(int i) {
                    CTMarkupRange moveFromRangeEndArray = CTOMathArgImpl.this.getMoveFromRangeEndArray(i);
                    CTOMathArgImpl.this.removeMoveFromRangeEnd(i);
                    return moveFromRangeEndArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkupRange set(int i, CTMarkupRange cTMarkupRange) {
                    CTMarkupRange moveFromRangeEndArray = CTOMathArgImpl.this.getMoveFromRangeEndArray(i);
                    CTOMathArgImpl.this.setMoveFromRangeEndArray(i, cTMarkupRange);
                    return moveFromRangeEndArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMoveBookmark getMoveFromRangeStartArray(int i) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTMoveBookmark = (CTMoveBookmark) get_store().find_element_user(MOVEFROMRANGESTART$52, i);
                if (cTMoveBookmark == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTMoveBookmark> getMoveFromRangeStartList() {
        AbstractList<CTMoveBookmark> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTMoveBookmark>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1MoveFromRangeStartList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfMoveFromRangeStartArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTMoveBookmark cTMoveBookmark) {
                    CTOMathArgImpl.this.insertNewMoveFromRangeStart(i).set(cTMoveBookmark);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMoveBookmark get(int i) {
                    return CTOMathArgImpl.this.getMoveFromRangeStartArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMoveBookmark remove(int i) {
                    CTMoveBookmark moveFromRangeStartArray = CTOMathArgImpl.this.getMoveFromRangeStartArray(i);
                    CTOMathArgImpl.this.removeMoveFromRangeStart(i);
                    return moveFromRangeStartArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMoveBookmark set(int i, CTMoveBookmark cTMoveBookmark) {
                    CTMoveBookmark moveFromRangeStartArray = CTOMathArgImpl.this.getMoveFromRangeStartArray(i);
                    CTOMathArgImpl.this.setMoveFromRangeStartArray(i, cTMoveBookmark);
                    return moveFromRangeStartArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRunTrackChange getMoveToArray(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTRunTrackChange = (CTRunTrackChange) get_store().find_element_user(MOVETO$86, i);
                if (cTRunTrackChange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTRunTrackChange> getMoveToList() {
        AbstractList<CTRunTrackChange> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTRunTrackChange>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1MoveToList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfMoveToArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTRunTrackChange cTRunTrackChange) {
                    CTOMathArgImpl.this.insertNewMoveTo(i).set(cTRunTrackChange);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRunTrackChange get(int i) {
                    return CTOMathArgImpl.this.getMoveToArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRunTrackChange remove(int i) {
                    CTRunTrackChange moveToArray = CTOMathArgImpl.this.getMoveToArray(i);
                    CTOMathArgImpl.this.removeMoveTo(i);
                    return moveToArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRunTrackChange set(int i, CTRunTrackChange cTRunTrackChange) {
                    CTRunTrackChange moveToArray = CTOMathArgImpl.this.getMoveToArray(i);
                    CTOMathArgImpl.this.setMoveToArray(i, cTRunTrackChange);
                    return moveToArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange getMoveToRangeEndArray(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTMarkupRange = (CTMarkupRange) get_store().find_element_user(MOVETORANGEEND$58, i);
                if (cTMarkupRange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTMarkupRange> getMoveToRangeEndList() {
        AbstractList<CTMarkupRange> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTMarkupRange>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1MoveToRangeEndList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfMoveToRangeEndArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTMarkupRange cTMarkupRange) {
                    CTOMathArgImpl.this.insertNewMoveToRangeEnd(i).set(cTMarkupRange);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkupRange get(int i) {
                    return CTOMathArgImpl.this.getMoveToRangeEndArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkupRange remove(int i) {
                    CTMarkupRange moveToRangeEndArray = CTOMathArgImpl.this.getMoveToRangeEndArray(i);
                    CTOMathArgImpl.this.removeMoveToRangeEnd(i);
                    return moveToRangeEndArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkupRange set(int i, CTMarkupRange cTMarkupRange) {
                    CTMarkupRange moveToRangeEndArray = CTOMathArgImpl.this.getMoveToRangeEndArray(i);
                    CTOMathArgImpl.this.setMoveToRangeEndArray(i, cTMarkupRange);
                    return moveToRangeEndArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMoveBookmark getMoveToRangeStartArray(int i) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTMoveBookmark = (CTMoveBookmark) get_store().find_element_user(MOVETORANGESTART$56, i);
                if (cTMoveBookmark == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTMoveBookmark> getMoveToRangeStartList() {
        AbstractList<CTMoveBookmark> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTMoveBookmark>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1MoveToRangeStartList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfMoveToRangeStartArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTMoveBookmark cTMoveBookmark) {
                    CTOMathArgImpl.this.insertNewMoveToRangeStart(i).set(cTMoveBookmark);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMoveBookmark get(int i) {
                    return CTOMathArgImpl.this.getMoveToRangeStartArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMoveBookmark remove(int i) {
                    CTMoveBookmark moveToRangeStartArray = CTOMathArgImpl.this.getMoveToRangeStartArray(i);
                    CTOMathArgImpl.this.removeMoveToRangeStart(i);
                    return moveToRangeStartArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMoveBookmark set(int i, CTMoveBookmark cTMoveBookmark) {
                    CTMoveBookmark moveToRangeStartArray = CTOMathArgImpl.this.getMoveToRangeStartArray(i);
                    CTOMathArgImpl.this.setMoveToRangeStartArray(i, cTMoveBookmark);
                    return moveToRangeStartArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTNary getNaryArray(int i) {
        CTNary cTNaryFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTNaryFind_element_user = get_store().find_element_user(NARY$26, i);
                if (cTNaryFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTNaryFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTNary> getNaryList() {
        AbstractList<CTNary> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTNary>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1NaryList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfNaryArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTNary cTNary) {
                    CTOMathArgImpl.this.insertNewNary(i).set(cTNary);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTNary get(int i) {
                    return CTOMathArgImpl.this.getNaryArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTNary remove(int i) {
                    CTNary naryArray = CTOMathArgImpl.this.getNaryArray(i);
                    CTOMathArgImpl.this.removeNary(i);
                    return naryArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTNary set(int i, CTNary cTNary) {
                    CTNary naryArray = CTOMathArgImpl.this.getNaryArray(i);
                    CTOMathArgImpl.this.setNaryArray(i, cTNary);
                    return naryArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTOMath getOMathArray(int i) {
        CTOMath cTOMath;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTOMath = (CTOMath) get_store().find_element_user(OMATH$90, i);
                if (cTOMath == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTOMath;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTOMath> getOMathList() {
        AbstractList<CTOMath> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTOMath>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1OMathList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfOMathArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTOMath cTOMath) {
                    CTOMathArgImpl.this.insertNewOMath(i).set(cTOMath);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTOMath get(int i) {
                    return CTOMathArgImpl.this.getOMathArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTOMath remove(int i) {
                    CTOMath oMathArray = CTOMathArgImpl.this.getOMathArray(i);
                    CTOMathArgImpl.this.removeOMath(i);
                    return oMathArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTOMath set(int i, CTOMath cTOMath) {
                    CTOMath oMathArray = CTOMathArgImpl.this.getOMathArray(i);
                    CTOMathArgImpl.this.setOMathArray(i, cTOMath);
                    return oMathArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTOMathPara getOMathParaArray(int i) {
        CTOMathPara cTOMathPara;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTOMathPara = (CTOMathPara) get_store().find_element_user(OMATHPARA$88, i);
                if (cTOMathPara == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTOMathPara;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTOMathPara> getOMathParaList() {
        AbstractList<CTOMathPara> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTOMathPara>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1OMathParaList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfOMathParaArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTOMathPara cTOMathPara) {
                    CTOMathArgImpl.this.insertNewOMathPara(i).set(cTOMathPara);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTOMathPara get(int i) {
                    return CTOMathArgImpl.this.getOMathParaArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTOMathPara remove(int i) {
                    CTOMathPara oMathParaArray = CTOMathArgImpl.this.getOMathParaArray(i);
                    CTOMathArgImpl.this.removeOMathPara(i);
                    return oMathParaArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTOMathPara set(int i, CTOMathPara cTOMathPara) {
                    CTOMathPara oMathParaArray = CTOMathArgImpl.this.getOMathParaArray(i);
                    CTOMathArgImpl.this.setOMathParaArray(i, cTOMathPara);
                    return oMathParaArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTPerm getPermEndArray(int i) {
        CTPerm cTPermFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTPermFind_element_user = get_store().find_element_user(PERMEND$46, i);
                if (cTPermFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTPermFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTPerm> getPermEndList() {
        AbstractList<CTPerm> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTPerm>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1PermEndList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfPermEndArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTPerm cTPerm) {
                    CTOMathArgImpl.this.insertNewPermEnd(i).set(cTPerm);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTPerm get(int i) {
                    return CTOMathArgImpl.this.getPermEndArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTPerm remove(int i) {
                    CTPerm permEndArray = CTOMathArgImpl.this.getPermEndArray(i);
                    CTOMathArgImpl.this.removePermEnd(i);
                    return permEndArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTPerm set(int i, CTPerm cTPerm) {
                    CTPerm permEndArray = CTOMathArgImpl.this.getPermEndArray(i);
                    CTOMathArgImpl.this.setPermEndArray(i, cTPerm);
                    return permEndArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTPermStart getPermStartArray(int i) {
        CTPermStart cTPermStartFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTPermStartFind_element_user = get_store().find_element_user(PERMSTART$44, i);
                if (cTPermStartFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTPermStartFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTPermStart> getPermStartList() {
        AbstractList<CTPermStart> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTPermStart>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1PermStartList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfPermStartArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTPermStart cTPermStart) {
                    CTOMathArgImpl.this.insertNewPermStart(i).set(cTPermStart);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTPermStart get(int i) {
                    return CTOMathArgImpl.this.getPermStartArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTPermStart remove(int i) {
                    CTPermStart permStartArray = CTOMathArgImpl.this.getPermStartArray(i);
                    CTOMathArgImpl.this.removePermStart(i);
                    return permStartArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTPermStart set(int i, CTPermStart cTPermStart) {
                    CTPermStart permStartArray = CTOMathArgImpl.this.getPermStartArray(i);
                    CTOMathArgImpl.this.setPermStartArray(i, cTPermStart);
                    return permStartArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTPhant getPhantArray(int i) {
        CTPhant cTPhantFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTPhantFind_element_user = get_store().find_element_user(PHANT$28, i);
                if (cTPhantFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTPhantFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTPhant> getPhantList() {
        AbstractList<CTPhant> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTPhant>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1PhantList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfPhantArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTPhant cTPhant) {
                    CTOMathArgImpl.this.insertNewPhant(i).set(cTPhant);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTPhant get(int i) {
                    return CTOMathArgImpl.this.getPhantArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTPhant remove(int i) {
                    CTPhant phantArray = CTOMathArgImpl.this.getPhantArray(i);
                    CTOMathArgImpl.this.removePhant(i);
                    return phantArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTPhant set(int i, CTPhant cTPhant) {
                    CTPhant phantArray = CTOMathArgImpl.this.getPhantArray(i);
                    CTOMathArgImpl.this.setPhantArray(i, cTPhant);
                    return phantArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTProofErr getProofErrArray(int i) {
        CTProofErr cTProofErrFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTProofErrFind_element_user = get_store().find_element_user(PROOFERR$42, i);
                if (cTProofErrFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTProofErrFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTProofErr> getProofErrList() {
        1ProofErrList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1ProofErrList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTR getRArray(int i) {
        CTR ctrFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                ctrFind_element_user = get_store().find_element_user(R$40, i);
                if (ctrFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return ctrFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTR> getRList() {
        AbstractList<CTR> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTR>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1RList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfRArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTR ctr) {
                    CTOMathArgImpl.this.insertNewR(i).set(ctr);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTR get(int i) {
                    return CTOMathArgImpl.this.getRArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTR remove(int i) {
                    CTR rArray = CTOMathArgImpl.this.getRArray(i);
                    CTOMathArgImpl.this.removeR(i);
                    return rArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTR set(int i, CTR ctr) {
                    CTR rArray = CTOMathArgImpl.this.getRArray(i);
                    CTOMathArgImpl.this.setRArray(i, ctr);
                    return rArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRad getRadArray(int i) {
        CTRad cTRadFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTRadFind_element_user = get_store().find_element_user(RAD$30, i);
                if (cTRadFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTRadFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTRad> getRadList() {
        AbstractList<CTRad> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTRad>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1RadList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfRadArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTRad cTRad) {
                    CTOMathArgImpl.this.insertNewRad(i).set(cTRad);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRad get(int i) {
                    return CTOMathArgImpl.this.getRadArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRad remove(int i) {
                    CTRad radArray = CTOMathArgImpl.this.getRadArray(i);
                    CTOMathArgImpl.this.removeRad(i);
                    return radArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRad set(int i, CTRad cTRad) {
                    CTRad radArray = CTOMathArgImpl.this.getRadArray(i);
                    CTOMathArgImpl.this.setRadArray(i, cTRad);
                    return radArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSPre getSPreArray(int i) {
        CTSPre cTSPreFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTSPreFind_element_user = get_store().find_element_user(SPRE$32, i);
                if (cTSPreFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTSPreFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTSPre> getSPreList() {
        AbstractList<CTSPre> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTSPre>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1SPreList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfSPreArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTSPre cTSPre) {
                    CTOMathArgImpl.this.insertNewSPre(i).set(cTSPre);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSPre get(int i) {
                    return CTOMathArgImpl.this.getSPreArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSPre remove(int i) {
                    CTSPre sPreArray = CTOMathArgImpl.this.getSPreArray(i);
                    CTOMathArgImpl.this.removeSPre(i);
                    return sPreArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSPre set(int i, CTSPre cTSPre) {
                    CTSPre sPreArray = CTOMathArgImpl.this.getSPreArray(i);
                    CTOMathArgImpl.this.setSPreArray(i, cTSPre);
                    return sPreArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSSub getSSubArray(int i) {
        CTSSub cTSSubFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTSSubFind_element_user = get_store().find_element_user(SSUB$34, i);
                if (cTSSubFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTSSubFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTSSub> getSSubList() {
        AbstractList<CTSSub> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTSSub>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1SSubList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfSSubArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTSSub cTSSub) {
                    CTOMathArgImpl.this.insertNewSSub(i).set(cTSSub);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSSub get(int i) {
                    return CTOMathArgImpl.this.getSSubArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSSub remove(int i) {
                    CTSSub sSubArray = CTOMathArgImpl.this.getSSubArray(i);
                    CTOMathArgImpl.this.removeSSub(i);
                    return sSubArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSSub set(int i, CTSSub cTSSub) {
                    CTSSub sSubArray = CTOMathArgImpl.this.getSSubArray(i);
                    CTOMathArgImpl.this.setSSubArray(i, cTSSub);
                    return sSubArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSSubSup getSSubSupArray(int i) {
        CTSSubSup cTSSubSupFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTSSubSupFind_element_user = get_store().find_element_user(SSUBSUP$36, i);
                if (cTSSubSupFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTSSubSupFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTSSubSup> getSSubSupList() {
        AbstractList<CTSSubSup> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTSSubSup>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1SSubSupList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfSSubSupArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTSSubSup cTSSubSup) {
                    CTOMathArgImpl.this.insertNewSSubSup(i).set(cTSSubSup);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSSubSup get(int i) {
                    return CTOMathArgImpl.this.getSSubSupArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSSubSup remove(int i) {
                    CTSSubSup sSubSupArray = CTOMathArgImpl.this.getSSubSupArray(i);
                    CTOMathArgImpl.this.removeSSubSup(i);
                    return sSubSupArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSSubSup set(int i, CTSSubSup cTSSubSup) {
                    CTSSubSup sSubSupArray = CTOMathArgImpl.this.getSSubSupArray(i);
                    CTOMathArgImpl.this.setSSubSupArray(i, cTSSubSup);
                    return sSubSupArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSSup getSSupArray(int i) {
        CTSSup cTSSupFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTSSupFind_element_user = get_store().find_element_user(SSUP$38, i);
                if (cTSSupFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTSSupFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public List<CTSSup> getSSupList() {
        AbstractList<CTSSup> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTSSup>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathArgImpl.1SSupList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathArgImpl.this.sizeOfSSupArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTSSup cTSSup) {
                    CTOMathArgImpl.this.insertNewSSup(i).set(cTSSup);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSSup get(int i) {
                    return CTOMathArgImpl.this.getSSupArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSSup remove(int i) {
                    CTSSup sSupArray = CTOMathArgImpl.this.getSSupArray(i);
                    CTOMathArgImpl.this.removeSSup(i);
                    return sSupArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSSup set(int i, CTSSup cTSSup) {
                    CTSSup sSupArray = CTOMathArgImpl.this.getSSupArray(i);
                    CTOMathArgImpl.this.setSSupArray(i, cTSSup);
                    return sSupArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTAcc insertNewAcc(int i) {
        CTAcc cTAccInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAccInsert_element_user = get_store().insert_element_user(ACC$2, i);
        }
        return cTAccInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTBar insertNewBar(int i) {
        CTBar cTBarInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBarInsert_element_user = get_store().insert_element_user(BAR$4, i);
        }
        return cTBarInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange insertNewBookmarkEnd(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(BOOKMARKEND$50, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTBookmark insertNewBookmarkStart(int i) {
        CTBookmark cTBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmark = (CTBookmark) get_store().insert_element_user(BOOKMARKSTART$48, i);
        }
        return cTBookmark;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTBorderBox insertNewBorderBox(int i) {
        CTBorderBox cTBorderBoxInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderBoxInsert_element_user = get_store().insert_element_user(BORDERBOX$8, i);
        }
        return cTBorderBoxInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTBox insertNewBox(int i) {
        CTBox cTBoxInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBoxInsert_element_user = get_store().insert_element_user(BOX$6, i);
        }
        return cTBoxInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange insertNewCommentRangeEnd(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(COMMENTRANGEEND$62, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange insertNewCommentRangeStart(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(COMMENTRANGESTART$60, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkup insertNewCustomXmlDelRangeEnd(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(CUSTOMXMLDELRANGEEND$70, i);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTTrackChange insertNewCustomXmlDelRangeStart(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(CUSTOMXMLDELRANGESTART$68, i);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkup insertNewCustomXmlInsRangeEnd(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(CUSTOMXMLINSRANGEEND$66, i);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTTrackChange insertNewCustomXmlInsRangeStart(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(CUSTOMXMLINSRANGESTART$64, i);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkup insertNewCustomXmlMoveFromRangeEnd(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(CUSTOMXMLMOVEFROMRANGEEND$74, i);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTTrackChange insertNewCustomXmlMoveFromRangeStart(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(CUSTOMXMLMOVEFROMRANGESTART$72, i);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkup insertNewCustomXmlMoveToRangeEnd(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(CUSTOMXMLMOVETORANGEEND$78, i);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTTrackChange insertNewCustomXmlMoveToRangeStart(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(CUSTOMXMLMOVETORANGESTART$76, i);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTD insertNewD(int i) {
        CTD ctdInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctdInsert_element_user = get_store().insert_element_user(D$10, i);
        }
        return ctdInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRunTrackChange insertNewDel(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(DEL$82, i);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTEqArr insertNewEqArr(int i) {
        CTEqArr cTEqArrInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEqArrInsert_element_user = get_store().insert_element_user(EQARR$12, i);
        }
        return cTEqArrInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTF insertNewF(int i) {
        CTF ctfInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctfInsert_element_user = get_store().insert_element_user(F$14, i);
        }
        return ctfInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTFunc insertNewFunc(int i) {
        CTFunc cTFuncInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFuncInsert_element_user = get_store().insert_element_user(FUNC$16, i);
        }
        return cTFuncInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTGroupChr insertNewGroupChr(int i) {
        CTGroupChr cTGroupChrInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupChrInsert_element_user = get_store().insert_element_user(GROUPCHR$18, i);
        }
        return cTGroupChrInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRunTrackChange insertNewIns(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(INS$80, i);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTLimLow insertNewLimLow(int i) {
        CTLimLow cTLimLowInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLimLowInsert_element_user = get_store().insert_element_user(LIMLOW$20, i);
        }
        return cTLimLowInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTLimUpp insertNewLimUpp(int i) {
        CTLimUpp cTLimUppInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLimUppInsert_element_user = get_store().insert_element_user(LIMUPP$22, i);
        }
        return cTLimUppInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTM insertNewM(int i) {
        CTM ctmInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctmInsert_element_user = get_store().insert_element_user(M$24, i);
        }
        return ctmInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRunTrackChange insertNewMoveFrom(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(MOVEFROM$84, i);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange insertNewMoveFromRangeEnd(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(MOVEFROMRANGEEND$54, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMoveBookmark insertNewMoveFromRangeStart(int i) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().insert_element_user(MOVEFROMRANGESTART$52, i);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRunTrackChange insertNewMoveTo(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(MOVETO$86, i);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange insertNewMoveToRangeEnd(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(MOVETORANGEEND$58, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMoveBookmark insertNewMoveToRangeStart(int i) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().insert_element_user(MOVETORANGESTART$56, i);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTNary insertNewNary(int i) {
        CTNary cTNaryInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTNaryInsert_element_user = get_store().insert_element_user(NARY$26, i);
        }
        return cTNaryInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTOMath insertNewOMath(int i) {
        CTOMath cTOMath;
        synchronized (monitor()) {
            check_orphaned();
            cTOMath = (CTOMath) get_store().insert_element_user(OMATH$90, i);
        }
        return cTOMath;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTOMathPara insertNewOMathPara(int i) {
        CTOMathPara cTOMathPara;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathPara = (CTOMathPara) get_store().insert_element_user(OMATHPARA$88, i);
        }
        return cTOMathPara;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTPerm insertNewPermEnd(int i) {
        CTPerm cTPermInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPermInsert_element_user = get_store().insert_element_user(PERMEND$46, i);
        }
        return cTPermInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTPermStart insertNewPermStart(int i) {
        CTPermStart cTPermStartInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPermStartInsert_element_user = get_store().insert_element_user(PERMSTART$44, i);
        }
        return cTPermStartInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTPhant insertNewPhant(int i) {
        CTPhant cTPhantInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPhantInsert_element_user = get_store().insert_element_user(PHANT$28, i);
        }
        return cTPhantInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTProofErr insertNewProofErr(int i) {
        CTProofErr cTProofErrInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErrInsert_element_user = get_store().insert_element_user(PROOFERR$42, i);
        }
        return cTProofErrInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTR insertNewR(int i) {
        CTR ctrInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctrInsert_element_user = get_store().insert_element_user(R$40, i);
        }
        return ctrInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRad insertNewRad(int i) {
        CTRad cTRadInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRadInsert_element_user = get_store().insert_element_user(RAD$30, i);
        }
        return cTRadInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSPre insertNewSPre(int i) {
        CTSPre cTSPreInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSPreInsert_element_user = get_store().insert_element_user(SPRE$32, i);
        }
        return cTSPreInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSSub insertNewSSub(int i) {
        CTSSub cTSSubInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSSubInsert_element_user = get_store().insert_element_user(SSUB$34, i);
        }
        return cTSSubInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSSubSup insertNewSSubSup(int i) {
        CTSSubSup cTSSubSupInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSSubSupInsert_element_user = get_store().insert_element_user(SSUBSUP$36, i);
        }
        return cTSSubSupInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSSup insertNewSSup(int i) {
        CTSSup cTSSupInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSSupInsert_element_user = get_store().insert_element_user(SSUP$38, i);
        }
        return cTSSupInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public boolean isSetArgPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ARGPR$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public boolean isSetCtrlPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CTRLPR$92) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeAcc(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ACC$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeBar(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BAR$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeBookmarkEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOOKMARKEND$50, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeBookmarkStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOOKMARKSTART$48, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeBorderBox(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERBOX$8, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeBox(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOX$6, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeCommentRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMMENTRANGEEND$62, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeCommentRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMMENTRANGESTART$60, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeCustomXmlDelRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLDELRANGEEND$70, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeCustomXmlDelRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLDELRANGESTART$68, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeCustomXmlInsRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLINSRANGEEND$66, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeCustomXmlInsRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLINSRANGESTART$64, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeCustomXmlMoveFromRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVEFROMRANGEEND$74, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeCustomXmlMoveFromRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVEFROMRANGESTART$72, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeCustomXmlMoveToRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVETORANGEEND$78, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeCustomXmlMoveToRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVETORANGESTART$76, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeD(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(D$10, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeDel(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DEL$82, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeEqArr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EQARR$12, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeF(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(F$14, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeFunc(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FUNC$16, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeGroupChr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GROUPCHR$18, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeIns(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(INS$80, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeLimLow(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LIMLOW$20, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeLimUpp(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LIMUPP$22, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeM(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(M$24, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeMoveFrom(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROM$84, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeMoveFromRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROMRANGEEND$54, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeMoveFromRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROMRANGESTART$52, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeMoveTo(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETO$86, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeMoveToRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETORANGEEND$58, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeMoveToRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETORANGESTART$56, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeNary(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NARY$26, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeOMath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OMATH$90, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeOMathPara(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OMATHPARA$88, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removePermEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PERMEND$46, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removePermStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PERMSTART$44, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removePhant(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PHANT$28, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeProofErr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROOFERR$42, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeR(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(R$40, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeRad(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RAD$30, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeSPre(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SPRE$32, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeSSub(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SSUB$34, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeSSubSup(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SSUBSUP$36, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void removeSSup(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SSUP$38, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setAccArray(int i, CTAcc cTAcc) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTAcc cTAccFind_element_user = get_store().find_element_user(ACC$2, i);
                if (cTAccFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTAccFind_element_user.set(cTAcc);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setArgPr(CTOMathArgPr cTOMathArgPr) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ARGPR$0;
                CTOMathArgPr cTOMathArgPr2 = (CTOMathArgPr) typeStore.find_element_user(qName, 0);
                if (cTOMathArgPr2 == null) {
                    cTOMathArgPr2 = (CTOMathArgPr) get_store().add_element_user(qName);
                }
                cTOMathArgPr2.set(cTOMathArgPr);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setBarArray(int i, CTBar cTBar) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTBar cTBarFind_element_user = get_store().find_element_user(BAR$4, i);
                if (cTBarFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTBarFind_element_user.set(cTBar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setBookmarkEndArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTMarkupRange cTMarkupRange2 = (CTMarkupRange) get_store().find_element_user(BOOKMARKEND$50, i);
                if (cTMarkupRange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTMarkupRange2.set(cTMarkupRange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setBookmarkStartArray(int i, CTBookmark cTBookmark) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTBookmark cTBookmark2 = (CTBookmark) get_store().find_element_user(BOOKMARKSTART$48, i);
                if (cTBookmark2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTBookmark2.set(cTBookmark);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setBorderBoxArray(int i, CTBorderBox cTBorderBox) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTBorderBox cTBorderBoxFind_element_user = get_store().find_element_user(BORDERBOX$8, i);
                if (cTBorderBoxFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTBorderBoxFind_element_user.set(cTBorderBox);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setBoxArray(int i, CTBox cTBox) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTBox cTBoxFind_element_user = get_store().find_element_user(BOX$6, i);
                if (cTBoxFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTBoxFind_element_user.set(cTBox);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCommentRangeEndArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTMarkupRange cTMarkupRange2 = (CTMarkupRange) get_store().find_element_user(COMMENTRANGEEND$62, i);
                if (cTMarkupRange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTMarkupRange2.set(cTMarkupRange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCommentRangeStartArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTMarkupRange cTMarkupRange2 = (CTMarkupRange) get_store().find_element_user(COMMENTRANGESTART$60, i);
                if (cTMarkupRange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTMarkupRange2.set(cTMarkupRange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCtrlPr(CTCtrlPr cTCtrlPr) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = CTRLPR$92;
                CTCtrlPr cTCtrlPrFind_element_user = typeStore.find_element_user(qName, 0);
                if (cTCtrlPrFind_element_user == null) {
                    cTCtrlPrFind_element_user = (CTCtrlPr) get_store().add_element_user(qName);
                }
                cTCtrlPrFind_element_user.set(cTCtrlPr);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCustomXmlDelRangeEndArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTMarkup cTMarkup2 = (CTMarkup) get_store().find_element_user(CUSTOMXMLDELRANGEEND$70, i);
                if (cTMarkup2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTMarkup2.set(cTMarkup);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCustomXmlDelRangeStartArray(int i, CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTrackChange cTTrackChange2 = (CTTrackChange) get_store().find_element_user(CUSTOMXMLDELRANGESTART$68, i);
                if (cTTrackChange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTTrackChange2.set(cTTrackChange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCustomXmlInsRangeEndArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTMarkup cTMarkup2 = (CTMarkup) get_store().find_element_user(CUSTOMXMLINSRANGEEND$66, i);
                if (cTMarkup2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTMarkup2.set(cTMarkup);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCustomXmlInsRangeStartArray(int i, CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTrackChange cTTrackChange2 = (CTTrackChange) get_store().find_element_user(CUSTOMXMLINSRANGESTART$64, i);
                if (cTTrackChange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTTrackChange2.set(cTTrackChange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCustomXmlMoveFromRangeEndArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTMarkup cTMarkup2 = (CTMarkup) get_store().find_element_user(CUSTOMXMLMOVEFROMRANGEEND$74, i);
                if (cTMarkup2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTMarkup2.set(cTMarkup);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCustomXmlMoveFromRangeStartArray(int i, CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTrackChange cTTrackChange2 = (CTTrackChange) get_store().find_element_user(CUSTOMXMLMOVEFROMRANGESTART$72, i);
                if (cTTrackChange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTTrackChange2.set(cTTrackChange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCustomXmlMoveToRangeEndArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTMarkup cTMarkup2 = (CTMarkup) get_store().find_element_user(CUSTOMXMLMOVETORANGEEND$78, i);
                if (cTMarkup2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTMarkup2.set(cTMarkup);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCustomXmlMoveToRangeStartArray(int i, CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTrackChange cTTrackChange2 = (CTTrackChange) get_store().find_element_user(CUSTOMXMLMOVETORANGESTART$76, i);
                if (cTTrackChange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTTrackChange2.set(cTTrackChange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setDArray(int i, CTD ctd) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTD ctdFind_element_user = get_store().find_element_user(D$10, i);
                if (ctdFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                ctdFind_element_user.set(ctd);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setDelArray(int i, CTRunTrackChange cTRunTrackChange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTRunTrackChange cTRunTrackChange2 = (CTRunTrackChange) get_store().find_element_user(DEL$82, i);
                if (cTRunTrackChange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTRunTrackChange2.set(cTRunTrackChange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setEqArrArray(int i, CTEqArr cTEqArr) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTEqArr cTEqArrFind_element_user = get_store().find_element_user(EQARR$12, i);
                if (cTEqArrFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTEqArrFind_element_user.set(cTEqArr);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setFArray(int i, CTF ctf) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTF ctfFind_element_user = get_store().find_element_user(F$14, i);
                if (ctfFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                ctfFind_element_user.set(ctf);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setFuncArray(int i, CTFunc cTFunc) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTFunc cTFuncFind_element_user = get_store().find_element_user(FUNC$16, i);
                if (cTFuncFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTFuncFind_element_user.set(cTFunc);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setGroupChrArray(int i, CTGroupChr cTGroupChr) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTGroupChr cTGroupChrFind_element_user = get_store().find_element_user(GROUPCHR$18, i);
                if (cTGroupChrFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTGroupChrFind_element_user.set(cTGroupChr);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setInsArray(int i, CTRunTrackChange cTRunTrackChange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTRunTrackChange cTRunTrackChange2 = (CTRunTrackChange) get_store().find_element_user(INS$80, i);
                if (cTRunTrackChange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTRunTrackChange2.set(cTRunTrackChange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setLimLowArray(int i, CTLimLow cTLimLow) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTLimLow cTLimLowFind_element_user = get_store().find_element_user(LIMLOW$20, i);
                if (cTLimLowFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTLimLowFind_element_user.set(cTLimLow);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setLimUppArray(int i, CTLimUpp cTLimUpp) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTLimUpp cTLimUppFind_element_user = get_store().find_element_user(LIMUPP$22, i);
                if (cTLimUppFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTLimUppFind_element_user.set(cTLimUpp);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setMArray(int i, CTM ctm) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTM ctmFind_element_user = get_store().find_element_user(M$24, i);
                if (ctmFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                ctmFind_element_user.set(ctm);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setMoveFromArray(int i, CTRunTrackChange cTRunTrackChange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTRunTrackChange cTRunTrackChange2 = (CTRunTrackChange) get_store().find_element_user(MOVEFROM$84, i);
                if (cTRunTrackChange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTRunTrackChange2.set(cTRunTrackChange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setMoveFromRangeEndArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTMarkupRange cTMarkupRange2 = (CTMarkupRange) get_store().find_element_user(MOVEFROMRANGEEND$54, i);
                if (cTMarkupRange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTMarkupRange2.set(cTMarkupRange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setMoveFromRangeStartArray(int i, CTMoveBookmark cTMoveBookmark) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTMoveBookmark cTMoveBookmark2 = (CTMoveBookmark) get_store().find_element_user(MOVEFROMRANGESTART$52, i);
                if (cTMoveBookmark2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTMoveBookmark2.set(cTMoveBookmark);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setMoveToArray(int i, CTRunTrackChange cTRunTrackChange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTRunTrackChange cTRunTrackChange2 = (CTRunTrackChange) get_store().find_element_user(MOVETO$86, i);
                if (cTRunTrackChange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTRunTrackChange2.set(cTRunTrackChange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setMoveToRangeEndArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTMarkupRange cTMarkupRange2 = (CTMarkupRange) get_store().find_element_user(MOVETORANGEEND$58, i);
                if (cTMarkupRange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTMarkupRange2.set(cTMarkupRange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setMoveToRangeStartArray(int i, CTMoveBookmark cTMoveBookmark) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTMoveBookmark cTMoveBookmark2 = (CTMoveBookmark) get_store().find_element_user(MOVETORANGESTART$56, i);
                if (cTMoveBookmark2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTMoveBookmark2.set(cTMoveBookmark);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setNaryArray(int i, CTNary cTNary) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTNary cTNaryFind_element_user = get_store().find_element_user(NARY$26, i);
                if (cTNaryFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTNaryFind_element_user.set(cTNary);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setOMathArray(int i, CTOMath cTOMath) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTOMath cTOMath2 = (CTOMath) get_store().find_element_user(OMATH$90, i);
                if (cTOMath2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTOMath2.set(cTOMath);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setOMathParaArray(int i, CTOMathPara cTOMathPara) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTOMathPara cTOMathPara2 = (CTOMathPara) get_store().find_element_user(OMATHPARA$88, i);
                if (cTOMathPara2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTOMathPara2.set(cTOMathPara);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setPermEndArray(int i, CTPerm cTPerm) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTPerm cTPermFind_element_user = get_store().find_element_user(PERMEND$46, i);
                if (cTPermFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTPermFind_element_user.set(cTPerm);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setPermStartArray(int i, CTPermStart cTPermStart) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTPermStart cTPermStartFind_element_user = get_store().find_element_user(PERMSTART$44, i);
                if (cTPermStartFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTPermStartFind_element_user.set(cTPermStart);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setPhantArray(int i, CTPhant cTPhant) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTPhant cTPhantFind_element_user = get_store().find_element_user(PHANT$28, i);
                if (cTPhantFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTPhantFind_element_user.set(cTPhant);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setProofErrArray(int i, CTProofErr cTProofErr) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTProofErr cTProofErrFind_element_user = get_store().find_element_user(PROOFERR$42, i);
                if (cTProofErrFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTProofErrFind_element_user.set(cTProofErr);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setRArray(int i, CTR ctr) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTR ctrFind_element_user = get_store().find_element_user(R$40, i);
                if (ctrFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                ctrFind_element_user.set(ctr);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setRadArray(int i, CTRad cTRad) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTRad cTRadFind_element_user = get_store().find_element_user(RAD$30, i);
                if (cTRadFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTRadFind_element_user.set(cTRad);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setSPreArray(int i, CTSPre cTSPre) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTSPre cTSPreFind_element_user = get_store().find_element_user(SPRE$32, i);
                if (cTSPreFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTSPreFind_element_user.set(cTSPre);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setSSubArray(int i, CTSSub cTSSub) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTSSub cTSSubFind_element_user = get_store().find_element_user(SSUB$34, i);
                if (cTSSubFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTSSubFind_element_user.set(cTSSub);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setSSubSupArray(int i, CTSSubSup cTSSubSup) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTSSubSup cTSSubSupFind_element_user = get_store().find_element_user(SSUBSUP$36, i);
                if (cTSSubSupFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTSSubSupFind_element_user.set(cTSSubSup);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setSSupArray(int i, CTSSup cTSSup) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTSSup cTSSupFind_element_user = get_store().find_element_user(SSUP$38, i);
                if (cTSSupFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTSSupFind_element_user.set(cTSSup);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfAccArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ACC$2);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfBarArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BAR$4);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfBookmarkEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BOOKMARKEND$50);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfBookmarkStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BOOKMARKSTART$48);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfBorderBoxArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BORDERBOX$8);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfBoxArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BOX$6);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfCommentRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(COMMENTRANGEEND$62);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfCommentRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(COMMENTRANGESTART$60);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfCustomXmlDelRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLDELRANGEEND$70);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfCustomXmlDelRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLDELRANGESTART$68);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfCustomXmlInsRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLINSRANGEEND$66);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfCustomXmlInsRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLINSRANGESTART$64);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfCustomXmlMoveFromRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLMOVEFROMRANGEEND$74);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfCustomXmlMoveFromRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLMOVEFROMRANGESTART$72);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfCustomXmlMoveToRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLMOVETORANGEEND$78);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfCustomXmlMoveToRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLMOVETORANGESTART$76);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfDArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(D$10);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfDelArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(DEL$82);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfEqArrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(EQARR$12);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfFArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(F$14);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfFuncArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(FUNC$16);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfGroupChrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(GROUPCHR$18);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfInsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(INS$80);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfLimLowArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(LIMLOW$20);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfLimUppArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(LIMUPP$22);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfMArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(M$24);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfMoveFromArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVEFROM$84);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfMoveFromRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVEFROMRANGEEND$54);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfMoveFromRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVEFROMRANGESTART$52);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfMoveToArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVETO$86);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfMoveToRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVETORANGEEND$58);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfMoveToRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVETORANGESTART$56);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfNaryArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(NARY$26);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfOMathArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(OMATH$90);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfOMathParaArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(OMATHPARA$88);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfPermEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PERMEND$46);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfPermStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PERMSTART$44);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfPhantArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PHANT$28);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfProofErrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROOFERR$42);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfRArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(R$40);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfRadArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(RAD$30);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfSPreArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SPRE$32);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfSSubArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SSUB$34);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfSSubSupArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SSUBSUP$36);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public int sizeOfSSupArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SSUP$38);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void unsetArgPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ARGPR$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void unsetCtrlPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CTRLPR$92, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTAcc[] getAccArray() {
        CTAcc[] cTAccArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ACC$2, arrayList);
            cTAccArr = new CTAcc[arrayList.size()];
            arrayList.toArray(cTAccArr);
        }
        return cTAccArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTBar[] getBarArray() {
        CTBar[] cTBarArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BAR$4, arrayList);
            cTBarArr = new CTBar[arrayList.size()];
            arrayList.toArray(cTBarArr);
        }
        return cTBarArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange[] getBookmarkEndArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BOOKMARKEND$50, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTBookmark[] getBookmarkStartArray() {
        CTBookmark[] cTBookmarkArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BOOKMARKSTART$48, arrayList);
            cTBookmarkArr = new CTBookmark[arrayList.size()];
            arrayList.toArray(cTBookmarkArr);
        }
        return cTBookmarkArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTBorderBox[] getBorderBoxArray() {
        CTBorderBox[] cTBorderBoxArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BORDERBOX$8, arrayList);
            cTBorderBoxArr = new CTBorderBox[arrayList.size()];
            arrayList.toArray(cTBorderBoxArr);
        }
        return cTBorderBoxArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTBox[] getBoxArray() {
        CTBox[] cTBoxArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BOX$6, arrayList);
            cTBoxArr = new CTBox[arrayList.size()];
            arrayList.toArray(cTBoxArr);
        }
        return cTBoxArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange[] getCommentRangeEndArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COMMENTRANGEEND$62, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange[] getCommentRangeStartArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COMMENTRANGESTART$60, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkup[] getCustomXmlDelRangeEndArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLDELRANGEEND$70, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTTrackChange[] getCustomXmlDelRangeStartArray() {
        CTTrackChange[] cTTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLDELRANGESTART$68, arrayList);
            cTTrackChangeArr = new CTTrackChange[arrayList.size()];
            arrayList.toArray(cTTrackChangeArr);
        }
        return cTTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkup[] getCustomXmlInsRangeEndArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLINSRANGEEND$66, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTTrackChange[] getCustomXmlInsRangeStartArray() {
        CTTrackChange[] cTTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLINSRANGESTART$64, arrayList);
            cTTrackChangeArr = new CTTrackChange[arrayList.size()];
            arrayList.toArray(cTTrackChangeArr);
        }
        return cTTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkup[] getCustomXmlMoveFromRangeEndArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLMOVEFROMRANGEEND$74, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTTrackChange[] getCustomXmlMoveFromRangeStartArray() {
        CTTrackChange[] cTTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLMOVEFROMRANGESTART$72, arrayList);
            cTTrackChangeArr = new CTTrackChange[arrayList.size()];
            arrayList.toArray(cTTrackChangeArr);
        }
        return cTTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkup[] getCustomXmlMoveToRangeEndArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLMOVETORANGEEND$78, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTTrackChange[] getCustomXmlMoveToRangeStartArray() {
        CTTrackChange[] cTTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLMOVETORANGESTART$76, arrayList);
            cTTrackChangeArr = new CTTrackChange[arrayList.size()];
            arrayList.toArray(cTTrackChangeArr);
        }
        return cTTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTD[] getDArray() {
        CTD[] ctdArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(D$10, arrayList);
            ctdArr = new CTD[arrayList.size()];
            arrayList.toArray(ctdArr);
        }
        return ctdArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRunTrackChange[] getDelArray() {
        CTRunTrackChange[] cTRunTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DEL$82, arrayList);
            cTRunTrackChangeArr = new CTRunTrackChange[arrayList.size()];
            arrayList.toArray(cTRunTrackChangeArr);
        }
        return cTRunTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTEqArr[] getEqArrArray() {
        CTEqArr[] cTEqArrArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(EQARR$12, arrayList);
            cTEqArrArr = new CTEqArr[arrayList.size()];
            arrayList.toArray(cTEqArrArr);
        }
        return cTEqArrArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTF[] getFArray() {
        CTF[] ctfArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(F$14, arrayList);
            ctfArr = new CTF[arrayList.size()];
            arrayList.toArray(ctfArr);
        }
        return ctfArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTFunc[] getFuncArray() {
        CTFunc[] cTFuncArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FUNC$16, arrayList);
            cTFuncArr = new CTFunc[arrayList.size()];
            arrayList.toArray(cTFuncArr);
        }
        return cTFuncArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTGroupChr[] getGroupChrArray() {
        CTGroupChr[] cTGroupChrArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(GROUPCHR$18, arrayList);
            cTGroupChrArr = new CTGroupChr[arrayList.size()];
            arrayList.toArray(cTGroupChrArr);
        }
        return cTGroupChrArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRunTrackChange[] getInsArray() {
        CTRunTrackChange[] cTRunTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(INS$80, arrayList);
            cTRunTrackChangeArr = new CTRunTrackChange[arrayList.size()];
            arrayList.toArray(cTRunTrackChangeArr);
        }
        return cTRunTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTLimLow[] getLimLowArray() {
        CTLimLow[] cTLimLowArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LIMLOW$20, arrayList);
            cTLimLowArr = new CTLimLow[arrayList.size()];
            arrayList.toArray(cTLimLowArr);
        }
        return cTLimLowArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTLimUpp[] getLimUppArray() {
        CTLimUpp[] cTLimUppArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LIMUPP$22, arrayList);
            cTLimUppArr = new CTLimUpp[arrayList.size()];
            arrayList.toArray(cTLimUppArr);
        }
        return cTLimUppArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTM[] getMArray() {
        CTM[] ctmArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(M$24, arrayList);
            ctmArr = new CTM[arrayList.size()];
            arrayList.toArray(ctmArr);
        }
        return ctmArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRunTrackChange[] getMoveFromArray() {
        CTRunTrackChange[] cTRunTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVEFROM$84, arrayList);
            cTRunTrackChangeArr = new CTRunTrackChange[arrayList.size()];
            arrayList.toArray(cTRunTrackChangeArr);
        }
        return cTRunTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange[] getMoveFromRangeEndArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVEFROMRANGEEND$54, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMoveBookmark[] getMoveFromRangeStartArray() {
        CTMoveBookmark[] cTMoveBookmarkArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVEFROMRANGESTART$52, arrayList);
            cTMoveBookmarkArr = new CTMoveBookmark[arrayList.size()];
            arrayList.toArray(cTMoveBookmarkArr);
        }
        return cTMoveBookmarkArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRunTrackChange[] getMoveToArray() {
        CTRunTrackChange[] cTRunTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVETO$86, arrayList);
            cTRunTrackChangeArr = new CTRunTrackChange[arrayList.size()];
            arrayList.toArray(cTRunTrackChangeArr);
        }
        return cTRunTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMarkupRange[] getMoveToRangeEndArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVETORANGEEND$58, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTMoveBookmark[] getMoveToRangeStartArray() {
        CTMoveBookmark[] cTMoveBookmarkArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVETORANGESTART$56, arrayList);
            cTMoveBookmarkArr = new CTMoveBookmark[arrayList.size()];
            arrayList.toArray(cTMoveBookmarkArr);
        }
        return cTMoveBookmarkArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTNary[] getNaryArray() {
        CTNary[] cTNaryArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(NARY$26, arrayList);
            cTNaryArr = new CTNary[arrayList.size()];
            arrayList.toArray(cTNaryArr);
        }
        return cTNaryArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTOMath[] getOMathArray() {
        CTOMath[] cTOMathArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(OMATH$90, arrayList);
            cTOMathArr = new CTOMath[arrayList.size()];
            arrayList.toArray(cTOMathArr);
        }
        return cTOMathArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTOMathPara[] getOMathParaArray() {
        CTOMathPara[] cTOMathParaArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(OMATHPARA$88, arrayList);
            cTOMathParaArr = new CTOMathPara[arrayList.size()];
            arrayList.toArray(cTOMathParaArr);
        }
        return cTOMathParaArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTPerm[] getPermEndArray() {
        CTPerm[] cTPermArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PERMEND$46, arrayList);
            cTPermArr = new CTPerm[arrayList.size()];
            arrayList.toArray(cTPermArr);
        }
        return cTPermArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTPermStart[] getPermStartArray() {
        CTPermStart[] cTPermStartArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PERMSTART$44, arrayList);
            cTPermStartArr = new CTPermStart[arrayList.size()];
            arrayList.toArray(cTPermStartArr);
        }
        return cTPermStartArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTPhant[] getPhantArray() {
        CTPhant[] cTPhantArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PHANT$28, arrayList);
            cTPhantArr = new CTPhant[arrayList.size()];
            arrayList.toArray(cTPhantArr);
        }
        return cTPhantArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTProofErr[] getProofErrArray() {
        CTProofErr[] cTProofErrArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PROOFERR$42, arrayList);
            cTProofErrArr = new CTProofErr[arrayList.size()];
            arrayList.toArray(cTProofErrArr);
        }
        return cTProofErrArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTR[] getRArray() {
        CTR[] ctrArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(R$40, arrayList);
            ctrArr = new CTR[arrayList.size()];
            arrayList.toArray(ctrArr);
        }
        return ctrArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTRad[] getRadArray() {
        CTRad[] cTRadArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(RAD$30, arrayList);
            cTRadArr = new CTRad[arrayList.size()];
            arrayList.toArray(cTRadArr);
        }
        return cTRadArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSPre[] getSPreArray() {
        CTSPre[] cTSPreArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SPRE$32, arrayList);
            cTSPreArr = new CTSPre[arrayList.size()];
            arrayList.toArray(cTSPreArr);
        }
        return cTSPreArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSSub[] getSSubArray() {
        CTSSub[] cTSSubArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SSUB$34, arrayList);
            cTSSubArr = new CTSSub[arrayList.size()];
            arrayList.toArray(cTSSubArr);
        }
        return cTSSubArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSSubSup[] getSSubSupArray() {
        CTSSubSup[] cTSSubSupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SSUBSUP$36, arrayList);
            cTSSubSupArr = new CTSSubSup[arrayList.size()];
            arrayList.toArray(cTSSubSupArr);
        }
        return cTSSubSupArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public CTSSup[] getSSupArray() {
        CTSSup[] cTSSupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SSUP$38, arrayList);
            cTSSupArr = new CTSSup[arrayList.size()];
            arrayList.toArray(cTSSupArr);
        }
        return cTSSupArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setAccArray(CTAcc[] cTAccArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTAccArr, ACC$2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setBarArray(CTBar[] cTBarArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTBarArr, BAR$4);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setBookmarkEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, BOOKMARKEND$50);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setBookmarkStartArray(CTBookmark[] cTBookmarkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBookmarkArr, BOOKMARKSTART$48);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setBorderBoxArray(CTBorderBox[] cTBorderBoxArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTBorderBoxArr, BORDERBOX$8);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setBoxArray(CTBox[] cTBoxArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTBoxArr, BOX$6);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCommentRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, COMMENTRANGEEND$62);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCommentRangeStartArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, COMMENTRANGESTART$60);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCustomXmlDelRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLDELRANGEEND$70);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCustomXmlDelRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLDELRANGESTART$68);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCustomXmlInsRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLINSRANGEEND$66);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCustomXmlInsRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLINSRANGESTART$64);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCustomXmlMoveFromRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLMOVEFROMRANGEEND$74);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCustomXmlMoveFromRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLMOVEFROMRANGESTART$72);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCustomXmlMoveToRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLMOVETORANGEEND$78);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setCustomXmlMoveToRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLMOVETORANGESTART$76);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setDArray(CTD[] ctdArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) ctdArr, D$10);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setDelArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, DEL$82);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setEqArrArray(CTEqArr[] cTEqArrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTEqArrArr, EQARR$12);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setFArray(CTF[] ctfArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) ctfArr, F$14);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setFuncArray(CTFunc[] cTFuncArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTFuncArr, FUNC$16);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setGroupChrArray(CTGroupChr[] cTGroupChrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTGroupChrArr, GROUPCHR$18);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setInsArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, INS$80);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setLimLowArray(CTLimLow[] cTLimLowArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTLimLowArr, LIMLOW$20);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setLimUppArray(CTLimUpp[] cTLimUppArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTLimUppArr, LIMUPP$22);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setMArray(CTM[] ctmArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) ctmArr, M$24);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setMoveFromArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, MOVEFROM$84);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setMoveFromRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, MOVEFROMRANGEEND$54);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setMoveFromRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMoveBookmarkArr, MOVEFROMRANGESTART$52);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setMoveToArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, MOVETO$86);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setMoveToRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, MOVETORANGEEND$58);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setMoveToRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMoveBookmarkArr, MOVETORANGESTART$56);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setNaryArray(CTNary[] cTNaryArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTNaryArr, NARY$26);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setOMathArray(CTOMath[] cTOMathArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTOMathArr, OMATH$90);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setOMathParaArray(CTOMathPara[] cTOMathParaArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTOMathParaArr, OMATHPARA$88);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setPermEndArray(CTPerm[] cTPermArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTPermArr, PERMEND$46);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setPermStartArray(CTPermStart[] cTPermStartArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTPermStartArr, PERMSTART$44);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setPhantArray(CTPhant[] cTPhantArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTPhantArr, PHANT$28);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setProofErrArray(CTProofErr[] cTProofErrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTProofErrArr, PROOFERR$42);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setRArray(CTR[] ctrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) ctrArr, R$40);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setRadArray(CTRad[] cTRadArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTRadArr, RAD$30);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setSPreArray(CTSPre[] cTSPreArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTSPreArr, SPRE$32);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setSSubArray(CTSSub[] cTSSubArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTSSubArr, SSUB$34);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setSSubSupArray(CTSSubSup[] cTSSubSupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTSSubSupArr, SSUBSUP$36);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArg
    public void setSSupArray(CTSSup[] cTSSupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTSSupArr, SSUP$38);
        }
    }
}
