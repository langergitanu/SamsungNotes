package org.openxmlformats.schemas.presentationml.x2006.main;

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
public interface STTLTimeNodeType extends XmlToken {
    public static final int INT_AFTER_EFFECT = 3;
    public static final int INT_AFTER_GROUP = 8;
    public static final int INT_CLICK_EFFECT = 1;
    public static final int INT_CLICK_PAR = 6;
    public static final int INT_INTERACTIVE_SEQ = 5;
    public static final int INT_MAIN_SEQ = 4;
    public static final int INT_TM_ROOT = 9;
    public static final int INT_WITH_EFFECT = 2;
    public static final int INT_WITH_GROUP = 7;
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STTLTimeNodeType.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "sttltimenodetypebbf4type");
    public static final Enum CLICK_EFFECT = Enum.forString("clickEffect");
    public static final Enum WITH_EFFECT = Enum.forString("withEffect");
    public static final Enum AFTER_EFFECT = Enum.forString("afterEffect");
    public static final Enum MAIN_SEQ = Enum.forString("mainSeq");
    public static final Enum INTERACTIVE_SEQ = Enum.forString("interactiveSeq");
    public static final Enum CLICK_PAR = Enum.forString("clickPar");
    public static final Enum WITH_GROUP = Enum.forString("withGroup");
    public static final Enum AFTER_GROUP = Enum.forString("afterGroup");
    public static final Enum TM_ROOT = Enum.forString("tmRoot");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_AFTER_EFFECT = 3;
        static final int INT_AFTER_GROUP = 8;
        static final int INT_CLICK_EFFECT = 1;
        static final int INT_CLICK_PAR = 6;
        static final int INT_INTERACTIVE_SEQ = 5;
        static final int INT_MAIN_SEQ = 4;
        static final int INT_TM_ROOT = 9;
        static final int INT_WITH_EFFECT = 2;
        static final int INT_WITH_GROUP = 7;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("clickEffect", 1), new Enum("withEffect", 2), new Enum("afterEffect", 3), new Enum("mainSeq", 4), new Enum("interactiveSeq", 5), new Enum("clickPar", 6), new Enum("withGroup", 7), new Enum("afterGroup", 8), new Enum("tmRoot", 9)});

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

        public static STTLTimeNodeType newInstance() {
            return (STTLTimeNodeType) POIXMLTypeLoader.newInstance(STTLTimeNodeType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTLTimeNodeType.type, null);
        }

        public static STTLTimeNodeType newValue(Object obj) {
            return (STTLTimeNodeType) STTLTimeNodeType.type.newValue(obj);
        }

        public static STTLTimeNodeType parse(File file) {
            return (STTLTimeNodeType) POIXMLTypeLoader.parse(file, STTLTimeNodeType.type, (XmlOptions) null);
        }

        public static STTLTimeNodeType newInstance(XmlOptions xmlOptions) {
            return (STTLTimeNodeType) POIXMLTypeLoader.newInstance(STTLTimeNodeType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTLTimeNodeType.type, xmlOptions);
        }

        public static STTLTimeNodeType parse(File file, XmlOptions xmlOptions) {
            return (STTLTimeNodeType) POIXMLTypeLoader.parse(file, STTLTimeNodeType.type, xmlOptions);
        }

        public static STTLTimeNodeType parse(InputStream inputStream) {
            return (STTLTimeNodeType) POIXMLTypeLoader.parse(inputStream, STTLTimeNodeType.type, (XmlOptions) null);
        }

        public static STTLTimeNodeType parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STTLTimeNodeType) POIXMLTypeLoader.parse(inputStream, STTLTimeNodeType.type, xmlOptions);
        }

        public static STTLTimeNodeType parse(Reader reader) {
            return (STTLTimeNodeType) POIXMLTypeLoader.parse(reader, STTLTimeNodeType.type, (XmlOptions) null);
        }

        public static STTLTimeNodeType parse(Reader reader, XmlOptions xmlOptions) {
            return (STTLTimeNodeType) POIXMLTypeLoader.parse(reader, STTLTimeNodeType.type, xmlOptions);
        }

        public static STTLTimeNodeType parse(String str) {
            return (STTLTimeNodeType) POIXMLTypeLoader.parse(str, STTLTimeNodeType.type, (XmlOptions) null);
        }

        public static STTLTimeNodeType parse(String str, XmlOptions xmlOptions) {
            return (STTLTimeNodeType) POIXMLTypeLoader.parse(str, STTLTimeNodeType.type, xmlOptions);
        }

        public static STTLTimeNodeType parse(URL url) {
            return (STTLTimeNodeType) POIXMLTypeLoader.parse(url, STTLTimeNodeType.type, (XmlOptions) null);
        }

        public static STTLTimeNodeType parse(URL url, XmlOptions xmlOptions) {
            return (STTLTimeNodeType) POIXMLTypeLoader.parse(url, STTLTimeNodeType.type, xmlOptions);
        }

        public static STTLTimeNodeType parse(XMLStreamReader xMLStreamReader) {
            return (STTLTimeNodeType) POIXMLTypeLoader.parse(xMLStreamReader, STTLTimeNodeType.type, (XmlOptions) null);
        }

        public static STTLTimeNodeType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STTLTimeNodeType) POIXMLTypeLoader.parse(xMLStreamReader, STTLTimeNodeType.type, xmlOptions);
        }

        public static STTLTimeNodeType parse(XMLInputStream xMLInputStream) {
            return (STTLTimeNodeType) POIXMLTypeLoader.parse(xMLInputStream, STTLTimeNodeType.type, (XmlOptions) null);
        }

        public static STTLTimeNodeType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STTLTimeNodeType) POIXMLTypeLoader.parse(xMLInputStream, STTLTimeNodeType.type, xmlOptions);
        }

        public static STTLTimeNodeType parse(Node node) {
            return (STTLTimeNodeType) POIXMLTypeLoader.parse(node, STTLTimeNodeType.type, (XmlOptions) null);
        }

        public static STTLTimeNodeType parse(Node node, XmlOptions xmlOptions) {
            return (STTLTimeNodeType) POIXMLTypeLoader.parse(node, STTLTimeNodeType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
