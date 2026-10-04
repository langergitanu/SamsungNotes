package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STFldCharType;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTFldChar extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTFldChar.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctfldchare83etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTFldChar newInstance() {
            return (CTFldChar) POIXMLTypeLoader.newInstance(CTFldChar.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFldChar.type, null);
        }

        public static CTFldChar parse(File file) {
            return (CTFldChar) POIXMLTypeLoader.parse(file, CTFldChar.type, (XmlOptions) null);
        }

        public static CTFldChar newInstance(XmlOptions xmlOptions) {
            return (CTFldChar) POIXMLTypeLoader.newInstance(CTFldChar.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFldChar.type, xmlOptions);
        }

        public static CTFldChar parse(File file, XmlOptions xmlOptions) {
            return (CTFldChar) POIXMLTypeLoader.parse(file, CTFldChar.type, xmlOptions);
        }

        public static CTFldChar parse(InputStream inputStream) {
            return (CTFldChar) POIXMLTypeLoader.parse(inputStream, CTFldChar.type, (XmlOptions) null);
        }

        public static CTFldChar parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTFldChar) POIXMLTypeLoader.parse(inputStream, CTFldChar.type, xmlOptions);
        }

        public static CTFldChar parse(Reader reader) {
            return (CTFldChar) POIXMLTypeLoader.parse(reader, CTFldChar.type, (XmlOptions) null);
        }

        public static CTFldChar parse(Reader reader, XmlOptions xmlOptions) {
            return (CTFldChar) POIXMLTypeLoader.parse(reader, CTFldChar.type, xmlOptions);
        }

        public static CTFldChar parse(String str) {
            return (CTFldChar) POIXMLTypeLoader.parse(str, CTFldChar.type, (XmlOptions) null);
        }

        public static CTFldChar parse(String str, XmlOptions xmlOptions) {
            return (CTFldChar) POIXMLTypeLoader.parse(str, CTFldChar.type, xmlOptions);
        }

        public static CTFldChar parse(URL url) {
            return (CTFldChar) POIXMLTypeLoader.parse(url, CTFldChar.type, (XmlOptions) null);
        }

        public static CTFldChar parse(URL url, XmlOptions xmlOptions) {
            return (CTFldChar) POIXMLTypeLoader.parse(url, CTFldChar.type, xmlOptions);
        }

        public static CTFldChar parse(XMLStreamReader xMLStreamReader) {
            return (CTFldChar) POIXMLTypeLoader.parse(xMLStreamReader, CTFldChar.type, (XmlOptions) null);
        }

        public static CTFldChar parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTFldChar) POIXMLTypeLoader.parse(xMLStreamReader, CTFldChar.type, xmlOptions);
        }

        public static CTFldChar parse(XMLInputStream xMLInputStream) {
            return (CTFldChar) POIXMLTypeLoader.parse(xMLInputStream, CTFldChar.type, (XmlOptions) null);
        }

        public static CTFldChar parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTFldChar) POIXMLTypeLoader.parse(xMLInputStream, CTFldChar.type, xmlOptions);
        }

        public static CTFldChar parse(Node node) {
            return (CTFldChar) POIXMLTypeLoader.parse(node, CTFldChar.type, (XmlOptions) null);
        }

        public static CTFldChar parse(Node node, XmlOptions xmlOptions) {
            return (CTFldChar) POIXMLTypeLoader.parse(node, CTFldChar.type, xmlOptions);
        }
    }

    CTFFData addNewFfData();

    CTText addNewFldData();

    CTTrackChangeNumbering addNewNumberingChange();

    STOnOff.Enum getDirty();

    CTFFData getFfData();

    STFldCharType.Enum getFldCharType();

    CTText getFldData();

    STOnOff.Enum getFldLock();

    CTTrackChangeNumbering getNumberingChange();

    boolean isSetDirty();

    boolean isSetFfData();

    boolean isSetFldData();

    boolean isSetFldLock();

    boolean isSetNumberingChange();

    void setDirty(STOnOff.Enum r12);

    void setFfData(CTFFData cTFFData);

    void setFldCharType(STFldCharType.Enum r12);

    void setFldData(CTText cTText);

    void setFldLock(STOnOff.Enum r12);

    void setNumberingChange(CTTrackChangeNumbering cTTrackChangeNumbering);

    void unsetDirty();

    void unsetFfData();

    void unsetFldData();

    void unsetFldLock();

    void unsetNumberingChange();

    STOnOff xgetDirty();

    STFldCharType xgetFldCharType();

    STOnOff xgetFldLock();

    void xsetDirty(STOnOff sTOnOff);

    void xsetFldCharType(STFldCharType sTFldCharType);

    void xsetFldLock(STOnOff sTOnOff);
}
