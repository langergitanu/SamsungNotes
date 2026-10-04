package com.samsung.android.app.notes.sync.push.base;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public enum PushType {
    SMP_FCM("SMP_FCM"),
    SMP_SPP("SMP_SPP");

    private String mType;

    PushType(String str) {
        this.mType = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.mType;
    }
}
