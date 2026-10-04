package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalJc;

/* JADX INFO: loaded from: classes11.dex */
public class CTVerticalJcImpl extends XmlComplexContentImpl implements CTVerticalJc {
    private static final QName VAL$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", VElementFormulasCmd.FVAL);

    public CTVerticalJcImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalJc
    public STVerticalJc.Enum getVal() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(VAL$0);
                if (simpleValue == null) {
                    return null;
                }
                return (STVerticalJc.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalJc
    public void setVal(STVerticalJc.Enum r4) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalJc
    public STVerticalJc xgetVal() {
        STVerticalJc sTVerticalJc;
        synchronized (monitor()) {
            check_orphaned();
            sTVerticalJc = (STVerticalJc) get_store().find_attribute_user(VAL$0);
        }
        return sTVerticalJc;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalJc
    public void xsetVal(STVerticalJc sTVerticalJc) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = VAL$0;
                STVerticalJc sTVerticalJc2 = (STVerticalJc) typeStore.find_attribute_user(qName);
                if (sTVerticalJc2 == null) {
                    sTVerticalJc2 = (STVerticalJc) get_store().add_attribute_user(qName);
                }
                sTVerticalJc2.set(sTVerticalJc);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
