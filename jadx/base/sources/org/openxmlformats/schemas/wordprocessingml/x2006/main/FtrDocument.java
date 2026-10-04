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
public interface FtrDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(FtrDocument.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ftre182doctype");

    public static final class Factory {
        private Factory() {
        }

        public static FtrDocument newInstance() {
            return (FtrDocument) POIXMLTypeLoader.newInstance(FtrDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, FtrDocument.type, null);
        }

        public static FtrDocument parse(File file) {
            return (FtrDocument) POIXMLTypeLoader.parse(file, FtrDocument.type, (XmlOptions) null);
        }

        public static FtrDocument newInstance(XmlOptions xmlOptions) {
            return (FtrDocument) POIXMLTypeLoader.newInstance(FtrDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, FtrDocument.type, xmlOptions);
        }

        public static FtrDocument parse(File file, XmlOptions xmlOptions) {
            return (FtrDocument) POIXMLTypeLoader.parse(file, FtrDocument.type, xmlOptions);
        }

        public static FtrDocument parse(InputStream inputStream) {
            return (FtrDocument) POIXMLTypeLoader.parse(inputStream, FtrDocument.type, (XmlOptions) null);
        }

        public static FtrDocument parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (FtrDocument) POIXMLTypeLoader.parse(inputStream, FtrDocument.type, xmlOptions);
        }

        public static FtrDocument parse(Reader reader) {
            return (FtrDocument) POIXMLTypeLoader.parse(reader, FtrDocument.type, (XmlOptions) null);
        }

        public static FtrDocument parse(Reader reader, XmlOptions xmlOptions) {
            return (FtrDocument) POIXMLTypeLoader.parse(reader, FtrDocument.type, xmlOptions);
        }

        public static FtrDocument parse(String str) {
            return (FtrDocument) POIXMLTypeLoader.parse(str, FtrDocument.type, (XmlOptions) null);
        }

        public static FtrDocument parse(String str, XmlOptions xmlOptions) {
            return (FtrDocument) POIXMLTypeLoader.parse(str, FtrDocument.type, xmlOptions);
        }

        public static FtrDocument parse(URL url) {
            return (FtrDocument) POIXMLTypeLoader.parse(url, FtrDocument.type, (XmlOptions) null);
        }

        public static FtrDocument parse(URL url, XmlOptions xmlOptions) {
            return (FtrDocument) POIXMLTypeLoader.parse(url, FtrDocument.type, xmlOptions);
        }

        public static FtrDocument parse(XMLStreamReader xMLStreamReader) {
            return (FtrDocument) POIXMLTypeLoader.parse(xMLStreamReader, FtrDocument.type, (XmlOptions) null);
        }

        public static FtrDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (FtrDocument) POIXMLTypeLoader.parse(xMLStreamReader, FtrDocument.type, xmlOptions);
        }

        public static FtrDocument parse(XMLInputStream xMLInputStream) {
            return (FtrDocument) POIXMLTypeLoader.parse(xMLInputStream, FtrDocument.type, (XmlOptions) null);
        }

        public static FtrDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (FtrDocument) POIXMLTypeLoader.parse(xMLInputStream, FtrDocument.type, xmlOptions);
        }

        public static FtrDocument parse(Node node) {
            return (FtrDocument) POIXMLTypeLoader.parse(node, FtrDocument.type, (XmlOptions) null);
        }

        public static FtrDocument parse(Node node, XmlOptions xmlOptions) {
            return (FtrDocument) POIXMLTypeLoader.parse(node, FtrDocument.type, xmlOptions);
        }
    }

    CTHdrFtr addNewFtr();

    CTHdrFtr getFtr();

    void setFtr(CTHdrFtr cTHdrFtr);
}
