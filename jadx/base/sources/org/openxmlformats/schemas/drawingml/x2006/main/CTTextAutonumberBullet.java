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
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAutonumberScheme;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTTextAutonumberBullet extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTextAutonumberBullet.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttextautonumberbulletd602type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextAutonumberBullet newInstance() {
            return (CTTextAutonumberBullet) POIXMLTypeLoader.newInstance(CTTextAutonumberBullet.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextAutonumberBullet.type, null);
        }

        public static CTTextAutonumberBullet parse(File file) {
            return (CTTextAutonumberBullet) POIXMLTypeLoader.parse(file, CTTextAutonumberBullet.type, (XmlOptions) null);
        }

        public static CTTextAutonumberBullet newInstance(XmlOptions xmlOptions) {
            return (CTTextAutonumberBullet) POIXMLTypeLoader.newInstance(CTTextAutonumberBullet.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextAutonumberBullet.type, xmlOptions);
        }

        public static CTTextAutonumberBullet parse(File file, XmlOptions xmlOptions) {
            return (CTTextAutonumberBullet) POIXMLTypeLoader.parse(file, CTTextAutonumberBullet.type, xmlOptions);
        }

        public static CTTextAutonumberBullet parse(InputStream inputStream) {
            return (CTTextAutonumberBullet) POIXMLTypeLoader.parse(inputStream, CTTextAutonumberBullet.type, (XmlOptions) null);
        }

        public static CTTextAutonumberBullet parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTextAutonumberBullet) POIXMLTypeLoader.parse(inputStream, CTTextAutonumberBullet.type, xmlOptions);
        }

        public static CTTextAutonumberBullet parse(Reader reader) {
            return (CTTextAutonumberBullet) POIXMLTypeLoader.parse(reader, CTTextAutonumberBullet.type, (XmlOptions) null);
        }

        public static CTTextAutonumberBullet parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTextAutonumberBullet) POIXMLTypeLoader.parse(reader, CTTextAutonumberBullet.type, xmlOptions);
        }

        public static CTTextAutonumberBullet parse(String str) {
            return (CTTextAutonumberBullet) POIXMLTypeLoader.parse(str, CTTextAutonumberBullet.type, (XmlOptions) null);
        }

        public static CTTextAutonumberBullet parse(String str, XmlOptions xmlOptions) {
            return (CTTextAutonumberBullet) POIXMLTypeLoader.parse(str, CTTextAutonumberBullet.type, xmlOptions);
        }

        public static CTTextAutonumberBullet parse(URL url) {
            return (CTTextAutonumberBullet) POIXMLTypeLoader.parse(url, CTTextAutonumberBullet.type, (XmlOptions) null);
        }

        public static CTTextAutonumberBullet parse(URL url, XmlOptions xmlOptions) {
            return (CTTextAutonumberBullet) POIXMLTypeLoader.parse(url, CTTextAutonumberBullet.type, xmlOptions);
        }

        public static CTTextAutonumberBullet parse(XMLStreamReader xMLStreamReader) {
            return (CTTextAutonumberBullet) POIXMLTypeLoader.parse(xMLStreamReader, CTTextAutonumberBullet.type, (XmlOptions) null);
        }

        public static CTTextAutonumberBullet parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTextAutonumberBullet) POIXMLTypeLoader.parse(xMLStreamReader, CTTextAutonumberBullet.type, xmlOptions);
        }

        public static CTTextAutonumberBullet parse(XMLInputStream xMLInputStream) {
            return (CTTextAutonumberBullet) POIXMLTypeLoader.parse(xMLInputStream, CTTextAutonumberBullet.type, (XmlOptions) null);
        }

        public static CTTextAutonumberBullet parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTextAutonumberBullet) POIXMLTypeLoader.parse(xMLInputStream, CTTextAutonumberBullet.type, xmlOptions);
        }

        public static CTTextAutonumberBullet parse(Node node) {
            return (CTTextAutonumberBullet) POIXMLTypeLoader.parse(node, CTTextAutonumberBullet.type, (XmlOptions) null);
        }

        public static CTTextAutonumberBullet parse(Node node, XmlOptions xmlOptions) {
            return (CTTextAutonumberBullet) POIXMLTypeLoader.parse(node, CTTextAutonumberBullet.type, xmlOptions);
        }
    }

    int getStartAt();

    STTextAutonumberScheme.Enum getType();

    boolean isSetStartAt();

    void setStartAt(int i);

    void setType(STTextAutonumberScheme.Enum r12);

    void unsetStartAt();

    STTextBulletStartAtNum xgetStartAt();

    STTextAutonumberScheme xgetType();

    void xsetStartAt(STTextBulletStartAtNum sTTextBulletStartAtNum);

    void xsetType(STTextAutonumberScheme sTTextAutonumberScheme);
}
