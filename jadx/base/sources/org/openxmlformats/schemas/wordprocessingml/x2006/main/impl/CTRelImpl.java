package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRel;

/* JADX INFO: loaded from: classes11.dex */
public class CTRelImpl extends XmlComplexContentImpl implements CTRel {
    private static final QName ID$0 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "id");

    public CTRelImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRel
    public String getId() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ID$0);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRel
    public void setId(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ID$0;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRel
    public STRelationshipId xgetId() {
        STRelationshipId sTRelationshipId;
        synchronized (monitor()) {
            check_orphaned();
            sTRelationshipId = (STRelationshipId) get_store().find_attribute_user(ID$0);
        }
        return sTRelationshipId;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRel
    public void xsetId(STRelationshipId sTRelationshipId) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ID$0;
                STRelationshipId sTRelationshipId2 = (STRelationshipId) typeStore.find_attribute_user(qName);
                if (sTRelationshipId2 == null) {
                    sTRelationshipId2 = (STRelationshipId) get_store().add_attribute_user(qName);
                }
                sTRelationshipId2.set(sTRelationshipId);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
