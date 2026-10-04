package org.openxmlformats.schemas.officeDocument.x2006.math.impl;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathJc;
import org.openxmlformats.schemas.officeDocument.x2006.math.STJc;

/* JADX INFO: loaded from: classes11.dex */
public class CTOMathJcImpl extends XmlComplexContentImpl implements CTOMathJc {
    private static final QName VAL$0 = new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", VElementFormulasCmd.FVAL);

    public CTOMathJcImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathJc
    public STJc.Enum getVal() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(VAL$0);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathJc
    public boolean isSetVal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(VAL$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathJc
    public void setVal(STJc.Enum r4) {
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

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathJc
    public void unsetVal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(VAL$0);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathJc
    public STJc xgetVal() {
        STJc sTJcFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTJcFind_attribute_user = get_store().find_attribute_user(VAL$0);
        }
        return sTJcFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTOMathJc
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
