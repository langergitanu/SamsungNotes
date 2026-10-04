package com.samsung.android.support.senl.p148nt.coedit.control.common;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ErrorCounter {
    private static final int MAX_COUNT = 3;
    int mCount = 0;
    long mCheckPoint = -1;
    String mErrorMsg = "";

    public boolean isMaxCounted(long j, String str) {
        if (!TextUtils.isEmpty(str) && j > -1) {
            if (this.mCheckPoint == j && str.equals(this.mErrorMsg)) {
                int i = this.mCount + 1;
                this.mCount = i;
                return i >= 3;
            }
            this.mCount = 0;
            this.mCheckPoint = j;
            this.mErrorMsg = str;
        }
        return false;
    }
}
