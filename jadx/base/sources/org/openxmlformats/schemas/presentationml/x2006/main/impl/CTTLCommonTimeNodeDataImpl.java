package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementKey;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.STPercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.STPositiveFixedPercentage;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLIterateData;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeConditionList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList;
import org.openxmlformats.schemas.presentationml.x2006.main.STTLTime;
import org.openxmlformats.schemas.presentationml.x2006.main.STTLTimeNodeFillType;
import org.openxmlformats.schemas.presentationml.x2006.main.STTLTimeNodeID;
import org.openxmlformats.schemas.presentationml.x2006.main.STTLTimeNodeMasterRelation;
import org.openxmlformats.schemas.presentationml.x2006.main.STTLTimeNodePresetClassType;
import org.openxmlformats.schemas.presentationml.x2006.main.STTLTimeNodeRestartType;
import org.openxmlformats.schemas.presentationml.x2006.main.STTLTimeNodeSyncType;
import org.openxmlformats.schemas.presentationml.x2006.main.STTLTimeNodeType;

/* JADX INFO: loaded from: classes11.dex */
public class CTTLCommonTimeNodeDataImpl extends XmlComplexContentImpl implements CTTLCommonTimeNodeData {
    private static final QName STCONDLST$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "stCondLst");
    private static final QName ENDCONDLST$2 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "endCondLst");
    private static final QName ENDSYNC$4 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "endSync");
    private static final QName ITERATE$6 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "iterate");
    private static final QName CHILDTNLST$8 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "childTnLst");
    private static final QName SUBTNLST$10 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "subTnLst");
    private static final QName ID$12 = new QName("", "id");
    private static final QName PRESETID$14 = new QName("", "presetID");
    private static final QName PRESETCLASS$16 = new QName("", "presetClass");
    private static final QName PRESETSUBTYPE$18 = new QName("", "presetSubtype");
    private static final QName DUR$20 = new QName("", "dur");
    private static final QName REPEATCOUNT$22 = new QName("", "repeatCount");
    private static final QName REPEATDUR$24 = new QName("", "repeatDur");
    private static final QName SPD$26 = new QName("", "spd");
    private static final QName ACCEL$28 = new QName("", "accel");
    private static final QName DECEL$30 = new QName("", "decel");
    private static final QName AUTOREV$32 = new QName("", "autoRev");
    private static final QName RESTART$34 = new QName("", "restart");
    private static final QName FILL$36 = new QName("", VElementKey.FILL);
    private static final QName SYNCBEHAVIOR$38 = new QName("", "syncBehavior");
    private static final QName TMFILTER$40 = new QName("", "tmFilter");
    private static final QName EVTFILTER$42 = new QName("", "evtFilter");
    private static final QName DISPLAY$44 = new QName("", "display");
    private static final QName MASTERREL$46 = new QName("", "masterRel");
    private static final QName BLDLVL$48 = new QName("", "bldLvl");
    private static final QName GRPID$50 = new QName("", "grpId");
    private static final QName AFTEREFFECT$52 = new QName("", "afterEffect");
    private static final QName NODETYPE$54 = new QName("", "nodeType");
    private static final QName NODEPH$56 = new QName("", "nodePh");

    public CTTLCommonTimeNodeDataImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public CTTimeNodeList addNewChildTnLst() {
        CTTimeNodeList cTTimeNodeList;
        synchronized (monitor()) {
            check_orphaned();
            cTTimeNodeList = (CTTimeNodeList) get_store().add_element_user(CHILDTNLST$8);
        }
        return cTTimeNodeList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public CTTLTimeConditionList addNewEndCondLst() {
        CTTLTimeConditionList cTTLTimeConditionList;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeConditionList = (CTTLTimeConditionList) get_store().add_element_user(ENDCONDLST$2);
        }
        return cTTLTimeConditionList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public CTTLTimeCondition addNewEndSync() {
        CTTLTimeCondition cTTLTimeCondition;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeCondition = (CTTLTimeCondition) get_store().add_element_user(ENDSYNC$4);
        }
        return cTTLTimeCondition;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public CTTLIterateData addNewIterate() {
        CTTLIterateData cTTLIterateDataAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLIterateDataAdd_element_user = get_store().add_element_user(ITERATE$6);
        }
        return cTTLIterateDataAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public CTTLTimeConditionList addNewStCondLst() {
        CTTLTimeConditionList cTTLTimeConditionList;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeConditionList = (CTTLTimeConditionList) get_store().add_element_user(STCONDLST$0);
        }
        return cTTLTimeConditionList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public CTTimeNodeList addNewSubTnLst() {
        CTTimeNodeList cTTimeNodeList;
        synchronized (monitor()) {
            check_orphaned();
            cTTimeNodeList = (CTTimeNodeList) get_store().add_element_user(SUBTNLST$10);
        }
        return cTTimeNodeList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public int getAccel() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ACCEL$28;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean getAfterEffect() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(AFTEREFFECT$52);
                if (simpleValue == null) {
                    return false;
                }
                return simpleValue.getBooleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean getAutoRev() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = AUTOREV$32;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public int getBldLvl() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BLDLVL$48);
                if (simpleValue == null) {
                    return 0;
                }
                return simpleValue.getIntValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public CTTimeNodeList getChildTnLst() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTimeNodeList cTTimeNodeList = (CTTimeNodeList) get_store().find_element_user(CHILDTNLST$8, 0);
                if (cTTimeNodeList == null) {
                    return null;
                }
                return cTTimeNodeList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public int getDecel() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = DECEL$30;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean getDisplay() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(DISPLAY$44);
                if (simpleValue == null) {
                    return false;
                }
                return simpleValue.getBooleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public Object getDur() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(DUR$20);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getObjectValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public CTTLTimeConditionList getEndCondLst() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTLTimeConditionList cTTLTimeConditionList = (CTTLTimeConditionList) get_store().find_element_user(ENDCONDLST$2, 0);
                if (cTTLTimeConditionList == null) {
                    return null;
                }
                return cTTLTimeConditionList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public CTTLTimeCondition getEndSync() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTLTimeCondition cTTLTimeCondition = (CTTLTimeCondition) get_store().find_element_user(ENDSYNC$4, 0);
                if (cTTLTimeCondition == null) {
                    return null;
                }
                return cTTLTimeCondition;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public String getEvtFilter() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(EVTFILTER$42);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STTLTimeNodeFillType.Enum getFill() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FILL$36);
                if (simpleValue == null) {
                    return null;
                }
                return (STTLTimeNodeFillType.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public long getGrpId() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(GRPID$50);
                if (simpleValue == null) {
                    return 0L;
                }
                return simpleValue.getLongValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public long getId() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ID$12);
                if (simpleValue == null) {
                    return 0L;
                }
                return simpleValue.getLongValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public CTTLIterateData getIterate() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTLIterateData cTTLIterateDataFind_element_user = get_store().find_element_user(ITERATE$6, 0);
                if (cTTLIterateDataFind_element_user == null) {
                    return null;
                }
                return cTTLIterateDataFind_element_user;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STTLTimeNodeMasterRelation.Enum getMasterRel() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(MASTERREL$46);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean getNodePh() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(NODEPH$56);
                if (simpleValue == null) {
                    return false;
                }
                return simpleValue.getBooleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STTLTimeNodeType.Enum getNodeType() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(NODETYPE$54);
                if (simpleValue == null) {
                    return null;
                }
                return (STTLTimeNodeType.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STTLTimeNodePresetClassType.Enum getPresetClass() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PRESETCLASS$16);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public int getPresetID() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PRESETID$14);
                if (simpleValue == null) {
                    return 0;
                }
                return simpleValue.getIntValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public int getPresetSubtype() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PRESETSUBTYPE$18);
                if (simpleValue == null) {
                    return 0;
                }
                return simpleValue.getIntValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public Object getRepeatCount() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = REPEATCOUNT$22;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qName);
                }
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getObjectValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public Object getRepeatDur() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(REPEATDUR$24);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getObjectValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STTLTimeNodeRestartType.Enum getRestart() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(RESTART$34);
                if (simpleValue == null) {
                    return null;
                }
                return (STTLTimeNodeRestartType.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public int getSpd() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SPD$26;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public CTTLTimeConditionList getStCondLst() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTLTimeConditionList cTTLTimeConditionList = (CTTLTimeConditionList) get_store().find_element_user(STCONDLST$0, 0);
                if (cTTLTimeConditionList == null) {
                    return null;
                }
                return cTTLTimeConditionList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public CTTimeNodeList getSubTnLst() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTimeNodeList cTTimeNodeList = (CTTimeNodeList) get_store().find_element_user(SUBTNLST$10, 0);
                if (cTTimeNodeList == null) {
                    return null;
                }
                return cTTimeNodeList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STTLTimeNodeSyncType.Enum getSyncBehavior() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(SYNCBEHAVIOR$38);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public String getTmFilter() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TMFILTER$40);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetAccel() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ACCEL$28) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetAfterEffect() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(AFTEREFFECT$52) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetAutoRev() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(AUTOREV$32) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetBldLvl() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BLDLVL$48) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetChildTnLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CHILDTNLST$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetDecel() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DECEL$30) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetDisplay() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DISPLAY$44) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetDur() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DUR$20) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetEndCondLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ENDCONDLST$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetEndSync() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ENDSYNC$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetEvtFilter() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(EVTFILTER$42) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FILL$36) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetGrpId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(GRPID$50) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$12) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetIterate() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(ITERATE$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetMasterRel() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MASTERREL$46) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetNodePh() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(NODEPH$56) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetNodeType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(NODETYPE$54) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetPresetClass() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PRESETCLASS$16) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetPresetID() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PRESETID$14) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetPresetSubtype() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PRESETSUBTYPE$18) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetRepeatCount() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(REPEATCOUNT$22) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetRepeatDur() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(REPEATDUR$24) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetRestart() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(RESTART$34) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetSpd() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SPD$26) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetStCondLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(STCONDLST$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetSubTnLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SUBTNLST$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetSyncBehavior() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SYNCBEHAVIOR$38) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public boolean isSetTmFilter() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TMFILTER$40) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setAccel(int i) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ACCEL$28;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setAfterEffect(boolean z) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = AFTEREFFECT$52;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setAutoRev(boolean z) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = AUTOREV$32;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setBldLvl(int i) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = BLDLVL$48;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setChildTnLst(CTTimeNodeList cTTimeNodeList) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = CHILDTNLST$8;
                CTTimeNodeList cTTimeNodeList2 = (CTTimeNodeList) typeStore.find_element_user(qName, 0);
                if (cTTimeNodeList2 == null) {
                    cTTimeNodeList2 = (CTTimeNodeList) get_store().add_element_user(qName);
                }
                cTTimeNodeList2.set(cTTimeNodeList);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setDecel(int i) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = DECEL$30;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setDisplay(boolean z) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = DISPLAY$44;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setDur(Object obj) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = DUR$20;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setEndCondLst(CTTLTimeConditionList cTTLTimeConditionList) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ENDCONDLST$2;
                CTTLTimeConditionList cTTLTimeConditionList2 = (CTTLTimeConditionList) typeStore.find_element_user(qName, 0);
                if (cTTLTimeConditionList2 == null) {
                    cTTLTimeConditionList2 = (CTTLTimeConditionList) get_store().add_element_user(qName);
                }
                cTTLTimeConditionList2.set(cTTLTimeConditionList);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setEndSync(CTTLTimeCondition cTTLTimeCondition) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ENDSYNC$4;
                CTTLTimeCondition cTTLTimeCondition2 = (CTTLTimeCondition) typeStore.find_element_user(qName, 0);
                if (cTTLTimeCondition2 == null) {
                    cTTLTimeCondition2 = (CTTLTimeCondition) get_store().add_element_user(qName);
                }
                cTTLTimeCondition2.set(cTTLTimeCondition);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setEvtFilter(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = EVTFILTER$42;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setFill(STTLTimeNodeFillType.Enum r4) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = FILL$36;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setGrpId(long j) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = GRPID$50;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setId(long j) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ID$12;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setIterate(CTTLIterateData cTTLIterateData) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ITERATE$6;
                CTTLIterateData cTTLIterateDataFind_element_user = typeStore.find_element_user(qName, 0);
                if (cTTLIterateDataFind_element_user == null) {
                    cTTLIterateDataFind_element_user = (CTTLIterateData) get_store().add_element_user(qName);
                }
                cTTLIterateDataFind_element_user.set(cTTLIterateData);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setMasterRel(STTLTimeNodeMasterRelation.Enum r4) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MASTERREL$46;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setNodePh(boolean z) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = NODEPH$56;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setNodeType(STTLTimeNodeType.Enum r4) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = NODETYPE$54;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setPresetClass(STTLTimeNodePresetClassType.Enum r4) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = PRESETCLASS$16;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setPresetID(int i) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = PRESETID$14;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setPresetSubtype(int i) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = PRESETSUBTYPE$18;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setRepeatCount(Object obj) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = REPEATCOUNT$22;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setRepeatDur(Object obj) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = REPEATDUR$24;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setRestart(STTLTimeNodeRestartType.Enum r4) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = RESTART$34;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setSpd(int i) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SPD$26;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setStCondLst(CTTLTimeConditionList cTTLTimeConditionList) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = STCONDLST$0;
                CTTLTimeConditionList cTTLTimeConditionList2 = (CTTLTimeConditionList) typeStore.find_element_user(qName, 0);
                if (cTTLTimeConditionList2 == null) {
                    cTTLTimeConditionList2 = (CTTLTimeConditionList) get_store().add_element_user(qName);
                }
                cTTLTimeConditionList2.set(cTTLTimeConditionList);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setSubTnLst(CTTimeNodeList cTTimeNodeList) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SUBTNLST$10;
                CTTimeNodeList cTTimeNodeList2 = (CTTimeNodeList) typeStore.find_element_user(qName, 0);
                if (cTTimeNodeList2 == null) {
                    cTTimeNodeList2 = (CTTimeNodeList) get_store().add_element_user(qName);
                }
                cTTimeNodeList2.set(cTTimeNodeList);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setSyncBehavior(STTLTimeNodeSyncType.Enum r4) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SYNCBEHAVIOR$38;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void setTmFilter(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = TMFILTER$40;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetAccel() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ACCEL$28);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetAfterEffect() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(AFTEREFFECT$52);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetAutoRev() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(AUTOREV$32);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetBldLvl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BLDLVL$48);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetChildTnLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CHILDTNLST$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetDecel() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DECEL$30);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetDisplay() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DISPLAY$44);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetDur() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DUR$20);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetEndCondLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ENDCONDLST$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetEndSync() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ENDSYNC$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetEvtFilter() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(EVTFILTER$42);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FILL$36);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetGrpId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(GRPID$50);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$12);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetIterate() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ITERATE$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetMasterRel() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MASTERREL$46);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetNodePh() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(NODEPH$56);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetNodeType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(NODETYPE$54);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetPresetClass() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PRESETCLASS$16);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetPresetID() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PRESETID$14);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetPresetSubtype() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PRESETSUBTYPE$18);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetRepeatCount() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(REPEATCOUNT$22);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetRepeatDur() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(REPEATDUR$24);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetRestart() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(RESTART$34);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetSpd() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SPD$26);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetStCondLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STCONDLST$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetSubTnLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SUBTNLST$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetSyncBehavior() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SYNCBEHAVIOR$38);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void unsetTmFilter() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TMFILTER$40);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STPositiveFixedPercentage xgetAccel() {
        STPositiveFixedPercentage sTPositiveFixedPercentage;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ACCEL$28;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public XmlBoolean xgetAfterEffect() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            xmlBoolean = (XmlBoolean) get_store().find_attribute_user(AFTEREFFECT$52);
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public XmlBoolean xgetAutoRev() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = AUTOREV$32;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public XmlInt xgetBldLvl() {
        XmlInt xmlInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlInt = (XmlInt) get_store().find_attribute_user(BLDLVL$48);
        }
        return xmlInt;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STPositiveFixedPercentage xgetDecel() {
        STPositiveFixedPercentage sTPositiveFixedPercentage;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = DECEL$30;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public XmlBoolean xgetDisplay() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            xmlBoolean = (XmlBoolean) get_store().find_attribute_user(DISPLAY$44);
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STTLTime xgetDur() {
        STTLTime sTTLTimeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTLTimeFind_attribute_user = get_store().find_attribute_user(DUR$20);
        }
        return sTTLTimeFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public XmlString xgetEvtFilter() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(EVTFILTER$42);
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STTLTimeNodeFillType xgetFill() {
        STTLTimeNodeFillType sTTLTimeNodeFillType;
        synchronized (monitor()) {
            check_orphaned();
            sTTLTimeNodeFillType = (STTLTimeNodeFillType) get_store().find_attribute_user(FILL$36);
        }
        return sTTLTimeNodeFillType;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public XmlUnsignedInt xgetGrpId() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlUnsignedInt = (XmlUnsignedInt) get_store().find_attribute_user(GRPID$50);
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STTLTimeNodeID xgetId() {
        STTLTimeNodeID sTTLTimeNodeIDFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTLTimeNodeIDFind_attribute_user = get_store().find_attribute_user(ID$12);
        }
        return sTTLTimeNodeIDFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STTLTimeNodeMasterRelation xgetMasterRel() {
        STTLTimeNodeMasterRelation sTTLTimeNodeMasterRelationFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTLTimeNodeMasterRelationFind_attribute_user = get_store().find_attribute_user(MASTERREL$46);
        }
        return sTTLTimeNodeMasterRelationFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public XmlBoolean xgetNodePh() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            check_orphaned();
            xmlBoolean = (XmlBoolean) get_store().find_attribute_user(NODEPH$56);
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STTLTimeNodeType xgetNodeType() {
        STTLTimeNodeType sTTLTimeNodeType;
        synchronized (monitor()) {
            check_orphaned();
            sTTLTimeNodeType = (STTLTimeNodeType) get_store().find_attribute_user(NODETYPE$54);
        }
        return sTTLTimeNodeType;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STTLTimeNodePresetClassType xgetPresetClass() {
        STTLTimeNodePresetClassType sTTLTimeNodePresetClassTypeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTLTimeNodePresetClassTypeFind_attribute_user = get_store().find_attribute_user(PRESETCLASS$16);
        }
        return sTTLTimeNodePresetClassTypeFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public XmlInt xgetPresetID() {
        XmlInt xmlInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlInt = (XmlInt) get_store().find_attribute_user(PRESETID$14);
        }
        return xmlInt;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public XmlInt xgetPresetSubtype() {
        XmlInt xmlInt;
        synchronized (monitor()) {
            check_orphaned();
            xmlInt = (XmlInt) get_store().find_attribute_user(PRESETSUBTYPE$18);
        }
        return xmlInt;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STTLTime xgetRepeatCount() {
        STTLTime sTTLTimeFind_attribute_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = REPEATCOUNT$22;
                sTTLTimeFind_attribute_user = typeStore.find_attribute_user(qName);
                if (sTTLTimeFind_attribute_user == null) {
                    sTTLTimeFind_attribute_user = (STTLTime) get_default_attribute_value(qName);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTLTimeFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STTLTime xgetRepeatDur() {
        STTLTime sTTLTimeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTLTimeFind_attribute_user = get_store().find_attribute_user(REPEATDUR$24);
        }
        return sTTLTimeFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STTLTimeNodeRestartType xgetRestart() {
        STTLTimeNodeRestartType sTTLTimeNodeRestartType;
        synchronized (monitor()) {
            check_orphaned();
            sTTLTimeNodeRestartType = (STTLTimeNodeRestartType) get_store().find_attribute_user(RESTART$34);
        }
        return sTTLTimeNodeRestartType;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STPercentage xgetSpd() {
        STPercentage sTPercentage;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SPD$26;
                sTPercentage = (STPercentage) typeStore.find_attribute_user(qName);
                if (sTPercentage == null) {
                    sTPercentage = (STPercentage) get_default_attribute_value(qName);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTPercentage;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public STTLTimeNodeSyncType xgetSyncBehavior() {
        STTLTimeNodeSyncType sTTLTimeNodeSyncTypeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTLTimeNodeSyncTypeFind_attribute_user = get_store().find_attribute_user(SYNCBEHAVIOR$38);
        }
        return sTTLTimeNodeSyncTypeFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public XmlString xgetTmFilter() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(TMFILTER$40);
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetAccel(STPositiveFixedPercentage sTPositiveFixedPercentage) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ACCEL$28;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetAfterEffect(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = AFTEREFFECT$52;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetAutoRev(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = AUTOREV$32;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetBldLvl(XmlInt xmlInt) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = BLDLVL$48;
                XmlInt xmlInt2 = (XmlInt) typeStore.find_attribute_user(qName);
                if (xmlInt2 == null) {
                    xmlInt2 = (XmlInt) get_store().add_attribute_user(qName);
                }
                xmlInt2.set(xmlInt);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetDecel(STPositiveFixedPercentage sTPositiveFixedPercentage) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = DECEL$30;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetDisplay(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = DISPLAY$44;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetDur(STTLTime sTTLTime) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = DUR$20;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetEvtFilter(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = EVTFILTER$42;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qName);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetFill(STTLTimeNodeFillType sTTLTimeNodeFillType) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = FILL$36;
                STTLTimeNodeFillType sTTLTimeNodeFillType2 = (STTLTimeNodeFillType) typeStore.find_attribute_user(qName);
                if (sTTLTimeNodeFillType2 == null) {
                    sTTLTimeNodeFillType2 = (STTLTimeNodeFillType) get_store().add_attribute_user(qName);
                }
                sTTLTimeNodeFillType2.set(sTTLTimeNodeFillType);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetGrpId(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = GRPID$50;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetId(STTLTimeNodeID sTTLTimeNodeID) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ID$12;
                STTLTimeNodeID sTTLTimeNodeIDFind_attribute_user = typeStore.find_attribute_user(qName);
                if (sTTLTimeNodeIDFind_attribute_user == null) {
                    sTTLTimeNodeIDFind_attribute_user = (STTLTimeNodeID) get_store().add_attribute_user(qName);
                }
                sTTLTimeNodeIDFind_attribute_user.set(sTTLTimeNodeID);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetMasterRel(STTLTimeNodeMasterRelation sTTLTimeNodeMasterRelation) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MASTERREL$46;
                STTLTimeNodeMasterRelation sTTLTimeNodeMasterRelationFind_attribute_user = typeStore.find_attribute_user(qName);
                if (sTTLTimeNodeMasterRelationFind_attribute_user == null) {
                    sTTLTimeNodeMasterRelationFind_attribute_user = (STTLTimeNodeMasterRelation) get_store().add_attribute_user(qName);
                }
                sTTLTimeNodeMasterRelationFind_attribute_user.set(sTTLTimeNodeMasterRelation);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetNodePh(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = NODEPH$56;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetNodeType(STTLTimeNodeType sTTLTimeNodeType) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = NODETYPE$54;
                STTLTimeNodeType sTTLTimeNodeType2 = (STTLTimeNodeType) typeStore.find_attribute_user(qName);
                if (sTTLTimeNodeType2 == null) {
                    sTTLTimeNodeType2 = (STTLTimeNodeType) get_store().add_attribute_user(qName);
                }
                sTTLTimeNodeType2.set(sTTLTimeNodeType);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetPresetClass(STTLTimeNodePresetClassType sTTLTimeNodePresetClassType) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = PRESETCLASS$16;
                STTLTimeNodePresetClassType sTTLTimeNodePresetClassTypeFind_attribute_user = typeStore.find_attribute_user(qName);
                if (sTTLTimeNodePresetClassTypeFind_attribute_user == null) {
                    sTTLTimeNodePresetClassTypeFind_attribute_user = (STTLTimeNodePresetClassType) get_store().add_attribute_user(qName);
                }
                sTTLTimeNodePresetClassTypeFind_attribute_user.set(sTTLTimeNodePresetClassType);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetPresetID(XmlInt xmlInt) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = PRESETID$14;
                XmlInt xmlInt2 = (XmlInt) typeStore.find_attribute_user(qName);
                if (xmlInt2 == null) {
                    xmlInt2 = (XmlInt) get_store().add_attribute_user(qName);
                }
                xmlInt2.set(xmlInt);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetPresetSubtype(XmlInt xmlInt) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = PRESETSUBTYPE$18;
                XmlInt xmlInt2 = (XmlInt) typeStore.find_attribute_user(qName);
                if (xmlInt2 == null) {
                    xmlInt2 = (XmlInt) get_store().add_attribute_user(qName);
                }
                xmlInt2.set(xmlInt);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetRepeatCount(STTLTime sTTLTime) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = REPEATCOUNT$22;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetRepeatDur(STTLTime sTTLTime) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = REPEATDUR$24;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetRestart(STTLTimeNodeRestartType sTTLTimeNodeRestartType) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = RESTART$34;
                STTLTimeNodeRestartType sTTLTimeNodeRestartType2 = (STTLTimeNodeRestartType) typeStore.find_attribute_user(qName);
                if (sTTLTimeNodeRestartType2 == null) {
                    sTTLTimeNodeRestartType2 = (STTLTimeNodeRestartType) get_store().add_attribute_user(qName);
                }
                sTTLTimeNodeRestartType2.set(sTTLTimeNodeRestartType);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetSpd(STPercentage sTPercentage) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SPD$26;
                STPercentage sTPercentage2 = (STPercentage) typeStore.find_attribute_user(qName);
                if (sTPercentage2 == null) {
                    sTPercentage2 = (STPercentage) get_store().add_attribute_user(qName);
                }
                sTPercentage2.set(sTPercentage);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetSyncBehavior(STTLTimeNodeSyncType sTTLTimeNodeSyncType) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SYNCBEHAVIOR$38;
                STTLTimeNodeSyncType sTTLTimeNodeSyncTypeFind_attribute_user = typeStore.find_attribute_user(qName);
                if (sTTLTimeNodeSyncTypeFind_attribute_user == null) {
                    sTTLTimeNodeSyncTypeFind_attribute_user = (STTLTimeNodeSyncType) get_store().add_attribute_user(qName);
                }
                sTTLTimeNodeSyncTypeFind_attribute_user.set(sTTLTimeNodeSyncType);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommonTimeNodeData
    public void xsetTmFilter(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = TMFILTER$40;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qName);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
