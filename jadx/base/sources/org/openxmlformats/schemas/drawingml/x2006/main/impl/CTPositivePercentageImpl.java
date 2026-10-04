package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositivePercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.STPositivePercentage;

/* JADX INFO: loaded from: classes11.dex */
public class CTPositivePercentageImpl extends XmlComplexContentImpl implements CTPositivePercentage {
    private static final QName VAL$0 = new QName("", VElementFormulasCmd.FVAL);

    public CTPositivePercentageImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPositivePercentage
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPositivePercentage
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPositivePercentage
    public STPositivePercentage xgetVal() {
        STPositivePercentage sTPositivePercentage;
        synchronized (monitor()) {
            check_orphaned();
            sTPositivePercentage = (STPositivePercentage) get_store().find_attribute_user(VAL$0);
        }
        return sTPositivePercentage;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPositivePercentage
    public void xsetVal(STPositivePercentage sTPositivePercentage) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = VAL$0;
                STPositivePercentage sTPositivePercentage2 = (STPositivePercentage) typeStore.find_attribute_user(qName);
                if (sTPositivePercentage2 == null) {
                    sTPositivePercentage2 = (STPositivePercentage) get_store().add_attribute_user(qName);
                }
                sTPositivePercentage2.set(sTPositivePercentage);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
