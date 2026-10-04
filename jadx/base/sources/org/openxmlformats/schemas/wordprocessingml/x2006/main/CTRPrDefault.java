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
public interface CTRPrDefault extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTRPrDefault.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctrprdefault5ebbtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTRPrDefault newInstance() {
            return (CTRPrDefault) POIXMLTypeLoader.newInstance(CTRPrDefault.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTRPrDefault.type, null);
        }

        public static CTRPrDefault parse(File file) {
            return (CTRPrDefault) POIXMLTypeLoader.parse(file, CTRPrDefault.type, (XmlOptions) null);
        }

        public static CTRPrDefault newInstance(XmlOptions xmlOptions) {
            return (CTRPrDefault) POIXMLTypeLoader.newInstance(CTRPrDefault.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTRPrDefault.type, xmlOptions);
        }

        public static CTRPrDefault parse(File file, XmlOptions xmlOptions) {
            return (CTRPrDefault) POIXMLTypeLoader.parse(file, CTRPrDefault.type, xmlOptions);
        }

        public static CTRPrDefault parse(InputStream inputStream) {
            return (CTRPrDefault) POIXMLTypeLoader.parse(inputStream, CTRPrDefault.type, (XmlOptions) null);
        }

        public static CTRPrDefault parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTRPrDefault) POIXMLTypeLoader.parse(inputStream, CTRPrDefault.type, xmlOptions);
        }

        public static CTRPrDefault parse(Reader reader) {
            return (CTRPrDefault) POIXMLTypeLoader.parse(reader, CTRPrDefault.type, (XmlOptions) null);
        }

        public static CTRPrDefault parse(Reader reader, XmlOptions xmlOptions) {
            return (CTRPrDefault) POIXMLTypeLoader.parse(reader, CTRPrDefault.type, xmlOptions);
        }

        public static CTRPrDefault parse(String str) {
            return (CTRPrDefault) POIXMLTypeLoader.parse(str, CTRPrDefault.type, (XmlOptions) null);
        }

        public static CTRPrDefault parse(String str, XmlOptions xmlOptions) {
            return (CTRPrDefault) POIXMLTypeLoader.parse(str, CTRPrDefault.type, xmlOptions);
        }

        public static CTRPrDefault parse(URL url) {
            return (CTRPrDefault) POIXMLTypeLoader.parse(url, CTRPrDefault.type, (XmlOptions) null);
        }

        public static CTRPrDefault parse(URL url, XmlOptions xmlOptions) {
            return (CTRPrDefault) POIXMLTypeLoader.parse(url, CTRPrDefault.type, xmlOptions);
        }

        public static CTRPrDefault parse(XMLStreamReader xMLStreamReader) {
            return (CTRPrDefault) POIXMLTypeLoader.parse(xMLStreamReader, CTRPrDefault.type, (XmlOptions) null);
        }

        public static CTRPrDefault parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTRPrDefault) POIXMLTypeLoader.parse(xMLStreamReader, CTRPrDefault.type, xmlOptions);
        }

        public static CTRPrDefault parse(XMLInputStream xMLInputStream) {
            return (CTRPrDefault) POIXMLTypeLoader.parse(xMLInputStream, CTRPrDefault.type, (XmlOptions) null);
        }

        public static CTRPrDefault parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTRPrDefault) POIXMLTypeLoader.parse(xMLInputStream, CTRPrDefault.type, xmlOptions);
        }

        public static CTRPrDefault parse(Node node) {
            return (CTRPrDefault) POIXMLTypeLoader.parse(node, CTRPrDefault.type, (XmlOptions) null);
        }

        public static CTRPrDefault parse(Node node, XmlOptions xmlOptions) {
            return (CTRPrDefault) POIXMLTypeLoader.parse(node, CTRPrDefault.type, xmlOptions);
        }
    }

    CTRPr addNewRPr();

    CTRPr getRPr();

    boolean isSetRPr();

    void setRPr(CTRPr cTRPr);

    void unsetRPr();
}
