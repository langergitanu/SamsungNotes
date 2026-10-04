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
public interface CTFixedPercentage extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTFixedPercentage.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctfixedpercentagea2dftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTFixedPercentage newInstance() {
            return (CTFixedPercentage) POIXMLTypeLoader.newInstance(CTFixedPercentage.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFixedPercentage.type, null);
        }

        public static CTFixedPercentage parse(File file) {
            return (CTFixedPercentage) POIXMLTypeLoader.parse(file, CTFixedPercentage.type, (XmlOptions) null);
        }

        public static CTFixedPercentage newInstance(XmlOptions xmlOptions) {
            return (CTFixedPercentage) POIXMLTypeLoader.newInstance(CTFixedPercentage.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFixedPercentage.type, xmlOptions);
        }

        public static CTFixedPercentage parse(File file, XmlOptions xmlOptions) {
            return (CTFixedPercentage) POIXMLTypeLoader.parse(file, CTFixedPercentage.type, xmlOptions);
        }

        public static CTFixedPercentage parse(InputStream inputStream) {
            return (CTFixedPercentage) POIXMLTypeLoader.parse(inputStream, CTFixedPercentage.type, (XmlOptions) null);
        }

        public static CTFixedPercentage parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTFixedPercentage) POIXMLTypeLoader.parse(inputStream, CTFixedPercentage.type, xmlOptions);
        }

        public static CTFixedPercentage parse(Reader reader) {
            return (CTFixedPercentage) POIXMLTypeLoader.parse(reader, CTFixedPercentage.type, (XmlOptions) null);
        }

        public static CTFixedPercentage parse(Reader reader, XmlOptions xmlOptions) {
            return (CTFixedPercentage) POIXMLTypeLoader.parse(reader, CTFixedPercentage.type, xmlOptions);
        }

        public static CTFixedPercentage parse(String str) {
            return (CTFixedPercentage) POIXMLTypeLoader.parse(str, CTFixedPercentage.type, (XmlOptions) null);
        }

        public static CTFixedPercentage parse(String str, XmlOptions xmlOptions) {
            return (CTFixedPercentage) POIXMLTypeLoader.parse(str, CTFixedPercentage.type, xmlOptions);
        }

        public static CTFixedPercentage parse(URL url) {
            return (CTFixedPercentage) POIXMLTypeLoader.parse(url, CTFixedPercentage.type, (XmlOptions) null);
        }

        public static CTFixedPercentage parse(URL url, XmlOptions xmlOptions) {
            return (CTFixedPercentage) POIXMLTypeLoader.parse(url, CTFixedPercentage.type, xmlOptions);
        }

        public static CTFixedPercentage parse(XMLStreamReader xMLStreamReader) {
            return (CTFixedPercentage) POIXMLTypeLoader.parse(xMLStreamReader, CTFixedPercentage.type, (XmlOptions) null);
        }

        public static CTFixedPercentage parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTFixedPercentage) POIXMLTypeLoader.parse(xMLStreamReader, CTFixedPercentage.type, xmlOptions);
        }

        public static CTFixedPercentage parse(XMLInputStream xMLInputStream) {
            return (CTFixedPercentage) POIXMLTypeLoader.parse(xMLInputStream, CTFixedPercentage.type, (XmlOptions) null);
        }

        public static CTFixedPercentage parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTFixedPercentage) POIXMLTypeLoader.parse(xMLInputStream, CTFixedPercentage.type, xmlOptions);
        }

        public static CTFixedPercentage parse(Node node) {
            return (CTFixedPercentage) POIXMLTypeLoader.parse(node, CTFixedPercentage.type, (XmlOptions) null);
        }

        public static CTFixedPercentage parse(Node node, XmlOptions xmlOptions) {
            return (CTFixedPercentage) POIXMLTypeLoader.parse(node, CTFixedPercentage.type, xmlOptions);
        }
    }

    int getVal();

    void setVal(int i);

    STFixedPercentage xgetVal();

    void xsetVal(STFixedPercentage sTFixedPercentage);
}
