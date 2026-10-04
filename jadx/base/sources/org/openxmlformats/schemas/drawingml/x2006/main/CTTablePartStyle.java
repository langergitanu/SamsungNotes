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
public interface CTTablePartStyle extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTablePartStyle.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttablepartstylef22btype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTablePartStyle newInstance() {
            return (CTTablePartStyle) POIXMLTypeLoader.newInstance(CTTablePartStyle.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTablePartStyle.type, null);
        }

        public static CTTablePartStyle parse(File file) {
            return (CTTablePartStyle) POIXMLTypeLoader.parse(file, CTTablePartStyle.type, (XmlOptions) null);
        }

        public static CTTablePartStyle newInstance(XmlOptions xmlOptions) {
            return (CTTablePartStyle) POIXMLTypeLoader.newInstance(CTTablePartStyle.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTablePartStyle.type, xmlOptions);
        }

        public static CTTablePartStyle parse(File file, XmlOptions xmlOptions) {
            return (CTTablePartStyle) POIXMLTypeLoader.parse(file, CTTablePartStyle.type, xmlOptions);
        }

        public static CTTablePartStyle parse(InputStream inputStream) {
            return (CTTablePartStyle) POIXMLTypeLoader.parse(inputStream, CTTablePartStyle.type, (XmlOptions) null);
        }

        public static CTTablePartStyle parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTablePartStyle) POIXMLTypeLoader.parse(inputStream, CTTablePartStyle.type, xmlOptions);
        }

        public static CTTablePartStyle parse(Reader reader) {
            return (CTTablePartStyle) POIXMLTypeLoader.parse(reader, CTTablePartStyle.type, (XmlOptions) null);
        }

        public static CTTablePartStyle parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTablePartStyle) POIXMLTypeLoader.parse(reader, CTTablePartStyle.type, xmlOptions);
        }

        public static CTTablePartStyle parse(String str) {
            return (CTTablePartStyle) POIXMLTypeLoader.parse(str, CTTablePartStyle.type, (XmlOptions) null);
        }

        public static CTTablePartStyle parse(String str, XmlOptions xmlOptions) {
            return (CTTablePartStyle) POIXMLTypeLoader.parse(str, CTTablePartStyle.type, xmlOptions);
        }

        public static CTTablePartStyle parse(URL url) {
            return (CTTablePartStyle) POIXMLTypeLoader.parse(url, CTTablePartStyle.type, (XmlOptions) null);
        }

        public static CTTablePartStyle parse(URL url, XmlOptions xmlOptions) {
            return (CTTablePartStyle) POIXMLTypeLoader.parse(url, CTTablePartStyle.type, xmlOptions);
        }

        public static CTTablePartStyle parse(XMLStreamReader xMLStreamReader) {
            return (CTTablePartStyle) POIXMLTypeLoader.parse(xMLStreamReader, CTTablePartStyle.type, (XmlOptions) null);
        }

        public static CTTablePartStyle parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTablePartStyle) POIXMLTypeLoader.parse(xMLStreamReader, CTTablePartStyle.type, xmlOptions);
        }

        public static CTTablePartStyle parse(XMLInputStream xMLInputStream) {
            return (CTTablePartStyle) POIXMLTypeLoader.parse(xMLInputStream, CTTablePartStyle.type, (XmlOptions) null);
        }

        public static CTTablePartStyle parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTablePartStyle) POIXMLTypeLoader.parse(xMLInputStream, CTTablePartStyle.type, xmlOptions);
        }

        public static CTTablePartStyle parse(Node node) {
            return (CTTablePartStyle) POIXMLTypeLoader.parse(node, CTTablePartStyle.type, (XmlOptions) null);
        }

        public static CTTablePartStyle parse(Node node, XmlOptions xmlOptions) {
            return (CTTablePartStyle) POIXMLTypeLoader.parse(node, CTTablePartStyle.type, xmlOptions);
        }
    }

    CTTableStyleCellStyle addNewTcStyle();

    CTTableStyleTextStyle addNewTcTxStyle();

    CTTableStyleCellStyle getTcStyle();

    CTTableStyleTextStyle getTcTxStyle();

    boolean isSetTcStyle();

    boolean isSetTcTxStyle();

    void setTcStyle(CTTableStyleCellStyle cTTableStyleCellStyle);

    void setTcTxStyle(CTTableStyleTextStyle cTTableStyleTextStyle);

    void unsetTcStyle();

    void unsetTcTxStyle();
}
