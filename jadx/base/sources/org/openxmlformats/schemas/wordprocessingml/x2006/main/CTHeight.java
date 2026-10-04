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
public interface CTHeight extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTHeight.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctheighta2e1type");

    public static final class Factory {
        private Factory() {
        }

        public static CTHeight newInstance() {
            return (CTHeight) POIXMLTypeLoader.newInstance(CTHeight.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTHeight.type, null);
        }

        public static CTHeight parse(File file) {
            return (CTHeight) POIXMLTypeLoader.parse(file, CTHeight.type, (XmlOptions) null);
        }

        public static CTHeight newInstance(XmlOptions xmlOptions) {
            return (CTHeight) POIXMLTypeLoader.newInstance(CTHeight.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTHeight.type, xmlOptions);
        }

        public static CTHeight parse(File file, XmlOptions xmlOptions) {
            return (CTHeight) POIXMLTypeLoader.parse(file, CTHeight.type, xmlOptions);
        }

        public static CTHeight parse(InputStream inputStream) {
            return (CTHeight) POIXMLTypeLoader.parse(inputStream, CTHeight.type, (XmlOptions) null);
        }

        public static CTHeight parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTHeight) POIXMLTypeLoader.parse(inputStream, CTHeight.type, xmlOptions);
        }

        public static CTHeight parse(Reader reader) {
            return (CTHeight) POIXMLTypeLoader.parse(reader, CTHeight.type, (XmlOptions) null);
        }

        public static CTHeight parse(Reader reader, XmlOptions xmlOptions) {
            return (CTHeight) POIXMLTypeLoader.parse(reader, CTHeight.type, xmlOptions);
        }

        public static CTHeight parse(String str) {
            return (CTHeight) POIXMLTypeLoader.parse(str, CTHeight.type, (XmlOptions) null);
        }

        public static CTHeight parse(String str, XmlOptions xmlOptions) {
            return (CTHeight) POIXMLTypeLoader.parse(str, CTHeight.type, xmlOptions);
        }

        public static CTHeight parse(URL url) {
            return (CTHeight) POIXMLTypeLoader.parse(url, CTHeight.type, (XmlOptions) null);
        }

        public static CTHeight parse(URL url, XmlOptions xmlOptions) {
            return (CTHeight) POIXMLTypeLoader.parse(url, CTHeight.type, xmlOptions);
        }

        public static CTHeight parse(XMLStreamReader xMLStreamReader) {
            return (CTHeight) POIXMLTypeLoader.parse(xMLStreamReader, CTHeight.type, (XmlOptions) null);
        }

        public static CTHeight parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTHeight) POIXMLTypeLoader.parse(xMLStreamReader, CTHeight.type, xmlOptions);
        }

        public static CTHeight parse(XMLInputStream xMLInputStream) {
            return (CTHeight) POIXMLTypeLoader.parse(xMLInputStream, CTHeight.type, (XmlOptions) null);
        }

        public static CTHeight parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTHeight) POIXMLTypeLoader.parse(xMLInputStream, CTHeight.type, xmlOptions);
        }

        public static CTHeight parse(Node node) {
            return (CTHeight) POIXMLTypeLoader.parse(node, CTHeight.type, (XmlOptions) null);
        }

        public static CTHeight parse(Node node, XmlOptions xmlOptions) {
            return (CTHeight) POIXMLTypeLoader.parse(node, CTHeight.type, xmlOptions);
        }
    }

    STHeightRule$Enum getHRule();

    BigInteger getVal();

    boolean isSetHRule();

    boolean isSetVal();

    void setHRule(STHeightRule$Enum sTHeightRule$Enum);

    void setVal(BigInteger bigInteger);

    void unsetHRule();

    void unsetVal();

    STHeightRule xgetHRule();

    STTwipsMeasure xgetVal();

    void xsetHRule(STHeightRule sTHeightRule);

    void xsetVal(STTwipsMeasure sTTwipsMeasure);
}
