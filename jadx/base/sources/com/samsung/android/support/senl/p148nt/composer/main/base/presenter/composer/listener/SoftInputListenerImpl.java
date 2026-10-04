package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import android.R;
import android.view.KeyEvent;
import android.view.View;
import com.samsung.android.sdk.pen.text.SpenSoftInputListener;
import com.samsung.android.support.senl.p145cm.base.framework.content.ClipboardManagerCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.info.DragAndDropInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ClipboardController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SoftInputListenerImpl implements SpenSoftInputListener {
    private static final String TAG = Logger.createTag("SoftInputListenerImpl");
    private ClipboardController mClipboardController;
    private DragAndDropInfo mDragAndDropInfo;
    private View.OnKeyListener mOnKeyListener;
    private ListenerImplContract.IPresenter mPresenter;
    private Runnable mShowRunnable;
    private SoftInputManager mSoftInputManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ISipContextMenu {
        boolean copy();

        boolean cut();

        boolean paste();

        boolean selectAll();
    }

    public SoftInputListenerImpl(ListenerImplContract.IPresenter iPresenter, SoftInputManager softInputManager, ClipboardController clipboardController) {
        this.mSoftInputManager = softInputManager;
        this.mPresenter = iPresenter;
        this.mClipboardController = clipboardController;
    }

    private void removeShowRunnable() {
        if (this.mShowRunnable != null) {
            this.mPresenter.getHandler().removeCallbacks(this.mShowRunnable);
            this.mShowRunnable = null;
        }
    }

    @Override // com.samsung.android.sdk.pen.text.SpenSoftInputListener
    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        View.OnKeyListener onKeyListener = this.mOnKeyListener;
        if (onKeyListener != null) {
            return onKeyListener.onKey(this.mPresenter.getView(), i, keyEvent);
        }
        return false;
    }

    @Override // com.samsung.android.sdk.pen.text.SpenSoftInputListener
    public boolean onPerformContextMenuAction(int i) {
        if (this.mPresenter.isLockedScreen()) {
            Logger.m11003i(TAG, "onPerformContextMenuAction# Progress is running. return");
            return true;
        }
        View.OnKeyListener onKeyListener = this.mOnKeyListener;
        if (onKeyListener == null) {
            return false;
        }
        switch (i) {
            case R.id.selectAll:
                return ((ISipContextMenu) onKeyListener).selectAll();
            case R.id.cut:
                return ((ISipContextMenu) onKeyListener).cut();
            case R.id.copy:
                return ((ISipContextMenu) onKeyListener).copy();
            case R.id.paste:
                return ((ISipContextMenu) onKeyListener).paste();
            default:
                AbstractC8014b.m7217s(i, "onPerformContextMenuAction# id is wrong:", TAG);
                return false;
        }
    }

    @Override // com.samsung.android.sdk.pen.text.SpenSoftInputListener
    public boolean onShowClipboard(boolean z) {
        ClipboardController clipboardController = this.mClipboardController;
        ClipboardManagerCompat.Companion companion = ClipboardManagerCompat.INSTANCE;
        clipboardController.setClipboardFilter(companion.getInstance().getTypeAll(), "onShowClipboard");
        this.mClipboardController.showClipboard(companion.getInstance().getTypeAll());
        return true;
    }

    @Override // com.samsung.android.sdk.pen.text.SpenSoftInputListener
    public boolean onShowSoftInput(boolean z) {
        String str = TAG;
        AbstractC8014b.m7224z("onShowSoftInput# isShow:", str, z);
        final View view = this.mPresenter.getView();
        if (view == null) {
            return false;
        }
        if (z) {
            DragAndDropInfo dragAndDropInfo = this.mDragAndDropInfo;
            if (dragAndDropInfo != null && dragAndDropInfo.isEnabled()) {
                return false;
            }
            if (!view.hasFocus()) {
                Logger.m11000e(str, "onShowSoftInput# view has not focus. view:" + view);
                if (!view.requestFocus()) {
                    Logger.m11000e(str, "onShowSoftInput# view requestFocus fail. view:" + view);
                    return false;
                }
            }
            if (!this.mPresenter.getActivity().hasWindowFocus()) {
                this.mShowRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.SoftInputListenerImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SoftInputListenerImpl.this.mSoftInputManager.show(view);
                        SoftInputListenerImpl.this.mShowRunnable = null;
                    }
                };
                this.mPresenter.getHandler().postDelayed(this.mShowRunnable, 300L);
                return false;
            }
            this.mSoftInputManager.show(view);
        } else {
            removeShowRunnable();
            this.mSoftInputManager.hide(view);
        }
        return false;
    }

    public void setDragAndDropInfo(DragAndDropInfo dragAndDropInfo) {
        this.mDragAndDropInfo = dragAndDropInfo;
    }

    public void setOnKeyListener(View.OnKeyListener onKeyListener) {
        this.mOnKeyListener = onKeyListener;
    }

    @Override // com.samsung.android.sdk.pen.text.SpenSoftInputListener
    public boolean onShowSoftInput(boolean z, long j) {
        Logger.m11003i(TAG, "onShowSoftInput# isShow:" + z + ", delay:" + j);
        View view = this.mPresenter.getView();
        if (view == null) {
            return false;
        }
        removeShowRunnable();
        if (z) {
            this.mSoftInputManager.delayForceToShow(view, j);
        } else {
            this.mSoftInputManager.delayHide(view, j);
        }
        return false;
    }
}
