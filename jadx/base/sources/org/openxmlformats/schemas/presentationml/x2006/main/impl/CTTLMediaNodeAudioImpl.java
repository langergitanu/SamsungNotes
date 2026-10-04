package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonMediaNodeData;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLMediaNodeAudio;

/* JADX INFO: loaded from: classes11.dex */
public class CTTLMediaNodeAudioImpl extends XmlComplexContentImpl implements CTTLMediaNodeAudio {
    private static final QName CMEDIANODE$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "cMediaNode");
    private static final QName ISNARRATION$2 = new QName("", "isNarration");

    public CTTLMediaNodeAudioImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLMediaNodeAudio
    public CTTLCommonMediaNodeData addNewCMediaNode() {
        CTTLCommonMediaNodeData cTTLCommonMediaNodeData;
        synchronized (monitor()) {
            check_orphaned();
            cTTLCommonMediaNodeData = (CTTLCommonMediaNodeData) get_store().add_element_user(CMEDIANODE$0);
        }
        return cTTLCommonMediaNodeData;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLMediaNodeAudio
    public CTTLCommonMediaNodeData getCMediaNode() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTLCommonMediaNodeData cTTLCommonMediaNodeData = (CTTLCommonMediaNodeData) get_store().find_element_user(CMEDIANODE$0, 0);
                if (cTTLCommonMediaNodeData == null) {
                    return null;
                }
                return cTTLCommonMediaNodeData;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLMediaNodeAudio
    public boolean getIsNarration() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ISNARRATION$2;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qName);
                }
                if (simpleValue == null) {
                    return false;
                }
                return simpleValue.getBooleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLMediaNodeAudio
    public boolean isSetIsNarration() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ISNARRATION$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLMediaNodeAudio
    public void setCMediaNode(CTTLCommonMediaNodeData cTTLCommonMediaNodeData) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = CMEDIANODE$0;
                CTTLCommonMediaNodeData cTTLCommonMediaNodeData2 = (CTTLCommonMediaNodeData) typeStore.find_element_user(qName, 0);
                if (cTTLCommonMediaNodeData2 == null) {
                    cTTLCommonMediaNodeData2 = (CTTLCommonMediaNodeData) get_store().add_element_user(qName);
                }
                cTTLCommonMediaNodeData2.set(cTTLCommonMediaNodeData);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLMediaNodeAudio
    public void setIsNarration(boolean z) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ISNARRATION$2;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setBooleanValue(z);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLMediaNodeAudio
    public void unsetIsNarration() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ISNARRATION$2);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLMediaNodeAudio
    public XmlBoolean xgetIsNarration() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ISNARRATION$2;
                xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qName);
                if (xmlBoolean == null) {
                    xmlBoolean = (XmlBoolean) get_default_attribute_value(qName);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLMediaNodeAudio
    public void xsetIsNarration(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ISNARRATION$2;
                XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
                if (xmlBoolean2 == null) {
                    xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
                }
                xmlBoolean2.set(xmlBoolean);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
