package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STString;

/* JADX INFO: loaded from: classes11.dex */
public class CTBookmarkImpl extends CTBookmarkRangeImpl implements CTBookmark {
    private static final QName NAME$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "name");

    public CTBookmarkImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark
    public String getName() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(NAME$0);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark
    public void setName(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = NAME$0;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark
    public STString xgetName() {
        STString sTString;
        synchronized (monitor()) {
            check_orphaned();
            sTString = (STString) get_store().find_attribute_user(NAME$0);
        }
        return sTString;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark
    public void xsetName(STString sTString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = NAME$0;
                STString sTString2 = (STString) typeStore.find_attribute_user(qName);
                if (sTString2 == null) {
                    sTString2 = (STString) get_store().add_attribute_user(qName);
                }
                sTString2.set(sTString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
