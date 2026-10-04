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
public interface CTFillProperties extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTFillProperties.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctfillproperties2371type");

    public static final class Factory {
        private Factory() {
        }

        public static CTFillProperties newInstance() {
            return (CTFillProperties) POIXMLTypeLoader.newInstance(CTFillProperties.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFillProperties.type, null);
        }

        public static CTFillProperties parse(File file) {
            return (CTFillProperties) POIXMLTypeLoader.parse(file, CTFillProperties.type, (XmlOptions) null);
        }

        public static CTFillProperties newInstance(XmlOptions xmlOptions) {
            return (CTFillProperties) POIXMLTypeLoader.newInstance(CTFillProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFillProperties.type, xmlOptions);
        }

        public static CTFillProperties parse(File file, XmlOptions xmlOptions) {
            return (CTFillProperties) POIXMLTypeLoader.parse(file, CTFillProperties.type, xmlOptions);
        }

        public static CTFillProperties parse(InputStream inputStream) {
            return (CTFillProperties) POIXMLTypeLoader.parse(inputStream, CTFillProperties.type, (XmlOptions) null);
        }

        public static CTFillProperties parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTFillProperties) POIXMLTypeLoader.parse(inputStream, CTFillProperties.type, xmlOptions);
        }

        public static CTFillProperties parse(Reader reader) {
            return (CTFillProperties) POIXMLTypeLoader.parse(reader, CTFillProperties.type, (XmlOptions) null);
        }

        public static CTFillProperties parse(Reader reader, XmlOptions xmlOptions) {
            return (CTFillProperties) POIXMLTypeLoader.parse(reader, CTFillProperties.type, xmlOptions);
        }

        public static CTFillProperties parse(String str) {
            return (CTFillProperties) POIXMLTypeLoader.parse(str, CTFillProperties.type, (XmlOptions) null);
        }

        public static CTFillProperties parse(String str, XmlOptions xmlOptions) {
            return (CTFillProperties) POIXMLTypeLoader.parse(str, CTFillProperties.type, xmlOptions);
        }

        public static CTFillProperties parse(URL url) {
            return (CTFillProperties) POIXMLTypeLoader.parse(url, CTFillProperties.type, (XmlOptions) null);
        }

        public static CTFillProperties parse(URL url, XmlOptions xmlOptions) {
            return (CTFillProperties) POIXMLTypeLoader.parse(url, CTFillProperties.type, xmlOptions);
        }

        public static CTFillProperties parse(XMLStreamReader xMLStreamReader) {
            return (CTFillProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTFillProperties.type, (XmlOptions) null);
        }

        public static CTFillProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTFillProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTFillProperties.type, xmlOptions);
        }

        public static CTFillProperties parse(XMLInputStream xMLInputStream) {
            return (CTFillProperties) POIXMLTypeLoader.parse(xMLInputStream, CTFillProperties.type, (XmlOptions) null);
        }

        public static CTFillProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTFillProperties) POIXMLTypeLoader.parse(xMLInputStream, CTFillProperties.type, xmlOptions);
        }

        public static CTFillProperties parse(Node node) {
            return (CTFillProperties) POIXMLTypeLoader.parse(node, CTFillProperties.type, (XmlOptions) null);
        }

        public static CTFillProperties parse(Node node, XmlOptions xmlOptions) {
            return (CTFillProperties) POIXMLTypeLoader.parse(node, CTFillProperties.type, xmlOptions);
        }
    }

    CTBlipFillProperties addNewBlipFill();

    CTGradientFillProperties addNewGradFill();

    CTGroupFillProperties addNewGrpFill();

    CTNoFillProperties addNewNoFill();

    CTPatternFillProperties addNewPattFill();

    CTSolidColorFillProperties addNewSolidFill();

    CTBlipFillProperties getBlipFill();

    CTGradientFillProperties getGradFill();

    CTGroupFillProperties getGrpFill();

    CTNoFillProperties getNoFill();

    CTPatternFillProperties getPattFill();

    CTSolidColorFillProperties getSolidFill();

    boolean isSetBlipFill();

    boolean isSetGradFill();

    boolean isSetGrpFill();

    boolean isSetNoFill();

    boolean isSetPattFill();

    boolean isSetSolidFill();

    void setBlipFill(CTBlipFillProperties cTBlipFillProperties);

    void setGradFill(CTGradientFillProperties cTGradientFillProperties);

    void setGrpFill(CTGroupFillProperties cTGroupFillProperties);

    void setNoFill(CTNoFillProperties cTNoFillProperties);

    void setPattFill(CTPatternFillProperties cTPatternFillProperties);

    void setSolidFill(CTSolidColorFillProperties cTSolidColorFillProperties);

    void unsetBlipFill();

    void unsetGradFill();

    void unsetGrpFill();

    void unsetNoFill();

    void unsetPattFill();

    void unsetSolidFill();
}
