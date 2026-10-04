package com.samsung.android.sdk.ocr;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.Log;
import com.samsung.android.sdk.pen.ocr.SpenIOcrEngine;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SOCRecognizer_OneUI411 extends SOCRecognizerBase implements IOCRecognizer {
    private static final String TAG = "SOCRecognizer_OneUI411";

    public SOCRecognizer_OneUI411(SpenIOcrEngine spenIOcrEngine, RecognizerParams recognizerParams) {
        super(spenIOcrEngine, recognizerParams);
        Log.i(TAG, "SpenRecognizer(SOCRecognizer_OneUI411) is created");
    }

    @Override // com.samsung.android.sdk.ocr.SOCRecognizerBase, com.samsung.android.sdk.ocr.IOCRecognizer
    public boolean recognizeBlockAt(Bitmap bitmap, Point point, boolean z, OCRResult oCRResult) {
        Log.i(TAG, "recognizeBlockAt is not supported at OneUI4.1, use recognize() instead!");
        return recognizeBase(bitmap, oCRResult);
    }
}
