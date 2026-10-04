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
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTOMathArgPr extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTOMathArgPr.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctomathargprccb1type");

    public static final class Factory {
        private Factory() {
        }

        public static CTOMathArgPr newInstance() {
            return (CTOMathArgPr) POIXMLTypeLoader.newInstance(CTOMathArgPr.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTOMathArgPr.type, null);
        }

        public static CTOMathArgPr parse(File file) {
            return (CTOMathArgPr) POIXMLTypeLoader.parse(file, CTOMathArgPr.type, (XmlOptions) null);
        }

        public static CTOMathArgPr newInstance(XmlOptions xmlOptions) {
            return (CTOMathArgPr) POIXMLTypeLoader.newInstance(CTOMathArgPr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTOMathArgPr.type, xmlOptions);
        }

        public static CTOMathArgPr parse(File file, XmlOptions xmlOptions) {
            return (CTOMathArgPr) POIXMLTypeLoader.parse(file, CTOMathArgPr.type, xmlOptions);
        }

        public static CTOMathArgPr parse(InputStream inputStream) {
            return (CTOMathArgPr) POIXMLTypeLoader.parse(inputStream, CTOMathArgPr.type, (XmlOptions) null);
        }

        public static CTOMathArgPr parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTOMathArgPr) POIXMLTypeLoader.parse(inputStream, CTOMathArgPr.type, xmlOptions);
        }

        public static CTOMathArgPr parse(Reader reader) {
            return (CTOMathArgPr) POIXMLTypeLoader.parse(reader, CTOMathArgPr.type, (XmlOptions) null);
        }

        public static CTOMathArgPr parse(Reader reader, XmlOptions xmlOptions) {
            return (CTOMathArgPr) POIXMLTypeLoader.parse(reader, CTOMathArgPr.type, xmlOptions);
        }

        public static CTOMathArgPr parse(String str) {
            return (CTOMathArgPr) POIXMLTypeLoader.parse(str, CTOMathArgPr.type, (XmlOptions) null);
        }

        public static CTOMathArgPr parse(String str, XmlOptions xmlOptions) {
            return (CTOMathArgPr) POIXMLTypeLoader.parse(str, CTOMathArgPr.type, xmlOptions);
        }

        public static CTOMathArgPr parse(URL url) {
            return (CTOMathArgPr) POIXMLTypeLoader.parse(url, CTOMathArgPr.type, (XmlOptions) null);
        }

        public static CTOMathArgPr parse(URL url, XmlOptions xmlOptions) {
            return (CTOMathArgPr) POIXMLTypeLoader.parse(url, CTOMathArgPr.type, xmlOptions);
        }

        public static CTOMathArgPr parse(XMLStreamReader xMLStreamReader) {
            return (CTOMathArgPr) POIXMLTypeLoader.parse(xMLStreamReader, CTOMathArgPr.type, (XmlOptions) null);
        }

        public static CTOMathArgPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTOMathArgPr) POIXMLTypeLoader.parse(xMLStreamReader, CTOMathArgPr.type, xmlOptions);
        }

        public static CTOMathArgPr parse(XMLInputStream xMLInputStream) {
            return (CTOMathArgPr) POIXMLTypeLoader.parse(xMLInputStream, CTOMathArgPr.type, (XmlOptions) null);
        }

        public static CTOMathArgPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTOMathArgPr) POIXMLTypeLoader.parse(xMLInputStream, CTOMathArgPr.type, xmlOptions);
        }

        public static CTOMathArgPr parse(Node node) {
            return (CTOMathArgPr) POIXMLTypeLoader.parse(node, CTOMathArgPr.type, (XmlOptions) null);
        }

        public static CTOMathArgPr parse(Node node, XmlOptions xmlOptions) {
            return (CTOMathArgPr) POIXMLTypeLoader.parse(node, CTOMathArgPr.type, xmlOptions);
        }
    }

    CTInteger2 addNewArgSz();

    CTInteger2 getArgSz();

    boolean isSetArgSz();

    void setArgSz(CTInteger2 cTInteger2);

    void unsetArgSz();
}
