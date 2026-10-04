package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import com.samsung.scsp.common.Header;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextField;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextLineBreak;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;

/* JADX INFO: loaded from: classes11.dex */
public class CTTextParagraphImpl extends XmlComplexContentImpl implements CTTextParagraph {
    private static final QName PPR$0 = new QName(XSSFRelation.NS_DRAWINGML, "pPr");
    private static final QName R$2 = new QName(XSSFRelation.NS_DRAWINGML, "r");
    private static final QName BR$4 = new QName(XSSFRelation.NS_DRAWINGML, Header.f8126BR);
    private static final QName FLD$6 = new QName(XSSFRelation.NS_DRAWINGML, "fld");
    private static final QName ENDPARARPR$8 = new QName(XSSFRelation.NS_DRAWINGML, "endParaRPr");

    public CTTextParagraphImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public CTTextLineBreak addNewBr() {
        CTTextLineBreak cTTextLineBreak;
        synchronized (monitor()) {
            check_orphaned();
            cTTextLineBreak = (CTTextLineBreak) get_store().add_element_user(BR$4);
        }
        return cTTextLineBreak;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public CTTextCharacterProperties addNewEndParaRPr() {
        CTTextCharacterProperties cTTextCharacterProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextCharacterProperties = (CTTextCharacterProperties) get_store().add_element_user(ENDPARARPR$8);
        }
        return cTTextCharacterProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public CTTextField addNewFld() {
        CTTextField cTTextField;
        synchronized (monitor()) {
            check_orphaned();
            cTTextField = (CTTextField) get_store().add_element_user(FLD$6);
        }
        return cTTextField;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public CTTextParagraphProperties addNewPPr() {
        CTTextParagraphProperties cTTextParagraphProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTTextParagraphProperties = (CTTextParagraphProperties) get_store().add_element_user(PPR$0);
        }
        return cTTextParagraphProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public CTRegularTextRun addNewR() {
        CTRegularTextRun cTRegularTextRun;
        synchronized (monitor()) {
            check_orphaned();
            cTRegularTextRun = (CTRegularTextRun) get_store().add_element_user(R$2);
        }
        return cTRegularTextRun;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public CTTextLineBreak getBrArray(int i) {
        CTTextLineBreak cTTextLineBreak;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTextLineBreak = (CTTextLineBreak) get_store().find_element_user(BR$4, i);
                if (cTTextLineBreak == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTextLineBreak;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public List<CTTextLineBreak> getBrList() {
        1BrList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1BrList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public CTTextCharacterProperties getEndParaRPr() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTextCharacterProperties cTTextCharacterProperties = (CTTextCharacterProperties) get_store().find_element_user(ENDPARARPR$8, 0);
                if (cTTextCharacterProperties == null) {
                    return null;
                }
                return cTTextCharacterProperties;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public CTTextField getFldArray(int i) {
        CTTextField cTTextField;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTextField = (CTTextField) get_store().find_element_user(FLD$6, i);
                if (cTTextField == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTextField;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public List<CTTextField> getFldList() {
        1FldList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1FldList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public CTTextParagraphProperties getPPr() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTextParagraphProperties cTTextParagraphProperties = (CTTextParagraphProperties) get_store().find_element_user(PPR$0, 0);
                if (cTTextParagraphProperties == null) {
                    return null;
                }
                return cTTextParagraphProperties;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public CTRegularTextRun getRArray(int i) {
        CTRegularTextRun cTRegularTextRun;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTRegularTextRun = (CTRegularTextRun) get_store().find_element_user(R$2, i);
                if (cTRegularTextRun == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTRegularTextRun;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public List<CTRegularTextRun> getRList() {
        1RList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1RList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public CTTextLineBreak insertNewBr(int i) {
        CTTextLineBreak cTTextLineBreak;
        synchronized (monitor()) {
            check_orphaned();
            cTTextLineBreak = (CTTextLineBreak) get_store().insert_element_user(BR$4, i);
        }
        return cTTextLineBreak;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public CTTextField insertNewFld(int i) {
        CTTextField cTTextField;
        synchronized (monitor()) {
            check_orphaned();
            cTTextField = (CTTextField) get_store().insert_element_user(FLD$6, i);
        }
        return cTTextField;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public CTRegularTextRun insertNewR(int i) {
        CTRegularTextRun cTRegularTextRun;
        synchronized (monitor()) {
            check_orphaned();
            cTRegularTextRun = (CTRegularTextRun) get_store().insert_element_user(R$2, i);
        }
        return cTRegularTextRun;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public boolean isSetEndParaRPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ENDPARARPR$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public boolean isSetPPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PPR$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public void removeBr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BR$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public void removeFld(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FLD$6, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public void removeR(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(R$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public void setBrArray(int i, CTTextLineBreak cTTextLineBreak) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTextLineBreak cTTextLineBreak2 = (CTTextLineBreak) get_store().find_element_user(BR$4, i);
                if (cTTextLineBreak2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTTextLineBreak2.set(cTTextLineBreak);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public void setEndParaRPr(CTTextCharacterProperties cTTextCharacterProperties) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ENDPARARPR$8;
                CTTextCharacterProperties cTTextCharacterProperties2 = (CTTextCharacterProperties) typeStore.find_element_user(qName, 0);
                if (cTTextCharacterProperties2 == null) {
                    cTTextCharacterProperties2 = (CTTextCharacterProperties) get_store().add_element_user(qName);
                }
                cTTextCharacterProperties2.set(cTTextCharacterProperties);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public void setFldArray(int i, CTTextField cTTextField) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTextField cTTextField2 = (CTTextField) get_store().find_element_user(FLD$6, i);
                if (cTTextField2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTTextField2.set(cTTextField);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public void setPPr(CTTextParagraphProperties cTTextParagraphProperties) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = PPR$0;
                CTTextParagraphProperties cTTextParagraphProperties2 = (CTTextParagraphProperties) typeStore.find_element_user(qName, 0);
                if (cTTextParagraphProperties2 == null) {
                    cTTextParagraphProperties2 = (CTTextParagraphProperties) get_store().add_element_user(qName);
                }
                cTTextParagraphProperties2.set(cTTextParagraphProperties);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public void setRArray(int i, CTRegularTextRun cTRegularTextRun) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTRegularTextRun cTRegularTextRun2 = (CTRegularTextRun) get_store().find_element_user(R$2, i);
                if (cTRegularTextRun2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTRegularTextRun2.set(cTRegularTextRun);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public int sizeOfBrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(BR$4);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public int sizeOfFldArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(FLD$6);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public int sizeOfRArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(R$2);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public void unsetEndParaRPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ENDPARARPR$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public void unsetPPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PPR$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public CTTextLineBreak[] getBrArray() {
        CTTextLineBreak[] cTTextLineBreakArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(BR$4, arrayList);
            cTTextLineBreakArr = new CTTextLineBreak[arrayList.size()];
            arrayList.toArray(cTTextLineBreakArr);
        }
        return cTTextLineBreakArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public CTTextField[] getFldArray() {
        CTTextField[] cTTextFieldArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(FLD$6, arrayList);
            cTTextFieldArr = new CTTextField[arrayList.size()];
            arrayList.toArray(cTTextFieldArr);
        }
        return cTTextFieldArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public CTRegularTextRun[] getRArray() {
        CTRegularTextRun[] cTRegularTextRunArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(R$2, arrayList);
            cTRegularTextRunArr = new CTRegularTextRun[arrayList.size()];
            arrayList.toArray(cTRegularTextRunArr);
        }
        return cTRegularTextRunArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public void setBrArray(CTTextLineBreak[] cTTextLineBreakArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTextLineBreakArr, BR$4);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public void setFldArray(CTTextField[] cTTextFieldArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTextFieldArr, FLD$6);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph
    public void setRArray(CTRegularTextRun[] cTRegularTextRunArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTRegularTextRunArr, R$2);
        }
    }
}
