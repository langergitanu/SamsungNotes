package org.apache.poi.javax.xml.stream.util;

import org.apache.poi.javax.xml.stream.XMLEventReader;
import org.apache.poi.javax.xml.stream.events.XMLEvent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class EventReaderDelegate implements XMLEventReader {
    private XMLEventReader reader;

    public EventReaderDelegate() {
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventReader
    public void close() {
        this.reader.close();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventReader
    public String getElementText() {
        return this.reader.getElementText();
    }

    public XMLEventReader getParent() {
        return this.reader;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventReader
    public Object getProperty(String str) {
        return this.reader.getProperty(str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventReader, java.util.Iterator
    public boolean hasNext() {
        return this.reader.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        return this.reader.next();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventReader
    public XMLEvent nextEvent() {
        return this.reader.nextEvent();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventReader
    public XMLEvent nextTag() {
        return this.reader.nextTag();
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventReader
    public XMLEvent peek() {
        return this.reader.peek();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.reader.remove();
    }

    public void setParent(XMLEventReader xMLEventReader) {
        this.reader = xMLEventReader;
    }

    public EventReaderDelegate(XMLEventReader xMLEventReader) {
        this.reader = xMLEventReader;
    }
}
