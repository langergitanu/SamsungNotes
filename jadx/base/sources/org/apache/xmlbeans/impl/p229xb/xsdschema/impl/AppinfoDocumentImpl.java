package org.apache.xmlbeans.impl.p229xb.xsdschema.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.impl.p229xb.xsdschema.AppinfoDocument;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class AppinfoDocumentImpl extends XmlComplexContentImpl implements AppinfoDocument {
    private static final QName APPINFO$0 = new QName("http://www.w3.org/2001/XMLSchema", "appinfo");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class AppinfoImpl extends XmlComplexContentImpl implements AppinfoDocument.Appinfo {
        private static final QName SOURCE$0 = new QName("", "source");

        public AppinfoImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument.Appinfo
        public String getSource() {
            synchronized (monitor()) {
                try {
                    check_orphaned();
                    SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(SOURCE$0);
                    if (simpleValue == null) {
                        return null;
                    }
                    return simpleValue.getStringValue();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument.Appinfo
        public boolean isSetSource() {
            boolean z;
            synchronized (monitor()) {
                check_orphaned();
                z = get_store().find_attribute_user(SOURCE$0) != null;
            }
            return z;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument.Appinfo
        public void setSource(String str) {
            synchronized (monitor()) {
                try {
                    check_orphaned();
                    TypeStore typeStore = get_store();
                    QName qName = SOURCE$0;
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

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument.Appinfo
        public void unsetSource() {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_attribute(SOURCE$0);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument.Appinfo
        public XmlAnyURI xgetSource() {
            XmlAnyURI xmlAnyURI;
            synchronized (monitor()) {
                check_orphaned();
                xmlAnyURI = (XmlAnyURI) get_store().find_attribute_user(SOURCE$0);
            }
            return xmlAnyURI;
        }

        @Override // org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument.Appinfo
        public void xsetSource(XmlAnyURI xmlAnyURI) {
            synchronized (monitor()) {
                try {
                    check_orphaned();
                    TypeStore typeStore = get_store();
                    QName qName = SOURCE$0;
                    XmlAnyURI xmlAnyURI2 = (XmlAnyURI) typeStore.find_attribute_user(qName);
                    if (xmlAnyURI2 == null) {
                        xmlAnyURI2 = (XmlAnyURI) get_store().add_attribute_user(qName);
                    }
                    xmlAnyURI2.set(xmlAnyURI);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public AppinfoDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.p229xb.xsdschema.AppinfoDocument
    public AppinfoDocument.Appinfo addNewAppinfo() {
        AppinfoDocument.Appinfo appinfo;
        synchronized (monitor()) {
            check_orphaned();
            appinfo = (AppinfoDocument.Appinfo) get_store().add_element_user(APPINFO$0);
        }
        return appinfo;
    }

    @Override // org.apache.xmlbeans.impl.p229xb.xsdschema.AppinfoDocument
    public AppinfoDocument.Appinfo getAppinfo() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                AppinfoDocument.Appinfo appinfo = (AppinfoDocument.Appinfo) get_store().find_element_user(APPINFO$0, 0);
                if (appinfo == null) {
                    return null;
                }
                return appinfo;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.p229xb.xsdschema.AppinfoDocument
    public void setAppinfo(AppinfoDocument.Appinfo appinfo) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = APPINFO$0;
                AppinfoDocument.Appinfo appinfo2 = (AppinfoDocument.Appinfo) typeStore.find_element_user(qName, 0);
                if (appinfo2 == null) {
                    appinfo2 = (AppinfoDocument.Appinfo) get_store().add_element_user(qName);
                }
                appinfo2.set(appinfo);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
