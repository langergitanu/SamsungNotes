package org.openxmlformats.schemas.presentationml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTTLMediaNodeVideo extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTLMediaNodeVideo.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttlmedianodevideoe3f8type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTLMediaNodeVideo newInstance() {
            return (CTTLMediaNodeVideo) POIXMLTypeLoader.newInstance(CTTLMediaNodeVideo.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTLMediaNodeVideo.type, null);
        }

        public static CTTLMediaNodeVideo parse(File file) {
            return (CTTLMediaNodeVideo) POIXMLTypeLoader.parse(file, CTTLMediaNodeVideo.type, (XmlOptions) null);
        }

        public static CTTLMediaNodeVideo newInstance(XmlOptions xmlOptions) {
            return (CTTLMediaNodeVideo) POIXMLTypeLoader.newInstance(CTTLMediaNodeVideo.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTLMediaNodeVideo.type, xmlOptions);
        }

        public static CTTLMediaNodeVideo parse(File file, XmlOptions xmlOptions) {
            return (CTTLMediaNodeVideo) POIXMLTypeLoader.parse(file, CTTLMediaNodeVideo.type, xmlOptions);
        }

        public static CTTLMediaNodeVideo parse(InputStream inputStream) {
            return (CTTLMediaNodeVideo) POIXMLTypeLoader.parse(inputStream, CTTLMediaNodeVideo.type, (XmlOptions) null);
        }

        public static CTTLMediaNodeVideo parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTLMediaNodeVideo) POIXMLTypeLoader.parse(inputStream, CTTLMediaNodeVideo.type, xmlOptions);
        }

        public static CTTLMediaNodeVideo parse(Reader reader) {
            return (CTTLMediaNodeVideo) POIXMLTypeLoader.parse(reader, CTTLMediaNodeVideo.type, (XmlOptions) null);
        }

        public static CTTLMediaNodeVideo parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTLMediaNodeVideo) POIXMLTypeLoader.parse(reader, CTTLMediaNodeVideo.type, xmlOptions);
        }

        public static CTTLMediaNodeVideo parse(String str) {
            return (CTTLMediaNodeVideo) POIXMLTypeLoader.parse(str, CTTLMediaNodeVideo.type, (XmlOptions) null);
        }

        public static CTTLMediaNodeVideo parse(String str, XmlOptions xmlOptions) {
            return (CTTLMediaNodeVideo) POIXMLTypeLoader.parse(str, CTTLMediaNodeVideo.type, xmlOptions);
        }

        public static CTTLMediaNodeVideo parse(URL url) {
            return (CTTLMediaNodeVideo) POIXMLTypeLoader.parse(url, CTTLMediaNodeVideo.type, (XmlOptions) null);
        }

        public static CTTLMediaNodeVideo parse(URL url, XmlOptions xmlOptions) {
            return (CTTLMediaNodeVideo) POIXMLTypeLoader.parse(url, CTTLMediaNodeVideo.type, xmlOptions);
        }

        public static CTTLMediaNodeVideo parse(XMLStreamReader xMLStreamReader) {
            return (CTTLMediaNodeVideo) POIXMLTypeLoader.parse(xMLStreamReader, CTTLMediaNodeVideo.type, (XmlOptions) null);
        }

        public static CTTLMediaNodeVideo parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTLMediaNodeVideo) POIXMLTypeLoader.parse(xMLStreamReader, CTTLMediaNodeVideo.type, xmlOptions);
        }

        public static CTTLMediaNodeVideo parse(XMLInputStream xMLInputStream) {
            return (CTTLMediaNodeVideo) POIXMLTypeLoader.parse(xMLInputStream, CTTLMediaNodeVideo.type, (XmlOptions) null);
        }

        public static CTTLMediaNodeVideo parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTLMediaNodeVideo) POIXMLTypeLoader.parse(xMLInputStream, CTTLMediaNodeVideo.type, xmlOptions);
        }

        public static CTTLMediaNodeVideo parse(Node node) {
            return (CTTLMediaNodeVideo) POIXMLTypeLoader.parse(node, CTTLMediaNodeVideo.type, (XmlOptions) null);
        }

        public static CTTLMediaNodeVideo parse(Node node, XmlOptions xmlOptions) {
            return (CTTLMediaNodeVideo) POIXMLTypeLoader.parse(node, CTTLMediaNodeVideo.type, xmlOptions);
        }
    }

    CTTLCommonMediaNodeData addNewCMediaNode();

    CTTLCommonMediaNodeData getCMediaNode();

    boolean getFullScrn();

    boolean isSetFullScrn();

    void setCMediaNode(CTTLCommonMediaNodeData cTTLCommonMediaNodeData);

    void setFullScrn(boolean z);

    void unsetFullScrn();

    XmlBoolean xgetFullScrn();

    void xsetFullScrn(XmlBoolean xmlBoolean);
}
