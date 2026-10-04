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
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.openxmlformats.schemas.drawingml.x2006.main.STPositiveFixedPercentage;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTTLCommonMediaNodeData extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTLCommonMediaNodeData.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttlcommonmedianodedatab6c2type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTLCommonMediaNodeData newInstance() {
            return (CTTLCommonMediaNodeData) POIXMLTypeLoader.newInstance(CTTLCommonMediaNodeData.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTLCommonMediaNodeData.type, null);
        }

        public static CTTLCommonMediaNodeData parse(File file) {
            return (CTTLCommonMediaNodeData) POIXMLTypeLoader.parse(file, CTTLCommonMediaNodeData.type, (XmlOptions) null);
        }

        public static CTTLCommonMediaNodeData newInstance(XmlOptions xmlOptions) {
            return (CTTLCommonMediaNodeData) POIXMLTypeLoader.newInstance(CTTLCommonMediaNodeData.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTLCommonMediaNodeData.type, xmlOptions);
        }

        public static CTTLCommonMediaNodeData parse(File file, XmlOptions xmlOptions) {
            return (CTTLCommonMediaNodeData) POIXMLTypeLoader.parse(file, CTTLCommonMediaNodeData.type, xmlOptions);
        }

        public static CTTLCommonMediaNodeData parse(InputStream inputStream) {
            return (CTTLCommonMediaNodeData) POIXMLTypeLoader.parse(inputStream, CTTLCommonMediaNodeData.type, (XmlOptions) null);
        }

        public static CTTLCommonMediaNodeData parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTLCommonMediaNodeData) POIXMLTypeLoader.parse(inputStream, CTTLCommonMediaNodeData.type, xmlOptions);
        }

        public static CTTLCommonMediaNodeData parse(Reader reader) {
            return (CTTLCommonMediaNodeData) POIXMLTypeLoader.parse(reader, CTTLCommonMediaNodeData.type, (XmlOptions) null);
        }

        public static CTTLCommonMediaNodeData parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTLCommonMediaNodeData) POIXMLTypeLoader.parse(reader, CTTLCommonMediaNodeData.type, xmlOptions);
        }

        public static CTTLCommonMediaNodeData parse(String str) {
            return (CTTLCommonMediaNodeData) POIXMLTypeLoader.parse(str, CTTLCommonMediaNodeData.type, (XmlOptions) null);
        }

        public static CTTLCommonMediaNodeData parse(String str, XmlOptions xmlOptions) {
            return (CTTLCommonMediaNodeData) POIXMLTypeLoader.parse(str, CTTLCommonMediaNodeData.type, xmlOptions);
        }

        public static CTTLCommonMediaNodeData parse(URL url) {
            return (CTTLCommonMediaNodeData) POIXMLTypeLoader.parse(url, CTTLCommonMediaNodeData.type, (XmlOptions) null);
        }

        public static CTTLCommonMediaNodeData parse(URL url, XmlOptions xmlOptions) {
            return (CTTLCommonMediaNodeData) POIXMLTypeLoader.parse(url, CTTLCommonMediaNodeData.type, xmlOptions);
        }

        public static CTTLCommonMediaNodeData parse(XMLStreamReader xMLStreamReader) {
            return (CTTLCommonMediaNodeData) POIXMLTypeLoader.parse(xMLStreamReader, CTTLCommonMediaNodeData.type, (XmlOptions) null);
        }

        public static CTTLCommonMediaNodeData parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTLCommonMediaNodeData) POIXMLTypeLoader.parse(xMLStreamReader, CTTLCommonMediaNodeData.type, xmlOptions);
        }

        public static CTTLCommonMediaNodeData parse(XMLInputStream xMLInputStream) {
            return (CTTLCommonMediaNodeData) POIXMLTypeLoader.parse(xMLInputStream, CTTLCommonMediaNodeData.type, (XmlOptions) null);
        }

        public static CTTLCommonMediaNodeData parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTLCommonMediaNodeData) POIXMLTypeLoader.parse(xMLInputStream, CTTLCommonMediaNodeData.type, xmlOptions);
        }

        public static CTTLCommonMediaNodeData parse(Node node) {
            return (CTTLCommonMediaNodeData) POIXMLTypeLoader.parse(node, CTTLCommonMediaNodeData.type, (XmlOptions) null);
        }

        public static CTTLCommonMediaNodeData parse(Node node, XmlOptions xmlOptions) {
            return (CTTLCommonMediaNodeData) POIXMLTypeLoader.parse(node, CTTLCommonMediaNodeData.type, xmlOptions);
        }
    }

    CTTLCommonTimeNodeData addNewCTn();

    CTTLTimeTargetElement addNewTgtEl();

    CTTLCommonTimeNodeData getCTn();

    boolean getMute();

    long getNumSld();

    boolean getShowWhenStopped();

    CTTLTimeTargetElement getTgtEl();

    int getVol();

    boolean isSetMute();

    boolean isSetNumSld();

    boolean isSetShowWhenStopped();

    boolean isSetVol();

    void setCTn(CTTLCommonTimeNodeData cTTLCommonTimeNodeData);

    void setMute(boolean z);

    void setNumSld(long j);

    void setShowWhenStopped(boolean z);

    void setTgtEl(CTTLTimeTargetElement cTTLTimeTargetElement);

    void setVol(int i);

    void unsetMute();

    void unsetNumSld();

    void unsetShowWhenStopped();

    void unsetVol();

    XmlBoolean xgetMute();

    XmlUnsignedInt xgetNumSld();

    XmlBoolean xgetShowWhenStopped();

    STPositiveFixedPercentage xgetVol();

    void xsetMute(XmlBoolean xmlBoolean);

    void xsetNumSld(XmlUnsignedInt xmlUnsignedInt);

    void xsetShowWhenStopped(XmlBoolean xmlBoolean);

    void xsetVol(STPositiveFixedPercentage sTPositiveFixedPercentage);
}
