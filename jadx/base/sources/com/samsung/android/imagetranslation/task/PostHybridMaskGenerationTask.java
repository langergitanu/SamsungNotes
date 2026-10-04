package com.samsung.android.imagetranslation.task;

import com.samsung.android.imagetranslation.TaskListener;
import com.samsung.android.imagetranslation.common.LTTLogger;
import com.samsung.android.imagetranslation.data.LttEngineException;
import com.samsung.android.imagetranslation.data.MaskResponse;
import com.samsung.android.imagetranslation.inpainting.InpainterParam;
import com.samsung.android.imagetranslation.jni.LttNativeHelper;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class PostHybridMaskGenerationTask implements Runnable {
    private static final String TAG = "com.samsung.android.imagetranslation.task.PostHybridMaskGenerationTask";
    private InpainterParam inpainterParam;
    private LttNativeHelper lttNativeHelper;
    private TaskListener taskListener;

    public PostHybridMaskGenerationTask(LttNativeHelper lttNativeHelper, InpainterParam inpainterParam, TaskListener taskListener) {
        this.lttNativeHelper = lttNativeHelper;
        this.inpainterParam = inpainterParam;
        this.taskListener = taskListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        LTTLogger.m5458d(TAG, "Get Mask Task execution started - request id " + this.inpainterParam.getRequestId());
        try {
            int[] maskForInpainting = this.lttNativeHelper.getMaskForInpainting(this.inpainterParam);
            if (maskForInpainting != null) {
                MaskResponse maskResponse = new MaskResponse();
                maskResponse.setRequestId(this.inpainterParam.getRequestId());
                maskResponse.setMaskData(maskForInpainting);
                maskResponse.setMaskSize(this.inpainterParam.getResizedImageSize());
                this.taskListener.onMaskAvailable(this.inpainterParam.getRequestId(), maskResponse);
            }
        } catch (LttEngineException e) {
            LTTLogger.m5459e(TAG, "Executor task exception: error code " + e.getErrorCode() + ", exception - " + e.getMessage());
            this.taskListener.onFailure(this.inpainterParam.getRequestId(), e.getErrorCode());
        }
    }
}
