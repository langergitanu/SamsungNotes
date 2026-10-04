package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTTblWidth extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTblWidth.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttblwidthec40type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTblWidth newInstance() {
            return (CTTblWidth) POIXMLTypeLoader.newInstance(CTTblWidth.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTblWidth.type, null);
        }

        public static CTTblWidth parse(File file) {
            return (CTTblWidth) POIXMLTypeLoader.parse(file, CTTblWidth.type, (XmlOptions) null);
        }

        public static CTTblWidth newInstance(XmlOptions xmlOptions) {
            return (CTTblWidth) POIXMLTypeLoader.newInstance(CTTblWidth.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTblWidth.type, xmlOptions);
        }

        public static CTTblWidth parse(File file, XmlOptions xmlOptions) {
            return (CTTblWidth) POIXMLTypeLoader.parse(file, CTTblWidth.type, xmlOptions);
        }

        public static CTTblWidth parse(InputStream inputStream) {
            return (CTTblWidth) POIXMLTypeLoader.parse(inputStream, CTTblWidth.type, (XmlOptions) null);
        }

        public static CTTblWidth parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTblWidth) POIXMLTypeLoader.parse(inputStream, CTTblWidth.type, xmlOptions);
        }

        public static CTTblWidth parse(Reader reader) {
            return (CTTblWidth) POIXMLTypeLoader.parse(reader, CTTblWidth.type, (XmlOptions) null);
        }

        public static CTTblWidth parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTblWidth) POIXMLTypeLoader.parse(reader, CTTblWidth.type, xmlOptions);
        }

        public static CTTblWidth parse(String str) {
            return (CTTblWidth) POIXMLTypeLoader.parse(str, CTTblWidth.type, (XmlOptions) null);
        }

        public static CTTblWidth parse(String str, XmlOptions xmlOptions) {
            return (CTTblWidth) POIXMLTypeLoader.parse(str, CTTblWidth.type, xmlOptions);
        }

        public static CTTblWidth parse(URL url) {
            return (CTTblWidth) POIXMLTypeLoader.parse(url, CTTblWidth.type, (XmlOptions) null);
        }

        public static CTTblWidth parse(URL url, XmlOptions xmlOptions) {
            return (CTTblWidth) POIXMLTypeLoader.parse(url, CTTblWidth.type, xmlOptions);
        }

        public static CTTblWidth parse(XMLStreamReader xMLStreamReader) {
            return (CTTblWidth) POIXMLTypeLoader.parse(xMLStreamReader, CTTblWidth.type, (XmlOptions) null);
        }

        public static CTTblWidth parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTblWidth) POIXMLTypeLoader.parse(xMLStreamReader, CTTblWidth.type, xmlOptions);
        }

        public static CTTblWidth parse(XMLInputStream xMLInputStream) {
            return (CTTblWidth) POIXMLTypeLoader.parse(xMLInputStream, CTTblWidth.type, (XmlOptions) null);
        }

        public static CTTblWidth parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTblWidth) POIXMLTypeLoader.parse(xMLInputStream, CTTblWidth.type, xmlOptions);
        }

        public static CTTblWidth parse(Node node) {
            return (CTTblWidth) POIXMLTypeLoader.parse(node, CTTblWidth.type, (XmlOptions) null);
        }

        public static CTTblWidth parse(Node node, XmlOptions xmlOptions) {
            return (CTTblWidth) POIXMLTypeLoader.parse(node, CTTblWidth.type, xmlOptions);
        }
    }

    STTblWidth.Enum getType();

    BigInteger getW();

    boolean isSetType();

    boolean isSetW();

    void setType(STTblWidth.Enum r12);

    void setW(BigInteger bigInteger);

    void unsetType();

    void unsetW();

    STTblWidth xgetType();

    STDecimalNumber xgetW();

    void xsetType(STTblWidth sTTblWidth);

    void xsetW(STDecimalNumber sTDecimalNumber);
}
