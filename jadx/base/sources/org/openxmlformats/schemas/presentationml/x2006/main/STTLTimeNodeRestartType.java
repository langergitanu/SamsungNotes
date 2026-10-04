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
public interface STTLTimeNodeRestartType extends XmlToken {
    public static final int INT_ALWAYS = 1;
    public static final int INT_NEVER = 3;
    public static final int INT_WHEN_NOT_ACTIVE = 2;
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STTLTimeNodeRestartType.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "sttltimenoderestarttype4e5dtype");
    public static final Enum ALWAYS = Enum.forString("always");
    public static final Enum WHEN_NOT_ACTIVE = Enum.forString("whenNotActive");
    public static final Enum NEVER = Enum.forString("never");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_ALWAYS = 1;
        static final int INT_NEVER = 3;
        static final int INT_WHEN_NOT_ACTIVE = 2;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("always", 1), new Enum("whenNotActive", 2), new Enum("never", 3)});

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

        public static STTLTimeNodeRestartType newInstance() {
            return (STTLTimeNodeRestartType) POIXMLTypeLoader.newInstance(STTLTimeNodeRestartType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTLTimeNodeRestartType.type, null);
        }

        public static STTLTimeNodeRestartType newValue(Object obj) {
            return (STTLTimeNodeRestartType) STTLTimeNodeRestartType.type.newValue(obj);
        }

        public static STTLTimeNodeRestartType parse(File file) {
            return (STTLTimeNodeRestartType) POIXMLTypeLoader.parse(file, STTLTimeNodeRestartType.type, (XmlOptions) null);
        }

        public static STTLTimeNodeRestartType newInstance(XmlOptions xmlOptions) {
            return (STTLTimeNodeRestartType) POIXMLTypeLoader.newInstance(STTLTimeNodeRestartType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTLTimeNodeRestartType.type, xmlOptions);
        }

        public static STTLTimeNodeRestartType parse(File file, XmlOptions xmlOptions) {
            return (STTLTimeNodeRestartType) POIXMLTypeLoader.parse(file, STTLTimeNodeRestartType.type, xmlOptions);
        }

        public static STTLTimeNodeRestartType parse(InputStream inputStream) {
            return (STTLTimeNodeRestartType) POIXMLTypeLoader.parse(inputStream, STTLTimeNodeRestartType.type, (XmlOptions) null);
        }

        public static STTLTimeNodeRestartType parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STTLTimeNodeRestartType) POIXMLTypeLoader.parse(inputStream, STTLTimeNodeRestartType.type, xmlOptions);
        }

        public static STTLTimeNodeRestartType parse(Reader reader) {
            return (STTLTimeNodeRestartType) POIXMLTypeLoader.parse(reader, STTLTimeNodeRestartType.type, (XmlOptions) null);
        }

        public static STTLTimeNodeRestartType parse(Reader reader, XmlOptions xmlOptions) {
            return (STTLTimeNodeRestartType) POIXMLTypeLoader.parse(reader, STTLTimeNodeRestartType.type, xmlOptions);
        }

        public static STTLTimeNodeRestartType parse(String str) {
            return (STTLTimeNodeRestartType) POIXMLTypeLoader.parse(str, STTLTimeNodeRestartType.type, (XmlOptions) null);
        }

        public static STTLTimeNodeRestartType parse(String str, XmlOptions xmlOptions) {
            return (STTLTimeNodeRestartType) POIXMLTypeLoader.parse(str, STTLTimeNodeRestartType.type, xmlOptions);
        }

        public static STTLTimeNodeRestartType parse(URL url) {
            return (STTLTimeNodeRestartType) POIXMLTypeLoader.parse(url, STTLTimeNodeRestartType.type, (XmlOptions) null);
        }

        public static STTLTimeNodeRestartType parse(URL url, XmlOptions xmlOptions) {
            return (STTLTimeNodeRestartType) POIXMLTypeLoader.parse(url, STTLTimeNodeRestartType.type, xmlOptions);
        }

        public static STTLTimeNodeRestartType parse(XMLStreamReader xMLStreamReader) {
            return (STTLTimeNodeRestartType) POIXMLTypeLoader.parse(xMLStreamReader, STTLTimeNodeRestartType.type, (XmlOptions) null);
        }

        public static STTLTimeNodeRestartType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STTLTimeNodeRestartType) POIXMLTypeLoader.parse(xMLStreamReader, STTLTimeNodeRestartType.type, xmlOptions);
        }

        public static STTLTimeNodeRestartType parse(XMLInputStream xMLInputStream) {
            return (STTLTimeNodeRestartType) POIXMLTypeLoader.parse(xMLInputStream, STTLTimeNodeRestartType.type, (XmlOptions) null);
        }

        public static STTLTimeNodeRestartType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STTLTimeNodeRestartType) POIXMLTypeLoader.parse(xMLInputStream, STTLTimeNodeRestartType.type, xmlOptions);
        }

        public static STTLTimeNodeRestartType parse(Node node) {
            return (STTLTimeNodeRestartType) POIXMLTypeLoader.parse(node, STTLTimeNodeRestartType.type, (XmlOptions) null);
        }

        public static STTLTimeNodeRestartType parse(Node node, XmlOptions xmlOptions) {
            return (STTLTimeNodeRestartType) POIXMLTypeLoader.parse(node, STTLTimeNodeRestartType.type, xmlOptions);
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
