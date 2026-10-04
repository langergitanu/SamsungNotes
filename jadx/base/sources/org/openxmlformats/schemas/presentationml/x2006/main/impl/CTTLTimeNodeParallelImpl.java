package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeNodeParallel;

/* JADX INFO: loaded from: classes11.dex */
public class CTTLTimeNodeParallelImpl extends XmlComplexContentImpl implements CTTLTimeNodeParallel {
    private static final QName CTN$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "cTn");

    public CTTLTimeNodeParallelImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeNodeParallel
    public CTTLCommonTimeNodeData addNewCTn() {
        CTTLCommonTimeNodeData cTTLCommonTimeNodeData;
        synchronized (monitor()) {
            check_orphaned();
            cTTLCommonTimeNodeData = (CTTLCommonTimeNodeData) get_store().add_element_user(CTN$0);
        }
        return cTTLCommonTimeNodeData;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeNodeParallel
    public CTTLCommonTimeNodeData getCTn() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTLCommonTimeNodeData cTTLCommonTimeNodeData = (CTTLCommonTimeNodeData) get_store().find_element_user(CTN$0, 0);
                if (cTTLCommonTimeNodeData == null) {
                    return null;
                }
                return cTTLCommonTimeNodeData;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeNodeParallel
    public void setCTn(CTTLCommonTimeNodeData cTTLCommonTimeNodeData) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = CTN$0;
                CTTLCommonTimeNodeData cTTLCommonTimeNodeData2 = (CTTLCommonTimeNodeData) typeStore.find_element_user(qName, 0);
                if (cTTLCommonTimeNodeData2 == null) {
                    cTTLCommonTimeNodeData2 = (CTTLCommonTimeNodeData) get_store().add_element_user(qName);
                }
                cTTLCommonTimeNodeData2.set(cTTLCommonTimeNodeData);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
