package org.openxmlformats.schemas.presentationml.x2006.main;

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
public interface STTLTimeIndefinite extends XmlToken {
    public static final int INT_INDEFINITE = 1;
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STTLTimeIndefinite.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "sttltimeindefinite369btype");
    public static final Enum INDEFINITE = Enum.forString("indefinite");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_INDEFINITE = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("indefinite", 1)});

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

        public static STTLTimeIndefinite newInstance() {
            return (STTLTimeIndefinite) POIXMLTypeLoader.newInstance(STTLTimeIndefinite.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTLTimeIndefinite.type, null);
        }

        public static STTLTimeIndefinite newValue(Object obj) {
            return (STTLTimeIndefinite) STTLTimeIndefinite.type.newValue(obj);
        }

        public static STTLTimeIndefinite parse(File file) {
            return (STTLTimeIndefinite) POIXMLTypeLoader.parse(file, STTLTimeIndefinite.type, (XmlOptions) null);
        }

        public static STTLTimeIndefinite newInstance(XmlOptions xmlOptions) {
            return (STTLTimeIndefinite) POIXMLTypeLoader.newInstance(STTLTimeIndefinite.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTLTimeIndefinite.type, xmlOptions);
        }

        public static STTLTimeIndefinite parse(File file, XmlOptions xmlOptions) {
            return (STTLTimeIndefinite) POIXMLTypeLoader.parse(file, STTLTimeIndefinite.type, xmlOptions);
        }

        public static STTLTimeIndefinite parse(InputStream inputStream) {
            return (STTLTimeIndefinite) POIXMLTypeLoader.parse(inputStream, STTLTimeIndefinite.type, (XmlOptions) null);
        }

        public static STTLTimeIndefinite parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STTLTimeIndefinite) POIXMLTypeLoader.parse(inputStream, STTLTimeIndefinite.type, xmlOptions);
        }

        public static STTLTimeIndefinite parse(Reader reader) {
            return (STTLTimeIndefinite) POIXMLTypeLoader.parse(reader, STTLTimeIndefinite.type, (XmlOptions) null);
        }

        public static STTLTimeIndefinite parse(Reader reader, XmlOptions xmlOptions) {
            return (STTLTimeIndefinite) POIXMLTypeLoader.parse(reader, STTLTimeIndefinite.type, xmlOptions);
        }

        public static STTLTimeIndefinite parse(String str) {
            return (STTLTimeIndefinite) POIXMLTypeLoader.parse(str, STTLTimeIndefinite.type, (XmlOptions) null);
        }

        public static STTLTimeIndefinite parse(String str, XmlOptions xmlOptions) {
            return (STTLTimeIndefinite) POIXMLTypeLoader.parse(str, STTLTimeIndefinite.type, xmlOptions);
        }

        public static STTLTimeIndefinite parse(URL url) {
            return (STTLTimeIndefinite) POIXMLTypeLoader.parse(url, STTLTimeIndefinite.type, (XmlOptions) null);
        }

        public static STTLTimeIndefinite parse(URL url, XmlOptions xmlOptions) {
            return (STTLTimeIndefinite) POIXMLTypeLoader.parse(url, STTLTimeIndefinite.type, xmlOptions);
        }

        public static STTLTimeIndefinite parse(XMLStreamReader xMLStreamReader) {
            return (STTLTimeIndefinite) POIXMLTypeLoader.parse(xMLStreamReader, STTLTimeIndefinite.type, (XmlOptions) null);
        }

        public static STTLTimeIndefinite parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STTLTimeIndefinite) POIXMLTypeLoader.parse(xMLStreamReader, STTLTimeIndefinite.type, xmlOptions);
        }

        public static STTLTimeIndefinite parse(XMLInputStream xMLInputStream) {
            return (STTLTimeIndefinite) POIXMLTypeLoader.parse(xMLInputStream, STTLTimeIndefinite.type, (XmlOptions) null);
        }

        public static STTLTimeIndefinite parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STTLTimeIndefinite) POIXMLTypeLoader.parse(xMLInputStream, STTLTimeIndefinite.type, xmlOptions);
        }

        public static STTLTimeIndefinite parse(Node node) {
            return (STTLTimeIndefinite) POIXMLTypeLoader.parse(node, STTLTimeIndefinite.type, (XmlOptions) null);
        }

        public static STTLTimeIndefinite parse(Node node, XmlOptions xmlOptions) {
            return (STTLTimeIndefinite) POIXMLTypeLoader.parse(node, STTLTimeIndefinite.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
