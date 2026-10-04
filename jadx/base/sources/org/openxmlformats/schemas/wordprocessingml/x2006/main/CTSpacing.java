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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STLineSpacingRule;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTSpacing extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTSpacing.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctspacingff2ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTSpacing newInstance() {
            return (CTSpacing) POIXMLTypeLoader.newInstance(CTSpacing.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSpacing.type, null);
        }

        public static CTSpacing parse(File file) {
            return (CTSpacing) POIXMLTypeLoader.parse(file, CTSpacing.type, (XmlOptions) null);
        }

        public static CTSpacing newInstance(XmlOptions xmlOptions) {
            return (CTSpacing) POIXMLTypeLoader.newInstance(CTSpacing.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSpacing.type, xmlOptions);
        }

        public static CTSpacing parse(File file, XmlOptions xmlOptions) {
            return (CTSpacing) POIXMLTypeLoader.parse(file, CTSpacing.type, xmlOptions);
        }

        public static CTSpacing parse(InputStream inputStream) {
            return (CTSpacing) POIXMLTypeLoader.parse(inputStream, CTSpacing.type, (XmlOptions) null);
        }

        public static CTSpacing parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTSpacing) POIXMLTypeLoader.parse(inputStream, CTSpacing.type, xmlOptions);
        }

        public static CTSpacing parse(Reader reader) {
            return (CTSpacing) POIXMLTypeLoader.parse(reader, CTSpacing.type, (XmlOptions) null);
        }

        public static CTSpacing parse(Reader reader, XmlOptions xmlOptions) {
            return (CTSpacing) POIXMLTypeLoader.parse(reader, CTSpacing.type, xmlOptions);
        }

        public static CTSpacing parse(String str) {
            return (CTSpacing) POIXMLTypeLoader.parse(str, CTSpacing.type, (XmlOptions) null);
        }

        public static CTSpacing parse(String str, XmlOptions xmlOptions) {
            return (CTSpacing) POIXMLTypeLoader.parse(str, CTSpacing.type, xmlOptions);
        }

        public static CTSpacing parse(URL url) {
            return (CTSpacing) POIXMLTypeLoader.parse(url, CTSpacing.type, (XmlOptions) null);
        }

        public static CTSpacing parse(URL url, XmlOptions xmlOptions) {
            return (CTSpacing) POIXMLTypeLoader.parse(url, CTSpacing.type, xmlOptions);
        }

        public static CTSpacing parse(XMLStreamReader xMLStreamReader) {
            return (CTSpacing) POIXMLTypeLoader.parse(xMLStreamReader, CTSpacing.type, (XmlOptions) null);
        }

        public static CTSpacing parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTSpacing) POIXMLTypeLoader.parse(xMLStreamReader, CTSpacing.type, xmlOptions);
        }

        public static CTSpacing parse(XMLInputStream xMLInputStream) {
            return (CTSpacing) POIXMLTypeLoader.parse(xMLInputStream, CTSpacing.type, (XmlOptions) null);
        }

        public static CTSpacing parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTSpacing) POIXMLTypeLoader.parse(xMLInputStream, CTSpacing.type, xmlOptions);
        }

        public static CTSpacing parse(Node node) {
            return (CTSpacing) POIXMLTypeLoader.parse(node, CTSpacing.type, (XmlOptions) null);
        }

        public static CTSpacing parse(Node node, XmlOptions xmlOptions) {
            return (CTSpacing) POIXMLTypeLoader.parse(node, CTSpacing.type, xmlOptions);
        }
    }

    BigInteger getAfter();

    STOnOff.Enum getAfterAutospacing();

    BigInteger getAfterLines();

    BigInteger getBefore();

    STOnOff.Enum getBeforeAutospacing();

    BigInteger getBeforeLines();

    BigInteger getLine();

    STLineSpacingRule.Enum getLineRule();

    boolean isSetAfter();

    boolean isSetAfterAutospacing();

    boolean isSetAfterLines();

    boolean isSetBefore();

    boolean isSetBeforeAutospacing();

    boolean isSetBeforeLines();

    boolean isSetLine();

    boolean isSetLineRule();

    void setAfter(BigInteger bigInteger);

    void setAfterAutospacing(STOnOff.Enum r12);

    void setAfterLines(BigInteger bigInteger);

    void setBefore(BigInteger bigInteger);

    void setBeforeAutospacing(STOnOff.Enum r12);

    void setBeforeLines(BigInteger bigInteger);

    void setLine(BigInteger bigInteger);

    void setLineRule(STLineSpacingRule.Enum r12);

    void unsetAfter();

    void unsetAfterAutospacing();

    void unsetAfterLines();

    void unsetBefore();

    void unsetBeforeAutospacing();

    void unsetBeforeLines();

    void unsetLine();

    void unsetLineRule();

    STTwipsMeasure xgetAfter();

    STOnOff xgetAfterAutospacing();

    STDecimalNumber xgetAfterLines();

    STTwipsMeasure xgetBefore();

    STOnOff xgetBeforeAutospacing();

    STDecimalNumber xgetBeforeLines();

    STSignedTwipsMeasure xgetLine();

    STLineSpacingRule xgetLineRule();

    void xsetAfter(STTwipsMeasure sTTwipsMeasure);

    void xsetAfterAutospacing(STOnOff sTOnOff);

    void xsetAfterLines(STDecimalNumber sTDecimalNumber);

    void xsetBefore(STTwipsMeasure sTTwipsMeasure);

    void xsetBeforeAutospacing(STOnOff sTOnOff);

    void xsetBeforeLines(STDecimalNumber sTDecimalNumber);

    void xsetLine(STSignedTwipsMeasure sTSignedTwipsMeasure);

    void xsetLineRule(STLineSpacingRule sTLineSpacingRule);
}
