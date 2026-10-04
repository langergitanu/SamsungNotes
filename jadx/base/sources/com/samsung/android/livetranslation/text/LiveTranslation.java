package com.samsung.android.livetranslation.text;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.imagetranslation.data.LttOcrResult;
import com.samsung.android.livetranslation.LttEngine;
import com.samsung.android.livetranslation.common.Config;
import com.samsung.android.livetranslation.common.LttEngineProperty;
import com.samsung.android.livetranslation.data.ImageBuffer;
import com.samsung.android.livetranslation.task.LiveTranslationTask;
import com.samsung.android.livetranslation.task.LiveTranslationTaskManager;
import com.samsung.android.livetranslation.text.KeyFrame;
import com.samsung.android.livetranslation.util.LTTLogger;
import com.samsung.android.livetranslation.util.Util;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import p001A.AbstractC0000a;
import p079T.RunnableC0284b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class LiveTranslation {
    public static int NATIVE_API_VERSION = -1;
    private static String NATIVE_LIBRARY_VERSION = null;
    private static final int NEW_VERSION_SUCCESS = 100;
    private static final String TAG = "LiveTranslation";
    public static boolean isJarAndNativeCompatible;
    private static Handler lttRendererHandler;
    private static HandlerThread lttRendererHandlerThread;
    private static long mLatestFrameID;
    private static OnEngineListener mOnEngineListener;
    private static Handler uiHandler;
    private static Handler updateTextHandler;
    private static HandlerThread updateTextHandlerThread;
    private AtomicBoolean mInProgress;
    private OnTaskControllerListener mOnTaskControllerListener;
    private AtomicBoolean mPrevFreezeStatus;
    private int mPreviewHeight;
    private int mPreviewWidth;
    private Rect mROIinLandscapeAxis;
    private int mSTRCP;
    private int mScreenRotationAngle;
    private String mSrcLang;
    private AtomicBoolean mStability;
    private int mTRLCP;
    private String mTarLang;
    private AtomicBoolean mTrackingSuccessInCurFrame;
    private AtomicBoolean mTrackingSuccessInPrevFrame;
    private long startLTT_Time;
    private int versionAvailable;
    private KeyFrame.TRL_UNIT mTRLUnit = KeyFrame.TRL_UNIT.PARAGRAPH;
    private boolean mIsImageModeSelected = false;
    private LiveTranslationTaskManager.STATUS mStatus = LiveTranslationTaskManager.STATUS.STR_PREPARING;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class LiveTranslationTaskManagerListenerImpl implements LiveTranslationTaskManager.LiveTranslationTaskManagerListener {
        public /* synthetic */ LiveTranslationTaskManagerListenerImpl(LiveTranslation liveTranslation, int i) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSTRFinish$0(KeyFrame keyFrame, int i) {
            LiveTranslation.this.mStatus = LiveTranslationTaskManager.STATUS.STR_COMPLETED;
            LTTLogger.m5583i(LiveTranslation.TAG, "onSTRFinish: Status - " + LiveTranslation.this.mStatus);
            double dCurrentTimeMillis = (double) System.currentTimeMillis();
            LiveTranslation.this.updateTexts(keyFrame, true, true, i);
            LTTLogger.m5581d(LiveTranslation.TAG, "onSTRFinish: Profiling - UpdateTexts(OCR) : " + (System.currentTimeMillis() - dCurrentTimeMillis) + "ms");
            LiveTranslation.this.mOnTaskControllerListener.requestSuccessiveTRL(LiveTranslation.this.mSrcLang, LiveTranslation.this.mTarLang);
            LiveTranslation.this.mStatus = LiveTranslationTaskManager.STATUS.TRL_WAITING;
            LTTLogger.m5583i(LiveTranslation.TAG, "onSTRFinish: Status - " + LiveTranslation.this.mStatus);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSTRFinish$1() {
            LiveTranslation.mOnEngineListener.onError(LiveTranslation.this.mStatus.toString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSTRFinish$2(KeyFrame keyFrame, int i) {
            LiveTranslation.this.mStatus = LiveTranslationTaskManager.STATUS.STR_FAIL;
            LTTLogger.m5583i(LiveTranslation.TAG, "onSTRFinish: Status - " + LiveTranslation.this.mStatus);
            LiveTranslation.this.updateTexts(keyFrame, true, false, i);
            if (LiveTranslation.mOnEngineListener == null || !LiveTranslation.this.mInProgress.get()) {
                return;
            }
            LiveTranslation.this.mInProgress.set(false);
            LiveTranslation.uiHandler.post(new RunnableC7166c(this, 0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTRLFinish$3(int i, KeyFrame keyFrame) {
            LiveTranslation.this.mStatus = LiveTranslationTaskManager.STATUS.TRL_COMPLETED;
            LTTLogger.m5583i(LiveTranslation.TAG, "onTRLJobFinish(): Status - " + LiveTranslation.this.mStatus);
            if (i == 3004) {
                LiveTranslation._clearRenderingText();
            }
            LiveTranslation.this.updateTexts(keyFrame, false, true, i);
            if (Config.IS_PROFILING_ENABLED) {
                LTTLogger.m5583i(LiveTranslation.TAG, "Profiling - LTT elapsed time: " + (System.currentTimeMillis() - LiveTranslation.this.startLTT_Time) + "ms");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTRLFinish$4(KeyFrame keyFrame, int i) {
            LiveTranslation.this.mStatus = LiveTranslationTaskManager.STATUS.TRL_FAIL;
            LTTLogger.m5583i(LiveTranslation.TAG, "onTRLJobFinish(): Status - " + LiveTranslation.this.mStatus);
            LiveTranslation.this.updateTexts(keyFrame, false, false, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTRLFinish$5(int i) {
            OnEngineListener onEngineListener = LiveTranslation.mOnEngineListener;
            StringBuilder sb = new StringBuilder();
            sb.append(LiveTranslation.this.mStatus.toString());
            sb.append(" ");
            sb.append(i == 3004 ? "Same Language detected" : "Invalid Parsing Data");
            onEngineListener.onError(sb.toString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTRLFinish$6(int i) {
            if (LiveTranslation.mOnEngineListener == null || !LiveTranslation.this.mInProgress.get()) {
                return;
            }
            LiveTranslation.this.mInProgress.set(false);
            if (i != 3005) {
                LiveTranslation.uiHandler.post(new RunnableC7165b(this, i, 1));
            } else {
                LiveTranslation.mOnEngineListener.finishProcess();
            }
        }

        private boolean needFurtherProcessForSTR(long j) {
            if (LiveTranslation.this.isLiveTranslationValid() && LiveTranslation.this.isLastestKeyFrameResponse(j)) {
                return true;
            }
            LTTLogger.m5583i(LiveTranslation.TAG, "needFurtherProcessForSTR() : false, LATEST_FRAME_ID(" + LiveTranslation.mLatestFrameID + ") vs KeyFrame.mFrameId(" + j + ")");
            return false;
        }

        @Override // com.samsung.android.livetranslation.task.LiveTranslationTaskManager.LiveTranslationTaskManagerListener
        public void onSTRFinish(boolean z, KeyFrame keyFrame, LttOcrResult lttOcrResult, int i) {
            LiveTranslation.this.mStatus = LiveTranslationTaskManager.STATUS.STR_ARRIVED;
            LTTLogger.m5583i(LiveTranslation.TAG, "onSTRFinish: Status - " + LiveTranslation.this.mStatus);
            if (needFurtherProcessForSTR(keyFrame.getFrameId())) {
                LTTLogger.m5581d(LiveTranslation.TAG, "onSTRFinish() success:" + z);
                if (z) {
                    LiveTranslation.updateTextHandler.post(new RunnableC7164a(this, keyFrame, i, 2));
                } else {
                    LiveTranslation.updateTextHandler.post(new RunnableC7164a(this, keyFrame, i, 3));
                }
            }
        }

        @Override // com.samsung.android.livetranslation.task.LiveTranslationTaskManager.LiveTranslationTaskManagerListener
        public void onTRLFinish(boolean z, KeyFrame keyFrame, int i) {
            LiveTranslation.this.mStatus = LiveTranslationTaskManager.STATUS.TRL_ARRIVED;
            LTTLogger.m5583i(LiveTranslation.TAG, "onTRLFinish : E (" + z + ") errortype : (" + i + ")");
            String str = LiveTranslation.TAG;
            StringBuilder sb = new StringBuilder("onTRLFinish: Status - ");
            sb.append(LiveTranslation.this.mStatus);
            LTTLogger.m5583i(str, sb.toString());
            if (LiveTranslation.this.needFurtherProcessForTRL(keyFrame.getFrameId(), keyFrame.getSrcLang(), keyFrame.getTarLang())) {
                if (z) {
                    LiveTranslation.updateTextHandler.post(new RunnableC7164a(i, keyFrame, this));
                } else {
                    LiveTranslation.updateTextHandler.post(new RunnableC7164a(this, keyFrame, i, 1));
                }
                LiveTranslation.updateTextHandler.post(new RunnableC7165b(this, i, 0));
            }
        }

        private LiveTranslationTaskManagerListenerImpl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnEngineListener {
        void checkEngineStability(boolean z);

        void finishProcess();

        void onCaptureSuccess(RenderingScreen renderingScreen);

        void onError(String str);

        void startProcess();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnTaskControllerListener {
        void cancelAllRequests();

        int getManagerSize();

        void requestNewTask(Context context, KeyFrame keyFrame, Rect rect, LiveTranslationTask.TASKTYPE tasktype, LiveTranslationTaskManager.LiveTranslationTaskManagerListener liveTranslationTaskManagerListener);

        void requestSuccessiveTRL(String str, String str2);

        void requestTask(int i, String str, String str2, LiveTranslationTask.TASKTYPE tasktype);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class RenderingScreen {
        private final byte[] bytes;
        private final boolean isTranslationRendered;

        public RenderingScreen(byte[] bArr, boolean z) {
            this.bytes = bArr;
            this.isTranslationRendered = z;
        }

        public byte[] getBytes() {
            return this.bytes;
        }

        public boolean isTranslationRendered() {
            return this.isTranslationRendered;
        }
    }

    static {
        try {
            LTTLogger.m5581d("LiveTranslation", "Load library: LttEngine.camera.samsung");
            System.loadLibrary("LttEngine.camera.samsung");
        } catch (Throwable th) {
            LTTLogger.m5583i(TAG, "Failed to load library: " + th.getMessage());
            th.printStackTrace();
        }
    }

    public LiveTranslation(Context context, int i, int i2, Rect rect, String str, String str2, int i4, boolean z, int i5, int i6, int i7, float f) {
        String str3 = TAG;
        StringBuilder sb = new StringBuilder("LiveTranslation() : context=");
        sb.append(context);
        sb.append(", previewWidth=");
        sb.append(i);
        sb.append(", previewHeight=");
        sb.append(i2);
        sb.append(", roi=");
        sb.append(rect.flattenToString());
        sb.append(", srcLang=");
        AbstractC2821a.m2207B(sb, str, ", tarLang=", str2, ", surfaceRotationAngle=");
        sb.append(i4);
        sb.append(", isSystemAutoRotatePreferenceEnabled=");
        sb.append(z);
        sb.append(", DeviceOrientation=");
        sb.append(i5);
        LTTLogger.m5583i(str3, sb.toString());
        this.mPreviewWidth = i;
        this.mPreviewHeight = i2;
        this.mSrcLang = str;
        this.mTarLang = str2;
        this.mROIinLandscapeAxis = rect;
        this.mScreenRotationAngle = i4;
        this.mTrackingSuccessInCurFrame = new AtomicBoolean(false);
        this.mTrackingSuccessInPrevFrame = new AtomicBoolean(false);
        this.mStability = new AtomicBoolean(false);
        this.mInProgress = new AtomicBoolean(false);
        this.mPrevFreezeStatus = new AtomicBoolean(false);
        HandlerThread handlerThread = new HandlerThread("LttRendererThread");
        lttRendererHandlerThread = handlerThread;
        handlerThread.start();
        lttRendererHandler = new Handler(lttRendererHandlerThread.getLooper());
        HandlerThread handlerThread2 = new HandlerThread("updateTextThread");
        updateTextHandlerThread = handlerThread2;
        handlerThread2.start();
        updateTextHandler = new Handler(updateTextHandlerThread.getLooper());
        uiHandler = new Handler(Looper.getMainLooper());
        int i8 = this.mPreviewWidth;
        int i9 = this.mPreviewHeight;
        Rect rect2 = this.mROIinLandscapeAxis;
        int i10 = rect2.left;
        int i11 = rect2.top;
        int i_initialize = _initialize(i8, i9, i10, i11, rect2.right - i10, rect2.bottom - i11);
        this.versionAvailable = i_initialize;
        if (i_initialize == 100) {
            NATIVE_LIBRARY_VERSION = _getNativeParameter(1);
            NATIVE_API_VERSION = Integer.parseInt(_getNativeParameter(2));
            LTTLogger.m5583i(str3, "Native Version - " + NATIVE_LIBRARY_VERSION);
            LTTLogger.m5583i(str3, "ApiVersion - " + NATIVE_API_VERSION);
            LTTLogger.m5583i(str3, "Client " + context.getPackageName());
            int i12 = (context.getPackageName().contains("aiselect") || context.getPackageName().contains("smartcapture")) ? 0 : 1;
            int[] deviceResolution = Util.getDeviceResolution(context);
            LttEngineProperty lttEngineProperty = new LttEngineProperty(3, Integer.valueOf(deviceResolution[0]));
            LttEngineProperty lttEngineProperty2 = new LttEngineProperty(4, Integer.valueOf(deviceResolution[1]));
            LttEngineProperty lttEngineProperty3 = new LttEngineProperty(5, Integer.valueOf(i6));
            LttEngineProperty lttEngineProperty4 = new LttEngineProperty(6, Integer.valueOf(i7));
            LttEngineProperty lttEngineProperty5 = new LttEngineProperty(7, Integer.valueOf((int) (100.0f * f)));
            LttEngineProperty lttEngineProperty6 = new LttEngineProperty(8, Integer.valueOf(i12));
            if (_setNativeParameter(lttEngineProperty) != 1) {
                LTTLogger.m5583i(str3, "Failed to set device width");
            }
            if (_setNativeParameter(lttEngineProperty2) != 1) {
                LTTLogger.m5583i(str3, "Failed to set device height");
            }
            if (_setNativeParameter(lttEngineProperty3) != 1) {
                LTTLogger.m5583i(str3, "Failed to set image width");
            }
            if (_setNativeParameter(lttEngineProperty4) != 1) {
                LTTLogger.m5583i(str3, "Failed to set image height");
            }
            if (_setNativeParameter(lttEngineProperty5) != 1) {
                LTTLogger.m5583i(str3, "Failed to set resize scale factor");
            }
            if (_setNativeParameter(lttEngineProperty6) != 1) {
                LTTLogger.m5583i(str3, "Failed to set mser");
            }
        }
        isJarAndNativeCompatible = Util.isJarAndNativeVersionCompatible(LttEngine.JAR_VERSION, NATIVE_LIBRARY_VERSION);
        LTTLogger.m5583i(str3, "Version Matches : " + isJarAndNativeCompatible);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native int _clearRenderingText();

    private static native String _getNativeParameter(int i);

    private static native RenderingScreen _getRenderingScreenInJPG();

    private static native int _initOpenGL(int i, int i2);

    private static native int _initialize(int i, int i2, int i4, int i5, int i6, int i7);

    private static native int _processImage(byte[] bArr);

    private static native int _refreshSession();

    private static native int _release();

    /* JADX INFO: Access modifiers changed from: private */
    public static native int _renderingText(boolean z);

    public static void _requestRenderCallback() {
        LTTLogger.m5583i(TAG, "requestRenderCallback");
        lttRendererHandler.post(new Runnable() { // from class: com.samsung.android.livetranslation.text.LiveTranslation.1
            @Override // java.lang.Runnable
            public void run() {
                LTTLogger.m5583i(LiveTranslation.TAG, "OpenGL Thread Id: " + LiveTranslation.lttRendererHandlerThread.getThreadId());
                LiveTranslation._renderingText(true);
            }
        });
    }

    private static native int _setNativeParameter(LttEngineProperty lttEngineProperty);

    private static native int _updateTexts(KeyFrame keyFrame, boolean z, boolean z2);

    public static void callback(int i, int i2, int i4, int i5, boolean z) {
    }

    private boolean doesTrackingStartToFail() {
        return this.mTrackingSuccessInPrevFrame.get() && !this.mTrackingSuccessInCurFrame.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean isLastestKeyFrameResponse(long j) {
        LTTLogger.m5583i(TAG, "isLastestFrameResponse : mLatestFrameID=" + mLatestFrameID + ", inFrameID=" + j);
        return mLatestFrameID <= j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLiveTranslationValid() {
        OnTaskControllerListener onTaskControllerListener = this.mOnTaskControllerListener;
        return onTaskControllerListener != null && onTaskControllerListener.getManagerSize() >= 1;
    }

    private boolean isSTRRequestingSignal(int i) {
        return i == 2 || i == 3;
    }

    private boolean isSameLang(String str, String str2) {
        return str != null && str.equals(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$_captureRequestCallback$0(RenderingScreen renderingScreen) {
        mOnEngineListener.onCaptureSuccess(renderingScreen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$_captureRequestCallback$1() {
        mOnEngineListener.onError("Failed due to timeout");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needFurtherProcessForTRL(long j, String str, String str2) {
        if (isLiveTranslationValid() && isLastestKeyFrameResponse(j) && (this.mIsImageModeSelected || this.mTrackingSuccessInCurFrame.get())) {
            return true;
        }
        String str3 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("needFurtherProcessForTRL() : false, KeyFrame.mSrcLang(", str, "), CurrentSrcLang(");
        AbstractC2821a.m2207B(sbM15l, this.mSrcLang, "), KeyFrame.mTarLang(", str2, "), CurrentTarLang(");
        sbM15l.append(this.mTarLang);
        sbM15l.append("), LATEST_FRAME_ID(");
        sbM15l.append(mLatestFrameID);
        AbstractC1038a.m1223x(sbM15l, ") vs KeyFrame.mFrameId(", j, ") + CURRENT_TRACKING_STATUS(");
        sbM15l.append(this.mTrackingSuccessInCurFrame.get());
        sbM15l.append(")");
        LTTLogger.m5583i(str3, sbM15l.toString());
        return false;
    }

    private KeyFrame prepareKeyFrame(byte[] bArr, Context context, float f, int i, int i2, int i4) {
        KeyFrame keyFrame = new KeyFrame();
        keyFrame.setSTRCP(this.mSTRCP);
        keyFrame.setTRLCP(this.mTRLCP);
        keyFrame.setTRLUnit(this.mTRLUnit);
        keyFrame.setRotation(i4);
        keyFrame.setFrameId(mLatestFrameID);
        keyFrame.setOriginalImageWidth(i);
        keyFrame.setOriginalImageHeight(i2);
        if (bArr != null) {
            keyFrame.setBufferWithCopy(bArr, 0, (int) (((double) (this.mPreviewWidth * this.mPreviewHeight)) * 1.5d));
        }
        keyFrame.setDpScaleFactor(Util.getDpToPxFactor(context));
        keyFrame.setFrameFormat(KeyFrame.FrameFormat.NV21);
        keyFrame.setWidth(this.mPreviewWidth);
        keyFrame.setHeight(this.mPreviewHeight);
        keyFrame.setResizeRatio(f);
        synchronized (this) {
            keyFrame.setSrcLang(this.mSrcLang);
            keyFrame.setTarLang(this.mTarLang);
        }
        return keyFrame;
    }

    private void releaseBitmaps(KeyFrame keyFrame) {
        Iterator<SceneText> it = keyFrame.getSceneTexts().iterator();
        while (it.hasNext()) {
            releaseTrsMaskBitmap(it.next());
        }
    }

    private void releaseResources(KeyFrame keyFrame) {
        releaseBitmaps(keyFrame);
    }

    private void releaseTrsMaskBitmap(SceneText sceneText) {
        if (sceneText.getComponents() != null) {
            Iterator<SceneText> it = sceneText.getComponents().iterator();
            while (it.hasNext()) {
                releaseTrsMaskBitmap(it.next());
            }
        }
        if (sceneText.getTrsTextMask() != null) {
            sceneText.setTrsTextMask(null);
        }
    }

    private void updateEngine(boolean z) {
        if (this.mStatus != LiveTranslationTaskManager.STATUS.TRL_COMPLETED && z && !this.mPrevFreezeStatus.get()) {
            LTTLogger.m5583i(TAG, "refresh Session is called for tab freeze before text rendering");
            _refreshSession();
            this.mOnTaskControllerListener.cancelAllRequests();
            if (mOnEngineListener != null && this.mInProgress.get()) {
                this.mInProgress.set(false);
            }
            this.mStatus = LiveTranslationTaskManager.STATUS.STR_PREPARING;
        }
        if (this.mStability.get() && doesTrackingStartToFail()) {
            this.mStability.set(false);
            if (mOnEngineListener != null && this.mInProgress.get()) {
                this.mInProgress.set(false);
            }
        }
        OnEngineListener onEngineListener = mOnEngineListener;
        if (onEngineListener != null) {
            onEngineListener.checkEngineStability(this.mStability.get());
        }
        this.mTrackingSuccessInPrevFrame.set(this.mTrackingSuccessInCurFrame.get());
        this.mPrevFreezeStatus.set(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTexts(KeyFrame keyFrame, boolean z, boolean z2, int i) {
        if (isLastestKeyFrameResponse(keyFrame.getFrameId())) {
            _updateTexts(keyFrame, z, z2);
            if (!z && z2 && !isSameLang(keyFrame.getTRLReqSrcLang(), keyFrame.getTarLang()) && i != 3004) {
                LTTLogger.m5583i(TAG, "updateTexts: Translation result updated");
            }
        } else {
            LTTLogger.m5583i(TAG, "Not call _updateTexts() : mLastestFrmaID=" + mLatestFrameID + ", KeyFrameID=" + keyFrame.getFrameId());
        }
        if (z || !z2) {
            return;
        }
        releaseResources(keyFrame);
    }

    public void _captureRequestCallback() {
        LTTLogger.m5583i(TAG, "captureRequestCallback");
        RenderingScreen renderingScreen = getRenderingScreen();
        if (renderingScreen != null) {
            uiHandler.post(new RunnableC7166c(renderingScreen, 1));
        } else {
            uiHandler.post(new RunnableC0284b(5));
        }
    }

    public RenderingScreen getRenderingScreen() {
        LTTLogger.m5583i(TAG, "getRenderingScreen");
        return _getRenderingScreenInJPG();
    }

    public synchronized void processImage(@NonNull ImageBuffer imageBuffer, Context context, float f, int i, int i2) {
        try {
            String str = TAG;
            StringBuilder sb = new StringBuilder("processImage() : E (imageBuffer.getmImageBuffer()=");
            sb.append(imageBuffer.getImageBuffer() == null ? "null" : Integer.valueOf(imageBuffer.getImageBuffer().length));
            sb.append(")");
            LTTLogger.m5583i(str, sb.toString());
            this.mIsImageModeSelected = true;
            int i_processImage = _processImage(imageBuffer.getImageBuffer());
            LTTLogger.m5581d(str, "processImage: STR_signal - " + i_processImage);
            int i4 = 0;
            if (isSTRRequestingSignal(i_processImage)) {
                LTTLogger.m5583i(str, "Frame is ready to process");
                this.mStability.set(true);
                mLatestFrameID = 1L;
                KeyFrame keyFramePrepareKeyFrame = prepareKeyFrame(imageBuffer.getImageBuffer(), context, f, i, i2, 0);
                keyFramePrepareKeyFrame.setBaseImageHash(imageBuffer.getBaseImageHash());
                if (Config.IS_PROFILING_ENABLED) {
                    this.startLTT_Time = System.currentTimeMillis();
                }
                LTTLogger.m5583i(str, "processImage: STATUS - " + this.mStatus);
                this.mOnTaskControllerListener.requestNewTask(context, keyFramePrepareKeyFrame, this.mROIinLandscapeAxis, LiveTranslationTask.TASKTYPE.POST_STR, new LiveTranslationTaskManagerListenerImpl(this, i4));
                this.mStatus = LiveTranslationTaskManager.STATUS.STR_WAITING;
                LTTLogger.m5583i(str, "processImage: Status - " + this.mStatus);
                if (!this.mInProgress.get() && mOnEngineListener != null) {
                    this.mInProgress.set(true);
                    mOnEngineListener.startProcess();
                }
            }
            updateEngine(false);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void refreshSession() {
        String str = TAG;
        LTTLogger.m5581d(str, "refreshSession-E");
        _refreshSession();
        LTTLogger.m5581d(str, "refreshSession-X");
    }

    public synchronized void release() {
        try {
            String str = TAG;
            LTTLogger.m5583i(str, "release()");
            Handler handler = lttRendererHandler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                lttRendererHandler = null;
            }
            Handler handler2 = updateTextHandler;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages(null);
                updateTextHandler = null;
            }
            Handler handler3 = uiHandler;
            if (handler3 != null) {
                handler3.removeCallbacksAndMessages(null);
                uiHandler = null;
            }
            if (lttRendererHandlerThread.isAlive()) {
                lttRendererHandlerThread.quitSafely();
                lttRendererHandlerThread = null;
                LTTLogger.m5583i(str, "lttRendererHandlerThread released");
            }
            if (updateTextHandlerThread.isAlive()) {
                updateTextHandlerThread.quitSafely();
                try {
                    updateTextHandlerThread.join();
                    updateTextHandlerThread = null;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                LTTLogger.m5583i(TAG, "updateTextHandlerThread released");
            }
            mOnEngineListener = null;
            _release();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setOnEngineListener(OnEngineListener onEngineListener) {
        LTTLogger.m5583i(TAG, "setOnEngineListener: " + Objects.toString(onEngineListener, "null"));
        mOnEngineListener = onEngineListener;
    }

    public void setOnTaskControllerListener(OnTaskControllerListener onTaskControllerListener) {
        LTTLogger.m5581d(TAG, "setOnTaskControllerListener : " + Objects.toString(onTaskControllerListener, "null"));
        this.mOnTaskControllerListener = onTaskControllerListener;
    }
}
