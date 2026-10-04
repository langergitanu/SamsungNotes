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
public interface STFontCollectionIndex extends XmlToken {
    public static final int INT_MAJOR = 1;
    public static final int INT_MINOR = 2;
    public static final int INT_NONE = 3;
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STFontCollectionIndex.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "stfontcollectionindex6766type");
    public static final Enum MAJOR = Enum.forString("major");
    public static final Enum MINOR = Enum.forString("minor");
    public static final Enum NONE = Enum.forString("none");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_MAJOR = 1;
        static final int INT_MINOR = 2;
        static final int INT_NONE = 3;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("major", 1), new Enum("minor", 2), new Enum("none", 3)});

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

        public static STFontCollectionIndex newInstance() {
            return (STFontCollectionIndex) POIXMLTypeLoader.newInstance(STFontCollectionIndex.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STFontCollectionIndex.type, null);
        }

        public static STFontCollectionIndex newValue(Object obj) {
            return (STFontCollectionIndex) STFontCollectionIndex.type.newValue(obj);
        }

        public static STFontCollectionIndex parse(File file) {
            return (STFontCollectionIndex) POIXMLTypeLoader.parse(file, STFontCollectionIndex.type, (XmlOptions) null);
        }

        public static STFontCollectionIndex newInstance(XmlOptions xmlOptions) {
            return (STFontCollectionIndex) POIXMLTypeLoader.newInstance(STFontCollectionIndex.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STFontCollectionIndex.type, xmlOptions);
        }

        public static STFontCollectionIndex parse(File file, XmlOptions xmlOptions) {
            return (STFontCollectionIndex) POIXMLTypeLoader.parse(file, STFontCollectionIndex.type, xmlOptions);
        }

        public static STFontCollectionIndex parse(InputStream inputStream) {
            return (STFontCollectionIndex) POIXMLTypeLoader.parse(inputStream, STFontCollectionIndex.type, (XmlOptions) null);
        }

        public static STFontCollectionIndex parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STFontCollectionIndex) POIXMLTypeLoader.parse(inputStream, STFontCollectionIndex.type, xmlOptions);
        }

        public static STFontCollectionIndex parse(Reader reader) {
            return (STFontCollectionIndex) POIXMLTypeLoader.parse(reader, STFontCollectionIndex.type, (XmlOptions) null);
        }

        public static STFontCollectionIndex parse(Reader reader, XmlOptions xmlOptions) {
            return (STFontCollectionIndex) POIXMLTypeLoader.parse(reader, STFontCollectionIndex.type, xmlOptions);
        }

        public static STFontCollectionIndex parse(String str) {
            return (STFontCollectionIndex) POIXMLTypeLoader.parse(str, STFontCollectionIndex.type, (XmlOptions) null);
        }

        public static STFontCollectionIndex parse(String str, XmlOptions xmlOptions) {
            return (STFontCollectionIndex) POIXMLTypeLoader.parse(str, STFontCollectionIndex.type, xmlOptions);
        }

        public static STFontCollectionIndex parse(URL url) {
            return (STFontCollectionIndex) POIXMLTypeLoader.parse(url, STFontCollectionIndex.type, (XmlOptions) null);
        }

        public static STFontCollectionIndex parse(URL url, XmlOptions xmlOptions) {
            return (STFontCollectionIndex) POIXMLTypeLoader.parse(url, STFontCollectionIndex.type, xmlOptions);
        }

        public static STFontCollectionIndex parse(XMLStreamReader xMLStreamReader) {
            return (STFontCollectionIndex) POIXMLTypeLoader.parse(xMLStreamReader, STFontCollectionIndex.type, (XmlOptions) null);
        }

        public static STFontCollectionIndex parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STFontCollectionIndex) POIXMLTypeLoader.parse(xMLStreamReader, STFontCollectionIndex.type, xmlOptions);
        }

        public static STFontCollectionIndex parse(XMLInputStream xMLInputStream) {
            return (STFontCollectionIndex) POIXMLTypeLoader.parse(xMLInputStream, STFontCollectionIndex.type, (XmlOptions) null);
        }

        public static STFontCollectionIndex parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STFontCollectionIndex) POIXMLTypeLoader.parse(xMLInputStream, STFontCollectionIndex.type, xmlOptions);
        }

        public static STFontCollectionIndex parse(Node node) {
            return (STFontCollectionIndex) POIXMLTypeLoader.parse(node, STFontCollectionIndex.type, (XmlOptions) null);
        }

        public static STFontCollectionIndex parse(Node node, XmlOptions xmlOptions) {
            return (STFontCollectionIndex) POIXMLTypeLoader.parse(node, STFontCollectionIndex.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
