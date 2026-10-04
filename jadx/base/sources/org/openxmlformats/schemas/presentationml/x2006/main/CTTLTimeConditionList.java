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
public interface CTTLTimeConditionList extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTLTimeConditionList.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttltimeconditionlistebbbtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTLTimeConditionList newInstance() {
            return (CTTLTimeConditionList) POIXMLTypeLoader.newInstance(CTTLTimeConditionList.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTLTimeConditionList.type, null);
        }

        public static CTTLTimeConditionList parse(File file) {
            return (CTTLTimeConditionList) POIXMLTypeLoader.parse(file, CTTLTimeConditionList.type, (XmlOptions) null);
        }

        public static CTTLTimeConditionList newInstance(XmlOptions xmlOptions) {
            return (CTTLTimeConditionList) POIXMLTypeLoader.newInstance(CTTLTimeConditionList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTLTimeConditionList.type, xmlOptions);
        }

        public static CTTLTimeConditionList parse(File file, XmlOptions xmlOptions) {
            return (CTTLTimeConditionList) POIXMLTypeLoader.parse(file, CTTLTimeConditionList.type, xmlOptions);
        }

        public static CTTLTimeConditionList parse(InputStream inputStream) {
            return (CTTLTimeConditionList) POIXMLTypeLoader.parse(inputStream, CTTLTimeConditionList.type, (XmlOptions) null);
        }

        public static CTTLTimeConditionList parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTLTimeConditionList) POIXMLTypeLoader.parse(inputStream, CTTLTimeConditionList.type, xmlOptions);
        }

        public static CTTLTimeConditionList parse(Reader reader) {
            return (CTTLTimeConditionList) POIXMLTypeLoader.parse(reader, CTTLTimeConditionList.type, (XmlOptions) null);
        }

        public static CTTLTimeConditionList parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTLTimeConditionList) POIXMLTypeLoader.parse(reader, CTTLTimeConditionList.type, xmlOptions);
        }

        public static CTTLTimeConditionList parse(String str) {
            return (CTTLTimeConditionList) POIXMLTypeLoader.parse(str, CTTLTimeConditionList.type, (XmlOptions) null);
        }

        public static CTTLTimeConditionList parse(String str, XmlOptions xmlOptions) {
            return (CTTLTimeConditionList) POIXMLTypeLoader.parse(str, CTTLTimeConditionList.type, xmlOptions);
        }

        public static CTTLTimeConditionList parse(URL url) {
            return (CTTLTimeConditionList) POIXMLTypeLoader.parse(url, CTTLTimeConditionList.type, (XmlOptions) null);
        }

        public static CTTLTimeConditionList parse(URL url, XmlOptions xmlOptions) {
            return (CTTLTimeConditionList) POIXMLTypeLoader.parse(url, CTTLTimeConditionList.type, xmlOptions);
        }

        public static CTTLTimeConditionList parse(XMLStreamReader xMLStreamReader) {
            return (CTTLTimeConditionList) POIXMLTypeLoader.parse(xMLStreamReader, CTTLTimeConditionList.type, (XmlOptions) null);
        }

        public static CTTLTimeConditionList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTLTimeConditionList) POIXMLTypeLoader.parse(xMLStreamReader, CTTLTimeConditionList.type, xmlOptions);
        }

        public static CTTLTimeConditionList parse(XMLInputStream xMLInputStream) {
            return (CTTLTimeConditionList) POIXMLTypeLoader.parse(xMLInputStream, CTTLTimeConditionList.type, (XmlOptions) null);
        }

        public static CTTLTimeConditionList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTLTimeConditionList) POIXMLTypeLoader.parse(xMLInputStream, CTTLTimeConditionList.type, xmlOptions);
        }

        public static CTTLTimeConditionList parse(Node node) {
            return (CTTLTimeConditionList) POIXMLTypeLoader.parse(node, CTTLTimeConditionList.type, (XmlOptions) null);
        }

        public static CTTLTimeConditionList parse(Node node, XmlOptions xmlOptions) {
            return (CTTLTimeConditionList) POIXMLTypeLoader.parse(node, CTTLTimeConditionList.type, xmlOptions);
        }
    }

    CTTLTimeCondition addNewCond();

    CTTLTimeCondition getCondArray(int i);

    CTTLTimeCondition[] getCondArray();

    List<CTTLTimeCondition> getCondList();

    CTTLTimeCondition insertNewCond(int i);

    void removeCond(int i);

    void setCondArray(int i, CTTLTimeCondition cTTLTimeCondition);

    void setCondArray(CTTLTimeCondition[] cTTLTimeConditionArr);

    int sizeOfCondArray();
}
