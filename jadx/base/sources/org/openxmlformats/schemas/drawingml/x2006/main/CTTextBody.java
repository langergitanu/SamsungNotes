package org.openxmlformats.schemas.drawingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTTextBody extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTextBody.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttextbodya3catype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextBody newInstance() {
            return (CTTextBody) POIXMLTypeLoader.newInstance(CTTextBody.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextBody.type, null);
        }

        public static CTTextBody parse(File file) {
            return (CTTextBody) POIXMLTypeLoader.parse(file, CTTextBody.type, (XmlOptions) null);
        }

        public static CTTextBody newInstance(XmlOptions xmlOptions) {
            return (CTTextBody) POIXMLTypeLoader.newInstance(CTTextBody.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextBody.type, xmlOptions);
        }

        public static CTTextBody parse(File file, XmlOptions xmlOptions) {
            return (CTTextBody) POIXMLTypeLoader.parse(file, CTTextBody.type, xmlOptions);
        }

        public static CTTextBody parse(InputStream inputStream) {
            return (CTTextBody) POIXMLTypeLoader.parse(inputStream, CTTextBody.type, (XmlOptions) null);
        }

        public static CTTextBody parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTextBody) POIXMLTypeLoader.parse(inputStream, CTTextBody.type, xmlOptions);
        }

        public static CTTextBody parse(Reader reader) {
            return (CTTextBody) POIXMLTypeLoader.parse(reader, CTTextBody.type, (XmlOptions) null);
        }

        public static CTTextBody parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTextBody) POIXMLTypeLoader.parse(reader, CTTextBody.type, xmlOptions);
        }

        public static CTTextBody parse(String str) {
            return (CTTextBody) POIXMLTypeLoader.parse(str, CTTextBody.type, (XmlOptions) null);
        }

        public static CTTextBody parse(String str, XmlOptions xmlOptions) {
            return (CTTextBody) POIXMLTypeLoader.parse(str, CTTextBody.type, xmlOptions);
        }

        public static CTTextBody parse(URL url) {
            return (CTTextBody) POIXMLTypeLoader.parse(url, CTTextBody.type, (XmlOptions) null);
        }

        public static CTTextBody parse(URL url, XmlOptions xmlOptions) {
            return (CTTextBody) POIXMLTypeLoader.parse(url, CTTextBody.type, xmlOptions);
        }

        public static CTTextBody parse(XMLStreamReader xMLStreamReader) {
            return (CTTextBody) POIXMLTypeLoader.parse(xMLStreamReader, CTTextBody.type, (XmlOptions) null);
        }

        public static CTTextBody parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTextBody) POIXMLTypeLoader.parse(xMLStreamReader, CTTextBody.type, xmlOptions);
        }

        public static CTTextBody parse(XMLInputStream xMLInputStream) {
            return (CTTextBody) POIXMLTypeLoader.parse(xMLInputStream, CTTextBody.type, (XmlOptions) null);
        }

        public static CTTextBody parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTextBody) POIXMLTypeLoader.parse(xMLInputStream, CTTextBody.type, xmlOptions);
        }

        public static CTTextBody parse(Node node) {
            return (CTTextBody) POIXMLTypeLoader.parse(node, CTTextBody.type, (XmlOptions) null);
        }

        public static CTTextBody parse(Node node, XmlOptions xmlOptions) {
            return (CTTextBody) POIXMLTypeLoader.parse(node, CTTextBody.type, xmlOptions);
        }
    }

    CTTextBodyProperties addNewBodyPr();

    CTTextListStyle addNewLstStyle();

    CTTextParagraph addNewP();

    CTTextBodyProperties getBodyPr();

    CTTextListStyle getLstStyle();

    CTTextParagraph getPArray(int i);

    CTTextParagraph[] getPArray();

    List<CTTextParagraph> getPList();

    CTTextParagraph insertNewP(int i);

    boolean isSetLstStyle();

    void removeP(int i);

    void setBodyPr(CTTextBodyProperties cTTextBodyProperties);

    void setLstStyle(CTTextListStyle cTTextListStyle);

    void setPArray(int i, CTTextParagraph cTTextParagraph);

    void setPArray(CTTextParagraph[] cTTextParagraphArr);

    int sizeOfPArray();

    void unsetLstStyle();
}
