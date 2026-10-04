package com.samsung.android.sdk.ocr;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.Log;
import com.samsung.android.sdk.ocr.OCRException;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class RecognizerInternal implements IRecognizer {
    private static final String TAG = "RecognizerInternal";
    private static final Object mSyncObj = new Object();
    protected IOCRecognizer mCurrentRecognizer;
    protected RecognizerProvider mRecognizerProvider;
    protected RecognizerSupporter mRecognizerSupporter;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ocr_processor {
        boolean process(IOCRecognizer iOCRecognizer, Bitmap bitmap, OCRResult oCRResult);
    }

    public RecognizerInternal(RecognizerParams recognizerParams) {
        this(recognizerParams.context, recognizerParams.ocrType, recognizerParams.language);
    }

    private void checkRecognizerStatus() {
        RecognizerProvider recognizerProvider = this.mRecognizerProvider;
        if (recognizerProvider == null) {
            throw new OCRException.InvalidUsageException("Recognizer is closed or has not been created");
        }
        recognizerProvider.checkRecognizerIsCreated();
    }

    public static boolean isSupported(Context context, OCRType oCRType) {
        return RecognizerSupporter.isSupported(context, oCRType);
    }

    private boolean processCommon(Bitmap bitmap, OCRResult oCRResult) {
        checkRecognizerStatus();
        if (!RecognizerAPIChecker.isValidParameter(bitmap, oCRResult)) {
            return false;
        }
        Log.i(TAG, String.format("[process] Input Image Size: (%d, %d)", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())));
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.mCurrentRecognizer != null) {
            Log.e(TAG, "Recognizer is already in processing");
            return false;
        }
        IOCRecognizer recognizer = this.mRecognizerProvider.getRecognizer(bitmap, oCRResult.getProcessInfo());
        this.mCurrentRecognizer = recognizer;
        if (recognizer == null) {
            Log.e(TAG, "There is no recognizer created.");
            return false;
        }
        Log.i(TAG, String.format("OCR Common processing Time: %d ms", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)));
        return true;
    }

    private void processEnd() {
        this.mCurrentRecognizer = null;
        Log.i(TAG, "Processing of Recognizer completed");
    }

    @Override // com.samsung.android.sdk.ocr.IRecognizer
    public void cancel() {
        if (this.mCurrentRecognizer == null) {
            Log.w(TAG, "There is no recognizer to cancel processing");
        } else {
            Log.i(TAG, "Cancel processing...");
            this.mCurrentRecognizer.cancel();
        }
    }

    @Override // com.samsung.android.sdk.ocr.IRecognizer
    public void close() {
        Log.i(TAG, "RecognizerInternal close()");
        closeRecognizerProvider();
    }

    public void closeRecognizerProvider() {
        RecognizerProvider recognizerProvider = this.mRecognizerProvider;
        if (recognizerProvider != null) {
            recognizerProvider.close();
        }
        this.mRecognizerProvider = null;
    }

    public void createRecognizerProvider(RecognizerParams recognizerParams) {
        closeRecognizerProvider();
        this.mRecognizerProvider = new RecognizerProvider(recognizerParams, this.mRecognizerSupporter);
    }

    @Override // com.samsung.android.sdk.ocr.IRecognizer
    public boolean detect(Bitmap bitmap, OCRResult oCRResult) {
        return process(bitmap, new ocr_processor() { // from class: com.samsung.android.sdk.ocr.RecognizerInternal.2
            @Override // com.samsung.android.sdk.ocr.RecognizerInternal.ocr_processor
            public boolean process(IOCRecognizer iOCRecognizer, Bitmap bitmap2, OCRResult oCRResult2) {
                Log.i(RecognizerInternal.TAG, "OCR Text Detection(Localizing)....");
                boolean zDetect = iOCRecognizer.detect(bitmap2, oCRResult2);
                Log.i(RecognizerInternal.TAG, "OCR Text Detection(Localizing) Done(ret=" + zDetect + ")");
                return zDetect;
            }
        }, oCRResult);
    }

    @Override // com.samsung.android.sdk.ocr.IRecognizer
    public boolean detectBlock(Bitmap bitmap, Point[] pointArr) {
        return detectBlock(bitmap, new Point(bitmap.getWidth() / 2, bitmap.getHeight() / 2), pointArr);
    }

    @Override // com.samsung.android.sdk.ocr.IRecognizer
    public boolean detectText(Bitmap bitmap) {
        return process(bitmap, new ocr_processor() { // from class: com.samsung.android.sdk.ocr.RecognizerInternal.1
            @Override // com.samsung.android.sdk.ocr.RecognizerInternal.ocr_processor
            public boolean process(IOCRecognizer iOCRecognizer, Bitmap bitmap2, OCRResult oCRResult) {
                Log.i(RecognizerInternal.TAG, "OCR Text Detecting(detectText)....");
                boolean zDetectText = iOCRecognizer.detectText(bitmap2);
                Log.i(RecognizerInternal.TAG, "OCR Text Detecting(detectText) Done (ret=" + zDetectText + ")");
                return zDetectText;
            }
        }, new OCRResult());
    }

    public void finalize() {
        close();
    }

    @Override // com.samsung.android.sdk.ocr.IRecognizer
    public boolean hasText(Bitmap bitmap) {
        return hasText(bitmap, true);
    }

    @Override // com.samsung.android.sdk.ocr.IRecognizer
    public boolean isHandwritten(Bitmap bitmap) {
        Log.i(TAG, String.format("[isHandwritten] Input Image Size: (%d, %d)", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())));
        checkRecognizerStatus();
        return this.mRecognizerProvider.isHandwritten(bitmap);
    }

    @Override // com.samsung.android.sdk.ocr.IRecognizer
    public boolean isPrinted(Bitmap bitmap) {
        Log.i(TAG, String.format("[isPrinted] Input Image Size: (%d, %d)", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())));
        checkRecognizerStatus();
        return this.mRecognizerProvider.isPrinted(bitmap);
    }

    public boolean process(Bitmap bitmap, ocr_processor ocr_processorVar, OCRResult oCRResult) {
        synchronized (mSyncObj) {
            try {
                if (!processCommon(bitmap, oCRResult)) {
                    return false;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                IOCRecognizer iOCRecognizer = this.mCurrentRecognizer;
                if (iOCRecognizer == null) {
                    Log.e(TAG, "OCR processing : Recognizer is null!");
                    return false;
                }
                boolean zProcess = ocr_processorVar.process(iOCRecognizer, bitmap, oCRResult);
                Log.i(TAG, "OCR Processing result of processor.process(...): " + zProcess);
                Log.i(TAG, String.format("OCR processing Time: %d ms", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)));
                processEnd();
                return zProcess;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.sdk.ocr.IRecognizer
    public boolean recognize(Bitmap bitmap, OCRResult oCRResult) {
        return process(bitmap, new ocr_processor() { // from class: com.samsung.android.sdk.ocr.RecognizerInternal.3
            @Override // com.samsung.android.sdk.ocr.RecognizerInternal.ocr_processor
            public boolean process(IOCRecognizer iOCRecognizer, Bitmap bitmap2, OCRResult oCRResult2) {
                Log.i(RecognizerInternal.TAG, "OCR Text Recognizing....");
                boolean zRecognize = iOCRecognizer.recognize(bitmap2, oCRResult2);
                String text = oCRResult2.getText();
                int length = text.isEmpty() ? 0 : text.length();
                Log.i(RecognizerInternal.TAG, "OCR Text Recognizing Done(success=" + zRecognize + ")");
                Log.i(RecognizerInternal.TAG, String.format("%d characters(including whitespace) are recognized.", Integer.valueOf(length)));
                if (!zRecognize) {
                    Log.e(RecognizerInternal.TAG, "OCR Process.recognize() failed!");
                }
                return zRecognize;
            }
        }, oCRResult);
    }

    @Override // com.samsung.android.sdk.ocr.IRecognizer
    public boolean recognizeBlockAt(Bitmap bitmap, Point point, boolean z, OCRResult oCRResult) {
        synchronized (mSyncObj) {
            try {
                int length = 0;
                if (!processCommon(bitmap, oCRResult)) {
                    return false;
                }
                if (point == null) {
                    Log.e(TAG, "Point of Interest is NULL");
                    return false;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                Log.i(TAG, "OCR Text Recognizing(BlocK) at (" + point.x + SQLKeyword.COMMA + point.y + ") forceToSelectAny=" + z);
                IOCRecognizer iOCRecognizer = this.mCurrentRecognizer;
                if (iOCRecognizer == null) {
                    Log.e(TAG, "recognizeBlockAt : Recognizer is null!");
                    return false;
                }
                boolean zRecognizeBlockAt = iOCRecognizer.recognizeBlockAt(bitmap, point, z, oCRResult);
                String text = oCRResult.getText();
                if (!text.isEmpty()) {
                    length = text.length();
                }
                Log.i(TAG, "OCR Text Recognizing(BlocK) Done(success=" + zRecognizeBlockAt + ")");
                Log.i(TAG, String.format("%d characters(including whitespace) are recognized.", Integer.valueOf(length)));
                if (!zRecognizeBlockAt) {
                    Log.e(TAG, "OCR recognizeBlockAt(...) failed!");
                }
                Log.i(TAG, "OCR Processing result of recognizeBlockAt(...): " + zRecognizeBlockAt);
                Log.i(TAG, String.format("OCR processing Time: %d ms", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)));
                processEnd();
                return zRecognizeBlockAt;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public RecognizerInternal(Context context, OCRType oCRType, OCRLanguage oCRLanguage) {
        this.mRecognizerSupporter = null;
        this.mRecognizerProvider = null;
        this.mCurrentRecognizer = null;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Log.i(TAG, "OCR Recognizer(Internal) is initialized with version: 3.4.250618");
        RecognizerParams recognizerParams = new RecognizerParams(context, oCRType, oCRLanguage);
        Log.i(TAG, "- Language : " + recognizerParams.language.toString());
        Log.i(TAG, "- OCR Type : " + recognizerParams.ocrType);
        this.mRecognizerSupporter = new RecognizerSupporter(context);
        Log.i(TAG, "- MOCR Support: " + this.mRecognizerSupporter.isMOCRSupported);
        AbstractC0000a.m27x(new StringBuilder("- SOCR Support: "), this.mRecognizerSupporter.isSOCRSupported, TAG);
        this.mRecognizerSupporter.checkRecognizerSupportedType(oCRType);
        createRecognizerProvider(recognizerParams);
        Log.i(TAG, String.format("OCR Initialization(Recognizer Creation) Time: %d ms", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)));
    }

    @Override // com.samsung.android.sdk.ocr.IRecognizer
    public boolean hasText(Bitmap bitmap, boolean z) {
        Log.i(TAG, String.format("[hasText] Input Image Size: (%d, %d)", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())));
        Log.i(TAG, "[hasText] checkPrintedTypeFirst : " + z);
        if (z) {
            if (this.mRecognizerProvider.isPrinted(bitmap)) {
                Log.i(TAG, "Step 1. hasText() true because isPrinted(bitmap) is true");
                return true;
            }
            Log.i(TAG, "Step 1. hasText() undefined because isPrinted(bitmap) is false");
            if (this.mRecognizerProvider.isHandwritten(bitmap)) {
                Log.i(TAG, "Step 2. hasText() true because isHandwritten(bitmap) is true");
                return true;
            }
            Log.i(TAG, "Step 2. hasText() false because isHandwritten(bitmap) is false");
            return false;
        }
        if (this.mRecognizerProvider.isHandwritten(bitmap)) {
            Log.i(TAG, "Step 1. hasText() true because isHandwritten(bitmap) is true");
            return true;
        }
        Log.i(TAG, "Step 1. hasText() undefined because isHandwritten(bitmap) is false");
        if (this.mRecognizerProvider.isPrinted(bitmap)) {
            Log.i(TAG, "Step 2. hasText() true because isPrinted(bitmap) is true");
            return true;
        }
        Log.i(TAG, "Step 2. hasText() false because isPrinted(bitmap) is false");
        return false;
    }

    @Override // com.samsung.android.sdk.ocr.IRecognizer
    public boolean detectBlock(Bitmap bitmap, Point point, Point[] pointArr) {
        Log.i(TAG, String.format("[detectBlock] Input Image Size: (%d, %d)", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())));
        if (!RecognizerAPIChecker.isValidParameter(bitmap, pointArr)) {
            return false;
        }
        OCRResult oCRResult = new OCRResult();
        long jCurrentTimeMillis = System.currentTimeMillis();
        IOCRecognizer recognizer = this.mRecognizerProvider.getRecognizer(bitmap, oCRResult.getProcessInfo());
        if (recognizer == null) {
            Log.e(TAG, "There is no recognizer created.");
            return false;
        }
        boolean zDetectBlock = recognizer.detectBlock(bitmap, point, pointArr);
        if (!zDetectBlock) {
            Log.w(TAG, "There is no detected block or OCR Processing Fail");
        }
        Log.i(TAG, String.format("OCR processing(detectBlock) Time: %d ms", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)));
        return zDetectBlock;
    }
}
