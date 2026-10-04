package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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
public interface CTTabs extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTabs.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttabsa2aatype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTabs newInstance() {
            return (CTTabs) POIXMLTypeLoader.newInstance(CTTabs.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTabs.type, null);
        }

        public static CTTabs parse(File file) {
            return (CTTabs) POIXMLTypeLoader.parse(file, CTTabs.type, (XmlOptions) null);
        }

        public static CTTabs newInstance(XmlOptions xmlOptions) {
            return (CTTabs) POIXMLTypeLoader.newInstance(CTTabs.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTabs.type, xmlOptions);
        }

        public static CTTabs parse(File file, XmlOptions xmlOptions) {
            return (CTTabs) POIXMLTypeLoader.parse(file, CTTabs.type, xmlOptions);
        }

        public static CTTabs parse(InputStream inputStream) {
            return (CTTabs) POIXMLTypeLoader.parse(inputStream, CTTabs.type, (XmlOptions) null);
        }

        public static CTTabs parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTabs) POIXMLTypeLoader.parse(inputStream, CTTabs.type, xmlOptions);
        }

        public static CTTabs parse(Reader reader) {
            return (CTTabs) POIXMLTypeLoader.parse(reader, CTTabs.type, (XmlOptions) null);
        }

        public static CTTabs parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTabs) POIXMLTypeLoader.parse(reader, CTTabs.type, xmlOptions);
        }

        public static CTTabs parse(String str) {
            return (CTTabs) POIXMLTypeLoader.parse(str, CTTabs.type, (XmlOptions) null);
        }

        public static CTTabs parse(String str, XmlOptions xmlOptions) {
            return (CTTabs) POIXMLTypeLoader.parse(str, CTTabs.type, xmlOptions);
        }

        public static CTTabs parse(URL url) {
            return (CTTabs) POIXMLTypeLoader.parse(url, CTTabs.type, (XmlOptions) null);
        }

        public static CTTabs parse(URL url, XmlOptions xmlOptions) {
            return (CTTabs) POIXMLTypeLoader.parse(url, CTTabs.type, xmlOptions);
        }

        public static CTTabs parse(XMLStreamReader xMLStreamReader) {
            return (CTTabs) POIXMLTypeLoader.parse(xMLStreamReader, CTTabs.type, (XmlOptions) null);
        }

        public static CTTabs parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTabs) POIXMLTypeLoader.parse(xMLStreamReader, CTTabs.type, xmlOptions);
        }

        public static CTTabs parse(XMLInputStream xMLInputStream) {
            return (CTTabs) POIXMLTypeLoader.parse(xMLInputStream, CTTabs.type, (XmlOptions) null);
        }

        public static CTTabs parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTabs) POIXMLTypeLoader.parse(xMLInputStream, CTTabs.type, xmlOptions);
        }

        public static CTTabs parse(Node node) {
            return (CTTabs) POIXMLTypeLoader.parse(node, CTTabs.type, (XmlOptions) null);
        }

        public static CTTabs parse(Node node, XmlOptions xmlOptions) {
            return (CTTabs) POIXMLTypeLoader.parse(node, CTTabs.type, xmlOptions);
        }
    }

    CTTabStop addNewTab();

    CTTabStop getTabArray(int i);

    CTTabStop[] getTabArray();

    List<CTTabStop> getTabList();

    CTTabStop insertNewTab(int i);

    void removeTab(int i);

    void setTabArray(int i, CTTabStop cTTabStop);

    void setTabArray(CTTabStop[] cTTabStopArr);

    int sizeOfTabArray();
}
