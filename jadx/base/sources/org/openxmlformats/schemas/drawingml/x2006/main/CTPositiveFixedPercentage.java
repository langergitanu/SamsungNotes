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
public interface CTPositiveFixedPercentage extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTPositiveFixedPercentage.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctpositivefixedpercentage8966type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPositiveFixedPercentage newInstance() {
            return (CTPositiveFixedPercentage) POIXMLTypeLoader.newInstance(CTPositiveFixedPercentage.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPositiveFixedPercentage.type, null);
        }

        public static CTPositiveFixedPercentage parse(File file) {
            return (CTPositiveFixedPercentage) POIXMLTypeLoader.parse(file, CTPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static CTPositiveFixedPercentage newInstance(XmlOptions xmlOptions) {
            return (CTPositiveFixedPercentage) POIXMLTypeLoader.newInstance(CTPositiveFixedPercentage.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPositiveFixedPercentage.type, xmlOptions);
        }

        public static CTPositiveFixedPercentage parse(File file, XmlOptions xmlOptions) {
            return (CTPositiveFixedPercentage) POIXMLTypeLoader.parse(file, CTPositiveFixedPercentage.type, xmlOptions);
        }

        public static CTPositiveFixedPercentage parse(InputStream inputStream) {
            return (CTPositiveFixedPercentage) POIXMLTypeLoader.parse(inputStream, CTPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static CTPositiveFixedPercentage parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTPositiveFixedPercentage) POIXMLTypeLoader.parse(inputStream, CTPositiveFixedPercentage.type, xmlOptions);
        }

        public static CTPositiveFixedPercentage parse(Reader reader) {
            return (CTPositiveFixedPercentage) POIXMLTypeLoader.parse(reader, CTPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static CTPositiveFixedPercentage parse(Reader reader, XmlOptions xmlOptions) {
            return (CTPositiveFixedPercentage) POIXMLTypeLoader.parse(reader, CTPositiveFixedPercentage.type, xmlOptions);
        }

        public static CTPositiveFixedPercentage parse(String str) {
            return (CTPositiveFixedPercentage) POIXMLTypeLoader.parse(str, CTPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static CTPositiveFixedPercentage parse(String str, XmlOptions xmlOptions) {
            return (CTPositiveFixedPercentage) POIXMLTypeLoader.parse(str, CTPositiveFixedPercentage.type, xmlOptions);
        }

        public static CTPositiveFixedPercentage parse(URL url) {
            return (CTPositiveFixedPercentage) POIXMLTypeLoader.parse(url, CTPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static CTPositiveFixedPercentage parse(URL url, XmlOptions xmlOptions) {
            return (CTPositiveFixedPercentage) POIXMLTypeLoader.parse(url, CTPositiveFixedPercentage.type, xmlOptions);
        }

        public static CTPositiveFixedPercentage parse(XMLStreamReader xMLStreamReader) {
            return (CTPositiveFixedPercentage) POIXMLTypeLoader.parse(xMLStreamReader, CTPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static CTPositiveFixedPercentage parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTPositiveFixedPercentage) POIXMLTypeLoader.parse(xMLStreamReader, CTPositiveFixedPercentage.type, xmlOptions);
        }

        public static CTPositiveFixedPercentage parse(XMLInputStream xMLInputStream) {
            return (CTPositiveFixedPercentage) POIXMLTypeLoader.parse(xMLInputStream, CTPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static CTPositiveFixedPercentage parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTPositiveFixedPercentage) POIXMLTypeLoader.parse(xMLInputStream, CTPositiveFixedPercentage.type, xmlOptions);
        }

        public static CTPositiveFixedPercentage parse(Node node) {
            return (CTPositiveFixedPercentage) POIXMLTypeLoader.parse(node, CTPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static CTPositiveFixedPercentage parse(Node node, XmlOptions xmlOptions) {
            return (CTPositiveFixedPercentage) POIXMLTypeLoader.parse(node, CTPositiveFixedPercentage.type, xmlOptions);
        }
    }

    int getVal();

    void setVal(int i);

    STPositiveFixedPercentage xgetVal();

    void xsetVal(STPositiveFixedPercentage sTPositiveFixedPercentage);
}
