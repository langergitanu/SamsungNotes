package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTabJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTabTlc;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTTabStop extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTabStop.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttabstop5ebbtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTabStop newInstance() {
            return (CTTabStop) POIXMLTypeLoader.newInstance(CTTabStop.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTabStop.type, null);
        }

        public static CTTabStop parse(File file) {
            return (CTTabStop) POIXMLTypeLoader.parse(file, CTTabStop.type, (XmlOptions) null);
        }

        public static CTTabStop newInstance(XmlOptions xmlOptions) {
            return (CTTabStop) POIXMLTypeLoader.newInstance(CTTabStop.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTabStop.type, xmlOptions);
        }

        public static CTTabStop parse(File file, XmlOptions xmlOptions) {
            return (CTTabStop) POIXMLTypeLoader.parse(file, CTTabStop.type, xmlOptions);
        }

        public static CTTabStop parse(InputStream inputStream) {
            return (CTTabStop) POIXMLTypeLoader.parse(inputStream, CTTabStop.type, (XmlOptions) null);
        }

        public static CTTabStop parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTabStop) POIXMLTypeLoader.parse(inputStream, CTTabStop.type, xmlOptions);
        }

        public static CTTabStop parse(Reader reader) {
            return (CTTabStop) POIXMLTypeLoader.parse(reader, CTTabStop.type, (XmlOptions) null);
        }

        public static CTTabStop parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTabStop) POIXMLTypeLoader.parse(reader, CTTabStop.type, xmlOptions);
        }

        public static CTTabStop parse(String str) {
            return (CTTabStop) POIXMLTypeLoader.parse(str, CTTabStop.type, (XmlOptions) null);
        }

        public static CTTabStop parse(String str, XmlOptions xmlOptions) {
            return (CTTabStop) POIXMLTypeLoader.parse(str, CTTabStop.type, xmlOptions);
        }

        public static CTTabStop parse(URL url) {
            return (CTTabStop) POIXMLTypeLoader.parse(url, CTTabStop.type, (XmlOptions) null);
        }

        public static CTTabStop parse(URL url, XmlOptions xmlOptions) {
            return (CTTabStop) POIXMLTypeLoader.parse(url, CTTabStop.type, xmlOptions);
        }

        public static CTTabStop parse(XMLStreamReader xMLStreamReader) {
            return (CTTabStop) POIXMLTypeLoader.parse(xMLStreamReader, CTTabStop.type, (XmlOptions) null);
        }

        public static CTTabStop parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTabStop) POIXMLTypeLoader.parse(xMLStreamReader, CTTabStop.type, xmlOptions);
        }

        public static CTTabStop parse(XMLInputStream xMLInputStream) {
            return (CTTabStop) POIXMLTypeLoader.parse(xMLInputStream, CTTabStop.type, (XmlOptions) null);
        }

        public static CTTabStop parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTabStop) POIXMLTypeLoader.parse(xMLInputStream, CTTabStop.type, xmlOptions);
        }

        public static CTTabStop parse(Node node) {
            return (CTTabStop) POIXMLTypeLoader.parse(node, CTTabStop.type, (XmlOptions) null);
        }

        public static CTTabStop parse(Node node, XmlOptions xmlOptions) {
            return (CTTabStop) POIXMLTypeLoader.parse(node, CTTabStop.type, xmlOptions);
        }
    }

    STTabTlc.Enum getLeader();

    BigInteger getPos();

    STTabJc.Enum getVal();

    boolean isSetLeader();

    void setLeader(STTabTlc.Enum r12);

    void setPos(BigInteger bigInteger);

    void setVal(STTabJc.Enum r12);

    void unsetLeader();

    STTabTlc xgetLeader();

    STSignedTwipsMeasure xgetPos();

    STTabJc xgetVal();

    void xsetLeader(STTabTlc sTTabTlc);

    void xsetPos(STSignedTwipsMeasure sTSignedTwipsMeasure);

    void xsetVal(STTabJc sTTabJc);
}
