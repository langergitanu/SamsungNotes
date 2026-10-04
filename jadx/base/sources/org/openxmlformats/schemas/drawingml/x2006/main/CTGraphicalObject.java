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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTGraphicalObject extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTGraphicalObject.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctgraphicalobject1ce3type");

    public static final class Factory {
        private Factory() {
        }

        public static CTGraphicalObject newInstance() {
            return (CTGraphicalObject) POIXMLTypeLoader.newInstance(CTGraphicalObject.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGraphicalObject.type, null);
        }

        public static CTGraphicalObject parse(File file) {
            return (CTGraphicalObject) POIXMLTypeLoader.parse(file, CTGraphicalObject.type, (XmlOptions) null);
        }

        public static CTGraphicalObject newInstance(XmlOptions xmlOptions) {
            return (CTGraphicalObject) POIXMLTypeLoader.newInstance(CTGraphicalObject.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGraphicalObject.type, xmlOptions);
        }

        public static CTGraphicalObject parse(File file, XmlOptions xmlOptions) {
            return (CTGraphicalObject) POIXMLTypeLoader.parse(file, CTGraphicalObject.type, xmlOptions);
        }

        public static CTGraphicalObject parse(InputStream inputStream) {
            return (CTGraphicalObject) POIXMLTypeLoader.parse(inputStream, CTGraphicalObject.type, (XmlOptions) null);
        }

        public static CTGraphicalObject parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTGraphicalObject) POIXMLTypeLoader.parse(inputStream, CTGraphicalObject.type, xmlOptions);
        }

        public static CTGraphicalObject parse(Reader reader) {
            return (CTGraphicalObject) POIXMLTypeLoader.parse(reader, CTGraphicalObject.type, (XmlOptions) null);
        }

        public static CTGraphicalObject parse(Reader reader, XmlOptions xmlOptions) {
            return (CTGraphicalObject) POIXMLTypeLoader.parse(reader, CTGraphicalObject.type, xmlOptions);
        }

        public static CTGraphicalObject parse(String str) {
            return (CTGraphicalObject) POIXMLTypeLoader.parse(str, CTGraphicalObject.type, (XmlOptions) null);
        }

        public static CTGraphicalObject parse(String str, XmlOptions xmlOptions) {
            return (CTGraphicalObject) POIXMLTypeLoader.parse(str, CTGraphicalObject.type, xmlOptions);
        }

        public static CTGraphicalObject parse(URL url) {
            return (CTGraphicalObject) POIXMLTypeLoader.parse(url, CTGraphicalObject.type, (XmlOptions) null);
        }

        public static CTGraphicalObject parse(URL url, XmlOptions xmlOptions) {
            return (CTGraphicalObject) POIXMLTypeLoader.parse(url, CTGraphicalObject.type, xmlOptions);
        }

        public static CTGraphicalObject parse(XMLStreamReader xMLStreamReader) {
            return (CTGraphicalObject) POIXMLTypeLoader.parse(xMLStreamReader, CTGraphicalObject.type, (XmlOptions) null);
        }

        public static CTGraphicalObject parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTGraphicalObject) POIXMLTypeLoader.parse(xMLStreamReader, CTGraphicalObject.type, xmlOptions);
        }

        public static CTGraphicalObject parse(XMLInputStream xMLInputStream) {
            return (CTGraphicalObject) POIXMLTypeLoader.parse(xMLInputStream, CTGraphicalObject.type, (XmlOptions) null);
        }

        public static CTGraphicalObject parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTGraphicalObject) POIXMLTypeLoader.parse(xMLInputStream, CTGraphicalObject.type, xmlOptions);
        }

        public static CTGraphicalObject parse(Node node) {
            return (CTGraphicalObject) POIXMLTypeLoader.parse(node, CTGraphicalObject.type, (XmlOptions) null);
        }

        public static CTGraphicalObject parse(Node node, XmlOptions xmlOptions) {
            return (CTGraphicalObject) POIXMLTypeLoader.parse(node, CTGraphicalObject.type, xmlOptions);
        }
    }

    CTGraphicalObjectData addNewGraphicData();

    CTGraphicalObjectData getGraphicData();

    void setGraphicData(CTGraphicalObjectData cTGraphicalObjectData);
}
