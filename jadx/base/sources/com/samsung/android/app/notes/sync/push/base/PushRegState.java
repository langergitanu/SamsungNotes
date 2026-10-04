package com.samsung.android.app.notes.sync.push.base;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public enum PushRegState {
    NOT_REGISTERED("NOT_REGISTERED"),
    REGISTERING("REGISTERING"),
    REGISTERED("REGISTERED");

    private String mState;

    PushRegState(String str) {
        this.mState = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.mState;
    }
}
