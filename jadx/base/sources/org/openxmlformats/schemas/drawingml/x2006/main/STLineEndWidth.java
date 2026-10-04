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
public interface STLineEndWidth extends XmlToken {
    public static final int INT_LG = 3;
    public static final int INT_MED = 2;
    public static final int INT_SM = 1;
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STLineEndWidth.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "stlineendwidth16aatype");

    /* JADX INFO: renamed from: SM */
    public static final Enum f10208SM = Enum.forString("sm");
    public static final Enum MED = Enum.forString("med");

    /* JADX INFO: renamed from: LG */
    public static final Enum f10207LG = Enum.forString("lg");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_LG = 3;
        static final int INT_MED = 2;
        static final int INT_SM = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("sm", 1), new Enum("med", 2), new Enum("lg", 3)});

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

        public static STLineEndWidth newInstance() {
            return (STLineEndWidth) POIXMLTypeLoader.newInstance(STLineEndWidth.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STLineEndWidth.type, null);
        }

        public static STLineEndWidth newValue(Object obj) {
            return (STLineEndWidth) STLineEndWidth.type.newValue(obj);
        }

        public static STLineEndWidth parse(File file) {
            return (STLineEndWidth) POIXMLTypeLoader.parse(file, STLineEndWidth.type, (XmlOptions) null);
        }

        public static STLineEndWidth newInstance(XmlOptions xmlOptions) {
            return (STLineEndWidth) POIXMLTypeLoader.newInstance(STLineEndWidth.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STLineEndWidth.type, xmlOptions);
        }

        public static STLineEndWidth parse(File file, XmlOptions xmlOptions) {
            return (STLineEndWidth) POIXMLTypeLoader.parse(file, STLineEndWidth.type, xmlOptions);
        }

        public static STLineEndWidth parse(InputStream inputStream) {
            return (STLineEndWidth) POIXMLTypeLoader.parse(inputStream, STLineEndWidth.type, (XmlOptions) null);
        }

        public static STLineEndWidth parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STLineEndWidth) POIXMLTypeLoader.parse(inputStream, STLineEndWidth.type, xmlOptions);
        }

        public static STLineEndWidth parse(Reader reader) {
            return (STLineEndWidth) POIXMLTypeLoader.parse(reader, STLineEndWidth.type, (XmlOptions) null);
        }

        public static STLineEndWidth parse(Reader reader, XmlOptions xmlOptions) {
            return (STLineEndWidth) POIXMLTypeLoader.parse(reader, STLineEndWidth.type, xmlOptions);
        }

        public static STLineEndWidth parse(String str) {
            return (STLineEndWidth) POIXMLTypeLoader.parse(str, STLineEndWidth.type, (XmlOptions) null);
        }

        public static STLineEndWidth parse(String str, XmlOptions xmlOptions) {
            return (STLineEndWidth) POIXMLTypeLoader.parse(str, STLineEndWidth.type, xmlOptions);
        }

        public static STLineEndWidth parse(URL url) {
            return (STLineEndWidth) POIXMLTypeLoader.parse(url, STLineEndWidth.type, (XmlOptions) null);
        }

        public static STLineEndWidth parse(URL url, XmlOptions xmlOptions) {
            return (STLineEndWidth) POIXMLTypeLoader.parse(url, STLineEndWidth.type, xmlOptions);
        }

        public static STLineEndWidth parse(XMLStreamReader xMLStreamReader) {
            return (STLineEndWidth) POIXMLTypeLoader.parse(xMLStreamReader, STLineEndWidth.type, (XmlOptions) null);
        }

        public static STLineEndWidth parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STLineEndWidth) POIXMLTypeLoader.parse(xMLStreamReader, STLineEndWidth.type, xmlOptions);
        }

        public static STLineEndWidth parse(XMLInputStream xMLInputStream) {
            return (STLineEndWidth) POIXMLTypeLoader.parse(xMLInputStream, STLineEndWidth.type, (XmlOptions) null);
        }

        public static STLineEndWidth parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STLineEndWidth) POIXMLTypeLoader.parse(xMLInputStream, STLineEndWidth.type, xmlOptions);
        }

        public static STLineEndWidth parse(Node node) {
            return (STLineEndWidth) POIXMLTypeLoader.parse(node, STLineEndWidth.type, (XmlOptions) null);
        }

        public static STLineEndWidth parse(Node node, XmlOptions xmlOptions) {
            return (STLineEndWidth) POIXMLTypeLoader.parse(node, STLineEndWidth.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
