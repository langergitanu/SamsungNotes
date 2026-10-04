package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTOnOff extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTOnOff.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctonoff04c2type");

    public static final class Factory {
        private Factory() {
        }

        public static CTOnOff newInstance() {
            return (CTOnOff) POIXMLTypeLoader.newInstance(CTOnOff.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTOnOff.type, null);
        }

        public static CTOnOff parse(File file) {
            return (CTOnOff) POIXMLTypeLoader.parse(file, CTOnOff.type, (XmlOptions) null);
        }

        public static CTOnOff newInstance(XmlOptions xmlOptions) {
            return (CTOnOff) POIXMLTypeLoader.newInstance(CTOnOff.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTOnOff.type, xmlOptions);
        }

        public static CTOnOff parse(File file, XmlOptions xmlOptions) {
            return (CTOnOff) POIXMLTypeLoader.parse(file, CTOnOff.type, xmlOptions);
        }

        public static CTOnOff parse(InputStream inputStream) {
            return (CTOnOff) POIXMLTypeLoader.parse(inputStream, CTOnOff.type, (XmlOptions) null);
        }

        public static CTOnOff parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTOnOff) POIXMLTypeLoader.parse(inputStream, CTOnOff.type, xmlOptions);
        }

        public static CTOnOff parse(Reader reader) {
            return (CTOnOff) POIXMLTypeLoader.parse(reader, CTOnOff.type, (XmlOptions) null);
        }

        public static CTOnOff parse(Reader reader, XmlOptions xmlOptions) {
            return (CTOnOff) POIXMLTypeLoader.parse(reader, CTOnOff.type, xmlOptions);
        }

        public static CTOnOff parse(String str) {
            return (CTOnOff) POIXMLTypeLoader.parse(str, CTOnOff.type, (XmlOptions) null);
        }

        public static CTOnOff parse(String str, XmlOptions xmlOptions) {
            return (CTOnOff) POIXMLTypeLoader.parse(str, CTOnOff.type, xmlOptions);
        }

        public static CTOnOff parse(URL url) {
            return (CTOnOff) POIXMLTypeLoader.parse(url, CTOnOff.type, (XmlOptions) null);
        }

        public static CTOnOff parse(URL url, XmlOptions xmlOptions) {
            return (CTOnOff) POIXMLTypeLoader.parse(url, CTOnOff.type, xmlOptions);
        }

        public static CTOnOff parse(XMLStreamReader xMLStreamReader) {
            return (CTOnOff) POIXMLTypeLoader.parse(xMLStreamReader, CTOnOff.type, (XmlOptions) null);
        }

        public static CTOnOff parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTOnOff) POIXMLTypeLoader.parse(xMLStreamReader, CTOnOff.type, xmlOptions);
        }

        public static CTOnOff parse(XMLInputStream xMLInputStream) {
            return (CTOnOff) POIXMLTypeLoader.parse(xMLInputStream, CTOnOff.type, (XmlOptions) null);
        }

        public static CTOnOff parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTOnOff) POIXMLTypeLoader.parse(xMLInputStream, CTOnOff.type, xmlOptions);
        }

        public static CTOnOff parse(Node node) {
            return (CTOnOff) POIXMLTypeLoader.parse(node, CTOnOff.type, (XmlOptions) null);
        }

        public static CTOnOff parse(Node node, XmlOptions xmlOptions) {
            return (CTOnOff) POIXMLTypeLoader.parse(node, CTOnOff.type, xmlOptions);
        }
    }

    STOnOff.Enum getVal();

    boolean isSetVal();

    void setVal(STOnOff.Enum r12);

    void unsetVal();

    STOnOff xgetVal();

    void xsetVal(STOnOff sTOnOff);
}
