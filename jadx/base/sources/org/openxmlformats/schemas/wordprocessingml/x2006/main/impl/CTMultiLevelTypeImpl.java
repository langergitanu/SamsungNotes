package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMultiLevelType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMultiLevelType;

/* JADX INFO: loaded from: classes11.dex */
public class CTMultiLevelTypeImpl extends XmlComplexContentImpl implements CTMultiLevelType {
    private static final QName VAL$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", VElementFormulasCmd.FVAL);

    public CTMultiLevelTypeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMultiLevelType
    public STMultiLevelType.Enum getVal() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(VAL$0);
                if (simpleValue == null) {
                    return null;
                }
                return (STMultiLevelType.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMultiLevelType
    public void setVal(STMultiLevelType.Enum r4) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMultiLevelType
    public STMultiLevelType xgetVal() {
        STMultiLevelType sTMultiLevelType;
        synchronized (monitor()) {
            check_orphaned();
            sTMultiLevelType = (STMultiLevelType) get_store().find_attribute_user(VAL$0);
        }
        return sTMultiLevelType;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMultiLevelType
    public void xsetVal(STMultiLevelType sTMultiLevelType) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = VAL$0;
                STMultiLevelType sTMultiLevelType2 = (STMultiLevelType) typeStore.find_attribute_user(qName);
                if (sTMultiLevelType2 == null) {
                    sTMultiLevelType2 = (STMultiLevelType) get_store().add_attribute_user(qName);
                }
                sTMultiLevelType2.set(sTMultiLevelType);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
