package com.samsung.android.support.senl.ntnl.base;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class NtnlDebugger {
    private static final int GC_CALL_DURATION_MS = 100;
    private static final int GC_CALL_TIMES = 3;
    private static final int LEAK_CHECK_DELAY_MS = 1000;
    private static final String TAG = "NtnlDebugger";
    private static NtnlDebugger sInstance;

    private NtnlDebugger() {
    }

    private native boolean NtnlDebugger_isEnabledLeakDebug();

    private native void NtnlDebugger_printCurrentInstancesInfo();

    public static NtnlDebugger getInstance() {
        if (sInstance == null) {
            sInstance = new NtnlDebugger();
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$printCurrentInstancesInfo$0() {
        for (int i = 0; i < 3; i++) {
            System.gc();
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                NtnlLogger.m12807e(TAG, "Error GC sleep : " + e.getMessage());
            }
        }
        NtnlDebugger_printCurrentInstancesInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void printCurrentInstancesInfo() {
        new Thread(new RunnableC11568a(this, 0)).start();
    }

    public void checkLeakState() {
        if (NtnlDebugger_isEnabledLeakDebug()) {
            new Handler(Looper.getMainLooper()).postDelayed(new RunnableC11568a(this, 1), 1000L);
        }
    }
}
