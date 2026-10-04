package org.apache.poi.javax.xml.stream;

import java.util.Iterator;
import org.apache.poi.javax.xml.namespace.NamespaceContext;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.javax.xml.stream.events.Attribute;
import org.apache.poi.javax.xml.stream.events.Characters;
import org.apache.poi.javax.xml.stream.events.Comment;
import org.apache.poi.javax.xml.stream.events.DTD;
import org.apache.poi.javax.xml.stream.events.EndDocument;
import org.apache.poi.javax.xml.stream.events.EndElement;
import org.apache.poi.javax.xml.stream.events.EntityDeclaration;
import org.apache.poi.javax.xml.stream.events.EntityReference;
import org.apache.poi.javax.xml.stream.events.Namespace;
import org.apache.poi.javax.xml.stream.events.ProcessingInstruction;
import org.apache.poi.javax.xml.stream.events.StartDocument;
import org.apache.poi.javax.xml.stream.events.StartElement;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class XMLEventFactory {
    public static XMLEventFactory newInstance() {
        return (XMLEventFactory) FactoryFinder.find("org.apache.poi.javax.xml.stream.XMLEventFactory", "com.bea.xml.stream.EventFactory");
    }

    public abstract Attribute createAttribute(String str, String str2);

    public abstract Attribute createAttribute(String str, String str2, String str3, String str4);

    public abstract Attribute createAttribute(QName qName, String str);

    public abstract Characters createCData(String str);

    public abstract Characters createCharacters(String str);

    public abstract Comment createComment(String str);

    public abstract DTD createDTD(String str);

    public abstract EndDocument createEndDocument();

    public abstract EndElement createEndElement(String str, String str2, String str3);

    public abstract EndElement createEndElement(String str, String str2, String str3, Iterator it);

    public abstract EndElement createEndElement(QName qName, Iterator it);

    public abstract EntityReference createEntityReference(String str, EntityDeclaration entityDeclaration);

    public abstract Characters createIgnorableSpace(String str);

    public abstract Namespace createNamespace(String str);

    public abstract Namespace createNamespace(String str, String str2);

    public abstract ProcessingInstruction createProcessingInstruction(String str, String str2);

    public abstract Characters createSpace(String str);

    public abstract StartDocument createStartDocument();

    public abstract StartDocument createStartDocument(String str);

    public abstract StartDocument createStartDocument(String str, String str2);

    public abstract StartDocument createStartDocument(String str, String str2, boolean z);

    public abstract StartElement createStartElement(String str, String str2, String str3);

    public abstract StartElement createStartElement(String str, String str2, String str3, Iterator it, Iterator it2);

    public abstract StartElement createStartElement(String str, String str2, String str3, Iterator it, Iterator it2, NamespaceContext namespaceContext);

    public abstract StartElement createStartElement(QName qName, Iterator it, Iterator it2);

    public abstract void setLocation(Location location);

    public static XMLEventFactory newInstance(String str, ClassLoader classLoader) {
        return (XMLEventFactory) FactoryFinder.find(str, "com.bea.xml.stream.EventFactory", classLoader);
    }
}
