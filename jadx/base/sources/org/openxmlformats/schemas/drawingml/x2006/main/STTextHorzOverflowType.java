package org.openxmlformats.schemas.drawingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface STTextHorzOverflowType extends XmlToken {
    public static final int INT_CLIP = 2;
    public static final int INT_OVERFLOW = 1;
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STTextHorzOverflowType.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "sttexthorzoverflowtype6003type");
    public static final Enum OVERFLOW = Enum.forString("overflow");
    public static final Enum CLIP = Enum.forString("clip");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CLIP = 2;
        static final int INT_OVERFLOW = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("overflow", 1), new Enum("clip", 2)});

        private Enum(String str, int i) {
            super(str, i);
        }

        public static Enum forInt(int i) {
            return (Enum) table.forInt(i);
        }

        public static Enum forString(String str) {
            return (Enum) table.forString(str);
        }

        private Object readResolve() {
            return forInt(intValue());
        }
    }

    public static final class Factory {
        private Factory() {
        }

        public static STTextHorzOverflowType newInstance() {
            return (STTextHorzOverflowType) POIXMLTypeLoader.newInstance(STTextHorzOverflowType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextHorzOverflowType.type, null);
        }

        public static STTextHorzOverflowType newValue(Object obj) {
            return (STTextHorzOverflowType) STTextHorzOverflowType.type.newValue(obj);
        }

        public static STTextHorzOverflowType parse(File file) {
            return (STTextHorzOverflowType) POIXMLTypeLoader.parse(file, STTextHorzOverflowType.type, (XmlOptions) null);
        }

        public static STTextHorzOverflowType newInstance(XmlOptions xmlOptions) {
            return (STTextHorzOverflowType) POIXMLTypeLoader.newInstance(STTextHorzOverflowType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextHorzOverflowType.type, xmlOptions);
        }

        public static STTextHorzOverflowType parse(File file, XmlOptions xmlOptions) {
            return (STTextHorzOverflowType) POIXMLTypeLoader.parse(file, STTextHorzOverflowType.type, xmlOptions);
        }

        public static STTextHorzOverflowType parse(InputStream inputStream) {
            return (STTextHorzOverflowType) POIXMLTypeLoader.parse(inputStream, STTextHorzOverflowType.type, (XmlOptions) null);
        }

        public static STTextHorzOverflowType parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STTextHorzOverflowType) POIXMLTypeLoader.parse(inputStream, STTextHorzOverflowType.type, xmlOptions);
        }

        public static STTextHorzOverflowType parse(Reader reader) {
            return (STTextHorzOverflowType) POIXMLTypeLoader.parse(reader, STTextHorzOverflowType.type, (XmlOptions) null);
        }

        public static STTextHorzOverflowType parse(Reader reader, XmlOptions xmlOptions) {
            return (STTextHorzOverflowType) POIXMLTypeLoader.parse(reader, STTextHorzOverflowType.type, xmlOptions);
        }

        public static STTextHorzOverflowType parse(String str) {
            return (STTextHorzOverflowType) POIXMLTypeLoader.parse(str, STTextHorzOverflowType.type, (XmlOptions) null);
        }

        public static STTextHorzOverflowType parse(String str, XmlOptions xmlOptions) {
            return (STTextHorzOverflowType) POIXMLTypeLoader.parse(str, STTextHorzOverflowType.type, xmlOptions);
        }

        public static STTextHorzOverflowType parse(URL url) {
            return (STTextHorzOverflowType) POIXMLTypeLoader.parse(url, STTextHorzOverflowType.type, (XmlOptions) null);
        }

        public static STTextHorzOverflowType parse(URL url, XmlOptions xmlOptions) {
            return (STTextHorzOverflowType) POIXMLTypeLoader.parse(url, STTextHorzOverflowType.type, xmlOptions);
        }

        public static STTextHorzOverflowType parse(XMLStreamReader xMLStreamReader) {
            return (STTextHorzOverflowType) POIXMLTypeLoader.parse(xMLStreamReader, STTextHorzOverflowType.type, (XmlOptions) null);
        }

        public static STTextHorzOverflowType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STTextHorzOverflowType) POIXMLTypeLoader.parse(xMLStreamReader, STTextHorzOverflowType.type, xmlOptions);
        }

        public static STTextHorzOverflowType parse(XMLInputStream xMLInputStream) {
            return (STTextHorzOverflowType) POIXMLTypeLoader.parse(xMLInputStream, STTextHorzOverflowType.type, (XmlOptions) null);
        }

        public static STTextHorzOverflowType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STTextHorzOverflowType) POIXMLTypeLoader.parse(xMLInputStream, STTextHorzOverflowType.type, xmlOptions);
        }

        public static STTextHorzOverflowType parse(Node node) {
            return (STTextHorzOverflowType) POIXMLTypeLoader.parse(node, STTextHorzOverflowType.type, (XmlOptions) null);
        }

        public static STTextHorzOverflowType parse(Node node, XmlOptions xmlOptions) {
            return (STTextHorzOverflowType) POIXMLTypeLoader.parse(node, STTextHorzOverflowType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
