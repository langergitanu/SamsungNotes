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
public interface CTDocDefaults extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTDocDefaults.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctdocdefaults2ea8type");

    public static final class Factory {
        private Factory() {
        }

        public static CTDocDefaults newInstance() {
            return (CTDocDefaults) POIXMLTypeLoader.newInstance(CTDocDefaults.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTDocDefaults.type, null);
        }

        public static CTDocDefaults parse(File file) {
            return (CTDocDefaults) POIXMLTypeLoader.parse(file, CTDocDefaults.type, (XmlOptions) null);
        }

        public static CTDocDefaults newInstance(XmlOptions xmlOptions) {
            return (CTDocDefaults) POIXMLTypeLoader.newInstance(CTDocDefaults.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTDocDefaults.type, xmlOptions);
        }

        public static CTDocDefaults parse(File file, XmlOptions xmlOptions) {
            return (CTDocDefaults) POIXMLTypeLoader.parse(file, CTDocDefaults.type, xmlOptions);
        }

        public static CTDocDefaults parse(InputStream inputStream) {
            return (CTDocDefaults) POIXMLTypeLoader.parse(inputStream, CTDocDefaults.type, (XmlOptions) null);
        }

        public static CTDocDefaults parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTDocDefaults) POIXMLTypeLoader.parse(inputStream, CTDocDefaults.type, xmlOptions);
        }

        public static CTDocDefaults parse(Reader reader) {
            return (CTDocDefaults) POIXMLTypeLoader.parse(reader, CTDocDefaults.type, (XmlOptions) null);
        }

        public static CTDocDefaults parse(Reader reader, XmlOptions xmlOptions) {
            return (CTDocDefaults) POIXMLTypeLoader.parse(reader, CTDocDefaults.type, xmlOptions);
        }

        public static CTDocDefaults parse(String str) {
            return (CTDocDefaults) POIXMLTypeLoader.parse(str, CTDocDefaults.type, (XmlOptions) null);
        }

        public static CTDocDefaults parse(String str, XmlOptions xmlOptions) {
            return (CTDocDefaults) POIXMLTypeLoader.parse(str, CTDocDefaults.type, xmlOptions);
        }

        public static CTDocDefaults parse(URL url) {
            return (CTDocDefaults) POIXMLTypeLoader.parse(url, CTDocDefaults.type, (XmlOptions) null);
        }

        public static CTDocDefaults parse(URL url, XmlOptions xmlOptions) {
            return (CTDocDefaults) POIXMLTypeLoader.parse(url, CTDocDefaults.type, xmlOptions);
        }

        public static CTDocDefaults parse(XMLStreamReader xMLStreamReader) {
            return (CTDocDefaults) POIXMLTypeLoader.parse(xMLStreamReader, CTDocDefaults.type, (XmlOptions) null);
        }

        public static CTDocDefaults parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTDocDefaults) POIXMLTypeLoader.parse(xMLStreamReader, CTDocDefaults.type, xmlOptions);
        }

        public static CTDocDefaults parse(XMLInputStream xMLInputStream) {
            return (CTDocDefaults) POIXMLTypeLoader.parse(xMLInputStream, CTDocDefaults.type, (XmlOptions) null);
        }

        public static CTDocDefaults parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTDocDefaults) POIXMLTypeLoader.parse(xMLInputStream, CTDocDefaults.type, xmlOptions);
        }

        public static CTDocDefaults parse(Node node) {
            return (CTDocDefaults) POIXMLTypeLoader.parse(node, CTDocDefaults.type, (XmlOptions) null);
        }

        public static CTDocDefaults parse(Node node, XmlOptions xmlOptions) {
            return (CTDocDefaults) POIXMLTypeLoader.parse(node, CTDocDefaults.type, xmlOptions);
        }
    }

    CTPPrDefault addNewPPrDefault();

    CTRPrDefault addNewRPrDefault();

    CTPPrDefault getPPrDefault();

    CTRPrDefault getRPrDefault();

    boolean isSetPPrDefault();

    boolean isSetRPrDefault();

    void setPPrDefault(CTPPrDefault cTPPrDefault);

    void setRPrDefault(CTRPrDefault cTRPrDefault);

    void unsetPPrDefault();

    void unsetRPrDefault();
}
