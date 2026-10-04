package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.Calendar;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTTrackChange extends CTMarkup {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTrackChange.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttrackchangec317type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTrackChange newInstance() {
            return (CTTrackChange) POIXMLTypeLoader.newInstance(CTTrackChange.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTrackChange.type, null);
        }

        public static CTTrackChange parse(File file) {
            return (CTTrackChange) POIXMLTypeLoader.parse(file, CTTrackChange.type, (XmlOptions) null);
        }

        public static CTTrackChange newInstance(XmlOptions xmlOptions) {
            return (CTTrackChange) POIXMLTypeLoader.newInstance(CTTrackChange.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTrackChange.type, xmlOptions);
        }

        public static CTTrackChange parse(File file, XmlOptions xmlOptions) {
            return (CTTrackChange) POIXMLTypeLoader.parse(file, CTTrackChange.type, xmlOptions);
        }

        public static CTTrackChange parse(InputStream inputStream) {
            return (CTTrackChange) POIXMLTypeLoader.parse(inputStream, CTTrackChange.type, (XmlOptions) null);
        }

        public static CTTrackChange parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTrackChange) POIXMLTypeLoader.parse(inputStream, CTTrackChange.type, xmlOptions);
        }

        public static CTTrackChange parse(Reader reader) {
            return (CTTrackChange) POIXMLTypeLoader.parse(reader, CTTrackChange.type, (XmlOptions) null);
        }

        public static CTTrackChange parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTrackChange) POIXMLTypeLoader.parse(reader, CTTrackChange.type, xmlOptions);
        }

        public static CTTrackChange parse(String str) {
            return (CTTrackChange) POIXMLTypeLoader.parse(str, CTTrackChange.type, (XmlOptions) null);
        }

        public static CTTrackChange parse(String str, XmlOptions xmlOptions) {
            return (CTTrackChange) POIXMLTypeLoader.parse(str, CTTrackChange.type, xmlOptions);
        }

        public static CTTrackChange parse(URL url) {
            return (CTTrackChange) POIXMLTypeLoader.parse(url, CTTrackChange.type, (XmlOptions) null);
        }

        public static CTTrackChange parse(URL url, XmlOptions xmlOptions) {
            return (CTTrackChange) POIXMLTypeLoader.parse(url, CTTrackChange.type, xmlOptions);
        }

        public static CTTrackChange parse(XMLStreamReader xMLStreamReader) {
            return (CTTrackChange) POIXMLTypeLoader.parse(xMLStreamReader, CTTrackChange.type, (XmlOptions) null);
        }

        public static CTTrackChange parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTrackChange) POIXMLTypeLoader.parse(xMLStreamReader, CTTrackChange.type, xmlOptions);
        }

        public static CTTrackChange parse(XMLInputStream xMLInputStream) {
            return (CTTrackChange) POIXMLTypeLoader.parse(xMLInputStream, CTTrackChange.type, (XmlOptions) null);
        }

        public static CTTrackChange parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTrackChange) POIXMLTypeLoader.parse(xMLInputStream, CTTrackChange.type, xmlOptions);
        }

        public static CTTrackChange parse(Node node) {
            return (CTTrackChange) POIXMLTypeLoader.parse(node, CTTrackChange.type, (XmlOptions) null);
        }

        public static CTTrackChange parse(Node node, XmlOptions xmlOptions) {
            return (CTTrackChange) POIXMLTypeLoader.parse(node, CTTrackChange.type, xmlOptions);
        }
    }

    String getAuthor();

    Calendar getDate();

    boolean isSetDate();

    void setAuthor(String str);

    void setDate(Calendar calendar);

    void unsetDate();

    STString xgetAuthor();

    STDateTime xgetDate();

    void xsetAuthor(STString sTString);

    void xsetDate(STDateTime sTDateTime);
}
