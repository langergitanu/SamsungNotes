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
public interface STTextAnchoringType extends XmlToken {
    public static final int INT_B = 3;
    public static final int INT_CTR = 2;
    public static final int INT_DIST = 5;
    public static final int INT_JUST = 4;
    public static final int INT_T = 1;
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STTextAnchoringType.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "sttextanchoringtyped99btype");

    /* JADX INFO: renamed from: T */
    public static final Enum f10213T = Enum.forString("t");
    public static final Enum CTR = Enum.forString("ctr");

    /* JADX INFO: renamed from: B */
    public static final Enum f10212B = Enum.forString("b");
    public static final Enum JUST = Enum.forString("just");
    public static final Enum DIST = Enum.forString("dist");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_B = 3;
        static final int INT_CTR = 2;
        static final int INT_DIST = 5;
        static final int INT_JUST = 4;
        static final int INT_T = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("t", 1), new Enum("ctr", 2), new Enum("b", 3), new Enum("just", 4), new Enum("dist", 5)});

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

        public static STTextAnchoringType newInstance() {
            return (STTextAnchoringType) POIXMLTypeLoader.newInstance(STTextAnchoringType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextAnchoringType.type, null);
        }

        public static STTextAnchoringType newValue(Object obj) {
            return (STTextAnchoringType) STTextAnchoringType.type.newValue(obj);
        }

        public static STTextAnchoringType parse(File file) {
            return (STTextAnchoringType) POIXMLTypeLoader.parse(file, STTextAnchoringType.type, (XmlOptions) null);
        }

        public static STTextAnchoringType newInstance(XmlOptions xmlOptions) {
            return (STTextAnchoringType) POIXMLTypeLoader.newInstance(STTextAnchoringType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextAnchoringType.type, xmlOptions);
        }

        public static STTextAnchoringType parse(File file, XmlOptions xmlOptions) {
            return (STTextAnchoringType) POIXMLTypeLoader.parse(file, STTextAnchoringType.type, xmlOptions);
        }

        public static STTextAnchoringType parse(InputStream inputStream) {
            return (STTextAnchoringType) POIXMLTypeLoader.parse(inputStream, STTextAnchoringType.type, (XmlOptions) null);
        }

        public static STTextAnchoringType parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STTextAnchoringType) POIXMLTypeLoader.parse(inputStream, STTextAnchoringType.type, xmlOptions);
        }

        public static STTextAnchoringType parse(Reader reader) {
            return (STTextAnchoringType) POIXMLTypeLoader.parse(reader, STTextAnchoringType.type, (XmlOptions) null);
        }

        public static STTextAnchoringType parse(Reader reader, XmlOptions xmlOptions) {
            return (STTextAnchoringType) POIXMLTypeLoader.parse(reader, STTextAnchoringType.type, xmlOptions);
        }

        public static STTextAnchoringType parse(String str) {
            return (STTextAnchoringType) POIXMLTypeLoader.parse(str, STTextAnchoringType.type, (XmlOptions) null);
        }

        public static STTextAnchoringType parse(String str, XmlOptions xmlOptions) {
            return (STTextAnchoringType) POIXMLTypeLoader.parse(str, STTextAnchoringType.type, xmlOptions);
        }

        public static STTextAnchoringType parse(URL url) {
            return (STTextAnchoringType) POIXMLTypeLoader.parse(url, STTextAnchoringType.type, (XmlOptions) null);
        }

        public static STTextAnchoringType parse(URL url, XmlOptions xmlOptions) {
            return (STTextAnchoringType) POIXMLTypeLoader.parse(url, STTextAnchoringType.type, xmlOptions);
        }

        public static STTextAnchoringType parse(XMLStreamReader xMLStreamReader) {
            return (STTextAnchoringType) POIXMLTypeLoader.parse(xMLStreamReader, STTextAnchoringType.type, (XmlOptions) null);
        }

        public static STTextAnchoringType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STTextAnchoringType) POIXMLTypeLoader.parse(xMLStreamReader, STTextAnchoringType.type, xmlOptions);
        }

        public static STTextAnchoringType parse(XMLInputStream xMLInputStream) {
            return (STTextAnchoringType) POIXMLTypeLoader.parse(xMLInputStream, STTextAnchoringType.type, (XmlOptions) null);
        }

        public static STTextAnchoringType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STTextAnchoringType) POIXMLTypeLoader.parse(xMLInputStream, STTextAnchoringType.type, xmlOptions);
        }

        public static STTextAnchoringType parse(Node node) {
            return (STTextAnchoringType) POIXMLTypeLoader.parse(node, STTextAnchoringType.type, (XmlOptions) null);
        }

        public static STTextAnchoringType parse(Node node, XmlOptions xmlOptions) {
            return (STTextAnchoringType) POIXMLTypeLoader.parse(node, STTextAnchoringType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
