package org.openxmlformats.schemas.officeDocument.x2006.math.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathJc;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathParaPr;

/* JADX INFO: loaded from: classes11.dex */
public class CTOMathParaPrImpl extends XmlComplexContentImpl implements CTOMathParaPr {
    private static final QName JC$0 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "jc");

    public CTOMathParaPrImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathParaPr
    public CTOMathJc addNewJc() {
        CTOMathJc cTOMathJc;
        synchronized (monitor()) {
            check_orphaned();
            cTOMathJc = (CTOMathJc) get_store().add_element_user(JC$0);
        }
        return cTOMathJc;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathParaPr
    public CTOMathJc getJc() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTOMathJc cTOMathJc = (CTOMathJc) get_store().find_element_user(JC$0, 0);
                if (cTOMathJc == null) {
                    return null;
                }
                return cTOMathJc;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathParaPr
    public boolean isSetJc() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(JC$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathParaPr
    public void setJc(CTOMathJc cTOMathJc) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = JC$0;
                CTOMathJc cTOMathJc2 = (CTOMathJc) typeStore.find_element_user(qName, 0);
                if (cTOMathJc2 == null) {
                    cTOMathJc2 = (CTOMathJc) get_store().add_element_user(qName);
                }
                cTOMathJc2.set(cTOMathJc);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathParaPr
    public void unsetJc() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(JC$0, 0);
        }
    }
}
