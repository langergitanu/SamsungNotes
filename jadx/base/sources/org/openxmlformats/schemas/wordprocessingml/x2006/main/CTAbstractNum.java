package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
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
public interface CTAbstractNum extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTAbstractNum.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctabstractnum588etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTAbstractNum newInstance() {
            return (CTAbstractNum) POIXMLTypeLoader.newInstance(CTAbstractNum.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTAbstractNum.type, null);
        }

        public static CTAbstractNum parse(File file) {
            return (CTAbstractNum) POIXMLTypeLoader.parse(file, CTAbstractNum.type, (XmlOptions) null);
        }

        public static CTAbstractNum newInstance(XmlOptions xmlOptions) {
            return (CTAbstractNum) POIXMLTypeLoader.newInstance(CTAbstractNum.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTAbstractNum.type, xmlOptions);
        }

        public static CTAbstractNum parse(File file, XmlOptions xmlOptions) {
            return (CTAbstractNum) POIXMLTypeLoader.parse(file, CTAbstractNum.type, xmlOptions);
        }

        public static CTAbstractNum parse(InputStream inputStream) {
            return (CTAbstractNum) POIXMLTypeLoader.parse(inputStream, CTAbstractNum.type, (XmlOptions) null);
        }

        public static CTAbstractNum parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTAbstractNum) POIXMLTypeLoader.parse(inputStream, CTAbstractNum.type, xmlOptions);
        }

        public static CTAbstractNum parse(Reader reader) {
            return (CTAbstractNum) POIXMLTypeLoader.parse(reader, CTAbstractNum.type, (XmlOptions) null);
        }

        public static CTAbstractNum parse(Reader reader, XmlOptions xmlOptions) {
            return (CTAbstractNum) POIXMLTypeLoader.parse(reader, CTAbstractNum.type, xmlOptions);
        }

        public static CTAbstractNum parse(String str) {
            return (CTAbstractNum) POIXMLTypeLoader.parse(str, CTAbstractNum.type, (XmlOptions) null);
        }

        public static CTAbstractNum parse(String str, XmlOptions xmlOptions) {
            return (CTAbstractNum) POIXMLTypeLoader.parse(str, CTAbstractNum.type, xmlOptions);
        }

        public static CTAbstractNum parse(URL url) {
            return (CTAbstractNum) POIXMLTypeLoader.parse(url, CTAbstractNum.type, (XmlOptions) null);
        }

        public static CTAbstractNum parse(URL url, XmlOptions xmlOptions) {
            return (CTAbstractNum) POIXMLTypeLoader.parse(url, CTAbstractNum.type, xmlOptions);
        }

        public static CTAbstractNum parse(XMLStreamReader xMLStreamReader) {
            return (CTAbstractNum) POIXMLTypeLoader.parse(xMLStreamReader, CTAbstractNum.type, (XmlOptions) null);
        }

        public static CTAbstractNum parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTAbstractNum) POIXMLTypeLoader.parse(xMLStreamReader, CTAbstractNum.type, xmlOptions);
        }

        public static CTAbstractNum parse(XMLInputStream xMLInputStream) {
            return (CTAbstractNum) POIXMLTypeLoader.parse(xMLInputStream, CTAbstractNum.type, (XmlOptions) null);
        }

        public static CTAbstractNum parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTAbstractNum) POIXMLTypeLoader.parse(xMLInputStream, CTAbstractNum.type, xmlOptions);
        }

        public static CTAbstractNum parse(Node node) {
            return (CTAbstractNum) POIXMLTypeLoader.parse(node, CTAbstractNum.type, (XmlOptions) null);
        }

        public static CTAbstractNum parse(Node node, XmlOptions xmlOptions) {
            return (CTAbstractNum) POIXMLTypeLoader.parse(node, CTAbstractNum.type, xmlOptions);
        }
    }

    CTLvl addNewLvl();

    CTMultiLevelType addNewMultiLevelType();

    CTString addNewName();

    CTLongHexNumber addNewNsid();

    CTString addNewNumStyleLink();

    CTString addNewStyleLink();

    CTLongHexNumber addNewTmpl();

    BigInteger getAbstractNumId();

    CTLvl getLvlArray(int i);

    CTLvl[] getLvlArray();

    List<CTLvl> getLvlList();

    CTMultiLevelType getMultiLevelType();

    CTString getName();

    CTLongHexNumber getNsid();

    CTString getNumStyleLink();

    CTString getStyleLink();

    CTLongHexNumber getTmpl();

    CTLvl insertNewLvl(int i);

    boolean isSetMultiLevelType();

    boolean isSetName();

    boolean isSetNsid();

    boolean isSetNumStyleLink();

    boolean isSetStyleLink();

    boolean isSetTmpl();

    void removeLvl(int i);

    void setAbstractNumId(BigInteger bigInteger);

    void setLvlArray(int i, CTLvl cTLvl);

    void setLvlArray(CTLvl[] cTLvlArr);

    void setMultiLevelType(CTMultiLevelType cTMultiLevelType);

    void setName(CTString cTString);

    void setNsid(CTLongHexNumber cTLongHexNumber);

    void setNumStyleLink(CTString cTString);

    void setStyleLink(CTString cTString);

    void setTmpl(CTLongHexNumber cTLongHexNumber);

    int sizeOfLvlArray();

    void unsetMultiLevelType();

    void unsetName();

    void unsetNsid();

    void unsetNumStyleLink();

    void unsetStyleLink();

    void unsetTmpl();

    STDecimalNumber xgetAbstractNumId();

    void xsetAbstractNumId(STDecimalNumber sTDecimalNumber);
}
