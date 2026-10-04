package org.openxmlformats.schemas.drawingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
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
public interface STPathShadeType extends XmlToken {
    public static final int INT_CIRCLE = 2;
    public static final int INT_RECT = 3;
    public static final int INT_SHAPE = 1;
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STPathShadeType.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "stpathshadetype93c3type");
    public static final Enum SHAPE = Enum.forString(VMetaDataKey.META_KEY_SHAPE);
    public static final Enum CIRCLE = Enum.forString("circle");
    public static final Enum RECT = Enum.forString("rect");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CIRCLE = 2;
        static final int INT_RECT = 3;
        static final int INT_SHAPE = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum(VMetaDataKey.META_KEY_SHAPE, 1), new Enum("circle", 2), new Enum("rect", 3)});

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

        public static STPathShadeType newInstance() {
            return (STPathShadeType) POIXMLTypeLoader.newInstance(STPathShadeType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STPathShadeType.type, null);
        }

        public static STPathShadeType newValue(Object obj) {
            return (STPathShadeType) STPathShadeType.type.newValue(obj);
        }

        public static STPathShadeType parse(File file) {
            return (STPathShadeType) POIXMLTypeLoader.parse(file, STPathShadeType.type, (XmlOptions) null);
        }

        public static STPathShadeType newInstance(XmlOptions xmlOptions) {
            return (STPathShadeType) POIXMLTypeLoader.newInstance(STPathShadeType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STPathShadeType.type, xmlOptions);
        }

        public static STPathShadeType parse(File file, XmlOptions xmlOptions) {
            return (STPathShadeType) POIXMLTypeLoader.parse(file, STPathShadeType.type, xmlOptions);
        }

        public static STPathShadeType parse(InputStream inputStream) {
            return (STPathShadeType) POIXMLTypeLoader.parse(inputStream, STPathShadeType.type, (XmlOptions) null);
        }

        public static STPathShadeType parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STPathShadeType) POIXMLTypeLoader.parse(inputStream, STPathShadeType.type, xmlOptions);
        }

        public static STPathShadeType parse(Reader reader) {
            return (STPathShadeType) POIXMLTypeLoader.parse(reader, STPathShadeType.type, (XmlOptions) null);
        }

        public static STPathShadeType parse(Reader reader, XmlOptions xmlOptions) {
            return (STPathShadeType) POIXMLTypeLoader.parse(reader, STPathShadeType.type, xmlOptions);
        }

        public static STPathShadeType parse(String str) {
            return (STPathShadeType) POIXMLTypeLoader.parse(str, STPathShadeType.type, (XmlOptions) null);
        }

        public static STPathShadeType parse(String str, XmlOptions xmlOptions) {
            return (STPathShadeType) POIXMLTypeLoader.parse(str, STPathShadeType.type, xmlOptions);
        }

        public static STPathShadeType parse(URL url) {
            return (STPathShadeType) POIXMLTypeLoader.parse(url, STPathShadeType.type, (XmlOptions) null);
        }

        public static STPathShadeType parse(URL url, XmlOptions xmlOptions) {
            return (STPathShadeType) POIXMLTypeLoader.parse(url, STPathShadeType.type, xmlOptions);
        }

        public static STPathShadeType parse(XMLStreamReader xMLStreamReader) {
            return (STPathShadeType) POIXMLTypeLoader.parse(xMLStreamReader, STPathShadeType.type, (XmlOptions) null);
        }

        public static STPathShadeType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STPathShadeType) POIXMLTypeLoader.parse(xMLStreamReader, STPathShadeType.type, xmlOptions);
        }

        public static STPathShadeType parse(XMLInputStream xMLInputStream) {
            return (STPathShadeType) POIXMLTypeLoader.parse(xMLInputStream, STPathShadeType.type, (XmlOptions) null);
        }

        public static STPathShadeType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STPathShadeType) POIXMLTypeLoader.parse(xMLInputStream, STPathShadeType.type, xmlOptions);
        }

        public static STPathShadeType parse(Node node) {
            return (STPathShadeType) POIXMLTypeLoader.parse(node, STPathShadeType.type, (XmlOptions) null);
        }

        public static STPathShadeType parse(Node node, XmlOptions xmlOptions) {
            return (STPathShadeType) POIXMLTypeLoader.parse(node, STPathShadeType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
