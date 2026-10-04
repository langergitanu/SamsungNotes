package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtension;

/* JADX INFO: loaded from: classes11.dex */
public class CTExtensionImpl extends XmlComplexContentImpl implements CTExtension {
    private static final QName URI$0 = new QName("", "uri");

    public CTExtensionImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTExtension
    public String getUri() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(URI$0);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTExtension
    public boolean isSetUri() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(URI$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTExtension
    public void setUri(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = URI$0;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTExtension
    public void unsetUri() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(URI$0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTExtension
    public XmlToken xgetUri() {
        XmlToken xmlToken;
        synchronized (monitor()) {
            check_orphaned();
            xmlToken = (XmlToken) get_store().find_attribute_user(URI$0);
        }
        return xmlToken;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTExtension
    public void xsetUri(XmlToken xmlToken) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = URI$0;
                XmlToken xmlToken2 = (XmlToken) typeStore.find_attribute_user(qName);
                if (xmlToken2 == null) {
                    xmlToken2 = (XmlToken) get_store().add_attribute_user(qName);
                }
                xmlToken2.set(xmlToken);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
