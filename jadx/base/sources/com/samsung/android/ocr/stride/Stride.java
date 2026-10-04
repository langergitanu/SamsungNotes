package com.samsung.android.ocr.stride;

import android.content.res.Resources;
import android.graphics.Point;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.samsung.android.ocr.MOCR;
import com.samsung.android.ocr.MOCRConstants;
import com.samsung.android.ocr.MOCRImage;
import com.samsung.android.ocr.MOCRLang;
import com.samsung.android.ocr.MOCRLog;
import com.samsung.android.ocr.MOCROptions;
import com.samsung.android.ocr.MOCRResult;
import com.samsung.android.ocr.stride.postocr.PostProcessCorrection;
import com.samsung.android.ocr.stride.postocr.entity.DateCorrection;
import com.samsung.android.ocr.stride.postocr.entity.EmailCorrection;
import com.samsung.android.ocr.stride.postocr.entity.PhoneNumberCorrection;
import com.samsung.android.ocr.stride.postocr.entity.TimeCorrection;
import com.samsung.android.ocr.stride.postocr.entity.URLCorrection;
import com.samsung.android.ocr.stride.postocr.entity.UnitCorrection;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class Stride extends MOCR {
    private static final int NO_LANG = -1;
    private static final String TAG = "Stride";
    private static volatile Stride stride;
    private int lang;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class IconResult {
        public Point[] iconRect;
    }

    private static native synchronized void Close();

    private static native synchronized int Detect(MOCRImage mOCRImage, MOCRResult.Page page);

    private static native synchronized boolean DetectDocument(MOCRImage mOCRImage, long[] jArr);

    public static native synchronized IconResult[] DetectIcon(MOCRImage mOCRImage);

    public static native synchronized int DetectLayout(MOCRImage mOCRImage, MOCRResult.Page page);

    private static native synchronized int DetectScript(MOCRImage mOCRImage);

    private static native synchronized int DetectScriptAll(MOCRImage mOCRImage, MOCRResult.Page page);

    public static native synchronized int DetectTable(MOCRImage mOCRImage, MOCRResult.Page page);

    public static native synchronized int DetectTableCells(MOCRImage mOCRImage, MOCRResult.Page page, boolean z);

    private static native synchronized boolean DetectText(MOCRImage mOCRImage);

    private static native synchronized String GetBuildType();

    private static native synchronized String GetVersion();

    private static native synchronized int Init(String str);

    private static native synchronized int Init(String str, int i);

    public static native synchronized int Orientation(MOCRImage mOCRImage);

    private static native synchronized int Recognize(MOCRImage mOCRImage, MOCRResult.Page page);

    private int Recognize_Java(MOCRImage mOCRImage, MOCRResult.Page page) {
        int iRecognize = Recognize(mOCRImage, page);
        if (iRecognize == MOCRConstants.MOCRStatus.MOCRSuccess.getValue() && getBuildType().equalsIgnoreCase(AuthenticationConstants.Broker.ACCOUNT_DEFAULT_NAME)) {
            MOCRLog.m5683d(TAG, "Entity PostProcess start");
            EmailCorrection.validateEmailLine(page);
            URLCorrection.validateURLLine(page);
            PhoneNumberCorrection.validatePhoneLine(page);
            DateCorrection.validateDateFormat(page);
            TimeCorrection.validateTimeFormat(page);
            UnitCorrection.validateUnits(page);
            try {
                PostProcessCorrection.process(page);
            } catch (IndexOutOfBoundsException e) {
                MOCRLog.m5684e(TAG, "Error in PostProcessCorrection due to bounds");
                e.printStackTrace();
            }
            MOCRLog.m5683d(TAG, "Entity PostProcess end");
        }
        this.lang = page.ocrLang;
        MOCRLog.m5683d(TAG, "OCR Lang is " + this.lang);
        return iRecognize;
    }

    public static native synchronized void SetFileNameForDebug(String str);

    private static native synchronized void SetOptions(MOCROptions mOCROptions);

    public static native synchronized int SrLayoutE2E(MOCRImage mOCRImage, MOCRResult.Page page);

    private int getDeviceLang() {
        return MOCRLang.getLangFromLocale(Resources.getSystem().getConfiguration().getLocales().get(0));
    }

    public static Stride getInstance() {
        if (stride == null) {
            synchronized (Stride.class) {
                try {
                    if (stride == null) {
                        stride = new Stride();
                    }
                } finally {
                }
            }
        }
        return stride;
    }

    @Override // com.samsung.android.ocr.MOCR
    public int cvtToLang(int i) {
        return i;
    }

    @Override // com.samsung.android.ocr.MOCR
    public void deinit() {
        Close();
    }

    @Override // com.samsung.android.ocr.MOCR
    public int detect(byte[] bArr, int i, int i2, MOCRConstants.MOCRPxlFmt mOCRPxlFmt, MOCRResult.Page page) {
        return Detect(MOCRImage.fromByteArray(bArr, i2, i, mOCRPxlFmt.getValue()), page);
    }

    public int detectScript(MOCRImage mOCRImage) {
        return mOCRImage == null ? MOCRConstants.MOCRStatus.MOCRUnsupportedFormat.getValue() : DetectScript(mOCRImage);
    }

    public int detectScriptAll(MOCRImage mOCRImage, MOCRResult.Page page) {
        return mOCRImage == null ? MOCRConstants.MOCRStatus.MOCRUnsupportedFormat.getValue() : DetectScriptAll(mOCRImage, page);
    }

    @Override // com.samsung.android.ocr.MOCR
    public boolean detectText(byte[] bArr, int i, int i2, MOCRConstants.MOCRPxlFmt mOCRPxlFmt) {
        return DetectText(MOCRImage.fromByteArray(bArr, i2, i, mOCRPxlFmt.getValue()));
    }

    @Override // com.samsung.android.ocr.MOCR
    public boolean detectText_ARGB(MOCRImage mOCRImage) {
        if (mOCRImage == null) {
            return false;
        }
        return DetectText(mOCRImage);
    }

    @Override // com.samsung.android.ocr.MOCR
    public int detect_ARGB(MOCRImage mOCRImage, MOCRResult.Page page) {
        return mOCRImage == null ? MOCRConstants.MOCRStatus.MOCRUnsupportedFormat.getValue() : Detect(mOCRImage, page);
    }

    @Override // com.samsung.android.ocr.MOCR
    public String getBuildType() {
        try {
            return GetBuildType();
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return AuthenticationConstants.Broker.ACCOUNT_DEFAULT_NAME;
        }
    }

    @Override // com.samsung.android.ocr.MOCR
    public String getVersion() {
        return GetVersion();
    }

    @Override // com.samsung.android.ocr.MOCR
    public int init(int i) {
        this.lang = i;
        if (i == 1001) {
            this.lang = getDeviceLang();
            MOCRLog.m5685i(TAG, "Auto Device Lang - " + this.lang);
        }
        return Init(null, this.lang);
    }

    public boolean isDocumentImage(MOCRImage mOCRImage, long[] jArr) {
        if (mOCRImage == null) {
            return false;
        }
        return DetectDocument(mOCRImage, jArr);
    }

    @Override // com.samsung.android.ocr.MOCR
    public int run(byte[] bArr, int i, int i2, MOCRConstants.MOCRPxlFmt mOCRPxlFmt, MOCRResult.Page page) {
        return Recognize_Java(MOCRImage.fromByteArray(bArr, i2, i, mOCRPxlFmt.getValue()), page);
    }

    @Override // com.samsung.android.ocr.MOCR
    public int run_ARGB(MOCRImage mOCRImage, MOCRResult.Page page) {
        return mOCRImage == null ? MOCRConstants.MOCRStatus.MOCRUnsupportedFormat.getValue() : Recognize_Java(mOCRImage, page);
    }

    @Override // com.samsung.android.ocr.MOCR
    public void set_options(MOCROptions mOCROptions) {
        SetOptions(mOCROptions);
    }

    @Override // com.samsung.android.ocr.MOCR
    public int init(String str, int i) {
        this.lang = i;
        if (i == 1001) {
            this.lang = getDeviceLang();
            MOCRLog.m5685i(TAG, "Auto Device Lang - " + this.lang);
        }
        return Init(str, this.lang);
    }

    @Override // com.samsung.android.ocr.MOCR
    public int init() {
        this.lang = -1;
        return Init(null);
    }

    @Override // com.samsung.android.ocr.MOCR
    public int init(String str) {
        this.lang = -1;
        return Init(str);
    }
}
