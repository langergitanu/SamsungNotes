package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface STLineSpacingRule extends XmlString {
    public static final int INT_AT_LEAST = 3;
    public static final int INT_AUTO = 1;
    public static final int INT_EXACT = 2;
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STLineSpacingRule.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "stlinespacingrule6237type");
    public static final Enum AUTO = Enum.forString(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
    public static final Enum EXACT = Enum.forString("exact");
    public static final Enum AT_LEAST = Enum.forString("atLeast");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_AT_LEAST = 3;
        static final int INT_AUTO = 1;
        static final int INT_EXACT = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, 1), new Enum("exact", 2), new Enum("atLeast", 3)});

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

        public static STLineSpacingRule newInstance() {
            return (STLineSpacingRule) POIXMLTypeLoader.newInstance(STLineSpacingRule.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STLineSpacingRule.type, null);
        }

        public static STLineSpacingRule newValue(Object obj) {
            return (STLineSpacingRule) STLineSpacingRule.type.newValue(obj);
        }

        public static STLineSpacingRule parse(File file) {
            return (STLineSpacingRule) POIXMLTypeLoader.parse(file, STLineSpacingRule.type, (XmlOptions) null);
        }

        public static STLineSpacingRule newInstance(XmlOptions xmlOptions) {
            return (STLineSpacingRule) POIXMLTypeLoader.newInstance(STLineSpacingRule.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STLineSpacingRule.type, xmlOptions);
        }

        public static STLineSpacingRule parse(File file, XmlOptions xmlOptions) {
            return (STLineSpacingRule) POIXMLTypeLoader.parse(file, STLineSpacingRule.type, xmlOptions);
        }

        public static STLineSpacingRule parse(InputStream inputStream) {
            return (STLineSpacingRule) POIXMLTypeLoader.parse(inputStream, STLineSpacingRule.type, (XmlOptions) null);
        }

        public static STLineSpacingRule parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STLineSpacingRule) POIXMLTypeLoader.parse(inputStream, STLineSpacingRule.type, xmlOptions);
        }

        public static STLineSpacingRule parse(Reader reader) {
            return (STLineSpacingRule) POIXMLTypeLoader.parse(reader, STLineSpacingRule.type, (XmlOptions) null);
        }

        public static STLineSpacingRule parse(Reader reader, XmlOptions xmlOptions) {
            return (STLineSpacingRule) POIXMLTypeLoader.parse(reader, STLineSpacingRule.type, xmlOptions);
        }

        public static STLineSpacingRule parse(String str) {
            return (STLineSpacingRule) POIXMLTypeLoader.parse(str, STLineSpacingRule.type, (XmlOptions) null);
        }

        public static STLineSpacingRule parse(String str, XmlOptions xmlOptions) {
            return (STLineSpacingRule) POIXMLTypeLoader.parse(str, STLineSpacingRule.type, xmlOptions);
        }

        public static STLineSpacingRule parse(URL url) {
            return (STLineSpacingRule) POIXMLTypeLoader.parse(url, STLineSpacingRule.type, (XmlOptions) null);
        }

        public static STLineSpacingRule parse(URL url, XmlOptions xmlOptions) {
            return (STLineSpacingRule) POIXMLTypeLoader.parse(url, STLineSpacingRule.type, xmlOptions);
        }

        public static STLineSpacingRule parse(XMLStreamReader xMLStreamReader) {
            return (STLineSpacingRule) POIXMLTypeLoader.parse(xMLStreamReader, STLineSpacingRule.type, (XmlOptions) null);
        }

        public static STLineSpacingRule parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STLineSpacingRule) POIXMLTypeLoader.parse(xMLStreamReader, STLineSpacingRule.type, xmlOptions);
        }

        public static STLineSpacingRule parse(XMLInputStream xMLInputStream) {
            return (STLineSpacingRule) POIXMLTypeLoader.parse(xMLInputStream, STLineSpacingRule.type, (XmlOptions) null);
        }

        public static STLineSpacingRule parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STLineSpacingRule) POIXMLTypeLoader.parse(xMLInputStream, STLineSpacingRule.type, xmlOptions);
        }

        public static STLineSpacingRule parse(Node node) {
            return (STLineSpacingRule) POIXMLTypeLoader.parse(node, STLineSpacingRule.type, (XmlOptions) null);
        }

        public static STLineSpacingRule parse(Node node, XmlOptions xmlOptions) {
            return (STLineSpacingRule) POIXMLTypeLoader.parse(node, STLineSpacingRule.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
