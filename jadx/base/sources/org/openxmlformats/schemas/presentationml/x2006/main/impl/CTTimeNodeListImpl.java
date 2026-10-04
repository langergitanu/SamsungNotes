package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLAnimateBehavior;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLAnimateColorBehavior;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLAnimateEffectBehavior;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLAnimateMotionBehavior;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLAnimateRotationBehavior;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLAnimateScaleBehavior;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLCommandBehavior;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLMediaNodeAudio;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLMediaNodeVideo;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLSetBehavior;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeNodeExclusive;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeNodeParallel;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeNodeSequence;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList;

/* JADX INFO: loaded from: classes11.dex */
public class CTTimeNodeListImpl extends XmlComplexContentImpl implements CTTimeNodeList {
    private static final QName PAR$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "par");
    private static final QName SEQ$2 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", RtspHeaders.Values.SEQ);
    private static final QName EXCL$4 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "excl");
    private static final QName ANIM$6 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "anim");
    private static final QName ANIMCLR$8 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "animClr");
    private static final QName ANIMEFFECT$10 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "animEffect");
    private static final QName ANIMMOTION$12 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "animMotion");
    private static final QName ANIMROT$14 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "animRot");
    private static final QName ANIMSCALE$16 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "animScale");
    private static final QName CMD$18 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "cmd");
    private static final QName SET$20 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX);
    private static final QName AUDIO$22 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "audio");
    private static final QName VIDEO$24 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", ComposerSAConstants.DETAIL_VIDEO);

    public CTTimeNodeListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateBehavior addNewAnim() {
        CTTLAnimateBehavior cTTLAnimateBehaviorAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateBehaviorAdd_element_user = get_store().add_element_user(ANIM$6);
        }
        return cTTLAnimateBehaviorAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateColorBehavior addNewAnimClr() {
        CTTLAnimateColorBehavior cTTLAnimateColorBehaviorAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateColorBehaviorAdd_element_user = get_store().add_element_user(ANIMCLR$8);
        }
        return cTTLAnimateColorBehaviorAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateEffectBehavior addNewAnimEffect() {
        CTTLAnimateEffectBehavior cTTLAnimateEffectBehaviorAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateEffectBehaviorAdd_element_user = get_store().add_element_user(ANIMEFFECT$10);
        }
        return cTTLAnimateEffectBehaviorAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateMotionBehavior addNewAnimMotion() {
        CTTLAnimateMotionBehavior cTTLAnimateMotionBehaviorAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateMotionBehaviorAdd_element_user = get_store().add_element_user(ANIMMOTION$12);
        }
        return cTTLAnimateMotionBehaviorAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateRotationBehavior addNewAnimRot() {
        CTTLAnimateRotationBehavior cTTLAnimateRotationBehaviorAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateRotationBehaviorAdd_element_user = get_store().add_element_user(ANIMROT$14);
        }
        return cTTLAnimateRotationBehaviorAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateScaleBehavior addNewAnimScale() {
        CTTLAnimateScaleBehavior cTTLAnimateScaleBehaviorAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateScaleBehaviorAdd_element_user = get_store().add_element_user(ANIMSCALE$16);
        }
        return cTTLAnimateScaleBehaviorAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLMediaNodeAudio addNewAudio() {
        CTTLMediaNodeAudio cTTLMediaNodeAudio;
        synchronized (monitor()) {
            check_orphaned();
            cTTLMediaNodeAudio = (CTTLMediaNodeAudio) get_store().add_element_user(AUDIO$22);
        }
        return cTTLMediaNodeAudio;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLCommandBehavior addNewCmd() {
        CTTLCommandBehavior cTTLCommandBehaviorAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLCommandBehaviorAdd_element_user = get_store().add_element_user(CMD$18);
        }
        return cTTLCommandBehaviorAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLTimeNodeExclusive addNewExcl() {
        CTTLTimeNodeExclusive cTTLTimeNodeExclusiveAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeNodeExclusiveAdd_element_user = get_store().add_element_user(EXCL$4);
        }
        return cTTLTimeNodeExclusiveAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLTimeNodeParallel addNewPar() {
        CTTLTimeNodeParallel cTTLTimeNodeParallel;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeNodeParallel = (CTTLTimeNodeParallel) get_store().add_element_user(PAR$0);
        }
        return cTTLTimeNodeParallel;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLTimeNodeSequence addNewSeq() {
        CTTLTimeNodeSequence cTTLTimeNodeSequenceAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeNodeSequenceAdd_element_user = get_store().add_element_user(SEQ$2);
        }
        return cTTLTimeNodeSequenceAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLSetBehavior addNewSet() {
        CTTLSetBehavior cTTLSetBehaviorAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLSetBehaviorAdd_element_user = get_store().add_element_user(SET$20);
        }
        return cTTLSetBehaviorAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLMediaNodeVideo addNewVideo() {
        CTTLMediaNodeVideo cTTLMediaNodeVideo;
        synchronized (monitor()) {
            check_orphaned();
            cTTLMediaNodeVideo = (CTTLMediaNodeVideo) get_store().add_element_user(VIDEO$24);
        }
        return cTTLMediaNodeVideo;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateBehavior getAnimArray(int i) {
        CTTLAnimateBehavior cTTLAnimateBehaviorFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTLAnimateBehaviorFind_element_user = get_store().find_element_user(ANIM$6, i);
                if (cTTLAnimateBehaviorFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTLAnimateBehaviorFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateColorBehavior getAnimClrArray(int i) {
        CTTLAnimateColorBehavior cTTLAnimateColorBehaviorFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTLAnimateColorBehaviorFind_element_user = get_store().find_element_user(ANIMCLR$8, i);
                if (cTTLAnimateColorBehaviorFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTLAnimateColorBehaviorFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLAnimateColorBehavior> getAnimClrList() {
        AbstractList<CTTLAnimateColorBehavior> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTTLAnimateColorBehavior>() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.CTTimeNodeListImpl.1AnimClrList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTTimeNodeListImpl.this.sizeOfAnimClrArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTTLAnimateColorBehavior cTTLAnimateColorBehavior) {
                    CTTimeNodeListImpl.this.insertNewAnimClr(i).set(cTTLAnimateColorBehavior);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLAnimateColorBehavior get(int i) {
                    return CTTimeNodeListImpl.this.getAnimClrArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLAnimateColorBehavior remove(int i) {
                    CTTLAnimateColorBehavior animClrArray = CTTimeNodeListImpl.this.getAnimClrArray(i);
                    CTTimeNodeListImpl.this.removeAnimClr(i);
                    return animClrArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLAnimateColorBehavior set(int i, CTTLAnimateColorBehavior cTTLAnimateColorBehavior) {
                    CTTLAnimateColorBehavior animClrArray = CTTimeNodeListImpl.this.getAnimClrArray(i);
                    CTTimeNodeListImpl.this.setAnimClrArray(i, cTTLAnimateColorBehavior);
                    return animClrArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateEffectBehavior getAnimEffectArray(int i) {
        CTTLAnimateEffectBehavior cTTLAnimateEffectBehaviorFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTLAnimateEffectBehaviorFind_element_user = get_store().find_element_user(ANIMEFFECT$10, i);
                if (cTTLAnimateEffectBehaviorFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTLAnimateEffectBehaviorFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLAnimateEffectBehavior> getAnimEffectList() {
        AbstractList<CTTLAnimateEffectBehavior> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTTLAnimateEffectBehavior>() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.CTTimeNodeListImpl.1AnimEffectList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTTimeNodeListImpl.this.sizeOfAnimEffectArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTTLAnimateEffectBehavior cTTLAnimateEffectBehavior) {
                    CTTimeNodeListImpl.this.insertNewAnimEffect(i).set(cTTLAnimateEffectBehavior);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLAnimateEffectBehavior get(int i) {
                    return CTTimeNodeListImpl.this.getAnimEffectArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLAnimateEffectBehavior remove(int i) {
                    CTTLAnimateEffectBehavior animEffectArray = CTTimeNodeListImpl.this.getAnimEffectArray(i);
                    CTTimeNodeListImpl.this.removeAnimEffect(i);
                    return animEffectArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLAnimateEffectBehavior set(int i, CTTLAnimateEffectBehavior cTTLAnimateEffectBehavior) {
                    CTTLAnimateEffectBehavior animEffectArray = CTTimeNodeListImpl.this.getAnimEffectArray(i);
                    CTTimeNodeListImpl.this.setAnimEffectArray(i, cTTLAnimateEffectBehavior);
                    return animEffectArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLAnimateBehavior> getAnimList() {
        AbstractList<CTTLAnimateBehavior> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTTLAnimateBehavior>() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.CTTimeNodeListImpl.1AnimList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTTimeNodeListImpl.this.sizeOfAnimArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTTLAnimateBehavior cTTLAnimateBehavior) {
                    CTTimeNodeListImpl.this.insertNewAnim(i).set(cTTLAnimateBehavior);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLAnimateBehavior get(int i) {
                    return CTTimeNodeListImpl.this.getAnimArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLAnimateBehavior remove(int i) {
                    CTTLAnimateBehavior animArray = CTTimeNodeListImpl.this.getAnimArray(i);
                    CTTimeNodeListImpl.this.removeAnim(i);
                    return animArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLAnimateBehavior set(int i, CTTLAnimateBehavior cTTLAnimateBehavior) {
                    CTTLAnimateBehavior animArray = CTTimeNodeListImpl.this.getAnimArray(i);
                    CTTimeNodeListImpl.this.setAnimArray(i, cTTLAnimateBehavior);
                    return animArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateMotionBehavior getAnimMotionArray(int i) {
        CTTLAnimateMotionBehavior cTTLAnimateMotionBehaviorFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTLAnimateMotionBehaviorFind_element_user = get_store().find_element_user(ANIMMOTION$12, i);
                if (cTTLAnimateMotionBehaviorFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTLAnimateMotionBehaviorFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLAnimateMotionBehavior> getAnimMotionList() {
        AbstractList<CTTLAnimateMotionBehavior> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTTLAnimateMotionBehavior>() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.CTTimeNodeListImpl.1AnimMotionList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTTimeNodeListImpl.this.sizeOfAnimMotionArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTTLAnimateMotionBehavior cTTLAnimateMotionBehavior) {
                    CTTimeNodeListImpl.this.insertNewAnimMotion(i).set(cTTLAnimateMotionBehavior);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLAnimateMotionBehavior get(int i) {
                    return CTTimeNodeListImpl.this.getAnimMotionArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLAnimateMotionBehavior remove(int i) {
                    CTTLAnimateMotionBehavior animMotionArray = CTTimeNodeListImpl.this.getAnimMotionArray(i);
                    CTTimeNodeListImpl.this.removeAnimMotion(i);
                    return animMotionArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLAnimateMotionBehavior set(int i, CTTLAnimateMotionBehavior cTTLAnimateMotionBehavior) {
                    CTTLAnimateMotionBehavior animMotionArray = CTTimeNodeListImpl.this.getAnimMotionArray(i);
                    CTTimeNodeListImpl.this.setAnimMotionArray(i, cTTLAnimateMotionBehavior);
                    return animMotionArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateRotationBehavior getAnimRotArray(int i) {
        CTTLAnimateRotationBehavior cTTLAnimateRotationBehaviorFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTLAnimateRotationBehaviorFind_element_user = get_store().find_element_user(ANIMROT$14, i);
                if (cTTLAnimateRotationBehaviorFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTLAnimateRotationBehaviorFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLAnimateRotationBehavior> getAnimRotList() {
        AbstractList<CTTLAnimateRotationBehavior> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTTLAnimateRotationBehavior>() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.CTTimeNodeListImpl.1AnimRotList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTTimeNodeListImpl.this.sizeOfAnimRotArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTTLAnimateRotationBehavior cTTLAnimateRotationBehavior) {
                    CTTimeNodeListImpl.this.insertNewAnimRot(i).set(cTTLAnimateRotationBehavior);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLAnimateRotationBehavior get(int i) {
                    return CTTimeNodeListImpl.this.getAnimRotArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLAnimateRotationBehavior remove(int i) {
                    CTTLAnimateRotationBehavior animRotArray = CTTimeNodeListImpl.this.getAnimRotArray(i);
                    CTTimeNodeListImpl.this.removeAnimRot(i);
                    return animRotArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLAnimateRotationBehavior set(int i, CTTLAnimateRotationBehavior cTTLAnimateRotationBehavior) {
                    CTTLAnimateRotationBehavior animRotArray = CTTimeNodeListImpl.this.getAnimRotArray(i);
                    CTTimeNodeListImpl.this.setAnimRotArray(i, cTTLAnimateRotationBehavior);
                    return animRotArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateScaleBehavior getAnimScaleArray(int i) {
        CTTLAnimateScaleBehavior cTTLAnimateScaleBehaviorFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTLAnimateScaleBehaviorFind_element_user = get_store().find_element_user(ANIMSCALE$16, i);
                if (cTTLAnimateScaleBehaviorFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTLAnimateScaleBehaviorFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLAnimateScaleBehavior> getAnimScaleList() {
        AbstractList<CTTLAnimateScaleBehavior> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTTLAnimateScaleBehavior>() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.CTTimeNodeListImpl.1AnimScaleList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTTimeNodeListImpl.this.sizeOfAnimScaleArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTTLAnimateScaleBehavior cTTLAnimateScaleBehavior) {
                    CTTimeNodeListImpl.this.insertNewAnimScale(i).set(cTTLAnimateScaleBehavior);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLAnimateScaleBehavior get(int i) {
                    return CTTimeNodeListImpl.this.getAnimScaleArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLAnimateScaleBehavior remove(int i) {
                    CTTLAnimateScaleBehavior animScaleArray = CTTimeNodeListImpl.this.getAnimScaleArray(i);
                    CTTimeNodeListImpl.this.removeAnimScale(i);
                    return animScaleArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLAnimateScaleBehavior set(int i, CTTLAnimateScaleBehavior cTTLAnimateScaleBehavior) {
                    CTTLAnimateScaleBehavior animScaleArray = CTTimeNodeListImpl.this.getAnimScaleArray(i);
                    CTTimeNodeListImpl.this.setAnimScaleArray(i, cTTLAnimateScaleBehavior);
                    return animScaleArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLMediaNodeAudio getAudioArray(int i) {
        CTTLMediaNodeAudio cTTLMediaNodeAudio;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTLMediaNodeAudio = (CTTLMediaNodeAudio) get_store().find_element_user(AUDIO$22, i);
                if (cTTLMediaNodeAudio == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTLMediaNodeAudio;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLMediaNodeAudio> getAudioList() {
        AbstractList<CTTLMediaNodeAudio> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTTLMediaNodeAudio>() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.CTTimeNodeListImpl.1AudioList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTTimeNodeListImpl.this.sizeOfAudioArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTTLMediaNodeAudio cTTLMediaNodeAudio) {
                    CTTimeNodeListImpl.this.insertNewAudio(i).set(cTTLMediaNodeAudio);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLMediaNodeAudio get(int i) {
                    return CTTimeNodeListImpl.this.getAudioArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLMediaNodeAudio remove(int i) {
                    CTTLMediaNodeAudio audioArray = CTTimeNodeListImpl.this.getAudioArray(i);
                    CTTimeNodeListImpl.this.removeAudio(i);
                    return audioArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLMediaNodeAudio set(int i, CTTLMediaNodeAudio cTTLMediaNodeAudio) {
                    CTTLMediaNodeAudio audioArray = CTTimeNodeListImpl.this.getAudioArray(i);
                    CTTimeNodeListImpl.this.setAudioArray(i, cTTLMediaNodeAudio);
                    return audioArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLCommandBehavior getCmdArray(int i) {
        CTTLCommandBehavior cTTLCommandBehaviorFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTLCommandBehaviorFind_element_user = get_store().find_element_user(CMD$18, i);
                if (cTTLCommandBehaviorFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTLCommandBehaviorFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLCommandBehavior> getCmdList() {
        AbstractList<CTTLCommandBehavior> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTTLCommandBehavior>() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.CTTimeNodeListImpl.1CmdList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTTimeNodeListImpl.this.sizeOfCmdArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTTLCommandBehavior cTTLCommandBehavior) {
                    CTTimeNodeListImpl.this.insertNewCmd(i).set(cTTLCommandBehavior);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLCommandBehavior get(int i) {
                    return CTTimeNodeListImpl.this.getCmdArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLCommandBehavior remove(int i) {
                    CTTLCommandBehavior cmdArray = CTTimeNodeListImpl.this.getCmdArray(i);
                    CTTimeNodeListImpl.this.removeCmd(i);
                    return cmdArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLCommandBehavior set(int i, CTTLCommandBehavior cTTLCommandBehavior) {
                    CTTLCommandBehavior cmdArray = CTTimeNodeListImpl.this.getCmdArray(i);
                    CTTimeNodeListImpl.this.setCmdArray(i, cTTLCommandBehavior);
                    return cmdArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLTimeNodeExclusive getExclArray(int i) {
        CTTLTimeNodeExclusive cTTLTimeNodeExclusiveFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTLTimeNodeExclusiveFind_element_user = get_store().find_element_user(EXCL$4, i);
                if (cTTLTimeNodeExclusiveFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTLTimeNodeExclusiveFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLTimeNodeExclusive> getExclList() {
        AbstractList<CTTLTimeNodeExclusive> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTTLTimeNodeExclusive>() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.CTTimeNodeListImpl.1ExclList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTTimeNodeListImpl.this.sizeOfExclArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTTLTimeNodeExclusive cTTLTimeNodeExclusive) {
                    CTTimeNodeListImpl.this.insertNewExcl(i).set(cTTLTimeNodeExclusive);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLTimeNodeExclusive get(int i) {
                    return CTTimeNodeListImpl.this.getExclArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLTimeNodeExclusive remove(int i) {
                    CTTLTimeNodeExclusive exclArray = CTTimeNodeListImpl.this.getExclArray(i);
                    CTTimeNodeListImpl.this.removeExcl(i);
                    return exclArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLTimeNodeExclusive set(int i, CTTLTimeNodeExclusive cTTLTimeNodeExclusive) {
                    CTTLTimeNodeExclusive exclArray = CTTimeNodeListImpl.this.getExclArray(i);
                    CTTimeNodeListImpl.this.setExclArray(i, cTTLTimeNodeExclusive);
                    return exclArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLTimeNodeParallel getParArray(int i) {
        CTTLTimeNodeParallel cTTLTimeNodeParallel;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTLTimeNodeParallel = (CTTLTimeNodeParallel) get_store().find_element_user(PAR$0, i);
                if (cTTLTimeNodeParallel == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTLTimeNodeParallel;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLTimeNodeParallel> getParList() {
        AbstractList<CTTLTimeNodeParallel> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTTLTimeNodeParallel>() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.CTTimeNodeListImpl.1ParList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTTimeNodeListImpl.this.sizeOfParArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTTLTimeNodeParallel cTTLTimeNodeParallel) {
                    CTTimeNodeListImpl.this.insertNewPar(i).set(cTTLTimeNodeParallel);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLTimeNodeParallel get(int i) {
                    return CTTimeNodeListImpl.this.getParArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLTimeNodeParallel remove(int i) {
                    CTTLTimeNodeParallel parArray = CTTimeNodeListImpl.this.getParArray(i);
                    CTTimeNodeListImpl.this.removePar(i);
                    return parArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLTimeNodeParallel set(int i, CTTLTimeNodeParallel cTTLTimeNodeParallel) {
                    CTTLTimeNodeParallel parArray = CTTimeNodeListImpl.this.getParArray(i);
                    CTTimeNodeListImpl.this.setParArray(i, cTTLTimeNodeParallel);
                    return parArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLTimeNodeSequence getSeqArray(int i) {
        CTTLTimeNodeSequence cTTLTimeNodeSequenceFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTLTimeNodeSequenceFind_element_user = get_store().find_element_user(SEQ$2, i);
                if (cTTLTimeNodeSequenceFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTLTimeNodeSequenceFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLTimeNodeSequence> getSeqList() {
        AbstractList<CTTLTimeNodeSequence> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTTLTimeNodeSequence>() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.CTTimeNodeListImpl.1SeqList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTTimeNodeListImpl.this.sizeOfSeqArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTTLTimeNodeSequence cTTLTimeNodeSequence) {
                    CTTimeNodeListImpl.this.insertNewSeq(i).set(cTTLTimeNodeSequence);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLTimeNodeSequence get(int i) {
                    return CTTimeNodeListImpl.this.getSeqArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLTimeNodeSequence remove(int i) {
                    CTTLTimeNodeSequence seqArray = CTTimeNodeListImpl.this.getSeqArray(i);
                    CTTimeNodeListImpl.this.removeSeq(i);
                    return seqArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLTimeNodeSequence set(int i, CTTLTimeNodeSequence cTTLTimeNodeSequence) {
                    CTTLTimeNodeSequence seqArray = CTTimeNodeListImpl.this.getSeqArray(i);
                    CTTimeNodeListImpl.this.setSeqArray(i, cTTLTimeNodeSequence);
                    return seqArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLSetBehavior getSetArray(int i) {
        CTTLSetBehavior cTTLSetBehaviorFind_element_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTLSetBehaviorFind_element_user = get_store().find_element_user(SET$20, i);
                if (cTTLSetBehaviorFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTLSetBehaviorFind_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLSetBehavior> getSetList() {
        AbstractList<CTTLSetBehavior> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTTLSetBehavior>() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.CTTimeNodeListImpl.1SetList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTTimeNodeListImpl.this.sizeOfSetArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTTLSetBehavior cTTLSetBehavior) {
                    CTTimeNodeListImpl.this.insertNewSet(i).set(cTTLSetBehavior);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLSetBehavior get(int i) {
                    return CTTimeNodeListImpl.this.getSetArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLSetBehavior remove(int i) {
                    CTTLSetBehavior setArray = CTTimeNodeListImpl.this.getSetArray(i);
                    CTTimeNodeListImpl.this.removeSet(i);
                    return setArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLSetBehavior set(int i, CTTLSetBehavior cTTLSetBehavior) {
                    CTTLSetBehavior setArray = CTTimeNodeListImpl.this.getSetArray(i);
                    CTTimeNodeListImpl.this.setSetArray(i, cTTLSetBehavior);
                    return setArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLMediaNodeVideo getVideoArray(int i) {
        CTTLMediaNodeVideo cTTLMediaNodeVideo;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTLMediaNodeVideo = (CTTLMediaNodeVideo) get_store().find_element_user(VIDEO$24, i);
                if (cTTLMediaNodeVideo == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTLMediaNodeVideo;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public List<CTTLMediaNodeVideo> getVideoList() {
        AbstractList<CTTLMediaNodeVideo> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTTLMediaNodeVideo>() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.CTTimeNodeListImpl.1VideoList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTTimeNodeListImpl.this.sizeOfVideoArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTTLMediaNodeVideo cTTLMediaNodeVideo) {
                    CTTimeNodeListImpl.this.insertNewVideo(i).set(cTTLMediaNodeVideo);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLMediaNodeVideo get(int i) {
                    return CTTimeNodeListImpl.this.getVideoArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLMediaNodeVideo remove(int i) {
                    CTTLMediaNodeVideo videoArray = CTTimeNodeListImpl.this.getVideoArray(i);
                    CTTimeNodeListImpl.this.removeVideo(i);
                    return videoArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLMediaNodeVideo set(int i, CTTLMediaNodeVideo cTTLMediaNodeVideo) {
                    CTTLMediaNodeVideo videoArray = CTTimeNodeListImpl.this.getVideoArray(i);
                    CTTimeNodeListImpl.this.setVideoArray(i, cTTLMediaNodeVideo);
                    return videoArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateBehavior insertNewAnim(int i) {
        CTTLAnimateBehavior cTTLAnimateBehaviorInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateBehaviorInsert_element_user = get_store().insert_element_user(ANIM$6, i);
        }
        return cTTLAnimateBehaviorInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateColorBehavior insertNewAnimClr(int i) {
        CTTLAnimateColorBehavior cTTLAnimateColorBehaviorInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateColorBehaviorInsert_element_user = get_store().insert_element_user(ANIMCLR$8, i);
        }
        return cTTLAnimateColorBehaviorInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateEffectBehavior insertNewAnimEffect(int i) {
        CTTLAnimateEffectBehavior cTTLAnimateEffectBehaviorInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateEffectBehaviorInsert_element_user = get_store().insert_element_user(ANIMEFFECT$10, i);
        }
        return cTTLAnimateEffectBehaviorInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateMotionBehavior insertNewAnimMotion(int i) {
        CTTLAnimateMotionBehavior cTTLAnimateMotionBehaviorInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateMotionBehaviorInsert_element_user = get_store().insert_element_user(ANIMMOTION$12, i);
        }
        return cTTLAnimateMotionBehaviorInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateRotationBehavior insertNewAnimRot(int i) {
        CTTLAnimateRotationBehavior cTTLAnimateRotationBehaviorInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateRotationBehaviorInsert_element_user = get_store().insert_element_user(ANIMROT$14, i);
        }
        return cTTLAnimateRotationBehaviorInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateScaleBehavior insertNewAnimScale(int i) {
        CTTLAnimateScaleBehavior cTTLAnimateScaleBehaviorInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLAnimateScaleBehaviorInsert_element_user = get_store().insert_element_user(ANIMSCALE$16, i);
        }
        return cTTLAnimateScaleBehaviorInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLMediaNodeAudio insertNewAudio(int i) {
        CTTLMediaNodeAudio cTTLMediaNodeAudio;
        synchronized (monitor()) {
            check_orphaned();
            cTTLMediaNodeAudio = (CTTLMediaNodeAudio) get_store().insert_element_user(AUDIO$22, i);
        }
        return cTTLMediaNodeAudio;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLCommandBehavior insertNewCmd(int i) {
        CTTLCommandBehavior cTTLCommandBehaviorInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLCommandBehaviorInsert_element_user = get_store().insert_element_user(CMD$18, i);
        }
        return cTTLCommandBehaviorInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLTimeNodeExclusive insertNewExcl(int i) {
        CTTLTimeNodeExclusive cTTLTimeNodeExclusiveInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeNodeExclusiveInsert_element_user = get_store().insert_element_user(EXCL$4, i);
        }
        return cTTLTimeNodeExclusiveInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLTimeNodeParallel insertNewPar(int i) {
        CTTLTimeNodeParallel cTTLTimeNodeParallel;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeNodeParallel = (CTTLTimeNodeParallel) get_store().insert_element_user(PAR$0, i);
        }
        return cTTLTimeNodeParallel;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLTimeNodeSequence insertNewSeq(int i) {
        CTTLTimeNodeSequence cTTLTimeNodeSequenceInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeNodeSequenceInsert_element_user = get_store().insert_element_user(SEQ$2, i);
        }
        return cTTLTimeNodeSequenceInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLSetBehavior insertNewSet(int i) {
        CTTLSetBehavior cTTLSetBehaviorInsert_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLSetBehaviorInsert_element_user = get_store().insert_element_user(SET$20, i);
        }
        return cTTLSetBehaviorInsert_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLMediaNodeVideo insertNewVideo(int i) {
        CTTLMediaNodeVideo cTTLMediaNodeVideo;
        synchronized (monitor()) {
            check_orphaned();
            cTTLMediaNodeVideo = (CTTLMediaNodeVideo) get_store().insert_element_user(VIDEO$24, i);
        }
        return cTTLMediaNodeVideo;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removeAnim(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ANIM$6, i);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removeAnimClr(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ANIMCLR$8, i);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removeAnimEffect(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ANIMEFFECT$10, i);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removeAnimMotion(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ANIMMOTION$12, i);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removeAnimRot(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ANIMROT$14, i);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removeAnimScale(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ANIMSCALE$16, i);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removeAudio(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(AUDIO$22, i);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removeCmd(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(CMD$18, i);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removeExcl(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXCL$4, i);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removePar(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PAR$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removeSeq(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SEQ$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removeSet(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SET$20, i);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void removeVideo(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(VIDEO$24, i);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAnimArray(int i, CTTLAnimateBehavior cTTLAnimateBehavior) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTLAnimateBehavior cTTLAnimateBehaviorFind_element_user = get_store().find_element_user(ANIM$6, i);
                if (cTTLAnimateBehaviorFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTTLAnimateBehaviorFind_element_user.set(cTTLAnimateBehavior);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAnimClrArray(int i, CTTLAnimateColorBehavior cTTLAnimateColorBehavior) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTLAnimateColorBehavior cTTLAnimateColorBehaviorFind_element_user = get_store().find_element_user(ANIMCLR$8, i);
                if (cTTLAnimateColorBehaviorFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTTLAnimateColorBehaviorFind_element_user.set(cTTLAnimateColorBehavior);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAnimEffectArray(int i, CTTLAnimateEffectBehavior cTTLAnimateEffectBehavior) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTLAnimateEffectBehavior cTTLAnimateEffectBehaviorFind_element_user = get_store().find_element_user(ANIMEFFECT$10, i);
                if (cTTLAnimateEffectBehaviorFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTTLAnimateEffectBehaviorFind_element_user.set(cTTLAnimateEffectBehavior);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAnimMotionArray(int i, CTTLAnimateMotionBehavior cTTLAnimateMotionBehavior) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTLAnimateMotionBehavior cTTLAnimateMotionBehaviorFind_element_user = get_store().find_element_user(ANIMMOTION$12, i);
                if (cTTLAnimateMotionBehaviorFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTTLAnimateMotionBehaviorFind_element_user.set(cTTLAnimateMotionBehavior);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAnimRotArray(int i, CTTLAnimateRotationBehavior cTTLAnimateRotationBehavior) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTLAnimateRotationBehavior cTTLAnimateRotationBehaviorFind_element_user = get_store().find_element_user(ANIMROT$14, i);
                if (cTTLAnimateRotationBehaviorFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTTLAnimateRotationBehaviorFind_element_user.set(cTTLAnimateRotationBehavior);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAnimScaleArray(int i, CTTLAnimateScaleBehavior cTTLAnimateScaleBehavior) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTLAnimateScaleBehavior cTTLAnimateScaleBehaviorFind_element_user = get_store().find_element_user(ANIMSCALE$16, i);
                if (cTTLAnimateScaleBehaviorFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTTLAnimateScaleBehaviorFind_element_user.set(cTTLAnimateScaleBehavior);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAudioArray(int i, CTTLMediaNodeAudio cTTLMediaNodeAudio) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTLMediaNodeAudio cTTLMediaNodeAudio2 = (CTTLMediaNodeAudio) get_store().find_element_user(AUDIO$22, i);
                if (cTTLMediaNodeAudio2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTTLMediaNodeAudio2.set(cTTLMediaNodeAudio);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setCmdArray(int i, CTTLCommandBehavior cTTLCommandBehavior) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTLCommandBehavior cTTLCommandBehaviorFind_element_user = get_store().find_element_user(CMD$18, i);
                if (cTTLCommandBehaviorFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTTLCommandBehaviorFind_element_user.set(cTTLCommandBehavior);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setExclArray(int i, CTTLTimeNodeExclusive cTTLTimeNodeExclusive) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTLTimeNodeExclusive cTTLTimeNodeExclusiveFind_element_user = get_store().find_element_user(EXCL$4, i);
                if (cTTLTimeNodeExclusiveFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTTLTimeNodeExclusiveFind_element_user.set(cTTLTimeNodeExclusive);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setParArray(int i, CTTLTimeNodeParallel cTTLTimeNodeParallel) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTLTimeNodeParallel cTTLTimeNodeParallel2 = (CTTLTimeNodeParallel) get_store().find_element_user(PAR$0, i);
                if (cTTLTimeNodeParallel2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTTLTimeNodeParallel2.set(cTTLTimeNodeParallel);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setSeqArray(int i, CTTLTimeNodeSequence cTTLTimeNodeSequence) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTLTimeNodeSequence cTTLTimeNodeSequenceFind_element_user = get_store().find_element_user(SEQ$2, i);
                if (cTTLTimeNodeSequenceFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTTLTimeNodeSequenceFind_element_user.set(cTTLTimeNodeSequence);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setSetArray(int i, CTTLSetBehavior cTTLSetBehavior) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTLSetBehavior cTTLSetBehaviorFind_element_user = get_store().find_element_user(SET$20, i);
                if (cTTLSetBehaviorFind_element_user == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTTLSetBehaviorFind_element_user.set(cTTLSetBehavior);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setVideoArray(int i, CTTLMediaNodeVideo cTTLMediaNodeVideo) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTLMediaNodeVideo cTTLMediaNodeVideo2 = (CTTLMediaNodeVideo) get_store().find_element_user(VIDEO$24, i);
                if (cTTLMediaNodeVideo2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTTLMediaNodeVideo2.set(cTTLMediaNodeVideo);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfAnimArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ANIM$6);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfAnimClrArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ANIMCLR$8);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfAnimEffectArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ANIMEFFECT$10);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfAnimMotionArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ANIMMOTION$12);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfAnimRotArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ANIMROT$14);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfAnimScaleArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ANIMSCALE$16);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfAudioArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(AUDIO$22);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfCmdArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(CMD$18);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfExclArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(EXCL$4);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfParArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PAR$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfSeqArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SEQ$2);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfSetArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(SET$20);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public int sizeOfVideoArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(VIDEO$24);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateBehavior[] getAnimArray() {
        CTTLAnimateBehavior[] cTTLAnimateBehaviorArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ANIM$6, arrayList);
            cTTLAnimateBehaviorArr = new CTTLAnimateBehavior[arrayList.size()];
            arrayList.toArray(cTTLAnimateBehaviorArr);
        }
        return cTTLAnimateBehaviorArr;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateColorBehavior[] getAnimClrArray() {
        CTTLAnimateColorBehavior[] cTTLAnimateColorBehaviorArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ANIMCLR$8, arrayList);
            cTTLAnimateColorBehaviorArr = new CTTLAnimateColorBehavior[arrayList.size()];
            arrayList.toArray(cTTLAnimateColorBehaviorArr);
        }
        return cTTLAnimateColorBehaviorArr;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateEffectBehavior[] getAnimEffectArray() {
        CTTLAnimateEffectBehavior[] cTTLAnimateEffectBehaviorArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ANIMEFFECT$10, arrayList);
            cTTLAnimateEffectBehaviorArr = new CTTLAnimateEffectBehavior[arrayList.size()];
            arrayList.toArray(cTTLAnimateEffectBehaviorArr);
        }
        return cTTLAnimateEffectBehaviorArr;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateMotionBehavior[] getAnimMotionArray() {
        CTTLAnimateMotionBehavior[] cTTLAnimateMotionBehaviorArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ANIMMOTION$12, arrayList);
            cTTLAnimateMotionBehaviorArr = new CTTLAnimateMotionBehavior[arrayList.size()];
            arrayList.toArray(cTTLAnimateMotionBehaviorArr);
        }
        return cTTLAnimateMotionBehaviorArr;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateRotationBehavior[] getAnimRotArray() {
        CTTLAnimateRotationBehavior[] cTTLAnimateRotationBehaviorArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ANIMROT$14, arrayList);
            cTTLAnimateRotationBehaviorArr = new CTTLAnimateRotationBehavior[arrayList.size()];
            arrayList.toArray(cTTLAnimateRotationBehaviorArr);
        }
        return cTTLAnimateRotationBehaviorArr;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLAnimateScaleBehavior[] getAnimScaleArray() {
        CTTLAnimateScaleBehavior[] cTTLAnimateScaleBehaviorArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ANIMSCALE$16, arrayList);
            cTTLAnimateScaleBehaviorArr = new CTTLAnimateScaleBehavior[arrayList.size()];
            arrayList.toArray(cTTLAnimateScaleBehaviorArr);
        }
        return cTTLAnimateScaleBehaviorArr;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLMediaNodeAudio[] getAudioArray() {
        CTTLMediaNodeAudio[] cTTLMediaNodeAudioArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(AUDIO$22, arrayList);
            cTTLMediaNodeAudioArr = new CTTLMediaNodeAudio[arrayList.size()];
            arrayList.toArray(cTTLMediaNodeAudioArr);
        }
        return cTTLMediaNodeAudioArr;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLCommandBehavior[] getCmdArray() {
        CTTLCommandBehavior[] cTTLCommandBehaviorArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(CMD$18, arrayList);
            cTTLCommandBehaviorArr = new CTTLCommandBehavior[arrayList.size()];
            arrayList.toArray(cTTLCommandBehaviorArr);
        }
        return cTTLCommandBehaviorArr;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLTimeNodeExclusive[] getExclArray() {
        CTTLTimeNodeExclusive[] cTTLTimeNodeExclusiveArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(EXCL$4, arrayList);
            cTTLTimeNodeExclusiveArr = new CTTLTimeNodeExclusive[arrayList.size()];
            arrayList.toArray(cTTLTimeNodeExclusiveArr);
        }
        return cTTLTimeNodeExclusiveArr;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLTimeNodeParallel[] getParArray() {
        CTTLTimeNodeParallel[] cTTLTimeNodeParallelArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PAR$0, arrayList);
            cTTLTimeNodeParallelArr = new CTTLTimeNodeParallel[arrayList.size()];
            arrayList.toArray(cTTLTimeNodeParallelArr);
        }
        return cTTLTimeNodeParallelArr;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLTimeNodeSequence[] getSeqArray() {
        CTTLTimeNodeSequence[] cTTLTimeNodeSequenceArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SEQ$2, arrayList);
            cTTLTimeNodeSequenceArr = new CTTLTimeNodeSequence[arrayList.size()];
            arrayList.toArray(cTTLTimeNodeSequenceArr);
        }
        return cTTLTimeNodeSequenceArr;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLSetBehavior[] getSetArray() {
        CTTLSetBehavior[] cTTLSetBehaviorArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(SET$20, arrayList);
            cTTLSetBehaviorArr = new CTTLSetBehavior[arrayList.size()];
            arrayList.toArray(cTTLSetBehaviorArr);
        }
        return cTTLSetBehaviorArr;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public CTTLMediaNodeVideo[] getVideoArray() {
        CTTLMediaNodeVideo[] cTTLMediaNodeVideoArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(VIDEO$24, arrayList);
            cTTLMediaNodeVideoArr = new CTTLMediaNodeVideo[arrayList.size()];
            arrayList.toArray(cTTLMediaNodeVideoArr);
        }
        return cTTLMediaNodeVideoArr;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAnimArray(CTTLAnimateBehavior[] cTTLAnimateBehaviorArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTTLAnimateBehaviorArr, ANIM$6);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAnimClrArray(CTTLAnimateColorBehavior[] cTTLAnimateColorBehaviorArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTTLAnimateColorBehaviorArr, ANIMCLR$8);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAnimEffectArray(CTTLAnimateEffectBehavior[] cTTLAnimateEffectBehaviorArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTTLAnimateEffectBehaviorArr, ANIMEFFECT$10);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAnimMotionArray(CTTLAnimateMotionBehavior[] cTTLAnimateMotionBehaviorArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTTLAnimateMotionBehaviorArr, ANIMMOTION$12);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAnimRotArray(CTTLAnimateRotationBehavior[] cTTLAnimateRotationBehaviorArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTTLAnimateRotationBehaviorArr, ANIMROT$14);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAnimScaleArray(CTTLAnimateScaleBehavior[] cTTLAnimateScaleBehaviorArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTTLAnimateScaleBehaviorArr, ANIMSCALE$16);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setAudioArray(CTTLMediaNodeAudio[] cTTLMediaNodeAudioArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTLMediaNodeAudioArr, AUDIO$22);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setCmdArray(CTTLCommandBehavior[] cTTLCommandBehaviorArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTTLCommandBehaviorArr, CMD$18);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setExclArray(CTTLTimeNodeExclusive[] cTTLTimeNodeExclusiveArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTTLTimeNodeExclusiveArr, EXCL$4);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setParArray(CTTLTimeNodeParallel[] cTTLTimeNodeParallelArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTLTimeNodeParallelArr, PAR$0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setSeqArray(CTTLTimeNodeSequence[] cTTLTimeNodeSequenceArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTTLTimeNodeSequenceArr, SEQ$2);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setSetArray(CTTLSetBehavior[] cTTLSetBehaviorArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper((XmlObject[]) cTTLSetBehaviorArr, SET$20);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTimeNodeList
    public void setVideoArray(CTTLMediaNodeVideo[] cTTLMediaNodeVideoArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTLMediaNodeVideoArr, VIDEO$24);
        }
    }
}
