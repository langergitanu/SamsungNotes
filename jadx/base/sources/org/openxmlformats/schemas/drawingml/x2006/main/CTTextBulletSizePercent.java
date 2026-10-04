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
public interface CTTextBulletSizePercent extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTextBulletSizePercent.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttextbulletsizepercent9b26type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextBulletSizePercent newInstance() {
            return (CTTextBulletSizePercent) POIXMLTypeLoader.newInstance(CTTextBulletSizePercent.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextBulletSizePercent.type, null);
        }

        public static CTTextBulletSizePercent parse(File file) {
            return (CTTextBulletSizePercent) POIXMLTypeLoader.parse(file, CTTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePercent newInstance(XmlOptions xmlOptions) {
            return (CTTextBulletSizePercent) POIXMLTypeLoader.newInstance(CTTextBulletSizePercent.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextBulletSizePercent.type, xmlOptions);
        }

        public static CTTextBulletSizePercent parse(File file, XmlOptions xmlOptions) {
            return (CTTextBulletSizePercent) POIXMLTypeLoader.parse(file, CTTextBulletSizePercent.type, xmlOptions);
        }

        public static CTTextBulletSizePercent parse(InputStream inputStream) {
            return (CTTextBulletSizePercent) POIXMLTypeLoader.parse(inputStream, CTTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePercent parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTextBulletSizePercent) POIXMLTypeLoader.parse(inputStream, CTTextBulletSizePercent.type, xmlOptions);
        }

        public static CTTextBulletSizePercent parse(Reader reader) {
            return (CTTextBulletSizePercent) POIXMLTypeLoader.parse(reader, CTTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePercent parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTextBulletSizePercent) POIXMLTypeLoader.parse(reader, CTTextBulletSizePercent.type, xmlOptions);
        }

        public static CTTextBulletSizePercent parse(String str) {
            return (CTTextBulletSizePercent) POIXMLTypeLoader.parse(str, CTTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePercent parse(String str, XmlOptions xmlOptions) {
            return (CTTextBulletSizePercent) POIXMLTypeLoader.parse(str, CTTextBulletSizePercent.type, xmlOptions);
        }

        public static CTTextBulletSizePercent parse(URL url) {
            return (CTTextBulletSizePercent) POIXMLTypeLoader.parse(url, CTTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePercent parse(URL url, XmlOptions xmlOptions) {
            return (CTTextBulletSizePercent) POIXMLTypeLoader.parse(url, CTTextBulletSizePercent.type, xmlOptions);
        }

        public static CTTextBulletSizePercent parse(XMLStreamReader xMLStreamReader) {
            return (CTTextBulletSizePercent) POIXMLTypeLoader.parse(xMLStreamReader, CTTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePercent parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTextBulletSizePercent) POIXMLTypeLoader.parse(xMLStreamReader, CTTextBulletSizePercent.type, xmlOptions);
        }

        public static CTTextBulletSizePercent parse(XMLInputStream xMLInputStream) {
            return (CTTextBulletSizePercent) POIXMLTypeLoader.parse(xMLInputStream, CTTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePercent parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTextBulletSizePercent) POIXMLTypeLoader.parse(xMLInputStream, CTTextBulletSizePercent.type, xmlOptions);
        }

        public static CTTextBulletSizePercent parse(Node node) {
            return (CTTextBulletSizePercent) POIXMLTypeLoader.parse(node, CTTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static CTTextBulletSizePercent parse(Node node, XmlOptions xmlOptions) {
            return (CTTextBulletSizePercent) POIXMLTypeLoader.parse(node, CTTextBulletSizePercent.type, xmlOptions);
        }
    }

    int getVal();

    boolean isSetVal();

    void setVal(int i);

    void unsetVal();

    STTextBulletSizePercent xgetVal();

    void xsetVal(STTextBulletSizePercent sTTextBulletSizePercent);
}
