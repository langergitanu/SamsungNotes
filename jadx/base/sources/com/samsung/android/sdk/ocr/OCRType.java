package com.samsung.android.sdk.ocr;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public enum OCRType {
    OCR_ALL(0),
    OCR_PRINTED(1),
    OCR_HANDWRITTEN(2);

    private final int value;

    OCRType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
