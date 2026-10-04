package org.openxmlformats.schemas.officeDocument.x2006.math;

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
public interface CTOMathPara extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTOMathPara.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctomathpara8825type");

    public static final class Factory {
        private Factory() {
        }

        public static CTOMathPara newInstance() {
            return (CTOMathPara) POIXMLTypeLoader.newInstance(CTOMathPara.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTOMathPara.type, null);
        }

        public static CTOMathPara parse(File file) {
            return (CTOMathPara) POIXMLTypeLoader.parse(file, CTOMathPara.type, (XmlOptions) null);
        }

        public static CTOMathPara newInstance(XmlOptions xmlOptions) {
            return (CTOMathPara) POIXMLTypeLoader.newInstance(CTOMathPara.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTOMathPara.type, xmlOptions);
        }

        public static CTOMathPara parse(File file, XmlOptions xmlOptions) {
            return (CTOMathPara) POIXMLTypeLoader.parse(file, CTOMathPara.type, xmlOptions);
        }

        public static CTOMathPara parse(InputStream inputStream) {
            return (CTOMathPara) POIXMLTypeLoader.parse(inputStream, CTOMathPara.type, (XmlOptions) null);
        }

        public static CTOMathPara parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTOMathPara) POIXMLTypeLoader.parse(inputStream, CTOMathPara.type, xmlOptions);
        }

        public static CTOMathPara parse(Reader reader) {
            return (CTOMathPara) POIXMLTypeLoader.parse(reader, CTOMathPara.type, (XmlOptions) null);
        }

        public static CTOMathPara parse(Reader reader, XmlOptions xmlOptions) {
            return (CTOMathPara) POIXMLTypeLoader.parse(reader, CTOMathPara.type, xmlOptions);
        }

        public static CTOMathPara parse(String str) {
            return (CTOMathPara) POIXMLTypeLoader.parse(str, CTOMathPara.type, (XmlOptions) null);
        }

        public static CTOMathPara parse(String str, XmlOptions xmlOptions) {
            return (CTOMathPara) POIXMLTypeLoader.parse(str, CTOMathPara.type, xmlOptions);
        }

        public static CTOMathPara parse(URL url) {
            return (CTOMathPara) POIXMLTypeLoader.parse(url, CTOMathPara.type, (XmlOptions) null);
        }

        public static CTOMathPara parse(URL url, XmlOptions xmlOptions) {
            return (CTOMathPara) POIXMLTypeLoader.parse(url, CTOMathPara.type, xmlOptions);
        }

        public static CTOMathPara parse(XMLStreamReader xMLStreamReader) {
            return (CTOMathPara) POIXMLTypeLoader.parse(xMLStreamReader, CTOMathPara.type, (XmlOptions) null);
        }

        public static CTOMathPara parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTOMathPara) POIXMLTypeLoader.parse(xMLStreamReader, CTOMathPara.type, xmlOptions);
        }

        public static CTOMathPara parse(XMLInputStream xMLInputStream) {
            return (CTOMathPara) POIXMLTypeLoader.parse(xMLInputStream, CTOMathPara.type, (XmlOptions) null);
        }

        public static CTOMathPara parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTOMathPara) POIXMLTypeLoader.parse(xMLInputStream, CTOMathPara.type, xmlOptions);
        }

        public static CTOMathPara parse(Node node) {
            return (CTOMathPara) POIXMLTypeLoader.parse(node, CTOMathPara.type, (XmlOptions) null);
        }

        public static CTOMathPara parse(Node node, XmlOptions xmlOptions) {
            return (CTOMathPara) POIXMLTypeLoader.parse(node, CTOMathPara.type, xmlOptions);
        }
    }

    CTOMath addNewOMath();

    CTOMathParaPr addNewOMathParaPr();

    CTOMath getOMathArray(int i);

    CTOMath[] getOMathArray();

    List<CTOMath> getOMathList();

    CTOMathParaPr getOMathParaPr();

    CTOMath insertNewOMath(int i);

    boolean isSetOMathParaPr();

    void removeOMath(int i);

    void setOMathArray(int i, CTOMath cTOMath);

    void setOMathArray(CTOMath[] cTOMathArr);

    void setOMathParaPr(CTOMathParaPr cTOMathParaPr);

    int sizeOfOMathArray();

    void unsetOMathParaPr();
}
