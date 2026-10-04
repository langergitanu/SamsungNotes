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
import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndLength;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndType;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndWidth;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTLineEndProperties extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTLineEndProperties.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctlineendproperties8acbtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTLineEndProperties newInstance() {
            return (CTLineEndProperties) POIXMLTypeLoader.newInstance(CTLineEndProperties.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLineEndProperties.type, null);
        }

        public static CTLineEndProperties parse(File file) {
            return (CTLineEndProperties) POIXMLTypeLoader.parse(file, CTLineEndProperties.type, (XmlOptions) null);
        }

        public static CTLineEndProperties newInstance(XmlOptions xmlOptions) {
            return (CTLineEndProperties) POIXMLTypeLoader.newInstance(CTLineEndProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLineEndProperties.type, xmlOptions);
        }

        public static CTLineEndProperties parse(File file, XmlOptions xmlOptions) {
            return (CTLineEndProperties) POIXMLTypeLoader.parse(file, CTLineEndProperties.type, xmlOptions);
        }

        public static CTLineEndProperties parse(InputStream inputStream) {
            return (CTLineEndProperties) POIXMLTypeLoader.parse(inputStream, CTLineEndProperties.type, (XmlOptions) null);
        }

        public static CTLineEndProperties parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTLineEndProperties) POIXMLTypeLoader.parse(inputStream, CTLineEndProperties.type, xmlOptions);
        }

        public static CTLineEndProperties parse(Reader reader) {
            return (CTLineEndProperties) POIXMLTypeLoader.parse(reader, CTLineEndProperties.type, (XmlOptions) null);
        }

        public static CTLineEndProperties parse(Reader reader, XmlOptions xmlOptions) {
            return (CTLineEndProperties) POIXMLTypeLoader.parse(reader, CTLineEndProperties.type, xmlOptions);
        }

        public static CTLineEndProperties parse(String str) {
            return (CTLineEndProperties) POIXMLTypeLoader.parse(str, CTLineEndProperties.type, (XmlOptions) null);
        }

        public static CTLineEndProperties parse(String str, XmlOptions xmlOptions) {
            return (CTLineEndProperties) POIXMLTypeLoader.parse(str, CTLineEndProperties.type, xmlOptions);
        }

        public static CTLineEndProperties parse(URL url) {
            return (CTLineEndProperties) POIXMLTypeLoader.parse(url, CTLineEndProperties.type, (XmlOptions) null);
        }

        public static CTLineEndProperties parse(URL url, XmlOptions xmlOptions) {
            return (CTLineEndProperties) POIXMLTypeLoader.parse(url, CTLineEndProperties.type, xmlOptions);
        }

        public static CTLineEndProperties parse(XMLStreamReader xMLStreamReader) {
            return (CTLineEndProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTLineEndProperties.type, (XmlOptions) null);
        }

        public static CTLineEndProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTLineEndProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTLineEndProperties.type, xmlOptions);
        }

        public static CTLineEndProperties parse(XMLInputStream xMLInputStream) {
            return (CTLineEndProperties) POIXMLTypeLoader.parse(xMLInputStream, CTLineEndProperties.type, (XmlOptions) null);
        }

        public static CTLineEndProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTLineEndProperties) POIXMLTypeLoader.parse(xMLInputStream, CTLineEndProperties.type, xmlOptions);
        }

        public static CTLineEndProperties parse(Node node) {
            return (CTLineEndProperties) POIXMLTypeLoader.parse(node, CTLineEndProperties.type, (XmlOptions) null);
        }

        public static CTLineEndProperties parse(Node node, XmlOptions xmlOptions) {
            return (CTLineEndProperties) POIXMLTypeLoader.parse(node, CTLineEndProperties.type, xmlOptions);
        }
    }

    STLineEndLength.Enum getLen();

    STLineEndType.Enum getType();

    STLineEndWidth.Enum getW();

    boolean isSetLen();

    boolean isSetType();

    boolean isSetW();

    void setLen(STLineEndLength.Enum r12);

    void setType(STLineEndType.Enum r12);

    void setW(STLineEndWidth.Enum r12);

    void unsetLen();

    void unsetType();

    void unsetW();

    STLineEndLength xgetLen();

    STLineEndType xgetType();

    STLineEndWidth xgetW();

    void xsetLen(STLineEndLength sTLineEndLength);

    void xsetType(STLineEndType sTLineEndType);

    void xsetW(STLineEndWidth sTLineEndWidth);
}
