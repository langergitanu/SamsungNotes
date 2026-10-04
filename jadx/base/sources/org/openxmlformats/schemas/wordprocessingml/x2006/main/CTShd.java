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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STThemeColor;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTShd extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTShd.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctshd58c3type");

    public static final class Factory {
        private Factory() {
        }

        public static CTShd newInstance() {
            return (CTShd) POIXMLTypeLoader.newInstance(CTShd.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTShd.type, null);
        }

        public static CTShd parse(File file) {
            return (CTShd) POIXMLTypeLoader.parse(file, CTShd.type, (XmlOptions) null);
        }

        public static CTShd newInstance(XmlOptions xmlOptions) {
            return (CTShd) POIXMLTypeLoader.newInstance(CTShd.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTShd.type, xmlOptions);
        }

        public static CTShd parse(File file, XmlOptions xmlOptions) {
            return (CTShd) POIXMLTypeLoader.parse(file, CTShd.type, xmlOptions);
        }

        public static CTShd parse(InputStream inputStream) {
            return (CTShd) POIXMLTypeLoader.parse(inputStream, CTShd.type, (XmlOptions) null);
        }

        public static CTShd parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTShd) POIXMLTypeLoader.parse(inputStream, CTShd.type, xmlOptions);
        }

        public static CTShd parse(Reader reader) {
            return (CTShd) POIXMLTypeLoader.parse(reader, CTShd.type, (XmlOptions) null);
        }

        public static CTShd parse(Reader reader, XmlOptions xmlOptions) {
            return (CTShd) POIXMLTypeLoader.parse(reader, CTShd.type, xmlOptions);
        }

        public static CTShd parse(String str) {
            return (CTShd) POIXMLTypeLoader.parse(str, CTShd.type, (XmlOptions) null);
        }

        public static CTShd parse(String str, XmlOptions xmlOptions) {
            return (CTShd) POIXMLTypeLoader.parse(str, CTShd.type, xmlOptions);
        }

        public static CTShd parse(URL url) {
            return (CTShd) POIXMLTypeLoader.parse(url, CTShd.type, (XmlOptions) null);
        }

        public static CTShd parse(URL url, XmlOptions xmlOptions) {
            return (CTShd) POIXMLTypeLoader.parse(url, CTShd.type, xmlOptions);
        }

        public static CTShd parse(XMLStreamReader xMLStreamReader) {
            return (CTShd) POIXMLTypeLoader.parse(xMLStreamReader, CTShd.type, (XmlOptions) null);
        }

        public static CTShd parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTShd) POIXMLTypeLoader.parse(xMLStreamReader, CTShd.type, xmlOptions);
        }

        public static CTShd parse(XMLInputStream xMLInputStream) {
            return (CTShd) POIXMLTypeLoader.parse(xMLInputStream, CTShd.type, (XmlOptions) null);
        }

        public static CTShd parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTShd) POIXMLTypeLoader.parse(xMLInputStream, CTShd.type, xmlOptions);
        }

        public static CTShd parse(Node node) {
            return (CTShd) POIXMLTypeLoader.parse(node, CTShd.type, (XmlOptions) null);
        }

        public static CTShd parse(Node node, XmlOptions xmlOptions) {
            return (CTShd) POIXMLTypeLoader.parse(node, CTShd.type, xmlOptions);
        }
    }

    Object getColor();

    Object getFill();

    STThemeColor.Enum getThemeColor();

    STThemeColor.Enum getThemeFill();

    byte[] getThemeFillShade();

    byte[] getThemeFillTint();

    byte[] getThemeShade();

    byte[] getThemeTint();

    STShd.Enum getVal();

    boolean isSetColor();

    boolean isSetFill();

    boolean isSetThemeColor();

    boolean isSetThemeFill();

    boolean isSetThemeFillShade();

    boolean isSetThemeFillTint();

    boolean isSetThemeShade();

    boolean isSetThemeTint();

    void setColor(Object obj);

    void setFill(Object obj);

    void setThemeColor(STThemeColor.Enum r12);

    void setThemeFill(STThemeColor.Enum r12);

    void setThemeFillShade(byte[] bArr);

    void setThemeFillTint(byte[] bArr);

    void setThemeShade(byte[] bArr);

    void setThemeTint(byte[] bArr);

    void setVal(STShd.Enum r12);

    void unsetColor();

    void unsetFill();

    void unsetThemeColor();

    void unsetThemeFill();

    void unsetThemeFillShade();

    void unsetThemeFillTint();

    void unsetThemeShade();

    void unsetThemeTint();

    STHexColor xgetColor();

    STHexColor xgetFill();

    STThemeColor xgetThemeColor();

    STThemeColor xgetThemeFill();

    STUcharHexNumber xgetThemeFillShade();

    STUcharHexNumber xgetThemeFillTint();

    STUcharHexNumber xgetThemeShade();

    STUcharHexNumber xgetThemeTint();

    STShd xgetVal();

    void xsetColor(STHexColor sTHexColor);

    void xsetFill(STHexColor sTHexColor);

    void xsetThemeColor(STThemeColor sTThemeColor);

    void xsetThemeFill(STThemeColor sTThemeColor);

    void xsetThemeFillShade(STUcharHexNumber sTUcharHexNumber);

    void xsetThemeFillTint(STUcharHexNumber sTUcharHexNumber);

    void xsetThemeShade(STUcharHexNumber sTUcharHexNumber);

    void xsetThemeTint(STUcharHexNumber sTUcharHexNumber);

    void xsetVal(STShd sTShd);
}
