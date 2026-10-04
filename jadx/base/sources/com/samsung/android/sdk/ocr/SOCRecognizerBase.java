package com.samsung.android.sdk.ocr;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Build;
import android.os.SemSystemProperties;
import android.text.TextUtils;
import android.util.Log;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.ocr.OCRResult;
import com.samsung.android.sdk.pen.ocr.SpenIOcrEngine;
import com.samsung.android.sdk.pen.ocr.SpenIOcrRecognizer;
import com.samsung.android.sdk.pen.ocr.SpenMoireDetector;
import com.samsung.android.sdk.pen.ocr.SpenOcrBlockData;
import com.samsung.android.sdk.pen.ocr.SpenOcrError;
import com.samsung.android.sdk.pen.ocr.SpenOcrLanguage;
import com.samsung.android.sdk.pen.ocr.SpenOcrLineData;
import com.samsung.android.sdk.pen.ocr.SpenOcrPageData;
import com.samsung.android.sdk.pen.ocr.SpenOcrRecognitionListener;
import com.samsung.android.sdk.pen.ocr.SpenRecogConfig;
import java.util.Iterator;
import java.util.Locale;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SOCRecognizerBase extends SpenOcrRecognitionListener implements IOCRecognizer {
    private static final String TAG = "SOCRecognizerBase";
    protected String mLanguageString;
    protected SpenIOcrRecognizer mRecognizer;
    private boolean mbEnableMoireDetector;
    protected SpenOcrPageData mOcrPageData = null;
    protected SpenMoireDetector mMoireDetector = null;

    public SOCRecognizerBase(SpenIOcrEngine spenIOcrEngine, RecognizerParams recognizerParams) {
        this.mRecognizer = null;
        this.mLanguageString = "";
        this.mLanguageString = SpenOcrLanguage.from(recognizerParams.language).toLanguageCode();
        long jCurrentTimeMillis = System.currentTimeMillis();
        spenIOcrEngine.loadLanguageDB(this.mLanguageString);
        Log.i(TAG, String.format("Time of Loading DB: %d ms", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)));
        this.mRecognizer = spenIOcrEngine.createRecognizer();
        this.mbEnableMoireDetector = Build.VERSION.SDK_INT < 35;
        AbstractC0000a.m27x(new StringBuilder("Support Moire in HWOCR? "), this.mbEnableMoireDetector, TAG);
        if (this.mbEnableMoireDetector) {
            createMoireDetector(recognizerParams.context, spenIOcrEngine);
        }
        Log.i(TAG, "SpenRecognizer(SOCRecognizerBase) is created!");
    }

    private int getOneUIVersion() {
        try {
            String str = SemSystemProperties.get("ro.build.version.oneui");
            if (TextUtils.isEmpty(str)) {
                Log.w(TAG, "Cannot get One UI version!");
                return 0;
            }
            Log.i(TAG, "OneUI = " + str);
            if (str.matches("[0-9]+")) {
                return Integer.parseInt(str);
            }
            return 0;
        } catch (NumberFormatException e) {
            Log.e(TAG, "Cannot get OneUI : " + e.getMessage());
            return 0;
        }
    }

    public void cancel() {
        Log.w(TAG, "Cancel operation is not supported on SOCR Base");
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenOcrRecognitionListener
    public void close() {
        SpenIOcrRecognizer spenIOcrRecognizer = this.mRecognizer;
        if (spenIOcrRecognizer != null) {
            spenIOcrRecognizer.close();
            this.mRecognizer = null;
        }
        super.close();
    }

    public void createMoireDetector(Context context, SpenIOcrEngine spenIOcrEngine) {
        this.mMoireDetector = new SpenMoireDetector(context, spenIOcrEngine);
        Log.i(TAG, "mMoireDetector is created!");
    }

    public void destroy() {
        if (this.mbEnableMoireDetector) {
            destroyMoireDetector();
        }
        close();
        Log.i(TAG, "SOCRecognizerBase destroyed");
    }

    public void destroyMoireDetector() {
        this.mMoireDetector.close();
        this.mMoireDetector = null;
        Log.i(TAG, "mMoireDetector is destroyed!");
    }

    public boolean detect(Bitmap bitmap, OCRResult oCRResult) {
        return detectBase(bitmap, oCRResult);
    }

    public boolean detectBase(Bitmap bitmap, OCRResult oCRResult) {
        SpenOcrError spenOcrErrorDetect = this.mRecognizer.detect(bitmap, new SpenRecogConfig("common"), this);
        if (spenOcrErrorDetect != SpenOcrError.OE_Success) {
            Log.e(TAG, "SpenRecognizer::detect() Failed! ErrorCode : " + spenOcrErrorDetect.toString());
            return false;
        }
        boolean z = this.mOcrPageData.getTextBlockList().size() <= 0;
        oCRResult.getProcessInfo().setHasText(z);
        if (z) {
            Log.w(TAG, "SpenRecognizer::detect() Failed! There is no detected text block");
            return false;
        }
        SOCRConverter.convertPage(this.mOcrPageData, oCRResult);
        return true;
    }

    @Override // com.samsung.android.sdk.ocr.IOCRecognizer
    public boolean detectBlock(Bitmap bitmap, Point[] pointArr) {
        return detectBlock(bitmap, new Point(bitmap.getWidth() / 2, bitmap.getHeight() / 2), pointArr);
    }

    public void detectMoire(Bitmap bitmap) {
        if (this.mbEnableMoireDetector && this.mMoireDetector.detectMoire(bitmap)) {
            this.mRecognizer.setConfiguration(SpenRecogConfig.OCR_RECOGNIZER_CONFIGURATION_KEY_DEMOIRE, "true");
        } else {
            this.mRecognizer.setConfiguration(SpenRecogConfig.OCR_RECOGNIZER_CONFIGURATION_KEY_DEMOIRE, "false");
        }
    }

    @Override // com.samsung.android.sdk.ocr.IOCRecognizer
    public boolean detectText(Bitmap bitmap) {
        Log.w(TAG, "detectText(bitmap) is true in case of being called when isHandwritten() is true. ");
        return true;
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenOcrRecognitionListener
    public void finalize() throws Throwable {
        super.finalize();
        close();
    }

    @Override // com.samsung.android.sdk.ocr.IOCRecognizer
    public String getVersion() {
        String version = this.mRecognizer.getVersion();
        AbstractC6670b.m4756q("Version(SOCR) = ", version, TAG);
        return version;
    }

    @Override // com.samsung.android.sdk.ocr.IOCRecognizer
    public boolean hasText(Bitmap bitmap) {
        SpenOcrError spenOcrErrorDetect = this.mRecognizer.detect(bitmap);
        if (spenOcrErrorDetect == SpenOcrError.OE_Success) {
            return true;
        }
        Log.e(TAG, "SpenRecognizer::detect() Failed! ErrorCode : " + spenOcrErrorDetect.toString());
        return false;
    }

    public boolean isValidDetectedBlockPoints(Point[] pointArr, Point[] pointArr2) {
        if (pointArr == null) {
            Log.e(TAG, "Result buffer has not been allocated in advance.");
            return false;
        }
        if (pointArr2 == null) {
            Log.e(TAG, "Detected Result is null");
            return false;
        }
        if (pointArr.length == pointArr2.length) {
            return true;
        }
        Log.w(TAG, "Size of output corner points is different.");
        Log.w(TAG, String.format("- #outputCornerPoints=%d, #detectedPoints=%d", Integer.valueOf(pointArr.length), Integer.valueOf(pointArr2.length)));
        if (pointArr.length < pointArr2.length) {
            Log.w(TAG, String.format("- #Points(%d) of detected block is much more than required points", Integer.valueOf(pointArr2.length)));
            return true;
        }
        Log.e(TAG, String.format("- #Points(%d) of detected block is not enough.", Integer.valueOf(pointArr2.length)));
        return false;
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenOcrRecognitionListener
    public void onPageRecognitionCompleted(SpenOcrPageData spenOcrPageData) {
        if (spenOcrPageData == null) {
            Log.e(TAG, "onPageRecognitionCompleted() Failed! pageData == null");
        } else {
            Log.d(TAG, "onPageRecognitionCompleted() callback");
            this.mOcrPageData = spenOcrPageData;
        }
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenOcrRecognitionListener
    public void onPageRecognitionStarted() {
        Log.i(TAG, "onPageRecognitionStarted() callback");
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenOcrRecognitionListener
    public void onTextBlockDetected(SpenOcrBlockData spenOcrBlockData) {
        if (spenOcrBlockData == null) {
            Log.e(TAG, "onTextBlockDetected() Failed! textBlock == null");
            return;
        }
        Log.d(TAG, "onTextBlockDetected() textBlock rect : " + spenOcrBlockData.getRectInfo());
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenOcrRecognitionListener
    public void onTextLineDetected(SpenOcrLineData spenOcrLineData) {
        if (spenOcrLineData == null) {
            Log.e(TAG, "onTextLineDetected() Failed! lineData == null");
            return;
        }
        Log.d(TAG, "onTextLineDetected() lineData uid : " + spenOcrLineData.getUID());
    }

    @Override // com.samsung.android.sdk.pen.ocr.SpenOcrRecognitionListener
    public void onTextLineRecognized(SpenOcrLineData spenOcrLineData) {
        if (spenOcrLineData == null) {
            Log.e(TAG, "onTextLineRecognized() Failed! lineData == null");
            return;
        }
        Log.d(TAG, "onTextLineRecognized() lineData uid : " + spenOcrLineData.getUID());
    }

    public boolean recognize(Bitmap bitmap, OCRResult oCRResult) {
        return recognizeBase(bitmap, oCRResult);
    }

    public boolean recognizeBase(Bitmap bitmap, OCRResult oCRResult) {
        int oneUIVersion = getOneUIVersion();
        if (oneUIVersion >= 60100) {
            String string = Locale.getDefault().toString();
            AbstractC6670b.m4756q("Set system language : ", string, TAG);
            this.mRecognizer.setConfiguration(SpenRecogConfig.OCR_RECOGNIZER_CONFIGURATION_KEY_SYSTEM_LANGUAGE, string);
        }
        if (oneUIVersion >= 70000) {
            Log.i(TAG, "Set memory optimization : ALLOW_MEMORY_OPT[True], ALLOW_PREFETCH_MODEL_OPT[FALSE]");
            this.mRecognizer.setConfiguration(SpenRecogConfig.OCR_RECOGNIZER_CONFIGURATION_KEY_ALLOW_MEMORY_OPTIMIZATION, "true");
            this.mRecognizer.setConfiguration(SpenRecogConfig.f4985x6f9787b2, "false");
        }
        SpenOcrError spenOcrErrorRecognize = this.mRecognizer.recognize(bitmap, new SpenRecogConfig(this.mLanguageString), this);
        if (spenOcrErrorRecognize == SpenOcrError.OE_Success) {
            SOCRConverter.convertPage(this.mOcrPageData, oCRResult);
            return true;
        }
        Log.e(TAG, "SpenRecognizer::recognize() Failed! ErrorCode : " + spenOcrErrorRecognize.toString());
        return false;
    }

    public boolean recognizeBlockAt(Bitmap bitmap, Point point, boolean z, OCRResult oCRResult) {
        Log.w(TAG, "recognizeBlockAt operation is not supported on SOCR Base");
        return false;
    }

    @Override // com.samsung.android.sdk.ocr.IOCRecognizer
    public boolean recognizeDetectedLines(Bitmap bitmap, OCRResult oCRResult) {
        SpenRecogConfig spenRecogConfig = new SpenRecogConfig(this.mLanguageString);
        Iterator<OCRResult.BlockData> it = oCRResult.getBlockDataList().iterator();
        while (it.hasNext()) {
            for (OCRResult.LineData lineData : it.next().getLineDataList()) {
                SpenOcrLineData spenOcrLineData = new SpenOcrLineData();
                float angle = lineData.getAngle();
                Point point = new Point();
                Bitmap rotatedROI = OCRResultUtils.getRotatedROI(bitmap, lineData.getRect(), angle, point);
                lineData.offset(-point.x, -point.y);
                SOCRConverter.convertLine(lineData, spenOcrLineData);
                if (this.mRecognizer.recognize_line(rotatedROI, spenRecogConfig, spenOcrLineData) != SpenOcrError.OE_Success) {
                    return false;
                }
                SOCRConverter.convertLine(spenOcrLineData, lineData);
                lineData.offset(point.x, point.y);
                lineData.rotate(angle, lineData.getCenter());
            }
        }
        return true;
    }

    public boolean recognizeLineAtBase(Bitmap bitmap, Point point, OCRResult oCRResult) {
        SpenOcrError spenOcrErrorRecognize = this.mRecognizer.recognize(bitmap, new SpenRecogConfig(this.mLanguageString), this);
        if (spenOcrErrorRecognize == SpenOcrError.OE_Success) {
            SOCRConverter.convertPage(this.mOcrPageData, oCRResult);
            return true;
        }
        Log.e(TAG, "SpenRecognizer::recognize() Failed! ErrorCode : " + spenOcrErrorRecognize.toString());
        return false;
    }

    @Override // com.samsung.android.sdk.ocr.IOCRecognizer
    public boolean detectBlock(Bitmap bitmap, Point point, Point[] pointArr) {
        SpenOcrError spenOcrErrorDetect = this.mRecognizer.detect(bitmap, new SpenRecogConfig("common"), this);
        if (spenOcrErrorDetect != SpenOcrError.OE_Success) {
            Log.e(TAG, "SpenRecognizer::detect() Failed! ErrorCode : " + spenOcrErrorDetect.toString());
            return false;
        }
        if (point == null) {
            point = OCRResultUtils.getImageCenter(bitmap);
        }
        int iFindNearestTextBlock = this.mOcrPageData.findNearestTextBlock(point);
        if (iFindNearestTextBlock < 0) {
            Log.w(TAG, "Fail to find nearest block");
            return false;
        }
        Point[] rect = this.mOcrPageData.getTextBlockList().get(iFindNearestTextBlock).getRect();
        if (!isValidDetectedBlockPoints(pointArr, rect)) {
            return false;
        }
        int length = pointArr.length;
        int length2 = rect.length;
        for (int i = 0; i < pointArr.length; i++) {
            pointArr[i] = new Point(rect[i]);
        }
        return true;
    }
}
