package com.samsung.android.sdk.scs.p142ai.suggestion;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AppCategoryResult {
    private int mCategoryId;
    private String mCategoryString;
    private String mPackageName;

    private AppCategoryResult() {
    }

    public static AppCategoryResult create() {
        return new AppCategoryResult();
    }

    public int getCategoryId() {
        return this.mCategoryId;
    }

    public String getCategoryString() {
        return this.mCategoryString;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public void setCategoryId(int i) {
        this.mCategoryId = i;
    }

    public void setCategoryString(String str) {
        this.mCategoryString = str;
    }

    public void setPackageName(String str) {
        this.mPackageName = str;
    }
}
