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
public interface CTSdtRun extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTSdtRun.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctsdtrun5c60type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSdtRun newInstance() {
            return (CTSdtRun) POIXMLTypeLoader.newInstance(CTSdtRun.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSdtRun.type, null);
        }

        public static CTSdtRun parse(File file) {
            return (CTSdtRun) POIXMLTypeLoader.parse(file, CTSdtRun.type, (XmlOptions) null);
        }

        public static CTSdtRun newInstance(XmlOptions xmlOptions) {
            return (CTSdtRun) POIXMLTypeLoader.newInstance(CTSdtRun.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSdtRun.type, xmlOptions);
        }

        public static CTSdtRun parse(File file, XmlOptions xmlOptions) {
            return (CTSdtRun) POIXMLTypeLoader.parse(file, CTSdtRun.type, xmlOptions);
        }

        public static CTSdtRun parse(InputStream inputStream) {
            return (CTSdtRun) POIXMLTypeLoader.parse(inputStream, CTSdtRun.type, (XmlOptions) null);
        }

        public static CTSdtRun parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTSdtRun) POIXMLTypeLoader.parse(inputStream, CTSdtRun.type, xmlOptions);
        }

        public static CTSdtRun parse(Reader reader) {
            return (CTSdtRun) POIXMLTypeLoader.parse(reader, CTSdtRun.type, (XmlOptions) null);
        }

        public static CTSdtRun parse(Reader reader, XmlOptions xmlOptions) {
            return (CTSdtRun) POIXMLTypeLoader.parse(reader, CTSdtRun.type, xmlOptions);
        }

        public static CTSdtRun parse(String str) {
            return (CTSdtRun) POIXMLTypeLoader.parse(str, CTSdtRun.type, (XmlOptions) null);
        }

        public static CTSdtRun parse(String str, XmlOptions xmlOptions) {
            return (CTSdtRun) POIXMLTypeLoader.parse(str, CTSdtRun.type, xmlOptions);
        }

        public static CTSdtRun parse(URL url) {
            return (CTSdtRun) POIXMLTypeLoader.parse(url, CTSdtRun.type, (XmlOptions) null);
        }

        public static CTSdtRun parse(URL url, XmlOptions xmlOptions) {
            return (CTSdtRun) POIXMLTypeLoader.parse(url, CTSdtRun.type, xmlOptions);
        }

        public static CTSdtRun parse(XMLStreamReader xMLStreamReader) {
            return (CTSdtRun) POIXMLTypeLoader.parse(xMLStreamReader, CTSdtRun.type, (XmlOptions) null);
        }

        public static CTSdtRun parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTSdtRun) POIXMLTypeLoader.parse(xMLStreamReader, CTSdtRun.type, xmlOptions);
        }

        public static CTSdtRun parse(XMLInputStream xMLInputStream) {
            return (CTSdtRun) POIXMLTypeLoader.parse(xMLInputStream, CTSdtRun.type, (XmlOptions) null);
        }

        public static CTSdtRun parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTSdtRun) POIXMLTypeLoader.parse(xMLInputStream, CTSdtRun.type, xmlOptions);
        }

        public static CTSdtRun parse(Node node) {
            return (CTSdtRun) POIXMLTypeLoader.parse(node, CTSdtRun.type, (XmlOptions) null);
        }

        public static CTSdtRun parse(Node node, XmlOptions xmlOptions) {
            return (CTSdtRun) POIXMLTypeLoader.parse(node, CTSdtRun.type, xmlOptions);
        }
    }

    CTSdtContentRun addNewSdtContent();

    CTSdtEndPr addNewSdtEndPr();

    CTSdtPr addNewSdtPr();

    CTSdtContentRun getSdtContent();

    CTSdtEndPr getSdtEndPr();

    CTSdtPr getSdtPr();

    boolean isSetSdtContent();

    boolean isSetSdtEndPr();

    boolean isSetSdtPr();

    void setSdtContent(CTSdtContentRun cTSdtContentRun);

    void setSdtEndPr(CTSdtEndPr cTSdtEndPr);

    void setSdtPr(CTSdtPr cTSdtPr);

    void unsetSdtContent();

    void unsetSdtEndPr();

    void unsetSdtPr();
}
