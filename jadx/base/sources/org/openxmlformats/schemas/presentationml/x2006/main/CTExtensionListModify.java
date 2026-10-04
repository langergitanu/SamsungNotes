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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTExtensionListModify extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTExtensionListModify.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctextensionlistmodify8c58type");

    public static final class Factory {
        private Factory() {
        }

        public static CTExtensionListModify newInstance() {
            return (CTExtensionListModify) POIXMLTypeLoader.newInstance(CTExtensionListModify.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTExtensionListModify.type, null);
        }

        public static CTExtensionListModify parse(File file) {
            return (CTExtensionListModify) POIXMLTypeLoader.parse(file, CTExtensionListModify.type, (XmlOptions) null);
        }

        public static CTExtensionListModify newInstance(XmlOptions xmlOptions) {
            return (CTExtensionListModify) POIXMLTypeLoader.newInstance(CTExtensionListModify.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTExtensionListModify.type, xmlOptions);
        }

        public static CTExtensionListModify parse(File file, XmlOptions xmlOptions) {
            return (CTExtensionListModify) POIXMLTypeLoader.parse(file, CTExtensionListModify.type, xmlOptions);
        }

        public static CTExtensionListModify parse(InputStream inputStream) {
            return (CTExtensionListModify) POIXMLTypeLoader.parse(inputStream, CTExtensionListModify.type, (XmlOptions) null);
        }

        public static CTExtensionListModify parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTExtensionListModify) POIXMLTypeLoader.parse(inputStream, CTExtensionListModify.type, xmlOptions);
        }

        public static CTExtensionListModify parse(Reader reader) {
            return (CTExtensionListModify) POIXMLTypeLoader.parse(reader, CTExtensionListModify.type, (XmlOptions) null);
        }

        public static CTExtensionListModify parse(Reader reader, XmlOptions xmlOptions) {
            return (CTExtensionListModify) POIXMLTypeLoader.parse(reader, CTExtensionListModify.type, xmlOptions);
        }

        public static CTExtensionListModify parse(String str) {
            return (CTExtensionListModify) POIXMLTypeLoader.parse(str, CTExtensionListModify.type, (XmlOptions) null);
        }

        public static CTExtensionListModify parse(String str, XmlOptions xmlOptions) {
            return (CTExtensionListModify) POIXMLTypeLoader.parse(str, CTExtensionListModify.type, xmlOptions);
        }

        public static CTExtensionListModify parse(URL url) {
            return (CTExtensionListModify) POIXMLTypeLoader.parse(url, CTExtensionListModify.type, (XmlOptions) null);
        }

        public static CTExtensionListModify parse(URL url, XmlOptions xmlOptions) {
            return (CTExtensionListModify) POIXMLTypeLoader.parse(url, CTExtensionListModify.type, xmlOptions);
        }

        public static CTExtensionListModify parse(XMLStreamReader xMLStreamReader) {
            return (CTExtensionListModify) POIXMLTypeLoader.parse(xMLStreamReader, CTExtensionListModify.type, (XmlOptions) null);
        }

        public static CTExtensionListModify parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTExtensionListModify) POIXMLTypeLoader.parse(xMLStreamReader, CTExtensionListModify.type, xmlOptions);
        }

        public static CTExtensionListModify parse(XMLInputStream xMLInputStream) {
            return (CTExtensionListModify) POIXMLTypeLoader.parse(xMLInputStream, CTExtensionListModify.type, (XmlOptions) null);
        }

        public static CTExtensionListModify parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTExtensionListModify) POIXMLTypeLoader.parse(xMLInputStream, CTExtensionListModify.type, xmlOptions);
        }

        public static CTExtensionListModify parse(Node node) {
            return (CTExtensionListModify) POIXMLTypeLoader.parse(node, CTExtensionListModify.type, (XmlOptions) null);
        }

        public static CTExtensionListModify parse(Node node, XmlOptions xmlOptions) {
            return (CTExtensionListModify) POIXMLTypeLoader.parse(node, CTExtensionListModify.type, xmlOptions);
        }
    }

    CTExtension addNewExt();

    CTExtension getExtArray(int i);

    CTExtension[] getExtArray();

    List<CTExtension> getExtList();

    boolean getMod();

    CTExtension insertNewExt(int i);

    boolean isSetMod();

    void removeExt(int i);

    void setExtArray(int i, CTExtension cTExtension);

    void setExtArray(CTExtension[] cTExtensionArr);

    void setMod(boolean z);

    int sizeOfExtArray();

    void unsetMod();

    XmlBoolean xgetMod();

    void xsetMod(XmlBoolean xmlBoolean);
}
