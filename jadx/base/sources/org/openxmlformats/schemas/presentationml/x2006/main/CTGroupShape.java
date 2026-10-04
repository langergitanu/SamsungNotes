package org.openxmlformats.schemas.presentationml.x2006.main;

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
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTGroupShape extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTGroupShape.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctgroupshape5b43type");

    public static final class Factory {
        private Factory() {
        }

        public static CTGroupShape newInstance() {
            return (CTGroupShape) POIXMLTypeLoader.newInstance(CTGroupShape.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGroupShape.type, null);
        }

        public static CTGroupShape parse(File file) {
            return (CTGroupShape) POIXMLTypeLoader.parse(file, CTGroupShape.type, (XmlOptions) null);
        }

        public static CTGroupShape newInstance(XmlOptions xmlOptions) {
            return (CTGroupShape) POIXMLTypeLoader.newInstance(CTGroupShape.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGroupShape.type, xmlOptions);
        }

        public static CTGroupShape parse(File file, XmlOptions xmlOptions) {
            return (CTGroupShape) POIXMLTypeLoader.parse(file, CTGroupShape.type, xmlOptions);
        }

        public static CTGroupShape parse(InputStream inputStream) {
            return (CTGroupShape) POIXMLTypeLoader.parse(inputStream, CTGroupShape.type, (XmlOptions) null);
        }

        public static CTGroupShape parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTGroupShape) POIXMLTypeLoader.parse(inputStream, CTGroupShape.type, xmlOptions);
        }

        public static CTGroupShape parse(Reader reader) {
            return (CTGroupShape) POIXMLTypeLoader.parse(reader, CTGroupShape.type, (XmlOptions) null);
        }

        public static CTGroupShape parse(Reader reader, XmlOptions xmlOptions) {
            return (CTGroupShape) POIXMLTypeLoader.parse(reader, CTGroupShape.type, xmlOptions);
        }

        public static CTGroupShape parse(String str) {
            return (CTGroupShape) POIXMLTypeLoader.parse(str, CTGroupShape.type, (XmlOptions) null);
        }

        public static CTGroupShape parse(String str, XmlOptions xmlOptions) {
            return (CTGroupShape) POIXMLTypeLoader.parse(str, CTGroupShape.type, xmlOptions);
        }

        public static CTGroupShape parse(URL url) {
            return (CTGroupShape) POIXMLTypeLoader.parse(url, CTGroupShape.type, (XmlOptions) null);
        }

        public static CTGroupShape parse(URL url, XmlOptions xmlOptions) {
            return (CTGroupShape) POIXMLTypeLoader.parse(url, CTGroupShape.type, xmlOptions);
        }

        public static CTGroupShape parse(XMLStreamReader xMLStreamReader) {
            return (CTGroupShape) POIXMLTypeLoader.parse(xMLStreamReader, CTGroupShape.type, (XmlOptions) null);
        }

        public static CTGroupShape parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTGroupShape) POIXMLTypeLoader.parse(xMLStreamReader, CTGroupShape.type, xmlOptions);
        }

        public static CTGroupShape parse(XMLInputStream xMLInputStream) {
            return (CTGroupShape) POIXMLTypeLoader.parse(xMLInputStream, CTGroupShape.type, (XmlOptions) null);
        }

        public static CTGroupShape parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTGroupShape) POIXMLTypeLoader.parse(xMLInputStream, CTGroupShape.type, xmlOptions);
        }

        public static CTGroupShape parse(Node node) {
            return (CTGroupShape) POIXMLTypeLoader.parse(node, CTGroupShape.type, (XmlOptions) null);
        }

        public static CTGroupShape parse(Node node, XmlOptions xmlOptions) {
            return (CTGroupShape) POIXMLTypeLoader.parse(node, CTGroupShape.type, xmlOptions);
        }
    }

    CTConnector addNewCxnSp();

    CTExtensionListModify addNewExtLst();

    CTGraphicalObjectFrame addNewGraphicFrame();

    CTGroupShape addNewGrpSp();

    CTGroupShapeProperties addNewGrpSpPr();

    CTGroupShapeNonVisual addNewNvGrpSpPr();

    CTPicture addNewPic();

    CTShape addNewSp();

    CTConnector getCxnSpArray(int i);

    CTConnector[] getCxnSpArray();

    List<CTConnector> getCxnSpList();

    CTExtensionListModify getExtLst();

    CTGraphicalObjectFrame getGraphicFrameArray(int i);

    CTGraphicalObjectFrame[] getGraphicFrameArray();

    List<CTGraphicalObjectFrame> getGraphicFrameList();

    CTGroupShape getGrpSpArray(int i);

    CTGroupShape[] getGrpSpArray();

    List<CTGroupShape> getGrpSpList();

    CTGroupShapeProperties getGrpSpPr();

    CTGroupShapeNonVisual getNvGrpSpPr();

    CTPicture getPicArray(int i);

    CTPicture[] getPicArray();

    List<CTPicture> getPicList();

    CTShape getSpArray(int i);

    CTShape[] getSpArray();

    List<CTShape> getSpList();

    CTConnector insertNewCxnSp(int i);

    CTGraphicalObjectFrame insertNewGraphicFrame(int i);

    CTGroupShape insertNewGrpSp(int i);

    CTPicture insertNewPic(int i);

    CTShape insertNewSp(int i);

    boolean isSetExtLst();

    void removeCxnSp(int i);

    void removeGraphicFrame(int i);

    void removeGrpSp(int i);

    void removePic(int i);

    void removeSp(int i);

    void setCxnSpArray(int i, CTConnector cTConnector);

    void setCxnSpArray(CTConnector[] cTConnectorArr);

    void setExtLst(CTExtensionListModify cTExtensionListModify);

    void setGraphicFrameArray(int i, CTGraphicalObjectFrame cTGraphicalObjectFrame);

    void setGraphicFrameArray(CTGraphicalObjectFrame[] cTGraphicalObjectFrameArr);

    void setGrpSpArray(int i, CTGroupShape cTGroupShape);

    void setGrpSpArray(CTGroupShape[] cTGroupShapeArr);

    void setGrpSpPr(CTGroupShapeProperties cTGroupShapeProperties);

    void setNvGrpSpPr(CTGroupShapeNonVisual cTGroupShapeNonVisual);

    void setPicArray(int i, CTPicture cTPicture);

    void setPicArray(CTPicture[] cTPictureArr);

    void setSpArray(int i, CTShape cTShape);

    void setSpArray(CTShape[] cTShapeArr);

    int sizeOfCxnSpArray();

    int sizeOfGraphicFrameArray();

    int sizeOfGrpSpArray();

    int sizeOfPicArray();

    int sizeOfSpArray();

    void unsetExtLst();
}
