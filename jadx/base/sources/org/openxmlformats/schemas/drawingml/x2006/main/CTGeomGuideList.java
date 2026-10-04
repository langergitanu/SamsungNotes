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
public interface CTGeomGuideList extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTGeomGuideList.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctgeomguidelist364ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTGeomGuideList newInstance() {
            return (CTGeomGuideList) POIXMLTypeLoader.newInstance(CTGeomGuideList.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGeomGuideList.type, null);
        }

        public static CTGeomGuideList parse(File file) {
            return (CTGeomGuideList) POIXMLTypeLoader.parse(file, CTGeomGuideList.type, (XmlOptions) null);
        }

        public static CTGeomGuideList newInstance(XmlOptions xmlOptions) {
            return (CTGeomGuideList) POIXMLTypeLoader.newInstance(CTGeomGuideList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGeomGuideList.type, xmlOptions);
        }

        public static CTGeomGuideList parse(File file, XmlOptions xmlOptions) {
            return (CTGeomGuideList) POIXMLTypeLoader.parse(file, CTGeomGuideList.type, xmlOptions);
        }

        public static CTGeomGuideList parse(InputStream inputStream) {
            return (CTGeomGuideList) POIXMLTypeLoader.parse(inputStream, CTGeomGuideList.type, (XmlOptions) null);
        }

        public static CTGeomGuideList parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTGeomGuideList) POIXMLTypeLoader.parse(inputStream, CTGeomGuideList.type, xmlOptions);
        }

        public static CTGeomGuideList parse(Reader reader) {
            return (CTGeomGuideList) POIXMLTypeLoader.parse(reader, CTGeomGuideList.type, (XmlOptions) null);
        }

        public static CTGeomGuideList parse(Reader reader, XmlOptions xmlOptions) {
            return (CTGeomGuideList) POIXMLTypeLoader.parse(reader, CTGeomGuideList.type, xmlOptions);
        }

        public static CTGeomGuideList parse(String str) {
            return (CTGeomGuideList) POIXMLTypeLoader.parse(str, CTGeomGuideList.type, (XmlOptions) null);
        }

        public static CTGeomGuideList parse(String str, XmlOptions xmlOptions) {
            return (CTGeomGuideList) POIXMLTypeLoader.parse(str, CTGeomGuideList.type, xmlOptions);
        }

        public static CTGeomGuideList parse(URL url) {
            return (CTGeomGuideList) POIXMLTypeLoader.parse(url, CTGeomGuideList.type, (XmlOptions) null);
        }

        public static CTGeomGuideList parse(URL url, XmlOptions xmlOptions) {
            return (CTGeomGuideList) POIXMLTypeLoader.parse(url, CTGeomGuideList.type, xmlOptions);
        }

        public static CTGeomGuideList parse(XMLStreamReader xMLStreamReader) {
            return (CTGeomGuideList) POIXMLTypeLoader.parse(xMLStreamReader, CTGeomGuideList.type, (XmlOptions) null);
        }

        public static CTGeomGuideList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTGeomGuideList) POIXMLTypeLoader.parse(xMLStreamReader, CTGeomGuideList.type, xmlOptions);
        }

        public static CTGeomGuideList parse(XMLInputStream xMLInputStream) {
            return (CTGeomGuideList) POIXMLTypeLoader.parse(xMLInputStream, CTGeomGuideList.type, (XmlOptions) null);
        }

        public static CTGeomGuideList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTGeomGuideList) POIXMLTypeLoader.parse(xMLInputStream, CTGeomGuideList.type, xmlOptions);
        }

        public static CTGeomGuideList parse(Node node) {
            return (CTGeomGuideList) POIXMLTypeLoader.parse(node, CTGeomGuideList.type, (XmlOptions) null);
        }

        public static CTGeomGuideList parse(Node node, XmlOptions xmlOptions) {
            return (CTGeomGuideList) POIXMLTypeLoader.parse(node, CTGeomGuideList.type, xmlOptions);
        }
    }

    CTGeomGuide addNewGd();

    CTGeomGuide getGdArray(int i);

    CTGeomGuide[] getGdArray();

    List<CTGeomGuide> getGdList();

    CTGeomGuide insertNewGd(int i);

    void removeGd(int i);

    void setGdArray(int i, CTGeomGuide cTGeomGuide);

    void setGdArray(CTGeomGuide[] cTGeomGuideArr);

    int sizeOfGdArray();
}
