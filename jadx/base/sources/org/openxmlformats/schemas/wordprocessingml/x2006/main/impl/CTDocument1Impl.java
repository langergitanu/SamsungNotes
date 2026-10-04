package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1;

/* JADX INFO: loaded from: classes11.dex */
public class CTDocument1Impl extends CTDocumentBaseImpl implements CTDocument1 {
    private static final QName BODY$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "body");

    public CTDocument1Impl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1
    public CTBody addNewBody() {
        CTBody cTBody;
        synchronized (monitor()) {
            check_orphaned();
            cTBody = (CTBody) get_store().add_element_user(BODY$0);
        }
        return cTBody;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1
    public CTBody getBody() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTBody cTBody = (CTBody) get_store().find_element_user(BODY$0, 0);
                if (cTBody == null) {
                    return null;
                }
                return cTBody;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1
    public boolean isSetBody() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BODY$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1
    public void setBody(CTBody cTBody) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = BODY$0;
                CTBody cTBody2 = (CTBody) typeStore.find_element_user(qName, 0);
                if (cTBody2 == null) {
                    cTBody2 = (CTBody) get_store().add_element_user(qName);
                }
                cTBody2.set(cTBody);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1
    public void unsetBody() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BODY$0, 0);
        }
    }
}
