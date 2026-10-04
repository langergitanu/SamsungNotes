package org.openxmlformats.schemas.officeDocument.x2006.math.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTInteger2;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArgPr;

/* JADX INFO: loaded from: classes11.dex */
public class CTOMathArgPrImpl extends XmlComplexContentImpl implements CTOMathArgPr {
    private static final QName ARGSZ$0 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "argSz");

    public CTOMathArgPrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArgPr
    public CTInteger2 addNewArgSz() {
        CTInteger2 cTInteger2Add_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTInteger2Add_element_user = get_store().add_element_user(ARGSZ$0);
        }
        return cTInteger2Add_element_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArgPr
    public CTInteger2 getArgSz() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTInteger2 cTInteger2Find_element_user = get_store().find_element_user(ARGSZ$0, 0);
                if (cTInteger2Find_element_user == null) {
                    return null;
                }
                return cTInteger2Find_element_user;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArgPr
    public boolean isSetArgSz() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ARGSZ$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArgPr
    public void setArgSz(CTInteger2 cTInteger2) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ARGSZ$0;
                CTInteger2 cTInteger2Find_element_user = typeStore.find_element_user(qName, 0);
                if (cTInteger2Find_element_user == null) {
                    cTInteger2Find_element_user = (CTInteger2) get_store().add_element_user(qName);
                }
                cTInteger2Find_element_user.set(cTInteger2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathArgPr
    public void unsetArgSz() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ARGSZ$0, 0);
        }
    }
}
