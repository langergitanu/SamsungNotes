package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify;
import org.openxmlformats.schemas.presentationml.x2006.main.CTHeaderFooter;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTiming;
import org.openxmlformats.schemas.presentationml.x2006.main.CTSlideTransition;
import org.openxmlformats.schemas.presentationml.x2006.main.STSlideLayoutType;

/* JADX INFO: loaded from: classes11.dex */
public class CTSlideLayoutImpl extends XmlComplexContentImpl implements CTSlideLayout {
    private static final QName CSLD$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "cSld");
    private static final QName CLRMAPOVR$2 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "clrMapOvr");
    private static final QName TRANSITION$4 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "transition");
    private static final QName TIMING$6 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "timing");
    private static final QName HF$8 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", VPathDataCmd.SmoothCurve);
    private static final QName EXTLST$10 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst");
    private static final QName SHOWMASTERSP$12 = new QName("", "showMasterSp");
    private static final QName SHOWMASTERPHANIM$14 = new QName("", "showMasterPhAnim");
    private static final QName MATCHINGNAME$16 = new QName("", "matchingName");
    private static final QName TYPE$18 = new QName("", "type");
    private static final QName PRESERVE$20 = new QName("", "preserve");
    private static final QName USERDRAWN$22 = new QName("", "userDrawn");

    public CTSlideLayoutImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public CTCommonSlideData addNewCSld() {
        CTCommonSlideData cTCommonSlideData;
        synchronized (monitor()) {
            check_orphaned();
            cTCommonSlideData = (CTCommonSlideData) get_store().add_element_user(CSLD$0);
        }
        return cTCommonSlideData;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public CTColorMappingOverride addNewClrMapOvr() {
        CTColorMappingOverride cTColorMappingOverride;
        synchronized (monitor()) {
            check_orphaned();
            cTColorMappingOverride = (CTColorMappingOverride) get_store().add_element_user(CLRMAPOVR$2);
        }
        return cTColorMappingOverride;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public CTExtensionListModify addNewExtLst() {
        CTExtensionListModify cTExtensionListModify;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListModify = (CTExtensionListModify) get_store().add_element_user(EXTLST$10);
        }
        return cTExtensionListModify;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public CTHeaderFooter addNewHf() {
        CTHeaderFooter cTHeaderFooterAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTHeaderFooterAdd_element_user = get_store().add_element_user(HF$8);
        }
        return cTHeaderFooterAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public CTSlideTiming addNewTiming() {
        CTSlideTiming cTSlideTiming;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideTiming = (CTSlideTiming) get_store().add_element_user(TIMING$6);
        }
        return cTSlideTiming;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public CTSlideTransition addNewTransition() {
        CTSlideTransition cTSlideTransitionAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTSlideTransitionAdd_element_user = get_store().add_element_user(TRANSITION$4);
        }
        return cTSlideTransitionAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public CTCommonSlideData getCSld() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTCommonSlideData cTCommonSlideData = (CTCommonSlideData) get_store().find_element_user(CSLD$0, 0);
                if (cTCommonSlideData == null) {
                    return null;
                }
                return cTCommonSlideData;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public CTColorMappingOverride getClrMapOvr() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTColorMappingOverride cTColorMappingOverride = (CTColorMappingOverride) get_store().find_element_user(CLRMAPOVR$2, 0);
                if (cTColorMappingOverride == null) {
                    return null;
                }
                return cTColorMappingOverride;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public CTExtensionListModify getExtLst() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTExtensionListModify cTExtensionListModify = (CTExtensionListModify) get_store().find_element_user(EXTLST$10, 0);
                if (cTExtensionListModify == null) {
                    return null;
                }
                return cTExtensionListModify;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public CTHeaderFooter getHf() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTHeaderFooter cTHeaderFooterFind_element_user = get_store().find_element_user(HF$8, 0);
                if (cTHeaderFooterFind_element_user == null) {
                    return null;
                }
                return cTHeaderFooterFind_element_user;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public String getMatchingName() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MATCHINGNAME$16;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qName);
                }
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public boolean getPreserve() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = PRESERVE$20;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public boolean getShowMasterPhAnim() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SHOWMASTERPHANIM$14;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public boolean getShowMasterSp() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SHOWMASTERSP$12;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public CTSlideTiming getTiming() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTSlideTiming cTSlideTiming = (CTSlideTiming) get_store().find_element_user(TIMING$6, 0);
                if (cTSlideTiming == null) {
                    return null;
                }
                return cTSlideTiming;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public CTSlideTransition getTransition() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTSlideTransition cTSlideTransitionFind_element_user = get_store().find_element_user(TRANSITION$4, 0);
                if (cTSlideTransitionFind_element_user == null) {
                    return null;
                }
                return cTSlideTransitionFind_element_user;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public STSlideLayoutType.Enum getType() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = TYPE$18;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qName);
                }
                if (simpleValue == null) {
                    return null;
                }
                return (STSlideLayoutType.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public boolean getUserDrawn() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = USERDRAWN$22;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public boolean isSetClrMapOvr() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CLRMAPOVR$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public boolean isSetHf() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(HF$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public boolean isSetMatchingName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MATCHINGNAME$16) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public boolean isSetPreserve() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PRESERVE$20) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public boolean isSetShowMasterPhAnim() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SHOWMASTERPHANIM$14) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public boolean isSetShowMasterSp() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SHOWMASTERSP$12) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public boolean isSetTiming() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TIMING$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public boolean isSetTransition() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TRANSITION$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public boolean isSetType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TYPE$18) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public boolean isSetUserDrawn() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(USERDRAWN$22) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void setCSld(CTCommonSlideData cTCommonSlideData) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = CSLD$0;
                CTCommonSlideData cTCommonSlideData2 = (CTCommonSlideData) typeStore.find_element_user(qName, 0);
                if (cTCommonSlideData2 == null) {
                    cTCommonSlideData2 = (CTCommonSlideData) get_store().add_element_user(qName);
                }
                cTCommonSlideData2.set(cTCommonSlideData);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void setClrMapOvr(CTColorMappingOverride cTColorMappingOverride) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = CLRMAPOVR$2;
                CTColorMappingOverride cTColorMappingOverride2 = (CTColorMappingOverride) typeStore.find_element_user(qName, 0);
                if (cTColorMappingOverride2 == null) {
                    cTColorMappingOverride2 = (CTColorMappingOverride) get_store().add_element_user(qName);
                }
                cTColorMappingOverride2.set(cTColorMappingOverride);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void setExtLst(CTExtensionListModify cTExtensionListModify) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = EXTLST$10;
                CTExtensionListModify cTExtensionListModify2 = (CTExtensionListModify) typeStore.find_element_user(qName, 0);
                if (cTExtensionListModify2 == null) {
                    cTExtensionListModify2 = (CTExtensionListModify) get_store().add_element_user(qName);
                }
                cTExtensionListModify2.set(cTExtensionListModify);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void setHf(CTHeaderFooter cTHeaderFooter) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = HF$8;
                CTHeaderFooter cTHeaderFooterFind_element_user = typeStore.find_element_user(qName, 0);
                if (cTHeaderFooterFind_element_user == null) {
                    cTHeaderFooterFind_element_user = (CTHeaderFooter) get_store().add_element_user(qName);
                }
                cTHeaderFooterFind_element_user.set(cTHeaderFooter);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void setMatchingName(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MATCHINGNAME$16;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void setPreserve(boolean z) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = PRESERVE$20;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void setShowMasterPhAnim(boolean z) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SHOWMASTERPHANIM$14;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void setShowMasterSp(boolean z) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SHOWMASTERSP$12;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void setTiming(CTSlideTiming cTSlideTiming) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = TIMING$6;
                CTSlideTiming cTSlideTiming2 = (CTSlideTiming) typeStore.find_element_user(qName, 0);
                if (cTSlideTiming2 == null) {
                    cTSlideTiming2 = (CTSlideTiming) get_store().add_element_user(qName);
                }
                cTSlideTiming2.set(cTSlideTiming);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void setTransition(CTSlideTransition cTSlideTransition) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = TRANSITION$4;
                CTSlideTransition cTSlideTransitionFind_element_user = typeStore.find_element_user(qName, 0);
                if (cTSlideTransitionFind_element_user == null) {
                    cTSlideTransitionFind_element_user = (CTSlideTransition) get_store().add_element_user(qName);
                }
                cTSlideTransitionFind_element_user.set(cTSlideTransition);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void setType(STSlideLayoutType.Enum r4) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = TYPE$18;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void setUserDrawn(boolean z) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = USERDRAWN$22;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void unsetClrMapOvr() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CLRMAPOVR$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void unsetHf() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(HF$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void unsetMatchingName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MATCHINGNAME$16);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void unsetPreserve() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PRESERVE$20);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void unsetShowMasterPhAnim() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SHOWMASTERPHANIM$14);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void unsetShowMasterSp() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SHOWMASTERSP$12);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void unsetTiming() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TIMING$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void unsetTransition() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TRANSITION$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void unsetType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TYPE$18);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void unsetUserDrawn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(USERDRAWN$22);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public XmlString xgetMatchingName() {
        XmlString xmlString;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MATCHINGNAME$16;
                xmlString = (XmlString) typeStore.find_attribute_user(qName);
                if (xmlString == null) {
                    xmlString = (XmlString) get_default_attribute_value(qName);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlString;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public XmlBoolean xgetPreserve() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = PRESERVE$20;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public XmlBoolean xgetShowMasterPhAnim() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SHOWMASTERPHANIM$14;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public XmlBoolean xgetShowMasterSp() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SHOWMASTERSP$12;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public STSlideLayoutType xgetType() {
        STSlideLayoutType sTSlideLayoutType;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = TYPE$18;
                sTSlideLayoutType = (STSlideLayoutType) typeStore.find_attribute_user(qName);
                if (sTSlideLayoutType == null) {
                    sTSlideLayoutType = (STSlideLayoutType) get_default_attribute_value(qName);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTSlideLayoutType;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public XmlBoolean xgetUserDrawn() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = USERDRAWN$22;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void xsetMatchingName(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MATCHINGNAME$16;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void xsetPreserve(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = PRESERVE$20;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void xsetShowMasterPhAnim(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SHOWMASTERPHANIM$14;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void xsetShowMasterSp(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SHOWMASTERSP$12;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void xsetType(STSlideLayoutType sTSlideLayoutType) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = TYPE$18;
                STSlideLayoutType sTSlideLayoutType2 = (STSlideLayoutType) typeStore.find_attribute_user(qName);
                if (sTSlideLayoutType2 == null) {
                    sTSlideLayoutType2 = (STSlideLayoutType) get_store().add_attribute_user(qName);
                }
                sTSlideLayoutType2.set(sTSlideLayoutType);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTSlideLayout
    public void xsetUserDrawn(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = USERDRAWN$22;
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
