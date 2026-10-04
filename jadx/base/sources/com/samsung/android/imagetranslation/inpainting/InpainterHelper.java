package com.samsung.android.imagetranslation.inpainting;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import com.samsung.android.imagetranslation.TaskListener;
import com.samsung.android.imagetranslation.common.Dump;
import com.samsung.android.imagetranslation.common.LTTLogger;
import com.samsung.android.imagetranslation.common.LttEngineErrors;
import com.samsung.android.imagetranslation.data.LttEngineException;
import com.samsung.android.imagetranslation.data.LttOcrResult;
import com.samsung.android.vexfwk.sdk.objeraser.VexFwkObjRemover;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.function.BiConsumer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class InpainterHelper {
    public static final int INITIALIZATION_SUCCESS = 1;
    public static final int PROCESSING_SUCCESS = 2;
    private static final String TAG = "InpainterHelper";
    private static InpainterHelper m_inpainterHelper;
    private CountDownLatch latch;
    VexFwkObjRemover vexFwkObjRemover;
    private TaskListener m_taskListener = null;
    private int m_requestId = -1;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum MaskLevel {
        BLOCK,
        LINE,
        WORD,
        CHAR;

        public int getMaskValue() {
            return ordinal();
        }
    }

    private InpainterHelper() {
    }

    public static synchronized InpainterHelper createInstance() {
        try {
            if (m_inpainterHelper == null) {
                m_inpainterHelper = new InpainterHelper();
            }
        } catch (Throwable th) {
            throw th;
        }
        return m_inpainterHelper;
    }

    private Rect getBoundingRect(ArrayList<Point> arrayList, int i, int i2) {
        int i4 = Integer.MAX_VALUE;
        int i5 = Integer.MIN_VALUE;
        int i6 = Integer.MIN_VALUE;
        int i7 = Integer.MAX_VALUE;
        for (Point point : arrayList) {
            if (point.x < 0) {
                point.x = 0;
            }
            if (point.x > i) {
                point.x = i;
            }
            if (point.y < 0) {
                point.y = 0;
            }
            if (point.y > i2) {
                point.y = i2;
            }
            int i8 = point.x;
            if (i8 < i4) {
                i4 = i8;
            }
            if (i8 > i5) {
                i5 = i8;
            }
            int i9 = point.y;
            if (i9 < i7) {
                i7 = i9;
            }
            if (i9 > i6) {
                i6 = i9;
            }
        }
        return new Rect(i4, i7, i5, i6);
    }

    private MaskLevel getInpaintingMaskLevel() {
        if (!Dump.IS_INIT_DUMP_SUCCESS) {
            return MaskLevel.LINE;
        }
        String str = Dump.INPAINTING_MASK_LEVEL;
        str.getClass();
        switch (str) {
            case "B":
                return MaskLevel.BLOCK;
            case "C":
                return MaskLevel.CHAR;
            case "W":
                return MaskLevel.WORD;
            default:
                return MaskLevel.LINE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getInpaintedFrame$0(InpainterParam inpainterParam, Bitmap bitmap, Throwable th) {
        String str = TAG;
        LTTLogger.m5461i(str, "getInpaintedFrame: Inpainted image received for req id = " + inpainterParam.getRequestId());
        if (th != null) {
            LTTLogger.m5459e(str, "getInpaintedBitmap: req id = " + inpainterParam.getRequestId() + " Exception = " + th.getMessage());
            this.latch.countDown();
            this.m_taskListener.onFailure(this.m_requestId, LttEngineErrors.ERROR_INPAINTING_PROCESSING_FAILED);
        }
        if (bitmap == null) {
            LTTLogger.m5461i(str, "getInpaintedBitmap: Failed to generate inpainted image for req id = " + inpainterParam.getRequestId());
            this.latch.countDown();
            this.m_taskListener.onFailure(this.m_requestId, LttEngineErrors.ERROR_INPAINTING_PROCESSING_FAILED);
            return;
        }
        InpainterResult inpainterResult = new InpainterResult();
        inpainterResult.setInpaintedBitmap(bitmap);
        LTTLogger.m5458d(str, "Inpainted Bitmap Height and Width : " + bitmap.getHeight() + " " + bitmap.getWidth());
        if (Dump.IS_INPAINTED_FRAME_ENABLED) {
            Dump.dumpBitmap(bitmap, "inpainted_image" + System.currentTimeMillis() + ".png", "InpaintedImage");
        }
        this.latch.countDown();
        this.m_taskListener.onInpaintingSuccess(this.m_requestId, inpainterResult);
    }

    private static void releaseInpainterHelper() {
        m_inpainterHelper = null;
    }

    public int getInpaintedFrame(InpainterParam inpainterParam) throws LttEngineException {
        LTTLogger.m5458d(TAG, "getInpaintedFrame : E");
        this.m_requestId = inpainterParam.getRequestId();
        Bitmap inputImage = inpainterParam.getInputImage();
        ArrayList arrayList = new ArrayList();
        Iterator<LttOcrResult.BlockInfo> it = inpainterParam.getLttOcrResult().getBlockInfoList().iterator();
        while (it.hasNext()) {
            Collections.addAll(arrayList, it.next().getPoly());
        }
        try {
            int width = inputImage.getWidth();
            int height = inputImage.getHeight();
            int i = width * height;
            inputImage.getPixels(new int[i], 0, width, 0, 0, width, height);
            if (i != inpainterParam.getInputMask().length) {
                LTTLogger.m5459e(TAG, "image and mask dimension is different");
                throw new LttEngineException(LttEngineErrors.ERROR_INPAINTING_IMG_DIM_MISMATCH, "image and mask dimension is different");
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                this.latch = new CountDownLatch(1);
                if (this.vexFwkObjRemover == null) {
                    throw new LttEngineException(LttEngineErrors.ERROR_INPAINTING_VEX_MANAGER_NULL, "VEX - Manager not initialized properly");
                }
                Rect rect = new Rect(0, 0, width, height);
                String str = TAG;
                LTTLogger.m5461i(str, "getInpaintedFrame: Inpainting requested for req id = " + inpainterParam.getRequestId());
                this.vexFwkObjRemover.removeObject(inputImage, inpainterParam.getInputMask(), rect).whenComplete((BiConsumer<? super Bitmap, ? super Throwable>) new C7126a(this, inpainterParam, 0));
                this.latch.await();
                LTTLogger.m5462p(str, "Inpainting Processing Time : " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
                LTTLogger.m5458d(str, "getInpaintedFrame : X");
                return 2;
            } catch (Exception e) {
                LTTLogger.m5459e(TAG, "exception: " + e.getMessage());
                throw new LttEngineException(LttEngineErrors.ERROR_INPAINTING_PROCESSING_FAILED, "Inpainting processing failed");
            }
        } catch (Exception e2) {
            LTTLogger.m5459e(TAG, "input image decode failed");
            throw new LttEngineException(LttEngineErrors.ERROR_INPAINTING_IMG_DECODING_FAILED, e2.getMessage());
        }
    }

    public int initializeInpainter(InpainterInitParam inpainterInitParam) {
        this.m_taskListener = inpainterInitParam.get_taskListener();
        try {
            if (!VexFwkObjRemover.isAvailable()) {
                throw new LttEngineException(LttEngineErrors.ERROR_INPAINTING_NOT_SUPPORTED, "VexFwk not supported on device !!");
            }
            VexFwkObjRemover vexFwkObjRemover = new VexFwkObjRemover();
            this.vexFwkObjRemover = vexFwkObjRemover;
            vexFwkObjRemover.configure();
            LTTLogger.m5458d(TAG, "VEX - configured");
            return 1;
        } catch (Exception e) {
            LTTLogger.m5459e(TAG, "exception: " + e.getMessage());
            throw new LttEngineException(LttEngineErrors.ERROR_INPAINTING_INITIALIZATION_FAILED, "VEX - initialization failed");
        }
    }

    public void releaseInpainter() {
        VexFwkObjRemover vexFwkObjRemover = this.vexFwkObjRemover;
        if (vexFwkObjRemover != null) {
            vexFwkObjRemover.close();
            this.vexFwkObjRemover = null;
        }
        CountDownLatch countDownLatch = this.latch;
        if (countDownLatch != null) {
            countDownLatch.countDown();
            this.latch = null;
        }
        releaseInpainterHelper();
        LTTLogger.m5461i(TAG, "releaseInpainter: Inpainter service released");
    }
}
