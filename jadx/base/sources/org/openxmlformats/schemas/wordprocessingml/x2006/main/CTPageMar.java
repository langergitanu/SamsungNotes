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
public interface CTPageMar extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTPageMar.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctpagemar92a3type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPageMar newInstance() {
            return (CTPageMar) POIXMLTypeLoader.newInstance(CTPageMar.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPageMar.type, null);
        }

        public static CTPageMar parse(File file) {
            return (CTPageMar) POIXMLTypeLoader.parse(file, CTPageMar.type, (XmlOptions) null);
        }

        public static CTPageMar newInstance(XmlOptions xmlOptions) {
            return (CTPageMar) POIXMLTypeLoader.newInstance(CTPageMar.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPageMar.type, xmlOptions);
        }

        public static CTPageMar parse(File file, XmlOptions xmlOptions) {
            return (CTPageMar) POIXMLTypeLoader.parse(file, CTPageMar.type, xmlOptions);
        }

        public static CTPageMar parse(InputStream inputStream) {
            return (CTPageMar) POIXMLTypeLoader.parse(inputStream, CTPageMar.type, (XmlOptions) null);
        }

        public static CTPageMar parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTPageMar) POIXMLTypeLoader.parse(inputStream, CTPageMar.type, xmlOptions);
        }

        public static CTPageMar parse(Reader reader) {
            return (CTPageMar) POIXMLTypeLoader.parse(reader, CTPageMar.type, (XmlOptions) null);
        }

        public static CTPageMar parse(Reader reader, XmlOptions xmlOptions) {
            return (CTPageMar) POIXMLTypeLoader.parse(reader, CTPageMar.type, xmlOptions);
        }

        public static CTPageMar parse(String str) {
            return (CTPageMar) POIXMLTypeLoader.parse(str, CTPageMar.type, (XmlOptions) null);
        }

        public static CTPageMar parse(String str, XmlOptions xmlOptions) {
            return (CTPageMar) POIXMLTypeLoader.parse(str, CTPageMar.type, xmlOptions);
        }

        public static CTPageMar parse(URL url) {
            return (CTPageMar) POIXMLTypeLoader.parse(url, CTPageMar.type, (XmlOptions) null);
        }

        public static CTPageMar parse(URL url, XmlOptions xmlOptions) {
            return (CTPageMar) POIXMLTypeLoader.parse(url, CTPageMar.type, xmlOptions);
        }

        public static CTPageMar parse(XMLStreamReader xMLStreamReader) {
            return (CTPageMar) POIXMLTypeLoader.parse(xMLStreamReader, CTPageMar.type, (XmlOptions) null);
        }

        public static CTPageMar parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTPageMar) POIXMLTypeLoader.parse(xMLStreamReader, CTPageMar.type, xmlOptions);
        }

        public static CTPageMar parse(XMLInputStream xMLInputStream) {
            return (CTPageMar) POIXMLTypeLoader.parse(xMLInputStream, CTPageMar.type, (XmlOptions) null);
        }

        public static CTPageMar parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTPageMar) POIXMLTypeLoader.parse(xMLInputStream, CTPageMar.type, xmlOptions);
        }

        public static CTPageMar parse(Node node) {
            return (CTPageMar) POIXMLTypeLoader.parse(node, CTPageMar.type, (XmlOptions) null);
        }

        public static CTPageMar parse(Node node, XmlOptions xmlOptions) {
            return (CTPageMar) POIXMLTypeLoader.parse(node, CTPageMar.type, xmlOptions);
        }
    }

    BigInteger getBottom();

    BigInteger getFooter();

    BigInteger getGutter();

    BigInteger getHeader();

    BigInteger getLeft();

    BigInteger getRight();

    BigInteger getTop();

    void setBottom(BigInteger bigInteger);

    void setFooter(BigInteger bigInteger);

    void setGutter(BigInteger bigInteger);

    void setHeader(BigInteger bigInteger);

    void setLeft(BigInteger bigInteger);

    void setRight(BigInteger bigInteger);

    void setTop(BigInteger bigInteger);

    STSignedTwipsMeasure xgetBottom();

    STTwipsMeasure xgetFooter();

    STTwipsMeasure xgetGutter();

    STTwipsMeasure xgetHeader();

    STTwipsMeasure xgetLeft();

    STTwipsMeasure xgetRight();

    STSignedTwipsMeasure xgetTop();

    void xsetBottom(STSignedTwipsMeasure sTSignedTwipsMeasure);

    void xsetFooter(STTwipsMeasure sTTwipsMeasure);

    void xsetGutter(STTwipsMeasure sTTwipsMeasure);

    void xsetHeader(STTwipsMeasure sTTwipsMeasure);

    void xsetLeft(STTwipsMeasure sTTwipsMeasure);

    void xsetRight(STTwipsMeasure sTTwipsMeasure);

    void xsetTop(STSignedTwipsMeasure sTSignedTwipsMeasure);
}
