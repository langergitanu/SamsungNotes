package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.editor.adjust.action;

import android.graphics.Rect;
import android.widget.OverScroller;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.adjust.action.FlingAction;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.adjust.state.ActionStateModel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class FlingPresenter {
    private ActionPresenter mActionPresenter;
    private FlingAction mModel;
    private OverScroller mOverScroller;
    private FlingRunnable mRunnable;
    private ActionStateModel mStateModel;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class FlingRunnable implements Runnable {
        private float mPrevY = 0.0f;
        private float mPrevX = 0.0f;

        public FlingRunnable(int i, int i2, Rect rect) {
            FlingPresenter.this.mOverScroller.fling(0, 0, i, i2, rect.left, rect.right, rect.top, rect.bottom);
        }

        public void cancelFling() {
            if (FlingPresenter.this.mOverScroller != null) {
                FlingPresenter.this.mOverScroller.forceFinished(true);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (FlingPresenter.this.mOverScroller == null) {
                return;
            }
            if (!FlingPresenter.this.mOverScroller.computeScrollOffset()) {
                FlingPresenter.this.onFlingFinished();
                return;
            }
            float currX = FlingPresenter.this.mOverScroller.getCurrX();
            float currY = FlingPresenter.this.mOverScroller.getCurrY();
            FlingPresenter.this.onFlingScrolled(currX, currY, this.mPrevX, this.mPrevY);
            this.mPrevX = currX;
            this.mPrevY = currY;
        }
    }

    public FlingPresenter(FlingAction flingAction, ActionStateModel actionStateModel, ActionPresenter actionPresenter) {
        this.mModel = flingAction;
        this.mStateModel = actionStateModel;
        this.mActionPresenter = actionPresenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFlingFinished() {
        if (this.mStateModel.isState(3)) {
            this.mStateModel.setState(0);
        }
        this.mActionPresenter.updateImageView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFlingScrolled(float f, float f4, float f5, float f6) {
        this.mModel.onFling(f, f4, f5, f6);
        this.mActionPresenter.updateImageView();
        this.mActionPresenter.postOnAnimation(this.mRunnable);
    }

    public void cancelFling() {
        FlingRunnable flingRunnable = this.mRunnable;
        if (flingRunnable != null) {
            flingRunnable.cancelFling();
        }
    }

    public void close() {
        cancelFling();
        this.mStateModel.setState(0);
        this.mStateModel = null;
        this.mRunnable = null;
        this.mOverScroller = null;
        this.mModel = null;
        this.mActionPresenter = null;
    }

    public void onFling(float f, float f4) {
        cancelFling();
        this.mStateModel.setState(3);
        FlingRunnable flingRunnable = new FlingRunnable((int) f, (int) f4, this.mModel.getFlingArea());
        this.mRunnable = flingRunnable;
        this.mActionPresenter.postOnAnimation(flingRunnable);
    }

    public void setOverScroller(OverScroller overScroller) {
        this.mOverScroller = overScroller;
    }
}
