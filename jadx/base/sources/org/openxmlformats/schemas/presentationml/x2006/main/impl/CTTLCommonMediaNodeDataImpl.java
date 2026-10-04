package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.STPositiveFixedPercentage;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonMediaNodeData;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement;

/* JADX INFO: loaded from: classes11.dex */
public class CTTLCommonMediaNodeDataImpl extends XmlComplexContentImpl implements CTTLCommonMediaNodeData {
    private static final QName CTN$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "cTn");
    private static final QName TGTEL$2 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "tgtEl");
    private static final QName VOL$4 = new QName("", "vol");
    private static final QName MUTE$6 = new QName("", "mute");
    private static final QName NUMSLD$8 = new QName("", "numSld");
    private static final QName SHOWWHENSTOPPED$10 = new QName("", "showWhenStopped");

    public CTTLCommonMediaNodeDataImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonMediaNodeData
    public CTTLCommonTimeNodeData addNewCTn() {
        CTTLCommonTimeNodeData cTTLCommonTimeNodeData;
        synchronized (monitor()) {
            check_orphaned();
            cTTLCommonTimeNodeData = (CTTLCommonTimeNodeData) get_store().add_element_user(CTN$0);
        }
        return cTTLCommonTimeNodeData;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonMediaNodeData
    public CTTLTimeTargetElement addNewTgtEl() {
        CTTLTimeTargetElement cTTLTimeTargetElement;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeTargetElement = (CTTLTimeTargetElement) get_store().add_element_user(TGTEL$2);
        }
        return cTTLTimeTargetElement;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonMediaNodeData
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonMediaNodeData
    public boolean getMute() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MUTE$6;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonMediaNodeData
    public long getNumSld() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = NUMSLD$8;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qName);
                }
                if (simpleValue == null) {
                    return 0L;
                }
                return simpleValue.getLongValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonMediaNodeData
    public boolean getShowWhenStopped() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SHOWWHENSTOPPED$10;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonMediaNodeData
    public CTTLTimeTargetElement getTgtEl() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTLTimeTargetElement cTTLTimeTargetElement = (CTTLTimeTargetElement) get_store().find_element_user(TGTEL$2, 0);
                if (cTTLTimeTargetElement == null) {
                    return null;
                }
                return cTTLTimeTargetElement;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonMediaNodeData
    public int getVol() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = VOL$4;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qName);
                }
                if (simpleValue == null) {
                    return 0;
                }
                return simpleValue.getIntValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonMediaNodeData
    public boolean isSetMute() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MUTE$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonMediaNodeData
    public boolean isSetNumSld() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(NUMSLD$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonMediaNodeData
    public boolean isSetShowWhenStopped() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SHOWWHENSTOPPED$10) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonMediaNodeData
    public boolean isSetVol() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(VOL$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonMediaNodeData
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonMediaNodeData
    public void setMute(boolean z) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MUTE$6;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonMediaNodeData
    public void setNumSld(long j) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = NUMSLD$8;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonMediaNodeData
    public void setShowWhenStopped(boolean z) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SHOWWHENSTOPPED$10;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonMediaNodeData
    public void setTgtEl(CTTLTimeTargetElement cTTLTimeTargetElement) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = TGTEL$2;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonMediaNodeData
    public void setVol(int i) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = VOL$4;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setIntValue(i);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonMediaNodeData
    public void unsetMute() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MUTE$6);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonMediaNodeData
    public void unsetNumSld() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(NUMSLD$8);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonMediaNodeData
    public void unsetShowWhenStopped() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SHOWWHENSTOPPED$10);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonMediaNodeData
    public void unsetVol() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(VOL$4);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonMediaNodeData
    public XmlBoolean xgetMute() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MUTE$6;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonMediaNodeData
    public XmlUnsignedInt xgetNumSld() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = NUMSLD$8;
                xmlUnsignedInt = (XmlUnsignedInt) typeStore.find_attribute_user(qName);
                if (xmlUnsignedInt == null) {
                    xmlUnsignedInt = (XmlUnsignedInt) get_default_attribute_value(qName);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonMediaNodeData
    public XmlBoolean xgetShowWhenStopped() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SHOWWHENSTOPPED$10;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonMediaNodeData
    public STPositiveFixedPercentage xgetVol() {
        STPositiveFixedPercentage sTPositiveFixedPercentage;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = VOL$4;
                sTPositiveFixedPercentage = (STPositiveFixedPercentage) typeStore.find_attribute_user(qName);
                if (sTPositiveFixedPercentage == null) {
                    sTPositiveFixedPercentage = (STPositiveFixedPercentage) get_default_attribute_value(qName);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTPositiveFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonMediaNodeData
    public void xsetMute(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MUTE$6;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonMediaNodeData
    public void xsetNumSld(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = NUMSLD$8;
                XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) typeStore.find_attribute_user(qName);
                if (xmlUnsignedInt2 == null) {
                    xmlUnsignedInt2 = (XmlUnsignedInt) get_store().add_attribute_user(qName);
                }
                xmlUnsignedInt2.set(xmlUnsignedInt);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonMediaNodeData
    public void xsetShowWhenStopped(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SHOWWHENSTOPPED$10;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonMediaNodeData
    public void xsetVol(STPositiveFixedPercentage sTPositiveFixedPercentage) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = VOL$4;
                STPositiveFixedPercentage sTPositiveFixedPercentage2 = (STPositiveFixedPercentage) typeStore.find_attribute_user(qName);
                if (sTPositiveFixedPercentage2 == null) {
                    sTPositiveFixedPercentage2 = (STPositiveFixedPercentage) get_store().add_attribute_user(qName);
                }
                sTPositiveFixedPercentage2.set(sTPositiveFixedPercentage);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
