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
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTNumLvl extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTNumLvl.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctnumlvl416ctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTNumLvl newInstance() {
            return (CTNumLvl) POIXMLTypeLoader.newInstance(CTNumLvl.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNumLvl.type, null);
        }

        public static CTNumLvl parse(File file) {
            return (CTNumLvl) POIXMLTypeLoader.parse(file, CTNumLvl.type, (XmlOptions) null);
        }

        public static CTNumLvl newInstance(XmlOptions xmlOptions) {
            return (CTNumLvl) POIXMLTypeLoader.newInstance(CTNumLvl.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNumLvl.type, xmlOptions);
        }

        public static CTNumLvl parse(File file, XmlOptions xmlOptions) {
            return (CTNumLvl) POIXMLTypeLoader.parse(file, CTNumLvl.type, xmlOptions);
        }

        public static CTNumLvl parse(InputStream inputStream) {
            return (CTNumLvl) POIXMLTypeLoader.parse(inputStream, CTNumLvl.type, (XmlOptions) null);
        }

        public static CTNumLvl parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTNumLvl) POIXMLTypeLoader.parse(inputStream, CTNumLvl.type, xmlOptions);
        }

        public static CTNumLvl parse(Reader reader) {
            return (CTNumLvl) POIXMLTypeLoader.parse(reader, CTNumLvl.type, (XmlOptions) null);
        }

        public static CTNumLvl parse(Reader reader, XmlOptions xmlOptions) {
            return (CTNumLvl) POIXMLTypeLoader.parse(reader, CTNumLvl.type, xmlOptions);
        }

        public static CTNumLvl parse(String str) {
            return (CTNumLvl) POIXMLTypeLoader.parse(str, CTNumLvl.type, (XmlOptions) null);
        }

        public static CTNumLvl parse(String str, XmlOptions xmlOptions) {
            return (CTNumLvl) POIXMLTypeLoader.parse(str, CTNumLvl.type, xmlOptions);
        }

        public static CTNumLvl parse(URL url) {
            return (CTNumLvl) POIXMLTypeLoader.parse(url, CTNumLvl.type, (XmlOptions) null);
        }

        public static CTNumLvl parse(URL url, XmlOptions xmlOptions) {
            return (CTNumLvl) POIXMLTypeLoader.parse(url, CTNumLvl.type, xmlOptions);
        }

        public static CTNumLvl parse(XMLStreamReader xMLStreamReader) {
            return (CTNumLvl) POIXMLTypeLoader.parse(xMLStreamReader, CTNumLvl.type, (XmlOptions) null);
        }

        public static CTNumLvl parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTNumLvl) POIXMLTypeLoader.parse(xMLStreamReader, CTNumLvl.type, xmlOptions);
        }

        public static CTNumLvl parse(XMLInputStream xMLInputStream) {
            return (CTNumLvl) POIXMLTypeLoader.parse(xMLInputStream, CTNumLvl.type, (XmlOptions) null);
        }

        public static CTNumLvl parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTNumLvl) POIXMLTypeLoader.parse(xMLInputStream, CTNumLvl.type, xmlOptions);
        }

        public static CTNumLvl parse(Node node) {
            return (CTNumLvl) POIXMLTypeLoader.parse(node, CTNumLvl.type, (XmlOptions) null);
        }

        public static CTNumLvl parse(Node node, XmlOptions xmlOptions) {
            return (CTNumLvl) POIXMLTypeLoader.parse(node, CTNumLvl.type, xmlOptions);
        }
    }

    CTLvl addNewLvl();

    CTDecimalNumber addNewStartOverride();

    BigInteger getIlvl();

    CTLvl getLvl();

    CTDecimalNumber getStartOverride();

    boolean isSetLvl();

    boolean isSetStartOverride();

    void setIlvl(BigInteger bigInteger);

    void setLvl(CTLvl cTLvl);

    void setStartOverride(CTDecimalNumber cTDecimalNumber);

    void unsetLvl();

    void unsetStartOverride();

    STDecimalNumber xgetIlvl();

    void xsetIlvl(STDecimalNumber sTDecimalNumber);
}
