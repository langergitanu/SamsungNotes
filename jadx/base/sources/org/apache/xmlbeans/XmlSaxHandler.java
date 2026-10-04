package org.apache.xmlbeans;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlCursor;
import org.xml.sax.ContentHandler;
import org.xml.sax.ext.LexicalHandler;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface XmlSaxHandler {
    void bookmarkLastAttr(QName qName, XmlCursor.XmlBookmark xmlBookmark);

    void bookmarkLastEvent(XmlCursor.XmlBookmark xmlBookmark);

    ContentHandler getContentHandler();

    LexicalHandler getLexicalHandler();

    XmlObject getObject();
}
