package org.apache.xmlbeans;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaGlobalAttribute;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaModelGroup;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface SchemaTypeLoader {
    String compilePath(String str, XmlOptions xmlOptions);

    String compileQuery(String str, XmlOptions xmlOptions);

    SchemaGlobalAttribute findAttribute(QName qName);

    SchemaAttributeGroup findAttributeGroup(QName qName);

    SchemaAttributeGroup.Ref findAttributeGroupRef(QName qName);

    SchemaGlobalAttribute.Ref findAttributeRef(QName qName);

    SchemaType findAttributeType(QName qName);

    SchemaType.Ref findAttributeTypeRef(QName qName);

    SchemaType findDocumentType(QName qName);

    SchemaType.Ref findDocumentTypeRef(QName qName);

    SchemaGlobalElement findElement(QName qName);

    SchemaGlobalElement.Ref findElementRef(QName qName);

    SchemaIdentityConstraint.Ref findIdentityConstraintRef(QName qName);

    SchemaModelGroup findModelGroup(QName qName);

    SchemaModelGroup.Ref findModelGroupRef(QName qName);

    SchemaType findType(QName qName);

    SchemaType.Ref findTypeRef(QName qName);

    InputStream getSourceAsStream(String str);

    boolean isNamespaceDefined(String str);

    DOMImplementation newDomImplementation(XmlOptions xmlOptions);

    XmlObject newInstance(SchemaType schemaType, XmlOptions xmlOptions);

    XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, SchemaType schemaType, XmlOptions xmlOptions);

    XmlSaxHandler newXmlSaxHandler(SchemaType schemaType, XmlOptions xmlOptions);

    XmlObject parse(File file, SchemaType schemaType, XmlOptions xmlOptions);

    XmlObject parse(InputStream inputStream, SchemaType schemaType, XmlOptions xmlOptions);

    XmlObject parse(Reader reader, SchemaType schemaType, XmlOptions xmlOptions);

    XmlObject parse(String str, SchemaType schemaType, XmlOptions xmlOptions);

    XmlObject parse(URL url, SchemaType schemaType, XmlOptions xmlOptions);

    XmlObject parse(XMLStreamReader xMLStreamReader, SchemaType schemaType, XmlOptions xmlOptions);

    XmlObject parse(XMLInputStream xMLInputStream, SchemaType schemaType, XmlOptions xmlOptions);

    XmlObject parse(Node node, SchemaType schemaType, XmlOptions xmlOptions);

    SchemaType typeForClassname(String str);

    SchemaType typeForSignature(String str);
}
