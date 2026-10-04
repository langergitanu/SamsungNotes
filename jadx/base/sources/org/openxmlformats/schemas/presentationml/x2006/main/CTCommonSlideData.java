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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTCommonSlideData extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTCommonSlideData.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctcommonslidedata8c7ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTCommonSlideData newInstance() {
            return (CTCommonSlideData) POIXMLTypeLoader.newInstance(CTCommonSlideData.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTCommonSlideData.type, null);
        }

        public static CTCommonSlideData parse(File file) {
            return (CTCommonSlideData) POIXMLTypeLoader.parse(file, CTCommonSlideData.type, (XmlOptions) null);
        }

        public static CTCommonSlideData newInstance(XmlOptions xmlOptions) {
            return (CTCommonSlideData) POIXMLTypeLoader.newInstance(CTCommonSlideData.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTCommonSlideData.type, xmlOptions);
        }

        public static CTCommonSlideData parse(File file, XmlOptions xmlOptions) {
            return (CTCommonSlideData) POIXMLTypeLoader.parse(file, CTCommonSlideData.type, xmlOptions);
        }

        public static CTCommonSlideData parse(InputStream inputStream) {
            return (CTCommonSlideData) POIXMLTypeLoader.parse(inputStream, CTCommonSlideData.type, (XmlOptions) null);
        }

        public static CTCommonSlideData parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTCommonSlideData) POIXMLTypeLoader.parse(inputStream, CTCommonSlideData.type, xmlOptions);
        }

        public static CTCommonSlideData parse(Reader reader) {
            return (CTCommonSlideData) POIXMLTypeLoader.parse(reader, CTCommonSlideData.type, (XmlOptions) null);
        }

        public static CTCommonSlideData parse(Reader reader, XmlOptions xmlOptions) {
            return (CTCommonSlideData) POIXMLTypeLoader.parse(reader, CTCommonSlideData.type, xmlOptions);
        }

        public static CTCommonSlideData parse(String str) {
            return (CTCommonSlideData) POIXMLTypeLoader.parse(str, CTCommonSlideData.type, (XmlOptions) null);
        }

        public static CTCommonSlideData parse(String str, XmlOptions xmlOptions) {
            return (CTCommonSlideData) POIXMLTypeLoader.parse(str, CTCommonSlideData.type, xmlOptions);
        }

        public static CTCommonSlideData parse(URL url) {
            return (CTCommonSlideData) POIXMLTypeLoader.parse(url, CTCommonSlideData.type, (XmlOptions) null);
        }

        public static CTCommonSlideData parse(URL url, XmlOptions xmlOptions) {
            return (CTCommonSlideData) POIXMLTypeLoader.parse(url, CTCommonSlideData.type, xmlOptions);
        }

        public static CTCommonSlideData parse(XMLStreamReader xMLStreamReader) {
            return (CTCommonSlideData) POIXMLTypeLoader.parse(xMLStreamReader, CTCommonSlideData.type, (XmlOptions) null);
        }

        public static CTCommonSlideData parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTCommonSlideData) POIXMLTypeLoader.parse(xMLStreamReader, CTCommonSlideData.type, xmlOptions);
        }

        public static CTCommonSlideData parse(XMLInputStream xMLInputStream) {
            return (CTCommonSlideData) POIXMLTypeLoader.parse(xMLInputStream, CTCommonSlideData.type, (XmlOptions) null);
        }

        public static CTCommonSlideData parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTCommonSlideData) POIXMLTypeLoader.parse(xMLInputStream, CTCommonSlideData.type, xmlOptions);
        }

        public static CTCommonSlideData parse(Node node) {
            return (CTCommonSlideData) POIXMLTypeLoader.parse(node, CTCommonSlideData.type, (XmlOptions) null);
        }

        public static CTCommonSlideData parse(Node node, XmlOptions xmlOptions) {
            return (CTCommonSlideData) POIXMLTypeLoader.parse(node, CTCommonSlideData.type, xmlOptions);
        }
    }

    CTBackground addNewBg();

    CTControlList addNewControls();

    CTCustomerDataList addNewCustDataLst();

    CTExtensionList addNewExtLst();

    CTGroupShape addNewSpTree();

    CTBackground getBg();

    CTControlList getControls();

    CTCustomerDataList getCustDataLst();

    CTExtensionList getExtLst();

    String getName();

    CTGroupShape getSpTree();

    boolean isSetBg();

    boolean isSetControls();

    boolean isSetCustDataLst();

    boolean isSetExtLst();

    boolean isSetName();

    void setBg(CTBackground cTBackground);

    void setControls(CTControlList cTControlList);

    void setCustDataLst(CTCustomerDataList cTCustomerDataList);

    void setExtLst(CTExtensionList cTExtensionList);

    void setName(String str);

    void setSpTree(CTGroupShape cTGroupShape);

    void unsetBg();

    void unsetControls();

    void unsetCustDataLst();

    void unsetExtLst();

    void unsetName();

    XmlString xgetName();

    void xsetName(XmlString xmlString);
}
