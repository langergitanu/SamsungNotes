package com.samsung.android.sdk.pen.ocr;

import android.graphics.Bitmap;
import android.graphics.Point;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface SpenIOcrRecognizer {
    void cancelRequest();

    void close();

    SpenOcrError detect(Bitmap bitmap);

    SpenOcrError detect(Bitmap bitmap, SpenRecogConfig spenRecogConfig, SpenOcrRecognitionListener spenOcrRecognitionListener);

    String getVersion();

    SpenOcrError recognize(Bitmap bitmap, SpenRecogConfig spenRecogConfig, SpenOcrRecognitionListener spenOcrRecognitionListener);

    SpenOcrError recognizeBlockAt(Bitmap bitmap, Point point, boolean z, SpenRecogConfig spenRecogConfig, SpenOcrRecognitionListener spenOcrRecognitionListener);

    SpenOcrError recognize_line(Bitmap bitmap, SpenRecogConfig spenRecogConfig, SpenOcrLineData spenOcrLineData);

    void setConfiguration(String str, String str2);

    void setConfiguration(String[] strArr, String[] strArr2);
}
