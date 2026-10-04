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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface STDrawingElementId extends XmlUnsignedInt {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STDrawingElementId.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "stdrawingelementid75a4type");

    public static final class Factory {
        private Factory() {
        }

        public static STDrawingElementId newInstance() {
            return (STDrawingElementId) POIXMLTypeLoader.newInstance(STDrawingElementId.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STDrawingElementId.type, null);
        }

        public static STDrawingElementId newValue(Object obj) {
            return (STDrawingElementId) STDrawingElementId.type.newValue(obj);
        }

        public static STDrawingElementId parse(File file) {
            return (STDrawingElementId) POIXMLTypeLoader.parse(file, STDrawingElementId.type, (XmlOptions) null);
        }

        public static STDrawingElementId newInstance(XmlOptions xmlOptions) {
            return (STDrawingElementId) POIXMLTypeLoader.newInstance(STDrawingElementId.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STDrawingElementId.type, xmlOptions);
        }

        public static STDrawingElementId parse(File file, XmlOptions xmlOptions) {
            return (STDrawingElementId) POIXMLTypeLoader.parse(file, STDrawingElementId.type, xmlOptions);
        }

        public static STDrawingElementId parse(InputStream inputStream) {
            return (STDrawingElementId) POIXMLTypeLoader.parse(inputStream, STDrawingElementId.type, (XmlOptions) null);
        }

        public static STDrawingElementId parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STDrawingElementId) POIXMLTypeLoader.parse(inputStream, STDrawingElementId.type, xmlOptions);
        }

        public static STDrawingElementId parse(Reader reader) {
            return (STDrawingElementId) POIXMLTypeLoader.parse(reader, STDrawingElementId.type, (XmlOptions) null);
        }

        public static STDrawingElementId parse(Reader reader, XmlOptions xmlOptions) {
            return (STDrawingElementId) POIXMLTypeLoader.parse(reader, STDrawingElementId.type, xmlOptions);
        }

        public static STDrawingElementId parse(String str) {
            return (STDrawingElementId) POIXMLTypeLoader.parse(str, STDrawingElementId.type, (XmlOptions) null);
        }

        public static STDrawingElementId parse(String str, XmlOptions xmlOptions) {
            return (STDrawingElementId) POIXMLTypeLoader.parse(str, STDrawingElementId.type, xmlOptions);
        }

        public static STDrawingElementId parse(URL url) {
            return (STDrawingElementId) POIXMLTypeLoader.parse(url, STDrawingElementId.type, (XmlOptions) null);
        }

        public static STDrawingElementId parse(URL url, XmlOptions xmlOptions) {
            return (STDrawingElementId) POIXMLTypeLoader.parse(url, STDrawingElementId.type, xmlOptions);
        }

        public static STDrawingElementId parse(XMLStreamReader xMLStreamReader) {
            return (STDrawingElementId) POIXMLTypeLoader.parse(xMLStreamReader, STDrawingElementId.type, (XmlOptions) null);
        }

        public static STDrawingElementId parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STDrawingElementId) POIXMLTypeLoader.parse(xMLStreamReader, STDrawingElementId.type, xmlOptions);
        }

        public static STDrawingElementId parse(XMLInputStream xMLInputStream) {
            return (STDrawingElementId) POIXMLTypeLoader.parse(xMLInputStream, STDrawingElementId.type, (XmlOptions) null);
        }

        public static STDrawingElementId parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STDrawingElementId) POIXMLTypeLoader.parse(xMLInputStream, STDrawingElementId.type, xmlOptions);
        }

        public static STDrawingElementId parse(Node node) {
            return (STDrawingElementId) POIXMLTypeLoader.parse(node, STDrawingElementId.type, (XmlOptions) null);
        }

        public static STDrawingElementId parse(Node node, XmlOptions xmlOptions) {
            return (STDrawingElementId) POIXMLTypeLoader.parse(node, STDrawingElementId.type, xmlOptions);
        }
    }
}
