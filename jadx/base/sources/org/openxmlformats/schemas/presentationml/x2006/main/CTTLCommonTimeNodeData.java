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
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.openxmlformats.schemas.drawingml.x2006.main.STPercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.STPositiveFixedPercentage;
import org.openxmlformats.schemas.presentationml.x2006.main.STTLTimeNodeFillType;
import org.openxmlformats.schemas.presentationml.x2006.main.STTLTimeNodeMasterRelation;
import org.openxmlformats.schemas.presentationml.x2006.main.STTLTimeNodePresetClassType;
import org.openxmlformats.schemas.presentationml.x2006.main.STTLTimeNodeRestartType;
import org.openxmlformats.schemas.presentationml.x2006.main.STTLTimeNodeSyncType;
import org.openxmlformats.schemas.presentationml.x2006.main.STTLTimeNodeType;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTTLCommonTimeNodeData extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTLCommonTimeNodeData.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttlcommontimenodedatac8e9type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTLCommonTimeNodeData newInstance() {
            return (CTTLCommonTimeNodeData) POIXMLTypeLoader.newInstance(CTTLCommonTimeNodeData.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTLCommonTimeNodeData.type, null);
        }

        public static CTTLCommonTimeNodeData parse(File file) {
            return (CTTLCommonTimeNodeData) POIXMLTypeLoader.parse(file, CTTLCommonTimeNodeData.type, (XmlOptions) null);
        }

        public static CTTLCommonTimeNodeData newInstance(XmlOptions xmlOptions) {
            return (CTTLCommonTimeNodeData) POIXMLTypeLoader.newInstance(CTTLCommonTimeNodeData.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTLCommonTimeNodeData.type, xmlOptions);
        }

        public static CTTLCommonTimeNodeData parse(File file, XmlOptions xmlOptions) {
            return (CTTLCommonTimeNodeData) POIXMLTypeLoader.parse(file, CTTLCommonTimeNodeData.type, xmlOptions);
        }

        public static CTTLCommonTimeNodeData parse(InputStream inputStream) {
            return (CTTLCommonTimeNodeData) POIXMLTypeLoader.parse(inputStream, CTTLCommonTimeNodeData.type, (XmlOptions) null);
        }

        public static CTTLCommonTimeNodeData parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTLCommonTimeNodeData) POIXMLTypeLoader.parse(inputStream, CTTLCommonTimeNodeData.type, xmlOptions);
        }

        public static CTTLCommonTimeNodeData parse(Reader reader) {
            return (CTTLCommonTimeNodeData) POIXMLTypeLoader.parse(reader, CTTLCommonTimeNodeData.type, (XmlOptions) null);
        }

        public static CTTLCommonTimeNodeData parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTLCommonTimeNodeData) POIXMLTypeLoader.parse(reader, CTTLCommonTimeNodeData.type, xmlOptions);
        }

        public static CTTLCommonTimeNodeData parse(String str) {
            return (CTTLCommonTimeNodeData) POIXMLTypeLoader.parse(str, CTTLCommonTimeNodeData.type, (XmlOptions) null);
        }

        public static CTTLCommonTimeNodeData parse(String str, XmlOptions xmlOptions) {
            return (CTTLCommonTimeNodeData) POIXMLTypeLoader.parse(str, CTTLCommonTimeNodeData.type, xmlOptions);
        }

        public static CTTLCommonTimeNodeData parse(URL url) {
            return (CTTLCommonTimeNodeData) POIXMLTypeLoader.parse(url, CTTLCommonTimeNodeData.type, (XmlOptions) null);
        }

        public static CTTLCommonTimeNodeData parse(URL url, XmlOptions xmlOptions) {
            return (CTTLCommonTimeNodeData) POIXMLTypeLoader.parse(url, CTTLCommonTimeNodeData.type, xmlOptions);
        }

        public static CTTLCommonTimeNodeData parse(XMLStreamReader xMLStreamReader) {
            return (CTTLCommonTimeNodeData) POIXMLTypeLoader.parse(xMLStreamReader, CTTLCommonTimeNodeData.type, (XmlOptions) null);
        }

        public static CTTLCommonTimeNodeData parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTLCommonTimeNodeData) POIXMLTypeLoader.parse(xMLStreamReader, CTTLCommonTimeNodeData.type, xmlOptions);
        }

        public static CTTLCommonTimeNodeData parse(XMLInputStream xMLInputStream) {
            return (CTTLCommonTimeNodeData) POIXMLTypeLoader.parse(xMLInputStream, CTTLCommonTimeNodeData.type, (XmlOptions) null);
        }

        public static CTTLCommonTimeNodeData parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTLCommonTimeNodeData) POIXMLTypeLoader.parse(xMLInputStream, CTTLCommonTimeNodeData.type, xmlOptions);
        }

        public static CTTLCommonTimeNodeData parse(Node node) {
            return (CTTLCommonTimeNodeData) POIXMLTypeLoader.parse(node, CTTLCommonTimeNodeData.type, (XmlOptions) null);
        }

        public static CTTLCommonTimeNodeData parse(Node node, XmlOptions xmlOptions) {
            return (CTTLCommonTimeNodeData) POIXMLTypeLoader.parse(node, CTTLCommonTimeNodeData.type, xmlOptions);
        }
    }

    CTTimeNodeList addNewChildTnLst();

    CTTLTimeConditionList addNewEndCondLst();

    CTTLTimeCondition addNewEndSync();

    CTTLIterateData addNewIterate();

    CTTLTimeConditionList addNewStCondLst();

    CTTimeNodeList addNewSubTnLst();

    int getAccel();

    boolean getAfterEffect();

    boolean getAutoRev();

    int getBldLvl();

    CTTimeNodeList getChildTnLst();

    int getDecel();

    boolean getDisplay();

    Object getDur();

    CTTLTimeConditionList getEndCondLst();

    CTTLTimeCondition getEndSync();

    String getEvtFilter();

    STTLTimeNodeFillType.Enum getFill();

    long getGrpId();

    long getId();

    CTTLIterateData getIterate();

    STTLTimeNodeMasterRelation.Enum getMasterRel();

    boolean getNodePh();

    STTLTimeNodeType.Enum getNodeType();

    STTLTimeNodePresetClassType.Enum getPresetClass();

    int getPresetID();

    int getPresetSubtype();

    Object getRepeatCount();

    Object getRepeatDur();

    STTLTimeNodeRestartType.Enum getRestart();

    int getSpd();

    CTTLTimeConditionList getStCondLst();

    CTTimeNodeList getSubTnLst();

    STTLTimeNodeSyncType.Enum getSyncBehavior();

    String getTmFilter();

    boolean isSetAccel();

    boolean isSetAfterEffect();

    boolean isSetAutoRev();

    boolean isSetBldLvl();

    boolean isSetChildTnLst();

    boolean isSetDecel();

    boolean isSetDisplay();

    boolean isSetDur();

    boolean isSetEndCondLst();

    boolean isSetEndSync();

    boolean isSetEvtFilter();

    boolean isSetFill();

    boolean isSetGrpId();

    boolean isSetId();

    boolean isSetIterate();

    boolean isSetMasterRel();

    boolean isSetNodePh();

    boolean isSetNodeType();

    boolean isSetPresetClass();

    boolean isSetPresetID();

    boolean isSetPresetSubtype();

    boolean isSetRepeatCount();

    boolean isSetRepeatDur();

    boolean isSetRestart();

    boolean isSetSpd();

    boolean isSetStCondLst();

    boolean isSetSubTnLst();

    boolean isSetSyncBehavior();

    boolean isSetTmFilter();

    void setAccel(int i);

    void setAfterEffect(boolean z);

    void setAutoRev(boolean z);

    void setBldLvl(int i);

    void setChildTnLst(CTTimeNodeList cTTimeNodeList);

    void setDecel(int i);

    void setDisplay(boolean z);

    void setDur(Object obj);

    void setEndCondLst(CTTLTimeConditionList cTTLTimeConditionList);

    void setEndSync(CTTLTimeCondition cTTLTimeCondition);

    void setEvtFilter(String str);

    void setFill(STTLTimeNodeFillType.Enum r12);

    void setGrpId(long j);

    void setId(long j);

    void setIterate(CTTLIterateData cTTLIterateData);

    void setMasterRel(STTLTimeNodeMasterRelation.Enum r12);

    void setNodePh(boolean z);

    void setNodeType(STTLTimeNodeType.Enum r12);

    void setPresetClass(STTLTimeNodePresetClassType.Enum r12);

    void setPresetID(int i);

    void setPresetSubtype(int i);

    void setRepeatCount(Object obj);

    void setRepeatDur(Object obj);

    void setRestart(STTLTimeNodeRestartType.Enum r12);

    void setSpd(int i);

    void setStCondLst(CTTLTimeConditionList cTTLTimeConditionList);

    void setSubTnLst(CTTimeNodeList cTTimeNodeList);

    void setSyncBehavior(STTLTimeNodeSyncType.Enum r12);

    void setTmFilter(String str);

    void unsetAccel();

    void unsetAfterEffect();

    void unsetAutoRev();

    void unsetBldLvl();

    void unsetChildTnLst();

    void unsetDecel();

    void unsetDisplay();

    void unsetDur();

    void unsetEndCondLst();

    void unsetEndSync();

    void unsetEvtFilter();

    void unsetFill();

    void unsetGrpId();

    void unsetId();

    void unsetIterate();

    void unsetMasterRel();

    void unsetNodePh();

    void unsetNodeType();

    void unsetPresetClass();

    void unsetPresetID();

    void unsetPresetSubtype();

    void unsetRepeatCount();

    void unsetRepeatDur();

    void unsetRestart();

    void unsetSpd();

    void unsetStCondLst();

    void unsetSubTnLst();

    void unsetSyncBehavior();

    void unsetTmFilter();

    STPositiveFixedPercentage xgetAccel();

    XmlBoolean xgetAfterEffect();

    XmlBoolean xgetAutoRev();

    XmlInt xgetBldLvl();

    STPositiveFixedPercentage xgetDecel();

    XmlBoolean xgetDisplay();

    STTLTime xgetDur();

    XmlString xgetEvtFilter();

    STTLTimeNodeFillType xgetFill();

    XmlUnsignedInt xgetGrpId();

    STTLTimeNodeID xgetId();

    STTLTimeNodeMasterRelation xgetMasterRel();

    XmlBoolean xgetNodePh();

    STTLTimeNodeType xgetNodeType();

    STTLTimeNodePresetClassType xgetPresetClass();

    XmlInt xgetPresetID();

    XmlInt xgetPresetSubtype();

    STTLTime xgetRepeatCount();

    STTLTime xgetRepeatDur();

    STTLTimeNodeRestartType xgetRestart();

    STPercentage xgetSpd();

    STTLTimeNodeSyncType xgetSyncBehavior();

    XmlString xgetTmFilter();

    void xsetAccel(STPositiveFixedPercentage sTPositiveFixedPercentage);

    void xsetAfterEffect(XmlBoolean xmlBoolean);

    void xsetAutoRev(XmlBoolean xmlBoolean);

    void xsetBldLvl(XmlInt xmlInt);

    void xsetDecel(STPositiveFixedPercentage sTPositiveFixedPercentage);

    void xsetDisplay(XmlBoolean xmlBoolean);

    void xsetDur(STTLTime sTTLTime);

    void xsetEvtFilter(XmlString xmlString);

    void xsetFill(STTLTimeNodeFillType sTTLTimeNodeFillType);

    void xsetGrpId(XmlUnsignedInt xmlUnsignedInt);

    void xsetId(STTLTimeNodeID sTTLTimeNodeID);

    void xsetMasterRel(STTLTimeNodeMasterRelation sTTLTimeNodeMasterRelation);

    void xsetNodePh(XmlBoolean xmlBoolean);

    void xsetNodeType(STTLTimeNodeType sTTLTimeNodeType);

    void xsetPresetClass(STTLTimeNodePresetClassType sTTLTimeNodePresetClassType);

    void xsetPresetID(XmlInt xmlInt);

    void xsetPresetSubtype(XmlInt xmlInt);

    void xsetRepeatCount(STTLTime sTTLTime);

    void xsetRepeatDur(STTLTime sTTLTime);

    void xsetRestart(STTLTimeNodeRestartType sTTLTimeNodeRestartType);

    void xsetSpd(STPercentage sTPercentage);

    void xsetSyncBehavior(STTLTimeNodeSyncType sTTLTimeNodeSyncType);

    void xsetTmFilter(XmlString xmlString);
}
