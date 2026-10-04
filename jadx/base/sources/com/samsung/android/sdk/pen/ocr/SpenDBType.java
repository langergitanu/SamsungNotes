package com.samsung.android.sdk.pen.ocr;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public enum SpenDBType {
    OCR(61440),
    BlockAnalyzer(3844),
    MoireDetector(240);

    private final int value;

    SpenDBType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
