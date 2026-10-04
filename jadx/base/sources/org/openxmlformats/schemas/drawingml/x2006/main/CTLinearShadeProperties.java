package org.openxmlformats.schemas.drawingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTLinearShadeProperties extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTLinearShadeProperties.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctlinearshadeproperties7f0ctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTLinearShadeProperties newInstance() {
            return (CTLinearShadeProperties) POIXMLTypeLoader.newInstance(CTLinearShadeProperties.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLinearShadeProperties.type, null);
        }

        public static CTLinearShadeProperties parse(File file) {
            return (CTLinearShadeProperties) POIXMLTypeLoader.parse(file, CTLinearShadeProperties.type, (XmlOptions) null);
        }

        public static CTLinearShadeProperties newInstance(XmlOptions xmlOptions) {
            return (CTLinearShadeProperties) POIXMLTypeLoader.newInstance(CTLinearShadeProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLinearShadeProperties.type, xmlOptions);
        }

        public static CTLinearShadeProperties parse(File file, XmlOptions xmlOptions) {
            return (CTLinearShadeProperties) POIXMLTypeLoader.parse(file, CTLinearShadeProperties.type, xmlOptions);
        }

        public static CTLinearShadeProperties parse(InputStream inputStream) {
            return (CTLinearShadeProperties) POIXMLTypeLoader.parse(inputStream, CTLinearShadeProperties.type, (XmlOptions) null);
        }

        public static CTLinearShadeProperties parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTLinearShadeProperties) POIXMLTypeLoader.parse(inputStream, CTLinearShadeProperties.type, xmlOptions);
        }

        public static CTLinearShadeProperties parse(Reader reader) {
            return (CTLinearShadeProperties) POIXMLTypeLoader.parse(reader, CTLinearShadeProperties.type, (XmlOptions) null);
        }

        public static CTLinearShadeProperties parse(Reader reader, XmlOptions xmlOptions) {
            return (CTLinearShadeProperties) POIXMLTypeLoader.parse(reader, CTLinearShadeProperties.type, xmlOptions);
        }

        public static CTLinearShadeProperties parse(String str) {
            return (CTLinearShadeProperties) POIXMLTypeLoader.parse(str, CTLinearShadeProperties.type, (XmlOptions) null);
        }

        public static CTLinearShadeProperties parse(String str, XmlOptions xmlOptions) {
            return (CTLinearShadeProperties) POIXMLTypeLoader.parse(str, CTLinearShadeProperties.type, xmlOptions);
        }

        public static CTLinearShadeProperties parse(URL url) {
            return (CTLinearShadeProperties) POIXMLTypeLoader.parse(url, CTLinearShadeProperties.type, (XmlOptions) null);
        }

        public static CTLinearShadeProperties parse(URL url, XmlOptions xmlOptions) {
            return (CTLinearShadeProperties) POIXMLTypeLoader.parse(url, CTLinearShadeProperties.type, xmlOptions);
        }

        public static CTLinearShadeProperties parse(XMLStreamReader xMLStreamReader) {
            return (CTLinearShadeProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTLinearShadeProperties.type, (XmlOptions) null);
        }

        public static CTLinearShadeProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTLinearShadeProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTLinearShadeProperties.type, xmlOptions);
        }

        public static CTLinearShadeProperties parse(XMLInputStream xMLInputStream) {
            return (CTLinearShadeProperties) POIXMLTypeLoader.parse(xMLInputStream, CTLinearShadeProperties.type, (XmlOptions) null);
        }

        public static CTLinearShadeProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTLinearShadeProperties) POIXMLTypeLoader.parse(xMLInputStream, CTLinearShadeProperties.type, xmlOptions);
        }

        public static CTLinearShadeProperties parse(Node node) {
            return (CTLinearShadeProperties) POIXMLTypeLoader.parse(node, CTLinearShadeProperties.type, (XmlOptions) null);
        }

        public static CTLinearShadeProperties parse(Node node, XmlOptions xmlOptions) {
            return (CTLinearShadeProperties) POIXMLTypeLoader.parse(node, CTLinearShadeProperties.type, xmlOptions);
        }
    }

    int getAng();

    boolean getScaled();

    boolean isSetAng();

    boolean isSetScaled();

    void setAng(int i);

    void setScaled(boolean z);

    void unsetAng();

    void unsetScaled();

    STPositiveFixedAngle xgetAng();

    XmlBoolean xgetScaled();

    void xsetAng(STPositiveFixedAngle sTPositiveFixedAngle);

    void xsetScaled(XmlBoolean xmlBoolean);
}
