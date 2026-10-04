package org.apache.xmlbeans;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;
import org.xml.sax.ContentHandler;
import org.xml.sax.ext.LexicalHandler;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface XmlTokenSource {
    XmlDocumentProperties documentProperties();

    void dump();

    Node getDomNode();

    Object monitor();

    XmlCursor newCursor();

    Node newDomNode();

    Node newDomNode(XmlOptions xmlOptions);

    InputStream newInputStream();

    InputStream newInputStream(XmlOptions xmlOptions);

    Reader newReader();

    Reader newReader(XmlOptions xmlOptions);

    XMLInputStream newXMLInputStream();

    XMLInputStream newXMLInputStream(XmlOptions xmlOptions);

    XMLStreamReader newXMLStreamReader();

    XMLStreamReader newXMLStreamReader(XmlOptions xmlOptions);

    void save(File file);

    void save(File file, XmlOptions xmlOptions);

    void save(OutputStream outputStream);

    void save(OutputStream outputStream, XmlOptions xmlOptions);

    void save(Writer writer);

    void save(Writer writer, XmlOptions xmlOptions);

    void save(ContentHandler contentHandler, LexicalHandler lexicalHandler);

    void save(ContentHandler contentHandler, LexicalHandler lexicalHandler, XmlOptions xmlOptions);

    String xmlText();

    String xmlText(XmlOptions xmlOptions);
}
