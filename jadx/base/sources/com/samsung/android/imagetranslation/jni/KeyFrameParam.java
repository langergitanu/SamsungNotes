package com.samsung.android.imagetranslation.jni;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Size;
import com.samsung.android.imagetranslation.data.LttOcrResult;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class KeyFrameParam {
    private static final String TAG = "KeyFrame";
    private int blockCount;
    private Context context;
    private String destLanguage;
    private int deviceHeight;
    private int deviceWidth;
    private String imageFormat;
    private Bitmap inPaintedImage;
    private Bitmap inputImage;
    private LttOcrResult lttOcrResult;
    private int mserNeeded;
    private byte[] nv21InPaintedImage;
    private byte[] nv21InputImage;
    private Size originalImageSize;
    private int requestId;
    private Size resizedImageSize;
    private CopyOnWriteArrayList<SceneText> sceneTexts;
    private List<String> trlResult;
    private float dpScaleFactor = 5.0f;
    private float resizeRatio = 1.0f;
    private int deviceRotation = 0;

    private int countBlocks() {
        HashSet hashSet = new HashSet();
        Iterator<SceneText> it = this.sceneTexts.iterator();
        while (it.hasNext()) {
            Iterator<SceneText> it2 = it.next().getComponents().iterator();
            while (it2.hasNext()) {
                hashSet.add(Integer.valueOf(it2.next().getGoogleBlockIdx()));
            }
        }
        this.blockCount = hashSet.size();
        return hashSet.size();
    }

    public int getBlockCount() {
        int i = this.blockCount;
        return i <= 0 ? countBlocks() : i;
    }

    public Context getContext() {
        return this.context;
    }

    public String getDestLanguage() {
        return this.destLanguage;
    }

    public int getDeviceHeight() {
        return this.deviceHeight;
    }

    public int getDeviceRotation() {
        return this.deviceRotation;
    }

    public int getDeviceWidth() {
        return this.deviceWidth;
    }

    public float getDpScaleFactor() {
        return this.dpScaleFactor;
    }

    public String getImageFormat() {
        return this.imageFormat;
    }

    public Bitmap getInPaintedImage() {
        return this.inPaintedImage;
    }

    public Bitmap getInputImage() {
        return this.inputImage;
    }

    public int getInputImageHeight() {
        return this.inputImage.getHeight();
    }

    public int getInputImageWidth() {
        return this.inputImage.getWidth();
    }

    public LttOcrResult getLttOcrResult() {
        return this.lttOcrResult;
    }

    public int getMserNeeded() {
        return this.mserNeeded;
    }

    public byte[] getNv21InPaintedImage() {
        return this.nv21InPaintedImage;
    }

    public byte[] getNv21InputImage() {
        return this.nv21InputImage;
    }

    public int getOriginalHeight() {
        return this.originalImageSize.getHeight();
    }

    public Size getOriginalImageSize() {
        return this.originalImageSize;
    }

    public int getOriginalWidth() {
        return this.originalImageSize.getWidth();
    }

    public int getRequestId() {
        return this.requestId;
    }

    public float getResizeRatio() {
        return this.resizeRatio;
    }

    public Size getResizedImageSize() {
        return this.resizedImageSize;
    }

    public CopyOnWriteArrayList<SceneText> getSceneTexts() {
        return this.sceneTexts;
    }

    public List<String> getTrlResult() {
        return this.trlResult;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setDestLanguage(String str) {
        this.destLanguage = str;
    }

    public void setDeviceHeight(int i) {
        this.deviceHeight = i;
    }

    public void setDeviceRotation(int i) {
        this.deviceRotation = i;
    }

    public void setDeviceWidth(int i) {
        this.deviceWidth = i;
    }

    public void setDpScaleFactor(float f) {
        this.dpScaleFactor = f;
    }

    public void setImageFormat(String str) {
        this.imageFormat = str;
    }

    public void setInPaintedImage(Bitmap bitmap) {
        this.inPaintedImage = bitmap;
    }

    public void setInputImage(Bitmap bitmap) {
        this.inputImage = bitmap;
    }

    public void setLttOcrResult(LttOcrResult lttOcrResult) {
        this.lttOcrResult = lttOcrResult;
    }

    public void setMserNeeded(int i) {
        this.mserNeeded = i;
    }

    public void setNv21InPaintedImage(byte[] bArr) {
        this.nv21InPaintedImage = bArr;
    }

    public void setNv21InputImage(byte[] bArr) {
        this.nv21InputImage = bArr;
    }

    public void setOriginalImageSize(Size size) {
        this.originalImageSize = size;
    }

    public void setRequestId(int i) {
        this.requestId = i;
    }

    public void setResizeRatio(float f) {
        this.resizeRatio = f;
    }

    public void setResizedImageSize(Size size) {
        this.resizedImageSize = size;
    }

    public void setSceneTexts(CopyOnWriteArrayList<SceneText> copyOnWriteArrayList) {
        this.sceneTexts = copyOnWriteArrayList;
    }

    public void setTrlResult(List<String> list) {
        this.trlResult = list;
    }
}
