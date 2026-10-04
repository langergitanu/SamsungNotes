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
public interface CTTextSpacing extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTextSpacing.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttextspacingef87type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextSpacing newInstance() {
            return (CTTextSpacing) POIXMLTypeLoader.newInstance(CTTextSpacing.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextSpacing.type, null);
        }

        public static CTTextSpacing parse(File file) {
            return (CTTextSpacing) POIXMLTypeLoader.parse(file, CTTextSpacing.type, (XmlOptions) null);
        }

        public static CTTextSpacing newInstance(XmlOptions xmlOptions) {
            return (CTTextSpacing) POIXMLTypeLoader.newInstance(CTTextSpacing.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextSpacing.type, xmlOptions);
        }

        public static CTTextSpacing parse(File file, XmlOptions xmlOptions) {
            return (CTTextSpacing) POIXMLTypeLoader.parse(file, CTTextSpacing.type, xmlOptions);
        }

        public static CTTextSpacing parse(InputStream inputStream) {
            return (CTTextSpacing) POIXMLTypeLoader.parse(inputStream, CTTextSpacing.type, (XmlOptions) null);
        }

        public static CTTextSpacing parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTextSpacing) POIXMLTypeLoader.parse(inputStream, CTTextSpacing.type, xmlOptions);
        }

        public static CTTextSpacing parse(Reader reader) {
            return (CTTextSpacing) POIXMLTypeLoader.parse(reader, CTTextSpacing.type, (XmlOptions) null);
        }

        public static CTTextSpacing parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTextSpacing) POIXMLTypeLoader.parse(reader, CTTextSpacing.type, xmlOptions);
        }

        public static CTTextSpacing parse(String str) {
            return (CTTextSpacing) POIXMLTypeLoader.parse(str, CTTextSpacing.type, (XmlOptions) null);
        }

        public static CTTextSpacing parse(String str, XmlOptions xmlOptions) {
            return (CTTextSpacing) POIXMLTypeLoader.parse(str, CTTextSpacing.type, xmlOptions);
        }

        public static CTTextSpacing parse(URL url) {
            return (CTTextSpacing) POIXMLTypeLoader.parse(url, CTTextSpacing.type, (XmlOptions) null);
        }

        public static CTTextSpacing parse(URL url, XmlOptions xmlOptions) {
            return (CTTextSpacing) POIXMLTypeLoader.parse(url, CTTextSpacing.type, xmlOptions);
        }

        public static CTTextSpacing parse(XMLStreamReader xMLStreamReader) {
            return (CTTextSpacing) POIXMLTypeLoader.parse(xMLStreamReader, CTTextSpacing.type, (XmlOptions) null);
        }

        public static CTTextSpacing parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTextSpacing) POIXMLTypeLoader.parse(xMLStreamReader, CTTextSpacing.type, xmlOptions);
        }

        public static CTTextSpacing parse(XMLInputStream xMLInputStream) {
            return (CTTextSpacing) POIXMLTypeLoader.parse(xMLInputStream, CTTextSpacing.type, (XmlOptions) null);
        }

        public static CTTextSpacing parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTextSpacing) POIXMLTypeLoader.parse(xMLInputStream, CTTextSpacing.type, xmlOptions);
        }

        public static CTTextSpacing parse(Node node) {
            return (CTTextSpacing) POIXMLTypeLoader.parse(node, CTTextSpacing.type, (XmlOptions) null);
        }

        public static CTTextSpacing parse(Node node, XmlOptions xmlOptions) {
            return (CTTextSpacing) POIXMLTypeLoader.parse(node, CTTextSpacing.type, xmlOptions);
        }
    }

    CTTextSpacingPercent addNewSpcPct();

    CTTextSpacingPoint addNewSpcPts();

    CTTextSpacingPercent getSpcPct();

    CTTextSpacingPoint getSpcPts();

    boolean isSetSpcPct();

    boolean isSetSpcPts();

    void setSpcPct(CTTextSpacingPercent cTTextSpacingPercent);

    void setSpcPts(CTTextSpacingPoint cTTextSpacingPoint);

    void unsetSpcPct();

    void unsetSpcPts();
}
