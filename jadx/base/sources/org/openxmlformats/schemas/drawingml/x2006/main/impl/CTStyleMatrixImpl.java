package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBackgroundFillStyleList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFillStyleList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineStyleList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrix;

/* JADX INFO: loaded from: classes11.dex */
public class CTStyleMatrixImpl extends XmlComplexContentImpl implements CTStyleMatrix {
    private static final QName FILLSTYLELST$0 = new QName(XSSFRelation.NS_DRAWINGML, "fillStyleLst");
    private static final QName LNSTYLELST$2 = new QName(XSSFRelation.NS_DRAWINGML, "lnStyleLst");
    private static final QName EFFECTSTYLELST$4 = new QName(XSSFRelation.NS_DRAWINGML, "effectStyleLst");
    private static final QName BGFILLSTYLELST$6 = new QName(XSSFRelation.NS_DRAWINGML, "bgFillStyleLst");
    private static final QName NAME$8 = new QName("", "name");

    public CTStyleMatrixImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrix
    public CTBackgroundFillStyleList addNewBgFillStyleLst() {
        CTBackgroundFillStyleList cTBackgroundFillStyleList;
        synchronized (monitor()) {
            check_orphaned();
            cTBackgroundFillStyleList = (CTBackgroundFillStyleList) get_store().add_element_user(BGFILLSTYLELST$6);
        }
        return cTBackgroundFillStyleList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrix
    public CTEffectStyleList addNewEffectStyleLst() {
        CTEffectStyleList cTEffectStyleListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEffectStyleListAdd_element_user = get_store().add_element_user(EFFECTSTYLELST$4);
        }
        return cTEffectStyleListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrix
    public CTFillStyleList addNewFillStyleLst() {
        CTFillStyleList cTFillStyleList;
        synchronized (monitor()) {
            check_orphaned();
            cTFillStyleList = (CTFillStyleList) get_store().add_element_user(FILLSTYLELST$0);
        }
        return cTFillStyleList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrix
    public CTLineStyleList addNewLnStyleLst() {
        CTLineStyleList cTLineStyleList;
        synchronized (monitor()) {
            check_orphaned();
            cTLineStyleList = (CTLineStyleList) get_store().add_element_user(LNSTYLELST$2);
        }
        return cTLineStyleList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrix
    public CTBackgroundFillStyleList getBgFillStyleLst() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTBackgroundFillStyleList cTBackgroundFillStyleList = (CTBackgroundFillStyleList) get_store().find_element_user(BGFILLSTYLELST$6, 0);
                if (cTBackgroundFillStyleList == null) {
                    return null;
                }
                return cTBackgroundFillStyleList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrix
    public CTEffectStyleList getEffectStyleLst() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTEffectStyleList cTEffectStyleListFind_element_user = get_store().find_element_user(EFFECTSTYLELST$4, 0);
                if (cTEffectStyleListFind_element_user == null) {
                    return null;
                }
                return cTEffectStyleListFind_element_user;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrix
    public CTFillStyleList getFillStyleLst() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTFillStyleList cTFillStyleList = (CTFillStyleList) get_store().find_element_user(FILLSTYLELST$0, 0);
                if (cTFillStyleList == null) {
                    return null;
                }
                return cTFillStyleList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrix
    public CTLineStyleList getLnStyleLst() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTLineStyleList cTLineStyleList = (CTLineStyleList) get_store().find_element_user(LNSTYLELST$2, 0);
                if (cTLineStyleList == null) {
                    return null;
                }
                return cTLineStyleList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrix
    public String getName() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = NAME$8;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrix
    public boolean isSetName() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(NAME$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrix
    public void setBgFillStyleLst(CTBackgroundFillStyleList cTBackgroundFillStyleList) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = BGFILLSTYLELST$6;
                CTBackgroundFillStyleList cTBackgroundFillStyleList2 = (CTBackgroundFillStyleList) typeStore.find_element_user(qName, 0);
                if (cTBackgroundFillStyleList2 == null) {
                    cTBackgroundFillStyleList2 = (CTBackgroundFillStyleList) get_store().add_element_user(qName);
                }
                cTBackgroundFillStyleList2.set(cTBackgroundFillStyleList);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrix
    public void setEffectStyleLst(CTEffectStyleList cTEffectStyleList) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = EFFECTSTYLELST$4;
                CTEffectStyleList cTEffectStyleListFind_element_user = typeStore.find_element_user(qName, 0);
                if (cTEffectStyleListFind_element_user == null) {
                    cTEffectStyleListFind_element_user = (CTEffectStyleList) get_store().add_element_user(qName);
                }
                cTEffectStyleListFind_element_user.set(cTEffectStyleList);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrix
    public void setFillStyleLst(CTFillStyleList cTFillStyleList) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = FILLSTYLELST$0;
                CTFillStyleList cTFillStyleList2 = (CTFillStyleList) typeStore.find_element_user(qName, 0);
                if (cTFillStyleList2 == null) {
                    cTFillStyleList2 = (CTFillStyleList) get_store().add_element_user(qName);
                }
                cTFillStyleList2.set(cTFillStyleList);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrix
    public void setLnStyleLst(CTLineStyleList cTLineStyleList) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = LNSTYLELST$2;
                CTLineStyleList cTLineStyleList2 = (CTLineStyleList) typeStore.find_element_user(qName, 0);
                if (cTLineStyleList2 == null) {
                    cTLineStyleList2 = (CTLineStyleList) get_store().add_element_user(qName);
                }
                cTLineStyleList2.set(cTLineStyleList);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrix
    public void setName(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = NAME$8;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrix
    public void unsetName() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(NAME$8);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrix
    public XmlString xgetName() {
        XmlString xmlString;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = NAME$8;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrix
    public void xsetName(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = NAME$8;
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
