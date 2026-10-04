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
public interface CTStyleMatrix extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTStyleMatrix.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctstylematrix1903type");

    public static final class Factory {
        private Factory() {
        }

        public static CTStyleMatrix newInstance() {
            return (CTStyleMatrix) POIXMLTypeLoader.newInstance(CTStyleMatrix.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTStyleMatrix.type, null);
        }

        public static CTStyleMatrix parse(File file) {
            return (CTStyleMatrix) POIXMLTypeLoader.parse(file, CTStyleMatrix.type, (XmlOptions) null);
        }

        public static CTStyleMatrix newInstance(XmlOptions xmlOptions) {
            return (CTStyleMatrix) POIXMLTypeLoader.newInstance(CTStyleMatrix.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTStyleMatrix.type, xmlOptions);
        }

        public static CTStyleMatrix parse(File file, XmlOptions xmlOptions) {
            return (CTStyleMatrix) POIXMLTypeLoader.parse(file, CTStyleMatrix.type, xmlOptions);
        }

        public static CTStyleMatrix parse(InputStream inputStream) {
            return (CTStyleMatrix) POIXMLTypeLoader.parse(inputStream, CTStyleMatrix.type, (XmlOptions) null);
        }

        public static CTStyleMatrix parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTStyleMatrix) POIXMLTypeLoader.parse(inputStream, CTStyleMatrix.type, xmlOptions);
        }

        public static CTStyleMatrix parse(Reader reader) {
            return (CTStyleMatrix) POIXMLTypeLoader.parse(reader, CTStyleMatrix.type, (XmlOptions) null);
        }

        public static CTStyleMatrix parse(Reader reader, XmlOptions xmlOptions) {
            return (CTStyleMatrix) POIXMLTypeLoader.parse(reader, CTStyleMatrix.type, xmlOptions);
        }

        public static CTStyleMatrix parse(String str) {
            return (CTStyleMatrix) POIXMLTypeLoader.parse(str, CTStyleMatrix.type, (XmlOptions) null);
        }

        public static CTStyleMatrix parse(String str, XmlOptions xmlOptions) {
            return (CTStyleMatrix) POIXMLTypeLoader.parse(str, CTStyleMatrix.type, xmlOptions);
        }

        public static CTStyleMatrix parse(URL url) {
            return (CTStyleMatrix) POIXMLTypeLoader.parse(url, CTStyleMatrix.type, (XmlOptions) null);
        }

        public static CTStyleMatrix parse(URL url, XmlOptions xmlOptions) {
            return (CTStyleMatrix) POIXMLTypeLoader.parse(url, CTStyleMatrix.type, xmlOptions);
        }

        public static CTStyleMatrix parse(XMLStreamReader xMLStreamReader) {
            return (CTStyleMatrix) POIXMLTypeLoader.parse(xMLStreamReader, CTStyleMatrix.type, (XmlOptions) null);
        }

        public static CTStyleMatrix parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTStyleMatrix) POIXMLTypeLoader.parse(xMLStreamReader, CTStyleMatrix.type, xmlOptions);
        }

        public static CTStyleMatrix parse(XMLInputStream xMLInputStream) {
            return (CTStyleMatrix) POIXMLTypeLoader.parse(xMLInputStream, CTStyleMatrix.type, (XmlOptions) null);
        }

        public static CTStyleMatrix parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTStyleMatrix) POIXMLTypeLoader.parse(xMLInputStream, CTStyleMatrix.type, xmlOptions);
        }

        public static CTStyleMatrix parse(Node node) {
            return (CTStyleMatrix) POIXMLTypeLoader.parse(node, CTStyleMatrix.type, (XmlOptions) null);
        }

        public static CTStyleMatrix parse(Node node, XmlOptions xmlOptions) {
            return (CTStyleMatrix) POIXMLTypeLoader.parse(node, CTStyleMatrix.type, xmlOptions);
        }
    }

    CTBackgroundFillStyleList addNewBgFillStyleLst();

    CTEffectStyleList addNewEffectStyleLst();

    CTFillStyleList addNewFillStyleLst();

    CTLineStyleList addNewLnStyleLst();

    CTBackgroundFillStyleList getBgFillStyleLst();

    CTEffectStyleList getEffectStyleLst();

    CTFillStyleList getFillStyleLst();

    CTLineStyleList getLnStyleLst();

    String getName();

    boolean isSetName();

    void setBgFillStyleLst(CTBackgroundFillStyleList cTBackgroundFillStyleList);

    void setEffectStyleLst(CTEffectStyleList cTEffectStyleList);

    void setFillStyleLst(CTFillStyleList cTFillStyleList);

    void setLnStyleLst(CTLineStyleList cTLineStyleList);

    void setName(String str);

    void unsetName();

    XmlString xgetName();

    void xsetName(XmlString xmlString);
}
