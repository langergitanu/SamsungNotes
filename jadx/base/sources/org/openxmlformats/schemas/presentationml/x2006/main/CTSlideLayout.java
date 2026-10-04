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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMappingOverride;
import org.openxmlformats.schemas.presentationml.x2006.main.STSlideLayoutType;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTSlideLayout extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTSlideLayout.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctslidelayouteb34type");

    public static final class Factory {
        private Factory() {
        }

        public static CTSlideLayout newInstance() {
            return (CTSlideLayout) POIXMLTypeLoader.newInstance(CTSlideLayout.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSlideLayout.type, null);
        }

        public static CTSlideLayout parse(File file) {
            return (CTSlideLayout) POIXMLTypeLoader.parse(file, CTSlideLayout.type, (XmlOptions) null);
        }

        public static CTSlideLayout newInstance(XmlOptions xmlOptions) {
            return (CTSlideLayout) POIXMLTypeLoader.newInstance(CTSlideLayout.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSlideLayout.type, xmlOptions);
        }

        public static CTSlideLayout parse(File file, XmlOptions xmlOptions) {
            return (CTSlideLayout) POIXMLTypeLoader.parse(file, CTSlideLayout.type, xmlOptions);
        }

        public static CTSlideLayout parse(InputStream inputStream) {
            return (CTSlideLayout) POIXMLTypeLoader.parse(inputStream, CTSlideLayout.type, (XmlOptions) null);
        }

        public static CTSlideLayout parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTSlideLayout) POIXMLTypeLoader.parse(inputStream, CTSlideLayout.type, xmlOptions);
        }

        public static CTSlideLayout parse(Reader reader) {
            return (CTSlideLayout) POIXMLTypeLoader.parse(reader, CTSlideLayout.type, (XmlOptions) null);
        }

        public static CTSlideLayout parse(Reader reader, XmlOptions xmlOptions) {
            return (CTSlideLayout) POIXMLTypeLoader.parse(reader, CTSlideLayout.type, xmlOptions);
        }

        public static CTSlideLayout parse(String str) {
            return (CTSlideLayout) POIXMLTypeLoader.parse(str, CTSlideLayout.type, (XmlOptions) null);
        }

        public static CTSlideLayout parse(String str, XmlOptions xmlOptions) {
            return (CTSlideLayout) POIXMLTypeLoader.parse(str, CTSlideLayout.type, xmlOptions);
        }

        public static CTSlideLayout parse(URL url) {
            return (CTSlideLayout) POIXMLTypeLoader.parse(url, CTSlideLayout.type, (XmlOptions) null);
        }

        public static CTSlideLayout parse(URL url, XmlOptions xmlOptions) {
            return (CTSlideLayout) POIXMLTypeLoader.parse(url, CTSlideLayout.type, xmlOptions);
        }

        public static CTSlideLayout parse(XMLStreamReader xMLStreamReader) {
            return (CTSlideLayout) POIXMLTypeLoader.parse(xMLStreamReader, CTSlideLayout.type, (XmlOptions) null);
        }

        public static CTSlideLayout parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTSlideLayout) POIXMLTypeLoader.parse(xMLStreamReader, CTSlideLayout.type, xmlOptions);
        }

        public static CTSlideLayout parse(XMLInputStream xMLInputStream) {
            return (CTSlideLayout) POIXMLTypeLoader.parse(xMLInputStream, CTSlideLayout.type, (XmlOptions) null);
        }

        public static CTSlideLayout parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTSlideLayout) POIXMLTypeLoader.parse(xMLInputStream, CTSlideLayout.type, xmlOptions);
        }

        public static CTSlideLayout parse(Node node) {
            return (CTSlideLayout) POIXMLTypeLoader.parse(node, CTSlideLayout.type, (XmlOptions) null);
        }

        public static CTSlideLayout parse(Node node, XmlOptions xmlOptions) {
            return (CTSlideLayout) POIXMLTypeLoader.parse(node, CTSlideLayout.type, xmlOptions);
        }
    }

    CTCommonSlideData addNewCSld();

    CTColorMappingOverride addNewClrMapOvr();

    CTExtensionListModify addNewExtLst();

    CTHeaderFooter addNewHf();

    CTSlideTiming addNewTiming();

    CTSlideTransition addNewTransition();

    CTCommonSlideData getCSld();

    CTColorMappingOverride getClrMapOvr();

    CTExtensionListModify getExtLst();

    CTHeaderFooter getHf();

    String getMatchingName();

    boolean getPreserve();

    boolean getShowMasterPhAnim();

    boolean getShowMasterSp();

    CTSlideTiming getTiming();

    CTSlideTransition getTransition();

    STSlideLayoutType.Enum getType();

    boolean getUserDrawn();

    boolean isSetClrMapOvr();

    boolean isSetExtLst();

    boolean isSetHf();

    boolean isSetMatchingName();

    boolean isSetPreserve();

    boolean isSetShowMasterPhAnim();

    boolean isSetShowMasterSp();

    boolean isSetTiming();

    boolean isSetTransition();

    boolean isSetType();

    boolean isSetUserDrawn();

    void setCSld(CTCommonSlideData cTCommonSlideData);

    void setClrMapOvr(CTColorMappingOverride cTColorMappingOverride);

    void setExtLst(CTExtensionListModify cTExtensionListModify);

    void setHf(CTHeaderFooter cTHeaderFooter);

    void setMatchingName(String str);

    void setPreserve(boolean z);

    void setShowMasterPhAnim(boolean z);

    void setShowMasterSp(boolean z);

    void setTiming(CTSlideTiming cTSlideTiming);

    void setTransition(CTSlideTransition cTSlideTransition);

    void setType(STSlideLayoutType.Enum r12);

    void setUserDrawn(boolean z);

    void unsetClrMapOvr();

    void unsetExtLst();

    void unsetHf();

    void unsetMatchingName();

    void unsetPreserve();

    void unsetShowMasterPhAnim();

    void unsetShowMasterSp();

    void unsetTiming();

    void unsetTransition();

    void unsetType();

    void unsetUserDrawn();

    XmlString xgetMatchingName();

    XmlBoolean xgetPreserve();

    XmlBoolean xgetShowMasterPhAnim();

    XmlBoolean xgetShowMasterSp();

    STSlideLayoutType xgetType();

    XmlBoolean xgetUserDrawn();

    void xsetMatchingName(XmlString xmlString);

    void xsetPreserve(XmlBoolean xmlBoolean);

    void xsetShowMasterPhAnim(XmlBoolean xmlBoolean);

    void xsetShowMasterSp(XmlBoolean xmlBoolean);

    void xsetType(STSlideLayoutType sTSlideLayoutType);

    void xsetUserDrawn(XmlBoolean xmlBoolean);
}
