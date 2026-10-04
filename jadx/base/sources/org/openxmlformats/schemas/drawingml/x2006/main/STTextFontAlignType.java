package org.openxmlformats.schemas.drawingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import kotlinx.coroutines.DebugKt;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface STTextFontAlignType extends XmlToken {
    public static final int INT_AUTO = 1;
    public static final int INT_B = 5;
    public static final int INT_BASE = 4;
    public static final int INT_CTR = 3;
    public static final int INT_T = 2;
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STTextFontAlignType.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "sttextfontaligntypecb44type");
    public static final Enum AUTO = Enum.forString(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);

    /* JADX INFO: renamed from: T */
    public static final Enum f10215T = Enum.forString("t");
    public static final Enum CTR = Enum.forString("ctr");
    public static final Enum BASE = Enum.forString("base");

    /* JADX INFO: renamed from: B */
    public static final Enum f10214B = Enum.forString("b");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_AUTO = 1;
        static final int INT_B = 5;
        static final int INT_BASE = 4;
        static final int INT_CTR = 3;
        static final int INT_T = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, 1), new Enum("t", 2), new Enum("ctr", 3), new Enum("base", 4), new Enum("b", 5)});

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

        public static STTextFontAlignType newInstance() {
            return (STTextFontAlignType) POIXMLTypeLoader.newInstance(STTextFontAlignType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextFontAlignType.type, null);
        }

        public static STTextFontAlignType newValue(Object obj) {
            return (STTextFontAlignType) STTextFontAlignType.type.newValue(obj);
        }

        public static STTextFontAlignType parse(File file) {
            return (STTextFontAlignType) POIXMLTypeLoader.parse(file, STTextFontAlignType.type, (XmlOptions) null);
        }

        public static STTextFontAlignType newInstance(XmlOptions xmlOptions) {
            return (STTextFontAlignType) POIXMLTypeLoader.newInstance(STTextFontAlignType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextFontAlignType.type, xmlOptions);
        }

        public static STTextFontAlignType parse(File file, XmlOptions xmlOptions) {
            return (STTextFontAlignType) POIXMLTypeLoader.parse(file, STTextFontAlignType.type, xmlOptions);
        }

        public static STTextFontAlignType parse(InputStream inputStream) {
            return (STTextFontAlignType) POIXMLTypeLoader.parse(inputStream, STTextFontAlignType.type, (XmlOptions) null);
        }

        public static STTextFontAlignType parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STTextFontAlignType) POIXMLTypeLoader.parse(inputStream, STTextFontAlignType.type, xmlOptions);
        }

        public static STTextFontAlignType parse(Reader reader) {
            return (STTextFontAlignType) POIXMLTypeLoader.parse(reader, STTextFontAlignType.type, (XmlOptions) null);
        }

        public static STTextFontAlignType parse(Reader reader, XmlOptions xmlOptions) {
            return (STTextFontAlignType) POIXMLTypeLoader.parse(reader, STTextFontAlignType.type, xmlOptions);
        }

        public static STTextFontAlignType parse(String str) {
            return (STTextFontAlignType) POIXMLTypeLoader.parse(str, STTextFontAlignType.type, (XmlOptions) null);
        }

        public static STTextFontAlignType parse(String str, XmlOptions xmlOptions) {
            return (STTextFontAlignType) POIXMLTypeLoader.parse(str, STTextFontAlignType.type, xmlOptions);
        }

        public static STTextFontAlignType parse(URL url) {
            return (STTextFontAlignType) POIXMLTypeLoader.parse(url, STTextFontAlignType.type, (XmlOptions) null);
        }

        public static STTextFontAlignType parse(URL url, XmlOptions xmlOptions) {
            return (STTextFontAlignType) POIXMLTypeLoader.parse(url, STTextFontAlignType.type, xmlOptions);
        }

        public static STTextFontAlignType parse(XMLStreamReader xMLStreamReader) {
            return (STTextFontAlignType) POIXMLTypeLoader.parse(xMLStreamReader, STTextFontAlignType.type, (XmlOptions) null);
        }

        public static STTextFontAlignType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STTextFontAlignType) POIXMLTypeLoader.parse(xMLStreamReader, STTextFontAlignType.type, xmlOptions);
        }

        public static STTextFontAlignType parse(XMLInputStream xMLInputStream) {
            return (STTextFontAlignType) POIXMLTypeLoader.parse(xMLInputStream, STTextFontAlignType.type, (XmlOptions) null);
        }

        public static STTextFontAlignType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STTextFontAlignType) POIXMLTypeLoader.parse(xMLInputStream, STTextFontAlignType.type, xmlOptions);
        }

        public static STTextFontAlignType parse(Node node) {
            return (STTextFontAlignType) POIXMLTypeLoader.parse(node, STTextFontAlignType.type, (XmlOptions) null);
        }

        public static STTextFontAlignType parse(Node node, XmlOptions xmlOptions) {
            return (STTextFontAlignType) POIXMLTypeLoader.parse(node, STTextFontAlignType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
