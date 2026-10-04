package com.samsung.android.sdk.ocr;

import android.content.Context;
import android.util.Log;
import com.samsung.android.sdk.ocr.OCRException;
import com.samsung.android.sdk.pen.ocr.SpenOcrEngine;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class RecognizerSupporter {
    private static final String TAG = "RecognizerSupporter";
    public boolean isMOCRSupported;
    public boolean isSOCRSupported;

    public RecognizerSupporter(Context context) {
        this.isMOCRSupported = false;
        this.isSOCRSupported = false;
        this.isMOCRSupported = MOCRecognizer.isSupported();
        this.isSOCRSupported = SpenOcrEngine.isSupported(context);
    }

    public static boolean isSupported(Context context, OCRType oCRType) {
        if (OCRType.OCR_ALL == oCRType) {
            return MOCRecognizer.isSupported() && SpenOcrEngine.isSupported(context);
        }
        if (OCRType.OCR_PRINTED == oCRType) {
            return MOCRecognizer.isSupported();
        }
        if (OCRType.OCR_HANDWRITTEN == oCRType) {
            return SpenOcrEngine.isSupported(context);
        }
        Log.e(TAG, "Undefined OCR Type : " + oCRType);
        return false;
    }

    public void checkRecognizerSupportedType(OCRType oCRType) {
        boolean z = this.isMOCRSupported;
        if (!z && !this.isSOCRSupported) {
            throw new OCRException.UnsupportedRecognizerException("OCR Recognizer is not supported");
        }
        if (!z && (oCRType == OCRType.OCR_PRINTED || oCRType == OCRType.OCR_ALL)) {
            throw new OCRException.UnsupportedRecognizerException("OCR Recognizer is not supported MOCR Type");
        }
        if (this.isSOCRSupported) {
            return;
        }
        if (oCRType == OCRType.OCR_HANDWRITTEN || oCRType == OCRType.OCR_ALL) {
            throw new OCRException.UnsupportedRecognizerException("OCR Recognizer is not supported SOCR Type");
        }
    }
}
