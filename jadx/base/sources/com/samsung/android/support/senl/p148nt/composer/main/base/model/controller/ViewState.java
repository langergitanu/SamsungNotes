package com.samsung.android.support.senl.p148nt.composer.main.base.model.controller;

import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ViewState {
    private int mState = NONE;
    private static final String TAG = Logger.createTag("ViewState");
    public static int NONE = 0;
    public static int RESUME = 1;
    public static int START = 2;
    public static int PAUSE = 3;
    public static int STOP = 4;

    public int getState() {
        return this.mState;
    }

    public boolean isResumed() {
        return this.mState == RESUME;
    }

    public boolean isStopped() {
        return this.mState == STOP;
    }

    public void onPause() {
        this.mState = PAUSE;
    }

    public void onResume() {
        this.mState = RESUME;
    }

    public void onStart() {
        this.mState = START;
    }

    public void onStop() {
        this.mState = STOP;
    }
}
