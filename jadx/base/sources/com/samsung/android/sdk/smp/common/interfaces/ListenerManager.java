package com.samsung.android.sdk.smp.common.interfaces;

import com.samsung.android.sdk.smp.SmpListeners;
import com.samsung.android.sdk.smp.common.util.SmpLog;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ListenerManager {
    private static final String TAG = "ListenerManager";
    private static ListenerManager sListenerManager;
    private SmpListeners.SmpInitResultListener mSmpInitResultListener;
    private SmpListeners.SmpPushResultListener mSmpPushResultListener;

    public static synchronized ListenerManager getInstance() {
        try {
            if (sListenerManager == null) {
                sListenerManager = new ListenerManager();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sListenerManager;
    }

    private void releaseListenerManagerIfNotNecessary() {
        if (this.mSmpPushResultListener == null && this.mSmpInitResultListener == null) {
            SmpLog.m6498i(TAG, "release listener manager");
            sListenerManager = null;
        }
    }

    public synchronized void removeSmpInitResultListener() {
        this.mSmpInitResultListener = null;
        releaseListenerManagerIfNotNecessary();
    }

    public synchronized void removeSmpPushResultListener() {
        this.mSmpPushResultListener = null;
        releaseListenerManagerIfNotNecessary();
    }

    public synchronized void sendInitResultFail(String str, String str2) {
        if (this.mSmpInitResultListener == null) {
            return;
        }
        String str3 = TAG;
        SmpLog.m6497hi(str3, "SEND LISTENER START : SMP_INIT_RESULT_FAIL");
        this.mSmpInitResultListener.onFail(str, str2);
        SmpLog.m6497hi(str3, "SEND LISTENER END : SMP_INIT_RESULT_FAIL");
    }

    public synchronized void sendInitResultSuccess() {
        if (this.mSmpInitResultListener == null) {
            return;
        }
        String str = TAG;
        SmpLog.m6497hi(str, "SEND LISTENER START : SMP_INIT_RESULT_SUCCESS");
        this.mSmpInitResultListener.onSuccess();
        SmpLog.m6497hi(str, "SEND LISTENER END : SMP_INIT_RESULT_SUCCESS");
    }

    public synchronized void sendPushResultFail(String str, String str2, String str3) {
        if (this.mSmpPushResultListener == null) {
            return;
        }
        String str4 = TAG;
        SmpLog.m6497hi(str4, "SEND LISTENER START : PUSH_REGISTRATION_RESULT_FAIL");
        this.mSmpPushResultListener.onFail(str, str2, str3);
        SmpLog.m6497hi(str4, "SEND LISTENER END : PUSH_REGISTRATION_RESULT_FAIL");
    }

    public synchronized void sendPushResultSuccess(String str, String str2) {
        if (this.mSmpPushResultListener == null) {
            return;
        }
        String str3 = TAG;
        SmpLog.m6497hi(str3, "SEND LISTENER START : PUSH_REGISTRATION_RESULT_SUCCESS");
        this.mSmpPushResultListener.onSuccess(str, str2);
        SmpLog.m6497hi(str3, "SEND LISTENER END : PUSH_REGISTRATION_RESULT_SUCCESS");
    }

    public synchronized void setSmpInitResultListener(SmpListeners.SmpInitResultListener smpInitResultListener) {
        this.mSmpInitResultListener = smpInitResultListener;
    }

    public synchronized void setSmpPushResultListener(SmpListeners.SmpPushResultListener smpPushResultListener) {
        this.mSmpPushResultListener = smpPushResultListener;
    }
}
