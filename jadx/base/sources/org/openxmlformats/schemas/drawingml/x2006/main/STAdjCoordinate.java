package org.openxmlformats.schemas.drawingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface STAdjCoordinate extends XmlAnySimpleType {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STAdjCoordinate.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "stadjcoordinated920type");

    public static final class Factory {
        private Factory() {
        }

        public static STAdjCoordinate newInstance() {
            return (STAdjCoordinate) POIXMLTypeLoader.newInstance(STAdjCoordinate.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STAdjCoordinate.type, null);
        }

        public static STAdjCoordinate newValue(Object obj) {
            return (STAdjCoordinate) STAdjCoordinate.type.newValue(obj);
        }

        public static STAdjCoordinate parse(File file) {
            return (STAdjCoordinate) POIXMLTypeLoader.parse(file, STAdjCoordinate.type, (XmlOptions) null);
        }

        public static STAdjCoordinate newInstance(XmlOptions xmlOptions) {
            return (STAdjCoordinate) POIXMLTypeLoader.newInstance(STAdjCoordinate.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STAdjCoordinate.type, xmlOptions);
        }

        public static STAdjCoordinate parse(File file, XmlOptions xmlOptions) {
            return (STAdjCoordinate) POIXMLTypeLoader.parse(file, STAdjCoordinate.type, xmlOptions);
        }

        public static STAdjCoordinate parse(InputStream inputStream) {
            return (STAdjCoordinate) POIXMLTypeLoader.parse(inputStream, STAdjCoordinate.type, (XmlOptions) null);
        }

        public static STAdjCoordinate parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STAdjCoordinate) POIXMLTypeLoader.parse(inputStream, STAdjCoordinate.type, xmlOptions);
        }

        public static STAdjCoordinate parse(Reader reader) {
            return (STAdjCoordinate) POIXMLTypeLoader.parse(reader, STAdjCoordinate.type, (XmlOptions) null);
        }

        public static STAdjCoordinate parse(Reader reader, XmlOptions xmlOptions) {
            return (STAdjCoordinate) POIXMLTypeLoader.parse(reader, STAdjCoordinate.type, xmlOptions);
        }

        public static STAdjCoordinate parse(String str) {
            return (STAdjCoordinate) POIXMLTypeLoader.parse(str, STAdjCoordinate.type, (XmlOptions) null);
        }

        public static STAdjCoordinate parse(String str, XmlOptions xmlOptions) {
            return (STAdjCoordinate) POIXMLTypeLoader.parse(str, STAdjCoordinate.type, xmlOptions);
        }

        public static STAdjCoordinate parse(URL url) {
            return (STAdjCoordinate) POIXMLTypeLoader.parse(url, STAdjCoordinate.type, (XmlOptions) null);
        }

        public static STAdjCoordinate parse(URL url, XmlOptions xmlOptions) {
            return (STAdjCoordinate) POIXMLTypeLoader.parse(url, STAdjCoordinate.type, xmlOptions);
        }

        public static STAdjCoordinate parse(XMLStreamReader xMLStreamReader) {
            return (STAdjCoordinate) POIXMLTypeLoader.parse(xMLStreamReader, STAdjCoordinate.type, (XmlOptions) null);
        }

        public static STAdjCoordinate parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STAdjCoordinate) POIXMLTypeLoader.parse(xMLStreamReader, STAdjCoordinate.type, xmlOptions);
        }

        public static STAdjCoordinate parse(XMLInputStream xMLInputStream) {
            return (STAdjCoordinate) POIXMLTypeLoader.parse(xMLInputStream, STAdjCoordinate.type, (XmlOptions) null);
        }

        public static STAdjCoordinate parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STAdjCoordinate) POIXMLTypeLoader.parse(xMLInputStream, STAdjCoordinate.type, xmlOptions);
        }

        public static STAdjCoordinate parse(Node node) {
            return (STAdjCoordinate) POIXMLTypeLoader.parse(node, STAdjCoordinate.type, (XmlOptions) null);
        }

        public static STAdjCoordinate parse(Node node, XmlOptions xmlOptions) {
            return (STAdjCoordinate) POIXMLTypeLoader.parse(node, STAdjCoordinate.type, xmlOptions);
        }
    }

    Object getObjectValue();

    SchemaType instanceType();

    void objectSet(Object obj);

    Object objectValue();

    void setObjectValue(Object obj);
}
