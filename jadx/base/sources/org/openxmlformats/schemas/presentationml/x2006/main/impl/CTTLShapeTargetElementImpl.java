package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAnimationElementChoice;
import org.openxmlformats.schemas.drawingml.x2006.main.STShapeID;
import org.openxmlformats.schemas.presentationml.x2006.main.CTEmpty;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLOleChartTargetElement;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLSubShapeId;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTextTargetElement;

/* JADX INFO: loaded from: classes11.dex */
public class CTTLShapeTargetElementImpl extends XmlComplexContentImpl implements CTTLShapeTargetElement {
    private static final QName BG$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", MarketingConstants.PopupConst.COLOR_BACKGROUND);
    private static final QName SUBSP$2 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "subSp");
    private static final QName OLECHARTEL$4 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "oleChartEl");
    private static final QName TXEL$6 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "txEl");
    private static final QName GRAPHICEL$8 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "graphicEl");
    private static final QName SPID$10 = new QName("", "spid");

    public CTTLShapeTargetElementImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public CTEmpty addNewBg() {
        CTEmpty cTEmptyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyAdd_element_user = get_store().add_element_user(BG$0);
        }
        return cTEmptyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public CTAnimationElementChoice addNewGraphicEl() {
        CTAnimationElementChoice cTAnimationElementChoiceAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTAnimationElementChoiceAdd_element_user = get_store().add_element_user(GRAPHICEL$8);
        }
        return cTAnimationElementChoiceAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public CTTLOleChartTargetElement addNewOleChartEl() {
        CTTLOleChartTargetElement cTTLOleChartTargetElementAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLOleChartTargetElementAdd_element_user = get_store().add_element_user(OLECHARTEL$4);
        }
        return cTTLOleChartTargetElementAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public CTTLSubShapeId addNewSubSp() {
        CTTLSubShapeId cTTLSubShapeIdAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLSubShapeIdAdd_element_user = get_store().add_element_user(SUBSP$2);
        }
        return cTTLSubShapeIdAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public CTTLTextTargetElement addNewTxEl() {
        CTTLTextTargetElement cTTLTextTargetElementAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTextTargetElementAdd_element_user = get_store().add_element_user(TXEL$6);
        }
        return cTTLTextTargetElementAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public CTEmpty getBg() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTEmpty cTEmptyFind_element_user = get_store().find_element_user(BG$0, 0);
                if (cTEmptyFind_element_user == null) {
                    return null;
                }
                return cTEmptyFind_element_user;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public CTAnimationElementChoice getGraphicEl() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTAnimationElementChoice cTAnimationElementChoiceFind_element_user = get_store().find_element_user(GRAPHICEL$8, 0);
                if (cTAnimationElementChoiceFind_element_user == null) {
                    return null;
                }
                return cTAnimationElementChoiceFind_element_user;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public CTTLOleChartTargetElement getOleChartEl() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTLOleChartTargetElement cTTLOleChartTargetElementFind_element_user = get_store().find_element_user(OLECHARTEL$4, 0);
                if (cTTLOleChartTargetElementFind_element_user == null) {
                    return null;
                }
                return cTTLOleChartTargetElementFind_element_user;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public String getSpid() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(SPID$10);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public CTTLSubShapeId getSubSp() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTLSubShapeId cTTLSubShapeIdFind_element_user = get_store().find_element_user(SUBSP$2, 0);
                if (cTTLSubShapeIdFind_element_user == null) {
                    return null;
                }
                return cTTLSubShapeIdFind_element_user;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public CTTLTextTargetElement getTxEl() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTLTextTargetElement cTTLTextTargetElementFind_element_user = get_store().find_element_user(TXEL$6, 0);
                if (cTTLTextTargetElementFind_element_user == null) {
                    return null;
                }
                return cTTLTextTargetElementFind_element_user;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public boolean isSetBg() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BG$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public boolean isSetGraphicEl() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(GRAPHICEL$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public boolean isSetOleChartEl() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(OLECHARTEL$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public boolean isSetSubSp() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SUBSP$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public boolean isSetTxEl() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TXEL$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public void setBg(CTEmpty cTEmpty) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = BG$0;
                CTEmpty cTEmptyFind_element_user = typeStore.find_element_user(qName, 0);
                if (cTEmptyFind_element_user == null) {
                    cTEmptyFind_element_user = (CTEmpty) get_store().add_element_user(qName);
                }
                cTEmptyFind_element_user.set(cTEmpty);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public void setGraphicEl(CTAnimationElementChoice cTAnimationElementChoice) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = GRAPHICEL$8;
                CTAnimationElementChoice cTAnimationElementChoiceFind_element_user = typeStore.find_element_user(qName, 0);
                if (cTAnimationElementChoiceFind_element_user == null) {
                    cTAnimationElementChoiceFind_element_user = (CTAnimationElementChoice) get_store().add_element_user(qName);
                }
                cTAnimationElementChoiceFind_element_user.set(cTAnimationElementChoice);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public void setOleChartEl(CTTLOleChartTargetElement cTTLOleChartTargetElement) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = OLECHARTEL$4;
                CTTLOleChartTargetElement cTTLOleChartTargetElementFind_element_user = typeStore.find_element_user(qName, 0);
                if (cTTLOleChartTargetElementFind_element_user == null) {
                    cTTLOleChartTargetElementFind_element_user = (CTTLOleChartTargetElement) get_store().add_element_user(qName);
                }
                cTTLOleChartTargetElementFind_element_user.set(cTTLOleChartTargetElement);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public void setSpid(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SPID$10;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public void setSubSp(CTTLSubShapeId cTTLSubShapeId) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SUBSP$2;
                CTTLSubShapeId cTTLSubShapeIdFind_element_user = typeStore.find_element_user(qName, 0);
                if (cTTLSubShapeIdFind_element_user == null) {
                    cTTLSubShapeIdFind_element_user = (CTTLSubShapeId) get_store().add_element_user(qName);
                }
                cTTLSubShapeIdFind_element_user.set(cTTLSubShapeId);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public void setTxEl(CTTLTextTargetElement cTTLTextTargetElement) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = TXEL$6;
                CTTLTextTargetElement cTTLTextTargetElementFind_element_user = typeStore.find_element_user(qName, 0);
                if (cTTLTextTargetElementFind_element_user == null) {
                    cTTLTextTargetElementFind_element_user = (CTTLTextTargetElement) get_store().add_element_user(qName);
                }
                cTTLTextTargetElementFind_element_user.set(cTTLTextTargetElement);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public void unsetBg() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BG$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public void unsetGraphicEl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GRAPHICEL$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public void unsetOleChartEl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(OLECHARTEL$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public void unsetSubSp() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SUBSP$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public void unsetTxEl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TXEL$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public STShapeID xgetSpid() {
        STShapeID sTShapeIDFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTShapeIDFind_attribute_user = get_store().find_attribute_user(SPID$10);
        }
        return sTShapeIDFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement
    public void xsetSpid(STShapeID sTShapeID) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SPID$10;
                STShapeID sTShapeIDFind_attribute_user = typeStore.find_attribute_user(qName);
                if (sTShapeIDFind_attribute_user == null) {
                    sTShapeIDFind_attribute_user = (STShapeID) get_store().add_attribute_user(qName);
                }
                sTShapeIDFind_attribute_user.set(sTShapeID);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
