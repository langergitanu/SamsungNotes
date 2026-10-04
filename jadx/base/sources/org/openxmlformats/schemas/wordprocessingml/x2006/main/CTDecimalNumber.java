package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTDecimalNumber extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTDecimalNumber.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctdecimalnumbera518type");

    public static final class Factory {
        private Factory() {
        }

        public static CTDecimalNumber newInstance() {
            return (CTDecimalNumber) POIXMLTypeLoader.newInstance(CTDecimalNumber.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTDecimalNumber.type, null);
        }

        public static CTDecimalNumber parse(File file) {
            return (CTDecimalNumber) POIXMLTypeLoader.parse(file, CTDecimalNumber.type, (XmlOptions) null);
        }

        public static CTDecimalNumber newInstance(XmlOptions xmlOptions) {
            return (CTDecimalNumber) POIXMLTypeLoader.newInstance(CTDecimalNumber.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTDecimalNumber.type, xmlOptions);
        }

        public static CTDecimalNumber parse(File file, XmlOptions xmlOptions) {
            return (CTDecimalNumber) POIXMLTypeLoader.parse(file, CTDecimalNumber.type, xmlOptions);
        }

        public static CTDecimalNumber parse(InputStream inputStream) {
            return (CTDecimalNumber) POIXMLTypeLoader.parse(inputStream, CTDecimalNumber.type, (XmlOptions) null);
        }

        public static CTDecimalNumber parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTDecimalNumber) POIXMLTypeLoader.parse(inputStream, CTDecimalNumber.type, xmlOptions);
        }

        public static CTDecimalNumber parse(Reader reader) {
            return (CTDecimalNumber) POIXMLTypeLoader.parse(reader, CTDecimalNumber.type, (XmlOptions) null);
        }

        public static CTDecimalNumber parse(Reader reader, XmlOptions xmlOptions) {
            return (CTDecimalNumber) POIXMLTypeLoader.parse(reader, CTDecimalNumber.type, xmlOptions);
        }

        public static CTDecimalNumber parse(String str) {
            return (CTDecimalNumber) POIXMLTypeLoader.parse(str, CTDecimalNumber.type, (XmlOptions) null);
        }

        public static CTDecimalNumber parse(String str, XmlOptions xmlOptions) {
            return (CTDecimalNumber) POIXMLTypeLoader.parse(str, CTDecimalNumber.type, xmlOptions);
        }

        public static CTDecimalNumber parse(URL url) {
            return (CTDecimalNumber) POIXMLTypeLoader.parse(url, CTDecimalNumber.type, (XmlOptions) null);
        }

        public static CTDecimalNumber parse(URL url, XmlOptions xmlOptions) {
            return (CTDecimalNumber) POIXMLTypeLoader.parse(url, CTDecimalNumber.type, xmlOptions);
        }

        public static CTDecimalNumber parse(XMLStreamReader xMLStreamReader) {
            return (CTDecimalNumber) POIXMLTypeLoader.parse(xMLStreamReader, CTDecimalNumber.type, (XmlOptions) null);
        }

        public static CTDecimalNumber parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTDecimalNumber) POIXMLTypeLoader.parse(xMLStreamReader, CTDecimalNumber.type, xmlOptions);
        }

        public static CTDecimalNumber parse(XMLInputStream xMLInputStream) {
            return (CTDecimalNumber) POIXMLTypeLoader.parse(xMLInputStream, CTDecimalNumber.type, (XmlOptions) null);
        }

        public static CTDecimalNumber parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTDecimalNumber) POIXMLTypeLoader.parse(xMLInputStream, CTDecimalNumber.type, xmlOptions);
        }

        public static CTDecimalNumber parse(Node node) {
            return (CTDecimalNumber) POIXMLTypeLoader.parse(node, CTDecimalNumber.type, (XmlOptions) null);
        }

        public static CTDecimalNumber parse(Node node, XmlOptions xmlOptions) {
            return (CTDecimalNumber) POIXMLTypeLoader.parse(node, CTDecimalNumber.type, xmlOptions);
        }
    }

    BigInteger getVal();

    void setVal(BigInteger bigInteger);

    STDecimalNumber xgetVal();

    void xsetVal(STDecimalNumber sTDecimalNumber);
}
