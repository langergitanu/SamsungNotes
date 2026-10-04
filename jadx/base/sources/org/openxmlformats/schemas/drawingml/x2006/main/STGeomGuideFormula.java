package org.openxmlformats.schemas.drawingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface STGeomGuideFormula extends XmlString {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STGeomGuideFormula.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "stgeomguideformula4b51type");

    public static final class Factory {
        private Factory() {
        }

        public static STGeomGuideFormula newInstance() {
            return (STGeomGuideFormula) POIXMLTypeLoader.newInstance(STGeomGuideFormula.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STGeomGuideFormula.type, null);
        }

        public static STGeomGuideFormula newValue(Object obj) {
            return (STGeomGuideFormula) STGeomGuideFormula.type.newValue(obj);
        }

        public static STGeomGuideFormula parse(File file) {
            return (STGeomGuideFormula) POIXMLTypeLoader.parse(file, STGeomGuideFormula.type, (XmlOptions) null);
        }

        public static STGeomGuideFormula newInstance(XmlOptions xmlOptions) {
            return (STGeomGuideFormula) POIXMLTypeLoader.newInstance(STGeomGuideFormula.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STGeomGuideFormula.type, xmlOptions);
        }

        public static STGeomGuideFormula parse(File file, XmlOptions xmlOptions) {
            return (STGeomGuideFormula) POIXMLTypeLoader.parse(file, STGeomGuideFormula.type, xmlOptions);
        }

        public static STGeomGuideFormula parse(InputStream inputStream) {
            return (STGeomGuideFormula) POIXMLTypeLoader.parse(inputStream, STGeomGuideFormula.type, (XmlOptions) null);
        }

        public static STGeomGuideFormula parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STGeomGuideFormula) POIXMLTypeLoader.parse(inputStream, STGeomGuideFormula.type, xmlOptions);
        }

        public static STGeomGuideFormula parse(Reader reader) {
            return (STGeomGuideFormula) POIXMLTypeLoader.parse(reader, STGeomGuideFormula.type, (XmlOptions) null);
        }

        public static STGeomGuideFormula parse(Reader reader, XmlOptions xmlOptions) {
            return (STGeomGuideFormula) POIXMLTypeLoader.parse(reader, STGeomGuideFormula.type, xmlOptions);
        }

        public static STGeomGuideFormula parse(String str) {
            return (STGeomGuideFormula) POIXMLTypeLoader.parse(str, STGeomGuideFormula.type, (XmlOptions) null);
        }

        public static STGeomGuideFormula parse(String str, XmlOptions xmlOptions) {
            return (STGeomGuideFormula) POIXMLTypeLoader.parse(str, STGeomGuideFormula.type, xmlOptions);
        }

        public static STGeomGuideFormula parse(URL url) {
            return (STGeomGuideFormula) POIXMLTypeLoader.parse(url, STGeomGuideFormula.type, (XmlOptions) null);
        }

        public static STGeomGuideFormula parse(URL url, XmlOptions xmlOptions) {
            return (STGeomGuideFormula) POIXMLTypeLoader.parse(url, STGeomGuideFormula.type, xmlOptions);
        }

        public static STGeomGuideFormula parse(XMLStreamReader xMLStreamReader) {
            return (STGeomGuideFormula) POIXMLTypeLoader.parse(xMLStreamReader, STGeomGuideFormula.type, (XmlOptions) null);
        }

        public static STGeomGuideFormula parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STGeomGuideFormula) POIXMLTypeLoader.parse(xMLStreamReader, STGeomGuideFormula.type, xmlOptions);
        }

        public static STGeomGuideFormula parse(XMLInputStream xMLInputStream) {
            return (STGeomGuideFormula) POIXMLTypeLoader.parse(xMLInputStream, STGeomGuideFormula.type, (XmlOptions) null);
        }

        public static STGeomGuideFormula parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STGeomGuideFormula) POIXMLTypeLoader.parse(xMLInputStream, STGeomGuideFormula.type, xmlOptions);
        }

        public static STGeomGuideFormula parse(Node node) {
            return (STGeomGuideFormula) POIXMLTypeLoader.parse(node, STGeomGuideFormula.type, (XmlOptions) null);
        }

        public static STGeomGuideFormula parse(Node node, XmlOptions xmlOptions) {
            return (STGeomGuideFormula) POIXMLTypeLoader.parse(node, STGeomGuideFormula.type, xmlOptions);
        }
    }
}
