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
public interface STTextCapsType extends XmlToken {
    public static final int INT_ALL = 3;
    public static final int INT_NONE = 1;
    public static final int INT_SMALL = 2;
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STTextCapsType.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "sttextcapstyped233type");
    public static final Enum NONE = Enum.forString("none");
    public static final Enum SMALL = Enum.forString("small");
    public static final Enum ALL = Enum.forString("all");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_ALL = 3;
        static final int INT_NONE = 1;
        static final int INT_SMALL = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("none", 1), new Enum("small", 2), new Enum("all", 3)});

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

        public static STTextCapsType newInstance() {
            return (STTextCapsType) POIXMLTypeLoader.newInstance(STTextCapsType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextCapsType.type, null);
        }

        public static STTextCapsType newValue(Object obj) {
            return (STTextCapsType) STTextCapsType.type.newValue(obj);
        }

        public static STTextCapsType parse(File file) {
            return (STTextCapsType) POIXMLTypeLoader.parse(file, STTextCapsType.type, (XmlOptions) null);
        }

        public static STTextCapsType newInstance(XmlOptions xmlOptions) {
            return (STTextCapsType) POIXMLTypeLoader.newInstance(STTextCapsType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextCapsType.type, xmlOptions);
        }

        public static STTextCapsType parse(File file, XmlOptions xmlOptions) {
            return (STTextCapsType) POIXMLTypeLoader.parse(file, STTextCapsType.type, xmlOptions);
        }

        public static STTextCapsType parse(InputStream inputStream) {
            return (STTextCapsType) POIXMLTypeLoader.parse(inputStream, STTextCapsType.type, (XmlOptions) null);
        }

        public static STTextCapsType parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STTextCapsType) POIXMLTypeLoader.parse(inputStream, STTextCapsType.type, xmlOptions);
        }

        public static STTextCapsType parse(Reader reader) {
            return (STTextCapsType) POIXMLTypeLoader.parse(reader, STTextCapsType.type, (XmlOptions) null);
        }

        public static STTextCapsType parse(Reader reader, XmlOptions xmlOptions) {
            return (STTextCapsType) POIXMLTypeLoader.parse(reader, STTextCapsType.type, xmlOptions);
        }

        public static STTextCapsType parse(String str) {
            return (STTextCapsType) POIXMLTypeLoader.parse(str, STTextCapsType.type, (XmlOptions) null);
        }

        public static STTextCapsType parse(String str, XmlOptions xmlOptions) {
            return (STTextCapsType) POIXMLTypeLoader.parse(str, STTextCapsType.type, xmlOptions);
        }

        public static STTextCapsType parse(URL url) {
            return (STTextCapsType) POIXMLTypeLoader.parse(url, STTextCapsType.type, (XmlOptions) null);
        }

        public static STTextCapsType parse(URL url, XmlOptions xmlOptions) {
            return (STTextCapsType) POIXMLTypeLoader.parse(url, STTextCapsType.type, xmlOptions);
        }

        public static STTextCapsType parse(XMLStreamReader xMLStreamReader) {
            return (STTextCapsType) POIXMLTypeLoader.parse(xMLStreamReader, STTextCapsType.type, (XmlOptions) null);
        }

        public static STTextCapsType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STTextCapsType) POIXMLTypeLoader.parse(xMLStreamReader, STTextCapsType.type, xmlOptions);
        }

        public static STTextCapsType parse(XMLInputStream xMLInputStream) {
            return (STTextCapsType) POIXMLTypeLoader.parse(xMLInputStream, STTextCapsType.type, (XmlOptions) null);
        }

        public static STTextCapsType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STTextCapsType) POIXMLTypeLoader.parse(xMLInputStream, STTextCapsType.type, xmlOptions);
        }

        public static STTextCapsType parse(Node node) {
            return (STTextCapsType) POIXMLTypeLoader.parse(node, STTextCapsType.type, (XmlOptions) null);
        }

        public static STTextCapsType parse(Node node, XmlOptions xmlOptions) {
            return (STTextCapsType) POIXMLTypeLoader.parse(node, STTextCapsType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
