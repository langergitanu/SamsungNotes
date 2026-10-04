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
public interface CTTableCol extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTableCol.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttablecol19edtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTableCol newInstance() {
            return (CTTableCol) POIXMLTypeLoader.newInstance(CTTableCol.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTableCol.type, null);
        }

        public static CTTableCol parse(File file) {
            return (CTTableCol) POIXMLTypeLoader.parse(file, CTTableCol.type, (XmlOptions) null);
        }

        public static CTTableCol newInstance(XmlOptions xmlOptions) {
            return (CTTableCol) POIXMLTypeLoader.newInstance(CTTableCol.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTableCol.type, xmlOptions);
        }

        public static CTTableCol parse(File file, XmlOptions xmlOptions) {
            return (CTTableCol) POIXMLTypeLoader.parse(file, CTTableCol.type, xmlOptions);
        }

        public static CTTableCol parse(InputStream inputStream) {
            return (CTTableCol) POIXMLTypeLoader.parse(inputStream, CTTableCol.type, (XmlOptions) null);
        }

        public static CTTableCol parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTableCol) POIXMLTypeLoader.parse(inputStream, CTTableCol.type, xmlOptions);
        }

        public static CTTableCol parse(Reader reader) {
            return (CTTableCol) POIXMLTypeLoader.parse(reader, CTTableCol.type, (XmlOptions) null);
        }

        public static CTTableCol parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTableCol) POIXMLTypeLoader.parse(reader, CTTableCol.type, xmlOptions);
        }

        public static CTTableCol parse(String str) {
            return (CTTableCol) POIXMLTypeLoader.parse(str, CTTableCol.type, (XmlOptions) null);
        }

        public static CTTableCol parse(String str, XmlOptions xmlOptions) {
            return (CTTableCol) POIXMLTypeLoader.parse(str, CTTableCol.type, xmlOptions);
        }

        public static CTTableCol parse(URL url) {
            return (CTTableCol) POIXMLTypeLoader.parse(url, CTTableCol.type, (XmlOptions) null);
        }

        public static CTTableCol parse(URL url, XmlOptions xmlOptions) {
            return (CTTableCol) POIXMLTypeLoader.parse(url, CTTableCol.type, xmlOptions);
        }

        public static CTTableCol parse(XMLStreamReader xMLStreamReader) {
            return (CTTableCol) POIXMLTypeLoader.parse(xMLStreamReader, CTTableCol.type, (XmlOptions) null);
        }

        public static CTTableCol parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTableCol) POIXMLTypeLoader.parse(xMLStreamReader, CTTableCol.type, xmlOptions);
        }

        public static CTTableCol parse(XMLInputStream xMLInputStream) {
            return (CTTableCol) POIXMLTypeLoader.parse(xMLInputStream, CTTableCol.type, (XmlOptions) null);
        }

        public static CTTableCol parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTableCol) POIXMLTypeLoader.parse(xMLInputStream, CTTableCol.type, xmlOptions);
        }

        public static CTTableCol parse(Node node) {
            return (CTTableCol) POIXMLTypeLoader.parse(node, CTTableCol.type, (XmlOptions) null);
        }

        public static CTTableCol parse(Node node, XmlOptions xmlOptions) {
            return (CTTableCol) POIXMLTypeLoader.parse(node, CTTableCol.type, xmlOptions);
        }
    }

    CTOfficeArtExtensionList addNewExtLst();

    CTOfficeArtExtensionList getExtLst();

    long getW();

    boolean isSetExtLst();

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setW(long j);

    void unsetExtLst();

    STCoordinate xgetW();

    void xsetW(STCoordinate sTCoordinate);
}
