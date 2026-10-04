package org.openxmlformats.schemas.officeDocument.x2006.extendedProperties;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTDigSigBlob extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTDigSigBlob.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctdigsigblob73c9type");

    public static final class Factory {
        private Factory() {
        }

        public static CTDigSigBlob newInstance() {
            return (CTDigSigBlob) POIXMLTypeLoader.newInstance(CTDigSigBlob.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTDigSigBlob.type, null);
        }

        public static CTDigSigBlob parse(File file) {
            return (CTDigSigBlob) POIXMLTypeLoader.parse(file, CTDigSigBlob.type, (XmlOptions) null);
        }

        public static CTDigSigBlob newInstance(XmlOptions xmlOptions) {
            return (CTDigSigBlob) POIXMLTypeLoader.newInstance(CTDigSigBlob.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTDigSigBlob.type, xmlOptions);
        }

        public static CTDigSigBlob parse(File file, XmlOptions xmlOptions) {
            return (CTDigSigBlob) POIXMLTypeLoader.parse(file, CTDigSigBlob.type, xmlOptions);
        }

        public static CTDigSigBlob parse(InputStream inputStream) {
            return (CTDigSigBlob) POIXMLTypeLoader.parse(inputStream, CTDigSigBlob.type, (XmlOptions) null);
        }

        public static CTDigSigBlob parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTDigSigBlob) POIXMLTypeLoader.parse(inputStream, CTDigSigBlob.type, xmlOptions);
        }

        public static CTDigSigBlob parse(Reader reader) {
            return (CTDigSigBlob) POIXMLTypeLoader.parse(reader, CTDigSigBlob.type, (XmlOptions) null);
        }

        public static CTDigSigBlob parse(Reader reader, XmlOptions xmlOptions) {
            return (CTDigSigBlob) POIXMLTypeLoader.parse(reader, CTDigSigBlob.type, xmlOptions);
        }

        public static CTDigSigBlob parse(String str) {
            return (CTDigSigBlob) POIXMLTypeLoader.parse(str, CTDigSigBlob.type, (XmlOptions) null);
        }

        public static CTDigSigBlob parse(String str, XmlOptions xmlOptions) {
            return (CTDigSigBlob) POIXMLTypeLoader.parse(str, CTDigSigBlob.type, xmlOptions);
        }

        public static CTDigSigBlob parse(URL url) {
            return (CTDigSigBlob) POIXMLTypeLoader.parse(url, CTDigSigBlob.type, (XmlOptions) null);
        }

        public static CTDigSigBlob parse(URL url, XmlOptions xmlOptions) {
            return (CTDigSigBlob) POIXMLTypeLoader.parse(url, CTDigSigBlob.type, xmlOptions);
        }

        public static CTDigSigBlob parse(XMLStreamReader xMLStreamReader) {
            return (CTDigSigBlob) POIXMLTypeLoader.parse(xMLStreamReader, CTDigSigBlob.type, (XmlOptions) null);
        }

        public static CTDigSigBlob parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTDigSigBlob) POIXMLTypeLoader.parse(xMLStreamReader, CTDigSigBlob.type, xmlOptions);
        }

        public static CTDigSigBlob parse(XMLInputStream xMLInputStream) {
            return (CTDigSigBlob) POIXMLTypeLoader.parse(xMLInputStream, CTDigSigBlob.type, (XmlOptions) null);
        }

        public static CTDigSigBlob parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTDigSigBlob) POIXMLTypeLoader.parse(xMLInputStream, CTDigSigBlob.type, xmlOptions);
        }

        public static CTDigSigBlob parse(Node node) {
            return (CTDigSigBlob) POIXMLTypeLoader.parse(node, CTDigSigBlob.type, (XmlOptions) null);
        }

        public static CTDigSigBlob parse(Node node, XmlOptions xmlOptions) {
            return (CTDigSigBlob) POIXMLTypeLoader.parse(node, CTDigSigBlob.type, xmlOptions);
        }
    }

    byte[] getBlob();

    void setBlob(byte[] bArr);

    XmlBase64Binary xgetBlob();

    void xsetBlob(XmlBase64Binary xmlBase64Binary);
}
