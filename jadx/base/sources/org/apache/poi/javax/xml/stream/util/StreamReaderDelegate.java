package org.apache.poi.javax.xml.stream.util;

import org.apache.poi.javax.xml.namespace.NamespaceContext;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.javax.xml.stream.Location;
import org.apache.poi.javax.xml.stream.XMLStreamReader;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class StreamReaderDelegate implements XMLStreamReader {
    private XMLStreamReader reader;

    public StreamReaderDelegate() {
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public void close() {
        this.reader.close();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public int getAttributeCount() {
        return this.reader.getAttributeCount();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getAttributeLocalName(int i) {
        return this.reader.getAttributeLocalName(i);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public QName getAttributeName(int i) {
        return this.reader.getAttributeName(i);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getAttributeNamespace(int i) {
        return this.reader.getAttributeNamespace(i);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getAttributePrefix(int i) {
        return this.reader.getAttributePrefix(i);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getAttributeType(int i) {
        return this.reader.getAttributeType(i);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getAttributeValue(String str, String str2) {
        return this.reader.getAttributeValue(str, str2);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getCharacterEncodingScheme() {
        return this.reader.getCharacterEncodingScheme();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getElementText() {
        return this.reader.getElementText();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getEncoding() {
        return this.reader.getEncoding();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public int getEventType() {
        return this.reader.getEventType();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getLocalName() {
        return this.reader.getLocalName();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public Location getLocation() {
        return this.reader.getLocation();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public QName getName() {
        return this.reader.getName();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public NamespaceContext getNamespaceContext() {
        return this.reader.getNamespaceContext();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public int getNamespaceCount() {
        return this.reader.getNamespaceCount();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getNamespacePrefix(int i) {
        return this.reader.getNamespacePrefix(i);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getNamespaceURI(String str) {
        return this.reader.getNamespaceURI(str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getPIData() {
        return this.reader.getPIData();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getPITarget() {
        return this.reader.getPITarget();
    }

    public XMLStreamReader getParent() {
        return this.reader;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getPrefix() {
        return this.reader.getPrefix();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public Object getProperty(String str) {
        return this.reader.getProperty(str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getText() {
        return this.reader.getText();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public int getTextCharacters(int i, char[] cArr, int i2, int i4) {
        return this.reader.getTextCharacters(i, cArr, i2, i4);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public int getTextLength() {
        return this.reader.getTextLength();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public int getTextStart() {
        return this.reader.getTextStart();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getVersion() {
        return this.reader.getVersion();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public boolean hasName() {
        return this.reader.hasName();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public boolean hasNext() {
        return this.reader.hasNext();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public boolean hasText() {
        return this.reader.hasText();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public boolean isAttributeSpecified(int i) {
        return this.reader.isAttributeSpecified(i);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public boolean isCharacters() {
        return this.reader.isCharacters();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public boolean isEndElement() {
        return this.reader.isEndElement();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public boolean isStandalone() {
        return this.reader.isStandalone();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public boolean isStartElement() {
        return this.reader.isStartElement();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public boolean isWhiteSpace() {
        return this.reader.isWhiteSpace();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public int next() {
        return this.reader.next();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public int nextTag() {
        return this.reader.nextTag();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public void require(int i, String str, String str2) {
        this.reader.require(i, str, str2);
    }

    public void setParent(XMLStreamReader xMLStreamReader) {
        this.reader = xMLStreamReader;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public boolean standaloneSet() {
        return this.reader.standaloneSet();
    }

    public StreamReaderDelegate(XMLStreamReader xMLStreamReader) {
        this.reader = xMLStreamReader;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getAttributeValue(int i) {
        return this.reader.getAttributeValue(i);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getNamespaceURI(int i) {
        return this.reader.getNamespaceURI(i);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public char[] getTextCharacters() {
        return this.reader.getTextCharacters();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLStreamReader
    public String getNamespaceURI() {
        return this.reader.getNamespaceURI();
    }
}
