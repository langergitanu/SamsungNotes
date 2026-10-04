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
public interface CTAdjustHandleList extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTAdjustHandleList.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctadjusthandlelistfdb0type");

    public static final class Factory {
        private Factory() {
        }

        public static CTAdjustHandleList newInstance() {
            return (CTAdjustHandleList) POIXMLTypeLoader.newInstance(CTAdjustHandleList.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTAdjustHandleList.type, null);
        }

        public static CTAdjustHandleList parse(File file) {
            return (CTAdjustHandleList) POIXMLTypeLoader.parse(file, CTAdjustHandleList.type, (XmlOptions) null);
        }

        public static CTAdjustHandleList newInstance(XmlOptions xmlOptions) {
            return (CTAdjustHandleList) POIXMLTypeLoader.newInstance(CTAdjustHandleList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTAdjustHandleList.type, xmlOptions);
        }

        public static CTAdjustHandleList parse(File file, XmlOptions xmlOptions) {
            return (CTAdjustHandleList) POIXMLTypeLoader.parse(file, CTAdjustHandleList.type, xmlOptions);
        }

        public static CTAdjustHandleList parse(InputStream inputStream) {
            return (CTAdjustHandleList) POIXMLTypeLoader.parse(inputStream, CTAdjustHandleList.type, (XmlOptions) null);
        }

        public static CTAdjustHandleList parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTAdjustHandleList) POIXMLTypeLoader.parse(inputStream, CTAdjustHandleList.type, xmlOptions);
        }

        public static CTAdjustHandleList parse(Reader reader) {
            return (CTAdjustHandleList) POIXMLTypeLoader.parse(reader, CTAdjustHandleList.type, (XmlOptions) null);
        }

        public static CTAdjustHandleList parse(Reader reader, XmlOptions xmlOptions) {
            return (CTAdjustHandleList) POIXMLTypeLoader.parse(reader, CTAdjustHandleList.type, xmlOptions);
        }

        public static CTAdjustHandleList parse(String str) {
            return (CTAdjustHandleList) POIXMLTypeLoader.parse(str, CTAdjustHandleList.type, (XmlOptions) null);
        }

        public static CTAdjustHandleList parse(String str, XmlOptions xmlOptions) {
            return (CTAdjustHandleList) POIXMLTypeLoader.parse(str, CTAdjustHandleList.type, xmlOptions);
        }

        public static CTAdjustHandleList parse(URL url) {
            return (CTAdjustHandleList) POIXMLTypeLoader.parse(url, CTAdjustHandleList.type, (XmlOptions) null);
        }

        public static CTAdjustHandleList parse(URL url, XmlOptions xmlOptions) {
            return (CTAdjustHandleList) POIXMLTypeLoader.parse(url, CTAdjustHandleList.type, xmlOptions);
        }

        public static CTAdjustHandleList parse(XMLStreamReader xMLStreamReader) {
            return (CTAdjustHandleList) POIXMLTypeLoader.parse(xMLStreamReader, CTAdjustHandleList.type, (XmlOptions) null);
        }

        public static CTAdjustHandleList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTAdjustHandleList) POIXMLTypeLoader.parse(xMLStreamReader, CTAdjustHandleList.type, xmlOptions);
        }

        public static CTAdjustHandleList parse(XMLInputStream xMLInputStream) {
            return (CTAdjustHandleList) POIXMLTypeLoader.parse(xMLInputStream, CTAdjustHandleList.type, (XmlOptions) null);
        }

        public static CTAdjustHandleList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTAdjustHandleList) POIXMLTypeLoader.parse(xMLInputStream, CTAdjustHandleList.type, xmlOptions);
        }

        public static CTAdjustHandleList parse(Node node) {
            return (CTAdjustHandleList) POIXMLTypeLoader.parse(node, CTAdjustHandleList.type, (XmlOptions) null);
        }

        public static CTAdjustHandleList parse(Node node, XmlOptions xmlOptions) {
            return (CTAdjustHandleList) POIXMLTypeLoader.parse(node, CTAdjustHandleList.type, xmlOptions);
        }
    }

    CTPolarAdjustHandle addNewAhPolar();

    CTXYAdjustHandle addNewAhXY();

    CTPolarAdjustHandle getAhPolarArray(int i);

    CTPolarAdjustHandle[] getAhPolarArray();

    List<CTPolarAdjustHandle> getAhPolarList();

    CTXYAdjustHandle getAhXYArray(int i);

    CTXYAdjustHandle[] getAhXYArray();

    List<CTXYAdjustHandle> getAhXYList();

    CTPolarAdjustHandle insertNewAhPolar(int i);

    CTXYAdjustHandle insertNewAhXY(int i);

    void removeAhPolar(int i);

    void removeAhXY(int i);

    void setAhPolarArray(int i, CTPolarAdjustHandle cTPolarAdjustHandle);

    void setAhPolarArray(CTPolarAdjustHandle[] cTPolarAdjustHandleArr);

    void setAhXYArray(int i, CTXYAdjustHandle cTXYAdjustHandle);

    void setAhXYArray(CTXYAdjustHandle[] cTXYAdjustHandleArr);

    int sizeOfAhPolarArray();

    int sizeOfAhXYArray();
}
