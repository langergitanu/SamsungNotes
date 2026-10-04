package org.openxmlformats.schemas.presentationml.x2006.main;

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
public interface CTExtensionList extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTExtensionList.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctextensionlist4772type");

    public static final class Factory {
        private Factory() {
        }

        public static CTExtensionList newInstance() {
            return (CTExtensionList) POIXMLTypeLoader.newInstance(CTExtensionList.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTExtensionList.type, null);
        }

        public static CTExtensionList parse(File file) {
            return (CTExtensionList) POIXMLTypeLoader.parse(file, CTExtensionList.type, (XmlOptions) null);
        }

        public static CTExtensionList newInstance(XmlOptions xmlOptions) {
            return (CTExtensionList) POIXMLTypeLoader.newInstance(CTExtensionList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTExtensionList.type, xmlOptions);
        }

        public static CTExtensionList parse(File file, XmlOptions xmlOptions) {
            return (CTExtensionList) POIXMLTypeLoader.parse(file, CTExtensionList.type, xmlOptions);
        }

        public static CTExtensionList parse(InputStream inputStream) {
            return (CTExtensionList) POIXMLTypeLoader.parse(inputStream, CTExtensionList.type, (XmlOptions) null);
        }

        public static CTExtensionList parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTExtensionList) POIXMLTypeLoader.parse(inputStream, CTExtensionList.type, xmlOptions);
        }

        public static CTExtensionList parse(Reader reader) {
            return (CTExtensionList) POIXMLTypeLoader.parse(reader, CTExtensionList.type, (XmlOptions) null);
        }

        public static CTExtensionList parse(Reader reader, XmlOptions xmlOptions) {
            return (CTExtensionList) POIXMLTypeLoader.parse(reader, CTExtensionList.type, xmlOptions);
        }

        public static CTExtensionList parse(String str) {
            return (CTExtensionList) POIXMLTypeLoader.parse(str, CTExtensionList.type, (XmlOptions) null);
        }

        public static CTExtensionList parse(String str, XmlOptions xmlOptions) {
            return (CTExtensionList) POIXMLTypeLoader.parse(str, CTExtensionList.type, xmlOptions);
        }

        public static CTExtensionList parse(URL url) {
            return (CTExtensionList) POIXMLTypeLoader.parse(url, CTExtensionList.type, (XmlOptions) null);
        }

        public static CTExtensionList parse(URL url, XmlOptions xmlOptions) {
            return (CTExtensionList) POIXMLTypeLoader.parse(url, CTExtensionList.type, xmlOptions);
        }

        public static CTExtensionList parse(XMLStreamReader xMLStreamReader) {
            return (CTExtensionList) POIXMLTypeLoader.parse(xMLStreamReader, CTExtensionList.type, (XmlOptions) null);
        }

        public static CTExtensionList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTExtensionList) POIXMLTypeLoader.parse(xMLStreamReader, CTExtensionList.type, xmlOptions);
        }

        public static CTExtensionList parse(XMLInputStream xMLInputStream) {
            return (CTExtensionList) POIXMLTypeLoader.parse(xMLInputStream, CTExtensionList.type, (XmlOptions) null);
        }

        public static CTExtensionList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTExtensionList) POIXMLTypeLoader.parse(xMLInputStream, CTExtensionList.type, xmlOptions);
        }

        public static CTExtensionList parse(Node node) {
            return (CTExtensionList) POIXMLTypeLoader.parse(node, CTExtensionList.type, (XmlOptions) null);
        }

        public static CTExtensionList parse(Node node, XmlOptions xmlOptions) {
            return (CTExtensionList) POIXMLTypeLoader.parse(node, CTExtensionList.type, xmlOptions);
        }
    }

    CTExtension addNewExt();

    CTExtension getExtArray(int i);

    CTExtension[] getExtArray();

    List<CTExtension> getExtList();

    CTExtension insertNewExt(int i);

    void removeExt(int i);

    void setExtArray(int i, CTExtension cTExtension);

    void setExtArray(CTExtension[] cTExtensionArr);

    int sizeOfExtArray();
}
