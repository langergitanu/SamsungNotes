package org.apache.poi.javax.xml.stream;

import org.apache.poi.javax.xml.namespace.NamespaceContext;
import org.apache.poi.javax.xml.namespace.QName;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface XMLStreamReader extends XMLStreamConstants {
    void close();

    int getAttributeCount();

    String getAttributeLocalName(int i);

    QName getAttributeName(int i);

    String getAttributeNamespace(int i);

    String getAttributePrefix(int i);

    String getAttributeType(int i);

    String getAttributeValue(int i);

    String getAttributeValue(String str, String str2);

    String getCharacterEncodingScheme();

    String getElementText();

    String getEncoding();

    int getEventType();

    String getLocalName();

    Location getLocation();

    QName getName();

    NamespaceContext getNamespaceContext();

    int getNamespaceCount();

    String getNamespacePrefix(int i);

    String getNamespaceURI();

    String getNamespaceURI(int i);

    String getNamespaceURI(String str);

    String getPIData();

    String getPITarget();

    String getPrefix();

    Object getProperty(String str);

    String getText();

    int getTextCharacters(int i, char[] cArr, int i2, int i4);

    char[] getTextCharacters();

    int getTextLength();

    int getTextStart();

    String getVersion();

    boolean hasName();

    boolean hasNext();

    boolean hasText();

    boolean isAttributeSpecified(int i);

    boolean isCharacters();

    boolean isEndElement();

    boolean isStandalone();

    boolean isStartElement();

    boolean isWhiteSpace();

    int next();

    int nextTag();

    void require(int i, String str, String str2);

    boolean standaloneSet();
}
