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
public interface CTTableStyleCellStyle extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTableStyleCellStyle.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttablestylecellstyle1fddtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTableStyleCellStyle newInstance() {
            return (CTTableStyleCellStyle) POIXMLTypeLoader.newInstance(CTTableStyleCellStyle.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTableStyleCellStyle.type, null);
        }

        public static CTTableStyleCellStyle parse(File file) {
            return (CTTableStyleCellStyle) POIXMLTypeLoader.parse(file, CTTableStyleCellStyle.type, (XmlOptions) null);
        }

        public static CTTableStyleCellStyle newInstance(XmlOptions xmlOptions) {
            return (CTTableStyleCellStyle) POIXMLTypeLoader.newInstance(CTTableStyleCellStyle.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTableStyleCellStyle.type, xmlOptions);
        }

        public static CTTableStyleCellStyle parse(File file, XmlOptions xmlOptions) {
            return (CTTableStyleCellStyle) POIXMLTypeLoader.parse(file, CTTableStyleCellStyle.type, xmlOptions);
        }

        public static CTTableStyleCellStyle parse(InputStream inputStream) {
            return (CTTableStyleCellStyle) POIXMLTypeLoader.parse(inputStream, CTTableStyleCellStyle.type, (XmlOptions) null);
        }

        public static CTTableStyleCellStyle parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTableStyleCellStyle) POIXMLTypeLoader.parse(inputStream, CTTableStyleCellStyle.type, xmlOptions);
        }

        public static CTTableStyleCellStyle parse(Reader reader) {
            return (CTTableStyleCellStyle) POIXMLTypeLoader.parse(reader, CTTableStyleCellStyle.type, (XmlOptions) null);
        }

        public static CTTableStyleCellStyle parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTableStyleCellStyle) POIXMLTypeLoader.parse(reader, CTTableStyleCellStyle.type, xmlOptions);
        }

        public static CTTableStyleCellStyle parse(String str) {
            return (CTTableStyleCellStyle) POIXMLTypeLoader.parse(str, CTTableStyleCellStyle.type, (XmlOptions) null);
        }

        public static CTTableStyleCellStyle parse(String str, XmlOptions xmlOptions) {
            return (CTTableStyleCellStyle) POIXMLTypeLoader.parse(str, CTTableStyleCellStyle.type, xmlOptions);
        }

        public static CTTableStyleCellStyle parse(URL url) {
            return (CTTableStyleCellStyle) POIXMLTypeLoader.parse(url, CTTableStyleCellStyle.type, (XmlOptions) null);
        }

        public static CTTableStyleCellStyle parse(URL url, XmlOptions xmlOptions) {
            return (CTTableStyleCellStyle) POIXMLTypeLoader.parse(url, CTTableStyleCellStyle.type, xmlOptions);
        }

        public static CTTableStyleCellStyle parse(XMLStreamReader xMLStreamReader) {
            return (CTTableStyleCellStyle) POIXMLTypeLoader.parse(xMLStreamReader, CTTableStyleCellStyle.type, (XmlOptions) null);
        }

        public static CTTableStyleCellStyle parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTableStyleCellStyle) POIXMLTypeLoader.parse(xMLStreamReader, CTTableStyleCellStyle.type, xmlOptions);
        }

        public static CTTableStyleCellStyle parse(XMLInputStream xMLInputStream) {
            return (CTTableStyleCellStyle) POIXMLTypeLoader.parse(xMLInputStream, CTTableStyleCellStyle.type, (XmlOptions) null);
        }

        public static CTTableStyleCellStyle parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTableStyleCellStyle) POIXMLTypeLoader.parse(xMLInputStream, CTTableStyleCellStyle.type, xmlOptions);
        }

        public static CTTableStyleCellStyle parse(Node node) {
            return (CTTableStyleCellStyle) POIXMLTypeLoader.parse(node, CTTableStyleCellStyle.type, (XmlOptions) null);
        }

        public static CTTableStyleCellStyle parse(Node node, XmlOptions xmlOptions) {
            return (CTTableStyleCellStyle) POIXMLTypeLoader.parse(node, CTTableStyleCellStyle.type, xmlOptions);
        }
    }

    CTCell3D addNewCell3D();

    CTFillProperties addNewFill();

    CTStyleMatrixReference addNewFillRef();

    CTTableCellBorderStyle addNewTcBdr();

    CTCell3D getCell3D();

    CTFillProperties getFill();

    CTStyleMatrixReference getFillRef();

    CTTableCellBorderStyle getTcBdr();

    boolean isSetCell3D();

    boolean isSetFill();

    boolean isSetFillRef();

    boolean isSetTcBdr();

    void setCell3D(CTCell3D cTCell3D);

    void setFill(CTFillProperties cTFillProperties);

    void setFillRef(CTStyleMatrixReference cTStyleMatrixReference);

    void setTcBdr(CTTableCellBorderStyle cTTableCellBorderStyle);

    void unsetCell3D();

    void unsetFill();

    void unsetFillRef();

    void unsetTcBdr();
}
