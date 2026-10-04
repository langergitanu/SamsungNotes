package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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
public interface CTBr extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTBr.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctbr7dd8type");

    public static final class Factory {
        private Factory() {
        }

        public static CTBr newInstance() {
            return (CTBr) POIXMLTypeLoader.newInstance(CTBr.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTBr.type, null);
        }

        public static CTBr parse(File file) {
            return (CTBr) POIXMLTypeLoader.parse(file, CTBr.type, (XmlOptions) null);
        }

        public static CTBr newInstance(XmlOptions xmlOptions) {
            return (CTBr) POIXMLTypeLoader.newInstance(CTBr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTBr.type, xmlOptions);
        }

        public static CTBr parse(File file, XmlOptions xmlOptions) {
            return (CTBr) POIXMLTypeLoader.parse(file, CTBr.type, xmlOptions);
        }

        public static CTBr parse(InputStream inputStream) {
            return (CTBr) POIXMLTypeLoader.parse(inputStream, CTBr.type, (XmlOptions) null);
        }

        public static CTBr parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTBr) POIXMLTypeLoader.parse(inputStream, CTBr.type, xmlOptions);
        }

        public static CTBr parse(Reader reader) {
            return (CTBr) POIXMLTypeLoader.parse(reader, CTBr.type, (XmlOptions) null);
        }

        public static CTBr parse(Reader reader, XmlOptions xmlOptions) {
            return (CTBr) POIXMLTypeLoader.parse(reader, CTBr.type, xmlOptions);
        }

        public static CTBr parse(String str) {
            return (CTBr) POIXMLTypeLoader.parse(str, CTBr.type, (XmlOptions) null);
        }

        public static CTBr parse(String str, XmlOptions xmlOptions) {
            return (CTBr) POIXMLTypeLoader.parse(str, CTBr.type, xmlOptions);
        }

        public static CTBr parse(URL url) {
            return (CTBr) POIXMLTypeLoader.parse(url, CTBr.type, (XmlOptions) null);
        }

        public static CTBr parse(URL url, XmlOptions xmlOptions) {
            return (CTBr) POIXMLTypeLoader.parse(url, CTBr.type, xmlOptions);
        }

        public static CTBr parse(XMLStreamReader xMLStreamReader) {
            return (CTBr) POIXMLTypeLoader.parse(xMLStreamReader, CTBr.type, (XmlOptions) null);
        }

        public static CTBr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTBr) POIXMLTypeLoader.parse(xMLStreamReader, CTBr.type, xmlOptions);
        }

        public static CTBr parse(XMLInputStream xMLInputStream) {
            return (CTBr) POIXMLTypeLoader.parse(xMLInputStream, CTBr.type, (XmlOptions) null);
        }

        public static CTBr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTBr) POIXMLTypeLoader.parse(xMLInputStream, CTBr.type, xmlOptions);
        }

        public static CTBr parse(Node node) {
            return (CTBr) POIXMLTypeLoader.parse(node, CTBr.type, (XmlOptions) null);
        }

        public static CTBr parse(Node node, XmlOptions xmlOptions) {
            return (CTBr) POIXMLTypeLoader.parse(node, CTBr.type, xmlOptions);
        }
    }

    STBrClear$Enum getClear();

    STBrType$Enum getType();

    boolean isSetClear();

    boolean isSetType();

    void setClear(STBrClear$Enum sTBrClear$Enum);

    void setType(STBrType$Enum sTBrType$Enum);

    void unsetClear();

    void unsetType();

    STBrClear xgetClear();

    STBrType xgetType();

    void xsetClear(STBrClear sTBrClear);

    void xsetType(STBrType sTBrType);
}
