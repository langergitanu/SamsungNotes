package org.openxmlformats.schemas.presentationml.x2006.main;

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
public interface CTSlideSize extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTSlideSize.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctslidesizeb0fdtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTSlideSize newInstance() {
            return (CTSlideSize) POIXMLTypeLoader.newInstance(CTSlideSize.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSlideSize.type, null);
        }

        public static CTSlideSize parse(File file) {
            return (CTSlideSize) POIXMLTypeLoader.parse(file, CTSlideSize.type, (XmlOptions) null);
        }

        public static CTSlideSize newInstance(XmlOptions xmlOptions) {
            return (CTSlideSize) POIXMLTypeLoader.newInstance(CTSlideSize.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSlideSize.type, xmlOptions);
        }

        public static CTSlideSize parse(File file, XmlOptions xmlOptions) {
            return (CTSlideSize) POIXMLTypeLoader.parse(file, CTSlideSize.type, xmlOptions);
        }

        public static CTSlideSize parse(InputStream inputStream) {
            return (CTSlideSize) POIXMLTypeLoader.parse(inputStream, CTSlideSize.type, (XmlOptions) null);
        }

        public static CTSlideSize parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTSlideSize) POIXMLTypeLoader.parse(inputStream, CTSlideSize.type, xmlOptions);
        }

        public static CTSlideSize parse(Reader reader) {
            return (CTSlideSize) POIXMLTypeLoader.parse(reader, CTSlideSize.type, (XmlOptions) null);
        }

        public static CTSlideSize parse(Reader reader, XmlOptions xmlOptions) {
            return (CTSlideSize) POIXMLTypeLoader.parse(reader, CTSlideSize.type, xmlOptions);
        }

        public static CTSlideSize parse(String str) {
            return (CTSlideSize) POIXMLTypeLoader.parse(str, CTSlideSize.type, (XmlOptions) null);
        }

        public static CTSlideSize parse(String str, XmlOptions xmlOptions) {
            return (CTSlideSize) POIXMLTypeLoader.parse(str, CTSlideSize.type, xmlOptions);
        }

        public static CTSlideSize parse(URL url) {
            return (CTSlideSize) POIXMLTypeLoader.parse(url, CTSlideSize.type, (XmlOptions) null);
        }

        public static CTSlideSize parse(URL url, XmlOptions xmlOptions) {
            return (CTSlideSize) POIXMLTypeLoader.parse(url, CTSlideSize.type, xmlOptions);
        }

        public static CTSlideSize parse(XMLStreamReader xMLStreamReader) {
            return (CTSlideSize) POIXMLTypeLoader.parse(xMLStreamReader, CTSlideSize.type, (XmlOptions) null);
        }

        public static CTSlideSize parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTSlideSize) POIXMLTypeLoader.parse(xMLStreamReader, CTSlideSize.type, xmlOptions);
        }

        public static CTSlideSize parse(XMLInputStream xMLInputStream) {
            return (CTSlideSize) POIXMLTypeLoader.parse(xMLInputStream, CTSlideSize.type, (XmlOptions) null);
        }

        public static CTSlideSize parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTSlideSize) POIXMLTypeLoader.parse(xMLInputStream, CTSlideSize.type, xmlOptions);
        }

        public static CTSlideSize parse(Node node) {
            return (CTSlideSize) POIXMLTypeLoader.parse(node, CTSlideSize.type, (XmlOptions) null);
        }

        public static CTSlideSize parse(Node node, XmlOptions xmlOptions) {
            return (CTSlideSize) POIXMLTypeLoader.parse(node, CTSlideSize.type, xmlOptions);
        }
    }

    int getCx();

    int getCy();

    STSlideSizeType$Enum getType();

    boolean isSetType();

    void setCx(int i);

    void setCy(int i);

    void setType(STSlideSizeType$Enum sTSlideSizeType$Enum);

    void unsetType();

    STSlideSizeCoordinate xgetCx();

    STSlideSizeCoordinate xgetCy();

    STSlideSizeType xgetType();

    void xsetCx(STSlideSizeCoordinate sTSlideSizeCoordinate);

    void xsetCy(STSlideSizeCoordinate sTSlideSizeCoordinate);

    void xsetType(STSlideSizeType sTSlideSizeType);
}
