package org.apache.poi.javax.xml.stream;

import org.apache.poi.javax.xml.namespace.NamespaceContext;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface XMLStreamWriter {
    void close();

    void flush();

    NamespaceContext getNamespaceContext();

    String getPrefix(String str);

    Object getProperty(String str);

    void setDefaultNamespace(String str);

    void setNamespaceContext(NamespaceContext namespaceContext);

    void setPrefix(String str, String str2);

    void writeAttribute(String str, String str2);

    void writeAttribute(String str, String str2, String str3);

    void writeAttribute(String str, String str2, String str3, String str4);

    void writeCData(String str);

    void writeCharacters(String str);

    void writeCharacters(char[] cArr, int i, int i2);

    void writeComment(String str);

    void writeDTD(String str);

    void writeDefaultNamespace(String str);

    void writeEmptyElement(String str);

    void writeEmptyElement(String str, String str2);

    void writeEmptyElement(String str, String str2, String str3);

    void writeEndDocument();

    void writeEndElement();

    void writeEntityRef(String str);

    void writeNamespace(String str, String str2);

    void writeProcessingInstruction(String str);

    void writeProcessingInstruction(String str, String str2);

    void writeStartDocument();

    void writeStartDocument(String str);

    void writeStartDocument(String str, String str2);

    void writeStartElement(String str);

    void writeStartElement(String str, String str2);

    void writeStartElement(String str, String str2, String str3);
}
