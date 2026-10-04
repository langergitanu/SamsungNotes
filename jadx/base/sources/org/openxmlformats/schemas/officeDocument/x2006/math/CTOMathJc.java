package org.openxmlformats.schemas.officeDocument.x2006.math;

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
import org.openxmlformats.schemas.officeDocument.x2006.math.STJc;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTOMathJc extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTOMathJc.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctomathjcfeactype");

    public static final class Factory {
        private Factory() {
        }

        public static CTOMathJc newInstance() {
            return (CTOMathJc) POIXMLTypeLoader.newInstance(CTOMathJc.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTOMathJc.type, null);
        }

        public static CTOMathJc parse(File file) {
            return (CTOMathJc) POIXMLTypeLoader.parse(file, CTOMathJc.type, (XmlOptions) null);
        }

        public static CTOMathJc newInstance(XmlOptions xmlOptions) {
            return (CTOMathJc) POIXMLTypeLoader.newInstance(CTOMathJc.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTOMathJc.type, xmlOptions);
        }

        public static CTOMathJc parse(File file, XmlOptions xmlOptions) {
            return (CTOMathJc) POIXMLTypeLoader.parse(file, CTOMathJc.type, xmlOptions);
        }

        public static CTOMathJc parse(InputStream inputStream) {
            return (CTOMathJc) POIXMLTypeLoader.parse(inputStream, CTOMathJc.type, (XmlOptions) null);
        }

        public static CTOMathJc parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTOMathJc) POIXMLTypeLoader.parse(inputStream, CTOMathJc.type, xmlOptions);
        }

        public static CTOMathJc parse(Reader reader) {
            return (CTOMathJc) POIXMLTypeLoader.parse(reader, CTOMathJc.type, (XmlOptions) null);
        }

        public static CTOMathJc parse(Reader reader, XmlOptions xmlOptions) {
            return (CTOMathJc) POIXMLTypeLoader.parse(reader, CTOMathJc.type, xmlOptions);
        }

        public static CTOMathJc parse(String str) {
            return (CTOMathJc) POIXMLTypeLoader.parse(str, CTOMathJc.type, (XmlOptions) null);
        }

        public static CTOMathJc parse(String str, XmlOptions xmlOptions) {
            return (CTOMathJc) POIXMLTypeLoader.parse(str, CTOMathJc.type, xmlOptions);
        }

        public static CTOMathJc parse(URL url) {
            return (CTOMathJc) POIXMLTypeLoader.parse(url, CTOMathJc.type, (XmlOptions) null);
        }

        public static CTOMathJc parse(URL url, XmlOptions xmlOptions) {
            return (CTOMathJc) POIXMLTypeLoader.parse(url, CTOMathJc.type, xmlOptions);
        }

        public static CTOMathJc parse(XMLStreamReader xMLStreamReader) {
            return (CTOMathJc) POIXMLTypeLoader.parse(xMLStreamReader, CTOMathJc.type, (XmlOptions) null);
        }

        public static CTOMathJc parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTOMathJc) POIXMLTypeLoader.parse(xMLStreamReader, CTOMathJc.type, xmlOptions);
        }

        public static CTOMathJc parse(XMLInputStream xMLInputStream) {
            return (CTOMathJc) POIXMLTypeLoader.parse(xMLInputStream, CTOMathJc.type, (XmlOptions) null);
        }

        public static CTOMathJc parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTOMathJc) POIXMLTypeLoader.parse(xMLInputStream, CTOMathJc.type, xmlOptions);
        }

        public static CTOMathJc parse(Node node) {
            return (CTOMathJc) POIXMLTypeLoader.parse(node, CTOMathJc.type, (XmlOptions) null);
        }

        public static CTOMathJc parse(Node node, XmlOptions xmlOptions) {
            return (CTOMathJc) POIXMLTypeLoader.parse(node, CTOMathJc.type, xmlOptions);
        }
    }

    STJc.Enum getVal();

    boolean isSetVal();

    void setVal(STJc.Enum r12);

    void unsetVal();

    STJc xgetVal();

    void xsetVal(STJc sTJc);
}
