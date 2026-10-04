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
public interface CTTextBulletSizePoint extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTextBulletSizePoint.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttextbulletsizepointe4f1type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextBulletSizePoint newInstance() {
            return (CTTextBulletSizePoint) POIXMLTypeLoader.newInstance(CTTextBulletSizePoint.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextBulletSizePoint.type, null);
        }

        public static CTTextBulletSizePoint parse(File file) {
            return (CTTextBulletSizePoint) POIXMLTypeLoader.parse(file, CTTextBulletSizePoint.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePoint newInstance(XmlOptions xmlOptions) {
            return (CTTextBulletSizePoint) POIXMLTypeLoader.newInstance(CTTextBulletSizePoint.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextBulletSizePoint.type, xmlOptions);
        }

        public static CTTextBulletSizePoint parse(File file, XmlOptions xmlOptions) {
            return (CTTextBulletSizePoint) POIXMLTypeLoader.parse(file, CTTextBulletSizePoint.type, xmlOptions);
        }

        public static CTTextBulletSizePoint parse(InputStream inputStream) {
            return (CTTextBulletSizePoint) POIXMLTypeLoader.parse(inputStream, CTTextBulletSizePoint.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePoint parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTextBulletSizePoint) POIXMLTypeLoader.parse(inputStream, CTTextBulletSizePoint.type, xmlOptions);
        }

        public static CTTextBulletSizePoint parse(Reader reader) {
            return (CTTextBulletSizePoint) POIXMLTypeLoader.parse(reader, CTTextBulletSizePoint.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePoint parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTextBulletSizePoint) POIXMLTypeLoader.parse(reader, CTTextBulletSizePoint.type, xmlOptions);
        }

        public static CTTextBulletSizePoint parse(String str) {
            return (CTTextBulletSizePoint) POIXMLTypeLoader.parse(str, CTTextBulletSizePoint.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePoint parse(String str, XmlOptions xmlOptions) {
            return (CTTextBulletSizePoint) POIXMLTypeLoader.parse(str, CTTextBulletSizePoint.type, xmlOptions);
        }

        public static CTTextBulletSizePoint parse(URL url) {
            return (CTTextBulletSizePoint) POIXMLTypeLoader.parse(url, CTTextBulletSizePoint.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePoint parse(URL url, XmlOptions xmlOptions) {
            return (CTTextBulletSizePoint) POIXMLTypeLoader.parse(url, CTTextBulletSizePoint.type, xmlOptions);
        }

        public static CTTextBulletSizePoint parse(XMLStreamReader xMLStreamReader) {
            return (CTTextBulletSizePoint) POIXMLTypeLoader.parse(xMLStreamReader, CTTextBulletSizePoint.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePoint parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTextBulletSizePoint) POIXMLTypeLoader.parse(xMLStreamReader, CTTextBulletSizePoint.type, xmlOptions);
        }

        public static CTTextBulletSizePoint parse(XMLInputStream xMLInputStream) {
            return (CTTextBulletSizePoint) POIXMLTypeLoader.parse(xMLInputStream, CTTextBulletSizePoint.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePoint parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTextBulletSizePoint) POIXMLTypeLoader.parse(xMLInputStream, CTTextBulletSizePoint.type, xmlOptions);
        }

        public static CTTextBulletSizePoint parse(Node node) {
            return (CTTextBulletSizePoint) POIXMLTypeLoader.parse(node, CTTextBulletSizePoint.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePoint parse(Node node, XmlOptions xmlOptions) {
            return (CTTextBulletSizePoint) POIXMLTypeLoader.parse(node, CTTextBulletSizePoint.type, xmlOptions);
        }
    }

    int getVal();

    boolean isSetVal();

    void setVal(int i);

    void unsetVal();

    STTextFontSize xgetVal();

    void xsetVal(STTextFontSize sTTextFontSize);
}
