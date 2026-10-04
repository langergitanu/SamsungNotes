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
public interface CTNonVisualPictureProperties extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTNonVisualPictureProperties.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctnonvisualpicturepropertiesee3ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTNonVisualPictureProperties newInstance() {
            return (CTNonVisualPictureProperties) POIXMLTypeLoader.newInstance(CTNonVisualPictureProperties.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNonVisualPictureProperties.type, null);
        }

        public static CTNonVisualPictureProperties parse(File file) {
            return (CTNonVisualPictureProperties) POIXMLTypeLoader.parse(file, CTNonVisualPictureProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualPictureProperties newInstance(XmlOptions xmlOptions) {
            return (CTNonVisualPictureProperties) POIXMLTypeLoader.newInstance(CTNonVisualPictureProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNonVisualPictureProperties.type, xmlOptions);
        }

        public static CTNonVisualPictureProperties parse(File file, XmlOptions xmlOptions) {
            return (CTNonVisualPictureProperties) POIXMLTypeLoader.parse(file, CTNonVisualPictureProperties.type, xmlOptions);
        }

        public static CTNonVisualPictureProperties parse(InputStream inputStream) {
            return (CTNonVisualPictureProperties) POIXMLTypeLoader.parse(inputStream, CTNonVisualPictureProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualPictureProperties parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTNonVisualPictureProperties) POIXMLTypeLoader.parse(inputStream, CTNonVisualPictureProperties.type, xmlOptions);
        }

        public static CTNonVisualPictureProperties parse(Reader reader) {
            return (CTNonVisualPictureProperties) POIXMLTypeLoader.parse(reader, CTNonVisualPictureProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualPictureProperties parse(Reader reader, XmlOptions xmlOptions) {
            return (CTNonVisualPictureProperties) POIXMLTypeLoader.parse(reader, CTNonVisualPictureProperties.type, xmlOptions);
        }

        public static CTNonVisualPictureProperties parse(String str) {
            return (CTNonVisualPictureProperties) POIXMLTypeLoader.parse(str, CTNonVisualPictureProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualPictureProperties parse(String str, XmlOptions xmlOptions) {
            return (CTNonVisualPictureProperties) POIXMLTypeLoader.parse(str, CTNonVisualPictureProperties.type, xmlOptions);
        }

        public static CTNonVisualPictureProperties parse(URL url) {
            return (CTNonVisualPictureProperties) POIXMLTypeLoader.parse(url, CTNonVisualPictureProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualPictureProperties parse(URL url, XmlOptions xmlOptions) {
            return (CTNonVisualPictureProperties) POIXMLTypeLoader.parse(url, CTNonVisualPictureProperties.type, xmlOptions);
        }

        public static CTNonVisualPictureProperties parse(XMLStreamReader xMLStreamReader) {
            return (CTNonVisualPictureProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTNonVisualPictureProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualPictureProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTNonVisualPictureProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTNonVisualPictureProperties.type, xmlOptions);
        }

        public static CTNonVisualPictureProperties parse(XMLInputStream xMLInputStream) {
            return (CTNonVisualPictureProperties) POIXMLTypeLoader.parse(xMLInputStream, CTNonVisualPictureProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualPictureProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTNonVisualPictureProperties) POIXMLTypeLoader.parse(xMLInputStream, CTNonVisualPictureProperties.type, xmlOptions);
        }

        public static CTNonVisualPictureProperties parse(Node node) {
            return (CTNonVisualPictureProperties) POIXMLTypeLoader.parse(node, CTNonVisualPictureProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualPictureProperties parse(Node node, XmlOptions xmlOptions) {
            return (CTNonVisualPictureProperties) POIXMLTypeLoader.parse(node, CTNonVisualPictureProperties.type, xmlOptions);
        }
    }

    CTOfficeArtExtensionList addNewExtLst();

    CTPictureLocking addNewPicLocks();

    CTOfficeArtExtensionList getExtLst();

    CTPictureLocking getPicLocks();

    boolean getPreferRelativeResize();

    boolean isSetExtLst();

    boolean isSetPicLocks();

    boolean isSetPreferRelativeResize();

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setPicLocks(CTPictureLocking cTPictureLocking);

    void setPreferRelativeResize(boolean z);

    void unsetExtLst();

    void unsetPicLocks();

    void unsetPreferRelativeResize();

    XmlBoolean xgetPreferRelativeResize();

    void xsetPreferRelativeResize(XmlBoolean xmlBoolean);
}
