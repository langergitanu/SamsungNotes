package org.openxmlformats.schemas.drawingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTOfficeArtExtensionList extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTOfficeArtExtensionList.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctofficeartextensionlista211type");

    public static final class Factory {
        private Factory() {
        }

        public static CTOfficeArtExtensionList newInstance() {
            return (CTOfficeArtExtensionList) POIXMLTypeLoader.newInstance(CTOfficeArtExtensionList.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTOfficeArtExtensionList.type, null);
        }

        public static CTOfficeArtExtensionList parse(File file) {
            return (CTOfficeArtExtensionList) POIXMLTypeLoader.parse(file, CTOfficeArtExtensionList.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtensionList newInstance(XmlOptions xmlOptions) {
            return (CTOfficeArtExtensionList) POIXMLTypeLoader.newInstance(CTOfficeArtExtensionList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTOfficeArtExtensionList.type, xmlOptions);
        }

        public static CTOfficeArtExtensionList parse(File file, XmlOptions xmlOptions) {
            return (CTOfficeArtExtensionList) POIXMLTypeLoader.parse(file, CTOfficeArtExtensionList.type, xmlOptions);
        }

        public static CTOfficeArtExtensionList parse(InputStream inputStream) {
            return (CTOfficeArtExtensionList) POIXMLTypeLoader.parse(inputStream, CTOfficeArtExtensionList.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtensionList parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTOfficeArtExtensionList) POIXMLTypeLoader.parse(inputStream, CTOfficeArtExtensionList.type, xmlOptions);
        }

        public static CTOfficeArtExtensionList parse(Reader reader) {
            return (CTOfficeArtExtensionList) POIXMLTypeLoader.parse(reader, CTOfficeArtExtensionList.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtensionList parse(Reader reader, XmlOptions xmlOptions) {
            return (CTOfficeArtExtensionList) POIXMLTypeLoader.parse(reader, CTOfficeArtExtensionList.type, xmlOptions);
        }

        public static CTOfficeArtExtensionList parse(String str) {
            return (CTOfficeArtExtensionList) POIXMLTypeLoader.parse(str, CTOfficeArtExtensionList.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtensionList parse(String str, XmlOptions xmlOptions) {
            return (CTOfficeArtExtensionList) POIXMLTypeLoader.parse(str, CTOfficeArtExtensionList.type, xmlOptions);
        }

        public static CTOfficeArtExtensionList parse(URL url) {
            return (CTOfficeArtExtensionList) POIXMLTypeLoader.parse(url, CTOfficeArtExtensionList.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtensionList parse(URL url, XmlOptions xmlOptions) {
            return (CTOfficeArtExtensionList) POIXMLTypeLoader.parse(url, CTOfficeArtExtensionList.type, xmlOptions);
        }

        public static CTOfficeArtExtensionList parse(XMLStreamReader xMLStreamReader) {
            return (CTOfficeArtExtensionList) POIXMLTypeLoader.parse(xMLStreamReader, CTOfficeArtExtensionList.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtensionList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTOfficeArtExtensionList) POIXMLTypeLoader.parse(xMLStreamReader, CTOfficeArtExtensionList.type, xmlOptions);
        }

        public static CTOfficeArtExtensionList parse(XMLInputStream xMLInputStream) {
            return (CTOfficeArtExtensionList) POIXMLTypeLoader.parse(xMLInputStream, CTOfficeArtExtensionList.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtensionList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTOfficeArtExtensionList) POIXMLTypeLoader.parse(xMLInputStream, CTOfficeArtExtensionList.type, xmlOptions);
        }

        public static CTOfficeArtExtensionList parse(Node node) {
            return (CTOfficeArtExtensionList) POIXMLTypeLoader.parse(node, CTOfficeArtExtensionList.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtensionList parse(Node node, XmlOptions xmlOptions) {
            return (CTOfficeArtExtensionList) POIXMLTypeLoader.parse(node, CTOfficeArtExtensionList.type, xmlOptions);
        }
    }

    CTOfficeArtExtension addNewExt();

    CTOfficeArtExtension getExtArray(int i);

    CTOfficeArtExtension[] getExtArray();

    List<CTOfficeArtExtension> getExtList();

    CTOfficeArtExtension insertNewExt(int i);

    void removeExt(int i);

    void setExtArray(int i, CTOfficeArtExtension cTOfficeArtExtension);

    void setExtArray(CTOfficeArtExtension[] cTOfficeArtExtensionArr);

    int sizeOfExtArray();
}
