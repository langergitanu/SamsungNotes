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
public interface CTEndnotes extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTEndnotes.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctendnotescee2type");

    public static final class Factory {
        private Factory() {
        }

        public static CTEndnotes newInstance() {
            return (CTEndnotes) POIXMLTypeLoader.newInstance(CTEndnotes.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTEndnotes.type, null);
        }

        public static CTEndnotes parse(File file) {
            return (CTEndnotes) POIXMLTypeLoader.parse(file, CTEndnotes.type, (XmlOptions) null);
        }

        public static CTEndnotes newInstance(XmlOptions xmlOptions) {
            return (CTEndnotes) POIXMLTypeLoader.newInstance(CTEndnotes.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTEndnotes.type, xmlOptions);
        }

        public static CTEndnotes parse(File file, XmlOptions xmlOptions) {
            return (CTEndnotes) POIXMLTypeLoader.parse(file, CTEndnotes.type, xmlOptions);
        }

        public static CTEndnotes parse(InputStream inputStream) {
            return (CTEndnotes) POIXMLTypeLoader.parse(inputStream, CTEndnotes.type, (XmlOptions) null);
        }

        public static CTEndnotes parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTEndnotes) POIXMLTypeLoader.parse(inputStream, CTEndnotes.type, xmlOptions);
        }

        public static CTEndnotes parse(Reader reader) {
            return (CTEndnotes) POIXMLTypeLoader.parse(reader, CTEndnotes.type, (XmlOptions) null);
        }

        public static CTEndnotes parse(Reader reader, XmlOptions xmlOptions) {
            return (CTEndnotes) POIXMLTypeLoader.parse(reader, CTEndnotes.type, xmlOptions);
        }

        public static CTEndnotes parse(String str) {
            return (CTEndnotes) POIXMLTypeLoader.parse(str, CTEndnotes.type, (XmlOptions) null);
        }

        public static CTEndnotes parse(String str, XmlOptions xmlOptions) {
            return (CTEndnotes) POIXMLTypeLoader.parse(str, CTEndnotes.type, xmlOptions);
        }

        public static CTEndnotes parse(URL url) {
            return (CTEndnotes) POIXMLTypeLoader.parse(url, CTEndnotes.type, (XmlOptions) null);
        }

        public static CTEndnotes parse(URL url, XmlOptions xmlOptions) {
            return (CTEndnotes) POIXMLTypeLoader.parse(url, CTEndnotes.type, xmlOptions);
        }

        public static CTEndnotes parse(XMLStreamReader xMLStreamReader) {
            return (CTEndnotes) POIXMLTypeLoader.parse(xMLStreamReader, CTEndnotes.type, (XmlOptions) null);
        }

        public static CTEndnotes parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTEndnotes) POIXMLTypeLoader.parse(xMLStreamReader, CTEndnotes.type, xmlOptions);
        }

        public static CTEndnotes parse(XMLInputStream xMLInputStream) {
            return (CTEndnotes) POIXMLTypeLoader.parse(xMLInputStream, CTEndnotes.type, (XmlOptions) null);
        }

        public static CTEndnotes parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTEndnotes) POIXMLTypeLoader.parse(xMLInputStream, CTEndnotes.type, xmlOptions);
        }

        public static CTEndnotes parse(Node node) {
            return (CTEndnotes) POIXMLTypeLoader.parse(node, CTEndnotes.type, (XmlOptions) null);
        }

        public static CTEndnotes parse(Node node, XmlOptions xmlOptions) {
            return (CTEndnotes) POIXMLTypeLoader.parse(node, CTEndnotes.type, xmlOptions);
        }
    }

    CTFtnEdn addNewEndnote();

    CTFtnEdn getEndnoteArray(int i);

    CTFtnEdn[] getEndnoteArray();

    List<CTFtnEdn> getEndnoteList();

    CTFtnEdn insertNewEndnote(int i);

    void removeEndnote(int i);

    void setEndnoteArray(int i, CTFtnEdn cTFtnEdn);

    void setEndnoteArray(CTFtnEdn[] cTFtnEdnArr);

    int sizeOfEndnoteArray();
}
