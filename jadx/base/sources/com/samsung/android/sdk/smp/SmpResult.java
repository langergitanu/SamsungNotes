package com.samsung.android.sdk.smp;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SmpResult {
    private Bundle resultData;
    private boolean success;

    public SmpResult(boolean z, Bundle bundle) {
        this.success = z;
        this.resultData = bundle == null ? new Bundle() : bundle;
    }

    public Bundle getResultData() {
        return this.resultData;
    }

    public boolean isSuccess() {
        return this.success;
    }
}
