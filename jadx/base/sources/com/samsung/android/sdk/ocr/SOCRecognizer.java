package com.samsung.android.sdk.ocr;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.Log;
import com.samsung.android.sdk.pen.ocr.SpenIOcrEngine;
import com.samsung.android.sdk.pen.ocr.SpenOcrError;
import com.samsung.android.sdk.pen.ocr.SpenRecogConfig;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SOCRecognizer extends SOCRecognizerBase implements IOCRecognizer {
    private static final String TAG = "SOCRecognizer";

    public SOCRecognizer(SpenIOcrEngine spenIOcrEngine, RecognizerParams recognizerParams) {
        super(spenIOcrEngine, recognizerParams);
        Log.i(TAG, "SpenRecognizer(SOCRecognizer) is created");
    }

    @Override // com.samsung.android.sdk.ocr.SOCRecognizerBase, com.samsung.android.sdk.ocr.IOCRecognizer
    public void cancel() {
        this.mRecognizer.cancelRequest();
    }

    @Override // com.samsung.android.sdk.ocr.SOCRecognizerBase, com.samsung.android.sdk.ocr.IOCRecognizer
    public void destroy() {
        super.destroy();
        Log.i(TAG, "SOCRecognizer destroyed");
    }

    @Override // com.samsung.android.sdk.ocr.SOCRecognizerBase, com.samsung.android.sdk.ocr.IOCRecognizer
    public boolean detect(Bitmap bitmap, OCRResult oCRResult) {
        detectMoire(bitmap);
        return detectBase(bitmap, oCRResult);
    }

    @Override // com.samsung.android.sdk.ocr.SOCRecognizerBase, com.samsung.android.sdk.ocr.IOCRecognizer
    public boolean recognize(Bitmap bitmap, OCRResult oCRResult) {
        detectMoire(bitmap);
        return recognizeBase(bitmap, oCRResult);
    }

    @Override // com.samsung.android.sdk.ocr.SOCRecognizerBase, com.samsung.android.sdk.ocr.IOCRecognizer
    public boolean recognizeBlockAt(Bitmap bitmap, Point point, boolean z, OCRResult oCRResult) {
        detectMoire(bitmap);
        SpenOcrError spenOcrErrorRecognizeBlockAt = this.mRecognizer.recognizeBlockAt(bitmap, point, z, new SpenRecogConfig(this.mLanguageString), this);
        if (spenOcrErrorRecognizeBlockAt == SpenOcrError.OE_Success) {
            SOCRConverter.convertPage(this.mOcrPageData, oCRResult);
            return true;
        }
        Log.e(TAG, "SpenRecognizer::recognizeBlockAt() Failed! ErrorCode : " + spenOcrErrorRecognizeBlockAt.toString());
        return false;
    }
}
