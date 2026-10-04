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
public interface CTTblGridCol extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTblGridCol.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttblgridcolbfectype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTblGridCol newInstance() {
            return (CTTblGridCol) POIXMLTypeLoader.newInstance(CTTblGridCol.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTblGridCol.type, null);
        }

        public static CTTblGridCol parse(File file) {
            return (CTTblGridCol) POIXMLTypeLoader.parse(file, CTTblGridCol.type, (XmlOptions) null);
        }

        public static CTTblGridCol newInstance(XmlOptions xmlOptions) {
            return (CTTblGridCol) POIXMLTypeLoader.newInstance(CTTblGridCol.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTblGridCol.type, xmlOptions);
        }

        public static CTTblGridCol parse(File file, XmlOptions xmlOptions) {
            return (CTTblGridCol) POIXMLTypeLoader.parse(file, CTTblGridCol.type, xmlOptions);
        }

        public static CTTblGridCol parse(InputStream inputStream) {
            return (CTTblGridCol) POIXMLTypeLoader.parse(inputStream, CTTblGridCol.type, (XmlOptions) null);
        }

        public static CTTblGridCol parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTblGridCol) POIXMLTypeLoader.parse(inputStream, CTTblGridCol.type, xmlOptions);
        }

        public static CTTblGridCol parse(Reader reader) {
            return (CTTblGridCol) POIXMLTypeLoader.parse(reader, CTTblGridCol.type, (XmlOptions) null);
        }

        public static CTTblGridCol parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTblGridCol) POIXMLTypeLoader.parse(reader, CTTblGridCol.type, xmlOptions);
        }

        public static CTTblGridCol parse(String str) {
            return (CTTblGridCol) POIXMLTypeLoader.parse(str, CTTblGridCol.type, (XmlOptions) null);
        }

        public static CTTblGridCol parse(String str, XmlOptions xmlOptions) {
            return (CTTblGridCol) POIXMLTypeLoader.parse(str, CTTblGridCol.type, xmlOptions);
        }

        public static CTTblGridCol parse(URL url) {
            return (CTTblGridCol) POIXMLTypeLoader.parse(url, CTTblGridCol.type, (XmlOptions) null);
        }

        public static CTTblGridCol parse(URL url, XmlOptions xmlOptions) {
            return (CTTblGridCol) POIXMLTypeLoader.parse(url, CTTblGridCol.type, xmlOptions);
        }

        public static CTTblGridCol parse(XMLStreamReader xMLStreamReader) {
            return (CTTblGridCol) POIXMLTypeLoader.parse(xMLStreamReader, CTTblGridCol.type, (XmlOptions) null);
        }

        public static CTTblGridCol parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTblGridCol) POIXMLTypeLoader.parse(xMLStreamReader, CTTblGridCol.type, xmlOptions);
        }

        public static CTTblGridCol parse(XMLInputStream xMLInputStream) {
            return (CTTblGridCol) POIXMLTypeLoader.parse(xMLInputStream, CTTblGridCol.type, (XmlOptions) null);
        }

        public static CTTblGridCol parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTblGridCol) POIXMLTypeLoader.parse(xMLInputStream, CTTblGridCol.type, xmlOptions);
        }

        public static CTTblGridCol parse(Node node) {
            return (CTTblGridCol) POIXMLTypeLoader.parse(node, CTTblGridCol.type, (XmlOptions) null);
        }

        public static CTTblGridCol parse(Node node, XmlOptions xmlOptions) {
            return (CTTblGridCol) POIXMLTypeLoader.parse(node, CTTblGridCol.type, xmlOptions);
        }
    }

    BigInteger getW();

    boolean isSetW();

    void setW(BigInteger bigInteger);

    void unsetW();

    STTwipsMeasure xgetW();

    void xsetW(STTwipsMeasure sTTwipsMeasure);
}
