package org.openxmlformats.schemas.drawingml.x2006.picture;

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
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface PicDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(PicDocument.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "pic8010doctype");

    public static final class Factory {
        private Factory() {
        }

        public static PicDocument newInstance() {
            return (PicDocument) POIXMLTypeLoader.newInstance(PicDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, PicDocument.type, null);
        }

        public static PicDocument parse(File file) {
            return (PicDocument) POIXMLTypeLoader.parse(file, PicDocument.type, (XmlOptions) null);
        }

        public static PicDocument newInstance(XmlOptions xmlOptions) {
            return (PicDocument) POIXMLTypeLoader.newInstance(PicDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, PicDocument.type, xmlOptions);
        }

        public static PicDocument parse(File file, XmlOptions xmlOptions) {
            return (PicDocument) POIXMLTypeLoader.parse(file, PicDocument.type, xmlOptions);
        }

        public static PicDocument parse(InputStream inputStream) {
            return (PicDocument) POIXMLTypeLoader.parse(inputStream, PicDocument.type, (XmlOptions) null);
        }

        public static PicDocument parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (PicDocument) POIXMLTypeLoader.parse(inputStream, PicDocument.type, xmlOptions);
        }

        public static PicDocument parse(Reader reader) {
            return (PicDocument) POIXMLTypeLoader.parse(reader, PicDocument.type, (XmlOptions) null);
        }

        public static PicDocument parse(Reader reader, XmlOptions xmlOptions) {
            return (PicDocument) POIXMLTypeLoader.parse(reader, PicDocument.type, xmlOptions);
        }

        public static PicDocument parse(String str) {
            return (PicDocument) POIXMLTypeLoader.parse(str, PicDocument.type, (XmlOptions) null);
        }

        public static PicDocument parse(String str, XmlOptions xmlOptions) {
            return (PicDocument) POIXMLTypeLoader.parse(str, PicDocument.type, xmlOptions);
        }

        public static PicDocument parse(URL url) {
            return (PicDocument) POIXMLTypeLoader.parse(url, PicDocument.type, (XmlOptions) null);
        }

        public static PicDocument parse(URL url, XmlOptions xmlOptions) {
            return (PicDocument) POIXMLTypeLoader.parse(url, PicDocument.type, xmlOptions);
        }

        public static PicDocument parse(XMLStreamReader xMLStreamReader) {
            return (PicDocument) POIXMLTypeLoader.parse(xMLStreamReader, PicDocument.type, (XmlOptions) null);
        }

        public static PicDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (PicDocument) POIXMLTypeLoader.parse(xMLStreamReader, PicDocument.type, xmlOptions);
        }

        public static PicDocument parse(XMLInputStream xMLInputStream) {
            return (PicDocument) POIXMLTypeLoader.parse(xMLInputStream, PicDocument.type, (XmlOptions) null);
        }

        public static PicDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (PicDocument) POIXMLTypeLoader.parse(xMLInputStream, PicDocument.type, xmlOptions);
        }

        public static PicDocument parse(Node node) {
            return (PicDocument) POIXMLTypeLoader.parse(node, PicDocument.type, (XmlOptions) null);
        }

        public static PicDocument parse(Node node, XmlOptions xmlOptions) {
            return (PicDocument) POIXMLTypeLoader.parse(node, PicDocument.type, xmlOptions);
        }
    }

    CTPicture addNewPic();

    CTPicture getPic();

    void setPic(CTPicture cTPicture);
}
