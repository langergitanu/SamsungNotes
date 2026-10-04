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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTSlideTiming extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTSlideTiming.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctslidetiming4214type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSlideTiming newInstance() {
            return (CTSlideTiming) POIXMLTypeLoader.newInstance(CTSlideTiming.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSlideTiming.type, null);
        }

        public static CTSlideTiming parse(File file) {
            return (CTSlideTiming) POIXMLTypeLoader.parse(file, CTSlideTiming.type, (XmlOptions) null);
        }

        public static CTSlideTiming newInstance(XmlOptions xmlOptions) {
            return (CTSlideTiming) POIXMLTypeLoader.newInstance(CTSlideTiming.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSlideTiming.type, xmlOptions);
        }

        public static CTSlideTiming parse(File file, XmlOptions xmlOptions) {
            return (CTSlideTiming) POIXMLTypeLoader.parse(file, CTSlideTiming.type, xmlOptions);
        }

        public static CTSlideTiming parse(InputStream inputStream) {
            return (CTSlideTiming) POIXMLTypeLoader.parse(inputStream, CTSlideTiming.type, (XmlOptions) null);
        }

        public static CTSlideTiming parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTSlideTiming) POIXMLTypeLoader.parse(inputStream, CTSlideTiming.type, xmlOptions);
        }

        public static CTSlideTiming parse(Reader reader) {
            return (CTSlideTiming) POIXMLTypeLoader.parse(reader, CTSlideTiming.type, (XmlOptions) null);
        }

        public static CTSlideTiming parse(Reader reader, XmlOptions xmlOptions) {
            return (CTSlideTiming) POIXMLTypeLoader.parse(reader, CTSlideTiming.type, xmlOptions);
        }

        public static CTSlideTiming parse(String str) {
            return (CTSlideTiming) POIXMLTypeLoader.parse(str, CTSlideTiming.type, (XmlOptions) null);
        }

        public static CTSlideTiming parse(String str, XmlOptions xmlOptions) {
            return (CTSlideTiming) POIXMLTypeLoader.parse(str, CTSlideTiming.type, xmlOptions);
        }

        public static CTSlideTiming parse(URL url) {
            return (CTSlideTiming) POIXMLTypeLoader.parse(url, CTSlideTiming.type, (XmlOptions) null);
        }

        public static CTSlideTiming parse(URL url, XmlOptions xmlOptions) {
            return (CTSlideTiming) POIXMLTypeLoader.parse(url, CTSlideTiming.type, xmlOptions);
        }

        public static CTSlideTiming parse(XMLStreamReader xMLStreamReader) {
            return (CTSlideTiming) POIXMLTypeLoader.parse(xMLStreamReader, CTSlideTiming.type, (XmlOptions) null);
        }

        public static CTSlideTiming parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTSlideTiming) POIXMLTypeLoader.parse(xMLStreamReader, CTSlideTiming.type, xmlOptions);
        }

        public static CTSlideTiming parse(XMLInputStream xMLInputStream) {
            return (CTSlideTiming) POIXMLTypeLoader.parse(xMLInputStream, CTSlideTiming.type, (XmlOptions) null);
        }

        public static CTSlideTiming parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTSlideTiming) POIXMLTypeLoader.parse(xMLInputStream, CTSlideTiming.type, xmlOptions);
        }

        public static CTSlideTiming parse(Node node) {
            return (CTSlideTiming) POIXMLTypeLoader.parse(node, CTSlideTiming.type, (XmlOptions) null);
        }

        public static CTSlideTiming parse(Node node, XmlOptions xmlOptions) {
            return (CTSlideTiming) POIXMLTypeLoader.parse(node, CTSlideTiming.type, xmlOptions);
        }
    }

    CTBuildList addNewBldLst();

    CTExtensionListModify addNewExtLst();

    CTTimeNodeList addNewTnLst();

    CTBuildList getBldLst();

    CTExtensionListModify getExtLst();

    CTTimeNodeList getTnLst();

    boolean isSetBldLst();

    boolean isSetExtLst();

    boolean isSetTnLst();

    void setBldLst(CTBuildList cTBuildList);

    void setExtLst(CTExtensionListModify cTExtensionListModify);

    void setTnLst(CTTimeNodeList cTTimeNodeList);

    void unsetBldLst();

    void unsetExtLst();

    void unsetTnLst();
}
