package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTAcc;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTBar;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTBorderBox;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTBox;
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
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTPhant;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTRad;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTSPre;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTSSub;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTSSubSup;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTSSup;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTCustomXmlRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkup;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkupRange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMoveBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPerm;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPermStart;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTProofErr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSmartTagRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrackChange;

/* JADX INFO: loaded from: classes11.dex */
public class CTRunTrackChangeImpl extends CTTrackChangeImpl implements CTRunTrackChange {
    private static final QName CUSTOMXML$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXml");
    private static final QName SMARTTAG$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "smartTag");
    private static final QName SDT$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "sdt");
    private static final QName R$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "r");
    private static final QName PROOFERR$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "proofErr");
    private static final QName PERMSTART$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "permStart");
    private static final QName PERMEND$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "permEnd");
    private static final QName BOOKMARKSTART$14 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bookmarkStart");
    private static final QName BOOKMARKEND$16 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bookmarkEnd");
    private static final QName MOVEFROMRANGESTART$18 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFromRangeStart");
    private static final QName MOVEFROMRANGEEND$20 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFromRangeEnd");
    private static final QName MOVETORANGESTART$22 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveToRangeStart");
    private static final QName MOVETORANGEEND$24 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveToRangeEnd");
    private static final QName COMMENTRANGESTART$26 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "commentRangeStart");
    private static final QName COMMENTRANGEEND$28 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "commentRangeEnd");
    private static final QName CUSTOMXMLINSRANGESTART$30 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlInsRangeStart");
    private static final QName CUSTOMXMLINSRANGEEND$32 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlInsRangeEnd");
    private static final QName CUSTOMXMLDELRANGESTART$34 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlDelRangeStart");
    private static final QName CUSTOMXMLDELRANGEEND$36 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlDelRangeEnd");
    private static final QName CUSTOMXMLMOVEFROMRANGESTART$38 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveFromRangeStart");
    private static final QName CUSTOMXMLMOVEFROMRANGEEND$40 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveFromRangeEnd");
    private static final QName CUSTOMXMLMOVETORANGESTART$42 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveToRangeStart");
    private static final QName CUSTOMXMLMOVETORANGEEND$44 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveToRangeEnd");
    private static final QName INS$46 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ins");
    private static final QName DEL$48 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "del");
    private static final QName MOVEFROM$50 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFrom");
    private static final QName MOVETO$52 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveTo");
    private static final QName OMATHPARA$54 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "oMathPara");
    private static final QName OMATH$56 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "oMath");
    private static final QName ACC$58 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "acc");
    private static final QName BAR$60 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "bar");
    private static final QName BOX$62 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "box");
    private static final QName BORDERBOX$64 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "borderBox");
    private static final QName D$66 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "d");
    private static final QName EQARR$68 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "eqArr");
    private static final QName F$70 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "f");
    private static final QName FUNC$72 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "func");
    private static final QName GROUPCHR$74 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "groupChr");
    private static final QName LIMLOW$76 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "limLow");
    private static final QName LIMUPP$78 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "limUpp");
    private static final QName M$80 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "m");
    private static final QName NARY$82 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "nary");
    private static final QName PHANT$84 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "phant");
    private static final QName RAD$86 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "rad");
    private static final QName SPRE$88 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "sPre");
    private static final QName SSUB$90 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "sSub");
    private static final QName SSUBSUP$92 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "sSubSup");
    private static final QName SSUP$94 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "sSup");
    private static final QName R2$96 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "r");

    public CTRunTrackChangeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTAcc addNewAcc() {
        CTAcc cTAccAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAccAdd_element_user = get_store().add_element_user(ACC$58);
        }
        return cTAccAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTBar addNewBar() {
        CTBar cTBarAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBarAdd_element_user = get_store().add_element_user(BAR$60);
        }
        return cTBarAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkupRange addNewBookmarkEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(BOOKMARKEND$16);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTBookmark addNewBookmarkStart() {
        CTBookmark cTBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmark = (CTBookmark) get_store().add_element_user(BOOKMARKSTART$14);
        }
        return cTBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTBorderBox addNewBorderBox() {
        CTBorderBox cTBorderBoxAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderBoxAdd_element_user = get_store().add_element_user(BORDERBOX$64);
        }
        return cTBorderBoxAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTBox addNewBox() {
        CTBox cTBoxAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBoxAdd_element_user = get_store().add_element_user(BOX$62);
        }
        return cTBoxAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkupRange addNewCommentRangeEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(COMMENTRANGEEND$28);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkupRange addNewCommentRangeStart() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(COMMENTRANGESTART$26);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTCustomXmlRun addNewCustomXml() {
        CTCustomXmlRun cTCustomXmlRunAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomXmlRunAdd_element_user = get_store().add_element_user(CUSTOMXML$0);
        }
        return cTCustomXmlRunAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkup addNewCustomXmlDelRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(CUSTOMXMLDELRANGEEND$36);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTTrackChange addNewCustomXmlDelRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(CUSTOMXMLDELRANGESTART$34);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkup addNewCustomXmlInsRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(CUSTOMXMLINSRANGEEND$32);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTTrackChange addNewCustomXmlInsRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(CUSTOMXMLINSRANGESTART$30);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkup addNewCustomXmlMoveFromRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(CUSTOMXMLMOVEFROMRANGEEND$40);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTTrackChange addNewCustomXmlMoveFromRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(CUSTOMXMLMOVEFROMRANGESTART$38);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkup addNewCustomXmlMoveToRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(CUSTOMXMLMOVETORANGEEND$44);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTTrackChange addNewCustomXmlMoveToRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(CUSTOMXMLMOVETORANGESTART$42);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTD addNewD() {
        CTD ctdAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctdAdd_element_user = get_store().add_element_user(D$66);
        }
        return ctdAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTRunTrackChange addNewDel() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(DEL$48);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTEqArr addNewEqArr() {
        CTEqArr cTEqArrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEqArrAdd_element_user = get_store().add_element_user(EQARR$68);
        }
        return cTEqArrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTF addNewF() {
        CTF ctfAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctfAdd_element_user = get_store().add_element_user(F$70);
        }
        return ctfAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTFunc addNewFunc() {
        CTFunc cTFuncAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFuncAdd_element_user = get_store().add_element_user(FUNC$72);
        }
        return cTFuncAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTGroupChr addNewGroupChr() {
        CTGroupChr cTGroupChrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupChrAdd_element_user = get_store().add_element_user(GROUPCHR$74);
        }
        return cTGroupChrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTRunTrackChange addNewIns() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(INS$46);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTLimLow addNewLimLow() {
        CTLimLow cTLimLowAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLimLowAdd_element_user = get_store().add_element_user(LIMLOW$76);
        }
        return cTLimLowAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTLimUpp addNewLimUpp() {
        CTLimUpp cTLimUppAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLimUppAdd_element_user = get_store().add_element_user(LIMUPP$78);
        }
        return cTLimUppAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTM addNewM() {
        CTM ctmAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctmAdd_element_user = get_store().add_element_user(M$80);
        }
        return ctmAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTRunTrackChange addNewMoveFrom() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(MOVEFROM$50);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkupRange addNewMoveFromRangeEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(MOVEFROMRANGEEND$20);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMoveBookmark addNewMoveFromRangeStart() {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().add_element_user(MOVEFROMRANGESTART$18);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTRunTrackChange addNewMoveTo() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(MOVETO$52);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkupRange addNewMoveToRangeEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(MOVETORANGEEND$24);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMoveBookmark addNewMoveToRangeStart() {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().add_element_user(MOVETORANGESTART$22);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTNary addNewNary() {
        CTNary cTNaryAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTNaryAdd_element_user = get_store().add_element_user(NARY$82);
        }
        return cTNaryAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTOMath addNewOMath() {
        CTOMath cTOMath;
        synchronized (monitor()) {
            check_orphaned();
            cTOMath = (CTOMath) get_store().add_element_user(OMATH$56);
        }
        return cTOMath;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTOMathPara addNewOMathPara() {
        CTOMathPara cTOMathPara;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathPara = (CTOMathPara) get_store().add_element_user(OMATHPARA$54);
        }
        return cTOMathPara;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTPerm addNewPermEnd() {
        CTPerm cTPermAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPermAdd_element_user = get_store().add_element_user(PERMEND$12);
        }
        return cTPermAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTPermStart addNewPermStart() {
        CTPermStart cTPermStartAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPermStartAdd_element_user = get_store().add_element_user(PERMSTART$10);
        }
        return cTPermStartAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTPhant addNewPhant() {
        CTPhant cTPhantAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPhantAdd_element_user = get_store().add_element_user(PHANT$84);
        }
        return cTPhantAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTProofErr addNewProofErr() {
        CTProofErr cTProofErrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErrAdd_element_user = get_store().add_element_user(PROOFERR$8);
        }
        return cTProofErrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTR addNewR() {
        CTR ctr;
        synchronized (monitor()) {
            check_orphaned();
            ctr = (CTR) get_store().add_element_user(R$6);
        }
        return ctr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public org.openxmlformats.schemas.officeDocument.x2006.math.CTR addNewR2() {
        org.openxmlformats.schemas.officeDocument.x2006.math.CTR ctrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctrAdd_element_user = get_store().add_element_user(R2$96);
        }
        return ctrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTRad addNewRad() {
        CTRad cTRadAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRadAdd_element_user = get_store().add_element_user(RAD$86);
        }
        return cTRadAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSPre addNewSPre() {
        CTSPre cTSPreAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSPreAdd_element_user = get_store().add_element_user(SPRE$88);
        }
        return cTSPreAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSSub addNewSSub() {
        CTSSub cTSSubAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSSubAdd_element_user = get_store().add_element_user(SSUB$90);
        }
        return cTSSubAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSSubSup addNewSSubSup() {
        CTSSubSup cTSSubSupAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSSubSupAdd_element_user = get_store().add_element_user(SSUBSUP$92);
        }
        return cTSSubSupAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSSup addNewSSup() {
        CTSSup cTSSupAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSSupAdd_element_user = get_store().add_element_user(SSUP$94);
        }
        return cTSSupAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSdtRun addNewSdt() {
        CTSdtRun cTSdtRun;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtRun = (CTSdtRun) get_store().add_element_user(SDT$4);
        }
        return cTSdtRun;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSmartTagRun addNewSmartTag() {
        CTSmartTagRun cTSmartTagRunAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSmartTagRunAdd_element_user = get_store().add_element_user(SMARTTAG$2);
        }
        return cTSmartTagRunAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTAcc getAccArray(int i) {
        CTAcc cTAccFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTAccFind_element_user = get_store().find_element_user(ACC$58, i);
                if (cTAccFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTAccFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTAcc> getAccList() {
        1AccList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1AccList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTBar getBarArray(int i) {
        CTBar cTBarFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTBarFind_element_user = get_store().find_element_user(BAR$60, i);
                if (cTBarFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTBarFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTBar> getBarList() {
        1BarList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1BarList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkupRange getBookmarkEndArray(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTMarkupRange = (CTMarkupRange) get_store().find_element_user(BOOKMARKEND$16, i);
                if (cTMarkupRange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTMarkupRange> getBookmarkEndList() {
        1BookmarkEndList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1BookmarkEndList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTBookmark getBookmarkStartArray(int i) {
        CTBookmark cTBookmark;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTBookmark = (CTBookmark) get_store().find_element_user(BOOKMARKSTART$14, i);
                if (cTBookmark == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTBookmark> getBookmarkStartList() {
        1BookmarkStartList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1BookmarkStartList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTBorderBox getBorderBoxArray(int i) {
        CTBorderBox cTBorderBoxFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTBorderBoxFind_element_user = get_store().find_element_user(BORDERBOX$64, i);
                if (cTBorderBoxFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTBorderBoxFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTBorderBox> getBorderBoxList() {
        1BorderBoxList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1BorderBoxList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTBox getBoxArray(int i) {
        CTBox cTBoxFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTBoxFind_element_user = get_store().find_element_user(BOX$62, i);
                if (cTBoxFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTBoxFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTBox> getBoxList() {
        1BoxList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1BoxList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkupRange getCommentRangeEndArray(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTMarkupRange = (CTMarkupRange) get_store().find_element_user(COMMENTRANGEEND$28, i);
                if (cTMarkupRange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTMarkupRange> getCommentRangeEndList() {
        1CommentRangeEndList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1CommentRangeEndList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkupRange getCommentRangeStartArray(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTMarkupRange = (CTMarkupRange) get_store().find_element_user(COMMENTRANGESTART$26, i);
                if (cTMarkupRange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTMarkupRange> getCommentRangeStartList() {
        1CommentRangeStartList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1CommentRangeStartList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTCustomXmlRun getCustomXmlArray(int i) {
        CTCustomXmlRun cTCustomXmlRunFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTCustomXmlRunFind_element_user = get_store().find_element_user(CUSTOMXML$0, i);
                if (cTCustomXmlRunFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTCustomXmlRunFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkup getCustomXmlDelRangeEndArray(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTMarkup = (CTMarkup) get_store().find_element_user(CUSTOMXMLDELRANGEEND$36, i);
                if (cTMarkup == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTMarkup> getCustomXmlDelRangeEndList() {
        1CustomXmlDelRangeEndList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1CustomXmlDelRangeEndList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTTrackChange getCustomXmlDelRangeStartArray(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTrackChange = (CTTrackChange) get_store().find_element_user(CUSTOMXMLDELRANGESTART$34, i);
                if (cTTrackChange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTTrackChange> getCustomXmlDelRangeStartList() {
        1CustomXmlDelRangeStartList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1CustomXmlDelRangeStartList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkup getCustomXmlInsRangeEndArray(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTMarkup = (CTMarkup) get_store().find_element_user(CUSTOMXMLINSRANGEEND$32, i);
                if (cTMarkup == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTMarkup> getCustomXmlInsRangeEndList() {
        1CustomXmlInsRangeEndList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1CustomXmlInsRangeEndList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTTrackChange getCustomXmlInsRangeStartArray(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTrackChange = (CTTrackChange) get_store().find_element_user(CUSTOMXMLINSRANGESTART$30, i);
                if (cTTrackChange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTTrackChange> getCustomXmlInsRangeStartList() {
        1CustomXmlInsRangeStartList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1CustomXmlInsRangeStartList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTCustomXmlRun> getCustomXmlList() {
        1CustomXmlList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1CustomXmlList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkup getCustomXmlMoveFromRangeEndArray(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTMarkup = (CTMarkup) get_store().find_element_user(CUSTOMXMLMOVEFROMRANGEEND$40, i);
                if (cTMarkup == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTMarkup> getCustomXmlMoveFromRangeEndList() {
        1CustomXmlMoveFromRangeEndList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1CustomXmlMoveFromRangeEndList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTTrackChange getCustomXmlMoveFromRangeStartArray(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTrackChange = (CTTrackChange) get_store().find_element_user(CUSTOMXMLMOVEFROMRANGESTART$38, i);
                if (cTTrackChange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTTrackChange> getCustomXmlMoveFromRangeStartList() {
        1CustomXmlMoveFromRangeStartList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1CustomXmlMoveFromRangeStartList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkup getCustomXmlMoveToRangeEndArray(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTMarkup = (CTMarkup) get_store().find_element_user(CUSTOMXMLMOVETORANGEEND$44, i);
                if (cTMarkup == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTMarkup> getCustomXmlMoveToRangeEndList() {
        1CustomXmlMoveToRangeEndList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1CustomXmlMoveToRangeEndList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTTrackChange getCustomXmlMoveToRangeStartArray(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTrackChange = (CTTrackChange) get_store().find_element_user(CUSTOMXMLMOVETORANGESTART$42, i);
                if (cTTrackChange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTTrackChange> getCustomXmlMoveToRangeStartList() {
        1CustomXmlMoveToRangeStartList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1CustomXmlMoveToRangeStartList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTD getDArray(int i) {
        CTD ctdFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                ctdFind_element_user = get_store().find_element_user(D$66, i);
                if (ctdFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return ctdFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTD> getDList() {
        1DList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1DList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTRunTrackChange getDelArray(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTRunTrackChange = (CTRunTrackChange) get_store().find_element_user(DEL$48, i);
                if (cTRunTrackChange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTRunTrackChange> getDelList() {
        1DelList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1DelList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTEqArr getEqArrArray(int i) {
        CTEqArr cTEqArrFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTEqArrFind_element_user = get_store().find_element_user(EQARR$68, i);
                if (cTEqArrFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTEqArrFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTEqArr> getEqArrList() {
        1EqArrList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1EqArrList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTF getFArray(int i) {
        CTF ctfFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                ctfFind_element_user = get_store().find_element_user(F$70, i);
                if (ctfFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return ctfFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTF> getFList() {
        1FList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1FList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTFunc getFuncArray(int i) {
        CTFunc cTFuncFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTFuncFind_element_user = get_store().find_element_user(FUNC$72, i);
                if (cTFuncFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTFuncFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTFunc> getFuncList() {
        1FuncList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1FuncList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTGroupChr getGroupChrArray(int i) {
        CTGroupChr cTGroupChrFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTGroupChrFind_element_user = get_store().find_element_user(GROUPCHR$74, i);
                if (cTGroupChrFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTGroupChrFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTGroupChr> getGroupChrList() {
        1GroupChrList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1GroupChrList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTRunTrackChange getInsArray(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTRunTrackChange = (CTRunTrackChange) get_store().find_element_user(INS$46, i);
                if (cTRunTrackChange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTRunTrackChange> getInsList() {
        1InsList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1InsList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTLimLow getLimLowArray(int i) {
        CTLimLow cTLimLowFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTLimLowFind_element_user = get_store().find_element_user(LIMLOW$76, i);
                if (cTLimLowFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTLimLowFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTLimLow> getLimLowList() {
        1LimLowList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1LimLowList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTLimUpp getLimUppArray(int i) {
        CTLimUpp cTLimUppFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTLimUppFind_element_user = get_store().find_element_user(LIMUPP$78, i);
                if (cTLimUppFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTLimUppFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTLimUpp> getLimUppList() {
        1LimUppList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1LimUppList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTM getMArray(int i) {
        CTM ctmFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                ctmFind_element_user = get_store().find_element_user(M$80, i);
                if (ctmFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return ctmFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTM> getMList() {
        1MList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1MList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTRunTrackChange getMoveFromArray(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTRunTrackChange = (CTRunTrackChange) get_store().find_element_user(MOVEFROM$50, i);
                if (cTRunTrackChange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTRunTrackChange> getMoveFromList() {
        1MoveFromList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1MoveFromList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkupRange getMoveFromRangeEndArray(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTMarkupRange = (CTMarkupRange) get_store().find_element_user(MOVEFROMRANGEEND$20, i);
                if (cTMarkupRange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTMarkupRange> getMoveFromRangeEndList() {
        1MoveFromRangeEndList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1MoveFromRangeEndList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMoveBookmark getMoveFromRangeStartArray(int i) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTMoveBookmark = (CTMoveBookmark) get_store().find_element_user(MOVEFROMRANGESTART$18, i);
                if (cTMoveBookmark == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTMoveBookmark> getMoveFromRangeStartList() {
        1MoveFromRangeStartList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1MoveFromRangeStartList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTRunTrackChange getMoveToArray(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTRunTrackChange = (CTRunTrackChange) get_store().find_element_user(MOVETO$52, i);
                if (cTRunTrackChange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTRunTrackChange> getMoveToList() {
        1MoveToList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1MoveToList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkupRange getMoveToRangeEndArray(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTMarkupRange = (CTMarkupRange) get_store().find_element_user(MOVETORANGEEND$24, i);
                if (cTMarkupRange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTMarkupRange> getMoveToRangeEndList() {
        1MoveToRangeEndList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1MoveToRangeEndList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMoveBookmark getMoveToRangeStartArray(int i) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTMoveBookmark = (CTMoveBookmark) get_store().find_element_user(MOVETORANGESTART$22, i);
                if (cTMoveBookmark == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTMoveBookmark> getMoveToRangeStartList() {
        1MoveToRangeStartList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1MoveToRangeStartList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTNary getNaryArray(int i) {
        CTNary cTNaryFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTNaryFind_element_user = get_store().find_element_user(NARY$82, i);
                if (cTNaryFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTNaryFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTNary> getNaryList() {
        1NaryList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1NaryList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTOMath getOMathArray(int i) {
        CTOMath cTOMath;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTOMath = (CTOMath) get_store().find_element_user(OMATH$56, i);
                if (cTOMath == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTOMath;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTOMath> getOMathList() {
        1OMathList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1OMathList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTOMathPara getOMathParaArray(int i) {
        CTOMathPara cTOMathPara;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTOMathPara = (CTOMathPara) get_store().find_element_user(OMATHPARA$54, i);
                if (cTOMathPara == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTOMathPara;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTOMathPara> getOMathParaList() {
        1OMathParaList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1OMathParaList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTPerm getPermEndArray(int i) {
        CTPerm cTPermFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTPermFind_element_user = get_store().find_element_user(PERMEND$12, i);
                if (cTPermFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTPermFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTPerm> getPermEndList() {
        1PermEndList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1PermEndList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTPermStart getPermStartArray(int i) {
        CTPermStart cTPermStartFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTPermStartFind_element_user = get_store().find_element_user(PERMSTART$10, i);
                if (cTPermStartFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTPermStartFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTPermStart> getPermStartList() {
        1PermStartList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1PermStartList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTPhant getPhantArray(int i) {
        CTPhant cTPhantFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTPhantFind_element_user = get_store().find_element_user(PHANT$84, i);
                if (cTPhantFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTPhantFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTPhant> getPhantList() {
        1PhantList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1PhantList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTProofErr getProofErrArray(int i) {
        CTProofErr cTProofErrFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTProofErrFind_element_user = get_store().find_element_user(PROOFERR$8, i);
                if (cTProofErrFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTProofErrFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTProofErr> getProofErrList() {
        1ProofErrList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1ProofErrList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public org.openxmlformats.schemas.officeDocument.x2006.math.CTR getR2Array(int i) {
        org.openxmlformats.schemas.officeDocument.x2006.math.CTR ctrFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                ctrFind_element_user = get_store().find_element_user(R2$96, i);
                if (ctrFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return ctrFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<org.openxmlformats.schemas.officeDocument.x2006.math.CTR> getR2List() {
        1R2List r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1R2List(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTR getRArray(int i) {
        CTR ctr;
        synchronized (monitor()) {
            try {
                check_orphaned();
                ctr = (CTR) get_store().find_element_user(R$6, i);
                if (ctr == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return ctr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTR> getRList() {
        1RList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1RList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTRad getRadArray(int i) {
        CTRad cTRadFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTRadFind_element_user = get_store().find_element_user(RAD$86, i);
                if (cTRadFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTRadFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTRad> getRadList() {
        1RadList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1RadList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSPre getSPreArray(int i) {
        CTSPre cTSPreFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTSPreFind_element_user = get_store().find_element_user(SPRE$88, i);
                if (cTSPreFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTSPreFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTSPre> getSPreList() {
        1SPreList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1SPreList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSSub getSSubArray(int i) {
        CTSSub cTSSubFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTSSubFind_element_user = get_store().find_element_user(SSUB$90, i);
                if (cTSSubFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTSSubFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTSSub> getSSubList() {
        1SSubList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1SSubList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSSubSup getSSubSupArray(int i) {
        CTSSubSup cTSSubSupFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTSSubSupFind_element_user = get_store().find_element_user(SSUBSUP$92, i);
                if (cTSSubSupFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTSSubSupFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTSSubSup> getSSubSupList() {
        1SSubSupList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1SSubSupList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSSup getSSupArray(int i) {
        CTSSup cTSSupFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTSSupFind_element_user = get_store().find_element_user(SSUP$94, i);
                if (cTSSupFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTSSupFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTSSup> getSSupList() {
        1SSupList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1SSupList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSdtRun getSdtArray(int i) {
        CTSdtRun cTSdtRun;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTSdtRun = (CTSdtRun) get_store().find_element_user(SDT$4, i);
                if (cTSdtRun == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTSdtRun;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTSdtRun> getSdtList() {
        1SdtList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1SdtList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSmartTagRun getSmartTagArray(int i) {
        CTSmartTagRun cTSmartTagRunFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTSmartTagRunFind_element_user = get_store().find_element_user(SMARTTAG$2, i);
                if (cTSmartTagRunFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTSmartTagRunFind_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public List<CTSmartTagRun> getSmartTagList() {
        1SmartTagList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1SmartTagList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTAcc insertNewAcc(int i) {
        CTAcc cTAccInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAccInsert_element_user = get_store().insert_element_user(ACC$58, i);
        }
        return cTAccInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTBar insertNewBar(int i) {
        CTBar cTBarInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBarInsert_element_user = get_store().insert_element_user(BAR$60, i);
        }
        return cTBarInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkupRange insertNewBookmarkEnd(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(BOOKMARKEND$16, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTBookmark insertNewBookmarkStart(int i) {
        CTBookmark cTBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmark = (CTBookmark) get_store().insert_element_user(BOOKMARKSTART$14, i);
        }
        return cTBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTBorderBox insertNewBorderBox(int i) {
        CTBorderBox cTBorderBoxInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderBoxInsert_element_user = get_store().insert_element_user(BORDERBOX$64, i);
        }
        return cTBorderBoxInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTBox insertNewBox(int i) {
        CTBox cTBoxInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBoxInsert_element_user = get_store().insert_element_user(BOX$62, i);
        }
        return cTBoxInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkupRange insertNewCommentRangeEnd(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(COMMENTRANGEEND$28, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkupRange insertNewCommentRangeStart(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(COMMENTRANGESTART$26, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTCustomXmlRun insertNewCustomXml(int i) {
        CTCustomXmlRun cTCustomXmlRunInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomXmlRunInsert_element_user = get_store().insert_element_user(CUSTOMXML$0, i);
        }
        return cTCustomXmlRunInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkup insertNewCustomXmlDelRangeEnd(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(CUSTOMXMLDELRANGEEND$36, i);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTTrackChange insertNewCustomXmlDelRangeStart(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(CUSTOMXMLDELRANGESTART$34, i);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkup insertNewCustomXmlInsRangeEnd(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(CUSTOMXMLINSRANGEEND$32, i);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTTrackChange insertNewCustomXmlInsRangeStart(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(CUSTOMXMLINSRANGESTART$30, i);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkup insertNewCustomXmlMoveFromRangeEnd(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(CUSTOMXMLMOVEFROMRANGEEND$40, i);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTTrackChange insertNewCustomXmlMoveFromRangeStart(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(CUSTOMXMLMOVEFROMRANGESTART$38, i);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkup insertNewCustomXmlMoveToRangeEnd(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(CUSTOMXMLMOVETORANGEEND$44, i);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTTrackChange insertNewCustomXmlMoveToRangeStart(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(CUSTOMXMLMOVETORANGESTART$42, i);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTD insertNewD(int i) {
        CTD ctdInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctdInsert_element_user = get_store().insert_element_user(D$66, i);
        }
        return ctdInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTRunTrackChange insertNewDel(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(DEL$48, i);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTEqArr insertNewEqArr(int i) {
        CTEqArr cTEqArrInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEqArrInsert_element_user = get_store().insert_element_user(EQARR$68, i);
        }
        return cTEqArrInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTF insertNewF(int i) {
        CTF ctfInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctfInsert_element_user = get_store().insert_element_user(F$70, i);
        }
        return ctfInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTFunc insertNewFunc(int i) {
        CTFunc cTFuncInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFuncInsert_element_user = get_store().insert_element_user(FUNC$72, i);
        }
        return cTFuncInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTGroupChr insertNewGroupChr(int i) {
        CTGroupChr cTGroupChrInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupChrInsert_element_user = get_store().insert_element_user(GROUPCHR$74, i);
        }
        return cTGroupChrInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTRunTrackChange insertNewIns(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(INS$46, i);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTLimLow insertNewLimLow(int i) {
        CTLimLow cTLimLowInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLimLowInsert_element_user = get_store().insert_element_user(LIMLOW$76, i);
        }
        return cTLimLowInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTLimUpp insertNewLimUpp(int i) {
        CTLimUpp cTLimUppInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLimUppInsert_element_user = get_store().insert_element_user(LIMUPP$78, i);
        }
        return cTLimUppInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTM insertNewM(int i) {
        CTM ctmInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctmInsert_element_user = get_store().insert_element_user(M$80, i);
        }
        return ctmInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTRunTrackChange insertNewMoveFrom(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(MOVEFROM$50, i);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkupRange insertNewMoveFromRangeEnd(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(MOVEFROMRANGEEND$20, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMoveBookmark insertNewMoveFromRangeStart(int i) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().insert_element_user(MOVEFROMRANGESTART$18, i);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTRunTrackChange insertNewMoveTo(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(MOVETO$52, i);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkupRange insertNewMoveToRangeEnd(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(MOVETORANGEEND$24, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMoveBookmark insertNewMoveToRangeStart(int i) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().insert_element_user(MOVETORANGESTART$22, i);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTNary insertNewNary(int i) {
        CTNary cTNaryInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTNaryInsert_element_user = get_store().insert_element_user(NARY$82, i);
        }
        return cTNaryInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTOMath insertNewOMath(int i) {
        CTOMath cTOMath;
        synchronized (monitor()) {
            check_orphaned();
            cTOMath = (CTOMath) get_store().insert_element_user(OMATH$56, i);
        }
        return cTOMath;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTOMathPara insertNewOMathPara(int i) {
        CTOMathPara cTOMathPara;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathPara = (CTOMathPara) get_store().insert_element_user(OMATHPARA$54, i);
        }
        return cTOMathPara;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTPerm insertNewPermEnd(int i) {
        CTPerm cTPermInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPermInsert_element_user = get_store().insert_element_user(PERMEND$12, i);
        }
        return cTPermInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTPermStart insertNewPermStart(int i) {
        CTPermStart cTPermStartInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPermStartInsert_element_user = get_store().insert_element_user(PERMSTART$10, i);
        }
        return cTPermStartInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTPhant insertNewPhant(int i) {
        CTPhant cTPhantInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPhantInsert_element_user = get_store().insert_element_user(PHANT$84, i);
        }
        return cTPhantInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTProofErr insertNewProofErr(int i) {
        CTProofErr cTProofErrInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErrInsert_element_user = get_store().insert_element_user(PROOFERR$8, i);
        }
        return cTProofErrInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTR insertNewR(int i) {
        CTR ctr;
        synchronized (monitor()) {
            check_orphaned();
            ctr = (CTR) get_store().insert_element_user(R$6, i);
        }
        return ctr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public org.openxmlformats.schemas.officeDocument.x2006.math.CTR insertNewR2(int i) {
        org.openxmlformats.schemas.officeDocument.x2006.math.CTR ctrInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctrInsert_element_user = get_store().insert_element_user(R2$96, i);
        }
        return ctrInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTRad insertNewRad(int i) {
        CTRad cTRadInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRadInsert_element_user = get_store().insert_element_user(RAD$86, i);
        }
        return cTRadInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSPre insertNewSPre(int i) {
        CTSPre cTSPreInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSPreInsert_element_user = get_store().insert_element_user(SPRE$88, i);
        }
        return cTSPreInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSSub insertNewSSub(int i) {
        CTSSub cTSSubInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSSubInsert_element_user = get_store().insert_element_user(SSUB$90, i);
        }
        return cTSSubInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSSubSup insertNewSSubSup(int i) {
        CTSSubSup cTSSubSupInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSSubSupInsert_element_user = get_store().insert_element_user(SSUBSUP$92, i);
        }
        return cTSSubSupInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSSup insertNewSSup(int i) {
        CTSSup cTSSupInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSSupInsert_element_user = get_store().insert_element_user(SSUP$94, i);
        }
        return cTSSupInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSdtRun insertNewSdt(int i) {
        CTSdtRun cTSdtRun;
        synchronized (monitor()) {
            check_orphaned();
            cTSdtRun = (CTSdtRun) get_store().insert_element_user(SDT$4, i);
        }
        return cTSdtRun;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSmartTagRun insertNewSmartTag(int i) {
        CTSmartTagRun cTSmartTagRunInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSmartTagRunInsert_element_user = get_store().insert_element_user(SMARTTAG$2, i);
        }
        return cTSmartTagRunInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeAcc(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ACC$58, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeBar(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BAR$60, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeBookmarkEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOOKMARKEND$16, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeBookmarkStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOOKMARKSTART$14, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeBorderBox(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERBOX$64, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeBox(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOX$62, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeCommentRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMMENTRANGEEND$28, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeCommentRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMMENTRANGESTART$26, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeCustomXml(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXML$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeCustomXmlDelRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLDELRANGEEND$36, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeCustomXmlDelRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLDELRANGESTART$34, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeCustomXmlInsRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLINSRANGEEND$32, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeCustomXmlInsRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLINSRANGESTART$30, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeCustomXmlMoveFromRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVEFROMRANGEEND$40, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeCustomXmlMoveFromRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVEFROMRANGESTART$38, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeCustomXmlMoveToRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVETORANGEEND$44, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeCustomXmlMoveToRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVETORANGESTART$42, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeD(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(D$66, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeDel(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DEL$48, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeEqArr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EQARR$68, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeF(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(F$70, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeFunc(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FUNC$72, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeGroupChr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GROUPCHR$74, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeIns(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(INS$46, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeLimLow(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LIMLOW$76, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeLimUpp(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LIMUPP$78, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeM(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(M$80, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeMoveFrom(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROM$50, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeMoveFromRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROMRANGEEND$20, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeMoveFromRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROMRANGESTART$18, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeMoveTo(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETO$52, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeMoveToRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETORANGEEND$24, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeMoveToRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETORANGESTART$22, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeNary(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NARY$82, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeOMath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OMATH$56, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeOMathPara(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OMATHPARA$54, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removePermEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PERMEND$12, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removePermStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PERMSTART$10, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removePhant(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PHANT$84, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeProofErr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROOFERR$8, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeR(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(R$6, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeR2(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(R2$96, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeRad(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RAD$86, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeSPre(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SPRE$88, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeSSub(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SSUB$90, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeSSubSup(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SSUBSUP$92, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeSSup(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SSUP$94, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeSdt(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SDT$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void removeSmartTag(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SMARTTAG$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setAccArray(int i, CTAcc cTAcc) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTAcc cTAccFind_element_user = get_store().find_element_user(ACC$58, i);
                if (cTAccFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTAccFind_element_user.set(cTAcc);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setBarArray(int i, CTBar cTBar) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTBar cTBarFind_element_user = get_store().find_element_user(BAR$60, i);
                if (cTBarFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTBarFind_element_user.set(cTBar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setBookmarkEndArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTMarkupRange cTMarkupRange2 = (CTMarkupRange) get_store().find_element_user(BOOKMARKEND$16, i);
                if (cTMarkupRange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTMarkupRange2.set(cTMarkupRange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setBookmarkStartArray(int i, CTBookmark cTBookmark) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTBookmark cTBookmark2 = (CTBookmark) get_store().find_element_user(BOOKMARKSTART$14, i);
                if (cTBookmark2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTBookmark2.set(cTBookmark);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setBorderBoxArray(int i, CTBorderBox cTBorderBox) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTBorderBox cTBorderBoxFind_element_user = get_store().find_element_user(BORDERBOX$64, i);
                if (cTBorderBoxFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTBorderBoxFind_element_user.set(cTBorderBox);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setBoxArray(int i, CTBox cTBox) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTBox cTBoxFind_element_user = get_store().find_element_user(BOX$62, i);
                if (cTBoxFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTBoxFind_element_user.set(cTBox);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setCommentRangeEndArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTMarkupRange cTMarkupRange2 = (CTMarkupRange) get_store().find_element_user(COMMENTRANGEEND$28, i);
                if (cTMarkupRange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTMarkupRange2.set(cTMarkupRange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setCommentRangeStartArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTMarkupRange cTMarkupRange2 = (CTMarkupRange) get_store().find_element_user(COMMENTRANGESTART$26, i);
                if (cTMarkupRange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTMarkupRange2.set(cTMarkupRange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setCustomXmlArray(int i, CTCustomXmlRun cTCustomXmlRun) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTCustomXmlRun cTCustomXmlRunFind_element_user = get_store().find_element_user(CUSTOMXML$0, i);
                if (cTCustomXmlRunFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTCustomXmlRunFind_element_user.set(cTCustomXmlRun);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setCustomXmlDelRangeEndArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTMarkup cTMarkup2 = (CTMarkup) get_store().find_element_user(CUSTOMXMLDELRANGEEND$36, i);
                if (cTMarkup2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTMarkup2.set(cTMarkup);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setCustomXmlDelRangeStartArray(int i, CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTrackChange cTTrackChange2 = (CTTrackChange) get_store().find_element_user(CUSTOMXMLDELRANGESTART$34, i);
                if (cTTrackChange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTTrackChange2.set(cTTrackChange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setCustomXmlInsRangeEndArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTMarkup cTMarkup2 = (CTMarkup) get_store().find_element_user(CUSTOMXMLINSRANGEEND$32, i);
                if (cTMarkup2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTMarkup2.set(cTMarkup);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setCustomXmlInsRangeStartArray(int i, CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTrackChange cTTrackChange2 = (CTTrackChange) get_store().find_element_user(CUSTOMXMLINSRANGESTART$30, i);
                if (cTTrackChange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTTrackChange2.set(cTTrackChange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setCustomXmlMoveFromRangeEndArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTMarkup cTMarkup2 = (CTMarkup) get_store().find_element_user(CUSTOMXMLMOVEFROMRANGEEND$40, i);
                if (cTMarkup2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTMarkup2.set(cTMarkup);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setCustomXmlMoveFromRangeStartArray(int i, CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTrackChange cTTrackChange2 = (CTTrackChange) get_store().find_element_user(CUSTOMXMLMOVEFROMRANGESTART$38, i);
                if (cTTrackChange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTTrackChange2.set(cTTrackChange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setCustomXmlMoveToRangeEndArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTMarkup cTMarkup2 = (CTMarkup) get_store().find_element_user(CUSTOMXMLMOVETORANGEEND$44, i);
                if (cTMarkup2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTMarkup2.set(cTMarkup);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setCustomXmlMoveToRangeStartArray(int i, CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTrackChange cTTrackChange2 = (CTTrackChange) get_store().find_element_user(CUSTOMXMLMOVETORANGESTART$42, i);
                if (cTTrackChange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTTrackChange2.set(cTTrackChange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setDArray(int i, CTD ctd) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTD ctdFind_element_user = get_store().find_element_user(D$66, i);
                if (ctdFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                ctdFind_element_user.set(ctd);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setDelArray(int i, CTRunTrackChange cTRunTrackChange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTRunTrackChange cTRunTrackChange2 = (CTRunTrackChange) get_store().find_element_user(DEL$48, i);
                if (cTRunTrackChange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTRunTrackChange2.set(cTRunTrackChange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setEqArrArray(int i, CTEqArr cTEqArr) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTEqArr cTEqArrFind_element_user = get_store().find_element_user(EQARR$68, i);
                if (cTEqArrFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTEqArrFind_element_user.set(cTEqArr);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setFArray(int i, CTF ctf) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTF ctfFind_element_user = get_store().find_element_user(F$70, i);
                if (ctfFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                ctfFind_element_user.set(ctf);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setFuncArray(int i, CTFunc cTFunc) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTFunc cTFuncFind_element_user = get_store().find_element_user(FUNC$72, i);
                if (cTFuncFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTFuncFind_element_user.set(cTFunc);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setGroupChrArray(int i, CTGroupChr cTGroupChr) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTGroupChr cTGroupChrFind_element_user = get_store().find_element_user(GROUPCHR$74, i);
                if (cTGroupChrFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTGroupChrFind_element_user.set(cTGroupChr);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setInsArray(int i, CTRunTrackChange cTRunTrackChange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTRunTrackChange cTRunTrackChange2 = (CTRunTrackChange) get_store().find_element_user(INS$46, i);
                if (cTRunTrackChange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTRunTrackChange2.set(cTRunTrackChange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setLimLowArray(int i, CTLimLow cTLimLow) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTLimLow cTLimLowFind_element_user = get_store().find_element_user(LIMLOW$76, i);
                if (cTLimLowFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTLimLowFind_element_user.set(cTLimLow);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setLimUppArray(int i, CTLimUpp cTLimUpp) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTLimUpp cTLimUppFind_element_user = get_store().find_element_user(LIMUPP$78, i);
                if (cTLimUppFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTLimUppFind_element_user.set(cTLimUpp);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setMArray(int i, CTM ctm) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTM ctmFind_element_user = get_store().find_element_user(M$80, i);
                if (ctmFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                ctmFind_element_user.set(ctm);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setMoveFromArray(int i, CTRunTrackChange cTRunTrackChange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTRunTrackChange cTRunTrackChange2 = (CTRunTrackChange) get_store().find_element_user(MOVEFROM$50, i);
                if (cTRunTrackChange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTRunTrackChange2.set(cTRunTrackChange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setMoveFromRangeEndArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTMarkupRange cTMarkupRange2 = (CTMarkupRange) get_store().find_element_user(MOVEFROMRANGEEND$20, i);
                if (cTMarkupRange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTMarkupRange2.set(cTMarkupRange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setMoveFromRangeStartArray(int i, CTMoveBookmark cTMoveBookmark) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTMoveBookmark cTMoveBookmark2 = (CTMoveBookmark) get_store().find_element_user(MOVEFROMRANGESTART$18, i);
                if (cTMoveBookmark2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTMoveBookmark2.set(cTMoveBookmark);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setMoveToArray(int i, CTRunTrackChange cTRunTrackChange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTRunTrackChange cTRunTrackChange2 = (CTRunTrackChange) get_store().find_element_user(MOVETO$52, i);
                if (cTRunTrackChange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTRunTrackChange2.set(cTRunTrackChange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setMoveToRangeEndArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTMarkupRange cTMarkupRange2 = (CTMarkupRange) get_store().find_element_user(MOVETORANGEEND$24, i);
                if (cTMarkupRange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTMarkupRange2.set(cTMarkupRange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setMoveToRangeStartArray(int i, CTMoveBookmark cTMoveBookmark) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTMoveBookmark cTMoveBookmark2 = (CTMoveBookmark) get_store().find_element_user(MOVETORANGESTART$22, i);
                if (cTMoveBookmark2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTMoveBookmark2.set(cTMoveBookmark);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setNaryArray(int i, CTNary cTNary) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTNary cTNaryFind_element_user = get_store().find_element_user(NARY$82, i);
                if (cTNaryFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTNaryFind_element_user.set(cTNary);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setOMathArray(int i, CTOMath cTOMath) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTOMath cTOMath2 = (CTOMath) get_store().find_element_user(OMATH$56, i);
                if (cTOMath2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTOMath2.set(cTOMath);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setOMathParaArray(int i, CTOMathPara cTOMathPara) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTOMathPara cTOMathPara2 = (CTOMathPara) get_store().find_element_user(OMATHPARA$54, i);
                if (cTOMathPara2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTOMathPara2.set(cTOMathPara);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setPermEndArray(int i, CTPerm cTPerm) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTPerm cTPermFind_element_user = get_store().find_element_user(PERMEND$12, i);
                if (cTPermFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTPermFind_element_user.set(cTPerm);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setPermStartArray(int i, CTPermStart cTPermStart) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTPermStart cTPermStartFind_element_user = get_store().find_element_user(PERMSTART$10, i);
                if (cTPermStartFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTPermStartFind_element_user.set(cTPermStart);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setPhantArray(int i, CTPhant cTPhant) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTPhant cTPhantFind_element_user = get_store().find_element_user(PHANT$84, i);
                if (cTPhantFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTPhantFind_element_user.set(cTPhant);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setProofErrArray(int i, CTProofErr cTProofErr) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTProofErr cTProofErrFind_element_user = get_store().find_element_user(PROOFERR$8, i);
                if (cTProofErrFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTProofErrFind_element_user.set(cTProofErr);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setR2Array(int i, org.openxmlformats.schemas.officeDocument.x2006.math.CTR ctr) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                org.openxmlformats.schemas.officeDocument.x2006.math.CTR ctrFind_element_user = get_store().find_element_user(R2$96, i);
                if (ctrFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                ctrFind_element_user.set(ctr);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setRArray(int i, CTR ctr) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTR ctr2 = (CTR) get_store().find_element_user(R$6, i);
                if (ctr2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                ctr2.set(ctr);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setRadArray(int i, CTRad cTRad) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTRad cTRadFind_element_user = get_store().find_element_user(RAD$86, i);
                if (cTRadFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTRadFind_element_user.set(cTRad);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setSPreArray(int i, CTSPre cTSPre) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTSPre cTSPreFind_element_user = get_store().find_element_user(SPRE$88, i);
                if (cTSPreFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTSPreFind_element_user.set(cTSPre);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setSSubArray(int i, CTSSub cTSSub) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTSSub cTSSubFind_element_user = get_store().find_element_user(SSUB$90, i);
                if (cTSSubFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTSSubFind_element_user.set(cTSSub);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setSSubSupArray(int i, CTSSubSup cTSSubSup) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTSSubSup cTSSubSupFind_element_user = get_store().find_element_user(SSUBSUP$92, i);
                if (cTSSubSupFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTSSubSupFind_element_user.set(cTSSubSup);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setSSupArray(int i, CTSSup cTSSup) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTSSup cTSSupFind_element_user = get_store().find_element_user(SSUP$94, i);
                if (cTSSupFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTSSupFind_element_user.set(cTSSup);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setSdtArray(int i, CTSdtRun cTSdtRun) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTSdtRun cTSdtRun2 = (CTSdtRun) get_store().find_element_user(SDT$4, i);
                if (cTSdtRun2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTSdtRun2.set(cTSdtRun);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setSmartTagArray(int i, CTSmartTagRun cTSmartTagRun) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTSmartTagRun cTSmartTagRunFind_element_user = get_store().find_element_user(SMARTTAG$2, i);
                if (cTSmartTagRunFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTSmartTagRunFind_element_user.set(cTSmartTagRun);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfAccArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ACC$58);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfBarArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BAR$60);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfBookmarkEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BOOKMARKEND$16);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfBookmarkStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BOOKMARKSTART$14);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfBorderBoxArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BORDERBOX$64);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfBoxArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BOX$62);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfCommentRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(COMMENTRANGEEND$28);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfCommentRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(COMMENTRANGESTART$26);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfCustomXmlArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXML$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfCustomXmlDelRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLDELRANGEEND$36);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfCustomXmlDelRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLDELRANGESTART$34);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfCustomXmlInsRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLINSRANGEEND$32);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfCustomXmlInsRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLINSRANGESTART$30);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfCustomXmlMoveFromRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLMOVEFROMRANGEEND$40);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfCustomXmlMoveFromRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLMOVEFROMRANGESTART$38);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfCustomXmlMoveToRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLMOVETORANGEEND$44);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfCustomXmlMoveToRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLMOVETORANGESTART$42);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfDArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(D$66);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfDelArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(DEL$48);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfEqArrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(EQARR$68);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfFArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(F$70);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfFuncArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(FUNC$72);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfGroupChrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(GROUPCHR$74);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfInsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(INS$46);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfLimLowArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(LIMLOW$76);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfLimUppArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(LIMUPP$78);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfMArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(M$80);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfMoveFromArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVEFROM$50);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfMoveFromRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVEFROMRANGEEND$20);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfMoveFromRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVEFROMRANGESTART$18);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfMoveToArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVETO$52);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfMoveToRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVETORANGEEND$24);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfMoveToRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVETORANGESTART$22);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfNaryArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(NARY$82);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfOMathArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(OMATH$56);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfOMathParaArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(OMATHPARA$54);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfPermEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PERMEND$12);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfPermStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PERMSTART$10);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfPhantArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PHANT$84);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfProofErrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROOFERR$8);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfR2Array() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(R2$96);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfRArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(R$6);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfRadArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(RAD$86);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfSPreArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SPRE$88);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfSSubArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SSUB$90);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfSSubSupArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SSUBSUP$92);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfSSupArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SSUP$94);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfSdtArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SDT$4);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public int sizeOfSmartTagArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SMARTTAG$2);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTAcc[] getAccArray() {
        CTAcc[] cTAccArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ACC$58, arrayList);
            cTAccArr = new CTAcc[arrayList.size()];
            arrayList.toArray(cTAccArr);
        }
        return cTAccArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTBar[] getBarArray() {
        CTBar[] cTBarArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BAR$60, arrayList);
            cTBarArr = new CTBar[arrayList.size()];
            arrayList.toArray(cTBarArr);
        }
        return cTBarArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkupRange[] getBookmarkEndArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BOOKMARKEND$16, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTBookmark[] getBookmarkStartArray() {
        CTBookmark[] cTBookmarkArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BOOKMARKSTART$14, arrayList);
            cTBookmarkArr = new CTBookmark[arrayList.size()];
            arrayList.toArray(cTBookmarkArr);
        }
        return cTBookmarkArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTBorderBox[] getBorderBoxArray() {
        CTBorderBox[] cTBorderBoxArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BORDERBOX$64, arrayList);
            cTBorderBoxArr = new CTBorderBox[arrayList.size()];
            arrayList.toArray(cTBorderBoxArr);
        }
        return cTBorderBoxArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTBox[] getBoxArray() {
        CTBox[] cTBoxArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BOX$62, arrayList);
            cTBoxArr = new CTBox[arrayList.size()];
            arrayList.toArray(cTBoxArr);
        }
        return cTBoxArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkupRange[] getCommentRangeEndArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COMMENTRANGEEND$28, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkupRange[] getCommentRangeStartArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COMMENTRANGESTART$26, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTCustomXmlRun[] getCustomXmlArray() {
        CTCustomXmlRun[] cTCustomXmlRunArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXML$0, arrayList);
            cTCustomXmlRunArr = new CTCustomXmlRun[arrayList.size()];
            arrayList.toArray(cTCustomXmlRunArr);
        }
        return cTCustomXmlRunArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkup[] getCustomXmlDelRangeEndArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLDELRANGEEND$36, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTTrackChange[] getCustomXmlDelRangeStartArray() {
        CTTrackChange[] cTTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLDELRANGESTART$34, arrayList);
            cTTrackChangeArr = new CTTrackChange[arrayList.size()];
            arrayList.toArray(cTTrackChangeArr);
        }
        return cTTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkup[] getCustomXmlInsRangeEndArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLINSRANGEEND$32, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTTrackChange[] getCustomXmlInsRangeStartArray() {
        CTTrackChange[] cTTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLINSRANGESTART$30, arrayList);
            cTTrackChangeArr = new CTTrackChange[arrayList.size()];
            arrayList.toArray(cTTrackChangeArr);
        }
        return cTTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkup[] getCustomXmlMoveFromRangeEndArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLMOVEFROMRANGEEND$40, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTTrackChange[] getCustomXmlMoveFromRangeStartArray() {
        CTTrackChange[] cTTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLMOVEFROMRANGESTART$38, arrayList);
            cTTrackChangeArr = new CTTrackChange[arrayList.size()];
            arrayList.toArray(cTTrackChangeArr);
        }
        return cTTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkup[] getCustomXmlMoveToRangeEndArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLMOVETORANGEEND$44, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTTrackChange[] getCustomXmlMoveToRangeStartArray() {
        CTTrackChange[] cTTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLMOVETORANGESTART$42, arrayList);
            cTTrackChangeArr = new CTTrackChange[arrayList.size()];
            arrayList.toArray(cTTrackChangeArr);
        }
        return cTTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTD[] getDArray() {
        CTD[] ctdArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(D$66, arrayList);
            ctdArr = new CTD[arrayList.size()];
            arrayList.toArray(ctdArr);
        }
        return ctdArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTRunTrackChange[] getDelArray() {
        CTRunTrackChange[] cTRunTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DEL$48, arrayList);
            cTRunTrackChangeArr = new CTRunTrackChange[arrayList.size()];
            arrayList.toArray(cTRunTrackChangeArr);
        }
        return cTRunTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTEqArr[] getEqArrArray() {
        CTEqArr[] cTEqArrArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(EQARR$68, arrayList);
            cTEqArrArr = new CTEqArr[arrayList.size()];
            arrayList.toArray(cTEqArrArr);
        }
        return cTEqArrArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTF[] getFArray() {
        CTF[] ctfArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(F$70, arrayList);
            ctfArr = new CTF[arrayList.size()];
            arrayList.toArray(ctfArr);
        }
        return ctfArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTFunc[] getFuncArray() {
        CTFunc[] cTFuncArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FUNC$72, arrayList);
            cTFuncArr = new CTFunc[arrayList.size()];
            arrayList.toArray(cTFuncArr);
        }
        return cTFuncArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTGroupChr[] getGroupChrArray() {
        CTGroupChr[] cTGroupChrArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(GROUPCHR$74, arrayList);
            cTGroupChrArr = new CTGroupChr[arrayList.size()];
            arrayList.toArray(cTGroupChrArr);
        }
        return cTGroupChrArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTRunTrackChange[] getInsArray() {
        CTRunTrackChange[] cTRunTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(INS$46, arrayList);
            cTRunTrackChangeArr = new CTRunTrackChange[arrayList.size()];
            arrayList.toArray(cTRunTrackChangeArr);
        }
        return cTRunTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTLimLow[] getLimLowArray() {
        CTLimLow[] cTLimLowArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LIMLOW$76, arrayList);
            cTLimLowArr = new CTLimLow[arrayList.size()];
            arrayList.toArray(cTLimLowArr);
        }
        return cTLimLowArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTLimUpp[] getLimUppArray() {
        CTLimUpp[] cTLimUppArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LIMUPP$78, arrayList);
            cTLimUppArr = new CTLimUpp[arrayList.size()];
            arrayList.toArray(cTLimUppArr);
        }
        return cTLimUppArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTM[] getMArray() {
        CTM[] ctmArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(M$80, arrayList);
            ctmArr = new CTM[arrayList.size()];
            arrayList.toArray(ctmArr);
        }
        return ctmArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTRunTrackChange[] getMoveFromArray() {
        CTRunTrackChange[] cTRunTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVEFROM$50, arrayList);
            cTRunTrackChangeArr = new CTRunTrackChange[arrayList.size()];
            arrayList.toArray(cTRunTrackChangeArr);
        }
        return cTRunTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkupRange[] getMoveFromRangeEndArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVEFROMRANGEEND$20, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMoveBookmark[] getMoveFromRangeStartArray() {
        CTMoveBookmark[] cTMoveBookmarkArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVEFROMRANGESTART$18, arrayList);
            cTMoveBookmarkArr = new CTMoveBookmark[arrayList.size()];
            arrayList.toArray(cTMoveBookmarkArr);
        }
        return cTMoveBookmarkArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTRunTrackChange[] getMoveToArray() {
        CTRunTrackChange[] cTRunTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVETO$52, arrayList);
            cTRunTrackChangeArr = new CTRunTrackChange[arrayList.size()];
            arrayList.toArray(cTRunTrackChangeArr);
        }
        return cTRunTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMarkupRange[] getMoveToRangeEndArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVETORANGEEND$24, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTMoveBookmark[] getMoveToRangeStartArray() {
        CTMoveBookmark[] cTMoveBookmarkArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVETORANGESTART$22, arrayList);
            cTMoveBookmarkArr = new CTMoveBookmark[arrayList.size()];
            arrayList.toArray(cTMoveBookmarkArr);
        }
        return cTMoveBookmarkArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTNary[] getNaryArray() {
        CTNary[] cTNaryArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(NARY$82, arrayList);
            cTNaryArr = new CTNary[arrayList.size()];
            arrayList.toArray(cTNaryArr);
        }
        return cTNaryArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTOMath[] getOMathArray() {
        CTOMath[] cTOMathArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(OMATH$56, arrayList);
            cTOMathArr = new CTOMath[arrayList.size()];
            arrayList.toArray(cTOMathArr);
        }
        return cTOMathArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTOMathPara[] getOMathParaArray() {
        CTOMathPara[] cTOMathParaArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(OMATHPARA$54, arrayList);
            cTOMathParaArr = new CTOMathPara[arrayList.size()];
            arrayList.toArray(cTOMathParaArr);
        }
        return cTOMathParaArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTPerm[] getPermEndArray() {
        CTPerm[] cTPermArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PERMEND$12, arrayList);
            cTPermArr = new CTPerm[arrayList.size()];
            arrayList.toArray(cTPermArr);
        }
        return cTPermArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTPermStart[] getPermStartArray() {
        CTPermStart[] cTPermStartArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PERMSTART$10, arrayList);
            cTPermStartArr = new CTPermStart[arrayList.size()];
            arrayList.toArray(cTPermStartArr);
        }
        return cTPermStartArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTPhant[] getPhantArray() {
        CTPhant[] cTPhantArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PHANT$84, arrayList);
            cTPhantArr = new CTPhant[arrayList.size()];
            arrayList.toArray(cTPhantArr);
        }
        return cTPhantArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTProofErr[] getProofErrArray() {
        CTProofErr[] cTProofErrArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PROOFERR$8, arrayList);
            cTProofErrArr = new CTProofErr[arrayList.size()];
            arrayList.toArray(cTProofErrArr);
        }
        return cTProofErrArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public org.openxmlformats.schemas.officeDocument.x2006.math.CTR[] getR2Array() {
        org.openxmlformats.schemas.officeDocument.x2006.math.CTR[] ctrArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(R2$96, arrayList);
            ctrArr = new org.openxmlformats.schemas.officeDocument.x2006.math.CTR[arrayList.size()];
            arrayList.toArray(ctrArr);
        }
        return ctrArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTR[] getRArray() {
        CTR[] ctrArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(R$6, arrayList);
            ctrArr = new CTR[arrayList.size()];
            arrayList.toArray(ctrArr);
        }
        return ctrArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTRad[] getRadArray() {
        CTRad[] cTRadArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(RAD$86, arrayList);
            cTRadArr = new CTRad[arrayList.size()];
            arrayList.toArray(cTRadArr);
        }
        return cTRadArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSPre[] getSPreArray() {
        CTSPre[] cTSPreArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SPRE$88, arrayList);
            cTSPreArr = new CTSPre[arrayList.size()];
            arrayList.toArray(cTSPreArr);
        }
        return cTSPreArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSSub[] getSSubArray() {
        CTSSub[] cTSSubArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SSUB$90, arrayList);
            cTSSubArr = new CTSSub[arrayList.size()];
            arrayList.toArray(cTSSubArr);
        }
        return cTSSubArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSSubSup[] getSSubSupArray() {
        CTSSubSup[] cTSSubSupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SSUBSUP$92, arrayList);
            cTSSubSupArr = new CTSSubSup[arrayList.size()];
            arrayList.toArray(cTSSubSupArr);
        }
        return cTSSubSupArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSSup[] getSSupArray() {
        CTSSup[] cTSSupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SSUP$94, arrayList);
            cTSSupArr = new CTSSup[arrayList.size()];
            arrayList.toArray(cTSSupArr);
        }
        return cTSSupArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSdtRun[] getSdtArray() {
        CTSdtRun[] cTSdtRunArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SDT$4, arrayList);
            cTSdtRunArr = new CTSdtRun[arrayList.size()];
            arrayList.toArray(cTSdtRunArr);
        }
        return cTSdtRunArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public CTSmartTagRun[] getSmartTagArray() {
        CTSmartTagRun[] cTSmartTagRunArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SMARTTAG$2, arrayList);
            cTSmartTagRunArr = new CTSmartTagRun[arrayList.size()];
            arrayList.toArray(cTSmartTagRunArr);
        }
        return cTSmartTagRunArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setAccArray(CTAcc[] cTAccArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTAccArr, ACC$58);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setBarArray(CTBar[] cTBarArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBarArr, BAR$60);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setBookmarkEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, BOOKMARKEND$16);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setBookmarkStartArray(CTBookmark[] cTBookmarkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBookmarkArr, BOOKMARKSTART$14);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setBorderBoxArray(CTBorderBox[] cTBorderBoxArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBorderBoxArr, BORDERBOX$64);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setBoxArray(CTBox[] cTBoxArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBoxArr, BOX$62);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setCommentRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, COMMENTRANGEEND$28);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setCommentRangeStartArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, COMMENTRANGESTART$26);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setCustomXmlArray(CTCustomXmlRun[] cTCustomXmlRunArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTCustomXmlRunArr, CUSTOMXML$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setCustomXmlDelRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLDELRANGEEND$36);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setCustomXmlDelRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLDELRANGESTART$34);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setCustomXmlInsRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLINSRANGEEND$32);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setCustomXmlInsRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLINSRANGESTART$30);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setCustomXmlMoveFromRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLMOVEFROMRANGEEND$40);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setCustomXmlMoveFromRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLMOVEFROMRANGESTART$38);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setCustomXmlMoveToRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLMOVETORANGEEND$44);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setCustomXmlMoveToRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLMOVETORANGESTART$42);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setDArray(CTD[] ctdArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(ctdArr, D$66);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setDelArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, DEL$48);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setEqArrArray(CTEqArr[] cTEqArrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTEqArrArr, EQARR$68);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setFArray(CTF[] ctfArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(ctfArr, F$70);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setFuncArray(CTFunc[] cTFuncArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTFuncArr, FUNC$72);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setGroupChrArray(CTGroupChr[] cTGroupChrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTGroupChrArr, GROUPCHR$74);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setInsArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, INS$46);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setLimLowArray(CTLimLow[] cTLimLowArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTLimLowArr, LIMLOW$76);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setLimUppArray(CTLimUpp[] cTLimUppArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTLimUppArr, LIMUPP$78);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setMArray(CTM[] ctmArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(ctmArr, M$80);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setMoveFromArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, MOVEFROM$50);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setMoveFromRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, MOVEFROMRANGEEND$20);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setMoveFromRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMoveBookmarkArr, MOVEFROMRANGESTART$18);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setMoveToArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, MOVETO$52);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setMoveToRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, MOVETORANGEEND$24);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setMoveToRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMoveBookmarkArr, MOVETORANGESTART$22);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setNaryArray(CTNary[] cTNaryArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTNaryArr, NARY$82);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setOMathArray(CTOMath[] cTOMathArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTOMathArr, OMATH$56);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setOMathParaArray(CTOMathPara[] cTOMathParaArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTOMathParaArr, OMATHPARA$54);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setPermEndArray(CTPerm[] cTPermArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPermArr, PERMEND$12);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setPermStartArray(CTPermStart[] cTPermStartArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPermStartArr, PERMSTART$10);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setPhantArray(CTPhant[] cTPhantArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPhantArr, PHANT$84);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setProofErrArray(CTProofErr[] cTProofErrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTProofErrArr, PROOFERR$8);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setR2Array(org.openxmlformats.schemas.officeDocument.x2006.math.CTR[] ctrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(ctrArr, R2$96);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setRArray(CTR[] ctrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(ctrArr, R$6);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setRadArray(CTRad[] cTRadArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRadArr, RAD$86);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setSPreArray(CTSPre[] cTSPreArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSPreArr, SPRE$88);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setSSubArray(CTSSub[] cTSSubArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSSubArr, SSUB$90);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setSSubSupArray(CTSSubSup[] cTSSubSupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSSubSupArr, SSUBSUP$92);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setSSupArray(CTSSup[] cTSSupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSSupArr, SSUP$94);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setSdtArray(CTSdtRun[] cTSdtRunArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSdtRunArr, SDT$4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRunTrackChange
    public void setSmartTagArray(CTSmartTagRun[] cTSmartTagRunArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTSmartTagRunArr, SMARTTAG$2);
        }
    }
}
