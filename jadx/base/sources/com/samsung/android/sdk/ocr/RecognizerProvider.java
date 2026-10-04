package com.samsung.android.sdk.ocr;

import android.graphics.Bitmap;
import android.util.Log;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.ocr.OCRException;
import com.samsung.android.sdk.ocr.OCRResult;
import com.samsung.android.sdk.pen.ocr.SpenIOcrEngine;
import com.samsung.android.sdk.pen.ocr.SpenITypeClassifier;
import com.samsung.android.sdk.pen.ocr.SpenOcrEngine;
import com.samsung.android.sdk.pen.ocr.SpenOcrLanguage;
import com.samsung.android.sdk.pen.ocr.SpenOcrModelLoaderFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class RecognizerProvider {
    private static final String TAG = "RecognizerProvider";
    protected SpenITypeClassifier mClassifier;
    protected SpenIOcrEngine mEngine;
    protected OCRType mOCRType;
    protected IOCRecognizer mSOCRecognizer = null;
    protected IOCRecognizer mMOCRecognizer = null;
    protected final DataConverter mDataConverter = new DataConverter(8192);

    /* JADX INFO: renamed from: com.samsung.android.sdk.ocr.RecognizerProvider$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C74251 {
        static final /* synthetic */ int[] $SwitchMap$com$samsung$android$sdk$ocr$OCRType;

        static {
            int[] iArr = new int[OCRType.values().length];
            $SwitchMap$com$samsung$android$sdk$ocr$OCRType = iArr;
            try {
                iArr[OCRType.OCR_ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$samsung$android$sdk$ocr$OCRType[OCRType.OCR_PRINTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$samsung$android$sdk$ocr$OCRType[OCRType.OCR_HANDWRITTEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public RecognizerProvider(RecognizerParams recognizerParams, RecognizerSupporter recognizerSupporter) {
        this.mEngine = null;
        this.mClassifier = null;
        this.mOCRType = OCRType.OCR_ALL;
        this.mOCRType = recognizerParams.ocrType;
        if (recognizerSupporter.isSOCRSupported) {
            Log.w(TAG, "SOCR is supported");
            SpenOcrEngine spenOcrEngine = new SpenOcrEngine(recognizerParams.context, whichModelLoader(false));
            this.mEngine = spenOcrEngine;
            this.mClassifier = spenOcrEngine.createTypeClassifier();
            createSOCRRecognizer(recognizerParams);
        } else {
            Log.w(TAG, "SOCR is not supported");
        }
        if (!recognizerSupporter.isMOCRSupported) {
            Log.w(TAG, "MOCR is not supported");
        } else {
            Log.w(TAG, "MOCR is supported");
            createMOCRecognizer(recognizerParams.language);
        }
    }

    private void closeCommonSCORecognizer() {
        SpenITypeClassifier spenITypeClassifier = this.mClassifier;
        if (spenITypeClassifier != null) {
            spenITypeClassifier.close();
        }
        this.mClassifier = null;
        IOCRecognizer iOCRecognizer = this.mSOCRecognizer;
        if (iOCRecognizer != null) {
            iOCRecognizer.destroy();
        }
        this.mSOCRecognizer = null;
        SpenIOcrEngine spenIOcrEngine = this.mEngine;
        if (spenIOcrEngine != null) {
            spenIOcrEngine.close();
        }
        this.mEngine = null;
    }

    private void closeMOCRecognizer() {
        IOCRecognizer iOCRecognizer = this.mMOCRecognizer;
        if (iOCRecognizer != null) {
            iOCRecognizer.destroy();
        }
        this.mMOCRecognizer = null;
    }

    private void createMOCRecognizer(OCRLanguage oCRLanguage) {
        if (MOCRecognizer.isSupportedLanguage(oCRLanguage)) {
            this.mMOCRecognizer = new MOCRecognizer(oCRLanguage);
            return;
        }
        Log.w(TAG, "MOCRecognizer does not support language(" + oCRLanguage.toString() + ")");
        this.mMOCRecognizer = null;
    }

    private IOCRecognizer getHandwrittenTypeRecognizer(OCRResult.ProcessInfo processInfo) {
        if (this.mSOCRecognizer != null) {
            Log.i(TAG, "Select recognizer by user selected type: OCRType =" + this.mOCRType);
            return getRecognizer(true, processInfo);
        }
        Log.e(TAG, "User selected ocr type is not supported: " + this.mOCRType);
        return null;
    }

    private IOCRecognizer getPrintedTypeRecognizer(OCRResult.ProcessInfo processInfo) {
        if (this.mMOCRecognizer != null) {
            Log.i(TAG, "Select recognizer by user selected type: OCRType =" + this.mOCRType);
            return getRecognizer(false, processInfo);
        }
        Log.e(TAG, "User selected ocr type is not supported: " + this.mOCRType);
        return null;
    }

    public void checkRecognizerIsCreated() {
        if (this.mMOCRecognizer == null && this.mSOCRecognizer == null) {
            throw new OCRException.UnsupportedRecognizerException("Any recognizer has not been created!");
        }
    }

    public void close() {
        Log.i(TAG, "RecognizerProvider close()");
        closeMOCRecognizer();
        closeCommonSCORecognizer();
    }

    public void createSOCRRecognizer(RecognizerParams recognizerParams) {
        if (this.mEngine.isSupportedLanguage(SpenOcrLanguage.from(recognizerParams.language))) {
            this.mSOCRecognizer = new SOCRecognizer(this.mEngine, recognizerParams);
            return;
        }
        Log.w(TAG, "SOCRecognizer does not support language(" + recognizerParams.language.toString() + ")");
        this.mSOCRecognizer = null;
    }

    public void finalize() {
        close();
    }

    public IOCRecognizer getAllTypeRecognizer(Bitmap bitmap, OCRResult.ProcessInfo processInfo) {
        IOCRecognizer iOCRecognizer = this.mMOCRecognizer;
        if (iOCRecognizer == null || this.mSOCRecognizer == null) {
            if (iOCRecognizer != null) {
                Log.w(TAG, "Select recognizer for Printed image");
                return getRecognizer(false, processInfo);
            }
            Log.w(TAG, "Select recognizer for Handwritten image");
            return getRecognizer(true, processInfo);
        }
        SpenITypeClassifier spenITypeClassifier = this.mClassifier;
        if (spenITypeClassifier == null) {
            throw new NullPointerException("Type classifier is not ready");
        }
        boolean zIsHandwrittenImage = spenITypeClassifier.isHandwrittenImage(bitmap);
        AbstractC4539a.m3208r("Select recognizer by type classification: isHandwritten=", TAG, zIsHandwrittenImage);
        return getRecognizer(zIsHandwrittenImage, processInfo);
    }

    public IOCRecognizer getRecognizer(Bitmap bitmap, OCRResult.ProcessInfo processInfo) {
        int i = C74251.$SwitchMap$com$samsung$android$sdk$ocr$OCRType[this.mOCRType.ordinal()];
        if (i == 1) {
            return getAllTypeRecognizer(bitmap, processInfo);
        }
        if (i == 2) {
            return getPrintedTypeRecognizer(processInfo);
        }
        if (i == 3) {
            return getHandwrittenTypeRecognizer(processInfo);
        }
        Log.e(TAG, "User selected ocr type is not supported: " + this.mOCRType);
        return null;
    }

    public boolean isHandwritten(Bitmap bitmap) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zIsHandwrittenImage = this.mClassifier.isHandwrittenImage(bitmap);
        Log.i(TAG, String.format("Type Classification(isHandwrittenImage=%s), Time: %d ms", Boolean.toString(zIsHandwrittenImage), Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)));
        return zIsHandwrittenImage;
    }

    public boolean isPrinted(Bitmap bitmap) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zIsPrintedImage = this.mClassifier.isPrintedImage(bitmap);
        Log.i(TAG, String.format("Type Classification(isPrintedImage=%s), Time: %d ms", Boolean.toString(zIsPrintedImage), Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)));
        return zIsPrintedImage;
    }

    public SpenOcrModelLoaderFactory.MODEL_LOADER whichModelLoader(boolean z) {
        return z ? SpenOcrModelLoaderFactory.MODEL_LOADER.ASSETS : SpenOcrModelLoaderFactory.MODEL_LOADER.PROVIDER_LATEST;
    }

    public IOCRecognizer getRecognizer(boolean z, OCRResult.ProcessInfo processInfo) {
        processInfo.setHandwrittenResult(z);
        IOCRecognizer iOCRecognizer = z ? this.mSOCRecognizer : this.mMOCRecognizer;
        processInfo.setEngineVersion(iOCRecognizer.getVersion(), z);
        return iOCRecognizer;
    }
}
