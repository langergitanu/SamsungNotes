package org.openxmlformats.schemas.officeDocument.x2006.extendedProperties;

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
import org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes.CTVector;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTVectorVariant extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTVectorVariant.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctvectorvariant9d75type");

    public static final class Factory {
        private Factory() {
        }

        public static CTVectorVariant newInstance() {
            return (CTVectorVariant) POIXMLTypeLoader.newInstance(CTVectorVariant.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTVectorVariant.type, null);
        }

        public static CTVectorVariant parse(File file) {
            return (CTVectorVariant) POIXMLTypeLoader.parse(file, CTVectorVariant.type, (XmlOptions) null);
        }

        public static CTVectorVariant newInstance(XmlOptions xmlOptions) {
            return (CTVectorVariant) POIXMLTypeLoader.newInstance(CTVectorVariant.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTVectorVariant.type, xmlOptions);
        }

        public static CTVectorVariant parse(File file, XmlOptions xmlOptions) {
            return (CTVectorVariant) POIXMLTypeLoader.parse(file, CTVectorVariant.type, xmlOptions);
        }

        public static CTVectorVariant parse(InputStream inputStream) {
            return (CTVectorVariant) POIXMLTypeLoader.parse(inputStream, CTVectorVariant.type, (XmlOptions) null);
        }

        public static CTVectorVariant parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTVectorVariant) POIXMLTypeLoader.parse(inputStream, CTVectorVariant.type, xmlOptions);
        }

        public static CTVectorVariant parse(Reader reader) {
            return (CTVectorVariant) POIXMLTypeLoader.parse(reader, CTVectorVariant.type, (XmlOptions) null);
        }

        public static CTVectorVariant parse(Reader reader, XmlOptions xmlOptions) {
            return (CTVectorVariant) POIXMLTypeLoader.parse(reader, CTVectorVariant.type, xmlOptions);
        }

        public static CTVectorVariant parse(String str) {
            return (CTVectorVariant) POIXMLTypeLoader.parse(str, CTVectorVariant.type, (XmlOptions) null);
        }

        public static CTVectorVariant parse(String str, XmlOptions xmlOptions) {
            return (CTVectorVariant) POIXMLTypeLoader.parse(str, CTVectorVariant.type, xmlOptions);
        }

        public static CTVectorVariant parse(URL url) {
            return (CTVectorVariant) POIXMLTypeLoader.parse(url, CTVectorVariant.type, (XmlOptions) null);
        }

        public static CTVectorVariant parse(URL url, XmlOptions xmlOptions) {
            return (CTVectorVariant) POIXMLTypeLoader.parse(url, CTVectorVariant.type, xmlOptions);
        }

        public static CTVectorVariant parse(XMLStreamReader xMLStreamReader) {
            return (CTVectorVariant) POIXMLTypeLoader.parse(xMLStreamReader, CTVectorVariant.type, (XmlOptions) null);
        }

        public static CTVectorVariant parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTVectorVariant) POIXMLTypeLoader.parse(xMLStreamReader, CTVectorVariant.type, xmlOptions);
        }

        public static CTVectorVariant parse(XMLInputStream xMLInputStream) {
            return (CTVectorVariant) POIXMLTypeLoader.parse(xMLInputStream, CTVectorVariant.type, (XmlOptions) null);
        }

        public static CTVectorVariant parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTVectorVariant) POIXMLTypeLoader.parse(xMLInputStream, CTVectorVariant.type, xmlOptions);
        }

        public static CTVectorVariant parse(Node node) {
            return (CTVectorVariant) POIXMLTypeLoader.parse(node, CTVectorVariant.type, (XmlOptions) null);
        }

        public static CTVectorVariant parse(Node node, XmlOptions xmlOptions) {
            return (CTVectorVariant) POIXMLTypeLoader.parse(node, CTVectorVariant.type, xmlOptions);
        }
    }

    CTVector addNewVector();

    CTVector getVector();

    void setVector(CTVector cTVector);
}
