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
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTSdtBlock extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTSdtBlock.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctsdtblock221etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTSdtBlock newInstance() {
            return (CTSdtBlock) POIXMLTypeLoader.newInstance(CTSdtBlock.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSdtBlock.type, null);
        }

        public static CTSdtBlock parse(File file) {
            return (CTSdtBlock) POIXMLTypeLoader.parse(file, CTSdtBlock.type, (XmlOptions) null);
        }

        public static CTSdtBlock newInstance(XmlOptions xmlOptions) {
            return (CTSdtBlock) POIXMLTypeLoader.newInstance(CTSdtBlock.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSdtBlock.type, xmlOptions);
        }

        public static CTSdtBlock parse(File file, XmlOptions xmlOptions) {
            return (CTSdtBlock) POIXMLTypeLoader.parse(file, CTSdtBlock.type, xmlOptions);
        }

        public static CTSdtBlock parse(InputStream inputStream) {
            return (CTSdtBlock) POIXMLTypeLoader.parse(inputStream, CTSdtBlock.type, (XmlOptions) null);
        }

        public static CTSdtBlock parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTSdtBlock) POIXMLTypeLoader.parse(inputStream, CTSdtBlock.type, xmlOptions);
        }

        public static CTSdtBlock parse(Reader reader) {
            return (CTSdtBlock) POIXMLTypeLoader.parse(reader, CTSdtBlock.type, (XmlOptions) null);
        }

        public static CTSdtBlock parse(Reader reader, XmlOptions xmlOptions) {
            return (CTSdtBlock) POIXMLTypeLoader.parse(reader, CTSdtBlock.type, xmlOptions);
        }

        public static CTSdtBlock parse(String str) {
            return (CTSdtBlock) POIXMLTypeLoader.parse(str, CTSdtBlock.type, (XmlOptions) null);
        }

        public static CTSdtBlock parse(String str, XmlOptions xmlOptions) {
            return (CTSdtBlock) POIXMLTypeLoader.parse(str, CTSdtBlock.type, xmlOptions);
        }

        public static CTSdtBlock parse(URL url) {
            return (CTSdtBlock) POIXMLTypeLoader.parse(url, CTSdtBlock.type, (XmlOptions) null);
        }

        public static CTSdtBlock parse(URL url, XmlOptions xmlOptions) {
            return (CTSdtBlock) POIXMLTypeLoader.parse(url, CTSdtBlock.type, xmlOptions);
        }

        public static CTSdtBlock parse(XMLStreamReader xMLStreamReader) {
            return (CTSdtBlock) POIXMLTypeLoader.parse(xMLStreamReader, CTSdtBlock.type, (XmlOptions) null);
        }

        public static CTSdtBlock parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTSdtBlock) POIXMLTypeLoader.parse(xMLStreamReader, CTSdtBlock.type, xmlOptions);
        }

        public static CTSdtBlock parse(XMLInputStream xMLInputStream) {
            return (CTSdtBlock) POIXMLTypeLoader.parse(xMLInputStream, CTSdtBlock.type, (XmlOptions) null);
        }

        public static CTSdtBlock parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTSdtBlock) POIXMLTypeLoader.parse(xMLInputStream, CTSdtBlock.type, xmlOptions);
        }

        public static CTSdtBlock parse(Node node) {
            return (CTSdtBlock) POIXMLTypeLoader.parse(node, CTSdtBlock.type, (XmlOptions) null);
        }

        public static CTSdtBlock parse(Node node, XmlOptions xmlOptions) {
            return (CTSdtBlock) POIXMLTypeLoader.parse(node, CTSdtBlock.type, xmlOptions);
        }
    }

    CTSdtContentBlock addNewSdtContent();

    CTSdtEndPr addNewSdtEndPr();

    CTSdtPr addNewSdtPr();

    CTSdtContentBlock getSdtContent();

    CTSdtEndPr getSdtEndPr();

    CTSdtPr getSdtPr();

    boolean isSetSdtContent();

    boolean isSetSdtEndPr();

    boolean isSetSdtPr();

    void setSdtContent(CTSdtContentBlock cTSdtContentBlock);

    void setSdtEndPr(CTSdtEndPr cTSdtEndPr);

    void setSdtPr(CTSdtPr cTSdtPr);

    void unsetSdtContent();

    void unsetSdtEndPr();

    void unsetSdtPr();
}
