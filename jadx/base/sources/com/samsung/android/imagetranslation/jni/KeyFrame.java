package com.samsung.android.imagetranslation.jni;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class KeyFrame implements Cloneable {
    private static final float DP_TO_PX_FACTOR = 5.0f;
    private CopyOnWriteArrayList<SceneText> mSceneTexts;
    private String mSrcLang;
    private String mTRLReqSrcLang;
    private String mTarLang;
    private int originalImageHeight;
    private int originalImageWidth;
    private long mFrameId = 0;
    private byte[] mBuffer = null;
    private FrameFormat mFrameFormat = FrameFormat.NV21;
    private boolean mIsMobile = false;
    private int mSTRCP = -1;
    private int mTRLCP = -1;
    private TRL_UNIT mTRLUnit = TRL_UNIT.LINE;
    private int mWidth = 0;
    private int mHeight = 0;
    private int mRotation = 0;
    private float mResizeRatio = 1.0f;
    private List<String> mSortedSrcLangList = null;
    private List<String> mTRLReqStr = null;
    private List<String> mTRLReqLangs = null;
    private List<Double> mTRLReqLangProportions = null;
    private List<String> mTRLResultStr = null;
    private int mGoogleBlockCount = 0;
    private int mBaseImageHash = 0;
    private float mDpScaleFactor = DP_TO_PX_FACTOR;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum FrameFormat {
        NV21,
        JPEG
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum TRL_UNIT {
        PARAGRAPH,
        LINE,
        GOOGLE_BLOCK
    }

    public KeyFrame() {
        this.mSceneTexts = null;
        this.mSceneTexts = new CopyOnWriteArrayList<>();
    }

    private int countGoogleBlocks() {
        HashSet hashSet = new HashSet();
        Iterator<SceneText> it = this.mSceneTexts.iterator();
        while (it.hasNext()) {
            Iterator<SceneText> it2 = it.next().getComponents().iterator();
            while (it2.hasNext()) {
                hashSet.add(Integer.valueOf(it2.next().getGoogleBlockIdx()));
            }
        }
        return hashSet.size();
    }

    private void setSortedSrcLangList(List<String> list) {
        this.mSortedSrcLangList = new ArrayList(list);
    }

    public int getBaseImageHash() {
        return this.mBaseImageHash;
    }

    public byte[] getBuffer() {
        return this.mBuffer;
    }

    public float getDpScaleFactor() {
        return this.mDpScaleFactor;
    }

    public FrameFormat getFrameFormat() {
        return this.mFrameFormat;
    }

    public long getFrameId() {
        return this.mFrameId;
    }

    public int getGoogleBlockCount() {
        int i = this.mGoogleBlockCount;
        return i <= 0 ? countGoogleBlocks() : i;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public boolean getIsMobile() {
        return this.mIsMobile;
    }

    public int getOriginalImageHeight() {
        return this.originalImageHeight;
    }

    public int getOriginalImageWidth() {
        return this.originalImageWidth;
    }

    public float getResizeRatio() {
        return this.mResizeRatio;
    }

    public int getRotation() {
        return this.mRotation;
    }

    public int getSTRCP() {
        return this.mSTRCP;
    }

    public CopyOnWriteArrayList<SceneText> getSceneTexts() {
        return this.mSceneTexts;
    }

    public String getSrcLang() {
        return this.mSrcLang;
    }

    public int getTRLCP() {
        return this.mTRLCP;
    }

    public List<Double> getTRLReqLangProportions() {
        return this.mTRLReqLangProportions;
    }

    public List<String> getTRLReqLangs() {
        return this.mTRLReqLangs;
    }

    public String getTRLReqSrcLang() {
        return this.mTRLReqSrcLang;
    }

    public List<String> getTRLReqString() {
        return this.mTRLReqStr;
    }

    public List<String> getTRLResultString() {
        return this.mTRLResultStr;
    }

    public TRL_UNIT getTRLUnit() {
        return this.mTRLUnit;
    }

    public String getTarLang() {
        return this.mTarLang;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isValidSTRCP() {
        return this.mSTRCP >= 0;
    }

    public boolean isValidTRLCP() {
        return this.mTRLCP >= 0;
    }

    public void setBaseImageHash(int i) {
        this.mBaseImageHash = i;
    }

    public void setBuffer(byte[] bArr) {
        this.mBuffer = bArr;
    }

    public void setBufferParams(byte[] bArr, int i, int i2, float f) {
        setBuffer(bArr);
        setWidth(i);
        setHeight(i2);
        setResizeRatio(f);
    }

    public void setBufferWithCopy(byte[] bArr, int i, int i2) {
        this.mBuffer = Arrays.copyOfRange(bArr, i, i2);
    }

    public void setDpScaleFactor(float f) {
        this.mDpScaleFactor = f;
    }

    public void setFrameFormat(FrameFormat frameFormat) {
        this.mFrameFormat = frameFormat;
    }

    public void setFrameId(long j) {
        this.mFrameId = j;
    }

    public void setGoogleBlockCount(int i) {
        this.mGoogleBlockCount = i;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setIsMobile(boolean z) {
        this.mIsMobile = z;
    }

    public void setOriginalImageHeight(int i) {
        this.originalImageHeight = i;
    }

    public void setOriginalImageWidth(int i) {
        this.originalImageWidth = i;
    }

    public void setResizeRatio(float f) {
        this.mResizeRatio = f;
    }

    public void setRotation(int i) {
        this.mRotation = i;
    }

    public void setSTRCP(int i) {
        this.mSTRCP = i;
    }

    public void setSceneTexts(CopyOnWriteArrayList<SceneText> copyOnWriteArrayList) {
        this.mSceneTexts = copyOnWriteArrayList;
    }

    public void setSrcLang(String str) {
        this.mSrcLang = str;
        this.mTRLReqSrcLang = str;
    }

    public void setTRLCP(int i) {
        this.mTRLCP = i;
    }

    public void setTRLReqLangProportions(List<Double> list) {
        this.mTRLReqLangProportions = list;
    }

    public void setTRLReqLangs(List<String> list) {
        this.mTRLReqLangs = list;
    }

    public void setTRLReqString(List<String> list) {
        this.mTRLReqStr = list;
    }

    public void setTRLResultString(List<String> list) {
        this.mTRLResultStr = list;
    }

    public void setTRLUnit(TRL_UNIT trl_unit) {
        this.mTRLUnit = trl_unit;
    }

    public void setTarLang(String str) {
        this.mTarLang = str;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public KeyFrame m22153clone() {
        KeyFrame keyFrame = new KeyFrame();
        keyFrame.setFrameId(this.mFrameId);
        byte[] bArr = this.mBuffer;
        keyFrame.setBufferWithCopy(bArr, 0, bArr.length);
        keyFrame.setFrameFormat(this.mFrameFormat);
        keyFrame.setIsMobile(this.mIsMobile);
        keyFrame.setWidth(this.mWidth);
        keyFrame.setHeight(this.mHeight);
        keyFrame.setRotation(this.mRotation);
        keyFrame.setResizeRatio(this.mResizeRatio);
        keyFrame.setTRLReqString(this.mTRLReqStr);
        keyFrame.setSTRCP(this.mSTRCP);
        keyFrame.setTRLCP(this.mTRLCP);
        keyFrame.setSrcLang(this.mSrcLang);
        keyFrame.setTarLang(this.mTarLang);
        keyFrame.setTRLUnit(this.mTRLUnit);
        keyFrame.setGoogleBlockCount(this.mGoogleBlockCount);
        List<String> list = this.mSortedSrcLangList;
        if (list != null) {
            keyFrame.setSortedSrcLangList(list);
        }
        if (this.mSceneTexts == null) {
            keyFrame.setSceneTexts(null);
            return keyFrame;
        }
        CopyOnWriteArrayList<SceneText> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        Iterator<SceneText> it = this.mSceneTexts.iterator();
        while (it.hasNext()) {
            copyOnWriteArrayList.add(it.next().m22154clone());
        }
        keyFrame.setSceneTexts(copyOnWriteArrayList);
        return keyFrame;
    }
}
