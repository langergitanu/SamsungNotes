package com.microsoft.schemas.vml;

import com.google.android.gms.common.data.AbstractC4539a;
import com.microsoft.schemas.vml.STShadowType;
import com.microsoft.schemas.vml.STTrueFalse;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes6.dex */
public interface CTShadow extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTShadow.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctshadowdfdetype");

    public static final class Factory {
        private Factory() {
        }

        public static CTShadow newInstance() {
            return (CTShadow) POIXMLTypeLoader.newInstance(CTShadow.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTShadow.type, null);
        }

        public static CTShadow parse(File file) {
            return (CTShadow) POIXMLTypeLoader.parse(file, CTShadow.type, (XmlOptions) null);
        }

        public static CTShadow newInstance(XmlOptions xmlOptions) {
            return (CTShadow) POIXMLTypeLoader.newInstance(CTShadow.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTShadow.type, xmlOptions);
        }

        public static CTShadow parse(File file, XmlOptions xmlOptions) {
            return (CTShadow) POIXMLTypeLoader.parse(file, CTShadow.type, xmlOptions);
        }

        public static CTShadow parse(InputStream inputStream) {
            return (CTShadow) POIXMLTypeLoader.parse(inputStream, CTShadow.type, (XmlOptions) null);
        }

        public static CTShadow parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTShadow) POIXMLTypeLoader.parse(inputStream, CTShadow.type, xmlOptions);
        }

        public static CTShadow parse(Reader reader) {
            return (CTShadow) POIXMLTypeLoader.parse(reader, CTShadow.type, (XmlOptions) null);
        }

        public static CTShadow parse(Reader reader, XmlOptions xmlOptions) {
            return (CTShadow) POIXMLTypeLoader.parse(reader, CTShadow.type, xmlOptions);
        }

        public static CTShadow parse(String str) {
            return (CTShadow) POIXMLTypeLoader.parse(str, CTShadow.type, (XmlOptions) null);
        }

        public static CTShadow parse(String str, XmlOptions xmlOptions) {
            return (CTShadow) POIXMLTypeLoader.parse(str, CTShadow.type, xmlOptions);
        }

        public static CTShadow parse(URL url) {
            return (CTShadow) POIXMLTypeLoader.parse(url, CTShadow.type, (XmlOptions) null);
        }

        public static CTShadow parse(URL url, XmlOptions xmlOptions) {
            return (CTShadow) POIXMLTypeLoader.parse(url, CTShadow.type, xmlOptions);
        }

        public static CTShadow parse(XMLStreamReader xMLStreamReader) {
            return (CTShadow) POIXMLTypeLoader.parse(xMLStreamReader, CTShadow.type, (XmlOptions) null);
        }

        public static CTShadow parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTShadow) POIXMLTypeLoader.parse(xMLStreamReader, CTShadow.type, xmlOptions);
        }

        public static CTShadow parse(XMLInputStream xMLInputStream) {
            return (CTShadow) POIXMLTypeLoader.parse(xMLInputStream, CTShadow.type, (XmlOptions) null);
        }

        public static CTShadow parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTShadow) POIXMLTypeLoader.parse(xMLInputStream, CTShadow.type, xmlOptions);
        }

        public static CTShadow parse(Node node) {
            return (CTShadow) POIXMLTypeLoader.parse(node, CTShadow.type, (XmlOptions) null);
        }

        public static CTShadow parse(Node node, XmlOptions xmlOptions) {
            return (CTShadow) POIXMLTypeLoader.parse(node, CTShadow.type, xmlOptions);
        }
    }

    String getColor();

    String getColor2();

    String getId();

    String getMatrix();

    STTrueFalse.Enum getObscured();

    String getOffset();

    String getOffset2();

    STTrueFalse.Enum getOn();

    String getOpacity();

    String getOrigin();

    STShadowType.Enum getType();

    boolean isSetColor();

    boolean isSetColor2();

    boolean isSetId();

    boolean isSetMatrix();

    boolean isSetObscured();

    boolean isSetOffset();

    boolean isSetOffset2();

    boolean isSetOn();

    boolean isSetOpacity();

    boolean isSetOrigin();

    boolean isSetType();

    void setColor(String str);

    void setColor2(String str);

    void setId(String str);

    void setMatrix(String str);

    void setObscured(STTrueFalse.Enum r12);

    void setOffset(String str);

    void setOffset2(String str);

    void setOn(STTrueFalse.Enum r12);

    void setOpacity(String str);

    void setOrigin(String str);

    void setType(STShadowType.Enum r12);

    void unsetColor();

    void unsetColor2();

    void unsetId();

    void unsetMatrix();

    void unsetObscured();

    void unsetOffset();

    void unsetOffset2();

    void unsetOn();

    void unsetOpacity();

    void unsetOrigin();

    void unsetType();

    STColorType xgetColor();

    STColorType xgetColor2();

    XmlString xgetId();

    XmlString xgetMatrix();

    STTrueFalse xgetObscured();

    XmlString xgetOffset();

    XmlString xgetOffset2();

    STTrueFalse xgetOn();

    XmlString xgetOpacity();

    XmlString xgetOrigin();

    STShadowType xgetType();

    void xsetColor(STColorType sTColorType);

    void xsetColor2(STColorType sTColorType);

    void xsetId(XmlString xmlString);

    void xsetMatrix(XmlString xmlString);

    void xsetObscured(STTrueFalse sTTrueFalse);

    void xsetOffset(XmlString xmlString);

    void xsetOffset2(XmlString xmlString);

    void xsetOn(STTrueFalse sTTrueFalse);

    void xsetOpacity(XmlString xmlString);

    void xsetOrigin(XmlString xmlString);

    void xsetType(STShadowType sTShadowType);
}
