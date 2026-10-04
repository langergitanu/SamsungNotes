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
public interface CTTableStyleList extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTableStyleList.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttablestylelist4bdctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTableStyleList newInstance() {
            return (CTTableStyleList) POIXMLTypeLoader.newInstance(CTTableStyleList.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTableStyleList.type, null);
        }

        public static CTTableStyleList parse(File file) {
            return (CTTableStyleList) POIXMLTypeLoader.parse(file, CTTableStyleList.type, (XmlOptions) null);
        }

        public static CTTableStyleList newInstance(XmlOptions xmlOptions) {
            return (CTTableStyleList) POIXMLTypeLoader.newInstance(CTTableStyleList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTableStyleList.type, xmlOptions);
        }

        public static CTTableStyleList parse(File file, XmlOptions xmlOptions) {
            return (CTTableStyleList) POIXMLTypeLoader.parse(file, CTTableStyleList.type, xmlOptions);
        }

        public static CTTableStyleList parse(InputStream inputStream) {
            return (CTTableStyleList) POIXMLTypeLoader.parse(inputStream, CTTableStyleList.type, (XmlOptions) null);
        }

        public static CTTableStyleList parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTableStyleList) POIXMLTypeLoader.parse(inputStream, CTTableStyleList.type, xmlOptions);
        }

        public static CTTableStyleList parse(Reader reader) {
            return (CTTableStyleList) POIXMLTypeLoader.parse(reader, CTTableStyleList.type, (XmlOptions) null);
        }

        public static CTTableStyleList parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTableStyleList) POIXMLTypeLoader.parse(reader, CTTableStyleList.type, xmlOptions);
        }

        public static CTTableStyleList parse(String str) {
            return (CTTableStyleList) POIXMLTypeLoader.parse(str, CTTableStyleList.type, (XmlOptions) null);
        }

        public static CTTableStyleList parse(String str, XmlOptions xmlOptions) {
            return (CTTableStyleList) POIXMLTypeLoader.parse(str, CTTableStyleList.type, xmlOptions);
        }

        public static CTTableStyleList parse(URL url) {
            return (CTTableStyleList) POIXMLTypeLoader.parse(url, CTTableStyleList.type, (XmlOptions) null);
        }

        public static CTTableStyleList parse(URL url, XmlOptions xmlOptions) {
            return (CTTableStyleList) POIXMLTypeLoader.parse(url, CTTableStyleList.type, xmlOptions);
        }

        public static CTTableStyleList parse(XMLStreamReader xMLStreamReader) {
            return (CTTableStyleList) POIXMLTypeLoader.parse(xMLStreamReader, CTTableStyleList.type, (XmlOptions) null);
        }

        public static CTTableStyleList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTableStyleList) POIXMLTypeLoader.parse(xMLStreamReader, CTTableStyleList.type, xmlOptions);
        }

        public static CTTableStyleList parse(XMLInputStream xMLInputStream) {
            return (CTTableStyleList) POIXMLTypeLoader.parse(xMLInputStream, CTTableStyleList.type, (XmlOptions) null);
        }

        public static CTTableStyleList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTableStyleList) POIXMLTypeLoader.parse(xMLInputStream, CTTableStyleList.type, xmlOptions);
        }

        public static CTTableStyleList parse(Node node) {
            return (CTTableStyleList) POIXMLTypeLoader.parse(node, CTTableStyleList.type, (XmlOptions) null);
        }

        public static CTTableStyleList parse(Node node, XmlOptions xmlOptions) {
            return (CTTableStyleList) POIXMLTypeLoader.parse(node, CTTableStyleList.type, xmlOptions);
        }
    }

    CTTableStyle addNewTblStyle();

    String getDef();

    CTTableStyle getTblStyleArray(int i);

    CTTableStyle[] getTblStyleArray();

    List<CTTableStyle> getTblStyleList();

    CTTableStyle insertNewTblStyle(int i);

    void removeTblStyle(int i);

    void setDef(String str);

    void setTblStyleArray(int i, CTTableStyle cTTableStyle);

    void setTblStyleArray(CTTableStyle[] cTTableStyleArr);

    int sizeOfTblStyleArray();

    STGuid xgetDef();

    void xsetDef(STGuid sTGuid);
}
