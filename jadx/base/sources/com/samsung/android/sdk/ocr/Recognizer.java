package com.samsung.android.sdk.ocr;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.Log;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.feature.SemFloatingFeature;
import com.samsung.android.sdk.pen.ocr.SpenOcrEngine;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class Recognizer implements IRecognizer {
    private static final int SOCR_LIB_VERSION_FOR_ONEUI41 = 100;
    private static final int SOCR_LIB_VERSION_FOR_ONEUI411 = 200;
    private static final int SOCR_LIB_VERSION_FOR_ONEUI50 = 300;
    private static final String TAG = "Recognizer";
    protected IRecognizer instance;
    private boolean mClosing;
    private final SafeCloser mSafeCloser;

    /* JADX INFO: renamed from: com.samsung.android.sdk.ocr.Recognizer$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C74191 {
        static final /* synthetic */ int[] $SwitchMap$com$samsung$android$sdk$ocr$RecognizerVersion;

        static {
            int[] iArr = new int[RecognizerVersion.values().length];
            $SwitchMap$com$samsung$android$sdk$ocr$RecognizerVersion = iArr;
            try {
                iArr[RecognizerVersion.RECOGNIZER_FOR_FW_ONEUI41.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$samsung$android$sdk$ocr$RecognizerVersion[RecognizerVersion.RECOGNIZER_FOR_FW_ONEUI411.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$samsung$android$sdk$ocr$RecognizerVersion[RecognizerVersion.RECOGNIZER_FOR_FW_LATEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$samsung$android$sdk$ocr$RecognizerVersion[RecognizerVersion.RECOGNIZER_FOR_DATA_PROVIDER_SERVICE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public Recognizer(RecognizerParams recognizerParams) {
        this(recognizerParams.context, recognizerParams.ocrType, recognizerParams.language);
    }

    private boolean checkInstanceNull(RecognizerApi recognizerApi) {
        return checkInstanceNull(recognizerApi, true);
    }

    private boolean checkIsClosing(RecognizerApi recognizerApi) {
        if (!this.mClosing) {
            return false;
        }
        Log.e(TAG, "[" + recognizerApi.toName() + "] This instance is closing...");
        decreaseCallingCountOf(recognizerApi);
        return true;
    }

    private void closeWith(boolean z) {
        AbstractC4539a.m3208r("Recognizer close() - start : waiting = ", TAG, z);
        if (checkInstanceNull(RecognizerApi.CLOSE, false)) {
            return;
        }
        if (z) {
            waitUntilOtherThreadIsDone();
        }
        this.mClosing = true;
        synchronized (this.mSafeCloser) {
            this.instance.close();
        }
        this.mClosing = false;
        Log.i(TAG, "Recognizer close() - finish");
    }

    private void decreaseCallingCountOf(RecognizerApi recognizerApi) {
        SafeCloser safeCloser = this.mSafeCloser;
        if (safeCloser != null) {
            safeCloser.decreaseCallingCountOf(recognizerApi);
        }
    }

    public static int getVersionOfNativeLibInDevice(Context context, int i) {
        return i >= 200 ? RecognizerUtils.getVersionOfNativeLibInDevice() : RecognizerUtils.getVersionOfNativeLibInOneUI41Device(context);
    }

    public static int getVersionOfNativeLibInServiceProvider(Context context) {
        return RecognizerUtils.getVersionOfNativeLibInServiceProvider(context);
    }

    private void increaseCallingCountOf(RecognizerApi recognizerApi) {
        SafeCloser safeCloser = this.mSafeCloser;
        if (safeCloser != null) {
            safeCloser.increaseCallingCountOf(recognizerApi);
        }
    }

    public static boolean isSupported(Context context, OCRType oCRType) {
        String string;
        try {
            string = SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_CAMERA_CONFIG_STRIDE_OCR_VERSION");
            Log.i(TAG, "SEC_FLOATING_FEATURE_CAMERA_CONFIG_STRIDE_OCR_VERSION=[" + string + "]");
        } catch (NoClassDefFoundError e) {
            Log.e(TAG, "Recognizer.isSupported() [NoClassDefFoundError] " + e.getMessage());
        } catch (NoSuchMethodError e2) {
            Log.e(TAG, "Recognizer.isSupported() [NoSuchMethodError] " + e2.getMessage());
        }
        if (!"V1".equals(string) && !"V2".equals(string) && !"Lite".equals(string)) {
            if ("None".equals(string)) {
                Log.e(TAG, "Recognizer.isSupported() Return false with feature version[None]");
                return false;
            }
            Log.e(TAG, "Recognizer.isSupported() Undefined version [" + string + "], checking libs in device");
            Log.e(TAG, "Recognizer.isSupported() There is no floatingFeature for OCR_VERSION");
            int i = C74191.$SwitchMap$com$samsung$android$sdk$ocr$RecognizerVersion[selectRecognizerVersion(context).ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                if (!RecognizerInternal.isSupported(context, oCRType)) {
                    Log.e(TAG, "Recognizer.isSupported() RecognizerInternal.isSupported() is failed");
                    return false;
                }
            } else {
                if (i != 4) {
                    Log.e(TAG, "Recognizer.isSupported() Undefined Recosgnizer Version");
                    return false;
                }
                if (!RecognizerProxy.isSupported(oCRType)) {
                    Log.e(TAG, "Recognizer.isSupported() RecognizerProxy.isSupported() is failed");
                    return false;
                }
            }
            Log.w(TAG, "Recognizer.isSupported() Return true without feature");
            return true;
        }
        Log.i(TAG, "Recognizer.isSupported() Return true with feature version[" + string + "]");
        return true;
    }

    public static RecognizerVersion selectRecognizerVersion(Context context) {
        if (!SpenOcrEngine.isSupported(context)) {
            Log.w(TAG, "SOCR is not supported!");
            return RecognizerVersion.RECOGNIZER_FOR_UNKNOWN;
        }
        int versionOfNativeLibInServiceProvider = getVersionOfNativeLibInServiceProvider(context);
        int versionOfNativeLibInDevice = getVersionOfNativeLibInDevice(context, versionOfNativeLibInServiceProvider);
        Log.i(TAG, String.format("Version: OCRDataProvider(%d), Device(%d)", Integer.valueOf(versionOfNativeLibInServiceProvider), Integer.valueOf(versionOfNativeLibInDevice)));
        if (versionOfNativeLibInServiceProvider > versionOfNativeLibInDevice) {
            Log.i(TAG, "Version for RECOGNIZER_FOR_DATA_PROVIDER_SERVICE is selected");
            return RecognizerVersion.RECOGNIZER_FOR_DATA_PROVIDER_SERVICE;
        }
        if (versionOfNativeLibInDevice >= 300) {
            Log.i(TAG, "Version for RECOGNIZER_FOR_FW_LATEST is selected");
            return RecognizerVersion.RECOGNIZER_FOR_FW_LATEST;
        }
        if (versionOfNativeLibInDevice >= 200) {
            Log.i(TAG, "Version for RECOGNIZER_FOR_FW_ONEUI411 is selected");
            return RecognizerVersion.RECOGNIZER_FOR_FW_ONEUI411;
        }
        Log.i(TAG, "Version for RECOGNIZER_FOR_FW_ONEUI41 is selected");
        return RecognizerVersion.RECOGNIZER_FOR_FW_ONEUI41;
    }

    private void waitUntilOtherThreadIsDone() {
        SafeCloser safeCloser = this.mSafeCloser;
        if (safeCloser != null) {
            safeCloser.waitUntilOtherThreadIsDone();
        }
    }

    @Override // com.samsung.android.sdk.ocr.IRecognizer
    public void cancel() {
        RecognizerApi recognizerApi = RecognizerApi.CANCEL;
        increaseCallingCountOf(recognizerApi);
        if (checkInstanceNull(recognizerApi) || checkIsClosing(recognizerApi)) {
            return;
        }
        this.instance.cancel();
        decreaseCallingCountOf(recognizerApi);
    }

    @Override // com.samsung.android.sdk.ocr.IRecognizer
    public void close() {
        closeWith(true);
    }

    @Override // com.samsung.android.sdk.ocr.IRecognizer
    public boolean detect(Bitmap bitmap, OCRResult oCRResult) {
        RecognizerApi recognizerApi = RecognizerApi.DETECT;
        increaseCallingCountOf(recognizerApi);
        if (checkInstanceNull(recognizerApi) || checkIsClosing(recognizerApi)) {
            return false;
        }
        boolean zDetect = this.instance.detect(bitmap, oCRResult);
        decreaseCallingCountOf(recognizerApi);
        return zDetect;
    }

    @Override // com.samsung.android.sdk.ocr.IRecognizer
    public boolean detectBlock(Bitmap bitmap, Point[] pointArr) {
        RecognizerApi recognizerApi = RecognizerApi.DETECT_BLOCK2;
        increaseCallingCountOf(recognizerApi);
        if (checkInstanceNull(recognizerApi) || checkIsClosing(recognizerApi)) {
            return false;
        }
        boolean zDetectBlock = this.instance.detectBlock(bitmap, pointArr);
        decreaseCallingCountOf(recognizerApi);
        return zDetectBlock;
    }

    @Override // com.samsung.android.sdk.ocr.IRecognizer
    public boolean detectText(Bitmap bitmap) {
        RecognizerApi recognizerApi = RecognizerApi.DETECT_TEXT;
        increaseCallingCountOf(recognizerApi);
        if (checkInstanceNull(recognizerApi) || checkIsClosing(recognizerApi)) {
            return false;
        }
        boolean zDetectText = this.instance.detectText(bitmap);
        decreaseCallingCountOf(recognizerApi);
        return zDetectText;
    }

    public void finalize() {
        closeWith(false);
    }

    @Override // com.samsung.android.sdk.ocr.IRecognizer
    public boolean hasText(Bitmap bitmap) {
        RecognizerApi recognizerApi = RecognizerApi.HAS_TEXT1;
        increaseCallingCountOf(recognizerApi);
        if (checkInstanceNull(recognizerApi) || checkIsClosing(recognizerApi)) {
            return false;
        }
        boolean zHasText = this.instance.hasText(bitmap);
        decreaseCallingCountOf(recognizerApi);
        return zHasText;
    }

    @Override // com.samsung.android.sdk.ocr.IRecognizer
    public boolean isHandwritten(Bitmap bitmap) {
        RecognizerApi recognizerApi = RecognizerApi.IS_HANDWRITTEN;
        increaseCallingCountOf(recognizerApi);
        if (checkInstanceNull(recognizerApi) || checkIsClosing(recognizerApi)) {
            return false;
        }
        boolean zIsHandwritten = this.instance.isHandwritten(bitmap);
        decreaseCallingCountOf(recognizerApi);
        return zIsHandwritten;
    }

    @Override // com.samsung.android.sdk.ocr.IRecognizer
    public boolean isPrinted(Bitmap bitmap) {
        RecognizerApi recognizerApi = RecognizerApi.IS_PRINTED;
        increaseCallingCountOf(recognizerApi);
        if (checkInstanceNull(recognizerApi) || checkIsClosing(recognizerApi)) {
            return false;
        }
        boolean zIsPrinted = this.instance.isPrinted(bitmap);
        decreaseCallingCountOf(recognizerApi);
        return zIsPrinted;
    }

    @Override // com.samsung.android.sdk.ocr.IRecognizer
    public boolean recognize(Bitmap bitmap, OCRResult oCRResult) {
        RecognizerApi recognizerApi = RecognizerApi.RECOGNIZE;
        increaseCallingCountOf(recognizerApi);
        if (checkInstanceNull(recognizerApi) || checkIsClosing(recognizerApi)) {
            return false;
        }
        boolean zRecognize = this.instance.recognize(bitmap, oCRResult);
        decreaseCallingCountOf(recognizerApi);
        return zRecognize;
    }

    @Override // com.samsung.android.sdk.ocr.IRecognizer
    public boolean recognizeBlockAt(Bitmap bitmap, Point point, boolean z, OCRResult oCRResult) {
        RecognizerApi recognizerApi = RecognizerApi.RECOGNIZE_BLOCK_AT;
        increaseCallingCountOf(recognizerApi);
        if (checkInstanceNull(recognizerApi) || checkIsClosing(recognizerApi)) {
            return false;
        }
        boolean zRecognizeBlockAt = this.instance.recognizeBlockAt(bitmap, point, z, oCRResult);
        decreaseCallingCountOf(recognizerApi);
        return zRecognizeBlockAt;
    }

    public Recognizer(Context context, OCRType oCRType, OCRLanguage oCRLanguage) {
        this.instance = null;
        int i = C74191.$SwitchMap$com$samsung$android$sdk$ocr$RecognizerVersion[selectRecognizerVersion(context).ordinal()];
        if (i == 1) {
            Log.i(TAG, "OCR Recognizer is initialized as RecognizerInternal_OneUI41 with version: 3.4.250618");
            this.instance = new RecognizerInternal_OneUI41(context, oCRType, oCRLanguage);
        } else if (i == 2) {
            Log.i(TAG, "OCR Recognizer is initialized as RecognizerInternal_OneUI411 with version: 3.4.250618");
            this.instance = new RecognizerInternal_OneUI411(context, oCRType, oCRLanguage);
        } else if (i == 3) {
            Log.i(TAG, "OCR Recognizer is initialized as RecognizerInternal with version: 3.4.250618");
            this.instance = new RecognizerInternal(context, oCRType, oCRLanguage);
        } else if (i != 4) {
            Log.e(TAG, "Undefined Recognizer Version");
        } else {
            Log.i(TAG, "OCR Recognizer is initialized as RecognizerProxy with version: 3.4.250618");
            this.instance = new RecognizerProxy(context, oCRType, oCRLanguage);
        }
        this.mSafeCloser = new SafeCloser(System.identityHashCode(this));
        this.mClosing = false;
    }

    private boolean checkInstanceNull(RecognizerApi recognizerApi, boolean z) {
        if (this.instance != null) {
            return false;
        }
        Log.e(TAG, "[" + recognizerApi.toName() + "] Instance has not been created yet.");
        if (!z) {
            return true;
        }
        decreaseCallingCountOf(recognizerApi);
        return true;
    }

    @Override // com.samsung.android.sdk.ocr.IRecognizer
    public boolean detectBlock(Bitmap bitmap, Point point, Point[] pointArr) {
        RecognizerApi recognizerApi = RecognizerApi.DETECT_BLOCK3;
        increaseCallingCountOf(recognizerApi);
        if (checkInstanceNull(recognizerApi) || checkIsClosing(recognizerApi)) {
            return false;
        }
        boolean zDetectBlock = this.instance.detectBlock(bitmap, point, pointArr);
        decreaseCallingCountOf(recognizerApi);
        return zDetectBlock;
    }

    @Override // com.samsung.android.sdk.ocr.IRecognizer
    public boolean hasText(Bitmap bitmap, boolean z) {
        RecognizerApi recognizerApi = RecognizerApi.HAS_TEXT2;
        increaseCallingCountOf(recognizerApi);
        if (checkInstanceNull(recognizerApi) || checkIsClosing(recognizerApi)) {
            return false;
        }
        boolean zHasText = this.instance.hasText(bitmap, z);
        decreaseCallingCountOf(recognizerApi);
        return zHasText;
    }
}
