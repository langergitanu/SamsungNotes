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
public interface CTLineStyleList extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTLineStyleList.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctlinestylelist510ctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTLineStyleList newInstance() {
            return (CTLineStyleList) POIXMLTypeLoader.newInstance(CTLineStyleList.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLineStyleList.type, null);
        }

        public static CTLineStyleList parse(File file) {
            return (CTLineStyleList) POIXMLTypeLoader.parse(file, CTLineStyleList.type, (XmlOptions) null);
        }

        public static CTLineStyleList newInstance(XmlOptions xmlOptions) {
            return (CTLineStyleList) POIXMLTypeLoader.newInstance(CTLineStyleList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLineStyleList.type, xmlOptions);
        }

        public static CTLineStyleList parse(File file, XmlOptions xmlOptions) {
            return (CTLineStyleList) POIXMLTypeLoader.parse(file, CTLineStyleList.type, xmlOptions);
        }

        public static CTLineStyleList parse(InputStream inputStream) {
            return (CTLineStyleList) POIXMLTypeLoader.parse(inputStream, CTLineStyleList.type, (XmlOptions) null);
        }

        public static CTLineStyleList parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTLineStyleList) POIXMLTypeLoader.parse(inputStream, CTLineStyleList.type, xmlOptions);
        }

        public static CTLineStyleList parse(Reader reader) {
            return (CTLineStyleList) POIXMLTypeLoader.parse(reader, CTLineStyleList.type, (XmlOptions) null);
        }

        public static CTLineStyleList parse(Reader reader, XmlOptions xmlOptions) {
            return (CTLineStyleList) POIXMLTypeLoader.parse(reader, CTLineStyleList.type, xmlOptions);
        }

        public static CTLineStyleList parse(String str) {
            return (CTLineStyleList) POIXMLTypeLoader.parse(str, CTLineStyleList.type, (XmlOptions) null);
        }

        public static CTLineStyleList parse(String str, XmlOptions xmlOptions) {
            return (CTLineStyleList) POIXMLTypeLoader.parse(str, CTLineStyleList.type, xmlOptions);
        }

        public static CTLineStyleList parse(URL url) {
            return (CTLineStyleList) POIXMLTypeLoader.parse(url, CTLineStyleList.type, (XmlOptions) null);
        }

        public static CTLineStyleList parse(URL url, XmlOptions xmlOptions) {
            return (CTLineStyleList) POIXMLTypeLoader.parse(url, CTLineStyleList.type, xmlOptions);
        }

        public static CTLineStyleList parse(XMLStreamReader xMLStreamReader) {
            return (CTLineStyleList) POIXMLTypeLoader.parse(xMLStreamReader, CTLineStyleList.type, (XmlOptions) null);
        }

        public static CTLineStyleList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTLineStyleList) POIXMLTypeLoader.parse(xMLStreamReader, CTLineStyleList.type, xmlOptions);
        }

        public static CTLineStyleList parse(XMLInputStream xMLInputStream) {
            return (CTLineStyleList) POIXMLTypeLoader.parse(xMLInputStream, CTLineStyleList.type, (XmlOptions) null);
        }

        public static CTLineStyleList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTLineStyleList) POIXMLTypeLoader.parse(xMLInputStream, CTLineStyleList.type, xmlOptions);
        }

        public static CTLineStyleList parse(Node node) {
            return (CTLineStyleList) POIXMLTypeLoader.parse(node, CTLineStyleList.type, (XmlOptions) null);
        }

        public static CTLineStyleList parse(Node node, XmlOptions xmlOptions) {
            return (CTLineStyleList) POIXMLTypeLoader.parse(node, CTLineStyleList.type, xmlOptions);
        }
    }

    CTLineProperties addNewLn();

    CTLineProperties getLnArray(int i);

    CTLineProperties[] getLnArray();

    List<CTLineProperties> getLnList();

    CTLineProperties insertNewLn(int i);

    void removeLn(int i);

    void setLnArray(int i, CTLineProperties cTLineProperties);

    void setLnArray(CTLineProperties[] cTLinePropertiesArr);

    int sizeOfLnArray();
}
