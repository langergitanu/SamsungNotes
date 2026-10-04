package com.samsung.android.imagetranslation.jni;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.imagetranslation.LttEngine;
import com.samsung.android.imagetranslation.common.Dump;
import com.samsung.android.imagetranslation.common.LTTLogger;
import com.samsung.android.imagetranslation.common.LttEngineErrors;
import com.samsung.android.imagetranslation.data.LttEngineException;
import com.samsung.android.imagetranslation.data.LttOcrResult;
import com.samsung.android.imagetranslation.inpainting.InpainterParam;
import com.samsung.android.imagetranslation.task.ProcessOCR;
import com.samsung.android.imagetranslation.task.ProcessTRL;
import com.samsung.android.imagetranslation.task.TextDistribution;
import com.samsung.android.imagetranslation.util.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class LttNativeHelper {
    private static final int INITIALIZE_SUCCESS = 1;
    public static String NATIVE_LIBRARY_VERSION = null;
    private static final String TAG = "LttNativeHelper";

    static {
        try {
            LTTLogger.m5458d("LttNativeHelper", "Load library: LttEngine.camera.samsung");
            System.loadLibrary("LttEngine.camera.samsung");
        } catch (Throwable th) {
            LTTLogger.m5461i(TAG, "Failed to load library: " + th.getMessage());
            th.printStackTrace();
        }
    }

    private static native int[] _getMaskForInpainting(byte[] bArr, int i, int i2, CopyOnWriteArrayList<SceneText> copyOnWriteArrayList);

    private static native String _getNativeParameter(int i);

    private static native int _initialize();

    private static native int _release();

    private static native int _releaseInternal();

    private static native byte[] _renderImage(KeyFrameParam keyFrameParam);

    private static native int _setNativeParameter(LttEngineProperty lttEngineProperty);

    private static void setNativeVersion() {
        NATIVE_LIBRARY_VERSION = _getNativeParameter(1);
    }

    public void cropAndRestoreOriginalText(KeyFrameParam keyFrameParam, List<Path> list) {
        if (list.isEmpty()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Bitmap bitmapCopy = keyFrameParam.getInPaintedImage().copy(Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(bitmapCopy);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        for (Path path : list) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(keyFrameParam.getInputImage().getWidth(), keyFrameParam.getInputImage().getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap);
            canvas2.save();
            canvas2.clipPath(path);
            canvas2.drawBitmap(keyFrameParam.getInputImage(), 0.0f, 0.0f, paint);
            canvas2.restore();
            canvas.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, paint);
            bitmapCreateBitmap.recycle();
        }
        LTTLogger.m5458d(TAG, "lines restored - " + list.size() + " time : " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
        if (Dump.IS_INPAINTED_FRAME_ENABLED) {
            Dump.dumpBitmap(bitmapCopy, "retored_inpainted_image" + System.currentTimeMillis() + ".png", "RestoredImage");
        }
        keyFrameParam.setInPaintedImage(bitmapCopy);
    }

    public boolean filterSceneTextLines(CopyOnWriteArrayList<SceneText> copyOnWriteArrayList) {
        if (copyOnWriteArrayList == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < copyOnWriteArrayList.size(); i++) {
            SceneText sceneText = copyOnWriteArrayList.get(i);
            CopyOnWriteArrayList<SceneText> components = sceneText.getComponents();
            if (!sceneText.isParagraphRendering()) {
                for (SceneText sceneText2 : components) {
                    LTTLogger.m5460h(TAG, "filterSceneTextLines : line value = " + sceneText2.getValue() + " hasOnlyNumber = " + sceneText2.hasOnlyNumber());
                    if (sceneText2.hasOnlyNumber()) {
                        components.remove(sceneText2);
                    }
                }
            }
            if (!components.isEmpty()) {
                z = true;
            }
            String str = TAG;
            StringBuilder sbM778t = AbstractC0541b.m778t(i, "Block - ", " size =");
            sbM778t.append(sceneText.getComponents().size());
            LTTLogger.m5458d(str, sbM778t.toString());
            copyOnWriteArrayList.set(i, sceneText);
        }
        return z;
    }

    public synchronized int[] getMaskForInpainting(InpainterParam inpainterParam) {
        int[] iArr_getMaskForInpainting;
        long jCurrentTimeMillis = System.currentTimeMillis();
        byte[] bArrConvertBitmapToNV21 = Util.convertBitmapToNV21(inpainterParam.getInputImage());
        KeyFrameParam keyFrameParam = new KeyFrameParam();
        keyFrameParam.setResizeRatio(inpainterParam.getResizeRatio());
        keyFrameParam.setInputImage(inpainterParam.getInputImage());
        keyFrameParam.setContext(inpainterParam.getContext());
        CopyOnWriteArrayList<SceneText> sceneTextFromOCR = new ProcessOCR(keyFrameParam).getSceneTextFromOCR(inpainterParam.getLttOcrResult(), inpainterParam.getInputImage().getWidth(), inpainterParam.getInputImage().getHeight(), keyFrameParam.getDeviceRotation());
        if (!filterSceneTextLines(sceneTextFromOCR)) {
            throw new LttEngineException(LttEngineErrors.ERROR_INPAINTING_GET_MASK_NATIVE_FAILED, "No lines to inpaint");
        }
        keyFrameParam.setSceneTexts(sceneTextFromOCR);
        iArr_getMaskForInpainting = _getMaskForInpainting(bArrConvertBitmapToNV21, inpainterParam.getInputImage().getWidth(), inpainterParam.getInputImage().getHeight(), sceneTextFromOCR);
        LTTLogger.m5462p(TAG, "Inpainting Mask Generated Time : " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
        if (iArr_getMaskForInpainting == null) {
            throw new LttEngineException(LttEngineErrors.ERROR_INPAINTING_GET_MASK_NATIVE_FAILED, "Native getMaskForInpainting api is failed");
        }
        if (Dump.IS_INPAINTING_MASK_DUMP_ENABLE) {
            Dump.dumpBitmap(Dump.intArrayToBitmap(iArr_getMaskForInpainting, inpainterParam.getInputImage().getWidth(), inpainterParam.getInputImage().getHeight()), "mser_mask" + System.currentTimeMillis() + ".png", "MserMask");
        }
        return iArr_getMaskForInpainting;
    }

    public void initialize() {
        setNativeVersion();
        LTTLogger.m5461i(TAG, "Native Version - " + NATIVE_LIBRARY_VERSION);
        if (!Util.isJarAndNativeVersionCompatible(LttEngine.JAR_VERSION, NATIVE_LIBRARY_VERSION)) {
            throw new LttEngineException(-4, "Jar and Native is not compatible");
        }
        if (_initialize() != 1) {
            throw new LttEngineException(-5, "Initialized failed");
        }
    }

    public void prepareKeyFrameParam(KeyFrameParam keyFrameParam) throws LttEngineException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        keyFrameParam.setDpScaleFactor(Util.getDpToPxFactor(keyFrameParam.getContext()));
        int[] deviceResolution = Util.getDeviceResolution(keyFrameParam.getContext());
        int i = 0;
        keyFrameParam.setDeviceWidth(deviceResolution[0]);
        keyFrameParam.setDeviceHeight(deviceResolution[1]);
        CopyOnWriteArrayList<SceneText> sceneTextFromOCR = new ProcessOCR(keyFrameParam).getSceneTextFromOCR(keyFrameParam.getLttOcrResult(), keyFrameParam.getInputImage().getWidth(), keyFrameParam.getInputImage().getHeight(), keyFrameParam.getDeviceRotation());
        if (sceneTextFromOCR == null) {
            throw new LttEngineException(-18, "Failed to get scene text from OCR");
        }
        keyFrameParam.setSceneTexts(sceneTextFromOCR);
        String str = TAG;
        LTTLogger.m5462p(str, "prepareKeyFrameParam: OCR processing time : " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (!new TextDistribution(keyFrameParam, keyFrameParam.getTrlResult()).distribute()) {
            throw new LttEngineException(-15, "Failed to distribute translation result");
        }
        LTTLogger.m5462p(str, "prepareKeyFrameParam: Text distribution time : " + (System.currentTimeMillis() - jCurrentTimeMillis2) + "ms");
        long jCurrentTimeMillis3 = System.currentTimeMillis();
        ProcessTRL processTRL = new ProcessTRL(keyFrameParam);
        if (keyFrameParam.getInPaintedImage() == null) {
            processTRL.detectAndClearSameTranslatedResult();
        } else {
            ArrayList arrayList = new ArrayList();
            processTRL.getLinesToRestore(arrayList);
            cropAndRestoreOriginalText(keyFrameParam, arrayList);
        }
        ProcessTRL.setTextScaleX(false);
        processTRL.generateTranslationMask();
        if (!keyFrameParam.getContext().getPackageName().contains("aiselect") && !keyFrameParam.getContext().getPackageName().contains("smartcapture")) {
            i = 1;
        }
        keyFrameParam.setMserNeeded(i);
        LTTLogger.m5461i(str, "renderImage:All required data prepared");
        LTTLogger.m5462p(str, "prepareKeyFrameParam: Total time taken : " + (System.currentTimeMillis() - jCurrentTimeMillis3) + "ms");
    }

    public synchronized void release() {
        LTTLogger.m5461i(TAG, "release()");
        _release();
    }

    public synchronized void releaseInternal() {
        LTTLogger.m5461i(TAG, "releaseInternal()");
        _releaseInternal();
    }

    public synchronized Bitmap renderImage(KeyFrameParam keyFrameParam) {
        byte[] bArr_renderImage;
        bArr_renderImage = _renderImage(keyFrameParam);
        if (bArr_renderImage == null) {
            throw new LttEngineException(-17, "Native render api is failed");
        }
        return BitmapFactory.decodeByteArray(bArr_renderImage, 0, bArr_renderImage.length);
    }

    public void updateAndSetKeyFrameParam(KeyFrameParam keyFrameParam) {
        StringBuilder sb = new StringBuilder("");
        Iterator<SceneText> it = keyFrameParam.getSceneTexts().iterator();
        while (it.hasNext()) {
            sb.append(it.next().getBlockType() == LttOcrResult.BlockInfo.BLOCK_TYPE.DEFAULT.ordinal() ? "0" : "1");
        }
        if (_setNativeParameter(new LttEngineProperty(2, sb.toString())) == 1) {
            LTTLogger.m5458d(TAG, "setNativeParameter : Success");
        } else {
            LTTLogger.m5459e(TAG, "setNativeParameter : Failed");
        }
    }
}
