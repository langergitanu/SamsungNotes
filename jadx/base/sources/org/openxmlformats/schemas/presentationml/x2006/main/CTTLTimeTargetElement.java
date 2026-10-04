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
import org.openxmlformats.schemas.drawingml.x2006.main.CTEmbeddedWAVAudioFile;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTTLTimeTargetElement extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTLTimeTargetElement.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttltimetargetelementdca9type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTLTimeTargetElement newInstance() {
            return (CTTLTimeTargetElement) POIXMLTypeLoader.newInstance(CTTLTimeTargetElement.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTLTimeTargetElement.type, null);
        }

        public static CTTLTimeTargetElement parse(File file) {
            return (CTTLTimeTargetElement) POIXMLTypeLoader.parse(file, CTTLTimeTargetElement.type, (XmlOptions) null);
        }

        public static CTTLTimeTargetElement newInstance(XmlOptions xmlOptions) {
            return (CTTLTimeTargetElement) POIXMLTypeLoader.newInstance(CTTLTimeTargetElement.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTLTimeTargetElement.type, xmlOptions);
        }

        public static CTTLTimeTargetElement parse(File file, XmlOptions xmlOptions) {
            return (CTTLTimeTargetElement) POIXMLTypeLoader.parse(file, CTTLTimeTargetElement.type, xmlOptions);
        }

        public static CTTLTimeTargetElement parse(InputStream inputStream) {
            return (CTTLTimeTargetElement) POIXMLTypeLoader.parse(inputStream, CTTLTimeTargetElement.type, (XmlOptions) null);
        }

        public static CTTLTimeTargetElement parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTLTimeTargetElement) POIXMLTypeLoader.parse(inputStream, CTTLTimeTargetElement.type, xmlOptions);
        }

        public static CTTLTimeTargetElement parse(Reader reader) {
            return (CTTLTimeTargetElement) POIXMLTypeLoader.parse(reader, CTTLTimeTargetElement.type, (XmlOptions) null);
        }

        public static CTTLTimeTargetElement parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTLTimeTargetElement) POIXMLTypeLoader.parse(reader, CTTLTimeTargetElement.type, xmlOptions);
        }

        public static CTTLTimeTargetElement parse(String str) {
            return (CTTLTimeTargetElement) POIXMLTypeLoader.parse(str, CTTLTimeTargetElement.type, (XmlOptions) null);
        }

        public static CTTLTimeTargetElement parse(String str, XmlOptions xmlOptions) {
            return (CTTLTimeTargetElement) POIXMLTypeLoader.parse(str, CTTLTimeTargetElement.type, xmlOptions);
        }

        public static CTTLTimeTargetElement parse(URL url) {
            return (CTTLTimeTargetElement) POIXMLTypeLoader.parse(url, CTTLTimeTargetElement.type, (XmlOptions) null);
        }

        public static CTTLTimeTargetElement parse(URL url, XmlOptions xmlOptions) {
            return (CTTLTimeTargetElement) POIXMLTypeLoader.parse(url, CTTLTimeTargetElement.type, xmlOptions);
        }

        public static CTTLTimeTargetElement parse(XMLStreamReader xMLStreamReader) {
            return (CTTLTimeTargetElement) POIXMLTypeLoader.parse(xMLStreamReader, CTTLTimeTargetElement.type, (XmlOptions) null);
        }

        public static CTTLTimeTargetElement parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTLTimeTargetElement) POIXMLTypeLoader.parse(xMLStreamReader, CTTLTimeTargetElement.type, xmlOptions);
        }

        public static CTTLTimeTargetElement parse(XMLInputStream xMLInputStream) {
            return (CTTLTimeTargetElement) POIXMLTypeLoader.parse(xMLInputStream, CTTLTimeTargetElement.type, (XmlOptions) null);
        }

        public static CTTLTimeTargetElement parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTLTimeTargetElement) POIXMLTypeLoader.parse(xMLInputStream, CTTLTimeTargetElement.type, xmlOptions);
        }

        public static CTTLTimeTargetElement parse(Node node) {
            return (CTTLTimeTargetElement) POIXMLTypeLoader.parse(node, CTTLTimeTargetElement.type, (XmlOptions) null);
        }

        public static CTTLTimeTargetElement parse(Node node, XmlOptions xmlOptions) {
            return (CTTLTimeTargetElement) POIXMLTypeLoader.parse(node, CTTLTimeTargetElement.type, xmlOptions);
        }
    }

    CTTLSubShapeId addNewInkTgt();

    CTEmpty addNewSldTgt();

    CTEmbeddedWAVAudioFile addNewSndTgt();

    CTTLShapeTargetElement addNewSpTgt();

    CTTLSubShapeId getInkTgt();

    CTEmpty getSldTgt();

    CTEmbeddedWAVAudioFile getSndTgt();

    CTTLShapeTargetElement getSpTgt();

    boolean isSetInkTgt();

    boolean isSetSldTgt();

    boolean isSetSndTgt();

    boolean isSetSpTgt();

    void setInkTgt(CTTLSubShapeId cTTLSubShapeId);

    void setSldTgt(CTEmpty cTEmpty);

    void setSndTgt(CTEmbeddedWAVAudioFile cTEmbeddedWAVAudioFile);

    void setSpTgt(CTTLShapeTargetElement cTTLShapeTargetElement);

    void unsetInkTgt();

    void unsetSldTgt();

    void unsetSndTgt();

    void unsetSpTgt();
}
