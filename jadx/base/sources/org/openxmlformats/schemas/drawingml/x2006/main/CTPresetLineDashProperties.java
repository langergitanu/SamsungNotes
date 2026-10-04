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
import org.openxmlformats.schemas.drawingml.x2006.main.STPresetLineDashVal;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTPresetLineDashProperties extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTPresetLineDashProperties.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctpresetlinedashproperties4553type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPresetLineDashProperties newInstance() {
            return (CTPresetLineDashProperties) POIXMLTypeLoader.newInstance(CTPresetLineDashProperties.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPresetLineDashProperties.type, null);
        }

        public static CTPresetLineDashProperties parse(File file) {
            return (CTPresetLineDashProperties) POIXMLTypeLoader.parse(file, CTPresetLineDashProperties.type, (XmlOptions) null);
        }

        public static CTPresetLineDashProperties newInstance(XmlOptions xmlOptions) {
            return (CTPresetLineDashProperties) POIXMLTypeLoader.newInstance(CTPresetLineDashProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPresetLineDashProperties.type, xmlOptions);
        }

        public static CTPresetLineDashProperties parse(File file, XmlOptions xmlOptions) {
            return (CTPresetLineDashProperties) POIXMLTypeLoader.parse(file, CTPresetLineDashProperties.type, xmlOptions);
        }

        public static CTPresetLineDashProperties parse(InputStream inputStream) {
            return (CTPresetLineDashProperties) POIXMLTypeLoader.parse(inputStream, CTPresetLineDashProperties.type, (XmlOptions) null);
        }

        public static CTPresetLineDashProperties parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTPresetLineDashProperties) POIXMLTypeLoader.parse(inputStream, CTPresetLineDashProperties.type, xmlOptions);
        }

        public static CTPresetLineDashProperties parse(Reader reader) {
            return (CTPresetLineDashProperties) POIXMLTypeLoader.parse(reader, CTPresetLineDashProperties.type, (XmlOptions) null);
        }

        public static CTPresetLineDashProperties parse(Reader reader, XmlOptions xmlOptions) {
            return (CTPresetLineDashProperties) POIXMLTypeLoader.parse(reader, CTPresetLineDashProperties.type, xmlOptions);
        }

        public static CTPresetLineDashProperties parse(String str) {
            return (CTPresetLineDashProperties) POIXMLTypeLoader.parse(str, CTPresetLineDashProperties.type, (XmlOptions) null);
        }

        public static CTPresetLineDashProperties parse(String str, XmlOptions xmlOptions) {
            return (CTPresetLineDashProperties) POIXMLTypeLoader.parse(str, CTPresetLineDashProperties.type, xmlOptions);
        }

        public static CTPresetLineDashProperties parse(URL url) {
            return (CTPresetLineDashProperties) POIXMLTypeLoader.parse(url, CTPresetLineDashProperties.type, (XmlOptions) null);
        }

        public static CTPresetLineDashProperties parse(URL url, XmlOptions xmlOptions) {
            return (CTPresetLineDashProperties) POIXMLTypeLoader.parse(url, CTPresetLineDashProperties.type, xmlOptions);
        }

        public static CTPresetLineDashProperties parse(XMLStreamReader xMLStreamReader) {
            return (CTPresetLineDashProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTPresetLineDashProperties.type, (XmlOptions) null);
        }

        public static CTPresetLineDashProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTPresetLineDashProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTPresetLineDashProperties.type, xmlOptions);
        }

        public static CTPresetLineDashProperties parse(XMLInputStream xMLInputStream) {
            return (CTPresetLineDashProperties) POIXMLTypeLoader.parse(xMLInputStream, CTPresetLineDashProperties.type, (XmlOptions) null);
        }

        public static CTPresetLineDashProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTPresetLineDashProperties) POIXMLTypeLoader.parse(xMLInputStream, CTPresetLineDashProperties.type, xmlOptions);
        }

        public static CTPresetLineDashProperties parse(Node node) {
            return (CTPresetLineDashProperties) POIXMLTypeLoader.parse(node, CTPresetLineDashProperties.type, (XmlOptions) null);
        }

        public static CTPresetLineDashProperties parse(Node node, XmlOptions xmlOptions) {
            return (CTPresetLineDashProperties) POIXMLTypeLoader.parse(node, CTPresetLineDashProperties.type, xmlOptions);
        }
    }

    STPresetLineDashVal.Enum getVal();

    boolean isSetVal();

    void setVal(STPresetLineDashVal.Enum r12);

    void unsetVal();

    STPresetLineDashVal xgetVal();

    void xsetVal(STPresetLineDashVal sTPresetLineDashVal);
}
