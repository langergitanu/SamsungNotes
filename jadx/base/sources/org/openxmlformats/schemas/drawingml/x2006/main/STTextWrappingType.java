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
public interface STTextWrappingType extends XmlToken {
    public static final int INT_NONE = 1;
    public static final int INT_SQUARE = 2;
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STTextWrappingType.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "sttextwrappingtype4b4etype");
    public static final Enum NONE = Enum.forString("none");
    public static final Enum SQUARE = Enum.forString("square");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_NONE = 1;
        static final int INT_SQUARE = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("square", 2)});

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

        public static STTextWrappingType newInstance() {
            return (STTextWrappingType) POIXMLTypeLoader.newInstance(STTextWrappingType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextWrappingType.type, null);
        }

        public static STTextWrappingType newValue(Object obj) {
            return (STTextWrappingType) STTextWrappingType.type.newValue(obj);
        }

        public static STTextWrappingType parse(File file) {
            return (STTextWrappingType) POIXMLTypeLoader.parse(file, STTextWrappingType.type, (XmlOptions) null);
        }

        public static STTextWrappingType newInstance(XmlOptions xmlOptions) {
            return (STTextWrappingType) POIXMLTypeLoader.newInstance(STTextWrappingType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextWrappingType.type, xmlOptions);
        }

        public static STTextWrappingType parse(File file, XmlOptions xmlOptions) {
            return (STTextWrappingType) POIXMLTypeLoader.parse(file, STTextWrappingType.type, xmlOptions);
        }

        public static STTextWrappingType parse(InputStream inputStream) {
            return (STTextWrappingType) POIXMLTypeLoader.parse(inputStream, STTextWrappingType.type, (XmlOptions) null);
        }

        public static STTextWrappingType parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STTextWrappingType) POIXMLTypeLoader.parse(inputStream, STTextWrappingType.type, xmlOptions);
        }

        public static STTextWrappingType parse(Reader reader) {
            return (STTextWrappingType) POIXMLTypeLoader.parse(reader, STTextWrappingType.type, (XmlOptions) null);
        }

        public static STTextWrappingType parse(Reader reader, XmlOptions xmlOptions) {
            return (STTextWrappingType) POIXMLTypeLoader.parse(reader, STTextWrappingType.type, xmlOptions);
        }

        public static STTextWrappingType parse(String str) {
            return (STTextWrappingType) POIXMLTypeLoader.parse(str, STTextWrappingType.type, (XmlOptions) null);
        }

        public static STTextWrappingType parse(String str, XmlOptions xmlOptions) {
            return (STTextWrappingType) POIXMLTypeLoader.parse(str, STTextWrappingType.type, xmlOptions);
        }

        public static STTextWrappingType parse(URL url) {
            return (STTextWrappingType) POIXMLTypeLoader.parse(url, STTextWrappingType.type, (XmlOptions) null);
        }

        public static STTextWrappingType parse(URL url, XmlOptions xmlOptions) {
            return (STTextWrappingType) POIXMLTypeLoader.parse(url, STTextWrappingType.type, xmlOptions);
        }

        public static STTextWrappingType parse(XMLStreamReader xMLStreamReader) {
            return (STTextWrappingType) POIXMLTypeLoader.parse(xMLStreamReader, STTextWrappingType.type, (XmlOptions) null);
        }

        public static STTextWrappingType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STTextWrappingType) POIXMLTypeLoader.parse(xMLStreamReader, STTextWrappingType.type, xmlOptions);
        }

        public static STTextWrappingType parse(XMLInputStream xMLInputStream) {
            return (STTextWrappingType) POIXMLTypeLoader.parse(xMLInputStream, STTextWrappingType.type, (XmlOptions) null);
        }

        public static STTextWrappingType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STTextWrappingType) POIXMLTypeLoader.parse(xMLInputStream, STTextWrappingType.type, xmlOptions);
        }

        public static STTextWrappingType parse(Node node) {
            return (STTextWrappingType) POIXMLTypeLoader.parse(node, STTextWrappingType.type, (XmlOptions) null);
        }

        public static STTextWrappingType parse(Node node, XmlOptions xmlOptions) {
            return (STTextWrappingType) POIXMLTypeLoader.parse(node, STTextWrappingType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
