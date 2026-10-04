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
public interface STTLTimeNodeFillType extends XmlToken {
    public static final int INT_FREEZE = 2;
    public static final int INT_HOLD = 3;
    public static final int INT_REMOVE = 1;
    public static final int INT_TRANSITION = 4;
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STTLTimeNodeFillType.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "sttltimenodefilltypeb7f1type");
    public static final Enum REMOVE = Enum.forString("remove");
    public static final Enum FREEZE = Enum.forString("freeze");
    public static final Enum HOLD = Enum.forString("hold");
    public static final Enum TRANSITION = Enum.forString("transition");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_FREEZE = 2;
        static final int INT_HOLD = 3;
        static final int INT_REMOVE = 1;
        static final int INT_TRANSITION = 4;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("remove", 1), new Enum("freeze", 2), new Enum("hold", 3), new Enum("transition", 4)});

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

        public static STTLTimeNodeFillType newInstance() {
            return (STTLTimeNodeFillType) POIXMLTypeLoader.newInstance(STTLTimeNodeFillType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTLTimeNodeFillType.type, null);
        }

        public static STTLTimeNodeFillType newValue(Object obj) {
            return (STTLTimeNodeFillType) STTLTimeNodeFillType.type.newValue(obj);
        }

        public static STTLTimeNodeFillType parse(File file) {
            return (STTLTimeNodeFillType) POIXMLTypeLoader.parse(file, STTLTimeNodeFillType.type, (XmlOptions) null);
        }

        public static STTLTimeNodeFillType newInstance(XmlOptions xmlOptions) {
            return (STTLTimeNodeFillType) POIXMLTypeLoader.newInstance(STTLTimeNodeFillType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTLTimeNodeFillType.type, xmlOptions);
        }

        public static STTLTimeNodeFillType parse(File file, XmlOptions xmlOptions) {
            return (STTLTimeNodeFillType) POIXMLTypeLoader.parse(file, STTLTimeNodeFillType.type, xmlOptions);
        }

        public static STTLTimeNodeFillType parse(InputStream inputStream) {
            return (STTLTimeNodeFillType) POIXMLTypeLoader.parse(inputStream, STTLTimeNodeFillType.type, (XmlOptions) null);
        }

        public static STTLTimeNodeFillType parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STTLTimeNodeFillType) POIXMLTypeLoader.parse(inputStream, STTLTimeNodeFillType.type, xmlOptions);
        }

        public static STTLTimeNodeFillType parse(Reader reader) {
            return (STTLTimeNodeFillType) POIXMLTypeLoader.parse(reader, STTLTimeNodeFillType.type, (XmlOptions) null);
        }

        public static STTLTimeNodeFillType parse(Reader reader, XmlOptions xmlOptions) {
            return (STTLTimeNodeFillType) POIXMLTypeLoader.parse(reader, STTLTimeNodeFillType.type, xmlOptions);
        }

        public static STTLTimeNodeFillType parse(String str) {
            return (STTLTimeNodeFillType) POIXMLTypeLoader.parse(str, STTLTimeNodeFillType.type, (XmlOptions) null);
        }

        public static STTLTimeNodeFillType parse(String str, XmlOptions xmlOptions) {
            return (STTLTimeNodeFillType) POIXMLTypeLoader.parse(str, STTLTimeNodeFillType.type, xmlOptions);
        }

        public static STTLTimeNodeFillType parse(URL url) {
            return (STTLTimeNodeFillType) POIXMLTypeLoader.parse(url, STTLTimeNodeFillType.type, (XmlOptions) null);
        }

        public static STTLTimeNodeFillType parse(URL url, XmlOptions xmlOptions) {
            return (STTLTimeNodeFillType) POIXMLTypeLoader.parse(url, STTLTimeNodeFillType.type, xmlOptions);
        }

        public static STTLTimeNodeFillType parse(XMLStreamReader xMLStreamReader) {
            return (STTLTimeNodeFillType) POIXMLTypeLoader.parse(xMLStreamReader, STTLTimeNodeFillType.type, (XmlOptions) null);
        }

        public static STTLTimeNodeFillType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STTLTimeNodeFillType) POIXMLTypeLoader.parse(xMLStreamReader, STTLTimeNodeFillType.type, xmlOptions);
        }

        public static STTLTimeNodeFillType parse(XMLInputStream xMLInputStream) {
            return (STTLTimeNodeFillType) POIXMLTypeLoader.parse(xMLInputStream, STTLTimeNodeFillType.type, (XmlOptions) null);
        }

        public static STTLTimeNodeFillType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STTLTimeNodeFillType) POIXMLTypeLoader.parse(xMLInputStream, STTLTimeNodeFillType.type, xmlOptions);
        }

        public static STTLTimeNodeFillType parse(Node node) {
            return (STTLTimeNodeFillType) POIXMLTypeLoader.parse(node, STTLTimeNodeFillType.type, (XmlOptions) null);
        }

        public static STTLTimeNodeFillType parse(Node node, XmlOptions xmlOptions) {
            return (STTLTimeNodeFillType) POIXMLTypeLoader.parse(node, STTLTimeNodeFillType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
