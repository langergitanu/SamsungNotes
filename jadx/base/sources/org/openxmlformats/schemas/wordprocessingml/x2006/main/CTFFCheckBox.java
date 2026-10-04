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
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTFFCheckBox extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTFFCheckBox.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctffcheckboxf3a5type");

    public static final class Factory {
        private Factory() {
        }

        public static CTFFCheckBox newInstance() {
            return (CTFFCheckBox) POIXMLTypeLoader.newInstance(CTFFCheckBox.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFFCheckBox.type, null);
        }

        public static CTFFCheckBox parse(File file) {
            return (CTFFCheckBox) POIXMLTypeLoader.parse(file, CTFFCheckBox.type, (XmlOptions) null);
        }

        public static CTFFCheckBox newInstance(XmlOptions xmlOptions) {
            return (CTFFCheckBox) POIXMLTypeLoader.newInstance(CTFFCheckBox.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFFCheckBox.type, xmlOptions);
        }

        public static CTFFCheckBox parse(File file, XmlOptions xmlOptions) {
            return (CTFFCheckBox) POIXMLTypeLoader.parse(file, CTFFCheckBox.type, xmlOptions);
        }

        public static CTFFCheckBox parse(InputStream inputStream) {
            return (CTFFCheckBox) POIXMLTypeLoader.parse(inputStream, CTFFCheckBox.type, (XmlOptions) null);
        }

        public static CTFFCheckBox parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTFFCheckBox) POIXMLTypeLoader.parse(inputStream, CTFFCheckBox.type, xmlOptions);
        }

        public static CTFFCheckBox parse(Reader reader) {
            return (CTFFCheckBox) POIXMLTypeLoader.parse(reader, CTFFCheckBox.type, (XmlOptions) null);
        }

        public static CTFFCheckBox parse(Reader reader, XmlOptions xmlOptions) {
            return (CTFFCheckBox) POIXMLTypeLoader.parse(reader, CTFFCheckBox.type, xmlOptions);
        }

        public static CTFFCheckBox parse(String str) {
            return (CTFFCheckBox) POIXMLTypeLoader.parse(str, CTFFCheckBox.type, (XmlOptions) null);
        }

        public static CTFFCheckBox parse(String str, XmlOptions xmlOptions) {
            return (CTFFCheckBox) POIXMLTypeLoader.parse(str, CTFFCheckBox.type, xmlOptions);
        }

        public static CTFFCheckBox parse(URL url) {
            return (CTFFCheckBox) POIXMLTypeLoader.parse(url, CTFFCheckBox.type, (XmlOptions) null);
        }

        public static CTFFCheckBox parse(URL url, XmlOptions xmlOptions) {
            return (CTFFCheckBox) POIXMLTypeLoader.parse(url, CTFFCheckBox.type, xmlOptions);
        }

        public static CTFFCheckBox parse(XMLStreamReader xMLStreamReader) {
            return (CTFFCheckBox) POIXMLTypeLoader.parse(xMLStreamReader, CTFFCheckBox.type, (XmlOptions) null);
        }

        public static CTFFCheckBox parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTFFCheckBox) POIXMLTypeLoader.parse(xMLStreamReader, CTFFCheckBox.type, xmlOptions);
        }

        public static CTFFCheckBox parse(XMLInputStream xMLInputStream) {
            return (CTFFCheckBox) POIXMLTypeLoader.parse(xMLInputStream, CTFFCheckBox.type, (XmlOptions) null);
        }

        public static CTFFCheckBox parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTFFCheckBox) POIXMLTypeLoader.parse(xMLInputStream, CTFFCheckBox.type, xmlOptions);
        }

        public static CTFFCheckBox parse(Node node) {
            return (CTFFCheckBox) POIXMLTypeLoader.parse(node, CTFFCheckBox.type, (XmlOptions) null);
        }

        public static CTFFCheckBox parse(Node node, XmlOptions xmlOptions) {
            return (CTFFCheckBox) POIXMLTypeLoader.parse(node, CTFFCheckBox.type, xmlOptions);
        }
    }

    CTOnOff addNewChecked();

    CTOnOff addNewDefault();

    CTHpsMeasure addNewSize();

    CTOnOff addNewSizeAuto();

    CTOnOff getChecked();

    CTOnOff getDefault();

    CTHpsMeasure getSize();

    CTOnOff getSizeAuto();

    boolean isSetChecked();

    boolean isSetDefault();

    boolean isSetSize();

    boolean isSetSizeAuto();

    void setChecked(CTOnOff cTOnOff);

    void setDefault(CTOnOff cTOnOff);

    void setSize(CTHpsMeasure cTHpsMeasure);

    void setSizeAuto(CTOnOff cTOnOff);

    void unsetChecked();

    void unsetDefault();

    void unsetSize();

    void unsetSizeAuto();
}
