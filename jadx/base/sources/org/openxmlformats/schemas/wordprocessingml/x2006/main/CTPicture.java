package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTPicture extends CTPictureBase {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTPicture.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctpicture1054type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPicture newInstance() {
            return (CTPicture) POIXMLTypeLoader.newInstance(CTPicture.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPicture.type, null);
        }

        public static CTPicture parse(File file) {
            return (CTPicture) POIXMLTypeLoader.parse(file, CTPicture.type, (XmlOptions) null);
        }

        public static CTPicture newInstance(XmlOptions xmlOptions) {
            return (CTPicture) POIXMLTypeLoader.newInstance(CTPicture.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPicture.type, xmlOptions);
        }

        public static CTPicture parse(File file, XmlOptions xmlOptions) {
            return (CTPicture) POIXMLTypeLoader.parse(file, CTPicture.type, xmlOptions);
        }

        public static CTPicture parse(InputStream inputStream) {
            return (CTPicture) POIXMLTypeLoader.parse(inputStream, CTPicture.type, (XmlOptions) null);
        }

        public static CTPicture parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTPicture) POIXMLTypeLoader.parse(inputStream, CTPicture.type, xmlOptions);
        }

        public static CTPicture parse(Reader reader) {
            return (CTPicture) POIXMLTypeLoader.parse(reader, CTPicture.type, (XmlOptions) null);
        }

        public static CTPicture parse(Reader reader, XmlOptions xmlOptions) {
            return (CTPicture) POIXMLTypeLoader.parse(reader, CTPicture.type, xmlOptions);
        }

        public static CTPicture parse(String str) {
            return (CTPicture) POIXMLTypeLoader.parse(str, CTPicture.type, (XmlOptions) null);
        }

        public static CTPicture parse(String str, XmlOptions xmlOptions) {
            return (CTPicture) POIXMLTypeLoader.parse(str, CTPicture.type, xmlOptions);
        }

        public static CTPicture parse(URL url) {
            return (CTPicture) POIXMLTypeLoader.parse(url, CTPicture.type, (XmlOptions) null);
        }

        public static CTPicture parse(URL url, XmlOptions xmlOptions) {
            return (CTPicture) POIXMLTypeLoader.parse(url, CTPicture.type, xmlOptions);
        }

        public static CTPicture parse(XMLStreamReader xMLStreamReader) {
            return (CTPicture) POIXMLTypeLoader.parse(xMLStreamReader, CTPicture.type, (XmlOptions) null);
        }

        public static CTPicture parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTPicture) POIXMLTypeLoader.parse(xMLStreamReader, CTPicture.type, xmlOptions);
        }

        public static CTPicture parse(XMLInputStream xMLInputStream) {
            return (CTPicture) POIXMLTypeLoader.parse(xMLInputStream, CTPicture.type, (XmlOptions) null);
        }

        public static CTPicture parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTPicture) POIXMLTypeLoader.parse(xMLInputStream, CTPicture.type, xmlOptions);
        }

        public static CTPicture parse(Node node) {
            return (CTPicture) POIXMLTypeLoader.parse(node, CTPicture.type, (XmlOptions) null);
        }

        public static CTPicture parse(Node node, XmlOptions xmlOptions) {
            return (CTPicture) POIXMLTypeLoader.parse(node, CTPicture.type, xmlOptions);
        }
    }

    CTControl addNewControl();

    CTRel addNewMovie();

    CTControl getControl();

    CTRel getMovie();

    boolean isSetControl();

    boolean isSetMovie();

    void setControl(CTControl cTControl);

    void setMovie(CTRel cTRel);

    void unsetControl();

    void unsetMovie();
}
