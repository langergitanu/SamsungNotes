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
public interface CTVectorLpstr extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTVectorLpstr.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctvectorlpstr9b1dtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTVectorLpstr newInstance() {
            return (CTVectorLpstr) POIXMLTypeLoader.newInstance(CTVectorLpstr.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTVectorLpstr.type, null);
        }

        public static CTVectorLpstr parse(File file) {
            return (CTVectorLpstr) POIXMLTypeLoader.parse(file, CTVectorLpstr.type, (XmlOptions) null);
        }

        public static CTVectorLpstr newInstance(XmlOptions xmlOptions) {
            return (CTVectorLpstr) POIXMLTypeLoader.newInstance(CTVectorLpstr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTVectorLpstr.type, xmlOptions);
        }

        public static CTVectorLpstr parse(File file, XmlOptions xmlOptions) {
            return (CTVectorLpstr) POIXMLTypeLoader.parse(file, CTVectorLpstr.type, xmlOptions);
        }

        public static CTVectorLpstr parse(InputStream inputStream) {
            return (CTVectorLpstr) POIXMLTypeLoader.parse(inputStream, CTVectorLpstr.type, (XmlOptions) null);
        }

        public static CTVectorLpstr parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTVectorLpstr) POIXMLTypeLoader.parse(inputStream, CTVectorLpstr.type, xmlOptions);
        }

        public static CTVectorLpstr parse(Reader reader) {
            return (CTVectorLpstr) POIXMLTypeLoader.parse(reader, CTVectorLpstr.type, (XmlOptions) null);
        }

        public static CTVectorLpstr parse(Reader reader, XmlOptions xmlOptions) {
            return (CTVectorLpstr) POIXMLTypeLoader.parse(reader, CTVectorLpstr.type, xmlOptions);
        }

        public static CTVectorLpstr parse(String str) {
            return (CTVectorLpstr) POIXMLTypeLoader.parse(str, CTVectorLpstr.type, (XmlOptions) null);
        }

        public static CTVectorLpstr parse(String str, XmlOptions xmlOptions) {
            return (CTVectorLpstr) POIXMLTypeLoader.parse(str, CTVectorLpstr.type, xmlOptions);
        }

        public static CTVectorLpstr parse(URL url) {
            return (CTVectorLpstr) POIXMLTypeLoader.parse(url, CTVectorLpstr.type, (XmlOptions) null);
        }

        public static CTVectorLpstr parse(URL url, XmlOptions xmlOptions) {
            return (CTVectorLpstr) POIXMLTypeLoader.parse(url, CTVectorLpstr.type, xmlOptions);
        }

        public static CTVectorLpstr parse(XMLStreamReader xMLStreamReader) {
            return (CTVectorLpstr) POIXMLTypeLoader.parse(xMLStreamReader, CTVectorLpstr.type, (XmlOptions) null);
        }

        public static CTVectorLpstr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTVectorLpstr) POIXMLTypeLoader.parse(xMLStreamReader, CTVectorLpstr.type, xmlOptions);
        }

        public static CTVectorLpstr parse(XMLInputStream xMLInputStream) {
            return (CTVectorLpstr) POIXMLTypeLoader.parse(xMLInputStream, CTVectorLpstr.type, (XmlOptions) null);
        }

        public static CTVectorLpstr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTVectorLpstr) POIXMLTypeLoader.parse(xMLInputStream, CTVectorLpstr.type, xmlOptions);
        }

        public static CTVectorLpstr parse(Node node) {
            return (CTVectorLpstr) POIXMLTypeLoader.parse(node, CTVectorLpstr.type, (XmlOptions) null);
        }

        public static CTVectorLpstr parse(Node node, XmlOptions xmlOptions) {
            return (CTVectorLpstr) POIXMLTypeLoader.parse(node, CTVectorLpstr.type, xmlOptions);
        }
    }

    CTVector addNewVector();

    CTVector getVector();

    void setVector(CTVector cTVector);
}
