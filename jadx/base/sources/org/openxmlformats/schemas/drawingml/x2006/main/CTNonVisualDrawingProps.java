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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTNonVisualDrawingProps extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTNonVisualDrawingProps.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctnonvisualdrawingprops8fb0type");

    public static final class Factory {
        private Factory() {
        }

        public static CTNonVisualDrawingProps newInstance() {
            return (CTNonVisualDrawingProps) POIXMLTypeLoader.newInstance(CTNonVisualDrawingProps.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNonVisualDrawingProps.type, null);
        }

        public static CTNonVisualDrawingProps parse(File file) {
            return (CTNonVisualDrawingProps) POIXMLTypeLoader.parse(file, CTNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTNonVisualDrawingProps newInstance(XmlOptions xmlOptions) {
            return (CTNonVisualDrawingProps) POIXMLTypeLoader.newInstance(CTNonVisualDrawingProps.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTNonVisualDrawingProps parse(File file, XmlOptions xmlOptions) {
            return (CTNonVisualDrawingProps) POIXMLTypeLoader.parse(file, CTNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTNonVisualDrawingProps parse(InputStream inputStream) {
            return (CTNonVisualDrawingProps) POIXMLTypeLoader.parse(inputStream, CTNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTNonVisualDrawingProps parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTNonVisualDrawingProps) POIXMLTypeLoader.parse(inputStream, CTNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTNonVisualDrawingProps parse(Reader reader) {
            return (CTNonVisualDrawingProps) POIXMLTypeLoader.parse(reader, CTNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTNonVisualDrawingProps parse(Reader reader, XmlOptions xmlOptions) {
            return (CTNonVisualDrawingProps) POIXMLTypeLoader.parse(reader, CTNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTNonVisualDrawingProps parse(String str) {
            return (CTNonVisualDrawingProps) POIXMLTypeLoader.parse(str, CTNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTNonVisualDrawingProps parse(String str, XmlOptions xmlOptions) {
            return (CTNonVisualDrawingProps) POIXMLTypeLoader.parse(str, CTNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTNonVisualDrawingProps parse(URL url) {
            return (CTNonVisualDrawingProps) POIXMLTypeLoader.parse(url, CTNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTNonVisualDrawingProps parse(URL url, XmlOptions xmlOptions) {
            return (CTNonVisualDrawingProps) POIXMLTypeLoader.parse(url, CTNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTNonVisualDrawingProps parse(XMLStreamReader xMLStreamReader) {
            return (CTNonVisualDrawingProps) POIXMLTypeLoader.parse(xMLStreamReader, CTNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTNonVisualDrawingProps parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTNonVisualDrawingProps) POIXMLTypeLoader.parse(xMLStreamReader, CTNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTNonVisualDrawingProps parse(XMLInputStream xMLInputStream) {
            return (CTNonVisualDrawingProps) POIXMLTypeLoader.parse(xMLInputStream, CTNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTNonVisualDrawingProps parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTNonVisualDrawingProps) POIXMLTypeLoader.parse(xMLInputStream, CTNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTNonVisualDrawingProps parse(Node node) {
            return (CTNonVisualDrawingProps) POIXMLTypeLoader.parse(node, CTNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTNonVisualDrawingProps parse(Node node, XmlOptions xmlOptions) {
            return (CTNonVisualDrawingProps) POIXMLTypeLoader.parse(node, CTNonVisualDrawingProps.type, xmlOptions);
        }
    }

    CTOfficeArtExtensionList addNewExtLst();

    CTHyperlink addNewHlinkClick();

    CTHyperlink addNewHlinkHover();

    String getDescr();

    CTOfficeArtExtensionList getExtLst();

    boolean getHidden();

    CTHyperlink getHlinkClick();

    CTHyperlink getHlinkHover();

    long getId();

    String getName();

    boolean isSetDescr();

    boolean isSetExtLst();

    boolean isSetHidden();

    boolean isSetHlinkClick();

    boolean isSetHlinkHover();

    void setDescr(String str);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setHidden(boolean z);

    void setHlinkClick(CTHyperlink cTHyperlink);

    void setHlinkHover(CTHyperlink cTHyperlink);

    void setId(long j);

    void setName(String str);

    void unsetDescr();

    void unsetExtLst();

    void unsetHidden();

    void unsetHlinkClick();

    void unsetHlinkHover();

    XmlString xgetDescr();

    XmlBoolean xgetHidden();

    STDrawingElementId xgetId();

    XmlString xgetName();

    void xsetDescr(XmlString xmlString);

    void xsetHidden(XmlBoolean xmlBoolean);

    void xsetId(STDrawingElementId sTDrawingElementId);

    void xsetName(XmlString xmlString);
}
