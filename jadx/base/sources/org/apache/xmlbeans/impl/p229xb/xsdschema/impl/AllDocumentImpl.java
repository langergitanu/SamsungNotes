package org.apache.xmlbeans.impl.p229xb.xsdschema.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.p229xb.xsdschema.All;
import org.apache.xmlbeans.impl.p229xb.xsdschema.AllDocument;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class AllDocumentImpl extends XmlComplexContentImpl implements AllDocument {
    private static final QName ALL$0 = new QName("http://www.w3.org/2001/XMLSchema", "all");

    public AllDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.p229xb.xsdschema.AllDocument
    public All addNewAll() {
        All all;
        synchronized (monitor()) {
            check_orphaned();
            all = (All) get_store().add_element_user(ALL$0);
        }
        return all;
    }

    @Override // org.apache.xmlbeans.impl.p229xb.xsdschema.AllDocument
    public All getAll() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                All all = (All) get_store().find_element_user(ALL$0, 0);
                if (all == null) {
                    return null;
                }
                return all;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.xmlbeans.impl.p229xb.xsdschema.AllDocument
    public void setAll(All all) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ALL$0;
                All all2 = (All) typeStore.find_element_user(qName, 0);
                if (all2 == null) {
                    all2 = (All) get_store().add_element_user(qName);
                }
                all2.set(all);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
