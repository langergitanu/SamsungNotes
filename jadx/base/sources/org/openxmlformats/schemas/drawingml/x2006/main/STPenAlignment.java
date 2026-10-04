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
public interface STPenAlignment extends XmlToken {
    public static final int INT_CTR = 1;
    public static final int INT_IN = 2;
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STPenAlignment.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "stpenalignmentd775type");
    public static final Enum CTR = Enum.forString("ctr");

    /* JADX INFO: renamed from: IN */
    public static final Enum f10209IN = Enum.forString("in");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CTR = 1;
        static final int INT_IN = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("ctr", 1), new Enum("in", 2)});

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

        public static STPenAlignment newInstance() {
            return (STPenAlignment) POIXMLTypeLoader.newInstance(STPenAlignment.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STPenAlignment.type, null);
        }

        public static STPenAlignment newValue(Object obj) {
            return (STPenAlignment) STPenAlignment.type.newValue(obj);
        }

        public static STPenAlignment parse(File file) {
            return (STPenAlignment) POIXMLTypeLoader.parse(file, STPenAlignment.type, (XmlOptions) null);
        }

        public static STPenAlignment newInstance(XmlOptions xmlOptions) {
            return (STPenAlignment) POIXMLTypeLoader.newInstance(STPenAlignment.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STPenAlignment.type, xmlOptions);
        }

        public static STPenAlignment parse(File file, XmlOptions xmlOptions) {
            return (STPenAlignment) POIXMLTypeLoader.parse(file, STPenAlignment.type, xmlOptions);
        }

        public static STPenAlignment parse(InputStream inputStream) {
            return (STPenAlignment) POIXMLTypeLoader.parse(inputStream, STPenAlignment.type, (XmlOptions) null);
        }

        public static STPenAlignment parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STPenAlignment) POIXMLTypeLoader.parse(inputStream, STPenAlignment.type, xmlOptions);
        }

        public static STPenAlignment parse(Reader reader) {
            return (STPenAlignment) POIXMLTypeLoader.parse(reader, STPenAlignment.type, (XmlOptions) null);
        }

        public static STPenAlignment parse(Reader reader, XmlOptions xmlOptions) {
            return (STPenAlignment) POIXMLTypeLoader.parse(reader, STPenAlignment.type, xmlOptions);
        }

        public static STPenAlignment parse(String str) {
            return (STPenAlignment) POIXMLTypeLoader.parse(str, STPenAlignment.type, (XmlOptions) null);
        }

        public static STPenAlignment parse(String str, XmlOptions xmlOptions) {
            return (STPenAlignment) POIXMLTypeLoader.parse(str, STPenAlignment.type, xmlOptions);
        }

        public static STPenAlignment parse(URL url) {
            return (STPenAlignment) POIXMLTypeLoader.parse(url, STPenAlignment.type, (XmlOptions) null);
        }

        public static STPenAlignment parse(URL url, XmlOptions xmlOptions) {
            return (STPenAlignment) POIXMLTypeLoader.parse(url, STPenAlignment.type, xmlOptions);
        }

        public static STPenAlignment parse(XMLStreamReader xMLStreamReader) {
            return (STPenAlignment) POIXMLTypeLoader.parse(xMLStreamReader, STPenAlignment.type, (XmlOptions) null);
        }

        public static STPenAlignment parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STPenAlignment) POIXMLTypeLoader.parse(xMLStreamReader, STPenAlignment.type, xmlOptions);
        }

        public static STPenAlignment parse(XMLInputStream xMLInputStream) {
            return (STPenAlignment) POIXMLTypeLoader.parse(xMLInputStream, STPenAlignment.type, (XmlOptions) null);
        }

        public static STPenAlignment parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STPenAlignment) POIXMLTypeLoader.parse(xMLInputStream, STPenAlignment.type, xmlOptions);
        }

        public static STPenAlignment parse(Node node) {
            return (STPenAlignment) POIXMLTypeLoader.parse(node, STPenAlignment.type, (XmlOptions) null);
        }

        public static STPenAlignment parse(Node node, XmlOptions xmlOptions) {
            return (STPenAlignment) POIXMLTypeLoader.parse(node, STPenAlignment.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
