package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTriggerRuntimeNode;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTriggerTimeNodeID;
import org.openxmlformats.schemas.presentationml.x2006.main.STTLTime;
import org.openxmlformats.schemas.presentationml.x2006.main.STTLTriggerEvent;

/* JADX INFO: loaded from: classes11.dex */
public class CTTLTimeConditionImpl extends XmlComplexContentImpl implements CTTLTimeCondition {
    private static final QName TGTEL$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "tgtEl");
    private static final QName TN$2 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "tn");
    private static final QName RTN$4 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "rtn");
    private static final QName EVT$6 = new QName("", "evt");
    private static final QName DELAY$8 = new QName("", "delay");

    public CTTLTimeConditionImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public CTTLTriggerRuntimeNode addNewRtn() {
        CTTLTriggerRuntimeNode cTTLTriggerRuntimeNodeAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTriggerRuntimeNodeAdd_element_user = get_store().add_element_user(RTN$4);
        }
        return cTTLTriggerRuntimeNodeAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public CTTLTimeTargetElement addNewTgtEl() {
        CTTLTimeTargetElement cTTLTimeTargetElement;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeTargetElement = (CTTLTimeTargetElement) get_store().add_element_user(TGTEL$0);
        }
        return cTTLTimeTargetElement;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public CTTLTriggerTimeNodeID addNewTn() {
        CTTLTriggerTimeNodeID cTTLTriggerTimeNodeIDAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTriggerTimeNodeIDAdd_element_user = get_store().add_element_user(TN$2);
        }
        return cTTLTriggerTimeNodeIDAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public Object getDelay() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(DELAY$8);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getObjectValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public STTLTriggerEvent.Enum getEvt() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(EVT$6);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public CTTLTriggerRuntimeNode getRtn() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTLTriggerRuntimeNode cTTLTriggerRuntimeNodeFind_element_user = get_store().find_element_user(RTN$4, 0);
                if (cTTLTriggerRuntimeNodeFind_element_user == null) {
                    return null;
                }
                return cTTLTriggerRuntimeNodeFind_element_user;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public CTTLTimeTargetElement getTgtEl() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTLTimeTargetElement cTTLTimeTargetElement = (CTTLTimeTargetElement) get_store().find_element_user(TGTEL$0, 0);
                if (cTTLTimeTargetElement == null) {
                    return null;
                }
                return cTTLTimeTargetElement;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public CTTLTriggerTimeNodeID getTn() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTLTriggerTimeNodeID cTTLTriggerTimeNodeIDFind_element_user = get_store().find_element_user(TN$2, 0);
                if (cTTLTriggerTimeNodeIDFind_element_user == null) {
                    return null;
                }
                return cTTLTriggerTimeNodeIDFind_element_user;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public boolean isSetDelay() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DELAY$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public boolean isSetEvt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(EVT$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public boolean isSetRtn() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RTN$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public boolean isSetTgtEl() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TGTEL$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public boolean isSetTn() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TN$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public void setDelay(Object obj) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = DELAY$8;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setObjectValue(obj);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public void setEvt(STTLTriggerEvent.Enum r4) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = EVT$6;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setEnumValue(r4);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public void setRtn(CTTLTriggerRuntimeNode cTTLTriggerRuntimeNode) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = RTN$4;
                CTTLTriggerRuntimeNode cTTLTriggerRuntimeNodeFind_element_user = typeStore.find_element_user(qName, 0);
                if (cTTLTriggerRuntimeNodeFind_element_user == null) {
                    cTTLTriggerRuntimeNodeFind_element_user = (CTTLTriggerRuntimeNode) get_store().add_element_user(qName);
                }
                cTTLTriggerRuntimeNodeFind_element_user.set(cTTLTriggerRuntimeNode);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public void setTgtEl(CTTLTimeTargetElement cTTLTimeTargetElement) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = TGTEL$0;
                CTTLTimeTargetElement cTTLTimeTargetElement2 = (CTTLTimeTargetElement) typeStore.find_element_user(qName, 0);
                if (cTTLTimeTargetElement2 == null) {
                    cTTLTimeTargetElement2 = (CTTLTimeTargetElement) get_store().add_element_user(qName);
                }
                cTTLTimeTargetElement2.set(cTTLTimeTargetElement);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public void setTn(CTTLTriggerTimeNodeID cTTLTriggerTimeNodeID) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = TN$2;
                CTTLTriggerTimeNodeID cTTLTriggerTimeNodeIDFind_element_user = typeStore.find_element_user(qName, 0);
                if (cTTLTriggerTimeNodeIDFind_element_user == null) {
                    cTTLTriggerTimeNodeIDFind_element_user = (CTTLTriggerTimeNodeID) get_store().add_element_user(qName);
                }
                cTTLTriggerTimeNodeIDFind_element_user.set(cTTLTriggerTimeNodeID);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public void unsetDelay() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DELAY$8);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public void unsetEvt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(EVT$6);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public void unsetRtn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RTN$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public void unsetTgtEl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TGTEL$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public void unsetTn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TN$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public STTLTime xgetDelay() {
        STTLTime sTTLTimeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTLTimeFind_attribute_user = get_store().find_attribute_user(DELAY$8);
        }
        return sTTLTimeFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public STTLTriggerEvent xgetEvt() {
        STTLTriggerEvent sTTLTriggerEventFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTLTriggerEventFind_attribute_user = get_store().find_attribute_user(EVT$6);
        }
        return sTTLTriggerEventFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public void xsetDelay(STTLTime sTTLTime) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = DELAY$8;
                STTLTime sTTLTimeFind_attribute_user = typeStore.find_attribute_user(qName);
                if (sTTLTimeFind_attribute_user == null) {
                    sTTLTimeFind_attribute_user = (STTLTime) get_store().add_attribute_user(qName);
                }
                sTTLTimeFind_attribute_user.set(sTTLTime);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition
    public void xsetEvt(STTLTriggerEvent sTTLTriggerEvent) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = EVT$6;
                STTLTriggerEvent sTTLTriggerEventFind_attribute_user = typeStore.find_attribute_user(qName);
                if (sTTLTriggerEventFind_attribute_user == null) {
                    sTTLTriggerEventFind_attribute_user = (STTLTriggerEvent) get_store().add_attribute_user(qName);
                }
                sTTLTriggerEventFind_attribute_user.set(sTTLTriggerEvent);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
