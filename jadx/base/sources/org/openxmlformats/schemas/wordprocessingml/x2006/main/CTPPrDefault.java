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
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTPPrDefault extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTPPrDefault.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctpprdefaultf839type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPPrDefault newInstance() {
            return (CTPPrDefault) POIXMLTypeLoader.newInstance(CTPPrDefault.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPPrDefault.type, null);
        }

        public static CTPPrDefault parse(File file) {
            return (CTPPrDefault) POIXMLTypeLoader.parse(file, CTPPrDefault.type, (XmlOptions) null);
        }

        public static CTPPrDefault newInstance(XmlOptions xmlOptions) {
            return (CTPPrDefault) POIXMLTypeLoader.newInstance(CTPPrDefault.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPPrDefault.type, xmlOptions);
        }

        public static CTPPrDefault parse(File file, XmlOptions xmlOptions) {
            return (CTPPrDefault) POIXMLTypeLoader.parse(file, CTPPrDefault.type, xmlOptions);
        }

        public static CTPPrDefault parse(InputStream inputStream) {
            return (CTPPrDefault) POIXMLTypeLoader.parse(inputStream, CTPPrDefault.type, (XmlOptions) null);
        }

        public static CTPPrDefault parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTPPrDefault) POIXMLTypeLoader.parse(inputStream, CTPPrDefault.type, xmlOptions);
        }

        public static CTPPrDefault parse(Reader reader) {
            return (CTPPrDefault) POIXMLTypeLoader.parse(reader, CTPPrDefault.type, (XmlOptions) null);
        }

        public static CTPPrDefault parse(Reader reader, XmlOptions xmlOptions) {
            return (CTPPrDefault) POIXMLTypeLoader.parse(reader, CTPPrDefault.type, xmlOptions);
        }

        public static CTPPrDefault parse(String str) {
            return (CTPPrDefault) POIXMLTypeLoader.parse(str, CTPPrDefault.type, (XmlOptions) null);
        }

        public static CTPPrDefault parse(String str, XmlOptions xmlOptions) {
            return (CTPPrDefault) POIXMLTypeLoader.parse(str, CTPPrDefault.type, xmlOptions);
        }

        public static CTPPrDefault parse(URL url) {
            return (CTPPrDefault) POIXMLTypeLoader.parse(url, CTPPrDefault.type, (XmlOptions) null);
        }

        public static CTPPrDefault parse(URL url, XmlOptions xmlOptions) {
            return (CTPPrDefault) POIXMLTypeLoader.parse(url, CTPPrDefault.type, xmlOptions);
        }

        public static CTPPrDefault parse(XMLStreamReader xMLStreamReader) {
            return (CTPPrDefault) POIXMLTypeLoader.parse(xMLStreamReader, CTPPrDefault.type, (XmlOptions) null);
        }

        public static CTPPrDefault parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTPPrDefault) POIXMLTypeLoader.parse(xMLStreamReader, CTPPrDefault.type, xmlOptions);
        }

        public static CTPPrDefault parse(XMLInputStream xMLInputStream) {
            return (CTPPrDefault) POIXMLTypeLoader.parse(xMLInputStream, CTPPrDefault.type, (XmlOptions) null);
        }

        public static CTPPrDefault parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTPPrDefault) POIXMLTypeLoader.parse(xMLInputStream, CTPPrDefault.type, xmlOptions);
        }

        public static CTPPrDefault parse(Node node) {
            return (CTPPrDefault) POIXMLTypeLoader.parse(node, CTPPrDefault.type, (XmlOptions) null);
        }

        public static CTPPrDefault parse(Node node, XmlOptions xmlOptions) {
            return (CTPPrDefault) POIXMLTypeLoader.parse(node, CTPPrDefault.type, xmlOptions);
        }
    }

    CTPPr addNewPPr();

    CTPPr getPPr();

    boolean isSetPPr();

    void setPPr(CTPPr cTPPr);

    void unsetPPr();
}
