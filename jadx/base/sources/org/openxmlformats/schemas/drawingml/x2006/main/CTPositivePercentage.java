package org.openxmlformats.schemas.drawingml.x2006.main;

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
public interface CTPositivePercentage extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTPositivePercentage.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctpositivepercentage2f8etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTPositivePercentage newInstance() {
            return (CTPositivePercentage) POIXMLTypeLoader.newInstance(CTPositivePercentage.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPositivePercentage.type, null);
        }

        public static CTPositivePercentage parse(File file) {
            return (CTPositivePercentage) POIXMLTypeLoader.parse(file, CTPositivePercentage.type, (XmlOptions) null);
        }

        public static CTPositivePercentage newInstance(XmlOptions xmlOptions) {
            return (CTPositivePercentage) POIXMLTypeLoader.newInstance(CTPositivePercentage.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPositivePercentage.type, xmlOptions);
        }

        public static CTPositivePercentage parse(File file, XmlOptions xmlOptions) {
            return (CTPositivePercentage) POIXMLTypeLoader.parse(file, CTPositivePercentage.type, xmlOptions);
        }

        public static CTPositivePercentage parse(InputStream inputStream) {
            return (CTPositivePercentage) POIXMLTypeLoader.parse(inputStream, CTPositivePercentage.type, (XmlOptions) null);
        }

        public static CTPositivePercentage parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTPositivePercentage) POIXMLTypeLoader.parse(inputStream, CTPositivePercentage.type, xmlOptions);
        }

        public static CTPositivePercentage parse(Reader reader) {
            return (CTPositivePercentage) POIXMLTypeLoader.parse(reader, CTPositivePercentage.type, (XmlOptions) null);
        }

        public static CTPositivePercentage parse(Reader reader, XmlOptions xmlOptions) {
            return (CTPositivePercentage) POIXMLTypeLoader.parse(reader, CTPositivePercentage.type, xmlOptions);
        }

        public static CTPositivePercentage parse(String str) {
            return (CTPositivePercentage) POIXMLTypeLoader.parse(str, CTPositivePercentage.type, (XmlOptions) null);
        }

        public static CTPositivePercentage parse(String str, XmlOptions xmlOptions) {
            return (CTPositivePercentage) POIXMLTypeLoader.parse(str, CTPositivePercentage.type, xmlOptions);
        }

        public static CTPositivePercentage parse(URL url) {
            return (CTPositivePercentage) POIXMLTypeLoader.parse(url, CTPositivePercentage.type, (XmlOptions) null);
        }

        public static CTPositivePercentage parse(URL url, XmlOptions xmlOptions) {
            return (CTPositivePercentage) POIXMLTypeLoader.parse(url, CTPositivePercentage.type, xmlOptions);
        }

        public static CTPositivePercentage parse(XMLStreamReader xMLStreamReader) {
            return (CTPositivePercentage) POIXMLTypeLoader.parse(xMLStreamReader, CTPositivePercentage.type, (XmlOptions) null);
        }

        public static CTPositivePercentage parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTPositivePercentage) POIXMLTypeLoader.parse(xMLStreamReader, CTPositivePercentage.type, xmlOptions);
        }

        public static CTPositivePercentage parse(XMLInputStream xMLInputStream) {
            return (CTPositivePercentage) POIXMLTypeLoader.parse(xMLInputStream, CTPositivePercentage.type, (XmlOptions) null);
        }

        public static CTPositivePercentage parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTPositivePercentage) POIXMLTypeLoader.parse(xMLInputStream, CTPositivePercentage.type, xmlOptions);
        }

        public static CTPositivePercentage parse(Node node) {
            return (CTPositivePercentage) POIXMLTypeLoader.parse(node, CTPositivePercentage.type, (XmlOptions) null);
        }

        public static CTPositivePercentage parse(Node node, XmlOptions xmlOptions) {
            return (CTPositivePercentage) POIXMLTypeLoader.parse(node, CTPositivePercentage.type, xmlOptions);
        }
    }

    int getVal();

    void setVal(int i);

    STPositivePercentage xgetVal();

    void xsetVal(STPositivePercentage sTPositivePercentage);
}
