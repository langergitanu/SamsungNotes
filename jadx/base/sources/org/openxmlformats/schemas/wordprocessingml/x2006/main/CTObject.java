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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTObject extends CTPictureBase {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTObject.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctobject47c9type");

    public static final class Factory {
        private Factory() {
        }

        public static CTObject newInstance() {
            return (CTObject) POIXMLTypeLoader.newInstance(CTObject.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTObject.type, null);
        }

        public static CTObject parse(File file) {
            return (CTObject) POIXMLTypeLoader.parse(file, CTObject.type, (XmlOptions) null);
        }

        public static CTObject newInstance(XmlOptions xmlOptions) {
            return (CTObject) POIXMLTypeLoader.newInstance(CTObject.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTObject.type, xmlOptions);
        }

        public static CTObject parse(File file, XmlOptions xmlOptions) {
            return (CTObject) POIXMLTypeLoader.parse(file, CTObject.type, xmlOptions);
        }

        public static CTObject parse(InputStream inputStream) {
            return (CTObject) POIXMLTypeLoader.parse(inputStream, CTObject.type, (XmlOptions) null);
        }

        public static CTObject parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTObject) POIXMLTypeLoader.parse(inputStream, CTObject.type, xmlOptions);
        }

        public static CTObject parse(Reader reader) {
            return (CTObject) POIXMLTypeLoader.parse(reader, CTObject.type, (XmlOptions) null);
        }

        public static CTObject parse(Reader reader, XmlOptions xmlOptions) {
            return (CTObject) POIXMLTypeLoader.parse(reader, CTObject.type, xmlOptions);
        }

        public static CTObject parse(String str) {
            return (CTObject) POIXMLTypeLoader.parse(str, CTObject.type, (XmlOptions) null);
        }

        public static CTObject parse(String str, XmlOptions xmlOptions) {
            return (CTObject) POIXMLTypeLoader.parse(str, CTObject.type, xmlOptions);
        }

        public static CTObject parse(URL url) {
            return (CTObject) POIXMLTypeLoader.parse(url, CTObject.type, (XmlOptions) null);
        }

        public static CTObject parse(URL url, XmlOptions xmlOptions) {
            return (CTObject) POIXMLTypeLoader.parse(url, CTObject.type, xmlOptions);
        }

        public static CTObject parse(XMLStreamReader xMLStreamReader) {
            return (CTObject) POIXMLTypeLoader.parse(xMLStreamReader, CTObject.type, (XmlOptions) null);
        }

        public static CTObject parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTObject) POIXMLTypeLoader.parse(xMLStreamReader, CTObject.type, xmlOptions);
        }

        public static CTObject parse(XMLInputStream xMLInputStream) {
            return (CTObject) POIXMLTypeLoader.parse(xMLInputStream, CTObject.type, (XmlOptions) null);
        }

        public static CTObject parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTObject) POIXMLTypeLoader.parse(xMLInputStream, CTObject.type, xmlOptions);
        }

        public static CTObject parse(Node node) {
            return (CTObject) POIXMLTypeLoader.parse(node, CTObject.type, (XmlOptions) null);
        }

        public static CTObject parse(Node node, XmlOptions xmlOptions) {
            return (CTObject) POIXMLTypeLoader.parse(node, CTObject.type, xmlOptions);
        }
    }

    CTControl addNewControl();

    CTControl getControl();

    BigInteger getDxaOrig();

    BigInteger getDyaOrig();

    boolean isSetControl();

    boolean isSetDxaOrig();

    boolean isSetDyaOrig();

    void setControl(CTControl cTControl);

    void setDxaOrig(BigInteger bigInteger);

    void setDyaOrig(BigInteger bigInteger);

    void unsetControl();

    void unsetDxaOrig();

    void unsetDyaOrig();

    STTwipsMeasure xgetDxaOrig();

    STTwipsMeasure xgetDyaOrig();

    void xsetDxaOrig(STTwipsMeasure sTTwipsMeasure);

    void xsetDyaOrig(STTwipsMeasure sTTwipsMeasure);
}
