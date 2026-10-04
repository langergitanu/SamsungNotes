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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTTextField extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTextField.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttextfield187etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextField newInstance() {
            return (CTTextField) POIXMLTypeLoader.newInstance(CTTextField.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextField.type, null);
        }

        public static CTTextField parse(File file) {
            return (CTTextField) POIXMLTypeLoader.parse(file, CTTextField.type, (XmlOptions) null);
        }

        public static CTTextField newInstance(XmlOptions xmlOptions) {
            return (CTTextField) POIXMLTypeLoader.newInstance(CTTextField.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextField.type, xmlOptions);
        }

        public static CTTextField parse(File file, XmlOptions xmlOptions) {
            return (CTTextField) POIXMLTypeLoader.parse(file, CTTextField.type, xmlOptions);
        }

        public static CTTextField parse(InputStream inputStream) {
            return (CTTextField) POIXMLTypeLoader.parse(inputStream, CTTextField.type, (XmlOptions) null);
        }

        public static CTTextField parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTextField) POIXMLTypeLoader.parse(inputStream, CTTextField.type, xmlOptions);
        }

        public static CTTextField parse(Reader reader) {
            return (CTTextField) POIXMLTypeLoader.parse(reader, CTTextField.type, (XmlOptions) null);
        }

        public static CTTextField parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTextField) POIXMLTypeLoader.parse(reader, CTTextField.type, xmlOptions);
        }

        public static CTTextField parse(String str) {
            return (CTTextField) POIXMLTypeLoader.parse(str, CTTextField.type, (XmlOptions) null);
        }

        public static CTTextField parse(String str, XmlOptions xmlOptions) {
            return (CTTextField) POIXMLTypeLoader.parse(str, CTTextField.type, xmlOptions);
        }

        public static CTTextField parse(URL url) {
            return (CTTextField) POIXMLTypeLoader.parse(url, CTTextField.type, (XmlOptions) null);
        }

        public static CTTextField parse(URL url, XmlOptions xmlOptions) {
            return (CTTextField) POIXMLTypeLoader.parse(url, CTTextField.type, xmlOptions);
        }

        public static CTTextField parse(XMLStreamReader xMLStreamReader) {
            return (CTTextField) POIXMLTypeLoader.parse(xMLStreamReader, CTTextField.type, (XmlOptions) null);
        }

        public static CTTextField parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTextField) POIXMLTypeLoader.parse(xMLStreamReader, CTTextField.type, xmlOptions);
        }

        public static CTTextField parse(XMLInputStream xMLInputStream) {
            return (CTTextField) POIXMLTypeLoader.parse(xMLInputStream, CTTextField.type, (XmlOptions) null);
        }

        public static CTTextField parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTextField) POIXMLTypeLoader.parse(xMLInputStream, CTTextField.type, xmlOptions);
        }

        public static CTTextField parse(Node node) {
            return (CTTextField) POIXMLTypeLoader.parse(node, CTTextField.type, (XmlOptions) null);
        }

        public static CTTextField parse(Node node, XmlOptions xmlOptions) {
            return (CTTextField) POIXMLTypeLoader.parse(node, CTTextField.type, xmlOptions);
        }
    }

    CTTextParagraphProperties addNewPPr();

    CTTextCharacterProperties addNewRPr();

    String getId();

    CTTextParagraphProperties getPPr();

    CTTextCharacterProperties getRPr();

    String getT();

    String getType();

    boolean isSetPPr();

    boolean isSetRPr();

    boolean isSetT();

    boolean isSetType();

    void setId(String str);

    void setPPr(CTTextParagraphProperties cTTextParagraphProperties);

    void setRPr(CTTextCharacterProperties cTTextCharacterProperties);

    void setT(String str);

    void setType(String str);

    void unsetPPr();

    void unsetRPr();

    void unsetT();

    void unsetType();

    STGuid xgetId();

    XmlString xgetT();

    XmlString xgetType();

    void xsetId(STGuid sTGuid);

    void xsetT(XmlString xmlString);

    void xsetType(XmlString xmlString);
}
