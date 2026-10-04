package org.openxmlformats.schemas.presentationml.x2006.main;

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
import org.openxmlformats.schemas.drawingml.x2006.main.CTAnimationElementChoice;
import org.openxmlformats.schemas.drawingml.x2006.main.STShapeID;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTTLShapeTargetElement extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTLShapeTargetElement.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttlshapetargetelement2763type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTLShapeTargetElement newInstance() {
            return (CTTLShapeTargetElement) POIXMLTypeLoader.newInstance(CTTLShapeTargetElement.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTLShapeTargetElement.type, null);
        }

        public static CTTLShapeTargetElement parse(File file) {
            return (CTTLShapeTargetElement) POIXMLTypeLoader.parse(file, CTTLShapeTargetElement.type, (XmlOptions) null);
        }

        public static CTTLShapeTargetElement newInstance(XmlOptions xmlOptions) {
            return (CTTLShapeTargetElement) POIXMLTypeLoader.newInstance(CTTLShapeTargetElement.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTLShapeTargetElement.type, xmlOptions);
        }

        public static CTTLShapeTargetElement parse(File file, XmlOptions xmlOptions) {
            return (CTTLShapeTargetElement) POIXMLTypeLoader.parse(file, CTTLShapeTargetElement.type, xmlOptions);
        }

        public static CTTLShapeTargetElement parse(InputStream inputStream) {
            return (CTTLShapeTargetElement) POIXMLTypeLoader.parse(inputStream, CTTLShapeTargetElement.type, (XmlOptions) null);
        }

        public static CTTLShapeTargetElement parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTLShapeTargetElement) POIXMLTypeLoader.parse(inputStream, CTTLShapeTargetElement.type, xmlOptions);
        }

        public static CTTLShapeTargetElement parse(Reader reader) {
            return (CTTLShapeTargetElement) POIXMLTypeLoader.parse(reader, CTTLShapeTargetElement.type, (XmlOptions) null);
        }

        public static CTTLShapeTargetElement parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTLShapeTargetElement) POIXMLTypeLoader.parse(reader, CTTLShapeTargetElement.type, xmlOptions);
        }

        public static CTTLShapeTargetElement parse(String str) {
            return (CTTLShapeTargetElement) POIXMLTypeLoader.parse(str, CTTLShapeTargetElement.type, (XmlOptions) null);
        }

        public static CTTLShapeTargetElement parse(String str, XmlOptions xmlOptions) {
            return (CTTLShapeTargetElement) POIXMLTypeLoader.parse(str, CTTLShapeTargetElement.type, xmlOptions);
        }

        public static CTTLShapeTargetElement parse(URL url) {
            return (CTTLShapeTargetElement) POIXMLTypeLoader.parse(url, CTTLShapeTargetElement.type, (XmlOptions) null);
        }

        public static CTTLShapeTargetElement parse(URL url, XmlOptions xmlOptions) {
            return (CTTLShapeTargetElement) POIXMLTypeLoader.parse(url, CTTLShapeTargetElement.type, xmlOptions);
        }

        public static CTTLShapeTargetElement parse(XMLStreamReader xMLStreamReader) {
            return (CTTLShapeTargetElement) POIXMLTypeLoader.parse(xMLStreamReader, CTTLShapeTargetElement.type, (XmlOptions) null);
        }

        public static CTTLShapeTargetElement parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTLShapeTargetElement) POIXMLTypeLoader.parse(xMLStreamReader, CTTLShapeTargetElement.type, xmlOptions);
        }

        public static CTTLShapeTargetElement parse(XMLInputStream xMLInputStream) {
            return (CTTLShapeTargetElement) POIXMLTypeLoader.parse(xMLInputStream, CTTLShapeTargetElement.type, (XmlOptions) null);
        }

        public static CTTLShapeTargetElement parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTLShapeTargetElement) POIXMLTypeLoader.parse(xMLInputStream, CTTLShapeTargetElement.type, xmlOptions);
        }

        public static CTTLShapeTargetElement parse(Node node) {
            return (CTTLShapeTargetElement) POIXMLTypeLoader.parse(node, CTTLShapeTargetElement.type, (XmlOptions) null);
        }

        public static CTTLShapeTargetElement parse(Node node, XmlOptions xmlOptions) {
            return (CTTLShapeTargetElement) POIXMLTypeLoader.parse(node, CTTLShapeTargetElement.type, xmlOptions);
        }
    }

    CTEmpty addNewBg();

    CTAnimationElementChoice addNewGraphicEl();

    CTTLOleChartTargetElement addNewOleChartEl();

    CTTLSubShapeId addNewSubSp();

    CTTLTextTargetElement addNewTxEl();

    CTEmpty getBg();

    CTAnimationElementChoice getGraphicEl();

    CTTLOleChartTargetElement getOleChartEl();

    String getSpid();

    CTTLSubShapeId getSubSp();

    CTTLTextTargetElement getTxEl();

    boolean isSetBg();

    boolean isSetGraphicEl();

    boolean isSetOleChartEl();

    boolean isSetSubSp();

    boolean isSetTxEl();

    void setBg(CTEmpty cTEmpty);

    void setGraphicEl(CTAnimationElementChoice cTAnimationElementChoice);

    void setOleChartEl(CTTLOleChartTargetElement cTTLOleChartTargetElement);

    void setSpid(String str);

    void setSubSp(CTTLSubShapeId cTTLSubShapeId);

    void setTxEl(CTTLTextTargetElement cTTLTextTargetElement);

    void unsetBg();

    void unsetGraphicEl();

    void unsetOleChartEl();

    void unsetSubSp();

    void unsetTxEl();

    STShapeID xgetSpid();

    void xsetSpid(STShapeID sTShapeID);
}
