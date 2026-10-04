package org.codehaus.stax2.p230ri;

import java.util.Iterator;
import org.apache.poi.javax.xml.namespace.NamespaceContext;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.javax.xml.stream.Location;
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
import org.codehaus.stax2.evt.DTD2;
import org.codehaus.stax2.evt.XMLEventFactory2;
import org.codehaus.stax2.p230ri.evt.AttributeEventImpl;
import org.codehaus.stax2.p230ri.evt.CommentEventImpl;
import org.codehaus.stax2.p230ri.evt.NamespaceEventImpl;
import org.codehaus.stax2.ri.evt.CharactersEventImpl;
import org.codehaus.stax2.ri.evt.DTDEventImpl;
import org.codehaus.stax2.ri.evt.EndDocumentEventImpl;
import org.codehaus.stax2.ri.evt.EndElementEventImpl;
import org.codehaus.stax2.ri.evt.EntityReferenceEventImpl;
import org.codehaus.stax2.ri.evt.ProcInstrEventImpl;
import org.codehaus.stax2.ri.evt.StartDocumentEventImpl;
import org.codehaus.stax2.ri.evt.StartElementEventImpl;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class Stax2EventFactoryImpl extends XMLEventFactory2 {
    protected Location mLocation;

    @Override // org.apache.poi.javax.xml.stream.XMLEventFactory
    public Attribute createAttribute(QName qName, String str) {
        return new AttributeEventImpl(this.mLocation, qName, str, true);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventFactory
    public Characters createCData(String str) {
        return new CharactersEventImpl(this.mLocation, str, true);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventFactory
    public Characters createCharacters(String str) {
        return new CharactersEventImpl(this.mLocation, str, false);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventFactory
    public Comment createComment(String str) {
        return new CommentEventImpl(this.mLocation, str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventFactory
    public DTD createDTD(String str) {
        return new DTDEventImpl(this.mLocation, str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventFactory
    public EndDocument createEndDocument() {
        return new EndDocumentEventImpl(this.mLocation);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventFactory
    public EndElement createEndElement(QName qName, Iterator it) {
        return new EndElementEventImpl(this.mLocation, qName, it);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventFactory
    public EntityReference createEntityReference(String str, EntityDeclaration entityDeclaration) {
        return new EntityReferenceEventImpl(this.mLocation, entityDeclaration);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventFactory
    public Characters createIgnorableSpace(String str) {
        return CharactersEventImpl.createIgnorableWS(this.mLocation, str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventFactory
    public Namespace createNamespace(String str) {
        return NamespaceEventImpl.constructDefaultNamespace(this.mLocation, str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventFactory
    public ProcessingInstruction createProcessingInstruction(String str, String str2) {
        return new ProcInstrEventImpl(this.mLocation, str, str2);
    }

    public abstract QName createQName(String str, String str2);

    public abstract QName createQName(String str, String str2, String str3);

    @Override // org.apache.poi.javax.xml.stream.XMLEventFactory
    public Characters createSpace(String str) {
        return CharactersEventImpl.createNonIgnorableWS(this.mLocation, str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventFactory
    public StartDocument createStartDocument() {
        return new StartDocumentEventImpl(this.mLocation);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventFactory
    public StartElement createStartElement(QName qName, Iterator it, Iterator it2) {
        return createStartElement(qName, it, it2, null);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventFactory
    public void setLocation(Location location) {
        this.mLocation = location;
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventFactory
    public Attribute createAttribute(String str, String str2) {
        return new AttributeEventImpl(this.mLocation, str, null, null, str2, true);
    }

    @Override // org.codehaus.stax2.evt.XMLEventFactory2
    public DTD2 createDTD(String str, String str2, String str3, String str4) {
        return new DTDEventImpl(this.mLocation, str, str2, str3, str4, (Object) null);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventFactory
    public EndElement createEndElement(String str, String str2, String str3) {
        return createEndElement(createQName(str2, str3, str), null);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventFactory
    public Namespace createNamespace(String str, String str2) {
        return NamespaceEventImpl.constructNamespace(this.mLocation, str, str2);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventFactory
    public StartDocument createStartDocument(String str) {
        return new StartDocumentEventImpl(this.mLocation, str);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventFactory
    public StartElement createStartElement(String str, String str2, String str3) {
        return createStartElement(createQName(str2, str3, str), null, null, null);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventFactory
    public Attribute createAttribute(String str, String str2, String str3, String str4) {
        return new AttributeEventImpl(this.mLocation, str3, str2, str, str4, true);
    }

    @Override // org.codehaus.stax2.evt.XMLEventFactory2
    public DTD2 createDTD(String str, String str2, String str3, String str4, Object obj) {
        return new DTDEventImpl(this.mLocation, str, str2, str3, str4, obj);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventFactory
    public EndElement createEndElement(String str, String str2, String str3, Iterator it) {
        return createEndElement(createQName(str2, str3, str), it);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventFactory
    public StartDocument createStartDocument(String str, String str2) {
        return new StartDocumentEventImpl(this.mLocation, str, str2);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventFactory
    public StartElement createStartElement(String str, String str2, String str3, Iterator it, Iterator it2) {
        return createStartElement(createQName(str2, str3, str), it, it2, null);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventFactory
    public StartDocument createStartDocument(String str, String str2, boolean z) {
        return new StartDocumentEventImpl(this.mLocation, str, str2, true, z);
    }

    @Override // org.apache.poi.javax.xml.stream.XMLEventFactory
    public StartElement createStartElement(String str, String str2, String str3, Iterator it, Iterator it2, NamespaceContext namespaceContext) {
        return createStartElement(createQName(str2, str3, str), it, it2, namespaceContext);
    }

    public StartElement createStartElement(QName qName, Iterator<?> it, Iterator<?> it2, NamespaceContext namespaceContext) {
        return StartElementEventImpl.construct(this.mLocation, qName, it, it2, namespaceContext);
    }
}
