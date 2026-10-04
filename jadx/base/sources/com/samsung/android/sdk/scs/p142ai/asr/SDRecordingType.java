package com.samsung.android.sdk.scs.p142ai.asr;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public enum SDRecordingType {
    TYPE_NORMAL(0),
    TYPE_CALL(1);

    private final int type;

    SDRecordingType(int i) {
        this.type = i;
    }

    public int getTypeInt() {
        return this.type;
    }
}
