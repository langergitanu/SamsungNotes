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
public interface CTTLMediaNodeAudio extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTLMediaNodeAudio.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttlmedianodeaudio47bdtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTLMediaNodeAudio newInstance() {
            return (CTTLMediaNodeAudio) POIXMLTypeLoader.newInstance(CTTLMediaNodeAudio.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTLMediaNodeAudio.type, null);
        }

        public static CTTLMediaNodeAudio parse(File file) {
            return (CTTLMediaNodeAudio) POIXMLTypeLoader.parse(file, CTTLMediaNodeAudio.type, (XmlOptions) null);
        }

        public static CTTLMediaNodeAudio newInstance(XmlOptions xmlOptions) {
            return (CTTLMediaNodeAudio) POIXMLTypeLoader.newInstance(CTTLMediaNodeAudio.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTLMediaNodeAudio.type, xmlOptions);
        }

        public static CTTLMediaNodeAudio parse(File file, XmlOptions xmlOptions) {
            return (CTTLMediaNodeAudio) POIXMLTypeLoader.parse(file, CTTLMediaNodeAudio.type, xmlOptions);
        }

        public static CTTLMediaNodeAudio parse(InputStream inputStream) {
            return (CTTLMediaNodeAudio) POIXMLTypeLoader.parse(inputStream, CTTLMediaNodeAudio.type, (XmlOptions) null);
        }

        public static CTTLMediaNodeAudio parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTLMediaNodeAudio) POIXMLTypeLoader.parse(inputStream, CTTLMediaNodeAudio.type, xmlOptions);
        }

        public static CTTLMediaNodeAudio parse(Reader reader) {
            return (CTTLMediaNodeAudio) POIXMLTypeLoader.parse(reader, CTTLMediaNodeAudio.type, (XmlOptions) null);
        }

        public static CTTLMediaNodeAudio parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTLMediaNodeAudio) POIXMLTypeLoader.parse(reader, CTTLMediaNodeAudio.type, xmlOptions);
        }

        public static CTTLMediaNodeAudio parse(String str) {
            return (CTTLMediaNodeAudio) POIXMLTypeLoader.parse(str, CTTLMediaNodeAudio.type, (XmlOptions) null);
        }

        public static CTTLMediaNodeAudio parse(String str, XmlOptions xmlOptions) {
            return (CTTLMediaNodeAudio) POIXMLTypeLoader.parse(str, CTTLMediaNodeAudio.type, xmlOptions);
        }

        public static CTTLMediaNodeAudio parse(URL url) {
            return (CTTLMediaNodeAudio) POIXMLTypeLoader.parse(url, CTTLMediaNodeAudio.type, (XmlOptions) null);
        }

        public static CTTLMediaNodeAudio parse(URL url, XmlOptions xmlOptions) {
            return (CTTLMediaNodeAudio) POIXMLTypeLoader.parse(url, CTTLMediaNodeAudio.type, xmlOptions);
        }

        public static CTTLMediaNodeAudio parse(XMLStreamReader xMLStreamReader) {
            return (CTTLMediaNodeAudio) POIXMLTypeLoader.parse(xMLStreamReader, CTTLMediaNodeAudio.type, (XmlOptions) null);
        }

        public static CTTLMediaNodeAudio parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTLMediaNodeAudio) POIXMLTypeLoader.parse(xMLStreamReader, CTTLMediaNodeAudio.type, xmlOptions);
        }

        public static CTTLMediaNodeAudio parse(XMLInputStream xMLInputStream) {
            return (CTTLMediaNodeAudio) POIXMLTypeLoader.parse(xMLInputStream, CTTLMediaNodeAudio.type, (XmlOptions) null);
        }

        public static CTTLMediaNodeAudio parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTLMediaNodeAudio) POIXMLTypeLoader.parse(xMLInputStream, CTTLMediaNodeAudio.type, xmlOptions);
        }

        public static CTTLMediaNodeAudio parse(Node node) {
            return (CTTLMediaNodeAudio) POIXMLTypeLoader.parse(node, CTTLMediaNodeAudio.type, (XmlOptions) null);
        }

        public static CTTLMediaNodeAudio parse(Node node, XmlOptions xmlOptions) {
            return (CTTLMediaNodeAudio) POIXMLTypeLoader.parse(node, CTTLMediaNodeAudio.type, xmlOptions);
        }
    }

    CTTLCommonMediaNodeData addNewCMediaNode();

    CTTLCommonMediaNodeData getCMediaNode();

    boolean getIsNarration();

    boolean isSetIsNarration();

    void setCMediaNode(CTTLCommonMediaNodeData cTTLCommonMediaNodeData);

    void setIsNarration(boolean z);

    void unsetIsNarration();

    XmlBoolean xgetIsNarration();

    void xsetIsNarration(XmlBoolean xmlBoolean);
}
