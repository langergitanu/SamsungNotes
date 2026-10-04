package org.openxmlformats.schemas.officeDocument.x2006.math.impl;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMath;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathParaPr;

/* JADX INFO: loaded from: classes11.dex */
public class CTOMathParaImpl extends XmlComplexContentImpl implements CTOMathPara {
    private static final QName OMATHPARAPR$0 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "oMathParaPr");
    private static final QName OMATH$2 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "oMath");

    public CTOMathParaImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara
    public CTOMath addNewOMath() {
        CTOMath cTOMath;
        synchronized (monitor()) {
            check_orphaned();
            cTOMath = (CTOMath) get_store().add_element_user(OMATH$2);
        }
        return cTOMath;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara
    public CTOMathParaPr addNewOMathParaPr() {
        CTOMathParaPr cTOMathParaPr;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathParaPr = (CTOMathParaPr) get_store().add_element_user(OMATHPARAPR$0);
        }
        return cTOMathParaPr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara
    public CTOMath getOMathArray(int i) {
        CTOMath cTOMath;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTOMath = (CTOMath) get_store().find_element_user(OMATH$2, i);
                if (cTOMath == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTOMath;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara
    public List<CTOMath> getOMathList() {
        AbstractList<CTOMath> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTOMath>() { // from class: org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTOMathParaImpl.1OMathList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTOMathParaImpl.this.sizeOfOMathArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTOMath cTOMath) {
                    CTOMathParaImpl.this.insertNewOMath(i).set(cTOMath);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTOMath get(int i) {
                    return CTOMathParaImpl.this.getOMathArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTOMath remove(int i) {
                    CTOMath oMathArray = CTOMathParaImpl.this.getOMathArray(i);
                    CTOMathParaImpl.this.removeOMath(i);
                    return oMathArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTOMath set(int i, CTOMath cTOMath) {
                    CTOMath oMathArray = CTOMathParaImpl.this.getOMathArray(i);
                    CTOMathParaImpl.this.setOMathArray(i, cTOMath);
                    return oMathArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara
    public CTOMathParaPr getOMathParaPr() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTOMathParaPr cTOMathParaPr = (CTOMathParaPr) get_store().find_element_user(OMATHPARAPR$0, 0);
                if (cTOMathParaPr == null) {
                    return null;
                }
                return cTOMathParaPr;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara
    public CTOMath insertNewOMath(int i) {
        CTOMath cTOMath;
        synchronized (monitor()) {
            check_orphaned();
            cTOMath = (CTOMath) get_store().insert_element_user(OMATH$2, i);
        }
        return cTOMath;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara
    public boolean isSetOMathParaPr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OMATHPARAPR$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara
    public void removeOMath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OMATH$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara
    public void setOMathArray(int i, CTOMath cTOMath) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTOMath cTOMath2 = (CTOMath) get_store().find_element_user(OMATH$2, i);
                if (cTOMath2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTOMath2.set(cTOMath);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara
    public void setOMathParaPr(CTOMathParaPr cTOMathParaPr) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = OMATHPARAPR$0;
                CTOMathParaPr cTOMathParaPr2 = (CTOMathParaPr) typeStore.find_element_user(qName, 0);
                if (cTOMathParaPr2 == null) {
                    cTOMathParaPr2 = (CTOMathParaPr) get_store().add_element_user(qName);
                }
                cTOMathParaPr2.set(cTOMathParaPr);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara
    public int sizeOfOMathArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(OMATH$2);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara
    public void unsetOMathParaPr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OMATHPARAPR$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara
    public CTOMath[] getOMathArray() {
        CTOMath[] cTOMathArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(OMATH$2, arrayList);
            cTOMathArr = new CTOMath[arrayList.size()];
            arrayList.toArray(cTOMathArr);
        }
        return cTOMathArr;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathPara
    public void setOMathArray(CTOMath[] cTOMathArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTOMathArr, OMATH$2);
        }
    }
}
