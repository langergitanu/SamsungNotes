package com.samsung.android.sdk.pen.ocr;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public enum SpenOcrError {
    OE_Success(0),
    OE_BlockAnalyzerNotLoaded(1),
    OE_DBNotLoaded(2),
    OE_UnknownImageFormat(3),
    OE_UknownOrientation(4),
    OE_RecogError(5),
    OE_DetectError(6);

    private final int value;

    SpenOcrError(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
