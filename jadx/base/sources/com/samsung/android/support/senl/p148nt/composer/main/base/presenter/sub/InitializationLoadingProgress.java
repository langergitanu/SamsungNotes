package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class InitializationLoadingProgress {
    private static final int DELAY_MILLIS = 300;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable mShowRunnable;
    private final BaseSubManager mSubManager;

    public InitializationLoadingProgress(BaseSubManager baseSubManager) {
        this.mSubManager = baseSubManager;
    }

    private boolean isNewNote() {
        return this.mSubManager.getComposerLifeState().getActivity().getIntent().getBooleanExtra("new_doc", false);
    }

    public void hide() {
        this.mHandler.removeCallbacks(this.mShowRunnable);
        this.mSubManager.getControllerManager().getProgressController().hideProgress(5, true);
        this.mShowRunnable = null;
    }

    public void release() {
        if (this.mShowRunnable == null) {
            return;
        }
        hide();
    }

    public void show() {
        if (this.mSubManager.getConfig().isInitialLoadingProgressEnabled() && !isNewNote()) {
            Runnable runnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.InitializationLoadingProgress.1
                @Override // java.lang.Runnable
                public void run() {
                    if (InitializationLoadingProgress.this.mSubManager.getComposerLifeState().getFragment().getView() == null) {
                        return;
                    }
                    InitializationLoadingProgress.this.mSubManager.getControllerManager().getProgressController().showProgress(0, 5);
                }
            };
            this.mShowRunnable = runnable;
            this.mHandler.postDelayed(runnable, 300L);
        }
    }
}
