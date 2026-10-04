package org.openxmlformats.schemas.presentationml.x2006.main;

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
public interface SldMasterDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(SldMasterDocument.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "sldmaster5156doctype");

    public static final class Factory {
        private Factory() {
        }

        public static SldMasterDocument newInstance() {
            return (SldMasterDocument) POIXMLTypeLoader.newInstance(SldMasterDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, SldMasterDocument.type, null);
        }

        public static SldMasterDocument parse(File file) {
            return (SldMasterDocument) POIXMLTypeLoader.parse(file, SldMasterDocument.type, (XmlOptions) null);
        }

        public static SldMasterDocument newInstance(XmlOptions xmlOptions) {
            return (SldMasterDocument) POIXMLTypeLoader.newInstance(SldMasterDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, SldMasterDocument.type, xmlOptions);
        }

        public static SldMasterDocument parse(File file, XmlOptions xmlOptions) {
            return (SldMasterDocument) POIXMLTypeLoader.parse(file, SldMasterDocument.type, xmlOptions);
        }

        public static SldMasterDocument parse(InputStream inputStream) {
            return (SldMasterDocument) POIXMLTypeLoader.parse(inputStream, SldMasterDocument.type, (XmlOptions) null);
        }

        public static SldMasterDocument parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (SldMasterDocument) POIXMLTypeLoader.parse(inputStream, SldMasterDocument.type, xmlOptions);
        }

        public static SldMasterDocument parse(Reader reader) {
            return (SldMasterDocument) POIXMLTypeLoader.parse(reader, SldMasterDocument.type, (XmlOptions) null);
        }

        public static SldMasterDocument parse(Reader reader, XmlOptions xmlOptions) {
            return (SldMasterDocument) POIXMLTypeLoader.parse(reader, SldMasterDocument.type, xmlOptions);
        }

        public static SldMasterDocument parse(String str) {
            return (SldMasterDocument) POIXMLTypeLoader.parse(str, SldMasterDocument.type, (XmlOptions) null);
        }

        public static SldMasterDocument parse(String str, XmlOptions xmlOptions) {
            return (SldMasterDocument) POIXMLTypeLoader.parse(str, SldMasterDocument.type, xmlOptions);
        }

        public static SldMasterDocument parse(URL url) {
            return (SldMasterDocument) POIXMLTypeLoader.parse(url, SldMasterDocument.type, (XmlOptions) null);
        }

        public static SldMasterDocument parse(URL url, XmlOptions xmlOptions) {
            return (SldMasterDocument) POIXMLTypeLoader.parse(url, SldMasterDocument.type, xmlOptions);
        }

        public static SldMasterDocument parse(XMLStreamReader xMLStreamReader) {
            return (SldMasterDocument) POIXMLTypeLoader.parse(xMLStreamReader, SldMasterDocument.type, (XmlOptions) null);
        }

        public static SldMasterDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (SldMasterDocument) POIXMLTypeLoader.parse(xMLStreamReader, SldMasterDocument.type, xmlOptions);
        }

        public static SldMasterDocument parse(XMLInputStream xMLInputStream) {
            return (SldMasterDocument) POIXMLTypeLoader.parse(xMLInputStream, SldMasterDocument.type, (XmlOptions) null);
        }

        public static SldMasterDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (SldMasterDocument) POIXMLTypeLoader.parse(xMLInputStream, SldMasterDocument.type, xmlOptions);
        }

        public static SldMasterDocument parse(Node node) {
            return (SldMasterDocument) POIXMLTypeLoader.parse(node, SldMasterDocument.type, (XmlOptions) null);
        }

        public static SldMasterDocument parse(Node node, XmlOptions xmlOptions) {
            return (SldMasterDocument) POIXMLTypeLoader.parse(node, SldMasterDocument.type, xmlOptions);
        }
    }

    CTSlideMaster addNewSldMaster();

    CTSlideMaster getSldMaster();

    void setSldMaster(CTSlideMaster cTSlideMaster);
}
