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
public interface CTTextParagraph extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTextParagraph.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttextparagraphcaf2type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextParagraph newInstance() {
            return (CTTextParagraph) POIXMLTypeLoader.newInstance(CTTextParagraph.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextParagraph.type, null);
        }

        public static CTTextParagraph parse(File file) {
            return (CTTextParagraph) POIXMLTypeLoader.parse(file, CTTextParagraph.type, (XmlOptions) null);
        }

        public static CTTextParagraph newInstance(XmlOptions xmlOptions) {
            return (CTTextParagraph) POIXMLTypeLoader.newInstance(CTTextParagraph.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextParagraph.type, xmlOptions);
        }

        public static CTTextParagraph parse(File file, XmlOptions xmlOptions) {
            return (CTTextParagraph) POIXMLTypeLoader.parse(file, CTTextParagraph.type, xmlOptions);
        }

        public static CTTextParagraph parse(InputStream inputStream) {
            return (CTTextParagraph) POIXMLTypeLoader.parse(inputStream, CTTextParagraph.type, (XmlOptions) null);
        }

        public static CTTextParagraph parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTextParagraph) POIXMLTypeLoader.parse(inputStream, CTTextParagraph.type, xmlOptions);
        }

        public static CTTextParagraph parse(Reader reader) {
            return (CTTextParagraph) POIXMLTypeLoader.parse(reader, CTTextParagraph.type, (XmlOptions) null);
        }

        public static CTTextParagraph parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTextParagraph) POIXMLTypeLoader.parse(reader, CTTextParagraph.type, xmlOptions);
        }

        public static CTTextParagraph parse(String str) {
            return (CTTextParagraph) POIXMLTypeLoader.parse(str, CTTextParagraph.type, (XmlOptions) null);
        }

        public static CTTextParagraph parse(String str, XmlOptions xmlOptions) {
            return (CTTextParagraph) POIXMLTypeLoader.parse(str, CTTextParagraph.type, xmlOptions);
        }

        public static CTTextParagraph parse(URL url) {
            return (CTTextParagraph) POIXMLTypeLoader.parse(url, CTTextParagraph.type, (XmlOptions) null);
        }

        public static CTTextParagraph parse(URL url, XmlOptions xmlOptions) {
            return (CTTextParagraph) POIXMLTypeLoader.parse(url, CTTextParagraph.type, xmlOptions);
        }

        public static CTTextParagraph parse(XMLStreamReader xMLStreamReader) {
            return (CTTextParagraph) POIXMLTypeLoader.parse(xMLStreamReader, CTTextParagraph.type, (XmlOptions) null);
        }

        public static CTTextParagraph parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTextParagraph) POIXMLTypeLoader.parse(xMLStreamReader, CTTextParagraph.type, xmlOptions);
        }

        public static CTTextParagraph parse(XMLInputStream xMLInputStream) {
            return (CTTextParagraph) POIXMLTypeLoader.parse(xMLInputStream, CTTextParagraph.type, (XmlOptions) null);
        }

        public static CTTextParagraph parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTextParagraph) POIXMLTypeLoader.parse(xMLInputStream, CTTextParagraph.type, xmlOptions);
        }

        public static CTTextParagraph parse(Node node) {
            return (CTTextParagraph) POIXMLTypeLoader.parse(node, CTTextParagraph.type, (XmlOptions) null);
        }

        public static CTTextParagraph parse(Node node, XmlOptions xmlOptions) {
            return (CTTextParagraph) POIXMLTypeLoader.parse(node, CTTextParagraph.type, xmlOptions);
        }
    }

    CTTextLineBreak addNewBr();

    CTTextCharacterProperties addNewEndParaRPr();

    CTTextField addNewFld();

    CTTextParagraphProperties addNewPPr();

    CTRegularTextRun addNewR();

    CTTextLineBreak getBrArray(int i);

    CTTextLineBreak[] getBrArray();

    List<CTTextLineBreak> getBrList();

    CTTextCharacterProperties getEndParaRPr();

    CTTextField getFldArray(int i);

    CTTextField[] getFldArray();

    List<CTTextField> getFldList();

    CTTextParagraphProperties getPPr();

    CTRegularTextRun getRArray(int i);

    CTRegularTextRun[] getRArray();

    List<CTRegularTextRun> getRList();

    CTTextLineBreak insertNewBr(int i);

    CTTextField insertNewFld(int i);

    CTRegularTextRun insertNewR(int i);

    boolean isSetEndParaRPr();

    boolean isSetPPr();

    void removeBr(int i);

    void removeFld(int i);

    void removeR(int i);

    void setBrArray(int i, CTTextLineBreak cTTextLineBreak);

    void setBrArray(CTTextLineBreak[] cTTextLineBreakArr);

    void setEndParaRPr(CTTextCharacterProperties cTTextCharacterProperties);

    void setFldArray(int i, CTTextField cTTextField);

    void setFldArray(CTTextField[] cTTextFieldArr);

    void setPPr(CTTextParagraphProperties cTTextParagraphProperties);

    void setRArray(int i, CTRegularTextRun cTRegularTextRun);

    void setRArray(CTRegularTextRun[] cTRegularTextRunArr);

    int sizeOfBrArray();

    int sizeOfFldArray();

    int sizeOfRArray();

    void unsetEndParaRPr();

    void unsetPPr();
}
