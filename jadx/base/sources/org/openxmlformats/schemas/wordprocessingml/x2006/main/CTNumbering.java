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
public interface CTNumbering extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTNumbering.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctnumberingfdf9type");

    public static final class Factory {
        private Factory() {
        }

        public static CTNumbering newInstance() {
            return (CTNumbering) POIXMLTypeLoader.newInstance(CTNumbering.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNumbering.type, null);
        }

        public static CTNumbering parse(File file) {
            return (CTNumbering) POIXMLTypeLoader.parse(file, CTNumbering.type, (XmlOptions) null);
        }

        public static CTNumbering newInstance(XmlOptions xmlOptions) {
            return (CTNumbering) POIXMLTypeLoader.newInstance(CTNumbering.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNumbering.type, xmlOptions);
        }

        public static CTNumbering parse(File file, XmlOptions xmlOptions) {
            return (CTNumbering) POIXMLTypeLoader.parse(file, CTNumbering.type, xmlOptions);
        }

        public static CTNumbering parse(InputStream inputStream) {
            return (CTNumbering) POIXMLTypeLoader.parse(inputStream, CTNumbering.type, (XmlOptions) null);
        }

        public static CTNumbering parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTNumbering) POIXMLTypeLoader.parse(inputStream, CTNumbering.type, xmlOptions);
        }

        public static CTNumbering parse(Reader reader) {
            return (CTNumbering) POIXMLTypeLoader.parse(reader, CTNumbering.type, (XmlOptions) null);
        }

        public static CTNumbering parse(Reader reader, XmlOptions xmlOptions) {
            return (CTNumbering) POIXMLTypeLoader.parse(reader, CTNumbering.type, xmlOptions);
        }

        public static CTNumbering parse(String str) {
            return (CTNumbering) POIXMLTypeLoader.parse(str, CTNumbering.type, (XmlOptions) null);
        }

        public static CTNumbering parse(String str, XmlOptions xmlOptions) {
            return (CTNumbering) POIXMLTypeLoader.parse(str, CTNumbering.type, xmlOptions);
        }

        public static CTNumbering parse(URL url) {
            return (CTNumbering) POIXMLTypeLoader.parse(url, CTNumbering.type, (XmlOptions) null);
        }

        public static CTNumbering parse(URL url, XmlOptions xmlOptions) {
            return (CTNumbering) POIXMLTypeLoader.parse(url, CTNumbering.type, xmlOptions);
        }

        public static CTNumbering parse(XMLStreamReader xMLStreamReader) {
            return (CTNumbering) POIXMLTypeLoader.parse(xMLStreamReader, CTNumbering.type, (XmlOptions) null);
        }

        public static CTNumbering parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTNumbering) POIXMLTypeLoader.parse(xMLStreamReader, CTNumbering.type, xmlOptions);
        }

        public static CTNumbering parse(XMLInputStream xMLInputStream) {
            return (CTNumbering) POIXMLTypeLoader.parse(xMLInputStream, CTNumbering.type, (XmlOptions) null);
        }

        public static CTNumbering parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTNumbering) POIXMLTypeLoader.parse(xMLInputStream, CTNumbering.type, xmlOptions);
        }

        public static CTNumbering parse(Node node) {
            return (CTNumbering) POIXMLTypeLoader.parse(node, CTNumbering.type, (XmlOptions) null);
        }

        public static CTNumbering parse(Node node, XmlOptions xmlOptions) {
            return (CTNumbering) POIXMLTypeLoader.parse(node, CTNumbering.type, xmlOptions);
        }
    }

    CTAbstractNum addNewAbstractNum();

    CTNum addNewNum();

    CTDecimalNumber addNewNumIdMacAtCleanup();

    CTNumPicBullet addNewNumPicBullet();

    CTAbstractNum getAbstractNumArray(int i);

    CTAbstractNum[] getAbstractNumArray();

    List<CTAbstractNum> getAbstractNumList();

    CTNum getNumArray(int i);

    CTNum[] getNumArray();

    CTDecimalNumber getNumIdMacAtCleanup();

    List<CTNum> getNumList();

    CTNumPicBullet getNumPicBulletArray(int i);

    CTNumPicBullet[] getNumPicBulletArray();

    List<CTNumPicBullet> getNumPicBulletList();

    CTAbstractNum insertNewAbstractNum(int i);

    CTNum insertNewNum(int i);

    CTNumPicBullet insertNewNumPicBullet(int i);

    boolean isSetNumIdMacAtCleanup();

    void removeAbstractNum(int i);

    void removeNum(int i);

    void removeNumPicBullet(int i);

    void setAbstractNumArray(int i, CTAbstractNum cTAbstractNum);

    void setAbstractNumArray(CTAbstractNum[] cTAbstractNumArr);

    void setNumArray(int i, CTNum cTNum);

    void setNumArray(CTNum[] cTNumArr);

    void setNumIdMacAtCleanup(CTDecimalNumber cTDecimalNumber);

    void setNumPicBulletArray(int i, CTNumPicBullet cTNumPicBullet);

    void setNumPicBulletArray(CTNumPicBullet[] cTNumPicBulletArr);

    int sizeOfAbstractNumArray();

    int sizeOfNumArray();

    int sizeOfNumPicBulletArray();

    void unsetNumIdMacAtCleanup();
}
