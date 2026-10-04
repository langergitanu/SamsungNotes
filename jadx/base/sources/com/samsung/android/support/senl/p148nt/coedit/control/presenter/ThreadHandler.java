package com.samsung.android.support.senl.p148nt.coedit.control.presenter;

import android.os.Handler;
import android.os.Looper;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ThreadHandler {
    private static final int MAX_THREAD_COUNT = 7;
    private static final String TAG = "coedit#ThreadHandler";
    private Handler mUIThreadHandler;
    private final Object mUIThreadLock = new Object();
    private ExecutorService mWorkerExecutor;

    public void initUiThreadHandler() {
        synchronized (this.mUIThreadLock) {
            try {
                if (this.mUIThreadHandler != null) {
                    return;
                }
                this.mUIThreadHandler = new Handler(Looper.getMainLooper());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void releaseUiThreadHandler() {
        synchronized (this.mUIThreadLock) {
            try {
                Handler handler = this.mUIThreadHandler;
                if (handler == null) {
                    return;
                }
                handler.removeCallbacksAndMessages(null);
                this.mUIThreadHandler = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void runOnUIThread(Runnable runnable) {
        synchronized (this.mUIThreadLock) {
            try {
                Handler handler = this.mUIThreadHandler;
                if (handler == null) {
                    return;
                }
                handler.postDelayed(runnable, 0L);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized void runOnWorkerThread(final Runnable runnable, long j) {
        synchronized (this.mUIThreadLock) {
            Handler handler = this.mUIThreadHandler;
            if (handler == null) {
                return;
            }
            handler.postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.control.presenter.ThreadHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    ThreadHandler.this.runOnWorkerThread(runnable);
                }
            }, j);
        }
    }

    public synchronized void runOnWorkerThread(Runnable runnable) {
        try {
            if (this.mWorkerExecutor == null) {
                this.mWorkerExecutor = Executors.newFixedThreadPool(7, new SenlThreadFactory(TAG));
            }
            this.mWorkerExecutor.execute(runnable);
        } catch (Throwable th) {
            throw th;
        }
    }
}
