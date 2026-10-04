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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STThemeColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STUnderline;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTUnderline extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTUnderline.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctunderline8406type");

    public static final class Factory {
        private Factory() {
        }

        public static CTUnderline newInstance() {
            return (CTUnderline) POIXMLTypeLoader.newInstance(CTUnderline.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTUnderline.type, null);
        }

        public static CTUnderline parse(File file) {
            return (CTUnderline) POIXMLTypeLoader.parse(file, CTUnderline.type, (XmlOptions) null);
        }

        public static CTUnderline newInstance(XmlOptions xmlOptions) {
            return (CTUnderline) POIXMLTypeLoader.newInstance(CTUnderline.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTUnderline.type, xmlOptions);
        }

        public static CTUnderline parse(File file, XmlOptions xmlOptions) {
            return (CTUnderline) POIXMLTypeLoader.parse(file, CTUnderline.type, xmlOptions);
        }

        public static CTUnderline parse(InputStream inputStream) {
            return (CTUnderline) POIXMLTypeLoader.parse(inputStream, CTUnderline.type, (XmlOptions) null);
        }

        public static CTUnderline parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTUnderline) POIXMLTypeLoader.parse(inputStream, CTUnderline.type, xmlOptions);
        }

        public static CTUnderline parse(Reader reader) {
            return (CTUnderline) POIXMLTypeLoader.parse(reader, CTUnderline.type, (XmlOptions) null);
        }

        public static CTUnderline parse(Reader reader, XmlOptions xmlOptions) {
            return (CTUnderline) POIXMLTypeLoader.parse(reader, CTUnderline.type, xmlOptions);
        }

        public static CTUnderline parse(String str) {
            return (CTUnderline) POIXMLTypeLoader.parse(str, CTUnderline.type, (XmlOptions) null);
        }

        public static CTUnderline parse(String str, XmlOptions xmlOptions) {
            return (CTUnderline) POIXMLTypeLoader.parse(str, CTUnderline.type, xmlOptions);
        }

        public static CTUnderline parse(URL url) {
            return (CTUnderline) POIXMLTypeLoader.parse(url, CTUnderline.type, (XmlOptions) null);
        }

        public static CTUnderline parse(URL url, XmlOptions xmlOptions) {
            return (CTUnderline) POIXMLTypeLoader.parse(url, CTUnderline.type, xmlOptions);
        }

        public static CTUnderline parse(XMLStreamReader xMLStreamReader) {
            return (CTUnderline) POIXMLTypeLoader.parse(xMLStreamReader, CTUnderline.type, (XmlOptions) null);
        }

        public static CTUnderline parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTUnderline) POIXMLTypeLoader.parse(xMLStreamReader, CTUnderline.type, xmlOptions);
        }

        public static CTUnderline parse(XMLInputStream xMLInputStream) {
            return (CTUnderline) POIXMLTypeLoader.parse(xMLInputStream, CTUnderline.type, (XmlOptions) null);
        }

        public static CTUnderline parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTUnderline) POIXMLTypeLoader.parse(xMLInputStream, CTUnderline.type, xmlOptions);
        }

        public static CTUnderline parse(Node node) {
            return (CTUnderline) POIXMLTypeLoader.parse(node, CTUnderline.type, (XmlOptions) null);
        }

        public static CTUnderline parse(Node node, XmlOptions xmlOptions) {
            return (CTUnderline) POIXMLTypeLoader.parse(node, CTUnderline.type, xmlOptions);
        }
    }

    Object getColor();

    STThemeColor.Enum getThemeColor();

    byte[] getThemeShade();

    byte[] getThemeTint();

    STUnderline.Enum getVal();

    boolean isSetColor();

    boolean isSetThemeColor();

    boolean isSetThemeShade();

    boolean isSetThemeTint();

    boolean isSetVal();

    void setColor(Object obj);

    void setThemeColor(STThemeColor.Enum r12);

    void setThemeShade(byte[] bArr);

    void setThemeTint(byte[] bArr);

    void setVal(STUnderline.Enum r12);

    void unsetColor();

    void unsetThemeColor();

    void unsetThemeShade();

    void unsetThemeTint();

    void unsetVal();

    STHexColor xgetColor();

    STThemeColor xgetThemeColor();

    STUcharHexNumber xgetThemeShade();

    STUcharHexNumber xgetThemeTint();

    STUnderline xgetVal();

    void xsetColor(STHexColor sTHexColor);

    void xsetThemeColor(STThemeColor sTThemeColor);

    void xsetThemeShade(STUcharHexNumber sTUcharHexNumber);

    void xsetThemeTint(STUcharHexNumber sTUcharHexNumber);

    void xsetVal(STUnderline sTUnderline);
}
