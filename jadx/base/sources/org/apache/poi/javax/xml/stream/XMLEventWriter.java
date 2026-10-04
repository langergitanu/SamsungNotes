package org.apache.poi.javax.xml.stream;

import org.apache.poi.javax.xml.namespace.NamespaceContext;
import org.apache.poi.javax.xml.stream.events.XMLEvent;
import org.apache.poi.javax.xml.stream.util.XMLEventConsumer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface XMLEventWriter extends XMLEventConsumer {
    void add(XMLEventReader xMLEventReader);

    @Override // org.apache.poi.javax.xml.stream.util.XMLEventConsumer
    void add(XMLEvent xMLEvent);

    void close();

    void flush();

    NamespaceContext getNamespaceContext();

    String getPrefix(String str);

    void setDefaultNamespace(String str);

    void setNamespaceContext(NamespaceContext namespaceContext);

    void setPrefix(String str, String str2);
}
