package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTEndnotes;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.EndnotesDocument;

/* JADX INFO: loaded from: classes11.dex */
public class EndnotesDocumentImpl extends XmlComplexContentImpl implements EndnotesDocument {
    private static final QName ENDNOTES$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "endnotes");

    public EndnotesDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.EndnotesDocument
    public CTEndnotes addNewEndnotes() {
        CTEndnotes cTEndnotes;
        synchronized (monitor()) {
            check_orphaned();
            cTEndnotes = (CTEndnotes) get_store().add_element_user(ENDNOTES$0);
        }
        return cTEndnotes;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.EndnotesDocument
    public CTEndnotes getEndnotes() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTEndnotes cTEndnotes = (CTEndnotes) get_store().find_element_user(ENDNOTES$0, 0);
                if (cTEndnotes == null) {
                    return null;
                }
                return cTEndnotes;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.EndnotesDocument
    public void setEndnotes(CTEndnotes cTEndnotes) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ENDNOTES$0;
                CTEndnotes cTEndnotes2 = (CTEndnotes) typeStore.find_element_user(qName, 0);
                if (cTEndnotes2 == null) {
                    cTEndnotes2 = (CTEndnotes) get_store().add_element_user(qName);
                }
                cTEndnotes2.set(cTEndnotes);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
