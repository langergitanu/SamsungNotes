package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface STFldCharType extends XmlString {
    public static final int INT_BEGIN = 1;
    public static final int INT_END = 3;
    public static final int INT_SEPARATE = 2;
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STFldCharType.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "stfldchartype1eb4type");
    public static final Enum BEGIN = Enum.forString("begin");
    public static final Enum SEPARATE = Enum.forString("separate");
    public static final Enum END = Enum.forString("end");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BEGIN = 1;
        static final int INT_END = 3;
        static final int INT_SEPARATE = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("begin", 1), new Enum("separate", 2), new Enum("end", 3)});

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

        public static STFldCharType newInstance() {
            return (STFldCharType) POIXMLTypeLoader.newInstance(STFldCharType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STFldCharType.type, null);
        }

        public static STFldCharType newValue(Object obj) {
            return (STFldCharType) STFldCharType.type.newValue(obj);
        }

        public static STFldCharType parse(File file) {
            return (STFldCharType) POIXMLTypeLoader.parse(file, STFldCharType.type, (XmlOptions) null);
        }

        public static STFldCharType newInstance(XmlOptions xmlOptions) {
            return (STFldCharType) POIXMLTypeLoader.newInstance(STFldCharType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STFldCharType.type, xmlOptions);
        }

        public static STFldCharType parse(File file, XmlOptions xmlOptions) {
            return (STFldCharType) POIXMLTypeLoader.parse(file, STFldCharType.type, xmlOptions);
        }

        public static STFldCharType parse(InputStream inputStream) {
            return (STFldCharType) POIXMLTypeLoader.parse(inputStream, STFldCharType.type, (XmlOptions) null);
        }

        public static STFldCharType parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STFldCharType) POIXMLTypeLoader.parse(inputStream, STFldCharType.type, xmlOptions);
        }

        public static STFldCharType parse(Reader reader) {
            return (STFldCharType) POIXMLTypeLoader.parse(reader, STFldCharType.type, (XmlOptions) null);
        }

        public static STFldCharType parse(Reader reader, XmlOptions xmlOptions) {
            return (STFldCharType) POIXMLTypeLoader.parse(reader, STFldCharType.type, xmlOptions);
        }

        public static STFldCharType parse(String str) {
            return (STFldCharType) POIXMLTypeLoader.parse(str, STFldCharType.type, (XmlOptions) null);
        }

        public static STFldCharType parse(String str, XmlOptions xmlOptions) {
            return (STFldCharType) POIXMLTypeLoader.parse(str, STFldCharType.type, xmlOptions);
        }

        public static STFldCharType parse(URL url) {
            return (STFldCharType) POIXMLTypeLoader.parse(url, STFldCharType.type, (XmlOptions) null);
        }

        public static STFldCharType parse(URL url, XmlOptions xmlOptions) {
            return (STFldCharType) POIXMLTypeLoader.parse(url, STFldCharType.type, xmlOptions);
        }

        public static STFldCharType parse(XMLStreamReader xMLStreamReader) {
            return (STFldCharType) POIXMLTypeLoader.parse(xMLStreamReader, STFldCharType.type, (XmlOptions) null);
        }

        public static STFldCharType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STFldCharType) POIXMLTypeLoader.parse(xMLStreamReader, STFldCharType.type, xmlOptions);
        }

        public static STFldCharType parse(XMLInputStream xMLInputStream) {
            return (STFldCharType) POIXMLTypeLoader.parse(xMLInputStream, STFldCharType.type, (XmlOptions) null);
        }

        public static STFldCharType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STFldCharType) POIXMLTypeLoader.parse(xMLInputStream, STFldCharType.type, xmlOptions);
        }

        public static STFldCharType parse(Node node) {
            return (STFldCharType) POIXMLTypeLoader.parse(node, STFldCharType.type, (XmlOptions) null);
        }

        public static STFldCharType parse(Node node, XmlOptions xmlOptions) {
            return (STFldCharType) POIXMLTypeLoader.parse(node, STFldCharType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
