package org.openxmlformats.schemas.drawingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTFillStyleList extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTFillStyleList.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctfillstylelist959dtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTFillStyleList newInstance() {
            return (CTFillStyleList) POIXMLTypeLoader.newInstance(CTFillStyleList.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFillStyleList.type, null);
        }

        public static CTFillStyleList parse(File file) {
            return (CTFillStyleList) POIXMLTypeLoader.parse(file, CTFillStyleList.type, (XmlOptions) null);
        }

        public static CTFillStyleList newInstance(XmlOptions xmlOptions) {
            return (CTFillStyleList) POIXMLTypeLoader.newInstance(CTFillStyleList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFillStyleList.type, xmlOptions);
        }

        public static CTFillStyleList parse(File file, XmlOptions xmlOptions) {
            return (CTFillStyleList) POIXMLTypeLoader.parse(file, CTFillStyleList.type, xmlOptions);
        }

        public static CTFillStyleList parse(InputStream inputStream) {
            return (CTFillStyleList) POIXMLTypeLoader.parse(inputStream, CTFillStyleList.type, (XmlOptions) null);
        }

        public static CTFillStyleList parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTFillStyleList) POIXMLTypeLoader.parse(inputStream, CTFillStyleList.type, xmlOptions);
        }

        public static CTFillStyleList parse(Reader reader) {
            return (CTFillStyleList) POIXMLTypeLoader.parse(reader, CTFillStyleList.type, (XmlOptions) null);
        }

        public static CTFillStyleList parse(Reader reader, XmlOptions xmlOptions) {
            return (CTFillStyleList) POIXMLTypeLoader.parse(reader, CTFillStyleList.type, xmlOptions);
        }

        public static CTFillStyleList parse(String str) {
            return (CTFillStyleList) POIXMLTypeLoader.parse(str, CTFillStyleList.type, (XmlOptions) null);
        }

        public static CTFillStyleList parse(String str, XmlOptions xmlOptions) {
            return (CTFillStyleList) POIXMLTypeLoader.parse(str, CTFillStyleList.type, xmlOptions);
        }

        public static CTFillStyleList parse(URL url) {
            return (CTFillStyleList) POIXMLTypeLoader.parse(url, CTFillStyleList.type, (XmlOptions) null);
        }

        public static CTFillStyleList parse(URL url, XmlOptions xmlOptions) {
            return (CTFillStyleList) POIXMLTypeLoader.parse(url, CTFillStyleList.type, xmlOptions);
        }

        public static CTFillStyleList parse(XMLStreamReader xMLStreamReader) {
            return (CTFillStyleList) POIXMLTypeLoader.parse(xMLStreamReader, CTFillStyleList.type, (XmlOptions) null);
        }

        public static CTFillStyleList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTFillStyleList) POIXMLTypeLoader.parse(xMLStreamReader, CTFillStyleList.type, xmlOptions);
        }

        public static CTFillStyleList parse(XMLInputStream xMLInputStream) {
            return (CTFillStyleList) POIXMLTypeLoader.parse(xMLInputStream, CTFillStyleList.type, (XmlOptions) null);
        }

        public static CTFillStyleList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTFillStyleList) POIXMLTypeLoader.parse(xMLInputStream, CTFillStyleList.type, xmlOptions);
        }

        public static CTFillStyleList parse(Node node) {
            return (CTFillStyleList) POIXMLTypeLoader.parse(node, CTFillStyleList.type, (XmlOptions) null);
        }

        public static CTFillStyleList parse(Node node, XmlOptions xmlOptions) {
            return (CTFillStyleList) POIXMLTypeLoader.parse(node, CTFillStyleList.type, xmlOptions);
        }
    }

    CTBlipFillProperties addNewBlipFill();

    CTGradientFillProperties addNewGradFill();

    CTGroupFillProperties addNewGrpFill();

    CTNoFillProperties addNewNoFill();

    CTPatternFillProperties addNewPattFill();

    CTSolidColorFillProperties addNewSolidFill();

    CTBlipFillProperties getBlipFillArray(int i);

    CTBlipFillProperties[] getBlipFillArray();

    List<CTBlipFillProperties> getBlipFillList();

    CTGradientFillProperties getGradFillArray(int i);

    CTGradientFillProperties[] getGradFillArray();

    List<CTGradientFillProperties> getGradFillList();

    CTGroupFillProperties getGrpFillArray(int i);

    CTGroupFillProperties[] getGrpFillArray();

    List<CTGroupFillProperties> getGrpFillList();

    CTNoFillProperties getNoFillArray(int i);

    CTNoFillProperties[] getNoFillArray();

    List<CTNoFillProperties> getNoFillList();

    CTPatternFillProperties getPattFillArray(int i);

    CTPatternFillProperties[] getPattFillArray();

    List<CTPatternFillProperties> getPattFillList();

    CTSolidColorFillProperties getSolidFillArray(int i);

    CTSolidColorFillProperties[] getSolidFillArray();

    List<CTSolidColorFillProperties> getSolidFillList();

    CTBlipFillProperties insertNewBlipFill(int i);

    CTGradientFillProperties insertNewGradFill(int i);

    CTGroupFillProperties insertNewGrpFill(int i);

    CTNoFillProperties insertNewNoFill(int i);

    CTPatternFillProperties insertNewPattFill(int i);

    CTSolidColorFillProperties insertNewSolidFill(int i);

    void removeBlipFill(int i);

    void removeGradFill(int i);

    void removeGrpFill(int i);

    void removeNoFill(int i);

    void removePattFill(int i);

    void removeSolidFill(int i);

    void setBlipFillArray(int i, CTBlipFillProperties cTBlipFillProperties);

    void setBlipFillArray(CTBlipFillProperties[] cTBlipFillPropertiesArr);

    void setGradFillArray(int i, CTGradientFillProperties cTGradientFillProperties);

    void setGradFillArray(CTGradientFillProperties[] cTGradientFillPropertiesArr);

    void setGrpFillArray(int i, CTGroupFillProperties cTGroupFillProperties);

    void setGrpFillArray(CTGroupFillProperties[] cTGroupFillPropertiesArr);

    void setNoFillArray(int i, CTNoFillProperties cTNoFillProperties);

    void setNoFillArray(CTNoFillProperties[] cTNoFillPropertiesArr);

    void setPattFillArray(int i, CTPatternFillProperties cTPatternFillProperties);

    void setPattFillArray(CTPatternFillProperties[] cTPatternFillPropertiesArr);

    void setSolidFillArray(int i, CTSolidColorFillProperties cTSolidColorFillProperties);

    void setSolidFillArray(CTSolidColorFillProperties[] cTSolidColorFillPropertiesArr);

    int sizeOfBlipFillArray();

    int sizeOfGradFillArray();

    int sizeOfGrpFillArray();

    int sizeOfNoFillArray();

    int sizeOfPattFillArray();

    int sizeOfSolidFillArray();
}
