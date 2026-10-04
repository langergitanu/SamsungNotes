package org.apache.xmlbeans.xml.stream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface XMLInputStream {
    void close();

    ReferenceResolver getReferenceResolver();

    XMLInputStream getSubStream();

    boolean hasNext();

    XMLEvent next();

    XMLEvent peek();

    void setReferenceResolver(ReferenceResolver referenceResolver);

    void skip();

    boolean skip(int i);

    boolean skip(XMLName xMLName);

    boolean skip(XMLName xMLName, int i);

    void skipElement();
}
