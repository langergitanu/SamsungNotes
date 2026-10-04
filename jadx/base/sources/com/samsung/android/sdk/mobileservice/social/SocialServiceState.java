package com.samsung.android.sdk.mobileservice.social;

import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SocialServiceState {
    public static final int SERVICE_END = 5;
    public static final int SERVICE_NORMAL = 1;
    public static final int SERVICE_NOTICE = 2;
    public static final int SERVICE_PAUSE = 4;
    public static final int SERVICE_REAGREE = 3;
    private Intent mIntent;
    private int mState;

    public SocialServiceState(int i) {
        this.mIntent = null;
        this.mState = i;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public int getState() {
        return this.mState;
    }

    public SocialServiceState(int i, Intent intent) {
        this.mState = i;
        this.mIntent = intent;
    }
}
