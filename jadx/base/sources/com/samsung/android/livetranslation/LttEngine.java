package com.samsung.android.livetranslation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.Size;
import androidx.annotation.NonNull;
import com.samsung.android.imagetranslation.LttEngineListener;
import com.samsung.android.imagetranslation.data.LttOcrResult;
import com.samsung.android.livetranslation.common.Config;
import com.samsung.android.livetranslation.common.Dump;
import com.samsung.android.livetranslation.data.ImageBuffer;
import com.samsung.android.livetranslation.data.ProcessParam;
import com.samsung.android.livetranslation.task.LiveTranslationTask;
import com.samsung.android.livetranslation.task.LiveTranslationTaskManager;
import com.samsung.android.livetranslation.task.LiveTranslationTaskManagerController;
import com.samsung.android.livetranslation.text.KeyFrame;
import com.samsung.android.livetranslation.text.LiveTranslation;
import com.samsung.android.livetranslation.util.LTTLogger;
import com.samsung.android.livetranslation.util.LineBreakUtil;
import com.samsung.android.livetranslation.util.Util;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class LttEngine {
    public static final String JAR_VERSION = "4.6.0";
    private static final int MAX_RESOLUTION_SUPPORTED = 16000;
    private static final int MAX_UPSCALE_LENGTH = 1080;
    protected static final int ORIENTATION_ANGLE_DOWN = 270;
    protected static final int ORIENTATION_ANGLE_LEFT = 0;
    protected static final int ORIENTATION_ANGLE_RIGHT = 180;
    protected static final int ORIENTATION_ANGLE_UP = 90;
    private static final int RESIZE_THRESHOLD = 512;
    private static final String TAG = "LttEngine";
    private static LttEngine lttEngine = null;
    protected static volatile int mCurrSensorOrientationAngle = 90;
    private int imageHeight;
    private int imageWidth;
    private LttEngineListener lttEngineListener;
    private LttOcrResult lttOcrResult;
    private Context mAppContext;
    private String mDstLang;
    protected LiveTranslation mLiveTranslation;
    private String mSrcLang;
    private ImageBuffer nv21InputImage;
    private int originalImageHeight;
    private int originalImageWidth;
    private int resizedImageHeight;
    private int resizedImageWidth;
    private List<String> trlResult;
    protected int mCurrScreenOrientationAngle = 90;
    protected int mOriginScreenOrientation = -1;
    private final AtomicBoolean mIsEngineInitialized = new AtomicBoolean(false);
    private LiveTranslationTaskManagerController mLiveTranslationTaskManagerController = null;
    private float scaleFactor = 1.0f;
    private final LiveTranslation.OnTaskControllerListener mTaskControllerListener = new LiveTranslation.OnTaskControllerListener() { // from class: com.samsung.android.livetranslation.LttEngine.1
        @Override // com.samsung.android.livetranslation.text.LiveTranslation.OnTaskControllerListener
        public void cancelAllRequests() {
            LttEngine.this.mLiveTranslationTaskManagerController.release();
            LttEngine.this.mLiveTranslationTaskManagerController.init();
        }

        @Override // com.samsung.android.livetranslation.text.LiveTranslation.OnTaskControllerListener
        public int getManagerSize() {
            if (LttEngine.this.mLiveTranslationTaskManagerController != null) {
                return LttEngine.this.mLiveTranslationTaskManagerController.getManagerSize();
            }
            return 0;
        }

        @Override // com.samsung.android.livetranslation.text.LiveTranslation.OnTaskControllerListener
        public void requestNewTask(Context context, KeyFrame keyFrame, Rect rect, LiveTranslationTask.TASKTYPE tasktype, LiveTranslationTaskManager.LiveTranslationTaskManagerListener liveTranslationTaskManagerListener) {
            LTTLogger.m5583i(LttEngine.TAG, "requestNewTask: " + tasktype);
            if (LttEngine.this.mLiveTranslationTaskManagerController != null) {
                LttEngine.this.mLiveTranslationTaskManagerController.requestNewTask(context, keyFrame, rect, tasktype, liveTranslationTaskManagerListener, LttEngine.this.lttOcrResult);
            }
        }

        @Override // com.samsung.android.livetranslation.text.LiveTranslation.OnTaskControllerListener
        public void requestSuccessiveTRL(String str, String str2) {
            LTTLogger.m5583i(LttEngine.TAG, "requestTRLTask");
            if (LttEngine.this.mLiveTranslationTaskManagerController != null) {
                LttEngine.this.mLiveTranslationTaskManagerController.requestSuccessiveTRL(str, str2, LttEngine.this.trlResult);
            }
        }

        @Override // com.samsung.android.livetranslation.text.LiveTranslation.OnTaskControllerListener
        public void requestTask(int i, String str, String str2, LiveTranslationTask.TASKTYPE tasktype) {
            if (LttEngine.this.mLiveTranslationTaskManagerController != null) {
                LttEngine.this.mLiveTranslationTaskManagerController.requestTask(i, str, str2, tasktype);
            }
        }
    };
    private final LiveTranslation.OnEngineListener mEngineListener = new LiveTranslation.OnEngineListener() { // from class: com.samsung.android.livetranslation.LttEngine.2
        @Override // com.samsung.android.livetranslation.text.LiveTranslation.OnEngineListener
        public void checkEngineStability(boolean z) {
            LTTLogger.m5581d(LttEngine.TAG, "checkEngineStability - stable: " + z);
        }

        @Override // com.samsung.android.livetranslation.text.LiveTranslation.OnEngineListener
        public void finishProcess() {
            LTTLogger.m5583i(LttEngine.TAG, "Finish LTT process");
        }

        @Override // com.samsung.android.livetranslation.text.LiveTranslation.OnEngineListener
        public void onCaptureSuccess(LiveTranslation.RenderingScreen renderingScreen) throws Throwable {
            LTTLogger.m5583i(LttEngine.TAG, "onCaptureSuccess()");
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(renderingScreen.getBytes(), 0, renderingScreen.getBytes().length);
            LTTLogger.m5581d(LttEngine.TAG, "onCaptureSuccess: " + bitmapDecodeByteArray.getWidth() + " " + bitmapDecodeByteArray.getHeight());
            if (Dump.IS_INIT_DUMP_SUCCESS && Dump.IS_RENDERED_FRAME_ENABLED) {
                Dump.dumpBitmap(bitmapDecodeByteArray, "result_dump" + Util.getTimeInMilliSecond() + ".png", "Result");
            }
            LttEngine.this.lttEngineListener.onRenderSuccess(bitmapDecodeByteArray);
            LttEngine.this.release();
        }

        @Override // com.samsung.android.livetranslation.text.LiveTranslation.OnEngineListener
        public void onError(String str) {
            LTTLogger.m5581d(LttEngine.TAG, "onError: STATUS - " + str);
            LttEngine.this.lttEngineListener.onRenderFailure(str);
        }

        @Override // com.samsung.android.livetranslation.text.LiveTranslation.OnEngineListener
        public void startProcess() {
            LTTLogger.m5583i(LttEngine.TAG, "Start LTT process");
        }
    };

    private LttEngine(Context context) {
        this.mAppContext = context;
        LTTLogger.m5583i(TAG, "LttEngine: JAR_VERSION : 4.6.0");
    }

    private void createCoreEngine() {
        String str = TAG;
        LTTLogger.m5583i(str, "createCoreEngine: E");
        LTTLogger.m5581d(str, "createCoreEngine: ENGINE_STATE - " + isEngineInitialized());
        if (isEngineInitialized()) {
            this.mLiveTranslation.refreshSession();
            return;
        }
        if (this.mLiveTranslation != null) {
            LTTLogger.m5582e(str, "createCoreEngine: bad thing happens, FC prevention here");
            try {
                this.mLiveTranslation.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        LiveTranslation liveTranslation = new LiveTranslation(this.mAppContext, this.imageWidth, this.imageHeight, new Rect(0, 0, this.imageWidth, this.imageHeight), this.mSrcLang, this.mDstLang, this.mCurrScreenOrientationAngle, false, mCurrSensorOrientationAngle, this.originalImageWidth, this.originalImageHeight, this.scaleFactor);
        this.mLiveTranslation = liveTranslation;
        liveTranslation.setOnEngineListener(this.mEngineListener);
        this.mLiveTranslation.setOnTaskControllerListener(this.mTaskControllerListener);
        this.mLiveTranslationTaskManagerController = new LiveTranslationTaskManagerController(false);
        this.mIsEngineInitialized.set(true);
        String str2 = TAG;
        LTTLogger.m5583i(str2, "createCoreEngine: Engine created");
        LTTLogger.m5583i(str2, "createCoreEngine: X");
        LTTLogger.m5581d(str2, "createCoreEngine: processImageState - " + startLTT(this.nv21InputImage));
    }

    public static LttEngine createInstance(Context context) {
        LttEngine lttEngine2 = new LttEngine(context);
        lttEngine = lttEngine2;
        return lttEngine2;
    }

    private Size decideAndSetResizeParams(int i, int i2) {
        int i4;
        if (i <= 512 && i2 <= 512) {
            if (i == i2) {
                this.resizedImageWidth = 1080;
                this.resizedImageHeight = 1080;
            } else if (i > i2) {
                this.resizedImageWidth = 1080;
                this.resizedImageHeight = (int) Math.ceil((((double) i2) / ((double) i)) * 1080.0d);
            } else {
                this.resizedImageHeight = 1080;
                this.resizedImageWidth = (int) Math.ceil((((double) i) / ((double) i2)) * 1080.0d);
            }
            LTTLogger.m5581d(TAG, "upscaleWidth=" + this.resizedImageWidth + ", upscaleHeight=" + this.resizedImageHeight);
            int i5 = this.resizedImageWidth;
            if (i5 != 0 && (i4 = this.resizedImageHeight) != 0) {
                i = i5;
                i2 = i4;
            }
        }
        int i6 = (i >> 2) << 2;
        if (i - i6 != 0 || i2 - ((i2 >> 2) << 2) != 0) {
            int i7 = (i2 >> 2) << 2;
            if (i6 < i) {
                i6 += 4;
            }
            i = i6;
            if (i7 < i2) {
                i7 += 4;
            }
            i2 = i7;
            LTTLogger.m5581d(TAG, "After 4bit aligned : width=" + this.resizedImageWidth + ", height=" + this.resizedImageHeight);
        }
        return new Size(i, i2);
    }

    private void setLttEngineListener(LttEngineListener lttEngineListener) {
        this.lttEngineListener = lttEngineListener;
    }

    private void updateScaleFactor(int i, int i2, int i4, int i5) {
        if (i2 >= i) {
            this.scaleFactor = i2 / i5;
        } else {
            this.scaleFactor = i / i4;
        }
        LTTLogger.m5585v(TAG, "setImage: scale factor - " + this.scaleFactor);
    }

    public List<String> getResultsWithLineBreak(LttOcrResult lttOcrResult, LttOcrResult lttOcrResult2) {
        return new LineBreakUtil(lttOcrResult2).initResultWithSourceText(lttOcrResult.getBlockInfoList());
    }

    public boolean isEngineInitialized() {
        return this.mIsEngineInitialized.get();
    }

    public void processImage(Bitmap bitmap, LttOcrResult lttOcrResult, List<String> list, ProcessParam processParam, LttEngineListener lttEngineListener) {
        try {
            String str = TAG;
            LTTLogger.m5583i(str, "processImage: E");
            setImage(bitmap);
            setLttOcrResult(lttOcrResult);
            setTRLResult(list);
            LTTLogger.m5583i(str, "processImage: " + lttOcrResult.getBlockInfoList().size() + " " + list.size());
            if (lttOcrResult.getBlockInfoList().size() != list.size()) {
                lttEngineListener.onRenderFailure("No. of Blocks(" + lttOcrResult.getBlockInfoList().size() + ") and No. of translation results(" + list.size() + ") doesn't match");
                return;
            }
            if (lttOcrResult.getBlockInfoList().size() == 0) {
                lttEngineListener.onRenderFailure("provided no.of blocks(" + lttOcrResult.getBlockInfoList().size() + "). So there is nothing to render");
                return;
            }
            LTTLogger.m5581d(str, "processImage: " + processParam);
            if (processParam != null && processParam.getDestLanguage() != null) {
                if (processParam.getDestLanguage().toLowerCase().contains("zh")) {
                    setDstLang("zh");
                } else {
                    setDstLang(processParam.getDestLanguage());
                }
                LTTLogger.m5581d(str, "processImage: DestLanguage - " + processParam.getDestLanguage());
            }
            setLttEngineListener(lttEngineListener);
            LTTLogger.m5583i(str, "processImage:All Inputs received");
            if (Config.IS_USER_DEBUG) {
                Dump.initDump(this.mAppContext, bitmap);
            }
            if (Dump.IS_INIT_DUMP_SUCCESS && Dump.IS_OCR_JSON_DUMP_ENABLED) {
                Dump.dumpStringToFile(Util.convertToJson(lttOcrResult), "Json_result_dump" + Util.getTimeInMilliSecond() + ".json", "Json_Result");
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                arrayList.add("Block " + i + ":" + list.get(i));
            }
            if (Dump.IS_INIT_DUMP_SUCCESS && Dump.IS_TRANSLATED_DUMP_ENABLED) {
                Dump.dumpStringToFile(arrayList.toString(), "Trl_result_dump" + Util.getTimeInMilliSecond() + Constants.TEXT_EXTENSION_WITH_DOT, "Trl_Result");
            }
            createCoreEngine();
        } catch (Exception e) {
            LTTLogger.m5582e(TAG, "processImage: " + e.getMessage());
            lttEngineListener.onRenderFailure(e.getMessage());
        }
    }

    public void release() {
        String str = TAG;
        LTTLogger.m5583i(str, "releaseCoreEngine");
        if (isEngineInitialized()) {
            this.mIsEngineInitialized.set(false);
            LiveTranslation liveTranslation = this.mLiveTranslation;
            if (liveTranslation != null) {
                liveTranslation.release();
                this.mLiveTranslation = null;
            } else {
                LTTLogger.m5582e(str, "stateMisMatched");
            }
        } else {
            LTTLogger.m5581d(str, "Release engine skipped because engine is not initialized");
        }
        if (this.mAppContext != null) {
            this.mAppContext = null;
            LTTLogger.m5581d(str, "release: Application Context released");
        }
        if (this.nv21InputImage != null) {
            this.nv21InputImage = null;
        }
        if (this.lttOcrResult != null) {
            this.lttOcrResult = null;
        }
        if (this.mLiveTranslationTaskManagerController != null) {
            this.mLiveTranslationTaskManagerController = null;
        }
        if (this.lttEngineListener != null) {
            this.lttEngineListener = null;
            LTTLogger.m5581d(str, "release: trlRenderListener released");
        }
    }

    public void setDstLang(String str) {
        LTTLogger.m5581d(TAG, "Destination Language: " + str);
        this.mDstLang = str;
    }

    public void setImage(Bitmap bitmap) throws Exception {
        String str = TAG;
        LTTLogger.m5585v(str, "setImage: E");
        if (bitmap == null) {
            throw new Exception("Invalid Image");
        }
        if (bitmap.getHeight() > 16000 || bitmap.getWidth() > 16000) {
            throw new Exception("Height : " + bitmap.getHeight() + " OR Width : " + bitmap.getWidth() + " is greater than supported resolution");
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        setOriginalImageSize(width, height);
        LTTLogger.m5585v(str, "setImage: Original height - " + height + " width - " + width);
        Size sizeDecideAndSetResizeParams = decideAndSetResizeParams(width, height);
        int width2 = sizeDecideAndSetResizeParams.getWidth();
        int height2 = sizeDecideAndSetResizeParams.getHeight();
        int i = this.originalImageWidth;
        if (width2 != i || height2 != this.originalImageHeight) {
            updateScaleFactor(this.originalImageHeight, i, height2, width2);
            long jCurrentTimeMillis = System.currentTimeMillis();
            bitmap = Bitmap.createScaledBitmap(bitmap, width2, height2, true);
            LTTLogger.m5581d(str, "upScaling time: " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
        }
        if (Config.IS_USER_DEBUG) {
            Dump.setScaledImage(bitmap);
        }
        setImageSize(bitmap.getWidth(), bitmap.getHeight());
        byte[] bArrConvertBitmapToNV21 = Util.convertBitmapToNV21(bitmap);
        LTTLogger.m5585v(str, "setImage: After convertBitmapToNV21  height - " + height2 + " width - " + width2);
        this.nv21InputImage = new ImageBuffer(bArrConvertBitmapToNV21, bitmap.hashCode());
        LTTLogger.m5585v(str, "setImage: X");
    }

    public void setImageSize(int i, int i2) {
        this.imageWidth = i;
        this.imageHeight = i2;
    }

    public void setLttOcrResult(LttOcrResult lttOcrResult) throws Exception {
        LTTLogger.m5585v(TAG, "setLttOcrResult()");
        if (lttOcrResult == null) {
            throw new Exception("LttOcrResult Invalid");
        }
        this.lttOcrResult = lttOcrResult;
    }

    public void setOriginalImageSize(int i, int i2) {
        this.originalImageWidth = i;
        this.originalImageHeight = i2;
    }

    public void setSrcLang(String str) {
        this.mSrcLang = str;
    }

    public void setTRLResult(List<String> list) throws Exception {
        LTTLogger.m5585v(TAG, "setTRLResult()");
        if (list == null) {
            throw new Exception("Translation Result Invalid");
        }
        Iterator<String> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                if (!it.next().isEmpty()) {
                    break;
                }
            } else {
                LTTLogger.m5581d(TAG, "Translation Results are Empty");
                break;
            }
        }
        for (String str : list) {
            LTTLogger.m5581d(TAG, "setTRLResult: " + str);
        }
        this.trlResult = list;
    }

    public boolean startLTT(@NonNull ImageBuffer imageBuffer) {
        String str = TAG;
        LTTLogger.m5581d(str, "startLTT: Engine State - " + isEngineInitialized());
        if (!isEngineInitialized()) {
            LTTLogger.m5583i(str, "startLTT : Engine not initialized, processImage failed");
            return false;
        }
        LTTLogger.m5583i(str, "startLTT : Start LTT process");
        this.mLiveTranslation.processImage(imageBuffer, this.mAppContext, this.scaleFactor, this.originalImageWidth, this.originalImageHeight);
        return true;
    }
}
