package org.apache.poi.javax.xml.stream;

import java.io.OutputStream;
import java.io.Writer;
import javax.xml.transform.Result;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class XMLOutputFactory {
    public static final String IS_REPAIRING_NAMESPACES = "org.apache.poi.javax.xml.stream.isRepairingNamespaces";

    public static XMLOutputFactory newInstance() {
        return (XMLOutputFactory) FactoryFinder.find("org.apache.poi.javax.xml.stream.XMLOutputFactory", "com.bea.xml.stream.XMLOutputFactoryBase");
    }

    public abstract XMLEventWriter createXMLEventWriter(OutputStream outputStream);

    public abstract XMLEventWriter createXMLEventWriter(OutputStream outputStream, String str);

    public abstract XMLEventWriter createXMLEventWriter(Writer writer);

    public abstract XMLEventWriter createXMLEventWriter(Result result);

    public abstract XMLStreamWriter createXMLStreamWriter(OutputStream outputStream);

    public abstract XMLStreamWriter createXMLStreamWriter(OutputStream outputStream, String str);

    public abstract XMLStreamWriter createXMLStreamWriter(Writer writer);

    public abstract XMLStreamWriter createXMLStreamWriter(Result result);

    public abstract Object getProperty(String str);

    public abstract boolean isPropertySupported(String str);

    public abstract void setProperty(String str, Object obj);

    public static XMLOutputFactory newInstance(String str, ClassLoader classLoader) {
        return (XMLOutputFactory) FactoryFinder.find(str, "com.bea.xml.stream.XMLOutputFactoryBase", classLoader);
    }
}
