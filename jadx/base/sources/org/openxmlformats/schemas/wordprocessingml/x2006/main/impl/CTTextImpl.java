package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.JavaStringHolderEx;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;

/* JADX INFO: loaded from: classes11.dex */
public class CTTextImpl extends JavaStringHolderEx implements CTText {
    private static final QName SPACE$0 = new QName("http://www.w3.org/XML/1998/namespace", "space");

    public CTTextImpl(SchemaType schemaType) {
        super(schemaType, true);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText
    public SpaceAttribute.Space.Enum getSpace() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SPACE$0;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qName);
                }
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText
    public boolean isSetSpace() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SPACE$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText
    public void setSpace(SpaceAttribute.Space.Enum r4) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SPACE$0;
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText
    public void unsetSpace() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SPACE$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText
    public SpaceAttribute.Space xgetSpace() {
        SpaceAttribute.Space spaceFind_attribute_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SPACE$0;
                spaceFind_attribute_user = typeStore.find_attribute_user(qName);
                if (spaceFind_attribute_user == null) {
                    spaceFind_attribute_user = (SpaceAttribute.Space) get_default_attribute_value(qName);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return spaceFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText
    public void xsetSpace(SpaceAttribute.Space space) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SPACE$0;
                SpaceAttribute.Space spaceFind_attribute_user = typeStore.find_attribute_user(qName);
                if (spaceFind_attribute_user == null) {
                    spaceFind_attribute_user = (SpaceAttribute.Space) get_store().add_attribute_user(qName);
                }
                spaceFind_attribute_user.set(space);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public CTTextImpl(SchemaType schemaType, boolean z) {
        super(schemaType, z);
    }
}
