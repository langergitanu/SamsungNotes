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
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTTimeNodeList extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTimeNodeList.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttimenodelist0258type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTimeNodeList newInstance() {
            return (CTTimeNodeList) POIXMLTypeLoader.newInstance(CTTimeNodeList.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTimeNodeList.type, null);
        }

        public static CTTimeNodeList parse(File file) {
            return (CTTimeNodeList) POIXMLTypeLoader.parse(file, CTTimeNodeList.type, (XmlOptions) null);
        }

        public static CTTimeNodeList newInstance(XmlOptions xmlOptions) {
            return (CTTimeNodeList) POIXMLTypeLoader.newInstance(CTTimeNodeList.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTimeNodeList.type, xmlOptions);
        }

        public static CTTimeNodeList parse(File file, XmlOptions xmlOptions) {
            return (CTTimeNodeList) POIXMLTypeLoader.parse(file, CTTimeNodeList.type, xmlOptions);
        }

        public static CTTimeNodeList parse(InputStream inputStream) {
            return (CTTimeNodeList) POIXMLTypeLoader.parse(inputStream, CTTimeNodeList.type, (XmlOptions) null);
        }

        public static CTTimeNodeList parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTimeNodeList) POIXMLTypeLoader.parse(inputStream, CTTimeNodeList.type, xmlOptions);
        }

        public static CTTimeNodeList parse(Reader reader) {
            return (CTTimeNodeList) POIXMLTypeLoader.parse(reader, CTTimeNodeList.type, (XmlOptions) null);
        }

        public static CTTimeNodeList parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTimeNodeList) POIXMLTypeLoader.parse(reader, CTTimeNodeList.type, xmlOptions);
        }

        public static CTTimeNodeList parse(String str) {
            return (CTTimeNodeList) POIXMLTypeLoader.parse(str, CTTimeNodeList.type, (XmlOptions) null);
        }

        public static CTTimeNodeList parse(String str, XmlOptions xmlOptions) {
            return (CTTimeNodeList) POIXMLTypeLoader.parse(str, CTTimeNodeList.type, xmlOptions);
        }

        public static CTTimeNodeList parse(URL url) {
            return (CTTimeNodeList) POIXMLTypeLoader.parse(url, CTTimeNodeList.type, (XmlOptions) null);
        }

        public static CTTimeNodeList parse(URL url, XmlOptions xmlOptions) {
            return (CTTimeNodeList) POIXMLTypeLoader.parse(url, CTTimeNodeList.type, xmlOptions);
        }

        public static CTTimeNodeList parse(XMLStreamReader xMLStreamReader) {
            return (CTTimeNodeList) POIXMLTypeLoader.parse(xMLStreamReader, CTTimeNodeList.type, (XmlOptions) null);
        }

        public static CTTimeNodeList parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTimeNodeList) POIXMLTypeLoader.parse(xMLStreamReader, CTTimeNodeList.type, xmlOptions);
        }

        public static CTTimeNodeList parse(XMLInputStream xMLInputStream) {
            return (CTTimeNodeList) POIXMLTypeLoader.parse(xMLInputStream, CTTimeNodeList.type, (XmlOptions) null);
        }

        public static CTTimeNodeList parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTimeNodeList) POIXMLTypeLoader.parse(xMLInputStream, CTTimeNodeList.type, xmlOptions);
        }

        public static CTTimeNodeList parse(Node node) {
            return (CTTimeNodeList) POIXMLTypeLoader.parse(node, CTTimeNodeList.type, (XmlOptions) null);
        }

        public static CTTimeNodeList parse(Node node, XmlOptions xmlOptions) {
            return (CTTimeNodeList) POIXMLTypeLoader.parse(node, CTTimeNodeList.type, xmlOptions);
        }
    }

    CTTLAnimateBehavior addNewAnim();

    CTTLAnimateColorBehavior addNewAnimClr();

    CTTLAnimateEffectBehavior addNewAnimEffect();

    CTTLAnimateMotionBehavior addNewAnimMotion();

    CTTLAnimateRotationBehavior addNewAnimRot();

    CTTLAnimateScaleBehavior addNewAnimScale();

    CTTLMediaNodeAudio addNewAudio();

    CTTLCommandBehavior addNewCmd();

    CTTLTimeNodeExclusive addNewExcl();

    CTTLTimeNodeParallel addNewPar();

    CTTLTimeNodeSequence addNewSeq();

    CTTLSetBehavior addNewSet();

    CTTLMediaNodeVideo addNewVideo();

    CTTLAnimateBehavior getAnimArray(int i);

    CTTLAnimateBehavior[] getAnimArray();

    CTTLAnimateColorBehavior getAnimClrArray(int i);

    CTTLAnimateColorBehavior[] getAnimClrArray();

    List<CTTLAnimateColorBehavior> getAnimClrList();

    CTTLAnimateEffectBehavior getAnimEffectArray(int i);

    CTTLAnimateEffectBehavior[] getAnimEffectArray();

    List<CTTLAnimateEffectBehavior> getAnimEffectList();

    List<CTTLAnimateBehavior> getAnimList();

    CTTLAnimateMotionBehavior getAnimMotionArray(int i);

    CTTLAnimateMotionBehavior[] getAnimMotionArray();

    List<CTTLAnimateMotionBehavior> getAnimMotionList();

    CTTLAnimateRotationBehavior getAnimRotArray(int i);

    CTTLAnimateRotationBehavior[] getAnimRotArray();

    List<CTTLAnimateRotationBehavior> getAnimRotList();

    CTTLAnimateScaleBehavior getAnimScaleArray(int i);

    CTTLAnimateScaleBehavior[] getAnimScaleArray();

    List<CTTLAnimateScaleBehavior> getAnimScaleList();

    CTTLMediaNodeAudio getAudioArray(int i);

    CTTLMediaNodeAudio[] getAudioArray();

    List<CTTLMediaNodeAudio> getAudioList();

    CTTLCommandBehavior getCmdArray(int i);

    CTTLCommandBehavior[] getCmdArray();

    List<CTTLCommandBehavior> getCmdList();

    CTTLTimeNodeExclusive getExclArray(int i);

    CTTLTimeNodeExclusive[] getExclArray();

    List<CTTLTimeNodeExclusive> getExclList();

    CTTLTimeNodeParallel getParArray(int i);

    CTTLTimeNodeParallel[] getParArray();

    List<CTTLTimeNodeParallel> getParList();

    CTTLTimeNodeSequence getSeqArray(int i);

    CTTLTimeNodeSequence[] getSeqArray();

    List<CTTLTimeNodeSequence> getSeqList();

    CTTLSetBehavior getSetArray(int i);

    CTTLSetBehavior[] getSetArray();

    List<CTTLSetBehavior> getSetList();

    CTTLMediaNodeVideo getVideoArray(int i);

    CTTLMediaNodeVideo[] getVideoArray();

    List<CTTLMediaNodeVideo> getVideoList();

    CTTLAnimateBehavior insertNewAnim(int i);

    CTTLAnimateColorBehavior insertNewAnimClr(int i);

    CTTLAnimateEffectBehavior insertNewAnimEffect(int i);

    CTTLAnimateMotionBehavior insertNewAnimMotion(int i);

    CTTLAnimateRotationBehavior insertNewAnimRot(int i);

    CTTLAnimateScaleBehavior insertNewAnimScale(int i);

    CTTLMediaNodeAudio insertNewAudio(int i);

    CTTLCommandBehavior insertNewCmd(int i);

    CTTLTimeNodeExclusive insertNewExcl(int i);

    CTTLTimeNodeParallel insertNewPar(int i);

    CTTLTimeNodeSequence insertNewSeq(int i);

    CTTLSetBehavior insertNewSet(int i);

    CTTLMediaNodeVideo insertNewVideo(int i);

    void removeAnim(int i);

    void removeAnimClr(int i);

    void removeAnimEffect(int i);

    void removeAnimMotion(int i);

    void removeAnimRot(int i);

    void removeAnimScale(int i);

    void removeAudio(int i);

    void removeCmd(int i);

    void removeExcl(int i);

    void removePar(int i);

    void removeSeq(int i);

    void removeSet(int i);

    void removeVideo(int i);

    void setAnimArray(int i, CTTLAnimateBehavior cTTLAnimateBehavior);

    void setAnimArray(CTTLAnimateBehavior[] cTTLAnimateBehaviorArr);

    void setAnimClrArray(int i, CTTLAnimateColorBehavior cTTLAnimateColorBehavior);

    void setAnimClrArray(CTTLAnimateColorBehavior[] cTTLAnimateColorBehaviorArr);

    void setAnimEffectArray(int i, CTTLAnimateEffectBehavior cTTLAnimateEffectBehavior);

    void setAnimEffectArray(CTTLAnimateEffectBehavior[] cTTLAnimateEffectBehaviorArr);

    void setAnimMotionArray(int i, CTTLAnimateMotionBehavior cTTLAnimateMotionBehavior);

    void setAnimMotionArray(CTTLAnimateMotionBehavior[] cTTLAnimateMotionBehaviorArr);

    void setAnimRotArray(int i, CTTLAnimateRotationBehavior cTTLAnimateRotationBehavior);

    void setAnimRotArray(CTTLAnimateRotationBehavior[] cTTLAnimateRotationBehaviorArr);

    void setAnimScaleArray(int i, CTTLAnimateScaleBehavior cTTLAnimateScaleBehavior);

    void setAnimScaleArray(CTTLAnimateScaleBehavior[] cTTLAnimateScaleBehaviorArr);

    void setAudioArray(int i, CTTLMediaNodeAudio cTTLMediaNodeAudio);

    void setAudioArray(CTTLMediaNodeAudio[] cTTLMediaNodeAudioArr);

    void setCmdArray(int i, CTTLCommandBehavior cTTLCommandBehavior);

    void setCmdArray(CTTLCommandBehavior[] cTTLCommandBehaviorArr);

    void setExclArray(int i, CTTLTimeNodeExclusive cTTLTimeNodeExclusive);

    void setExclArray(CTTLTimeNodeExclusive[] cTTLTimeNodeExclusiveArr);

    void setParArray(int i, CTTLTimeNodeParallel cTTLTimeNodeParallel);

    void setParArray(CTTLTimeNodeParallel[] cTTLTimeNodeParallelArr);

    void setSeqArray(int i, CTTLTimeNodeSequence cTTLTimeNodeSequence);

    void setSeqArray(CTTLTimeNodeSequence[] cTTLTimeNodeSequenceArr);

    void setSetArray(int i, CTTLSetBehavior cTTLSetBehavior);

    void setSetArray(CTTLSetBehavior[] cTTLSetBehaviorArr);

    void setVideoArray(int i, CTTLMediaNodeVideo cTTLMediaNodeVideo);

    void setVideoArray(CTTLMediaNodeVideo[] cTTLMediaNodeVideoArr);

    int sizeOfAnimArray();

    int sizeOfAnimClrArray();

    int sizeOfAnimEffectArray();

    int sizeOfAnimMotionArray();

    int sizeOfAnimRotArray();

    int sizeOfAnimScaleArray();

    int sizeOfAudioArray();

    int sizeOfCmdArray();

    int sizeOfExclArray();

    int sizeOfParArray();

    int sizeOfSeqArray();

    int sizeOfSetArray();

    int sizeOfVideoArray();
}
