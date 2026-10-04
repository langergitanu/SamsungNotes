package com.samsung.android.imagetranslation.task;

import com.samsung.android.imagetranslation.TaskListener;
import com.samsung.android.imagetranslation.common.LTTLogger;
import com.samsung.android.imagetranslation.data.LttEngineException;
import com.samsung.android.imagetranslation.inpainting.InpainterHelper;
import com.samsung.android.imagetranslation.inpainting.InpainterParam;
import com.samsung.android.imagetranslation.jni.LttNativeHelper;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class PostInpaintingTask implements Runnable {
    private static final String TAG = "com.samsung.android.imagetranslation.task.PostInpaintingTask";
    private InpainterHelper inpainterHelper;
    private InpainterParam inpainterParam;
    private LttNativeHelper lttNativeHelper;
    private TaskListener taskListener;

    public PostInpaintingTask(InpainterHelper inpainterHelper, LttNativeHelper lttNativeHelper, InpainterParam inpainterParam, TaskListener taskListener) {
        this.inpainterHelper = inpainterHelper;
        this.lttNativeHelper = lttNativeHelper;
        this.inpainterParam = inpainterParam;
        this.taskListener = taskListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        LTTLogger.m5458d(TAG, "Task execution started - request id " + this.inpainterParam.getRequestId());
        try {
            this.inpainterParam.setInputMask(this.lttNativeHelper.getMaskForInpainting(this.inpainterParam));
            this.inpainterHelper.getInpaintedFrame(this.inpainterParam);
        } catch (LttEngineException e) {
            LTTLogger.m5459e(TAG, "Executor task exception: error code " + e.getErrorCode() + ", exception - " + e.getMessage());
            this.taskListener.onFailure(this.inpainterParam.getRequestId(), e.getErrorCode());
        }
    }
}
