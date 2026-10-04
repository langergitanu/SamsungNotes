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
public interface CTShapeStyle extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTShapeStyle.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctshapestyle81ebtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTShapeStyle newInstance() {
            return (CTShapeStyle) POIXMLTypeLoader.newInstance(CTShapeStyle.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTShapeStyle.type, null);
        }

        public static CTShapeStyle parse(File file) {
            return (CTShapeStyle) POIXMLTypeLoader.parse(file, CTShapeStyle.type, (XmlOptions) null);
        }

        public static CTShapeStyle newInstance(XmlOptions xmlOptions) {
            return (CTShapeStyle) POIXMLTypeLoader.newInstance(CTShapeStyle.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTShapeStyle.type, xmlOptions);
        }

        public static CTShapeStyle parse(File file, XmlOptions xmlOptions) {
            return (CTShapeStyle) POIXMLTypeLoader.parse(file, CTShapeStyle.type, xmlOptions);
        }

        public static CTShapeStyle parse(InputStream inputStream) {
            return (CTShapeStyle) POIXMLTypeLoader.parse(inputStream, CTShapeStyle.type, (XmlOptions) null);
        }

        public static CTShapeStyle parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTShapeStyle) POIXMLTypeLoader.parse(inputStream, CTShapeStyle.type, xmlOptions);
        }

        public static CTShapeStyle parse(Reader reader) {
            return (CTShapeStyle) POIXMLTypeLoader.parse(reader, CTShapeStyle.type, (XmlOptions) null);
        }

        public static CTShapeStyle parse(Reader reader, XmlOptions xmlOptions) {
            return (CTShapeStyle) POIXMLTypeLoader.parse(reader, CTShapeStyle.type, xmlOptions);
        }

        public static CTShapeStyle parse(String str) {
            return (CTShapeStyle) POIXMLTypeLoader.parse(str, CTShapeStyle.type, (XmlOptions) null);
        }

        public static CTShapeStyle parse(String str, XmlOptions xmlOptions) {
            return (CTShapeStyle) POIXMLTypeLoader.parse(str, CTShapeStyle.type, xmlOptions);
        }

        public static CTShapeStyle parse(URL url) {
            return (CTShapeStyle) POIXMLTypeLoader.parse(url, CTShapeStyle.type, (XmlOptions) null);
        }

        public static CTShapeStyle parse(URL url, XmlOptions xmlOptions) {
            return (CTShapeStyle) POIXMLTypeLoader.parse(url, CTShapeStyle.type, xmlOptions);
        }

        public static CTShapeStyle parse(XMLStreamReader xMLStreamReader) {
            return (CTShapeStyle) POIXMLTypeLoader.parse(xMLStreamReader, CTShapeStyle.type, (XmlOptions) null);
        }

        public static CTShapeStyle parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTShapeStyle) POIXMLTypeLoader.parse(xMLStreamReader, CTShapeStyle.type, xmlOptions);
        }

        public static CTShapeStyle parse(XMLInputStream xMLInputStream) {
            return (CTShapeStyle) POIXMLTypeLoader.parse(xMLInputStream, CTShapeStyle.type, (XmlOptions) null);
        }

        public static CTShapeStyle parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTShapeStyle) POIXMLTypeLoader.parse(xMLInputStream, CTShapeStyle.type, xmlOptions);
        }

        public static CTShapeStyle parse(Node node) {
            return (CTShapeStyle) POIXMLTypeLoader.parse(node, CTShapeStyle.type, (XmlOptions) null);
        }

        public static CTShapeStyle parse(Node node, XmlOptions xmlOptions) {
            return (CTShapeStyle) POIXMLTypeLoader.parse(node, CTShapeStyle.type, xmlOptions);
        }
    }

    CTStyleMatrixReference addNewEffectRef();

    CTStyleMatrixReference addNewFillRef();

    CTFontReference addNewFontRef();

    CTStyleMatrixReference addNewLnRef();

    CTStyleMatrixReference getEffectRef();

    CTStyleMatrixReference getFillRef();

    CTFontReference getFontRef();

    CTStyleMatrixReference getLnRef();

    void setEffectRef(CTStyleMatrixReference cTStyleMatrixReference);

    void setFillRef(CTStyleMatrixReference cTStyleMatrixReference);

    void setFontRef(CTFontReference cTFontReference);

    void setLnRef(CTStyleMatrixReference cTStyleMatrixReference);
}
