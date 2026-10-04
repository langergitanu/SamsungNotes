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
public interface CTSolidColorFillProperties extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTSolidColorFillProperties.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctsolidcolorfillproperties9cc9type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSolidColorFillProperties newInstance() {
            return (CTSolidColorFillProperties) POIXMLTypeLoader.newInstance(CTSolidColorFillProperties.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSolidColorFillProperties.type, null);
        }

        public static CTSolidColorFillProperties parse(File file) {
            return (CTSolidColorFillProperties) POIXMLTypeLoader.parse(file, CTSolidColorFillProperties.type, (XmlOptions) null);
        }

        public static CTSolidColorFillProperties newInstance(XmlOptions xmlOptions) {
            return (CTSolidColorFillProperties) POIXMLTypeLoader.newInstance(CTSolidColorFillProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSolidColorFillProperties.type, xmlOptions);
        }

        public static CTSolidColorFillProperties parse(File file, XmlOptions xmlOptions) {
            return (CTSolidColorFillProperties) POIXMLTypeLoader.parse(file, CTSolidColorFillProperties.type, xmlOptions);
        }

        public static CTSolidColorFillProperties parse(InputStream inputStream) {
            return (CTSolidColorFillProperties) POIXMLTypeLoader.parse(inputStream, CTSolidColorFillProperties.type, (XmlOptions) null);
        }

        public static CTSolidColorFillProperties parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTSolidColorFillProperties) POIXMLTypeLoader.parse(inputStream, CTSolidColorFillProperties.type, xmlOptions);
        }

        public static CTSolidColorFillProperties parse(Reader reader) {
            return (CTSolidColorFillProperties) POIXMLTypeLoader.parse(reader, CTSolidColorFillProperties.type, (XmlOptions) null);
        }

        public static CTSolidColorFillProperties parse(Reader reader, XmlOptions xmlOptions) {
            return (CTSolidColorFillProperties) POIXMLTypeLoader.parse(reader, CTSolidColorFillProperties.type, xmlOptions);
        }

        public static CTSolidColorFillProperties parse(String str) {
            return (CTSolidColorFillProperties) POIXMLTypeLoader.parse(str, CTSolidColorFillProperties.type, (XmlOptions) null);
        }

        public static CTSolidColorFillProperties parse(String str, XmlOptions xmlOptions) {
            return (CTSolidColorFillProperties) POIXMLTypeLoader.parse(str, CTSolidColorFillProperties.type, xmlOptions);
        }

        public static CTSolidColorFillProperties parse(URL url) {
            return (CTSolidColorFillProperties) POIXMLTypeLoader.parse(url, CTSolidColorFillProperties.type, (XmlOptions) null);
        }

        public static CTSolidColorFillProperties parse(URL url, XmlOptions xmlOptions) {
            return (CTSolidColorFillProperties) POIXMLTypeLoader.parse(url, CTSolidColorFillProperties.type, xmlOptions);
        }

        public static CTSolidColorFillProperties parse(XMLStreamReader xMLStreamReader) {
            return (CTSolidColorFillProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTSolidColorFillProperties.type, (XmlOptions) null);
        }

        public static CTSolidColorFillProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTSolidColorFillProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTSolidColorFillProperties.type, xmlOptions);
        }

        public static CTSolidColorFillProperties parse(XMLInputStream xMLInputStream) {
            return (CTSolidColorFillProperties) POIXMLTypeLoader.parse(xMLInputStream, CTSolidColorFillProperties.type, (XmlOptions) null);
        }

        public static CTSolidColorFillProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTSolidColorFillProperties) POIXMLTypeLoader.parse(xMLInputStream, CTSolidColorFillProperties.type, xmlOptions);
        }

        public static CTSolidColorFillProperties parse(Node node) {
            return (CTSolidColorFillProperties) POIXMLTypeLoader.parse(node, CTSolidColorFillProperties.type, (XmlOptions) null);
        }

        public static CTSolidColorFillProperties parse(Node node, XmlOptions xmlOptions) {
            return (CTSolidColorFillProperties) POIXMLTypeLoader.parse(node, CTSolidColorFillProperties.type, xmlOptions);
        }
    }

    CTHslColor addNewHslClr();

    CTPresetColor addNewPrstClr();

    CTSchemeColor addNewSchemeClr();

    CTScRgbColor addNewScrgbClr();

    CTSRgbColor addNewSrgbClr();

    CTSystemColor addNewSysClr();

    CTHslColor getHslClr();

    CTPresetColor getPrstClr();

    CTSchemeColor getSchemeClr();

    CTScRgbColor getScrgbClr();

    CTSRgbColor getSrgbClr();

    CTSystemColor getSysClr();

    boolean isSetHslClr();

    boolean isSetPrstClr();

    boolean isSetSchemeClr();

    boolean isSetScrgbClr();

    boolean isSetSrgbClr();

    boolean isSetSysClr();

    void setHslClr(CTHslColor cTHslColor);

    void setPrstClr(CTPresetColor cTPresetColor);

    void setSchemeClr(CTSchemeColor cTSchemeColor);

    void setScrgbClr(CTScRgbColor cTScRgbColor);

    void setSrgbClr(CTSRgbColor cTSRgbColor);

    void setSysClr(CTSystemColor cTSystemColor);

    void unsetHslClr();

    void unsetPrstClr();

    void unsetSchemeClr();

    void unsetScrgbClr();

    void unsetSrgbClr();

    void unsetSysClr();
}
