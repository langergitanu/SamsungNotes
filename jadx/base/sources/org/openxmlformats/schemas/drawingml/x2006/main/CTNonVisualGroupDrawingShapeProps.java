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
public interface CTNonVisualGroupDrawingShapeProps extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTNonVisualGroupDrawingShapeProps.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctnonvisualgroupdrawingshapeprops610ctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTNonVisualGroupDrawingShapeProps newInstance() {
            return (CTNonVisualGroupDrawingShapeProps) POIXMLTypeLoader.newInstance(CTNonVisualGroupDrawingShapeProps.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNonVisualGroupDrawingShapeProps.type, null);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(File file) {
            return (CTNonVisualGroupDrawingShapeProps) POIXMLTypeLoader.parse(file, CTNonVisualGroupDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualGroupDrawingShapeProps newInstance(XmlOptions xmlOptions) {
            return (CTNonVisualGroupDrawingShapeProps) POIXMLTypeLoader.newInstance(CTNonVisualGroupDrawingShapeProps.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNonVisualGroupDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(File file, XmlOptions xmlOptions) {
            return (CTNonVisualGroupDrawingShapeProps) POIXMLTypeLoader.parse(file, CTNonVisualGroupDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(InputStream inputStream) {
            return (CTNonVisualGroupDrawingShapeProps) POIXMLTypeLoader.parse(inputStream, CTNonVisualGroupDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTNonVisualGroupDrawingShapeProps) POIXMLTypeLoader.parse(inputStream, CTNonVisualGroupDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(Reader reader) {
            return (CTNonVisualGroupDrawingShapeProps) POIXMLTypeLoader.parse(reader, CTNonVisualGroupDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(Reader reader, XmlOptions xmlOptions) {
            return (CTNonVisualGroupDrawingShapeProps) POIXMLTypeLoader.parse(reader, CTNonVisualGroupDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(String str) {
            return (CTNonVisualGroupDrawingShapeProps) POIXMLTypeLoader.parse(str, CTNonVisualGroupDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(String str, XmlOptions xmlOptions) {
            return (CTNonVisualGroupDrawingShapeProps) POIXMLTypeLoader.parse(str, CTNonVisualGroupDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(URL url) {
            return (CTNonVisualGroupDrawingShapeProps) POIXMLTypeLoader.parse(url, CTNonVisualGroupDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(URL url, XmlOptions xmlOptions) {
            return (CTNonVisualGroupDrawingShapeProps) POIXMLTypeLoader.parse(url, CTNonVisualGroupDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(XMLStreamReader xMLStreamReader) {
            return (CTNonVisualGroupDrawingShapeProps) POIXMLTypeLoader.parse(xMLStreamReader, CTNonVisualGroupDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTNonVisualGroupDrawingShapeProps) POIXMLTypeLoader.parse(xMLStreamReader, CTNonVisualGroupDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(XMLInputStream xMLInputStream) {
            return (CTNonVisualGroupDrawingShapeProps) POIXMLTypeLoader.parse(xMLInputStream, CTNonVisualGroupDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTNonVisualGroupDrawingShapeProps) POIXMLTypeLoader.parse(xMLInputStream, CTNonVisualGroupDrawingShapeProps.type, xmlOptions);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(Node node) {
            return (CTNonVisualGroupDrawingShapeProps) POIXMLTypeLoader.parse(node, CTNonVisualGroupDrawingShapeProps.type, (XmlOptions) null);
        }

        public static CTNonVisualGroupDrawingShapeProps parse(Node node, XmlOptions xmlOptions) {
            return (CTNonVisualGroupDrawingShapeProps) POIXMLTypeLoader.parse(node, CTNonVisualGroupDrawingShapeProps.type, xmlOptions);
        }
    }

    CTOfficeArtExtensionList addNewExtLst();

    CTGroupLocking addNewGrpSpLocks();

    CTOfficeArtExtensionList getExtLst();

    CTGroupLocking getGrpSpLocks();

    boolean isSetExtLst();

    boolean isSetGrpSpLocks();

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setGrpSpLocks(CTGroupLocking cTGroupLocking);

    void unsetExtLst();

    void unsetGrpSpLocks();
}
