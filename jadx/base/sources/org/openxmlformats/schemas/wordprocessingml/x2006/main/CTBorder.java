package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STThemeColor;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTBorder extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTBorder.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctbordercdfctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTBorder newInstance() {
            return (CTBorder) POIXMLTypeLoader.newInstance(CTBorder.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTBorder.type, null);
        }

        public static CTBorder parse(File file) {
            return (CTBorder) POIXMLTypeLoader.parse(file, CTBorder.type, (XmlOptions) null);
        }

        public static CTBorder newInstance(XmlOptions xmlOptions) {
            return (CTBorder) POIXMLTypeLoader.newInstance(CTBorder.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTBorder.type, xmlOptions);
        }

        public static CTBorder parse(File file, XmlOptions xmlOptions) {
            return (CTBorder) POIXMLTypeLoader.parse(file, CTBorder.type, xmlOptions);
        }

        public static CTBorder parse(InputStream inputStream) {
            return (CTBorder) POIXMLTypeLoader.parse(inputStream, CTBorder.type, (XmlOptions) null);
        }

        public static CTBorder parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTBorder) POIXMLTypeLoader.parse(inputStream, CTBorder.type, xmlOptions);
        }

        public static CTBorder parse(Reader reader) {
            return (CTBorder) POIXMLTypeLoader.parse(reader, CTBorder.type, (XmlOptions) null);
        }

        public static CTBorder parse(Reader reader, XmlOptions xmlOptions) {
            return (CTBorder) POIXMLTypeLoader.parse(reader, CTBorder.type, xmlOptions);
        }

        public static CTBorder parse(String str) {
            return (CTBorder) POIXMLTypeLoader.parse(str, CTBorder.type, (XmlOptions) null);
        }

        public static CTBorder parse(String str, XmlOptions xmlOptions) {
            return (CTBorder) POIXMLTypeLoader.parse(str, CTBorder.type, xmlOptions);
        }

        public static CTBorder parse(URL url) {
            return (CTBorder) POIXMLTypeLoader.parse(url, CTBorder.type, (XmlOptions) null);
        }

        public static CTBorder parse(URL url, XmlOptions xmlOptions) {
            return (CTBorder) POIXMLTypeLoader.parse(url, CTBorder.type, xmlOptions);
        }

        public static CTBorder parse(XMLStreamReader xMLStreamReader) {
            return (CTBorder) POIXMLTypeLoader.parse(xMLStreamReader, CTBorder.type, (XmlOptions) null);
        }

        public static CTBorder parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTBorder) POIXMLTypeLoader.parse(xMLStreamReader, CTBorder.type, xmlOptions);
        }

        public static CTBorder parse(XMLInputStream xMLInputStream) {
            return (CTBorder) POIXMLTypeLoader.parse(xMLInputStream, CTBorder.type, (XmlOptions) null);
        }

        public static CTBorder parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTBorder) POIXMLTypeLoader.parse(xMLInputStream, CTBorder.type, xmlOptions);
        }

        public static CTBorder parse(Node node) {
            return (CTBorder) POIXMLTypeLoader.parse(node, CTBorder.type, (XmlOptions) null);
        }

        public static CTBorder parse(Node node, XmlOptions xmlOptions) {
            return (CTBorder) POIXMLTypeLoader.parse(node, CTBorder.type, xmlOptions);
        }
    }

    Object getColor();

    STOnOff.Enum getFrame();

    STOnOff.Enum getShadow();

    BigInteger getSpace();

    BigInteger getSz();

    STThemeColor.Enum getThemeColor();

    byte[] getThemeShade();

    byte[] getThemeTint();

    STBorder.Enum getVal();

    boolean isSetColor();

    boolean isSetFrame();

    boolean isSetShadow();

    boolean isSetSpace();

    boolean isSetSz();

    boolean isSetThemeColor();

    boolean isSetThemeShade();

    boolean isSetThemeTint();

    void setColor(Object obj);

    void setFrame(STOnOff.Enum r12);

    void setShadow(STOnOff.Enum r12);

    void setSpace(BigInteger bigInteger);

    void setSz(BigInteger bigInteger);

    void setThemeColor(STThemeColor.Enum r12);

    void setThemeShade(byte[] bArr);

    void setThemeTint(byte[] bArr);

    void setVal(STBorder.Enum r12);

    void unsetColor();

    void unsetFrame();

    void unsetShadow();

    void unsetSpace();

    void unsetSz();

    void unsetThemeColor();

    void unsetThemeShade();

    void unsetThemeTint();

    STHexColor xgetColor();

    STOnOff xgetFrame();

    STOnOff xgetShadow();

    STPointMeasure xgetSpace();

    STEighthPointMeasure xgetSz();

    STThemeColor xgetThemeColor();

    STUcharHexNumber xgetThemeShade();

    STUcharHexNumber xgetThemeTint();

    STBorder xgetVal();

    void xsetColor(STHexColor sTHexColor);

    void xsetFrame(STOnOff sTOnOff);

    void xsetShadow(STOnOff sTOnOff);

    void xsetSpace(STPointMeasure sTPointMeasure);

    void xsetSz(STEighthPointMeasure sTEighthPointMeasure);

    void xsetThemeColor(STThemeColor sTThemeColor);

    void xsetThemeShade(STUcharHexNumber sTUcharHexNumber);

    void xsetThemeTint(STUcharHexNumber sTUcharHexNumber);

    void xsetVal(STBorder sTBorder);
}
