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
public interface CTConnectionSiteList extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTConnectionSiteList.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctconnectionsitelistab9etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTConnectionSiteList newInstance() {
            return (CTConnectionSiteList) POIXMLTypeLoader.newInstance(CTConnectionSiteList.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTConnectionSiteList.type, null);
        }

        public static CTConnectionSiteList parse(File file) {
            return (CTConnectionSiteList) POIXMLTypeLoader.parse(file, CTConnectionSiteList.type, (XmlOptions) null);
        }

        public static CTConnectionSiteList newInstance(XmlOptions xmlOptions) {
            return (CTConnectionSiteList) POIXMLTypeLoader.newInstance(CTConnectionSiteList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTConnectionSiteList.type, xmlOptions);
        }

        public static CTConnectionSiteList parse(File file, XmlOptions xmlOptions) {
            return (CTConnectionSiteList) POIXMLTypeLoader.parse(file, CTConnectionSiteList.type, xmlOptions);
        }

        public static CTConnectionSiteList parse(InputStream inputStream) {
            return (CTConnectionSiteList) POIXMLTypeLoader.parse(inputStream, CTConnectionSiteList.type, (XmlOptions) null);
        }

        public static CTConnectionSiteList parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTConnectionSiteList) POIXMLTypeLoader.parse(inputStream, CTConnectionSiteList.type, xmlOptions);
        }

        public static CTConnectionSiteList parse(Reader reader) {
            return (CTConnectionSiteList) POIXMLTypeLoader.parse(reader, CTConnectionSiteList.type, (XmlOptions) null);
        }

        public static CTConnectionSiteList parse(Reader reader, XmlOptions xmlOptions) {
            return (CTConnectionSiteList) POIXMLTypeLoader.parse(reader, CTConnectionSiteList.type, xmlOptions);
        }

        public static CTConnectionSiteList parse(String str) {
            return (CTConnectionSiteList) POIXMLTypeLoader.parse(str, CTConnectionSiteList.type, (XmlOptions) null);
        }

        public static CTConnectionSiteList parse(String str, XmlOptions xmlOptions) {
            return (CTConnectionSiteList) POIXMLTypeLoader.parse(str, CTConnectionSiteList.type, xmlOptions);
        }

        public static CTConnectionSiteList parse(URL url) {
            return (CTConnectionSiteList) POIXMLTypeLoader.parse(url, CTConnectionSiteList.type, (XmlOptions) null);
        }

        public static CTConnectionSiteList parse(URL url, XmlOptions xmlOptions) {
            return (CTConnectionSiteList) POIXMLTypeLoader.parse(url, CTConnectionSiteList.type, xmlOptions);
        }

        public static CTConnectionSiteList parse(XMLStreamReader xMLStreamReader) {
            return (CTConnectionSiteList) POIXMLTypeLoader.parse(xMLStreamReader, CTConnectionSiteList.type, (XmlOptions) null);
        }

        public static CTConnectionSiteList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTConnectionSiteList) POIXMLTypeLoader.parse(xMLStreamReader, CTConnectionSiteList.type, xmlOptions);
        }

        public static CTConnectionSiteList parse(XMLInputStream xMLInputStream) {
            return (CTConnectionSiteList) POIXMLTypeLoader.parse(xMLInputStream, CTConnectionSiteList.type, (XmlOptions) null);
        }

        public static CTConnectionSiteList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTConnectionSiteList) POIXMLTypeLoader.parse(xMLInputStream, CTConnectionSiteList.type, xmlOptions);
        }

        public static CTConnectionSiteList parse(Node node) {
            return (CTConnectionSiteList) POIXMLTypeLoader.parse(node, CTConnectionSiteList.type, (XmlOptions) null);
        }

        public static CTConnectionSiteList parse(Node node, XmlOptions xmlOptions) {
            return (CTConnectionSiteList) POIXMLTypeLoader.parse(node, CTConnectionSiteList.type, xmlOptions);
        }
    }

    CTConnectionSite addNewCxn();

    CTConnectionSite getCxnArray(int i);

    CTConnectionSite[] getCxnArray();

    List<CTConnectionSite> getCxnList();

    CTConnectionSite insertNewCxn(int i);

    void removeCxn(int i);

    void setCxnArray(int i, CTConnectionSite cTConnectionSite);

    void setCxnArray(CTConnectionSite[] cTConnectionSiteArr);

    int sizeOfCxnArray();
}
