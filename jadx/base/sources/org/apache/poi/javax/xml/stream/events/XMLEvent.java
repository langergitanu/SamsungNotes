package org.apache.poi.javax.xml.stream.events;

import java.io.Writer;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.javax.xml.stream.Location;
import org.apache.poi.javax.xml.stream.XMLStreamConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface XMLEvent extends XMLStreamConstants {
    Characters asCharacters();

    EndElement asEndElement();

    StartElement asStartElement();

    int getEventType();

    Location getLocation();

    QName getSchemaType();

    boolean isAttribute();

    boolean isCharacters();

    boolean isEndDocument();

    boolean isEndElement();

    boolean isEntityReference();

    boolean isNamespace();

    boolean isProcessingInstruction();

    boolean isStartDocument();

    boolean isStartElement();

    void writeAsEncodedUnicode(Writer writer);
}
