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
public interface STMultiLevelType extends XmlString {
    public static final int INT_HYBRID_MULTILEVEL = 3;
    public static final int INT_MULTILEVEL = 2;
    public static final int INT_SINGLE_LEVEL = 1;
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STMultiLevelType.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "stmultileveltypebc13type");
    public static final Enum SINGLE_LEVEL = Enum.forString("singleLevel");
    public static final Enum MULTILEVEL = Enum.forString("multilevel");
    public static final Enum HYBRID_MULTILEVEL = Enum.forString("hybridMultilevel");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_HYBRID_MULTILEVEL = 3;
        static final int INT_MULTILEVEL = 2;
        static final int INT_SINGLE_LEVEL = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("singleLevel", 1), new Enum("multilevel", 2), new Enum("hybridMultilevel", 3)});

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

        public static STMultiLevelType newInstance() {
            return (STMultiLevelType) POIXMLTypeLoader.newInstance(STMultiLevelType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STMultiLevelType.type, null);
        }

        public static STMultiLevelType newValue(Object obj) {
            return (STMultiLevelType) STMultiLevelType.type.newValue(obj);
        }

        public static STMultiLevelType parse(File file) {
            return (STMultiLevelType) POIXMLTypeLoader.parse(file, STMultiLevelType.type, (XmlOptions) null);
        }

        public static STMultiLevelType newInstance(XmlOptions xmlOptions) {
            return (STMultiLevelType) POIXMLTypeLoader.newInstance(STMultiLevelType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STMultiLevelType.type, xmlOptions);
        }

        public static STMultiLevelType parse(File file, XmlOptions xmlOptions) {
            return (STMultiLevelType) POIXMLTypeLoader.parse(file, STMultiLevelType.type, xmlOptions);
        }

        public static STMultiLevelType parse(InputStream inputStream) {
            return (STMultiLevelType) POIXMLTypeLoader.parse(inputStream, STMultiLevelType.type, (XmlOptions) null);
        }

        public static STMultiLevelType parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STMultiLevelType) POIXMLTypeLoader.parse(inputStream, STMultiLevelType.type, xmlOptions);
        }

        public static STMultiLevelType parse(Reader reader) {
            return (STMultiLevelType) POIXMLTypeLoader.parse(reader, STMultiLevelType.type, (XmlOptions) null);
        }

        public static STMultiLevelType parse(Reader reader, XmlOptions xmlOptions) {
            return (STMultiLevelType) POIXMLTypeLoader.parse(reader, STMultiLevelType.type, xmlOptions);
        }

        public static STMultiLevelType parse(String str) {
            return (STMultiLevelType) POIXMLTypeLoader.parse(str, STMultiLevelType.type, (XmlOptions) null);
        }

        public static STMultiLevelType parse(String str, XmlOptions xmlOptions) {
            return (STMultiLevelType) POIXMLTypeLoader.parse(str, STMultiLevelType.type, xmlOptions);
        }

        public static STMultiLevelType parse(URL url) {
            return (STMultiLevelType) POIXMLTypeLoader.parse(url, STMultiLevelType.type, (XmlOptions) null);
        }

        public static STMultiLevelType parse(URL url, XmlOptions xmlOptions) {
            return (STMultiLevelType) POIXMLTypeLoader.parse(url, STMultiLevelType.type, xmlOptions);
        }

        public static STMultiLevelType parse(XMLStreamReader xMLStreamReader) {
            return (STMultiLevelType) POIXMLTypeLoader.parse(xMLStreamReader, STMultiLevelType.type, (XmlOptions) null);
        }

        public static STMultiLevelType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STMultiLevelType) POIXMLTypeLoader.parse(xMLStreamReader, STMultiLevelType.type, xmlOptions);
        }

        public static STMultiLevelType parse(XMLInputStream xMLInputStream) {
            return (STMultiLevelType) POIXMLTypeLoader.parse(xMLInputStream, STMultiLevelType.type, (XmlOptions) null);
        }

        public static STMultiLevelType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STMultiLevelType) POIXMLTypeLoader.parse(xMLInputStream, STMultiLevelType.type, xmlOptions);
        }

        public static STMultiLevelType parse(Node node) {
            return (STMultiLevelType) POIXMLTypeLoader.parse(node, STMultiLevelType.type, (XmlOptions) null);
        }

        public static STMultiLevelType parse(Node node, XmlOptions xmlOptions) {
            return (STMultiLevelType) POIXMLTypeLoader.parse(node, STMultiLevelType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
