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
public interface CTFootnotes extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTFootnotes.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctfootnotes691ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTFootnotes newInstance() {
            return (CTFootnotes) POIXMLTypeLoader.newInstance(CTFootnotes.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFootnotes.type, null);
        }

        public static CTFootnotes parse(File file) {
            return (CTFootnotes) POIXMLTypeLoader.parse(file, CTFootnotes.type, (XmlOptions) null);
        }

        public static CTFootnotes newInstance(XmlOptions xmlOptions) {
            return (CTFootnotes) POIXMLTypeLoader.newInstance(CTFootnotes.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFootnotes.type, xmlOptions);
        }

        public static CTFootnotes parse(File file, XmlOptions xmlOptions) {
            return (CTFootnotes) POIXMLTypeLoader.parse(file, CTFootnotes.type, xmlOptions);
        }

        public static CTFootnotes parse(InputStream inputStream) {
            return (CTFootnotes) POIXMLTypeLoader.parse(inputStream, CTFootnotes.type, (XmlOptions) null);
        }

        public static CTFootnotes parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTFootnotes) POIXMLTypeLoader.parse(inputStream, CTFootnotes.type, xmlOptions);
        }

        public static CTFootnotes parse(Reader reader) {
            return (CTFootnotes) POIXMLTypeLoader.parse(reader, CTFootnotes.type, (XmlOptions) null);
        }

        public static CTFootnotes parse(Reader reader, XmlOptions xmlOptions) {
            return (CTFootnotes) POIXMLTypeLoader.parse(reader, CTFootnotes.type, xmlOptions);
        }

        public static CTFootnotes parse(String str) {
            return (CTFootnotes) POIXMLTypeLoader.parse(str, CTFootnotes.type, (XmlOptions) null);
        }

        public static CTFootnotes parse(String str, XmlOptions xmlOptions) {
            return (CTFootnotes) POIXMLTypeLoader.parse(str, CTFootnotes.type, xmlOptions);
        }

        public static CTFootnotes parse(URL url) {
            return (CTFootnotes) POIXMLTypeLoader.parse(url, CTFootnotes.type, (XmlOptions) null);
        }

        public static CTFootnotes parse(URL url, XmlOptions xmlOptions) {
            return (CTFootnotes) POIXMLTypeLoader.parse(url, CTFootnotes.type, xmlOptions);
        }

        public static CTFootnotes parse(XMLStreamReader xMLStreamReader) {
            return (CTFootnotes) POIXMLTypeLoader.parse(xMLStreamReader, CTFootnotes.type, (XmlOptions) null);
        }

        public static CTFootnotes parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTFootnotes) POIXMLTypeLoader.parse(xMLStreamReader, CTFootnotes.type, xmlOptions);
        }

        public static CTFootnotes parse(XMLInputStream xMLInputStream) {
            return (CTFootnotes) POIXMLTypeLoader.parse(xMLInputStream, CTFootnotes.type, (XmlOptions) null);
        }

        public static CTFootnotes parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTFootnotes) POIXMLTypeLoader.parse(xMLInputStream, CTFootnotes.type, xmlOptions);
        }

        public static CTFootnotes parse(Node node) {
            return (CTFootnotes) POIXMLTypeLoader.parse(node, CTFootnotes.type, (XmlOptions) null);
        }

        public static CTFootnotes parse(Node node, XmlOptions xmlOptions) {
            return (CTFootnotes) POIXMLTypeLoader.parse(node, CTFootnotes.type, xmlOptions);
        }
    }

    CTFtnEdn addNewFootnote();

    CTFtnEdn getFootnoteArray(int i);

    CTFtnEdn[] getFootnoteArray();

    List<CTFtnEdn> getFootnoteList();

    CTFtnEdn insertNewFootnote(int i);

    void removeFootnote(int i);

    void setFootnoteArray(int i, CTFtnEdn cTFtnEdn);

    void setFootnoteArray(CTFtnEdn[] cTFtnEdnArr);

    int sizeOfFootnoteArray();
}
