package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShapeNonVisual;

/* JADX INFO: loaded from: classes11.dex */
public class CTShapeImpl extends XmlComplexContentImpl implements CTShape {
    private static final QName NVSPPR$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "nvSpPr");
    private static final QName SPPR$2 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "spPr");
    private static final QName STYLE$4 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "style");
    private static final QName TXBODY$6 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "txBody");
    private static final QName EXTLST$8 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst");
    private static final QName USEBGFILL$10 = new QName("", "useBgFill");

    public CTShapeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTShape
    public CTExtensionListModify addNewExtLst() {
        CTExtensionListModify cTExtensionListModify;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListModify = (CTExtensionListModify) get_store().add_element_user(EXTLST$8);
        }
        return cTExtensionListModify;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTShape
    public CTShapeNonVisual addNewNvSpPr() {
        CTShapeNonVisual cTShapeNonVisual;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeNonVisual = (CTShapeNonVisual) get_store().add_element_user(NVSPPR$0);
        }
        return cTShapeNonVisual;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTShape
    public CTShapeProperties addNewSpPr() {
        CTShapeProperties cTShapeProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeProperties = (CTShapeProperties) get_store().add_element_user(SPPR$2);
        }
        return cTShapeProperties;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTShape
    public CTShapeStyle addNewStyle() {
        CTShapeStyle cTShapeStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTShapeStyle = (CTShapeStyle) get_store().add_element_user(STYLE$4);
        }
        return cTShapeStyle;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTShape
    public CTTextBody addNewTxBody() {
        CTTextBody cTTextBody;
        synchronized (monitor()) {
            check_orphaned();
            cTTextBody = (CTTextBody) get_store().add_element_user(TXBODY$6);
        }
        return cTTextBody;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTShape
    public CTExtensionListModify getExtLst() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTExtensionListModify cTExtensionListModify = (CTExtensionListModify) get_store().find_element_user(EXTLST$8, 0);
                if (cTExtensionListModify == null) {
                    return null;
                }
                return cTExtensionListModify;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTShape
    public CTShapeNonVisual getNvSpPr() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTShapeNonVisual cTShapeNonVisual = (CTShapeNonVisual) get_store().find_element_user(NVSPPR$0, 0);
                if (cTShapeNonVisual == null) {
                    return null;
                }
                return cTShapeNonVisual;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTShape
    public CTShapeProperties getSpPr() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTShapeProperties cTShapeProperties = (CTShapeProperties) get_store().find_element_user(SPPR$2, 0);
                if (cTShapeProperties == null) {
                    return null;
                }
                return cTShapeProperties;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTShape
    public CTShapeStyle getStyle() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTShapeStyle cTShapeStyle = (CTShapeStyle) get_store().find_element_user(STYLE$4, 0);
                if (cTShapeStyle == null) {
                    return null;
                }
                return cTShapeStyle;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTShape
    public CTTextBody getTxBody() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTextBody cTTextBody = (CTTextBody) get_store().find_element_user(TXBODY$6, 0);
                if (cTTextBody == null) {
                    return null;
                }
                return cTTextBody;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTShape
    public boolean getUseBgFill() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = USEBGFILL$10;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTShape
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTShape
    public boolean isSetStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(STYLE$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTShape
    public boolean isSetTxBody() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TXBODY$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTShape
    public boolean isSetUseBgFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(USEBGFILL$10) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTShape
    public void setExtLst(CTExtensionListModify cTExtensionListModify) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = EXTLST$8;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTShape
    public void setNvSpPr(CTShapeNonVisual cTShapeNonVisual) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = NVSPPR$0;
                CTShapeNonVisual cTShapeNonVisual2 = (CTShapeNonVisual) typeStore.find_element_user(qName, 0);
                if (cTShapeNonVisual2 == null) {
                    cTShapeNonVisual2 = (CTShapeNonVisual) get_store().add_element_user(qName);
                }
                cTShapeNonVisual2.set(cTShapeNonVisual);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTShape
    public void setSpPr(CTShapeProperties cTShapeProperties) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SPPR$2;
                CTShapeProperties cTShapeProperties2 = (CTShapeProperties) typeStore.find_element_user(qName, 0);
                if (cTShapeProperties2 == null) {
                    cTShapeProperties2 = (CTShapeProperties) get_store().add_element_user(qName);
                }
                cTShapeProperties2.set(cTShapeProperties);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTShape
    public void setStyle(CTShapeStyle cTShapeStyle) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = STYLE$4;
                CTShapeStyle cTShapeStyle2 = (CTShapeStyle) typeStore.find_element_user(qName, 0);
                if (cTShapeStyle2 == null) {
                    cTShapeStyle2 = (CTShapeStyle) get_store().add_element_user(qName);
                }
                cTShapeStyle2.set(cTShapeStyle);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTShape
    public void setTxBody(CTTextBody cTTextBody) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = TXBODY$6;
                CTTextBody cTTextBody2 = (CTTextBody) typeStore.find_element_user(qName, 0);
                if (cTTextBody2 == null) {
                    cTTextBody2 = (CTTextBody) get_store().add_element_user(qName);
                }
                cTTextBody2.set(cTTextBody);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTShape
    public void setUseBgFill(boolean z) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = USEBGFILL$10;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTShape
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTShape
    public void unsetStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STYLE$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTShape
    public void unsetTxBody() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TXBODY$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTShape
    public void unsetUseBgFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(USEBGFILL$10);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTShape
    public XmlBoolean xgetUseBgFill() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = USEBGFILL$10;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTShape
    public void xsetUseBgFill(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = USEBGFILL$10;
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
