package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import android.view.MotionEvent;
import android.view.View;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.handoff.HandoffHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.QuickSaveTimerController;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DefaultPreTouchListenerImpl implements SpenPreTouchListenerImpl.PreTouchListener {
    private static final String TAG = Logger.createTag("DefaultPreTouchListenerImpl");
    private final ComposerModel mComposerModel;
    private HandoffHandler mHandoffHandler;
    private MotionEvent mLastTouchedMotionEvent;
    private QuickSaveTimerController mQuickSaveTimerController;
    private boolean mPendingHandoffMsg = false;
    private boolean mIsBlockedTouch = false;

    public DefaultPreTouchListenerImpl(ComposerModel composerModel, HandoffHandler handoffHandler, QuickSaveTimerController quickSaveTimerController) {
        this.mComposerModel = composerModel;
        this.mHandoffHandler = handoffHandler;
        this.mQuickSaveTimerController = quickSaveTimerController;
    }

    private void notifyHandoffHandler(boolean z) {
        HandoffHandler handoffHandler = this.mHandoffHandler;
        if (handoffHandler == null || handoffHandler.isDisabled() || !this.mComposerModel.getModeManager().isMode(Mode.Writing)) {
            return;
        }
        if (z) {
            this.mPendingHandoffMsg = this.mHandoffHandler.hasMessages(1);
            this.mHandoffHandler.removeMessages(1);
        } else {
            if (this.mPendingHandoffMsg && !this.mHandoffHandler.hasMessages(1)) {
                this.mHandoffHandler.sendHandoffDataMsg(1000);
            }
            this.mPendingHandoffMsg = false;
        }
    }

    private void notifyQuickSaveTimer(boolean z) {
        QuickSaveTimerController quickSaveTimerController = this.mQuickSaveTimerController;
        if (quickSaveTimerController == null) {
            return;
        }
        if (z) {
            quickSaveTimerController.lock("hwTouchDown");
        } else {
            quickSaveTimerController.unLock("hwTouchUpCancel");
        }
    }

    public MotionEvent getLastTouchedMotionEvent() {
        return this.mLastTouchedMotionEvent;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl.PreTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mIsBlockedTouch) {
            Logger.m11004w(TAG, "DefaultPreTouchListenerImpl# is blockedTouch");
            return true;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 || actionMasked == 211) {
            notifyQuickSaveTimer(true);
            notifyHandoffHandler(true);
        } else if (actionMasked == 1 || actionMasked == 212 || actionMasked == 3 || actionMasked == 214) {
            notifyQuickSaveTimer(false);
            notifyHandoffHandler(false);
        }
        this.mLastTouchedMotionEvent = motionEvent;
        return false;
    }

    public void release() {
        this.mHandoffHandler = null;
        this.mQuickSaveTimerController = null;
    }

    public void setBlockDefaultPreTouch(boolean z) {
        this.mIsBlockedTouch = z;
    }
}
