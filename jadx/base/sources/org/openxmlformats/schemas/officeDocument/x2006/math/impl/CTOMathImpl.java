package org.openxmlformats.schemas.officeDocument.x2006.math.impl;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
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
public class CTOMathImpl extends XmlComplexContentImpl implements CTOMath {
    private static final QName ACC$0 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "acc");
    private static final QName BAR$2 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "bar");
    private static final QName BOX$4 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "box");
    private static final QName BORDERBOX$6 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "borderBox");
    private static final QName D$8 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "d");
    private static final QName EQARR$10 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "eqArr");
    private static final QName F$12 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "f");
    private static final QName FUNC$14 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "func");
    private static final QName GROUPCHR$16 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "groupChr");
    private static final QName LIMLOW$18 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "limLow");
    private static final QName LIMUPP$20 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "limUpp");
    private static final QName M$22 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "m");
    private static final QName NARY$24 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "nary");
    private static final QName PHANT$26 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "phant");
    private static final QName RAD$28 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "rad");
    private static final QName SPRE$30 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "sPre");
    private static final QName SSUB$32 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "sSub");
    private static final QName SSUBSUP$34 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "sSubSup");
    private static final QName SSUP$36 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "sSup");
    private static final QName R$38 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "r");
    private static final QName PROOFERR$40 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "proofErr");
    private static final QName PERMSTART$42 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "permStart");
    private static final QName PERMEND$44 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "permEnd");
    private static final QName BOOKMARKSTART$46 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bookmarkStart");
    private static final QName BOOKMARKEND$48 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bookmarkEnd");
    private static final QName MOVEFROMRANGESTART$50 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFromRangeStart");
    private static final QName MOVEFROMRANGEEND$52 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFromRangeEnd");
    private static final QName MOVETORANGESTART$54 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveToRangeStart");
    private static final QName MOVETORANGEEND$56 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveToRangeEnd");
    private static final QName COMMENTRANGESTART$58 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "commentRangeStart");
    private static final QName COMMENTRANGEEND$60 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "commentRangeEnd");
    private static final QName CUSTOMXMLINSRANGESTART$62 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlInsRangeStart");
    private static final QName CUSTOMXMLINSRANGEEND$64 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlInsRangeEnd");
    private static final QName CUSTOMXMLDELRANGESTART$66 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlDelRangeStart");
    private static final QName CUSTOMXMLDELRANGEEND$68 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlDelRangeEnd");
    private static final QName CUSTOMXMLMOVEFROMRANGESTART$70 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveFromRangeStart");
    private static final QName CUSTOMXMLMOVEFROMRANGEEND$72 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveFromRangeEnd");
    private static final QName CUSTOMXMLMOVETORANGESTART$74 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveToRangeStart");
    private static final QName CUSTOMXMLMOVETORANGEEND$76 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customXmlMoveToRangeEnd");
    private static final QName INS$78 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ins");
    private static final QName DEL$80 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "del");
    private static final QName MOVEFROM$82 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveFrom");
    private static final QName MOVETO$84 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "moveTo");
    private static final QName OMATHPARA$86 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "oMathPara");
    private static final QName OMATH$88 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "oMath");

    public CTOMathImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTAcc addNewAcc() {
        CTAcc cTAccAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAccAdd_element_user = get_store().add_element_user(ACC$0);
        }
        return cTAccAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTBar addNewBar() {
        CTBar cTBarAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBarAdd_element_user = get_store().add_element_user(BAR$2);
        }
        return cTBarAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMarkupRange addNewBookmarkEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(BOOKMARKEND$48);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTBookmark addNewBookmarkStart() {
        CTBookmark cTBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmark = (CTBookmark) get_store().add_element_user(BOOKMARKSTART$46);
        }
        return cTBookmark;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTBorderBox addNewBorderBox() {
        CTBorderBox cTBorderBoxAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderBoxAdd_element_user = get_store().add_element_user(BORDERBOX$6);
        }
        return cTBorderBoxAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTBox addNewBox() {
        CTBox cTBoxAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBoxAdd_element_user = get_store().add_element_user(BOX$4);
        }
        return cTBoxAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMarkupRange addNewCommentRangeEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(COMMENTRANGEEND$60);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMarkupRange addNewCommentRangeStart() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(COMMENTRANGESTART$58);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMarkup addNewCustomXmlDelRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(CUSTOMXMLDELRANGEEND$68);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTTrackChange addNewCustomXmlDelRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(CUSTOMXMLDELRANGESTART$66);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMarkup addNewCustomXmlInsRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(CUSTOMXMLINSRANGEEND$64);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTTrackChange addNewCustomXmlInsRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(CUSTOMXMLINSRANGESTART$62);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMarkup addNewCustomXmlMoveFromRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(CUSTOMXMLMOVEFROMRANGEEND$72);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTTrackChange addNewCustomXmlMoveFromRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(CUSTOMXMLMOVEFROMRANGESTART$70);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMarkup addNewCustomXmlMoveToRangeEnd() {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().add_element_user(CUSTOMXMLMOVETORANGEEND$76);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTTrackChange addNewCustomXmlMoveToRangeStart() {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().add_element_user(CUSTOMXMLMOVETORANGESTART$74);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTD addNewD() {
        CTD ctdAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctdAdd_element_user = get_store().add_element_user(D$8);
        }
        return ctdAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTRunTrackChange addNewDel() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(DEL$80);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTEqArr addNewEqArr() {
        CTEqArr cTEqArrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEqArrAdd_element_user = get_store().add_element_user(EQARR$10);
        }
        return cTEqArrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTF addNewF() {
        CTF ctfAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctfAdd_element_user = get_store().add_element_user(F$12);
        }
        return ctfAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTFunc addNewFunc() {
        CTFunc cTFuncAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFuncAdd_element_user = get_store().add_element_user(FUNC$14);
        }
        return cTFuncAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTGroupChr addNewGroupChr() {
        CTGroupChr cTGroupChrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupChrAdd_element_user = get_store().add_element_user(GROUPCHR$16);
        }
        return cTGroupChrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTRunTrackChange addNewIns() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(INS$78);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTLimLow addNewLimLow() {
        CTLimLow cTLimLowAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLimLowAdd_element_user = get_store().add_element_user(LIMLOW$18);
        }
        return cTLimLowAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTLimUpp addNewLimUpp() {
        CTLimUpp cTLimUppAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLimUppAdd_element_user = get_store().add_element_user(LIMUPP$20);
        }
        return cTLimUppAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTM addNewM() {
        CTM ctmAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctmAdd_element_user = get_store().add_element_user(M$22);
        }
        return ctmAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTRunTrackChange addNewMoveFrom() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(MOVEFROM$82);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMarkupRange addNewMoveFromRangeEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(MOVEFROMRANGEEND$52);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMoveBookmark addNewMoveFromRangeStart() {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().add_element_user(MOVEFROMRANGESTART$50);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTRunTrackChange addNewMoveTo() {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().add_element_user(MOVETO$84);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMarkupRange addNewMoveToRangeEnd() {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().add_element_user(MOVETORANGEEND$56);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMoveBookmark addNewMoveToRangeStart() {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().add_element_user(MOVETORANGESTART$54);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTNary addNewNary() {
        CTNary cTNaryAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTNaryAdd_element_user = get_store().add_element_user(NARY$24);
        }
        return cTNaryAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTOMath addNewOMath() {
        CTOMath cTOMath;
        synchronized (monitor()) {
            check_orphaned();
            cTOMath = (CTOMath) get_store().add_element_user(OMATH$88);
        }
        return cTOMath;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTOMathPara addNewOMathPara() {
        CTOMathPara cTOMathPara;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathPara = (CTOMathPara) get_store().add_element_user(OMATHPARA$86);
        }
        return cTOMathPara;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTPerm addNewPermEnd() {
        CTPerm cTPermAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPermAdd_element_user = get_store().add_element_user(PERMEND$44);
        }
        return cTPermAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTPermStart addNewPermStart() {
        CTPermStart cTPermStartAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPermStartAdd_element_user = get_store().add_element_user(PERMSTART$42);
        }
        return cTPermStartAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTPhant addNewPhant() {
        CTPhant cTPhantAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPhantAdd_element_user = get_store().add_element_user(PHANT$26);
        }
        return cTPhantAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTProofErr addNewProofErr() {
        CTProofErr cTProofErrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErrAdd_element_user = get_store().add_element_user(PROOFERR$40);
        }
        return cTProofErrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTR addNewR() {
        CTR ctrAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctrAdd_element_user = get_store().add_element_user(R$38);
        }
        return ctrAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTRad addNewRad() {
        CTRad cTRadAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRadAdd_element_user = get_store().add_element_user(RAD$28);
        }
        return cTRadAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTSPre addNewSPre() {
        CTSPre cTSPreAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSPreAdd_element_user = get_store().add_element_user(SPRE$30);
        }
        return cTSPreAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTSSub addNewSSub() {
        CTSSub cTSSubAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSSubAdd_element_user = get_store().add_element_user(SSUB$32);
        }
        return cTSSubAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTSSubSup addNewSSubSup() {
        CTSSubSup cTSSubSupAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSSubSupAdd_element_user = get_store().add_element_user(SSUBSUP$34);
        }
        return cTSSubSupAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTSSup addNewSSup() {
        CTSSup cTSSupAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSSupAdd_element_user = get_store().add_element_user(SSUP$36);
        }
        return cTSSupAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTAcc getAccArray(int i) {
        CTAcc cTAccFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTAccFind_element_user = get_store().find_element_user(ACC$0, i);
                if (cTAccFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTAccFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTAcc> getAccList() {
        AbstractList<CTAcc> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTAcc>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1AccList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfAccArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTAcc cTAcc) {
                    CTOMathImpl.this.insertNewAcc(i).set(cTAcc);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTAcc get(int i) {
                    return CTOMathImpl.this.getAccArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTAcc remove(int i) {
                    CTAcc accArray = CTOMathImpl.this.getAccArray(i);
                    CTOMathImpl.this.removeAcc(i);
                    return accArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTAcc set(int i, CTAcc cTAcc) {
                    CTAcc accArray = CTOMathImpl.this.getAccArray(i);
                    CTOMathImpl.this.setAccArray(i, cTAcc);
                    return accArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTBar getBarArray(int i) {
        CTBar cTBarFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTBarFind_element_user = get_store().find_element_user(BAR$2, i);
                if (cTBarFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTBarFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTBar> getBarList() {
        AbstractList<CTBar> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTBar>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1BarList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfBarArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTBar cTBar) {
                    CTOMathImpl.this.insertNewBar(i).set(cTBar);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBar get(int i) {
                    return CTOMathImpl.this.getBarArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBar remove(int i) {
                    CTBar barArray = CTOMathImpl.this.getBarArray(i);
                    CTOMathImpl.this.removeBar(i);
                    return barArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBar set(int i, CTBar cTBar) {
                    CTBar barArray = CTOMathImpl.this.getBarArray(i);
                    CTOMathImpl.this.setBarArray(i, cTBar);
                    return barArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMarkupRange getBookmarkEndArray(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTMarkupRange = (CTMarkupRange) get_store().find_element_user(BOOKMARKEND$48, i);
                if (cTMarkupRange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTMarkupRange> getBookmarkEndList() {
        AbstractList<CTMarkupRange> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTMarkupRange>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1BookmarkEndList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfBookmarkEndArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTMarkupRange cTMarkupRange) {
                    CTOMathImpl.this.insertNewBookmarkEnd(i).set(cTMarkupRange);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkupRange get(int i) {
                    return CTOMathImpl.this.getBookmarkEndArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkupRange remove(int i) {
                    CTMarkupRange bookmarkEndArray = CTOMathImpl.this.getBookmarkEndArray(i);
                    CTOMathImpl.this.removeBookmarkEnd(i);
                    return bookmarkEndArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkupRange set(int i, CTMarkupRange cTMarkupRange) {
                    CTMarkupRange bookmarkEndArray = CTOMathImpl.this.getBookmarkEndArray(i);
                    CTOMathImpl.this.setBookmarkEndArray(i, cTMarkupRange);
                    return bookmarkEndArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTBookmark getBookmarkStartArray(int i) {
        CTBookmark cTBookmark;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTBookmark = (CTBookmark) get_store().find_element_user(BOOKMARKSTART$46, i);
                if (cTBookmark == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTBookmark;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTBookmark> getBookmarkStartList() {
        AbstractList<CTBookmark> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTBookmark>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1BookmarkStartList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfBookmarkStartArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTBookmark cTBookmark) {
                    CTOMathImpl.this.insertNewBookmarkStart(i).set(cTBookmark);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBookmark get(int i) {
                    return CTOMathImpl.this.getBookmarkStartArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBookmark remove(int i) {
                    CTBookmark bookmarkStartArray = CTOMathImpl.this.getBookmarkStartArray(i);
                    CTOMathImpl.this.removeBookmarkStart(i);
                    return bookmarkStartArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBookmark set(int i, CTBookmark cTBookmark) {
                    CTBookmark bookmarkStartArray = CTOMathImpl.this.getBookmarkStartArray(i);
                    CTOMathImpl.this.setBookmarkStartArray(i, cTBookmark);
                    return bookmarkStartArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTBorderBox getBorderBoxArray(int i) {
        CTBorderBox cTBorderBoxFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTBorderBoxFind_element_user = get_store().find_element_user(BORDERBOX$6, i);
                if (cTBorderBoxFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTBorderBoxFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTBorderBox> getBorderBoxList() {
        AbstractList<CTBorderBox> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTBorderBox>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1BorderBoxList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfBorderBoxArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTBorderBox cTBorderBox) {
                    CTOMathImpl.this.insertNewBorderBox(i).set(cTBorderBox);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorderBox get(int i) {
                    return CTOMathImpl.this.getBorderBoxArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorderBox remove(int i) {
                    CTBorderBox borderBoxArray = CTOMathImpl.this.getBorderBoxArray(i);
                    CTOMathImpl.this.removeBorderBox(i);
                    return borderBoxArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBorderBox set(int i, CTBorderBox cTBorderBox) {
                    CTBorderBox borderBoxArray = CTOMathImpl.this.getBorderBoxArray(i);
                    CTOMathImpl.this.setBorderBoxArray(i, cTBorderBox);
                    return borderBoxArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTBox getBoxArray(int i) {
        CTBox cTBoxFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTBoxFind_element_user = get_store().find_element_user(BOX$4, i);
                if (cTBoxFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTBoxFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTBox> getBoxList() {
        AbstractList<CTBox> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTBox>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1BoxList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfBoxArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTBox cTBox) {
                    CTOMathImpl.this.insertNewBox(i).set(cTBox);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBox get(int i) {
                    return CTOMathImpl.this.getBoxArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBox remove(int i) {
                    CTBox boxArray = CTOMathImpl.this.getBoxArray(i);
                    CTOMathImpl.this.removeBox(i);
                    return boxArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTBox set(int i, CTBox cTBox) {
                    CTBox boxArray = CTOMathImpl.this.getBoxArray(i);
                    CTOMathImpl.this.setBoxArray(i, cTBox);
                    return boxArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMarkupRange getCommentRangeEndArray(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTMarkupRange = (CTMarkupRange) get_store().find_element_user(COMMENTRANGEEND$60, i);
                if (cTMarkupRange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTMarkupRange> getCommentRangeEndList() {
        AbstractList<CTMarkupRange> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTMarkupRange>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1CommentRangeEndList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfCommentRangeEndArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTMarkupRange cTMarkupRange) {
                    CTOMathImpl.this.insertNewCommentRangeEnd(i).set(cTMarkupRange);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkupRange get(int i) {
                    return CTOMathImpl.this.getCommentRangeEndArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkupRange remove(int i) {
                    CTMarkupRange commentRangeEndArray = CTOMathImpl.this.getCommentRangeEndArray(i);
                    CTOMathImpl.this.removeCommentRangeEnd(i);
                    return commentRangeEndArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkupRange set(int i, CTMarkupRange cTMarkupRange) {
                    CTMarkupRange commentRangeEndArray = CTOMathImpl.this.getCommentRangeEndArray(i);
                    CTOMathImpl.this.setCommentRangeEndArray(i, cTMarkupRange);
                    return commentRangeEndArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMarkupRange getCommentRangeStartArray(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTMarkupRange = (CTMarkupRange) get_store().find_element_user(COMMENTRANGESTART$58, i);
                if (cTMarkupRange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTMarkupRange> getCommentRangeStartList() {
        AbstractList<CTMarkupRange> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTMarkupRange>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1CommentRangeStartList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfCommentRangeStartArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTMarkupRange cTMarkupRange) {
                    CTOMathImpl.this.insertNewCommentRangeStart(i).set(cTMarkupRange);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkupRange get(int i) {
                    return CTOMathImpl.this.getCommentRangeStartArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkupRange remove(int i) {
                    CTMarkupRange commentRangeStartArray = CTOMathImpl.this.getCommentRangeStartArray(i);
                    CTOMathImpl.this.removeCommentRangeStart(i);
                    return commentRangeStartArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkupRange set(int i, CTMarkupRange cTMarkupRange) {
                    CTMarkupRange commentRangeStartArray = CTOMathImpl.this.getCommentRangeStartArray(i);
                    CTOMathImpl.this.setCommentRangeStartArray(i, cTMarkupRange);
                    return commentRangeStartArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMarkup getCustomXmlDelRangeEndArray(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTMarkup = (CTMarkup) get_store().find_element_user(CUSTOMXMLDELRANGEEND$68, i);
                if (cTMarkup == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTMarkup> getCustomXmlDelRangeEndList() {
        AbstractList<CTMarkup> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTMarkup>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1CustomXmlDelRangeEndList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfCustomXmlDelRangeEndArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTMarkup cTMarkup) {
                    CTOMathImpl.this.insertNewCustomXmlDelRangeEnd(i).set(cTMarkup);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkup get(int i) {
                    return CTOMathImpl.this.getCustomXmlDelRangeEndArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkup remove(int i) {
                    CTMarkup customXmlDelRangeEndArray = CTOMathImpl.this.getCustomXmlDelRangeEndArray(i);
                    CTOMathImpl.this.removeCustomXmlDelRangeEnd(i);
                    return customXmlDelRangeEndArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkup set(int i, CTMarkup cTMarkup) {
                    CTMarkup customXmlDelRangeEndArray = CTOMathImpl.this.getCustomXmlDelRangeEndArray(i);
                    CTOMathImpl.this.setCustomXmlDelRangeEndArray(i, cTMarkup);
                    return customXmlDelRangeEndArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTTrackChange getCustomXmlDelRangeStartArray(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTrackChange = (CTTrackChange) get_store().find_element_user(CUSTOMXMLDELRANGESTART$66, i);
                if (cTTrackChange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTTrackChange> getCustomXmlDelRangeStartList() {
        AbstractList<CTTrackChange> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTTrackChange>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1CustomXmlDelRangeStartList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfCustomXmlDelRangeStartArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTTrackChange cTTrackChange) {
                    CTOMathImpl.this.insertNewCustomXmlDelRangeStart(i).set(cTTrackChange);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTrackChange get(int i) {
                    return CTOMathImpl.this.getCustomXmlDelRangeStartArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTrackChange remove(int i) {
                    CTTrackChange customXmlDelRangeStartArray = CTOMathImpl.this.getCustomXmlDelRangeStartArray(i);
                    CTOMathImpl.this.removeCustomXmlDelRangeStart(i);
                    return customXmlDelRangeStartArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTrackChange set(int i, CTTrackChange cTTrackChange) {
                    CTTrackChange customXmlDelRangeStartArray = CTOMathImpl.this.getCustomXmlDelRangeStartArray(i);
                    CTOMathImpl.this.setCustomXmlDelRangeStartArray(i, cTTrackChange);
                    return customXmlDelRangeStartArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMarkup getCustomXmlInsRangeEndArray(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTMarkup = (CTMarkup) get_store().find_element_user(CUSTOMXMLINSRANGEEND$64, i);
                if (cTMarkup == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTMarkup> getCustomXmlInsRangeEndList() {
        AbstractList<CTMarkup> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTMarkup>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1CustomXmlInsRangeEndList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfCustomXmlInsRangeEndArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTMarkup cTMarkup) {
                    CTOMathImpl.this.insertNewCustomXmlInsRangeEnd(i).set(cTMarkup);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkup get(int i) {
                    return CTOMathImpl.this.getCustomXmlInsRangeEndArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkup remove(int i) {
                    CTMarkup customXmlInsRangeEndArray = CTOMathImpl.this.getCustomXmlInsRangeEndArray(i);
                    CTOMathImpl.this.removeCustomXmlInsRangeEnd(i);
                    return customXmlInsRangeEndArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkup set(int i, CTMarkup cTMarkup) {
                    CTMarkup customXmlInsRangeEndArray = CTOMathImpl.this.getCustomXmlInsRangeEndArray(i);
                    CTOMathImpl.this.setCustomXmlInsRangeEndArray(i, cTMarkup);
                    return customXmlInsRangeEndArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTTrackChange getCustomXmlInsRangeStartArray(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTrackChange = (CTTrackChange) get_store().find_element_user(CUSTOMXMLINSRANGESTART$62, i);
                if (cTTrackChange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTTrackChange> getCustomXmlInsRangeStartList() {
        AbstractList<CTTrackChange> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTTrackChange>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1CustomXmlInsRangeStartList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfCustomXmlInsRangeStartArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTTrackChange cTTrackChange) {
                    CTOMathImpl.this.insertNewCustomXmlInsRangeStart(i).set(cTTrackChange);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTrackChange get(int i) {
                    return CTOMathImpl.this.getCustomXmlInsRangeStartArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTrackChange remove(int i) {
                    CTTrackChange customXmlInsRangeStartArray = CTOMathImpl.this.getCustomXmlInsRangeStartArray(i);
                    CTOMathImpl.this.removeCustomXmlInsRangeStart(i);
                    return customXmlInsRangeStartArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTrackChange set(int i, CTTrackChange cTTrackChange) {
                    CTTrackChange customXmlInsRangeStartArray = CTOMathImpl.this.getCustomXmlInsRangeStartArray(i);
                    CTOMathImpl.this.setCustomXmlInsRangeStartArray(i, cTTrackChange);
                    return customXmlInsRangeStartArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMarkup getCustomXmlMoveFromRangeEndArray(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTMarkup = (CTMarkup) get_store().find_element_user(CUSTOMXMLMOVEFROMRANGEEND$72, i);
                if (cTMarkup == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTMarkup> getCustomXmlMoveFromRangeEndList() {
        AbstractList<CTMarkup> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTMarkup>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1CustomXmlMoveFromRangeEndList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfCustomXmlMoveFromRangeEndArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTMarkup cTMarkup) {
                    CTOMathImpl.this.insertNewCustomXmlMoveFromRangeEnd(i).set(cTMarkup);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkup get(int i) {
                    return CTOMathImpl.this.getCustomXmlMoveFromRangeEndArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkup remove(int i) {
                    CTMarkup customXmlMoveFromRangeEndArray = CTOMathImpl.this.getCustomXmlMoveFromRangeEndArray(i);
                    CTOMathImpl.this.removeCustomXmlMoveFromRangeEnd(i);
                    return customXmlMoveFromRangeEndArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkup set(int i, CTMarkup cTMarkup) {
                    CTMarkup customXmlMoveFromRangeEndArray = CTOMathImpl.this.getCustomXmlMoveFromRangeEndArray(i);
                    CTOMathImpl.this.setCustomXmlMoveFromRangeEndArray(i, cTMarkup);
                    return customXmlMoveFromRangeEndArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTTrackChange getCustomXmlMoveFromRangeStartArray(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTrackChange = (CTTrackChange) get_store().find_element_user(CUSTOMXMLMOVEFROMRANGESTART$70, i);
                if (cTTrackChange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTTrackChange> getCustomXmlMoveFromRangeStartList() {
        AbstractList<CTTrackChange> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTTrackChange>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1CustomXmlMoveFromRangeStartList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfCustomXmlMoveFromRangeStartArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTTrackChange cTTrackChange) {
                    CTOMathImpl.this.insertNewCustomXmlMoveFromRangeStart(i).set(cTTrackChange);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTrackChange get(int i) {
                    return CTOMathImpl.this.getCustomXmlMoveFromRangeStartArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTrackChange remove(int i) {
                    CTTrackChange customXmlMoveFromRangeStartArray = CTOMathImpl.this.getCustomXmlMoveFromRangeStartArray(i);
                    CTOMathImpl.this.removeCustomXmlMoveFromRangeStart(i);
                    return customXmlMoveFromRangeStartArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTrackChange set(int i, CTTrackChange cTTrackChange) {
                    CTTrackChange customXmlMoveFromRangeStartArray = CTOMathImpl.this.getCustomXmlMoveFromRangeStartArray(i);
                    CTOMathImpl.this.setCustomXmlMoveFromRangeStartArray(i, cTTrackChange);
                    return customXmlMoveFromRangeStartArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMarkup getCustomXmlMoveToRangeEndArray(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTMarkup = (CTMarkup) get_store().find_element_user(CUSTOMXMLMOVETORANGEEND$76, i);
                if (cTMarkup == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTMarkup> getCustomXmlMoveToRangeEndList() {
        AbstractList<CTMarkup> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTMarkup>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1CustomXmlMoveToRangeEndList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfCustomXmlMoveToRangeEndArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTMarkup cTMarkup) {
                    CTOMathImpl.this.insertNewCustomXmlMoveToRangeEnd(i).set(cTMarkup);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkup get(int i) {
                    return CTOMathImpl.this.getCustomXmlMoveToRangeEndArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkup remove(int i) {
                    CTMarkup customXmlMoveToRangeEndArray = CTOMathImpl.this.getCustomXmlMoveToRangeEndArray(i);
                    CTOMathImpl.this.removeCustomXmlMoveToRangeEnd(i);
                    return customXmlMoveToRangeEndArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkup set(int i, CTMarkup cTMarkup) {
                    CTMarkup customXmlMoveToRangeEndArray = CTOMathImpl.this.getCustomXmlMoveToRangeEndArray(i);
                    CTOMathImpl.this.setCustomXmlMoveToRangeEndArray(i, cTMarkup);
                    return customXmlMoveToRangeEndArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTTrackChange getCustomXmlMoveToRangeStartArray(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTrackChange = (CTTrackChange) get_store().find_element_user(CUSTOMXMLMOVETORANGESTART$74, i);
                if (cTTrackChange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTTrackChange> getCustomXmlMoveToRangeStartList() {
        AbstractList<CTTrackChange> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTTrackChange>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1CustomXmlMoveToRangeStartList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfCustomXmlMoveToRangeStartArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTTrackChange cTTrackChange) {
                    CTOMathImpl.this.insertNewCustomXmlMoveToRangeStart(i).set(cTTrackChange);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTrackChange get(int i) {
                    return CTOMathImpl.this.getCustomXmlMoveToRangeStartArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTrackChange remove(int i) {
                    CTTrackChange customXmlMoveToRangeStartArray = CTOMathImpl.this.getCustomXmlMoveToRangeStartArray(i);
                    CTOMathImpl.this.removeCustomXmlMoveToRangeStart(i);
                    return customXmlMoveToRangeStartArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTrackChange set(int i, CTTrackChange cTTrackChange) {
                    CTTrackChange customXmlMoveToRangeStartArray = CTOMathImpl.this.getCustomXmlMoveToRangeStartArray(i);
                    CTOMathImpl.this.setCustomXmlMoveToRangeStartArray(i, cTTrackChange);
                    return customXmlMoveToRangeStartArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTD getDArray(int i) {
        CTD ctdFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                ctdFind_element_user = get_store().find_element_user(D$8, i);
                if (ctdFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return ctdFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTD> getDList() {
        AbstractList<CTD> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTD>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1DList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfDArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTD ctd) {
                    CTOMathImpl.this.insertNewD(i).set(ctd);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTD get(int i) {
                    return CTOMathImpl.this.getDArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTD remove(int i) {
                    CTD dArray = CTOMathImpl.this.getDArray(i);
                    CTOMathImpl.this.removeD(i);
                    return dArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTD set(int i, CTD ctd) {
                    CTD dArray = CTOMathImpl.this.getDArray(i);
                    CTOMathImpl.this.setDArray(i, ctd);
                    return dArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTRunTrackChange getDelArray(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTRunTrackChange = (CTRunTrackChange) get_store().find_element_user(DEL$80, i);
                if (cTRunTrackChange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTRunTrackChange> getDelList() {
        AbstractList<CTRunTrackChange> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTRunTrackChange>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1DelList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfDelArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTRunTrackChange cTRunTrackChange) {
                    CTOMathImpl.this.insertNewDel(i).set(cTRunTrackChange);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRunTrackChange get(int i) {
                    return CTOMathImpl.this.getDelArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRunTrackChange remove(int i) {
                    CTRunTrackChange delArray = CTOMathImpl.this.getDelArray(i);
                    CTOMathImpl.this.removeDel(i);
                    return delArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRunTrackChange set(int i, CTRunTrackChange cTRunTrackChange) {
                    CTRunTrackChange delArray = CTOMathImpl.this.getDelArray(i);
                    CTOMathImpl.this.setDelArray(i, cTRunTrackChange);
                    return delArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTEqArr getEqArrArray(int i) {
        CTEqArr cTEqArrFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTEqArrFind_element_user = get_store().find_element_user(EQARR$10, i);
                if (cTEqArrFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTEqArrFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTEqArr> getEqArrList() {
        AbstractList<CTEqArr> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTEqArr>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1EqArrList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfEqArrArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTEqArr cTEqArr) {
                    CTOMathImpl.this.insertNewEqArr(i).set(cTEqArr);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTEqArr get(int i) {
                    return CTOMathImpl.this.getEqArrArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTEqArr remove(int i) {
                    CTEqArr eqArrArray = CTOMathImpl.this.getEqArrArray(i);
                    CTOMathImpl.this.removeEqArr(i);
                    return eqArrArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTEqArr set(int i, CTEqArr cTEqArr) {
                    CTEqArr eqArrArray = CTOMathImpl.this.getEqArrArray(i);
                    CTOMathImpl.this.setEqArrArray(i, cTEqArr);
                    return eqArrArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTF getFArray(int i) {
        CTF ctfFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                ctfFind_element_user = get_store().find_element_user(F$12, i);
                if (ctfFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return ctfFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTF> getFList() {
        AbstractList<CTF> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTF>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1FList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfFArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTF ctf) {
                    CTOMathImpl.this.insertNewF(i).set(ctf);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTF get(int i) {
                    return CTOMathImpl.this.getFArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTF remove(int i) {
                    CTF fArray = CTOMathImpl.this.getFArray(i);
                    CTOMathImpl.this.removeF(i);
                    return fArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTF set(int i, CTF ctf) {
                    CTF fArray = CTOMathImpl.this.getFArray(i);
                    CTOMathImpl.this.setFArray(i, ctf);
                    return fArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTFunc getFuncArray(int i) {
        CTFunc cTFuncFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTFuncFind_element_user = get_store().find_element_user(FUNC$14, i);
                if (cTFuncFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTFuncFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTFunc> getFuncList() {
        AbstractList<CTFunc> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTFunc>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1FuncList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfFuncArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTFunc cTFunc) {
                    CTOMathImpl.this.insertNewFunc(i).set(cTFunc);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTFunc get(int i) {
                    return CTOMathImpl.this.getFuncArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTFunc remove(int i) {
                    CTFunc funcArray = CTOMathImpl.this.getFuncArray(i);
                    CTOMathImpl.this.removeFunc(i);
                    return funcArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTFunc set(int i, CTFunc cTFunc) {
                    CTFunc funcArray = CTOMathImpl.this.getFuncArray(i);
                    CTOMathImpl.this.setFuncArray(i, cTFunc);
                    return funcArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTGroupChr getGroupChrArray(int i) {
        CTGroupChr cTGroupChrFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTGroupChrFind_element_user = get_store().find_element_user(GROUPCHR$16, i);
                if (cTGroupChrFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTGroupChrFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTGroupChr> getGroupChrList() {
        AbstractList<CTGroupChr> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTGroupChr>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1GroupChrList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfGroupChrArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTGroupChr cTGroupChr) {
                    CTOMathImpl.this.insertNewGroupChr(i).set(cTGroupChr);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTGroupChr get(int i) {
                    return CTOMathImpl.this.getGroupChrArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTGroupChr remove(int i) {
                    CTGroupChr groupChrArray = CTOMathImpl.this.getGroupChrArray(i);
                    CTOMathImpl.this.removeGroupChr(i);
                    return groupChrArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTGroupChr set(int i, CTGroupChr cTGroupChr) {
                    CTGroupChr groupChrArray = CTOMathImpl.this.getGroupChrArray(i);
                    CTOMathImpl.this.setGroupChrArray(i, cTGroupChr);
                    return groupChrArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTRunTrackChange getInsArray(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTRunTrackChange = (CTRunTrackChange) get_store().find_element_user(INS$78, i);
                if (cTRunTrackChange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTRunTrackChange> getInsList() {
        AbstractList<CTRunTrackChange> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTRunTrackChange>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1InsList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfInsArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTRunTrackChange cTRunTrackChange) {
                    CTOMathImpl.this.insertNewIns(i).set(cTRunTrackChange);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRunTrackChange get(int i) {
                    return CTOMathImpl.this.getInsArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRunTrackChange remove(int i) {
                    CTRunTrackChange insArray = CTOMathImpl.this.getInsArray(i);
                    CTOMathImpl.this.removeIns(i);
                    return insArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRunTrackChange set(int i, CTRunTrackChange cTRunTrackChange) {
                    CTRunTrackChange insArray = CTOMathImpl.this.getInsArray(i);
                    CTOMathImpl.this.setInsArray(i, cTRunTrackChange);
                    return insArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTLimLow getLimLowArray(int i) {
        CTLimLow cTLimLowFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTLimLowFind_element_user = get_store().find_element_user(LIMLOW$18, i);
                if (cTLimLowFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTLimLowFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTLimLow> getLimLowList() {
        AbstractList<CTLimLow> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTLimLow>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1LimLowList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfLimLowArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTLimLow cTLimLow) {
                    CTOMathImpl.this.insertNewLimLow(i).set(cTLimLow);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTLimLow get(int i) {
                    return CTOMathImpl.this.getLimLowArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTLimLow remove(int i) {
                    CTLimLow limLowArray = CTOMathImpl.this.getLimLowArray(i);
                    CTOMathImpl.this.removeLimLow(i);
                    return limLowArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTLimLow set(int i, CTLimLow cTLimLow) {
                    CTLimLow limLowArray = CTOMathImpl.this.getLimLowArray(i);
                    CTOMathImpl.this.setLimLowArray(i, cTLimLow);
                    return limLowArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTLimUpp getLimUppArray(int i) {
        CTLimUpp cTLimUppFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTLimUppFind_element_user = get_store().find_element_user(LIMUPP$20, i);
                if (cTLimUppFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTLimUppFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTLimUpp> getLimUppList() {
        AbstractList<CTLimUpp> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTLimUpp>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1LimUppList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfLimUppArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTLimUpp cTLimUpp) {
                    CTOMathImpl.this.insertNewLimUpp(i).set(cTLimUpp);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTLimUpp get(int i) {
                    return CTOMathImpl.this.getLimUppArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTLimUpp remove(int i) {
                    CTLimUpp limUppArray = CTOMathImpl.this.getLimUppArray(i);
                    CTOMathImpl.this.removeLimUpp(i);
                    return limUppArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTLimUpp set(int i, CTLimUpp cTLimUpp) {
                    CTLimUpp limUppArray = CTOMathImpl.this.getLimUppArray(i);
                    CTOMathImpl.this.setLimUppArray(i, cTLimUpp);
                    return limUppArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTM getMArray(int i) {
        CTM ctmFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                ctmFind_element_user = get_store().find_element_user(M$22, i);
                if (ctmFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return ctmFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTM> getMList() {
        AbstractList<CTM> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTM>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1MList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfMArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTM ctm) {
                    CTOMathImpl.this.insertNewM(i).set(ctm);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTM get(int i) {
                    return CTOMathImpl.this.getMArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTM remove(int i) {
                    CTM mArray = CTOMathImpl.this.getMArray(i);
                    CTOMathImpl.this.removeM(i);
                    return mArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTM set(int i, CTM ctm) {
                    CTM mArray = CTOMathImpl.this.getMArray(i);
                    CTOMathImpl.this.setMArray(i, ctm);
                    return mArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTRunTrackChange getMoveFromArray(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTRunTrackChange = (CTRunTrackChange) get_store().find_element_user(MOVEFROM$82, i);
                if (cTRunTrackChange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTRunTrackChange> getMoveFromList() {
        AbstractList<CTRunTrackChange> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTRunTrackChange>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1MoveFromList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfMoveFromArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTRunTrackChange cTRunTrackChange) {
                    CTOMathImpl.this.insertNewMoveFrom(i).set(cTRunTrackChange);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRunTrackChange get(int i) {
                    return CTOMathImpl.this.getMoveFromArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRunTrackChange remove(int i) {
                    CTRunTrackChange moveFromArray = CTOMathImpl.this.getMoveFromArray(i);
                    CTOMathImpl.this.removeMoveFrom(i);
                    return moveFromArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRunTrackChange set(int i, CTRunTrackChange cTRunTrackChange) {
                    CTRunTrackChange moveFromArray = CTOMathImpl.this.getMoveFromArray(i);
                    CTOMathImpl.this.setMoveFromArray(i, cTRunTrackChange);
                    return moveFromArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMarkupRange getMoveFromRangeEndArray(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTMarkupRange = (CTMarkupRange) get_store().find_element_user(MOVEFROMRANGEEND$52, i);
                if (cTMarkupRange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTMarkupRange> getMoveFromRangeEndList() {
        AbstractList<CTMarkupRange> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTMarkupRange>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1MoveFromRangeEndList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfMoveFromRangeEndArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTMarkupRange cTMarkupRange) {
                    CTOMathImpl.this.insertNewMoveFromRangeEnd(i).set(cTMarkupRange);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkupRange get(int i) {
                    return CTOMathImpl.this.getMoveFromRangeEndArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkupRange remove(int i) {
                    CTMarkupRange moveFromRangeEndArray = CTOMathImpl.this.getMoveFromRangeEndArray(i);
                    CTOMathImpl.this.removeMoveFromRangeEnd(i);
                    return moveFromRangeEndArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkupRange set(int i, CTMarkupRange cTMarkupRange) {
                    CTMarkupRange moveFromRangeEndArray = CTOMathImpl.this.getMoveFromRangeEndArray(i);
                    CTOMathImpl.this.setMoveFromRangeEndArray(i, cTMarkupRange);
                    return moveFromRangeEndArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMoveBookmark getMoveFromRangeStartArray(int i) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTMoveBookmark = (CTMoveBookmark) get_store().find_element_user(MOVEFROMRANGESTART$50, i);
                if (cTMoveBookmark == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTMoveBookmark> getMoveFromRangeStartList() {
        AbstractList<CTMoveBookmark> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTMoveBookmark>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1MoveFromRangeStartList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfMoveFromRangeStartArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTMoveBookmark cTMoveBookmark) {
                    CTOMathImpl.this.insertNewMoveFromRangeStart(i).set(cTMoveBookmark);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMoveBookmark get(int i) {
                    return CTOMathImpl.this.getMoveFromRangeStartArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMoveBookmark remove(int i) {
                    CTMoveBookmark moveFromRangeStartArray = CTOMathImpl.this.getMoveFromRangeStartArray(i);
                    CTOMathImpl.this.removeMoveFromRangeStart(i);
                    return moveFromRangeStartArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMoveBookmark set(int i, CTMoveBookmark cTMoveBookmark) {
                    CTMoveBookmark moveFromRangeStartArray = CTOMathImpl.this.getMoveFromRangeStartArray(i);
                    CTOMathImpl.this.setMoveFromRangeStartArray(i, cTMoveBookmark);
                    return moveFromRangeStartArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTRunTrackChange getMoveToArray(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTRunTrackChange = (CTRunTrackChange) get_store().find_element_user(MOVETO$84, i);
                if (cTRunTrackChange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTRunTrackChange> getMoveToList() {
        AbstractList<CTRunTrackChange> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTRunTrackChange>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1MoveToList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfMoveToArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTRunTrackChange cTRunTrackChange) {
                    CTOMathImpl.this.insertNewMoveTo(i).set(cTRunTrackChange);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRunTrackChange get(int i) {
                    return CTOMathImpl.this.getMoveToArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRunTrackChange remove(int i) {
                    CTRunTrackChange moveToArray = CTOMathImpl.this.getMoveToArray(i);
                    CTOMathImpl.this.removeMoveTo(i);
                    return moveToArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRunTrackChange set(int i, CTRunTrackChange cTRunTrackChange) {
                    CTRunTrackChange moveToArray = CTOMathImpl.this.getMoveToArray(i);
                    CTOMathImpl.this.setMoveToArray(i, cTRunTrackChange);
                    return moveToArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMarkupRange getMoveToRangeEndArray(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTMarkupRange = (CTMarkupRange) get_store().find_element_user(MOVETORANGEEND$56, i);
                if (cTMarkupRange == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTMarkupRange> getMoveToRangeEndList() {
        AbstractList<CTMarkupRange> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTMarkupRange>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1MoveToRangeEndList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfMoveToRangeEndArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTMarkupRange cTMarkupRange) {
                    CTOMathImpl.this.insertNewMoveToRangeEnd(i).set(cTMarkupRange);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkupRange get(int i) {
                    return CTOMathImpl.this.getMoveToRangeEndArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkupRange remove(int i) {
                    CTMarkupRange moveToRangeEndArray = CTOMathImpl.this.getMoveToRangeEndArray(i);
                    CTOMathImpl.this.removeMoveToRangeEnd(i);
                    return moveToRangeEndArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMarkupRange set(int i, CTMarkupRange cTMarkupRange) {
                    CTMarkupRange moveToRangeEndArray = CTOMathImpl.this.getMoveToRangeEndArray(i);
                    CTOMathImpl.this.setMoveToRangeEndArray(i, cTMarkupRange);
                    return moveToRangeEndArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMoveBookmark getMoveToRangeStartArray(int i) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTMoveBookmark = (CTMoveBookmark) get_store().find_element_user(MOVETORANGESTART$54, i);
                if (cTMoveBookmark == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTMoveBookmark> getMoveToRangeStartList() {
        AbstractList<CTMoveBookmark> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTMoveBookmark>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1MoveToRangeStartList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfMoveToRangeStartArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTMoveBookmark cTMoveBookmark) {
                    CTOMathImpl.this.insertNewMoveToRangeStart(i).set(cTMoveBookmark);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMoveBookmark get(int i) {
                    return CTOMathImpl.this.getMoveToRangeStartArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMoveBookmark remove(int i) {
                    CTMoveBookmark moveToRangeStartArray = CTOMathImpl.this.getMoveToRangeStartArray(i);
                    CTOMathImpl.this.removeMoveToRangeStart(i);
                    return moveToRangeStartArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTMoveBookmark set(int i, CTMoveBookmark cTMoveBookmark) {
                    CTMoveBookmark moveToRangeStartArray = CTOMathImpl.this.getMoveToRangeStartArray(i);
                    CTOMathImpl.this.setMoveToRangeStartArray(i, cTMoveBookmark);
                    return moveToRangeStartArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTNary getNaryArray(int i) {
        CTNary cTNaryFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTNaryFind_element_user = get_store().find_element_user(NARY$24, i);
                if (cTNaryFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTNaryFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTNary> getNaryList() {
        AbstractList<CTNary> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTNary>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1NaryList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfNaryArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTNary cTNary) {
                    CTOMathImpl.this.insertNewNary(i).set(cTNary);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTNary get(int i) {
                    return CTOMathImpl.this.getNaryArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTNary remove(int i) {
                    CTNary naryArray = CTOMathImpl.this.getNaryArray(i);
                    CTOMathImpl.this.removeNary(i);
                    return naryArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTNary set(int i, CTNary cTNary) {
                    CTNary naryArray = CTOMathImpl.this.getNaryArray(i);
                    CTOMathImpl.this.setNaryArray(i, cTNary);
                    return naryArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTOMath getOMathArray(int i) {
        CTOMath cTOMath;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTOMath = (CTOMath) get_store().find_element_user(OMATH$88, i);
                if (cTOMath == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTOMath;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTOMath> getOMathList() {
        AbstractList<CTOMath> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTOMath>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1OMathList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfOMathArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTOMath cTOMath) {
                    CTOMathImpl.this.insertNewOMath(i).set(cTOMath);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTOMath get(int i) {
                    return CTOMathImpl.this.getOMathArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTOMath remove(int i) {
                    CTOMath oMathArray = CTOMathImpl.this.getOMathArray(i);
                    CTOMathImpl.this.removeOMath(i);
                    return oMathArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTOMath set(int i, CTOMath cTOMath) {
                    CTOMath oMathArray = CTOMathImpl.this.getOMathArray(i);
                    CTOMathImpl.this.setOMathArray(i, cTOMath);
                    return oMathArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTOMathPara getOMathParaArray(int i) {
        CTOMathPara cTOMathPara;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTOMathPara = (CTOMathPara) get_store().find_element_user(OMATHPARA$86, i);
                if (cTOMathPara == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTOMathPara;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTOMathPara> getOMathParaList() {
        AbstractList<CTOMathPara> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTOMathPara>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1OMathParaList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfOMathParaArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTOMathPara cTOMathPara) {
                    CTOMathImpl.this.insertNewOMathPara(i).set(cTOMathPara);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTOMathPara get(int i) {
                    return CTOMathImpl.this.getOMathParaArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTOMathPara remove(int i) {
                    CTOMathPara oMathParaArray = CTOMathImpl.this.getOMathParaArray(i);
                    CTOMathImpl.this.removeOMathPara(i);
                    return oMathParaArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTOMathPara set(int i, CTOMathPara cTOMathPara) {
                    CTOMathPara oMathParaArray = CTOMathImpl.this.getOMathParaArray(i);
                    CTOMathImpl.this.setOMathParaArray(i, cTOMathPara);
                    return oMathParaArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTPerm getPermEndArray(int i) {
        CTPerm cTPermFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTPermFind_element_user = get_store().find_element_user(PERMEND$44, i);
                if (cTPermFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTPermFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTPerm> getPermEndList() {
        AbstractList<CTPerm> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTPerm>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1PermEndList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfPermEndArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTPerm cTPerm) {
                    CTOMathImpl.this.insertNewPermEnd(i).set(cTPerm);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTPerm get(int i) {
                    return CTOMathImpl.this.getPermEndArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTPerm remove(int i) {
                    CTPerm permEndArray = CTOMathImpl.this.getPermEndArray(i);
                    CTOMathImpl.this.removePermEnd(i);
                    return permEndArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTPerm set(int i, CTPerm cTPerm) {
                    CTPerm permEndArray = CTOMathImpl.this.getPermEndArray(i);
                    CTOMathImpl.this.setPermEndArray(i, cTPerm);
                    return permEndArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTPermStart getPermStartArray(int i) {
        CTPermStart cTPermStartFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTPermStartFind_element_user = get_store().find_element_user(PERMSTART$42, i);
                if (cTPermStartFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTPermStartFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTPermStart> getPermStartList() {
        AbstractList<CTPermStart> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTPermStart>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1PermStartList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfPermStartArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTPermStart cTPermStart) {
                    CTOMathImpl.this.insertNewPermStart(i).set(cTPermStart);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTPermStart get(int i) {
                    return CTOMathImpl.this.getPermStartArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTPermStart remove(int i) {
                    CTPermStart permStartArray = CTOMathImpl.this.getPermStartArray(i);
                    CTOMathImpl.this.removePermStart(i);
                    return permStartArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTPermStart set(int i, CTPermStart cTPermStart) {
                    CTPermStart permStartArray = CTOMathImpl.this.getPermStartArray(i);
                    CTOMathImpl.this.setPermStartArray(i, cTPermStart);
                    return permStartArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTPhant getPhantArray(int i) {
        CTPhant cTPhantFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTPhantFind_element_user = get_store().find_element_user(PHANT$26, i);
                if (cTPhantFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTPhantFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTPhant> getPhantList() {
        AbstractList<CTPhant> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTPhant>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1PhantList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfPhantArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTPhant cTPhant) {
                    CTOMathImpl.this.insertNewPhant(i).set(cTPhant);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTPhant get(int i) {
                    return CTOMathImpl.this.getPhantArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTPhant remove(int i) {
                    CTPhant phantArray = CTOMathImpl.this.getPhantArray(i);
                    CTOMathImpl.this.removePhant(i);
                    return phantArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTPhant set(int i, CTPhant cTPhant) {
                    CTPhant phantArray = CTOMathImpl.this.getPhantArray(i);
                    CTOMathImpl.this.setPhantArray(i, cTPhant);
                    return phantArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTProofErr getProofErrArray(int i) {
        CTProofErr cTProofErrFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTProofErrFind_element_user = get_store().find_element_user(PROOFERR$40, i);
                if (cTProofErrFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTProofErrFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTProofErr> getProofErrList() {
        1ProofErrList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1ProofErrList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTR getRArray(int i) {
        CTR ctrFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                ctrFind_element_user = get_store().find_element_user(R$38, i);
                if (ctrFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return ctrFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTR> getRList() {
        AbstractList<CTR> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTR>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1RList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfRArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTR ctr) {
                    CTOMathImpl.this.insertNewR(i).set(ctr);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTR get(int i) {
                    return CTOMathImpl.this.getRArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTR remove(int i) {
                    CTR rArray = CTOMathImpl.this.getRArray(i);
                    CTOMathImpl.this.removeR(i);
                    return rArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTR set(int i, CTR ctr) {
                    CTR rArray = CTOMathImpl.this.getRArray(i);
                    CTOMathImpl.this.setRArray(i, ctr);
                    return rArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTRad getRadArray(int i) {
        CTRad cTRadFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTRadFind_element_user = get_store().find_element_user(RAD$28, i);
                if (cTRadFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTRadFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTRad> getRadList() {
        AbstractList<CTRad> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTRad>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1RadList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfRadArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTRad cTRad) {
                    CTOMathImpl.this.insertNewRad(i).set(cTRad);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRad get(int i) {
                    return CTOMathImpl.this.getRadArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRad remove(int i) {
                    CTRad radArray = CTOMathImpl.this.getRadArray(i);
                    CTOMathImpl.this.removeRad(i);
                    return radArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTRad set(int i, CTRad cTRad) {
                    CTRad radArray = CTOMathImpl.this.getRadArray(i);
                    CTOMathImpl.this.setRadArray(i, cTRad);
                    return radArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTSPre getSPreArray(int i) {
        CTSPre cTSPreFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTSPreFind_element_user = get_store().find_element_user(SPRE$30, i);
                if (cTSPreFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTSPreFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTSPre> getSPreList() {
        AbstractList<CTSPre> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTSPre>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1SPreList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfSPreArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTSPre cTSPre) {
                    CTOMathImpl.this.insertNewSPre(i).set(cTSPre);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSPre get(int i) {
                    return CTOMathImpl.this.getSPreArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSPre remove(int i) {
                    CTSPre sPreArray = CTOMathImpl.this.getSPreArray(i);
                    CTOMathImpl.this.removeSPre(i);
                    return sPreArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSPre set(int i, CTSPre cTSPre) {
                    CTSPre sPreArray = CTOMathImpl.this.getSPreArray(i);
                    CTOMathImpl.this.setSPreArray(i, cTSPre);
                    return sPreArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTSSub getSSubArray(int i) {
        CTSSub cTSSubFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTSSubFind_element_user = get_store().find_element_user(SSUB$32, i);
                if (cTSSubFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTSSubFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTSSub> getSSubList() {
        AbstractList<CTSSub> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTSSub>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1SSubList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfSSubArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTSSub cTSSub) {
                    CTOMathImpl.this.insertNewSSub(i).set(cTSSub);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSSub get(int i) {
                    return CTOMathImpl.this.getSSubArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSSub remove(int i) {
                    CTSSub sSubArray = CTOMathImpl.this.getSSubArray(i);
                    CTOMathImpl.this.removeSSub(i);
                    return sSubArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSSub set(int i, CTSSub cTSSub) {
                    CTSSub sSubArray = CTOMathImpl.this.getSSubArray(i);
                    CTOMathImpl.this.setSSubArray(i, cTSSub);
                    return sSubArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTSSubSup getSSubSupArray(int i) {
        CTSSubSup cTSSubSupFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTSSubSupFind_element_user = get_store().find_element_user(SSUBSUP$34, i);
                if (cTSSubSupFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTSSubSupFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTSSubSup> getSSubSupList() {
        AbstractList<CTSSubSup> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTSSubSup>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1SSubSupList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfSSubSupArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTSSubSup cTSSubSup) {
                    CTOMathImpl.this.insertNewSSubSup(i).set(cTSSubSup);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSSubSup get(int i) {
                    return CTOMathImpl.this.getSSubSupArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSSubSup remove(int i) {
                    CTSSubSup sSubSupArray = CTOMathImpl.this.getSSubSupArray(i);
                    CTOMathImpl.this.removeSSubSup(i);
                    return sSubSupArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSSubSup set(int i, CTSSubSup cTSSubSup) {
                    CTSSubSup sSubSupArray = CTOMathImpl.this.getSSubSupArray(i);
                    CTOMathImpl.this.setSSubSupArray(i, cTSSubSup);
                    return sSubSupArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTSSup getSSupArray(int i) {
        CTSSup cTSSupFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTSSupFind_element_user = get_store().find_element_user(SSUP$36, i);
                if (cTSSupFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTSSupFind_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public List<CTSSup> getSSupList() {
        AbstractList<CTSSup> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTSSup>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathImpl.1SSupList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathImpl.this.sizeOfSSupArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTSSup cTSSup) {
                    CTOMathImpl.this.insertNewSSup(i).set(cTSSup);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSSup get(int i) {
                    return CTOMathImpl.this.getSSupArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSSup remove(int i) {
                    CTSSup sSupArray = CTOMathImpl.this.getSSupArray(i);
                    CTOMathImpl.this.removeSSup(i);
                    return sSupArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTSSup set(int i, CTSSup cTSSup) {
                    CTSSup sSupArray = CTOMathImpl.this.getSSupArray(i);
                    CTOMathImpl.this.setSSupArray(i, cTSSup);
                    return sSupArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTAcc insertNewAcc(int i) {
        CTAcc cTAccInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAccInsert_element_user = get_store().insert_element_user(ACC$0, i);
        }
        return cTAccInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTBar insertNewBar(int i) {
        CTBar cTBarInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBarInsert_element_user = get_store().insert_element_user(BAR$2, i);
        }
        return cTBarInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMarkupRange insertNewBookmarkEnd(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(BOOKMARKEND$48, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTBookmark insertNewBookmarkStart(int i) {
        CTBookmark cTBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTBookmark = (CTBookmark) get_store().insert_element_user(BOOKMARKSTART$46, i);
        }
        return cTBookmark;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTBorderBox insertNewBorderBox(int i) {
        CTBorderBox cTBorderBoxInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBorderBoxInsert_element_user = get_store().insert_element_user(BORDERBOX$6, i);
        }
        return cTBorderBoxInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTBox insertNewBox(int i) {
        CTBox cTBoxInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBoxInsert_element_user = get_store().insert_element_user(BOX$4, i);
        }
        return cTBoxInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMarkupRange insertNewCommentRangeEnd(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(COMMENTRANGEEND$60, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMarkupRange insertNewCommentRangeStart(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(COMMENTRANGESTART$58, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMarkup insertNewCustomXmlDelRangeEnd(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(CUSTOMXMLDELRANGEEND$68, i);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTTrackChange insertNewCustomXmlDelRangeStart(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(CUSTOMXMLDELRANGESTART$66, i);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMarkup insertNewCustomXmlInsRangeEnd(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(CUSTOMXMLINSRANGEEND$64, i);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTTrackChange insertNewCustomXmlInsRangeStart(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(CUSTOMXMLINSRANGESTART$62, i);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMarkup insertNewCustomXmlMoveFromRangeEnd(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(CUSTOMXMLMOVEFROMRANGEEND$72, i);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTTrackChange insertNewCustomXmlMoveFromRangeStart(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(CUSTOMXMLMOVEFROMRANGESTART$70, i);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMarkup insertNewCustomXmlMoveToRangeEnd(int i) {
        CTMarkup cTMarkup;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkup = (CTMarkup) get_store().insert_element_user(CUSTOMXMLMOVETORANGEEND$76, i);
        }
        return cTMarkup;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTTrackChange insertNewCustomXmlMoveToRangeStart(int i) {
        CTTrackChange cTTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTTrackChange = (CTTrackChange) get_store().insert_element_user(CUSTOMXMLMOVETORANGESTART$74, i);
        }
        return cTTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTD insertNewD(int i) {
        CTD ctdInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctdInsert_element_user = get_store().insert_element_user(D$8, i);
        }
        return ctdInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTRunTrackChange insertNewDel(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(DEL$80, i);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTEqArr insertNewEqArr(int i) {
        CTEqArr cTEqArrInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEqArrInsert_element_user = get_store().insert_element_user(EQARR$10, i);
        }
        return cTEqArrInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTF insertNewF(int i) {
        CTF ctfInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctfInsert_element_user = get_store().insert_element_user(F$12, i);
        }
        return ctfInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTFunc insertNewFunc(int i) {
        CTFunc cTFuncInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTFuncInsert_element_user = get_store().insert_element_user(FUNC$14, i);
        }
        return cTFuncInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTGroupChr insertNewGroupChr(int i) {
        CTGroupChr cTGroupChrInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupChrInsert_element_user = get_store().insert_element_user(GROUPCHR$16, i);
        }
        return cTGroupChrInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTRunTrackChange insertNewIns(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(INS$78, i);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTLimLow insertNewLimLow(int i) {
        CTLimLow cTLimLowInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLimLowInsert_element_user = get_store().insert_element_user(LIMLOW$18, i);
        }
        return cTLimLowInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTLimUpp insertNewLimUpp(int i) {
        CTLimUpp cTLimUppInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTLimUppInsert_element_user = get_store().insert_element_user(LIMUPP$20, i);
        }
        return cTLimUppInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTM insertNewM(int i) {
        CTM ctmInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctmInsert_element_user = get_store().insert_element_user(M$22, i);
        }
        return ctmInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTRunTrackChange insertNewMoveFrom(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(MOVEFROM$82, i);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMarkupRange insertNewMoveFromRangeEnd(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(MOVEFROMRANGEEND$52, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMoveBookmark insertNewMoveFromRangeStart(int i) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().insert_element_user(MOVEFROMRANGESTART$50, i);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTRunTrackChange insertNewMoveTo(int i) {
        CTRunTrackChange cTRunTrackChange;
        synchronized (monitor()) {
            check_orphaned();
            cTRunTrackChange = (CTRunTrackChange) get_store().insert_element_user(MOVETO$84, i);
        }
        return cTRunTrackChange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMarkupRange insertNewMoveToRangeEnd(int i) {
        CTMarkupRange cTMarkupRange;
        synchronized (monitor()) {
            check_orphaned();
            cTMarkupRange = (CTMarkupRange) get_store().insert_element_user(MOVETORANGEEND$56, i);
        }
        return cTMarkupRange;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMoveBookmark insertNewMoveToRangeStart(int i) {
        CTMoveBookmark cTMoveBookmark;
        synchronized (monitor()) {
            check_orphaned();
            cTMoveBookmark = (CTMoveBookmark) get_store().insert_element_user(MOVETORANGESTART$54, i);
        }
        return cTMoveBookmark;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTNary insertNewNary(int i) {
        CTNary cTNaryInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTNaryInsert_element_user = get_store().insert_element_user(NARY$24, i);
        }
        return cTNaryInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTOMath insertNewOMath(int i) {
        CTOMath cTOMath;
        synchronized (monitor()) {
            check_orphaned();
            cTOMath = (CTOMath) get_store().insert_element_user(OMATH$88, i);
        }
        return cTOMath;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTOMathPara insertNewOMathPara(int i) {
        CTOMathPara cTOMathPara;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathPara = (CTOMathPara) get_store().insert_element_user(OMATHPARA$86, i);
        }
        return cTOMathPara;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTPerm insertNewPermEnd(int i) {
        CTPerm cTPermInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPermInsert_element_user = get_store().insert_element_user(PERMEND$44, i);
        }
        return cTPermInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTPermStart insertNewPermStart(int i) {
        CTPermStart cTPermStartInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPermStartInsert_element_user = get_store().insert_element_user(PERMSTART$42, i);
        }
        return cTPermStartInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTPhant insertNewPhant(int i) {
        CTPhant cTPhantInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTPhantInsert_element_user = get_store().insert_element_user(PHANT$26, i);
        }
        return cTPhantInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTProofErr insertNewProofErr(int i) {
        CTProofErr cTProofErrInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTProofErrInsert_element_user = get_store().insert_element_user(PROOFERR$40, i);
        }
        return cTProofErrInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTR insertNewR(int i) {
        CTR ctrInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            ctrInsert_element_user = get_store().insert_element_user(R$38, i);
        }
        return ctrInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTRad insertNewRad(int i) {
        CTRad cTRadInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTRadInsert_element_user = get_store().insert_element_user(RAD$28, i);
        }
        return cTRadInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTSPre insertNewSPre(int i) {
        CTSPre cTSPreInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSPreInsert_element_user = get_store().insert_element_user(SPRE$30, i);
        }
        return cTSPreInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTSSub insertNewSSub(int i) {
        CTSSub cTSSubInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSSubInsert_element_user = get_store().insert_element_user(SSUB$32, i);
        }
        return cTSSubInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTSSubSup insertNewSSubSup(int i) {
        CTSSubSup cTSSubSupInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSSubSupInsert_element_user = get_store().insert_element_user(SSUBSUP$34, i);
        }
        return cTSSubSupInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTSSup insertNewSSup(int i) {
        CTSSup cTSSupInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSSupInsert_element_user = get_store().insert_element_user(SSUP$36, i);
        }
        return cTSSupInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeAcc(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ACC$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeBar(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BAR$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeBookmarkEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOOKMARKEND$48, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeBookmarkStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOOKMARKSTART$46, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeBorderBox(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BORDERBOX$6, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeBox(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOX$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeCommentRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMMENTRANGEEND$60, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeCommentRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COMMENTRANGESTART$58, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeCustomXmlDelRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLDELRANGEEND$68, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeCustomXmlDelRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLDELRANGESTART$66, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeCustomXmlInsRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLINSRANGEEND$64, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeCustomXmlInsRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLINSRANGESTART$62, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeCustomXmlMoveFromRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVEFROMRANGEEND$72, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeCustomXmlMoveFromRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVEFROMRANGESTART$70, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeCustomXmlMoveToRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVETORANGEEND$76, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeCustomXmlMoveToRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTOMXMLMOVETORANGESTART$74, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeD(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(D$8, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeDel(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(DEL$80, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeEqArr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EQARR$10, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeF(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(F$12, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeFunc(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FUNC$14, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeGroupChr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GROUPCHR$16, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeIns(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(INS$78, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeLimLow(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LIMLOW$18, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeLimUpp(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LIMUPP$20, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeM(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(M$22, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeMoveFrom(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROM$82, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeMoveFromRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROMRANGEEND$52, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeMoveFromRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVEFROMRANGESTART$50, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeMoveTo(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETO$84, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeMoveToRangeEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETORANGEEND$56, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeMoveToRangeStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(MOVETORANGESTART$54, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeNary(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NARY$24, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeOMath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OMATH$88, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeOMathPara(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OMATHPARA$86, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removePermEnd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PERMEND$44, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removePermStart(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PERMSTART$42, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removePhant(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PHANT$26, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeProofErr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROOFERR$40, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeR(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(R$38, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeRad(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RAD$28, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeSPre(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SPRE$30, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeSSub(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SSUB$32, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeSSubSup(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SSUBSUP$34, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void removeSSup(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SSUP$36, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setAccArray(int i, CTAcc cTAcc) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTAcc cTAccFind_element_user = get_store().find_element_user(ACC$0, i);
                if (cTAccFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTAccFind_element_user.set(cTAcc);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setBarArray(int i, CTBar cTBar) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTBar cTBarFind_element_user = get_store().find_element_user(BAR$2, i);
                if (cTBarFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTBarFind_element_user.set(cTBar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setBookmarkEndArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTMarkupRange cTMarkupRange2 = (CTMarkupRange) get_store().find_element_user(BOOKMARKEND$48, i);
                if (cTMarkupRange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTMarkupRange2.set(cTMarkupRange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setBookmarkStartArray(int i, CTBookmark cTBookmark) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTBookmark cTBookmark2 = (CTBookmark) get_store().find_element_user(BOOKMARKSTART$46, i);
                if (cTBookmark2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTBookmark2.set(cTBookmark);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setBorderBoxArray(int i, CTBorderBox cTBorderBox) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTBorderBox cTBorderBoxFind_element_user = get_store().find_element_user(BORDERBOX$6, i);
                if (cTBorderBoxFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTBorderBoxFind_element_user.set(cTBorderBox);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setBoxArray(int i, CTBox cTBox) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTBox cTBoxFind_element_user = get_store().find_element_user(BOX$4, i);
                if (cTBoxFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTBoxFind_element_user.set(cTBox);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setCommentRangeEndArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTMarkupRange cTMarkupRange2 = (CTMarkupRange) get_store().find_element_user(COMMENTRANGEEND$60, i);
                if (cTMarkupRange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTMarkupRange2.set(cTMarkupRange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setCommentRangeStartArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTMarkupRange cTMarkupRange2 = (CTMarkupRange) get_store().find_element_user(COMMENTRANGESTART$58, i);
                if (cTMarkupRange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTMarkupRange2.set(cTMarkupRange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setCustomXmlDelRangeEndArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTMarkup cTMarkup2 = (CTMarkup) get_store().find_element_user(CUSTOMXMLDELRANGEEND$68, i);
                if (cTMarkup2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTMarkup2.set(cTMarkup);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setCustomXmlDelRangeStartArray(int i, CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTrackChange cTTrackChange2 = (CTTrackChange) get_store().find_element_user(CUSTOMXMLDELRANGESTART$66, i);
                if (cTTrackChange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTTrackChange2.set(cTTrackChange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setCustomXmlInsRangeEndArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTMarkup cTMarkup2 = (CTMarkup) get_store().find_element_user(CUSTOMXMLINSRANGEEND$64, i);
                if (cTMarkup2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTMarkup2.set(cTMarkup);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setCustomXmlInsRangeStartArray(int i, CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTrackChange cTTrackChange2 = (CTTrackChange) get_store().find_element_user(CUSTOMXMLINSRANGESTART$62, i);
                if (cTTrackChange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTTrackChange2.set(cTTrackChange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setCustomXmlMoveFromRangeEndArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTMarkup cTMarkup2 = (CTMarkup) get_store().find_element_user(CUSTOMXMLMOVEFROMRANGEEND$72, i);
                if (cTMarkup2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTMarkup2.set(cTMarkup);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setCustomXmlMoveFromRangeStartArray(int i, CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTrackChange cTTrackChange2 = (CTTrackChange) get_store().find_element_user(CUSTOMXMLMOVEFROMRANGESTART$70, i);
                if (cTTrackChange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTTrackChange2.set(cTTrackChange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setCustomXmlMoveToRangeEndArray(int i, CTMarkup cTMarkup) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTMarkup cTMarkup2 = (CTMarkup) get_store().find_element_user(CUSTOMXMLMOVETORANGEEND$76, i);
                if (cTMarkup2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTMarkup2.set(cTMarkup);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setCustomXmlMoveToRangeStartArray(int i, CTTrackChange cTTrackChange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTrackChange cTTrackChange2 = (CTTrackChange) get_store().find_element_user(CUSTOMXMLMOVETORANGESTART$74, i);
                if (cTTrackChange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTTrackChange2.set(cTTrackChange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setDArray(int i, CTD ctd) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTD ctdFind_element_user = get_store().find_element_user(D$8, i);
                if (ctdFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                ctdFind_element_user.set(ctd);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setDelArray(int i, CTRunTrackChange cTRunTrackChange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTRunTrackChange cTRunTrackChange2 = (CTRunTrackChange) get_store().find_element_user(DEL$80, i);
                if (cTRunTrackChange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTRunTrackChange2.set(cTRunTrackChange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setEqArrArray(int i, CTEqArr cTEqArr) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTEqArr cTEqArrFind_element_user = get_store().find_element_user(EQARR$10, i);
                if (cTEqArrFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTEqArrFind_element_user.set(cTEqArr);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setFArray(int i, CTF ctf) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTF ctfFind_element_user = get_store().find_element_user(F$12, i);
                if (ctfFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                ctfFind_element_user.set(ctf);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setFuncArray(int i, CTFunc cTFunc) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTFunc cTFuncFind_element_user = get_store().find_element_user(FUNC$14, i);
                if (cTFuncFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTFuncFind_element_user.set(cTFunc);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setGroupChrArray(int i, CTGroupChr cTGroupChr) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTGroupChr cTGroupChrFind_element_user = get_store().find_element_user(GROUPCHR$16, i);
                if (cTGroupChrFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTGroupChrFind_element_user.set(cTGroupChr);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setInsArray(int i, CTRunTrackChange cTRunTrackChange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTRunTrackChange cTRunTrackChange2 = (CTRunTrackChange) get_store().find_element_user(INS$78, i);
                if (cTRunTrackChange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTRunTrackChange2.set(cTRunTrackChange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setLimLowArray(int i, CTLimLow cTLimLow) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTLimLow cTLimLowFind_element_user = get_store().find_element_user(LIMLOW$18, i);
                if (cTLimLowFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTLimLowFind_element_user.set(cTLimLow);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setLimUppArray(int i, CTLimUpp cTLimUpp) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTLimUpp cTLimUppFind_element_user = get_store().find_element_user(LIMUPP$20, i);
                if (cTLimUppFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTLimUppFind_element_user.set(cTLimUpp);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setMArray(int i, CTM ctm) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTM ctmFind_element_user = get_store().find_element_user(M$22, i);
                if (ctmFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                ctmFind_element_user.set(ctm);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setMoveFromArray(int i, CTRunTrackChange cTRunTrackChange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTRunTrackChange cTRunTrackChange2 = (CTRunTrackChange) get_store().find_element_user(MOVEFROM$82, i);
                if (cTRunTrackChange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTRunTrackChange2.set(cTRunTrackChange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setMoveFromRangeEndArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTMarkupRange cTMarkupRange2 = (CTMarkupRange) get_store().find_element_user(MOVEFROMRANGEEND$52, i);
                if (cTMarkupRange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTMarkupRange2.set(cTMarkupRange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setMoveFromRangeStartArray(int i, CTMoveBookmark cTMoveBookmark) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTMoveBookmark cTMoveBookmark2 = (CTMoveBookmark) get_store().find_element_user(MOVEFROMRANGESTART$50, i);
                if (cTMoveBookmark2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTMoveBookmark2.set(cTMoveBookmark);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setMoveToArray(int i, CTRunTrackChange cTRunTrackChange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTRunTrackChange cTRunTrackChange2 = (CTRunTrackChange) get_store().find_element_user(MOVETO$84, i);
                if (cTRunTrackChange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTRunTrackChange2.set(cTRunTrackChange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setMoveToRangeEndArray(int i, CTMarkupRange cTMarkupRange) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTMarkupRange cTMarkupRange2 = (CTMarkupRange) get_store().find_element_user(MOVETORANGEEND$56, i);
                if (cTMarkupRange2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTMarkupRange2.set(cTMarkupRange);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setMoveToRangeStartArray(int i, CTMoveBookmark cTMoveBookmark) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTMoveBookmark cTMoveBookmark2 = (CTMoveBookmark) get_store().find_element_user(MOVETORANGESTART$54, i);
                if (cTMoveBookmark2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTMoveBookmark2.set(cTMoveBookmark);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setNaryArray(int i, CTNary cTNary) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTNary cTNaryFind_element_user = get_store().find_element_user(NARY$24, i);
                if (cTNaryFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTNaryFind_element_user.set(cTNary);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setOMathArray(int i, CTOMath cTOMath) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTOMath cTOMath2 = (CTOMath) get_store().find_element_user(OMATH$88, i);
                if (cTOMath2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTOMath2.set(cTOMath);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setOMathParaArray(int i, CTOMathPara cTOMathPara) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTOMathPara cTOMathPara2 = (CTOMathPara) get_store().find_element_user(OMATHPARA$86, i);
                if (cTOMathPara2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTOMathPara2.set(cTOMathPara);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setPermEndArray(int i, CTPerm cTPerm) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTPerm cTPermFind_element_user = get_store().find_element_user(PERMEND$44, i);
                if (cTPermFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTPermFind_element_user.set(cTPerm);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setPermStartArray(int i, CTPermStart cTPermStart) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTPermStart cTPermStartFind_element_user = get_store().find_element_user(PERMSTART$42, i);
                if (cTPermStartFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTPermStartFind_element_user.set(cTPermStart);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setPhantArray(int i, CTPhant cTPhant) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTPhant cTPhantFind_element_user = get_store().find_element_user(PHANT$26, i);
                if (cTPhantFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTPhantFind_element_user.set(cTPhant);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setProofErrArray(int i, CTProofErr cTProofErr) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTProofErr cTProofErrFind_element_user = get_store().find_element_user(PROOFERR$40, i);
                if (cTProofErrFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTProofErrFind_element_user.set(cTProofErr);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setRArray(int i, CTR ctr) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTR ctrFind_element_user = get_store().find_element_user(R$38, i);
                if (ctrFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                ctrFind_element_user.set(ctr);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setRadArray(int i, CTRad cTRad) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTRad cTRadFind_element_user = get_store().find_element_user(RAD$28, i);
                if (cTRadFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTRadFind_element_user.set(cTRad);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setSPreArray(int i, CTSPre cTSPre) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTSPre cTSPreFind_element_user = get_store().find_element_user(SPRE$30, i);
                if (cTSPreFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTSPreFind_element_user.set(cTSPre);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setSSubArray(int i, CTSSub cTSSub) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTSSub cTSSubFind_element_user = get_store().find_element_user(SSUB$32, i);
                if (cTSSubFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTSSubFind_element_user.set(cTSSub);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setSSubSupArray(int i, CTSSubSup cTSSubSup) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTSSubSup cTSSubSupFind_element_user = get_store().find_element_user(SSUBSUP$34, i);
                if (cTSSubSupFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTSSubSupFind_element_user.set(cTSSubSup);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setSSupArray(int i, CTSSup cTSSup) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTSSup cTSSupFind_element_user = get_store().find_element_user(SSUP$36, i);
                if (cTSSupFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTSSupFind_element_user.set(cTSSup);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfAccArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ACC$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfBarArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BAR$2);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfBookmarkEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BOOKMARKEND$48);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfBookmarkStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BOOKMARKSTART$46);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfBorderBoxArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BORDERBOX$6);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfBoxArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BOX$4);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfCommentRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(COMMENTRANGEEND$60);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfCommentRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(COMMENTRANGESTART$58);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfCustomXmlDelRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLDELRANGEEND$68);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfCustomXmlDelRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLDELRANGESTART$66);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfCustomXmlInsRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLINSRANGEEND$64);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfCustomXmlInsRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLINSRANGESTART$62);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfCustomXmlMoveFromRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLMOVEFROMRANGEEND$72);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfCustomXmlMoveFromRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLMOVEFROMRANGESTART$70);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfCustomXmlMoveToRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLMOVETORANGEEND$76);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfCustomXmlMoveToRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CUSTOMXMLMOVETORANGESTART$74);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfDArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(D$8);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfDelArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(DEL$80);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfEqArrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(EQARR$10);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfFArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(F$12);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfFuncArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(FUNC$14);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfGroupChrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(GROUPCHR$16);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfInsArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(INS$78);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfLimLowArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(LIMLOW$18);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfLimUppArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(LIMUPP$20);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfMArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(M$22);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfMoveFromArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVEFROM$82);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfMoveFromRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVEFROMRANGEEND$52);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfMoveFromRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVEFROMRANGESTART$50);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfMoveToArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVETO$84);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfMoveToRangeEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVETORANGEEND$56);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfMoveToRangeStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(MOVETORANGESTART$54);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfNaryArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(NARY$24);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfOMathArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(OMATH$88);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfOMathParaArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(OMATHPARA$86);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfPermEndArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PERMEND$44);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfPermStartArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PERMSTART$42);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfPhantArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PHANT$26);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfProofErrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROOFERR$40);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfRArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(R$38);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfRadArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(RAD$28);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfSPreArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SPRE$30);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfSSubArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SSUB$32);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfSSubSupArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SSUBSUP$34);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public int sizeOfSSupArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SSUP$36);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTAcc[] getAccArray() {
        CTAcc[] cTAccArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ACC$0, arrayList);
            cTAccArr = new CTAcc[arrayList.size()];
            arrayList.toArray(cTAccArr);
        }
        return cTAccArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTBar[] getBarArray() {
        CTBar[] cTBarArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BAR$2, arrayList);
            cTBarArr = new CTBar[arrayList.size()];
            arrayList.toArray(cTBarArr);
        }
        return cTBarArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMarkupRange[] getBookmarkEndArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BOOKMARKEND$48, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTBookmark[] getBookmarkStartArray() {
        CTBookmark[] cTBookmarkArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BOOKMARKSTART$46, arrayList);
            cTBookmarkArr = new CTBookmark[arrayList.size()];
            arrayList.toArray(cTBookmarkArr);
        }
        return cTBookmarkArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTBorderBox[] getBorderBoxArray() {
        CTBorderBox[] cTBorderBoxArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BORDERBOX$6, arrayList);
            cTBorderBoxArr = new CTBorderBox[arrayList.size()];
            arrayList.toArray(cTBorderBoxArr);
        }
        return cTBorderBoxArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTBox[] getBoxArray() {
        CTBox[] cTBoxArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BOX$4, arrayList);
            cTBoxArr = new CTBox[arrayList.size()];
            arrayList.toArray(cTBoxArr);
        }
        return cTBoxArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMarkupRange[] getCommentRangeEndArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COMMENTRANGEEND$60, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMarkupRange[] getCommentRangeStartArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COMMENTRANGESTART$58, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMarkup[] getCustomXmlDelRangeEndArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLDELRANGEEND$68, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTTrackChange[] getCustomXmlDelRangeStartArray() {
        CTTrackChange[] cTTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLDELRANGESTART$66, arrayList);
            cTTrackChangeArr = new CTTrackChange[arrayList.size()];
            arrayList.toArray(cTTrackChangeArr);
        }
        return cTTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMarkup[] getCustomXmlInsRangeEndArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLINSRANGEEND$64, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTTrackChange[] getCustomXmlInsRangeStartArray() {
        CTTrackChange[] cTTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLINSRANGESTART$62, arrayList);
            cTTrackChangeArr = new CTTrackChange[arrayList.size()];
            arrayList.toArray(cTTrackChangeArr);
        }
        return cTTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMarkup[] getCustomXmlMoveFromRangeEndArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLMOVEFROMRANGEEND$72, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTTrackChange[] getCustomXmlMoveFromRangeStartArray() {
        CTTrackChange[] cTTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLMOVEFROMRANGESTART$70, arrayList);
            cTTrackChangeArr = new CTTrackChange[arrayList.size()];
            arrayList.toArray(cTTrackChangeArr);
        }
        return cTTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMarkup[] getCustomXmlMoveToRangeEndArray() {
        CTMarkup[] cTMarkupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLMOVETORANGEEND$76, arrayList);
            cTMarkupArr = new CTMarkup[arrayList.size()];
            arrayList.toArray(cTMarkupArr);
        }
        return cTMarkupArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTTrackChange[] getCustomXmlMoveToRangeStartArray() {
        CTTrackChange[] cTTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CUSTOMXMLMOVETORANGESTART$74, arrayList);
            cTTrackChangeArr = new CTTrackChange[arrayList.size()];
            arrayList.toArray(cTTrackChangeArr);
        }
        return cTTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTD[] getDArray() {
        CTD[] ctdArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(D$8, arrayList);
            ctdArr = new CTD[arrayList.size()];
            arrayList.toArray(ctdArr);
        }
        return ctdArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTRunTrackChange[] getDelArray() {
        CTRunTrackChange[] cTRunTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(DEL$80, arrayList);
            cTRunTrackChangeArr = new CTRunTrackChange[arrayList.size()];
            arrayList.toArray(cTRunTrackChangeArr);
        }
        return cTRunTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTEqArr[] getEqArrArray() {
        CTEqArr[] cTEqArrArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(EQARR$10, arrayList);
            cTEqArrArr = new CTEqArr[arrayList.size()];
            arrayList.toArray(cTEqArrArr);
        }
        return cTEqArrArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTF[] getFArray() {
        CTF[] ctfArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(F$12, arrayList);
            ctfArr = new CTF[arrayList.size()];
            arrayList.toArray(ctfArr);
        }
        return ctfArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTFunc[] getFuncArray() {
        CTFunc[] cTFuncArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FUNC$14, arrayList);
            cTFuncArr = new CTFunc[arrayList.size()];
            arrayList.toArray(cTFuncArr);
        }
        return cTFuncArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTGroupChr[] getGroupChrArray() {
        CTGroupChr[] cTGroupChrArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(GROUPCHR$16, arrayList);
            cTGroupChrArr = new CTGroupChr[arrayList.size()];
            arrayList.toArray(cTGroupChrArr);
        }
        return cTGroupChrArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTRunTrackChange[] getInsArray() {
        CTRunTrackChange[] cTRunTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(INS$78, arrayList);
            cTRunTrackChangeArr = new CTRunTrackChange[arrayList.size()];
            arrayList.toArray(cTRunTrackChangeArr);
        }
        return cTRunTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTLimLow[] getLimLowArray() {
        CTLimLow[] cTLimLowArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LIMLOW$18, arrayList);
            cTLimLowArr = new CTLimLow[arrayList.size()];
            arrayList.toArray(cTLimLowArr);
        }
        return cTLimLowArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTLimUpp[] getLimUppArray() {
        CTLimUpp[] cTLimUppArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(LIMUPP$20, arrayList);
            cTLimUppArr = new CTLimUpp[arrayList.size()];
            arrayList.toArray(cTLimUppArr);
        }
        return cTLimUppArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTM[] getMArray() {
        CTM[] ctmArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(M$22, arrayList);
            ctmArr = new CTM[arrayList.size()];
            arrayList.toArray(ctmArr);
        }
        return ctmArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTRunTrackChange[] getMoveFromArray() {
        CTRunTrackChange[] cTRunTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVEFROM$82, arrayList);
            cTRunTrackChangeArr = new CTRunTrackChange[arrayList.size()];
            arrayList.toArray(cTRunTrackChangeArr);
        }
        return cTRunTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMarkupRange[] getMoveFromRangeEndArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVEFROMRANGEEND$52, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMoveBookmark[] getMoveFromRangeStartArray() {
        CTMoveBookmark[] cTMoveBookmarkArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVEFROMRANGESTART$50, arrayList);
            cTMoveBookmarkArr = new CTMoveBookmark[arrayList.size()];
            arrayList.toArray(cTMoveBookmarkArr);
        }
        return cTMoveBookmarkArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTRunTrackChange[] getMoveToArray() {
        CTRunTrackChange[] cTRunTrackChangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVETO$84, arrayList);
            cTRunTrackChangeArr = new CTRunTrackChange[arrayList.size()];
            arrayList.toArray(cTRunTrackChangeArr);
        }
        return cTRunTrackChangeArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMarkupRange[] getMoveToRangeEndArray() {
        CTMarkupRange[] cTMarkupRangeArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVETORANGEEND$56, arrayList);
            cTMarkupRangeArr = new CTMarkupRange[arrayList.size()];
            arrayList.toArray(cTMarkupRangeArr);
        }
        return cTMarkupRangeArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTMoveBookmark[] getMoveToRangeStartArray() {
        CTMoveBookmark[] cTMoveBookmarkArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(MOVETORANGESTART$54, arrayList);
            cTMoveBookmarkArr = new CTMoveBookmark[arrayList.size()];
            arrayList.toArray(cTMoveBookmarkArr);
        }
        return cTMoveBookmarkArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTNary[] getNaryArray() {
        CTNary[] cTNaryArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(NARY$24, arrayList);
            cTNaryArr = new CTNary[arrayList.size()];
            arrayList.toArray(cTNaryArr);
        }
        return cTNaryArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTOMath[] getOMathArray() {
        CTOMath[] cTOMathArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(OMATH$88, arrayList);
            cTOMathArr = new CTOMath[arrayList.size()];
            arrayList.toArray(cTOMathArr);
        }
        return cTOMathArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTOMathPara[] getOMathParaArray() {
        CTOMathPara[] cTOMathParaArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(OMATHPARA$86, arrayList);
            cTOMathParaArr = new CTOMathPara[arrayList.size()];
            arrayList.toArray(cTOMathParaArr);
        }
        return cTOMathParaArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTPerm[] getPermEndArray() {
        CTPerm[] cTPermArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PERMEND$44, arrayList);
            cTPermArr = new CTPerm[arrayList.size()];
            arrayList.toArray(cTPermArr);
        }
        return cTPermArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTPermStart[] getPermStartArray() {
        CTPermStart[] cTPermStartArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PERMSTART$42, arrayList);
            cTPermStartArr = new CTPermStart[arrayList.size()];
            arrayList.toArray(cTPermStartArr);
        }
        return cTPermStartArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTPhant[] getPhantArray() {
        CTPhant[] cTPhantArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PHANT$26, arrayList);
            cTPhantArr = new CTPhant[arrayList.size()];
            arrayList.toArray(cTPhantArr);
        }
        return cTPhantArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTProofErr[] getProofErrArray() {
        CTProofErr[] cTProofErrArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PROOFERR$40, arrayList);
            cTProofErrArr = new CTProofErr[arrayList.size()];
            arrayList.toArray(cTProofErrArr);
        }
        return cTProofErrArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTR[] getRArray() {
        CTR[] ctrArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(R$38, arrayList);
            ctrArr = new CTR[arrayList.size()];
            arrayList.toArray(ctrArr);
        }
        return ctrArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTRad[] getRadArray() {
        CTRad[] cTRadArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(RAD$28, arrayList);
            cTRadArr = new CTRad[arrayList.size()];
            arrayList.toArray(cTRadArr);
        }
        return cTRadArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTSPre[] getSPreArray() {
        CTSPre[] cTSPreArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SPRE$30, arrayList);
            cTSPreArr = new CTSPre[arrayList.size()];
            arrayList.toArray(cTSPreArr);
        }
        return cTSPreArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTSSub[] getSSubArray() {
        CTSSub[] cTSSubArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SSUB$32, arrayList);
            cTSSubArr = new CTSSub[arrayList.size()];
            arrayList.toArray(cTSSubArr);
        }
        return cTSSubArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTSSubSup[] getSSubSupArray() {
        CTSSubSup[] cTSSubSupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SSUBSUP$34, arrayList);
            cTSSubSupArr = new CTSSubSup[arrayList.size()];
            arrayList.toArray(cTSSubSupArr);
        }
        return cTSSubSupArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public CTSSup[] getSSupArray() {
        CTSSup[] cTSSupArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SSUP$36, arrayList);
            cTSSupArr = new CTSSup[arrayList.size()];
            arrayList.toArray(cTSSupArr);
        }
        return cTSSupArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setAccArray(CTAcc[] cTAccArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTAccArr, ACC$0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setBarArray(CTBar[] cTBarArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTBarArr, BAR$2);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setBookmarkEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, BOOKMARKEND$48);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setBookmarkStartArray(CTBookmark[] cTBookmarkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTBookmarkArr, BOOKMARKSTART$46);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setBorderBoxArray(CTBorderBox[] cTBorderBoxArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTBorderBoxArr, BORDERBOX$6);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setBoxArray(CTBox[] cTBoxArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTBoxArr, BOX$4);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setCommentRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, COMMENTRANGEEND$60);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setCommentRangeStartArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, COMMENTRANGESTART$58);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setCustomXmlDelRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLDELRANGEEND$68);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setCustomXmlDelRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLDELRANGESTART$66);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setCustomXmlInsRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLINSRANGEEND$64);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setCustomXmlInsRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLINSRANGESTART$62);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setCustomXmlMoveFromRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLMOVEFROMRANGEEND$72);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setCustomXmlMoveFromRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLMOVEFROMRANGESTART$70);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setCustomXmlMoveToRangeEndArray(CTMarkup[] cTMarkupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupArr, CUSTOMXMLMOVETORANGEEND$76);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setCustomXmlMoveToRangeStartArray(CTTrackChange[] cTTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTrackChangeArr, CUSTOMXMLMOVETORANGESTART$74);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setDArray(CTD[] ctdArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) ctdArr, D$8);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setDelArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, DEL$80);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setEqArrArray(CTEqArr[] cTEqArrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTEqArrArr, EQARR$10);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setFArray(CTF[] ctfArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) ctfArr, F$12);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setFuncArray(CTFunc[] cTFuncArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTFuncArr, FUNC$14);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setGroupChrArray(CTGroupChr[] cTGroupChrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTGroupChrArr, GROUPCHR$16);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setInsArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, INS$78);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setLimLowArray(CTLimLow[] cTLimLowArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTLimLowArr, LIMLOW$18);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setLimUppArray(CTLimUpp[] cTLimUppArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTLimUppArr, LIMUPP$20);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setMArray(CTM[] ctmArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) ctmArr, M$22);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setMoveFromArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, MOVEFROM$82);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setMoveFromRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, MOVEFROMRANGEEND$52);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setMoveFromRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMoveBookmarkArr, MOVEFROMRANGESTART$50);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setMoveToArray(CTRunTrackChange[] cTRunTrackChangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRunTrackChangeArr, MOVETO$84);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setMoveToRangeEndArray(CTMarkupRange[] cTMarkupRangeArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMarkupRangeArr, MOVETORANGEEND$56);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setMoveToRangeStartArray(CTMoveBookmark[] cTMoveBookmarkArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTMoveBookmarkArr, MOVETORANGESTART$54);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setNaryArray(CTNary[] cTNaryArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTNaryArr, NARY$24);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setOMathArray(CTOMath[] cTOMathArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTOMathArr, OMATH$88);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setOMathParaArray(CTOMathPara[] cTOMathParaArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTOMathParaArr, OMATHPARA$86);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setPermEndArray(CTPerm[] cTPermArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTPermArr, PERMEND$44);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setPermStartArray(CTPermStart[] cTPermStartArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTPermStartArr, PERMSTART$42);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setPhantArray(CTPhant[] cTPhantArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTPhantArr, PHANT$26);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setProofErrArray(CTProofErr[] cTProofErrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTProofErrArr, PROOFERR$40);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setRArray(CTR[] ctrArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) ctrArr, R$38);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setRadArray(CTRad[] cTRadArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTRadArr, RAD$28);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setSPreArray(CTSPre[] cTSPreArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTSPreArr, SPRE$30);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setSSubArray(CTSSub[] cTSSubArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTSSubArr, SSUB$32);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setSSubSupArray(CTSSubSup[] cTSSubSupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTSSubSupArr, SSUBSUP$34);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath
    public void setSSupArray(CTSSup[] cTSSupArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTSSupArr, SSUP$36);
        }
    }
}
