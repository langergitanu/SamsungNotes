package org.openxmlformats.schemas.drawingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTPath2DList extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTPath2DList.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctpath2dlistb010type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPath2DList newInstance() {
            return (CTPath2DList) POIXMLTypeLoader.newInstance(CTPath2DList.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPath2DList.type, null);
        }

        public static CTPath2DList parse(File file) {
            return (CTPath2DList) POIXMLTypeLoader.parse(file, CTPath2DList.type, (XmlOptions) null);
        }

        public static CTPath2DList newInstance(XmlOptions xmlOptions) {
            return (CTPath2DList) POIXMLTypeLoader.newInstance(CTPath2DList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPath2DList.type, xmlOptions);
        }

        public static CTPath2DList parse(File file, XmlOptions xmlOptions) {
            return (CTPath2DList) POIXMLTypeLoader.parse(file, CTPath2DList.type, xmlOptions);
        }

        public static CTPath2DList parse(InputStream inputStream) {
            return (CTPath2DList) POIXMLTypeLoader.parse(inputStream, CTPath2DList.type, (XmlOptions) null);
        }

        public static CTPath2DList parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTPath2DList) POIXMLTypeLoader.parse(inputStream, CTPath2DList.type, xmlOptions);
        }

        public static CTPath2DList parse(Reader reader) {
            return (CTPath2DList) POIXMLTypeLoader.parse(reader, CTPath2DList.type, (XmlOptions) null);
        }

        public static CTPath2DList parse(Reader reader, XmlOptions xmlOptions) {
            return (CTPath2DList) POIXMLTypeLoader.parse(reader, CTPath2DList.type, xmlOptions);
        }

        public static CTPath2DList parse(String str) {
            return (CTPath2DList) POIXMLTypeLoader.parse(str, CTPath2DList.type, (XmlOptions) null);
        }

        public static CTPath2DList parse(String str, XmlOptions xmlOptions) {
            return (CTPath2DList) POIXMLTypeLoader.parse(str, CTPath2DList.type, xmlOptions);
        }

        public static CTPath2DList parse(URL url) {
            return (CTPath2DList) POIXMLTypeLoader.parse(url, CTPath2DList.type, (XmlOptions) null);
        }

        public static CTPath2DList parse(URL url, XmlOptions xmlOptions) {
            return (CTPath2DList) POIXMLTypeLoader.parse(url, CTPath2DList.type, xmlOptions);
        }

        public static CTPath2DList parse(XMLStreamReader xMLStreamReader) {
            return (CTPath2DList) POIXMLTypeLoader.parse(xMLStreamReader, CTPath2DList.type, (XmlOptions) null);
        }

        public static CTPath2DList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTPath2DList) POIXMLTypeLoader.parse(xMLStreamReader, CTPath2DList.type, xmlOptions);
        }

        public static CTPath2DList parse(XMLInputStream xMLInputStream) {
            return (CTPath2DList) POIXMLTypeLoader.parse(xMLInputStream, CTPath2DList.type, (XmlOptions) null);
        }

        public static CTPath2DList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTPath2DList) POIXMLTypeLoader.parse(xMLInputStream, CTPath2DList.type, xmlOptions);
        }

        public static CTPath2DList parse(Node node) {
            return (CTPath2DList) POIXMLTypeLoader.parse(node, CTPath2DList.type, (XmlOptions) null);
        }

        public static CTPath2DList parse(Node node, XmlOptions xmlOptions) {
            return (CTPath2DList) POIXMLTypeLoader.parse(node, CTPath2DList.type, xmlOptions);
        }
    }

    CTPath2D addNewPath();

    CTPath2D getPathArray(int i);

    CTPath2D[] getPathArray();

    List<CTPath2D> getPathList();

    CTPath2D insertNewPath(int i);

    void removePath(int i);

    void setPathArray(int i, CTPath2D cTPath2D);

    void setPathArray(CTPath2D[] cTPath2DArr);

    int sizeOfPathArray();
}
