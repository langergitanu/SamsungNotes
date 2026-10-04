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
public interface CTTLTimeNodeParallel extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTLTimeNodeParallel.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttltimenodeparallelf917type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTLTimeNodeParallel newInstance() {
            return (CTTLTimeNodeParallel) POIXMLTypeLoader.newInstance(CTTLTimeNodeParallel.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTLTimeNodeParallel.type, null);
        }

        public static CTTLTimeNodeParallel parse(File file) {
            return (CTTLTimeNodeParallel) POIXMLTypeLoader.parse(file, CTTLTimeNodeParallel.type, (XmlOptions) null);
        }

        public static CTTLTimeNodeParallel newInstance(XmlOptions xmlOptions) {
            return (CTTLTimeNodeParallel) POIXMLTypeLoader.newInstance(CTTLTimeNodeParallel.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTLTimeNodeParallel.type, xmlOptions);
        }

        public static CTTLTimeNodeParallel parse(File file, XmlOptions xmlOptions) {
            return (CTTLTimeNodeParallel) POIXMLTypeLoader.parse(file, CTTLTimeNodeParallel.type, xmlOptions);
        }

        public static CTTLTimeNodeParallel parse(InputStream inputStream) {
            return (CTTLTimeNodeParallel) POIXMLTypeLoader.parse(inputStream, CTTLTimeNodeParallel.type, (XmlOptions) null);
        }

        public static CTTLTimeNodeParallel parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTLTimeNodeParallel) POIXMLTypeLoader.parse(inputStream, CTTLTimeNodeParallel.type, xmlOptions);
        }

        public static CTTLTimeNodeParallel parse(Reader reader) {
            return (CTTLTimeNodeParallel) POIXMLTypeLoader.parse(reader, CTTLTimeNodeParallel.type, (XmlOptions) null);
        }

        public static CTTLTimeNodeParallel parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTLTimeNodeParallel) POIXMLTypeLoader.parse(reader, CTTLTimeNodeParallel.type, xmlOptions);
        }

        public static CTTLTimeNodeParallel parse(String str) {
            return (CTTLTimeNodeParallel) POIXMLTypeLoader.parse(str, CTTLTimeNodeParallel.type, (XmlOptions) null);
        }

        public static CTTLTimeNodeParallel parse(String str, XmlOptions xmlOptions) {
            return (CTTLTimeNodeParallel) POIXMLTypeLoader.parse(str, CTTLTimeNodeParallel.type, xmlOptions);
        }

        public static CTTLTimeNodeParallel parse(URL url) {
            return (CTTLTimeNodeParallel) POIXMLTypeLoader.parse(url, CTTLTimeNodeParallel.type, (XmlOptions) null);
        }

        public static CTTLTimeNodeParallel parse(URL url, XmlOptions xmlOptions) {
            return (CTTLTimeNodeParallel) POIXMLTypeLoader.parse(url, CTTLTimeNodeParallel.type, xmlOptions);
        }

        public static CTTLTimeNodeParallel parse(XMLStreamReader xMLStreamReader) {
            return (CTTLTimeNodeParallel) POIXMLTypeLoader.parse(xMLStreamReader, CTTLTimeNodeParallel.type, (XmlOptions) null);
        }

        public static CTTLTimeNodeParallel parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTLTimeNodeParallel) POIXMLTypeLoader.parse(xMLStreamReader, CTTLTimeNodeParallel.type, xmlOptions);
        }

        public static CTTLTimeNodeParallel parse(XMLInputStream xMLInputStream) {
            return (CTTLTimeNodeParallel) POIXMLTypeLoader.parse(xMLInputStream, CTTLTimeNodeParallel.type, (XmlOptions) null);
        }

        public static CTTLTimeNodeParallel parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTLTimeNodeParallel) POIXMLTypeLoader.parse(xMLInputStream, CTTLTimeNodeParallel.type, xmlOptions);
        }

        public static CTTLTimeNodeParallel parse(Node node) {
            return (CTTLTimeNodeParallel) POIXMLTypeLoader.parse(node, CTTLTimeNodeParallel.type, (XmlOptions) null);
        }

        public static CTTLTimeNodeParallel parse(Node node, XmlOptions xmlOptions) {
            return (CTTLTimeNodeParallel) POIXMLTypeLoader.parse(node, CTTLTimeNodeParallel.type, xmlOptions);
        }
    }

    CTTLCommonTimeNodeData addNewCTn();

    CTTLCommonTimeNodeData getCTn();

    void setCTn(CTTLCommonTimeNodeData cTTLCommonTimeNodeData);
}
