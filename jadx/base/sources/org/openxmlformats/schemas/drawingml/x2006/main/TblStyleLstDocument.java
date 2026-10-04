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
public interface TblStyleLstDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(TblStyleLstDocument.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "tblstylelst4997doctype");

    public static final class Factory {
        private Factory() {
        }

        public static TblStyleLstDocument newInstance() {
            return (TblStyleLstDocument) POIXMLTypeLoader.newInstance(TblStyleLstDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, TblStyleLstDocument.type, null);
        }

        public static TblStyleLstDocument parse(File file) {
            return (TblStyleLstDocument) POIXMLTypeLoader.parse(file, TblStyleLstDocument.type, (XmlOptions) null);
        }

        public static TblStyleLstDocument newInstance(XmlOptions xmlOptions) {
            return (TblStyleLstDocument) POIXMLTypeLoader.newInstance(TblStyleLstDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, TblStyleLstDocument.type, xmlOptions);
        }

        public static TblStyleLstDocument parse(File file, XmlOptions xmlOptions) {
            return (TblStyleLstDocument) POIXMLTypeLoader.parse(file, TblStyleLstDocument.type, xmlOptions);
        }

        public static TblStyleLstDocument parse(InputStream inputStream) {
            return (TblStyleLstDocument) POIXMLTypeLoader.parse(inputStream, TblStyleLstDocument.type, (XmlOptions) null);
        }

        public static TblStyleLstDocument parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (TblStyleLstDocument) POIXMLTypeLoader.parse(inputStream, TblStyleLstDocument.type, xmlOptions);
        }

        public static TblStyleLstDocument parse(Reader reader) {
            return (TblStyleLstDocument) POIXMLTypeLoader.parse(reader, TblStyleLstDocument.type, (XmlOptions) null);
        }

        public static TblStyleLstDocument parse(Reader reader, XmlOptions xmlOptions) {
            return (TblStyleLstDocument) POIXMLTypeLoader.parse(reader, TblStyleLstDocument.type, xmlOptions);
        }

        public static TblStyleLstDocument parse(String str) {
            return (TblStyleLstDocument) POIXMLTypeLoader.parse(str, TblStyleLstDocument.type, (XmlOptions) null);
        }

        public static TblStyleLstDocument parse(String str, XmlOptions xmlOptions) {
            return (TblStyleLstDocument) POIXMLTypeLoader.parse(str, TblStyleLstDocument.type, xmlOptions);
        }

        public static TblStyleLstDocument parse(URL url) {
            return (TblStyleLstDocument) POIXMLTypeLoader.parse(url, TblStyleLstDocument.type, (XmlOptions) null);
        }

        public static TblStyleLstDocument parse(URL url, XmlOptions xmlOptions) {
            return (TblStyleLstDocument) POIXMLTypeLoader.parse(url, TblStyleLstDocument.type, xmlOptions);
        }

        public static TblStyleLstDocument parse(XMLStreamReader xMLStreamReader) {
            return (TblStyleLstDocument) POIXMLTypeLoader.parse(xMLStreamReader, TblStyleLstDocument.type, (XmlOptions) null);
        }

        public static TblStyleLstDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (TblStyleLstDocument) POIXMLTypeLoader.parse(xMLStreamReader, TblStyleLstDocument.type, xmlOptions);
        }

        public static TblStyleLstDocument parse(XMLInputStream xMLInputStream) {
            return (TblStyleLstDocument) POIXMLTypeLoader.parse(xMLInputStream, TblStyleLstDocument.type, (XmlOptions) null);
        }

        public static TblStyleLstDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (TblStyleLstDocument) POIXMLTypeLoader.parse(xMLInputStream, TblStyleLstDocument.type, xmlOptions);
        }

        public static TblStyleLstDocument parse(Node node) {
            return (TblStyleLstDocument) POIXMLTypeLoader.parse(node, TblStyleLstDocument.type, (XmlOptions) null);
        }

        public static TblStyleLstDocument parse(Node node, XmlOptions xmlOptions) {
            return (TblStyleLstDocument) POIXMLTypeLoader.parse(node, TblStyleLstDocument.type, xmlOptions);
        }
    }

    CTTableStyleList addNewTblStyleLst();

    CTTableStyleList getTblStyleLst();

    void setTblStyleLst(CTTableStyleList cTTableStyleList);
}
