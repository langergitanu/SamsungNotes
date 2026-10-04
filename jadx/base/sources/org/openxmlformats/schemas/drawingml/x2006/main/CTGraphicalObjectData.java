package org.openxmlformats.schemas.drawingml.x2006.main;

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
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTGraphicalObjectData extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTGraphicalObjectData.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctgraphicalobjectdata66adtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTGraphicalObjectData newInstance() {
            return (CTGraphicalObjectData) POIXMLTypeLoader.newInstance(CTGraphicalObjectData.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGraphicalObjectData.type, null);
        }

        public static CTGraphicalObjectData parse(File file) {
            return (CTGraphicalObjectData) POIXMLTypeLoader.parse(file, CTGraphicalObjectData.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectData newInstance(XmlOptions xmlOptions) {
            return (CTGraphicalObjectData) POIXMLTypeLoader.newInstance(CTGraphicalObjectData.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGraphicalObjectData.type, xmlOptions);
        }

        public static CTGraphicalObjectData parse(File file, XmlOptions xmlOptions) {
            return (CTGraphicalObjectData) POIXMLTypeLoader.parse(file, CTGraphicalObjectData.type, xmlOptions);
        }

        public static CTGraphicalObjectData parse(InputStream inputStream) {
            return (CTGraphicalObjectData) POIXMLTypeLoader.parse(inputStream, CTGraphicalObjectData.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectData parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTGraphicalObjectData) POIXMLTypeLoader.parse(inputStream, CTGraphicalObjectData.type, xmlOptions);
        }

        public static CTGraphicalObjectData parse(Reader reader) {
            return (CTGraphicalObjectData) POIXMLTypeLoader.parse(reader, CTGraphicalObjectData.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectData parse(Reader reader, XmlOptions xmlOptions) {
            return (CTGraphicalObjectData) POIXMLTypeLoader.parse(reader, CTGraphicalObjectData.type, xmlOptions);
        }

        public static CTGraphicalObjectData parse(String str) {
            return (CTGraphicalObjectData) POIXMLTypeLoader.parse(str, CTGraphicalObjectData.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectData parse(String str, XmlOptions xmlOptions) {
            return (CTGraphicalObjectData) POIXMLTypeLoader.parse(str, CTGraphicalObjectData.type, xmlOptions);
        }

        public static CTGraphicalObjectData parse(URL url) {
            return (CTGraphicalObjectData) POIXMLTypeLoader.parse(url, CTGraphicalObjectData.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectData parse(URL url, XmlOptions xmlOptions) {
            return (CTGraphicalObjectData) POIXMLTypeLoader.parse(url, CTGraphicalObjectData.type, xmlOptions);
        }

        public static CTGraphicalObjectData parse(XMLStreamReader xMLStreamReader) {
            return (CTGraphicalObjectData) POIXMLTypeLoader.parse(xMLStreamReader, CTGraphicalObjectData.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectData parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTGraphicalObjectData) POIXMLTypeLoader.parse(xMLStreamReader, CTGraphicalObjectData.type, xmlOptions);
        }

        public static CTGraphicalObjectData parse(XMLInputStream xMLInputStream) {
            return (CTGraphicalObjectData) POIXMLTypeLoader.parse(xMLInputStream, CTGraphicalObjectData.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectData parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTGraphicalObjectData) POIXMLTypeLoader.parse(xMLInputStream, CTGraphicalObjectData.type, xmlOptions);
        }

        public static CTGraphicalObjectData parse(Node node) {
            return (CTGraphicalObjectData) POIXMLTypeLoader.parse(node, CTGraphicalObjectData.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectData parse(Node node, XmlOptions xmlOptions) {
            return (CTGraphicalObjectData) POIXMLTypeLoader.parse(node, CTGraphicalObjectData.type, xmlOptions);
        }
    }

    String getUri();

    boolean isSetUri();

    void setUri(String str);

    void unsetUri();

    XmlToken xgetUri();

    void xsetUri(XmlToken xmlToken);
}
