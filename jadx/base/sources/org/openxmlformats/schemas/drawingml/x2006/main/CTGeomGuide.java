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
public interface CTGeomGuide extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTGeomGuide.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctgeomguidef191type");

    public static final class Factory {
        private Factory() {
        }

        public static CTGeomGuide newInstance() {
            return (CTGeomGuide) POIXMLTypeLoader.newInstance(CTGeomGuide.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGeomGuide.type, null);
        }

        public static CTGeomGuide parse(File file) {
            return (CTGeomGuide) POIXMLTypeLoader.parse(file, CTGeomGuide.type, (XmlOptions) null);
        }

        public static CTGeomGuide newInstance(XmlOptions xmlOptions) {
            return (CTGeomGuide) POIXMLTypeLoader.newInstance(CTGeomGuide.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGeomGuide.type, xmlOptions);
        }

        public static CTGeomGuide parse(File file, XmlOptions xmlOptions) {
            return (CTGeomGuide) POIXMLTypeLoader.parse(file, CTGeomGuide.type, xmlOptions);
        }

        public static CTGeomGuide parse(InputStream inputStream) {
            return (CTGeomGuide) POIXMLTypeLoader.parse(inputStream, CTGeomGuide.type, (XmlOptions) null);
        }

        public static CTGeomGuide parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTGeomGuide) POIXMLTypeLoader.parse(inputStream, CTGeomGuide.type, xmlOptions);
        }

        public static CTGeomGuide parse(Reader reader) {
            return (CTGeomGuide) POIXMLTypeLoader.parse(reader, CTGeomGuide.type, (XmlOptions) null);
        }

        public static CTGeomGuide parse(Reader reader, XmlOptions xmlOptions) {
            return (CTGeomGuide) POIXMLTypeLoader.parse(reader, CTGeomGuide.type, xmlOptions);
        }

        public static CTGeomGuide parse(String str) {
            return (CTGeomGuide) POIXMLTypeLoader.parse(str, CTGeomGuide.type, (XmlOptions) null);
        }

        public static CTGeomGuide parse(String str, XmlOptions xmlOptions) {
            return (CTGeomGuide) POIXMLTypeLoader.parse(str, CTGeomGuide.type, xmlOptions);
        }

        public static CTGeomGuide parse(URL url) {
            return (CTGeomGuide) POIXMLTypeLoader.parse(url, CTGeomGuide.type, (XmlOptions) null);
        }

        public static CTGeomGuide parse(URL url, XmlOptions xmlOptions) {
            return (CTGeomGuide) POIXMLTypeLoader.parse(url, CTGeomGuide.type, xmlOptions);
        }

        public static CTGeomGuide parse(XMLStreamReader xMLStreamReader) {
            return (CTGeomGuide) POIXMLTypeLoader.parse(xMLStreamReader, CTGeomGuide.type, (XmlOptions) null);
        }

        public static CTGeomGuide parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTGeomGuide) POIXMLTypeLoader.parse(xMLStreamReader, CTGeomGuide.type, xmlOptions);
        }

        public static CTGeomGuide parse(XMLInputStream xMLInputStream) {
            return (CTGeomGuide) POIXMLTypeLoader.parse(xMLInputStream, CTGeomGuide.type, (XmlOptions) null);
        }

        public static CTGeomGuide parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTGeomGuide) POIXMLTypeLoader.parse(xMLInputStream, CTGeomGuide.type, xmlOptions);
        }

        public static CTGeomGuide parse(Node node) {
            return (CTGeomGuide) POIXMLTypeLoader.parse(node, CTGeomGuide.type, (XmlOptions) null);
        }

        public static CTGeomGuide parse(Node node, XmlOptions xmlOptions) {
            return (CTGeomGuide) POIXMLTypeLoader.parse(node, CTGeomGuide.type, xmlOptions);
        }
    }

    String getFmla();

    String getName();

    void setFmla(String str);

    void setName(String str);

    STGeomGuideFormula xgetFmla();

    STGeomGuideName xgetName();

    void xsetFmla(STGeomGuideFormula sTGeomGuideFormula);

    void xsetName(STGeomGuideName sTGeomGuideName);
}
