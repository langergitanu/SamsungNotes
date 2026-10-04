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
public interface CTPPr extends CTPPrBase {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTPPr.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctppr01c0type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPPr newInstance() {
            return (CTPPr) POIXMLTypeLoader.newInstance(CTPPr.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPPr.type, null);
        }

        public static CTPPr parse(File file) {
            return (CTPPr) POIXMLTypeLoader.parse(file, CTPPr.type, (XmlOptions) null);
        }

        public static CTPPr newInstance(XmlOptions xmlOptions) {
            return (CTPPr) POIXMLTypeLoader.newInstance(CTPPr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPPr.type, xmlOptions);
        }

        public static CTPPr parse(File file, XmlOptions xmlOptions) {
            return (CTPPr) POIXMLTypeLoader.parse(file, CTPPr.type, xmlOptions);
        }

        public static CTPPr parse(InputStream inputStream) {
            return (CTPPr) POIXMLTypeLoader.parse(inputStream, CTPPr.type, (XmlOptions) null);
        }

        public static CTPPr parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTPPr) POIXMLTypeLoader.parse(inputStream, CTPPr.type, xmlOptions);
        }

        public static CTPPr parse(Reader reader) {
            return (CTPPr) POIXMLTypeLoader.parse(reader, CTPPr.type, (XmlOptions) null);
        }

        public static CTPPr parse(Reader reader, XmlOptions xmlOptions) {
            return (CTPPr) POIXMLTypeLoader.parse(reader, CTPPr.type, xmlOptions);
        }

        public static CTPPr parse(String str) {
            return (CTPPr) POIXMLTypeLoader.parse(str, CTPPr.type, (XmlOptions) null);
        }

        public static CTPPr parse(String str, XmlOptions xmlOptions) {
            return (CTPPr) POIXMLTypeLoader.parse(str, CTPPr.type, xmlOptions);
        }

        public static CTPPr parse(URL url) {
            return (CTPPr) POIXMLTypeLoader.parse(url, CTPPr.type, (XmlOptions) null);
        }

        public static CTPPr parse(URL url, XmlOptions xmlOptions) {
            return (CTPPr) POIXMLTypeLoader.parse(url, CTPPr.type, xmlOptions);
        }

        public static CTPPr parse(XMLStreamReader xMLStreamReader) {
            return (CTPPr) POIXMLTypeLoader.parse(xMLStreamReader, CTPPr.type, (XmlOptions) null);
        }

        public static CTPPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTPPr) POIXMLTypeLoader.parse(xMLStreamReader, CTPPr.type, xmlOptions);
        }

        public static CTPPr parse(XMLInputStream xMLInputStream) {
            return (CTPPr) POIXMLTypeLoader.parse(xMLInputStream, CTPPr.type, (XmlOptions) null);
        }

        public static CTPPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTPPr) POIXMLTypeLoader.parse(xMLInputStream, CTPPr.type, xmlOptions);
        }

        public static CTPPr parse(Node node) {
            return (CTPPr) POIXMLTypeLoader.parse(node, CTPPr.type, (XmlOptions) null);
        }

        public static CTPPr parse(Node node, XmlOptions xmlOptions) {
            return (CTPPr) POIXMLTypeLoader.parse(node, CTPPr.type, xmlOptions);
        }
    }

    CTPPrChange addNewPPrChange();

    CTParaRPr addNewRPr();

    CTSectPr addNewSectPr();

    CTPPrChange getPPrChange();

    CTParaRPr getRPr();

    CTSectPr getSectPr();

    boolean isSetPPrChange();

    boolean isSetRPr();

    boolean isSetSectPr();

    void setPPrChange(CTPPrChange cTPPrChange);

    void setRPr(CTParaRPr cTParaRPr);

    void setSectPr(CTSectPr cTSectPr);

    void unsetPPrChange();

    void unsetRPr();

    void unsetSectPr();
}
