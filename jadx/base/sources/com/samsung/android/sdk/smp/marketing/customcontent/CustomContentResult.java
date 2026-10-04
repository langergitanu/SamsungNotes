package com.samsung.android.sdk.smp.marketing.customcontent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class CustomContentResult {
    private final String mData;
    private final String mFeedbackDetail;
    private final boolean mIsSuccess;

    private CustomContentResult(boolean z, String str, String str2) {
        this.mIsSuccess = z;
        this.mData = str;
        this.mFeedbackDetail = str2;
    }

    public static CustomContentResult fail(String str) {
        return new CustomContentResult(false, null, str);
    }

    public static CustomContentResult success(String str) {
        return new CustomContentResult(true, str, null);
    }

    public String getData() {
        return this.mData;
    }

    public String getFeedbackDetail() {
        return this.mFeedbackDetail;
    }

    public boolean isSuccess() {
        return this.mIsSuccess;
    }
}
