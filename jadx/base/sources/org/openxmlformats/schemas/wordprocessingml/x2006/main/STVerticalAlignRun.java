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
public interface STVerticalAlignRun extends XmlString {
    public static final int INT_BASELINE = 1;
    public static final int INT_SUBSCRIPT = 3;
    public static final int INT_SUPERSCRIPT = 2;
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STVerticalAlignRun.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "stverticalalignrun297ctype");
    public static final Enum BASELINE = Enum.forString("baseline");
    public static final Enum SUPERSCRIPT = Enum.forString("superscript");
    public static final Enum SUBSCRIPT = Enum.forString("subscript");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_BASELINE = 1;
        static final int INT_SUBSCRIPT = 3;
        static final int INT_SUPERSCRIPT = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("baseline", 1), new Enum("superscript", 2), new Enum("subscript", 3)});

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

        public static STVerticalAlignRun newInstance() {
            return (STVerticalAlignRun) POIXMLTypeLoader.newInstance(STVerticalAlignRun.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STVerticalAlignRun.type, null);
        }

        public static STVerticalAlignRun newValue(Object obj) {
            return (STVerticalAlignRun) STVerticalAlignRun.type.newValue(obj);
        }

        public static STVerticalAlignRun parse(File file) {
            return (STVerticalAlignRun) POIXMLTypeLoader.parse(file, STVerticalAlignRun.type, (XmlOptions) null);
        }

        public static STVerticalAlignRun newInstance(XmlOptions xmlOptions) {
            return (STVerticalAlignRun) POIXMLTypeLoader.newInstance(STVerticalAlignRun.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STVerticalAlignRun.type, xmlOptions);
        }

        public static STVerticalAlignRun parse(File file, XmlOptions xmlOptions) {
            return (STVerticalAlignRun) POIXMLTypeLoader.parse(file, STVerticalAlignRun.type, xmlOptions);
        }

        public static STVerticalAlignRun parse(InputStream inputStream) {
            return (STVerticalAlignRun) POIXMLTypeLoader.parse(inputStream, STVerticalAlignRun.type, (XmlOptions) null);
        }

        public static STVerticalAlignRun parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STVerticalAlignRun) POIXMLTypeLoader.parse(inputStream, STVerticalAlignRun.type, xmlOptions);
        }

        public static STVerticalAlignRun parse(Reader reader) {
            return (STVerticalAlignRun) POIXMLTypeLoader.parse(reader, STVerticalAlignRun.type, (XmlOptions) null);
        }

        public static STVerticalAlignRun parse(Reader reader, XmlOptions xmlOptions) {
            return (STVerticalAlignRun) POIXMLTypeLoader.parse(reader, STVerticalAlignRun.type, xmlOptions);
        }

        public static STVerticalAlignRun parse(String str) {
            return (STVerticalAlignRun) POIXMLTypeLoader.parse(str, STVerticalAlignRun.type, (XmlOptions) null);
        }

        public static STVerticalAlignRun parse(String str, XmlOptions xmlOptions) {
            return (STVerticalAlignRun) POIXMLTypeLoader.parse(str, STVerticalAlignRun.type, xmlOptions);
        }

        public static STVerticalAlignRun parse(URL url) {
            return (STVerticalAlignRun) POIXMLTypeLoader.parse(url, STVerticalAlignRun.type, (XmlOptions) null);
        }

        public static STVerticalAlignRun parse(URL url, XmlOptions xmlOptions) {
            return (STVerticalAlignRun) POIXMLTypeLoader.parse(url, STVerticalAlignRun.type, xmlOptions);
        }

        public static STVerticalAlignRun parse(XMLStreamReader xMLStreamReader) {
            return (STVerticalAlignRun) POIXMLTypeLoader.parse(xMLStreamReader, STVerticalAlignRun.type, (XmlOptions) null);
        }

        public static STVerticalAlignRun parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STVerticalAlignRun) POIXMLTypeLoader.parse(xMLStreamReader, STVerticalAlignRun.type, xmlOptions);
        }

        public static STVerticalAlignRun parse(XMLInputStream xMLInputStream) {
            return (STVerticalAlignRun) POIXMLTypeLoader.parse(xMLInputStream, STVerticalAlignRun.type, (XmlOptions) null);
        }

        public static STVerticalAlignRun parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STVerticalAlignRun) POIXMLTypeLoader.parse(xMLInputStream, STVerticalAlignRun.type, xmlOptions);
        }

        public static STVerticalAlignRun parse(Node node) {
            return (STVerticalAlignRun) POIXMLTypeLoader.parse(node, STVerticalAlignRun.type, (XmlOptions) null);
        }

        public static STVerticalAlignRun parse(Node node, XmlOptions xmlOptions) {
            return (STVerticalAlignRun) POIXMLTypeLoader.parse(node, STVerticalAlignRun.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
