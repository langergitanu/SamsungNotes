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
public interface STLineCap extends XmlToken {
    public static final int INT_FLAT = 3;
    public static final int INT_RND = 1;
    public static final int INT_SQ = 2;
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STLineCap.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "stlinecapcddftype");
    public static final Enum RND = Enum.forString("rnd");

    /* JADX INFO: renamed from: SQ */
    public static final Enum f10204SQ = Enum.forString("sq");
    public static final Enum FLAT = Enum.forString("flat");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_FLAT = 3;
        static final int INT_RND = 1;
        static final int INT_SQ = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("rnd", 1), new Enum("sq", 2), new Enum("flat", 3)});

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

        public static STLineCap newInstance() {
            return (STLineCap) POIXMLTypeLoader.newInstance(STLineCap.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STLineCap.type, null);
        }

        public static STLineCap newValue(Object obj) {
            return (STLineCap) STLineCap.type.newValue(obj);
        }

        public static STLineCap parse(File file) {
            return (STLineCap) POIXMLTypeLoader.parse(file, STLineCap.type, (XmlOptions) null);
        }

        public static STLineCap newInstance(XmlOptions xmlOptions) {
            return (STLineCap) POIXMLTypeLoader.newInstance(STLineCap.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STLineCap.type, xmlOptions);
        }

        public static STLineCap parse(File file, XmlOptions xmlOptions) {
            return (STLineCap) POIXMLTypeLoader.parse(file, STLineCap.type, xmlOptions);
        }

        public static STLineCap parse(InputStream inputStream) {
            return (STLineCap) POIXMLTypeLoader.parse(inputStream, STLineCap.type, (XmlOptions) null);
        }

        public static STLineCap parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STLineCap) POIXMLTypeLoader.parse(inputStream, STLineCap.type, xmlOptions);
        }

        public static STLineCap parse(Reader reader) {
            return (STLineCap) POIXMLTypeLoader.parse(reader, STLineCap.type, (XmlOptions) null);
        }

        public static STLineCap parse(Reader reader, XmlOptions xmlOptions) {
            return (STLineCap) POIXMLTypeLoader.parse(reader, STLineCap.type, xmlOptions);
        }

        public static STLineCap parse(String str) {
            return (STLineCap) POIXMLTypeLoader.parse(str, STLineCap.type, (XmlOptions) null);
        }

        public static STLineCap parse(String str, XmlOptions xmlOptions) {
            return (STLineCap) POIXMLTypeLoader.parse(str, STLineCap.type, xmlOptions);
        }

        public static STLineCap parse(URL url) {
            return (STLineCap) POIXMLTypeLoader.parse(url, STLineCap.type, (XmlOptions) null);
        }

        public static STLineCap parse(URL url, XmlOptions xmlOptions) {
            return (STLineCap) POIXMLTypeLoader.parse(url, STLineCap.type, xmlOptions);
        }

        public static STLineCap parse(XMLStreamReader xMLStreamReader) {
            return (STLineCap) POIXMLTypeLoader.parse(xMLStreamReader, STLineCap.type, (XmlOptions) null);
        }

        public static STLineCap parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STLineCap) POIXMLTypeLoader.parse(xMLStreamReader, STLineCap.type, xmlOptions);
        }

        public static STLineCap parse(XMLInputStream xMLInputStream) {
            return (STLineCap) POIXMLTypeLoader.parse(xMLInputStream, STLineCap.type, (XmlOptions) null);
        }

        public static STLineCap parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STLineCap) POIXMLTypeLoader.parse(xMLInputStream, STLineCap.type, xmlOptions);
        }

        public static STLineCap parse(Node node) {
            return (STLineCap) POIXMLTypeLoader.parse(node, STLineCap.type, (XmlOptions) null);
        }

        public static STLineCap parse(Node node, XmlOptions xmlOptions) {
            return (STLineCap) POIXMLTypeLoader.parse(node, STLineCap.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
