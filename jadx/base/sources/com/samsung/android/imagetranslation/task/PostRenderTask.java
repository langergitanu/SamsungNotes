package com.samsung.android.imagetranslation.task;

import android.graphics.Bitmap;
import com.samsung.android.imagetranslation.TaskListener;
import com.samsung.android.imagetranslation.common.LTTLogger;
import com.samsung.android.imagetranslation.data.LttEngineException;
import com.samsung.android.imagetranslation.jni.KeyFrameParam;
import com.samsung.android.imagetranslation.jni.LttNativeHelper;
import com.samsung.android.imagetranslation.util.Util;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class PostRenderTask implements Runnable {
    private static final String TAG = "com.samsung.android.imagetranslation.task.PostRenderTask";
    private KeyFrameParam keyFrameParam;
    private LttNativeHelper lttNativeHelper;
    private TaskListener taskListener;

    public PostRenderTask(KeyFrameParam keyFrameParam, LttNativeHelper lttNativeHelper, TaskListener taskListener) {
        this.lttNativeHelper = lttNativeHelper;
        this.keyFrameParam = keyFrameParam;
        this.taskListener = taskListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str = TAG;
        LTTLogger.m5458d(str, "Task execution started - request id " + this.keyFrameParam.getRequestId());
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.lttNativeHelper.prepareKeyFrameParam(this.keyFrameParam);
            this.keyFrameParam.setNv21InputImage(Util.convertBitmapToNV21(this.keyFrameParam.getInputImage()));
            if (this.keyFrameParam.getInPaintedImage() != null) {
                this.keyFrameParam.setNv21InPaintedImage(Util.convertBitmapToNV21(this.keyFrameParam.getInPaintedImage()));
            }
            LTTLogger.m5462p(str, "NV21 conversion time : " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            this.lttNativeHelper.updateAndSetKeyFrameParam(this.keyFrameParam);
            Bitmap bitmapRenderImage = this.lttNativeHelper.renderImage(this.keyFrameParam);
            LTTLogger.m5462p(str, "Renderer executed in : " + (System.currentTimeMillis() - jCurrentTimeMillis2) + "ms");
            this.taskListener.onRenderSuccess(this.keyFrameParam.getRequestId(), bitmapRenderImage);
        } catch (LttEngineException e) {
            LTTLogger.m5459e(TAG, "Executor task exception: error code " + e.getErrorCode() + ", exception - " + e.getMessage());
            if (e.getErrorCode() == -17) {
                this.lttNativeHelper.releaseInternal();
            }
            this.taskListener.onFailure(this.keyFrameParam.getRequestId(), e.getErrorCode());
        }
    }
}
