package com.samsung.android.app.notes.sync.saccount;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public enum AccountSamsungType {
    LOCAL("LOCAL"),
    WEB("WEB");

    private String mType;

    AccountSamsungType(String str) {
        this.mType = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.mType;
    }
}
