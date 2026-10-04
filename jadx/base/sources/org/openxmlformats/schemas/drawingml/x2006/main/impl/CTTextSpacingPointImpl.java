package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacingPoint;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextSpacingPoint;

/* JADX INFO: loaded from: classes11.dex */
public class CTTextSpacingPointImpl extends XmlComplexContentImpl implements CTTextSpacingPoint {
    private static final QName VAL$0 = new QName("", VElementFormulasCmd.FVAL);

    public CTTextSpacingPointImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacingPoint
    public int getVal() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(VAL$0);
                if (simpleValue == null) {
                    return 0;
                }
                return simpleValue.getIntValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacingPoint
    public void setVal(int i) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = VAL$0;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacingPoint
    public STTextSpacingPoint xgetVal() {
        STTextSpacingPoint sTTextSpacingPoint;
        synchronized (monitor()) {
            check_orphaned();
            sTTextSpacingPoint = (STTextSpacingPoint) get_store().find_attribute_user(VAL$0);
        }
        return sTTextSpacingPoint;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextSpacingPoint
    public void xsetVal(STTextSpacingPoint sTTextSpacingPoint) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = VAL$0;
                STTextSpacingPoint sTTextSpacingPoint2 = (STTextSpacingPoint) typeStore.find_attribute_user(qName);
                if (sTTextSpacingPoint2 == null) {
                    sTTextSpacingPoint2 = (STTextSpacingPoint) get_store().add_attribute_user(qName);
                }
                sTTextSpacingPoint2.set(sTTextSpacingPoint);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
