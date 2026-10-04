package com.samsung.android.imagetranslation;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.feature.SemFloatingFeature;
import com.samsung.android.imagetranslation.common.LTTLogger;
import com.samsung.android.imagetranslation.common.LttEngineErrors;
import com.samsung.android.imagetranslation.data.LttEngineException;
import com.samsung.android.imagetranslation.data.LttOcrResult;
import com.samsung.android.imagetranslation.data.MaskRequest;
import com.samsung.android.imagetranslation.data.RenderParam;
import com.samsung.android.imagetranslation.data.Session;
import com.samsung.android.imagetranslation.inpainting.InpainterParam;
import com.samsung.android.imagetranslation.jni.KeyFrameParam;
import com.samsung.android.imagetranslation.jni.LttNativeHelper;
import com.samsung.android.imagetranslation.util.LineBreakUtil;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class LttEngineClient extends LttEngine {
    public static final int ERROR_HARD_ERROR = -400;
    public static final int ERROR_INPAINTER_SOFT_ERROR = -200;
    public static final int ERROR_RENDERER_SOFT_ERROR = -300;
    public static final int NO_ERROR = 1;
    private static final String TAG = "LttEngineClient";
    private static LttEngineClient lttEngineClient;
    private com.samsung.android.livetranslation.LttEngine lttEngine;

    /* JADX INFO: renamed from: com.samsung.android.imagetranslation.LttEngineClient$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C71131 {

        /* JADX INFO: renamed from: $SwitchMap$com$samsung$android$imagetranslation$LttEngineClient$Key */
        static final /* synthetic */ int[] f4772x34d8d228;

        static {
            int[] iArr = new int[Key.values().length];
            f4772x34d8d228 = iArr;
            try {
                iArr[Key.KEY_JAR_VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4772x34d8d228[Key.KEY_NATIVE_VERSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Key {
        KEY_JAR_VERSION,
        KEY_NATIVE_VERSION
    }

    public static LttEngineClient createInstance() {
        LttEngineClient lttEngineClient2 = lttEngineClient;
        if (lttEngineClient2 != null) {
            return lttEngineClient2;
        }
        LTTLogger.m5458d(TAG, "lttEngineClient instance created");
        LttEngineClient lttEngineClient3 = new LttEngineClient();
        lttEngineClient = lttEngineClient3;
        return lttEngineClient3;
    }

    public static boolean isImageTranslationAvailable() {
        boolean zM1607A = AbstractC2322a.m1607A("/system/lib64/libLttEngine.camera.samsung.so");
        if (!zM1607A) {
            LTTLogger.m5461i(TAG, "Image Translation not supported ");
            return zM1607A;
        }
        int i = SemFloatingFeature.getInstance().getInt("SEC_FLOATING_FEATURE_VISION_CONFIG_IMAGE_TRANSLATION_OVERLAY_VERSION");
        LTTLogger.m5461i(TAG, "Image Translation supported, Version : " + i);
        return zM1607A;
    }

    public void destroyInstance() {
        String str = TAG;
        LTTLogger.m5461i(str, "destroyInstance");
        super.release();
        if (lttEngineClient != null) {
            lttEngineClient = null;
            LTTLogger.m5458d(str, "lttEngineClient instance destroyed");
        }
    }

    public void getMaskForInpainting(int i, MaskRequest maskRequest) {
        String str = TAG;
        LTTLogger.m5461i(str, "Mask request: request id - " + i);
        long jCurrentTimeMillis = System.currentTimeMillis();
        InpainterParam inpainterParam = new InpainterParam(i, maskRequest.getInputBitmap(), maskRequest.getLttOcrResult());
        if (!this.isLttEngineInitialized || !this.isMaskHelperInitialized) {
            LTTLogger.m5459e(str, "Error: Ltt Engine not initialized to generate mask");
            LttEngineListener lttEngineListener = this.lttEngineListener;
            if (lttEngineListener != null) {
                lttEngineListener.onFailure(i, LttEngineErrors.ERROR_INPAINTING_GET_MASK_NATIVE_FAILED);
                return;
            }
            return;
        }
        try {
            validateMaskInputImage(inpainterParam.getInputImage());
            validateInpainterOCR(inpainterParam.getLttOcrResult());
            preProcessOnInputImage(inpainterParam.getInputImage(), inpainterParam);
            inpainterParam.setRequestId(i);
            super.postMaskTask(inpainterParam);
            LTTLogger.m5462p(str, "getMaskForInpainting: validation time taken : " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
        } catch (LttEngineException e) {
            LTTLogger.m5464w(TAG, "getMaskForInpainting: error code " + e.getErrorCode() + ", exception - " + e.getMessage());
            this.lttEngineListener.onFailure(i, -200);
        }
    }

    public Object getParam(Key key) {
        int i = C71131.f4772x34d8d228[key.ordinal()];
        if (i == 1) {
            return LttEngine.JAR_VERSION;
        }
        if (i == 2 && this.isLttEngineInitialized) {
            return LttNativeHelper.NATIVE_LIBRARY_VERSION;
        }
        return null;
    }

    @Deprecated
    public List<String> getResultsWithLineBreak(LttOcrResult lttOcrResult, LttOcrResult lttOcrResult2) {
        return new LineBreakUtil(lttOcrResult2).initResultWithSourceText(lttOcrResult.getBlockInfoList());
    }

    public void inPaintImage(int i, InpainterParam inpainterParam) {
        String str = TAG;
        LTTLogger.m5461i(str, "New inPainting request: request id - " + i);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!this.isInpainterHelperInitialized) {
            LTTLogger.m5459e(str, "Error: Inpainter Engine not initialized");
            LttEngineListener lttEngineListener = this.lttEngineListener;
            if (lttEngineListener != null) {
                lttEngineListener.onFailure(inpainterParam.getRequestId(), -200);
                return;
            }
            return;
        }
        try {
            validateInpainterImage(inpainterParam.getInputImage());
            validateInpainterOCR(inpainterParam.getLttOcrResult());
            validateInpaintingNeeded(inpainterParam);
            preProcessOnInputImage(inpainterParam.getInputImage(), inpainterParam);
            inpainterParam.setRequestId(i);
            super.inPaintImage(inpainterParam);
            LTTLogger.m5462p(str, "inPaintImage: Total time taken : " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
        } catch (LttEngineException e) {
            LTTLogger.m5464w(TAG, "inPaintImage: error code " + e.getErrorCode() + ", exception - " + e.getMessage());
            this.lttEngineListener.onFailure(i, -200);
        }
    }

    @Override // com.samsung.android.imagetranslation.LttEngine
    public int initialize(Session session) {
        String str = TAG;
        LTTLogger.m5461i(str, "initialize");
        if (!this.isLttEngineInitialized) {
            return super.initialize(session);
        }
        LTTLogger.m5458d(str, "Engine already initialized");
        return 1;
    }

    public void initialize4x(Context context) {
        LTTLogger.m5461i(TAG, "initialize 4x");
        this.lttEngine = com.samsung.android.livetranslation.LttEngine.createInstance(context);
    }

    @Override // com.samsung.android.imagetranslation.LttEngine
    public void release() {
        LTTLogger.m5461i(TAG, "release");
        super.release();
    }

    public void release4x() {
        LTTLogger.m5461i(TAG, "release 4x");
        this.lttEngine.release();
    }

    public void renderImage(RenderParam renderParam) {
        if (renderParam.getLttEngineListener() != null) {
            LTTLogger.m5461i(TAG, "New render request for 4.x");
            this.lttEngine.processImage(renderParam.getInputBitmap(), renderParam.getLttOcrResult(), renderParam.getTrlResult(), null, renderParam.getLttEngineListener());
        }
    }

    public void setParam(Object obj) {
        LTTLogger.m5461i(TAG, "setParam");
    }

    public List<String> getResultsWithLineBreak(@NonNull Context context, LttOcrResult lttOcrResult) {
        return LineBreakUtil.initResultWithSourceText(context, lttOcrResult.getBlockInfoList());
    }

    public void renderImage(int i, RenderParam renderParam) {
        String str = TAG;
        LTTLogger.m5461i(str, "New render request: request id - " + i);
        if (!this.isRenderEngineInitialized) {
            LTTLogger.m5459e(str, "Error: LttEngine not initialized");
            LttEngineListener lttEngineListener = this.lttEngineListener;
            if (lttEngineListener != null) {
                lttEngineListener.onFailure(i, -400);
                return;
            }
            return;
        }
        KeyFrameParam keyFrameParam = new KeyFrameParam();
        try {
            validateInputImage(renderParam.getInputBitmap());
            validateOCRAndTranslation(renderParam.getLttOcrResult(), renderParam.getTrlResult());
            preProcessOnInputImage(renderParam.getInputBitmap(), keyFrameParam);
            if (renderParam.getInPaintedBitmap() != null) {
                LTTLogger.m5461i(str, "renderImage: original image size (width-" + keyFrameParam.getInputImage().getWidth() + ", height-" + keyFrameParam.getInputImage().getHeight() + ") \n OE image size (width-" + renderParam.getInPaintedBitmap().getWidth() + " height-" + renderParam.getInPaintedBitmap().getHeight() + ")");
            } else {
                LTTLogger.m5461i(str, "renderImage: original image size (width-" + keyFrameParam.getInputImage().getWidth() + ", height-" + keyFrameParam.getInputImage().getHeight() + ")");
            }
            keyFrameParam.setRequestId(i);
            keyFrameParam.setContext(this.session.getContext());
            setDstLang(renderParam.getDestLanguage(), keyFrameParam);
            setImageFormat(renderParam.getImageFormat(), keyFrameParam);
            keyFrameParam.setLttOcrResult(renderParam.getLttOcrResult());
            keyFrameParam.setTrlResult(renderParam.getTrlResult());
            keyFrameParam.setInPaintedImage(renderParam.getInPaintedBitmap());
            LTTLogger.m5461i(str, "renderImage:All Inputs received");
            postRenderTask(keyFrameParam);
        } catch (LttEngineException e) {
            LTTLogger.m5459e(TAG, "Render Image API Exception : error code " + e.getErrorCode() + ", exception - " + e.getMessage());
            this.lttEngineListener.onFailure(i, e.getErrorCode());
        }
    }
}
