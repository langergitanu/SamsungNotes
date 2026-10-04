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
public interface STMerge extends XmlString {
    public static final int INT_CONTINUE = 1;
    public static final int INT_RESTART = 2;
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STMerge.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "stmerge50aatype");
    public static final Enum CONTINUE = Enum.forString("continue");
    public static final Enum RESTART = Enum.forString("restart");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_CONTINUE = 1;
        static final int INT_RESTART = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("continue", 1), new Enum("restart", 2)});

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

        public static STMerge newInstance() {
            return (STMerge) POIXMLTypeLoader.newInstance(STMerge.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STMerge.type, null);
        }

        public static STMerge newValue(Object obj) {
            return (STMerge) STMerge.type.newValue(obj);
        }

        public static STMerge parse(File file) {
            return (STMerge) POIXMLTypeLoader.parse(file, STMerge.type, (XmlOptions) null);
        }

        public static STMerge newInstance(XmlOptions xmlOptions) {
            return (STMerge) POIXMLTypeLoader.newInstance(STMerge.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STMerge.type, xmlOptions);
        }

        public static STMerge parse(File file, XmlOptions xmlOptions) {
            return (STMerge) POIXMLTypeLoader.parse(file, STMerge.type, xmlOptions);
        }

        public static STMerge parse(InputStream inputStream) {
            return (STMerge) POIXMLTypeLoader.parse(inputStream, STMerge.type, (XmlOptions) null);
        }

        public static STMerge parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STMerge) POIXMLTypeLoader.parse(inputStream, STMerge.type, xmlOptions);
        }

        public static STMerge parse(Reader reader) {
            return (STMerge) POIXMLTypeLoader.parse(reader, STMerge.type, (XmlOptions) null);
        }

        public static STMerge parse(Reader reader, XmlOptions xmlOptions) {
            return (STMerge) POIXMLTypeLoader.parse(reader, STMerge.type, xmlOptions);
        }

        public static STMerge parse(String str) {
            return (STMerge) POIXMLTypeLoader.parse(str, STMerge.type, (XmlOptions) null);
        }

        public static STMerge parse(String str, XmlOptions xmlOptions) {
            return (STMerge) POIXMLTypeLoader.parse(str, STMerge.type, xmlOptions);
        }

        public static STMerge parse(URL url) {
            return (STMerge) POIXMLTypeLoader.parse(url, STMerge.type, (XmlOptions) null);
        }

        public static STMerge parse(URL url, XmlOptions xmlOptions) {
            return (STMerge) POIXMLTypeLoader.parse(url, STMerge.type, xmlOptions);
        }

        public static STMerge parse(XMLStreamReader xMLStreamReader) {
            return (STMerge) POIXMLTypeLoader.parse(xMLStreamReader, STMerge.type, (XmlOptions) null);
        }

        public static STMerge parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STMerge) POIXMLTypeLoader.parse(xMLStreamReader, STMerge.type, xmlOptions);
        }

        public static STMerge parse(XMLInputStream xMLInputStream) {
            return (STMerge) POIXMLTypeLoader.parse(xMLInputStream, STMerge.type, (XmlOptions) null);
        }

        public static STMerge parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STMerge) POIXMLTypeLoader.parse(xMLInputStream, STMerge.type, xmlOptions);
        }

        public static STMerge parse(Node node) {
            return (STMerge) POIXMLTypeLoader.parse(node, STMerge.type, (XmlOptions) null);
        }

        public static STMerge parse(Node node, XmlOptions xmlOptions) {
            return (STMerge) POIXMLTypeLoader.parse(node, STMerge.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
