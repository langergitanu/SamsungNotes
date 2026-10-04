package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdListEntry;
import org.openxmlformats.schemas.presentationml.x2006.main.STSlideId;

/* JADX INFO: loaded from: classes11.dex */
public class CTSlideIdListEntryImpl extends XmlComplexContentImpl implements CTSlideIdListEntry {
    private static final QName EXTLST$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst");
    private static final QName ID$2 = new QName("", "id");
    private static final QName ID2$4 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "id");

    public CTSlideIdListEntryImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdListEntry
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().add_element_user(EXTLST$0);
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdListEntry
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTExtensionList cTExtensionList = (CTExtensionList) get_store().find_element_user(EXTLST$0, 0);
                if (cTExtensionList == null) {
                    return null;
                }
                return cTExtensionList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdListEntry
    public long getId() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ID$2);
                if (simpleValue == null) {
                    return 0L;
                }
                return simpleValue.getLongValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdListEntry
    public String getId2() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ID2$4);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdListEntry
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdListEntry
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = EXTLST$0;
                CTExtensionList cTExtensionList2 = (CTExtensionList) typeStore.find_element_user(qName, 0);
                if (cTExtensionList2 == null) {
                    cTExtensionList2 = (CTExtensionList) get_store().add_element_user(qName);
                }
                cTExtensionList2.set(cTExtensionList);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdListEntry
    public void setId(long j) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ID$2;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setLongValue(j);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdListEntry
    public void setId2(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ID2$4;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdListEntry
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdListEntry
    public STSlideId xgetId() {
        STSlideId sTSlideId;
        synchronized (monitor()) {
            check_orphaned();
            sTSlideId = (STSlideId) get_store().find_attribute_user(ID$2);
        }
        return sTSlideId;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdListEntry
    public STRelationshipId xgetId2() {
        STRelationshipId sTRelationshipId;
        synchronized (monitor()) {
            check_orphaned();
            sTRelationshipId = (STRelationshipId) get_store().find_attribute_user(ID2$4);
        }
        return sTRelationshipId;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdListEntry
    public void xsetId(STSlideId sTSlideId) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ID$2;
                STSlideId sTSlideId2 = (STSlideId) typeStore.find_attribute_user(qName);
                if (sTSlideId2 == null) {
                    sTSlideId2 = (STSlideId) get_store().add_attribute_user(qName);
                }
                sTSlideId2.set(sTSlideId);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideIdListEntry
    public void xsetId2(STRelationshipId sTRelationshipId) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ID2$4;
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
