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
public interface CTColorMappingOverride extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTColorMappingOverride.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctcolormappingoverridea2b2type");

    public static final class Factory {
        private Factory() {
        }

        public static CTColorMappingOverride newInstance() {
            return (CTColorMappingOverride) POIXMLTypeLoader.newInstance(CTColorMappingOverride.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTColorMappingOverride.type, null);
        }

        public static CTColorMappingOverride parse(File file) {
            return (CTColorMappingOverride) POIXMLTypeLoader.parse(file, CTColorMappingOverride.type, (XmlOptions) null);
        }

        public static CTColorMappingOverride newInstance(XmlOptions xmlOptions) {
            return (CTColorMappingOverride) POIXMLTypeLoader.newInstance(CTColorMappingOverride.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTColorMappingOverride.type, xmlOptions);
        }

        public static CTColorMappingOverride parse(File file, XmlOptions xmlOptions) {
            return (CTColorMappingOverride) POIXMLTypeLoader.parse(file, CTColorMappingOverride.type, xmlOptions);
        }

        public static CTColorMappingOverride parse(InputStream inputStream) {
            return (CTColorMappingOverride) POIXMLTypeLoader.parse(inputStream, CTColorMappingOverride.type, (XmlOptions) null);
        }

        public static CTColorMappingOverride parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTColorMappingOverride) POIXMLTypeLoader.parse(inputStream, CTColorMappingOverride.type, xmlOptions);
        }

        public static CTColorMappingOverride parse(Reader reader) {
            return (CTColorMappingOverride) POIXMLTypeLoader.parse(reader, CTColorMappingOverride.type, (XmlOptions) null);
        }

        public static CTColorMappingOverride parse(Reader reader, XmlOptions xmlOptions) {
            return (CTColorMappingOverride) POIXMLTypeLoader.parse(reader, CTColorMappingOverride.type, xmlOptions);
        }

        public static CTColorMappingOverride parse(String str) {
            return (CTColorMappingOverride) POIXMLTypeLoader.parse(str, CTColorMappingOverride.type, (XmlOptions) null);
        }

        public static CTColorMappingOverride parse(String str, XmlOptions xmlOptions) {
            return (CTColorMappingOverride) POIXMLTypeLoader.parse(str, CTColorMappingOverride.type, xmlOptions);
        }

        public static CTColorMappingOverride parse(URL url) {
            return (CTColorMappingOverride) POIXMLTypeLoader.parse(url, CTColorMappingOverride.type, (XmlOptions) null);
        }

        public static CTColorMappingOverride parse(URL url, XmlOptions xmlOptions) {
            return (CTColorMappingOverride) POIXMLTypeLoader.parse(url, CTColorMappingOverride.type, xmlOptions);
        }

        public static CTColorMappingOverride parse(XMLStreamReader xMLStreamReader) {
            return (CTColorMappingOverride) POIXMLTypeLoader.parse(xMLStreamReader, CTColorMappingOverride.type, (XmlOptions) null);
        }

        public static CTColorMappingOverride parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTColorMappingOverride) POIXMLTypeLoader.parse(xMLStreamReader, CTColorMappingOverride.type, xmlOptions);
        }

        public static CTColorMappingOverride parse(XMLInputStream xMLInputStream) {
            return (CTColorMappingOverride) POIXMLTypeLoader.parse(xMLInputStream, CTColorMappingOverride.type, (XmlOptions) null);
        }

        public static CTColorMappingOverride parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTColorMappingOverride) POIXMLTypeLoader.parse(xMLInputStream, CTColorMappingOverride.type, xmlOptions);
        }

        public static CTColorMappingOverride parse(Node node) {
            return (CTColorMappingOverride) POIXMLTypeLoader.parse(node, CTColorMappingOverride.type, (XmlOptions) null);
        }

        public static CTColorMappingOverride parse(Node node, XmlOptions xmlOptions) {
            return (CTColorMappingOverride) POIXMLTypeLoader.parse(node, CTColorMappingOverride.type, xmlOptions);
        }
    }

    CTEmptyElement addNewMasterClrMapping();

    CTColorMapping addNewOverrideClrMapping();

    CTEmptyElement getMasterClrMapping();

    CTColorMapping getOverrideClrMapping();

    boolean isSetMasterClrMapping();

    boolean isSetOverrideClrMapping();

    void setMasterClrMapping(CTEmptyElement cTEmptyElement);

    void setOverrideClrMapping(CTColorMapping cTColorMapping);

    void unsetMasterClrMapping();

    void unsetOverrideClrMapping();
}
