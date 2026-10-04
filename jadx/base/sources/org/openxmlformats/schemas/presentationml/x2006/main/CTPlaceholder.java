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
import org.openxmlformats.schemas.presentationml.x2006.main.STDirection;
import org.openxmlformats.schemas.presentationml.x2006.main.STPlaceholderType;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTPlaceholder extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTPlaceholder.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctplaceholder9efctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTPlaceholder newInstance() {
            return (CTPlaceholder) POIXMLTypeLoader.newInstance(CTPlaceholder.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPlaceholder.type, null);
        }

        public static CTPlaceholder parse(File file) {
            return (CTPlaceholder) POIXMLTypeLoader.parse(file, CTPlaceholder.type, (XmlOptions) null);
        }

        public static CTPlaceholder newInstance(XmlOptions xmlOptions) {
            return (CTPlaceholder) POIXMLTypeLoader.newInstance(CTPlaceholder.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPlaceholder.type, xmlOptions);
        }

        public static CTPlaceholder parse(File file, XmlOptions xmlOptions) {
            return (CTPlaceholder) POIXMLTypeLoader.parse(file, CTPlaceholder.type, xmlOptions);
        }

        public static CTPlaceholder parse(InputStream inputStream) {
            return (CTPlaceholder) POIXMLTypeLoader.parse(inputStream, CTPlaceholder.type, (XmlOptions) null);
        }

        public static CTPlaceholder parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTPlaceholder) POIXMLTypeLoader.parse(inputStream, CTPlaceholder.type, xmlOptions);
        }

        public static CTPlaceholder parse(Reader reader) {
            return (CTPlaceholder) POIXMLTypeLoader.parse(reader, CTPlaceholder.type, (XmlOptions) null);
        }

        public static CTPlaceholder parse(Reader reader, XmlOptions xmlOptions) {
            return (CTPlaceholder) POIXMLTypeLoader.parse(reader, CTPlaceholder.type, xmlOptions);
        }

        public static CTPlaceholder parse(String str) {
            return (CTPlaceholder) POIXMLTypeLoader.parse(str, CTPlaceholder.type, (XmlOptions) null);
        }

        public static CTPlaceholder parse(String str, XmlOptions xmlOptions) {
            return (CTPlaceholder) POIXMLTypeLoader.parse(str, CTPlaceholder.type, xmlOptions);
        }

        public static CTPlaceholder parse(URL url) {
            return (CTPlaceholder) POIXMLTypeLoader.parse(url, CTPlaceholder.type, (XmlOptions) null);
        }

        public static CTPlaceholder parse(URL url, XmlOptions xmlOptions) {
            return (CTPlaceholder) POIXMLTypeLoader.parse(url, CTPlaceholder.type, xmlOptions);
        }

        public static CTPlaceholder parse(XMLStreamReader xMLStreamReader) {
            return (CTPlaceholder) POIXMLTypeLoader.parse(xMLStreamReader, CTPlaceholder.type, (XmlOptions) null);
        }

        public static CTPlaceholder parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTPlaceholder) POIXMLTypeLoader.parse(xMLStreamReader, CTPlaceholder.type, xmlOptions);
        }

        public static CTPlaceholder parse(XMLInputStream xMLInputStream) {
            return (CTPlaceholder) POIXMLTypeLoader.parse(xMLInputStream, CTPlaceholder.type, (XmlOptions) null);
        }

        public static CTPlaceholder parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTPlaceholder) POIXMLTypeLoader.parse(xMLInputStream, CTPlaceholder.type, xmlOptions);
        }

        public static CTPlaceholder parse(Node node) {
            return (CTPlaceholder) POIXMLTypeLoader.parse(node, CTPlaceholder.type, (XmlOptions) null);
        }

        public static CTPlaceholder parse(Node node, XmlOptions xmlOptions) {
            return (CTPlaceholder) POIXMLTypeLoader.parse(node, CTPlaceholder.type, xmlOptions);
        }
    }

    CTExtensionListModify addNewExtLst();

    CTExtensionListModify getExtLst();

    boolean getHasCustomPrompt();

    long getIdx();

    STDirection.Enum getOrient();

    STPlaceholderSize$Enum getSz();

    STPlaceholderType.Enum getType();

    boolean isSetExtLst();

    boolean isSetHasCustomPrompt();

    boolean isSetIdx();

    boolean isSetOrient();

    boolean isSetSz();

    boolean isSetType();

    void setExtLst(CTExtensionListModify cTExtensionListModify);

    void setHasCustomPrompt(boolean z);

    void setIdx(long j);

    void setOrient(STDirection.Enum r12);

    void setSz(STPlaceholderSize$Enum sTPlaceholderSize$Enum);

    void setType(STPlaceholderType.Enum r12);

    void unsetExtLst();

    void unsetHasCustomPrompt();

    void unsetIdx();

    void unsetOrient();

    void unsetSz();

    void unsetType();

    XmlBoolean xgetHasCustomPrompt();

    XmlUnsignedInt xgetIdx();

    STDirection xgetOrient();

    STPlaceholderSize xgetSz();

    STPlaceholderType xgetType();

    void xsetHasCustomPrompt(XmlBoolean xmlBoolean);

    void xsetIdx(XmlUnsignedInt xmlUnsignedInt);

    void xsetOrient(STDirection sTDirection);

    void xsetSz(STPlaceholderSize sTPlaceholderSize);

    void xsetType(STPlaceholderType sTPlaceholderType);
}
