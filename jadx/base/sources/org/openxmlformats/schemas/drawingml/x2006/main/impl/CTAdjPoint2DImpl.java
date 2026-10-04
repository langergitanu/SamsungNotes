package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAdjPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.STAdjCoordinate;

/* JADX INFO: loaded from: classes11.dex */
public class CTAdjPoint2DImpl extends XmlComplexContentImpl implements CTAdjPoint2D {
    private static final QName X$0 = new QName("", "x");
    private static final QName Y$2 = new QName("", "y");

    public CTAdjPoint2DImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjPoint2D
    public Object getX() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(X$0);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getObjectValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjPoint2D
    public Object getY() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(Y$2);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getObjectValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjPoint2D
    public void setX(Object obj) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = X$0;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjPoint2D
    public void setY(Object obj) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = Y$2;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjPoint2D
    public STAdjCoordinate xgetX() {
        STAdjCoordinate sTAdjCoordinate;
        synchronized (monitor()) {
            check_orphaned();
            sTAdjCoordinate = (STAdjCoordinate) get_store().find_attribute_user(X$0);
        }
        return sTAdjCoordinate;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjPoint2D
    public STAdjCoordinate xgetY() {
        STAdjCoordinate sTAdjCoordinate;
        synchronized (monitor()) {
            check_orphaned();
            sTAdjCoordinate = (STAdjCoordinate) get_store().find_attribute_user(Y$2);
        }
        return sTAdjCoordinate;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjPoint2D
    public void xsetX(STAdjCoordinate sTAdjCoordinate) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = X$0;
                STAdjCoordinate sTAdjCoordinate2 = (STAdjCoordinate) typeStore.find_attribute_user(qName);
                if (sTAdjCoordinate2 == null) {
                    sTAdjCoordinate2 = (STAdjCoordinate) get_store().add_attribute_user(qName);
                }
                sTAdjCoordinate2.set(sTAdjCoordinate);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTAdjPoint2D
    public void xsetY(STAdjCoordinate sTAdjCoordinate) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = Y$2;
                STAdjCoordinate sTAdjCoordinate2 = (STAdjCoordinate) typeStore.find_attribute_user(qName);
                if (sTAdjCoordinate2 == null) {
                    sTAdjCoordinate2 = (STAdjCoordinate) get_store().add_attribute_user(qName);
                }
                sTAdjCoordinate2.set(sTAdjCoordinate);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
