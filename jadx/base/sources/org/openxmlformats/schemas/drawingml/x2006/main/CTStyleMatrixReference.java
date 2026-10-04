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
public interface CTStyleMatrixReference extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTStyleMatrixReference.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctstylematrixreference6ef4type");

    public static final class Factory {
        private Factory() {
        }

        public static CTStyleMatrixReference newInstance() {
            return (CTStyleMatrixReference) POIXMLTypeLoader.newInstance(CTStyleMatrixReference.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTStyleMatrixReference.type, null);
        }

        public static CTStyleMatrixReference parse(File file) {
            return (CTStyleMatrixReference) POIXMLTypeLoader.parse(file, CTStyleMatrixReference.type, (XmlOptions) null);
        }

        public static CTStyleMatrixReference newInstance(XmlOptions xmlOptions) {
            return (CTStyleMatrixReference) POIXMLTypeLoader.newInstance(CTStyleMatrixReference.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTStyleMatrixReference.type, xmlOptions);
        }

        public static CTStyleMatrixReference parse(File file, XmlOptions xmlOptions) {
            return (CTStyleMatrixReference) POIXMLTypeLoader.parse(file, CTStyleMatrixReference.type, xmlOptions);
        }

        public static CTStyleMatrixReference parse(InputStream inputStream) {
            return (CTStyleMatrixReference) POIXMLTypeLoader.parse(inputStream, CTStyleMatrixReference.type, (XmlOptions) null);
        }

        public static CTStyleMatrixReference parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTStyleMatrixReference) POIXMLTypeLoader.parse(inputStream, CTStyleMatrixReference.type, xmlOptions);
        }

        public static CTStyleMatrixReference parse(Reader reader) {
            return (CTStyleMatrixReference) POIXMLTypeLoader.parse(reader, CTStyleMatrixReference.type, (XmlOptions) null);
        }

        public static CTStyleMatrixReference parse(Reader reader, XmlOptions xmlOptions) {
            return (CTStyleMatrixReference) POIXMLTypeLoader.parse(reader, CTStyleMatrixReference.type, xmlOptions);
        }

        public static CTStyleMatrixReference parse(String str) {
            return (CTStyleMatrixReference) POIXMLTypeLoader.parse(str, CTStyleMatrixReference.type, (XmlOptions) null);
        }

        public static CTStyleMatrixReference parse(String str, XmlOptions xmlOptions) {
            return (CTStyleMatrixReference) POIXMLTypeLoader.parse(str, CTStyleMatrixReference.type, xmlOptions);
        }

        public static CTStyleMatrixReference parse(URL url) {
            return (CTStyleMatrixReference) POIXMLTypeLoader.parse(url, CTStyleMatrixReference.type, (XmlOptions) null);
        }

        public static CTStyleMatrixReference parse(URL url, XmlOptions xmlOptions) {
            return (CTStyleMatrixReference) POIXMLTypeLoader.parse(url, CTStyleMatrixReference.type, xmlOptions);
        }

        public static CTStyleMatrixReference parse(XMLStreamReader xMLStreamReader) {
            return (CTStyleMatrixReference) POIXMLTypeLoader.parse(xMLStreamReader, CTStyleMatrixReference.type, (XmlOptions) null);
        }

        public static CTStyleMatrixReference parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTStyleMatrixReference) POIXMLTypeLoader.parse(xMLStreamReader, CTStyleMatrixReference.type, xmlOptions);
        }

        public static CTStyleMatrixReference parse(XMLInputStream xMLInputStream) {
            return (CTStyleMatrixReference) POIXMLTypeLoader.parse(xMLInputStream, CTStyleMatrixReference.type, (XmlOptions) null);
        }

        public static CTStyleMatrixReference parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTStyleMatrixReference) POIXMLTypeLoader.parse(xMLInputStream, CTStyleMatrixReference.type, xmlOptions);
        }

        public static CTStyleMatrixReference parse(Node node) {
            return (CTStyleMatrixReference) POIXMLTypeLoader.parse(node, CTStyleMatrixReference.type, (XmlOptions) null);
        }

        public static CTStyleMatrixReference parse(Node node, XmlOptions xmlOptions) {
            return (CTStyleMatrixReference) POIXMLTypeLoader.parse(node, CTStyleMatrixReference.type, xmlOptions);
        }
    }

    CTHslColor addNewHslClr();

    CTPresetColor addNewPrstClr();

    CTSchemeColor addNewSchemeClr();

    CTScRgbColor addNewScrgbClr();

    CTSRgbColor addNewSrgbClr();

    CTSystemColor addNewSysClr();

    CTHslColor getHslClr();

    long getIdx();

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

    void setIdx(long j);

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

    STStyleMatrixColumnIndex xgetIdx();

    void xsetIdx(STStyleMatrixColumnIndex sTStyleMatrixColumnIndex);
}
