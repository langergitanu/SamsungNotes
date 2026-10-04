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
public interface STTextAlignType extends XmlToken {
    public static final int INT_CTR = 2;
    public static final int INT_DIST = 6;
    public static final int INT_JUST = 4;
    public static final int INT_JUST_LOW = 5;
    public static final int INT_L = 1;
    public static final int INT_R = 3;
    public static final int INT_THAI_DIST = 7;
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STTextAlignType.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "sttextaligntypebc93type");

    /* JADX INFO: renamed from: L */
    public static final Enum f10210L = Enum.forString("l");
    public static final Enum CTR = Enum.forString("ctr");

    /* JADX INFO: renamed from: R */
    public static final Enum f10211R = Enum.forString("r");
    public static final Enum JUST = Enum.forString("just");
    public static final Enum JUST_LOW = Enum.forString("justLow");
    public static final Enum DIST = Enum.forString("dist");
    public static final Enum THAI_DIST = Enum.forString("thaiDist");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CTR = 2;
        static final int INT_DIST = 6;
        static final int INT_JUST = 4;
        static final int INT_JUST_LOW = 5;
        static final int INT_L = 1;
        static final int INT_R = 3;
        static final int INT_THAI_DIST = 7;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("l", 1), new Enum("ctr", 2), new Enum("r", 3), new Enum("just", 4), new Enum("justLow", 5), new Enum("dist", 6), new Enum("thaiDist", 7)});

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

        public static STTextAlignType newInstance() {
            return (STTextAlignType) POIXMLTypeLoader.newInstance(STTextAlignType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextAlignType.type, null);
        }

        public static STTextAlignType newValue(Object obj) {
            return (STTextAlignType) STTextAlignType.type.newValue(obj);
        }

        public static STTextAlignType parse(File file) {
            return (STTextAlignType) POIXMLTypeLoader.parse(file, STTextAlignType.type, (XmlOptions) null);
        }

        public static STTextAlignType newInstance(XmlOptions xmlOptions) {
            return (STTextAlignType) POIXMLTypeLoader.newInstance(STTextAlignType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextAlignType.type, xmlOptions);
        }

        public static STTextAlignType parse(File file, XmlOptions xmlOptions) {
            return (STTextAlignType) POIXMLTypeLoader.parse(file, STTextAlignType.type, xmlOptions);
        }

        public static STTextAlignType parse(InputStream inputStream) {
            return (STTextAlignType) POIXMLTypeLoader.parse(inputStream, STTextAlignType.type, (XmlOptions) null);
        }

        public static STTextAlignType parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STTextAlignType) POIXMLTypeLoader.parse(inputStream, STTextAlignType.type, xmlOptions);
        }

        public static STTextAlignType parse(Reader reader) {
            return (STTextAlignType) POIXMLTypeLoader.parse(reader, STTextAlignType.type, (XmlOptions) null);
        }

        public static STTextAlignType parse(Reader reader, XmlOptions xmlOptions) {
            return (STTextAlignType) POIXMLTypeLoader.parse(reader, STTextAlignType.type, xmlOptions);
        }

        public static STTextAlignType parse(String str) {
            return (STTextAlignType) POIXMLTypeLoader.parse(str, STTextAlignType.type, (XmlOptions) null);
        }

        public static STTextAlignType parse(String str, XmlOptions xmlOptions) {
            return (STTextAlignType) POIXMLTypeLoader.parse(str, STTextAlignType.type, xmlOptions);
        }

        public static STTextAlignType parse(URL url) {
            return (STTextAlignType) POIXMLTypeLoader.parse(url, STTextAlignType.type, (XmlOptions) null);
        }

        public static STTextAlignType parse(URL url, XmlOptions xmlOptions) {
            return (STTextAlignType) POIXMLTypeLoader.parse(url, STTextAlignType.type, xmlOptions);
        }

        public static STTextAlignType parse(XMLStreamReader xMLStreamReader) {
            return (STTextAlignType) POIXMLTypeLoader.parse(xMLStreamReader, STTextAlignType.type, (XmlOptions) null);
        }

        public static STTextAlignType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STTextAlignType) POIXMLTypeLoader.parse(xMLStreamReader, STTextAlignType.type, xmlOptions);
        }

        public static STTextAlignType parse(XMLInputStream xMLInputStream) {
            return (STTextAlignType) POIXMLTypeLoader.parse(xMLInputStream, STTextAlignType.type, (XmlOptions) null);
        }

        public static STTextAlignType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STTextAlignType) POIXMLTypeLoader.parse(xMLInputStream, STTextAlignType.type, xmlOptions);
        }

        public static STTextAlignType parse(Node node) {
            return (STTextAlignType) POIXMLTypeLoader.parse(node, STTextAlignType.type, (XmlOptions) null);
        }

        public static STTextAlignType parse(Node node, XmlOptions xmlOptions) {
            return (STTextAlignType) POIXMLTypeLoader.parse(node, STTextAlignType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
