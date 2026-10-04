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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTNonVisualDrawingShapeProps extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTNonVisualDrawingShapeProps.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctnonvisualdrawingshapepropsf17btype");

    public static final class Factory {
        private Factory() {
        }

        public static CTNonVisualDrawingShapeProps newInstance() {
            return (CTNonVisualDrawingShapeProps) POIXMLTypeLoader.newInstance(CTNonVisualDrawingShapeProps.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNonVisualDrawingShapeProps.type, null);
        }

        public static CTNonVisualDrawingShapeProps parse(File file) {
            return (CTNonVisualDrawingShapeProps) POIXMLTypeLoader.parse(file, CTNonVisualDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualDrawingShapeProps newInstance(XmlOptions xmlOptions) {
            return (CTNonVisualDrawingShapeProps) POIXMLTypeLoader.newInstance(CTNonVisualDrawingShapeProps.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNonVisualDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualDrawingShapeProps parse(File file, XmlOptions xmlOptions) {
            return (CTNonVisualDrawingShapeProps) POIXMLTypeLoader.parse(file, CTNonVisualDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualDrawingShapeProps parse(InputStream inputStream) {
            return (CTNonVisualDrawingShapeProps) POIXMLTypeLoader.parse(inputStream, CTNonVisualDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualDrawingShapeProps parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTNonVisualDrawingShapeProps) POIXMLTypeLoader.parse(inputStream, CTNonVisualDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualDrawingShapeProps parse(Reader reader) {
            return (CTNonVisualDrawingShapeProps) POIXMLTypeLoader.parse(reader, CTNonVisualDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualDrawingShapeProps parse(Reader reader, XmlOptions xmlOptions) {
            return (CTNonVisualDrawingShapeProps) POIXMLTypeLoader.parse(reader, CTNonVisualDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualDrawingShapeProps parse(String str) {
            return (CTNonVisualDrawingShapeProps) POIXMLTypeLoader.parse(str, CTNonVisualDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualDrawingShapeProps parse(String str, XmlOptions xmlOptions) {
            return (CTNonVisualDrawingShapeProps) POIXMLTypeLoader.parse(str, CTNonVisualDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualDrawingShapeProps parse(URL url) {
            return (CTNonVisualDrawingShapeProps) POIXMLTypeLoader.parse(url, CTNonVisualDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualDrawingShapeProps parse(URL url, XmlOptions xmlOptions) {
            return (CTNonVisualDrawingShapeProps) POIXMLTypeLoader.parse(url, CTNonVisualDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualDrawingShapeProps parse(XMLStreamReader xMLStreamReader) {
            return (CTNonVisualDrawingShapeProps) POIXMLTypeLoader.parse(xMLStreamReader, CTNonVisualDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualDrawingShapeProps parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTNonVisualDrawingShapeProps) POIXMLTypeLoader.parse(xMLStreamReader, CTNonVisualDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualDrawingShapeProps parse(XMLInputStream xMLInputStream) {
            return (CTNonVisualDrawingShapeProps) POIXMLTypeLoader.parse(xMLInputStream, CTNonVisualDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualDrawingShapeProps parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTNonVisualDrawingShapeProps) POIXMLTypeLoader.parse(xMLInputStream, CTNonVisualDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualDrawingShapeProps parse(Node node) {
            return (CTNonVisualDrawingShapeProps) POIXMLTypeLoader.parse(node, CTNonVisualDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualDrawingShapeProps parse(Node node, XmlOptions xmlOptions) {
            return (CTNonVisualDrawingShapeProps) POIXMLTypeLoader.parse(node, CTNonVisualDrawingShapeProps.type, xmlOptions);
        }
    }

    CTOfficeArtExtensionList addNewExtLst();

    CTShapeLocking addNewSpLocks();

    CTOfficeArtExtensionList getExtLst();

    CTShapeLocking getSpLocks();

    boolean getTxBox();

    boolean isSetExtLst();

    boolean isSetSpLocks();

    boolean isSetTxBox();

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setSpLocks(CTShapeLocking cTShapeLocking);

    void setTxBox(boolean z);

    void unsetExtLst();

    void unsetSpLocks();

    void unsetTxBox();

    XmlBoolean xgetTxBox();

    void xsetTxBox(XmlBoolean xmlBoolean);
}
