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
public interface CTSlideMasterIdList extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTSlideMasterIdList.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctslidemasteridlist0b63type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSlideMasterIdList newInstance() {
            return (CTSlideMasterIdList) POIXMLTypeLoader.newInstance(CTSlideMasterIdList.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSlideMasterIdList.type, null);
        }

        public static CTSlideMasterIdList parse(File file) {
            return (CTSlideMasterIdList) POIXMLTypeLoader.parse(file, CTSlideMasterIdList.type, (XmlOptions) null);
        }

        public static CTSlideMasterIdList newInstance(XmlOptions xmlOptions) {
            return (CTSlideMasterIdList) POIXMLTypeLoader.newInstance(CTSlideMasterIdList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSlideMasterIdList.type, xmlOptions);
        }

        public static CTSlideMasterIdList parse(File file, XmlOptions xmlOptions) {
            return (CTSlideMasterIdList) POIXMLTypeLoader.parse(file, CTSlideMasterIdList.type, xmlOptions);
        }

        public static CTSlideMasterIdList parse(InputStream inputStream) {
            return (CTSlideMasterIdList) POIXMLTypeLoader.parse(inputStream, CTSlideMasterIdList.type, (XmlOptions) null);
        }

        public static CTSlideMasterIdList parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTSlideMasterIdList) POIXMLTypeLoader.parse(inputStream, CTSlideMasterIdList.type, xmlOptions);
        }

        public static CTSlideMasterIdList parse(Reader reader) {
            return (CTSlideMasterIdList) POIXMLTypeLoader.parse(reader, CTSlideMasterIdList.type, (XmlOptions) null);
        }

        public static CTSlideMasterIdList parse(Reader reader, XmlOptions xmlOptions) {
            return (CTSlideMasterIdList) POIXMLTypeLoader.parse(reader, CTSlideMasterIdList.type, xmlOptions);
        }

        public static CTSlideMasterIdList parse(String str) {
            return (CTSlideMasterIdList) POIXMLTypeLoader.parse(str, CTSlideMasterIdList.type, (XmlOptions) null);
        }

        public static CTSlideMasterIdList parse(String str, XmlOptions xmlOptions) {
            return (CTSlideMasterIdList) POIXMLTypeLoader.parse(str, CTSlideMasterIdList.type, xmlOptions);
        }

        public static CTSlideMasterIdList parse(URL url) {
            return (CTSlideMasterIdList) POIXMLTypeLoader.parse(url, CTSlideMasterIdList.type, (XmlOptions) null);
        }

        public static CTSlideMasterIdList parse(URL url, XmlOptions xmlOptions) {
            return (CTSlideMasterIdList) POIXMLTypeLoader.parse(url, CTSlideMasterIdList.type, xmlOptions);
        }

        public static CTSlideMasterIdList parse(XMLStreamReader xMLStreamReader) {
            return (CTSlideMasterIdList) POIXMLTypeLoader.parse(xMLStreamReader, CTSlideMasterIdList.type, (XmlOptions) null);
        }

        public static CTSlideMasterIdList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTSlideMasterIdList) POIXMLTypeLoader.parse(xMLStreamReader, CTSlideMasterIdList.type, xmlOptions);
        }

        public static CTSlideMasterIdList parse(XMLInputStream xMLInputStream) {
            return (CTSlideMasterIdList) POIXMLTypeLoader.parse(xMLInputStream, CTSlideMasterIdList.type, (XmlOptions) null);
        }

        public static CTSlideMasterIdList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTSlideMasterIdList) POIXMLTypeLoader.parse(xMLInputStream, CTSlideMasterIdList.type, xmlOptions);
        }

        public static CTSlideMasterIdList parse(Node node) {
            return (CTSlideMasterIdList) POIXMLTypeLoader.parse(node, CTSlideMasterIdList.type, (XmlOptions) null);
        }

        public static CTSlideMasterIdList parse(Node node, XmlOptions xmlOptions) {
            return (CTSlideMasterIdList) POIXMLTypeLoader.parse(node, CTSlideMasterIdList.type, xmlOptions);
        }
    }

    CTSlideMasterIdListEntry addNewSldMasterId();

    CTSlideMasterIdListEntry getSldMasterIdArray(int i);

    CTSlideMasterIdListEntry[] getSldMasterIdArray();

    List<CTSlideMasterIdListEntry> getSldMasterIdList();

    CTSlideMasterIdListEntry insertNewSldMasterId(int i);

    void removeSldMasterId(int i);

    void setSldMasterIdArray(int i, CTSlideMasterIdListEntry cTSlideMasterIdListEntry);

    void setSldMasterIdArray(CTSlideMasterIdListEntry[] cTSlideMasterIdListEntryArr);

    int sizeOfSldMasterIdArray();
}
