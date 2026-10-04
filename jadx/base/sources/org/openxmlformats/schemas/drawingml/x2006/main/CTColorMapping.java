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
import org.openxmlformats.schemas.drawingml.x2006.main.STColorSchemeIndex;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTColorMapping extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTColorMapping.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctcolormapping5bc6type");

    public static final class Factory {
        private Factory() {
        }

        public static CTColorMapping newInstance() {
            return (CTColorMapping) POIXMLTypeLoader.newInstance(CTColorMapping.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTColorMapping.type, null);
        }

        public static CTColorMapping parse(File file) {
            return (CTColorMapping) POIXMLTypeLoader.parse(file, CTColorMapping.type, (XmlOptions) null);
        }

        public static CTColorMapping newInstance(XmlOptions xmlOptions) {
            return (CTColorMapping) POIXMLTypeLoader.newInstance(CTColorMapping.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTColorMapping.type, xmlOptions);
        }

        public static CTColorMapping parse(File file, XmlOptions xmlOptions) {
            return (CTColorMapping) POIXMLTypeLoader.parse(file, CTColorMapping.type, xmlOptions);
        }

        public static CTColorMapping parse(InputStream inputStream) {
            return (CTColorMapping) POIXMLTypeLoader.parse(inputStream, CTColorMapping.type, (XmlOptions) null);
        }

        public static CTColorMapping parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTColorMapping) POIXMLTypeLoader.parse(inputStream, CTColorMapping.type, xmlOptions);
        }

        public static CTColorMapping parse(Reader reader) {
            return (CTColorMapping) POIXMLTypeLoader.parse(reader, CTColorMapping.type, (XmlOptions) null);
        }

        public static CTColorMapping parse(Reader reader, XmlOptions xmlOptions) {
            return (CTColorMapping) POIXMLTypeLoader.parse(reader, CTColorMapping.type, xmlOptions);
        }

        public static CTColorMapping parse(String str) {
            return (CTColorMapping) POIXMLTypeLoader.parse(str, CTColorMapping.type, (XmlOptions) null);
        }

        public static CTColorMapping parse(String str, XmlOptions xmlOptions) {
            return (CTColorMapping) POIXMLTypeLoader.parse(str, CTColorMapping.type, xmlOptions);
        }

        public static CTColorMapping parse(URL url) {
            return (CTColorMapping) POIXMLTypeLoader.parse(url, CTColorMapping.type, (XmlOptions) null);
        }

        public static CTColorMapping parse(URL url, XmlOptions xmlOptions) {
            return (CTColorMapping) POIXMLTypeLoader.parse(url, CTColorMapping.type, xmlOptions);
        }

        public static CTColorMapping parse(XMLStreamReader xMLStreamReader) {
            return (CTColorMapping) POIXMLTypeLoader.parse(xMLStreamReader, CTColorMapping.type, (XmlOptions) null);
        }

        public static CTColorMapping parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTColorMapping) POIXMLTypeLoader.parse(xMLStreamReader, CTColorMapping.type, xmlOptions);
        }

        public static CTColorMapping parse(XMLInputStream xMLInputStream) {
            return (CTColorMapping) POIXMLTypeLoader.parse(xMLInputStream, CTColorMapping.type, (XmlOptions) null);
        }

        public static CTColorMapping parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTColorMapping) POIXMLTypeLoader.parse(xMLInputStream, CTColorMapping.type, xmlOptions);
        }

        public static CTColorMapping parse(Node node) {
            return (CTColorMapping) POIXMLTypeLoader.parse(node, CTColorMapping.type, (XmlOptions) null);
        }

        public static CTColorMapping parse(Node node, XmlOptions xmlOptions) {
            return (CTColorMapping) POIXMLTypeLoader.parse(node, CTColorMapping.type, xmlOptions);
        }
    }

    CTOfficeArtExtensionList addNewExtLst();

    STColorSchemeIndex.Enum getAccent1();

    STColorSchemeIndex.Enum getAccent2();

    STColorSchemeIndex.Enum getAccent3();

    STColorSchemeIndex.Enum getAccent4();

    STColorSchemeIndex.Enum getAccent5();

    STColorSchemeIndex.Enum getAccent6();

    STColorSchemeIndex.Enum getBg1();

    STColorSchemeIndex.Enum getBg2();

    CTOfficeArtExtensionList getExtLst();

    STColorSchemeIndex.Enum getFolHlink();

    STColorSchemeIndex.Enum getHlink();

    STColorSchemeIndex.Enum getTx1();

    STColorSchemeIndex.Enum getTx2();

    boolean isSetExtLst();

    void setAccent1(STColorSchemeIndex.Enum r12);

    void setAccent2(STColorSchemeIndex.Enum r12);

    void setAccent3(STColorSchemeIndex.Enum r12);

    void setAccent4(STColorSchemeIndex.Enum r12);

    void setAccent5(STColorSchemeIndex.Enum r12);

    void setAccent6(STColorSchemeIndex.Enum r12);

    void setBg1(STColorSchemeIndex.Enum r12);

    void setBg2(STColorSchemeIndex.Enum r12);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setFolHlink(STColorSchemeIndex.Enum r12);

    void setHlink(STColorSchemeIndex.Enum r12);

    void setTx1(STColorSchemeIndex.Enum r12);

    void setTx2(STColorSchemeIndex.Enum r12);

    void unsetExtLst();

    STColorSchemeIndex xgetAccent1();

    STColorSchemeIndex xgetAccent2();

    STColorSchemeIndex xgetAccent3();

    STColorSchemeIndex xgetAccent4();

    STColorSchemeIndex xgetAccent5();

    STColorSchemeIndex xgetAccent6();

    STColorSchemeIndex xgetBg1();

    STColorSchemeIndex xgetBg2();

    STColorSchemeIndex xgetFolHlink();

    STColorSchemeIndex xgetHlink();

    STColorSchemeIndex xgetTx1();

    STColorSchemeIndex xgetTx2();

    void xsetAccent1(STColorSchemeIndex sTColorSchemeIndex);

    void xsetAccent2(STColorSchemeIndex sTColorSchemeIndex);

    void xsetAccent3(STColorSchemeIndex sTColorSchemeIndex);

    void xsetAccent4(STColorSchemeIndex sTColorSchemeIndex);

    void xsetAccent5(STColorSchemeIndex sTColorSchemeIndex);

    void xsetAccent6(STColorSchemeIndex sTColorSchemeIndex);

    void xsetBg1(STColorSchemeIndex sTColorSchemeIndex);

    void xsetBg2(STColorSchemeIndex sTColorSchemeIndex);

    void xsetFolHlink(STColorSchemeIndex sTColorSchemeIndex);

    void xsetHlink(STColorSchemeIndex sTColorSchemeIndex);

    void xsetTx1(STColorSchemeIndex sTColorSchemeIndex);

    void xsetTx2(STColorSchemeIndex sTColorSchemeIndex);
}
