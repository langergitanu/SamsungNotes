package org.openxmlformats.schemas.drawingml.x2006.main;

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
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTGraphicalObjectFrameLocking extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTGraphicalObjectFrameLocking.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctgraphicalobjectframelocking42adtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTGraphicalObjectFrameLocking newInstance() {
            return (CTGraphicalObjectFrameLocking) POIXMLTypeLoader.newInstance(CTGraphicalObjectFrameLocking.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGraphicalObjectFrameLocking.type, null);
        }

        public static CTGraphicalObjectFrameLocking parse(File file) {
            return (CTGraphicalObjectFrameLocking) POIXMLTypeLoader.parse(file, CTGraphicalObjectFrameLocking.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameLocking newInstance(XmlOptions xmlOptions) {
            return (CTGraphicalObjectFrameLocking) POIXMLTypeLoader.newInstance(CTGraphicalObjectFrameLocking.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGraphicalObjectFrameLocking.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameLocking parse(File file, XmlOptions xmlOptions) {
            return (CTGraphicalObjectFrameLocking) POIXMLTypeLoader.parse(file, CTGraphicalObjectFrameLocking.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameLocking parse(InputStream inputStream) {
            return (CTGraphicalObjectFrameLocking) POIXMLTypeLoader.parse(inputStream, CTGraphicalObjectFrameLocking.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameLocking parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTGraphicalObjectFrameLocking) POIXMLTypeLoader.parse(inputStream, CTGraphicalObjectFrameLocking.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameLocking parse(Reader reader) {
            return (CTGraphicalObjectFrameLocking) POIXMLTypeLoader.parse(reader, CTGraphicalObjectFrameLocking.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameLocking parse(Reader reader, XmlOptions xmlOptions) {
            return (CTGraphicalObjectFrameLocking) POIXMLTypeLoader.parse(reader, CTGraphicalObjectFrameLocking.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameLocking parse(String str) {
            return (CTGraphicalObjectFrameLocking) POIXMLTypeLoader.parse(str, CTGraphicalObjectFrameLocking.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameLocking parse(String str, XmlOptions xmlOptions) {
            return (CTGraphicalObjectFrameLocking) POIXMLTypeLoader.parse(str, CTGraphicalObjectFrameLocking.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameLocking parse(URL url) {
            return (CTGraphicalObjectFrameLocking) POIXMLTypeLoader.parse(url, CTGraphicalObjectFrameLocking.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameLocking parse(URL url, XmlOptions xmlOptions) {
            return (CTGraphicalObjectFrameLocking) POIXMLTypeLoader.parse(url, CTGraphicalObjectFrameLocking.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameLocking parse(XMLStreamReader xMLStreamReader) {
            return (CTGraphicalObjectFrameLocking) POIXMLTypeLoader.parse(xMLStreamReader, CTGraphicalObjectFrameLocking.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameLocking parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTGraphicalObjectFrameLocking) POIXMLTypeLoader.parse(xMLStreamReader, CTGraphicalObjectFrameLocking.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameLocking parse(XMLInputStream xMLInputStream) {
            return (CTGraphicalObjectFrameLocking) POIXMLTypeLoader.parse(xMLInputStream, CTGraphicalObjectFrameLocking.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameLocking parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTGraphicalObjectFrameLocking) POIXMLTypeLoader.parse(xMLInputStream, CTGraphicalObjectFrameLocking.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameLocking parse(Node node) {
            return (CTGraphicalObjectFrameLocking) POIXMLTypeLoader.parse(node, CTGraphicalObjectFrameLocking.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameLocking parse(Node node, XmlOptions xmlOptions) {
            return (CTGraphicalObjectFrameLocking) POIXMLTypeLoader.parse(node, CTGraphicalObjectFrameLocking.type, xmlOptions);
        }
    }

    CTOfficeArtExtensionList addNewExtLst();

    CTOfficeArtExtensionList getExtLst();

    boolean getNoChangeAspect();

    boolean getNoDrilldown();

    boolean getNoGrp();

    boolean getNoMove();

    boolean getNoResize();

    boolean getNoSelect();

    boolean isSetExtLst();

    boolean isSetNoChangeAspect();

    boolean isSetNoDrilldown();

    boolean isSetNoGrp();

    boolean isSetNoMove();

    boolean isSetNoResize();

    boolean isSetNoSelect();

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setNoChangeAspect(boolean z);

    void setNoDrilldown(boolean z);

    void setNoGrp(boolean z);

    void setNoMove(boolean z);

    void setNoResize(boolean z);

    void setNoSelect(boolean z);

    void unsetExtLst();

    void unsetNoChangeAspect();

    void unsetNoDrilldown();

    void unsetNoGrp();

    void unsetNoMove();

    void unsetNoResize();

    void unsetNoSelect();

    XmlBoolean xgetNoChangeAspect();

    XmlBoolean xgetNoDrilldown();

    XmlBoolean xgetNoGrp();

    XmlBoolean xgetNoMove();

    XmlBoolean xgetNoResize();

    XmlBoolean xgetNoSelect();

    void xsetNoChangeAspect(XmlBoolean xmlBoolean);

    void xsetNoDrilldown(XmlBoolean xmlBoolean);

    void xsetNoGrp(XmlBoolean xmlBoolean);

    void xsetNoMove(XmlBoolean xmlBoolean);

    void xsetNoResize(XmlBoolean xmlBoolean);

    void xsetNoSelect(XmlBoolean xmlBoolean);
}
