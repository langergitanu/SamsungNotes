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
public interface CTRelativeRect extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTRelativeRect.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctrelativerecta4ebtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTRelativeRect newInstance() {
            return (CTRelativeRect) POIXMLTypeLoader.newInstance(CTRelativeRect.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTRelativeRect.type, null);
        }

        public static CTRelativeRect parse(File file) {
            return (CTRelativeRect) POIXMLTypeLoader.parse(file, CTRelativeRect.type, (XmlOptions) null);
        }

        public static CTRelativeRect newInstance(XmlOptions xmlOptions) {
            return (CTRelativeRect) POIXMLTypeLoader.newInstance(CTRelativeRect.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTRelativeRect.type, xmlOptions);
        }

        public static CTRelativeRect parse(File file, XmlOptions xmlOptions) {
            return (CTRelativeRect) POIXMLTypeLoader.parse(file, CTRelativeRect.type, xmlOptions);
        }

        public static CTRelativeRect parse(InputStream inputStream) {
            return (CTRelativeRect) POIXMLTypeLoader.parse(inputStream, CTRelativeRect.type, (XmlOptions) null);
        }

        public static CTRelativeRect parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTRelativeRect) POIXMLTypeLoader.parse(inputStream, CTRelativeRect.type, xmlOptions);
        }

        public static CTRelativeRect parse(Reader reader) {
            return (CTRelativeRect) POIXMLTypeLoader.parse(reader, CTRelativeRect.type, (XmlOptions) null);
        }

        public static CTRelativeRect parse(Reader reader, XmlOptions xmlOptions) {
            return (CTRelativeRect) POIXMLTypeLoader.parse(reader, CTRelativeRect.type, xmlOptions);
        }

        public static CTRelativeRect parse(String str) {
            return (CTRelativeRect) POIXMLTypeLoader.parse(str, CTRelativeRect.type, (XmlOptions) null);
        }

        public static CTRelativeRect parse(String str, XmlOptions xmlOptions) {
            return (CTRelativeRect) POIXMLTypeLoader.parse(str, CTRelativeRect.type, xmlOptions);
        }

        public static CTRelativeRect parse(URL url) {
            return (CTRelativeRect) POIXMLTypeLoader.parse(url, CTRelativeRect.type, (XmlOptions) null);
        }

        public static CTRelativeRect parse(URL url, XmlOptions xmlOptions) {
            return (CTRelativeRect) POIXMLTypeLoader.parse(url, CTRelativeRect.type, xmlOptions);
        }

        public static CTRelativeRect parse(XMLStreamReader xMLStreamReader) {
            return (CTRelativeRect) POIXMLTypeLoader.parse(xMLStreamReader, CTRelativeRect.type, (XmlOptions) null);
        }

        public static CTRelativeRect parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTRelativeRect) POIXMLTypeLoader.parse(xMLStreamReader, CTRelativeRect.type, xmlOptions);
        }

        public static CTRelativeRect parse(XMLInputStream xMLInputStream) {
            return (CTRelativeRect) POIXMLTypeLoader.parse(xMLInputStream, CTRelativeRect.type, (XmlOptions) null);
        }

        public static CTRelativeRect parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTRelativeRect) POIXMLTypeLoader.parse(xMLInputStream, CTRelativeRect.type, xmlOptions);
        }

        public static CTRelativeRect parse(Node node) {
            return (CTRelativeRect) POIXMLTypeLoader.parse(node, CTRelativeRect.type, (XmlOptions) null);
        }

        public static CTRelativeRect parse(Node node, XmlOptions xmlOptions) {
            return (CTRelativeRect) POIXMLTypeLoader.parse(node, CTRelativeRect.type, xmlOptions);
        }
    }

    int getB();

    int getL();

    int getR();

    int getT();

    boolean isSetB();

    boolean isSetL();

    boolean isSetR();

    boolean isSetT();

    void setB(int i);

    void setL(int i);

    void setR(int i);

    void setT(int i);

    void unsetB();

    void unsetL();

    void unsetR();

    void unsetT();

    STPercentage xgetB();

    STPercentage xgetL();

    STPercentage xgetR();

    STPercentage xgetT();

    void xsetB(STPercentage sTPercentage);

    void xsetL(STPercentage sTPercentage);

    void xsetR(STPercentage sTPercentage);

    void xsetT(STPercentage sTPercentage);
}
