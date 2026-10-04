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
public interface CTSlideIdList extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTSlideIdList.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctslideidlist70a5type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSlideIdList newInstance() {
            return (CTSlideIdList) POIXMLTypeLoader.newInstance(CTSlideIdList.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSlideIdList.type, null);
        }

        public static CTSlideIdList parse(File file) {
            return (CTSlideIdList) POIXMLTypeLoader.parse(file, CTSlideIdList.type, (XmlOptions) null);
        }

        public static CTSlideIdList newInstance(XmlOptions xmlOptions) {
            return (CTSlideIdList) POIXMLTypeLoader.newInstance(CTSlideIdList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSlideIdList.type, xmlOptions);
        }

        public static CTSlideIdList parse(File file, XmlOptions xmlOptions) {
            return (CTSlideIdList) POIXMLTypeLoader.parse(file, CTSlideIdList.type, xmlOptions);
        }

        public static CTSlideIdList parse(InputStream inputStream) {
            return (CTSlideIdList) POIXMLTypeLoader.parse(inputStream, CTSlideIdList.type, (XmlOptions) null);
        }

        public static CTSlideIdList parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTSlideIdList) POIXMLTypeLoader.parse(inputStream, CTSlideIdList.type, xmlOptions);
        }

        public static CTSlideIdList parse(Reader reader) {
            return (CTSlideIdList) POIXMLTypeLoader.parse(reader, CTSlideIdList.type, (XmlOptions) null);
        }

        public static CTSlideIdList parse(Reader reader, XmlOptions xmlOptions) {
            return (CTSlideIdList) POIXMLTypeLoader.parse(reader, CTSlideIdList.type, xmlOptions);
        }

        public static CTSlideIdList parse(String str) {
            return (CTSlideIdList) POIXMLTypeLoader.parse(str, CTSlideIdList.type, (XmlOptions) null);
        }

        public static CTSlideIdList parse(String str, XmlOptions xmlOptions) {
            return (CTSlideIdList) POIXMLTypeLoader.parse(str, CTSlideIdList.type, xmlOptions);
        }

        public static CTSlideIdList parse(URL url) {
            return (CTSlideIdList) POIXMLTypeLoader.parse(url, CTSlideIdList.type, (XmlOptions) null);
        }

        public static CTSlideIdList parse(URL url, XmlOptions xmlOptions) {
            return (CTSlideIdList) POIXMLTypeLoader.parse(url, CTSlideIdList.type, xmlOptions);
        }

        public static CTSlideIdList parse(XMLStreamReader xMLStreamReader) {
            return (CTSlideIdList) POIXMLTypeLoader.parse(xMLStreamReader, CTSlideIdList.type, (XmlOptions) null);
        }

        public static CTSlideIdList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTSlideIdList) POIXMLTypeLoader.parse(xMLStreamReader, CTSlideIdList.type, xmlOptions);
        }

        public static CTSlideIdList parse(XMLInputStream xMLInputStream) {
            return (CTSlideIdList) POIXMLTypeLoader.parse(xMLInputStream, CTSlideIdList.type, (XmlOptions) null);
        }

        public static CTSlideIdList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTSlideIdList) POIXMLTypeLoader.parse(xMLInputStream, CTSlideIdList.type, xmlOptions);
        }

        public static CTSlideIdList parse(Node node) {
            return (CTSlideIdList) POIXMLTypeLoader.parse(node, CTSlideIdList.type, (XmlOptions) null);
        }

        public static CTSlideIdList parse(Node node, XmlOptions xmlOptions) {
            return (CTSlideIdList) POIXMLTypeLoader.parse(node, CTSlideIdList.type, xmlOptions);
        }
    }

    CTSlideIdListEntry addNewSldId();

    CTSlideIdListEntry getSldIdArray(int i);

    CTSlideIdListEntry[] getSldIdArray();

    List<CTSlideIdListEntry> getSldIdList();

    CTSlideIdListEntry insertNewSldId(int i);

    void removeSldId(int i);

    void setSldIdArray(int i, CTSlideIdListEntry cTSlideIdListEntry);

    void setSldIdArray(CTSlideIdListEntry[] cTSlideIdListEntryArr);

    int sizeOfSldIdArray();
}
