package com.samsung.android.sdk.pen.ocr;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class SpenDBConfig {
    private SpenDBType mDbType;
    private String mLanguage;

    public SpenDBConfig(SpenDBType spenDBType, String str) {
        SpenDBType spenDBType2 = SpenDBType.OCR;
        this.mDbType = spenDBType;
        this.mLanguage = str;
    }

    public SpenDBType getDBType() {
        return this.mDbType;
    }

    public final String getDBTypeName() {
        return this.mDbType.name();
    }

    public String getLanguage() {
        return this.mLanguage;
    }

    public void setDBType(SpenDBType spenDBType) {
        this.mDbType = spenDBType;
    }

    public void setLanguage(String str) {
        this.mLanguage = str;
    }
}
