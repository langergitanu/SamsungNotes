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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTVMerge extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTVMerge.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctvmergee086type");

    public static final class Factory {
        private Factory() {
        }

        public static CTVMerge newInstance() {
            return (CTVMerge) POIXMLTypeLoader.newInstance(CTVMerge.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTVMerge.type, null);
        }

        public static CTVMerge parse(File file) {
            return (CTVMerge) POIXMLTypeLoader.parse(file, CTVMerge.type, (XmlOptions) null);
        }

        public static CTVMerge newInstance(XmlOptions xmlOptions) {
            return (CTVMerge) POIXMLTypeLoader.newInstance(CTVMerge.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTVMerge.type, xmlOptions);
        }

        public static CTVMerge parse(File file, XmlOptions xmlOptions) {
            return (CTVMerge) POIXMLTypeLoader.parse(file, CTVMerge.type, xmlOptions);
        }

        public static CTVMerge parse(InputStream inputStream) {
            return (CTVMerge) POIXMLTypeLoader.parse(inputStream, CTVMerge.type, (XmlOptions) null);
        }

        public static CTVMerge parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTVMerge) POIXMLTypeLoader.parse(inputStream, CTVMerge.type, xmlOptions);
        }

        public static CTVMerge parse(Reader reader) {
            return (CTVMerge) POIXMLTypeLoader.parse(reader, CTVMerge.type, (XmlOptions) null);
        }

        public static CTVMerge parse(Reader reader, XmlOptions xmlOptions) {
            return (CTVMerge) POIXMLTypeLoader.parse(reader, CTVMerge.type, xmlOptions);
        }

        public static CTVMerge parse(String str) {
            return (CTVMerge) POIXMLTypeLoader.parse(str, CTVMerge.type, (XmlOptions) null);
        }

        public static CTVMerge parse(String str, XmlOptions xmlOptions) {
            return (CTVMerge) POIXMLTypeLoader.parse(str, CTVMerge.type, xmlOptions);
        }

        public static CTVMerge parse(URL url) {
            return (CTVMerge) POIXMLTypeLoader.parse(url, CTVMerge.type, (XmlOptions) null);
        }

        public static CTVMerge parse(URL url, XmlOptions xmlOptions) {
            return (CTVMerge) POIXMLTypeLoader.parse(url, CTVMerge.type, xmlOptions);
        }

        public static CTVMerge parse(XMLStreamReader xMLStreamReader) {
            return (CTVMerge) POIXMLTypeLoader.parse(xMLStreamReader, CTVMerge.type, (XmlOptions) null);
        }

        public static CTVMerge parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTVMerge) POIXMLTypeLoader.parse(xMLStreamReader, CTVMerge.type, xmlOptions);
        }

        public static CTVMerge parse(XMLInputStream xMLInputStream) {
            return (CTVMerge) POIXMLTypeLoader.parse(xMLInputStream, CTVMerge.type, (XmlOptions) null);
        }

        public static CTVMerge parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTVMerge) POIXMLTypeLoader.parse(xMLInputStream, CTVMerge.type, xmlOptions);
        }

        public static CTVMerge parse(Node node) {
            return (CTVMerge) POIXMLTypeLoader.parse(node, CTVMerge.type, (XmlOptions) null);
        }

        public static CTVMerge parse(Node node, XmlOptions xmlOptions) {
            return (CTVMerge) POIXMLTypeLoader.parse(node, CTVMerge.type, xmlOptions);
        }
    }

    STMerge.Enum getVal();

    boolean isSetVal();

    void setVal(STMerge.Enum r12);

    void unsetVal();

    STMerge xgetVal();

    void xsetVal(STMerge sTMerge);
}
