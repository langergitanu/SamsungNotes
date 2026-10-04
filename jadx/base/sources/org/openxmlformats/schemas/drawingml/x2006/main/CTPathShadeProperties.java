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
import org.openxmlformats.schemas.drawingml.x2006.main.STPathShadeType;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTPathShadeProperties extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTPathShadeProperties.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctpathshadeproperties7ccctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTPathShadeProperties newInstance() {
            return (CTPathShadeProperties) POIXMLTypeLoader.newInstance(CTPathShadeProperties.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPathShadeProperties.type, null);
        }

        public static CTPathShadeProperties parse(File file) {
            return (CTPathShadeProperties) POIXMLTypeLoader.parse(file, CTPathShadeProperties.type, (XmlOptions) null);
        }

        public static CTPathShadeProperties newInstance(XmlOptions xmlOptions) {
            return (CTPathShadeProperties) POIXMLTypeLoader.newInstance(CTPathShadeProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPathShadeProperties.type, xmlOptions);
        }

        public static CTPathShadeProperties parse(File file, XmlOptions xmlOptions) {
            return (CTPathShadeProperties) POIXMLTypeLoader.parse(file, CTPathShadeProperties.type, xmlOptions);
        }

        public static CTPathShadeProperties parse(InputStream inputStream) {
            return (CTPathShadeProperties) POIXMLTypeLoader.parse(inputStream, CTPathShadeProperties.type, (XmlOptions) null);
        }

        public static CTPathShadeProperties parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTPathShadeProperties) POIXMLTypeLoader.parse(inputStream, CTPathShadeProperties.type, xmlOptions);
        }

        public static CTPathShadeProperties parse(Reader reader) {
            return (CTPathShadeProperties) POIXMLTypeLoader.parse(reader, CTPathShadeProperties.type, (XmlOptions) null);
        }

        public static CTPathShadeProperties parse(Reader reader, XmlOptions xmlOptions) {
            return (CTPathShadeProperties) POIXMLTypeLoader.parse(reader, CTPathShadeProperties.type, xmlOptions);
        }

        public static CTPathShadeProperties parse(String str) {
            return (CTPathShadeProperties) POIXMLTypeLoader.parse(str, CTPathShadeProperties.type, (XmlOptions) null);
        }

        public static CTPathShadeProperties parse(String str, XmlOptions xmlOptions) {
            return (CTPathShadeProperties) POIXMLTypeLoader.parse(str, CTPathShadeProperties.type, xmlOptions);
        }

        public static CTPathShadeProperties parse(URL url) {
            return (CTPathShadeProperties) POIXMLTypeLoader.parse(url, CTPathShadeProperties.type, (XmlOptions) null);
        }

        public static CTPathShadeProperties parse(URL url, XmlOptions xmlOptions) {
            return (CTPathShadeProperties) POIXMLTypeLoader.parse(url, CTPathShadeProperties.type, xmlOptions);
        }

        public static CTPathShadeProperties parse(XMLStreamReader xMLStreamReader) {
            return (CTPathShadeProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTPathShadeProperties.type, (XmlOptions) null);
        }

        public static CTPathShadeProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTPathShadeProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTPathShadeProperties.type, xmlOptions);
        }

        public static CTPathShadeProperties parse(XMLInputStream xMLInputStream) {
            return (CTPathShadeProperties) POIXMLTypeLoader.parse(xMLInputStream, CTPathShadeProperties.type, (XmlOptions) null);
        }

        public static CTPathShadeProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTPathShadeProperties) POIXMLTypeLoader.parse(xMLInputStream, CTPathShadeProperties.type, xmlOptions);
        }

        public static CTPathShadeProperties parse(Node node) {
            return (CTPathShadeProperties) POIXMLTypeLoader.parse(node, CTPathShadeProperties.type, (XmlOptions) null);
        }

        public static CTPathShadeProperties parse(Node node, XmlOptions xmlOptions) {
            return (CTPathShadeProperties) POIXMLTypeLoader.parse(node, CTPathShadeProperties.type, xmlOptions);
        }
    }

    CTRelativeRect addNewFillToRect();

    CTRelativeRect getFillToRect();

    STPathShadeType.Enum getPath();

    boolean isSetFillToRect();

    boolean isSetPath();

    void setFillToRect(CTRelativeRect cTRelativeRect);

    void setPath(STPathShadeType.Enum r12);

    void unsetFillToRect();

    void unsetPath();

    STPathShadeType xgetPath();

    void xsetPath(STPathShadeType sTPathShadeType);
}
