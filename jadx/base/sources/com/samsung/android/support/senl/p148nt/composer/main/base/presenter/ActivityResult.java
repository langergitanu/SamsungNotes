package com.samsung.android.support.senl.p148nt.composer.main.base.presenter;

import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ActivityResult {
    private Intent mData;
    private int mRequestCode;
    private int mResultCode;

    public ActivityResult(int i, int i2, Intent intent) {
        this.mRequestCode = i;
        this.mResultCode = i2;
        this.mData = intent;
    }

    public Intent getData() {
        return this.mData;
    }

    public int getRequestCode() {
        return this.mRequestCode;
    }

    public int getResultCode() {
        return this.mResultCode;
    }
}
