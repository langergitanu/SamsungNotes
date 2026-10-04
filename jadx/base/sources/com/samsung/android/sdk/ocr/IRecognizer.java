package com.samsung.android.sdk.ocr;

import android.graphics.Bitmap;
import android.graphics.Point;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface IRecognizer {
    void cancel();

    void close();

    boolean detect(Bitmap bitmap, OCRResult oCRResult);

    boolean detectBlock(Bitmap bitmap, Point point, Point[] pointArr);

    boolean detectBlock(Bitmap bitmap, Point[] pointArr);

    boolean detectText(Bitmap bitmap);

    boolean hasText(Bitmap bitmap);

    boolean hasText(Bitmap bitmap, boolean z);

    boolean isHandwritten(Bitmap bitmap);

    boolean isPrinted(Bitmap bitmap);

    boolean recognize(Bitmap bitmap, OCRResult oCRResult);

    boolean recognizeBlockAt(Bitmap bitmap, Point point, boolean z, OCRResult oCRResult);
}
