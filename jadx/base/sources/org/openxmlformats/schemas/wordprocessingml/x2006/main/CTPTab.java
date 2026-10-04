package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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
public interface CTPTab extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTPTab.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctptaba283type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPTab newInstance() {
            return (CTPTab) POIXMLTypeLoader.newInstance(CTPTab.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPTab.type, null);
        }

        public static CTPTab parse(File file) {
            return (CTPTab) POIXMLTypeLoader.parse(file, CTPTab.type, (XmlOptions) null);
        }

        public static CTPTab newInstance(XmlOptions xmlOptions) {
            return (CTPTab) POIXMLTypeLoader.newInstance(CTPTab.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPTab.type, xmlOptions);
        }

        public static CTPTab parse(File file, XmlOptions xmlOptions) {
            return (CTPTab) POIXMLTypeLoader.parse(file, CTPTab.type, xmlOptions);
        }

        public static CTPTab parse(InputStream inputStream) {
            return (CTPTab) POIXMLTypeLoader.parse(inputStream, CTPTab.type, (XmlOptions) null);
        }

        public static CTPTab parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTPTab) POIXMLTypeLoader.parse(inputStream, CTPTab.type, xmlOptions);
        }

        public static CTPTab parse(Reader reader) {
            return (CTPTab) POIXMLTypeLoader.parse(reader, CTPTab.type, (XmlOptions) null);
        }

        public static CTPTab parse(Reader reader, XmlOptions xmlOptions) {
            return (CTPTab) POIXMLTypeLoader.parse(reader, CTPTab.type, xmlOptions);
        }

        public static CTPTab parse(String str) {
            return (CTPTab) POIXMLTypeLoader.parse(str, CTPTab.type, (XmlOptions) null);
        }

        public static CTPTab parse(String str, XmlOptions xmlOptions) {
            return (CTPTab) POIXMLTypeLoader.parse(str, CTPTab.type, xmlOptions);
        }

        public static CTPTab parse(URL url) {
            return (CTPTab) POIXMLTypeLoader.parse(url, CTPTab.type, (XmlOptions) null);
        }

        public static CTPTab parse(URL url, XmlOptions xmlOptions) {
            return (CTPTab) POIXMLTypeLoader.parse(url, CTPTab.type, xmlOptions);
        }

        public static CTPTab parse(XMLStreamReader xMLStreamReader) {
            return (CTPTab) POIXMLTypeLoader.parse(xMLStreamReader, CTPTab.type, (XmlOptions) null);
        }

        public static CTPTab parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTPTab) POIXMLTypeLoader.parse(xMLStreamReader, CTPTab.type, xmlOptions);
        }

        public static CTPTab parse(XMLInputStream xMLInputStream) {
            return (CTPTab) POIXMLTypeLoader.parse(xMLInputStream, CTPTab.type, (XmlOptions) null);
        }

        public static CTPTab parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTPTab) POIXMLTypeLoader.parse(xMLInputStream, CTPTab.type, xmlOptions);
        }

        public static CTPTab parse(Node node) {
            return (CTPTab) POIXMLTypeLoader.parse(node, CTPTab.type, (XmlOptions) null);
        }

        public static CTPTab parse(Node node, XmlOptions xmlOptions) {
            return (CTPTab) POIXMLTypeLoader.parse(node, CTPTab.type, xmlOptions);
        }
    }

    STPTabAlignment$Enum getAlignment();

    STPTabLeader$Enum getLeader();

    STPTabRelativeTo$Enum getRelativeTo();

    void setAlignment(STPTabAlignment$Enum sTPTabAlignment$Enum);

    void setLeader(STPTabLeader$Enum sTPTabLeader$Enum);

    void setRelativeTo(STPTabRelativeTo$Enum sTPTabRelativeTo$Enum);

    STPTabAlignment xgetAlignment();

    STPTabLeader xgetLeader();

    STPTabRelativeTo xgetRelativeTo();

    void xsetAlignment(STPTabAlignment sTPTabAlignment);

    void xsetLeader(STPTabLeader sTPTabLeader);

    void xsetRelativeTo(STPTabRelativeTo sTPTabRelativeTo);
}
