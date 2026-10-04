package org.openxmlformats.schemas.drawingml.x2006.main;

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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTBlipFillProperties extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTBlipFillProperties.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctblipfillproperties0382type");

    public static final class Factory {
        private Factory() {
        }

        public static CTBlipFillProperties newInstance() {
            return (CTBlipFillProperties) POIXMLTypeLoader.newInstance(CTBlipFillProperties.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTBlipFillProperties.type, null);
        }

        public static CTBlipFillProperties parse(File file) {
            return (CTBlipFillProperties) POIXMLTypeLoader.parse(file, CTBlipFillProperties.type, (XmlOptions) null);
        }

        public static CTBlipFillProperties newInstance(XmlOptions xmlOptions) {
            return (CTBlipFillProperties) POIXMLTypeLoader.newInstance(CTBlipFillProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTBlipFillProperties.type, xmlOptions);
        }

        public static CTBlipFillProperties parse(File file, XmlOptions xmlOptions) {
            return (CTBlipFillProperties) POIXMLTypeLoader.parse(file, CTBlipFillProperties.type, xmlOptions);
        }

        public static CTBlipFillProperties parse(InputStream inputStream) {
            return (CTBlipFillProperties) POIXMLTypeLoader.parse(inputStream, CTBlipFillProperties.type, (XmlOptions) null);
        }

        public static CTBlipFillProperties parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTBlipFillProperties) POIXMLTypeLoader.parse(inputStream, CTBlipFillProperties.type, xmlOptions);
        }

        public static CTBlipFillProperties parse(Reader reader) {
            return (CTBlipFillProperties) POIXMLTypeLoader.parse(reader, CTBlipFillProperties.type, (XmlOptions) null);
        }

        public static CTBlipFillProperties parse(Reader reader, XmlOptions xmlOptions) {
            return (CTBlipFillProperties) POIXMLTypeLoader.parse(reader, CTBlipFillProperties.type, xmlOptions);
        }

        public static CTBlipFillProperties parse(String str) {
            return (CTBlipFillProperties) POIXMLTypeLoader.parse(str, CTBlipFillProperties.type, (XmlOptions) null);
        }

        public static CTBlipFillProperties parse(String str, XmlOptions xmlOptions) {
            return (CTBlipFillProperties) POIXMLTypeLoader.parse(str, CTBlipFillProperties.type, xmlOptions);
        }

        public static CTBlipFillProperties parse(URL url) {
            return (CTBlipFillProperties) POIXMLTypeLoader.parse(url, CTBlipFillProperties.type, (XmlOptions) null);
        }

        public static CTBlipFillProperties parse(URL url, XmlOptions xmlOptions) {
            return (CTBlipFillProperties) POIXMLTypeLoader.parse(url, CTBlipFillProperties.type, xmlOptions);
        }

        public static CTBlipFillProperties parse(XMLStreamReader xMLStreamReader) {
            return (CTBlipFillProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTBlipFillProperties.type, (XmlOptions) null);
        }

        public static CTBlipFillProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTBlipFillProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTBlipFillProperties.type, xmlOptions);
        }

        public static CTBlipFillProperties parse(XMLInputStream xMLInputStream) {
            return (CTBlipFillProperties) POIXMLTypeLoader.parse(xMLInputStream, CTBlipFillProperties.type, (XmlOptions) null);
        }

        public static CTBlipFillProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTBlipFillProperties) POIXMLTypeLoader.parse(xMLInputStream, CTBlipFillProperties.type, xmlOptions);
        }

        public static CTBlipFillProperties parse(Node node) {
            return (CTBlipFillProperties) POIXMLTypeLoader.parse(node, CTBlipFillProperties.type, (XmlOptions) null);
        }

        public static CTBlipFillProperties parse(Node node, XmlOptions xmlOptions) {
            return (CTBlipFillProperties) POIXMLTypeLoader.parse(node, CTBlipFillProperties.type, xmlOptions);
        }
    }

    CTBlip addNewBlip();

    CTRelativeRect addNewSrcRect();

    CTStretchInfoProperties addNewStretch();

    CTTileInfoProperties addNewTile();

    CTBlip getBlip();

    long getDpi();

    boolean getRotWithShape();

    CTRelativeRect getSrcRect();

    CTStretchInfoProperties getStretch();

    CTTileInfoProperties getTile();

    boolean isSetBlip();

    boolean isSetDpi();

    boolean isSetRotWithShape();

    boolean isSetSrcRect();

    boolean isSetStretch();

    boolean isSetTile();

    void setBlip(CTBlip cTBlip);

    void setDpi(long j);

    void setRotWithShape(boolean z);

    void setSrcRect(CTRelativeRect cTRelativeRect);

    void setStretch(CTStretchInfoProperties cTStretchInfoProperties);

    void setTile(CTTileInfoProperties cTTileInfoProperties);

    void unsetBlip();

    void unsetDpi();

    void unsetRotWithShape();

    void unsetSrcRect();

    void unsetStretch();

    void unsetTile();

    XmlUnsignedInt xgetDpi();

    XmlBoolean xgetRotWithShape();

    void xsetDpi(XmlUnsignedInt xmlUnsignedInt);

    void xsetRotWithShape(XmlBoolean xmlBoolean);
}
