package com.samsung.android.imagetranslation;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.Size;
import com.samsung.android.imagetranslation.common.Dump;
import com.samsung.android.imagetranslation.common.LTTLogger;
import com.samsung.android.imagetranslation.common.LttEngineErrors;
import com.samsung.android.imagetranslation.data.LttEngineException;
import com.samsung.android.imagetranslation.data.LttOcrResult;
import com.samsung.android.imagetranslation.data.MaskResponse;
import com.samsung.android.imagetranslation.data.Session;
import com.samsung.android.imagetranslation.inpainting.InpainterHelper;
import com.samsung.android.imagetranslation.inpainting.InpainterInitParam;
import com.samsung.android.imagetranslation.inpainting.InpainterParam;
import com.samsung.android.imagetranslation.inpainting.InpainterResult;
import com.samsung.android.imagetranslation.jni.KeyFrameParam;
import com.samsung.android.imagetranslation.jni.LttNativeHelper;
import com.samsung.android.imagetranslation.task.PostHybridMaskGenerationTask;
import com.samsung.android.imagetranslation.task.PostInpaintingTask;
import com.samsung.android.imagetranslation.task.PostRenderTask;
import com.samsung.android.imagetranslation.util.Util;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class LttEngine {
    private static final String INPAINTER_SERVICE = "Inpainter";
    public static final String JAR_VERSION = "5.4.0";
    private static final String MASK_GENERATION_SERVICE = "Mask";
    private static final String RENDERER_SERVICE = "Renderer";
    private static final String TAG = "LttEngine";
    protected InpainterHelper inpainterHelper;
    protected ExecutorService inpainterService;
    protected boolean isInpainterHelperInitialized;
    protected boolean isLttEngineInitialized;
    protected boolean isMaskHelperInitialized;
    protected boolean isRenderEngineInitialized;
    protected LttEngineListener lttEngineListener;
    protected LttNativeHelper lttNativeHelper;
    Handler mainHandler;
    protected ExecutorService maskGenerationService;
    protected ExecutorService rendererService;
    protected Session session;
    TaskListener taskListener = new C71121();

    /* JADX INFO: renamed from: com.samsung.android.imagetranslation.LttEngine$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C71121 implements TaskListener {
        public C71121() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFailure$1(int i, int i2) {
            LttEngine.this.lttEngineListener.onFailure(i, LttEngineErrors.mapToClientErrorType(i2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onInpaintingSuccess$2(int i, InpainterResult inpainterResult) {
            LttEngine.this.lttEngineListener.onInPaintingSuccess(i, inpainterResult);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onMaskAvailable$3(int i, MaskResponse maskResponse) {
            LttEngine.this.lttEngineListener.onMaskAvailable(i, maskResponse);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onRenderSuccess$0(int i, Bitmap bitmap) {
            LttEngine.this.lttEngineListener.onRenderSuccess(i, bitmap);
        }

        @Override // com.samsung.android.imagetranslation.TaskListener
        public void onFailure(final int i, final int i2) {
            if (LttEngineErrors.mapToClientErrorType(i2) == -200) {
                LTTLogger.m5464w(LttEngine.TAG, "onFailure soft error : request id " + i + " code " + i2);
            } else {
                LTTLogger.m5459e(LttEngine.TAG, "onFailure: request id " + i + " code " + i2);
            }
            LttEngine lttEngine = LttEngine.this;
            Handler handler = lttEngine.mainHandler;
            if (handler != null && lttEngine.lttEngineListener != null) {
                handler.post(new Runnable() { // from class: com.samsung.android.imagetranslation.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f4773a.lambda$onFailure$1(i, i2);
                    }
                });
                return;
            }
            LTTLogger.m5464w(LttEngine.TAG, "mainHandler : " + LttEngine.this.mainHandler + " lttEngineListener" + LttEngine.this.lttEngineListener);
        }

        @Override // com.samsung.android.imagetranslation.TaskListener
        public void onInpaintingSuccess(int i, InpainterResult inpainterResult) {
            LTTLogger.m5461i(LttEngine.TAG, "onInpaintingSuccess reqId : " + i);
            LttEngine lttEngine = LttEngine.this;
            lttEngine.printRequestStatus(lttEngine.inpainterService, LttEngine.INPAINTER_SERVICE);
            LttEngine lttEngine2 = LttEngine.this;
            Handler handler = lttEngine2.mainHandler;
            if (handler != null && lttEngine2.lttEngineListener != null) {
                handler.post(new RunnableC7115b(this, i, inpainterResult, 1));
                return;
            }
            LTTLogger.m5464w(LttEngine.TAG, "mainHandler : " + LttEngine.this.mainHandler + " lttEngineListener" + LttEngine.this.lttEngineListener);
        }

        @Override // com.samsung.android.imagetranslation.TaskListener
        public void onMaskAvailable(int i, MaskResponse maskResponse) {
            LTTLogger.m5461i(LttEngine.TAG, "onMaskAvailable reqId : " + i);
            LttEngine lttEngine = LttEngine.this;
            lttEngine.printRequestStatus(lttEngine.maskGenerationService, LttEngine.MASK_GENERATION_SERVICE);
            LttEngine lttEngine2 = LttEngine.this;
            Handler handler = lttEngine2.mainHandler;
            if (handler != null && lttEngine2.lttEngineListener != null) {
                handler.post(new RunnableC7115b(this, i, maskResponse, 2));
                return;
            }
            LTTLogger.m5464w(LttEngine.TAG, "mainHandler : " + LttEngine.this.mainHandler + " lttEngineListener" + LttEngine.this.lttEngineListener);
        }

        @Override // com.samsung.android.imagetranslation.TaskListener
        public void onRenderSuccess(int i, Bitmap bitmap) {
            LTTLogger.m5461i(LttEngine.TAG, "onRenderSuccess : request id " + i);
            LttEngine lttEngine = LttEngine.this;
            lttEngine.printRequestStatus(lttEngine.rendererService, LttEngine.RENDERER_SERVICE);
            if (Dump.IS_INIT_DUMP_SUCCESS && Dump.IS_RENDERED_FRAME_ENABLED) {
                Dump.dumpBitmap(bitmap, "result_dump" + System.currentTimeMillis() + ".png", "Result");
            }
            LttEngine lttEngine2 = LttEngine.this;
            Handler handler = lttEngine2.mainHandler;
            if (handler != null && lttEngine2.lttEngineListener != null) {
                handler.post(new RunnableC7115b(this, i, bitmap, 0));
                return;
            }
            LTTLogger.m5464w(LttEngine.TAG, "mainHandler : " + LttEngine.this.mainHandler + " lttEngineListener" + LttEngine.this.lttEngineListener);
        }
    }

    private Size decideAndSetResizeParams(int i, int i2) {
        int iCeil;
        if (i <= 512 && i2 <= 512) {
            int iCeil2 = 1080;
            if (i == i2) {
                iCeil = 1080;
            } else if (i > i2) {
                iCeil = (int) Math.ceil((((double) i2) / ((double) i)) * 1080.0d);
            } else {
                iCeil = 1080;
                iCeil2 = (int) Math.ceil((((double) i) / ((double) i2)) * 1080.0d);
            }
            LTTLogger.m5458d(TAG, "upscaleWidth=" + iCeil2 + ", upscaleHeight=" + iCeil);
            if (iCeil2 != 0 && iCeil != 0) {
                i = iCeil2;
                i2 = iCeil;
            }
        }
        int i4 = (i >> 2) << 2;
        if (i - i4 != 0 || i2 - ((i2 >> 2) << 2) != 0) {
            int i5 = (i2 >> 2) << 2;
            if (i4 < i) {
                i4 += 4;
            }
            i = i4;
            if (i5 < i2) {
                i5 += 4;
            }
            i2 = i5;
            LTTLogger.m5458d(TAG, "After 4bit aligned : width=" + i + ", height=" + i2);
        }
        return new Size(i, i2);
    }

    private float updateScaleFactor(int i, int i2, int i4, int i5) {
        float f;
        float f4;
        if (i >= i2) {
            f = i;
            f4 = i5;
        } else {
            f = i2;
            f4 = i4;
        }
        float f5 = f / f4;
        LTTLogger.m5463v(TAG, "setImage: scale factor - " + f5);
        return f5;
    }

    public void inPaintImage(InpainterParam inpainterParam) {
        if (Dump.IS_INIT_DUMP_SUCCESS && Dump.DISABLE_INPAINTING) {
            LTTLogger.m5461i(TAG, "Inpainting feature disabled");
            this.taskListener.onFailure(inpainterParam.getRequestId(), LttEngineErrors.ERROR_INPAINTING_NOT_SUPPORTED);
        } else {
            inpainterParam.setContext(this.session.getContext());
            this.inpainterService.submit(new PostInpaintingTask(this.inpainterHelper, this.lttNativeHelper, inpainterParam, this.taskListener));
            printRequestStatus(this.inpainterService, INPAINTER_SERVICE);
        }
    }

    public int initialize(Session session) {
        String str = TAG;
        LTTLogger.m5461i(str, "LttEngine: JAR_VERSION : 5.4.0");
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            setSession(session);
            this.mainHandler = new Handler(Looper.getMainLooper());
            if (!this.isRenderEngineInitialized) {
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                LttNativeHelper lttNativeHelper = new LttNativeHelper();
                this.lttNativeHelper = lttNativeHelper;
                lttNativeHelper.initialize();
                this.isRenderEngineInitialized = true;
                this.rendererService = Executors.newFixedThreadPool(1);
                LTTLogger.m5461i(str, "Renderer module initialized");
                LTTLogger.m5462p(str, "Renderer module initialized in : " + (System.currentTimeMillis() - jCurrentTimeMillis2) + "ms");
            }
            if (!this.isInpainterHelperInitialized && session.isInpainterModuleEnabled()) {
                long jCurrentTimeMillis3 = System.currentTimeMillis();
                InpainterHelper inpainterHelperCreateInstance = InpainterHelper.createInstance();
                this.inpainterHelper = inpainterHelperCreateInstance;
                inpainterHelperCreateInstance.initializeInpainter(new InpainterInitParam(session.getContext(), this.taskListener));
                this.inpainterService = Executors.newFixedThreadPool(1);
                this.isInpainterHelperInitialized = true;
                LTTLogger.m5461i(str, "Inpainter module initialized");
                LTTLogger.m5462p(str, "Inpainter module initialized in : " + (System.currentTimeMillis() - jCurrentTimeMillis3) + "ms");
            }
            if (!session.isInpainterModuleEnabled()) {
                this.maskGenerationService = Executors.newFixedThreadPool(1);
                this.isMaskHelperInitialized = true;
            }
            this.isLttEngineInitialized = true;
            LTTLogger.m5461i(str, "Engine initialized");
            LTTLogger.m5462p(str, "Engine initialized in : " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
            Dump.initDump(session.getContext());
            return 1;
        } catch (LttEngineException e) {
            LTTLogger.m5459e(TAG, "Initialize API Exception: error code " + e.getErrorCode() + ", exception - " + e.getMessage());
            if (this.isRenderEngineInitialized) {
                return (!this.isInpainterHelperInitialized || LttEngineErrors.mapToClientErrorType(e.getErrorCode()) == -200) ? LttEngineErrors.ERROR_INPAINTING_INITIALIZATION_FAILED : e.getErrorCode();
            }
            return -400;
        }
    }

    public void postMaskTask(InpainterParam inpainterParam) {
        inpainterParam.setContext(this.session.getContext());
        this.maskGenerationService.submit(new PostHybridMaskGenerationTask(this.lttNativeHelper, inpainterParam, this.taskListener));
        printRequestStatus(this.maskGenerationService, MASK_GENERATION_SERVICE);
    }

    public void postRenderTask(KeyFrameParam keyFrameParam) {
        PostRenderTask postRenderTask = new PostRenderTask(keyFrameParam, this.lttNativeHelper, this.taskListener);
        LTTLogger.m5458d(TAG, "New request posted into queue - request id " + keyFrameParam.getRequestId());
        this.rendererService.submit(postRenderTask);
        printRequestStatus(this.rendererService, RENDERER_SERVICE);
    }

    public void preProcessOnInputImage(Bitmap bitmap, InpainterParam inpainterParam) {
        String str = TAG;
        LTTLogger.m5463v(str, "preProcessOnInputImage_Inpainter: E");
        long jCurrentTimeMillis = System.currentTimeMillis();
        inpainterParam.setOriginalImageSize(new Size(bitmap.getWidth(), bitmap.getHeight()));
        inpainterParam.setInputImage(bitmap);
        LTTLogger.m5463v(str, "preProcessOnInputImage_Inpainter: Original width - " + bitmap.getWidth() + " height - " + bitmap.getHeight());
        Size sizeDecideAndSetResizeParams = decideAndSetResizeParams(bitmap.getWidth(), bitmap.getHeight());
        inpainterParam.setResizedImageSize(sizeDecideAndSetResizeParams);
        int width = sizeDecideAndSetResizeParams.getWidth();
        int height = sizeDecideAndSetResizeParams.getHeight();
        if (width != bitmap.getWidth() || height != bitmap.getHeight()) {
            inpainterParam.setResizeRatio(updateScaleFactor(bitmap.getWidth(), bitmap.getHeight(), height, width));
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            bitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
            LTTLogger.m5462p(str, "preProcessOnInputImage_Inpainter: upScaling time: " + (System.currentTimeMillis() - jCurrentTimeMillis2) + "ms");
        }
        inpainterParam.setInputImage(bitmap);
        LTTLogger.m5458d(str, "preProcessOnInputImage_Inpainter: Input width - " + bitmap.getWidth() + " height - " + bitmap.getHeight());
        StringBuilder sb = new StringBuilder("preProcessOnInputImage_Inpainter: Total time taken : ");
        sb.append(System.currentTimeMillis() - jCurrentTimeMillis);
        sb.append("ms");
        LTTLogger.m5462p(str, sb.toString());
        LTTLogger.m5463v(str, "preProcessOnInputImage_Inpainter: X");
    }

    public void printRequestStatus(ExecutorService executorService, String str) {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
        String str2 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("service: ", str, ", total request received: ");
        sbM15l.append(threadPoolExecutor.getTaskCount());
        sbM15l.append(", active count: ");
        sbM15l.append(threadPoolExecutor.getActiveCount());
        sbM15l.append(", queue size: ");
        sbM15l.append(threadPoolExecutor.getQueue().size());
        LTTLogger.m5458d(str2, sbM15l.toString());
    }

    public void release() {
        String str = TAG;
        LTTLogger.m5461i(str, "Release - E");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.session != null) {
            this.session = null;
            LTTLogger.m5458d(str, "release: session released");
        }
        if (this.mainHandler != null) {
            this.mainHandler = null;
            LTTLogger.m5458d(str, "release: mainHandler released");
        }
        if (this.lttEngineListener != null) {
            this.lttEngineListener = null;
            LTTLogger.m5458d(str, "release: lttEngineListener callback released");
        }
        InpainterHelper inpainterHelper = this.inpainterHelper;
        if (inpainterHelper != null) {
            inpainterHelper.releaseInpainter();
            this.inpainterHelper = null;
            LTTLogger.m5458d(str, "release: inpainterHelper helper released");
        }
        LttNativeHelper lttNativeHelper = this.lttNativeHelper;
        if (lttNativeHelper != null) {
            lttNativeHelper.release();
            this.lttNativeHelper = null;
            LTTLogger.m5458d(str, "release: native helper released");
        }
        ExecutorService executorService = this.rendererService;
        if (executorService != null) {
            executorService.shutdownNow();
            this.rendererService = null;
            LTTLogger.m5458d(str, "release: renderer service released");
        }
        ExecutorService executorService2 = this.inpainterService;
        if (executorService2 != null) {
            executorService2.shutdownNow();
            this.inpainterService = null;
            LTTLogger.m5458d(str, "release: inpainter service released");
        }
        ExecutorService executorService3 = this.maskGenerationService;
        if (executorService3 != null) {
            executorService3.shutdownNow();
            this.maskGenerationService = null;
            LTTLogger.m5458d(str, "release: maskGenerationService service released");
        }
        this.isRenderEngineInitialized = false;
        this.isInpainterHelperInitialized = false;
        this.isMaskHelperInitialized = false;
        this.isLttEngineInitialized = false;
        LTTLogger.m5462p(str, "Engine release in : " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
        LTTLogger.m5461i(str, "Release - X");
    }

    public void setDstLang(String str, KeyFrameParam keyFrameParam) {
        if (str == null) {
            LTTLogger.m5458d(TAG, "setDstLang: DestLanguage not provided");
            return;
        }
        if (str.toLowerCase().contains("zh")) {
            keyFrameParam.setDestLanguage("zh");
        } else {
            keyFrameParam.setDestLanguage(str);
        }
        LTTLogger.m5458d(TAG, "setDstLang: DestLanguage - " + keyFrameParam.getDestLanguage());
    }

    public void setImageFormat(String str, KeyFrameParam keyFrameParam) {
        if (str == null) {
            keyFrameParam.setImageFormat("");
            LTTLogger.m5458d(TAG, "setImageFormat: ImageFormat not provided");
            return;
        }
        keyFrameParam.setImageFormat(str);
        LTTLogger.m5458d(TAG, "setImageFormat: ImageFormat - " + keyFrameParam.getImageFormat());
    }

    public void setSession(Session session) throws LttEngineException {
        if (session == null) {
            throw new LttEngineException(-1, "session is null");
        }
        this.lttEngineListener = session.getLttEngineListener();
        if (session.getLttEngineListener() == null) {
            throw new LttEngineException(-2, "callback is null");
        }
        if (session.getContext() == null) {
            throw new LttEngineException(-3, "context is null");
        }
        this.session = session;
    }

    public void validateInpainterImage(Bitmap bitmap) throws LttEngineException {
        if (bitmap == null) {
            throw new LttEngineException(LttEngineErrors.ERROR_INPAINTING_INPUT_IMAGE_NULL, "Invalid input image");
        }
    }

    public void validateInpainterOCR(LttOcrResult lttOcrResult) throws LttEngineException {
        if (lttOcrResult == null) {
            throw new LttEngineException(LttEngineErrors.ERROR_INPAINTING_OCR_NULL, "lttOcrResult invalid");
        }
        if (lttOcrResult.getBlockInfoList().isEmpty()) {
            throw new LttEngineException(LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_EMPTY, "No.of blocks(" + lttOcrResult.getBlockInfoList().size() + "). So there is nothing to inpaint");
        }
        if (Dump.IS_OCR_JSON_DUMP_ENABLED) {
            Dump.dumpFile(Util.convertToJson(lttOcrResult), "inpainter_ocr_" + System.currentTimeMillis() + ".json", "InpainterOCR");
        }
    }

    public void validateInpaintingNeeded(InpainterParam inpainterParam) throws LttEngineException {
        if (Math.ceil(((double) Math.max(inpainterParam.getInputImage().getHeight(), inpainterParam.getInputImage().getWidth())) / ((double) Math.min(inpainterParam.getInputImage().getHeight(), inpainterParam.getInputImage().getWidth()))) >= 7.0d) {
            throw new LttEngineException(LttEngineErrors.ERROR_INPAINTING_RESOLUTION_NOT_SUPPORTED, "Aspect Ratio for image is >= 7.0");
        }
    }

    public void validateInputImage(Bitmap bitmap) throws LttEngineException {
        if (bitmap == null) {
            throw new LttEngineException(-7, "Invalid input image");
        }
        if (bitmap.getHeight() > 16000 || bitmap.getWidth() > 16000) {
            throw new LttEngineException(-8, "Height : " + bitmap.getHeight() + " OR Width : " + bitmap.getWidth() + " is greater than supported resolution");
        }
        if (Dump.IS_INIT_DUMP_SUCCESS && Dump.IS_ORIGINAL_IMAGE_DUMP) {
            Dump.dumpBitmap(bitmap, "original_image_" + System.currentTimeMillis(), "OriginalImage");
        }
    }

    public void validateMaskInputImage(Bitmap bitmap) throws LttEngineException {
        if (bitmap == null) {
            throw new LttEngineException(-7, "Invalid input image");
        }
        if (bitmap.getHeight() > 16000 || bitmap.getWidth() > 16000) {
            throw new LttEngineException(-8, "Height : " + bitmap.getHeight() + " OR Width : " + bitmap.getWidth() + " is greater than supported resolution");
        }
        if (Math.ceil(((double) Math.max(bitmap.getHeight(), bitmap.getWidth())) / ((double) Math.min(bitmap.getHeight(), bitmap.getWidth()))) >= 7.0d) {
            throw new LttEngineException(-8, "Aspect Ratio for image is >= 7.0");
        }
        if (Dump.IS_INIT_DUMP_SUCCESS && Dump.IS_ORIGINAL_IMAGE_DUMP) {
            Dump.dumpBitmap(bitmap, "mask_request_input_image_" + System.currentTimeMillis(), "MaskRequest");
        }
    }

    public void validateOCRAndTranslation(LttOcrResult lttOcrResult, List<String> list) throws LttEngineException {
        if (lttOcrResult == null) {
            throw new LttEngineException(-9, "lttOcrResult invalid");
        }
        if (lttOcrResult.getBlockInfoList().isEmpty()) {
            throw new LttEngineException(-10, "No.of blocks(" + lttOcrResult.getBlockInfoList().size() + "). So there is nothing to render");
        }
        if (list == null) {
            throw new LttEngineException(-11, "Translation Result Invalid");
        }
        if (list.isEmpty()) {
            throw new LttEngineException(-12, "No.of translation(" + list.size() + "). So there is nothing to render");
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (!it.next().isEmpty()) {
                if (lttOcrResult.getBlockInfoList().size() != list.size()) {
                    throw new LttEngineException(-14, "No. of Blocks(" + lttOcrResult.getBlockInfoList().size() + ") and No. of translation results(" + list.size() + ") doesn't match");
                }
                LTTLogger.m5461i(TAG, "validateBlockAndTranslation: Block size - " + lttOcrResult.getBlockInfoList().size() + ", Translation size - " + list.size());
                if (Dump.IS_INIT_DUMP_SUCCESS && Dump.IS_OCR_JSON_DUMP_ENABLED) {
                    Dump.dumpFile(Util.convertToJson(lttOcrResult), "Json_result_dump" + System.currentTimeMillis() + ".json", "Json_Result");
                }
                if (Dump.IS_INIT_DUMP_SUCCESS && Dump.IS_TRANSLATED_DUMP_ENABLED) {
                    Dump.dumpStringListToJsonFile(list, "Trl_result_dump" + System.currentTimeMillis() + ".json", "Trl_Result");
                    return;
                }
                return;
            }
        }
        throw new LttEngineException(-13, "Translation is empty for all the lines");
    }

    public void preProcessOnInputImage(Bitmap bitmap, KeyFrameParam keyFrameParam) {
        String str = TAG;
        LTTLogger.m5463v(str, "preProcessOnInputImage: E");
        keyFrameParam.setOriginalImageSize(new Size(bitmap.getWidth(), bitmap.getHeight()));
        keyFrameParam.setInputImage(bitmap);
        LTTLogger.m5463v(str, "preProcessOnInputImage: Original width - " + bitmap.getWidth() + " height - " + bitmap.getHeight());
        Size sizeDecideAndSetResizeParams = decideAndSetResizeParams(bitmap.getWidth(), bitmap.getHeight());
        keyFrameParam.setResizedImageSize(sizeDecideAndSetResizeParams);
        int width = sizeDecideAndSetResizeParams.getWidth();
        int height = sizeDecideAndSetResizeParams.getHeight();
        if (width != bitmap.getWidth() || height != bitmap.getHeight()) {
            keyFrameParam.setResizeRatio(updateScaleFactor(bitmap.getWidth(), bitmap.getHeight(), height, width));
            long jCurrentTimeMillis = System.currentTimeMillis();
            bitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
            LTTLogger.m5462p(str, "preProcessOnInputImage: upScaling time: " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
        }
        keyFrameParam.setInputImage(bitmap);
        LTTLogger.m5458d(str, "preProcessOnInputImage: Input width - " + bitmap.getWidth() + " height - " + bitmap.getHeight());
        if (Dump.IS_INIT_DUMP_SUCCESS && Dump.IS_ORIGINAL_UPSCALED_IMAGE_DUMP) {
            Dump.dumpBitmap(bitmap, "input_image_" + System.currentTimeMillis(), "InputImage");
        }
        LTTLogger.m5463v(str, "preProcessOnInputImage: X");
    }
}
