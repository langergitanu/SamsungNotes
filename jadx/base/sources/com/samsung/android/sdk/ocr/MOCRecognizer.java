package com.samsung.android.sdk.ocr;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.ocr.MOCR;
import com.samsung.android.ocr.MOCROptions;
import com.samsung.android.ocr.MOCRResult;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class MOCRecognizer implements IOCRecognizer {
    private static final String TAG = "MOCRecgonzier";
    private static HashMap<OCRLanguage, Integer> mMapID_MOCR;
    private int mLanguageID;
    private MOCR mocr;

    static {
        HashMap<OCRLanguage, Integer> map = new HashMap<>();
        mMapID_MOCR = map;
        map.put(OCRLanguage.AUTO, 1001);
        mMapID_MOCR.put(OCRLanguage.ENGLISH, 1);
        mMapID_MOCR.put(OCRLanguage.FRENCH, 11);
        mMapID_MOCR.put(OCRLanguage.GERMAN, 13);
        mMapID_MOCR.put(OCRLanguage.ITALIAN, 18);
        mMapID_MOCR.put(OCRLanguage.SPANISH, 26);
        mMapID_MOCR.put(OCRLanguage.KOREAN, 40);
        mMapID_MOCR.put(OCRLanguage.PORTUGUESE, 24);
        mMapID_MOCR.put(OCRLanguage.CHINESE, 60);
    }

    public MOCRecognizer(OCRLanguage oCRLanguage) {
        this.mocr = null;
        this.mLanguageID = getMOCRLanguageID(oCRLanguage);
        MOCR mocr = MOCR.getInstance(new MOCROptions.Builder().setGetCharResult(true).build());
        this.mocr = mocr;
        mocr.initialize(this.mLanguageID);
    }

    private static int getMOCRLanguageID(OCRLanguage oCRLanguage) {
        return mMapID_MOCR.get(oCRLanguage).intValue();
    }

    public static boolean isSupported() {
        if (MOCR.isOCRSupport()) {
            return true;
        }
        Log.e(TAG, "MOCR does not supported!");
        return false;
    }

    public static boolean isSupportedLanguage(OCRLanguage oCRLanguage) {
        return mMapID_MOCR.containsKey(oCRLanguage);
    }

    @Override // com.samsung.android.sdk.ocr.IOCRecognizer
    public void cancel() {
        Log.w(TAG, "Cancel operation is not supported on MOCR");
    }

    @Override // com.samsung.android.sdk.ocr.IOCRecognizer
    public void destroy() {
        this.mocr.deinitialize();
    }

    @Override // com.samsung.android.sdk.ocr.IOCRecognizer
    public boolean detect(Bitmap bitmap, OCRResult oCRResult) {
        Log.i(TAG, "MOCRecognizer::detect_ARGB_bmp() Used to MOCR library");
        MOCRResult.Page page = new MOCRResult.Page();
        int iDetect_ARGB_bmp = this.mocr.detect_ARGB_bmp(bitmap, page);
        boolean z = false;
        if (iDetect_ARGB_bmp != 0) {
            AbstractC0541b.m758D(iDetect_ARGB_bmp, "MOCRecognizer::detect_ARGB_bmp() MOCR(detect_ARGB_bmp) is Failed! ErrorCode : ", TAG);
        } else {
            MOCRResult.Block[] blockArr = page.blocks;
            if (blockArr != null && blockArr.length > 0) {
                z = true;
            }
            if (z) {
                MOCRConverter.convertPage(page, oCRResult);
            } else {
                Log.e(TAG, "MOCRecognizer::detect_ARGB_bmp() MOCR(detect_ARGB_bmp) is Failed! There is no detected text block");
            }
        }
        oCRResult.getProcessInfo().setHasText(z);
        return z;
    }

    @Override // com.samsung.android.sdk.ocr.IOCRecognizer
    public boolean detectBlock(Bitmap bitmap, Point[] pointArr) {
        return detectBlock(bitmap, new Point(bitmap.getWidth() / 2, bitmap.getHeight() / 2), pointArr);
    }

    @Override // com.samsung.android.sdk.ocr.IOCRecognizer
    public boolean detectText(Bitmap bitmap) {
        Log.i(TAG, "MOCRecognizer::detectText_ARGB_bmp() Used to MOCR library");
        return this.mocr.detectText_ARGB_bmp(bitmap);
    }

    @Override // com.samsung.android.sdk.ocr.IOCRecognizer
    public String getVersion() {
        MOCR mocr = this.mocr;
        String version = mocr != null ? mocr.getVersion() : "";
        AbstractC6670b.m4756q("Version(MOCR) = ", version, TAG);
        return version;
    }

    @Override // com.samsung.android.sdk.ocr.IOCRecognizer
    public boolean hasText(Bitmap bitmap) {
        Log.i(TAG, "Deprecated: MOCRecognizer::detectText_ARGB_bmp() Used to MOCR library");
        return this.mocr.detectText_ARGB_bmp(bitmap);
    }

    @Override // com.samsung.android.sdk.ocr.IOCRecognizer
    public boolean recognize(Bitmap bitmap, OCRResult oCRResult) {
        Log.i(TAG, "MOCRecognizer::process_ARGB_bmp() Used to MOCR library");
        Log.i(TAG, "MOCRecognizer::process_ARGB_bmp() ID: " + this.mLanguageID);
        MOCRResult.Page page = new MOCRResult.Page();
        int iProcess_ARGB_bmp = this.mocr.process_ARGB_bmp(bitmap, page);
        if (iProcess_ARGB_bmp == 0) {
            MOCRConverter.convertPage(page, oCRResult);
            return true;
        }
        AbstractC0541b.m758D(iProcess_ARGB_bmp, "MOCRecognizer::recognize() MOCR(process_ARGB_bmp) is Failed! ErrorCode : ", TAG);
        return false;
    }

    @Override // com.samsung.android.sdk.ocr.IOCRecognizer
    public boolean recognizeBlockAt(Bitmap bitmap, Point point, boolean z, OCRResult oCRResult) {
        Log.i(TAG, "MOCRecognizer::recognizeBlock_ARGB() Used to MOCR library");
        return false;
    }

    @Override // com.samsung.android.sdk.ocr.IOCRecognizer
    public boolean recognizeDetectedLines(Bitmap bitmap, OCRResult oCRResult) {
        return recognize(bitmap, oCRResult);
    }

    @Override // com.samsung.android.sdk.ocr.IOCRecognizer
    public boolean detectBlock(Bitmap bitmap, Point point, Point[] pointArr) {
        Log.i(TAG, "Use MOCR::detectBlock_ARGB_bmp");
        return false;
    }
}
