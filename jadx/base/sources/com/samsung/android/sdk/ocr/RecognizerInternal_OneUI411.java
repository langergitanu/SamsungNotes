package com.samsung.android.sdk.ocr;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class RecognizerInternal_OneUI411 extends RecognizerInternal {
    private static final String TAG = "RecognizerInternal_OneUI411";

    public RecognizerInternal_OneUI411(RecognizerParams recognizerParams) {
        super(recognizerParams);
        Log.i(TAG, "OCR Recognizer(Internal_OneUI411) is initialized with version: 3.4.250618");
    }

    @Override // com.samsung.android.sdk.ocr.RecognizerInternal, com.samsung.android.sdk.ocr.IRecognizer
    public void cancel() {
        Log.w(TAG, "Cancel operation is not supported in Recognizer OneUI4.1.1");
    }

    @Override // com.samsung.android.sdk.ocr.RecognizerInternal
    public void createRecognizerProvider(RecognizerParams recognizerParams) {
        closeRecognizerProvider();
        this.mRecognizerProvider = new RecognizerProvider_OneUI411(recognizerParams, this.mRecognizerSupporter);
    }

    @Override // com.samsung.android.sdk.ocr.RecognizerInternal, com.samsung.android.sdk.ocr.IRecognizer
    public boolean recognizeBlockAt(Bitmap bitmap, Point point, boolean z, OCRResult oCRResult) {
        Log.w(TAG, "recognizeBlockAt(...) is not supported in Recognizer OneUI4.11");
        return false;
    }

    public RecognizerInternal_OneUI411(Context context, OCRType oCRType, OCRLanguage oCRLanguage) {
        super(context, oCRType, oCRLanguage);
        Log.i(TAG, "OCR Recognizer(Internal_OneUI411) is initialized with version: 3.4.250618");
    }
}
