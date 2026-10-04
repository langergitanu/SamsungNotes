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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTConnection extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTConnection.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctconnection7fb9type");

    public static final class Factory {
        private Factory() {
        }

        public static CTConnection newInstance() {
            return (CTConnection) POIXMLTypeLoader.newInstance(CTConnection.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTConnection.type, null);
        }

        public static CTConnection parse(File file) {
            return (CTConnection) POIXMLTypeLoader.parse(file, CTConnection.type, (XmlOptions) null);
        }

        public static CTConnection newInstance(XmlOptions xmlOptions) {
            return (CTConnection) POIXMLTypeLoader.newInstance(CTConnection.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTConnection.type, xmlOptions);
        }

        public static CTConnection parse(File file, XmlOptions xmlOptions) {
            return (CTConnection) POIXMLTypeLoader.parse(file, CTConnection.type, xmlOptions);
        }

        public static CTConnection parse(InputStream inputStream) {
            return (CTConnection) POIXMLTypeLoader.parse(inputStream, CTConnection.type, (XmlOptions) null);
        }

        public static CTConnection parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTConnection) POIXMLTypeLoader.parse(inputStream, CTConnection.type, xmlOptions);
        }

        public static CTConnection parse(Reader reader) {
            return (CTConnection) POIXMLTypeLoader.parse(reader, CTConnection.type, (XmlOptions) null);
        }

        public static CTConnection parse(Reader reader, XmlOptions xmlOptions) {
            return (CTConnection) POIXMLTypeLoader.parse(reader, CTConnection.type, xmlOptions);
        }

        public static CTConnection parse(String str) {
            return (CTConnection) POIXMLTypeLoader.parse(str, CTConnection.type, (XmlOptions) null);
        }

        public static CTConnection parse(String str, XmlOptions xmlOptions) {
            return (CTConnection) POIXMLTypeLoader.parse(str, CTConnection.type, xmlOptions);
        }

        public static CTConnection parse(URL url) {
            return (CTConnection) POIXMLTypeLoader.parse(url, CTConnection.type, (XmlOptions) null);
        }

        public static CTConnection parse(URL url, XmlOptions xmlOptions) {
            return (CTConnection) POIXMLTypeLoader.parse(url, CTConnection.type, xmlOptions);
        }

        public static CTConnection parse(XMLStreamReader xMLStreamReader) {
            return (CTConnection) POIXMLTypeLoader.parse(xMLStreamReader, CTConnection.type, (XmlOptions) null);
        }

        public static CTConnection parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTConnection) POIXMLTypeLoader.parse(xMLStreamReader, CTConnection.type, xmlOptions);
        }

        public static CTConnection parse(XMLInputStream xMLInputStream) {
            return (CTConnection) POIXMLTypeLoader.parse(xMLInputStream, CTConnection.type, (XmlOptions) null);
        }

        public static CTConnection parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTConnection) POIXMLTypeLoader.parse(xMLInputStream, CTConnection.type, xmlOptions);
        }

        public static CTConnection parse(Node node) {
            return (CTConnection) POIXMLTypeLoader.parse(node, CTConnection.type, (XmlOptions) null);
        }

        public static CTConnection parse(Node node, XmlOptions xmlOptions) {
            return (CTConnection) POIXMLTypeLoader.parse(node, CTConnection.type, xmlOptions);
        }
    }

    long getId();

    long getIdx();

    void setId(long j);

    void setIdx(long j);

    STDrawingElementId xgetId();

    XmlUnsignedInt xgetIdx();

    void xsetId(STDrawingElementId sTDrawingElementId);

    void xsetIdx(XmlUnsignedInt xmlUnsignedInt);
}
