package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc$Enum;

/* JADX INFO: loaded from: classes11.dex */
public class CTJcImpl extends XmlComplexContentImpl implements CTJc {
    private static final QName VAL$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", VElementFormulasCmd.FVAL);

    public CTJcImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc
    public STJc$Enum getVal() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(VAL$0);
                if (simpleValue == null) {
                    return null;
                }
                return (STJc$Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc
    public void setVal(STJc$Enum sTJc$Enum) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = VAL$0;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setEnumValue(sTJc$Enum);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc
    public STJc xgetVal() {
        STJc sTJcFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTJcFind_attribute_user = get_store().find_attribute_user(VAL$0);
        }
        return sTJcFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc
    public void xsetVal(STJc sTJc) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = VAL$0;
                STJc sTJcFind_attribute_user = typeStore.find_attribute_user(qName);
                if (sTJcFind_attribute_user == null) {
                    sTJcFind_attribute_user = (STJc) get_store().add_attribute_user(qName);
                }
                sTJcFind_attribute_user.set(sTJc);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
