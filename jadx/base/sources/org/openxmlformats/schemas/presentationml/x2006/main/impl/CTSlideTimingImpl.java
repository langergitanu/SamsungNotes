package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTBuildList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList;

/* JADX INFO: loaded from: classes11.dex */
public class CTSlideTimingImpl extends XmlComplexContentImpl implements CTSlideTiming {
    private static final QName TNLST$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "tnLst");
    private static final QName BLDLST$2 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "bldLst");
    private static final QName EXTLST$4 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst");

    public CTSlideTimingImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming
    public CTBuildList addNewBldLst() {
        CTBuildList cTBuildListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBuildListAdd_element_user = get_store().add_element_user(BLDLST$2);
        }
        return cTBuildListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming
    public CTExtensionListModify addNewExtLst() {
        CTExtensionListModify cTExtensionListModify;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListModify = (CTExtensionListModify) get_store().add_element_user(EXTLST$4);
        }
        return cTExtensionListModify;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming
    public CTTimeNodeList addNewTnLst() {
        CTTimeNodeList cTTimeNodeList;
        synchronized (monitor()) {
            check_orphaned();
            cTTimeNodeList = (CTTimeNodeList) get_store().add_element_user(TNLST$0);
        }
        return cTTimeNodeList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming
    public CTBuildList getBldLst() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTBuildList cTBuildListFind_element_user = get_store().find_element_user(BLDLST$2, 0);
                if (cTBuildListFind_element_user == null) {
                    return null;
                }
                return cTBuildListFind_element_user;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming
    public CTExtensionListModify getExtLst() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTExtensionListModify cTExtensionListModify = (CTExtensionListModify) get_store().find_element_user(EXTLST$4, 0);
                if (cTExtensionListModify == null) {
                    return null;
                }
                return cTExtensionListModify;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming
    public CTTimeNodeList getTnLst() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTimeNodeList cTTimeNodeList = (CTTimeNodeList) get_store().find_element_user(TNLST$0, 0);
                if (cTTimeNodeList == null) {
                    return null;
                }
                return cTTimeNodeList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming
    public boolean isSetBldLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BLDLST$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming
    public boolean isSetTnLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TNLST$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming
    public void setBldLst(CTBuildList cTBuildList) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = BLDLST$2;
                CTBuildList cTBuildListFind_element_user = typeStore.find_element_user(qName, 0);
                if (cTBuildListFind_element_user == null) {
                    cTBuildListFind_element_user = (CTBuildList) get_store().add_element_user(qName);
                }
                cTBuildListFind_element_user.set(cTBuildList);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming
    public void setExtLst(CTExtensionListModify cTExtensionListModify) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = EXTLST$4;
                CTExtensionListModify cTExtensionListModify2 = (CTExtensionListModify) typeStore.find_element_user(qName, 0);
                if (cTExtensionListModify2 == null) {
                    cTExtensionListModify2 = (CTExtensionListModify) get_store().add_element_user(qName);
                }
                cTExtensionListModify2.set(cTExtensionListModify);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming
    public void setTnLst(CTTimeNodeList cTTimeNodeList) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = TNLST$0;
                CTTimeNodeList cTTimeNodeList2 = (CTTimeNodeList) typeStore.find_element_user(qName, 0);
                if (cTTimeNodeList2 == null) {
                    cTTimeNodeList2 = (CTTimeNodeList) get_store().add_element_user(qName);
                }
                cTTimeNodeList2.set(cTTimeNodeList);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming
    public void unsetBldLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BLDLST$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming
    public void unsetTnLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TNLST$0, 0);
        }
    }
}
