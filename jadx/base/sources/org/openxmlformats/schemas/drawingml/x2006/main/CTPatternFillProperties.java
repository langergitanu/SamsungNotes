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
import org.openxmlformats.schemas.drawingml.x2006.main.STPresetPatternVal;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTPatternFillProperties extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTPatternFillProperties.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctpatternfillproperties3637type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPatternFillProperties newInstance() {
            return (CTPatternFillProperties) POIXMLTypeLoader.newInstance(CTPatternFillProperties.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPatternFillProperties.type, null);
        }

        public static CTPatternFillProperties parse(File file) {
            return (CTPatternFillProperties) POIXMLTypeLoader.parse(file, CTPatternFillProperties.type, (XmlOptions) null);
        }

        public static CTPatternFillProperties newInstance(XmlOptions xmlOptions) {
            return (CTPatternFillProperties) POIXMLTypeLoader.newInstance(CTPatternFillProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPatternFillProperties.type, xmlOptions);
        }

        public static CTPatternFillProperties parse(File file, XmlOptions xmlOptions) {
            return (CTPatternFillProperties) POIXMLTypeLoader.parse(file, CTPatternFillProperties.type, xmlOptions);
        }

        public static CTPatternFillProperties parse(InputStream inputStream) {
            return (CTPatternFillProperties) POIXMLTypeLoader.parse(inputStream, CTPatternFillProperties.type, (XmlOptions) null);
        }

        public static CTPatternFillProperties parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTPatternFillProperties) POIXMLTypeLoader.parse(inputStream, CTPatternFillProperties.type, xmlOptions);
        }

        public static CTPatternFillProperties parse(Reader reader) {
            return (CTPatternFillProperties) POIXMLTypeLoader.parse(reader, CTPatternFillProperties.type, (XmlOptions) null);
        }

        public static CTPatternFillProperties parse(Reader reader, XmlOptions xmlOptions) {
            return (CTPatternFillProperties) POIXMLTypeLoader.parse(reader, CTPatternFillProperties.type, xmlOptions);
        }

        public static CTPatternFillProperties parse(String str) {
            return (CTPatternFillProperties) POIXMLTypeLoader.parse(str, CTPatternFillProperties.type, (XmlOptions) null);
        }

        public static CTPatternFillProperties parse(String str, XmlOptions xmlOptions) {
            return (CTPatternFillProperties) POIXMLTypeLoader.parse(str, CTPatternFillProperties.type, xmlOptions);
        }

        public static CTPatternFillProperties parse(URL url) {
            return (CTPatternFillProperties) POIXMLTypeLoader.parse(url, CTPatternFillProperties.type, (XmlOptions) null);
        }

        public static CTPatternFillProperties parse(URL url, XmlOptions xmlOptions) {
            return (CTPatternFillProperties) POIXMLTypeLoader.parse(url, CTPatternFillProperties.type, xmlOptions);
        }

        public static CTPatternFillProperties parse(XMLStreamReader xMLStreamReader) {
            return (CTPatternFillProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTPatternFillProperties.type, (XmlOptions) null);
        }

        public static CTPatternFillProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTPatternFillProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTPatternFillProperties.type, xmlOptions);
        }

        public static CTPatternFillProperties parse(XMLInputStream xMLInputStream) {
            return (CTPatternFillProperties) POIXMLTypeLoader.parse(xMLInputStream, CTPatternFillProperties.type, (XmlOptions) null);
        }

        public static CTPatternFillProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTPatternFillProperties) POIXMLTypeLoader.parse(xMLInputStream, CTPatternFillProperties.type, xmlOptions);
        }

        public static CTPatternFillProperties parse(Node node) {
            return (CTPatternFillProperties) POIXMLTypeLoader.parse(node, CTPatternFillProperties.type, (XmlOptions) null);
        }

        public static CTPatternFillProperties parse(Node node, XmlOptions xmlOptions) {
            return (CTPatternFillProperties) POIXMLTypeLoader.parse(node, CTPatternFillProperties.type, xmlOptions);
        }
    }

    CTColor addNewBgClr();

    CTColor addNewFgClr();

    CTColor getBgClr();

    CTColor getFgClr();

    STPresetPatternVal.Enum getPrst();

    boolean isSetBgClr();

    boolean isSetFgClr();

    boolean isSetPrst();

    void setBgClr(CTColor cTColor);

    void setFgClr(CTColor cTColor);

    void setPrst(STPresetPatternVal.Enum r12);

    void unsetBgClr();

    void unsetFgClr();

    void unsetPrst();

    STPresetPatternVal xgetPrst();

    void xsetPrst(STPresetPatternVal sTPresetPatternVal);
}
