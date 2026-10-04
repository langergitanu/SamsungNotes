package com.samsung.android.sdk.ocr;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public enum OCRLanguage {
    AUTO,
    ENGLISH,
    FRENCH,
    GERMAN,
    ITALIAN,
    SPANISH,
    KOREAN,
    PORTUGUESE,
    CHINESE;

    public static OCRLanguage fromString(String str) {
        try {
            return valueOf(str);
        } catch (Exception unused) {
            return ENGLISH;
        }
    }
}
