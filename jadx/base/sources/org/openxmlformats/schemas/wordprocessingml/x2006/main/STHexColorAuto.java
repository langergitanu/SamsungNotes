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
public interface STHexColorAuto extends XmlString {
    public static final int INT_AUTO = 1;
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STHexColorAuto.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "sthexcolorauto3ce1type");
    public static final Enum AUTO = Enum.forString(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_AUTO = 1;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, 1)});

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

        public static STHexColorAuto newInstance() {
            return (STHexColorAuto) POIXMLTypeLoader.newInstance(STHexColorAuto.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STHexColorAuto.type, null);
        }

        public static STHexColorAuto newValue(Object obj) {
            return (STHexColorAuto) STHexColorAuto.type.newValue(obj);
        }

        public static STHexColorAuto parse(File file) {
            return (STHexColorAuto) POIXMLTypeLoader.parse(file, STHexColorAuto.type, (XmlOptions) null);
        }

        public static STHexColorAuto newInstance(XmlOptions xmlOptions) {
            return (STHexColorAuto) POIXMLTypeLoader.newInstance(STHexColorAuto.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STHexColorAuto.type, xmlOptions);
        }

        public static STHexColorAuto parse(File file, XmlOptions xmlOptions) {
            return (STHexColorAuto) POIXMLTypeLoader.parse(file, STHexColorAuto.type, xmlOptions);
        }

        public static STHexColorAuto parse(InputStream inputStream) {
            return (STHexColorAuto) POIXMLTypeLoader.parse(inputStream, STHexColorAuto.type, (XmlOptions) null);
        }

        public static STHexColorAuto parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STHexColorAuto) POIXMLTypeLoader.parse(inputStream, STHexColorAuto.type, xmlOptions);
        }

        public static STHexColorAuto parse(Reader reader) {
            return (STHexColorAuto) POIXMLTypeLoader.parse(reader, STHexColorAuto.type, (XmlOptions) null);
        }

        public static STHexColorAuto parse(Reader reader, XmlOptions xmlOptions) {
            return (STHexColorAuto) POIXMLTypeLoader.parse(reader, STHexColorAuto.type, xmlOptions);
        }

        public static STHexColorAuto parse(String str) {
            return (STHexColorAuto) POIXMLTypeLoader.parse(str, STHexColorAuto.type, (XmlOptions) null);
        }

        public static STHexColorAuto parse(String str, XmlOptions xmlOptions) {
            return (STHexColorAuto) POIXMLTypeLoader.parse(str, STHexColorAuto.type, xmlOptions);
        }

        public static STHexColorAuto parse(URL url) {
            return (STHexColorAuto) POIXMLTypeLoader.parse(url, STHexColorAuto.type, (XmlOptions) null);
        }

        public static STHexColorAuto parse(URL url, XmlOptions xmlOptions) {
            return (STHexColorAuto) POIXMLTypeLoader.parse(url, STHexColorAuto.type, xmlOptions);
        }

        public static STHexColorAuto parse(XMLStreamReader xMLStreamReader) {
            return (STHexColorAuto) POIXMLTypeLoader.parse(xMLStreamReader, STHexColorAuto.type, (XmlOptions) null);
        }

        public static STHexColorAuto parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STHexColorAuto) POIXMLTypeLoader.parse(xMLStreamReader, STHexColorAuto.type, xmlOptions);
        }

        public static STHexColorAuto parse(XMLInputStream xMLInputStream) {
            return (STHexColorAuto) POIXMLTypeLoader.parse(xMLInputStream, STHexColorAuto.type, (XmlOptions) null);
        }

        public static STHexColorAuto parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STHexColorAuto) POIXMLTypeLoader.parse(xMLInputStream, STHexColorAuto.type, xmlOptions);
        }

        public static STHexColorAuto parse(Node node) {
            return (STHexColorAuto) POIXMLTypeLoader.parse(node, STHexColorAuto.type, (XmlOptions) null);
        }

        public static STHexColorAuto parse(Node node, XmlOptions xmlOptions) {
            return (STHexColorAuto) POIXMLTypeLoader.parse(node, STHexColorAuto.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
