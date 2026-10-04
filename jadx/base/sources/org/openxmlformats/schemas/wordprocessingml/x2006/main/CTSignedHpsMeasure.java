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
public interface CTSignedHpsMeasure extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTSignedHpsMeasure.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctsignedhpsmeasure3099type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSignedHpsMeasure newInstance() {
            return (CTSignedHpsMeasure) POIXMLTypeLoader.newInstance(CTSignedHpsMeasure.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSignedHpsMeasure.type, null);
        }

        public static CTSignedHpsMeasure parse(File file) {
            return (CTSignedHpsMeasure) POIXMLTypeLoader.parse(file, CTSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static CTSignedHpsMeasure newInstance(XmlOptions xmlOptions) {
            return (CTSignedHpsMeasure) POIXMLTypeLoader.newInstance(CTSignedHpsMeasure.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSignedHpsMeasure.type, xmlOptions);
        }

        public static CTSignedHpsMeasure parse(File file, XmlOptions xmlOptions) {
            return (CTSignedHpsMeasure) POIXMLTypeLoader.parse(file, CTSignedHpsMeasure.type, xmlOptions);
        }

        public static CTSignedHpsMeasure parse(InputStream inputStream) {
            return (CTSignedHpsMeasure) POIXMLTypeLoader.parse(inputStream, CTSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static CTSignedHpsMeasure parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTSignedHpsMeasure) POIXMLTypeLoader.parse(inputStream, CTSignedHpsMeasure.type, xmlOptions);
        }

        public static CTSignedHpsMeasure parse(Reader reader) {
            return (CTSignedHpsMeasure) POIXMLTypeLoader.parse(reader, CTSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static CTSignedHpsMeasure parse(Reader reader, XmlOptions xmlOptions) {
            return (CTSignedHpsMeasure) POIXMLTypeLoader.parse(reader, CTSignedHpsMeasure.type, xmlOptions);
        }

        public static CTSignedHpsMeasure parse(String str) {
            return (CTSignedHpsMeasure) POIXMLTypeLoader.parse(str, CTSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static CTSignedHpsMeasure parse(String str, XmlOptions xmlOptions) {
            return (CTSignedHpsMeasure) POIXMLTypeLoader.parse(str, CTSignedHpsMeasure.type, xmlOptions);
        }

        public static CTSignedHpsMeasure parse(URL url) {
            return (CTSignedHpsMeasure) POIXMLTypeLoader.parse(url, CTSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static CTSignedHpsMeasure parse(URL url, XmlOptions xmlOptions) {
            return (CTSignedHpsMeasure) POIXMLTypeLoader.parse(url, CTSignedHpsMeasure.type, xmlOptions);
        }

        public static CTSignedHpsMeasure parse(XMLStreamReader xMLStreamReader) {
            return (CTSignedHpsMeasure) POIXMLTypeLoader.parse(xMLStreamReader, CTSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static CTSignedHpsMeasure parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTSignedHpsMeasure) POIXMLTypeLoader.parse(xMLStreamReader, CTSignedHpsMeasure.type, xmlOptions);
        }

        public static CTSignedHpsMeasure parse(XMLInputStream xMLInputStream) {
            return (CTSignedHpsMeasure) POIXMLTypeLoader.parse(xMLInputStream, CTSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static CTSignedHpsMeasure parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTSignedHpsMeasure) POIXMLTypeLoader.parse(xMLInputStream, CTSignedHpsMeasure.type, xmlOptions);
        }

        public static CTSignedHpsMeasure parse(Node node) {
            return (CTSignedHpsMeasure) POIXMLTypeLoader.parse(node, CTSignedHpsMeasure.type, (XmlOptions) null);
        }

        public static CTSignedHpsMeasure parse(Node node, XmlOptions xmlOptions) {
            return (CTSignedHpsMeasure) POIXMLTypeLoader.parse(node, CTSignedHpsMeasure.type, xmlOptions);
        }
    }

    BigInteger getVal();

    void setVal(BigInteger bigInteger);

    STSignedHpsMeasure xgetVal();

    void xsetVal(STSignedHpsMeasure sTSignedHpsMeasure);
}
