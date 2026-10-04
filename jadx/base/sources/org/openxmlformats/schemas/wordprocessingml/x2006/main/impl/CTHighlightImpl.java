package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHighlight;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHighlightColor;

/* JADX INFO: loaded from: classes11.dex */
public class CTHighlightImpl extends XmlComplexContentImpl implements CTHighlight {
    private static final QName VAL$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", VElementFormulasCmd.FVAL);

    public CTHighlightImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHighlight
    public STHighlightColor.Enum getVal() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(VAL$0);
                if (simpleValue == null) {
                    return null;
                }
                return (STHighlightColor.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHighlight
    public void setVal(STHighlightColor.Enum r4) {
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHighlight
    public STHighlightColor xgetVal() {
        STHighlightColor sTHighlightColor;
        synchronized (monitor()) {
            check_orphaned();
            sTHighlightColor = (STHighlightColor) get_store().find_attribute_user(VAL$0);
        }
        return sTHighlightColor;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHighlight
    public void xsetVal(STHighlightColor sTHighlightColor) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = VAL$0;
                STHighlightColor sTHighlightColor2 = (STHighlightColor) typeStore.find_attribute_user(qName);
                if (sTHighlightColor2 == null) {
                    sTHighlightColor2 = (STHighlightColor) get_store().add_attribute_user(qName);
                }
                sTHighlightColor2.set(sTHighlightColor);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
