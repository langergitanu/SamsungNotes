package com.samsung.android.sdk.pen.ocr;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SpenRecogConfig {
    public static final String OCR_RECOGNIZER_CONFIGURATION_KEY_ALLOW_MEMORY_OPTIMIZATION = "allowMemoryOptimization";

    /* JADX INFO: renamed from: OCR_RECOGNIZER_CONFIGURATION_KEY_ALLOW_PREFETCH_MODEL_OPTIMIZATION */
    public static final String f4985x6f9787b2 = "allowPrefetchModelOptimization";
    public static final String OCR_RECOGNIZER_CONFIGURATION_KEY_DEMOIRE = "deMoire";
    public static final String OCR_RECOGNIZER_CONFIGURATION_KEY_SYSTEM_LANGUAGE = "systemLanguage";
    public static final String OCR_RECOGNIZER_CONFIGURATION_VAL_FALSE = "false";
    public static final String OCR_RECOGNIZER_CONFIGURATION_VAL_TRUE = "true";
    private String mLanguage;
    private SpenOrientation mOrientation;

    public SpenRecogConfig() {
        this.mOrientation = SpenOrientation.Rotation_0;
        this.mLanguage = SpenOcrLanguage.ENGLISH.toLanguageCode();
    }

    public String getLanguage() {
        return this.mLanguage;
    }

    public SpenOrientation getOrientation() {
        return this.mOrientation;
    }

    public void setLanguage(String str) {
        this.mLanguage = str;
    }

    public void setOrientation(SpenOrientation spenOrientation) {
        this.mOrientation = spenOrientation;
    }

    public SpenRecogConfig(String str) {
        this.mOrientation = SpenOrientation.Rotation_0;
        this.mLanguage = str;
    }
}
