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
public interface STColorSchemeIndex extends XmlToken {
    public static final int INT_ACCENT_1 = 5;
    public static final int INT_ACCENT_2 = 6;
    public static final int INT_ACCENT_3 = 7;
    public static final int INT_ACCENT_4 = 8;
    public static final int INT_ACCENT_5 = 9;
    public static final int INT_ACCENT_6 = 10;
    public static final int INT_DK_1 = 1;
    public static final int INT_DK_2 = 3;
    public static final int INT_FOL_HLINK = 12;
    public static final int INT_HLINK = 11;
    public static final int INT_LT_1 = 2;
    public static final int INT_LT_2 = 4;
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STColorSchemeIndex.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "stcolorschemeindexe6f5type");
    public static final Enum DK_1 = Enum.forString("dk1");
    public static final Enum LT_1 = Enum.forString("lt1");
    public static final Enum DK_2 = Enum.forString("dk2");
    public static final Enum LT_2 = Enum.forString("lt2");
    public static final Enum ACCENT_1 = Enum.forString("accent1");
    public static final Enum ACCENT_2 = Enum.forString("accent2");
    public static final Enum ACCENT_3 = Enum.forString("accent3");
    public static final Enum ACCENT_4 = Enum.forString("accent4");
    public static final Enum ACCENT_5 = Enum.forString("accent5");
    public static final Enum ACCENT_6 = Enum.forString("accent6");
    public static final Enum HLINK = Enum.forString("hlink");
    public static final Enum FOL_HLINK = Enum.forString("folHlink");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_ACCENT_1 = 5;
        static final int INT_ACCENT_2 = 6;
        static final int INT_ACCENT_3 = 7;
        static final int INT_ACCENT_4 = 8;
        static final int INT_ACCENT_5 = 9;
        static final int INT_ACCENT_6 = 10;
        static final int INT_DK_1 = 1;
        static final int INT_DK_2 = 3;
        static final int INT_FOL_HLINK = 12;
        static final int INT_HLINK = 11;
        static final int INT_LT_1 = 2;
        static final int INT_LT_2 = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("dk1", 1), new Enum("lt1", 2), new Enum("dk2", 3), new Enum("lt2", 4), new Enum("accent1", 5), new Enum("accent2", 6), new Enum("accent3", 7), new Enum("accent4", 8), new Enum("accent5", 9), new Enum("accent6", 10), new Enum("hlink", 11), new Enum("folHlink", 12)});

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

        public static STColorSchemeIndex newInstance() {
            return (STColorSchemeIndex) POIXMLTypeLoader.newInstance(STColorSchemeIndex.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STColorSchemeIndex.type, null);
        }

        public static STColorSchemeIndex newValue(Object obj) {
            return (STColorSchemeIndex) STColorSchemeIndex.type.newValue(obj);
        }

        public static STColorSchemeIndex parse(File file) {
            return (STColorSchemeIndex) POIXMLTypeLoader.parse(file, STColorSchemeIndex.type, (XmlOptions) null);
        }

        public static STColorSchemeIndex newInstance(XmlOptions xmlOptions) {
            return (STColorSchemeIndex) POIXMLTypeLoader.newInstance(STColorSchemeIndex.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STColorSchemeIndex.type, xmlOptions);
        }

        public static STColorSchemeIndex parse(File file, XmlOptions xmlOptions) {
            return (STColorSchemeIndex) POIXMLTypeLoader.parse(file, STColorSchemeIndex.type, xmlOptions);
        }

        public static STColorSchemeIndex parse(InputStream inputStream) {
            return (STColorSchemeIndex) POIXMLTypeLoader.parse(inputStream, STColorSchemeIndex.type, (XmlOptions) null);
        }

        public static STColorSchemeIndex parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STColorSchemeIndex) POIXMLTypeLoader.parse(inputStream, STColorSchemeIndex.type, xmlOptions);
        }

        public static STColorSchemeIndex parse(Reader reader) {
            return (STColorSchemeIndex) POIXMLTypeLoader.parse(reader, STColorSchemeIndex.type, (XmlOptions) null);
        }

        public static STColorSchemeIndex parse(Reader reader, XmlOptions xmlOptions) {
            return (STColorSchemeIndex) POIXMLTypeLoader.parse(reader, STColorSchemeIndex.type, xmlOptions);
        }

        public static STColorSchemeIndex parse(String str) {
            return (STColorSchemeIndex) POIXMLTypeLoader.parse(str, STColorSchemeIndex.type, (XmlOptions) null);
        }

        public static STColorSchemeIndex parse(String str, XmlOptions xmlOptions) {
            return (STColorSchemeIndex) POIXMLTypeLoader.parse(str, STColorSchemeIndex.type, xmlOptions);
        }

        public static STColorSchemeIndex parse(URL url) {
            return (STColorSchemeIndex) POIXMLTypeLoader.parse(url, STColorSchemeIndex.type, (XmlOptions) null);
        }

        public static STColorSchemeIndex parse(URL url, XmlOptions xmlOptions) {
            return (STColorSchemeIndex) POIXMLTypeLoader.parse(url, STColorSchemeIndex.type, xmlOptions);
        }

        public static STColorSchemeIndex parse(XMLStreamReader xMLStreamReader) {
            return (STColorSchemeIndex) POIXMLTypeLoader.parse(xMLStreamReader, STColorSchemeIndex.type, (XmlOptions) null);
        }

        public static STColorSchemeIndex parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STColorSchemeIndex) POIXMLTypeLoader.parse(xMLStreamReader, STColorSchemeIndex.type, xmlOptions);
        }

        public static STColorSchemeIndex parse(XMLInputStream xMLInputStream) {
            return (STColorSchemeIndex) POIXMLTypeLoader.parse(xMLInputStream, STColorSchemeIndex.type, (XmlOptions) null);
        }

        public static STColorSchemeIndex parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STColorSchemeIndex) POIXMLTypeLoader.parse(xMLInputStream, STColorSchemeIndex.type, xmlOptions);
        }

        public static STColorSchemeIndex parse(Node node) {
            return (STColorSchemeIndex) POIXMLTypeLoader.parse(node, STColorSchemeIndex.type, (XmlOptions) null);
        }

        public static STColorSchemeIndex parse(Node node, XmlOptions xmlOptions) {
            return (STColorSchemeIndex) POIXMLTypeLoader.parse(node, STColorSchemeIndex.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
