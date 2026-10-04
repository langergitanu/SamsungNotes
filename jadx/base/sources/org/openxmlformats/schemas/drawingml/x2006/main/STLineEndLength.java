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
public interface STLineEndLength extends XmlToken {
    public static final int INT_LG = 3;
    public static final int INT_MED = 2;
    public static final int INT_SM = 1;
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STLineEndLength.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "stlineendlength3f2etype");

    /* JADX INFO: renamed from: SM */
    public static final Enum f10206SM = Enum.forString("sm");
    public static final Enum MED = Enum.forString("med");

    /* JADX INFO: renamed from: LG */
    public static final Enum f10205LG = Enum.forString("lg");

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

        public static STLineEndLength newInstance() {
            return (STLineEndLength) POIXMLTypeLoader.newInstance(STLineEndLength.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STLineEndLength.type, null);
        }

        public static STLineEndLength newValue(Object obj) {
            return (STLineEndLength) STLineEndLength.type.newValue(obj);
        }

        public static STLineEndLength parse(File file) {
            return (STLineEndLength) POIXMLTypeLoader.parse(file, STLineEndLength.type, (XmlOptions) null);
        }

        public static STLineEndLength newInstance(XmlOptions xmlOptions) {
            return (STLineEndLength) POIXMLTypeLoader.newInstance(STLineEndLength.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STLineEndLength.type, xmlOptions);
        }

        public static STLineEndLength parse(File file, XmlOptions xmlOptions) {
            return (STLineEndLength) POIXMLTypeLoader.parse(file, STLineEndLength.type, xmlOptions);
        }

        public static STLineEndLength parse(InputStream inputStream) {
            return (STLineEndLength) POIXMLTypeLoader.parse(inputStream, STLineEndLength.type, (XmlOptions) null);
        }

        public static STLineEndLength parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STLineEndLength) POIXMLTypeLoader.parse(inputStream, STLineEndLength.type, xmlOptions);
        }

        public static STLineEndLength parse(Reader reader) {
            return (STLineEndLength) POIXMLTypeLoader.parse(reader, STLineEndLength.type, (XmlOptions) null);
        }

        public static STLineEndLength parse(Reader reader, XmlOptions xmlOptions) {
            return (STLineEndLength) POIXMLTypeLoader.parse(reader, STLineEndLength.type, xmlOptions);
        }

        public static STLineEndLength parse(String str) {
            return (STLineEndLength) POIXMLTypeLoader.parse(str, STLineEndLength.type, (XmlOptions) null);
        }

        public static STLineEndLength parse(String str, XmlOptions xmlOptions) {
            return (STLineEndLength) POIXMLTypeLoader.parse(str, STLineEndLength.type, xmlOptions);
        }

        public static STLineEndLength parse(URL url) {
            return (STLineEndLength) POIXMLTypeLoader.parse(url, STLineEndLength.type, (XmlOptions) null);
        }

        public static STLineEndLength parse(URL url, XmlOptions xmlOptions) {
            return (STLineEndLength) POIXMLTypeLoader.parse(url, STLineEndLength.type, xmlOptions);
        }

        public static STLineEndLength parse(XMLStreamReader xMLStreamReader) {
            return (STLineEndLength) POIXMLTypeLoader.parse(xMLStreamReader, STLineEndLength.type, (XmlOptions) null);
        }

        public static STLineEndLength parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STLineEndLength) POIXMLTypeLoader.parse(xMLStreamReader, STLineEndLength.type, xmlOptions);
        }

        public static STLineEndLength parse(XMLInputStream xMLInputStream) {
            return (STLineEndLength) POIXMLTypeLoader.parse(xMLInputStream, STLineEndLength.type, (XmlOptions) null);
        }

        public static STLineEndLength parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STLineEndLength) POIXMLTypeLoader.parse(xMLInputStream, STLineEndLength.type, xmlOptions);
        }

        public static STLineEndLength parse(Node node) {
            return (STLineEndLength) POIXMLTypeLoader.parse(node, STLineEndLength.type, (XmlOptions) null);
        }

        public static STLineEndLength parse(Node node, XmlOptions xmlOptions) {
            return (STLineEndLength) POIXMLTypeLoader.parse(node, STLineEndLength.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
