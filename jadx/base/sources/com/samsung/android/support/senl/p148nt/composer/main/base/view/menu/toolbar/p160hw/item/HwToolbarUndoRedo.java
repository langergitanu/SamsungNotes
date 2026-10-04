package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item;

import android.view.MotionEvent;
import android.view.View;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class HwToolbarUndoRedo extends HwToolbarItem {
    private static final String TAG = Logger.createTag("HwToolbarUndoRedo");
    protected boolean mIsLongPressed;
    protected boolean mIsUndoRedoValid;
    protected boolean mOnDoingRedoUndo;
    protected HwToolbarPresenterImpl mPresenter;

    public HwToolbarUndoRedo(View view, HwToolbarItemContract hwToolbarItemContract) {
        super(view, hwToolbarItemContract);
        this.mIsUndoRedoValid = false;
        this.mOnDoingRedoUndo = false;
        this.mIsLongPressed = false;
        this.mPresenter = hwToolbarItemContract.getHwToolbarPresenter();
        init();
    }

    private void init() {
        View view = this.mView;
        if (view == null) {
            return;
        }
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.item.HwToolbarUndoRedo.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                Logger.m10999d(HwToolbarUndoRedo.TAG, "onLongClick()");
                if (HwToolbarUndoRedo.this.mPresenter.isDockingMode()) {
                    return false;
                }
                HwToolbarUndoRedo hwToolbarUndoRedo = HwToolbarUndoRedo.this;
                if (!hwToolbarUndoRedo.mIsUndoRedoValid) {
                    return false;
                }
                hwToolbarUndoRedo.mOnDoingRedoUndo = true;
                hwToolbarUndoRedo.mIsLongPressed = true;
                hwToolbarUndoRedo.onUndoRedo();
                return false;
            }
        });
        this.mView.setOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.item.HwToolbarUndoRedo.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    HwToolbarUndoRedo.this.mIsLongPressed = false;
                }
                return false;
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void clearControl() {
        this.mHwToolbarItemManager.clearContextMenu();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItem
    public void onClick() {
        String str = TAG;
        Logger.m10999d(str, "onClick()");
        if (!this.mPresenter.isIdleWorkingState()) {
            Logger.m10999d(str, "Not IdleWorkingState");
        } else {
            this.mHwSettingViewManager.hide();
            onUndoRedo();
        }
    }

    public void onLongClicked() {
        onUndoRedo();
    }

    public void onObjectChanged() {
        Logger.m10999d(TAG, "onObjectChanged()");
        boolean z = this.mIsLongPressed;
        this.mOnDoingRedoUndo = z;
        if (z) {
            HwToolbarPresenterImpl hwToolbarPresenterImpl = this.mPresenter;
            if (hwToolbarPresenterImpl == null || !hwToolbarPresenterImpl.isTaskRunningInUndoRedoPresenter()) {
                onLongClicked();
                return;
            }
            View view = this.mView;
            if (view != null) {
                view.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.item.HwToolbarUndoRedo.3
                    @Override // java.lang.Runnable
                    public void run() {
                        HwToolbarUndoRedo.this.onObjectChanged();
                    }
                });
            }
        }
    }

    public abstract void onUndoRedo();

    public void updateUndoRedoMenu(boolean z) {
        if (this.mView.getVisibility() != 0) {
            return;
        }
        this.mIsUndoRedoValid = z;
        if ((this.mIsLongPressed || this.mView.isSelected()) && !this.mIsUndoRedoValid) {
            this.mIsLongPressed = false;
        }
        this.mView.setClickable(this.mIsUndoRedoValid);
        ViewCompat viewCompat = ViewCompat.getInstance();
        View view = this.mView;
        viewCompat.setTooltipText(view, this.mIsUndoRedoValid ? (String) view.getContentDescription() : "");
        setEnable(this.mIsUndoRedoValid);
        AbstractC8014b.m7215q(new StringBuilder("updateUndoRedoMenu() undoRedoable : "), this.mIsUndoRedoValid, TAG);
    }
}
