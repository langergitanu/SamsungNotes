package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTText extends STString {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTText.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttext7f5btype");

    public static final class Factory {
        private Factory() {
        }

        public static CTText newInstance() {
            return (CTText) POIXMLTypeLoader.newInstance(CTText.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTText.type, null);
        }

        public static CTText parse(File file) {
            return (CTText) POIXMLTypeLoader.parse(file, CTText.type, (XmlOptions) null);
        }

        public static CTText newInstance(XmlOptions xmlOptions) {
            return (CTText) POIXMLTypeLoader.newInstance(CTText.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTText.type, xmlOptions);
        }

        public static CTText parse(File file, XmlOptions xmlOptions) {
            return (CTText) POIXMLTypeLoader.parse(file, CTText.type, xmlOptions);
        }

        public static CTText parse(InputStream inputStream) {
            return (CTText) POIXMLTypeLoader.parse(inputStream, CTText.type, (XmlOptions) null);
        }

        public static CTText parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTText) POIXMLTypeLoader.parse(inputStream, CTText.type, xmlOptions);
        }

        public static CTText parse(Reader reader) {
            return (CTText) POIXMLTypeLoader.parse(reader, CTText.type, (XmlOptions) null);
        }

        public static CTText parse(Reader reader, XmlOptions xmlOptions) {
            return (CTText) POIXMLTypeLoader.parse(reader, CTText.type, xmlOptions);
        }

        public static CTText parse(String str) {
            return (CTText) POIXMLTypeLoader.parse(str, CTText.type, (XmlOptions) null);
        }

        public static CTText parse(String str, XmlOptions xmlOptions) {
            return (CTText) POIXMLTypeLoader.parse(str, CTText.type, xmlOptions);
        }

        public static CTText parse(URL url) {
            return (CTText) POIXMLTypeLoader.parse(url, CTText.type, (XmlOptions) null);
        }

        public static CTText parse(URL url, XmlOptions xmlOptions) {
            return (CTText) POIXMLTypeLoader.parse(url, CTText.type, xmlOptions);
        }

        public static CTText parse(XMLStreamReader xMLStreamReader) {
            return (CTText) POIXMLTypeLoader.parse(xMLStreamReader, CTText.type, (XmlOptions) null);
        }

        public static CTText parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTText) POIXMLTypeLoader.parse(xMLStreamReader, CTText.type, xmlOptions);
        }

        public static CTText parse(XMLInputStream xMLInputStream) {
            return (CTText) POIXMLTypeLoader.parse(xMLInputStream, CTText.type, (XmlOptions) null);
        }

        public static CTText parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTText) POIXMLTypeLoader.parse(xMLInputStream, CTText.type, xmlOptions);
        }

        public static CTText parse(Node node) {
            return (CTText) POIXMLTypeLoader.parse(node, CTText.type, (XmlOptions) null);
        }

        public static CTText parse(Node node, XmlOptions xmlOptions) {
            return (CTText) POIXMLTypeLoader.parse(node, CTText.type, xmlOptions);
        }
    }

    SpaceAttribute.Space.Enum getSpace();

    boolean isSetSpace();

    void setSpace(SpaceAttribute.Space.Enum r12);

    void unsetSpace();

    SpaceAttribute.Space xgetSpace();

    void xsetSpace(SpaceAttribute.Space space);
}
