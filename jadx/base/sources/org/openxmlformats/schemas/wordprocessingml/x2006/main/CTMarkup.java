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
public interface CTMarkup extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTMarkup.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctmarkup2d80type");

    public static final class Factory {
        private Factory() {
        }

        public static CTMarkup newInstance() {
            return (CTMarkup) POIXMLTypeLoader.newInstance(CTMarkup.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTMarkup.type, null);
        }

        public static CTMarkup parse(File file) {
            return (CTMarkup) POIXMLTypeLoader.parse(file, CTMarkup.type, (XmlOptions) null);
        }

        public static CTMarkup newInstance(XmlOptions xmlOptions) {
            return (CTMarkup) POIXMLTypeLoader.newInstance(CTMarkup.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTMarkup.type, xmlOptions);
        }

        public static CTMarkup parse(File file, XmlOptions xmlOptions) {
            return (CTMarkup) POIXMLTypeLoader.parse(file, CTMarkup.type, xmlOptions);
        }

        public static CTMarkup parse(InputStream inputStream) {
            return (CTMarkup) POIXMLTypeLoader.parse(inputStream, CTMarkup.type, (XmlOptions) null);
        }

        public static CTMarkup parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTMarkup) POIXMLTypeLoader.parse(inputStream, CTMarkup.type, xmlOptions);
        }

        public static CTMarkup parse(Reader reader) {
            return (CTMarkup) POIXMLTypeLoader.parse(reader, CTMarkup.type, (XmlOptions) null);
        }

        public static CTMarkup parse(Reader reader, XmlOptions xmlOptions) {
            return (CTMarkup) POIXMLTypeLoader.parse(reader, CTMarkup.type, xmlOptions);
        }

        public static CTMarkup parse(String str) {
            return (CTMarkup) POIXMLTypeLoader.parse(str, CTMarkup.type, (XmlOptions) null);
        }

        public static CTMarkup parse(String str, XmlOptions xmlOptions) {
            return (CTMarkup) POIXMLTypeLoader.parse(str, CTMarkup.type, xmlOptions);
        }

        public static CTMarkup parse(URL url) {
            return (CTMarkup) POIXMLTypeLoader.parse(url, CTMarkup.type, (XmlOptions) null);
        }

        public static CTMarkup parse(URL url, XmlOptions xmlOptions) {
            return (CTMarkup) POIXMLTypeLoader.parse(url, CTMarkup.type, xmlOptions);
        }

        public static CTMarkup parse(XMLStreamReader xMLStreamReader) {
            return (CTMarkup) POIXMLTypeLoader.parse(xMLStreamReader, CTMarkup.type, (XmlOptions) null);
        }

        public static CTMarkup parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTMarkup) POIXMLTypeLoader.parse(xMLStreamReader, CTMarkup.type, xmlOptions);
        }

        public static CTMarkup parse(XMLInputStream xMLInputStream) {
            return (CTMarkup) POIXMLTypeLoader.parse(xMLInputStream, CTMarkup.type, (XmlOptions) null);
        }

        public static CTMarkup parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTMarkup) POIXMLTypeLoader.parse(xMLInputStream, CTMarkup.type, xmlOptions);
        }

        public static CTMarkup parse(Node node) {
            return (CTMarkup) POIXMLTypeLoader.parse(node, CTMarkup.type, (XmlOptions) null);
        }

        public static CTMarkup parse(Node node, XmlOptions xmlOptions) {
            return (CTMarkup) POIXMLTypeLoader.parse(node, CTMarkup.type, xmlOptions);
        }
    }

    BigInteger getId();

    void setId(BigInteger bigInteger);

    STDecimalNumber xgetId();

    void xsetId(STDecimalNumber sTDecimalNumber);
}
