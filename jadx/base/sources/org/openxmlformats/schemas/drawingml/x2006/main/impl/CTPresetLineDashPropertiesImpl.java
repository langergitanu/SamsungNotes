package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetLineDashProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.STPresetLineDashVal;

/* JADX INFO: loaded from: classes11.dex */
public class CTPresetLineDashPropertiesImpl extends XmlComplexContentImpl implements CTPresetLineDashProperties {
    private static final QName VAL$0 = new QName("", VElementFormulasCmd.FVAL);

    public CTPresetLineDashPropertiesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetLineDashProperties
    public STPresetLineDashVal.Enum getVal() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(VAL$0);
                if (simpleValue == null) {
                    return null;
                }
                return (STPresetLineDashVal.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetLineDashProperties
    public boolean isSetVal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(VAL$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetLineDashProperties
    public void setVal(STPresetLineDashVal.Enum r4) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = VAL$0;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetLineDashProperties
    public void unsetVal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(VAL$0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetLineDashProperties
    public STPresetLineDashVal xgetVal() {
        STPresetLineDashVal sTPresetLineDashVal;
        synchronized (monitor()) {
            check_orphaned();
            sTPresetLineDashVal = (STPresetLineDashVal) get_store().find_attribute_user(VAL$0);
        }
        return sTPresetLineDashVal;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPresetLineDashProperties
    public void xsetVal(STPresetLineDashVal sTPresetLineDashVal) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = VAL$0;
                STPresetLineDashVal sTPresetLineDashVal2 = (STPresetLineDashVal) typeStore.find_attribute_user(qName);
                if (sTPresetLineDashVal2 == null) {
                    sTPresetLineDashVal2 = (STPresetLineDashVal) get_store().add_attribute_user(qName);
                }
                sTPresetLineDashVal2.set(sTPresetLineDashVal);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
