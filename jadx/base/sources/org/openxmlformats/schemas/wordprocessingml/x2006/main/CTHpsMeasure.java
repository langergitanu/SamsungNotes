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
public interface CTHpsMeasure extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTHpsMeasure.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cthpsmeasure3795type");

    public static final class Factory {
        private Factory() {
        }

        public static CTHpsMeasure newInstance() {
            return (CTHpsMeasure) POIXMLTypeLoader.newInstance(CTHpsMeasure.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTHpsMeasure.type, null);
        }

        public static CTHpsMeasure parse(File file) {
            return (CTHpsMeasure) POIXMLTypeLoader.parse(file, CTHpsMeasure.type, (XmlOptions) null);
        }

        public static CTHpsMeasure newInstance(XmlOptions xmlOptions) {
            return (CTHpsMeasure) POIXMLTypeLoader.newInstance(CTHpsMeasure.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTHpsMeasure.type, xmlOptions);
        }

        public static CTHpsMeasure parse(File file, XmlOptions xmlOptions) {
            return (CTHpsMeasure) POIXMLTypeLoader.parse(file, CTHpsMeasure.type, xmlOptions);
        }

        public static CTHpsMeasure parse(InputStream inputStream) {
            return (CTHpsMeasure) POIXMLTypeLoader.parse(inputStream, CTHpsMeasure.type, (XmlOptions) null);
        }

        public static CTHpsMeasure parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTHpsMeasure) POIXMLTypeLoader.parse(inputStream, CTHpsMeasure.type, xmlOptions);
        }

        public static CTHpsMeasure parse(Reader reader) {
            return (CTHpsMeasure) POIXMLTypeLoader.parse(reader, CTHpsMeasure.type, (XmlOptions) null);
        }

        public static CTHpsMeasure parse(Reader reader, XmlOptions xmlOptions) {
            return (CTHpsMeasure) POIXMLTypeLoader.parse(reader, CTHpsMeasure.type, xmlOptions);
        }

        public static CTHpsMeasure parse(String str) {
            return (CTHpsMeasure) POIXMLTypeLoader.parse(str, CTHpsMeasure.type, (XmlOptions) null);
        }

        public static CTHpsMeasure parse(String str, XmlOptions xmlOptions) {
            return (CTHpsMeasure) POIXMLTypeLoader.parse(str, CTHpsMeasure.type, xmlOptions);
        }

        public static CTHpsMeasure parse(URL url) {
            return (CTHpsMeasure) POIXMLTypeLoader.parse(url, CTHpsMeasure.type, (XmlOptions) null);
        }

        public static CTHpsMeasure parse(URL url, XmlOptions xmlOptions) {
            return (CTHpsMeasure) POIXMLTypeLoader.parse(url, CTHpsMeasure.type, xmlOptions);
        }

        public static CTHpsMeasure parse(XMLStreamReader xMLStreamReader) {
            return (CTHpsMeasure) POIXMLTypeLoader.parse(xMLStreamReader, CTHpsMeasure.type, (XmlOptions) null);
        }

        public static CTHpsMeasure parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTHpsMeasure) POIXMLTypeLoader.parse(xMLStreamReader, CTHpsMeasure.type, xmlOptions);
        }

        public static CTHpsMeasure parse(XMLInputStream xMLInputStream) {
            return (CTHpsMeasure) POIXMLTypeLoader.parse(xMLInputStream, CTHpsMeasure.type, (XmlOptions) null);
        }

        public static CTHpsMeasure parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTHpsMeasure) POIXMLTypeLoader.parse(xMLInputStream, CTHpsMeasure.type, xmlOptions);
        }

        public static CTHpsMeasure parse(Node node) {
            return (CTHpsMeasure) POIXMLTypeLoader.parse(node, CTHpsMeasure.type, (XmlOptions) null);
        }

        public static CTHpsMeasure parse(Node node, XmlOptions xmlOptions) {
            return (CTHpsMeasure) POIXMLTypeLoader.parse(node, CTHpsMeasure.type, xmlOptions);
        }
    }

    BigInteger getVal();

    void setVal(BigInteger bigInteger);

    STHpsMeasure xgetVal();

    void xsetVal(STHpsMeasure sTHpsMeasure);
}
