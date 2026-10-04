package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPathShadeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect;
import org.openxmlformats.schemas.drawingml.x2006.main.STPathShadeType;

/* JADX INFO: loaded from: classes11.dex */
public class CTPathShadePropertiesImpl extends XmlComplexContentImpl implements CTPathShadeProperties {
    private static final QName FILLTORECT$0 = new QName(XSSFRelation.NS_DRAWINGML, "fillToRect");
    private static final QName PATH$2 = new QName("", "path");

    public CTPathShadePropertiesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPathShadeProperties
    public CTRelativeRect addNewFillToRect() {
        CTRelativeRect cTRelativeRect;
        synchronized (monitor()) {
            check_orphaned();
            cTRelativeRect = (CTRelativeRect) get_store().add_element_user(FILLTORECT$0);
        }
        return cTRelativeRect;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPathShadeProperties
    public CTRelativeRect getFillToRect() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTRelativeRect cTRelativeRect = (CTRelativeRect) get_store().find_element_user(FILLTORECT$0, 0);
                if (cTRelativeRect == null) {
                    return null;
                }
                return cTRelativeRect;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPathShadeProperties
    public STPathShadeType.Enum getPath() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PATH$2);
                if (simpleValue == null) {
                    return null;
                }
                return (STPathShadeType.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPathShadeProperties
    public boolean isSetFillToRect() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(FILLTORECT$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPathShadeProperties
    public boolean isSetPath() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(PATH$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPathShadeProperties
    public void setFillToRect(CTRelativeRect cTRelativeRect) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = FILLTORECT$0;
                CTRelativeRect cTRelativeRect2 = (CTRelativeRect) typeStore.find_element_user(qName, 0);
                if (cTRelativeRect2 == null) {
                    cTRelativeRect2 = (CTRelativeRect) get_store().add_element_user(qName);
                }
                cTRelativeRect2.set(cTRelativeRect);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPathShadeProperties
    public void setPath(STPathShadeType.Enum r4) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = PATH$2;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPathShadeProperties
    public void unsetFillToRect() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(FILLTORECT$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPathShadeProperties
    public void unsetPath() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PATH$2);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPathShadeProperties
    public STPathShadeType xgetPath() {
        STPathShadeType sTPathShadeType;
        synchronized (monitor()) {
            check_orphaned();
            sTPathShadeType = (STPathShadeType) get_store().find_attribute_user(PATH$2);
        }
        return sTPathShadeType;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPathShadeProperties
    public void xsetPath(STPathShadeType sTPathShadeType) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = PATH$2;
                STPathShadeType sTPathShadeType2 = (STPathShadeType) typeStore.find_attribute_user(qName);
                if (sTPathShadeType2 == null) {
                    sTPathShadeType2 = (STPathShadeType) get_store().add_attribute_user(qName);
                }
                sTPathShadeType2.set(sTPathShadeType);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
