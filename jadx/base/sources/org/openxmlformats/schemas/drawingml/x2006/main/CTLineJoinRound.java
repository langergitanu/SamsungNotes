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
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTLineJoinRound extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTLineJoinRound.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctlinejoinround7be1type");

    public static final class Factory {
        private Factory() {
        }

        public static CTLineJoinRound newInstance() {
            return (CTLineJoinRound) POIXMLTypeLoader.newInstance(CTLineJoinRound.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLineJoinRound.type, null);
        }

        public static CTLineJoinRound parse(File file) {
            return (CTLineJoinRound) POIXMLTypeLoader.parse(file, CTLineJoinRound.type, (XmlOptions) null);
        }

        public static CTLineJoinRound newInstance(XmlOptions xmlOptions) {
            return (CTLineJoinRound) POIXMLTypeLoader.newInstance(CTLineJoinRound.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLineJoinRound.type, xmlOptions);
        }

        public static CTLineJoinRound parse(File file, XmlOptions xmlOptions) {
            return (CTLineJoinRound) POIXMLTypeLoader.parse(file, CTLineJoinRound.type, xmlOptions);
        }

        public static CTLineJoinRound parse(InputStream inputStream) {
            return (CTLineJoinRound) POIXMLTypeLoader.parse(inputStream, CTLineJoinRound.type, (XmlOptions) null);
        }

        public static CTLineJoinRound parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTLineJoinRound) POIXMLTypeLoader.parse(inputStream, CTLineJoinRound.type, xmlOptions);
        }

        public static CTLineJoinRound parse(Reader reader) {
            return (CTLineJoinRound) POIXMLTypeLoader.parse(reader, CTLineJoinRound.type, (XmlOptions) null);
        }

        public static CTLineJoinRound parse(Reader reader, XmlOptions xmlOptions) {
            return (CTLineJoinRound) POIXMLTypeLoader.parse(reader, CTLineJoinRound.type, xmlOptions);
        }

        public static CTLineJoinRound parse(String str) {
            return (CTLineJoinRound) POIXMLTypeLoader.parse(str, CTLineJoinRound.type, (XmlOptions) null);
        }

        public static CTLineJoinRound parse(String str, XmlOptions xmlOptions) {
            return (CTLineJoinRound) POIXMLTypeLoader.parse(str, CTLineJoinRound.type, xmlOptions);
        }

        public static CTLineJoinRound parse(URL url) {
            return (CTLineJoinRound) POIXMLTypeLoader.parse(url, CTLineJoinRound.type, (XmlOptions) null);
        }

        public static CTLineJoinRound parse(URL url, XmlOptions xmlOptions) {
            return (CTLineJoinRound) POIXMLTypeLoader.parse(url, CTLineJoinRound.type, xmlOptions);
        }

        public static CTLineJoinRound parse(XMLStreamReader xMLStreamReader) {
            return (CTLineJoinRound) POIXMLTypeLoader.parse(xMLStreamReader, CTLineJoinRound.type, (XmlOptions) null);
        }

        public static CTLineJoinRound parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTLineJoinRound) POIXMLTypeLoader.parse(xMLStreamReader, CTLineJoinRound.type, xmlOptions);
        }

        public static CTLineJoinRound parse(XMLInputStream xMLInputStream) {
            return (CTLineJoinRound) POIXMLTypeLoader.parse(xMLInputStream, CTLineJoinRound.type, (XmlOptions) null);
        }

        public static CTLineJoinRound parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTLineJoinRound) POIXMLTypeLoader.parse(xMLInputStream, CTLineJoinRound.type, xmlOptions);
        }

        public static CTLineJoinRound parse(Node node) {
            return (CTLineJoinRound) POIXMLTypeLoader.parse(node, CTLineJoinRound.type, (XmlOptions) null);
        }

        public static CTLineJoinRound parse(Node node, XmlOptions xmlOptions) {
            return (CTLineJoinRound) POIXMLTypeLoader.parse(node, CTLineJoinRound.type, xmlOptions);
        }
    }
}
