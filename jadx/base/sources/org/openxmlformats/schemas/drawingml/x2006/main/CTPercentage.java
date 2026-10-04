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
public interface CTPercentage extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTPercentage.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctpercentage4e75type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPercentage newInstance() {
            return (CTPercentage) POIXMLTypeLoader.newInstance(CTPercentage.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPercentage.type, null);
        }

        public static CTPercentage parse(File file) {
            return (CTPercentage) POIXMLTypeLoader.parse(file, CTPercentage.type, (XmlOptions) null);
        }

        public static CTPercentage newInstance(XmlOptions xmlOptions) {
            return (CTPercentage) POIXMLTypeLoader.newInstance(CTPercentage.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPercentage.type, xmlOptions);
        }

        public static CTPercentage parse(File file, XmlOptions xmlOptions) {
            return (CTPercentage) POIXMLTypeLoader.parse(file, CTPercentage.type, xmlOptions);
        }

        public static CTPercentage parse(InputStream inputStream) {
            return (CTPercentage) POIXMLTypeLoader.parse(inputStream, CTPercentage.type, (XmlOptions) null);
        }

        public static CTPercentage parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTPercentage) POIXMLTypeLoader.parse(inputStream, CTPercentage.type, xmlOptions);
        }

        public static CTPercentage parse(Reader reader) {
            return (CTPercentage) POIXMLTypeLoader.parse(reader, CTPercentage.type, (XmlOptions) null);
        }

        public static CTPercentage parse(Reader reader, XmlOptions xmlOptions) {
            return (CTPercentage) POIXMLTypeLoader.parse(reader, CTPercentage.type, xmlOptions);
        }

        public static CTPercentage parse(String str) {
            return (CTPercentage) POIXMLTypeLoader.parse(str, CTPercentage.type, (XmlOptions) null);
        }

        public static CTPercentage parse(String str, XmlOptions xmlOptions) {
            return (CTPercentage) POIXMLTypeLoader.parse(str, CTPercentage.type, xmlOptions);
        }

        public static CTPercentage parse(URL url) {
            return (CTPercentage) POIXMLTypeLoader.parse(url, CTPercentage.type, (XmlOptions) null);
        }

        public static CTPercentage parse(URL url, XmlOptions xmlOptions) {
            return (CTPercentage) POIXMLTypeLoader.parse(url, CTPercentage.type, xmlOptions);
        }

        public static CTPercentage parse(XMLStreamReader xMLStreamReader) {
            return (CTPercentage) POIXMLTypeLoader.parse(xMLStreamReader, CTPercentage.type, (XmlOptions) null);
        }

        public static CTPercentage parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTPercentage) POIXMLTypeLoader.parse(xMLStreamReader, CTPercentage.type, xmlOptions);
        }

        public static CTPercentage parse(XMLInputStream xMLInputStream) {
            return (CTPercentage) POIXMLTypeLoader.parse(xMLInputStream, CTPercentage.type, (XmlOptions) null);
        }

        public static CTPercentage parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTPercentage) POIXMLTypeLoader.parse(xMLInputStream, CTPercentage.type, xmlOptions);
        }

        public static CTPercentage parse(Node node) {
            return (CTPercentage) POIXMLTypeLoader.parse(node, CTPercentage.type, (XmlOptions) null);
        }

        public static CTPercentage parse(Node node, XmlOptions xmlOptions) {
            return (CTPercentage) POIXMLTypeLoader.parse(node, CTPercentage.type, xmlOptions);
        }
    }

    int getVal();

    void setVal(int i);

    STPercentage xgetVal();

    void xsetVal(STPercentage sTPercentage);
}
