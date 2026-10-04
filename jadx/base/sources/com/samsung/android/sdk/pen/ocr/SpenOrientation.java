package com.samsung.android.sdk.pen.ocr;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
enum SpenOrientation {
    Rotation_0(240),
    Rotation_90(241),
    Rotation_180(242),
    Rotation_270(243);

    private final int value;

    SpenOrientation(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
