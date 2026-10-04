package com.samsung.android.sdk.ocr;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.samsung.android.sdk.ocr.RecognizerInternal;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class RecognizerInternal_Testing extends RecognizerInternal {
    private static final String TAG = "RecognizerOnTesting";

    public RecognizerInternal_Testing(RecognizerParams recognizerParams) {
        super(recognizerParams);
    }

    public boolean recognizeDetectedLines(Bitmap bitmap, OCRResult oCRResult) {
        return process(bitmap, new RecognizerInternal.ocr_processor() { // from class: com.samsung.android.sdk.ocr.RecognizerInternal_Testing.1
            @Override // com.samsung.android.sdk.ocr.RecognizerInternal.ocr_processor
            public boolean process(IOCRecognizer iOCRecognizer, Bitmap bitmap2, OCRResult oCRResult2) {
                Log.i(RecognizerInternal_Testing.TAG, "OCR Text Recognizing Detected Lines....");
                return iOCRecognizer.recognizeDetectedLines(bitmap2, oCRResult2);
            }
        }, oCRResult);
    }

    public RecognizerInternal_Testing(Context context, OCRType oCRType, OCRLanguage oCRLanguage) {
        super(context, oCRType, oCRLanguage);
    }
}
