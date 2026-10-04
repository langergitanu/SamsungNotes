package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import android.app.Activity;
import android.graphics.RectF;
import com.samsung.android.sdk.pen.recoguifeature.alignment.SPenAlignmentListener;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ProgressController;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SpenAlignmentListenerImpl extends SPenAlignmentListener {
    private static final String TAG = Logger.createTag("SpenAlignmentListenerImpl");
    private final Activity mActivity;
    private final ListenerImplContract.IPresenter mPresenter;
    private final ProgressHandler mProgressHandler;
    private Runnable mRunnableToUpdate = null;

    public SpenAlignmentListenerImpl(ListenerImplContract.IPresenter iPresenter, ProgressController progressController) {
        this.mActivity = iPresenter.getActivity();
        this.mPresenter = iPresenter;
        this.mProgressHandler = new ProgressHandler(progressController);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRunningStateForCoEdit(boolean z) {
        if (this.mPresenter.getComposerModel().getCoeditAdapter().isCoeditNote()) {
            if (z) {
                this.mPresenter.pauseCoEdit(TAG, new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.SpenAlignmentListenerImpl.6
                    @Override // java.lang.Runnable
                    public void run() {
                        SpenAlignmentListenerImpl.this.mPresenter.clearWritingToolControl();
                    }
                });
            } else {
                this.mPresenter.resumeCoEdit(TAG);
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.SPenAlignmentListener
    public void onAlignmentFailed() {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.SpenAlignmentListenerImpl.3
            @Override // java.lang.Runnable
            public void run() {
                ToastHandler.show(SpenAlignmentListenerImpl.this.mActivity, C9086R.string.composer_unable_to_extract_text, 1);
            }
        });
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.SPenAlignmentListener
    public void onAlignmentRunning(final boolean z) {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.SpenAlignmentListenerImpl.4
            @Override // java.lang.Runnable
            public void run() {
                SpenAlignmentListenerImpl.this.mPresenter.onAlignmentRunning(z);
                SpenAlignmentListenerImpl.this.setRunningStateForCoEdit(z);
            }
        });
        if (z) {
            ComposerSA.insertLog("413", HWToolbarSAConstants.EVENT_STRAIGHTEN_VIEW_OF_STRAIGHTEN_RESULT);
        }
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.SPenAlignmentListener
    public void onProgressStart() {
        Logger.m10999d(TAG, "onProgressStart");
        this.mProgressHandler.onProgressStart();
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.SpenAlignmentListenerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                if (SpenAlignmentListenerImpl.this.mPresenter == null) {
                    return;
                }
                SpenAlignmentListenerImpl.this.mPresenter.onAlignmentProgress(true);
            }
        });
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.SPenAlignmentListener
    public void onProgressStop() {
        Logger.m10999d(TAG, "onProgressStop");
        this.mProgressHandler.onProgressStop();
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.SpenAlignmentListenerImpl.2
            @Override // java.lang.Runnable
            public void run() {
                if (SpenAlignmentListenerImpl.this.mPresenter == null) {
                    return;
                }
                SpenAlignmentListenerImpl.this.mPresenter.onAlignmentProgress(false);
            }
        });
    }

    @Override // com.samsung.android.sdk.pen.recoguifeature.alignment.SPenAlignmentListener
    public void onUpdateResult(final ArrayList<RectF> arrayList) {
        if (this.mRunnableToUpdate != null) {
            this.mPresenter.getHandler().removeCallbacks(this.mRunnableToUpdate);
        }
        this.mRunnableToUpdate = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.SpenAlignmentListenerImpl.5
            @Override // java.lang.Runnable
            public void run() {
                SpenAlignmentListenerImpl.this.mRunnableToUpdate = null;
                if (SpenAlignmentListenerImpl.this.mPresenter != null) {
                    SpenAlignmentListenerImpl.this.mPresenter.onAlignmentUpdateResult(arrayList);
                }
            }
        };
        this.mPresenter.getHandler().postDelayed(this.mRunnableToUpdate, 100L);
    }

    public void release() {
        this.mProgressHandler.release();
    }
}
