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
public interface CTTextNormalAutofit extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTextNormalAutofit.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttextnormalautofitbbdftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextNormalAutofit newInstance() {
            return (CTTextNormalAutofit) POIXMLTypeLoader.newInstance(CTTextNormalAutofit.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextNormalAutofit.type, null);
        }

        public static CTTextNormalAutofit parse(File file) {
            return (CTTextNormalAutofit) POIXMLTypeLoader.parse(file, CTTextNormalAutofit.type, (XmlOptions) null);
        }

        public static CTTextNormalAutofit newInstance(XmlOptions xmlOptions) {
            return (CTTextNormalAutofit) POIXMLTypeLoader.newInstance(CTTextNormalAutofit.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextNormalAutofit.type, xmlOptions);
        }

        public static CTTextNormalAutofit parse(File file, XmlOptions xmlOptions) {
            return (CTTextNormalAutofit) POIXMLTypeLoader.parse(file, CTTextNormalAutofit.type, xmlOptions);
        }

        public static CTTextNormalAutofit parse(InputStream inputStream) {
            return (CTTextNormalAutofit) POIXMLTypeLoader.parse(inputStream, CTTextNormalAutofit.type, (XmlOptions) null);
        }

        public static CTTextNormalAutofit parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTextNormalAutofit) POIXMLTypeLoader.parse(inputStream, CTTextNormalAutofit.type, xmlOptions);
        }

        public static CTTextNormalAutofit parse(Reader reader) {
            return (CTTextNormalAutofit) POIXMLTypeLoader.parse(reader, CTTextNormalAutofit.type, (XmlOptions) null);
        }

        public static CTTextNormalAutofit parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTextNormalAutofit) POIXMLTypeLoader.parse(reader, CTTextNormalAutofit.type, xmlOptions);
        }

        public static CTTextNormalAutofit parse(String str) {
            return (CTTextNormalAutofit) POIXMLTypeLoader.parse(str, CTTextNormalAutofit.type, (XmlOptions) null);
        }

        public static CTTextNormalAutofit parse(String str, XmlOptions xmlOptions) {
            return (CTTextNormalAutofit) POIXMLTypeLoader.parse(str, CTTextNormalAutofit.type, xmlOptions);
        }

        public static CTTextNormalAutofit parse(URL url) {
            return (CTTextNormalAutofit) POIXMLTypeLoader.parse(url, CTTextNormalAutofit.type, (XmlOptions) null);
        }

        public static CTTextNormalAutofit parse(URL url, XmlOptions xmlOptions) {
            return (CTTextNormalAutofit) POIXMLTypeLoader.parse(url, CTTextNormalAutofit.type, xmlOptions);
        }

        public static CTTextNormalAutofit parse(XMLStreamReader xMLStreamReader) {
            return (CTTextNormalAutofit) POIXMLTypeLoader.parse(xMLStreamReader, CTTextNormalAutofit.type, (XmlOptions) null);
        }

        public static CTTextNormalAutofit parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTextNormalAutofit) POIXMLTypeLoader.parse(xMLStreamReader, CTTextNormalAutofit.type, xmlOptions);
        }

        public static CTTextNormalAutofit parse(XMLInputStream xMLInputStream) {
            return (CTTextNormalAutofit) POIXMLTypeLoader.parse(xMLInputStream, CTTextNormalAutofit.type, (XmlOptions) null);
        }

        public static CTTextNormalAutofit parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTextNormalAutofit) POIXMLTypeLoader.parse(xMLInputStream, CTTextNormalAutofit.type, xmlOptions);
        }

        public static CTTextNormalAutofit parse(Node node) {
            return (CTTextNormalAutofit) POIXMLTypeLoader.parse(node, CTTextNormalAutofit.type, (XmlOptions) null);
        }

        public static CTTextNormalAutofit parse(Node node, XmlOptions xmlOptions) {
            return (CTTextNormalAutofit) POIXMLTypeLoader.parse(node, CTTextNormalAutofit.type, xmlOptions);
        }
    }

    int getFontScale();

    int getLnSpcReduction();

    boolean isSetFontScale();

    boolean isSetLnSpcReduction();

    void setFontScale(int i);

    void setLnSpcReduction(int i);

    void unsetFontScale();

    void unsetLnSpcReduction();

    STTextFontScalePercent xgetFontScale();

    STTextSpacingPercent xgetLnSpcReduction();

    void xsetFontScale(STTextFontScalePercent sTTextFontScalePercent);

    void xsetLnSpcReduction(STTextSpacingPercent sTTextSpacingPercent);
}
