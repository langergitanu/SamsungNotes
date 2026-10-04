package org.openxmlformats.schemas.drawingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTTextLineBreak extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTextLineBreak.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttextlinebreak932ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextLineBreak newInstance() {
            return (CTTextLineBreak) POIXMLTypeLoader.newInstance(CTTextLineBreak.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextLineBreak.type, null);
        }

        public static CTTextLineBreak parse(File file) {
            return (CTTextLineBreak) POIXMLTypeLoader.parse(file, CTTextLineBreak.type, (XmlOptions) null);
        }

        public static CTTextLineBreak newInstance(XmlOptions xmlOptions) {
            return (CTTextLineBreak) POIXMLTypeLoader.newInstance(CTTextLineBreak.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextLineBreak.type, xmlOptions);
        }

        public static CTTextLineBreak parse(File file, XmlOptions xmlOptions) {
            return (CTTextLineBreak) POIXMLTypeLoader.parse(file, CTTextLineBreak.type, xmlOptions);
        }

        public static CTTextLineBreak parse(InputStream inputStream) {
            return (CTTextLineBreak) POIXMLTypeLoader.parse(inputStream, CTTextLineBreak.type, (XmlOptions) null);
        }

        public static CTTextLineBreak parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTextLineBreak) POIXMLTypeLoader.parse(inputStream, CTTextLineBreak.type, xmlOptions);
        }

        public static CTTextLineBreak parse(Reader reader) {
            return (CTTextLineBreak) POIXMLTypeLoader.parse(reader, CTTextLineBreak.type, (XmlOptions) null);
        }

        public static CTTextLineBreak parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTextLineBreak) POIXMLTypeLoader.parse(reader, CTTextLineBreak.type, xmlOptions);
        }

        public static CTTextLineBreak parse(String str) {
            return (CTTextLineBreak) POIXMLTypeLoader.parse(str, CTTextLineBreak.type, (XmlOptions) null);
        }

        public static CTTextLineBreak parse(String str, XmlOptions xmlOptions) {
            return (CTTextLineBreak) POIXMLTypeLoader.parse(str, CTTextLineBreak.type, xmlOptions);
        }

        public static CTTextLineBreak parse(URL url) {
            return (CTTextLineBreak) POIXMLTypeLoader.parse(url, CTTextLineBreak.type, (XmlOptions) null);
        }

        public static CTTextLineBreak parse(URL url, XmlOptions xmlOptions) {
            return (CTTextLineBreak) POIXMLTypeLoader.parse(url, CTTextLineBreak.type, xmlOptions);
        }

        public static CTTextLineBreak parse(XMLStreamReader xMLStreamReader) {
            return (CTTextLineBreak) POIXMLTypeLoader.parse(xMLStreamReader, CTTextLineBreak.type, (XmlOptions) null);
        }

        public static CTTextLineBreak parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTextLineBreak) POIXMLTypeLoader.parse(xMLStreamReader, CTTextLineBreak.type, xmlOptions);
        }

        public static CTTextLineBreak parse(XMLInputStream xMLInputStream) {
            return (CTTextLineBreak) POIXMLTypeLoader.parse(xMLInputStream, CTTextLineBreak.type, (XmlOptions) null);
        }

        public static CTTextLineBreak parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTextLineBreak) POIXMLTypeLoader.parse(xMLInputStream, CTTextLineBreak.type, xmlOptions);
        }

        public static CTTextLineBreak parse(Node node) {
            return (CTTextLineBreak) POIXMLTypeLoader.parse(node, CTTextLineBreak.type, (XmlOptions) null);
        }

        public static CTTextLineBreak parse(Node node, XmlOptions xmlOptions) {
            return (CTTextLineBreak) POIXMLTypeLoader.parse(node, CTTextLineBreak.type, xmlOptions);
        }
    }

    CTTextCharacterProperties addNewRPr();

    CTTextCharacterProperties getRPr();

    boolean isSetRPr();

    void setRPr(CTTextCharacterProperties cTTextCharacterProperties);

    void unsetRPr();
}
