package org.apache.poi.javax.xml.stream;

import java.io.InputStream;
import java.io.Reader;
import javax.xml.transform.Source;
import org.apache.poi.javax.xml.stream.util.XMLEventAllocator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class XMLInputFactory {
    public static final String ALLOCATOR = "org.apache.poi.javax.xml.stream.allocator";
    public static final String IS_COALESCING = "org.apache.poi.javax.xml.stream.isCoalescing";
    public static final String IS_NAMESPACE_AWARE = "org.apache.poi.javax.xml.stream.isNamespaceAware";
    public static final String IS_REPLACING_ENTITY_REFERENCES = "org.apache.poi.javax.xml.stream.isReplacingEntityReferences";
    public static final String IS_SUPPORTING_EXTERNAL_ENTITIES = "org.apache.poi.javax.xml.stream.isSupportingExternalEntities";
    public static final String IS_VALIDATING = "org.apache.poi.javax.xml.stream.isValidating";
    public static final String REPORTER = "org.apache.poi.javax.xml.stream.reporter";
    public static final String RESOLVER = "org.apache.poi.javax.xml.stream.resolver";
    public static final String SUPPORT_DTD = "org.apache.poi.javax.xml.stream.supportDTD";

    public static XMLInputFactory newInstance() {
        return (XMLInputFactory) FactoryFinder.find("org.apache.poi.javax.xml.stream.XMLInputFactory", "com.bea.xml.stream.MXParserFactory");
    }

    public abstract XMLEventReader createFilteredReader(XMLEventReader xMLEventReader, EventFilter eventFilter);

    public abstract XMLStreamReader createFilteredReader(XMLStreamReader xMLStreamReader, StreamFilter streamFilter);

    public abstract XMLEventReader createXMLEventReader(InputStream inputStream);

    public abstract XMLEventReader createXMLEventReader(InputStream inputStream, String str);

    public abstract XMLEventReader createXMLEventReader(Reader reader);

    public abstract XMLEventReader createXMLEventReader(String str, InputStream inputStream);

    public abstract XMLEventReader createXMLEventReader(String str, Reader reader);

    public abstract XMLEventReader createXMLEventReader(Source source);

    public abstract XMLEventReader createXMLEventReader(XMLStreamReader xMLStreamReader);

    public abstract XMLStreamReader createXMLStreamReader(InputStream inputStream);

    public abstract XMLStreamReader createXMLStreamReader(InputStream inputStream, String str);

    public abstract XMLStreamReader createXMLStreamReader(Reader reader);

    public abstract XMLStreamReader createXMLStreamReader(String str, InputStream inputStream);

    public abstract XMLStreamReader createXMLStreamReader(String str, Reader reader);

    public abstract XMLStreamReader createXMLStreamReader(Source source);

    public abstract XMLEventAllocator getEventAllocator();

    public abstract Object getProperty(String str);

    public abstract XMLReporter getXMLReporter();

    public abstract XMLResolver getXMLResolver();

    public abstract boolean isPropertySupported(String str);

    public abstract void setEventAllocator(XMLEventAllocator xMLEventAllocator);

    public abstract void setProperty(String str, Object obj);

    public abstract void setXMLReporter(XMLReporter xMLReporter);

    public abstract void setXMLResolver(XMLResolver xMLResolver);

    public static XMLInputFactory newInstance(String str, ClassLoader classLoader) {
        return (XMLInputFactory) FactoryFinder.find(str, "com.bea.xml.stream.MXParserFactory", classLoader);
    }
}
