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
public interface CTTextTabStop extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTextTabStop.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttexttabstopb57btype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextTabStop newInstance() {
            return (CTTextTabStop) POIXMLTypeLoader.newInstance(CTTextTabStop.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextTabStop.type, null);
        }

        public static CTTextTabStop parse(File file) {
            return (CTTextTabStop) POIXMLTypeLoader.parse(file, CTTextTabStop.type, (XmlOptions) null);
        }

        public static CTTextTabStop newInstance(XmlOptions xmlOptions) {
            return (CTTextTabStop) POIXMLTypeLoader.newInstance(CTTextTabStop.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextTabStop.type, xmlOptions);
        }

        public static CTTextTabStop parse(File file, XmlOptions xmlOptions) {
            return (CTTextTabStop) POIXMLTypeLoader.parse(file, CTTextTabStop.type, xmlOptions);
        }

        public static CTTextTabStop parse(InputStream inputStream) {
            return (CTTextTabStop) POIXMLTypeLoader.parse(inputStream, CTTextTabStop.type, (XmlOptions) null);
        }

        public static CTTextTabStop parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTextTabStop) POIXMLTypeLoader.parse(inputStream, CTTextTabStop.type, xmlOptions);
        }

        public static CTTextTabStop parse(Reader reader) {
            return (CTTextTabStop) POIXMLTypeLoader.parse(reader, CTTextTabStop.type, (XmlOptions) null);
        }

        public static CTTextTabStop parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTextTabStop) POIXMLTypeLoader.parse(reader, CTTextTabStop.type, xmlOptions);
        }

        public static CTTextTabStop parse(String str) {
            return (CTTextTabStop) POIXMLTypeLoader.parse(str, CTTextTabStop.type, (XmlOptions) null);
        }

        public static CTTextTabStop parse(String str, XmlOptions xmlOptions) {
            return (CTTextTabStop) POIXMLTypeLoader.parse(str, CTTextTabStop.type, xmlOptions);
        }

        public static CTTextTabStop parse(URL url) {
            return (CTTextTabStop) POIXMLTypeLoader.parse(url, CTTextTabStop.type, (XmlOptions) null);
        }

        public static CTTextTabStop parse(URL url, XmlOptions xmlOptions) {
            return (CTTextTabStop) POIXMLTypeLoader.parse(url, CTTextTabStop.type, xmlOptions);
        }

        public static CTTextTabStop parse(XMLStreamReader xMLStreamReader) {
            return (CTTextTabStop) POIXMLTypeLoader.parse(xMLStreamReader, CTTextTabStop.type, (XmlOptions) null);
        }

        public static CTTextTabStop parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTextTabStop) POIXMLTypeLoader.parse(xMLStreamReader, CTTextTabStop.type, xmlOptions);
        }

        public static CTTextTabStop parse(XMLInputStream xMLInputStream) {
            return (CTTextTabStop) POIXMLTypeLoader.parse(xMLInputStream, CTTextTabStop.type, (XmlOptions) null);
        }

        public static CTTextTabStop parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTextTabStop) POIXMLTypeLoader.parse(xMLInputStream, CTTextTabStop.type, xmlOptions);
        }

        public static CTTextTabStop parse(Node node) {
            return (CTTextTabStop) POIXMLTypeLoader.parse(node, CTTextTabStop.type, (XmlOptions) null);
        }

        public static CTTextTabStop parse(Node node, XmlOptions xmlOptions) {
            return (CTTextTabStop) POIXMLTypeLoader.parse(node, CTTextTabStop.type, xmlOptions);
        }
    }

    STTextTabAlignType$Enum getAlgn();

    int getPos();

    boolean isSetAlgn();

    boolean isSetPos();

    void setAlgn(STTextTabAlignType$Enum sTTextTabAlignType$Enum);

    void setPos(int i);

    void unsetAlgn();

    void unsetPos();

    STTextTabAlignType xgetAlgn();

    STCoordinate32 xgetPos();

    void xsetAlgn(STTextTabAlignType sTTextTabAlignType);

    void xsetPos(STCoordinate32 sTCoordinate32);
}
