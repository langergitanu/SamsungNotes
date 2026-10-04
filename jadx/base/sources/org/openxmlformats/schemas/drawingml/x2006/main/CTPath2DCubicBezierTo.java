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
public interface CTPath2DCubicBezierTo extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTPath2DCubicBezierTo.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctpath2dcubicbezierto5a1etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTPath2DCubicBezierTo newInstance() {
            return (CTPath2DCubicBezierTo) POIXMLTypeLoader.newInstance(CTPath2DCubicBezierTo.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPath2DCubicBezierTo.type, null);
        }

        public static CTPath2DCubicBezierTo parse(File file) {
            return (CTPath2DCubicBezierTo) POIXMLTypeLoader.parse(file, CTPath2DCubicBezierTo.type, (XmlOptions) null);
        }

        public static CTPath2DCubicBezierTo newInstance(XmlOptions xmlOptions) {
            return (CTPath2DCubicBezierTo) POIXMLTypeLoader.newInstance(CTPath2DCubicBezierTo.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPath2DCubicBezierTo.type, xmlOptions);
        }

        public static CTPath2DCubicBezierTo parse(File file, XmlOptions xmlOptions) {
            return (CTPath2DCubicBezierTo) POIXMLTypeLoader.parse(file, CTPath2DCubicBezierTo.type, xmlOptions);
        }

        public static CTPath2DCubicBezierTo parse(InputStream inputStream) {
            return (CTPath2DCubicBezierTo) POIXMLTypeLoader.parse(inputStream, CTPath2DCubicBezierTo.type, (XmlOptions) null);
        }

        public static CTPath2DCubicBezierTo parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTPath2DCubicBezierTo) POIXMLTypeLoader.parse(inputStream, CTPath2DCubicBezierTo.type, xmlOptions);
        }

        public static CTPath2DCubicBezierTo parse(Reader reader) {
            return (CTPath2DCubicBezierTo) POIXMLTypeLoader.parse(reader, CTPath2DCubicBezierTo.type, (XmlOptions) null);
        }

        public static CTPath2DCubicBezierTo parse(Reader reader, XmlOptions xmlOptions) {
            return (CTPath2DCubicBezierTo) POIXMLTypeLoader.parse(reader, CTPath2DCubicBezierTo.type, xmlOptions);
        }

        public static CTPath2DCubicBezierTo parse(String str) {
            return (CTPath2DCubicBezierTo) POIXMLTypeLoader.parse(str, CTPath2DCubicBezierTo.type, (XmlOptions) null);
        }

        public static CTPath2DCubicBezierTo parse(String str, XmlOptions xmlOptions) {
            return (CTPath2DCubicBezierTo) POIXMLTypeLoader.parse(str, CTPath2DCubicBezierTo.type, xmlOptions);
        }

        public static CTPath2DCubicBezierTo parse(URL url) {
            return (CTPath2DCubicBezierTo) POIXMLTypeLoader.parse(url, CTPath2DCubicBezierTo.type, (XmlOptions) null);
        }

        public static CTPath2DCubicBezierTo parse(URL url, XmlOptions xmlOptions) {
            return (CTPath2DCubicBezierTo) POIXMLTypeLoader.parse(url, CTPath2DCubicBezierTo.type, xmlOptions);
        }

        public static CTPath2DCubicBezierTo parse(XMLStreamReader xMLStreamReader) {
            return (CTPath2DCubicBezierTo) POIXMLTypeLoader.parse(xMLStreamReader, CTPath2DCubicBezierTo.type, (XmlOptions) null);
        }

        public static CTPath2DCubicBezierTo parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTPath2DCubicBezierTo) POIXMLTypeLoader.parse(xMLStreamReader, CTPath2DCubicBezierTo.type, xmlOptions);
        }

        public static CTPath2DCubicBezierTo parse(XMLInputStream xMLInputStream) {
            return (CTPath2DCubicBezierTo) POIXMLTypeLoader.parse(xMLInputStream, CTPath2DCubicBezierTo.type, (XmlOptions) null);
        }

        public static CTPath2DCubicBezierTo parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTPath2DCubicBezierTo) POIXMLTypeLoader.parse(xMLInputStream, CTPath2DCubicBezierTo.type, xmlOptions);
        }

        public static CTPath2DCubicBezierTo parse(Node node) {
            return (CTPath2DCubicBezierTo) POIXMLTypeLoader.parse(node, CTPath2DCubicBezierTo.type, (XmlOptions) null);
        }

        public static CTPath2DCubicBezierTo parse(Node node, XmlOptions xmlOptions) {
            return (CTPath2DCubicBezierTo) POIXMLTypeLoader.parse(node, CTPath2DCubicBezierTo.type, xmlOptions);
        }
    }

    CTAdjPoint2D addNewPt();

    CTAdjPoint2D getPtArray(int i);

    CTAdjPoint2D[] getPtArray();

    List<CTAdjPoint2D> getPtList();

    CTAdjPoint2D insertNewPt(int i);

    void removePt(int i);

    void setPtArray(int i, CTAdjPoint2D cTAdjPoint2D);

    void setPtArray(CTAdjPoint2D[] cTAdjPoint2DArr);

    int sizeOfPtArray();
}
