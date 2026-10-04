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
public interface CTAlphaModulateFixedEffect extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTAlphaModulateFixedEffect.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctalphamodulatefixedeffect9769type");

    public static final class Factory {
        private Factory() {
        }

        public static CTAlphaModulateFixedEffect newInstance() {
            return (CTAlphaModulateFixedEffect) POIXMLTypeLoader.newInstance(CTAlphaModulateFixedEffect.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTAlphaModulateFixedEffect.type, null);
        }

        public static CTAlphaModulateFixedEffect parse(File file) {
            return (CTAlphaModulateFixedEffect) POIXMLTypeLoader.parse(file, CTAlphaModulateFixedEffect.type, (XmlOptions) null);
        }

        public static CTAlphaModulateFixedEffect newInstance(XmlOptions xmlOptions) {
            return (CTAlphaModulateFixedEffect) POIXMLTypeLoader.newInstance(CTAlphaModulateFixedEffect.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTAlphaModulateFixedEffect.type, xmlOptions);
        }

        public static CTAlphaModulateFixedEffect parse(File file, XmlOptions xmlOptions) {
            return (CTAlphaModulateFixedEffect) POIXMLTypeLoader.parse(file, CTAlphaModulateFixedEffect.type, xmlOptions);
        }

        public static CTAlphaModulateFixedEffect parse(InputStream inputStream) {
            return (CTAlphaModulateFixedEffect) POIXMLTypeLoader.parse(inputStream, CTAlphaModulateFixedEffect.type, (XmlOptions) null);
        }

        public static CTAlphaModulateFixedEffect parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTAlphaModulateFixedEffect) POIXMLTypeLoader.parse(inputStream, CTAlphaModulateFixedEffect.type, xmlOptions);
        }

        public static CTAlphaModulateFixedEffect parse(Reader reader) {
            return (CTAlphaModulateFixedEffect) POIXMLTypeLoader.parse(reader, CTAlphaModulateFixedEffect.type, (XmlOptions) null);
        }

        public static CTAlphaModulateFixedEffect parse(Reader reader, XmlOptions xmlOptions) {
            return (CTAlphaModulateFixedEffect) POIXMLTypeLoader.parse(reader, CTAlphaModulateFixedEffect.type, xmlOptions);
        }

        public static CTAlphaModulateFixedEffect parse(String str) {
            return (CTAlphaModulateFixedEffect) POIXMLTypeLoader.parse(str, CTAlphaModulateFixedEffect.type, (XmlOptions) null);
        }

        public static CTAlphaModulateFixedEffect parse(String str, XmlOptions xmlOptions) {
            return (CTAlphaModulateFixedEffect) POIXMLTypeLoader.parse(str, CTAlphaModulateFixedEffect.type, xmlOptions);
        }

        public static CTAlphaModulateFixedEffect parse(URL url) {
            return (CTAlphaModulateFixedEffect) POIXMLTypeLoader.parse(url, CTAlphaModulateFixedEffect.type, (XmlOptions) null);
        }

        public static CTAlphaModulateFixedEffect parse(URL url, XmlOptions xmlOptions) {
            return (CTAlphaModulateFixedEffect) POIXMLTypeLoader.parse(url, CTAlphaModulateFixedEffect.type, xmlOptions);
        }

        public static CTAlphaModulateFixedEffect parse(XMLStreamReader xMLStreamReader) {
            return (CTAlphaModulateFixedEffect) POIXMLTypeLoader.parse(xMLStreamReader, CTAlphaModulateFixedEffect.type, (XmlOptions) null);
        }

        public static CTAlphaModulateFixedEffect parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTAlphaModulateFixedEffect) POIXMLTypeLoader.parse(xMLStreamReader, CTAlphaModulateFixedEffect.type, xmlOptions);
        }

        public static CTAlphaModulateFixedEffect parse(XMLInputStream xMLInputStream) {
            return (CTAlphaModulateFixedEffect) POIXMLTypeLoader.parse(xMLInputStream, CTAlphaModulateFixedEffect.type, (XmlOptions) null);
        }

        public static CTAlphaModulateFixedEffect parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTAlphaModulateFixedEffect) POIXMLTypeLoader.parse(xMLInputStream, CTAlphaModulateFixedEffect.type, xmlOptions);
        }

        public static CTAlphaModulateFixedEffect parse(Node node) {
            return (CTAlphaModulateFixedEffect) POIXMLTypeLoader.parse(node, CTAlphaModulateFixedEffect.type, (XmlOptions) null);
        }

        public static CTAlphaModulateFixedEffect parse(Node node, XmlOptions xmlOptions) {
            return (CTAlphaModulateFixedEffect) POIXMLTypeLoader.parse(node, CTAlphaModulateFixedEffect.type, xmlOptions);
        }
    }

    int getAmt();

    boolean isSetAmt();

    void setAmt(int i);

    void unsetAmt();

    STPositivePercentage xgetAmt();

    void xsetAmt(STPositivePercentage sTPositivePercentage);
}
