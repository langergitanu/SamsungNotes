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
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTSlide extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTSlide.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctslided7betype");

    public static final class Factory {
        private Factory() {
        }

        public static CTSlide newInstance() {
            return (CTSlide) POIXMLTypeLoader.newInstance(CTSlide.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSlide.type, null);
        }

        public static CTSlide parse(File file) {
            return (CTSlide) POIXMLTypeLoader.parse(file, CTSlide.type, (XmlOptions) null);
        }

        public static CTSlide newInstance(XmlOptions xmlOptions) {
            return (CTSlide) POIXMLTypeLoader.newInstance(CTSlide.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSlide.type, xmlOptions);
        }

        public static CTSlide parse(File file, XmlOptions xmlOptions) {
            return (CTSlide) POIXMLTypeLoader.parse(file, CTSlide.type, xmlOptions);
        }

        public static CTSlide parse(InputStream inputStream) {
            return (CTSlide) POIXMLTypeLoader.parse(inputStream, CTSlide.type, (XmlOptions) null);
        }

        public static CTSlide parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTSlide) POIXMLTypeLoader.parse(inputStream, CTSlide.type, xmlOptions);
        }

        public static CTSlide parse(Reader reader) {
            return (CTSlide) POIXMLTypeLoader.parse(reader, CTSlide.type, (XmlOptions) null);
        }

        public static CTSlide parse(Reader reader, XmlOptions xmlOptions) {
            return (CTSlide) POIXMLTypeLoader.parse(reader, CTSlide.type, xmlOptions);
        }

        public static CTSlide parse(String str) {
            return (CTSlide) POIXMLTypeLoader.parse(str, CTSlide.type, (XmlOptions) null);
        }

        public static CTSlide parse(String str, XmlOptions xmlOptions) {
            return (CTSlide) POIXMLTypeLoader.parse(str, CTSlide.type, xmlOptions);
        }

        public static CTSlide parse(URL url) {
            return (CTSlide) POIXMLTypeLoader.parse(url, CTSlide.type, (XmlOptions) null);
        }

        public static CTSlide parse(URL url, XmlOptions xmlOptions) {
            return (CTSlide) POIXMLTypeLoader.parse(url, CTSlide.type, xmlOptions);
        }

        public static CTSlide parse(XMLStreamReader xMLStreamReader) {
            return (CTSlide) POIXMLTypeLoader.parse(xMLStreamReader, CTSlide.type, (XmlOptions) null);
        }

        public static CTSlide parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTSlide) POIXMLTypeLoader.parse(xMLStreamReader, CTSlide.type, xmlOptions);
        }

        public static CTSlide parse(XMLInputStream xMLInputStream) {
            return (CTSlide) POIXMLTypeLoader.parse(xMLInputStream, CTSlide.type, (XmlOptions) null);
        }

        public static CTSlide parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTSlide) POIXMLTypeLoader.parse(xMLInputStream, CTSlide.type, xmlOptions);
        }

        public static CTSlide parse(Node node) {
            return (CTSlide) POIXMLTypeLoader.parse(node, CTSlide.type, (XmlOptions) null);
        }

        public static CTSlide parse(Node node, XmlOptions xmlOptions) {
            return (CTSlide) POIXMLTypeLoader.parse(node, CTSlide.type, xmlOptions);
        }
    }

    CTCommonSlideData addNewCSld();

    CTColorMappingOverride addNewClrMapOvr();

    CTExtensionListModify addNewExtLst();

    CTSlideTiming addNewTiming();

    CTSlideTransition addNewTransition();

    CTCommonSlideData getCSld();

    CTColorMappingOverride getClrMapOvr();

    CTExtensionListModify getExtLst();

    boolean getShow();

    boolean getShowMasterPhAnim();

    boolean getShowMasterSp();

    CTSlideTiming getTiming();

    CTSlideTransition getTransition();

    boolean isSetClrMapOvr();

    boolean isSetExtLst();

    boolean isSetShow();

    boolean isSetShowMasterPhAnim();

    boolean isSetShowMasterSp();

    boolean isSetTiming();

    boolean isSetTransition();

    void setCSld(CTCommonSlideData cTCommonSlideData);

    void setClrMapOvr(CTColorMappingOverride cTColorMappingOverride);

    void setExtLst(CTExtensionListModify cTExtensionListModify);

    void setShow(boolean z);

    void setShowMasterPhAnim(boolean z);

    void setShowMasterSp(boolean z);

    void setTiming(CTSlideTiming cTSlideTiming);

    void setTransition(CTSlideTransition cTSlideTransition);

    void unsetClrMapOvr();

    void unsetExtLst();

    void unsetShow();

    void unsetShowMasterPhAnim();

    void unsetShowMasterSp();

    void unsetTiming();

    void unsetTransition();

    XmlBoolean xgetShow();

    XmlBoolean xgetShowMasterPhAnim();

    XmlBoolean xgetShowMasterSp();

    void xsetShow(XmlBoolean xmlBoolean);

    void xsetShowMasterPhAnim(XmlBoolean xmlBoolean);

    void xsetShowMasterSp(XmlBoolean xmlBoolean);
}
