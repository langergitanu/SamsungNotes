package org.codehaus.stax2.p230ri.evt;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.javax.xml.stream.Location;
import org.apache.poi.javax.xml.stream.XMLStreamException;
import org.apache.poi.javax.xml.stream.events.Characters;
import org.apache.poi.javax.xml.stream.events.EndElement;
import org.apache.poi.javax.xml.stream.events.StartElement;
import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.evt.XMLEvent2;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class BaseEventImpl implements XMLEvent2 {

    @Deprecated
    protected final Location mLocation;

    public BaseEventImpl(Location location) {
        this.mLocation = location;
    }

    public static int addHash(Iterator<?> it, int i) {
        if (it != null) {
            while (it.hasNext()) {
                i ^= it.next().hashCode();
            }
        }
        return i;
    }

    public static boolean iteratedEquals(Iterator<?> it, Iterator<?> it2) {
        if (it == null || it2 == null) {
            return it == it2;
        }
        while (it.hasNext()) {
            if (!it2.hasNext() || !it.next().equals(it2.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean stringsWithNullsEqual(String str, String str2) {
        return (str == null || str.length() == 0) ? str2 == null || str2.length() == 0 : str2 != null && str.equals(str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public Characters asCharacters() {
        return (Characters) this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public EndElement asEndElement() {
        return (EndElement) this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public StartElement asStartElement() {
        return (StartElement) this;
    }

    public abstract boolean equals(Object obj);

    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public abstract int getEventType();

    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public Location getLocation() {
        return this.mLocation;
    }

    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public QName getSchemaType() {
        return null;
    }

    public abstract int hashCode();

    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public boolean isAttribute() {
        return false;
    }

    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public boolean isCharacters() {
        return false;
    }

    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public boolean isEndDocument() {
        return false;
    }

    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public boolean isEndElement() {
        return false;
    }

    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public boolean isEntityReference() {
        return false;
    }

    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public boolean isNamespace() {
        return false;
    }

    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public boolean isProcessingInstruction() {
        return false;
    }

    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public boolean isStartDocument() {
        return false;
    }

    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public boolean isStartElement() {
        return false;
    }

    public void throwFromIOE(IOException iOException) throws XMLStreamException {
        throw new XMLStreamException(iOException.getMessage(), iOException);
    }

    public String toString() {
        return "[Stax Event #" + getEventType() + "]";
    }

    @Override // org.apache.poi.javax.xml.stream.events.XMLEvent
    public abstract void writeAsEncodedUnicode(Writer writer);

    @Override // org.codehaus.stax2.evt.XMLEvent2
    public abstract void writeUsing(XMLStreamWriter2 xMLStreamWriter2);
}
