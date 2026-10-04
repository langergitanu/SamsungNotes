package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextAlignment;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTextAlignment;

/* JADX INFO: loaded from: classes11.dex */
public class CTTextAlignmentImpl extends XmlComplexContentImpl implements CTTextAlignment {
    private static final QName VAL$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", VElementFormulasCmd.FVAL);

    public CTTextAlignmentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextAlignment
    public STTextAlignment.Enum getVal() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(VAL$0);
                if (simpleValue == null) {
                    return null;
                }
                return (STTextAlignment.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextAlignment
    public void setVal(STTextAlignment.Enum r4) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextAlignment
    public STTextAlignment xgetVal() {
        STTextAlignment sTTextAlignment;
        synchronized (monitor()) {
            check_orphaned();
            sTTextAlignment = (STTextAlignment) get_store().find_attribute_user(VAL$0);
        }
        return sTTextAlignment;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTextAlignment
    public void xsetVal(STTextAlignment sTTextAlignment) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = VAL$0;
                STTextAlignment sTTextAlignment2 = (STTextAlignment) typeStore.find_attribute_user(qName);
                if (sTTextAlignment2 == null) {
                    sTTextAlignment2 = (STTextAlignment) get_store().add_attribute_user(qName);
                }
                sTTextAlignment2.set(sTTextAlignment);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
