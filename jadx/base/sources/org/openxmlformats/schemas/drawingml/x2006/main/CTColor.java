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
public interface CTColor extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTColor.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctcolorb114type");

    public static final class Factory {
        private Factory() {
        }

        public static CTColor newInstance() {
            return (CTColor) POIXMLTypeLoader.newInstance(CTColor.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTColor.type, null);
        }

        public static CTColor parse(File file) {
            return (CTColor) POIXMLTypeLoader.parse(file, CTColor.type, (XmlOptions) null);
        }

        public static CTColor newInstance(XmlOptions xmlOptions) {
            return (CTColor) POIXMLTypeLoader.newInstance(CTColor.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTColor.type, xmlOptions);
        }

        public static CTColor parse(File file, XmlOptions xmlOptions) {
            return (CTColor) POIXMLTypeLoader.parse(file, CTColor.type, xmlOptions);
        }

        public static CTColor parse(InputStream inputStream) {
            return (CTColor) POIXMLTypeLoader.parse(inputStream, CTColor.type, (XmlOptions) null);
        }

        public static CTColor parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTColor) POIXMLTypeLoader.parse(inputStream, CTColor.type, xmlOptions);
        }

        public static CTColor parse(Reader reader) {
            return (CTColor) POIXMLTypeLoader.parse(reader, CTColor.type, (XmlOptions) null);
        }

        public static CTColor parse(Reader reader, XmlOptions xmlOptions) {
            return (CTColor) POIXMLTypeLoader.parse(reader, CTColor.type, xmlOptions);
        }

        public static CTColor parse(String str) {
            return (CTColor) POIXMLTypeLoader.parse(str, CTColor.type, (XmlOptions) null);
        }

        public static CTColor parse(String str, XmlOptions xmlOptions) {
            return (CTColor) POIXMLTypeLoader.parse(str, CTColor.type, xmlOptions);
        }

        public static CTColor parse(URL url) {
            return (CTColor) POIXMLTypeLoader.parse(url, CTColor.type, (XmlOptions) null);
        }

        public static CTColor parse(URL url, XmlOptions xmlOptions) {
            return (CTColor) POIXMLTypeLoader.parse(url, CTColor.type, xmlOptions);
        }

        public static CTColor parse(XMLStreamReader xMLStreamReader) {
            return (CTColor) POIXMLTypeLoader.parse(xMLStreamReader, CTColor.type, (XmlOptions) null);
        }

        public static CTColor parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTColor) POIXMLTypeLoader.parse(xMLStreamReader, CTColor.type, xmlOptions);
        }

        public static CTColor parse(XMLInputStream xMLInputStream) {
            return (CTColor) POIXMLTypeLoader.parse(xMLInputStream, CTColor.type, (XmlOptions) null);
        }

        public static CTColor parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTColor) POIXMLTypeLoader.parse(xMLInputStream, CTColor.type, xmlOptions);
        }

        public static CTColor parse(Node node) {
            return (CTColor) POIXMLTypeLoader.parse(node, CTColor.type, (XmlOptions) null);
        }

        public static CTColor parse(Node node, XmlOptions xmlOptions) {
            return (CTColor) POIXMLTypeLoader.parse(node, CTColor.type, xmlOptions);
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
