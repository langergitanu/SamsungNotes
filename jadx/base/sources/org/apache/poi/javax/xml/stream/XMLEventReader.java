package org.apache.poi.javax.xml.stream;

import java.util.Iterator;
import org.apache.poi.javax.xml.stream.events.XMLEvent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface XMLEventReader extends Iterator {
    void close();

    String getElementText();

    Object getProperty(String str);

    @Override // java.util.Iterator
    boolean hasNext();

    XMLEvent nextEvent();

    XMLEvent nextTag();

    XMLEvent peek();
}
