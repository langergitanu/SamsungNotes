package org.openxmlformats.schemas.presentationml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAudioCD;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAudioFile;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEmbeddedWAVAudioFile;
import org.openxmlformats.schemas.drawingml.x2006.main.CTQuickTimeFile;
import org.openxmlformats.schemas.drawingml.x2006.main.CTVideoFile;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTApplicationNonVisualDrawingProps extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTApplicationNonVisualDrawingProps.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctapplicationnonvisualdrawingprops2fb6type");

    public static final class Factory {
        private Factory() {
        }

        public static CTApplicationNonVisualDrawingProps newInstance() {
            return (CTApplicationNonVisualDrawingProps) POIXMLTypeLoader.newInstance(CTApplicationNonVisualDrawingProps.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTApplicationNonVisualDrawingProps.type, null);
        }

        public static CTApplicationNonVisualDrawingProps parse(File file) {
            return (CTApplicationNonVisualDrawingProps) POIXMLTypeLoader.parse(file, CTApplicationNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTApplicationNonVisualDrawingProps newInstance(XmlOptions xmlOptions) {
            return (CTApplicationNonVisualDrawingProps) POIXMLTypeLoader.newInstance(CTApplicationNonVisualDrawingProps.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTApplicationNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTApplicationNonVisualDrawingProps parse(File file, XmlOptions xmlOptions) {
            return (CTApplicationNonVisualDrawingProps) POIXMLTypeLoader.parse(file, CTApplicationNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTApplicationNonVisualDrawingProps parse(InputStream inputStream) {
            return (CTApplicationNonVisualDrawingProps) POIXMLTypeLoader.parse(inputStream, CTApplicationNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTApplicationNonVisualDrawingProps parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTApplicationNonVisualDrawingProps) POIXMLTypeLoader.parse(inputStream, CTApplicationNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTApplicationNonVisualDrawingProps parse(Reader reader) {
            return (CTApplicationNonVisualDrawingProps) POIXMLTypeLoader.parse(reader, CTApplicationNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTApplicationNonVisualDrawingProps parse(Reader reader, XmlOptions xmlOptions) {
            return (CTApplicationNonVisualDrawingProps) POIXMLTypeLoader.parse(reader, CTApplicationNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTApplicationNonVisualDrawingProps parse(String str) {
            return (CTApplicationNonVisualDrawingProps) POIXMLTypeLoader.parse(str, CTApplicationNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTApplicationNonVisualDrawingProps parse(String str, XmlOptions xmlOptions) {
            return (CTApplicationNonVisualDrawingProps) POIXMLTypeLoader.parse(str, CTApplicationNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTApplicationNonVisualDrawingProps parse(URL url) {
            return (CTApplicationNonVisualDrawingProps) POIXMLTypeLoader.parse(url, CTApplicationNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTApplicationNonVisualDrawingProps parse(URL url, XmlOptions xmlOptions) {
            return (CTApplicationNonVisualDrawingProps) POIXMLTypeLoader.parse(url, CTApplicationNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTApplicationNonVisualDrawingProps parse(XMLStreamReader xMLStreamReader) {
            return (CTApplicationNonVisualDrawingProps) POIXMLTypeLoader.parse(xMLStreamReader, CTApplicationNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTApplicationNonVisualDrawingProps parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTApplicationNonVisualDrawingProps) POIXMLTypeLoader.parse(xMLStreamReader, CTApplicationNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTApplicationNonVisualDrawingProps parse(XMLInputStream xMLInputStream) {
            return (CTApplicationNonVisualDrawingProps) POIXMLTypeLoader.parse(xMLInputStream, CTApplicationNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTApplicationNonVisualDrawingProps parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTApplicationNonVisualDrawingProps) POIXMLTypeLoader.parse(xMLInputStream, CTApplicationNonVisualDrawingProps.type, xmlOptions);
        }

        public static CTApplicationNonVisualDrawingProps parse(Node node) {
            return (CTApplicationNonVisualDrawingProps) POIXMLTypeLoader.parse(node, CTApplicationNonVisualDrawingProps.type, (XmlOptions) null);
        }

        public static CTApplicationNonVisualDrawingProps parse(Node node, XmlOptions xmlOptions) {
            return (CTApplicationNonVisualDrawingProps) POIXMLTypeLoader.parse(node, CTApplicationNonVisualDrawingProps.type, xmlOptions);
        }
    }

    CTAudioCD addNewAudioCd();

    CTAudioFile addNewAudioFile();

    CTCustomerDataList addNewCustDataLst();

    CTExtensionList addNewExtLst();

    CTPlaceholder addNewPh();

    CTQuickTimeFile addNewQuickTimeFile();

    CTVideoFile addNewVideoFile();

    CTEmbeddedWAVAudioFile addNewWavAudioFile();

    CTAudioCD getAudioCd();

    CTAudioFile getAudioFile();

    CTCustomerDataList getCustDataLst();

    CTExtensionList getExtLst();

    boolean getIsPhoto();

    CTPlaceholder getPh();

    CTQuickTimeFile getQuickTimeFile();

    boolean getUserDrawn();

    CTVideoFile getVideoFile();

    CTEmbeddedWAVAudioFile getWavAudioFile();

    boolean isSetAudioCd();

    boolean isSetAudioFile();

    boolean isSetCustDataLst();

    boolean isSetExtLst();

    boolean isSetIsPhoto();

    boolean isSetPh();

    boolean isSetQuickTimeFile();

    boolean isSetUserDrawn();

    boolean isSetVideoFile();

    boolean isSetWavAudioFile();

    void setAudioCd(CTAudioCD cTAudioCD);

    void setAudioFile(CTAudioFile cTAudioFile);

    void setCustDataLst(CTCustomerDataList cTCustomerDataList);

    void setExtLst(CTExtensionList cTExtensionList);

    void setIsPhoto(boolean z);

    void setPh(CTPlaceholder cTPlaceholder);

    void setQuickTimeFile(CTQuickTimeFile cTQuickTimeFile);

    void setUserDrawn(boolean z);

    void setVideoFile(CTVideoFile cTVideoFile);

    void setWavAudioFile(CTEmbeddedWAVAudioFile cTEmbeddedWAVAudioFile);

    void unsetAudioCd();

    void unsetAudioFile();

    void unsetCustDataLst();

    void unsetExtLst();

    void unsetIsPhoto();

    void unsetPh();

    void unsetQuickTimeFile();

    void unsetUserDrawn();

    void unsetVideoFile();

    void unsetWavAudioFile();

    XmlBoolean xgetIsPhoto();

    XmlBoolean xgetUserDrawn();

    void xsetIsPhoto(XmlBoolean xmlBoolean);

    void xsetUserDrawn(XmlBoolean xmlBoolean);
}
