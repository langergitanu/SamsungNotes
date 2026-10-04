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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTLevelText extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTLevelText.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctleveltext0621type");

    public static final class Factory {
        private Factory() {
        }

        public static CTLevelText newInstance() {
            return (CTLevelText) POIXMLTypeLoader.newInstance(CTLevelText.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLevelText.type, null);
        }

        public static CTLevelText parse(File file) {
            return (CTLevelText) POIXMLTypeLoader.parse(file, CTLevelText.type, (XmlOptions) null);
        }

        public static CTLevelText newInstance(XmlOptions xmlOptions) {
            return (CTLevelText) POIXMLTypeLoader.newInstance(CTLevelText.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLevelText.type, xmlOptions);
        }

        public static CTLevelText parse(File file, XmlOptions xmlOptions) {
            return (CTLevelText) POIXMLTypeLoader.parse(file, CTLevelText.type, xmlOptions);
        }

        public static CTLevelText parse(InputStream inputStream) {
            return (CTLevelText) POIXMLTypeLoader.parse(inputStream, CTLevelText.type, (XmlOptions) null);
        }

        public static CTLevelText parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTLevelText) POIXMLTypeLoader.parse(inputStream, CTLevelText.type, xmlOptions);
        }

        public static CTLevelText parse(Reader reader) {
            return (CTLevelText) POIXMLTypeLoader.parse(reader, CTLevelText.type, (XmlOptions) null);
        }

        public static CTLevelText parse(Reader reader, XmlOptions xmlOptions) {
            return (CTLevelText) POIXMLTypeLoader.parse(reader, CTLevelText.type, xmlOptions);
        }

        public static CTLevelText parse(String str) {
            return (CTLevelText) POIXMLTypeLoader.parse(str, CTLevelText.type, (XmlOptions) null);
        }

        public static CTLevelText parse(String str, XmlOptions xmlOptions) {
            return (CTLevelText) POIXMLTypeLoader.parse(str, CTLevelText.type, xmlOptions);
        }

        public static CTLevelText parse(URL url) {
            return (CTLevelText) POIXMLTypeLoader.parse(url, CTLevelText.type, (XmlOptions) null);
        }

        public static CTLevelText parse(URL url, XmlOptions xmlOptions) {
            return (CTLevelText) POIXMLTypeLoader.parse(url, CTLevelText.type, xmlOptions);
        }

        public static CTLevelText parse(XMLStreamReader xMLStreamReader) {
            return (CTLevelText) POIXMLTypeLoader.parse(xMLStreamReader, CTLevelText.type, (XmlOptions) null);
        }

        public static CTLevelText parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTLevelText) POIXMLTypeLoader.parse(xMLStreamReader, CTLevelText.type, xmlOptions);
        }

        public static CTLevelText parse(XMLInputStream xMLInputStream) {
            return (CTLevelText) POIXMLTypeLoader.parse(xMLInputStream, CTLevelText.type, (XmlOptions) null);
        }

        public static CTLevelText parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTLevelText) POIXMLTypeLoader.parse(xMLInputStream, CTLevelText.type, xmlOptions);
        }

        public static CTLevelText parse(Node node) {
            return (CTLevelText) POIXMLTypeLoader.parse(node, CTLevelText.type, (XmlOptions) null);
        }

        public static CTLevelText parse(Node node, XmlOptions xmlOptions) {
            return (CTLevelText) POIXMLTypeLoader.parse(node, CTLevelText.type, xmlOptions);
        }
    }

    STOnOff.Enum getNull();

    String getVal();

    boolean isSetNull();

    boolean isSetVal();

    void setNull(STOnOff.Enum r12);

    void setVal(String str);

    void unsetNull();

    void unsetVal();

    STOnOff xgetNull();

    STString xgetVal();

    void xsetNull(STOnOff sTOnOff);

    void xsetVal(STString sTString);
}
