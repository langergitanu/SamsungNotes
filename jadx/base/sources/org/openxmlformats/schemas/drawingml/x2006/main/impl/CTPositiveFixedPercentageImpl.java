package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveFixedPercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.STPositiveFixedPercentage;

/* JADX INFO: loaded from: classes11.dex */
public class CTPositiveFixedPercentageImpl extends XmlComplexContentImpl implements CTPositiveFixedPercentage {
    private static final QName VAL$0 = new QName("", VElementFormulasCmd.FVAL);

    public CTPositiveFixedPercentageImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveFixedPercentage
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveFixedPercentage
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveFixedPercentage
    public STPositiveFixedPercentage xgetVal() {
        STPositiveFixedPercentage sTPositiveFixedPercentage;
        synchronized (monitor()) {
            check_orphaned();
            sTPositiveFixedPercentage = (STPositiveFixedPercentage) get_store().find_attribute_user(VAL$0);
        }
        return sTPositiveFixedPercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveFixedPercentage
    public void xsetVal(STPositiveFixedPercentage sTPositiveFixedPercentage) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = VAL$0;
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
}
