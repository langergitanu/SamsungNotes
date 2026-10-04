package org.apache.xmlbeans;

import java.io.InputStream;
import java.io.Reader;
import java.lang.ref.SoftReference;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface XmlFactoryHook {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ThreadContext {
        private static ThreadLocal threadHook = new ThreadLocal();

        private ThreadContext() {
        }

        public static XmlFactoryHook getHook() {
            SoftReference softReference = (SoftReference) threadHook.get();
            if (softReference == null) {
                return null;
            }
            return (XmlFactoryHook) softReference.get();
        }

        public static void setHook(XmlFactoryHook xmlFactoryHook) {
            threadHook.set(new SoftReference(xmlFactoryHook));
        }
    }

    DOMImplementation newDomImplementation(SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions);

    XmlObject newInstance(SchemaTypeLoader schemaTypeLoader, SchemaType schemaType, XmlOptions xmlOptions);

    XmlSaxHandler newXmlSaxHandler(SchemaTypeLoader schemaTypeLoader, SchemaType schemaType, XmlOptions xmlOptions);

    XmlObject parse(SchemaTypeLoader schemaTypeLoader, InputStream inputStream, SchemaType schemaType, XmlOptions xmlOptions);

    XmlObject parse(SchemaTypeLoader schemaTypeLoader, Reader reader, SchemaType schemaType, XmlOptions xmlOptions);

    XmlObject parse(SchemaTypeLoader schemaTypeLoader, String str, SchemaType schemaType, XmlOptions xmlOptions);

    XmlObject parse(SchemaTypeLoader schemaTypeLoader, XMLStreamReader xMLStreamReader, SchemaType schemaType, XmlOptions xmlOptions);

    XmlObject parse(SchemaTypeLoader schemaTypeLoader, XMLInputStream xMLInputStream, SchemaType schemaType, XmlOptions xmlOptions);

    XmlObject parse(SchemaTypeLoader schemaTypeLoader, Node node, SchemaType schemaType, XmlOptions xmlOptions);
}
