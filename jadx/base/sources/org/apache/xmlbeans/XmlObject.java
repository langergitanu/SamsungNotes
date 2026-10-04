package org.apache.xmlbeans;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface XmlObject extends XmlTokenSource {
    public static final int EQUAL = 0;
    public static final int GREATER_THAN = 1;
    public static final int LESS_THAN = -1;
    public static final int NOT_EQUAL = 2;
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_anyType");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static DOMImplementation newDomImplementation() {
            return XmlBeans.getContextTypeLoader().newDomImplementation(null);
        }

        public static XmlObject newInstance() {
            return XmlBeans.getContextTypeLoader().newInstance(null, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, null, null);
        }

        public static XmlObject newValue(Object obj) {
            return XmlObject.type.newValue(obj);
        }

        public static XmlSaxHandler newXmlSaxHandler() {
            return XmlBeans.getContextTypeLoader().newXmlSaxHandler(null, null);
        }

        public static XmlObject parse(String str) {
            return XmlBeans.getContextTypeLoader().parse(str, (SchemaType) null, (XmlOptions) null);
        }

        public static DOMImplementation newDomImplementation(XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newDomImplementation(xmlOptions);
        }

        public static XmlObject newInstance(XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newInstance(null, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, null, xmlOptions);
        }

        public static XmlSaxHandler newXmlSaxHandler(XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newXmlSaxHandler(null, xmlOptions);
        }

        public static XmlObject parse(String str, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().parse(str, (SchemaType) null, xmlOptions);
        }

        public static XmlObject parse(File file) {
            return XmlBeans.getContextTypeLoader().parse(file, (SchemaType) null, (XmlOptions) null);
        }

        public static XmlObject parse(File file, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().parse(file, (SchemaType) null, xmlOptions);
        }

        public static XmlObject parse(URL url) {
            return XmlBeans.getContextTypeLoader().parse(url, (SchemaType) null, (XmlOptions) null);
        }

        public static XmlObject parse(URL url, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().parse(url, (SchemaType) null, xmlOptions);
        }

        public static XmlObject parse(InputStream inputStream) {
            return XmlBeans.getContextTypeLoader().parse(inputStream, (SchemaType) null, (XmlOptions) null);
        }

        public static XmlObject parse(XMLStreamReader xMLStreamReader) {
            return XmlBeans.getContextTypeLoader().parse(xMLStreamReader, (SchemaType) null, (XmlOptions) null);
        }

        public static XmlObject parse(InputStream inputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().parse(inputStream, (SchemaType) null, xmlOptions);
        }

        public static XmlObject parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().parse(xMLStreamReader, (SchemaType) null, xmlOptions);
        }

        public static XmlObject parse(Reader reader) {
            return XmlBeans.getContextTypeLoader().parse(reader, (SchemaType) null, (XmlOptions) null);
        }

        public static XmlObject parse(Reader reader, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().parse(reader, (SchemaType) null, xmlOptions);
        }

        public static XmlObject parse(Node node) {
            return XmlBeans.getContextTypeLoader().parse(node, (SchemaType) null, (XmlOptions) null);
        }

        public static XmlObject parse(Node node, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().parse(node, (SchemaType) null, xmlOptions);
        }

        public static XmlObject parse(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().parse(xMLInputStream, (SchemaType) null, (XmlOptions) null);
        }

        public static XmlObject parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().parse(xMLInputStream, (SchemaType) null, xmlOptions);
        }
    }

    XmlObject changeType(SchemaType schemaType);

    int compareTo(Object obj);

    int compareValue(XmlObject xmlObject);

    XmlObject copy();

    XmlObject copy(XmlOptions xmlOptions);

    XmlObject[] execQuery(String str);

    XmlObject[] execQuery(String str, XmlOptions xmlOptions);

    boolean isImmutable();

    boolean isNil();

    SchemaType schemaType();

    XmlObject selectAttribute(String str, String str2);

    XmlObject selectAttribute(QName qName);

    XmlObject[] selectAttributes(QNameSet qNameSet);

    XmlObject[] selectChildren(String str, String str2);

    XmlObject[] selectChildren(QName qName);

    XmlObject[] selectChildren(QNameSet qNameSet);

    XmlObject[] selectPath(String str);

    XmlObject[] selectPath(String str, XmlOptions xmlOptions);

    XmlObject set(XmlObject xmlObject);

    void setNil();

    XmlObject substitute(QName qName, SchemaType schemaType);

    String toString();

    boolean validate();

    boolean validate(XmlOptions xmlOptions);

    boolean valueEquals(XmlObject xmlObject);

    int valueHashCode();
}
