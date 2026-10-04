package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkup;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumber;

/* JADX INFO: loaded from: classes11.dex */
public class CTMarkupImpl extends XmlComplexContentImpl implements CTMarkup {
    private static final QName ID$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "id");

    public CTMarkupImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkup
    public BigInteger getId() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ID$0);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getBigIntegerValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkup
    public void setId(BigInteger bigInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ID$0;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setBigIntegerValue(bigInteger);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkup
    public STDecimalNumber xgetId() {
        STDecimalNumber sTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            sTDecimalNumber = (STDecimalNumber) get_store().find_attribute_user(ID$0);
        }
        return sTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkup
    public void xsetId(STDecimalNumber sTDecimalNumber) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ID$0;
                STDecimalNumber sTDecimalNumber2 = (STDecimalNumber) typeStore.find_attribute_user(qName);
                if (sTDecimalNumber2 == null) {
                    sTDecimalNumber2 = (STDecimalNumber) get_store().add_attribute_user(qName);
                }
                sTDecimalNumber2.set(sTDecimalNumber);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
