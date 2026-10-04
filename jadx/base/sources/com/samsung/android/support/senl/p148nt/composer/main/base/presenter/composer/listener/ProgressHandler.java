package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import android.os.Handler;
import android.os.Looper;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ProgressController;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ProgressHandler {
    private Handler mHandler = new Handler();
    private ProgressController mProgressController;

    public ProgressHandler(ProgressController progressController) {
        this.mProgressController = progressController;
    }

    private void runProgress(Runnable runnable) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            this.mHandler.post(runnable);
        } else {
            runnable.run();
        }
    }

    public void onProgressStart() {
        runProgress(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ProgressHandler.1
            @Override // java.lang.Runnable
            public void run() {
                ProgressHandler.this.mProgressController.showProgress(250, 1);
            }
        });
    }

    public void onProgressStop() {
        runProgress(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.ProgressHandler.2
            @Override // java.lang.Runnable
            public void run() {
                ProgressHandler.this.mProgressController.hideProgress(1, true);
            }
        });
    }

    public void release() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
