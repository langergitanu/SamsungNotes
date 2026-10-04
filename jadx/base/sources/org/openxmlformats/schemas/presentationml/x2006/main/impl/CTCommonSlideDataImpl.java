package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTBackground;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData;
import org.openxmlformats.schemas.presentationml.x2006.main.CTControlList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCustomerDataList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;

/* JADX INFO: loaded from: classes11.dex */
public class CTCommonSlideDataImpl extends XmlComplexContentImpl implements CTCommonSlideData {
    private static final QName BG$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", MarketingConstants.PopupConst.COLOR_BACKGROUND);
    private static final QName SPTREE$2 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "spTree");
    private static final QName CUSTDATALST$4 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "custDataLst");
    private static final QName CONTROLS$6 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "controls");
    private static final QName EXTLST$8 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst");
    private static final QName NAME$10 = new QName("", "name");

    public CTCommonSlideDataImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public CTBackground addNewBg() {
        CTBackground cTBackgroundAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTBackgroundAdd_element_user = get_store().add_element_user(BG$0);
        }
        return cTBackgroundAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public CTControlList addNewControls() {
        CTControlList cTControlListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTControlListAdd_element_user = get_store().add_element_user(CONTROLS$6);
        }
        return cTControlListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public CTCustomerDataList addNewCustDataLst() {
        CTCustomerDataList cTCustomerDataListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTCustomerDataListAdd_element_user = get_store().add_element_user(CUSTDATALST$4);
        }
        return cTCustomerDataListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public CTExtensionList addNewExtLst() {
        CTExtensionList cTExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionList = (CTExtensionList) get_store().add_element_user(EXTLST$8);
        }
        return cTExtensionList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public CTGroupShape addNewSpTree() {
        CTGroupShape cTGroupShape;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupShape = (CTGroupShape) get_store().add_element_user(SPTREE$2);
        }
        return cTGroupShape;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public CTBackground getBg() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTBackground cTBackgroundFind_element_user = get_store().find_element_user(BG$0, 0);
                if (cTBackgroundFind_element_user == null) {
                    return null;
                }
                return cTBackgroundFind_element_user;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public CTControlList getControls() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTControlList cTControlListFind_element_user = get_store().find_element_user(CONTROLS$6, 0);
                if (cTControlListFind_element_user == null) {
                    return null;
                }
                return cTControlListFind_element_user;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public CTCustomerDataList getCustDataLst() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTCustomerDataList cTCustomerDataListFind_element_user = get_store().find_element_user(CUSTDATALST$4, 0);
                if (cTCustomerDataListFind_element_user == null) {
                    return null;
                }
                return cTCustomerDataListFind_element_user;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public CTExtensionList getExtLst() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTExtensionList cTExtensionList = (CTExtensionList) get_store().find_element_user(EXTLST$8, 0);
                if (cTExtensionList == null) {
                    return null;
                }
                return cTExtensionList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public String getName() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = NAME$10;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public CTGroupShape getSpTree() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTGroupShape cTGroupShape = (CTGroupShape) get_store().find_element_user(SPTREE$2, 0);
                if (cTGroupShape == null) {
                    return null;
                }
                return cTGroupShape;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public boolean isSetBg() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BG$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public boolean isSetControls() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CONTROLS$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public boolean isSetCustDataLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(CUSTDATALST$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public boolean isSetName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(NAME$10) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public void setBg(CTBackground cTBackground) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = BG$0;
                CTBackground cTBackgroundFind_element_user = typeStore.find_element_user(qName, 0);
                if (cTBackgroundFind_element_user == null) {
                    cTBackgroundFind_element_user = (CTBackground) get_store().add_element_user(qName);
                }
                cTBackgroundFind_element_user.set(cTBackground);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public void setControls(CTControlList cTControlList) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = CONTROLS$6;
                CTControlList cTControlListFind_element_user = typeStore.find_element_user(qName, 0);
                if (cTControlListFind_element_user == null) {
                    cTControlListFind_element_user = (CTControlList) get_store().add_element_user(qName);
                }
                cTControlListFind_element_user.set(cTControlList);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public void setCustDataLst(CTCustomerDataList cTCustomerDataList) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = CUSTDATALST$4;
                CTCustomerDataList cTCustomerDataListFind_element_user = typeStore.find_element_user(qName, 0);
                if (cTCustomerDataListFind_element_user == null) {
                    cTCustomerDataListFind_element_user = (CTCustomerDataList) get_store().add_element_user(qName);
                }
                cTCustomerDataListFind_element_user.set(cTCustomerDataList);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public void setExtLst(CTExtensionList cTExtensionList) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = EXTLST$8;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public void setName(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = NAME$10;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public void setSpTree(CTGroupShape cTGroupShape) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SPTREE$2;
                CTGroupShape cTGroupShape2 = (CTGroupShape) typeStore.find_element_user(qName, 0);
                if (cTGroupShape2 == null) {
                    cTGroupShape2 = (CTGroupShape) get_store().add_element_user(qName);
                }
                cTGroupShape2.set(cTGroupShape);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public void unsetBg() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BG$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public void unsetControls() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CONTROLS$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public void unsetCustDataLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CUSTDATALST$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public void unsetName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(NAME$10);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public XmlString xgetName() {
        XmlString xmlString;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = NAME$10;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData
    public void xsetName(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = NAME$10;
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
