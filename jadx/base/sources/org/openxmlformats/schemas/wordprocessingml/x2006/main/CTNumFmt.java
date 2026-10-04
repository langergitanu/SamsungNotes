package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STNumberFormat;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTNumFmt extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTNumFmt.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctnumfmt00e1type");

    public static final class Factory {
        private Factory() {
        }

        public static CTNumFmt newInstance() {
            return (CTNumFmt) POIXMLTypeLoader.newInstance(CTNumFmt.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNumFmt.type, null);
        }

        public static CTNumFmt parse(File file) {
            return (CTNumFmt) POIXMLTypeLoader.parse(file, CTNumFmt.type, (XmlOptions) null);
        }

        public static CTNumFmt newInstance(XmlOptions xmlOptions) {
            return (CTNumFmt) POIXMLTypeLoader.newInstance(CTNumFmt.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNumFmt.type, xmlOptions);
        }

        public static CTNumFmt parse(File file, XmlOptions xmlOptions) {
            return (CTNumFmt) POIXMLTypeLoader.parse(file, CTNumFmt.type, xmlOptions);
        }

        public static CTNumFmt parse(InputStream inputStream) {
            return (CTNumFmt) POIXMLTypeLoader.parse(inputStream, CTNumFmt.type, (XmlOptions) null);
        }

        public static CTNumFmt parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTNumFmt) POIXMLTypeLoader.parse(inputStream, CTNumFmt.type, xmlOptions);
        }

        public static CTNumFmt parse(Reader reader) {
            return (CTNumFmt) POIXMLTypeLoader.parse(reader, CTNumFmt.type, (XmlOptions) null);
        }

        public static CTNumFmt parse(Reader reader, XmlOptions xmlOptions) {
            return (CTNumFmt) POIXMLTypeLoader.parse(reader, CTNumFmt.type, xmlOptions);
        }

        public static CTNumFmt parse(String str) {
            return (CTNumFmt) POIXMLTypeLoader.parse(str, CTNumFmt.type, (XmlOptions) null);
        }

        public static CTNumFmt parse(String str, XmlOptions xmlOptions) {
            return (CTNumFmt) POIXMLTypeLoader.parse(str, CTNumFmt.type, xmlOptions);
        }

        public static CTNumFmt parse(URL url) {
            return (CTNumFmt) POIXMLTypeLoader.parse(url, CTNumFmt.type, (XmlOptions) null);
        }

        public static CTNumFmt parse(URL url, XmlOptions xmlOptions) {
            return (CTNumFmt) POIXMLTypeLoader.parse(url, CTNumFmt.type, xmlOptions);
        }

        public static CTNumFmt parse(XMLStreamReader xMLStreamReader) {
            return (CTNumFmt) POIXMLTypeLoader.parse(xMLStreamReader, CTNumFmt.type, (XmlOptions) null);
        }

        public static CTNumFmt parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTNumFmt) POIXMLTypeLoader.parse(xMLStreamReader, CTNumFmt.type, xmlOptions);
        }

        public static CTNumFmt parse(XMLInputStream xMLInputStream) {
            return (CTNumFmt) POIXMLTypeLoader.parse(xMLInputStream, CTNumFmt.type, (XmlOptions) null);
        }

        public static CTNumFmt parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTNumFmt) POIXMLTypeLoader.parse(xMLInputStream, CTNumFmt.type, xmlOptions);
        }

        public static CTNumFmt parse(Node node) {
            return (CTNumFmt) POIXMLTypeLoader.parse(node, CTNumFmt.type, (XmlOptions) null);
        }

        public static CTNumFmt parse(Node node, XmlOptions xmlOptions) {
            return (CTNumFmt) POIXMLTypeLoader.parse(node, CTNumFmt.type, xmlOptions);
        }
    }

    STNumberFormat.Enum getVal();

    void setVal(STNumberFormat.Enum r12);

    STNumberFormat xgetVal();

    void xsetVal(STNumberFormat sTNumberFormat);
}
